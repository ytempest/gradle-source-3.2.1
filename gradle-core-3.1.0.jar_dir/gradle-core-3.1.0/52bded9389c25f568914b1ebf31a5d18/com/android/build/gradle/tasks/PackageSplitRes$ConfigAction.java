/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.VariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import java.io.File;
/*     */ 
/*     */ public class PackageSplitRes$ConfigAction
/*     */   implements TaskConfigAction<PackageSplitRes>
/*     */ {
/*     */   private VariantScope scope;
/*     */   private File outputDirectory;
/*     */   
/*     */   public PackageSplitRes$ConfigAction(VariantScope scope, File outputDirectory)
/*     */   {
/* 127 */     this.scope = scope;
/* 128 */     this.outputDirectory = outputDirectory;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 134 */     return scope.getTaskName("package", "SplitResources");
/*     */   }
/*     */   
/*     */   public Class<PackageSplitRes> getType()
/*     */   {
/* 140 */     return PackageSplitRes.class;
/*     */   }
/*     */   
/*     */   public void execute(PackageSplitRes packageSplitResourcesTask)
/*     */   {
/* 145 */     BaseVariantData variantData = scope.getVariantData();
/* 146 */     VariantConfiguration config = variantData.getVariantConfiguration();
/*     */     
/* 149 */     processedResources = scope.getOutput(TaskOutputHolder.TaskOutputType.PROCESSED_RES);
/* 150 */     PackageSplitRes.access$002(packageSplitResourcesTask, config.getSigningConfig());
/* 151 */     splitResApkOutputDirectory = outputDirectory;
/* 152 */     PackageSplitRes.access$102(packageSplitResourcesTask, scope.getIncrementalDir(getName()));
/* 153 */     packageSplitResourcesTask.setAndroidBuilder(scope.getGlobalScope().getAndroidBuilder());
/* 154 */     packageSplitResourcesTask.setVariantName(config.getFullName());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.PackageSplitRes.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */