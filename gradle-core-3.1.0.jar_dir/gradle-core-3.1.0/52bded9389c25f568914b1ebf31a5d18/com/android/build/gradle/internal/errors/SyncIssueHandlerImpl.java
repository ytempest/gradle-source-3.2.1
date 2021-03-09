/*    */ package com.android.build.gradle.internal.errors;
/*    */ 
/*    */ import com.android.build.gradle.internal.ide.SyncIssueImpl;
/*    */ import com.android.build.gradle.options.SyncOptions.EvaluationMode;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.android.builder.errors.EvalIssueReporter.Severity;
/*    */ import com.android.builder.errors.EvalIssueReporter.Type;
/*    */ import com.android.builder.model.SyncIssue;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.GradleException;
/*    */ import org.gradle.api.logging.Logger;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000L\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\020\020\020\032\0020\0212\006\020\022\032\0020\023H\026J*\020\024\032\0020\0132\006\020\022\032\0020\0232\006\020\025\032\0020\0262\006\020\027\032\0020\0302\b\020\031\032\004\030\0010\030H\026RN\020\007\032B\022\f\022\n \n*\004\030\0010\t0\t\022\f\022\n \n*\004\030\0010\0130\013 \n* \022\f\022\n \n*\004\030\0010\t0\t\022\f\022\n \n*\004\030\0010\0130\013\030\0010\b0\bX\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R\032\020\f\032\b\022\004\022\0020\0130\r8VX\004¢\006\006\032\004\b\016\020\017¨\006\032"}, d2={"Lcom/android/build/gradle/internal/errors/SyncIssueHandlerImpl;", "Lcom/android/build/gradle/internal/errors/SyncIssueHandler;", "mode", "Lcom/android/build/gradle/options/SyncOptions$EvaluationMode;", "logger", "Lorg/gradle/api/logging/Logger;", "(Lcom/android/build/gradle/options/SyncOptions$EvaluationMode;Lorg/gradle/api/logging/Logger;)V", "_syncIssues", "Ljava/util/HashMap;", "Lcom/android/build/gradle/internal/errors/SyncIssueKey;", "kotlin.jvm.PlatformType", "Lcom/android/builder/model/SyncIssue;", "syncIssues", "Lcom/google/common/collect/ImmutableList;", "getSyncIssues", "()Lcom/google/common/collect/ImmutableList;", "hasSyncIssue", "", "type", "Lcom/android/builder/errors/EvalIssueReporter$Type;", "reportIssue", "severity", "Lcom/android/builder/errors/EvalIssueReporter$Severity;", "msg", "", "data", "gradle-core"})
/*    */ public final class SyncIssueHandlerImpl implements SyncIssueHandler
/*    */ {
/*    */   private final HashMap<SyncIssueKey, SyncIssue> _syncIssues;
/*    */   private final SyncOptions.EvaluationMode mode;
/*    */   private final Logger logger;
/*    */   
/*    */   @NotNull
/*    */   public SyncIssue reportIssue(@NotNull EvalIssueReporter.Type type, @NotNull EvalIssueReporter.Severity severity, @NotNull String msg)
/*    */   {
/* 30 */     Intrinsics.checkParameterIsNotNull(type, "type");Intrinsics.checkParameterIsNotNull(severity, "severity");Intrinsics.checkParameterIsNotNull(msg, "msg");return SyncIssueHandler.DefaultImpls.reportIssue(this, type, severity, msg); } @NotNull
/* 30 */   public SyncIssue reportError(@NotNull EvalIssueReporter.Type type, @NotNull String msg) { Intrinsics.checkParameterIsNotNull(type, "type");Intrinsics.checkParameterIsNotNull(msg, "msg");return SyncIssueHandler.DefaultImpls.reportError(this, type, msg); } @NotNull
/* 30 */   public SyncIssue reportError(@NotNull EvalIssueReporter.Type type, @NotNull String msg, @Nullable String data) { Intrinsics.checkParameterIsNotNull(type, "type");Intrinsics.checkParameterIsNotNull(msg, "msg");return SyncIssueHandler.DefaultImpls.reportError(this, type, msg, data); } @NotNull
/* 30 */   public SyncIssue reportWarning(@NotNull EvalIssueReporter.Type type, @NotNull String msg) { Intrinsics.checkParameterIsNotNull(type, "type");Intrinsics.checkParameterIsNotNull(msg, "msg");return SyncIssueHandler.DefaultImpls.reportWarning(this, type, msg); } @NotNull
/* 30 */   public SyncIssue reportWarning(@NotNull EvalIssueReporter.Type type, @NotNull String msg, @Nullable String data) { Intrinsics.checkParameterIsNotNull(type, "type");Intrinsics.checkParameterIsNotNull(msg, "msg");return SyncIssueHandler.DefaultImpls.reportWarning(this, type, msg, data); } public SyncIssueHandlerImpl(@NotNull SyncOptions.EvaluationMode mode, @NotNull Logger logger) { this.mode = mode;this.logger = logger;
/*    */     
/* 35 */     _syncIssues = Maps.newHashMap(); }
/*    */   
/*    */   @NotNull
/* 38 */   public ImmutableList<SyncIssue> getSyncIssues() { ImmutableList tmp10_7 = ImmutableList.copyOf(_syncIssues.values());Intrinsics.checkExpressionValueIsNotNull(tmp10_7, "ImmutableList.copyOf(_syncIssues.values)");return tmp10_7;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public SyncIssue reportIssue(@NotNull EvalIssueReporter.Type type, @NotNull EvalIssueReporter.Severity severity, @NotNull String msg, @Nullable String data)
/*    */   {
/* 50 */     Intrinsics.checkParameterIsNotNull(type, "type");Intrinsics.checkParameterIsNotNull(severity, "severity");Intrinsics.checkParameterIsNotNull(msg, "msg"); SyncIssue issue; switch (SyncIssueHandlerImpl.WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) {
/*    */     case 1: 
/* 52 */       if (severity.getSeverity() != 1) {
/* 53 */         throw ((Throwable)new GradleException(msg));
/*    */       }
/* 55 */       logger.warn("WARNING: " + msg);
/* 56 */       issue = (SyncIssue)new SyncIssueImpl(type, severity, data, msg); break;
/*    */     
/*    */     case 2: 
/* 60 */       issue = (SyncIssue)new SyncIssueImpl(type, severity, data, msg);
/* 61 */       _syncIssues.put(SyncIssueHandlerImplKt.access$syncIssueKeyFrom(issue), issue); break;
/*    */     default: 
/* 63 */       throw ((Throwable)new RuntimeException("Unknown SyncIssue type"));
/*    */     }
/*    */     
/* 66 */     return issue;
/*    */   }
/*    */   
/*    */   public boolean hasSyncIssue(@NotNull EvalIssueReporter.Type type)
/*    */   {
/* 41 */     Intrinsics.checkParameterIsNotNull(type, "type"); Collection tmp13_10 = _syncIssues.values();Intrinsics.checkExpressionValueIsNotNull(tmp13_10, "_syncIssues.values");Iterable $receiver$iv = (Iterable)tmp13_10;
/*    */     
/*    */     int $i$f$any;
/*    */     
/* 91 */     for (Iterator localIterator = $receiver$iv.iterator(); localIterator.hasNext(); Intrinsics.checkExpressionValueIsNotNull(tmp79_77, "issue"))
/*    */     {
/* 91 */       Object element$iv = localIterator.next();SyncIssue issue = (SyncIssue)element$iv;
/* 92 */       int $i$a$1$any; } return (!($receiver$iv instanceof Collection)) || (!((Collection)$receiver$iv).isEmpty());
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.errors.SyncIssueHandlerImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */