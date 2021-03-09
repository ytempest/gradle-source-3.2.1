/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import java.io.File;
/*     */ 
/*     */ public class TestPreBuildTask$ConfigAction
/*     */   implements TaskConfigAction<TestPreBuildTask>
/*     */ {
/*     */   private final VariantScope variantScope;
/*     */   
/*     */   public TestPreBuildTask$ConfigAction(VariantScope variantScope)
/*     */   {
/* 138 */     this.variantScope = variantScope;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 144 */     return variantScope.getTaskName("pre", "Build");
/*     */   }
/*     */   
/*     */   public Class<TestPreBuildTask> getType()
/*     */   {
/* 150 */     return TestPreBuildTask.class;
/*     */   }
/*     */   
/*     */   public void execute(TestPreBuildTask task)
/*     */   {
/* 155 */     task.setVariantName(variantScope.getFullVariantName());
/*     */     
/* 157 */     TestPreBuildTask.access$002(task, variantScope
/*     */     
/* 159 */       .getTestedVariantData()
/* 160 */       .getScope()
/* 161 */       .getArtifactCollection(AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, AndroidArtifacts.ArtifactScope.EXTERNAL, AndroidArtifacts.ArtifactType.CLASSES));
/* 162 */     TestPreBuildTask.access$102(task, variantScope
/* 163 */       .getArtifactCollection(AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, AndroidArtifacts.ArtifactScope.EXTERNAL, AndroidArtifacts.ArtifactType.CLASSES));
/*     */     
/* 165 */     TestPreBuildTask.access$202(task, new File(variantScope
/*     */     
/* 167 */       .getGlobalScope().getIntermediatesDir(), "prebuild/" + variantScope
/* 168 */       .getVariantConfiguration().getDirName()));
/*     */     
/* 170 */     variantScope.getVariantData().preBuildTask = task;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.TestPreBuildTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */