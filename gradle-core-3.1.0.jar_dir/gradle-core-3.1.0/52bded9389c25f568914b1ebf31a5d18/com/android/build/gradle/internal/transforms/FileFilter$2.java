/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import java.io.File;
/*     */ 
/*     */ class FileFilter$2
/*     */   implements FileFilter.FolderAction
/*     */ {
/*     */   FileFilter$2(FileFilter this$0, String paramString, ImmutableList.Builder paramBuilder) {}
/*     */   
/*     */   public File on(File folder)
/*     */   {
/* 248 */     File expandedFile = new File(folder, val$archivePath);
/* 249 */     if (expandedFile.exists()) {
/* 250 */       val$matchingFiles.add(expandedFile);
/*     */     }
/* 252 */     return null;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.FileFilter.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */