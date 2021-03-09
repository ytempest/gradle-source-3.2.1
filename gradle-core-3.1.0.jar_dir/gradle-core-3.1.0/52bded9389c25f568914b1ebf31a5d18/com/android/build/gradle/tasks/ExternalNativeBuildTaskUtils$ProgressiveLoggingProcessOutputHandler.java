/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.ide.common.process.ProcessException;
/*     */ import com.android.ide.common.process.ProcessOutput;
/*     */ import com.android.ide.common.process.ProcessOutputHandler;
/*     */ import com.android.utils.ILogger;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.io.ByteSource;
/*     */ import com.google.common.io.CharSource;
/*     */ import com.google.common.io.FileBackedOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ class ExternalNativeBuildTaskUtils$ProgressiveLoggingProcessOutputHandler
/*     */   implements ProcessOutputHandler
/*     */ {
/*     */   private final ILogger logger;
/*     */   private final FileBackedOutputStream standardOutput;
/*     */   private final FileBackedOutputStream combinedOutput;
/*     */   private final ProgressiveLoggingProcessOutput loggingProcessOutput;
/*     */   private final boolean logStdioToInfo;
/*     */   
/*     */   public ExternalNativeBuildTaskUtils$ProgressiveLoggingProcessOutputHandler(ILogger logger, boolean logStdioToInfo)
/*     */   {
/* 455 */     this.logger = logger;
/* 456 */     this.logStdioToInfo = logStdioToInfo;
/* 457 */     standardOutput = new FileBackedOutputStream(2048);
/* 458 */     combinedOutput = new FileBackedOutputStream(2048);
/* 459 */     loggingProcessOutput = new ProgressiveLoggingProcessOutput();
/*     */   }
/*     */   
/*     */   String getStandardOutputString() throws IOException
/*     */   {
/* 464 */     return standardOutput.asByteSource().asCharSource(Charsets.UTF_8).read();
/*     */   }
/*     */   
/*     */   String getCombinedOutputString() throws IOException
/*     */   {
/* 469 */     return combinedOutput.asByteSource().asCharSource(Charsets.UTF_8).read();
/*     */   }
/*     */   
/*     */   public ProcessOutput createOutput()
/*     */   {
/* 475 */     return loggingProcessOutput;
/*     */   }
/*     */   
/*     */   public void handleOutput(ProcessOutput processOutput)
/*     */     throws ProcessException
/*     */   {}
/*     */   
/*     */   private class ProgressiveLoggingProcessOutput
/*     */     implements ProcessOutput
/*     */   {
/*     */     private final ProgressiveLoggingOutputStream outputStream;
/*     */     private final ProgressiveLoggingOutputStream errorStream;
/*     */     
/*     */     ProgressiveLoggingProcessOutput()
/*     */     {
/* 490 */       outputStream = new ProgressiveLoggingOutputStream(logStdioToInfo, standardOutput);
/* 491 */       errorStream = new ProgressiveLoggingOutputStream(true, null);
/*     */     }
/*     */     
/*     */     public ProgressiveLoggingOutputStream getStandardOutput()
/*     */     {
/* 497 */       return outputStream;
/*     */     }
/*     */     
/*     */     public ProgressiveLoggingOutputStream getErrorOutput()
/*     */     {
/* 503 */       return errorStream;
/*     */     }
/*     */     
/*     */     public void close() throws IOException
/*     */     {}
/*     */     
/*     */     private class ProgressiveLoggingOutputStream extends OutputStream {
/*     */       private static final int INITIAL_BUFFER_SIZE = 256;
/*     */       private final boolean logToInfo;
/*     */       private final FileBackedOutputStream individualOutput;
/* 513 */       byte[] buffer = new byte['Ā'];
/*     */       
/* 515 */       int nextByteIndex = 0;
/*     */       
/*     */       ProgressiveLoggingOutputStream(boolean logToInfo, FileBackedOutputStream individualOutput)
/*     */       {
/* 519 */         this.logToInfo = logToInfo;
/* 520 */         this.individualOutput = individualOutput;
/*     */       }
/*     */       
/*     */       public void write(int b) throws IOException
/*     */       {
/* 525 */         combinedOutput.write(b);
/* 526 */         if (individualOutput != null) {
/* 527 */           individualOutput.write(b);
/*     */         }
/*     */         
/* 530 */         if ((b == 10) || (b == 13)) {
/* 531 */           printBuffer();
/*     */         } else {
/* 533 */           writeBuffer(b);
/*     */         }
/*     */       }
/*     */       
/*     */       private void writeBuffer(int b) {
/* 538 */         if (nextByteIndex == buffer.length) {
/* 539 */           buffer = Arrays.copyOf(buffer, buffer.length * 2);
/*     */         }
/* 541 */         buffer[nextByteIndex] = ((byte)b);
/* 542 */         nextByteIndex += 1;
/*     */       }
/*     */       
/*     */       private void printBuffer() throws UnsupportedEncodingException {
/* 546 */         if (nextByteIndex == 0) {
/* 547 */           return;
/*     */         }
/* 549 */         if (logToInfo) {
/* 550 */           String line = new String(buffer, 0, nextByteIndex, "UTF-8");
/* 551 */           logger.info(line, new Object[0]);
/*     */         }
/* 553 */         nextByteIndex = 0;
/*     */       }
/*     */       
/*     */       public void close() throws IOException
/*     */       {
/* 558 */         printBuffer();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ExternalNativeBuildTaskUtils.ProgressiveLoggingProcessOutputHandler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */