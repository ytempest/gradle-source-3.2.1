/*    */ package com.android.build.gradle.shrinker.parser;
/*    */ 
/*    */ public class ProguardParserException
/*    */   extends RuntimeException
/*    */ {
/*    */   public ProguardParserException(String message)
/*    */   {
/* 22 */     super("ProGuard configuration parser error: " + message);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.ProguardParserException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */