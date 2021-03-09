/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.build.gradle.api.BaseVariantOutput;
/*    */ import com.android.build.gradle.api.FeatureVariant;
/*    */ import com.android.build.gradle.api.TestVariant;
/*    */ import com.android.build.gradle.api.UnitTestVariant;
/*    */ import com.android.build.gradle.internal.variant.ApkVariantData;
/*    */ import com.android.build.gradle.internal.variant.FeatureVariantData;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public class FeatureVariantImpl
/*    */   extends ApkVariantImpl
/*    */   implements FeatureVariant
/*    */ {
/*    */   private final FeatureVariantData variantData;
/* 42 */   private TestVariant testVariant = null;
/* 43 */   private UnitTestVariant unitTestVariant = null;
/*    */   
/*    */   @Inject
/*    */   public FeatureVariantImpl(FeatureVariantData variantData, ObjectFactory objectFactory, AndroidBuilder androidBuilder, ReadOnlyObjectProvider readOnlyObjectProvider, NamedDomainObjectContainer<BaseVariantOutput> outputs)
/*    */   {
/* 52 */     super(objectFactory, androidBuilder, readOnlyObjectProvider, outputs);
/* 53 */     this.variantData = variantData;
/*    */   }
/*    */   
/*    */   public ApkVariantData getVariantData()
/*    */   {
/* 59 */     return variantData;
/*    */   }
/*    */   
/*    */   public void setTestVariant(TestVariant testVariant)
/*    */   {
/* 64 */     this.testVariant = testVariant;
/*    */   }
/*    */   
/*    */   public TestVariant getTestVariant()
/*    */   {
/* 70 */     return testVariant;
/*    */   }
/*    */   
/*    */   public UnitTestVariant getUnitTestVariant()
/*    */   {
/* 76 */     return unitTestVariant;
/*    */   }
/*    */   
/*    */   public void setUnitTestVariant(UnitTestVariant unitTestVariant)
/*    */   {
/* 81 */     this.unitTestVariant = unitTestVariant;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.FeatureVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */