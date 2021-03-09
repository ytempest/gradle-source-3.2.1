/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.build.gradle.internal.LoggerWrapper;
/*    */ import com.android.builder.internal.aapt.AaptPackageConfig;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonManager.LeasedAaptDaemon;
/*    */ import com.android.repository.Revision;
/*    */ import com.android.utils.ILogger;
/*    */ import java.io.Serializable;
/*    */ import javax.inject.Inject;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.gradle.api.logging.Logging;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\032\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\030\0002\0020\001:\001\007B\017\b\007\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\005\032\0020\006H\026R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\b"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/Aapt2LinkRunnable;", "Ljava/lang/Runnable;", "params", "Lcom/android/build/gradle/internal/res/namespaced/Aapt2LinkRunnable$Params;", "(Lcom/android/build/gradle/internal/res/namespaced/Aapt2LinkRunnable$Params;)V", "run", "", "Params", "gradle-core"})
/*    */ public final class Aapt2LinkRunnable implements Runnable
/*    */ {
/*    */   private final Params params;
/*    */   
/*    */   @Inject
/*    */   public Aapt2LinkRunnable(@NotNull Params params)
/*    */   {
/* 26 */     this.params = params;
/*    */   }
/*    */   
/*    */   public void run() {
/* 30 */     final LoggerWrapper logger = new LoggerWrapper(Logging.getLogger(getClass()));
/* 31 */     Aapt2DaemonManagerService.useAaptDaemon$default(params.getRevision(), null, (Function1)new Lambda(logger) {
/* 32 */       public final void invoke(@NotNull Aapt2DaemonManager.LeasedAaptDaemon daemon) { Intrinsics.checkParameterIsNotNull(daemon, "daemon");daemon.link(Aapt2LinkRunnable.access$getParams$p(this$0).getRequest(), (ILogger)logger); } }, 2, null);
/*    */   }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\013"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/Aapt2LinkRunnable$Params;", "Ljava/io/Serializable;", "revision", "Lcom/android/repository/Revision;", "request", "Lcom/android/builder/internal/aapt/AaptPackageConfig;", "(Lcom/android/repository/Revision;Lcom/android/builder/internal/aapt/AaptPackageConfig;)V", "getRequest", "()Lcom/android/builder/internal/aapt/AaptPackageConfig;", "getRevision", "()Lcom/android/repository/Revision;", "gradle-core"})
/* 36 */   public static final class Params implements Serializable { public Params(@NotNull Revision revision, @NotNull AaptPackageConfig request) { this.revision = revision;this.request = request; } @NotNull
/* 37 */     public final Revision getRevision() { return revision; } @NotNull
/* 38 */     public final AaptPackageConfig getRequest() { return request; }
/*    */     
/*    */     @NotNull
/*    */     private final Revision revision;
/*    */     @NotNull
/*    */     private final AaptPackageConfig request;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.Aapt2LinkRunnable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */