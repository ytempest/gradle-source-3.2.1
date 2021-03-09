package com.android.build.gradle.internal.scope;

import java.util.Collection;

public abstract interface TransformVariantScope
{
  public abstract String getFullVariantName();
  
  public abstract TransformGlobalScope getGlobalScope();
  
  public abstract String getTaskName(String paramString);
  
  public abstract String getTaskName(String paramString1, String paramString2);
  
  public abstract String getDirName();
  
  public abstract Collection<String> getDirectorySegments();
  
  public abstract OutputScope getOutputScope();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.TransformVariantScope
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */