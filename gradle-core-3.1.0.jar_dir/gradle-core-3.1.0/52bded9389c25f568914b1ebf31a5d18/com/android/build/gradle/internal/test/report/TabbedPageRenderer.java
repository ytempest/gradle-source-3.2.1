/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.text.DateFormat;
/*    */ import java.util.Date;
/*    */ import org.gradle.reporting.ReportRenderer;
/*    */ import org.gradle.util.GradleVersion;
/*    */ 
/*    */ public abstract class TabbedPageRenderer<T>
/*    */   extends ReportRenderer<T, SimpleHtmlWriter>
/*    */ {
/*    */   private T model;
/*    */   
/*    */   protected T getModel()
/*    */   {
/* 29 */     return (T)model;
/*    */   }
/*    */   
/*    */   protected abstract String getTitle();
/*    */   
/*    */   protected abstract ReportRenderer<T, SimpleHtmlWriter> getHeaderRenderer();
/*    */   
/*    */   protected abstract ReportRenderer<T, SimpleHtmlWriter> getContentRenderer();
/*    */   
/*    */   protected String getPageTitle() {
/* 39 */     return getTitle();
/*    */   }
/*    */   
/*    */   public void render(T model, SimpleHtmlWriter htmlWriter)
/*    */     throws IOException
/*    */   {
/* 45 */     this.model = model;
/* 46 */     htmlWriter.startElement("head")
/* 47 */       .startElement("meta").attribute("http-equiv", "Content-Type").attribute("content", "text/html; charset=utf-8").endElement()
/* 48 */       .startElement("title").characters(getPageTitle()).endElement()
/* 49 */       .startElement("link").attribute("href", "css/base-style.css").attribute("rel", "stylesheet").attribute("type", "text/css").endElement()
/* 50 */       .startElement("link").attribute("href", "css/style.css").attribute("rel", "stylesheet").attribute("type", "text/css").endElement()
/* 51 */       .startElement("script").attribute("src", "js/report.js").attribute("type", "text/javascript").characters("").endElement()
/* 52 */       .endElement();
/*    */     
/* 54 */     htmlWriter.startElement("body")
/* 55 */       .startElement("div").attribute("id", "content")
/* 56 */       .startElement("h1").characters(getTitle()).endElement();
/* 57 */     getHeaderRenderer().render(model, htmlWriter);
/* 58 */     getContentRenderer().render(model, htmlWriter);
/* 59 */     htmlWriter.startElement("div").attribute("id", "footer")
/* 60 */       .startElement("p").characters("Generated by ")
/* 61 */       .startElement("a").attribute("href", "http://www.gradle.org").characters(String.format("Gradle %s", new Object[] { GradleVersion.current().getVersion() })).endElement()
/* 62 */       .characters(String.format(" at %s", new Object[] {DateFormat.getDateTimeInstance().format(new Date()) }))
/* 63 */       .endElement()
/* 64 */       .endElement()
/* 65 */       .endElement();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.TabbedPageRenderer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */