package com.android.build.gradle.internal.variant2;

import com.android.build.api.dsl.model.BuildType;
import com.android.build.api.dsl.model.DefaultConfig;
import com.android.build.api.dsl.model.ProductFlavor;
import com.android.build.api.dsl.options.SigningConfig;
import com.android.build.api.sourcesets.AndroidSourceSet;
import kotlin.Metadata;
import org.gradle.api.NamedDomainObjectContainer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0006\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\bf\030\0002\0020\001R\030\020\002\032\b\022\004\022\0020\0040\003X¦\004¢\006\006\032\004\b\005\020\006R\022\020\007\032\0020\bX¦\004¢\006\006\032\004\b\t\020\nR\030\020\013\032\b\022\004\022\0020\f0\003X¦\004¢\006\006\032\004\b\r\020\006R\030\020\016\032\b\022\004\022\0020\0170\003X¦\004¢\006\006\032\004\b\020\020\006R\030\020\021\032\b\022\004\022\0020\0220\003X¦\004¢\006\006\032\004\b\023\020\006¨\006\024"}, d2={"Lcom/android/build/gradle/internal/variant2/DslModelData;", "", "buildTypes", "Lorg/gradle/api/NamedDomainObjectContainer;", "Lcom/android/build/api/dsl/model/BuildType;", "getBuildTypes", "()Lorg/gradle/api/NamedDomainObjectContainer;", "defaultConfig", "Lcom/android/build/api/dsl/model/DefaultConfig;", "getDefaultConfig", "()Lcom/android/build/api/dsl/model/DefaultConfig;", "productFlavors", "Lcom/android/build/api/dsl/model/ProductFlavor;", "getProductFlavors", "signingConfigs", "Lcom/android/build/api/dsl/options/SigningConfig;", "getSigningConfigs", "sourceSets", "Lcom/android/build/api/sourcesets/AndroidSourceSet;", "getSourceSets", "gradle-core"})
public abstract interface DslModelData
{
  @NotNull
  public abstract DefaultConfig getDefaultConfig();
  
  @NotNull
  public abstract NamedDomainObjectContainer<AndroidSourceSet> getSourceSets();
  
  @NotNull
  public abstract NamedDomainObjectContainer<ProductFlavor> getProductFlavors();
  
  @NotNull
  public abstract NamedDomainObjectContainer<BuildType> getBuildTypes();
  
  @NotNull
  public abstract NamedDomainObjectContainer<SigningConfig> getSigningConfigs();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.DslModelData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */