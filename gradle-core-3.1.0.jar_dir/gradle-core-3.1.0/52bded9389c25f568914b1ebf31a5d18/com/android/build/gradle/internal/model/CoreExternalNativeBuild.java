package com.android.build.gradle.internal.model;

import org.gradle.model.Managed;

@Managed
public abstract interface CoreExternalNativeBuild
{
  public abstract CoreNdkBuildOptions getNdkBuild();
  
  public abstract CoreCmakeOptions getCmake();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.model.CoreExternalNativeBuild
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */