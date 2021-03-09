package com.android.build.gradle.internal.transforms;

import com.android.build.gradle.internal.scope.InstantRunVariantScope;
import java.io.File;

public enum InstantRunBuildType
{
  RELOAD,  RESTART;
  
  private InstantRunBuildType() {}
  
  abstract File getOutputFolder(InstantRunVariantScope paramInstantRunVariantScope);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunBuildType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */