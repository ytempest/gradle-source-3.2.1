/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.build.gradle.api.ApplicationVariant;
/*    */ import com.android.build.gradle.api.BaseVariantOutput;
/*    */ import com.android.build.gradle.api.TestVariant;
/*    */ import com.android.build.gradle.api.UnitTestVariant;
/*    */ import com.android.build.gradle.internal.variant.ApkVariantData;
/*    */ import com.android.build.gradle.internal.variant.ApplicationVariantData;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public class ApplicationVariantImpl
/*    */   extends ApkVariantImpl
/*    */   implements ApplicationVariant
/*    */ {
/*    */   private final ApplicationVariantData variantData;
/* 44 */   private TestVariant testVariant = null;
/*    */   
/* 47 */   private UnitTestVariant unitTestVariant = null;
/*    */   
/*    */   @Inject
/*    */   public ApplicationVariantImpl(ApplicationVariantData variantData, ObjectFactory objectFactory, AndroidBuilder androidBuilder, ReadOnlyObjectProvider readOnlyObjectProvider, NamedDomainObjectContainer<BaseVariantOutput> outputs)
/*    */   {
/* 57 */     super(objectFactory, androidBuilder, readOnlyObjectProvider, outputs);
/* 58 */     this.variantData = variantData;
/*    */   }
/*    */   
/*    */   public ApkVariantData getVariantData()
/*    */   {
/* 64 */     return variantData;
/*    */   }
/*    */   
/*    */   public void setTestVariant(TestVariant testVariant)
/*    */   {
/* 69 */     this.testVariant = testVariant;
/*    */   }
/*    */   
/*    */   public TestVariant getTestVariant()
/*    */   {
/* 75 */     return testVariant;
/*    */   }
/*    */   
/*    */   public UnitTestVariant getUnitTestVariant()
/*    */   {
/* 81 */     return unitTestVariant;
/*    */   }
/*    */   
/*    */   public void setUnitTestVariant(UnitTestVariant unitTestVariant)
/*    */   {
/* 86 */     this.unitTestVariant = unitTestVariant;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ApplicationVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */