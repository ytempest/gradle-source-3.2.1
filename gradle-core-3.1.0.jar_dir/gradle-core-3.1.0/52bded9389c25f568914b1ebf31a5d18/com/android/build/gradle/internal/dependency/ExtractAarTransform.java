/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.io.ByteStreams;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.List;
/*     */ import java.util.jar.JarOutputStream;
/*     */ import java.util.jar.Manifest;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.artifacts.transform.ArtifactTransform;
/*     */ 
/*     */ public class ExtractAarTransform
/*     */   extends ArtifactTransform
/*     */ {
/*     */   private static final String LIBS_PREFIX = "libs/";
/*  49 */   private static final int LIBS_PREFIX_LENGTH = "libs/".length();
/*  50 */   private static final int JARS_PREFIX_LENGTH = "jars".length() + 1;
/*     */   
/*     */   public List<File> transform(File input)
/*     */   {
/*  57 */     File outputDir = getOutputDirectory();
/*     */     
/*  59 */     FileUtils.mkdirs(outputDir);
/*     */     
/*  61 */     StringBuilder sb = new StringBuilder(20);
/*  62 */     sb.append("jars").append(File.separatorChar);
/*     */     try {
/*  64 */       InputStream fis = new BufferedInputStream(new FileInputStream(input));Throwable localThrowable10 = null;
/*  65 */       try { ZipInputStream zis = new ZipInputStream(fis);Throwable localThrowable11 = null;
/*     */         try {
/*     */           ZipEntry entry;
/*  68 */           while ((entry = zis.getNextEntry()) != null) {
/*     */             try {
/*  70 */               String name = entry.getName();
/*     */               
/*  73 */               if (entry.isDirectory())
/*     */               {
/* 111 */                 zis.closeEntry();
/*     */               }
/*     */               else
/*     */               {
/*  77 */                 String path = name;
/*     */                 
/*  80 */                 if ((path.equals("classes.jar")) || (path.equals("lint.jar"))) {
/*  81 */                   sb.setLength(JARS_PREFIX_LENGTH);
/*  82 */                   sb.append(path);
/*  83 */                   path = sb.toString();
/*     */                 }
/*  85 */                 else if (path.startsWith("libs/")) {
/*  86 */                   sb.setLength(JARS_PREFIX_LENGTH);
/*     */                   
/*  91 */                   String path2 = path.substring(LIBS_PREFIX_LENGTH);
/*  92 */                   if ("classes.jar".equals(path2)) {
/*  93 */                     sb.append("libs/").append("classes-2.jar");
/*  94 */                   } else if ("lint.jar".equals(path2)) {
/*  95 */                     sb.append("libs/").append("lint-2.jar");
/*     */                   } else {
/*  97 */                     sb.append("libs/").append(path2);
/*     */                   }
/*  99 */                   path = sb.toString();
/*     */                 }
/*     */                 
/* 102 */                 File outputFile = new File(outputDir, path.replace('/', File.separatorChar));
/* 103 */                 FileUtils.mkdirs(outputFile.getParentFile());
/*     */                 
/* 105 */                 OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile));Throwable localThrowable12 = null;
/*     */                 try {
/* 107 */                   ByteStreams.copy(zis, outputStream);
/*     */                 }
/*     */                 catch (Throwable localThrowable2)
/*     */                 {
/* 105 */                   localThrowable12 = localThrowable2;throw localThrowable2;
/*     */                 }
/*     */                 finally
/*     */                 {
/* 109 */                   if (outputStream != null) if (localThrowable12 != null) try {}catch (Throwable localThrowable3) { localThrowable12.addSuppressed(localThrowable3);
/*     */                       }
/* 111 */                 } } } finally { zis.closeEntry();
/*     */             }
/*     */           }
/*     */         }
/*     */         catch (Throwable localThrowable5)
/*     */         {
/*  64 */           localThrowable11 = localThrowable5;throw localThrowable5; } finally {} } catch (Throwable localThrowable8) { localThrowable10 = localThrowable8;throw localThrowable8;
/*     */       }
/*     */       finally
/*     */       {
/* 115 */         if (fis != null) if (localThrowable10 != null) try { fis.close(); } catch (Throwable localThrowable9) { localThrowable10.addSuppressed(localThrowable9); } else fis.close();
/* 116 */       } } catch (Throwable t) { throw new RuntimeException(t);
/*     */     }
/*     */     
/* 120 */     File classesJar = new File(new File(outputDir, "jars"), "classes.jar");
/* 121 */     if (!classesJar.exists()) {
/*     */       try {
/* 123 */         Files.createParentDirs(classesJar);
/* 124 */         JarOutputStream jarOutputStream = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(classesJar)), new Manifest());
/*     */         
/* 128 */         jarOutputStream.close();
/*     */       } catch (IOException e) {
/* 130 */         throw new RuntimeException("Cannot create missing classes.jar", e);
/*     */       }
/*     */     }
/*     */     
/* 134 */     return ImmutableList.of(outputDir);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.ExtractAarTransform
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */