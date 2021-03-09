/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import com.android.build.api.dsl.model.VariantProperties;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\020\000\032\004\030\0010\0012\006\020\002\032\0020\003H\n¢\006\004\b\004\020\005"}, d2={"<anonymous>", "", "it", "Lcom/android/build/api/dsl/model/VariantProperties;", "invoke", "(Lcom/android/build/api/dsl/model/VariantProperties;)Ljava/lang/Boolean;"})
/*     */ final class VariantBuilderKt$GET_MULTIDEX_ENABLED$1
/*     */   extends Lambda
/*     */   implements Function1<VariantProperties, Boolean>
/*     */ {
/*     */   public static final 1 INSTANCE = new 1();
/*     */   
/*     */   @Nullable
/*     */   public final Boolean invoke(@NotNull VariantProperties it)
/*     */   {
/* 465 */     Intrinsics.checkParameterIsNotNull(it, "it");return it.getMultiDexEnabled();
/*     */   }
/*     */   
/*     */   VariantBuilderKt$GET_MULTIDEX_ENABLED$1()
/*     */   {
/*     */     super(1);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantBuilderKt.GET_MULTIDEX_ENABLED.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */