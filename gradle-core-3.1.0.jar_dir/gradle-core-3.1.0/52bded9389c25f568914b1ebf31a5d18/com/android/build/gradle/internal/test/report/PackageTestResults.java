/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import java.util.TreeMap;
/*    */ 
/*    */ class PackageTestResults
/*    */   extends CompositeTestResults
/*    */ {
/*    */   private static final String DEFAULT_PACKAGE = "default-package";
/*    */   private final String name;
/* 29 */   private final Map<String, ClassTestResults> classes = new TreeMap();
/*    */   
/*    */   public PackageTestResults(String name, AllTestResults model) {
/* 32 */     super(model);
/* 33 */     this.name = (name.isEmpty() ? "default-package" : name);
/*    */   }
/*    */   
/*    */   public String getTitle()
/*    */   {
/* 38 */     return name.equals("default-package") ? "Default package" : String.format("Package %s", new Object[] { name });
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 43 */     return name;
/*    */   }
/*    */   
/*    */   public Collection<ClassTestResults> getClasses() {
/* 47 */     return classes.values();
/*    */   }
/*    */   
/*    */   public TestResult addTest(String className, String testName, long duration, String device, String project, String flavor)
/*    */   {
/* 52 */     ClassTestResults classResults = addClass(className);
/* 53 */     TestResult testResult = addTest(classResults
/* 54 */       .addTest(testName, duration, device, project, flavor));
/*    */     
/* 56 */     addDevice(device, testResult);
/* 57 */     addVariant(project, flavor, testResult);
/*    */     
/* 59 */     return testResult;
/*    */   }
/*    */   
/*    */   public ClassTestResults addClass(String className) {
/* 63 */     ClassTestResults classResults = (ClassTestResults)classes.get(className);
/* 64 */     if (classResults == null) {
/* 65 */       classResults = new ClassTestResults(className, this);
/* 66 */       classes.put(className, classResults);
/*    */     }
/* 68 */     return classResults;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.PackageTestResults
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */