/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.gradle.api.tasks.testing.TestResult.ResultType;
/*     */ 
/*     */ class TestResult
/*     */   extends TestResultModel
/*     */   implements Comparable<TestResult>
/*     */ {
/*     */   private final long duration;
/*     */   private final String device;
/*     */   private final String project;
/*     */   private final String flavor;
/*     */   final ClassTestResults classResults;
/*  33 */   final List<TestFailure> failures = new ArrayList();
/*     */   final String name;
/*     */   private boolean ignored;
/*     */   
/*     */   public TestResult(String name, long duration, String device, String project, String flavor, ClassTestResults classResults)
/*     */   {
/*  39 */     this.name = name;
/*  40 */     this.duration = duration;
/*  41 */     this.device = device;
/*  42 */     this.project = project;
/*  43 */     this.flavor = flavor;
/*  44 */     this.classResults = classResults;
/*     */   }
/*     */   
/*     */   public Object getId() {
/*  48 */     return name;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  52 */     return name;
/*     */   }
/*     */   
/*     */   public String getDevice() {
/*  56 */     return device;
/*     */   }
/*     */   
/*     */   public String getProject() {
/*  60 */     return project;
/*     */   }
/*     */   
/*     */   public String getFlavor() {
/*  64 */     return flavor;
/*     */   }
/*     */   
/*     */   public String getTitle()
/*     */   {
/*  69 */     return String.format("Test %s", new Object[] { name });
/*     */   }
/*     */   
/*     */   public TestResult.ResultType getResultType()
/*     */   {
/*  74 */     if (ignored) {
/*  75 */       return TestResult.ResultType.SKIPPED;
/*     */     }
/*  77 */     return failures.isEmpty() ? TestResult.ResultType.SUCCESS : TestResult.ResultType.FAILURE;
/*     */   }
/*     */   
/*     */   public long getDuration()
/*     */   {
/*  82 */     return duration;
/*     */   }
/*     */   
/*     */   public String getFormattedDuration()
/*     */   {
/*  87 */     return ignored ? "-" : super.getFormattedDuration();
/*     */   }
/*     */   
/*     */   public ClassTestResults getClassResults() {
/*  91 */     return classResults;
/*     */   }
/*     */   
/*     */   public List<TestFailure> getFailures() {
/*  95 */     return failures;
/*     */   }
/*     */   
/*     */   public void addFailure(String message, String stackTrace, String deviceName, String projectName, String flavorName)
/*     */   {
/* 100 */     classResults.failed(this, deviceName, projectName, flavorName);
/* 101 */     failures.add(new TestFailure(message, stackTrace, null));
/*     */   }
/*     */   
/*     */   public void ignored() {
/* 105 */     ignored = true;
/*     */   }
/*     */   
/*     */   public int compareTo(TestResult testResult)
/*     */   {
/* 110 */     int diff = classResults.getName().compareTo(classResults.getName());
/* 111 */     if (diff != 0) {
/* 112 */       return diff;
/*     */     }
/*     */     
/* 115 */     diff = name.compareTo(name);
/* 116 */     if (diff != 0) {
/* 117 */       return diff;
/*     */     }
/*     */     
/* 120 */     diff = device.compareTo(device);
/* 121 */     if (diff != 0) {
/* 122 */       return diff;
/*     */     }
/*     */     
/* 125 */     diff = flavor.compareTo(flavor);
/* 126 */     if (diff != 0) {
/* 127 */       return diff;
/*     */     }
/*     */     
/* 130 */     Integer thisIdentity = Integer.valueOf(System.identityHashCode(this));
/* 131 */     int otherIdentity = System.identityHashCode(testResult);
/* 132 */     return thisIdentity.compareTo(Integer.valueOf(otherIdentity));
/*     */   }
/*     */   
/*     */   public static class TestFailure {
/*     */     private final String message;
/*     */     private final String stackTrace;
/*     */     private final String exceptionType;
/*     */     
/*     */     public TestFailure(String message, String stackTrace, String exceptionType) {
/* 141 */       this.message = message;
/* 142 */       this.stackTrace = stackTrace;
/* 143 */       this.exceptionType = exceptionType;
/*     */     }
/*     */     
/*     */     public String getMessage() {
/* 147 */       return message;
/*     */     }
/*     */     
/*     */     public String getStackTrace() {
/* 151 */       return stackTrace;
/*     */     }
/*     */     
/*     */     public String getExceptionType() {
/* 155 */       return exceptionType;
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.TestResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */