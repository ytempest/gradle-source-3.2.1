/*    */ package com.android.build.gradle.internal;
/*    */ 
/*    */ import com.android.build.gradle.internal.api.DefaultAndroidSourceSet;
/*    */ import com.android.builder.core.VariantType;
/*    */ 
/*    */ public abstract class VariantDimensionData
/*    */ {
/*    */   private final DefaultAndroidSourceSet sourceSet;
/*    */   private final DefaultAndroidSourceSet androidTestSourceSet;
/*    */   private final DefaultAndroidSourceSet unitTestSourceSet;
/*    */   
/*    */   public VariantDimensionData(DefaultAndroidSourceSet sourceSet, DefaultAndroidSourceSet androidTestSourceSet, DefaultAndroidSourceSet unitTestSourceSet)
/*    */   {
/* 35 */     this.sourceSet = sourceSet;
/* 36 */     this.androidTestSourceSet = androidTestSourceSet;
/* 37 */     this.unitTestSourceSet = unitTestSourceSet;
/*    */   }
/*    */   
/*    */   public final DefaultAndroidSourceSet getSourceSet()
/*    */   {
/* 42 */     return sourceSet;
/*    */   }
/*    */   
/*    */   public final DefaultAndroidSourceSet getTestSourceSet(VariantType type)
/*    */   {
/* 47 */     switch (type) {
/*    */     case ANDROID_TEST: 
/* 49 */       return androidTestSourceSet;
/*    */     case UNIT_TEST: 
/* 51 */       return unitTestSourceSet;
/*    */     }
/*    */     
/* 54 */     throw new IllegalArgumentException(String.format("Unknown test variant type %s", new Object[] { type }));
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.VariantDimensionData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */