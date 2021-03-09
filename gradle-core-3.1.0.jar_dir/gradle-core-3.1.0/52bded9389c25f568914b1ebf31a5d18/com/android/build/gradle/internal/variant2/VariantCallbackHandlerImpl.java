/*    */ package com.android.build.gradle.internal.variant2;
/*    */ 
/*    */ import com.android.build.api.dsl.extension.VariantCallbackHandler;
/*    */ import com.android.build.api.dsl.variant.Variant;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000B\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\004\n\002\020\016\n\002\b\005\n\002\030\002\n\000\b\000\030\000*\b\b\000\020\001*\0020\0022\b\022\004\022\002H\0010\003B\027\b\020\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bB\037\b\002\022\006\020\t\032\0020\n\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\013J\026\020\f\032\0020\r2\f\020\016\032\b\022\004\022\0028\0000\017H\026J(\020\020\032\0020\r\"\b\b\001\020\021*\0020\0022\f\020\016\032\b\022\004\022\002H\0210\0172\006\020\t\032\0020\nH\002J\026\020\022\032\b\022\004\022\0028\0000\0032\006\020\023\032\0020\024H\026J\036\020\022\032\0020\r2\006\020\023\032\0020\0242\f\020\016\032\b\022\004\022\0028\0000\017H\026J\026\020\025\032\b\022\004\022\0028\0000\0032\006\020\023\032\0020\024H\026J\036\020\025\032\0020\r2\006\020\023\032\0020\0242\f\020\016\032\b\022\004\022\0028\0000\017H\026J\026\020\026\032\b\022\004\022\0028\0000\0032\006\020\023\032\0020\024H\026J\036\020\026\032\0020\r2\006\020\023\032\0020\0242\f\020\016\032\b\022\004\022\0028\0000\017H\026J&\020\027\032\b\022\004\022\002H\0300\003\"\b\b\001\020\030*\0020\0022\f\020\031\032\b\022\004\022\002H\0300\032H\026J.\020\027\032\0020\r\"\b\b\001\020\030*\0020\0022\f\020\031\032\b\022\004\022\002H\0300\0322\f\020\016\032\b\022\004\022\002H\0300\017H\026R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000¨\006\033"}, d2={"Lcom/android/build/gradle/internal/variant2/VariantCallbackHandlerImpl;", "T", "Lcom/android/build/api/dsl/variant/Variant;", "Lcom/android/build/api/dsl/extension/VariantCallbackHandler;", "variantCallbackHolder", "Lcom/android/build/gradle/internal/variant2/VariantCallbackHolder;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/variant2/VariantCallbackHolder;Lcom/android/builder/errors/EvalIssueReporter;)V", "predicate", "Lcom/android/build/gradle/internal/variant2/VariantPredicate;", "(Lcom/android/build/gradle/internal/variant2/VariantPredicate;Lcom/android/build/gradle/internal/variant2/VariantCallbackHolder;Lcom/android/builder/errors/EvalIssueReporter;)V", "all", "", "action", "Lorg/gradle/api/Action;", "registerAction", "V", "withBuildType", "name", "", "withName", "withProductFlavor", "withType", "S", "variantClass", "Ljava/lang/Class;", "gradle-core"})
/*    */ public final class VariantCallbackHandlerImpl<T extends Variant>
/*    */   implements VariantCallbackHandler<T>
/*    */ {
/*    */   private final VariantPredicate predicate;
/*    */   private final VariantCallbackHolder variantCallbackHolder;
/*    */   private final EvalIssueReporter issueReporter;
/*    */   
/*    */   private VariantCallbackHandlerImpl(VariantPredicate predicate, VariantCallbackHolder variantCallbackHolder, EvalIssueReporter issueReporter)
/*    */   {
/* 25 */     this.predicate = predicate;this.variantCallbackHolder = variantCallbackHolder;this.issueReporter = issueReporter;
/*    */   }
/*    */   
/* 34 */   public VariantCallbackHandlerImpl(@NotNull VariantCallbackHolder variantCallbackHolder, @NotNull EvalIssueReporter issueReporter) { this(new VariantPredicate(issueReporter), variantCallbackHolder, issueReporter); }
/*    */   
/*    */   @NotNull
/* 37 */   public VariantCallbackHandler<T> withName(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name");return (VariantCallbackHandler)new VariantCallbackHandlerImpl(
/* 38 */       predicate.cloneWithName$gradle_core(name), variantCallbackHolder, issueReporter);
/*    */   }
/*    */   
/*    */   @NotNull
/* 42 */   public <S extends Variant> VariantCallbackHandler<S> withType(@NotNull Class<S> variantClass) { Intrinsics.checkParameterIsNotNull(variantClass, "variantClass");return (VariantCallbackHandler)new VariantCallbackHandlerImpl(
/* 43 */       predicate.cloneWithClass$gradle_core(variantClass), variantCallbackHolder, issueReporter);
/*    */   }
/*    */   
/*    */   @NotNull
/* 47 */   public VariantCallbackHandler<T> withBuildType(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name");return (VariantCallbackHandler)new VariantCallbackHandlerImpl(
/* 48 */       predicate.cloneWithBuildType$gradle_core(name), variantCallbackHolder, issueReporter);
/*    */   }
/*    */   
/*    */   @NotNull
/* 52 */   public VariantCallbackHandler<T> withProductFlavor(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name");return (VariantCallbackHandler)new VariantCallbackHandlerImpl(
/* 53 */       predicate.cloneWithFlavor$gradle_core(name), variantCallbackHolder, issueReporter);
/*    */   }
/*    */   
/*    */   public void all(@NotNull Action<T> action) {
/* 57 */     Intrinsics.checkParameterIsNotNull(action, "action");registerAction(action, predicate);
/*    */   }
/*    */   
/*    */   public <S extends Variant> void withType(@NotNull Class<S> variantClass, @NotNull Action<S> action) {
/* 61 */     Intrinsics.checkParameterIsNotNull(variantClass, "variantClass");Intrinsics.checkParameterIsNotNull(action, "action");registerAction(action, predicate.cloneWithClass$gradle_core(variantClass));
/*    */   }
/*    */   
/*    */   public void withName(@NotNull String name, @NotNull Action<T> action) {
/* 65 */     Intrinsics.checkParameterIsNotNull(name, "name");Intrinsics.checkParameterIsNotNull(action, "action");registerAction(action, predicate.cloneWithName$gradle_core(name));
/*    */   }
/*    */   
/*    */   public void withBuildType(@NotNull String name, @NotNull Action<T> action) {
/* 69 */     Intrinsics.checkParameterIsNotNull(name, "name");Intrinsics.checkParameterIsNotNull(action, "action");registerAction(action, predicate.cloneWithBuildType$gradle_core(name));
/*    */   }
/*    */   
/*    */   public void withProductFlavor(@NotNull String name, @NotNull Action<T> action) {
/* 73 */     Intrinsics.checkParameterIsNotNull(name, "name");Intrinsics.checkParameterIsNotNull(action, "action");registerAction(action, predicate.cloneWithFlavor$gradle_core(name));
/*    */   }
/*    */   
/*    */   private final <V extends Variant> void registerAction(Action<V> action, VariantPredicate predicate)
/*    */   {
/* 78 */     Action tmp6_5 = action;
/*    */     
/* 78 */     if (tmp6_5 == null) throw new TypeCastException("null cannot be cast to non-null type org.gradle.api.Action<com.android.build.api.dsl.variant.Variant>"); variantCallbackHolder.register(predicate, tmp6_5);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantCallbackHandlerImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */