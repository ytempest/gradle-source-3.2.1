/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.OutputScope;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.builder.utils.FileCache;
/*     */ import java.io.File;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public class PackageApplication$StandardConfigAction
/*     */   extends PackageAndroidArtifact.ConfigAction<PackageApplication>
/*     */ {
/*     */   private final TaskOutputHolder.TaskOutputType expectedOutputType;
/*     */   
/*     */   public PackageApplication$StandardConfigAction(VariantScope packagingScope, File outputDirectory, TaskOutputHolder.TaskOutputType inputResourceFilesType, FileCollection manifests, TaskOutputHolder.TaskOutputType manifestType, OutputScope outputScope, FileCache fileCache, TaskOutputHolder.TaskOutputType expectedOutputType)
/*     */   {
/* 103 */     super(packagingScope, outputDirectory, inputResourceFilesType, manifests, manifestType, fileCache, outputScope);
/*     */     
/* 111 */     this.expectedOutputType = expectedOutputType;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 117 */     return variantScope.getTaskName("package");
/*     */   }
/*     */   
/*     */   public Class<PackageApplication> getType()
/*     */   {
/* 123 */     return PackageApplication.class;
/*     */   }
/*     */   
/*     */   protected void configure(PackageApplication task)
/*     */   {
/* 128 */     super.configure(task);
/* 129 */     expectedOutputType = expectedOutputType;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.PackageApplication.StandardConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */