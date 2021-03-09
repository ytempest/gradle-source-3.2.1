/*    */ package com.android.build.gradle.external.cmake.server.receiver;
/*    */ 
/*    */ public class InteractiveMessage
/*    */ {
/*    */   public final String type;
/*    */   
/*    */   public final String cookie;
/*    */   
/*    */   public final String inReplyTo;
/*    */   
/*    */   public final String message;
/*    */   
/*    */   public final String errorMessage;
/*    */   
/*    */   public final String title;
/*    */   
/*    */   private InteractiveMessage()
/*    */   {
/* 32 */     type = null;
/* 33 */     cookie = null;
/* 34 */     inReplyTo = null;
/* 35 */     message = null;
/* 36 */     errorMessage = null;
/* 37 */     title = null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.receiver.InteractiveMessage
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */