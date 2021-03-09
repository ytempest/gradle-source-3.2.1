/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.InstantRunVariantScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TransformVariantScope;
/*     */ import org.gradle.api.logging.Logger;
/*     */ 
/*     */ public class BuildInfoLoaderTask$ConfigAction
/*     */   implements TaskConfigAction<BuildInfoLoaderTask>
/*     */ {
/*     */   private final String taskName;
/*     */   private final InstantRunVariantScope variantScope;
/*     */   private final Logger logger;
/*     */   
/*     */   public BuildInfoLoaderTask$ConfigAction(InstantRunVariantScope scope, Logger logger)
/*     */   {
/* 121 */     taskName = scope.getTransformVariantScope().getTaskName("buildInfo", "Loader");
/* 122 */     variantScope = scope;
/* 123 */     this.logger = logger;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 129 */     return taskName;
/*     */   }
/*     */   
/*     */   public Class<BuildInfoLoaderTask> getType()
/*     */   {
/* 135 */     return BuildInfoLoaderTask.class;
/*     */   }
/*     */   
/*     */   public void execute(BuildInfoLoaderTask task)
/*     */   {
/* 140 */     task.setDescription("InstantRun task to load and backup previous iterations artifacts");
/* 141 */     task.setVariantName(variantScope.getFullVariantName());
/* 142 */     buildInfoFile = BuildInfoWriterTask.ConfigAction.getBuildInfoFile(variantScope);
/*     */     
/* 144 */     tmpBuildInfoFile = BuildInfoWriterTask.ConfigAction.getTmpBuildInfoFile(variantScope);
/* 145 */     pastBuildsFolder = variantScope.getInstantRunPastIterationsFolder();
/* 146 */     buildContext = variantScope.getInstantRunBuildContext();
/* 147 */     logger = logger;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.BuildInfoLoaderTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */