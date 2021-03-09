/*    */ package com.android.build.gradle.internal.transforms;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.InstantRunVariantScope;
/*    */ import java.io.File;
/*    */ 
/*    */  enum InstantRunBuildType$2
/*    */ {
/*    */   InstantRunBuildType$2()
/*    */   {
/* 41 */     super(paramString, paramInt, null);
/*    */   }
/*    */   
/*    */   File getOutputFolder(InstantRunVariantScope variantScope) {
/* 45 */     return variantScope.getRestartDexOutputFolder();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunBuildType.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */