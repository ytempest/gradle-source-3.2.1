/*
 * Copyright (C) 2012 The Android Open Source Project
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

package com.android.build.gradle.internal;

import static com.android.build.gradle.internal.ide.ArtifactDependencyGraph.DependencyType.ANDROID;
import static org.gradle.internal.logging.text.StyledTextOutput.Style.Description;
import static org.gradle.internal.logging.text.StyledTextOutput.Style.Header;
import static org.gradle.internal.logging.text.StyledTextOutput.Style.Identifier;
import static org.gradle.internal.logging.text.StyledTextOutput.Style.Info;

import com.android.annotations.NonNull;
import com.android.build.gradle.internal.ide.ArtifactDependencyGraph;
import com.android.build.gradle.internal.ide.ArtifactDependencyGraph.HashableResolvedArtifactResult;
import com.android.build.gradle.internal.ide.ModelBuilder;
import com.android.build.gradle.internal.publishing.AndroidArtifacts;
import com.android.build.gradle.internal.scope.VariantScope;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Set;
import org.gradle.api.Project;
import org.gradle.api.artifacts.component.ComponentIdentifier;
import org.gradle.api.artifacts.component.ModuleComponentIdentifier;
import org.gradle.api.artifacts.component.ProjectComponentIdentifier;
import org.gradle.api.tasks.diagnostics.internal.TextReportRenderer;
import org.gradle.internal.graph.GraphRenderer;

/** android version of the TextReportRenderer that outputs Android Library dependencies. */
public class AndroidDependenciesRenderer extends TextReportRenderer {
    private boolean hasConfigs;
    private boolean hasCyclicDependencies;
    private GraphRenderer renderer;

    @Override
    public void startProject(Project project) {
        super.startProject(project);
        hasConfigs = false;
        hasCyclicDependencies = false;
    }

    @Override
    public void completeProject(Project project) {
        if (!hasConfigs) {
            getTextOutput().withStyle(Info).println("No dependencies");
        }
        super.completeProject(project);
    }

    public void startVariant(VariantScope variantScope) {
        if (hasConfigs) {
            getTextOutput().println();
        }
        hasConfigs = true;
        renderer = new GraphRenderer(getTextOutput());
        renderer.visit(
                styledTextOutput ->
                        getTextOutput().withStyle(Header).text(variantScope.getFullVariantName()),
                true);
    }

    public void render(@NonNull VariantScope variant) {
        ImmutableMap<String, String> buildMapping =
                ModelBuilder.computeBuildMapping(variant.getGlobalScope().getProject().getGradle());

        Set<HashableResolvedArtifactResult> compileArtifacts =
                ArtifactDependencyGraph.getAllArtifacts(
                        variant,
                        AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH,
                        null,
                        buildMapping);

        getTextOutput()
                .withStyle(Identifier)
                .text(variant.getVariantDependencies().getCompileClasspath().getName());
        getTextOutput().withStyle(Description).text(" - Dependencies for compilation");
        getTextOutput().println();
        renderer.startChildren();
        render(ImmutableList.copyOf(compileArtifacts));
        renderer.completeChildren();

        Set<HashableResolvedArtifactResult> runtimeArtifacts =
                ArtifactDependencyGraph.getAllArtifacts(
                        variant,
                        AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH,
                        null,
                        buildMapping);

        getTextOutput().println();
        getTextOutput()
                .withStyle(Identifier)
                .text(variant.getVariantDependencies().getRuntimeClasspath().getName());
        getTextOutput().withStyle(Description).text(" - Dependencies for runtime/packaging");
        getTextOutput().println();
        renderer.startChildren();
        render(ImmutableList.copyOf(runtimeArtifacts));
        renderer.completeChildren();
    }

    @Override
    public void complete() {
        if (hasCyclicDependencies) {
            getTextOutput()
                    .withStyle(Info)
                    .println("\n(*) - dependencies omitted (listed previously)");
        }

        super.complete();
    }

    private void render(@NonNull List<HashableResolvedArtifactResult> artifacts) {
        for (int i = 0, count = artifacts.size(); i < count; i++) {
            HashableResolvedArtifactResult artifact = artifacts.get(i);

            renderer.visit(
                    styledTextOutput -> {
                        ComponentIdentifier id = artifact.getId().getComponentIdentifier();

                        String text;

                        if (id instanceof ProjectComponentIdentifier) {
                            if (artifact.isWrappedModule()) {
                                String project = ((ProjectComponentIdentifier) id).getProjectPath();
                                String file = artifact.getFile().getAbsolutePath();

                                text = String.format("%s (file: %s)", project, file);
                            } else if (artifact.getDependencyType() == ANDROID) {
                                String project = ((ProjectComponentIdentifier) id).getProjectPath();
                                String variant = ArtifactDependencyGraph.getVariant(artifact);

                                text = String.format("%s (variant: %s)", project, variant);
                            } else {
                                text = ((ProjectComponentIdentifier) id).getProjectPath();
                            }

                        } else if (id instanceof ModuleComponentIdentifier) {
                            text = ArtifactDependencyGraph.computeAddress(artifact);

                        } else {
                            // local files?
                            text = artifact.getFile().getAbsolutePath();
                        }

                        getTextOutput().text(text);
                    },
                    i == count - 1);
        }
    }
}
