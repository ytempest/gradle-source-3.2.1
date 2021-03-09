/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import com.android.build.gradle.internal.ide.ArtifactDependencyGraph;
/*     */ import com.android.build.gradle.internal.ide.level2.GraphItemImpl;
/*     */ import com.android.build.gradle.internal.ide.level2.JavaLibraryImpl;
/*     */ import com.android.builder.dependency.MavenCoordinatesImpl;
/*     */ import com.android.builder.model.level2.DependencyGraphs;
/*     */ import com.android.builder.model.level2.GraphItem;
/*     */ import com.android.builder.model.level2.Library;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.File;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.artifacts.Configuration;
/*     */ 
/*     */ public class ConfigurationDependencyGraphs
/*     */   implements DependencyGraphs
/*     */ {
/*     */   private final Configuration configuration;
/*     */   private List<GraphItem> graphItems;
/*     */   private List<Library> libraries;
/*     */   
/*     */   public ConfigurationDependencyGraphs(Configuration configuration)
/*     */   {
/*  52 */     this.configuration = configuration;
/*     */   }
/*     */   
/*     */   public List<Library> getLibraries()
/*     */   {
/*  57 */     init();
/*  58 */     return libraries;
/*     */   }
/*     */   
/*     */   public List<GraphItem> getCompileDependencies()
/*     */   {
/*  64 */     init();
/*  65 */     return graphItems;
/*     */   }
/*     */   
/*     */   public List<GraphItem> getPackageDependencies()
/*     */   {
/*  71 */     init();
/*  72 */     return graphItems;
/*     */   }
/*     */   
/*     */   public List<String> getProvidedLibraries()
/*     */   {
/*  78 */     return Collections.emptyList();
/*     */   }
/*     */   
/*     */   public List<String> getSkippedLibraries()
/*     */   {
/*  84 */     return Collections.emptyList();
/*     */   }
/*     */   
/*     */   private void init()
/*     */   {
/*  89 */     if (graphItems != null) {
/*  90 */       return;
/*     */     }
/*     */     
/*  93 */     Set<File> files = configuration.getFiles();
/*  94 */     if (files.isEmpty()) {
/*  95 */       graphItems = Collections.emptyList();
/*  96 */       libraries = Collections.emptyList();
/*  97 */       return;
/*     */     }
/*     */     
/* 100 */     graphItems = Lists.newArrayListWithCapacity(files.size());
/* 101 */     libraries = Lists.newArrayListWithCapacity(files.size());
/*     */     
/* 103 */     for (File file : files)
/*     */     {
/* 108 */       Library javaLib = new JavaLibraryImpl(ArtifactDependencyGraph.getMavenCoordForLocalFile(file).toString().intern(), file);
/*     */       
/* 110 */       libraries.add(javaLib);
/* 111 */       graphItems.add(new GraphItemImpl(javaLib.getArtifactAddress(), ImmutableList.of()));
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.ConfigurationDependencyGraphs
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */