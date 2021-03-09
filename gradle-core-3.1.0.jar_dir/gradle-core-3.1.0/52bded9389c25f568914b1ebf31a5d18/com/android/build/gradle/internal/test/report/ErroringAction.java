/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import org.gradle.api.Action;
/*    */ 
/*    */ public abstract class ErroringAction<T>
/*    */   implements Action<T>
/*    */ {
/*    */   public void execute(T thing)
/*    */   {
/*    */     try
/*    */     {
/* 35 */       doExecute(thing);
/*    */     } catch (Exception e) {
/* 37 */       if ((e instanceof RuntimeException)) {
/* 38 */         throw ((RuntimeException)e);
/*    */       }
/* 40 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */   
/*    */   protected abstract void doExecute(T paramT)
/*    */     throws Exception;
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.ErroringAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */