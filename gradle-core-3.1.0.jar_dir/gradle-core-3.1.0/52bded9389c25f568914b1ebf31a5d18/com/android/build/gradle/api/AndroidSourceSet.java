package com.android.build.gradle.api;

import groovy.lang.Closure;

public abstract interface AndroidSourceSet
{
  public abstract String getName();
  
  public abstract AndroidSourceDirectorySet getResources();
  
  public abstract AndroidSourceSet resources(Closure paramClosure);
  
  public abstract AndroidSourceDirectorySet getJava();
  
  public abstract AndroidSourceSet java(Closure paramClosure);
  
  @Deprecated
  public abstract String getCompileConfigurationName();
  
  @Deprecated
  public abstract String getPackageConfigurationName();
  
  @Deprecated
  public abstract String getProvidedConfigurationName();
  
  public abstract String getApiConfigurationName();
  
  public abstract String getCompileOnlyConfigurationName();
  
  public abstract String getImplementationConfigurationName();
  
  public abstract String getRuntimeOnlyConfigurationName();
  
  public abstract String getWearAppConfigurationName();
  
  public abstract String getAnnotationProcessorConfigurationName();
  
  public abstract AndroidSourceFile getManifest();
  
  public abstract AndroidSourceSet manifest(Closure paramClosure);
  
  public abstract AndroidSourceDirectorySet getRes();
  
  public abstract AndroidSourceSet res(Closure paramClosure);
  
  public abstract AndroidSourceDirectorySet getAssets();
  
  public abstract AndroidSourceSet assets(Closure paramClosure);
  
  public abstract AndroidSourceDirectorySet getAidl();
  
  public abstract AndroidSourceSet aidl(Closure paramClosure);
  
  public abstract AndroidSourceDirectorySet getRenderscript();
  
  public abstract AndroidSourceSet renderscript(Closure paramClosure);
  
  public abstract AndroidSourceDirectorySet getJni();
  
  public abstract AndroidSourceSet jni(Closure paramClosure);
  
  public abstract AndroidSourceDirectorySet getJniLibs();
  
  public abstract AndroidSourceSet jniLibs(Closure paramClosure);
  
  public abstract AndroidSourceDirectorySet getShaders();
  
  public abstract AndroidSourceSet shaders(Closure paramClosure);
  
  public abstract AndroidSourceSet setRoot(String paramString);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.AndroidSourceSet
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */