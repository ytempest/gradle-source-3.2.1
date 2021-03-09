/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.gradle.reporting.ReportRenderer;
/*    */ 
/*    */ public class TabsRenderer<T>
/*    */   extends ReportRenderer<T, SimpleHtmlWriter>
/*    */ {
/* 25 */   private final List<TabsRenderer<T>.TabDefinition> tabs = new ArrayList();
/*    */   
/*    */   public void add(String title, ReportRenderer<T, SimpleHtmlWriter> contentRenderer) {
/* 28 */     tabs.add(new TabDefinition(title, contentRenderer, null));
/*    */   }
/*    */   
/*    */   public void clear() {
/* 32 */     tabs.clear();
/*    */   }
/*    */   
/*    */   public void render(T model, SimpleHtmlWriter htmlWriterWriter) throws IOException
/*    */   {
/* 37 */     htmlWriterWriter.startElement("div").attribute("id", "tabs");
/* 38 */     htmlWriterWriter.startElement("ul").attribute("class", "tabLinks");
/* 39 */     for (int i = 0; i < tabs.size(); i++) {
/* 40 */       TabsRenderer<T>.TabDefinition tab = (TabDefinition)tabs.get(i);
/* 41 */       String tabId = String.format("tab%s", new Object[] { Integer.valueOf(i) });
/* 42 */       htmlWriterWriter.startElement("li");
/* 43 */       htmlWriterWriter.startElement("a").attribute("href", "#" + tabId).characters(title).endElement();
/* 44 */       htmlWriterWriter.endElement();
/*    */     }
/* 46 */     htmlWriterWriter.endElement();
/*    */     
/* 48 */     for (int i = 0; i < tabs.size(); i++) {
/* 49 */       TabsRenderer<T>.TabDefinition tab = (TabDefinition)tabs.get(i);
/* 50 */       String tabId = String.format("tab%s", new Object[] { Integer.valueOf(i) });
/* 51 */       htmlWriterWriter.startElement("div").attribute("id", tabId).attribute("class", "tab");
/* 52 */       htmlWriterWriter.startElement("h2").characters(title).endElement();
/* 53 */       renderer.render(model, htmlWriterWriter);
/* 54 */       htmlWriterWriter.endElement();
/*    */     }
/* 56 */     htmlWriterWriter.endElement();
/*    */   }
/*    */   
/*    */   private class TabDefinition {
/*    */     final String title;
/*    */     final ReportRenderer<T, SimpleHtmlWriter> renderer;
/*    */     
/*    */     private TabDefinition(ReportRenderer<T, SimpleHtmlWriter> title) {
/* 64 */       this.title = title;
/* 65 */       this.renderer = renderer;
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.TabsRenderer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */