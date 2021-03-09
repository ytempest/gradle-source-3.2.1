/*    */ package com.android.build.gradle.shrinker.parser;
/*    */ 
/*    */ public class KeepModifier
/*    */ {
/*    */   private static final int NONE = 0;
/*    */   
/*    */   private static final int ALLOW_SHRINKING = 1;
/*    */   
/*    */   private static final int ALLOW_OBFUSCATION = 2;
/*    */   
/* 29 */   private int modifier = 0;
/*    */   
/*    */   public boolean allowShrinking() {
/* 32 */     return (modifier & 0x1) == 1;
/*    */   }
/*    */   
/*    */   public boolean allowObfuscation() {
/* 36 */     return (modifier & 0x2) == 2;
/*    */   }
/*    */   
/*    */   public KeepModifier setAllowShrinking()
/*    */   {
/* 41 */     modifier |= 0x1;
/* 42 */     return this;
/*    */   }
/*    */   
/*    */   public KeepModifier setAllowObfuscation()
/*    */   {
/* 47 */     modifier |= 0x2;
/* 48 */     return this;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.KeepModifier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */