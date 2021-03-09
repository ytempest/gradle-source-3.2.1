/*    */ package com.android.build.gradle.internal.api.dsl.model;
/*    */ 
/*    */ import com.android.build.api.dsl.model.FallbackStrategy;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableList;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableList.Companion;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.collections.ArraysKt;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000>\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\016\n\000\n\002\020!\n\002\b\006\n\002\020\002\n\002\b\004\n\002\020\021\n\002\b\005\030\0002\0020\0012\0020\002B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\025\020\022\032\0020\0232\006\020\024\032\0020\000H\000¢\006\002\b\025J\b\020\026\032\0020\023H\026J!\020\020\032\0020\0232\022\020\027\032\n\022\006\b\001\022\0020\n0\030\"\0020\nH\027¢\006\002\020\031J\020\020\020\032\0020\0232\006\020\032\032\0020\nH\027J\037\020\033\032\0020\0232\016\020\027\032\n\022\006\b\001\022\0020\n0\030H\000¢\006\004\b\034\020\031R\024\020\b\032\b\022\004\022\0020\n0\tX\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000R0\020\r\032\b\022\004\022\0020\n0\f2\f\020\013\032\b\022\004\022\0020\n0\f8V@VX\016¢\006\f\032\004\b\016\020\017\"\004\b\020\020\021¨\006\035"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/model/FallbackStrategy;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)V", "_matchingFallbacks", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableList;", "", "value", "", "matchingFallbacks", "getMatchingFallbacks", "()Ljava/util/List;", "setMatchingFallbacks", "(Ljava/util/List;)V", "initWith", "", "that", "initWith$gradle_core", "seal", "fallbacks", "", "([Ljava/lang/String;)V", "fallback", "setMatchingFallbacksAsArray", "setMatchingFallbacksAsArray$gradle_core", "gradle-core"})
/*    */ public final class FallbackStrategyImpl
/*    */   extends SealableObject
/*    */   implements FallbackStrategy
/*    */ {
/*    */   private final SealableList<String> _matchingFallbacks;
/*    */   private final DeprecationReporter deprecationReporter;
/*    */   
/*    */   public FallbackStrategyImpl(@NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 28 */     super(issueReporter);this.deprecationReporter = deprecationReporter;
/*    */     
/* 30 */     _matchingFallbacks = SealableList.Companion.jdMethod_new(issueReporter); }
/*    */   
/*    */   @NotNull
/* 33 */   public List<String> getMatchingFallbacks() { return (List)_matchingFallbacks; }
/*    */   
/* 35 */   public void setMatchingFallbacks(@NotNull List<String> value) { Intrinsics.checkParameterIsNotNull(value, "value");_matchingFallbacks.reset$gradle_core((Collection)value);
/*    */   }
/*    */   
/*    */   public final void setMatchingFallbacksAsArray$gradle_core(@NotNull String[] fallbacks) {
/* 39 */     Intrinsics.checkParameterIsNotNull(fallbacks, "fallbacks");deprecationReporter.reportDeprecatedUsage(
/* 40 */       "BuildType.matchingFallbacks", 
/* 41 */       "BuildType.setMatchingFallbacks", 
/* 42 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 43 */     _matchingFallbacks.reset$gradle_core((Collection)ArraysKt.toMutableList((Object[])fallbacks));
/*    */   }
/*    */   
/*    */   public void setMatchingFallbacks(@NotNull String... fallbacks)
/*    */   {
/* 48 */     Intrinsics.checkParameterIsNotNull(fallbacks, "fallbacks");setMatchingFallbacksAsArray$gradle_core(fallbacks);
/*    */   }
/*    */   
/*    */   public void setMatchingFallbacks(@NotNull String fallback)
/*    */   {
/* 53 */     Intrinsics.checkParameterIsNotNull(fallback, "fallback");deprecationReporter.reportDeprecatedUsage(
/* 54 */       "BuildType.matchingFallbacks", 
/* 55 */       "BuildType.setMatchingFallbacks", 
/* 56 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 57 */     _matchingFallbacks.reset$gradle_core((Collection)CollectionsKt.mutableListOf(new String[] { fallback }));
/*    */   }
/*    */   
/*    */   public final void initWith$gradle_core(@NotNull FallbackStrategyImpl that) {
/* 61 */     Intrinsics.checkParameterIsNotNull(that, "that"); if (checkSeal()) {
/* 62 */       _matchingFallbacks.reset$gradle_core((Collection)_matchingFallbacks);
/*    */     }
/*    */   }
/*    */   
/*    */   public void seal() {
/* 67 */     super.seal();
/*    */     
/* 69 */     _matchingFallbacks.seal();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.FallbackStrategyImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */