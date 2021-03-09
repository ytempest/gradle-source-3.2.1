/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020%\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J&\020\003\032\016\022\004\022\002H\005\022\004\022\002H\0060\004\"\004\b\002\020\005\"\004\b\003\020\0062\006\020\007\032\0020\bJ:\020\t\032\016\022\004\022\002H\005\022\004\022\002H\0060\004\"\004\b\002\020\005\"\004\b\003\020\0062\022\020\n\032\016\022\004\022\002H\005\022\004\022\002H\0060\0132\006\020\007\032\0020\b¨\006\f"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/SealableMap$Companion;", "", "()V", "new", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableMap;", "K", "V", "errorReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "wrap", "originMap", "", "gradle-core"})
/*    */ public final class SealableMap$Companion
/*    */ {
/*    */   @NotNull
/*    */   public final <K, V> SealableMap<K, V> wrap(@NotNull Map<K, V> originMap, @NotNull EvalIssueReporter errorReporter)
/*    */   {
/* 46 */     Intrinsics.checkParameterIsNotNull(originMap, "originMap");Intrinsics.checkParameterIsNotNull(errorReporter, "errorReporter");
/*    */     
/* 50 */     return new SealableMap(originMap, (Function0)wrap.1.INSTANCE, (Function1)wrap.2.INSTANCE, errorReporter, null); }
/*    */   @NotNull
/* 52 */   public final <K, V> SealableMap<K, V> jdMethod_new(@NotNull EvalIssueReporter errorReporter) { Intrinsics.checkParameterIsNotNull(errorReporter, "errorReporter");
/*    */     
/* 56 */     return new SealableMap(null, (Function0)new.1.INSTANCE, (Function1)new.2.INSTANCE, errorReporter, null);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableMap.Companion
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */