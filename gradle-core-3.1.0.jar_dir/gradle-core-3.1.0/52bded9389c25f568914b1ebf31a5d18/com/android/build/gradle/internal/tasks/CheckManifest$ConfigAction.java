/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import java.io.File;
/*     */ 
/*     */ public class CheckManifest$ConfigAction
/*     */   implements TaskConfigAction<CheckManifest>
/*     */ {
/*     */   private final VariantScope scope;
/*     */   private final boolean isManifestOptional;
/*     */   
/*     */   public CheckManifest$ConfigAction(VariantScope scope, boolean isManifestOptional)
/*     */   {
/*  81 */     this.scope = scope;
/*  82 */     this.isManifestOptional = isManifestOptional;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  88 */     return scope.getTaskName("check", "Manifest");
/*     */   }
/*     */   
/*     */   public Class<CheckManifest> getType()
/*     */   {
/*  94 */     return CheckManifest.class;
/*     */   }
/*     */   
/*     */   public void execute(CheckManifest checkManifestTask)
/*     */   {
/*  99 */     scope.getVariantData().checkManifestTask = checkManifestTask;
/* 100 */     checkManifestTask.setVariantName(scope
/* 101 */       .getVariantData().getVariantConfiguration().getFullName());
/* 102 */     checkManifestTask.setOptional(Boolean.valueOf(isManifestOptional));
/* 103 */     CheckManifest.access$002(checkManifestTask, scope
/* 104 */       .getVariantData().getVariantConfiguration().getMainManifest());
/*     */     
/* 106 */     CheckManifest.access$102(checkManifestTask, new File(scope
/*     */     
/* 108 */       .getGlobalScope().getIntermediatesDir(), "check-manifest/" + scope
/* 109 */       .getVariantConfiguration().getDirName()));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.CheckManifest.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */