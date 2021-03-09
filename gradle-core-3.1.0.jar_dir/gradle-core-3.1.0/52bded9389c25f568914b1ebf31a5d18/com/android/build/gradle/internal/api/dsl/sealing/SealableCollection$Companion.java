/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\037\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\032\020\003\032\b\022\004\022\002H\0050\004\"\004\b\001\020\0052\006\020\006\032\0020\007J(\020\b\032\b\022\004\022\002H\0050\004\"\004\b\001\020\0052\f\020\t\032\b\022\004\022\002H\0050\n2\006\020\006\032\0020\007¨\006\013"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/SealableCollection$Companion;", "", "()V", "new", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableCollection;", "T", "errorReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "wrap", "wrappedList", "", "gradle-core"})
/*    */ public final class SealableCollection$Companion
/*    */ {
/*    */   @NotNull
/*    */   public final <T> SealableCollection<T> wrap(@NotNull Collection<T> wrappedList, @NotNull EvalIssueReporter errorReporter)
/*    */   {
/* 50 */     Intrinsics.checkParameterIsNotNull(wrappedList, "wrappedList");Intrinsics.checkParameterIsNotNull(errorReporter, "errorReporter");
/*    */     
/* 54 */     return new SealableCollection(wrappedList, (Function0)wrap.1.INSTANCE, (Function1)wrap.2.INSTANCE, errorReporter, null); }
/*    */   @NotNull
/* 56 */   public final <T> SealableCollection<T> jdMethod_new(@NotNull EvalIssueReporter errorReporter) { Intrinsics.checkParameterIsNotNull(errorReporter, "errorReporter");
/*    */     
/* 60 */     return new SealableCollection(null, (Function0)new.1.INSTANCE, (Function1)new.2.INSTANCE, errorReporter, null);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableCollection.Companion
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */