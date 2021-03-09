/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ public enum IncrementalVisitor$AccessRight
/*    */ {
/* 86 */   PRIVATE,  PACKAGE_PRIVATE,  PROTECTED,  PUBLIC;
/*    */   
/*    */   private IncrementalVisitor$AccessRight() {}
/*    */   
/* 90 */   static AccessRight fromNodeAccess(int nodeAccess) { if ((nodeAccess & 0x2) != 0) return PRIVATE;
/* 91 */     if ((nodeAccess & 0x4) != 0) return PROTECTED;
/* 92 */     if ((nodeAccess & 0x1) != 0) return PUBLIC;
/* 93 */     return PACKAGE_PRIVATE;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalVisitor.AccessRight
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */