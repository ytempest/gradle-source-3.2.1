/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class InstantRunVerifier$ClassBytesFileProvider
/*     */   implements InstantRunVerifier.ClassBytesProvider
/*     */ {
/*     */   private final File file;
/*     */   
/*     */   public InstantRunVerifier$ClassBytesFileProvider(File file)
/*     */   {
/* 100 */     this.file = file;
/*     */   }
/*     */   
/*     */   public byte[] load() throws IOException
/*     */   {
/* 105 */     return Files.toByteArray(file);
/*     */   }
/*     */   
/*     */   public File getFile()
/*     */   {
/* 110 */     return file;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunVerifier.ClassBytesFileProvider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */