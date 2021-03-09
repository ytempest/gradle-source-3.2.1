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
/*    */ public class InstantAppVariantData
/*    */   extends BaseVariantData
/*    */ {
/*    */   public InstantAppVariantData(GlobalScope globalScope, AndroidConfig androidConfig, TaskManager taskManager, GradleVariantConfiguration config, Recorder recorder)
/*    */   {
/* 36 */     super(globalScope, androidConfig, taskManager, config, recorder);
/*    */   }
/*    */   
/*    */   public String getDescription()
/*    */   {
/* 42 */     GradleVariantConfiguration config = getVariantConfiguration();
/*    */     
/* 44 */     if (config.hasFlavors()) {
/* 45 */       StringBuilder sb = new StringBuilder(50);
/* 46 */       StringHelper.appendCapitalized(sb, ((CoreBuildType)config.getBuildType()).getName());
/* 47 */       sb.append(" build for flavor ");
/* 48 */       StringHelper.appendCapitalized(sb, config.getFlavorName());
/* 49 */       return sb.toString();
/*    */     }
/* 51 */     return StringHelper.capitalizeWithSuffix(((CoreBuildType)config.getBuildType()).getName(), " build");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.InstantAppVariantData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */