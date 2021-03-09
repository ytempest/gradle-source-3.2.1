/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.google.common.io.Files;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.gradle.api.DefaultTask;
/*    */ import org.gradle.api.tasks.InputFile;
/*    */ import org.gradle.api.tasks.OutputFile;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ 
/*    */ public class SingleFileCopyTask
/*    */   extends DefaultTask
/*    */ {
/*    */   protected File inputFile;
/*    */   protected File outputFile;
/*    */   
/*    */   @InputFile
/*    */   public File getInputFile()
/*    */   {
/* 50 */     return inputFile;
/*    */   }
/*    */   
/*    */   @OutputFile
/*    */   public File getOutputFile() {
/* 55 */     return outputFile;
/*    */   }
/*    */   
/*    */   public void setInputFile(File inputFile) {
/* 59 */     this.inputFile = inputFile;
/*    */   }
/*    */   
/*    */   public void setOutputFile(File outputFile) {
/* 63 */     this.outputFile = outputFile;
/*    */   }
/*    */   
/*    */   @TaskAction
/*    */   public void copy() throws IOException {
/* 68 */     Files.copy(inputFile, outputFile);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.SingleFileCopyTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */