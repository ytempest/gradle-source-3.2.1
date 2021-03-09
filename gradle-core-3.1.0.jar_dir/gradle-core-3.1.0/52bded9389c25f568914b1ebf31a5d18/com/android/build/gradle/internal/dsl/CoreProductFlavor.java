package com.android.build.gradle.internal.dsl;

import com.android.build.gradle.api.JavaCompileOptions;
import com.android.builder.model.ProductFlavor;
import org.gradle.api.Named;

public abstract interface CoreProductFlavor
  extends ProductFlavor, Named
{
  public abstract CoreNdkOptions getNdkConfig();
  
  public abstract CoreExternalNativeBuildOptions getExternalNativeBuildOptions();
  
  public abstract JavaCompileOptions getJavaCompileOptions();
  
  public abstract CoreShaderOptions getShaders();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.CoreProductFlavor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */