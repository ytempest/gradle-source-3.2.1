package com.android.build.gradle.shrinker;

public enum DependencyType
{
  REQUIRED_CODE_REFERENCE,  REQUIRED_CODE_REFERENCE_REFLECTION,  REQUIRED_CLASS_STRUCTURE,  REQUIRED_KEEP_RULES,  IF_CLASS_KEPT,  CLASS_IS_KEPT,  SUPERINTERFACE_KEPT,  INTERFACE_IMPLEMENTED;
  
  private DependencyType() {}
}

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */