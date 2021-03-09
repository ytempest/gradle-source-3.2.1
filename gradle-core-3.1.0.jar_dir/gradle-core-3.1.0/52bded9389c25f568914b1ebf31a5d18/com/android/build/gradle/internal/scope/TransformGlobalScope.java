package com.android.build.gradle.internal.scope;

import com.android.build.gradle.options.ProjectOptions;
import com.android.builder.model.OptionalCompilationStep;
import com.android.builder.utils.FileCache;
import java.io.File;
import org.gradle.api.Project;

public abstract interface TransformGlobalScope
{
  public abstract Project getProject();
  
  public abstract File getBuildDir();
  
  public abstract boolean isActive(OptionalCompilationStep paramOptionalCompilationStep);
  
  public abstract ProjectOptions getProjectOptions();
  
  public abstract FileCache getBuildCache();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.TransformGlobalScope
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */