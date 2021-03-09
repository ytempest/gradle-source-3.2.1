/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.gradle.reporting.ReportRenderer;
/*     */ 
/*     */ class PageRenderer$6
/*     */   extends ReportRenderer<T, SimpleHtmlWriter>
/*     */ {
/*     */   PageRenderer$6(PageRenderer this$0) {}
/*     */   
/*     */   public void render(T model, SimpleHtmlWriter htmlWriter)
/*     */     throws IOException
/*     */   {
/* 240 */     PageRenderer.access$002(this$0, model);
/* 241 */     PageRenderer.access$100(this$0).clear();
/* 242 */     this$0.registerTabs();
/* 243 */     this$0.renderTabs(htmlWriter);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.PageRenderer.6
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */