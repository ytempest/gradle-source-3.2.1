/*    */ package com.android.build.gradle.internal.process;
/*    */ 
/*    */ import com.android.ide.common.process.ProcessException;
/*    */ import com.android.ide.common.process.ProcessResult;
/*    */ 
/*    */ public class OutputHandlerFailedGradleProcessResult
/*    */   implements ProcessResult
/*    */ {
/*    */   private final ProcessException failure;
/*    */   
/*    */   OutputHandlerFailedGradleProcessResult(ProcessException failure)
/*    */   {
/* 28 */     this.failure = failure;
/*    */   }
/*    */   
/*    */   public ProcessResult assertNormalExitValue()
/*    */     throws ProcessException
/*    */   {
/* 34 */     throw failure;
/*    */   }
/*    */   
/*    */   public int getExitValue()
/*    */   {
/* 39 */     return -1;
/*    */   }
/*    */   
/*    */   public ProcessResult rethrowFailure()
/*    */     throws ProcessException
/*    */   {
/* 45 */     throw failure;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.process.OutputHandlerFailedGradleProcessResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */