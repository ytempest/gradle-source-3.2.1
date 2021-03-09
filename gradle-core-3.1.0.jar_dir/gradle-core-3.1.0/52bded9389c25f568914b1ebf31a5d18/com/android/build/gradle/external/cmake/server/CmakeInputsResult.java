/*    */ package com.android.build.gradle.external.cmake.server;
/*    */ 
/*    */ public class CmakeInputsResult
/*    */ {
/*    */   public final BuildFiles[] buildFiles;
/*    */   
/*    */   public final String cmakeRootDirectory;
/*    */   
/*    */   public final String sourceDirectory;
/*    */   
/*    */   public final String cookie;
/*    */   
/*    */   public final String inReplyTo;
/*    */   
/*    */   public final String type;
/*    */   
/*    */   private CmakeInputsResult()
/*    */   {
/* 35 */     buildFiles = null;
/* 36 */     cmakeRootDirectory = null;
/* 37 */     sourceDirectory = null;
/* 38 */     cookie = null;
/* 39 */     inReplyTo = null;
/* 40 */     type = null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.CmakeInputsResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */