/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.android.utils.ILogger;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.zip.ZipEntry;
/*     */ import org.objectweb.asm.ClassReader;
/*     */ import org.objectweb.asm.tree.ClassNode;
/*     */ 
/*     */ public class AsmUtils$JarBasedClassReader
/*     */   implements AsmUtils.ClassNodeProvider
/*     */ {
/*     */   private final File file;
/*     */   
/*     */   public AsmUtils$JarBasedClassReader(File file)
/*     */   {
/* 104 */     this.file = file;
/*     */   }
/*     */   
/*     */   public ClassNode loadClassNode(String className, ILogger logger)
/*     */     throws IOException
/*     */   {
/* 111 */     JarFile jarFile = new JarFile(file);Throwable localThrowable7 = null;
/* 112 */     try { ZipEntry entry = jarFile.getEntry(className.replace(".", "/") + ".class");
/* 113 */       if (entry != null) {
/* 114 */         InputStream is = jarFile.getInputStream(entry);Throwable localThrowable8 = null;
/* 115 */         try { return AsmUtils.readClass(new ClassReader(is));
/*     */         }
/*     */         catch (Throwable localThrowable9)
/*     */         {
/* 114 */           localThrowable8 = localThrowable9;throw localThrowable9;
/*     */         }
/*     */         finally {}
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable5)
/*     */     {
/* 111 */       localThrowable7 = localThrowable5;throw localThrowable5;
/*     */     }
/*     */     finally
/*     */     {
/* 118 */       if (jarFile != null) if (localThrowable7 != null) try { jarFile.close(); } catch (Throwable localThrowable6) { localThrowable7.addSuppressed(localThrowable6); } else jarFile.close(); }
/* 119 */     return null;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.AsmUtils.JarBasedClassReader
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */