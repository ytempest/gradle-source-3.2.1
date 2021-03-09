/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.io.ByteSource;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.UncheckedIOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.jacoco.core.instr.Instrumenter;
/*     */ import org.jacoco.core.runtime.OfflineInstrumentationAccessGenerator;
/*     */ 
/*     */ class JacocoTransform$JacocoWorkerAction
/*     */   implements Runnable
/*     */ {
/*     */   private Map<JacocoTransform.Action, List<File>> inputs;
/*     */   private File inputDir;
/*     */   private File outputDir;
/*     */   
/*     */   @Inject
/*     */   public JacocoTransform$JacocoWorkerAction(Map<JacocoTransform.Action, List<File>> inputs, File inputDir, File outputDir)
/*     */   {
/* 271 */     this.inputs = inputs;
/* 272 */     this.inputDir = inputDir;
/* 273 */     this.outputDir = outputDir;
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/* 278 */     Instrumenter instrumenter = new Instrumenter(new OfflineInstrumentationAccessGenerator());
/*     */     
/* 280 */     for (File toInstrument : (List)inputs.getOrDefault(JacocoTransform.Action.INSTRUMENT, ImmutableList.of())) {
/*     */       try {
/* 282 */         InputStream inputStream = Files.asByteSource(toInstrument).openBufferedStream();Throwable localThrowable3 = null;
/*     */         try {
/* 284 */           byte[] instrumented = instrumenter.instrument(inputStream, toInstrument.toString());
/*     */           
/* 286 */           File outputFile = new File(outputDir, FileUtils.relativePath(toInstrument, inputDir));
/* 287 */           Files.createParentDirs(outputFile);
/* 288 */           Files.write(instrumented, outputFile);
/*     */         }
/*     */         catch (Throwable localThrowable1)
/*     */         {
/* 281 */           localThrowable3 = localThrowable1;throw localThrowable1;
/*     */         }
/*     */         finally
/*     */         {
/* 289 */           if (inputStream != null) if (localThrowable3 != null) try { inputStream.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else inputStream.close();
/* 290 */         } } catch (IOException e) { throw new UncheckedIOException("Unable to instrument file with Jacoco: " + toInstrument, e);
/*     */       }
/*     */     }
/*     */     
/* 295 */     for (File toCopy : (List)inputs.getOrDefault(JacocoTransform.Action.COPY, ImmutableList.of())) {
/* 296 */       File outputFile = new File(outputDir, FileUtils.relativePath(toCopy, inputDir));
/*     */       try {
/* 298 */         Files.createParentDirs(outputFile);
/* 299 */         Files.copy(toCopy, outputFile);
/*     */       } catch (IOException e) {
/* 301 */         throw new UncheckedIOException("Unable to copy file: " + toCopy, e);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.JacocoTransform.JacocoWorkerAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */