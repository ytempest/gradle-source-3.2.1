/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.ide.common.process.ProcessOutput;
/*     */ import com.android.utils.ILogger;
/*     */ import com.google.common.io.FileBackedOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ class ExternalNativeBuildTaskUtils$ProgressiveLoggingProcessOutputHandler$ProgressiveLoggingProcessOutput
/*     */   implements ProcessOutput
/*     */ {
/*     */   private final ProgressiveLoggingOutputStream outputStream;
/*     */   private final ProgressiveLoggingOutputStream errorStream;
/*     */   
/*     */   ExternalNativeBuildTaskUtils$ProgressiveLoggingProcessOutputHandler$ProgressiveLoggingProcessOutput(ExternalNativeBuildTaskUtils.ProgressiveLoggingProcessOutputHandler paramProgressiveLoggingProcessOutputHandler)
/*     */   {
/* 490 */     outputStream = new ProgressiveLoggingOutputStream(ExternalNativeBuildTaskUtils.ProgressiveLoggingProcessOutputHandler.access$100(paramProgressiveLoggingProcessOutputHandler), ExternalNativeBuildTaskUtils.ProgressiveLoggingProcessOutputHandler.access$200(paramProgressiveLoggingProcessOutputHandler));
/* 491 */     errorStream = new ProgressiveLoggingOutputStream(true, null);
/*     */   }
/*     */   
/*     */   public ProgressiveLoggingOutputStream getStandardOutput()
/*     */   {
/* 497 */     return outputStream;
/*     */   }
/*     */   
/*     */   public ProgressiveLoggingOutputStream getErrorOutput()
/*     */   {
/* 503 */     return errorStream;
/*     */   }
/*     */   
/*     */   public void close() throws IOException
/*     */   {}
/*     */   
/*     */   private class ProgressiveLoggingOutputStream extends OutputStream {
/*     */     private static final int INITIAL_BUFFER_SIZE = 256;
/*     */     private final boolean logToInfo;
/*     */     private final FileBackedOutputStream individualOutput;
/* 513 */     byte[] buffer = new byte['Ā'];
/*     */     
/* 515 */     int nextByteIndex = 0;
/*     */     
/*     */     ProgressiveLoggingOutputStream(boolean logToInfo, FileBackedOutputStream individualOutput)
/*     */     {
/* 519 */       this.logToInfo = logToInfo;
/* 520 */       this.individualOutput = individualOutput;
/*     */     }
/*     */     
/*     */     public void write(int b) throws IOException
/*     */     {
/* 525 */       ExternalNativeBuildTaskUtils.ProgressiveLoggingProcessOutputHandler.access$300(this$0).write(b);
/* 526 */       if (individualOutput != null) {
/* 527 */         individualOutput.write(b);
/*     */       }
/*     */       
/* 530 */       if ((b == 10) || (b == 13)) {
/* 531 */         printBuffer();
/*     */       } else {
/* 533 */         writeBuffer(b);
/*     */       }
/*     */     }
/*     */     
/*     */     private void writeBuffer(int b) {
/* 538 */       if (nextByteIndex == buffer.length) {
/* 539 */         buffer = Arrays.copyOf(buffer, buffer.length * 2);
/*     */       }
/* 541 */       buffer[nextByteIndex] = ((byte)b);
/* 542 */       nextByteIndex += 1;
/*     */     }
/*     */     
/*     */     private void printBuffer() throws UnsupportedEncodingException {
/* 546 */       if (nextByteIndex == 0) {
/* 547 */         return;
/*     */       }
/* 549 */       if (logToInfo) {
/* 550 */         String line = new String(buffer, 0, nextByteIndex, "UTF-8");
/* 551 */         ExternalNativeBuildTaskUtils.ProgressiveLoggingProcessOutputHandler.access$400(this$0).info(line, new Object[0]);
/*     */       }
/* 553 */       nextByteIndex = 0;
/*     */     }
/*     */     
/*     */     public void close() throws IOException
/*     */     {
/* 558 */       printBuffer();
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ExternalNativeBuildTaskUtils.ProgressiveLoggingProcessOutputHandler.ProgressiveLoggingProcessOutput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */