package com.android.build.gradle.internal.dsl;

import java.util.List;
import java.util.Set;

public abstract interface CoreExternalNativeNdkBuildOptions
{
  public abstract List<String> getArguments();
  
  public abstract List<String> getcFlags();
  
  public abstract List<String> getCppFlags();
  
  public abstract Set<String> getAbiFilters();
  
  public abstract Set<String> getTargets();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.CoreExternalNativeNdkBuildOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */