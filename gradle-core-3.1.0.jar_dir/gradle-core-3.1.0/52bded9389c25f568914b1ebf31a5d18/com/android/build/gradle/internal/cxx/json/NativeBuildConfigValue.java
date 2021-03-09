package com.android.build.gradle.internal.cxx.json;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class NativeBuildConfigValue
{
  public Collection<File> buildFiles;
  public List<String> cleanCommands;
  public Map<String, NativeLibraryValue> libraries;
  public Map<String, NativeToolchainValue> toolchains;
  public Collection<String> cFileExtensions;
  public Collection<String> cppFileExtensions;
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.cxx.json.NativeBuildConfigValue
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */