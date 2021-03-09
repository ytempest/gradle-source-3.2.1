package com.android.build.gradle.internal.variant;

import com.android.build.gradle.internal.core.VariantConfiguration;
import com.android.build.gradle.internal.scope.VariantScope;
import com.android.builder.core.VariantType;

public abstract interface TestedVariantData
{
  public abstract void setTestVariantData(TestVariantData paramTestVariantData, VariantType paramVariantType);
  
  public abstract TestVariantData getTestVariantData(VariantType paramVariantType);
  
  public abstract VariantConfiguration getVariantConfiguration();
  
  public abstract VariantScope getScope();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.TestedVariantData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */