/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.tasks.testing.TestResult.ResultType;
/*     */ 
/*     */ class ClassPageRenderer
/*     */   extends PageRenderer<ClassTestResults>
/*     */ {
/*  34 */   private final CodePanelRenderer codePanelRenderer = new CodePanelRenderer();
/*     */   
/*     */   ClassPageRenderer(ReportType reportType) {
/*  37 */     super(reportType);
/*     */   }
/*     */   
/*     */   protected String getTitle()
/*     */   {
/*  42 */     return ((ClassTestResults)getModel()).getTitle();
/*     */   }
/*     */   
/*     */   protected void renderBreadcrumbs(SimpleHtmlWriter htmlWriter)
/*     */     throws IOException
/*     */   {
/*  52 */     htmlWriter.startElement("div").attribute("class", "breadcrumbs").startElement("a").attribute("href", "index.html").characters("all").endElement().characters(" > ").startElement("a").attribute("href", String.format("%s.html", new Object[] { ((ClassTestResults)getResults()).getPackageResults().getFilename(reportType) })).characters(((ClassTestResults)getResults()).getPackageResults().getName()).endElement().characters(String.format(" > %s", new Object[] { ((ClassTestResults)getResults()).getSimpleName() })).endElement();
/*     */   }
/*     */   
/*     */   private void renderTests(SimpleHtmlWriter htmlWriter)
/*     */     throws IOException
/*     */   {
/*  59 */     htmlWriter.startElement("table").startElement("thead").startElement("tr").startElement("th").characters("Test").endElement();
/*     */     
/*  62 */     Map<String, Map<String, TestResult>> results = ((ClassTestResults)getResults()).getTestResultsMap();
/*     */     
/*  65 */     List<String> devices = Lists.newArrayList(results.keySet());
/*  66 */     Collections.sort(devices);
/*     */     
/*  68 */     for (Iterator localIterator1 = devices.iterator(); localIterator1.hasNext();) { device = (String)localIterator1.next();
/*  69 */       htmlWriter.startElement("th").characters(device).endElement();
/*     */     }
/*  71 */     htmlWriter.endElement().endElement();
/*     */     
/*  74 */     Object tests = Sets.newHashSet();
/*  75 */     for (String device = results.values().iterator(); device.hasNext();) { deviceMap = (Map)device.next();
/*  76 */       ((Set)tests).addAll(deviceMap.keySet()); }
/*     */     Map<String, TestResult> deviceMap;
/*  78 */     List<String> sortedTests = Lists.newArrayList((Iterable)tests);
/*  79 */     Collections.sort(sortedTests);
/*     */     
/*  81 */     for (String testName : sortedTests) {
/*  82 */       htmlWriter.startElement("tr").startElement("td").characters(testName).endElement();
/*     */       
/*  84 */       TestResult.ResultType currentType = TestResult.ResultType.SKIPPED;
/*     */       
/*  87 */       for (String device : devices) {
/*  88 */         Map<String, TestResult> deviceMap = (Map)results.get(device);
/*  89 */         TestResult test = (TestResult)deviceMap.get(testName);
/*  90 */         if (test != null)
/*     */         {
/*  94 */           htmlWriter.startElement("td").attribute("class", test.getStatusClass()).characters(String.format("%s (%s)", new Object[] { test.getFormattedResultType(), test.getFormattedDuration() })).endElement();
/*     */           
/*  96 */           currentType = combineResultType(currentType, test.getResultType());
/*     */         } else {
/*  98 */           htmlWriter.startElement("td").characters("not run ").endElement();
/*     */         }
/*     */       }
/*     */       
/* 105 */       htmlWriter.endElement();
/*     */     }
/* 107 */     htmlWriter.endElement();
/*     */   }
/*     */   
/*     */   public static TestResult.ResultType combineResultType(TestResult.ResultType currentType, TestResult.ResultType newType) {
/* 111 */     switch (currentType) {
/*     */     case SUCCESS: 
/* 113 */       if (newType == TestResult.ResultType.FAILURE) {
/* 114 */         return newType;
/*     */       }
/*     */       
/* 117 */       return currentType;
/*     */     case FAILURE: 
/* 119 */       return currentType;
/*     */     case SKIPPED: 
/* 121 */       if (newType != TestResult.ResultType.SKIPPED) {
/* 122 */         return newType;
/*     */       }
/* 124 */       return currentType;
/*     */     }
/* 126 */     throw new IllegalStateException();
/*     */   }
/*     */   
/*     */   public String getStatusClass(TestResult.ResultType resultType)
/*     */   {
/* 131 */     switch (resultType) {
/*     */     case SUCCESS: 
/* 133 */       return "success";
/*     */     case FAILURE: 
/* 135 */       return "failures";
/*     */     case SKIPPED: 
/* 137 */       return "skipped";
/*     */     }
/* 139 */     throw new IllegalStateException();
/*     */   }
/*     */   
/*     */   private static final class TestPercent {
/*     */     int failed;
/*     */     int total;
/*     */     
/*     */     TestPercent(int failed, int total) {
/* 147 */       this.failed = failed;
/* 148 */       this.total = total;
/*     */     }
/*     */     
/*     */     boolean isFullFailure() {
/* 152 */       return failed == total;
/*     */     }
/*     */   }
/*     */   
/*     */   protected void renderFailures(SimpleHtmlWriter htmlWriter)
/*     */     throws IOException
/*     */   {
/* 159 */     Map<String, Map<String, TestResult>> results = ((ClassTestResults)getResults()).getTestResultsMap();
/*     */     
/* 161 */     Map<String, TestPercent> testPassPercent = Maps.newHashMap();
/*     */     
/* 163 */     for (TestResult test : ((ClassTestResults)getResults()).getFailures()) {
/* 164 */       String testName = test.getName();
/*     */       
/* 169 */       TestPercent percent = (TestPercent)testPassPercent.get(testName);
/* 170 */       if ((percent == null) || (!percent.isFullFailure()))
/*     */       {
/*     */         int total;
/*     */         
/* 174 */         if (percent == null) {
/* 175 */           int failed = 0;
/* 176 */           total = 0;
/* 177 */           for (Map<String, TestResult> deviceMap : results.values()) {
/* 178 */             TestResult testResult = (TestResult)deviceMap.get(testName);
/* 179 */             if (testResult != null)
/*     */             {
/* 182 */               TestResult.ResultType resultType = testResult.getResultType();
/*     */               
/* 184 */               if (resultType == TestResult.ResultType.FAILURE) {
/* 185 */                 failed++;
/*     */               }
/*     */               
/* 188 */               if (resultType != TestResult.ResultType.SKIPPED) {
/* 189 */                 total++;
/*     */               }
/*     */             }
/*     */           }
/* 193 */           percent = new TestPercent(failed, total);
/* 194 */           testPassPercent.put(testName, percent);
/*     */         }
/*     */         String name;
/*     */         String name;
/* 198 */         if (total == 1) {
/* 199 */           name = testName; } else { String name;
/* 200 */           if (percent.isFullFailure()) {
/* 201 */             name = testName + " [all devices]";
/*     */           } else {
/* 203 */             name = String.format("%s [%s] (on %d/%d devices)", new Object[] { testName, test.getDevice(), 
/* 204 */               Integer.valueOf(failed), Integer.valueOf(total) });
/*     */           }
/*     */         }
/*     */         
/* 209 */         htmlWriter.startElement("div").attribute("class", "test").startElement("a").attribute("name", test.getId().toString()).characters("").endElement().startElement("h3").attribute("class", test.getStatusClass()).characters(name).endElement();
/* 210 */         for (TestResult.TestFailure failure : test.getFailures()) {
/* 211 */           codePanelRenderer.render(failure.getStackTrace(), htmlWriter);
/*     */         }
/* 213 */         htmlWriter.endElement();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected void registerTabs() {
/* 219 */     addFailuresTab();
/* 220 */     addTab("Tests", new ErroringAction()
/*     */     {
/*     */       public void doExecute(SimpleHtmlWriter writer) throws IOException {
/* 223 */         ClassPageRenderer.this.renderTests(writer);
/*     */       }
/* 225 */     });
/* 226 */     addDeviceAndVariantTabs();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.ClassPageRenderer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */