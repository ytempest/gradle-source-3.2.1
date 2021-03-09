/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ import com.android.sdklib.AndroidVersion;
/*    */ 
/*    */ public enum InstantRunPatchingPolicy
/*    */ {
/* 31 */   UNKNOWN_PATCHING_POLICY, 
/*    */   
/* 37 */   MULTI_APK, 
/*    */   
/* 46 */   MULTI_APK_SEPARATE_RESOURCES;
/*    */   
/*    */   private InstantRunPatchingPolicy() {}
/*    */   
/*    */   public static InstantRunPatchingPolicy getPatchingPolicy(AndroidVersion androidVersion, boolean useAapt2OrAbove, boolean createSeparateApkForResources)
/*    */   {
/* 63 */     if (androidVersion.getFeatureLevel() < AndroidVersion.ART_RUNTIME.getFeatureLevel()) {
/* 64 */       return UNKNOWN_PATCHING_POLICY;
/*    */     }
/* 66 */     return (androidVersion.getFeatureLevel() >= 26) && (useAapt2OrAbove) && (createSeparateApkForResources) ? MULTI_APK_SEPARATE_RESOURCES : MULTI_APK;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunPatchingPolicy
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */