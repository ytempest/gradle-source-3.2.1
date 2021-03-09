package com.android.build.gradle.api;

import com.android.build.gradle.internal.api.TestedVariant;
import org.gradle.api.tasks.bundling.Zip;

public abstract interface LibraryVariant
  extends BaseVariant, TestedVariant
{
  public abstract Zip getPackageLibrary();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.LibraryVariant
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */