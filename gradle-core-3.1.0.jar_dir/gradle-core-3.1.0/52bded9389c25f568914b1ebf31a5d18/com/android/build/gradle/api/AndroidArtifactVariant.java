package com.android.build.gradle.api;

import com.android.builder.model.SigningConfig;
import java.util.Set;

public abstract interface AndroidArtifactVariant
  extends VersionedVariant
{
  public abstract SigningConfig getSigningConfig();
  
  public abstract boolean isSigningReady();
  
  public abstract Set<String> getCompatibleScreens();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.AndroidArtifactVariant
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */