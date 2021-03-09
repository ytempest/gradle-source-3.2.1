package com.android.build.gradle.internal.dsl;

import com.android.builder.model.SigningConfig;
import java.io.File;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.Optional;

public abstract interface CoreSigningConfig
  extends SigningConfig
{
  @InputFile
  @Optional
  public abstract File getStoreFile();
  
  @Input
  public abstract String getStorePassword();
  
  @Input
  public abstract String getKeyAlias();
  
  @Input
  public abstract String getStoreType();
  
  @Input
  public abstract boolean isV1SigningEnabled();
  
  @Input
  public abstract boolean isV2SigningEnabled();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.CoreSigningConfig
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */