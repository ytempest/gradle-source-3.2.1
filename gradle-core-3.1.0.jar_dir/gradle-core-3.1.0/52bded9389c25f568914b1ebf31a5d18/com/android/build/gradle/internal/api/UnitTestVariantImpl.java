/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.build.gradle.api.BaseVariantOutput;
/*    */ import com.android.build.gradle.api.UnitTestVariant;
/*    */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*    */ import com.android.build.gradle.internal.variant.TestVariantData;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public class UnitTestVariantImpl
/*    */   extends BaseVariantImpl
/*    */   implements UnitTestVariant
/*    */ {
/*    */   private final TestVariantData variantData;
/*    */   private final TestedVariant testedVariant;
/*    */   
/*    */   @Inject
/*    */   public UnitTestVariantImpl(TestVariantData variantData, TestedVariant testedVariant, ObjectFactory objectFactory, AndroidBuilder androidBuilder, ReadOnlyObjectProvider readOnlyObjectProvider, NamedDomainObjectContainer<BaseVariantOutput> outputs)
/*    */   {
/* 47 */     super(objectFactory, androidBuilder, readOnlyObjectProvider, outputs);
/*    */     
/* 49 */     this.variantData = variantData;
/* 50 */     this.testedVariant = testedVariant;
/*    */   }
/*    */   
/*    */   protected BaseVariantData getVariantData()
/*    */   {
/* 56 */     return variantData;
/*    */   }
/*    */   
/*    */   public TestedVariant getTestedVariant()
/*    */   {
/* 62 */     return testedVariant;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.UnitTestVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */