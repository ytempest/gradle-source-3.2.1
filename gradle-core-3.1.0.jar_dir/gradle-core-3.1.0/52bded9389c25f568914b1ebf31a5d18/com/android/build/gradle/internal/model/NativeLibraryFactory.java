package com.android.build.gradle.internal.model;

import com.android.build.gradle.internal.core.Abi;
import com.android.build.gradle.internal.scope.VariantScope;
import com.android.builder.model.NativeLibrary;
import java.util.Optional;

public abstract interface NativeLibraryFactory
{
  public abstract Optional<NativeLibrary> create(VariantScope paramVariantScope, String paramString, Abi paramAbi);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.model.NativeLibraryFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */