/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.build.gradle.api.BaseVariantOutput;
/*    */ import com.android.build.gradle.api.LibraryVariant;
/*    */ import com.android.build.gradle.api.TestVariant;
/*    */ import com.android.build.gradle.api.UnitTestVariant;
/*    */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*    */ import com.android.build.gradle.internal.variant.LibraryVariantData;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ import org.gradle.api.tasks.bundling.Zip;
/*    */ 
/*    */ public class LibraryVariantImpl
/*    */   extends BaseVariantImpl
/*    */   implements LibraryVariant, TestedVariant
/*    */ {
/*    */   private final LibraryVariantData variantData;
/* 44 */   private TestVariant testVariant = null;
/*    */   
/* 46 */   private UnitTestVariant unitTestVariant = null;
/*    */   
/*    */   @Inject
/*    */   public LibraryVariantImpl(LibraryVariantData variantData, ObjectFactory objectFactory, AndroidBuilder androidBuilder, ReadOnlyObjectProvider readOnlyObjectProvider, NamedDomainObjectContainer<BaseVariantOutput> outputs)
/*    */   {
/* 56 */     super(objectFactory, androidBuilder, readOnlyObjectProvider, outputs);
/* 57 */     this.variantData = variantData;
/*    */   }
/*    */   
/*    */   protected BaseVariantData getVariantData()
/*    */   {
/* 63 */     return variantData;
/*    */   }
/*    */   
/*    */   public void setTestVariant(TestVariant testVariant)
/*    */   {
/* 68 */     this.testVariant = testVariant;
/*    */   }
/*    */   
/*    */   public TestVariant getTestVariant()
/*    */   {
/* 74 */     return testVariant;
/*    */   }
/*    */   
/*    */   public UnitTestVariant getUnitTestVariant()
/*    */   {
/* 80 */     return unitTestVariant;
/*    */   }
/*    */   
/*    */   public void setUnitTestVariant(UnitTestVariant unitTestVariant)
/*    */   {
/* 85 */     this.unitTestVariant = unitTestVariant;
/*    */   }
/*    */   
/*    */   public Zip getPackageLibrary()
/*    */   {
/* 92 */     return variantData.packageLibTask;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.LibraryVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */