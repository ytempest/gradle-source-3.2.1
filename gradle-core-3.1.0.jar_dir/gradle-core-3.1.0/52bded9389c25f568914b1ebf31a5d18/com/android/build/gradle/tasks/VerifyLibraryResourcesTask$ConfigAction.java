/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.TaskManager.MergeType;
/*     */ import com.android.build.gradle.internal.aapt.AaptGeneration;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.google.common.base.Preconditions;
/*     */ 
/*     */ public class VerifyLibraryResourcesTask$ConfigAction
/*     */   implements TaskConfigAction<VerifyLibraryResourcesTask>
/*     */ {
/*     */   protected final VariantScope scope;
/*     */   private final TaskManager.MergeType sourceTaskOutputType;
/*     */   
/*     */   public VerifyLibraryResourcesTask$ConfigAction(VariantScope scope, TaskManager.MergeType sourceTaskOutputType)
/*     */   {
/* 252 */     this.scope = scope;
/* 253 */     this.sourceTaskOutputType = sourceTaskOutputType;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 260 */     return scope.getTaskName("verify", "Resources");
/*     */   }
/*     */   
/*     */   public Class<VerifyLibraryResourcesTask> getType()
/*     */   {
/* 267 */     return VerifyLibraryResourcesTask.class;
/*     */   }
/*     */   
/*     */   public void execute(VerifyLibraryResourcesTask verifyLibraryResources)
/*     */   {
/* 273 */     BaseVariantData variantData = scope.getVariantData();
/* 274 */     GradleVariantConfiguration config = variantData.getVariantConfiguration();
/* 275 */     verifyLibraryResources.setVariantName(config.getFullName());
/*     */     
/* 277 */     verifyLibraryResources.setAndroidBuilder(scope.getGlobalScope().getAndroidBuilder());
/*     */     
/* 279 */     VerifyLibraryResourcesTask.access$002(verifyLibraryResources, 
/* 280 */       AaptGeneration.fromProjectOptions(scope.getGlobalScope().getProjectOptions()));
/*     */     
/* 282 */     verifyLibraryResources.setIncrementalFolder(scope.getIncrementalDir(getName()));
/*     */     
/* 284 */     Preconditions.checkState(sourceTaskOutputType == TaskManager.MergeType.MERGE, "Support for not merging resources in libraries not implemented yet.");
/*     */     
/* 287 */     VerifyLibraryResourcesTask.access$102(verifyLibraryResources, scope
/* 288 */       .getOutput(sourceTaskOutputType.getOutputType()));
/*     */     
/* 290 */     VerifyLibraryResourcesTask.access$202(verifyLibraryResources, scope.getCompiledResourcesOutputDir());
/* 291 */     VerifyLibraryResourcesTask.access$302(verifyLibraryResources, scope.getResourceBlameLogDir());
/*     */     
/* 294 */     boolean aaptFriendlyManifestsFilePresent = scope.hasOutput(TaskOutputHolder.TaskOutputType.AAPT_FRIENDLY_MERGED_MANIFESTS);
/* 295 */     VerifyLibraryResourcesTask.access$402(verifyLibraryResources, scope
/*     */     
/* 298 */       .getInstantRunBuildContext().isInInstantRunMode() ? TaskOutputHolder.TaskOutputType.INSTANT_RUN_MERGED_MANIFESTS : aaptFriendlyManifestsFilePresent ? TaskOutputHolder.TaskOutputType.AAPT_FRIENDLY_MERGED_MANIFESTS : TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS);
/*     */     
/* 301 */     VerifyLibraryResourcesTask.access$502(verifyLibraryResources, scope
/* 302 */       .getOutput(VerifyLibraryResourcesTask.access$400(verifyLibraryResources)));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.VerifyLibraryResourcesTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */