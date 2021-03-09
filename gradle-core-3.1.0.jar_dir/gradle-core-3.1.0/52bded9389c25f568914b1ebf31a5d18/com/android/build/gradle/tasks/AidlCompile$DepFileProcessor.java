/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.builder.compiling.DependencyFileProcessor;
/*     */ import com.android.builder.internal.incremental.DependencyData;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ class AidlCompile$DepFileProcessor
/*     */   implements DependencyFileProcessor
/*     */ {
/*  97 */   List<DependencyData> dependencyDataList = Collections.synchronizedList(Lists.newArrayList());
/*     */   
/*     */   List<DependencyData> getDependencyDataList() {
/* 100 */     return dependencyDataList;
/*     */   }
/*     */   
/*     */   public DependencyData processFile(File dependencyFile) throws IOException
/*     */   {
/* 105 */     DependencyData data = DependencyData.parseDependencyFile(dependencyFile);
/* 106 */     if (data != null) {
/* 107 */       dependencyDataList.add(data);
/*     */     }
/*     */     
/* 110 */     return data;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.AidlCompile.DepFileProcessor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */