/*    */ package com.android.build.gradle.internal.variant2;
/*    */ 
/*    */ import com.android.build.api.dsl.extension.VariantCallbackHandler;
/*    */ import com.android.build.api.dsl.variant.Variant;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.google.common.collect.ArrayListMultimap;
/*    */ import com.google.common.collect.ListMultimap;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000<\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\004\n\002\020\036\n\000\030\0002\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\016\020\013\032\b\022\004\022\0020\n0\fH\026J\036\020\r\032\0020\0162\006\020\017\032\0020\b2\f\020\020\032\b\022\004\022\0020\n0\tH\026J\024\020\021\032\0020\0162\f\020\022\032\b\022\004\022\0020\n0\023R \020\006\032\024\022\004\022\0020\b\022\n\022\b\022\004\022\0020\n0\t0\007X\004¢\006\002\n\000¨\006\024"}, d2={"Lcom/android/build/gradle/internal/variant2/VariantModelData;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/gradle/internal/variant2/VariantCallbackHolder;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "variantCallbacks", "Lcom/google/common/collect/ListMultimap;", "Lcom/android/build/gradle/internal/variant2/VariantPredicate;", "Lorg/gradle/api/Action;", "Lcom/android/build/api/dsl/variant/Variant;", "createVariantCallbackHandler", "Lcom/android/build/api/dsl/extension/VariantCallbackHandler;", "register", "", "predicate", "action", "runVariantCallbacks", "variants", "", "gradle-core"})
/*    */ public final class VariantModelData
/*    */   extends SealableObject
/*    */   implements VariantCallbackHolder
/*    */ {
/*    */   private final ListMultimap<VariantPredicate, Action<Variant>> variantCallbacks;
/*    */   
/*    */   public VariantModelData(@NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 46 */     super(issueReporter); ArrayListMultimap 
/*    */     
/* 50 */       tmp15_12 = ArrayListMultimap.create();Intrinsics.checkExpressionValueIsNotNull(tmp15_12, "ArrayListMultimap.create()");variantCallbacks = ((ListMultimap)tmp15_12);
/*    */   }
/*    */   
/*    */   public final void runVariantCallbacks(@NotNull Collection<? extends Variant> variants)
/*    */   {
/* 60 */     Intrinsics.checkParameterIsNotNull(variants, "variants");Set predicates = variantCallbacks.keySet();
/*    */     
/* 64 */     for (Iterator localIterator1 = variants.iterator(); localIterator1.hasNext();) { variant = (Variant)localIterator1.next();
/* 65 */       for (VariantPredicate predicate : predicates)
/* 66 */         if (predicate.accept(variant)) {
/* 67 */           List actions = variantCallbacks.get(predicate);
/* 68 */           for (Action action : actions)
/* 69 */             action.execute(variant);
/*    */         }
/*    */     }
/*    */     Variant variant;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public VariantCallbackHandler<Variant> createVariantCallbackHandler() {
/* 77 */     return (VariantCallbackHandler)new VariantCallbackHandlerImpl((VariantCallbackHolder)this, getIssueReporter());
/*    */   }
/*    */   
/*    */   public void register(@NotNull VariantPredicate predicate, @NotNull Action<Variant> action) {
/* 81 */     Intrinsics.checkParameterIsNotNull(predicate, "predicate");Intrinsics.checkParameterIsNotNull(action, "action"); if (checkSeal()) {
/* 82 */       variantCallbacks.put(predicate, action);
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantModelData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */