/*    */ package com.android.build.gradle.external.cmake.server;
/*    */ 
/*    */ public class ConfigureCommandResult
/*    */ {
/*    */   public final ConfigureResult configureResult;
/*    */   
/*    */   public final String interactiveMessages;
/*    */   
/*    */   public ConfigureCommandResult(ConfigureResult configureResult, String interactiveMessages)
/*    */   {
/* 28 */     this.configureResult = configureResult;
/* 29 */     this.interactiveMessages = interactiveMessages;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.ConfigureCommandResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */