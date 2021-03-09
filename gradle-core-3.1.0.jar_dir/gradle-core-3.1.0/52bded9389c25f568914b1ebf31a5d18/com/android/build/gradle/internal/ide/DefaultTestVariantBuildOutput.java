/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.TestVariantBuildOutput;
/*    */ import com.android.builder.model.TestVariantBuildOutput.TestType;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class DefaultTestVariantBuildOutput
/*    */   extends DefaultBaseBuildOutput
/*    */   implements TestVariantBuildOutput
/*    */ {
/*    */   private final String testedVariantName;
/*    */   private final TestVariantBuildOutput.TestType testType;
/*    */   
/*    */   public DefaultTestVariantBuildOutput(String name, Collection<EarlySyncBuildOutput> buildOutputSupplier, String testedVariantName, TestVariantBuildOutput.TestType testType)
/*    */   {
/* 35 */     super(name, buildOutputSupplier);
/* 36 */     this.testedVariantName = testedVariantName;
/* 37 */     this.testType = testType;
/*    */   }
/*    */   
/*    */   public String getTestedVariantName()
/*    */   {
/* 43 */     return testedVariantName;
/*    */   }
/*    */   
/*    */   public String getType()
/*    */   {
/* 49 */     return testType.name();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DefaultTestVariantBuildOutput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */