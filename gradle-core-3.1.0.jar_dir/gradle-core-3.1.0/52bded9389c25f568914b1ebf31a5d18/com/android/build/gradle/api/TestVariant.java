package com.android.build.gradle.api;

import java.util.List;
import org.gradle.api.DefaultTask;

public abstract interface TestVariant
  extends ApkVariant
{
  public abstract BaseVariant getTestedVariant();
  
  public abstract DefaultTask getConnectedInstrumentTest();
  
  public abstract List<? extends DefaultTask> getProviderInstrumentTests();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.TestVariant
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */