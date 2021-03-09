package com.android.build.gradle;

public abstract interface TestAndroidConfig
  extends AndroidConfig
{
  public abstract String getTargetProjectPath();
  
  @Deprecated
  public abstract String getTargetVariant();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.TestAndroidConfig
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */