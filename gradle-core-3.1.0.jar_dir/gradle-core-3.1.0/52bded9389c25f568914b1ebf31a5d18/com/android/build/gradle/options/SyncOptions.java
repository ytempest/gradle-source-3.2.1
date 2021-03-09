/*    */ package com.android.build.gradle.options;
/*    */ 
/*    */ public final class SyncOptions
/*    */ {
/*    */   public static enum ErrorFormatMode
/*    */   {
/* 26 */     MACHINE_PARSABLE, 
/* 27 */     HUMAN_READABLE;
/*    */     
/*    */     private ErrorFormatMode() {}
/*    */   }
/*    */   
/* 32 */   public static enum EvaluationMode { STANDARD, 
/*    */     
/* 34 */     IDE;
/*    */     
/*    */     private EvaluationMode() {}
/*    */   }
/*    */   
/*    */   public static EvaluationMode getModelQueryMode(ProjectOptions options) {
/* 40 */     if (options.get(BooleanOption.IDE_BUILD_MODEL_ONLY_ADVANCED)) {
/* 41 */       return EvaluationMode.IDE;
/*    */     }
/*    */     
/* 44 */     return EvaluationMode.STANDARD;
/*    */   }
/*    */   
/*    */   public static ErrorFormatMode getErrorFormatMode(ProjectOptions options) {
/* 48 */     if (options.get(BooleanOption.IDE_INVOKED_FROM_IDE)) {
/* 49 */       return ErrorFormatMode.MACHINE_PARSABLE;
/*    */     }
/* 51 */     return ErrorFormatMode.HUMAN_READABLE;
/*    */   }
/*    */   
/*    */   public static Integer buildModelOnlyVersion(ProjectOptions options)
/*    */   {
/* 71 */     Integer revision = options.get(IntegerOption.IDE_BUILD_MODEL_ONLY_VERSION);
/* 72 */     if (revision != null) {
/* 73 */       return revision;
/*    */     }
/*    */     
/* 76 */     if (options.get(BooleanOption.IDE_BUILD_MODEL_ONLY_ADVANCED)) {
/* 77 */       return Integer.valueOf(1);
/*    */     }
/*    */     
/* 80 */     if (options.get(BooleanOption.IDE_BUILD_MODEL_ONLY)) {
/* 81 */       return Integer.valueOf(0);
/*    */     }
/*    */     
/* 84 */     return null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.SyncOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */