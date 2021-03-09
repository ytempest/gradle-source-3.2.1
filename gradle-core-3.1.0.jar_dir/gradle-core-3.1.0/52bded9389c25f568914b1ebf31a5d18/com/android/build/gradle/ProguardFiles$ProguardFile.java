/*    */ package com.android.build.gradle;
/*    */ 
/*    */ public enum ProguardFiles$ProguardFile
/*    */ {
/* 43 */   DONT_OPTIMIZE("proguard-android.txt"), 
/*    */   
/* 46 */   OPTIMIZE("proguard-android-optimize.txt"), 
/*    */   
/* 52 */   NO_ACTIONS("proguard-defaults.txt");
/*    */   
/*    */   public final String fileName;
/*    */   
/*    */   private ProguardFiles$ProguardFile(String fileName)
/*    */   {
/* 58 */     this.fileName = fileName;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.ProguardFiles.ProguardFile
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */