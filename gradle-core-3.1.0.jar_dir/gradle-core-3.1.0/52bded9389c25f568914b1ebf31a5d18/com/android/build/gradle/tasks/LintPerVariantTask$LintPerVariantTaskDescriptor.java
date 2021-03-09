/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ class LintPerVariantTask$LintPerVariantTaskDescriptor
/*    */   extends LintBaseTask.LintBaseTaskDescriptor
/*    */ {
/*    */   private LintPerVariantTask$LintPerVariantTaskDescriptor(LintPerVariantTask paramLintPerVariantTask)
/*    */   {
/* 44 */     super(paramLintPerVariantTask);
/*    */   }
/*    */   
/*    */   public String getVariantName() {
/* 48 */     return this$0.getVariantName();
/*    */   }
/*    */   
/*    */   public LintBaseTask.VariantInputs getVariantInputs(String variantName)
/*    */   {
/* 54 */     assert (variantName.equals(getVariantName()));
/* 55 */     return LintPerVariantTask.access$100(this$0);
/*    */   }
/*    */   
/*    */   public boolean isFatalOnly()
/*    */   {
/* 60 */     return LintPerVariantTask.access$200(this$0);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.LintPerVariantTask.LintPerVariantTaskDescriptor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */