/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.build.gradle.internal.InstantRunTaskManager;
/*     */ import com.android.build.gradle.internal.PostprocessingFeatures;
/*     */ import com.android.build.gradle.internal.core.Abi;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dependency.VariantDependencies;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.pipeline.TransformManager;
/*     */ import com.android.build.gradle.internal.pipeline.TransformTask;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.publishing.VariantPublishingSpec;
/*     */ import com.android.build.gradle.internal.tasks.CheckManifest;
/*     */ import com.android.build.gradle.internal.tasks.GenerateApkDataTask;
/*     */ import com.android.build.gradle.internal.tasks.databinding.DataBindingExportBuildInfoTask;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.tasks.AidlCompile;
/*     */ import com.android.build.gradle.tasks.ExternalNativeBuildTask;
/*     */ import com.android.build.gradle.tasks.ExternalNativeJsonGenerator;
/*     */ import com.android.build.gradle.tasks.GenerateBuildConfig;
/*     */ import com.android.build.gradle.tasks.ManifestProcessorTask;
/*     */ import com.android.build.gradle.tasks.MergeSourceSetFolders;
/*     */ import com.android.build.gradle.tasks.ProcessAndroidResources;
/*     */ import com.android.build.gradle.tasks.RenderscriptCompile;
/*     */ import com.android.builder.dexing.DexMergerTool;
/*     */ import com.android.builder.dexing.DexerTool;
/*     */ import com.android.builder.dexing.DexingType;
/*     */ import com.android.sdklib.AndroidVersion;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import org.gradle.api.DefaultTask;
/*     */ import org.gradle.api.Task;
/*     */ import org.gradle.api.artifacts.ArtifactCollection;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.Sync;
/*     */ import org.gradle.api.tasks.compile.JavaCompile;
/*     */ 
/*     */ public abstract interface VariantScope
/*     */   extends TransformVariantScope, InstantRunVariantScope, TaskOutputHolder
/*     */ {
/*     */   public abstract GlobalScope getGlobalScope();
/*     */   
/*     */   public abstract GradleVariantConfiguration getVariantConfiguration();
/*     */   
/*     */   public abstract VariantPublishingSpec getPublishingSpec();
/*     */   
/*     */   public abstract BaseVariantData getVariantData();
/*     */   
/*     */   public abstract CodeShrinker getCodeShrinker();
/*     */   
/*     */   public abstract List<File> getProguardFiles();
/*     */   
/*     */   public abstract List<File> getTestProguardFiles();
/*     */   
/*     */   public abstract List<File> getConsumerProguardFiles();
/*     */   
/*     */   public abstract PostprocessingFeatures getPostprocessingFeatures();
/*     */   
/*     */   public abstract boolean useResourceShrinker();
/*     */   
/*     */   public abstract boolean isCrunchPngs();
/*     */   
/*     */   public abstract InstantRunBuildContext getInstantRunBuildContext();
/*     */   
/*     */   public abstract boolean isTestOnly();
/*     */   
/*     */   public abstract boolean isBaseFeature();
/*     */   
/*     */   public abstract DexingType getDexingType();
/*     */   
/*     */   public abstract AndroidVersion getMinSdkVersion();
/*     */   
/*     */   public abstract TransformManager getTransformManager();
/*     */   
/*     */   public abstract Collection<Object> getNdkBuildable();
/*     */   
/*     */   public abstract void setNdkBuildable(Collection<Object> paramCollection);
/*     */   
/*     */   public abstract Collection<File> getNdkSoFolder();
/*     */   
/*     */   public abstract void setNdkSoFolder(Collection<File> paramCollection);
/*     */   
/*     */   public abstract File getNdkObjFolder();
/*     */   
/*     */   public abstract void setNdkObjFolder(File paramFile);
/*     */   
/*     */   public abstract File getNdkDebuggableLibraryFolders(Abi paramAbi);
/*     */   
/*     */   public abstract void addNdkDebuggableLibraryFolders(Abi paramAbi, File paramFile);
/*     */   
/*     */   public abstract BaseVariantData getTestedVariantData();
/*     */   
/*     */   public abstract File getInstantRunSplitApkOutputFolder();
/*     */   
/*     */   public abstract File getDefaultInstantRunApkLocation();
/*     */   
/*     */   public abstract FileCollection getJavaClasspath(AndroidArtifacts.ConsumedConfigType paramConsumedConfigType, AndroidArtifacts.ArtifactType paramArtifactType);
/*     */   
/*     */   public abstract FileCollection getJavaClasspath(AndroidArtifacts.ConsumedConfigType paramConsumedConfigType, AndroidArtifacts.ArtifactType paramArtifactType, Object paramObject);
/*     */   
/*     */   public abstract ArtifactCollection getJavaClasspathArtifacts(AndroidArtifacts.ConsumedConfigType paramConsumedConfigType, AndroidArtifacts.ArtifactType paramArtifactType, Object paramObject);
/*     */   
/*     */   public abstract boolean keepDefaultBootstrap();
/*     */   
/*     */   public abstract File getJavaOutputDir();
/*     */   
/*     */   public abstract BuildArtifactHolder getBuildArtifactHolder();
/*     */   
/*     */   public abstract FileCollection getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType paramConsumedConfigType, AndroidArtifacts.ArtifactScope paramArtifactScope, AndroidArtifacts.ArtifactType paramArtifactType);
/*     */   
/*     */   public abstract ArtifactCollection getArtifactCollection(AndroidArtifacts.ConsumedConfigType paramConsumedConfigType, AndroidArtifacts.ArtifactScope paramArtifactScope, AndroidArtifacts.ArtifactType paramArtifactType);
/*     */   
/*     */   public abstract FileCollection getLocalPackagedJars();
/*     */   
/*     */   public abstract FileCollection getProvidedOnlyClasspath();
/*     */   
/*     */   public abstract File getIntermediateJarOutputFolder();
/*     */   
/*     */   public abstract File getProguardComponentsJarFile();
/*     */   
/*     */   public abstract File getManifestKeepListProguardFile();
/*     */   
/*     */   public abstract File getConsumerProguardFile();
/*     */   
/*     */   public abstract File getMainDexListFile();
/*     */   
/*     */   public abstract File getRenderscriptSourceOutputDir();
/*     */   
/*     */   public abstract File getRenderscriptLibOutputDir();
/*     */   
/*     */   public abstract File getFinalResourcesDir();
/*     */   
/*     */   public abstract void setResourceOutputDir(File paramFile);
/*     */   
/*     */   public abstract File getDefaultMergeResourcesOutputDir();
/*     */   
/*     */   public abstract File getMergeResourcesOutputDir();
/*     */   
/*     */   public abstract void setMergeResourceOutputDir(File paramFile);
/*     */   
/*     */   public abstract File getCompiledResourcesOutputDir();
/*     */   
/*     */   public abstract File getResourceBlameLogDir();
/*     */   
/*     */   public abstract File getMergeNativeLibsOutputDir();
/*     */   
/*     */   public abstract File getMergeShadersOutputDir();
/*     */   
/*     */   public abstract File getBuildConfigSourceOutputDir();
/*     */   
/*     */   public abstract File getGeneratedAssetsDir(String paramString);
/*     */   
/*     */   public abstract File getGeneratedResOutputDir();
/*     */   
/*     */   public abstract File getGeneratedPngsOutputDir();
/*     */   
/*     */   public abstract File getRenderscriptResOutputDir();
/*     */   
/*     */   public abstract File getRenderscriptObjOutputDir();
/*     */   
/*     */   public abstract File getSourceFoldersJavaResDestinationDir();
/*     */   
/*     */   public abstract File getJavaResourcesDestinationDir();
/*     */   
/*     */   public abstract File getRClassSourceOutputDir();
/*     */   
/*     */   public abstract File getAidlSourceOutputDir();
/*     */   
/*     */   public abstract File getPackagedAidlDir();
/*     */   
/*     */   public abstract File getAarClassesJar();
/*     */   
/*     */   public abstract File getAarLibsDirectory();
/*     */   
/*     */   public abstract File getAnnotationZipFile();
/*     */   
/*     */   public abstract File getTypedefFile();
/*     */   
/*     */   public abstract File getIncrementalDir(String paramString);
/*     */   
/*     */   public abstract File getCoverageReportDir();
/*     */   
/*     */   public abstract File getClassOutputForDataBinding();
/*     */   
/*     */   public abstract File getLayoutInfoOutputForDataBinding();
/*     */   
/*     */   public abstract File getLayoutFolderOutputForDataBinding();
/*     */   
/*     */   public abstract File getLayoutInputFolderForDataBinding();
/*     */   
/*     */   public abstract File getBuildFolderForDataBindingCompiler();
/*     */   
/*     */   public abstract File getGeneratedClassListOutputFileForDataBinding();
/*     */   
/*     */   public abstract File getBundleArtifactFolderForDataBinding();
/*     */   
/*     */   public abstract File getProguardOutputFolder();
/*     */   
/*     */   public abstract File getProcessAndroidResourcesProguardOutputFile();
/*     */   
/*     */   public abstract File getGenerateSplitAbiResOutputDirectory();
/*     */   
/*     */   public abstract File getSplitDensityOrLanguagesPackagesOutputDirectory();
/*     */   
/*     */   public abstract File getSplitAbiPackagesOutputDirectory();
/*     */   
/*     */   public abstract File getFullApkPackagesOutputDirectory();
/*     */   
/*     */   public abstract File getSplitSupportDirectory();
/*     */   
/*     */   public abstract File getAaptFriendlyManifestOutputDirectory();
/*     */   
/*     */   public abstract File getInstantRunManifestOutputDirectory();
/*     */   
/*     */   public abstract File getMicroApkManifestFile();
/*     */   
/*     */   public abstract File getMicroApkResDirectory();
/*     */   
/*     */   public abstract File getAarLocation();
/*     */   
/*     */   public abstract File getAnnotationProcessorOutputDir();
/*     */   
/*     */   public abstract File getMainJarOutputDir();
/*     */   
/*     */   public abstract File getCompatibleScreensManifestDirectory();
/*     */   
/*     */   public abstract File getManifestOutputDirectory();
/*     */   
/*     */   public abstract File getApkLocation();
/*     */   
/*     */   public abstract ManifestProcessorTask getManifestProcessorTask();
/*     */   
/*     */   public abstract void setManifestProcessorTask(ManifestProcessorTask paramManifestProcessorTask);
/*     */   
/*     */   public abstract DefaultTask getAssembleTask();
/*     */   
/*     */   public abstract void setAssembleTask(DefaultTask paramDefaultTask);
/*     */   
/*     */   public abstract DefaultTask getPreBuildTask();
/*     */   
/*     */   public abstract void setPreBuildTask(DefaultTask paramDefaultTask);
/*     */   
/*     */   public abstract Task getSourceGenTask();
/*     */   
/*     */   public abstract void setSourceGenTask(Task paramTask);
/*     */   
/*     */   public abstract Task getResourceGenTask();
/*     */   
/*     */   public abstract void setResourceGenTask(Task paramTask);
/*     */   
/*     */   public abstract Task getAssetGenTask();
/*     */   
/*     */   public abstract void setAssetGenTask(Task paramTask);
/*     */   
/*     */   public abstract CheckManifest getCheckManifestTask();
/*     */   
/*     */   public abstract void setCheckManifestTask(CheckManifest paramCheckManifest);
/*     */   
/*     */   public abstract RenderscriptCompile getRenderscriptCompileTask();
/*     */   
/*     */   public abstract void setRenderscriptCompileTask(RenderscriptCompile paramRenderscriptCompile);
/*     */   
/*     */   public abstract AidlCompile getAidlCompileTask();
/*     */   
/*     */   public abstract void setAidlCompileTask(AidlCompile paramAidlCompile);
/*     */   
/*     */   public abstract MergeSourceSetFolders getMergeAssetsTask();
/*     */   
/*     */   public abstract void setMergeAssetsTask(MergeSourceSetFolders paramMergeSourceSetFolders);
/*     */   
/*     */   public abstract GenerateBuildConfig getGenerateBuildConfigTask();
/*     */   
/*     */   public abstract void setGenerateBuildConfigTask(GenerateBuildConfig paramGenerateBuildConfig);
/*     */   
/*     */   public abstract Sync getProcessJavaResourcesTask();
/*     */   
/*     */   public abstract void setProcessJavaResourcesTask(Sync paramSync);
/*     */   
/*     */   public abstract void setMergeJavaResourcesTask(TransformTask paramTransformTask);
/*     */   
/*     */   public abstract TransformTask getMergeJavaResourcesTask();
/*     */   
/*     */   public abstract JavaCompile getJavacTask();
/*     */   
/*     */   public abstract void setJavacTask(JavaCompile paramJavaCompile);
/*     */   
/*     */   public abstract Task getCompileTask();
/*     */   
/*     */   public abstract void setCompileTask(Task paramTask);
/*     */   
/*     */   public abstract DefaultTask getConnectedTask();
/*     */   
/*     */   public abstract void setConnectedTask(DefaultTask paramDefaultTask);
/*     */   
/*     */   public abstract GenerateApkDataTask getMicroApkTask();
/*     */   
/*     */   public abstract void setMicroApkTask(GenerateApkDataTask paramGenerateApkDataTask);
/*     */   
/*     */   public abstract Task getCoverageReportTask();
/*     */   
/*     */   public abstract void setCoverageReportTask(Task paramTask);
/*     */   
/*     */   public abstract ExternalNativeBuildTask getExternalNativeBuildTask();
/*     */   
/*     */   public abstract void setExternalNativeBuildTask(ExternalNativeBuildTask paramExternalNativeBuildTask);
/*     */   
/*     */   public abstract ExternalNativeJsonGenerator getExternalNativeJsonGenerator();
/*     */   
/*     */   public abstract void setExternalNativeJsonGenerator(ExternalNativeJsonGenerator paramExternalNativeJsonGenerator);
/*     */   
/*     */   public abstract InstantRunTaskManager getInstantRunTaskManager();
/*     */   
/*     */   public abstract void setInstantRunTaskManager(InstantRunTaskManager paramInstantRunTaskManager);
/*     */   
/*     */   public abstract File getProcessResourcePackageOutputDirectory();
/*     */   
/*     */   public abstract void setProcessResourcesTask(ProcessAndroidResources paramProcessAndroidResources);
/*     */   
/*     */   public abstract ProcessAndroidResources getProcessResourcesTask();
/*     */   
/*     */   public abstract void setDataBindingExportBuildInfoTask(DataBindingExportBuildInfoTask paramDataBindingExportBuildInfoTask);
/*     */   
/*     */   public abstract DataBindingExportBuildInfoTask getDataBindingExportBuildInfoTask();
/*     */   
/*     */   public abstract VariantDependencies getVariantDependencies();
/*     */   
/*     */   public abstract File getInstantRunResourceApkFolder();
/*     */   
/*     */   public abstract File getIntermediateDir(TaskOutputHolder.TaskOutputType paramTaskOutputType);
/*     */   
/*     */   public abstract Java8LangSupport getJava8LangSupportType();
/*     */   
/*     */   public abstract DexerTool getDexer();
/*     */   
/*     */   public abstract DexMergerTool getDexMerger();
/*     */   
/*     */   public abstract ConfigurableFileCollection getTryWithResourceRuntimeSupportJar();
/*     */   
/*     */   public static enum Java8LangSupport
/*     */   {
/* 473 */     INVALID, 
/* 474 */     UNUSED, 
/* 475 */     D8, 
/* 476 */     DESUGAR, 
/* 477 */     RETROLAMBDA;
/*     */     
/*     */     private Java8LangSupport() {}
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.VariantScope
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */