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

package com.android.build.gradle.internal.scope

import com.android.build.gradle.internal.tasks.CheckManifest
import com.android.build.gradle.tasks.AidlCompile
import com.android.build.gradle.tasks.ExternalNativeBuildTask
import com.android.build.gradle.tasks.GenerateBuildConfig
import com.android.build.gradle.tasks.ManifestProcessorTask
import com.android.build.gradle.tasks.MergeResources
import com.android.build.gradle.tasks.MergeSourceSetFolders
import com.android.build.gradle.tasks.NdkCompile
import com.android.build.gradle.tasks.PackageAndroidArtifact
import com.android.build.gradle.tasks.ProcessAndroidResources
import com.android.build.gradle.tasks.RenderscriptCompile
import org.gradle.api.Task
import org.gradle.api.tasks.Sync
import org.gradle.api.tasks.bundling.Zip
import org.gradle.api.tasks.compile.JavaCompile

/**
 * Task container for the tasks needed by the Variant API.
 */
interface TaskContainer {

    val assembleTask: Task
    val javacTask: JavaCompile
    // empty anchor compile task to set all compilations tasks as dependents.
    val compileTask: Task
    val preBuildTask: Task
    val checkManifestTask: CheckManifest?
    val aidlCompileTask: AidlCompile?
    val renderscriptCompileTask: RenderscriptCompile?
    val mergeResourcesTask: MergeResources
    val mergeAssetsTask: MergeSourceSetFolders
    val processJavaResourcesTask: Sync
    val generateBuildConfigTask: GenerateBuildConfig?
    val ndkCompileTask: NdkCompile?
    val obfuscationTask: Task?
    val processAndroidResTask: ProcessAndroidResources?
    val processManifestTask: ManifestProcessorTask?
    val packageAndroidTask: PackageAndroidArtifact?
    val bundleLibraryTask: Zip?

    val externalNativeBuildTasks: Collection<ExternalNativeBuildTask>
}