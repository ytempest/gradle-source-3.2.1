/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import java.io.File;
/*     */ 
/*     */ class FileFilter$1
/*     */   implements FileFilter.FolderAction
/*     */ {
/*     */   FileFilter$1(FileFilter this$0, String paramString) {}
/*     */   
/*     */   public File on(File folder)
/*     */   {
/* 227 */     File expandedFile = new File(folder, val$archivePath);
/* 228 */     if (expandedFile.exists()) {
/* 229 */       return expandedFile;
/*     */     }
/* 231 */     return null;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.FileFilter.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */