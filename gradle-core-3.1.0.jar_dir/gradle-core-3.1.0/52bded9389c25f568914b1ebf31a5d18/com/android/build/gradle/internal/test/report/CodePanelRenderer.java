/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.gradle.reporting.ReportRenderer;
/*    */ 
/*    */ public class CodePanelRenderer
/*    */   extends ReportRenderer<String, SimpleHtmlWriter>
/*    */ {
/*    */   public void render(String text, SimpleHtmlWriter htmlWriter)
/*    */     throws IOException
/*    */   {
/* 28 */     htmlWriter.startElement("span").attribute("class", "code").startElement("pre").characters(text).endElement().endElement();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.CodePanelRenderer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */