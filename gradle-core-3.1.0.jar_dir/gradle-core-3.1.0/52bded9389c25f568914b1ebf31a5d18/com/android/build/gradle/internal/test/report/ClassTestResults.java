/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ 
/*     */ class ClassTestResults
/*     */   extends CompositeTestResults
/*     */ {
/*     */   private final String name;
/*     */   private final PackageTestResults packageResults;
/*  31 */   private final Set<TestResult> results = new TreeSet();
/*  32 */   private final StringBuilder standardOutput = new StringBuilder();
/*  33 */   private final StringBuilder standardError = new StringBuilder();
/*     */   
/*     */   public ClassTestResults(String name, PackageTestResults packageResults) {
/*  36 */     super(packageResults);
/*  37 */     this.name = name;
/*  38 */     this.packageResults = packageResults;
/*     */   }
/*     */   
/*     */   public String getTitle()
/*     */   {
/*  43 */     return String.format("Class %s", new Object[] { name });
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  48 */     return name;
/*     */   }
/*     */   
/*     */   public String getSimpleName() {
/*  52 */     int pos = name.lastIndexOf(".");
/*  53 */     if (pos != -1) {
/*  54 */       return name.substring(pos + 1);
/*     */     }
/*  56 */     return name;
/*     */   }
/*     */   
/*     */   public PackageTestResults getPackageResults() {
/*  60 */     return packageResults;
/*     */   }
/*     */   
/*     */   public Map<String, Map<String, TestResult>> getTestResultsMap() {
/*  64 */     Map<String, Map<String, TestResult>> map = Maps.newHashMap();
/*  65 */     for (TestResult result : results) {
/*  66 */       String device = result.getDevice();
/*     */       
/*  68 */       Map<String, TestResult> deviceMap = (Map)map.get(device);
/*  69 */       if (deviceMap == null) {
/*  70 */         deviceMap = Maps.newHashMap();
/*  71 */         map.put(device, deviceMap);
/*     */       }
/*     */       
/*  74 */       deviceMap.put(result.getName(), result);
/*     */     }
/*     */     
/*  77 */     return map;
/*     */   }
/*     */   
/*     */   public CharSequence getStandardError() {
/*  81 */     return standardError;
/*     */   }
/*     */   
/*     */   public CharSequence getStandardOutput() {
/*  85 */     return standardOutput;
/*     */   }
/*     */   
/*     */   public TestResult addTest(String testName, long duration, String device, String project, String flavor)
/*     */   {
/*  90 */     TestResult test = new TestResult(testName, duration, device, project, flavor, this);
/*  91 */     results.add(test);
/*     */     
/*  93 */     addDevice(device, test);
/*  94 */     addVariant(project, flavor, test);
/*     */     
/*  96 */     return addTest(test);
/*     */   }
/*     */   
/*     */   public void addStandardOutput(String textContent) {
/* 100 */     standardOutput.append(textContent);
/*     */   }
/*     */   
/*     */   public void addStandardError(String textContent) {
/* 104 */     standardError.append(textContent);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.ClassTestResults
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */