package com.android.build.gradle.internal.ndk;

import java.io.File;
import java.util.List;

public abstract interface NativeLibrarySpecification
{
  public abstract List<File> getIncludes();
  
  public abstract List<File> getStaticLibs();
  
  public abstract List<File> getSharedLibs();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.NativeLibrarySpecification
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */