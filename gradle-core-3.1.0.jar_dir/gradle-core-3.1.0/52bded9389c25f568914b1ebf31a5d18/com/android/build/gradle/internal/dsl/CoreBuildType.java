package com.android.build.gradle.internal.dsl;

import com.android.build.gradle.api.JavaCompileOptions;
import com.android.builder.model.BuildType;

public abstract interface CoreBuildType
  extends BuildType
{
  public abstract CoreNdkOptions getNdkConfig();
  
  public abstract CoreExternalNativeBuildOptions getExternalNativeBuildOptions();
  
  public abstract JavaCompileOptions getJavaCompileOptions();
  
  public abstract CoreShaderOptions getShaders();
  
  @Deprecated
  public abstract boolean isShrinkResources();
  
  @Deprecated
  public abstract Boolean isUseProguard();
  
  public abstract Boolean isCrunchPngs();
  
  @Deprecated
  public abstract boolean isCrunchPngsDefault();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.CoreBuildType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */