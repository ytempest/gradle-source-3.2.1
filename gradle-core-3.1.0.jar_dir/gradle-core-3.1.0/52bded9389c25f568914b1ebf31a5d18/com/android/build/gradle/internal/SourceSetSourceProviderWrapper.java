/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import com.android.builder.model.SourceProvider;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import org.gradle.api.file.SourceDirectorySet;
/*     */ import org.gradle.api.tasks.SourceSet;
/*     */ 
/*     */ public class SourceSetSourceProviderWrapper
/*     */   implements SourceProvider
/*     */ {
/*     */   private final SourceSet sourceSet;
/*     */   
/*     */   public SourceSetSourceProviderWrapper(SourceSet sourceSet)
/*     */   {
/*  38 */     this.sourceSet = sourceSet;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  44 */     return sourceSet.getName();
/*     */   }
/*     */   
/*     */   public File getManifestFile()
/*     */   {
/*  50 */     throw new IllegalAccessError("Shouldn't access manifest from SourceSetSourceProviderWrapper");
/*     */   }
/*     */   
/*     */   public Collection<File> getJavaDirectories()
/*     */   {
/*  56 */     return sourceSet.getJava().getSrcDirs();
/*     */   }
/*     */   
/*     */   public Collection<File> getResourcesDirectories()
/*     */   {
/*  62 */     return sourceSet.getResources().getSrcDirs();
/*     */   }
/*     */   
/*     */   public Collection<File> getAidlDirectories()
/*     */   {
/*  68 */     return ImmutableList.of();
/*     */   }
/*     */   
/*     */   public Collection<File> getRenderscriptDirectories()
/*     */   {
/*  74 */     return ImmutableList.of();
/*     */   }
/*     */   
/*     */   public Collection<File> getCDirectories()
/*     */   {
/*  80 */     return ImmutableList.of();
/*     */   }
/*     */   
/*     */   public Collection<File> getCppDirectories()
/*     */   {
/*  86 */     return ImmutableList.of();
/*     */   }
/*     */   
/*     */   public Collection<File> getResDirectories()
/*     */   {
/*  92 */     return ImmutableList.of();
/*     */   }
/*     */   
/*     */   public Collection<File> getAssetsDirectories()
/*     */   {
/*  98 */     return ImmutableList.of();
/*     */   }
/*     */   
/*     */   public Collection<File> getJniLibsDirectories()
/*     */   {
/* 104 */     return ImmutableList.of();
/*     */   }
/*     */   
/*     */   public Collection<File> getShadersDirectories()
/*     */   {
/* 110 */     return ImmutableList.of();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.SourceSetSourceProviderWrapper
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */