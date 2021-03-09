/*     */ package com.android.build.gradle.internal.core;
/*     */ 
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.dsl.CoreProductFlavor;
/*     */ import com.android.build.gradle.internal.dsl.CoreSigningConfig;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.builder.core.ManifestAttributeSupplier;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.model.SourceProvider;
/*     */ 
/*     */ class GradleVariantConfiguration$VariantConfigurationBuilder
/*     */   implements GradleVariantConfiguration.Builder
/*     */ {
/*     */   public GradleVariantConfiguration create(ProjectOptions projectOptions, CoreProductFlavor defaultConfig, SourceProvider defaultSourceProvider, ManifestAttributeSupplier mainManifestAttributeSupplier, CoreBuildType buildType, SourceProvider buildTypeSourceProvider, VariantType type, CoreSigningConfig signingConfigOverride)
/*     */   {
/* 170 */     return new GradleVariantConfiguration(projectOptions, null, defaultConfig, defaultSourceProvider, mainManifestAttributeSupplier, buildType, buildTypeSourceProvider, type, signingConfigOverride);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.core.GradleVariantConfiguration.VariantConfigurationBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */