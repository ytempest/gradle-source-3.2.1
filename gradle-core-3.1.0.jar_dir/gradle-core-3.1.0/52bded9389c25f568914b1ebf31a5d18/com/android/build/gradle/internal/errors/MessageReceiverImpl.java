/*    */ package com.android.build.gradle.internal.errors;
/*    */ 
/*    */ import com.android.build.gradle.options.ProjectOptions;
/*    */ import com.android.build.gradle.options.SyncOptions;
/*    */ import com.android.build.gradle.options.SyncOptions.ErrorFormatMode;
/*    */ import com.android.ide.common.blame.Message;
/*    */ import com.android.ide.common.blame.MessageJsonSerializer;
/*    */ import com.android.ide.common.blame.MessageReceiver;
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.GsonBuilder;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.logging.Logger;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0008\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020\002\n\000\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\020\020\f\032\0020\r2\006\020\016\032\0020\017H\002J\020\020\020\032\0020\0212\006\020\016\032\0020\017H\026R\026\020\007\032\n \t*\004\030\0010\b0\bX\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000R\020\020\n\032\004\030\0010\013X\004¢\006\002\n\000¨\006\022"}, d2={"Lcom/android/build/gradle/internal/errors/MessageReceiverImpl;", "Lcom/android/ide/common/blame/MessageReceiver;", "projectOptions", "Lcom/android/build/gradle/options/ProjectOptions;", "logger", "Lorg/gradle/api/logging/Logger;", "(Lcom/android/build/gradle/options/ProjectOptions;Lorg/gradle/api/logging/Logger;)V", "errorFormatMode", "Lcom/android/build/gradle/options/SyncOptions$ErrorFormatMode;", "kotlin.jvm.PlatformType", "mGson", "Lcom/google/gson/Gson;", "machineReadableMessage", "", "message", "Lcom/android/ide/common/blame/Message;", "receiveMessage", "", "gradle-core"})
/*    */ public final class MessageReceiverImpl
/*    */   implements MessageReceiver
/*    */ {
/*    */   private final SyncOptions.ErrorFormatMode errorFormatMode;
/*    */   private final Gson mGson;
/*    */   private final Logger logger;
/*    */   
/*    */   public MessageReceiverImpl(@NotNull ProjectOptions projectOptions, @NotNull Logger logger)
/*    */   {
/* 34 */     this.logger = logger;
/*    */     
/* 38 */     errorFormatMode = SyncOptions.getErrorFormatMode(projectOptions);
/*    */     
/* 44 */     GsonBuilder gsonBuilder = new GsonBuilder();
/* 45 */     MessageJsonSerializer.registerTypeAdapters(gsonBuilder);mGson = (Intrinsics.areEqual(errorFormatMode, SyncOptions.ErrorFormatMode.MACHINE_PARSABLE) ? 
/* 46 */       gsonBuilder.create() : 
/*    */       
/* 48 */       null);
/*    */   }
/*    */   
/*    */   private final String machineReadableMessage(Message message)
/*    */   {
/* 75 */     Gson tmp16_13 = mGson;
/*    */     
/* 75 */     if (tmp16_13 == null) Intrinsics.throwNpe(); return "AGPBI: " + tmp16_13.toJson(message);
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public void receiveMessage(@NotNull Message message)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 15
/*    */     //   3: invokestatic 21	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_1
/*    */     //   7: invokevirtual 27	com/android/ide/common/blame/Message:getKind	()Lcom/android/ide/common/blame/Message$Kind;
/*    */     //   10: dup
/*    */     //   11: ifnonnull +7 -> 18
/*    */     //   14: pop
/*    */     //   15: goto +202 -> 217
/*    */     //   18: getstatic 33	com/android/build/gradle/internal/errors/MessageReceiverImpl$WhenMappings:$EnumSwitchMapping$0	[I
/*    */     //   21: swap
/*    */     //   22: invokevirtual 39	com/android/ide/common/blame/Message$Kind:ordinal	()I
/*    */     //   25: iaload
/*    */     //   26: tableswitch	default:+191->217, 1:+38->64, 2:+84->110, 3:+130->156, 4:+146->172, 5:+162->188, 6:+178->204
/*    */     //   64: aload_0
/*    */     //   65: getfield 41	com/android/build/gradle/internal/errors/MessageReceiverImpl:errorFormatMode	Lcom/android/build/gradle/options/SyncOptions$ErrorFormatMode;
/*    */     //   68: getstatic 46	com/android/build/gradle/options/SyncOptions$ErrorFormatMode:MACHINE_PARSABLE	Lcom/android/build/gradle/options/SyncOptions$ErrorFormatMode;
/*    */     //   71: invokestatic 50	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
/*    */     //   74: ifeq +20 -> 94
/*    */     //   77: aload_0
/*    */     //   78: getfield 54	com/android/build/gradle/internal/errors/MessageReceiverImpl:logger	Lorg/gradle/api/logging/Logger;
/*    */     //   81: aload_0
/*    */     //   82: aload_1
/*    */     //   83: invokespecial 58	com/android/build/gradle/internal/errors/MessageReceiverImpl:machineReadableMessage	(Lcom/android/ide/common/blame/Message;)Ljava/lang/String;
/*    */     //   86: invokeinterface 64 2 0
/*    */     //   91: goto +16 -> 107
/*    */     //   94: aload_0
/*    */     //   95: getfield 54	com/android/build/gradle/internal/errors/MessageReceiverImpl:logger	Lorg/gradle/api/logging/Logger;
/*    */     //   98: aload_1
/*    */     //   99: invokestatic 69	com/android/build/gradle/internal/errors/MessageReceiverImplKt:access$humanReadableMessage	(Lcom/android/ide/common/blame/Message;)Ljava/lang/String;
/*    */     //   102: invokeinterface 64 2 0
/*    */     //   107: goto +110 -> 217
/*    */     //   110: aload_0
/*    */     //   111: getfield 41	com/android/build/gradle/internal/errors/MessageReceiverImpl:errorFormatMode	Lcom/android/build/gradle/options/SyncOptions$ErrorFormatMode;
/*    */     //   114: getstatic 46	com/android/build/gradle/options/SyncOptions$ErrorFormatMode:MACHINE_PARSABLE	Lcom/android/build/gradle/options/SyncOptions$ErrorFormatMode;
/*    */     //   117: invokestatic 50	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
/*    */     //   120: ifeq +20 -> 140
/*    */     //   123: aload_0
/*    */     //   124: getfield 54	com/android/build/gradle/internal/errors/MessageReceiverImpl:logger	Lorg/gradle/api/logging/Logger;
/*    */     //   127: aload_0
/*    */     //   128: aload_1
/*    */     //   129: invokespecial 58	com/android/build/gradle/internal/errors/MessageReceiverImpl:machineReadableMessage	(Lcom/android/ide/common/blame/Message;)Ljava/lang/String;
/*    */     //   132: invokeinterface 72 2 0
/*    */     //   137: goto +16 -> 153
/*    */     //   140: aload_0
/*    */     //   141: getfield 54	com/android/build/gradle/internal/errors/MessageReceiverImpl:logger	Lorg/gradle/api/logging/Logger;
/*    */     //   144: aload_1
/*    */     //   145: invokestatic 69	com/android/build/gradle/internal/errors/MessageReceiverImplKt:access$humanReadableMessage	(Lcom/android/ide/common/blame/Message;)Ljava/lang/String;
/*    */     //   148: invokeinterface 72 2 0
/*    */     //   153: goto +64 -> 217
/*    */     //   156: aload_0
/*    */     //   157: getfield 54	com/android/build/gradle/internal/errors/MessageReceiverImpl:logger	Lorg/gradle/api/logging/Logger;
/*    */     //   160: aload_1
/*    */     //   161: invokestatic 69	com/android/build/gradle/internal/errors/MessageReceiverImplKt:access$humanReadableMessage	(Lcom/android/ide/common/blame/Message;)Ljava/lang/String;
/*    */     //   164: invokeinterface 75 2 0
/*    */     //   169: goto +48 -> 217
/*    */     //   172: aload_0
/*    */     //   173: getfield 54	com/android/build/gradle/internal/errors/MessageReceiverImpl:logger	Lorg/gradle/api/logging/Logger;
/*    */     //   176: aload_1
/*    */     //   177: invokestatic 69	com/android/build/gradle/internal/errors/MessageReceiverImplKt:access$humanReadableMessage	(Lcom/android/ide/common/blame/Message;)Ljava/lang/String;
/*    */     //   180: invokeinterface 78 2 0
/*    */     //   185: goto +32 -> 217
/*    */     //   188: aload_0
/*    */     //   189: getfield 54	com/android/build/gradle/internal/errors/MessageReceiverImpl:logger	Lorg/gradle/api/logging/Logger;
/*    */     //   192: aload_1
/*    */     //   193: invokestatic 69	com/android/build/gradle/internal/errors/MessageReceiverImplKt:access$humanReadableMessage	(Lcom/android/ide/common/blame/Message;)Ljava/lang/String;
/*    */     //   196: invokeinterface 72 2 0
/*    */     //   201: goto +16 -> 217
/*    */     //   204: aload_0
/*    */     //   205: getfield 54	com/android/build/gradle/internal/errors/MessageReceiverImpl:logger	Lorg/gradle/api/logging/Logger;
/*    */     //   208: aload_1
/*    */     //   209: invokestatic 69	com/android/build/gradle/internal/errors/MessageReceiverImplKt:access$humanReadableMessage	(Lcom/android/ide/common/blame/Message;)Ljava/lang/String;
/*    */     //   212: invokeinterface 72 2 0
/*    */     //   217: return
/*    */     // Line number table:
/*    */     //   Java source line #53	-> byte code offset #6
/*    */     //   Java source line #54	-> byte code offset #64
/*    */     //   Java source line #55	-> byte code offset #77
/*    */     //   Java source line #57	-> byte code offset #94
/*    */     //   Java source line #58	-> byte code offset #107
/*    */     //   Java source line #59	-> byte code offset #110
/*    */     //   Java source line #60	-> byte code offset #123
/*    */     //   Java source line #62	-> byte code offset #140
/*    */     //   Java source line #63	-> byte code offset #153
/*    */     //   Java source line #64	-> byte code offset #156
/*    */     //   Java source line #65	-> byte code offset #172
/*    */     //   Java source line #66	-> byte code offset #188
/*    */     //   Java source line #67	-> byte code offset #204
/*    */     //   Java source line #68	-> byte code offset #217
/*    */     //   Java source line #69	-> byte code offset #217
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	218	0	this	MessageReceiverImpl
/*    */     //   0	218	1	message	Message
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.errors.MessageReceiverImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */