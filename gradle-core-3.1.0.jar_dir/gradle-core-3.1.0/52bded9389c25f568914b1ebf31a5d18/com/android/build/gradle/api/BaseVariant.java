package com.android.build.gradle.api;

import com.android.build.gradle.tasks.AidlCompile;
import com.android.build.gradle.tasks.ExternalNativeBuildTask;
import com.android.build.gradle.tasks.GenerateBuildConfig;
import com.android.build.gradle.tasks.MergeResources;
import com.android.build.gradle.tasks.MergeSourceSetFolders;
import com.android.build.gradle.tasks.NdkCompile;
import com.android.build.gradle.tasks.RenderscriptCompile;
import com.android.builder.model.BuildType;
import com.android.builder.model.ProductFlavor;
import com.android.builder.model.SourceProvider;
import java.io.File;
import java.util.Collection;
import java.util.List;
import org.gradle.api.DomainObjectCollection;
import org.gradle.api.Task;
import org.gradle.api.artifacts.ArtifactCollection;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.file.ConfigurableFileTree;
import org.gradle.api.file.FileCollection;
import org.gradle.api.tasks.AbstractCopyTask;
import org.gradle.api.tasks.compile.JavaCompile;

public abstract interface BaseVariant
{
  public abstract String getName();
  
  public abstract String getDescription();
  
  public abstract String getDirName();
  
  public abstract String getBaseName();
  
  public abstract String getFlavorName();
  
  public abstract DomainObjectCollection<BaseVariantOutput> getOutputs();
  
  public abstract BuildType getBuildType();
  
  public abstract ProductFlavor getMergedFlavor();
  
  public abstract JavaCompileOptions getJavaCompileOptions();
  
  public abstract List<ProductFlavor> getProductFlavors();
  
  public abstract List<SourceProvider> getSourceSets();
  
  public abstract List<ConfigurableFileTree> getSourceFolders(SourceKind paramSourceKind);
  
  public abstract Configuration getCompileConfiguration();
  
  public abstract Configuration getAnnotationProcessorConfiguration();
  
  public abstract Configuration getRuntimeConfiguration();
  
  public abstract String getApplicationId();
  
  public abstract Task getPreBuild();
  
  public abstract Task getCheckManifest();
  
  public abstract AidlCompile getAidlCompile();
  
  public abstract RenderscriptCompile getRenderscriptCompile();
  
  public abstract MergeResources getMergeResources();
  
  public abstract MergeSourceSetFolders getMergeAssets();
  
  public abstract GenerateBuildConfig getGenerateBuildConfig();
  
  @Deprecated
  public abstract JavaCompile getJavaCompile()
    throws IllegalStateException;
  
  public abstract Task getJavaCompiler();
  
  public abstract FileCollection getCompileClasspath(Object paramObject);
  
  public abstract ArtifactCollection getCompileClasspathArtifacts(Object paramObject);
  
  public abstract NdkCompile getNdkCompile();
  
  public abstract Collection<ExternalNativeBuildTask> getExternalNativeBuildTasks();
  
  public abstract Task getObfuscation();
  
  public abstract File getMappingFile();
  
  public abstract AbstractCopyTask getProcessJavaResources();
  
  public abstract Task getAssemble();
  
  public abstract void addJavaSourceFoldersToModel(File... paramVarArgs);
  
  public abstract void addJavaSourceFoldersToModel(Collection<File> paramCollection);
  
  public abstract void registerJavaGeneratingTask(Task paramTask, File... paramVarArgs);
  
  public abstract void registerJavaGeneratingTask(Task paramTask, Collection<File> paramCollection);
  
  public abstract void registerExternalAptJavaOutput(ConfigurableFileTree paramConfigurableFileTree);
  
  public abstract void registerGeneratedResFolders(FileCollection paramFileCollection);
  
  @Deprecated
  public abstract void registerResGeneratingTask(Task paramTask, File... paramVarArgs);
  
  @Deprecated
  public abstract void registerResGeneratingTask(Task paramTask, Collection<File> paramCollection);
  
  public abstract Object registerPreJavacGeneratedBytecode(FileCollection paramFileCollection);
  
  @Deprecated
  public abstract Object registerGeneratedBytecode(FileCollection paramFileCollection);
  
  public abstract void registerPostJavacGeneratedBytecode(FileCollection paramFileCollection);
  
  public abstract void buildConfigField(String paramString1, String paramString2, String paramString3);
  
  public abstract void resValue(String paramString1, String paramString2, String paramString3);
  
  public abstract void missingDimensionStrategy(String paramString1, String paramString2);
  
  public abstract void missingDimensionStrategy(String paramString, String... paramVarArgs);
  
  public abstract void missingDimensionStrategy(String paramString, List<String> paramList);
  
  public abstract void setOutputsAreSigned(boolean paramBoolean);
  
  public abstract boolean getOutputsAreSigned();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.api.BaseVariant
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */