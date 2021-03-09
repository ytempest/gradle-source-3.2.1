/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
/*    */ 
/*    */ public class AdbOptions
/*    */   implements com.android.builder.model.AdbOptions
/*    */ {
/*    */   int timeOutInMs;
/*    */   List<String> installOptions;
/*    */   
/*    */   public int getTimeOutInMs()
/*    */   {
/* 41 */     return timeOutInMs;
/*    */   }
/*    */   
/*    */   public void setTimeOutInMs(int timeOutInMs) {
/* 45 */     this.timeOutInMs = timeOutInMs;
/*    */   }
/*    */   
/*    */   public void timeOutInMs(int timeOutInMs) {
/* 49 */     setTimeOutInMs(timeOutInMs);
/*    */   }
/*    */   
/*    */   public Collection<String> getInstallOptions()
/*    */   {
/* 55 */     return installOptions;
/*    */   }
/*    */   
/*    */   public void setInstallOptions(String option) {
/* 59 */     installOptions = ImmutableList.of(option);
/*    */   }
/*    */   
/*    */   public void setInstallOptions(String... options) {
/* 63 */     installOptions = ImmutableList.copyOf(options);
/*    */   }
/*    */   
/*    */   public void installOptions(String option) {
/* 67 */     installOptions = ImmutableList.of(option);
/*    */   }
/*    */   
/*    */   public void installOptions(String... options) {
/* 71 */     installOptions = ImmutableList.copyOf(options);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.AdbOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */