/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.Writer;
/*    */ import org.gradle.internal.ErroringAction;
/*    */ import org.gradle.internal.IoActions;
/*    */ 
/*    */ public abstract class TextReportRenderer<T>
/*    */ {
/*    */   protected abstract void writeTo(T paramT, Writer paramWriter)
/*    */     throws Exception;
/*    */   
/*    */   public void writeTo(final T model, File file)
/*    */   {
/* 36 */     IoActions.writeTextFile(file, "utf-8", new ErroringAction()
/*    */     {
/*    */       protected void doExecute(Writer writer) throws Exception {
/* 39 */         writeTo(model, writer);
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.TextReportRenderer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */