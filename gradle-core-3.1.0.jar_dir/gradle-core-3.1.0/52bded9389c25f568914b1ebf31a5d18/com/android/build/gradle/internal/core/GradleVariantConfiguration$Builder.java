package com.android.build.gradle.internal.core;

import com.android.build.gradle.internal.dsl.CoreBuildType;
import com.android.build.gradle.internal.dsl.CoreProductFlavor;
import com.android.build.gradle.internal.dsl.CoreSigningConfig;
import com.android.build.gradle.options.ProjectOptions;
import com.android.builder.core.ManifestAttributeSupplier;
import com.android.builder.core.VariantType;
import com.android.builder.model.SourceProvider;

public abstract interface GradleVariantConfiguration$Builder
{
  public abstract GradleVariantConfiguration create(ProjectOptions paramProjectOptions, CoreProductFlavor paramCoreProductFlavor, SourceProvider paramSourceProvider1, ManifestAttributeSupplier paramManifestAttributeSupplier, CoreBuildType paramCoreBuildType, SourceProvider paramSourceProvider2, VariantType paramVariantType, CoreSigningConfig paramCoreSigningConfig);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.core.GradleVariantConfiguration.Builder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */