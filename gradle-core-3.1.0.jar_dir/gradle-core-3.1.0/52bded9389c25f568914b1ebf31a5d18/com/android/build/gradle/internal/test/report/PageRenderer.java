/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.reporting.ReportRenderer;
/*     */ 
/*     */ abstract class PageRenderer<T extends CompositeTestResults>
/*     */   extends TabbedPageRenderer<T>
/*     */ {
/*     */   private T results;
/*  28 */   private final TabsRenderer<T> tabsRenderer = new TabsRenderer();
/*     */   protected final ReportType reportType;
/*     */   
/*     */   PageRenderer(ReportType reportType) {
/*  32 */     this.reportType = reportType;
/*     */   }
/*     */   
/*     */   protected T getResults() {
/*  36 */     return results;
/*     */   }
/*     */   
/*     */   protected abstract void renderBreadcrumbs(SimpleHtmlWriter paramSimpleHtmlWriter) throws IOException;
/*     */   
/*     */   protected abstract void registerTabs();
/*     */   
/*     */   protected void addTab(String title, final Action<SimpleHtmlWriter> contentRenderer) {
/*  44 */     tabsRenderer.add(title, new ReportRenderer()
/*     */     {
/*     */       public void render(T model, SimpleHtmlWriter writer) {
/*  47 */         contentRenderer.execute(writer);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   protected void renderTabs(SimpleHtmlWriter htmlWriter) throws IOException {
/*  53 */     tabsRenderer.render(getModel(), htmlWriter);
/*     */   }
/*     */   
/*     */   protected void addFailuresTab() {
/*  57 */     if (!results.getFailures().isEmpty()) {
/*  58 */       addTab("Failed tests", new ErroringAction()
/*     */       {
/*     */         public void doExecute(SimpleHtmlWriter writer) throws IOException {
/*  61 */           renderFailures(writer);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addDeviceAndVariantTabs() {
/*  68 */     if (results.getResultsPerDevices().size() > 1) {
/*  69 */       addTab("Devices", new ErroringAction()
/*     */       {
/*     */         public void doExecute(SimpleHtmlWriter writer) throws IOException {
/*  72 */           renderCompositeResults(writer, results.getResultsPerDevices(), "Devices");
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*  78 */     if (results.getResultsPerVariants().size() > 1) {
/*  79 */       addTab("Variants", new ErroringAction()
/*     */       {
/*     */         public void doExecute(SimpleHtmlWriter writer) throws IOException {
/*  82 */           renderCompositeResults(writer, results.getResultsPerVariants(), "Variants");
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   protected void renderFailures(SimpleHtmlWriter htmlWriter) throws IOException
/*     */   {
/*  90 */     htmlWriter.startElement("ul").attribute("class", "linkList");
/*     */     
/*  92 */     boolean multiDevices = results.getResultsPerDevices().size() > 1;
/*  93 */     boolean multiVariants = results.getResultsPerVariants().size() > 1;
/*     */     
/*  95 */     htmlWriter.startElement("table");
/*  96 */     htmlWriter.startElement("thead");
/*     */     
/*  98 */     htmlWriter.startElement("tr");
/*  99 */     if (multiDevices) {
/* 100 */       htmlWriter.startElement("th").characters("Devices").endElement();
/*     */     }
/* 102 */     if (multiVariants) {
/* 103 */       if (reportType == ReportType.MULTI_PROJECT) {
/* 104 */         htmlWriter.startElement("th").characters("Project").endElement();
/* 105 */         htmlWriter.startElement("th").characters("Flavor").endElement();
/* 106 */       } else if (reportType == ReportType.MULTI_FLAVOR) {
/* 107 */         htmlWriter.startElement("th").characters("Flavor").endElement();
/*     */       }
/*     */     }
/* 110 */     htmlWriter.startElement("th").characters("Class").endElement();
/* 111 */     htmlWriter.startElement("th").characters("Test").endElement();
/*     */     
/* 113 */     htmlWriter.endElement();
/* 114 */     htmlWriter.endElement();
/*     */     
/* 116 */     for (TestResult test : results.getFailures()) {
/* 117 */       htmlWriter.startElement("tr");
/*     */       
/* 119 */       if (multiDevices) {
/* 120 */         htmlWriter.startElement("td").characters(test.getDevice()).endElement();
/*     */       }
/* 122 */       if (multiVariants) {
/* 123 */         if (reportType == ReportType.MULTI_PROJECT) {
/* 124 */           htmlWriter.startElement("td").characters(test.getProject()).endElement();
/* 125 */           htmlWriter.startElement("td").characters(test.getFlavor()).endElement();
/* 126 */         } else if (reportType == ReportType.MULTI_FLAVOR) {
/* 127 */           htmlWriter.startElement("td").characters(test.getFlavor()).endElement();
/*     */         }
/*     */       }
/*     */       
/* 134 */       htmlWriter.startElement("td").attribute("class", test.getStatusClass()).startElement("a").attribute("href", String.format("%s.html", new Object[] { test.getClassResults().getFilename(reportType) })).characters(test.getClassResults().getSimpleName()).endElement().endElement();
/*     */       
/* 136 */       htmlWriter.startElement("td").attribute("class", test.getStatusClass())
/* 137 */         .startElement("a").attribute("href", String.format("%s.html#%s", new Object[] { test.getClassResults().getFilename(reportType), test.getName() }))
/* 138 */         .characters(test.getName()).endElement()
/* 139 */         .endElement();
/* 140 */       htmlWriter.endElement();
/*     */     }
/* 142 */     htmlWriter.endElement();
/* 143 */     htmlWriter.endElement();
/*     */   }
/*     */   
/*     */   protected void renderCompositeResults(SimpleHtmlWriter htmlWriter, Map<String, ? extends CompositeTestResults> map, String name)
/*     */     throws IOException
/*     */   {
/* 150 */     htmlWriter.startElement("table");
/* 151 */     htmlWriter.startElement("thead");
/* 152 */     htmlWriter.startElement("tr");
/* 153 */     htmlWriter.startElement("th").characters(name).endElement();
/* 154 */     htmlWriter.startElement("th").characters("Tests").endElement();
/* 155 */     htmlWriter.startElement("th").characters("Failures").endElement();
/* 156 */     htmlWriter.startElement("th").characters("Duration").endElement();
/* 157 */     htmlWriter.startElement("th").characters("Success rate").endElement();
/* 158 */     htmlWriter.endElement();
/* 159 */     htmlWriter.endElement();
/*     */     
/* 161 */     for (CompositeTestResults results : map.values()) {
/* 162 */       htmlWriter.startElement("tr");
/* 163 */       htmlWriter.startElement("td").attribute("class", results.getStatusClass()).characters(results.getName()).endElement();
/* 164 */       htmlWriter.startElement("td").characters(Integer.toString(results.getTestCount())).endElement();
/* 165 */       htmlWriter.startElement("td").characters(Integer.toString(results.getFailureCount())).endElement();
/* 166 */       htmlWriter.startElement("td").characters(results.getFormattedDuration()).endElement();
/* 167 */       htmlWriter.startElement("td").characters(results.getFormattedSuccessRate()).endElement();
/* 168 */       htmlWriter.endElement();
/*     */     }
/*     */     
/* 171 */     htmlWriter.endElement();
/*     */   }
/*     */   
/*     */   protected String getTitle()
/*     */   {
/* 176 */     return ((CompositeTestResults)getModel()).getTitle();
/*     */   }
/*     */   
/*     */   protected String getPageTitle()
/*     */   {
/* 181 */     return String.format("Test results - %s", new Object[] { ((CompositeTestResults)getModel()).getTitle() });
/*     */   }
/*     */   
/*     */   protected ReportRenderer<T, SimpleHtmlWriter> getHeaderRenderer()
/*     */   {
/* 186 */     new ReportRenderer()
/*     */     {
/*     */       public void render(T model, SimpleHtmlWriter htmlWriter) throws IOException {
/* 189 */         results = model;
/* 190 */         renderBreadcrumbs(htmlWriter);
/*     */         
/* 193 */         htmlWriter.startElement("div").attribute("id", "summary");
/* 194 */         htmlWriter.startElement("table");
/* 195 */         htmlWriter.startElement("tr");
/* 196 */         htmlWriter.startElement("td");
/* 197 */         htmlWriter.startElement("div").attribute("class", "summaryGroup");
/* 198 */         htmlWriter.startElement("table");
/* 199 */         htmlWriter.startElement("tr");
/* 200 */         htmlWriter.startElement("td");
/* 201 */         htmlWriter.startElement("div").attribute("class", "infoBox").attribute("id", "tests");
/* 202 */         htmlWriter.startElement("div").attribute("class", "counter").characters(Integer.toString(results.getTestCount())).endElement();
/* 203 */         htmlWriter.startElement("p").characters("tests").endElement();
/* 204 */         htmlWriter.endElement();
/* 205 */         htmlWriter.endElement();
/* 206 */         htmlWriter.startElement("td");
/* 207 */         htmlWriter.startElement("div").attribute("class", "infoBox").attribute("id", "failures");
/* 208 */         htmlWriter.startElement("div").attribute("class", "counter").characters(Integer.toString(results.getFailureCount())).endElement();
/* 209 */         htmlWriter.startElement("p").characters("failures").endElement();
/* 210 */         htmlWriter.endElement();
/* 211 */         htmlWriter.endElement();
/* 212 */         htmlWriter.startElement("td");
/* 213 */         htmlWriter.startElement("div").attribute("class", "infoBox").attribute("id", "duration");
/* 214 */         htmlWriter.startElement("div").attribute("class", "counter").characters(results.getFormattedDuration()).endElement();
/* 215 */         htmlWriter.startElement("p").characters("duration").endElement();
/* 216 */         htmlWriter.endElement();
/* 217 */         htmlWriter.endElement();
/* 218 */         htmlWriter.endElement();
/* 219 */         htmlWriter.endElement();
/* 220 */         htmlWriter.endElement();
/* 221 */         htmlWriter.endElement();
/* 222 */         htmlWriter.startElement("td");
/* 223 */         htmlWriter.startElement("div").attribute("class", String.format("infoBox %s", new Object[] { results.getStatusClass() })).attribute("id", "successRate");
/* 224 */         htmlWriter.startElement("div").attribute("class", "percent").characters(results.getFormattedSuccessRate()).endElement();
/* 225 */         htmlWriter.startElement("p").characters("successful").endElement();
/* 226 */         htmlWriter.endElement();
/* 227 */         htmlWriter.endElement();
/* 228 */         htmlWriter.endElement();
/* 229 */         htmlWriter.endElement();
/* 230 */         htmlWriter.endElement();
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   protected ReportRenderer<T, SimpleHtmlWriter> getContentRenderer()
/*     */   {
/* 237 */     new ReportRenderer()
/*     */     {
/*     */       public void render(T model, SimpleHtmlWriter htmlWriter) throws IOException {
/* 240 */         results = model;
/* 241 */         tabsRenderer.clear();
/* 242 */         registerTabs();
/* 243 */         renderTabs(htmlWriter);
/*     */       }
/*     */     };
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.PageRenderer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */