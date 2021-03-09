/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.AbiSplitOptions;
/*     */ import com.android.build.gradle.internal.dsl.DensitySplitOptions;
/*     */ import com.android.build.gradle.internal.dsl.LanguageSplitOptions;
/*     */ import com.android.build.gradle.internal.dsl.Splits;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.options.BooleanOption;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import com.google.common.collect.Iterables;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ 
/*     */ public final class SplitsDiscovery$ConfigAction
/*     */   implements TaskConfigAction<SplitsDiscovery>
/*     */ {
/*     */   private final VariantScope variantScope;
/*     */   private final File persistedList;
/*     */   
/*     */   public SplitsDiscovery$ConfigAction(VariantScope variantScope, File persistedList)
/*     */   {
/* 335 */     this.variantScope = variantScope;
/* 336 */     this.persistedList = persistedList;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 342 */     return variantScope.getTaskName("splitsDiscoveryTask");
/*     */   }
/*     */   
/*     */   public Class<SplitsDiscovery> getType()
/*     */   {
/* 348 */     return SplitsDiscovery.class;
/*     */   }
/*     */   
/*     */   public void execute(SplitsDiscovery task)
/*     */   {
/* 353 */     task.setVariantName(variantScope.getFullVariantName());
/* 354 */     Splits splits = variantScope.getGlobalScope().getExtension().getSplits();
/* 355 */     persistedList = persistedList;
/* 356 */     if (splits.getDensity().isEnable()) {
/* 357 */       densityFilters = splits.getDensityFilters();
/* 358 */       densityAuto = splits.getDensity().isAuto();
/*     */     }
/* 360 */     if (splits.getLanguage().isEnable()) {
/* 361 */       languageFilters = splits.getLanguageFilters();
/* 362 */       languageAuto = splits.getLanguage().isAuto();
/*     */     }
/* 364 */     if (splits.getAbi().isEnable()) {
/* 365 */       abiFilters = splits.getAbiFilters();
/*     */     }
/*     */     
/* 372 */     resourceConfigs = variantScope.getVariantConfiguration().getMergedFlavor().getResourceConfigurations();
/*     */     
/* 376 */     resConfigAuto = ((resourceConfigs.size() == 1) && (((String)Iterables.getOnlyElement(resourceConfigs)).equals("auto")));
/*     */     
/* 379 */     if ((densityAuto) || (languageAuto) || (resConfigAuto))
/*     */     {
/* 381 */       mergedResourcesFolders = variantScope.getOutput(TaskOutputHolder.TaskOutputType.MERGED_RES);
/*     */     }
/*     */     
/* 384 */     ProjectOptions projectOptions = variantScope.getGlobalScope().getProjectOptions();
/* 385 */     aapt2Enabled = projectOptions.get(BooleanOption.ENABLE_AAPT2);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.SplitsDiscovery.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */