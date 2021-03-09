package com.android.build.gradle.internal;

import org.gradle.api.invocation.Gradle;

abstract interface BuildSession
{
  public abstract void initialize(Gradle paramGradle);
  
  public abstract void executeOnce(String paramString1, String paramString2, Runnable paramRunnable);
  
  public abstract void executeOnceWhenBuildFinished(String paramString1, String paramString2, Runnable paramRunnable);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.BuildSession
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */