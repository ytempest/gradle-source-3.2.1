package com.android.build.gradle.internal.ndk;

import com.android.build.gradle.internal.core.Abi;

public abstract interface StlSpecificationFactory
{
  public abstract StlSpecification create(Stl paramStl, String paramString, Abi paramAbi);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.StlSpecificationFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */