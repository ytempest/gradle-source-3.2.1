/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.VariantOutput.FilterType;
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.core.VariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.AaptOptions;
/*     */ import com.android.build.gradle.internal.pipeline.StreamFilter;
/*     */ import com.android.build.gradle.internal.pipeline.TransformManager;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.builder.model.BuildType;
/*     */ import java.io.File;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public class PackageSplitAbi$ConfigAction
/*     */   implements TaskConfigAction<PackageSplitAbi>
/*     */ {
/*     */   private VariantScope scope;
/*     */   private File outputDirectory;
/*     */   private FileCollection processedAbiResources;
/*     */   
/*     */   public PackageSplitAbi$ConfigAction(VariantScope scope, File outputDirectory, FileCollection processedAbiResources)
/*     */   {
/* 176 */     this.scope = scope;
/* 177 */     this.outputDirectory = outputDirectory;
/* 178 */     this.processedAbiResources = processedAbiResources;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 184 */     return scope.getTaskName("package", "SplitAbi");
/*     */   }
/*     */   
/*     */   public Class<PackageSplitAbi> getType()
/*     */   {
/* 190 */     return PackageSplitAbi.class;
/*     */   }
/*     */   
/*     */   public void execute(PackageSplitAbi packageSplitAbiTask)
/*     */   {
/* 195 */     VariantConfiguration config = scope.getVariantConfiguration();
/* 196 */     PackageSplitAbi.access$002(packageSplitAbiTask, processedAbiResources);
/* 197 */     PackageSplitAbi.access$102(packageSplitAbiTask, config.getSigningConfig());
/* 198 */     PackageSplitAbi.access$202(packageSplitAbiTask, outputDirectory);
/* 199 */     packageSplitAbiTask.setAndroidBuilder(scope.getGlobalScope().getAndroidBuilder());
/* 200 */     packageSplitAbiTask.setVariantName(config.getFullName());
/* 201 */     PackageSplitAbi.access$302(packageSplitAbiTask, config.getMinSdkVersion());
/* 202 */     PackageSplitAbi.access$402(packageSplitAbiTask, scope
/* 203 */       .getIncrementalDir(packageSplitAbiTask.getName()));
/*     */     
/* 205 */     PackageSplitAbi.access$502(packageSplitAbiTask, scope
/* 206 */       .getGlobalScope().getExtension().getAaptOptions().getNoCompress());
/* 207 */     PackageSplitAbi.access$602(packageSplitAbiTask, config.getBuildType().isJniDebuggable());
/*     */     
/* 209 */     PackageSplitAbi.access$702(packageSplitAbiTask, scope
/* 210 */       .getTransformManager()
/* 211 */       .getPipelineOutputAsFileCollection(StreamFilter.NATIVE_LIBS));
/* 212 */     PackageSplitAbi.access$602(packageSplitAbiTask, config.getBuildType().isJniDebuggable());
/* 213 */     PackageSplitAbi.access$802(packageSplitAbiTask, scope
/* 214 */       .getVariantData().getFilters(VariantOutput.FilterType.ABI));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.PackageSplitAbi.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */