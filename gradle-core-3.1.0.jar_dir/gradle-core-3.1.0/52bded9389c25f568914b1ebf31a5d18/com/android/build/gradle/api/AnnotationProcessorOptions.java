package com.android.build.gradle.api;

import java.util.List;
import java.util.Map;

public abstract interface AnnotationProcessorOptions
{
  public abstract List<String> getClassNames();
  
  public abstract Map<String, String> getArguments();
  
  public abstract Boolean getIncludeCompileClasspath();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.AnnotationProcessorOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */