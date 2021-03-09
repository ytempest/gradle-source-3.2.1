/*    */ package com.android.build.gradle.external.cmake.server;
/*    */ 
/*    */ public class CacheResult
/*    */ {
/*    */   public final String type;
/*    */   
/*    */   public final String cookie;
/*    */   
/*    */   public final String inReplyTo;
/*    */   
/*    */   public final Cache[] cache;
/*    */   
/*    */   private CacheResult()
/*    */   {
/* 30 */     type = null;
/* 31 */     cookie = null;
/* 32 */     inReplyTo = null;
/* 33 */     cache = null;
/*    */   }
/*    */   
/*    */   public class Cache {
/* 37 */     public String key = null;
/* 38 */     public String type = null;
/* 39 */     public String value = null;
/*    */     
/*    */     public class Property {
/* 42 */       public String ADVANCED = null;
/* 43 */       public String HELPSTRING = null;
/*    */       
/*    */       public Property() {}
/*    */     }
/*    */     
/*    */     public Cache() {}
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.CacheResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */