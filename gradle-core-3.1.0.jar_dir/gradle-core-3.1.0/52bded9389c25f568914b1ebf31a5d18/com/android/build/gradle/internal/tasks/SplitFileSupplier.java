package com.android.build.gradle.internal.tasks;

import com.android.build.FilterData;

public abstract interface SplitFileSupplier
  extends FileSupplier
{
  public abstract FilterData getFilterData();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.SplitFileSupplier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */