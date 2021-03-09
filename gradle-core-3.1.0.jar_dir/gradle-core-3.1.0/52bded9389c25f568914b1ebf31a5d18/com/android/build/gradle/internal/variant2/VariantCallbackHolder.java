package com.android.build.gradle.internal.variant2;

import com.android.build.api.dsl.extension.VariantCallbackHandler;
import com.android.build.api.dsl.variant.Variant;
import kotlin.Metadata;
import org.gradle.api.Action;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000&\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J\016\020\002\032\b\022\004\022\0020\0040\003H&J\036\020\005\032\0020\0062\006\020\007\032\0020\b2\f\020\t\032\b\022\004\022\0020\0040\nH&¨\006\013"}, d2={"Lcom/android/build/gradle/internal/variant2/VariantCallbackHolder;", "", "createVariantCallbackHandler", "Lcom/android/build/api/dsl/extension/VariantCallbackHandler;", "Lcom/android/build/api/dsl/variant/Variant;", "register", "", "predicate", "Lcom/android/build/gradle/internal/variant2/VariantPredicate;", "action", "Lorg/gradle/api/Action;", "gradle-core"})
public abstract interface VariantCallbackHolder
{
  public abstract void register(@NotNull VariantPredicate paramVariantPredicate, @NotNull Action<Variant> paramAction);
  
  @NotNull
  public abstract VariantCallbackHandler<Variant> createVariantCallbackHandler();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantCallbackHolder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */