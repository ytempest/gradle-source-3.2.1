/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.aapt.AaptGeneration;
/*     */ import com.android.build.gradle.internal.core.VariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.AbiSplitOptions;
/*     */ import com.android.build.gradle.internal.dsl.Splits;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.internal.variant.FeatureVariantData;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.model.BuildType;
/*     */ import java.io.File;
/*     */ 
/*     */ public class GenerateSplitAbiRes$ConfigAction
/*     */   implements TaskConfigAction<GenerateSplitAbiRes>
/*     */ {
/*     */   private final VariantScope scope;
/*     */   private final File outputDirectory;
/*     */   
/*     */   public GenerateSplitAbiRes$ConfigAction(VariantScope scope, File outputDirectory)
/*     */   {
/* 294 */     this.scope = scope;
/* 295 */     this.outputDirectory = outputDirectory;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 301 */     return scope.getTaskName("generate", "SplitAbiRes");
/*     */   }
/*     */   
/*     */   public Class<GenerateSplitAbiRes> getType()
/*     */   {
/* 307 */     return GenerateSplitAbiRes.class;
/*     */   }
/*     */   
/*     */   public void execute(GenerateSplitAbiRes generateSplitAbiRes)
/*     */   {
/* 312 */     VariantConfiguration config = scope.getVariantConfiguration();
/*     */     
/* 314 */     generateSplitAbiRes.setAndroidBuilder(scope.getGlobalScope().getAndroidBuilder());
/* 315 */     generateSplitAbiRes.setVariantName(config.getFullName());
/* 316 */     GenerateSplitAbiRes.access$002(generateSplitAbiRes, 
/* 317 */       (config.getType() == VariantType.FEATURE) && (!scope.isBaseFeature()) ? 
/* 318 */       ((FeatureVariantData)scope.getVariantData()).getFeatureName() : null);
/*     */     
/* 322 */     GenerateSplitAbiRes.access$102(generateSplitAbiRes, config.getVersionCode());
/* 323 */     GenerateSplitAbiRes.access$202(generateSplitAbiRes, config.getVersionName());
/* 324 */     GenerateSplitAbiRes.access$302(generateSplitAbiRes, 
/* 325 */       AaptGeneration.fromProjectOptions(scope.getGlobalScope().getProjectOptions()));
/*     */     
/* 327 */     GenerateSplitAbiRes.access$402(generateSplitAbiRes, scope);
/* 328 */     GenerateSplitAbiRes.access$502(generateSplitAbiRes, config.getType());
/* 329 */     GenerateSplitAbiRes.access$602(generateSplitAbiRes, outputDirectory);
/* 330 */     GenerateSplitAbiRes.access$702(generateSplitAbiRes, 
/* 331 */       AbiSplitOptions.getAbiFilters(scope
/* 332 */       .getGlobalScope().getExtension().getSplits().getAbiFilters()));
/* 333 */     GenerateSplitAbiRes.access$802(generateSplitAbiRes, config.getBaseName());
/* 334 */     GenerateSplitAbiRes.access$902(generateSplitAbiRes, config.getApplicationId());
/* 335 */     GenerateSplitAbiRes.access$1002(generateSplitAbiRes, config.getBuildType().isDebuggable());
/* 336 */     GenerateSplitAbiRes.access$1102(generateSplitAbiRes, scope
/* 337 */       .getGlobalScope().getExtension().getAaptOptions());
/* 338 */     GenerateSplitAbiRes.access$1202(generateSplitAbiRes, scope.getVariantData().getOutputFactory());
/*     */     
/* 340 */     if (scope.getVariantData().getType() == VariantType.FEATURE) {
/* 341 */       if (scope.isBaseFeature()) {
/* 342 */         GenerateSplitAbiRes.access$1302(generateSplitAbiRes, scope
/* 343 */           .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.METADATA_VALUES, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.METADATA_APP_ID_DECLARATION));
/*     */       }
/*     */       else {
/* 346 */         GenerateSplitAbiRes.access$1302(generateSplitAbiRes, scope
/* 347 */           .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.FEATURE_APPLICATION_ID_DECLARATION));
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.GenerateSplitAbiRes.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */