/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ 
/*     */ public class AppPreBuildTask$ConfigAction
/*     */   implements TaskConfigAction<AppPreBuildTask>
/*     */ {
/*     */   private final VariantScope variantScope;
/*     */   
/*     */   public AppPreBuildTask$ConfigAction(VariantScope variantScope)
/*     */   {
/* 138 */     this.variantScope = variantScope;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 144 */     return variantScope.getTaskName("pre", "Build");
/*     */   }
/*     */   
/*     */   public Class<AppPreBuildTask> getType()
/*     */   {
/* 150 */     return AppPreBuildTask.class;
/*     */   }
/*     */   
/*     */   public void execute(AppPreBuildTask task)
/*     */   {
/* 155 */     task.setVariantName(variantScope.getFullVariantName());
/*     */     
/* 157 */     AppPreBuildTask.access$002(task, variantScope
/* 158 */       .getArtifactCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.ALL, AndroidArtifacts.ArtifactType.MANIFEST));
/* 159 */     AppPreBuildTask.access$102(task, variantScope
/* 160 */       .getArtifactCollection(AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, AndroidArtifacts.ArtifactScope.ALL, AndroidArtifacts.ArtifactType.MANIFEST));
/*     */     
/* 162 */     AppPreBuildTask.access$202(task, new File(variantScope
/*     */     
/* 164 */       .getGlobalScope().getIntermediatesDir(), "prebuild/" + variantScope
/* 165 */       .getVariantConfiguration().getDirName()));
/*     */     
/* 167 */     variantScope.getVariantData().preBuildTask = task;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.AppPreBuildTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */