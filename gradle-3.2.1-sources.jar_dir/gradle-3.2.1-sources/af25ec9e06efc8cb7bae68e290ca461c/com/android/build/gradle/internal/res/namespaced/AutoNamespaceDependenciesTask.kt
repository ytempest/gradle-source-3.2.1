/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.build.gradle.internal.res.namespaced

import android.databinding.tool.util.Preconditions
import com.android.annotations.VisibleForTesting
import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope
import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType
import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType
import com.android.build.gradle.internal.scope.InternalArtifactType
import com.android.build.gradle.internal.scope.TaskConfigAction
import com.android.build.gradle.internal.scope.VariantScope
import com.android.build.gradle.internal.tasks.AndroidBuilderTask
import com.android.builder.symbols.exportToCompiledJava
import com.android.ide.common.symbols.SymbolIo
import com.android.ide.common.symbols.SymbolTable
import com.android.tools.build.apkzlib.zip.StoredEntryType
import com.android.tools.build.apkzlib.zip.ZFile
import com.android.utils.FileUtils
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap
import org.gradle.api.artifacts.ArtifactCollection
import org.gradle.api.artifacts.ResolvableDependencies
import org.gradle.api.artifacts.component.ProjectComponentIdentifier
import org.gradle.api.file.FileCollection
import org.gradle.api.logging.Logger
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.nio.file.Files

/**
 * Rewrites the classes.jar files of the module's dependencies to be fully resource namespaced. It
 * does not rewrite the references inside the resources in the libraries, only in the bytecode.
 */
@CacheableTask
open class AutoNamespaceDependenciesTask : AndroidBuilderTask() {

    lateinit var rFiles: ArtifactCollection private set
    lateinit var nonNamespacedManifests: ArtifactCollection private set
    lateinit var jarFiles: ArtifactCollection private set
    lateinit var dependencies: ResolvableDependencies private set

    @InputFiles fun getRDefFiles(): FileCollection = rFiles.artifactFiles
    @InputFiles fun getManifestsFiles(): FileCollection = nonNamespacedManifests.artifactFiles
    @InputFiles fun getClassesJarFiles(): FileCollection = jarFiles.artifactFiles
    @InputFiles fun getDependenciesFiles(): FileCollection = dependencies.files

    @VisibleForTesting internal var log: Logger? = null
    private var symbolTablesCache: HashMap<File, SymbolTable> = HashMap()
    private var usedSanitizedDependencyNames: HashSet<String> = HashSet()

    @get:OutputDirectory lateinit var outputRewrittenClasses: File private set
    @get:OutputDirectory lateinit var outputRClasses: File private set
    @get:OutputFile lateinit var outputClassesJar: File private set
    @get:OutputFile lateinit var outputRClassesJar: File private set
    @get:OutputDirectory lateinit var outputRewrittenManifests: File private set

    @TaskAction
    fun taskAction() = namespaceDependencies()

    @VisibleForTesting
    fun namespaceDependencies(
        dependencies: ResolvableDependencies = this.dependencies,
        rFiles: ArtifactCollection = this.rFiles,
        jarFiles: ArtifactCollection = this.jarFiles,
        manifests: ArtifactCollection = this.nonNamespacedManifests,
        outputDirectory: File = this.outputRewrittenClasses,
        outputRClasses: File = this.outputRClasses,
        outputClassesJar: File = this.outputClassesJar,
        outputRClassesJar: File = this.outputRClassesJar,
        outputManifests: File = this.outputRewrittenManifests
    ) {
        if (outputDirectory.exists()) {
            outputDirectory.deleteRecursively()
            FileUtils.mkdirs(outputDirectory)
        }
        if (outputRClasses.exists()) {
            outputRClasses.deleteRecursively()
            FileUtils.mkdirs(outputRClasses)
        }
        outputClassesJar.delete()
        outputRClassesJar.delete()

        // First, create a graph based on the ResolvableDependencies and the Artifact Collections.
        // Each node in the DependenciesGraph is an external dependency and is either a full AAR or
        // a JAR dependency.
        // Each node will hold the information about its dependencies. Additionally, nodes
        // representing AARs will also contain the paths to the corresponding R-def.txt file, their
        // classes.jar file and their non-namespaced AndroidManifest.xml file; nodes representing
        // JAR dependencies will have none.
        val graph = DependenciesGraph.create(
                dependencies,
                ImmutableMap.of(
                        ArtifactType.DEFINED_ONLY_SYMBOL_LIST, rFiles.toMap(),
                        ArtifactType.NON_NAMESPACED_CLASSES, jarFiles.toMap(),
                        ArtifactType.NON_NAMESPACED_MANIFEST, manifests.toMap()
                )
        )

        // The rewriting works per node, since for rewriting a library the only files from its
        // dependencies we need are their R-def.txt files, which were already generated by the
        // [LibraryDefinedSymbolTableTransform].
        // TODO: do this in parallel
        for (dependency in graph.allNodes) {
            namespaceDependency(dependency, outputDirectory, outputRClasses, outputManifests)
        }

        symbolTablesCache.clear()
        usedSanitizedDependencyNames.clear()

        // Jar all the classes into two JAR files - one for namespaced classes, one for R classes.
        jarOutputs(outputClassesJar, outputDirectory)
        jarOutputs(outputRClassesJar, outputRClasses)
    }

    private fun jarOutputs(outputJar: File, inputDirectory: File) {
        ZFile(outputJar).use { jar ->
            Files.walk(inputDirectory.toPath()).use { paths ->
                paths.filter { p -> p.toFile().isFile}.forEach { it ->
                    ZFile(it.toFile()).use { classesJar ->
                        classesJar.entries().forEach { entry ->
                            val name = entry.centralDirectoryHeader.name
                            if (entry.type == StoredEntryType.FILE && name.endsWith(".class")) {
                                jar.add(name, entry.open())
                            }
                        }
                    }
                }
            }
        }
    }

    private fun namespaceDependency(
        dependency: DependenciesGraph.Node,
        outputDirectory: File,
        outputRClassesDirectory: File,
        outputManifests: File
    ) {
        val input = dependency.getFile(ArtifactType.NON_NAMESPACED_CLASSES)
        val manifest = dependency.getFile(ArtifactType.NON_NAMESPACED_MANIFEST)
        // Only convert external nodes and non-namespaced libraries. Already namespaced libraries
        // and JAR files can be present in the graph, but they will not contain the
        // NON_NAMESPACED_CLASSES artifacts. Only try to rewrite non-namespaced libraries' classes.
        if (dependency.id !is ProjectComponentIdentifier && input != null) {
            Preconditions.checkNotNull(
                    manifest,
                    "Manifest missing for library ${dependency.id.displayName}")
            val dependencyName = dependency.id.displayName
            val sanitizedDependencyName = getUniqueSanitizedDependencyName(dependencyName)
            val out = File(
                    outputDirectory,
                    "namespaced-$sanitizedDependencyName-${input.name}"
            )

            // The rewriting algorithm uses ordered symbol tables, with this library's table at the
            // top of the list. It looks up resources starting from the top of the list, trying to
            // find where the references resource was defined (or overridden), closest to the root
            // (this node) in the dependency graph.
            val symbolTables = getSymbolTables(dependency)
            logger.info("Started rewriting $dependencyName")
            val rewriter = NamespaceRewriter(symbolTables, log ?: logger)
            rewriter.rewriteJar(input, out)
            rewriter.rewriteManifest(
                    manifest!!,
                    File(outputManifests, "${sanitizedDependencyName}_AndroidManifest.xml"))
            logger.info("Finished rewriting $dependencyName")

            // Also generate fake R classes for compilation.
            exportToCompiledJava(
                    ImmutableList.of(symbolTables[0]),
                    File(
                            outputRClassesDirectory,
                            "namespaced-$sanitizedDependencyName-R.jar"
                    ).toPath()
            )
        }
    }

    private fun getUniqueSanitizedDependencyName(name: String): String {
        var sanitizedName = FileUtils.sanitizeFileName(name)
        // This should not happen, but in case we do run into a collision better to be safe and
        // append an extra underscore character. And to be extremely cautious, keep checking until
        // we're safe.
        while (usedSanitizedDependencyNames.contains(sanitizedName)) {
            sanitizedName += "_"
        }
        usedSanitizedDependencyNames.add(sanitizedName)
        return sanitizedName
    }

    private fun getSymbolTables(node: DependenciesGraph.Node): ImmutableList<SymbolTable> {
        synchronized(symbolTablesCache) {
            val builder = ImmutableList.builder<SymbolTable>()

            // Reading the R files and building symbol tables is very costly, remember them in the
            // cache when reading for the first time, then just fetch the already build table.
            for (rFile in node.getTransitiveFiles(ArtifactType.DEFINED_ONLY_SYMBOL_LIST)) {
                if (!symbolTablesCache.contains(rFile)) {
                    val table = SymbolIo.readRDef(rFile.toPath())
                    symbolTablesCache[rFile] = table
                }
                builder.add(symbolTablesCache[rFile]!!)
            }
            return builder.build()
        }
    }

    private fun ArtifactCollection.toMap(): ImmutableMap<String, File> =
        ImmutableMap.builder<String, File>().apply {
            for (artifact in artifacts) {
                put(artifact.id.componentIdentifier.displayName, artifact.file)
            }
        }.build()

    class ConfigAction(private val variantScope: VariantScope)
        : TaskConfigAction<AutoNamespaceDependenciesTask> {

        override fun getName(): String = variantScope.getTaskName("autoNamespace", "Dependencies")

        override fun getType(): Class<AutoNamespaceDependenciesTask>
                = AutoNamespaceDependenciesTask::class.java

        override fun execute(task: AutoNamespaceDependenciesTask) {
            task.variantName = variantScope.fullVariantName
            task.setAndroidBuilder(variantScope.globalScope.androidBuilder)

            task.rFiles = variantScope.getArtifactCollection(
                    ConsumedConfigType.RUNTIME_CLASSPATH,
                    ArtifactScope.EXTERNAL,
                    ArtifactType.DEFINED_ONLY_SYMBOL_LIST
            )

            task.jarFiles = variantScope.getArtifactCollection(
                    ConsumedConfigType.RUNTIME_CLASSPATH,
                    ArtifactScope.EXTERNAL,
                    ArtifactType.NON_NAMESPACED_CLASSES
            )

            task.nonNamespacedManifests = variantScope.getArtifactCollection(
                    ConsumedConfigType.RUNTIME_CLASSPATH,
                    ArtifactScope.EXTERNAL,
                    ArtifactType.NON_NAMESPACED_MANIFEST
            )

            task.outputRewrittenClasses = variantScope.artifacts.appendArtifact(
                    InternalArtifactType.NAMESPACED_CLASSES, task)

            task.outputRewrittenManifests = variantScope.artifacts.appendArtifact(
                    InternalArtifactType.NAMESPACED_MANIFESTS, task)

            task.outputRClasses = variantScope.artifacts.appendArtifact(
                    InternalArtifactType.COMPILE_ONLY_NAMESPACED_DEPENDENCIES_R_JARS, task)

            task.outputClassesJar = variantScope.artifacts.appendArtifact(
                    InternalArtifactType.NAMESPACED_CLASSES_JAR, task, "namespaced-classes.jar")

            task.outputRClassesJar = variantScope.artifacts.appendArtifact(
                    InternalArtifactType.COMPILE_ONLY_NAMESPACED_DEPENDENCIES_R_JAR,
                    task,
                    "namespaced-R.jar")

            task.dependencies =
                    variantScope.variantData.variantDependency.runtimeClasspath.incoming
        }
    }
}