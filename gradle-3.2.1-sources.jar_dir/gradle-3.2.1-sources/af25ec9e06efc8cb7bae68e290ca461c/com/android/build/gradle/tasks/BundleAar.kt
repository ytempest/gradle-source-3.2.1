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

package com.android.build.gradle.tasks

import android.databinding.tool.DataBindingBuilder
import com.android.SdkConstants
import com.android.build.gradle.AndroidConfig
import com.android.build.gradle.internal.scope.InternalArtifactType
import com.android.build.gradle.internal.scope.TaskConfigAction
import com.android.build.gradle.internal.scope.VariantScope
import com.android.build.gradle.internal.variant.LibraryVariantData
import com.android.builder.core.BuilderConstants
import org.gradle.api.Action
import org.gradle.api.file.CopySpec
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.file.FileCopyDetails
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.bundling.Zip
import java.io.File

/** Custom Zip task to allow archive name to be set lazily. */
open class BundleAar : Zip() {
    private lateinit var archiveNameSupplier: () -> String

    @Input
    override fun getArchiveName() = archiveNameSupplier()

    class ConfigAction(
        private val extension: AndroidConfig,
        private val variantScope: VariantScope
    ) : TaskConfigAction<BundleAar> {

        override fun getName() = variantScope.getTaskName("bundle", "Aar")

        override fun getType() = BundleAar::class.java

        override fun execute(bundle: BundleAar) {
            val libVariantData = variantScope.variantData as LibraryVariantData

            val artifacts = variantScope.artifacts

            libVariantData.scope.taskContainer.bundleLibraryTask = bundle

            // Sanity check, there should never be duplicates.
            bundle.duplicatesStrategy = DuplicatesStrategy.FAIL
            // Make the AAR reproducible. Note that we package several zips inside the AAR, so all of
            // those need to be reproducible too before we can switch this on.
            // https://issuetracker.google.com/67597902
            bundle.isReproducibleFileOrder = true
            bundle.isPreserveFileTimestamps = false

            bundle.description = ("Assembles a bundle containing the library in "
                    + variantScope.variantConfiguration.fullName
                    + ".")

            bundle.destinationDir = variantScope.aarLocation
            bundle.archiveNameSupplier = { variantScope.outputScope.mainSplit.outputFileName }
            bundle.extension = BuilderConstants.EXT_LIB_ARCHIVE
            bundle.from(
                variantScope.artifacts.getArtifactFiles(
                    InternalArtifactType.AIDL_PARCELABLE
                ),
                prependToCopyPath(SdkConstants.FD_AIDL)
            )
            bundle.from(artifacts.getFinalArtifactFiles(InternalArtifactType.CONSUMER_PROGUARD_FILE))
            if (extension.dataBinding.isEnabled) {
                bundle.from(
                    variantScope.globalScope.project.provider {
                        variantScope.artifacts.getFinalArtifactFiles(
                            InternalArtifactType.DATA_BINDING_ARTIFACT) },
                    prependToCopyPath(DataBindingBuilder.DATA_BINDING_ROOT_FOLDER_IN_AAR)
                )
                bundle.from(
                    variantScope.globalScope.project.provider {
                        variantScope.artifacts.getFinalArtifactFiles(
                            InternalArtifactType.DATA_BINDING_BASE_CLASS_LOG_ARTIFACT
                        )
                    },
                    prependToCopyPath(
                        DataBindingBuilder.DATA_BINDING_CLASS_LOG_ROOT_FOLDER_IN_AAR
                    )
                )
            }
            bundle.from(artifacts.getFinalArtifactFiles(InternalArtifactType.LIBRARY_MANIFEST))
            // TODO: this should be unconditional b/69358522
            if (java.lang.Boolean.TRUE != variantScope.globalScope.extension.aaptOptions.namespaced) {
                bundle.from(artifacts.getFinalArtifactFiles(InternalArtifactType.SYMBOL_LIST))
                bundle.from(
                    artifacts.getFinalArtifactFiles(InternalArtifactType.PACKAGED_RES),
                    prependToCopyPath(SdkConstants.FD_RES)
                )
            }
            bundle.from(
                artifacts.getFinalArtifactFiles(InternalArtifactType.RENDERSCRIPT_HEADERS),
                prependToCopyPath(SdkConstants.FD_RENDERSCRIPT)
            )
            bundle.from(artifacts.getFinalArtifactFiles(InternalArtifactType.PUBLIC_RES))
            if (artifacts.hasArtifact(InternalArtifactType.COMPILE_ONLY_NAMESPACED_R_CLASS_JAR)) {
                bundle.from(artifacts.getFinalArtifactFiles(
                    InternalArtifactType.COMPILE_ONLY_NAMESPACED_R_CLASS_JAR))
            }
            if (artifacts.hasArtifact(InternalArtifactType.RES_STATIC_LIBRARY)) {
                bundle.from(artifacts.getFinalArtifactFiles(InternalArtifactType.RES_STATIC_LIBRARY))
            }
            bundle.from(
                artifacts.getFinalArtifactFiles(InternalArtifactType.LIBRARY_AND_LOCAL_JARS_JNI),
                prependToCopyPath(SdkConstants.FD_JNI)
            )
            bundle.from(variantScope.globalScope.artifacts
                .getFinalArtifactFiles(InternalArtifactType.LINT_JAR))
            if (artifacts.hasArtifact(InternalArtifactType.ANNOTATIONS_ZIP)) {
                bundle.from(artifacts.getFinalArtifactFiles(InternalArtifactType.ANNOTATIONS_ZIP))
            }
            bundle.from(artifacts.getFinalArtifactFiles(InternalArtifactType.AAR_MAIN_JAR))
            bundle.from(
                artifacts.getFinalArtifactFiles(InternalArtifactType.AAR_LIBS_DIRECTORY),
                prependToCopyPath(SdkConstants.LIBS_FOLDER)
            )
            bundle.from(
                variantScope.artifacts
                    .getFinalArtifactFiles(InternalArtifactType.LIBRARY_ASSETS),
                prependToCopyPath(SdkConstants.FD_ASSETS))

            variantScope.artifacts.appendArtifact(
                InternalArtifactType.AAR,
                listOf(File(variantScope.aarLocation,
                    variantScope.outputScope.mainSplit.outputFileName)),
                bundle)

            libVariantData.packageLibTask = bundle
        }

        private fun prependToCopyPath(pathSegment: String) = Action { copySpec: CopySpec ->
            copySpec.eachFile(
                { fileCopyDetails: FileCopyDetails ->
                    fileCopyDetails.relativePath =
                            fileCopyDetails.relativePath.prepend(pathSegment)
                })
        }
    }
}
