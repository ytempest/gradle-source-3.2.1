/*    */ package com.android.build.gradle.internal.core;
/*    */ 
/*    */ import com.android.build.gradle.internal.dsl.CoreExternalNativeBuildOptions;
/*    */ import com.android.build.gradle.internal.dsl.CoreExternalNativeCmakeOptions;
/*    */ import com.android.build.gradle.internal.dsl.CoreExternalNativeNdkBuildOptions;
/*    */ 
/*    */ public class MergedExternalNativeBuildOptions
/*    */   implements CoreExternalNativeBuildOptions
/*    */ {
/* 30 */   private final MergedExternalNativeNdkBuildOptions ndkBuild = new MergedExternalNativeNdkBuildOptions();
/*    */   
/* 33 */   private final MergedExternalNativeCmakeOptions cmake = new MergedExternalNativeCmakeOptions();
/*    */   
/*    */   public void reset()
/*    */   {
/* 37 */     ndkBuild.reset();
/* 38 */     cmake.reset();
/*    */   }
/*    */   
/*    */   public void append(CoreExternalNativeBuildOptions options) {
/* 42 */     ndkBuild.append(options.getExternalNativeNdkBuildOptions());
/* 43 */     cmake.append(options.getExternalNativeCmakeOptions());
/*    */   }
/*    */   
/*    */   public CoreExternalNativeNdkBuildOptions getExternalNativeNdkBuildOptions()
/*    */   {
/* 49 */     return ndkBuild;
/*    */   }
/*    */   
/*    */   public CoreExternalNativeCmakeOptions getExternalNativeCmakeOptions()
/*    */   {
/* 55 */     return cmake;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.core.MergedExternalNativeBuildOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */