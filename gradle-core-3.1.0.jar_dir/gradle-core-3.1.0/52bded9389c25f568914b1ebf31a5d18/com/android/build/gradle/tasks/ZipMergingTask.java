/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Set;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.CacheableTask;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.PathSensitive;
/*     */ import org.gradle.api.tasks.PathSensitivity;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ @CacheableTask
/*     */ public class ZipMergingTask
/*     */   extends AndroidVariantTask
/*     */ {
/*     */   private FileCollection inputFiles;
/*     */   private File outputFile;
/*     */   
/*     */   void init(FileCollection inputFiles, File outputFile)
/*     */   {
/*  52 */     this.inputFiles = inputFiles;
/*  53 */     this.outputFile = outputFile;
/*     */   }
/*     */   
/*     */   @InputFiles
/*     */   @PathSensitive(PathSensitivity.NONE)
/*     */   public FileCollection getInputFiles() {
/*  59 */     return inputFiles;
/*     */   }
/*     */   
/*     */   @TaskAction
/*     */   public void merge() throws IOException {
/*  64 */     byte[] buffer = new byte[' '];
/*  65 */     FileOutputStream fos = new FileOutputStream(outputFile);Throwable localThrowable15 = null;
/*  66 */     try { BufferedOutputStream bos = new BufferedOutputStream(fos);Throwable localThrowable16 = null;
/*  67 */       try { ZipOutputStream zos = new ZipOutputStream(bos);Throwable localThrowable17 = null;
/*     */         try {
/*  69 */           entries = Sets.newHashSet();
/*     */           
/*  71 */           for (File inputFile : inputFiles) {
/*  72 */             FileInputStream fis = new FileInputStream(inputFile);Throwable localThrowable18 = null;
/*  73 */             try { ZipInputStream zis = new ZipInputStream(fis);Throwable localThrowable19 = null;
/*     */               try {
/*     */                 ZipEntry entry;
/*  76 */                 while ((entry = zis.getNextEntry()) != null) {
/*  77 */                   if (!entry.isDirectory())
/*     */                   {
/*  81 */                     String entryName = entry.getName();
/*  82 */                     if (!entries.contains(entryName))
/*     */                     {
/*  88 */                       entries.add(entryName);
/*     */                       
/*  91 */                       zos.putNextEntry(entry);
/*     */                       
/*     */                       int count;
/*     */                       
/*  96 */                       while ((count = zis.read(buffer)) != -1) {
/*  97 */                         zos.write(buffer, 0, count);
/*     */                       }
/*     */                       
/* 101 */                       zos.closeEntry();
/* 102 */                       zis.closeEntry();
/*     */                     }
/*     */                   }
/*     */                 }
/*     */               }
/*     */               catch (Throwable localThrowable1)
/*     */               {
/*  72 */                 localThrowable19 = localThrowable1;throw localThrowable1; } finally {} } catch (Throwable localThrowable4) { localThrowable18 = localThrowable4;throw localThrowable4;
/*     */             }
/*     */             finally {}
/*     */           }
/*     */         }
/*     */         catch (Throwable localThrowable7)
/*     */         {
/*     */           Set<String> entries;
/*  65 */           localThrowable17 = localThrowable7;throw localThrowable7; } finally {} } catch (Throwable localThrowable10) { localThrowable16 = localThrowable10;throw localThrowable10; } finally {} } catch (Throwable localThrowable13) { localThrowable15 = localThrowable13;throw localThrowable13;
/*     */     }
/*     */     finally
/*     */     {
/* 106 */       if (fos != null) if (localThrowable15 != null) try { fos.close(); } catch (Throwable localThrowable14) { localThrowable15.addSuppressed(localThrowable14); } else fos.close();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ConfigAction implements TaskConfigAction<ZipMergingTask>
/*     */   {
/*     */     private VariantScope scope;
/*     */     private File outputFile;
/*     */     
/*     */     public ConfigAction(VariantScope scope, File outputFile) {
/* 116 */       this.scope = scope;
/* 117 */       this.outputFile = outputFile;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 123 */       return scope.getTaskName("createFullJar");
/*     */     }
/*     */     
/*     */     public Class<ZipMergingTask> getType()
/*     */     {
/* 129 */       return ZipMergingTask.class;
/*     */     }
/*     */     
/*     */     public void execute(ZipMergingTask task)
/*     */     {
/* 134 */       task.init(scope
/* 135 */         .getOutput(TaskOutputHolder.TaskOutputType.LIBRARY_CLASSES)
/* 136 */         .plus(scope.getOutput(TaskOutputHolder.TaskOutputType.LIBRARY_JAVA_RES)), outputFile);
/*     */       
/* 138 */       task.setVariantName(scope.getFullVariantName());
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ZipMergingTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */