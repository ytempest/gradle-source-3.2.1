package com.android.build.gradle.api;

import java.io.File;
import java.util.List;
import java.util.Set;
import org.gradle.api.file.ConfigurableFileTree;
import org.gradle.api.file.FileTree;
import org.gradle.api.tasks.util.PatternFilterable;

public abstract interface AndroidSourceDirectorySet
  extends PatternFilterable
{
  public abstract String getName();
  
  public abstract AndroidSourceDirectorySet srcDir(Object paramObject);
  
  public abstract AndroidSourceDirectorySet srcDirs(Object... paramVarArgs);
  
  public abstract AndroidSourceDirectorySet setSrcDirs(Iterable<?> paramIterable);
  
  public abstract FileTree getSourceFiles();
  
  public abstract PatternFilterable getFilter();
  
  public abstract List<ConfigurableFileTree> getSourceDirectoryTrees();
  
  public abstract Set<File> getSrcDirs();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.AndroidSourceDirectorySet
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */