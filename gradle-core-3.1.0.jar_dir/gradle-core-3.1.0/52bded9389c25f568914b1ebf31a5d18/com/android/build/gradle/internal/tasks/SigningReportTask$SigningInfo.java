/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ final class SigningReportTask$SigningInfo
/*     */ {
/*     */   String md5;
/*     */   String sha1;
/*     */   Date notAfter;
/*     */   String error;
/*     */   
/*     */   boolean isValid()
/*     */   {
/* 165 */     return (md5 != null) || (error != null);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.SigningReportTask.SigningInfo
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */