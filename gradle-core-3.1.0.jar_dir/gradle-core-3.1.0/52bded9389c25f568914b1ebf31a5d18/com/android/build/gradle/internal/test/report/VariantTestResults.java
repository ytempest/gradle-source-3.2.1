/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ class VariantTestResults
/*    */   extends CompositeTestResults
/*    */ {
/*    */   private final String name;
/*    */   
/*    */   public VariantTestResults(String name, CompositeTestResults parent)
/*    */   {
/* 28 */     super(parent);
/* 29 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getTitle()
/*    */   {
/* 34 */     return name;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 39 */     return name;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.VariantTestResults
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */