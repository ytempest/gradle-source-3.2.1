package com.android.build.gradle.api;

import org.gradle.api.artifacts.component.ComponentIdentifier;

public abstract interface TestedComponentIdentifier
  extends ComponentIdentifier
{
  public abstract String getVariantName();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.TestedComponentIdentifier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */