package com.android.build.gradle.shrinker;

import java.util.Map;

public abstract interface KeepRules
{
  public abstract <T> Map<T, DependencyType> getSymbolsToKeep(T paramT, ShrinkerGraph<T> paramShrinkerGraph);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.KeepRules
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */