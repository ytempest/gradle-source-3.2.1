/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ 
/*     */ class OverviewPageRenderer
/*     */   extends PageRenderer<AllTestResults>
/*     */ {
/*     */   public OverviewPageRenderer(ReportType reportType)
/*     */   {
/*  26 */     super(reportType);
/*     */   }
/*     */   
/*     */   protected void registerTabs()
/*     */   {
/*  31 */     addFailuresTab();
/*  32 */     if (!((AllTestResults)getResults()).getPackages().isEmpty()) {
/*  33 */       addTab("Packages", new ErroringAction()
/*     */       {
/*     */         protected void doExecute(SimpleHtmlWriter writer) throws IOException {
/*  36 */           OverviewPageRenderer.this.renderPackages(writer);
/*     */         }
/*     */       });
/*     */     }
/*  40 */     addTab("Classes", new ErroringAction()
/*     */     {
/*     */       public void doExecute(SimpleHtmlWriter htmlWriter) throws IOException {
/*  43 */         OverviewPageRenderer.this.renderClasses(htmlWriter);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   protected void renderBreadcrumbs(SimpleHtmlWriter htmlWriter) {}
/*     */   
/*     */   private void renderPackages(SimpleHtmlWriter htmlWriter)
/*     */     throws IOException
/*     */   {
/*  53 */     htmlWriter.startElement("table");
/*  54 */     htmlWriter.startElement("thead");
/*  55 */     htmlWriter.startElement("tr");
/*  56 */     htmlWriter.startElement("th").characters("Package").endElement();
/*  57 */     htmlWriter.startElement("th").characters("Tests").endElement();
/*  58 */     htmlWriter.startElement("th").characters("Failures").endElement();
/*  59 */     htmlWriter.startElement("th").characters("Duration").endElement();
/*  60 */     htmlWriter.startElement("th").characters("Success rate").endElement();
/*  61 */     htmlWriter.endElement();
/*  62 */     htmlWriter.endElement();
/*  63 */     htmlWriter.startElement("tbody");
/*  64 */     for (PackageTestResults testPackage : ((AllTestResults)getResults()).getPackages()) {
/*  65 */       htmlWriter.startElement("tr");
/*  66 */       htmlWriter.startElement("td").attribute("class", testPackage.getStatusClass());
/*  67 */       htmlWriter.startElement("a").attribute("href", String.format("%s.html", new Object[] { testPackage.getFilename(reportType) })).characters(testPackage.getName()).endElement();
/*  68 */       htmlWriter.endElement();
/*  69 */       htmlWriter.startElement("td").characters(Integer.toString(testPackage.getTestCount())).endElement();
/*  70 */       htmlWriter.startElement("td").characters(Integer.toString(testPackage.getFailureCount())).endElement();
/*  71 */       htmlWriter.startElement("td").characters(testPackage.getFormattedDuration()).endElement();
/*  72 */       htmlWriter.startElement("td").attribute("class", testPackage.getStatusClass()).characters(testPackage.getFormattedSuccessRate()).endElement();
/*  73 */       htmlWriter.endElement();
/*     */     }
/*  75 */     htmlWriter.endElement();
/*  76 */     htmlWriter.endElement();
/*     */   }
/*     */   
/*     */   private void renderClasses(SimpleHtmlWriter htmlWriter) throws IOException {
/*  80 */     htmlWriter.startElement("table");
/*  81 */     htmlWriter.startElement("thead");
/*  82 */     htmlWriter.startElement("tr");
/*  83 */     htmlWriter.startElement("th").characters("Class").endElement();
/*  84 */     htmlWriter.startElement("th").characters("Tests").endElement();
/*  85 */     htmlWriter.startElement("th").characters("Failures").endElement();
/*  86 */     htmlWriter.startElement("th").characters("Duration").endElement();
/*  87 */     htmlWriter.startElement("th").characters("Success rate").endElement();
/*  88 */     htmlWriter.endElement();
/*  89 */     htmlWriter.endElement();
/*  90 */     htmlWriter.startElement("tbody");
/*     */     
/*  92 */     for (PackageTestResults testPackage : ((AllTestResults)getResults()).getPackages()) {
/*  93 */       for (ClassTestResults testClass : testPackage.getClasses()) {
/*  94 */         htmlWriter.startElement("tr");
/*  95 */         htmlWriter.startElement("td").attribute("class", testClass.getStatusClass()).endElement();
/*  96 */         htmlWriter.startElement("a").attribute("href", String.format("%s.html", new Object[] { testClass.getFilename(reportType) })).characters(testClass.getName()).endElement();
/*  97 */         htmlWriter.startElement("td").characters(Integer.toString(testClass.getTestCount())).endElement();
/*  98 */         htmlWriter.startElement("td").characters(Integer.toString(testClass.getFailureCount())).endElement();
/*  99 */         htmlWriter.startElement("td").characters(testClass.getFormattedDuration()).endElement();
/* 100 */         htmlWriter.startElement("td").attribute("class", testClass.getStatusClass()).characters(testClass.getFormattedSuccessRate()).endElement();
/* 101 */         htmlWriter.endElement();
/*     */       }
/*     */     }
/* 104 */     htmlWriter.endElement();
/* 105 */     htmlWriter.endElement();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.OverviewPageRenderer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */