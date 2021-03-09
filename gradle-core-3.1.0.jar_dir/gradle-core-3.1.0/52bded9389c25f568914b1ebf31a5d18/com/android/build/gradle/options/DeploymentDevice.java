/*    */ package com.android.build.gradle.options;
/*    */ 
/*    */ import com.android.sdklib.AndroidVersion;
/*    */ 
/*    */ public final class DeploymentDevice
/*    */ {
/*    */   public static AndroidVersion getDeploymentDeviceAndroidVersion(ProjectOptions options)
/*    */   {
/* 36 */     Integer apiLevel = options.get(IntegerOption.IDE_TARGET_DEVICE_API);
/* 37 */     if (apiLevel == null) {
/* 38 */       return AndroidVersion.DEFAULT;
/*    */     }
/* 40 */     String codeName = options.get(StringOption.IDE_TARGET_DEVICE_CODENAME);
/* 41 */     return new AndroidVersion(apiLevel.intValue(), codeName);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.DeploymentDevice
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */