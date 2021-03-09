package com.android.build.gradle.internal;

import com.android.build.gradle.internal.scope.TaskConfigAction;
import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.Task;

public abstract interface TaskFactory
{
  public abstract boolean containsKey(String paramString);
  
  public abstract Task findByName(String paramString);
  
  public abstract Task create(String paramString);
  
  public abstract <S extends Task> S create(String paramString, Class<S> paramClass);
  
  public abstract <T extends Task> T create(TaskConfigAction<T> paramTaskConfigAction);
  
  public abstract <T extends Task> T create(String paramString, Class<T> paramClass, Action<T> paramAction);
  
  public abstract DefaultTask create(String paramString, Action<DefaultTask> paramAction);
  
  public abstract void configure(String paramString, Action<? super Task> paramAction);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.TaskFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */