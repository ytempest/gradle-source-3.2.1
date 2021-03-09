/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ 
/*     */ public class CheckProguardFiles$ConfigAction
/*     */   implements TaskConfigAction<CheckProguardFiles>
/*     */ {
/*     */   private final VariantScope scope;
/*     */   
/*     */   public CheckProguardFiles$ConfigAction(VariantScope scope)
/*     */   {
/*  98 */     this.scope = scope;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 104 */     return scope.getTaskName("check", "ProguardFiles");
/*     */   }
/*     */   
/*     */   public Class<CheckProguardFiles> getType()
/*     */   {
/* 110 */     return CheckProguardFiles.class;
/*     */   }
/*     */   
/*     */   public void execute(CheckProguardFiles task)
/*     */   {
/* 115 */     CheckProguardFiles.access$002(task, scope.getProguardFiles());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.CheckProguardFiles.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */