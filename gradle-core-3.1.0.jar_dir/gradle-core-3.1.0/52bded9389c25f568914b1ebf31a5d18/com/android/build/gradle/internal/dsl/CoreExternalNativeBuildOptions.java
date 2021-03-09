package com.android.build.gradle.internal.dsl;

public abstract interface CoreExternalNativeBuildOptions
{
  public abstract CoreExternalNativeNdkBuildOptions getExternalNativeNdkBuildOptions();
  
  public abstract CoreExternalNativeCmakeOptions getExternalNativeCmakeOptions();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.CoreExternalNativeBuildOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */