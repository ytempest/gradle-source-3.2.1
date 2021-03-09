/*     */ package com.android.build.gradle.internal.pipeline;
/*     */ 
/*     */ import com.android.build.api.transform.JarInput;
/*     */ import com.android.build.api.transform.QualifiedContent;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.Status;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ abstract class IncrementalTransformInput
/*     */ {
/*  41 */   private final Map<File, QualifiedContent> jarInputs = Maps.newHashMap();
/*     */   
/*  47 */   private final List<MutableDirectoryInput> folderInputs = Lists.newArrayList();
/*     */   
/*  52 */   private final List<JarInput> convertedJarInputs = Lists.newArrayList();
/*     */   
/*     */   boolean checkForJar(File file, Status status)
/*     */   {
/*  66 */     if (jarInputs.containsKey(file)) {
/*  67 */       QualifiedContent jarContent = (QualifiedContent)jarInputs.get(file);
/*  68 */       addImmutableJar(new ImmutableJarInput(jarContent, status));
/*  69 */       jarInputs.remove(file);
/*  70 */       return true;
/*     */     }
/*     */     
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   boolean checkForFolder(File file, List<String> fileSegments, Status status)
/*     */   {
/*  89 */     for (MutableDirectoryInput folderInput : folderInputs) {
/*  90 */       if (folderInput.processForChangedFile(file, fileSegments, status)) {
/*  91 */         return true;
/*     */       }
/*     */     }
/*     */     
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   boolean checkRemovedFolderFile(Set<? super QualifiedContent.Scope> transformScopes, Set<QualifiedContent.ContentType> transformInputTypes, File file, List<String> fileSegments)
/*     */   {
/* 112 */     for (MutableDirectoryInput folderInput : folderInputs) {
/* 113 */       if (folderInput.processForChangedFile(file, fileSegments, Status.REMOVED)) {
/* 114 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 120 */     return checkRemovedFolder(transformScopes, transformInputTypes, file, fileSegments);
/*     */   }
/*     */   
/*     */   abstract boolean checkRemovedJarFile(Set<? super QualifiedContent.Scope> paramSet, Set<QualifiedContent.ContentType> paramSet1, File paramFile, List<String> paramList);
/*     */   
/*     */   protected abstract boolean checkRemovedFolder(Set<? super QualifiedContent.Scope> paramSet, Set<QualifiedContent.ContentType> paramSet1, File paramFile, List<String> paramList);
/*     */   
/*     */   void addJarInput(QualifiedContent jarInput)
/*     */   {
/* 157 */     jarInputs.put(jarInput.getFile(), jarInput);
/*     */   }
/*     */   
/*     */   protected void addImmutableJar(ImmutableJarInput jarInput) {
/* 161 */     convertedJarInputs.add(jarInput);
/*     */   }
/*     */   
/*     */   void addFolderInput(MutableDirectoryInput folderInput) {
/* 165 */     folderInputs.add(folderInput);
/*     */   }
/*     */   
/*     */   ImmutableTransformInput asImmutable()
/*     */   {
/* 171 */     List<JarInput> immutableJarInputs = Lists.newArrayListWithCapacity(jarInputs
/* 172 */       .size() + convertedJarInputs.size());
/* 173 */     immutableJarInputs.addAll(convertedJarInputs);
/*     */     
/* 175 */     for (Iterator localIterator = jarInputs.values().iterator(); localIterator.hasNext();) { jarContent = (QualifiedContent)localIterator.next();
/* 176 */       immutableJarInputs.add(new ImmutableJarInput(jarContent, Status.NOTCHANGED));
/*     */     }
/*     */     
/*     */     QualifiedContent jarContent;
/* 180 */     Object immutableDirectoryInputs = Lists.newArrayListWithCapacity(folderInputs
/* 181 */       .size());
/* 182 */     for (MutableDirectoryInput folderInput : folderInputs) {
/* 183 */       ((List)immutableDirectoryInputs).add(folderInput.asImmutable());
/*     */     }
/*     */     
/* 186 */     return new ImmutableTransformInput(immutableJarInputs, (Collection)immutableDirectoryInputs, null);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.IncrementalTransformInput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */