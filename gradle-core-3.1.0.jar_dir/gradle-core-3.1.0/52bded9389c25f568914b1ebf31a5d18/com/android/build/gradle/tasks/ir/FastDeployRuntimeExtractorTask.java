/*     */ package com.android.build.gradle.tasks.ir;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.InstantRunVariantScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TransformVariantScope;
/*     */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*     */ import com.google.common.io.ByteStreams;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.util.jar.JarInputStream;
/*     */ import java.util.jar.JarOutputStream;
/*     */ import java.util.zip.ZipEntry;
/*     */ import org.gradle.api.tasks.OutputFile;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class FastDeployRuntimeExtractorTask
/*     */   extends AndroidVariantTask
/*     */ {
/*     */   private File outputFile;
/*     */   
/*     */   @OutputFile
/*     */   public File getOutputFile()
/*     */   {
/*  48 */     return outputFile;
/*     */   }
/*     */   
/*     */   public void setOutputFile(File file) {
/*  52 */     outputFile = file;
/*     */   }
/*     */   
/*     */   @TaskAction
/*     */   public void extract()
/*     */     throws IOException
/*     */   {
/*  61 */     URL fdrJar = FastDeployRuntimeExtractorTask.class.getResource("/instant-run/instant-run-server.jar");
/*     */     
/*  63 */     if (fdrJar == null) {
/*  64 */       throw new RuntimeException("Couldn't find Instant-Run runtime library");
/*     */     }
/*  66 */     URLConnection urlConnection = fdrJar.openConnection();
/*  67 */     urlConnection.setUseCaches(false);
/*  68 */     Files.createParentDirs(getOutputFile());
/*     */     
/*  70 */     InputStream inputStream = urlConnection.getInputStream();Throwable localThrowable9 = null;
/*  71 */     try { JarInputStream jarInputStream = new JarInputStream(inputStream);Throwable localThrowable10 = null;
/*     */       try {
/*  73 */         JarOutputStream jarOutputStream = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(getOutputFile())));Throwable localThrowable11 = null;
/*  74 */         try { ZipEntry entry = jarInputStream.getNextEntry();
/*  75 */           while (entry != null) {
/*  76 */             String name = entry.getName();
/*     */             
/*  78 */             if (isValidForPackaging(name)) {
/*  79 */               ZipEntry copy = new ZipEntry(entry);
/*  80 */               jarOutputStream.putNextEntry(copy);
/*  81 */               ByteStreams.copy(jarInputStream, jarOutputStream);
/*  82 */               jarOutputStream.closeEntry();
/*     */             }
/*  84 */             entry = jarInputStream.getNextEntry();
/*     */           }
/*     */         }
/*     */         catch (Throwable localThrowable1)
/*     */         {
/*  70 */           localThrowable11 = localThrowable1;throw localThrowable1; } finally {} } catch (Throwable localThrowable4) { localThrowable10 = localThrowable4;throw localThrowable4; } finally {} } catch (Throwable localThrowable7) { localThrowable9 = localThrowable7;throw localThrowable7;
/*     */     }
/*     */     finally
/*     */     {
/*  86 */       if (inputStream != null) { if (localThrowable9 != null) try { inputStream.close(); } catch (Throwable localThrowable8) { localThrowable9.addSuppressed(localThrowable8); } else { inputStream.close();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean isValidForPackaging(String name)
/*     */   {
/*  97 */     return (!name.startsWith("META-INF")) && (!name.endsWith("AppInfo.class"));
/*     */   }
/*     */   
/*     */   public static class ConfigAction implements TaskConfigAction<FastDeployRuntimeExtractorTask>
/*     */   {
/*     */     private final InstantRunVariantScope instantRunVariantScope;
/*     */     
/*     */     public ConfigAction(InstantRunVariantScope instantRunVariantScope)
/*     */     {
/* 106 */       this.instantRunVariantScope = instantRunVariantScope;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 112 */       return instantRunVariantScope.getTransformVariantScope().getTaskName("fastDeploy", "Extractor");
/*     */     }
/*     */     
/*     */     public Class<FastDeployRuntimeExtractorTask> getType()
/*     */     {
/* 119 */       return FastDeployRuntimeExtractorTask.class;
/*     */     }
/*     */     
/*     */     public void execute(FastDeployRuntimeExtractorTask fastDeployRuntimeExtractorTask)
/*     */     {
/* 124 */       fastDeployRuntimeExtractorTask.setVariantName(instantRunVariantScope
/* 125 */         .getFullVariantName());
/* 126 */       fastDeployRuntimeExtractorTask.setOutputFile(instantRunVariantScope
/* 127 */         .getIncrementalRuntimeSupportJar());
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ir.FastDeployRuntimeExtractorTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */