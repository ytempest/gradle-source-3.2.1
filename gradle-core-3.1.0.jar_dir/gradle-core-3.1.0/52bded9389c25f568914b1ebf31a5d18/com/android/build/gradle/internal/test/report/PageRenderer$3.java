/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ class PageRenderer$3
/*    */   extends ErroringAction<SimpleHtmlWriter>
/*    */ {
/*    */   PageRenderer$3(PageRenderer this$0) {}
/*    */   
/*    */   public void doExecute(SimpleHtmlWriter writer)
/*    */     throws IOException
/*    */   {
/* 72 */     this$0.renderCompositeResults(writer, PageRenderer.access$000(this$0).getResultsPerDevices(), "Devices");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.PageRenderer.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */