package com.android.build.gradle.internal;

import com.android.build.gradle.internal.dsl.CoreProductFlavor;
import com.android.builder.model.SigningConfig;
import java.util.Map;

public abstract interface VariantModel
{
  public abstract ProductFlavorData<CoreProductFlavor> getDefaultConfig();
  
  public abstract Map<String, BuildTypeData> getBuildTypes();
  
  public abstract Map<String, ProductFlavorData<CoreProductFlavor>> getProductFlavors();
  
  public abstract Map<String, ? extends SigningConfig> getSigningConfigs();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.VariantModel
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */