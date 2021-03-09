package com.android.build.gradle.api;

import com.android.build.VariantOutput.FilterType;
import com.android.build.gradle.tasks.PackageAndroidArtifact;
import org.gradle.api.Task;

public abstract interface ApkVariantOutput
  extends BaseVariantOutput
{
  public abstract PackageAndroidArtifact getPackageApplication();
  
  public abstract Task getZipAlign();
  
  public abstract void setVersionCodeOverride(int paramInt);
  
  public abstract int getVersionCodeOverride();
  
  public abstract void setVersionNameOverride(String paramString);
  
  public abstract String getVersionNameOverride();
  
  public abstract String getFilter(VariantOutput.FilterType paramFilterType);
  
  public abstract String getOutputFileName();
  
  public abstract void setOutputFileName(String paramString);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.ApkVariantOutput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */