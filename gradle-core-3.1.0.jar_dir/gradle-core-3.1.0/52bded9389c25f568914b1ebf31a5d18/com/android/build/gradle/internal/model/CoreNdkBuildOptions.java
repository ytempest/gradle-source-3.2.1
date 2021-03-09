package com.android.build.gradle.internal.model;

import java.io.File;
import org.gradle.model.Managed;

@Managed
public abstract interface CoreNdkBuildOptions
{
  public abstract File getPath();
  
  public abstract void setPath(File paramFile);
  
  public abstract File getBuildStagingDirectory();
  
  public abstract void setBuildStagingDirectory(File paramFile);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.model.CoreNdkBuildOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */