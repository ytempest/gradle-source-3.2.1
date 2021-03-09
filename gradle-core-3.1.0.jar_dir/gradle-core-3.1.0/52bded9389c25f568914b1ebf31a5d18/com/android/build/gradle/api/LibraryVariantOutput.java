package com.android.build.gradle.api;

import org.gradle.api.tasks.bundling.Zip;

public abstract interface LibraryVariantOutput
{
  @Deprecated
  public abstract Zip getPackageLibrary();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.LibraryVariantOutput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */