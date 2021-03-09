/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.gradle.reporting.ReportRenderer;
/*     */ 
/*     */ class PageRenderer$5
/*     */   extends ReportRenderer<T, SimpleHtmlWriter>
/*     */ {
/*     */   PageRenderer$5(PageRenderer this$0) {}
/*     */   
/*     */   public void render(T model, SimpleHtmlWriter htmlWriter)
/*     */     throws IOException
/*     */   {
/* 189 */     PageRenderer.access$002(this$0, model);
/* 190 */     this$0.renderBreadcrumbs(htmlWriter);
/*     */     
/* 193 */     htmlWriter.startElement("div").attribute("id", "summary");
/* 194 */     htmlWriter.startElement("table");
/* 195 */     htmlWriter.startElement("tr");
/* 196 */     htmlWriter.startElement("td");
/* 197 */     htmlWriter.startElement("div").attribute("class", "summaryGroup");
/* 198 */     htmlWriter.startElement("table");
/* 199 */     htmlWriter.startElement("tr");
/* 200 */     htmlWriter.startElement("td");
/* 201 */     htmlWriter.startElement("div").attribute("class", "infoBox").attribute("id", "tests");
/* 202 */     htmlWriter.startElement("div").attribute("class", "counter").characters(Integer.toString(PageRenderer.access$000(this$0).getTestCount())).endElement();
/* 203 */     htmlWriter.startElement("p").characters("tests").endElement();
/* 204 */     htmlWriter.endElement();
/* 205 */     htmlWriter.endElement();
/* 206 */     htmlWriter.startElement("td");
/* 207 */     htmlWriter.startElement("div").attribute("class", "infoBox").attribute("id", "failures");
/* 208 */     htmlWriter.startElement("div").attribute("class", "counter").characters(Integer.toString(PageRenderer.access$000(this$0).getFailureCount())).endElement();
/* 209 */     htmlWriter.startElement("p").characters("failures").endElement();
/* 210 */     htmlWriter.endElement();
/* 211 */     htmlWriter.endElement();
/* 212 */     htmlWriter.startElement("td");
/* 213 */     htmlWriter.startElement("div").attribute("class", "infoBox").attribute("id", "duration");
/* 214 */     htmlWriter.startElement("div").attribute("class", "counter").characters(PageRenderer.access$000(this$0).getFormattedDuration()).endElement();
/* 215 */     htmlWriter.startElement("p").characters("duration").endElement();
/* 216 */     htmlWriter.endElement();
/* 217 */     htmlWriter.endElement();
/* 218 */     htmlWriter.endElement();
/* 219 */     htmlWriter.endElement();
/* 220 */     htmlWriter.endElement();
/* 221 */     htmlWriter.endElement();
/* 222 */     htmlWriter.startElement("td");
/* 223 */     htmlWriter.startElement("div").attribute("class", String.format("infoBox %s", new Object[] { PageRenderer.access$000(this$0).getStatusClass() })).attribute("id", "successRate");
/* 224 */     htmlWriter.startElement("div").attribute("class", "percent").characters(PageRenderer.access$000(this$0).getFormattedSuccessRate()).endElement();
/* 225 */     htmlWriter.startElement("p").characters("successful").endElement();
/* 226 */     htmlWriter.endElement();
/* 227 */     htmlWriter.endElement();
/* 228 */     htmlWriter.endElement();
/* 229 */     htmlWriter.endElement();
/* 230 */     htmlWriter.endElement();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.PageRenderer.5
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */