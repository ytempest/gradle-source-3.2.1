/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ public enum NativeBuildSystem
/*    */ {
/* 30 */   UNKNOWN("unknown"), 
/* 31 */   GRADLE("gradle"), 
/* 32 */   CMAKE("cmake"), 
/* 33 */   NDK_BUILD("ndkBuild");
/*    */   
/*    */   private final String name;
/*    */   
/*    */   private NativeBuildSystem(String name) {
/* 38 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 46 */     return name;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.NativeBuildSystem
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */