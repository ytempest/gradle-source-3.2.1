package com.android.build.gradle.internal.dsl;

import java.util.List;
import java.util.Set;

public abstract interface CoreNdkOptions
{
  public abstract String getModuleName();
  
  public abstract String getcFlags();
  
  public abstract List<String> getLdLibs();
  
  public abstract Set<String> getAbiFilters();
  
  public abstract String getStl();
  
  public abstract Integer getJobs();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.CoreNdkOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */