/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.LoggerWrapper;
/*    */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*    */ import com.android.manifmerger.ManifestMerger2;
/*    */ import com.android.manifmerger.ManifestMerger2.Invoker;
/*    */ import com.android.manifmerger.ManifestMerger2.MergeFailureException;
/*    */ import com.android.manifmerger.ManifestMerger2.MergeType;
/*    */ import com.android.manifmerger.MergingReport;
/*    */ import com.android.manifmerger.MergingReport.MergedManifestKind;
/*    */ import com.android.manifmerger.MergingReport.Result;
/*    */ import com.android.utils.ILogger;
/*    */ import com.google.common.base.Supplier;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.apache.tools.ant.BuildException;
/*    */ import org.gradle.api.logging.Logger;
/*    */ import org.gradle.api.tasks.InputFile;
/*    */ import org.gradle.api.tasks.InputFiles;
/*    */ import org.gradle.api.tasks.OutputFile;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ 
/*    */ public class InvokeManifestMerger
/*    */   extends AndroidVariantTask
/*    */   implements Supplier<File>
/*    */ {
/*    */   private File mMainManifestFile;
/*    */   private List<File> mSecondaryManifestFiles;
/*    */   private File mOutputFile;
/*    */   
/*    */   @InputFile
/*    */   public File getMainManifestFile()
/*    */   {
/* 49 */     return mMainManifestFile;
/*    */   }
/*    */   
/*    */   public void setMainManifestFile(File mainManifestFile) {
/* 53 */     mMainManifestFile = mainManifestFile;
/*    */   }
/*    */   
/*    */   @InputFiles
/*    */   public List<File> getSecondaryManifestFiles() {
/* 58 */     return mSecondaryManifestFiles;
/*    */   }
/*    */   
/*    */   public void setSecondaryManifestFiles(List<File> secondaryManifestFiles) {
/* 62 */     mSecondaryManifestFiles = secondaryManifestFiles;
/*    */   }
/*    */   
/*    */   @OutputFile
/*    */   public File getOutputFile() {
/* 67 */     return mOutputFile;
/*    */   }
/*    */   
/*    */   public void setOutputFile(File outputFile) {
/* 71 */     mOutputFile = outputFile;
/*    */   }
/*    */   
/*    */   @TaskAction
/*    */   protected void doFullTaskAction() throws ManifestMerger2.MergeFailureException, IOException {
/* 76 */     ILogger iLogger = new LoggerWrapper(getLogger());
/*    */     
/* 78 */     ManifestMerger2.Invoker mergerInvoker = ManifestMerger2.newMerger(getMainManifestFile(), iLogger, ManifestMerger2.MergeType.APPLICATION);
/* 79 */     List<File> secondaryManifestFiles = getSecondaryManifestFiles();
/* 80 */     mergerInvoker.addLibraryManifests((File[])secondaryManifestFiles.toArray(new File[secondaryManifestFiles.size()]));
/* 81 */     MergingReport mergingReport = mergerInvoker.merge();
/* 82 */     if (mergingReport.getResult().isError()) {
/* 83 */       getLogger().error(mergingReport.getReportString());
/* 84 */       mergingReport.log(iLogger);
/* 85 */       throw new BuildException(mergingReport.getReportString());
/*    */     }
/* 87 */     FileWriter fileWriter = new FileWriter(getOutputFile());Throwable localThrowable3 = null;
/* 88 */     try { fileWriter.append(mergingReport
/* 89 */         .getMergedDocument(MergingReport.MergedManifestKind.MERGED));
/*    */     }
/*    */     catch (Throwable localThrowable1)
/*    */     {
/* 87 */       localThrowable3 = localThrowable1;throw localThrowable1;
/*    */     }
/*    */     finally {
/* 90 */       if (fileWriter != null) if (localThrowable3 != null) try { fileWriter.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else fileWriter.close();
/*    */     }
/*    */   }
/*    */   
/*    */   public File get() {
/* 95 */     return getOutputFile();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.InvokeManifestMerger
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */