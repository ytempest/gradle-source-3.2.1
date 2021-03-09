package com.android.build.gradle.external.gnumake;

import java.io.File;
import java.util.List;

abstract interface OsFileConventions
{
  public abstract List<String> tokenizeCommandLineToEscaped(String paramString);
  
  public abstract List<String> tokenizeCommandLineToRaw(String paramString);
  
  public abstract List<String> splitCommandLine(String paramString);
  
  public abstract boolean isPathAbsolute(String paramString);
  
  public abstract String getFileParent(String paramString);
  
  public abstract String getFileName(String paramString);
  
  public abstract File toFile(String paramString);
  
  public abstract File toFile(File paramFile, String paramString);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.OsFileConventions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */