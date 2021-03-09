/*    */ package com.android.build.gradle.external.cmake.server;
/*    */ 
/*    */ public class HandshakeRequest
/*    */ {
/*    */   public final String type;
/*    */   
/*    */   public String cookie;
/*    */   
/*    */   public ProtocolVersion protocolVersion;
/*    */   
/*    */   public String sourceDirectory;
/*    */   
/*    */   public String buildDirectory;
/*    */   
/*    */   public String generator;
/*    */   
/*    */   public HandshakeRequest()
/*    */   {
/* 32 */     type = "handshake";
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.HandshakeRequest
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */