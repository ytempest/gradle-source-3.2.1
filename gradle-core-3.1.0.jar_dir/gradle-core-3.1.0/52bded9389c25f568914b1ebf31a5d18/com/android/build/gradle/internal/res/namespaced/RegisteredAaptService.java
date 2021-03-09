/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.build.gradle.internal.workeractions.WorkerActionServiceRegistry.RegisteredService;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonManager;
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\026\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\b\002\030\0002\b\022\004\022\0020\0020\001B\r\022\006\020\003\032\0020\002¢\006\002\020\004J\b\020\007\032\0020\bH\026R\024\020\003\032\0020\002X\004¢\006\b\n\000\032\004\b\005\020\006¨\006\t"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/RegisteredAaptService;", "Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry$RegisteredService;", "Lcom/android/builder/internal/aapt/v2/Aapt2DaemonManager;", "service", "(Lcom/android/builder/internal/aapt/v2/Aapt2DaemonManager;)V", "getService", "()Lcom/android/builder/internal/aapt/v2/Aapt2DaemonManager;", "shutdown", "", "gradle-core"})
/*    */ final class RegisteredAaptService
/*    */   implements WorkerActionServiceRegistry.RegisteredService<Aapt2DaemonManager>
/*    */ {
/*    */   @NotNull
/*    */   private final Aapt2DaemonManager service;
/*    */   
/* 48 */   public RegisteredAaptService(@NotNull Aapt2DaemonManager service) { this.service = service; } @NotNull
/* 48 */   public Aapt2DaemonManager getService() { return service; }
/*    */   
/*    */   public void shutdown() {
/* 51 */     getService().shutdown();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.RegisteredAaptService
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */