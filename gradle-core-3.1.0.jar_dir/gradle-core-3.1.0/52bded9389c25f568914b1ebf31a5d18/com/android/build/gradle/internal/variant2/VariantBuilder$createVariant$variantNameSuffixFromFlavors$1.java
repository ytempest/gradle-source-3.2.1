/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import com.android.build.api.dsl.model.BuildTypeOrProductFlavor;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\024\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\020\000\032\004\030\0010\001\"\n\b\000\020\002 \000*\0020\0032\006\020\004\032\0020\005H\n¢\006\002\b\006"}, d2={"<anonymous>", "", "E", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "it", "Lcom/android/build/api/dsl/model/BuildTypeOrProductFlavor;", "invoke"})
/*     */ final class VariantBuilder$createVariant$variantNameSuffixFromFlavors$1
/*     */   extends Lambda
/*     */   implements Function1<BuildTypeOrProductFlavor, String>
/*     */ {
/*     */   public static final 1 INSTANCE = new 1();
/*     */   
/*     */   @Nullable
/*     */   public final String invoke(@NotNull BuildTypeOrProductFlavor it)
/*     */   {
/* 226 */     Intrinsics.checkParameterIsNotNull(it, "it");return it.getVersionNameSuffix();
/*     */   }
/*     */   
/*     */   VariantBuilder$createVariant$variantNameSuffixFromFlavors$1()
/*     */   {
/*     */     super(1);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantBuilder.createVariant.variantNameSuffixFromFlavors.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */