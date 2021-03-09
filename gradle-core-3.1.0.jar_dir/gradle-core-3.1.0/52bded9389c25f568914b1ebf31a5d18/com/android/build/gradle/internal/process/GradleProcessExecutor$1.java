/*    */ package com.android.build.gradle.internal.process;
/*    */ 
/*    */ import com.android.ide.common.process.ProcessInfo;
/*    */ import com.android.ide.common.process.ProcessOutputHandler;
/*    */ import com.android.ide.common.process.ProcessResult;
/*    */ import com.google.common.util.concurrent.SettableFuture;
/*    */ 
/*    */ class GradleProcessExecutor$1
/*    */   extends Thread
/*    */ {
/*    */   GradleProcessExecutor$1(GradleProcessExecutor this$0, ProcessInfo paramProcessInfo, ProcessOutputHandler paramProcessOutputHandler, SettableFuture paramSettableFuture) {}
/*    */   
/*    */   public void run()
/*    */   {
/*    */     try
/*    */     {
/* 57 */       ProcessResult result = this$0.execute(val$processInfo, val$processOutputHandler);
/* 58 */       val$res.set(result);
/*    */     } catch (Throwable e) {
/* 60 */       val$res.setException(e);
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.process.GradleProcessExecutor.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */