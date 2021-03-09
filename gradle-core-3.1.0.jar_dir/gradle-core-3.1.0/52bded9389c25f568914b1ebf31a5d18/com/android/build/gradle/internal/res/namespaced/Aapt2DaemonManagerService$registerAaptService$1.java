/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonImpl;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonManager;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonManager.Listener;
/*    */ import com.android.sdklib.BuildToolInfo;
/*    */ import com.android.sdklib.BuildToolInfo.PathId;
/*    */ import com.android.utils.ILogger;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.Paths;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2={"<anonymous>", "Lcom/android/build/gradle/internal/res/namespaced/RegisteredAaptService;", "invoke"})
/*    */ final class Aapt2DaemonManagerService$registerAaptService$1
/*    */   extends Lambda
/*    */   implements Function0<RegisteredAaptService>
/*    */ {
/*    */   @NotNull
/*    */   public final RegisteredAaptService invoke()
/*    */   {
/* 69 */     final String aaptExecutablePath = $buildToolInfo.getPath(BuildToolInfo.PathId.AAPT2);
/* 70 */     Aapt2DaemonManager manager = new Aapt2DaemonManager($logger, 
/* 71 */       (Function1)new Lambda(aaptExecutablePath) {
/*    */         @NotNull
/*    */         public final Aapt2DaemonImpl invoke(int displayId) {
/* 74 */           Path tmp34_31 = Paths.get(aaptExecutablePath, new String[0]);Intrinsics.checkExpressionValueIsNotNull(tmp34_31, "Paths.get(aaptExecutablePath)");
/*    */           
/* 76 */           return new Aapt2DaemonImpl('#' + displayId, tmp34_31, Aapt2DaemonManagerService.access$getDaemonTimeouts$p(), this$0.$logger);
/*    */         }
/* 78 */       }, Aapt2DaemonManagerService.access$getDaemonExpiryTimeSeconds$p(), 
/* 79 */       TimeUnit.SECONDS, 
/* 80 */       (Aapt2DaemonManager.Listener)new Aapt2DaemonManagerMaintainer(), null, 32, null);
/* 81 */     return new RegisteredAaptService(manager);
/*    */   }
/*    */   
/*    */   Aapt2DaemonManagerService$registerAaptService$1(BuildToolInfo paramBuildToolInfo, ILogger paramILogger)
/*    */   {
/*    */     super(0);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.Aapt2DaemonManagerService.registerAaptService.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */