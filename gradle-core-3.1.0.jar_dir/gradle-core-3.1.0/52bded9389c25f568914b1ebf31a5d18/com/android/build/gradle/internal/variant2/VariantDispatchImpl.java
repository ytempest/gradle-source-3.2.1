/*    */ package com.android.build.gradle.internal.variant2;
/*    */ 
/*    */ import com.android.build.api.dsl.variant.AndroidTestVariant;
/*    */ import com.android.build.api.dsl.variant.UnitTestVariant;
/*    */ import com.android.build.api.dsl.variant.Variant;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000$\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\030\0002\0020\001B\005¢\006\002\020\002R\034\020\003\032\004\030\0010\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\032\020\t\032\0020\nX.¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R\034\020\017\032\004\030\0010\020X\016¢\006\016\n\000\032\004\b\021\020\022\"\004\b\023\020\024¨\006\025"}, d2={"Lcom/android/build/gradle/internal/variant2/VariantDispatchImpl;", "Lcom/android/build/gradle/internal/variant2/VariantDispatcher;", "()V", "androidTestVariant", "Lcom/android/build/api/dsl/variant/AndroidTestVariant;", "getAndroidTestVariant", "()Lcom/android/build/api/dsl/variant/AndroidTestVariant;", "setAndroidTestVariant", "(Lcom/android/build/api/dsl/variant/AndroidTestVariant;)V", "productionVariant", "Lcom/android/build/api/dsl/variant/Variant;", "getProductionVariant", "()Lcom/android/build/api/dsl/variant/Variant;", "setProductionVariant", "(Lcom/android/build/api/dsl/variant/Variant;)V", "unitTestVariant", "Lcom/android/build/api/dsl/variant/UnitTestVariant;", "getUnitTestVariant", "()Lcom/android/build/api/dsl/variant/UnitTestVariant;", "setUnitTestVariant", "(Lcom/android/build/api/dsl/variant/UnitTestVariant;)V", "gradle-core"})
/*    */ public final class VariantDispatchImpl
/*    */   implements VariantDispatcher
/*    */ {
/*    */   @NotNull
/*    */   public Variant productionVariant;
/*    */   @Nullable
/*    */   private AndroidTestVariant androidTestVariant;
/*    */   @Nullable
/*    */   private UnitTestVariant unitTestVariant;
/*    */   
/*    */   @NotNull
/*    */   public Variant getProductionVariant()
/*    */   {
/* 33 */     Variant tmp4_1 = productionVariant;
/*    */     
/* 33 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("productionVariant"); return tmp4_1; } public void setProductionVariant(@NotNull Variant <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");productionVariant = <set-?>; } @Nullable
/* 34 */   public AndroidTestVariant getAndroidTestVariant() { return androidTestVariant; } public void setAndroidTestVariant(@Nullable AndroidTestVariant <set-?>) { androidTestVariant = <set-?>; } @Nullable
/* 35 */   public UnitTestVariant getUnitTestVariant() { return unitTestVariant; } public void setUnitTestVariant(@Nullable UnitTestVariant <set-?>) { unitTestVariant = <set-?>; }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantDispatchImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */