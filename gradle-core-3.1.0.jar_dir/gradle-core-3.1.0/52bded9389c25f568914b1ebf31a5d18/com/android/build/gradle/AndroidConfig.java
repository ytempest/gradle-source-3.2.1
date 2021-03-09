package com.android.build.gradle;

import com.android.build.api.transform.Transform;
import com.android.build.api.variant.VariantFilter;
import com.android.build.gradle.api.AndroidSourceSet;
import com.android.build.gradle.api.BaseVariantOutput;
import com.android.build.gradle.internal.CompileOptions;
import com.android.build.gradle.internal.coverage.JacocoOptions;
import com.android.build.gradle.internal.dsl.AaptOptions;
import com.android.build.gradle.internal.dsl.AdbOptions;
import com.android.build.gradle.internal.dsl.CoreBuildType;
import com.android.build.gradle.internal.dsl.CoreProductFlavor;
import com.android.build.gradle.internal.dsl.DexOptions;
import com.android.build.gradle.internal.dsl.LintOptions;
import com.android.build.gradle.internal.dsl.PackagingOptions;
import com.android.build.gradle.internal.dsl.Splits;
import com.android.build.gradle.internal.dsl.TestOptions;
import com.android.build.gradle.internal.model.CoreExternalNativeBuild;
import com.android.builder.core.LibraryRequest;
import com.android.builder.model.DataBindingOptions;
import com.android.builder.model.SigningConfig;
import com.android.builder.testing.api.DeviceProvider;
import com.android.builder.testing.api.TestServer;
import com.android.repository.Revision;
import java.util.Collection;
import java.util.List;
import org.gradle.api.Action;
import org.gradle.api.Incubating;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.tasks.Internal;

public abstract interface AndroidConfig
{
  public abstract String getBuildToolsVersion();
  
  public abstract String getCompileSdkVersion();
  
  @Internal
  public abstract Revision getBuildToolsRevision();
  
  public abstract String getDefaultPublishConfig();
  
  public abstract Action<VariantFilter> getVariantFilter();
  
  public abstract AdbOptions getAdbOptions();
  
  public abstract String getResourcePrefix();
  
  public abstract List<String> getFlavorDimensionList();
  
  @Incubating
  public abstract boolean getGeneratePureSplits();
  
  public abstract CoreProductFlavor getDefaultConfig();
  
  public abstract AaptOptions getAaptOptions();
  
  public abstract CompileOptions getCompileOptions();
  
  public abstract DexOptions getDexOptions();
  
  public abstract JacocoOptions getJacoco();
  
  public abstract LintOptions getLintOptions();
  
  public abstract CoreExternalNativeBuild getExternalNativeBuild();
  
  public abstract PackagingOptions getPackagingOptions();
  
  public abstract Splits getSplits();
  
  public abstract TestOptions getTestOptions();
  
  public abstract List<DeviceProvider> getDeviceProviders();
  
  public abstract List<TestServer> getTestServers();
  
  public abstract List<Transform> getTransforms();
  
  public abstract List<List<Object>> getTransformsDependencies();
  
  public abstract Collection<? extends CoreProductFlavor> getProductFlavors();
  
  public abstract Collection<? extends CoreBuildType> getBuildTypes();
  
  public abstract Collection<? extends SigningConfig> getSigningConfigs();
  
  public abstract NamedDomainObjectContainer<AndroidSourceSet> getSourceSets();
  
  public abstract Collection<BaseVariantOutput> getBuildOutputs();
  
  public abstract Boolean getPackageBuildConfig();
  
  public abstract Collection<String> getAidlPackageWhiteList();
  
  public abstract Collection<LibraryRequest> getLibraryRequests();
  
  public abstract DataBindingOptions getDataBinding();
  
  public abstract Boolean getBaseFeature();
  
  public abstract String getTestBuildType();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.AndroidConfig
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */