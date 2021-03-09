/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.build.gradle.api.BaseVariant;
/*    */ import com.android.build.gradle.api.BaseVariantOutput;
/*    */ import com.android.build.gradle.api.TestVariant;
/*    */ import com.android.build.gradle.internal.variant.TestVariantData;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.DefaultTask;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public class TestVariantImpl
/*    */   extends ApkVariantImpl
/*    */   implements TestVariant
/*    */ {
/*    */   private final TestVariantData variantData;
/*    */   private final BaseVariant testedVariantData;
/*    */   
/*    */   @Inject
/*    */   public TestVariantImpl(TestVariantData variantData, BaseVariant testedVariantData, ObjectFactory objectFactory, AndroidBuilder androidBuilder, ReadOnlyObjectProvider readOnlyObjectProvider, NamedDomainObjectContainer<BaseVariantOutput> outputs)
/*    */   {
/* 52 */     super(objectFactory, androidBuilder, readOnlyObjectProvider, outputs);
/* 53 */     this.variantData = variantData;
/* 54 */     this.testedVariantData = testedVariantData;
/*    */   }
/*    */   
/*    */   public TestVariantData getVariantData()
/*    */   {
/* 60 */     return variantData;
/*    */   }
/*    */   
/*    */   public BaseVariant getTestedVariant()
/*    */   {
/* 66 */     return testedVariantData;
/*    */   }
/*    */   
/*    */   public DefaultTask getConnectedInstrumentTest()
/*    */   {
/* 71 */     return variantData.connectedTestTask;
/*    */   }
/*    */   
/*    */   public List<? extends DefaultTask> getProviderInstrumentTests()
/*    */   {
/* 77 */     return variantData.providerTestTaskList;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.TestVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */