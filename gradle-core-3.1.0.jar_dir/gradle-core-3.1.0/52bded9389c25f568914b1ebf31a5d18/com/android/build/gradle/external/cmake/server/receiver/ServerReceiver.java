/*    */ package com.android.build.gradle.external.cmake.server.receiver;
/*    */ 
/*    */ public class ServerReceiver
/*    */ {
/* 26 */   private ProgressReceiver progressReceiver = null;
/* 27 */   private MessageReceiver messageReceiver = null;
/* 28 */   private SignalReceiver signalReceiver = null;
/* 29 */   private DiagnosticReceiver diagnosticReceiver = null;
/* 30 */   private DeserializationMonitor deserializationMonitor = null;
/*    */   
/*    */   public ProgressReceiver getProgressReceiver()
/*    */   {
/* 34 */     return progressReceiver;
/*    */   }
/*    */   
/*    */   public ServerReceiver setProgressReceiver(ProgressReceiver progressReceiver) {
/* 38 */     this.progressReceiver = progressReceiver;
/* 39 */     return this;
/*    */   }
/*    */   
/*    */   public MessageReceiver getMessageReceiver()
/*    */   {
/* 44 */     return messageReceiver;
/*    */   }
/*    */   
/*    */   public ServerReceiver setMessageReceiver(MessageReceiver messageReceiver) {
/* 48 */     this.messageReceiver = messageReceiver;
/* 49 */     return this;
/*    */   }
/*    */   
/*    */   public SignalReceiver getSignalReceiver()
/*    */   {
/* 54 */     return signalReceiver;
/*    */   }
/*    */   
/*    */   public ServerReceiver setSignalReceiver(SignalReceiver signalReceiver) {
/* 58 */     this.signalReceiver = signalReceiver;
/* 59 */     return this;
/*    */   }
/*    */   
/*    */   public DiagnosticReceiver getDiagnosticReceiver()
/*    */   {
/* 64 */     return diagnosticReceiver;
/*    */   }
/*    */   
/*    */   public ServerReceiver setDiagnosticReceiver(DiagnosticReceiver diagnosticReceiver) {
/* 68 */     this.diagnosticReceiver = diagnosticReceiver;
/* 69 */     return this;
/*    */   }
/*    */   
/*    */   public DeserializationMonitor getDeserializationMonitor()
/*    */   {
/* 74 */     return deserializationMonitor;
/*    */   }
/*    */   
/*    */   public ServerReceiver setDeserializationMonitor(DeserializationMonitor deserializationMonitor)
/*    */   {
/* 79 */     this.deserializationMonitor = deserializationMonitor;
/* 80 */     return this;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.receiver.ServerReceiver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */