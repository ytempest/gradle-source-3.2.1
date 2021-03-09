/*     */ package com.android.build.gradle.internal.core;
/*     */ 
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.dsl.CoreProductFlavor;
/*     */ import com.android.build.gradle.internal.dsl.CoreSigningConfig;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.builder.core.ManifestAttributeSupplier;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import com.android.builder.model.SourceProvider;
/*     */ import com.google.common.base.Strings;
/*     */ 
/*     */ class GradleVariantConfiguration$TestModuleConfigurationBuilder
/*     */   implements GradleVariantConfiguration.Builder
/*     */ {
/*     */   public GradleVariantConfiguration create(ProjectOptions projectOptions, CoreProductFlavor defaultConfig, SourceProvider defaultSourceProvider, ManifestAttributeSupplier mainManifestAttributeSupplier, CoreBuildType buildType, SourceProvider buildTypeSourceProvider, VariantType type, CoreSigningConfig signingConfigOverride)
/*     */   {
/* 204 */     new GradleVariantConfiguration(projectOptions, null, defaultConfig, defaultSourceProvider, mainManifestAttributeSupplier, buildType, buildTypeSourceProvider, type, signingConfigOverride)
/*     */     {
/*     */       public String getApplicationId()
/*     */       {
/* 217 */         String applicationId = getMergedFlavor().getTestApplicationId();
/*     */         
/* 219 */         if (Strings.isNullOrEmpty(applicationId)) {
/* 220 */           applicationId = super.getApplicationId();
/*     */         }
/*     */         
/* 223 */         return applicationId;
/*     */       }
/*     */       
/*     */       public String getOriginalApplicationId()
/*     */       {
/* 229 */         return getApplicationId();
/*     */       }
/*     */       
/*     */       public String getTestApplicationId()
/*     */       {
/* 235 */         return getApplicationId();
/*     */       }
/*     */       
/*     */       public GradleVariantConfiguration getMyTestConfig(SourceProvider defaultSourceProvider, ManifestAttributeSupplier mainManifestAttributeSupplier, SourceProvider buildTypeSourceProvider, VariantType type)
/*     */       {
/* 244 */         throw new UnsupportedOperationException("Test modules have no test variants.");
/*     */       }
/*     */       
/*     */       public boolean isInstantRunBuild(GlobalScope globalScope)
/*     */       {
/* 249 */         return false;
/*     */       }
/*     */     };
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.core.GradleVariantConfiguration.TestModuleConfigurationBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */