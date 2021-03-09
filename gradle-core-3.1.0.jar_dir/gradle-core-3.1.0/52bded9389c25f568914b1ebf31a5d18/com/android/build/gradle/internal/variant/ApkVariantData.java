/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.internal.TaskManager;
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.builder.profile.Recorder;
/*    */ import com.android.utils.StringHelper;
/*    */ 
/*    */ public abstract class ApkVariantData
/*    */   extends InstallableVariantData
/*    */ {
/*    */   protected ApkVariantData(GlobalScope globalScope, AndroidConfig androidConfig, TaskManager taskManager, GradleVariantConfiguration config, Recorder recorder)
/*    */   {
/* 35 */     super(globalScope, androidConfig, taskManager, config, recorder);
/*    */   }
/*    */   
/*    */   public String getDescription()
/*    */   {
/* 41 */     GradleVariantConfiguration config = getVariantConfiguration();
/*    */     
/* 43 */     if (config.hasFlavors()) {
/* 44 */       StringBuilder sb = new StringBuilder(50);
/* 45 */       StringHelper.appendCapitalized(sb, ((CoreBuildType)config.getBuildType()).getName());
/* 46 */       StringHelper.appendCapitalized(sb, config.getFlavorName());
/* 47 */       sb.append(" build");
/* 48 */       return sb.toString();
/*    */     }
/* 50 */     return StringHelper.capitalizeWithSuffix(((CoreBuildType)config.getBuildType()).getName(), " build");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.ApkVariantData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */