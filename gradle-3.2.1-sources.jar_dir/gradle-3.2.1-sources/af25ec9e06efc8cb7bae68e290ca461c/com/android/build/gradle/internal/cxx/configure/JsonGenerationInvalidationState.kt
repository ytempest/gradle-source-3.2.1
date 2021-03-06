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

package com.android.build.gradle.internal.cxx.configure

import com.android.build.gradle.tasks.ExternalNativeBuildTaskUtils
import java.io.File
import kotlin.coroutines.experimental.buildSequence

/**
 * Logic responsible for determining whether configuration JSON for the given ABI should be
 * regenerated.
 */
class JsonGenerationInvalidationState(
        forceRegeneration: Boolean,
        expectedJson : File,
        commandFile : File,
        currentBuildCommand: String,
        previousBuildCommand: String,
        dependentBuildFiles : List<File>) {
    private val rebuildDueToMissingJson = !expectedJson.exists()
    private val rebuildDueToMissingPreviousCommand = !commandFile.exists()
    private val rebuildDueToChangeInCommandFile = previousBuildCommand != currentBuildCommand
    private val dependentBuildFilesChanged = (buildSequence {
        if (expectedJson.exists()) {
            for (buildFile in dependentBuildFiles) {
                if (!ExternalNativeBuildTaskUtils.fileIsUpToDate(buildFile, expectedJson)) {
                    yield(buildFile)
                }
            }
        }
    }).toList()
    private val rebuildDueToDependentBuildFileChanged = !dependentBuildFilesChanged.isEmpty()
    val softRegeneration = rebuildDueToDependentBuildFileChanged
            && !forceRegeneration
            && !rebuildDueToMissingJson
            && !rebuildDueToMissingPreviousCommand
            && !rebuildDueToChangeInCommandFile
    val rebuild = forceRegeneration
            || rebuildDueToMissingJson
            || rebuildDueToMissingPreviousCommand
            || rebuildDueToChangeInCommandFile
            || rebuildDueToDependentBuildFileChanged
    val rebuildReasons = (buildSequence {
        val softRegenerateMessage =
                if (softRegeneration) ""
                else ", will remove stale json folder"
        if (forceRegeneration) {
            yield("- force flag, will remove stale json folder")
        }

        if (rebuildDueToMissingJson) {
            yield("- expected json $expectedJson file is not present$softRegenerateMessage")
        }

        if (rebuildDueToMissingPreviousCommand) {
            yield("- missing previous command file $commandFile$softRegenerateMessage")
        }

        if (rebuildDueToChangeInCommandFile) {
            yield("- command changed from previous$softRegenerateMessage")
        }

        if (rebuildDueToDependentBuildFileChanged) {
            yield("- a dependent build file changed")
            for (dependentBuildFile in dependentBuildFilesChanged) {
                yield("  - ${dependentBuildFile.absolutePath}")
            }
        }
    }).toList()
}