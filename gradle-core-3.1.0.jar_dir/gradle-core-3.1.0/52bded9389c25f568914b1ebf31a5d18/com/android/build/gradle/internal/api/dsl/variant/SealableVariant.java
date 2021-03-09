package com.android.build.gradle.internal.api.dsl.variant;

import com.android.build.api.dsl.variant.Variant;
import com.android.build.gradle.internal.api.dsl.sealing.Sealable;
import com.android.builder.core.VariantType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\026\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\bf\030\0002\0020\0012\0020\002J\b\020\007\032\0020\001H&R\022\020\003\032\0020\004X¦\004¢\006\006\032\004\b\005\020\006¨\006\b"}, d2={"Lcom/android/build/gradle/internal/api/dsl/variant/SealableVariant;", "Lcom/android/build/api/dsl/variant/Variant;", "Lcom/android/build/gradle/internal/api/dsl/sealing/Sealable;", "variantType", "Lcom/android/builder/core/VariantType;", "getVariantType", "()Lcom/android/builder/core/VariantType;", "createShim", "gradle-core"})
public abstract interface SealableVariant
  extends Variant, Sealable
{
  @NotNull
  public abstract VariantType getVariantType();
  
  @NotNull
  public abstract Variant createShim();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.variant.SealableVariant
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */