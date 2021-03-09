package com.android.build.gradle.internal;

import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;

public enum TaskManager$MergeType
{
  MERGE,  PACKAGE;
  
  private TaskManager$MergeType() {}
  
  public abstract TaskOutputHolder.TaskOutputType getOutputType();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.TaskManager.MergeType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */