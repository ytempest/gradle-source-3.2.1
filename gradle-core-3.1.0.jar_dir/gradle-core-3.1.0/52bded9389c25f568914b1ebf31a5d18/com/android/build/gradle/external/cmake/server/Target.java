/*    */ package com.android.build.gradle.external.cmake.server;
/*    */ 
/*    */ public class Target
/*    */ {
/*    */   public final String[] artifacts;
/*    */   
/*    */   public final String buildDirectory;
/*    */   
/*    */   public final FileGroup[] fileGroups;
/*    */   
/*    */   public final String fullName;
/*    */   
/*    */   public final String linkLibraries;
/*    */   
/*    */   public final String linkerLanguage;
/*    */   
/*    */   public final String name;
/*    */   
/*    */   public final String sourceDirectory;
/*    */   
/*    */   public final String type;
/*    */   
/*    */   public final String linkFlags;
/*    */   
/*    */   public final String sysroot;
/*    */   
/*    */   private Target()
/*    */   {
/* 37 */     artifacts = null;
/* 38 */     buildDirectory = null;
/* 39 */     fileGroups = null;
/* 40 */     fullName = null;
/* 41 */     linkLibraries = null;
/* 42 */     linkerLanguage = null;
/* 43 */     name = null;
/* 44 */     type = null;
/* 45 */     sourceDirectory = null;
/* 46 */     linkFlags = null;
/* 47 */     sysroot = null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.Target
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */