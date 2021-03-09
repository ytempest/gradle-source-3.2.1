/*    */ package com.android.build.gradle.internal.process;
/*    */ 
/*    */ import com.android.ide.common.process.ProcessException;
/*    */ import com.android.ide.common.process.ProcessInfo;
/*    */ import com.android.ide.common.process.ProcessResult;
/*    */ import com.google.common.base.Joiner;
/*    */ import org.gradle.process.ExecResult;
/*    */ import org.gradle.process.internal.ExecException;
/*    */ 
/*    */ class GradleProcessResult
/*    */   implements ProcessResult
/*    */ {
/*    */   private final ExecResult result;
/*    */   private final ProcessInfo processInfo;
/*    */   
/*    */   GradleProcessResult(ExecResult result, ProcessInfo processInfo)
/*    */   {
/* 38 */     this.result = result;
/* 39 */     this.processInfo = processInfo;
/*    */   }
/*    */   
/*    */   public ProcessResult assertNormalExitValue() throws ProcessException
/*    */   {
/*    */     try
/*    */     {
/* 46 */       result.assertNormalExitValue();
/*    */     } catch (ExecException e) {
/* 48 */       throw buildProcessException(e);
/*    */     }
/*    */     
/* 51 */     return this;
/*    */   }
/*    */   
/*    */   public int getExitValue()
/*    */   {
/* 56 */     return result.getExitValue();
/*    */   }
/*    */   
/*    */   public ProcessResult rethrowFailure() throws ProcessException
/*    */   {
/*    */     try
/*    */     {
/* 63 */       result.rethrowFailure();
/*    */     } catch (ExecException e) {
/* 65 */       throw buildProcessException(e);
/*    */     }
/* 67 */     return this;
/*    */   }
/*    */   
/*    */   private ProcessException buildProcessException(ExecException e)
/*    */   {
/* 72 */     return new ProcessException(
/* 73 */       String.format("Error while executing %s with arguments {%s}", new Object[] {processInfo
/*    */       
/* 75 */       .getDescription(), 
/* 76 */       Joiner.on(' ').join(processInfo.getArgs()) }), e);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.process.GradleProcessResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */