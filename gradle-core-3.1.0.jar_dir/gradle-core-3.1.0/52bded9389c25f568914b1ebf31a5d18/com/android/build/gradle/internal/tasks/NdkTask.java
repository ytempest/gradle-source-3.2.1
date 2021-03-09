/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.dsl.CoreNdkOptions;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import org.gradle.api.tasks.Input;
/*    */ import org.gradle.api.tasks.Optional;
/*    */ 
/*    */ public class NdkTask
/*    */   extends AndroidBuilderTask
/*    */ {
/*    */   private CoreNdkOptions ndkConfig;
/*    */   
/*    */   public CoreNdkOptions getNdkConfig()
/*    */   {
/* 34 */     return ndkConfig;
/*    */   }
/*    */   
/* 38 */   public void setNdkConfig(CoreNdkOptions ndkConfig) { this.ndkConfig = ndkConfig; }
/*    */   
/*    */   @Input
/*    */   @Optional
/*    */   public String getModuleName() {
/* 43 */     if (getNdkConfig() == null) {
/* 44 */       return null;
/*    */     }
/* 46 */     return getNdkConfig().getModuleName();
/*    */   }
/*    */   
/*    */   @Input
/*    */   @Optional
/* 51 */   public String getcFlags() { if (getNdkConfig() == null) {
/* 52 */       return null;
/*    */     }
/* 54 */     return getNdkConfig().getcFlags();
/*    */   }
/*    */   
/*    */   @Input
/*    */   @Optional
/* 59 */   public List<String> getLdLibs() { if (getNdkConfig() == null) {
/* 60 */       return null;
/*    */     }
/* 62 */     return getNdkConfig().getLdLibs();
/*    */   }
/*    */   
/*    */   @Input
/*    */   @Optional
/* 67 */   public Set<String> getAbiFilters() { if (getNdkConfig() == null) {
/* 68 */       return null;
/*    */     }
/* 70 */     return getNdkConfig().getAbiFilters();
/*    */   }
/*    */   
/*    */   @Input
/*    */   @Optional
/* 75 */   public String getStl() { if (getNdkConfig() == null) {
/* 76 */       return null;
/*    */     }
/* 78 */     return getNdkConfig().getStl();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.NdkTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */