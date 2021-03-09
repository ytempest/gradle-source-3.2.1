/*     */ package com.android.build.gradle.tasks.ir;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.InstantRunVariantScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TransformVariantScope;
/*     */ 
/*     */ public class FastDeployRuntimeExtractorTask$ConfigAction
/*     */   implements TaskConfigAction<FastDeployRuntimeExtractorTask>
/*     */ {
/*     */   private final InstantRunVariantScope instantRunVariantScope;
/*     */   
/*     */   public FastDeployRuntimeExtractorTask$ConfigAction(InstantRunVariantScope instantRunVariantScope)
/*     */   {
/* 106 */     this.instantRunVariantScope = instantRunVariantScope;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 112 */     return instantRunVariantScope.getTransformVariantScope().getTaskName("fastDeploy", "Extractor");
/*     */   }
/*     */   
/*     */   public Class<FastDeployRuntimeExtractorTask> getType()
/*     */   {
/* 119 */     return FastDeployRuntimeExtractorTask.class;
/*     */   }
/*     */   
/*     */   public void execute(FastDeployRuntimeExtractorTask fastDeployRuntimeExtractorTask)
/*     */   {
/* 124 */     fastDeployRuntimeExtractorTask.setVariantName(instantRunVariantScope
/* 125 */       .getFullVariantName());
/* 126 */     fastDeployRuntimeExtractorTask.setOutputFile(instantRunVariantScope
/* 127 */       .getIncrementalRuntimeSupportJar());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ir.FastDeployRuntimeExtractorTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */