/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.build.gradle.internal.workeractions.WorkerActionServiceRegistry;
/*    */ import com.android.build.gradle.internal.workeractions.WorkerActionServiceRegistry.RegisteredService;
/*    */ import com.android.build.gradle.internal.workeractions.WorkerActionServiceRegistry.ServiceKey;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonImpl;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonManager;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonManager.LeasedAaptDaemon;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonManager.Listener;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonTimeouts;
/*    */ import com.android.repository.Revision;
/*    */ import com.android.sdklib.BuildToolInfo;
/*    */ import com.android.sdklib.BuildToolInfo.PathId;
/*    */ import com.android.utils.ILogger;
/*    */ import java.io.Closeable;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.Paths;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Unit;
/*    */ import kotlin.io.CloseableKt;
/*    */ import kotlin.jvm.JvmName;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000:\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\032\036\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0020\f\032,\020\r\032\0020\0062\006\020\016\032\0020\0172\b\b\002\020\013\032\0020\f2\022\020\020\032\016\022\004\022\0020\022\022\004\022\0020\0060\021\"\016\020\000\032\0020\001X\004¢\006\002\n\000\"\016\020\002\032\0020\003X\004¢\006\002\n\000\"\016\020\004\032\0020\001X\004¢\006\002\n\000¨\006\023"}, d2={"daemonExpiryTimeSeconds", "", "daemonTimeouts", "Lcom/android/builder/internal/aapt/v2/Aapt2DaemonTimeouts;", "maintenanceIntervalSeconds", "registerAaptService", "", "buildToolInfo", "Lcom/android/sdklib/BuildToolInfo;", "logger", "Lcom/android/utils/ILogger;", "serviceRegistry", "Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry;", "useAaptDaemon", "aapt2Version", "Lcom/android/repository/Revision;", "block", "Lkotlin/Function1;", "Lcom/android/builder/internal/aapt/v2/Aapt2DaemonManager$LeasedAaptDaemon;", "gradle-core"})
/*    */ @JvmName(name="Aapt2DaemonManagerService")
/*    */ public final class Aapt2DaemonManagerService
/*    */ {
/* 39 */   private static final Aapt2DaemonTimeouts daemonTimeouts = new Aapt2DaemonTimeouts(0L, null, 0L, null, 0L, null, 0L, null, 255, null);
/* 40 */   private static final long daemonExpiryTimeSeconds = TimeUnit.MINUTES.toSeconds(3L);
/* 41 */   private static final long maintenanceIntervalSeconds = TimeUnit.MINUTES.toSeconds(1L);
/*    */   
/*    */   public static final void useAaptDaemon(@NotNull Revision aapt2Version, @NotNull WorkerActionServiceRegistry serviceRegistry, @NotNull Function1<? super Aapt2DaemonManager.LeasedAaptDaemon, Unit> block)
/*    */   {
/* 60 */     Intrinsics.checkParameterIsNotNull(aapt2Version, "aapt2Version");Intrinsics.checkParameterIsNotNull(serviceRegistry, "serviceRegistry");Intrinsics.checkParameterIsNotNull(block, "block");Closeable localCloseable = (Closeable)((Aapt2DaemonManager)serviceRegistry.getService((WorkerActionServiceRegistry.ServiceKey)new AaptServiceKey(aapt2Version)).getService()).leaseDaemon();Throwable localThrowable1 = (Throwable)null; try { Object localObject1 = block.invoke(localCloseable); } catch (Throwable localThrowable2) { localThrowable1 = localThrowable2; throw localThrowable2; } finally { CloseableKt.closeFinally(localCloseable, localThrowable1);
/*    */     }
/*    */   }
/*    */   
/*    */   public static final void registerAaptService(@NotNull BuildToolInfo buildToolInfo, @NotNull final ILogger logger, @NotNull WorkerActionServiceRegistry serviceRegistry)
/*    */   {
/* 68 */     Intrinsics.checkParameterIsNotNull(buildToolInfo, "buildToolInfo");Intrinsics.checkParameterIsNotNull(logger, "logger");Intrinsics.checkParameterIsNotNull(serviceRegistry, "serviceRegistry"); Revision tmp27_24 = buildToolInfo.getRevision();Intrinsics.checkExpressionValueIsNotNull(tmp27_24, "buildToolInfo.revision");serviceRegistry.registerService((WorkerActionServiceRegistry.ServiceKey)new AaptServiceKey(tmp27_24), (Function0)new Lambda(buildToolInfo) { @NotNull
/* 69 */       public final RegisteredAaptService invoke() { final String aaptExecutablePath = $buildToolInfo.getPath(BuildToolInfo.PathId.AAPT2);
/* 70 */         Aapt2DaemonManager manager = new Aapt2DaemonManager(logger, 
/* 71 */           (Function1)new Lambda(aaptExecutablePath) {
/*    */             @NotNull
/*    */             public final Aapt2DaemonImpl invoke(int displayId) {
/* 74 */               Path tmp34_31 = Paths.get(aaptExecutablePath, new String[0]);Intrinsics.checkExpressionValueIsNotNull(tmp34_31, "Paths.get(aaptExecutablePath)");
/*    */               
/* 76 */               return new Aapt2DaemonImpl('#' + displayId, tmp34_31, Aapt2DaemonManagerService.access$getDaemonTimeouts$p(), this$0.$logger);
/*    */             }
/* 78 */           }, Aapt2DaemonManagerService.access$getDaemonExpiryTimeSeconds$p(), 
/* 79 */           TimeUnit.SECONDS, 
/* 80 */           (Aapt2DaemonManager.Listener)new Aapt2DaemonManagerMaintainer(), null, 32, null);
/* 81 */         return new RegisteredAaptService(manager);
/*    */       }
/*    */     });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.Aapt2DaemonManagerService
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */