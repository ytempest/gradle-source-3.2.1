package com.android.build.gradle.api;

import org.gradle.api.DefaultTask;

public abstract interface InstallableVariant
{
  public abstract DefaultTask getInstall();
  
  public abstract DefaultTask getUninstall();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.InstallableVariant
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */