/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.google.common.io.ByteStreams;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ 
/*     */ public class InstantRunVerifier$ClassBytesJarEntryProvider
/*     */   implements InstantRunVerifier.ClassBytesProvider
/*     */ {
/*     */   private final JarFile jarFile;
/*     */   private final JarEntry jarEntry;
/*     */   
/*     */   public InstantRunVerifier$ClassBytesJarEntryProvider(JarFile jarFile, JarEntry jarEntry)
/*     */   {
/* 120 */     this.jarFile = jarFile;
/* 121 */     this.jarEntry = jarEntry;
/*     */   }
/*     */   
/*     */   public byte[] load() throws IOException
/*     */   {
/* 126 */     InputStream is = jarFile.getInputStream(jarEntry);Throwable localThrowable3 = null;
/* 127 */     try { return ByteStreams.toByteArray(is);
/*     */     }
/*     */     catch (Throwable localThrowable4)
/*     */     {
/* 126 */       localThrowable3 = localThrowable4;throw localThrowable4;
/*     */     } finally {
/* 128 */       if (is != null) if (localThrowable3 != null) try { is.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else is.close();
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunVerifier.ClassBytesJarEntryProvider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */