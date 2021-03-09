package com.android.build.gradle.internal.scope;

import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
import com.android.build.gradle.tasks.PackageApplication;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.util.List;
import org.gradle.api.DefaultTask;

public abstract interface InstantRunVariantScope
{
  public abstract String getFullVariantName();
  
  public abstract TransformVariantScope getTransformVariantScope();
  
  public abstract TransformGlobalScope getGlobalScope();
  
  public abstract File getBuildInfoOutputFolder();
  
  public abstract File getReloadDexOutputFolder();
  
  public abstract File getRestartDexOutputFolder();
  
  public abstract File getManifestCheckerDir();
  
  public abstract File getInstantRunMainApkResourcesDir();
  
  public abstract File getIncrementalVerifierDir();
  
  public abstract InstantRunBuildContext getInstantRunBuildContext();
  
  public abstract File getInstantRunPastIterationsFolder();
  
  public abstract File getIncrementalRuntimeSupportJar();
  
  public abstract File getIncrementalApplicationSupportDir();
  
  public abstract File getInstantRunResourcesFile();
  
  public abstract ImmutableList<File> getInstantRunBootClasspath();
  
  public abstract List<DefaultTask> getColdSwapBuildTasks();
  
  public abstract void addColdSwapBuildTask(DefaultTask paramDefaultTask);
  
  public abstract PackageApplication getPackageApplicationTask();
  
  public abstract void setPackageApplicationTask(PackageApplication paramPackageApplication);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.InstantRunVariantScope
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */