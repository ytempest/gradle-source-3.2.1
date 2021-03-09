/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ final class ClassPageRenderer$TestPercent
/*     */ {
/*     */   int failed;
/*     */   
/*     */   int total;
/*     */   
/*     */   ClassPageRenderer$TestPercent(int failed, int total)
/*     */   {
/* 147 */     this.failed = failed;
/* 148 */     this.total = total;
/*     */   }
/*     */   
/*     */   boolean isFullFailure() {
/* 152 */     return failed == total;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.ClassPageRenderer.TestPercent
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */