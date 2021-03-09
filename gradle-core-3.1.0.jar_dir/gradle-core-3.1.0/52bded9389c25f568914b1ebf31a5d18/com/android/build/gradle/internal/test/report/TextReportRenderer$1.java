/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.io.Writer;
/*    */ import org.gradle.internal.ErroringAction;
/*    */ 
/*    */ class TextReportRenderer$1
/*    */   extends ErroringAction<Writer>
/*    */ {
/*    */   TextReportRenderer$1(TextReportRenderer this$0, Object paramObject) {}
/*    */   
/*    */   protected void doExecute(Writer writer)
/*    */     throws Exception
/*    */   {
/* 39 */     this$0.writeTo(val$model, writer);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.TextReportRenderer.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */