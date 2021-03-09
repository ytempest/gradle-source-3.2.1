/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.google.common.base.Charsets;
/*    */ import com.google.common.io.Files;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import org.gradle.api.tasks.InputFiles;
/*    */ import org.gradle.api.tasks.OutputFile;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ 
/*    */ public class MergeFileTask
/*    */   extends AndroidVariantTask
/*    */ {
/*    */   private Set<File> mInputFiles;
/*    */   private File mOutputFile;
/*    */   
/*    */   @TaskAction
/*    */   public void mergeFiles()
/*    */     throws IOException
/*    */   {
/* 37 */     Set<File> files = getInputFiles();
/* 38 */     File output = getOutputFile();
/*    */     
/* 40 */     if (files.size() == 1) {
/* 41 */       Files.copy((File)files.iterator().next(), output);
/* 42 */       return;
/*    */     }
/*    */     
/* 46 */     output.delete();
/*    */     
/* 49 */     if (files.isEmpty()) {
/* 50 */       return;
/*    */     }
/*    */     
/* 54 */     for (File file : files) {
/* 55 */       String content = Files.toString(file, Charsets.UTF_8);
/* 56 */       Files.append(content, output, Charsets.UTF_8);
/* 57 */       Files.append("\n", output, Charsets.UTF_8);
/*    */     }
/*    */   }
/*    */   
/*    */   @InputFiles
/*    */   public Set<File> getInputFiles() {
/* 63 */     return mInputFiles;
/*    */   }
/*    */   
/*    */   public void setInputFiles(Set<File> inputFiles) {
/* 67 */     mInputFiles = inputFiles;
/*    */   }
/*    */   
/*    */   @OutputFile
/*    */   public File getOutputFile() {
/* 72 */     return mOutputFile;
/*    */   }
/*    */   
/*    */   public void setOutputFile(File outputFile) {
/* 76 */     mOutputFile = outputFile;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.MergeFileTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */