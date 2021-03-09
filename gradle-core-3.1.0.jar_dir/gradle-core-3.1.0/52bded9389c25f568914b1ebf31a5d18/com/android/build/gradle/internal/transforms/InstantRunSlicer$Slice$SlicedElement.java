/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.google.common.base.Strings;
/*     */ import java.io.File;
/*     */ 
/*     */ class InstantRunSlicer$Slice$SlicedElement
/*     */ {
/*     */   private final String packagePath;
/*     */   private final File slicedFile;
/*     */   
/*     */   private InstantRunSlicer$Slice$SlicedElement(String packagePath, File slicedFile)
/*     */   {
/* 294 */     this.packagePath = packagePath;
/* 295 */     this.slicedFile = slicedFile;
/*     */   }
/*     */   
/*     */   public int getHashBucket()
/*     */   {
/* 305 */     String hashTarget = Strings.isNullOrEmpty(packagePath) ? slicedFile.getName() : packagePath;
/*     */     
/* 307 */     return Math.abs(hashTarget.hashCode() % 10);
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 312 */     return packagePath + slicedFile.getName();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunSlicer.Slice.SlicedElement
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */