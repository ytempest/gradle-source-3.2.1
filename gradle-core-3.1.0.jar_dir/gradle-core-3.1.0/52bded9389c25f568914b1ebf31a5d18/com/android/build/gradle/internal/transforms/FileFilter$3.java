/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import java.io.File;
/*     */ 
/*     */ class FileFilter$3
/*     */   implements FileFilter.FolderAction
/*     */ {
/*     */   FileFilter$3(FileFilter this$0, File paramFile) {}
/*     */   
/*     */   public File on(File folder)
/*     */   {
/* 303 */     return val$expandedFile.getAbsolutePath().startsWith(folder.getAbsolutePath()) ? folder : null;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.FileFilter.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */