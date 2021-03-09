/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import org.gradle.api.tasks.testing.TestResult.ResultType;
/*    */ 
/*    */ public abstract class TestResultModel
/*    */ {
/* 22 */   public static final DurationFormatter DURATION_FORMATTER = new DurationFormatter();
/*    */   
/*    */   public abstract TestResult.ResultType getResultType();
/*    */   
/*    */   public abstract long getDuration();
/*    */   
/*    */   public abstract String getTitle();
/*    */   
/*    */   public String getFormattedDuration() {
/* 31 */     return DURATION_FORMATTER.format(getDuration());
/*    */   }
/*    */   
/*    */   public String getStatusClass() {
/* 35 */     switch (getResultType()) {
/*    */     case SUCCESS: 
/* 37 */       return "success";
/*    */     case FAILURE: 
/* 39 */       return "failures";
/*    */     case SKIPPED: 
/* 41 */       return "skipped";
/*    */     }
/* 43 */     throw new IllegalStateException();
/*    */   }
/*    */   
/*    */   public String getFormattedResultType()
/*    */   {
/* 48 */     switch (getResultType()) {
/*    */     case SUCCESS: 
/* 50 */       return "passed";
/*    */     case FAILURE: 
/* 52 */       return "failed";
/*    */     case SKIPPED: 
/* 54 */       return "ignored";
/*    */     }
/* 56 */     throw new IllegalStateException();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.TestResultModel
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */