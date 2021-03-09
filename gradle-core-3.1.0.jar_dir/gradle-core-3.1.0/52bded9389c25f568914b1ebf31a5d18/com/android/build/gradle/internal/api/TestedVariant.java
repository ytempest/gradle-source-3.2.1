package com.android.build.gradle.internal.api;

import com.android.build.gradle.api.TestVariant;
import com.android.build.gradle.api.UnitTestVariant;

public abstract interface TestedVariant
{
  public abstract void setTestVariant(TestVariant paramTestVariant);
  
  public abstract TestVariant getTestVariant();
  
  public abstract UnitTestVariant getUnitTestVariant();
  
  public abstract void setUnitTestVariant(UnitTestVariant paramUnitTestVariant);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.TestedVariant
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */