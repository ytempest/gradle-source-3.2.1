/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ 
/*     */ public class CheckManifestInInstantRunMode$ConfigAction
/*     */   implements TaskConfigAction<CheckManifestInInstantRunMode>
/*     */ {
/*     */   protected final VariantScope variantScope;
/*     */   
/*     */   public CheckManifestInInstantRunMode$ConfigAction(VariantScope variantScope)
/*     */   {
/* 206 */     this.variantScope = variantScope;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 212 */     return variantScope.getTaskName("checkManifestChanges");
/*     */   }
/*     */   
/*     */   public Class<CheckManifestInInstantRunMode> getType()
/*     */   {
/* 218 */     return CheckManifestInInstantRunMode.class;
/*     */   }
/*     */   
/*     */   public void execute(CheckManifestInInstantRunMode task)
/*     */   {
/* 224 */     CheckManifestInInstantRunMode.access$002(task, variantScope
/* 225 */       .getOutput(TaskOutputHolder.TaskOutputType.INSTANT_RUN_MERGED_MANIFESTS));
/* 226 */     CheckManifestInInstantRunMode.access$102(task, variantScope
/* 227 */       .getInstantRunBuildContext().useSeparateApkForResources() ? TaskOutputHolder.TaskOutputType.INSTANT_RUN_MAIN_APK_RESOURCES : TaskOutputHolder.TaskOutputType.PROCESSED_RES);
/*     */     
/* 230 */     CheckManifestInInstantRunMode.access$202(task, variantScope.getOutput(CheckManifestInInstantRunMode.access$100(task)));
/* 231 */     CheckManifestInInstantRunMode.access$302(task, variantScope.getInstantRunBuildContext());
/* 232 */     CheckManifestInInstantRunMode.access$402(task, variantScope.getManifestCheckerDir());
/* 233 */     task.setVariantName(variantScope.getFullVariantName());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.CheckManifestInInstantRunMode.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */