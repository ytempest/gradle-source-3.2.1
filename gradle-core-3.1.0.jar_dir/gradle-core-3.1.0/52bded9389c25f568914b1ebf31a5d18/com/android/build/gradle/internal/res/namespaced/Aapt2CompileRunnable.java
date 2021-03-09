/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.build.gradle.internal.LoggerWrapper;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonManager.LeasedAaptDaemon;
/*    */ import com.android.ide.common.res2.CompileResourceRequest;
/*    */ import com.android.repository.Revision;
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.gradle.api.logging.Logging;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\032\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\030\0002\0020\001:\001\007B\017\b\007\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\005\032\0020\006H\026R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\b"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/Aapt2CompileRunnable;", "Ljava/lang/Runnable;", "params", "Lcom/android/build/gradle/internal/res/namespaced/Aapt2CompileRunnable$Params;", "(Lcom/android/build/gradle/internal/res/namespaced/Aapt2CompileRunnable$Params;)V", "run", "", "Params", "gradle-core"})
/*    */ public final class Aapt2CompileRunnable
/*    */   implements Runnable
/*    */ {
/*    */   private final Params params;
/*    */   
/*    */   @javax.inject.Inject
/* 27 */   public Aapt2CompileRunnable(@NotNull Params params) { this.params = params; }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\002\b\b\030\0002\0020\001B#\022\006\020\002\032\0020\003\022\f\020\004\032\b\022\004\022\0020\0060\005\022\006\020\007\032\0020\b¢\006\002\020\tR\021\020\007\032\0020\b¢\006\b\n\000\032\004\b\n\020\013R\027\020\004\032\b\022\004\022\0020\0060\005¢\006\b\n\000\032\004\b\f\020\rR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\016\020\017¨\006\020"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/Aapt2CompileRunnable$Params;", "Ljava/io/Serializable;", "revision", "Lcom/android/repository/Revision;", "requests", "", "Lcom/android/ide/common/res2/CompileResourceRequest;", "outputDirectory", "Ljava/io/File;", "(Lcom/android/repository/Revision;Ljava/util/List;Ljava/io/File;)V", "getOutputDirectory", "()Ljava/io/File;", "getRequests", "()Ljava/util/List;", "getRevision", "()Lcom/android/repository/Revision;", "gradle-core"})
/*    */   public static final class Params implements Serializable { @NotNull
/*    */     private final Revision revision;
/*    */     @NotNull
/*    */     private final List<CompileResourceRequest> requests;
/*    */     @NotNull
/*    */     private final File outputDirectory;
/*    */     
/* 37 */     public Params(@NotNull Revision revision, @NotNull List<CompileResourceRequest> requests, @NotNull File outputDirectory) { this.revision = revision;this.requests = requests;this.outputDirectory = outputDirectory; } @NotNull
/* 38 */     public final Revision getRevision() { return revision; } @NotNull
/* 39 */     public final List<CompileResourceRequest> getRequests() { return requests; } @NotNull
/* 40 */     public final File getOutputDirectory() { return outputDirectory; }
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/* 31 */     final LoggerWrapper logger = new LoggerWrapper(Logging.getLogger(getClass()));
/* 32 */     Aapt2DaemonManagerService.useAaptDaemon$default(params.getRevision(), null, (Function1)new Lambda(logger) {
/* 33 */       public final void invoke(@NotNull Aapt2DaemonManager.LeasedAaptDaemon daemon) { Intrinsics.checkParameterIsNotNull(daemon, "daemon");Iterable $receiver$iv = (Iterable)Aapt2CompileRunnable.access$getParams$p(this$0).getRequests();
/*    */         
/*    */         int $i$f$forEach;
/*    */         
/*    */         CompileResourceRequest it;
/*    */         
/*    */         int $i$a$1$forEach;
/*    */         
/* 43 */         for (Iterator localIterator = $receiver$iv.iterator(); localIterator.hasNext(); daemon.compile(it, (com.android.utils.ILogger)logger))
/*    */         {
/* 43 */           Object element$iv = localIterator.next();it = (CompileResourceRequest)element$iv; } } }, 2, null);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.Aapt2CompileRunnable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */