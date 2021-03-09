package com.android.build.gradle.internal.ndk;

import com.android.build.gradle.internal.core.Abi;
import com.android.build.gradle.internal.core.Toolchain;
import java.io.File;
import java.util.Collection;

public abstract interface NdkInfo
{
  public abstract File getRootDirectory();
  
  public abstract String getCompilerSysrootPath(Abi paramAbi, String paramString, boolean paramBoolean);
  
  public abstract String getLinkerSysrootPath(Abi paramAbi, String paramString);
  
  public abstract String findLatestPlatformVersion(String paramString);
  
  public abstract int findSuitablePlatformVersion(String paramString, int paramInt);
  
  public abstract File getCCompiler(Toolchain paramToolchain, String paramString, Abi paramAbi);
  
  public abstract File getCppCompiler(Toolchain paramToolchain, String paramString, Abi paramAbi);
  
  public abstract File getLinker(Toolchain paramToolchain, String paramString, Abi paramAbi);
  
  public abstract File getAssembler(Toolchain paramToolchain, String paramString, Abi paramAbi);
  
  public abstract File getAr(Toolchain paramToolchain, String paramString, Abi paramAbi);
  
  public abstract File getStripExecutable(Toolchain paramToolchain, String paramString, Abi paramAbi);
  
  public abstract StlNativeToolSpecification getStlNativeToolSpecification(Stl paramStl, String paramString, Abi paramAbi);
  
  public abstract File getToolchainPath(Toolchain paramToolchain, String paramString, Abi paramAbi);
  
  public abstract String getDefaultToolchainVersion(Toolchain paramToolchain, Abi paramAbi);
  
  public abstract Collection<Abi> getDefault32BitsAbis();
  
  public abstract Collection<Abi> getDefaultAbis();
  
  public abstract Collection<Abi> getSupported32BitsAbis();
  
  public abstract Collection<Abi> getSupportedAbis();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.NdkInfo
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */