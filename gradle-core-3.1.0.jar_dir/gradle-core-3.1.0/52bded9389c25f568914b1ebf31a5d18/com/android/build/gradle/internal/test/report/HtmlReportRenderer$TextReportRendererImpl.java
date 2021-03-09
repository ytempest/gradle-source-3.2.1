/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import java.io.Writer;
/*     */ import org.gradle.reporting.ReportRenderer;
/*     */ 
/*     */ class HtmlReportRenderer$TextReportRendererImpl<T>
/*     */   extends TextReportRenderer<T>
/*     */ {
/*     */   private final ReportRenderer<T, SimpleHtmlWriter> delegate;
/*     */   
/*     */   private HtmlReportRenderer$TextReportRendererImpl(ReportRenderer<T, SimpleHtmlWriter> delegate)
/*     */   {
/*  96 */     this.delegate = delegate;
/*     */   }
/*     */   
/*     */   protected void writeTo(T model, Writer writer) throws Exception
/*     */   {
/* 101 */     SimpleHtmlWriter htmlWriter = new SimpleHtmlWriter(writer, "");
/* 102 */     htmlWriter.startElement("html");
/* 103 */     delegate.render(model, htmlWriter);
/* 104 */     htmlWriter.endElement();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.HtmlReportRenderer.TextReportRendererImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */