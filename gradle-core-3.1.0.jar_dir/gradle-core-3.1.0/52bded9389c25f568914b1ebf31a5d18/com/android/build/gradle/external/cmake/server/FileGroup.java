/*    */ package com.android.build.gradle.external.cmake.server;
/*    */ 
/*    */ public class FileGroup
/*    */ {
/*    */   public final String compileFlags;
/*    */   
/*    */   public final Boolean isGenerated;
/*    */   
/*    */   public final String language;
/*    */   
/*    */   public final String[] sources;
/*    */   
/*    */   public final String[] defines;
/*    */   
/*    */   public final IncludePath[] includePath;
/*    */   
/*    */   private FileGroup()
/*    */   {
/* 32 */     compileFlags = null;
/* 33 */     isGenerated = null;
/* 34 */     language = null;
/* 35 */     sources = null;
/* 36 */     defines = null;
/* 37 */     includePath = null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.FileGroup
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */