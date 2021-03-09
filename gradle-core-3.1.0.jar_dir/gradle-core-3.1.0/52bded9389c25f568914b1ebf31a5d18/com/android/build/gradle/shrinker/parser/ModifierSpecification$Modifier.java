/*    */ package com.android.build.gradle.shrinker.parser;
/*    */ 
/*    */ public enum ModifierSpecification$Modifier
/*    */ {
/* 59 */   STATIC(8), 
/* 60 */   FINAL(16), 
/* 61 */   SUPER(32), 
/* 62 */   SYNCHRONIZED(32), 
/* 63 */   VOLATILE(64), 
/* 64 */   BRIDGE(64), 
/* 65 */   TRANSIENT(128), 
/* 66 */   VARARGS(128), 
/* 67 */   NATIVE(256), 
/* 68 */   INTERFACE(512), 
/* 69 */   ABSTRACT(1024), 
/* 70 */   STRICTFP(2048), 
/* 71 */   SYNTHETIC(4096), 
/* 72 */   ANNOTATION(8192), 
/* 73 */   ENUM(16384);
/*    */   
/*    */   private final int value;
/*    */   
/*    */   private ModifierSpecification$Modifier(int value) {
/* 78 */     this.value = value;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.ModifierSpecification.Modifier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */