package com.android.build.gradle.api;

import com.android.build.gradle.internal.api.TestedVariant;

public abstract interface UnitTestVariant
  extends BaseVariant
{
  public abstract TestedVariant getTestedVariant();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.UnitTestVariant
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */