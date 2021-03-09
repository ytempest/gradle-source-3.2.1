/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ public class ClassLookupException
/*    */   extends Exception
/*    */ {
/*    */   private final String mClassName;
/*    */   
/*    */   public ClassLookupException(String className)
/*    */   {
/* 28 */     mClassName = className;
/*    */   }
/*    */   
/*    */   public String getClassName() {
/* 32 */     return mClassName;
/*    */   }
/*    */   
/*    */   public String getMessage()
/*    */   {
/* 37 */     return "Invalid class reference: " + mClassName;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.ClassLookupException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */