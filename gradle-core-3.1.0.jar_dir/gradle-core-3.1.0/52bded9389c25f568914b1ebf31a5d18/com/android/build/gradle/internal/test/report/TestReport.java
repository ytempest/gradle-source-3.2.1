/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import com.google.common.io.Closeables;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.DecimalFormatSymbols;
/*     */ import java.text.ParseException;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.xpath.XPath;
/*     */ import javax.xml.xpath.XPathFactory;
/*     */ import org.gradle.api.GradleException;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.InputSource;
/*     */ 
/*     */ public class TestReport
/*     */ {
/*  40 */   private final HtmlReportRenderer htmlRenderer = new HtmlReportRenderer();
/*     */   private final ReportType reportType;
/*     */   private final File resultDir;
/*     */   private final File reportDir;
/*     */   
/*     */   public TestReport(ReportType reportType, File resultDir, File reportDir) {
/*  46 */     this.reportType = reportType;
/*  47 */     this.resultDir = resultDir;
/*  48 */     this.reportDir = reportDir;
/*  49 */     htmlRenderer.requireResource(getClass().getResource("report.js"));
/*  50 */     htmlRenderer.requireResource(getClass().getResource("base-style.css"));
/*  51 */     htmlRenderer.requireResource(getClass().getResource("style.css"));
/*     */   }
/*     */   
/*     */   public void generateReport() {
/*  55 */     AllTestResults model = loadModel();
/*  56 */     generateFiles(model);
/*     */   }
/*     */   
/*     */   private AllTestResults loadModel() {
/*  60 */     AllTestResults model = new AllTestResults();
/*  61 */     if (resultDir.exists()) {
/*  62 */       File[] files = resultDir.listFiles();
/*  63 */       if (files != null) {
/*  64 */         for (File file : files) {
/*  65 */           if ((file.getName().startsWith("TEST-")) && (file.getName().endsWith(".xml"))) {
/*  66 */             mergeFromFile(file, model);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*  71 */     return model;
/*     */   }
/*     */   
/*     */   private void mergeFromFile(File file, AllTestResults model) {
/*  75 */     InputStream inputStream = null;
/*     */     try
/*     */     {
/*  78 */       inputStream = new FileInputStream(file);
/*     */       try
/*     */       {
/*  81 */         document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(inputStream));
/*     */       } finally {
/*     */         Document document;
/*  84 */         inputStream.close();
/*     */       }
/*     */       Document document;
/*  87 */       String deviceName = null;
/*  88 */       String projectName = null;
/*  89 */       String flavorName = null;
/*  90 */       NodeList propertiesList = document.getElementsByTagName("properties");
/*  91 */       for (int i = 0; i < propertiesList.getLength(); i++) {
/*  92 */         Element properties = (Element)propertiesList.item(i);
/*  93 */         XPath xPath = XPathFactory.newInstance().newXPath();
/*  94 */         deviceName = xPath.evaluate("property[@name='device']/@value", properties);
/*  95 */         projectName = xPath.evaluate("property[@name='project']/@value", properties);
/*  96 */         flavorName = xPath.evaluate("property[@name='flavor']/@value", properties);
/*     */       }
/*     */       
/*  99 */       NodeList testCases = document.getElementsByTagName("testcase");
/* 100 */       for (int i = 0; i < testCases.getLength(); i++) {
/* 101 */         Element testCase = (Element)testCases.item(i);
/* 102 */         String className = testCase.getAttribute("classname");
/* 103 */         String testName = testCase.getAttribute("name");
/* 104 */         BigDecimal duration = parse(testCase.getAttribute("time"));
/* 105 */         duration = duration.multiply(BigDecimal.valueOf(1000L));
/* 106 */         NodeList failures = testCase.getElementsByTagName("failure");
/* 107 */         TestResult testResult = model.addTest(className, testName, duration.longValue(), deviceName, projectName, flavorName);
/*     */         
/* 109 */         for (int j = 0; j < failures.getLength(); j++) {
/* 110 */           Element failure = (Element)failures.item(j);
/* 111 */           testResult.addFailure(failure
/* 112 */             .getAttribute("message"), failure.getTextContent(), deviceName, projectName, flavorName);
/*     */         }
/*     */       }
/*     */       
/* 116 */       NodeList ignoredTestCases = document.getElementsByTagName("ignored-testcase");
/* 117 */       for (int i = 0; i < ignoredTestCases.getLength(); i++) {
/* 118 */         Element testCase = (Element)ignoredTestCases.item(i);
/* 119 */         String className = testCase.getAttribute("classname");
/* 120 */         String testName = testCase.getAttribute("name");
/* 121 */         model.addTest(className, testName, 0L, deviceName, projectName, flavorName).ignored();
/*     */       }
/* 123 */       String suiteClassName = document.getDocumentElement().getAttribute("name");
/* 124 */       ClassTestResults suiteResults = model.addTestClass(suiteClassName);
/* 125 */       NodeList stdOutElements = document.getElementsByTagName("system-out");
/* 126 */       for (int i = 0; i < stdOutElements.getLength(); i++) {
/* 127 */         suiteResults.addStandardOutput(stdOutElements.item(i).getTextContent());
/*     */       }
/* 129 */       NodeList stdErrElements = document.getElementsByTagName("system-err");
/* 130 */       for (int i = 0; i < stdErrElements.getLength(); i++)
/* 131 */         suiteResults.addStandardError(stdErrElements.item(i).getTextContent());
/*     */       return;
/*     */     } catch (Exception e) {
/* 134 */       throw new GradleException(String.format("Could not load test results from '%s'.", new Object[] { file }), e);
/*     */     } finally {
/*     */       try {
/* 137 */         Closeables.close(inputStream, true);
/*     */       }
/*     */       catch (IOException localIOException1) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private void generateFiles(AllTestResults model)
/*     */   {
/*     */     try {
/* 146 */       generatePage(model, new OverviewPageRenderer(reportType), new File(reportDir, "index.html"));
/* 147 */       for (PackageTestResults packageResults : model.getPackages()) {
/* 148 */         generatePage(packageResults, new PackagePageRenderer(reportType), new File(reportDir, packageResults
/* 149 */           .getFilename(reportType) + ".html"));
/* 150 */         for (ClassTestResults classResults : packageResults.getClasses()) {
/* 151 */           generatePage(classResults, new ClassPageRenderer(reportType), new File(reportDir, classResults
/* 152 */             .getFilename(reportType) + ".html"));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 157 */       throw new GradleException(String.format("Could not generate test report to '%s'.", new Object[] { reportDir }), e);
/*     */     }
/*     */   }
/*     */   
/*     */   private <T extends CompositeTestResults> void generatePage(T model, PageRenderer<T> renderer, File outputFile) throws Exception
/*     */   {
/* 163 */     htmlRenderer.renderer(renderer).writeTo(model, outputFile);
/*     */   }
/*     */   
/*     */   public BigDecimal parse(String source)
/*     */     throws ParseException
/*     */   {
/* 174 */     DecimalFormatSymbols symbols = new DecimalFormatSymbols();
/* 175 */     symbols.setDecimalSeparator('.');
/* 176 */     DecimalFormat format = new DecimalFormat("#.#", symbols);
/* 177 */     format.setParseBigDecimal(true);
/* 178 */     return (BigDecimal)format.parse(source);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.TestReport
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */