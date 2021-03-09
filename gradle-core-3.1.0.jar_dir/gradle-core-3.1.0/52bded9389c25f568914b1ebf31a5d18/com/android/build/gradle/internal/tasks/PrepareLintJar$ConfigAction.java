/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import java.io.File;
/*     */ 
/*     */ public class PrepareLintJar$ConfigAction
/*     */   implements TaskConfigAction<PrepareLintJar>
/*     */ {
/*     */   private final GlobalScope scope;
/*     */   private final File destFile;
/*     */   
/*     */   public PrepareLintJar$ConfigAction(GlobalScope scope, File destFile)
/*     */   {
/*  87 */     this.scope = scope;
/*  88 */     this.destFile = destFile;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  94 */     return "prepareLintJar";
/*     */   }
/*     */   
/*     */   public Class<PrepareLintJar> getType()
/*     */   {
/* 100 */     return PrepareLintJar.class;
/*     */   }
/*     */   
/*     */   public void execute(PrepareLintJar task)
/*     */   {
/* 105 */     PrepareLintJar.access$002(task, destFile);
/* 106 */     PrepareLintJar.access$102(task, scope.getLocalCustomLintChecks());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.PrepareLintJar.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */