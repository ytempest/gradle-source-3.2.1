package com.android.build.gradle.options;

import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;

public abstract interface Option<T>
{
  public abstract String getPropertyName();
  
  public abstract T getDefaultValue();
  
  public abstract T parse(Object paramObject);
  
  public abstract boolean isDeprecated();
  
  public abstract DeprecationReporter.DeprecationTarget getDeprecationTarget();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.options.Option
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */