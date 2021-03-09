/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.TestVariantBuildOutput;
/*    */ import com.android.builder.model.VariantBuildOutput;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class DefaultVariantBuildOutput
/*    */   extends DefaultBaseBuildOutput
/*    */   implements VariantBuildOutput
/*    */ {
/*    */   Collection<TestVariantBuildOutput> testVariants;
/*    */   
/*    */   public DefaultVariantBuildOutput(String name, Collection<EarlySyncBuildOutput> buildOutputSupplier, Collection<TestVariantBuildOutput> testVariants)
/*    */   {
/* 34 */     super(name, buildOutputSupplier);
/* 35 */     this.testVariants = testVariants;
/*    */   }
/*    */   
/*    */   public Collection<TestVariantBuildOutput> getTestingVariants()
/*    */   {
/* 41 */     return testVariants;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DefaultVariantBuildOutput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */