/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.internal.TaskManager;
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.builder.profile.Recorder;
/*    */ import org.gradle.api.DefaultTask;
/*    */ 
/*    */ public abstract class InstallableVariantData
/*    */   extends AndroidArtifactVariantData
/*    */ {
/*    */   public DefaultTask installTask;
/*    */   public DefaultTask uninstallTask;
/*    */   
/*    */   protected InstallableVariantData(GlobalScope globalScope, AndroidConfig androidConfig, TaskManager taskManager, GradleVariantConfiguration config, Recorder recorder)
/*    */   {
/* 39 */     super(globalScope, androidConfig, taskManager, config, recorder);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.InstallableVariantData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */