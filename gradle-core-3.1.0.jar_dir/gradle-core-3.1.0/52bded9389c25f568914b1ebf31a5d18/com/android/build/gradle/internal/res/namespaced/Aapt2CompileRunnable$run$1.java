/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.build.gradle.internal.LoggerWrapper;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonManager.LeasedAaptDaemon;
/*    */ import com.android.ide.common.res2.CompileResourceRequest;
/*    */ import com.android.utils.ILogger;
/*    */ import java.util.Iterator;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2={"<anonymous>", "", "daemon", "Lcom/android/builder/internal/aapt/v2/Aapt2DaemonManager$LeasedAaptDaemon;", "invoke"})
/*    */ final class Aapt2CompileRunnable$run$1
/*    */   extends Lambda
/*    */   implements Function1<Aapt2DaemonManager.LeasedAaptDaemon, Unit>
/*    */ {
/*    */   public final void invoke(@NotNull Aapt2DaemonManager.LeasedAaptDaemon daemon)
/*    */   {
/* 33 */     Intrinsics.checkParameterIsNotNull(daemon, "daemon");Iterable $receiver$iv = (Iterable)Aapt2CompileRunnable.access$getParams$p(this$0).getRequests();
/*    */     
/*    */     int $i$f$forEach;
/*    */     
/*    */     CompileResourceRequest it;
/*    */     
/*    */     int $i$a$1$forEach;
/*    */     
/* 43 */     for (Iterator localIterator = $receiver$iv.iterator(); localIterator.hasNext(); daemon.compile(it, (ILogger)$logger))
/*    */     {
/* 43 */       Object element$iv = localIterator.next();it = (CompileResourceRequest)element$iv;
/*    */     }
/*    */   }
/*    */   
/*    */   Aapt2CompileRunnable$run$1(Aapt2CompileRunnable paramAapt2CompileRunnable, LoggerWrapper paramLoggerWrapper)
/*    */   {
/*    */     super(1);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.Aapt2CompileRunnable.run.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */