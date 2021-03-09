/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.InstantRunVariantScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TransformVariantScope;
/*     */ 
/*     */ public class PreColdSwapTask$ConfigAction
/*     */   implements TaskConfigAction<PreColdSwapTask>
/*     */ {
/*     */   protected final TransformVariantScope transformVariantScope;
/*     */   protected final InstantRunVariantScope instantRunVariantScope;
/*     */   protected final String name;
/*     */   
/*     */   public PreColdSwapTask$ConfigAction(String name, TransformVariantScope transformVariantScope, InstantRunVariantScope instantRunVariantScope)
/*     */   {
/*  89 */     this.name = name;
/*  90 */     this.transformVariantScope = transformVariantScope;
/*  91 */     this.instantRunVariantScope = instantRunVariantScope;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  97 */     return transformVariantScope.getTaskName(name);
/*     */   }
/*     */   
/*     */   public Class<PreColdSwapTask> getType()
/*     */   {
/* 103 */     return PreColdSwapTask.class;
/*     */   }
/*     */   
/*     */   public void execute(PreColdSwapTask task)
/*     */   {
/* 108 */     task.setVariantName(instantRunVariantScope.getFullVariantName());
/* 109 */     PreColdSwapTask.access$002(task, transformVariantScope);
/* 110 */     PreColdSwapTask.access$102(task, instantRunVariantScope);
/* 111 */     PreColdSwapTask.access$202(task, instantRunVariantScope.getInstantRunBuildContext());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.PreColdSwapTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */