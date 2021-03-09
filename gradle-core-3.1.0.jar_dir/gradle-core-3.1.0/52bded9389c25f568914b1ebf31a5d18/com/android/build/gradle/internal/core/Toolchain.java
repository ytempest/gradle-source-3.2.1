/*    */ package com.android.build.gradle.internal.core;
/*    */ 
/*    */ public enum Toolchain
/*    */ {
/* 26 */   GCC("gcc"), 
/* 27 */   CLANG("clang");
/*    */   
/*    */   private final String name;
/*    */   
/*    */   public static Toolchain getDefault()
/*    */   {
/* 34 */     return GCC;
/*    */   }
/*    */   
/*    */   public static Toolchain getByName(String toolchainName)
/*    */   {
/* 39 */     for (Toolchain toolchain : ) {
/* 40 */       if (name.equals(toolchainName)) {
/* 41 */         return toolchain;
/*    */       }
/*    */     }
/* 44 */     return null;
/*    */   }
/*    */   
/*    */   private Toolchain(String name) {
/* 48 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 53 */     return name;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.core.Toolchain
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */