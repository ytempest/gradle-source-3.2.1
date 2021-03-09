/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import javax.inject.Inject;
/*    */ 
/*    */ public class DataBindingOptions
/*    */   implements com.android.builder.model.DataBindingOptions
/*    */ {
/*    */   private String version;
/* 26 */   private boolean enabled = false;
/* 27 */   private boolean addDefaultAdapters = true;
/* 28 */   private boolean enabledForTests = false;
/*    */   
/*    */   public String getVersion()
/*    */   {
/* 38 */     return version;
/*    */   }
/*    */   
/*    */   public void setVersion(String version) {
/* 42 */     this.version = version;
/*    */   }
/*    */   
/*    */   public boolean isEnabled()
/*    */   {
/* 50 */     return enabled;
/*    */   }
/*    */   
/*    */   public void setEnabled(boolean enabled) {
/* 54 */     this.enabled = enabled;
/*    */   }
/*    */   
/*    */   public boolean getAddDefaultAdapters()
/*    */   {
/* 62 */     return addDefaultAdapters;
/*    */   }
/*    */   
/*    */   public void setAddDefaultAdapters(boolean addDefaultAdapters) {
/* 66 */     this.addDefaultAdapters = addDefaultAdapters;
/*    */   }
/*    */   
/*    */   public boolean isEnabledForTests()
/*    */   {
/* 74 */     return enabledForTests;
/*    */   }
/*    */   
/*    */   public void setEnabledForTests(boolean enabledForTests) {
/* 78 */     this.enabledForTests = enabledForTests;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.DataBindingOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */