/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.ApkVariantData;
/*     */ import com.android.builder.model.ApiVersion;
/*     */ import com.android.sdklib.AndroidVersion;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public class GenerateApkDataTask$ConfigAction
/*     */   implements TaskConfigAction<GenerateApkDataTask>
/*     */ {
/*     */   VariantScope scope;
/*     */   FileCollection apkFileCollection;
/*     */   
/*     */   public GenerateApkDataTask$ConfigAction(VariantScope scope, FileCollection apkFileCollection)
/*     */   {
/* 186 */     this.scope = scope;
/* 187 */     this.apkFileCollection = apkFileCollection;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 193 */     return scope.getTaskName("handle", "MicroApk");
/*     */   }
/*     */   
/*     */   public Class<GenerateApkDataTask> getType()
/*     */   {
/* 199 */     return GenerateApkDataTask.class;
/*     */   }
/*     */   
/*     */   public void execute(GenerateApkDataTask task)
/*     */   {
/* 204 */     ApkVariantData variantData = (ApkVariantData)scope.getVariantData();
/*     */     
/* 206 */     GradleVariantConfiguration variantConfiguration = variantData.getVariantConfiguration();
/*     */     
/* 208 */     generateApkDataTask = task;
/*     */     
/* 210 */     task.setAndroidBuilder(scope.getGlobalScope().getAndroidBuilder());
/* 211 */     task.setVariantName(variantConfiguration.getFullName());
/*     */     
/* 213 */     task.setResOutputDir(scope.getMicroApkResDirectory());
/*     */     
/* 215 */     GenerateApkDataTask.access$002(task, apkFileCollection);
/*     */     
/* 217 */     GenerateApkDataTask.access$102(task, scope.getMicroApkManifestFile());
/* 218 */     GenerateApkDataTask.access$202(task, variantConfiguration.getApplicationId());
/* 219 */     GenerateApkDataTask.access$302(task, variantConfiguration.getMinSdkVersion().getApiLevel());
/* 220 */     GenerateApkDataTask.access$402(task, variantConfiguration.getTargetSdkVersion().getApiLevel());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.GenerateApkDataTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */