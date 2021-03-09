package com.android.build.gradle.internal.model;

import java.io.File;
import org.gradle.model.Managed;

@Managed
public abstract interface CoreCmakeOptions
{
  public abstract File getPath();
  
  public abstract void setPath(File paramFile);
  
  public abstract File getBuildStagingDirectory();
  
  public abstract void setBuildStagingDirectory(File paramFile);
  
  public abstract String getVersion();
  
  public abstract void setVersion(String paramString);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.model.CoreCmakeOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */