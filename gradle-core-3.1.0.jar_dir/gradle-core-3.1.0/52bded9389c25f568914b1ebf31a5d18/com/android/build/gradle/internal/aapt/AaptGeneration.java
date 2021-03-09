/*    */ package com.android.build.gradle.internal.aapt;
/*    */ 
/*    */ import com.android.build.gradle.options.BooleanOption;
/*    */ import com.android.build.gradle.options.ProjectOptions;
/*    */ 
/*    */ public enum AaptGeneration
/*    */ {
/* 24 */   AAPT_V1, 
/* 25 */   AAPT_V2_DAEMON_MODE;
/*    */   
/*    */   private AaptGeneration() {}
/* 28 */   public static AaptGeneration fromProjectOptions(ProjectOptions projectOptions) { if (projectOptions.get(BooleanOption.ENABLE_AAPT2)) {
/* 29 */       return AAPT_V2_DAEMON_MODE;
/*    */     }
/* 31 */     return AAPT_V1;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.aapt.AaptGeneration
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */