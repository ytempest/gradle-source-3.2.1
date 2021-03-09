/*    */ package com.android.build.gradle.internal.transforms;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.InstantRunVariantScope;
/*    */ import java.io.File;
/*    */ 
/*    */  enum InstantRunBuildType$1
/*    */ {
/*    */   InstantRunBuildType$1()
/*    */   {
/* 30 */     super(paramString, paramInt, null);
/*    */   }
/*    */   
/*    */   File getOutputFolder(InstantRunVariantScope variantScope) {
/* 34 */     return variantScope.getReloadDexOutputFolder();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunBuildType.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */