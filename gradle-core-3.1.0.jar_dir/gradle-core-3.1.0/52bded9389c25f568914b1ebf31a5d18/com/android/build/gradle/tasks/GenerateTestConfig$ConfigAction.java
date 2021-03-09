/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.OutputScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.sdklib.IAndroidTarget;
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.io.File;
/*     */ import java.nio.file.Paths;
/*     */ 
/*     */ public class GenerateTestConfig$ConfigAction
/*     */   implements TaskConfigAction<GenerateTestConfig>
/*     */ {
/*     */   private final VariantScope scope;
/*     */   private final VariantScope testedScope;
/*     */   private final File outputDirectory;
/*     */   
/*     */   public GenerateTestConfig$ConfigAction(VariantScope scope, File outputDirectory)
/*     */   {
/* 154 */     this.scope = scope;
/*     */     
/* 158 */     testedScope = ((BaseVariantData)Preconditions.checkNotNull(scope.getTestedVariantData(), "Not a unit test variant.")).getScope();
/* 159 */     this.outputDirectory = outputDirectory;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 165 */     return scope.getTaskName("generate", "Config");
/*     */   }
/*     */   
/*     */   public Class<GenerateTestConfig> getType()
/*     */   {
/* 171 */     return GenerateTestConfig.class;
/*     */   }
/*     */   
/*     */   public void execute(GenerateTestConfig task)
/*     */   {
/* 179 */     resourcesDirectory = testedScope.getOutput(TaskOutputHolder.TaskOutputType.MERGED_NOT_COMPILED_RES);
/* 180 */     task.dependsOn(new Object[] { resourcesDirectory });
/* 181 */     assetsDirectory = testedScope.getOutput(TaskOutputHolder.TaskOutputType.MERGED_ASSETS);
/* 182 */     task.dependsOn(new Object[] { assetsDirectory });
/*     */     
/* 184 */     manifests = testedScope.getOutput(TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS);
/* 185 */     mainApkInfo = testedScope.getOutputScope().getMainSplit();
/*     */     
/* 187 */     sdkHome = Paths.get(scope.getGlobalScope().getAndroidBuilder().getTarget().getLocation(), new String[0]);
/* 188 */     generatedJavaResourcesDirectory = outputDirectory;
/* 189 */     packageForR = testedScope.getVariantConfiguration().getOriginalApplicationId();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.GenerateTestConfig.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */