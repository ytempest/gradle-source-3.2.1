/*    */ package com.android.build.gradle.internal.coverage;
/*    */ 
/*    */ import javax.inject.Inject;
/*    */ 
/*    */ public class JacocoOptions
/*    */ {
/*    */   public static final String DEFAULT_VERSION = "0.7.9";
/* 33 */   private String version = "0.7.9";
/*    */   
/*    */   public String getVersion()
/*    */   {
/* 38 */     return version;
/*    */   }
/*    */   
/*    */   public void setVersion(String version)
/*    */   {
/* 43 */     this.version = version;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.coverage.JacocoOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */