/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.build.gradle.internal.model.CoreCmakeOptions;
/*     */ import java.io.File;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Project;
/*     */ 
/*     */ public class CmakeOptions
/*     */   implements CoreCmakeOptions
/*     */ {
/*     */   private final Project project;
/*     */   private File path;
/*     */   private File buildStagingDirectory;
/*     */   private String version;
/*     */   
/*     */   @Inject
/*     */   public CmakeOptions(Project project)
/*     */   {
/*  53 */     this.project = project;
/*     */   }
/*     */   
/*     */   public File getPath()
/*     */   {
/*  83 */     return path;
/*     */   }
/*     */   
/*     */   public void setPath(Object path) {
/*  87 */     this.path = project.file(path);
/*     */   }
/*     */   
/*     */   public void setPath(File path)
/*     */   {
/*  92 */     this.path = path;
/*     */   }
/*     */   
/*     */   public File getBuildStagingDirectory()
/*     */   {
/* 131 */     return buildStagingDirectory;
/*     */   }
/*     */   
/*     */   public void setBuildStagingDirectory(File buildStagingDirectory)
/*     */   {
/* 136 */     this.buildStagingDirectory = project.file(buildStagingDirectory);
/*     */   }
/*     */   
/*     */   public String getVersion()
/*     */   {
/* 180 */     return version;
/*     */   }
/*     */   
/*     */   public void setVersion(String version)
/*     */   {
/* 185 */     this.version = version;
/*     */   }
/*     */   
/*     */   public void setBuildStagingDirectory(Object buildStagingDirectory) {
/* 189 */     this.buildStagingDirectory = project.file(buildStagingDirectory);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.CmakeOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */