/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.DefaultTask;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.OutputFile;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class PrepareLintJar
/*     */   extends DefaultTask
/*     */ {
/*     */   public static final String NAME = "prepareLintJar";
/*     */   private FileCollection lintChecks;
/*     */   private File outputLintJar;
/*     */   
/*     */   @InputFiles
/*     */   public FileCollection getLintChecks()
/*     */   {
/*  50 */     return lintChecks;
/*     */   }
/*     */   
/*     */   @OutputFile
/*     */   public File getOutputLintJar() {
/*  55 */     return outputLintJar;
/*     */   }
/*     */   
/*     */   @TaskAction
/*     */   public void prepare()
/*     */     throws IOException
/*     */   {
/*  63 */     Set<File> files = lintChecks.getFiles();
/*  64 */     if (files.size() > 1) {
/*  65 */       throw new RuntimeException("Found more than one jar in the 'lintChecks' configuration. Only one file is supported. If using a separate Gradle project, make sure compilation dependencies are using compileOnly");
/*     */     }
/*     */     
/*  71 */     if (files.isEmpty()) {
/*  72 */       if (outputLintJar.isFile()) {
/*  73 */         FileUtils.delete(outputLintJar);
/*     */       }
/*     */     } else {
/*  76 */       FileUtils.mkdirs(outputLintJar.getParentFile());
/*  77 */       Files.copy((File)Iterables.getOnlyElement(files), outputLintJar);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ConfigAction implements TaskConfigAction<PrepareLintJar>
/*     */   {
/*     */     private final GlobalScope scope;
/*     */     private final File destFile;
/*     */     
/*     */     public ConfigAction(GlobalScope scope, File destFile) {
/*  87 */       this.scope = scope;
/*  88 */       this.destFile = destFile;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/*  94 */       return "prepareLintJar";
/*     */     }
/*     */     
/*     */     public Class<PrepareLintJar> getType()
/*     */     {
/* 100 */       return PrepareLintJar.class;
/*     */     }
/*     */     
/*     */     public void execute(PrepareLintJar task)
/*     */     {
/* 105 */       outputLintJar = destFile;
/* 106 */       lintChecks = scope.getLocalCustomLintChecks();
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.PrepareLintJar
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */