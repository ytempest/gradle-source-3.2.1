/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.LoggerWrapper;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import com.android.builder.sdk.TargetInfo;
/*    */ import com.android.sdklib.BuildToolInfo;
/*    */ import com.android.utils.ILogger;
/*    */ import com.google.common.base.Preconditions;
/*    */ import org.gradle.api.tasks.Internal;
/*    */ 
/*    */ public abstract class AndroidBuilderTask
/*    */   extends AndroidVariantTask
/*    */ {
/*    */   private AndroidBuilder androidBuilder;
/*    */   private ILogger iLogger;
/*    */   
/*    */   @Internal("No influence on output, this is to give access to the build to other classes")
/*    */   protected AndroidBuilder getBuilder()
/*    */   {
/* 45 */     Preconditions.checkState(androidBuilder != null, "androidBuilder required for task '%s'.", 
/* 46 */       getName());
/* 47 */     return androidBuilder;
/*    */   }
/*    */   
/*    */   @Internal
/*    */   protected ILogger getILogger()
/*    */   {
/* 53 */     if (iLogger == null) {
/* 54 */       iLogger = new LoggerWrapper(getLogger());
/*    */     }
/* 56 */     return iLogger;
/*    */   }
/*    */   
/*    */   @Internal("No influence on output, this is to give access to the build tools")
/*    */   protected BuildToolInfo getBuildTools()
/*    */   {
/* 67 */     TargetInfo targetInfo = getBuilder().getTargetInfo();
/* 68 */     Preconditions.checkState(targetInfo != null, "androidBuilder.targetInfo required for task '%s'.", 
/* 69 */       getName());
/* 70 */     return targetInfo.getBuildTools();
/*    */   }
/*    */   
/*    */   public void setAndroidBuilder(AndroidBuilder androidBuilder) {
/* 74 */     this.androidBuilder = androidBuilder;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.AndroidBuilderTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */