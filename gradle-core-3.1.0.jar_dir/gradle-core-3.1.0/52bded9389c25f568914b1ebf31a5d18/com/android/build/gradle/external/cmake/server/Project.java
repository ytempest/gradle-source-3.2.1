/*    */ package com.android.build.gradle.external.cmake.server;
/*    */ 
/*    */ public class Project
/*    */ {
/*    */   public final String buildDirectory;
/*    */   
/*    */   public final String name;
/*    */   
/*    */   public final String sourceDirectory;
/*    */   
/*    */   public final Target[] targets;
/*    */   
/*    */   private Project()
/*    */   {
/* 30 */     buildDirectory = null;
/* 31 */     name = null;
/* 32 */     sourceDirectory = null;
/* 33 */     targets = null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.Project
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */