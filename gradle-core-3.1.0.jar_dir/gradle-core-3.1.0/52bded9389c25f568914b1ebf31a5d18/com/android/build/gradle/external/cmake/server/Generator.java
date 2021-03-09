/*    */ package com.android.build.gradle.external.cmake.server;
/*    */ 
/*    */ public class Generator
/*    */ {
/*    */   public final String name;
/*    */   
/*    */   public final Boolean platformSupport;
/*    */   
/*    */   public final Boolean toolsetSupport;
/*    */   
/*    */   public final String[] extraGenerators;
/*    */   
/*    */   private Generator()
/*    */   {
/* 31 */     name = null;
/* 32 */     platformSupport = null;
/* 33 */     toolsetSupport = null;
/* 34 */     extraGenerators = null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.Generator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */