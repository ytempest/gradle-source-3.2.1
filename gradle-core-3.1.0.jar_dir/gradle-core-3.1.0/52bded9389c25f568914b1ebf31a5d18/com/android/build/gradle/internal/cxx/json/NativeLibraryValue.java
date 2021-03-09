package com.android.build.gradle.internal.cxx.json;

import java.io.File;
import java.util.Collection;

public class NativeLibraryValue
{
  public String buildCommand;
  public String buildType;
  public String toolchain;
  public String groupName;
  public String abi;
  public String artifactName;
  public Collection<NativeSourceFolderValue> folders;
  public Collection<NativeSourceFileValue> files;
  public Collection<File> exportedHeaders;
  public File output;
  public Collection<File> runtimeFiles;
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.cxx.json.NativeLibraryValue
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */