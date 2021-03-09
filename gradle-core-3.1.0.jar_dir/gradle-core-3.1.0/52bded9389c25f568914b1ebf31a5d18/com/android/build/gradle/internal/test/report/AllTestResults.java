/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import java.util.TreeMap;
/*    */ 
/*    */ class AllTestResults
/*    */   extends CompositeTestResults
/*    */ {
/* 28 */   private final Map<String, PackageTestResults> packages = new TreeMap();
/*    */   
/*    */   public AllTestResults() {
/* 31 */     super(null);
/*    */   }
/*    */   
/*    */   public String getTitle()
/*    */   {
/* 36 */     return "Test Summary";
/*    */   }
/*    */   
/*    */   public Collection<PackageTestResults> getPackages() {
/* 40 */     return packages.values();
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 45 */     return null;
/*    */   }
/*    */   
/*    */   public TestResult addTest(String className, String testName, long duration, String device, String project, String flavor)
/*    */   {
/* 50 */     PackageTestResults packageResults = addPackageForClass(className);
/* 51 */     TestResult testResult = addTest(packageResults
/* 52 */       .addTest(className, testName, duration, device, project, flavor));
/*    */     
/* 54 */     addDevice(device, testResult);
/* 55 */     addVariant(project, flavor, testResult);
/*    */     
/* 57 */     return testResult;
/*    */   }
/*    */   
/*    */   public ClassTestResults addTestClass(String className) {
/* 61 */     return addPackageForClass(className).addClass(className);
/*    */   }
/*    */   
/*    */   private PackageTestResults addPackageForClass(String className)
/*    */   {
/* 66 */     int pos = className.lastIndexOf(".");
/* 67 */     String packageName; String packageName; if (pos != -1) {
/* 68 */       packageName = className.substring(0, pos);
/*    */     } else {
/* 70 */       packageName = "";
/*    */     }
/* 72 */     return addPackage(packageName);
/*    */   }
/*    */   
/*    */   private PackageTestResults addPackage(String packageName)
/*    */   {
/* 77 */     PackageTestResults packageResults = (PackageTestResults)packages.get(packageName);
/* 78 */     if (packageResults == null) {
/* 79 */       packageResults = new PackageTestResults(packageName, this);
/* 80 */       packages.put(packageName, packageResults);
/*    */     }
/* 82 */     return packageResults;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.AllTestResults
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */