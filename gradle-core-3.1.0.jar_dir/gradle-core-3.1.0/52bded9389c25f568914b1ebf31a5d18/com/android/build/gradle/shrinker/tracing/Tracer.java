package com.android.build.gradle.shrinker.tracing;

import java.util.Map;

public abstract interface Tracer<T>
{
  public abstract Trace<T> startTrace();
  
  public abstract void nodeReached(T paramT, Trace<T> paramTrace);
  
  public abstract Map<T, Trace<T>> getRecordedTraces();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.tracing.Tracer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */