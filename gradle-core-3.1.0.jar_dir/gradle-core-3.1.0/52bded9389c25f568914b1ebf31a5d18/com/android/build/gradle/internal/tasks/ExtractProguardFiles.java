/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.ProguardFiles;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import com.google.common.collect.ImmutableList.Builder;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.gradle.api.DefaultTask;
/*    */ import org.gradle.api.tasks.OutputFiles;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ 
/*    */ public class ExtractProguardFiles
/*    */   extends DefaultTask
/*    */ {
/*    */   private final ImmutableList<File> generatedFiles;
/*    */   
/*    */   public ExtractProguardFiles()
/*    */   {
/* 36 */     ImmutableList.Builder<File> outputs = ImmutableList.builder();
/*    */     
/* 38 */     for (String name : ProguardFiles.KNOWN_FILE_NAMES) {
/* 39 */       outputs.add(ProguardFiles.getDefaultProguardFile(name, getProject()));
/*    */     }
/*    */     
/* 42 */     generatedFiles = outputs.build();
/*    */   }
/*    */   
/*    */   @OutputFiles
/*    */   public List<File> getGeneratedFiles() {
/* 47 */     return generatedFiles;
/*    */   }
/*    */   
/*    */   @TaskAction
/*    */   public void run() throws IOException {
/* 52 */     for (String name : ProguardFiles.KNOWN_FILE_NAMES) {
/* 53 */       File defaultProguardFile = ProguardFiles.getDefaultProguardFile(name, getProject());
/* 54 */       if (!defaultProguardFile.isFile()) {
/* 55 */         ProguardFiles.createProguardFile(name, defaultProguardFile);
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.ExtractProguardFiles
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */