/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.Set;
/*     */ 
/*     */ final class IncrementalShrinker$Changes<T>
/*     */ {
/*     */   final Set<T> classesToWrite;
/*     */   final Set<File> classFilesToDelete;
/*     */   
/*     */   private IncrementalShrinker$Changes(Set<T> classesToWrite, Set<File> classFilesToDelete)
/*     */   {
/* 393 */     this.classesToWrite = classesToWrite;
/* 394 */     this.classFilesToDelete = classFilesToDelete;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.IncrementalShrinker.Changes
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */