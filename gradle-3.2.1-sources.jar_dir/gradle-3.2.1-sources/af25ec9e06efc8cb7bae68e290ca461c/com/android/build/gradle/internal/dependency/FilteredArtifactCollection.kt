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

package com.android.build.gradle.internal.dependency

import com.android.build.gradle.internal.scope.InternalArtifactType
import com.android.build.gradle.internal.tasks.featuresplit.compIdToString
import com.google.common.collect.ImmutableList
import com.google.common.io.Files
import org.gradle.api.Project
import org.gradle.api.artifacts.ArtifactCollection
import org.gradle.api.artifacts.result.ResolvedArtifactResult
import org.gradle.api.file.FileCollection
import org.gradle.api.provider.Provider
import java.io.File
import java.util.concurrent.Callable
import java.util.function.Consumer
import java.util.stream.Collectors

/**
 * Implementation of a [ArtifactCollection] on top of a main collection, and a component
 * filter, coming from a list of files published by sub-modules as [InternalArtifactType.FEATURE_TRANSITIVE_DEPS]

 *
 * The main use case for this is building an ArtifactCollection that represents the runtime
 * dependencies of a test app, minus the runtime dependencies of the tested app (to avoid duplicated
 * classes during runtime).
 */
class FilteredArtifactCollection(
        project: Project,
        mainArtifact: ArtifactCollection,
        excludeDirectoryFiles: FileCollection) : ArtifactCollection {

    private val fileCollection: FileCollection
    private val filterResolver: FilterResolver

    init {
        filterResolver = FilterResolver(mainArtifact, excludeDirectoryFiles, project)

        // create a dynamic file collection, using a callable that will compute the
        // content when queried the first time, but not during configuration.
        // Include the original build dependencies.
        // and the dependency to generate the excludeDirectoryFiles.
        fileCollection = project.files(filterResolver)
                .builtBy(mainArtifact.artifactFiles.buildDependencies)
                .builtBy(excludeDirectoryFiles.buildDependencies)
    }

    override fun getArtifactFiles() = fileCollection

    override fun getArtifacts() = filterResolver.getArtifactResults()

    override fun getFailures(): Collection<Throwable> {
        val builder = ImmutableList.builder<Throwable>()
        builder.addAll(filterResolver.mainArtifacts.failures)
        return builder.build()
    }

    override fun iterator() = artifacts.iterator() as MutableIterator<ResolvedArtifactResult>
    override fun spliterator() = artifacts.spliterator()

    override fun forEach(action: Consumer<in ResolvedArtifactResult>) {
        artifacts.forEach(action)
    }

    /**
     * We need to pass a Callable<Provider<Collection<File>>>, otherwise Gradle does not compute
     * this file collection correctly. Previously we passed Callable<Collection<File>>, but that
     * caused issues such as b/79660649.
     */
    private class FilterResolver(
        val mainArtifacts: ArtifactCollection,
        private val excludeDirectoryFiles: FileCollection,
        private val project: Project
    ) : Callable<Provider<Collection<File>>> {

        fun getArtifactResults(): Set<ResolvedArtifactResult> {
            val filteredArtifacts = computeFilteredArtifacts()

            if (filteredArtifacts.isEmpty()) {
                return mainArtifacts.artifacts
            }

            return mainArtifacts.artifacts.asSequence()
                .filter { !filteredArtifacts.contains(compIdToString(it)) }.toSet()
        }

        override fun call(): Provider<Collection<File>> {
            val excludedArtifacts = computeFilteredArtifacts()

            if (excludedArtifacts.isEmpty()) {
                return project.providers.provider({mainArtifacts.artifactFiles.files})
            }

            return project.providers.provider({mainArtifacts.artifacts.asSequence()
                .filter { !excludedArtifacts.contains(compIdToString(it)) }.map { it.file }.toSet()})
        }

        private fun computeFilteredArtifacts(): Set<String>
                = excludeDirectoryFiles
                .files
                .stream()
                .map { file: File ->
                    if (file.isFile) Files.readLines(file,
                            Charsets.UTF_8) else listOf()
                }
                .flatMap { list: List<String> -> list.stream() }
                .collect(Collectors.toSet<String>())
    }
}
