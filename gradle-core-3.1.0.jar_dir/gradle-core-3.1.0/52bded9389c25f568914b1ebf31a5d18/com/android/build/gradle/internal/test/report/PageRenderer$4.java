/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ class PageRenderer$4
/*    */   extends ErroringAction<SimpleHtmlWriter>
/*    */ {
/*    */   PageRenderer$4(PageRenderer this$0) {}
/*    */   
/*    */   public void doExecute(SimpleHtmlWriter writer)
/*    */     throws IOException
/*    */   {
/* 82 */     this$0.renderCompositeResults(writer, PageRenderer.access$000(this$0).getResultsPerVariants(), "Variants");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.PageRenderer.4
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */