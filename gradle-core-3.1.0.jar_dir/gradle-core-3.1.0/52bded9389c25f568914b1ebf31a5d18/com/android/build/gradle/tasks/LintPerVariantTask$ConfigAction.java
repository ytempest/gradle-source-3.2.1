/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.utils.StringHelper;
/*    */ 
/*    */ public class LintPerVariantTask$ConfigAction
/*    */   extends LintBaseTask.BaseConfigAction<LintPerVariantTask>
/*    */ {
/*    */   private final VariantScope scope;
/*    */   
/*    */   public LintPerVariantTask$ConfigAction(VariantScope scope)
/*    */   {
/* 69 */     super(scope.getGlobalScope());
/* 70 */     this.scope = scope;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 76 */     return scope.getTaskName("lint");
/*    */   }
/*    */   
/*    */   public Class<LintPerVariantTask> getType()
/*    */   {
/* 82 */     return LintPerVariantTask.class;
/*    */   }
/*    */   
/*    */   public void execute(LintPerVariantTask lint)
/*    */   {
/* 87 */     super.execute(lint);
/*    */     
/* 89 */     lint.setVariantName(scope.getVariantConfiguration().getFullName());
/*    */     
/* 91 */     LintPerVariantTask.access$102(lint, new LintBaseTask.VariantInputs(scope));
/*    */     
/* 93 */     lint.setDescription(
/* 94 */       StringHelper.appendCapitalized("Runs lint on the ", scope
/*    */       
/* 96 */       .getVariantConfiguration().getFullName(), " build."));
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.LintPerVariantTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */