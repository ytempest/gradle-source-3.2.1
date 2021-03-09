package com.android.build.gradle.internal.variant2;

import com.android.build.api.dsl.variant.AndroidTestVariant;
import com.android.build.api.dsl.variant.UnitTestVariant;
import com.android.build.api.dsl.variant.Variant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\bf\030\0002\0020\001R\024\020\002\032\004\030\0010\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\007X¦\004¢\006\006\032\004\b\b\020\tR\024\020\n\032\004\030\0010\013X¦\004¢\006\006\032\004\b\f\020\r¨\006\016"}, d2={"Lcom/android/build/gradle/internal/variant2/VariantDispatcher;", "", "androidTestVariant", "Lcom/android/build/api/dsl/variant/AndroidTestVariant;", "getAndroidTestVariant", "()Lcom/android/build/api/dsl/variant/AndroidTestVariant;", "productionVariant", "Lcom/android/build/api/dsl/variant/Variant;", "getProductionVariant", "()Lcom/android/build/api/dsl/variant/Variant;", "unitTestVariant", "Lcom/android/build/api/dsl/variant/UnitTestVariant;", "getUnitTestVariant", "()Lcom/android/build/api/dsl/variant/UnitTestVariant;", "gradle-core"})
public abstract interface VariantDispatcher
{
  @NotNull
  public abstract Variant getProductionVariant();
  
  @Nullable
  public abstract AndroidTestVariant getAndroidTestVariant();
  
  @Nullable
  public abstract UnitTestVariant getUnitTestVariant();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantDispatcher
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */