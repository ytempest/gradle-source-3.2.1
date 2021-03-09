package com.android.build.gradle.api;

import java.io.File;

public abstract interface AndroidSourceFile
{
  public abstract String getName();
  
  public abstract File getSrcFile();
  
  public abstract AndroidSourceFile srcFile(Object paramObject);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.AndroidSourceFile
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */