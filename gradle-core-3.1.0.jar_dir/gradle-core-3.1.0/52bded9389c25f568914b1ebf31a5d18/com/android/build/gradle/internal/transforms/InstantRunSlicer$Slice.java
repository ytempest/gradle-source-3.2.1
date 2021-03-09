/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.Format;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.TransformOutputProvider;
/*     */ import com.android.build.gradle.internal.pipeline.TransformManager;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ class InstantRunSlicer$Slice
/*     */ {
/*     */   private final String name;
/*     */   private final int hashBucket;
/*     */   private final List<SlicedElement> slicedElements;
/*     */   
/*     */   private static class SlicedElement
/*     */   {
/*     */     private final String packagePath;
/*     */     private final File slicedFile;
/*     */     
/*     */     private SlicedElement(String packagePath, File slicedFile)
/*     */     {
/* 294 */       this.packagePath = packagePath;
/* 295 */       this.slicedFile = slicedFile;
/*     */     }
/*     */     
/*     */     public int getHashBucket()
/*     */     {
/* 305 */       String hashTarget = Strings.isNullOrEmpty(packagePath) ? slicedFile.getName() : packagePath;
/*     */       
/* 307 */       return Math.abs(hashTarget.hashCode() % 10);
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/* 312 */       return packagePath + slicedFile.getName();
/*     */     }
/*     */   }
/*     */   
/*     */   private InstantRunSlicer$Slice(String name, int hashBucket)
/*     */   {
/* 322 */     this.name = name;
/* 323 */     this.hashBucket = hashBucket;
/* 324 */     slicedElements = new ArrayList();
/*     */   }
/*     */   
/*     */   private void add(SlicedElement slicedElement) {
/* 328 */     if (hashBucket != slicedElement.getHashBucket()) {
/* 329 */       throw new RuntimeException("Wrong bucket for " + slicedElement);
/*     */     }
/* 331 */     slicedElements.add(slicedElement);
/*     */   }
/*     */   
/*     */   private void writeTo(TransformOutputProvider outputProvider) throws IOException
/*     */   {
/* 336 */     File sliceOutputLocation = outputProvider.getContentLocation(name, TransformManager.CONTENT_CLASS, 
/*     */     
/* 338 */       Sets.immutableEnumSet(QualifiedContent.Scope.PROJECT, new QualifiedContent.Scope[] { QualifiedContent.Scope.SUB_PROJECTS }), Format.DIRECTORY);
/*     */     
/* 341 */     FileUtils.cleanOutputDir(sliceOutputLocation);
/*     */     
/* 345 */     InstantRunSlicer.access$900(name, sliceOutputLocation);
/*     */     
/* 348 */     for (SlicedElement slicedElement : slicedElements)
/*     */     {
/* 350 */       File outputFile = new File(sliceOutputLocation, new File(packagePath, slicedFile.getName()).getPath());
/* 351 */       Files.createParentDirs(outputFile);
/* 352 */       Files.copy(slicedFile, outputFile);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunSlicer.Slice
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */