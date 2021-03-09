/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.instantapp.run.InstantAppRunException;
/*     */ import com.android.instantapp.run.RunListener;
/*     */ import org.gradle.api.logging.Logger;
/*     */ 
/*     */ class InstantAppSideLoadTask$1
/*     */   implements RunListener
/*     */ {
/*     */   InstantAppSideLoadTask$1(InstantAppSideLoadTask this$0) {}
/*     */   
/*     */   public void printMessage(String message)
/*     */   {
/*  92 */     this$0.getLogger().info(message);
/*     */   }
/*     */   
/*     */   public void logMessage(String message, InstantAppRunException e)
/*     */   {
/*  98 */     if (e == null) {
/*  99 */       this$0.getLogger().debug(message);
/*     */     } else {
/* 101 */       this$0.getLogger().debug(message, e);
/* 102 */       this$0.getLogger().error(message, e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setProgress(double fraction) {}
/*     */   
/*     */   public boolean isCancelled()
/*     */   {
/* 111 */     return false;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.InstantAppSideLoadTask.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */