package com.android.build.gradle.api;

import com.android.build.OutputFile;
import com.android.build.gradle.tasks.ManifestProcessorTask;
import com.android.build.gradle.tasks.ProcessAndroidResources;
import org.gradle.api.Task;
import org.gradle.model.Managed;

@Managed
public abstract interface BaseVariantOutput
  extends OutputFile
{
  public abstract ProcessAndroidResources getProcessResources();
  
  public abstract ManifestProcessorTask getProcessManifest();
  
  public abstract Task getAssemble();
  
  public abstract String getName();
  
  public abstract String getBaseName();
  
  public abstract String getDirName();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.BaseVariantOutput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */