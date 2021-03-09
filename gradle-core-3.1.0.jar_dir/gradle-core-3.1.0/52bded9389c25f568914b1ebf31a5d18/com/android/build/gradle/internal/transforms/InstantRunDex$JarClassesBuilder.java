/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.jar.JarOutputStream;
/*     */ 
/*     */ class InstantRunDex$JarClassesBuilder
/*     */   implements Closeable
/*     */ {
/*     */   final File outputFile;
/*     */   private JarOutputStream jarOutputStream;
/* 180 */   boolean empty = true;
/*     */   
/*     */   private InstantRunDex$JarClassesBuilder(File outputFile) {
/* 183 */     this.outputFile = outputFile;
/*     */   }
/*     */   
/*     */   void add(File inputDir, File file) throws IOException {
/* 187 */     if (jarOutputStream == null) {
/* 188 */       jarOutputStream = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile)));
/*     */     }
/*     */     
/* 191 */     empty = false;
/* 192 */     InstantRunDex.access$000(inputDir, file, jarOutputStream);
/*     */   }
/*     */   
/*     */   public void close() throws IOException
/*     */   {
/* 197 */     if (jarOutputStream != null) {
/* 198 */       jarOutputStream.close();
/*     */     }
/*     */   }
/*     */   
/*     */   boolean isEmpty() {
/* 203 */     return empty;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunDex.JarClassesBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */