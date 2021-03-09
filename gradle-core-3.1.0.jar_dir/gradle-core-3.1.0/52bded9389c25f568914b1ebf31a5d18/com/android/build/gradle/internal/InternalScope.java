/*    */ package com.android.build.gradle.internal;
/*    */ 
/*    */ import com.android.build.api.transform.QualifiedContent.ScopeType;
/*    */ 
/*    */ public enum InternalScope
/*    */   implements QualifiedContent.ScopeType
/*    */ {
/* 31 */   MAIN_SPLIT(65536), 
/*    */   
/* 37 */   LOCAL_DEPS(131072);
/*    */   
/*    */   private final int value;
/*    */   
/*    */   private InternalScope(int value)
/*    */   {
/* 43 */     this.value = value;
/*    */   }
/*    */   
/*    */   public int getValue()
/*    */   {
/* 48 */     return value;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.InternalScope
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */