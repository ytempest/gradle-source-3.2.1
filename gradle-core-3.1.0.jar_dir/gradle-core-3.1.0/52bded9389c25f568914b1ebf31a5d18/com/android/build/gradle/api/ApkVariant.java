package com.android.build.gradle.api;

import com.android.build.gradle.tasks.PackageAndroidArtifact;

public abstract interface ApkVariant
  extends BaseVariant, InstallableVariant, AndroidArtifactVariant
{
  @Deprecated
  public abstract Object getDex();
  
  public abstract PackageAndroidArtifact getPackageApplication();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.ApkVariant
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */