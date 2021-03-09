/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import java.io.File;
/*     */ 
/*     */ public class InstantRunSplitApkBuilder$DexFiles
/*     */ {
/*     */   private final ImmutableSet<File> dexFiles;
/*     */   private final String dexFolderName;
/*     */   
/*     */   protected InstantRunSplitApkBuilder$DexFiles(File[] dexFiles, String dexFolderName)
/*     */   {
/* 182 */     this(ImmutableSet.copyOf(dexFiles), dexFolderName);
/*     */   }
/*     */   
/*     */   protected InstantRunSplitApkBuilder$DexFiles(ImmutableSet<File> dexFiles, String dexFolderName) {
/* 186 */     this.dexFiles = dexFiles;
/* 187 */     this.dexFolderName = dexFolderName;
/*     */   }
/*     */   
/*     */   protected String encodeName() {
/* 191 */     return dexFolderName.replace('-', '_');
/*     */   }
/*     */   
/*     */   protected ImmutableSet<File> getDexFiles() {
/* 195 */     return dexFiles;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunSplitApkBuilder.DexFiles
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */