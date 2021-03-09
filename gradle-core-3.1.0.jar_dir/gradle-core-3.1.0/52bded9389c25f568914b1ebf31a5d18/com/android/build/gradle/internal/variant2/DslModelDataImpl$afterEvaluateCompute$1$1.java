/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import com.android.build.gradle.internal.api.dsl.model.ProductFlavorImpl;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\026\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\001\"\n\b\000\020\002 \000*\0020\0032\016\020\004\032\n \006*\004\030\0010\0050\005H\n¢\006\002\b\007"}, d2={"<anonymous>", "", "E", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "it", "Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl;", "kotlin.jvm.PlatformType", "invoke"})
/*     */ final class DslModelDataImpl$afterEvaluateCompute$1$1
/*     */   extends Lambda
/*     */   implements Function1<ProductFlavorImpl, String>
/*     */ {
/*     */   public static final 1 INSTANCE = new 1();
/*     */   
/*     */   @NotNull
/*     */   public final String invoke(ProductFlavorImpl it)
/*     */   {
/* 215 */     ProductFlavorImpl tmp1_0 = it;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "it");return tmp1_0.getName();
/*     */   }
/*     */   
/*     */   DslModelDataImpl$afterEvaluateCompute$1$1()
/*     */   {
/*     */     super(1);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.DslModelDataImpl.afterEvaluateCompute.1.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */