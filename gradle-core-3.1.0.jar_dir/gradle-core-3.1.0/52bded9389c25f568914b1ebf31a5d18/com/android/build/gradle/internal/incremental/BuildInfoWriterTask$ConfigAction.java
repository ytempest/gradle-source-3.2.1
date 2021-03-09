/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.InstantRunVariantScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TransformVariantScope;
/*     */ import java.io.File;
/*     */ import org.gradle.api.logging.Logger;
/*     */ 
/*     */ public class BuildInfoWriterTask$ConfigAction
/*     */   implements TaskConfigAction<BuildInfoWriterTask>
/*     */ {
/*     */   private final String taskName;
/*     */   private final InstantRunVariantScope variantScope;
/*     */   private final Logger logger;
/*     */   
/*     */   public static File getBuildInfoFile(InstantRunVariantScope scope)
/*     */   {
/*  91 */     return new File(scope.getBuildInfoOutputFolder(), "build-info.xml");
/*     */   }
/*     */   
/*     */   public static File getTmpBuildInfoFile(InstantRunVariantScope scope) {
/*  95 */     return new File(scope.getBuildInfoOutputFolder(), "tmp-build-info.xml");
/*     */   }
/*     */   
/*     */   public BuildInfoWriterTask$ConfigAction(InstantRunVariantScope scope, Logger logger)
/*     */   {
/* 105 */     taskName = scope.getTransformVariantScope().getTaskName("buildInfoGenerator");
/* 106 */     variantScope = scope;
/* 107 */     this.logger = logger;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 113 */     return taskName;
/*     */   }
/*     */   
/*     */   public Class<BuildInfoWriterTask> getType()
/*     */   {
/* 119 */     return BuildInfoWriterTask.class;
/*     */   }
/*     */   
/*     */   public void execute(BuildInfoWriterTask task)
/*     */   {
/* 124 */     task.setDescription("InstantRun task to build incremental artifacts");
/* 125 */     task.setVariantName(variantScope.getFullVariantName());
/* 126 */     buildInfoFile = getBuildInfoFile(variantScope);
/* 127 */     tmpBuildInfoFile = getTmpBuildInfoFile(variantScope);
/* 128 */     buildContext = variantScope.getInstantRunBuildContext();
/* 129 */     logger = logger;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.BuildInfoWriterTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */