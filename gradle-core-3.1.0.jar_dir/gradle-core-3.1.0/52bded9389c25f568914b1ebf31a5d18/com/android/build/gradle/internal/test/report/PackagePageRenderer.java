/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class PackagePageRenderer
/*    */   extends PageRenderer<PackageTestResults>
/*    */ {
/*    */   public PackagePageRenderer(ReportType reportType)
/*    */   {
/* 26 */     super(reportType);
/*    */   }
/*    */   
/*    */   protected String getTitle()
/*    */   {
/* 31 */     return ((PackageTestResults)getModel()).getTitle();
/*    */   }
/*    */   
/*    */   protected void renderBreadcrumbs(SimpleHtmlWriter htmlWriter) throws IOException
/*    */   {
/* 36 */     htmlWriter.startElement("div").attribute("class", "breadcrumbs");
/* 37 */     htmlWriter.startElement("a").attribute("href", "index.html").characters("all").endElement();
/* 38 */     htmlWriter.characters(String.format(" > %s", new Object[] { ((PackageTestResults)getResults()).getName() }));
/* 39 */     htmlWriter.endElement();
/*    */   }
/*    */   
/*    */   private void renderClasses(SimpleHtmlWriter htmlWriter) throws IOException {
/* 43 */     htmlWriter.startElement("table");
/* 44 */     htmlWriter.startElement("thread");
/* 45 */     htmlWriter.startElement("tr");
/*    */     
/* 47 */     htmlWriter.startElement("th").characters("Class").endElement();
/* 48 */     htmlWriter.startElement("th").characters("Tests").endElement();
/* 49 */     htmlWriter.startElement("th").characters("Failures").endElement();
/* 50 */     htmlWriter.startElement("th").characters("Duration").endElement();
/* 51 */     htmlWriter.startElement("th").characters("Success rate").endElement();
/*    */     
/* 53 */     htmlWriter.endElement();
/* 54 */     htmlWriter.endElement();
/*    */     
/* 56 */     for (ClassTestResults testClass : ((PackageTestResults)getResults()).getClasses()) {
/* 57 */       htmlWriter.startElement("tr");
/* 58 */       htmlWriter.startElement("td").attribute("class", testClass.getStatusClass());
/* 59 */       htmlWriter.startElement("a").attribute("href", String.format("%s.html", new Object[] { testClass.getFilename(reportType) })).characters(testClass.getSimpleName()).endElement();
/* 60 */       htmlWriter.endElement();
/* 61 */       htmlWriter.startElement("td").characters(Integer.toString(testClass.getTestCount())).endElement();
/* 62 */       htmlWriter.startElement("td").characters(Integer.toString(testClass.getFailureCount())).endElement();
/* 63 */       htmlWriter.startElement("td").characters(testClass.getFormattedDuration()).endElement();
/* 64 */       htmlWriter.startElement("td").attribute("class", testClass.getStatusClass()).characters(testClass.getFormattedSuccessRate()).endElement();
/* 65 */       htmlWriter.endElement();
/*    */     }
/* 67 */     htmlWriter.endElement();
/*    */   }
/*    */   
/*    */   protected void registerTabs()
/*    */   {
/* 72 */     addFailuresTab();
/* 73 */     addTab("Classes", new ErroringAction()
/*    */     {
/*    */       public void doExecute(SimpleHtmlWriter htmlWriter) throws IOException {
/* 76 */         PackagePageRenderer.this.renderClasses(htmlWriter);
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.PackagePageRenderer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */