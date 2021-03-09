package com.android.build.gradle.internal.scope;

import org.gradle.api.Action;

public abstract interface TaskConfigAction<T>
  extends Action<T>
{
  public abstract String getName();
  
  public abstract Class<T> getType();
  
  public abstract void execute(T paramT);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.TaskConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */