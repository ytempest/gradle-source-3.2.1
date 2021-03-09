/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.Collection;
/*    */ import java.util.LinkedHashSet;
/*    */ import java.util.Set;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import kotlin.jvm.internal.markers.KMutableSet;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000&\n\002\030\002\n\000\n\002\030\002\n\002\020#\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\030\000 \f*\004\b\000\020\0012\024\022\004\022\002H\001\022\n\022\b\022\004\022\002H\0010\0030\0022\b\022\004\022\002H\0010\003:\001\fBS\b\002\022\016\020\004\032\n\022\004\022\0028\000\030\0010\003\022\022\020\005\032\016\022\n\022\b\022\004\022\0028\0000\0030\006\022\036\020\007\032\032\022\n\022\b\022\004\022\0028\0000\003\022\n\022\b\022\004\022\0028\0000\0030\b\022\006\020\t\032\0020\n¢\006\002\020\013¨\006\r"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/SealableSet;", "T", "Lcom/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection;", "", "wrappedSet", "instantiator", "Lkotlin/Function0;", "cloner", "Lkotlin/Function1;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/util/Set;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/android/builder/errors/EvalIssueReporter;)V", "Companion", "gradle-core"})
/*    */ public final class SealableSet<T>
/*    */   extends AbstractSealableCollection<T, Set<T>>
/*    */   implements Set<T>, KMutableSet
/*    */ {
/*    */   public static final Companion Companion = new Companion(null);
/*    */   
/*    */   private SealableSet(Set<T> wrappedSet, Function0<? extends Set<T>> instantiator, Function1<? super Set<T>, ? extends Set<T>> cloner, EvalIssueReporter issueReporter)
/*    */   {
/* 43 */     super(
/* 44 */       (Collection)wrappedSet, instantiator, cloner, issueReporter);
/*    */   }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020#\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\032\020\003\032\b\022\004\022\002H\0050\004\"\004\b\001\020\0052\006\020\006\032\0020\007J(\020\b\032\b\022\004\022\002H\0050\004\"\004\b\001\020\0052\f\020\t\032\b\022\004\022\002H\0050\n2\006\020\006\032\0020\007¨\006\013"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/SealableSet$Companion;", "", "()V", "new", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableSet;", "T", "errorReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "wrap", "wrappedList", "", "gradle-core"})
/*    */   public static final class Companion { @NotNull
/* 49 */     public final <T> SealableSet<T> wrap(@NotNull Set<T> wrappedList, @NotNull EvalIssueReporter errorReporter) { Intrinsics.checkParameterIsNotNull(wrappedList, "wrappedList");Intrinsics.checkParameterIsNotNull(errorReporter, "errorReporter");
/*    */       
/* 53 */       return new SealableSet(wrappedList, (Function0)wrap.1.INSTANCE, (Function1)wrap.2.INSTANCE, errorReporter, null); }
/*    */     @NotNull
/* 55 */     public final <T> SealableSet<T> jdMethod_new(@NotNull EvalIssueReporter errorReporter) { Intrinsics.checkParameterIsNotNull(errorReporter, "errorReporter");
/*    */       
/* 59 */       return new SealableSet(null, (Function0)new.1.INSTANCE, (Function1)new.2.INSTANCE, errorReporter, null);
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableSet
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */