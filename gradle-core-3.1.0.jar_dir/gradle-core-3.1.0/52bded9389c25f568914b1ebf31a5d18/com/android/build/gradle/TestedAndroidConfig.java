package com.android.build.gradle;

import com.android.build.gradle.api.TestVariant;
import com.android.build.gradle.api.UnitTestVariant;
import org.gradle.api.DomainObjectSet;

public abstract interface TestedAndroidConfig
  extends AndroidConfig
{
  public abstract String getTestBuildType();
  
  public abstract DomainObjectSet<TestVariant> getTestVariants();
  
  public abstract DomainObjectSet<UnitTestVariant> getUnitTestVariants();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.TestedAndroidConfig
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */