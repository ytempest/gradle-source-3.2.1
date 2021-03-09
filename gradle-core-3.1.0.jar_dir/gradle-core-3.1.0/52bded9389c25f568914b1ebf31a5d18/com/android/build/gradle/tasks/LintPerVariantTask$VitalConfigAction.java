/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ 
/*     */ public class LintPerVariantTask$VitalConfigAction
/*     */   extends LintBaseTask.BaseConfigAction<LintPerVariantTask>
/*     */ {
/*     */   private final VariantScope scope;
/*     */   
/*     */   public LintPerVariantTask$VitalConfigAction(VariantScope scope)
/*     */   {
/* 106 */     super(scope.getGlobalScope());
/* 107 */     this.scope = scope;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 113 */     return scope.getTaskName("lintVital");
/*     */   }
/*     */   
/*     */   public Class<LintPerVariantTask> getType()
/*     */   {
/* 119 */     return LintPerVariantTask.class;
/*     */   }
/*     */   
/*     */   public void execute(LintPerVariantTask task)
/*     */   {
/* 124 */     super.execute(task);
/*     */     
/* 126 */     String variantName = scope.getVariantData().getVariantConfiguration().getFullName();
/* 127 */     task.setVariantName(variantName);
/*     */     
/* 129 */     LintPerVariantTask.access$102(task, new LintBaseTask.VariantInputs(scope));
/* 130 */     LintPerVariantTask.access$202(task, true);
/* 131 */     task.setDescription("Runs lint on just the fatal issues in the " + variantName + " build.");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.LintPerVariantTask.VitalConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */