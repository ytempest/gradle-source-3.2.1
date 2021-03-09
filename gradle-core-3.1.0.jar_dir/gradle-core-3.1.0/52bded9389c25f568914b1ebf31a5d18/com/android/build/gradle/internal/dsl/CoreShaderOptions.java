package com.android.build.gradle.internal.dsl;

import com.google.common.collect.ListMultimap;
import java.util.List;

public abstract interface CoreShaderOptions
{
  public abstract List<String> getGlslcArgs();
  
  public abstract ListMultimap<String, String> getScopedGlslcArgs();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.CoreShaderOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */