/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.TreeSet;
/*     */ import org.gradle.api.tasks.testing.TestResult.ResultType;
/*     */ 
/*     */ public abstract class CompositeTestResults
/*     */   extends TestResultModel
/*     */ {
/*     */   private final CompositeTestResults parent;
/*     */   private int tests;
/*  34 */   private final Set<TestResult> failures = new TreeSet();
/*     */   
/*     */   private long duration;
/*  37 */   private final Map<String, DeviceTestResults> devices = new TreeMap();
/*  38 */   private final Map<String, VariantTestResults> variants = new TreeMap();
/*     */   
/*     */   protected CompositeTestResults(CompositeTestResults parent)
/*     */   {
/*  42 */     this.parent = parent;
/*     */   }
/*     */   
/*     */   public String getFilename(ReportType reportType) {
/*  46 */     return getName();
/*     */   }
/*     */   
/*     */   public abstract String getName();
/*     */   
/*     */   public int getTestCount() {
/*  52 */     return tests;
/*     */   }
/*     */   
/*     */   public int getFailureCount() {
/*  56 */     return failures.size();
/*     */   }
/*     */   
/*     */   public long getDuration()
/*     */   {
/*  61 */     return duration;
/*     */   }
/*     */   
/*     */   public String getFormattedDuration()
/*     */   {
/*  66 */     return getTestCount() == 0 ? "-" : super.getFormattedDuration();
/*     */   }
/*     */   
/*     */   public Set<TestResult> getFailures() {
/*  70 */     return failures;
/*     */   }
/*     */   
/*     */   Map<String, DeviceTestResults> getResultsPerDevices() {
/*  74 */     return devices;
/*     */   }
/*     */   
/*     */   Map<String, VariantTestResults> getResultsPerVariants() {
/*  78 */     return variants;
/*     */   }
/*     */   
/*     */   public TestResult.ResultType getResultType()
/*     */   {
/*  83 */     return failures.isEmpty() ? TestResult.ResultType.SUCCESS : TestResult.ResultType.FAILURE;
/*     */   }
/*     */   
/*     */   public String getFormattedSuccessRate() {
/*  87 */     Number successRate = getSuccessRate();
/*  88 */     if (successRate == null) {
/*  89 */       return "-";
/*     */     }
/*  91 */     return successRate + "%";
/*     */   }
/*     */   
/*     */   public Number getSuccessRate() {
/*  95 */     if (getTestCount() == 0) {
/*  96 */       return null;
/*     */     }
/*     */     
/*  99 */     BigDecimal tests = BigDecimal.valueOf(getTestCount());
/* 100 */     BigDecimal successful = BigDecimal.valueOf(getTestCount() - getFailureCount());
/*     */     
/* 102 */     return Integer.valueOf(successful.divide(tests, 2, 1)
/* 103 */       .multiply(BigDecimal.valueOf(100L)).intValue());
/*     */   }
/*     */   
/*     */   protected void failed(TestResult failedTest, String deviceName, String projectName, String flavorName)
/*     */   {
/* 108 */     failures.add(failedTest);
/* 109 */     if (parent != null) {
/* 110 */       parent.failed(failedTest, deviceName, projectName, flavorName);
/*     */     }
/*     */     
/* 113 */     DeviceTestResults deviceResults = (DeviceTestResults)devices.get(deviceName);
/* 114 */     if (deviceResults != null) {
/* 115 */       deviceResults.failed(failedTest, deviceName, projectName, flavorName);
/*     */     }
/*     */     
/* 118 */     String key = getVariantKey(projectName, flavorName);
/* 119 */     VariantTestResults variantResults = (VariantTestResults)variants.get(key);
/* 120 */     if (variantResults != null) {
/* 121 */       variantResults.failed(failedTest, deviceName, projectName, flavorName);
/*     */     }
/*     */   }
/*     */   
/*     */   protected TestResult addTest(TestResult test) {
/* 126 */     tests += 1;
/* 127 */     duration += test.getDuration();
/* 128 */     return test;
/*     */   }
/*     */   
/*     */   protected void addDevice(String deviceName, TestResult testResult) {
/* 132 */     DeviceTestResults deviceResults = (DeviceTestResults)devices.get(deviceName);
/* 133 */     if (deviceResults == null) {
/* 134 */       deviceResults = new DeviceTestResults(deviceName, null);
/* 135 */       devices.put(deviceName, deviceResults);
/*     */     }
/*     */     
/* 138 */     deviceResults.addTest(testResult);
/*     */   }
/*     */   
/*     */   protected void addVariant(String projectName, String flavorName, TestResult testResult) {
/* 142 */     String key = getVariantKey(projectName, flavorName);
/* 143 */     VariantTestResults variantResults = (VariantTestResults)variants.get(key);
/* 144 */     if (variantResults == null) {
/* 145 */       variantResults = new VariantTestResults(key, null);
/* 146 */       variants.put(key, variantResults);
/*     */     }
/*     */     
/* 149 */     variantResults.addTest(testResult);
/*     */   }
/*     */   
/*     */   private static String getVariantKey(String projectName, String flavorName) {
/* 153 */     if ("main".equalsIgnoreCase(flavorName)) {
/* 154 */       return projectName;
/*     */     }
/*     */     
/* 157 */     return projectName + ":" + flavorName;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.CompositeTestResults
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */