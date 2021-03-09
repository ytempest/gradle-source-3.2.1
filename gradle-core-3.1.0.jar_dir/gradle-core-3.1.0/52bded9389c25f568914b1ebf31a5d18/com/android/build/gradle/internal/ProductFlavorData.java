/*    */ package com.android.build.gradle.internal;
/*    */ 
/*    */ import com.android.build.gradle.internal.api.DefaultAndroidSourceSet;
/*    */ import com.android.build.gradle.internal.dsl.CoreProductFlavor;
/*    */ import org.gradle.api.DefaultTask;
/*    */ 
/*    */ public class ProductFlavorData<T extends CoreProductFlavor>
/*    */   extends VariantDimensionData
/*    */ {
/*    */   private final T productFlavor;
/*    */   private DefaultTask assembleTask;
/*    */   
/*    */   ProductFlavorData(T productFlavor, DefaultAndroidSourceSet sourceSet, DefaultAndroidSourceSet androidTestSourceSet, DefaultAndroidSourceSet unitTestSourceSet)
/*    */   {
/* 36 */     super(sourceSet, androidTestSourceSet, unitTestSourceSet);
/*    */     
/* 38 */     this.productFlavor = productFlavor;
/*    */   }
/*    */   
/*    */   public T getProductFlavor() {
/* 42 */     return productFlavor;
/*    */   }
/*    */   
/*    */   public DefaultTask getAssembleTask()
/*    */   {
/* 47 */     return assembleTask;
/*    */   }
/*    */   
/*    */   public void setAssembleTask(DefaultTask assembleTask) {
/* 51 */     this.assembleTask = assembleTask;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ProductFlavorData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */