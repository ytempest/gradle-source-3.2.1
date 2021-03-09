/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ public enum InstantRunBuildMode
/*    */ {
/* 25 */   HOT_WARM, 
/*    */   
/* 36 */   COLD, 
/*    */   
/* 49 */   FULL;
/*    */   
/*    */   private InstantRunBuildMode() {}
/* 52 */   public InstantRunBuildMode combine(InstantRunBuildMode other) { return values()[Math.max(ordinal(), other.ordinal())]; }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunBuildMode
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */