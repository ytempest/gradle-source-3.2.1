package com.android.build.gradle.internal.ndk;

public abstract interface NativeToolSpecification
{
  public abstract Iterable<String> getCFlags();
  
  public abstract Iterable<String> getCppFlags();
  
  public abstract Iterable<String> getLdFlags();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.NativeToolSpecification
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */