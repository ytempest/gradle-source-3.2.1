/*
 * Copyright (C) 2017 The Android Open Source Project
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

package com.android.build.gradle.internal.transforms

import com.android.build.api.artifact.BuildableArtifact
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.QualifiedContent.ContentType
import com.android.build.api.transform.QualifiedContent.Scope
import com.android.build.api.transform.SecondaryFile
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformException
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.internal.LoggerWrapper
import com.android.build.gradle.internal.api.artifact.singleFile
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.build.gradle.internal.scope.InternalArtifactType
import com.android.build.gradle.internal.scope.VariantScope
import com.android.build.gradle.internal.transforms.MainDexListTransform.ProguardInput.INPUT_JAR
import com.android.build.gradle.internal.transforms.MainDexListTransform.ProguardInput.LIBRARY_JAR
import com.android.builder.multidex.D8MainDexList
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap
import com.google.common.collect.ImmutableSet
import com.google.common.collect.Sets
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.util.function.Supplier

/**
 * Calculate the main dex list using D8.
 */
class D8MainDexListTransform(
        private val manifestProguardRules: BuildableArtifact,
        private val userProguardRules: Path? = null,
        private val userClasses: Path? = null,
        private val includeDynamicFeatures: Boolean = false,
        private val bootClasspath: Supplier<List<Path>>) : Transform(), MainDexListWriter {

    private val logger = LoggerWrapper.getLogger(D8MainDexListTransform::class.java)
    private lateinit var outputMainDexList: Path
    @JvmOverloads
    constructor(variantScope: VariantScope, includeDynamicFeatures: Boolean = false) :
            this(
                    variantScope.artifacts.getFinalArtifactFiles(InternalArtifactType.LEGACY_MULTIDEX_AAPT_DERIVED_PROGUARD_RULES),
                    variantScope.variantConfiguration.multiDexKeepProguard?.toPath(),
                    variantScope.variantConfiguration.multiDexKeepFile?.toPath(),
                    includeDynamicFeatures,
                    Supplier {
                        variantScope
                                .globalScope
                                .androidBuilder
                                .getBootClasspath(true)
                                .map { it.toPath() }})

    override fun setMainDexListOutputFile(mainDexListFile: File) {
        this.outputMainDexList = mainDexListFile.toPath()
    }

    override fun getName(): String = if (includeDynamicFeatures) "bundleMultiDexList" else "multidexlist"

    override fun getInputTypes(): ImmutableSet<out ContentType> =
            Sets.immutableEnumSet(QualifiedContent.DefaultContentType.CLASSES)

    override fun getScopes(): ImmutableSet<in Scope> = ImmutableSet.of()

    override fun getReferencedScopes(): MutableSet<in Scope> {
        val referenced = Sets.immutableEnumSet(
            Scope.PROJECT,
            Scope.SUB_PROJECTS,
            Scope.EXTERNAL_LIBRARIES,
            Scope.PROVIDED_ONLY,
            Scope.TESTED_CODE
        )
        if (!includeDynamicFeatures) {
            return referenced
        }

        return Sets.union(referenced, TransformManager.SCOPE_FEATURES)
    }

    override fun isIncremental(): Boolean = false

    override fun isCacheable(): Boolean = true

    override fun getSecondaryFiles(): MutableCollection<SecondaryFile> =
        ImmutableList.builder<SecondaryFile>().apply {
            add(SecondaryFile.nonIncremental(manifestProguardRules))
            userProguardRules?.let { add(SecondaryFile.nonIncremental(it.toFile())) }
            userClasses?.let { add(SecondaryFile.nonIncremental(it.toFile())) }
        }.build()

    override fun getSecondaryFileOutputs(): ImmutableList<File> =
            ImmutableList.of(outputMainDexList.toFile())

    override fun getParameterInputs(): ImmutableMap<String, Any> =
            ImmutableMap.of("implementation", D8MainDexListTransform::class.java.name)

    override fun transform(invocation: TransformInvocation) {
        logger.verbose("Generating the main dex list using D8.")
        try {
            val inputs = MainDexListTransform.getByInputType(invocation)
            val programFiles = inputs[INPUT_JAR]!!.map { it.toPath() }
            val libraryFiles = inputs[LIBRARY_JAR]!!.map { it.toPath() } + bootClasspath.get()
            logger.verbose("Program files: %s", programFiles.joinToString())
            logger.verbose("Library files: %s", libraryFiles.joinToString())
            logger.verbose(
                    "Proguard rule files: %s",
                    listOfNotNull(manifestProguardRules, userProguardRules).joinToString())

            val proguardRules =
                listOfNotNull(manifestProguardRules.singleFile().toPath(), userProguardRules)
            val mainDexClasses = mutableSetOf<String>()

            val keepRules = MainDexListTransform.getPlatformRules().map { it -> "-keep " + it }
            mainDexClasses.addAll(
                    D8MainDexList.generate(
                            keepRules,
                            proguardRules,
                            programFiles,
                            libraryFiles))

            if (userClasses != null) {
                mainDexClasses.addAll(Files.readAllLines(userClasses))
            }

            Files.deleteIfExists(outputMainDexList)
            Files.write(outputMainDexList, mainDexClasses)
        } catch (e: D8MainDexList.MainDexListException) {
            throw TransformException("Error while generating the main dex list.", e)
        }

    }
}