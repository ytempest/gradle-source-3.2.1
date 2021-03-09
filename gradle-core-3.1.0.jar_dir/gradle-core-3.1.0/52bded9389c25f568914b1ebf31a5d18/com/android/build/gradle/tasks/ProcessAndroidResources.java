/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.OutputScope;
/*    */ import com.android.build.gradle.internal.tasks.IncrementalTask;
/*    */ import com.android.ide.common.build.ApkData;
/*    */ import com.android.utils.FileUtils;
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.google.common.collect.Iterables;
/*    */ import java.io.File;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.gradle.api.tasks.InputFiles;
/*    */ import org.gradle.api.tasks.PathSensitive;
/*    */ import org.gradle.api.tasks.PathSensitivity;
/*    */ 
/*    */ public abstract class ProcessAndroidResources
/*    */   extends IncrementalTask
/*    */ {
/*    */   protected OutputScope outputScope;
/*    */   protected FileCollection manifestFiles;
/*    */   
/*    */   @InputFiles
/*    */   @PathSensitive(PathSensitivity.RELATIVE)
/*    */   public FileCollection getManifestFiles()
/*    */   {
/* 41 */     return manifestFiles;
/*    */   }
/*    */   
/*    */   protected void setManifestFiles(FileCollection manifestFiles) {
/* 45 */     this.manifestFiles = manifestFiles;
/*    */   }
/*    */   
/*    */   public abstract File getSourceOutputDir();
/*    */   
/*    */   public File getManifestFile()
/*    */   {
/* 52 */     File manifestDirectory = (File)Iterables.getFirst(manifestFiles.getFiles(), null);
/* 53 */     Preconditions.checkNotNull(manifestDirectory);
/* 54 */     Preconditions.checkNotNull(outputScope.getMainSplit());
/* 55 */     return FileUtils.join(manifestDirectory, new String[] {outputScope
/*    */     
/* 57 */       .getMainSplit().getDirName(), "AndroidManifest.xml" });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ProcessAndroidResources
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */