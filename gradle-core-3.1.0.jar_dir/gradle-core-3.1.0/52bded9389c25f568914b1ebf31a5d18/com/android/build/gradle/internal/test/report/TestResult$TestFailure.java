/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ public class TestResult$TestFailure
/*     */ {
/*     */   private final String message;
/*     */   
/*     */   private final String stackTrace;
/*     */   
/*     */   private final String exceptionType;
/*     */   
/*     */   public TestResult$TestFailure(String message, String stackTrace, String exceptionType)
/*     */   {
/* 141 */     this.message = message;
/* 142 */     this.stackTrace = stackTrace;
/* 143 */     this.exceptionType = exceptionType;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/* 147 */     return message;
/*     */   }
/*     */   
/*     */   public String getStackTrace() {
/* 151 */     return stackTrace;
/*     */   }
/*     */   
/*     */   public String getExceptionType() {
/* 155 */     return exceptionType;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.TestResult.TestFailure
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */