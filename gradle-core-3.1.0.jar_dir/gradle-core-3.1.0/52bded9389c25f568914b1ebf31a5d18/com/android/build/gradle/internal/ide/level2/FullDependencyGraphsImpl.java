/*     */ package com.android.build.gradle.internal.ide.level2;
/*     */ 
/*     */ import com.android.builder.model.level2.DependencyGraphs;
/*     */ import com.android.builder.model.level2.GraphItem;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ 
/*     */ public class FullDependencyGraphsImpl
/*     */   implements DependencyGraphs, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final List<GraphItem> compileItems;
/*     */   private final List<GraphItem> packageItems;
/*     */   private final List<String> providedLibraries;
/*     */   private final List<String> skippedLibraries;
/*     */   private final int hashCode;
/*     */   
/*     */   public FullDependencyGraphsImpl(List<GraphItem> compileItems, List<GraphItem> packageItems, List<String> providedLibraries, List<String> skippedLibraries)
/*     */   {
/*  44 */     this.compileItems = compileItems;
/*  45 */     this.packageItems = packageItems;
/*  46 */     this.providedLibraries = ImmutableList.copyOf(providedLibraries);
/*  47 */     this.skippedLibraries = ImmutableList.copyOf(skippedLibraries);
/*  48 */     hashCode = computeHashCode();
/*     */   }
/*     */   
/*     */   public List<GraphItem> getCompileDependencies()
/*     */   {
/*  54 */     return compileItems;
/*     */   }
/*     */   
/*     */   public List<GraphItem> getPackageDependencies()
/*     */   {
/*  60 */     return packageItems;
/*     */   }
/*     */   
/*     */   public List<String> getProvidedLibraries()
/*     */   {
/*  66 */     return providedLibraries;
/*     */   }
/*     */   
/*     */   public List<String> getSkippedLibraries()
/*     */   {
/*  72 */     return skippedLibraries;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/*  78 */     if (this == o) {
/*  79 */       return true;
/*     */     }
/*  81 */     if ((o == null) || (getClass() != o.getClass())) {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     FullDependencyGraphsImpl that = (FullDependencyGraphsImpl)o;
/*     */     
/*  87 */     if (!compileItems.equals(compileItems)) {
/*  88 */       return false;
/*     */     }
/*  90 */     if (!packageItems.equals(packageItems)) {
/*  91 */       return false;
/*     */     }
/*  93 */     if (!providedLibraries.equals(providedLibraries)) {
/*  94 */       return false;
/*     */     }
/*  96 */     return skippedLibraries.equals(skippedLibraries);
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 102 */     return hashCode;
/*     */   }
/*     */   
/*     */   private int computeHashCode() {
/* 106 */     int result = compileItems.hashCode();
/* 107 */     result = 31 * result + packageItems.hashCode();
/* 108 */     result = 31 * result + providedLibraries.hashCode();
/* 109 */     result = 31 * result + skippedLibraries.hashCode();
/* 110 */     return result;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.level2.FullDependencyGraphsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */