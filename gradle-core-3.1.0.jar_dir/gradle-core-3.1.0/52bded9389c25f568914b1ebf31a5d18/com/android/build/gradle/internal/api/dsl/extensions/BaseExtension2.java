package com.android.build.gradle.internal.api.dsl.extensions;

import com.android.build.api.dsl.extension.BuildProperties;
import com.android.build.api.dsl.extension.VariantAwareProperties;
import com.android.build.api.dsl.extension.VariantOrExtensionProperties;
import com.android.build.gradle.internal.api.dsl.sealing.Sealable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\036\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\bf\030\0002\0020\0012\0020\0022\0020\0032\0020\004R\022\020\005\032\0020\006X¦\004¢\006\006\032\004\b\007\020\b¨\006\t"}, d2={"Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "Lcom/android/build/api/dsl/extension/BuildProperties;", "Lcom/android/build/api/dsl/extension/VariantOrExtensionProperties;", "Lcom/android/build/api/dsl/extension/VariantAwareProperties;", "Lcom/android/build/gradle/internal/api/dsl/sealing/Sealable;", "variantExtensionProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "getVariantExtensionProperties", "()Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "gradle-core"})
public abstract interface BaseExtension2
  extends BuildProperties, VariantOrExtensionProperties, VariantAwareProperties, Sealable
{
  @NotNull
  public abstract VariantOrExtensionPropertiesImpl getVariantExtensionProperties();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.extensions.BaseExtension2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */