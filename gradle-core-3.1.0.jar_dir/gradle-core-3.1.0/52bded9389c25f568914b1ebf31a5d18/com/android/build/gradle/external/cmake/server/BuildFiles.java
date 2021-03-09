/*    */ package com.android.build.gradle.external.cmake.server;
/*    */ 
/*    */ public class BuildFiles
/*    */ {
/*    */   public final boolean isCMake;
/*    */   
/*    */   public final boolean isTemporary;
/*    */   
/*    */   public final String[] sources;
/*    */   
/*    */   private BuildFiles()
/*    */   {
/* 31 */     isCMake = false;
/* 32 */     isTemporary = false;
/* 33 */     sources = null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.BuildFiles
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */