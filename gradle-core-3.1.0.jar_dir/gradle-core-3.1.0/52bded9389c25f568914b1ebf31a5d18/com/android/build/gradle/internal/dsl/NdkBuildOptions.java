/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.build.gradle.internal.model.CoreNdkBuildOptions;
/*     */ import java.io.File;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Project;
/*     */ 
/*     */ public class NdkBuildOptions
/*     */   implements CoreNdkBuildOptions
/*     */ {
/*     */   private final Project project;
/*     */   private File path;
/*     */   private File buildStagingDirectory;
/*     */   
/*     */   @Inject
/*     */   public NdkBuildOptions(Project project)
/*     */   {
/*  50 */     this.project = project;
/*     */   }
/*     */   
/*     */   public File getPath()
/*     */   {
/*  78 */     return path;
/*     */   }
/*     */   
/*     */   public void setPath(Object path) {
/*  82 */     this.path = project.file(path);
/*     */   }
/*     */   
/*     */   public void setPath(File path)
/*     */   {
/*  87 */     this.path = path;
/*     */   }
/*     */   
/*     */   public File getBuildStagingDirectory()
/*     */   {
/* 122 */     return buildStagingDirectory;
/*     */   }
/*     */   
/*     */   public void setBuildStagingDirectory(File buildStagingDirectory)
/*     */   {
/* 127 */     this.buildStagingDirectory = project.file(buildStagingDirectory);
/*     */   }
/*     */   
/*     */   public void setBuildStagingDirectory(Object buildStagingDirectory) {
/* 131 */     this.buildStagingDirectory = project.file(buildStagingDirectory);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.NdkBuildOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */