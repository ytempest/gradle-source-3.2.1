/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import com.android.build.api.dsl.model.VariantProperties;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.functions.Function2;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\024\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\0032\b\020\004\032\004\030\0010\005H\n¢\006\002\b\006"}, d2={"<anonymous>", "", "o", "Lcom/android/build/api/dsl/model/VariantProperties;", "v", "Ljava/io/File;", "invoke"})
/*     */ final class VariantBuilderKt$SET_MULTIDEX_KEEPFILE$1
/*     */   extends Lambda
/*     */   implements Function2<VariantProperties, File, Unit>
/*     */ {
/*     */   public static final 1 INSTANCE = new 1();
/*     */   
/*     */   public final void invoke(@NotNull VariantProperties o, @Nullable File v)
/*     */   {
/* 466 */     Intrinsics.checkParameterIsNotNull(o, "o");o.setMultiDexKeepFile(v);
/*     */   }
/*     */   
/*     */   VariantBuilderKt$SET_MULTIDEX_KEEPFILE$1()
/*     */   {
/*     */     super(2);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantBuilderKt.SET_MULTIDEX_KEEPFILE.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */