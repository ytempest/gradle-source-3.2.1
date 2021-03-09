/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.aapt.AaptGeneration;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.AbiSplitOptions;
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.dsl.DensitySplitOptions;
/*     */ import com.android.build.gradle.internal.dsl.DslAdaptersKt;
/*     */ import com.android.build.gradle.internal.dsl.Splits;
/*     */ import com.android.build.gradle.internal.incremental.FileType;
/*     */ import com.android.build.gradle.internal.pipeline.StreamFilter;
/*     */ import com.android.build.gradle.internal.pipeline.TransformManager;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.OutputScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.internal.variant.MultiOutputPolicy;
/*     */ import com.android.build.gradle.internal.variant.TaskContainer.TaskKind;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.build.gradle.options.StringOption;
/*     */ import com.android.builder.internal.aapt.AaptOptions;
/*     */ import com.android.builder.utils.FileCache;
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.io.File;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public abstract class PackageAndroidArtifact$ConfigAction<T extends PackageAndroidArtifact>
/*     */   implements TaskConfigAction<T>
/*     */ {
/*     */   protected final Project project;
/*     */   protected final VariantScope variantScope;
/*     */   protected final FileCollection manifests;
/*     */   protected final TaskOutputHolder.TaskOutputType inputResourceFilesType;
/*     */   protected final File outputDirectory;
/*     */   protected final OutputScope outputScope;
/*     */   private final FileCache fileCache;
/*     */   private final TaskOutputHolder.TaskOutputType manifestType;
/*     */   
/*     */   public PackageAndroidArtifact$ConfigAction(VariantScope variantScope, File outputDirectory, TaskOutputHolder.TaskOutputType inputResourceFilesType, FileCollection manifests, TaskOutputHolder.TaskOutputType manifestType, FileCache fileCache, OutputScope outputScope)
/*     */   {
/* 874 */     project = variantScope.getGlobalScope().getProject();
/* 875 */     this.variantScope = ((VariantScope)Preconditions.checkNotNull(variantScope));
/* 876 */     this.inputResourceFilesType = inputResourceFilesType;
/* 877 */     this.manifests = manifests;
/* 878 */     this.outputDirectory = outputDirectory;
/* 879 */     this.outputScope = outputScope;
/* 880 */     this.manifestType = manifestType;
/* 881 */     this.fileCache = fileCache;
/*     */   }
/*     */   
/*     */   public void execute(T packageAndroidArtifact)
/*     */   {
/* 886 */     GlobalScope globalScope = variantScope.getGlobalScope();
/*     */     
/* 888 */     GradleVariantConfiguration variantConfiguration = variantScope.getVariantConfiguration();
/*     */     
/* 890 */     instantRunFileType = FileType.MAIN;
/* 891 */     taskInputType = inputResourceFilesType;
/* 892 */     packageAndroidArtifact.setAndroidBuilder(globalScope.getAndroidBuilder());
/* 893 */     packageAndroidArtifact.setVariantName(variantScope.getFullVariantName());
/* 894 */     packageAndroidArtifact.setMinSdkVersion(variantScope.getMinSdkVersion());
/* 895 */     instantRunContext = variantScope.getInstantRunBuildContext();
/*     */     
/* 898 */     aaptIntermediateFolder = new File(variantScope.getIncrementalDir(packageAndroidArtifact.getName()), "aapt-temp");
/*     */     
/* 901 */     resourceFiles = variantScope.getOutput(inputResourceFilesType);
/* 902 */     outputDirectory = outputDirectory;
/* 903 */     packageAndroidArtifact.setIncrementalFolder(new File(variantScope
/*     */     
/* 905 */       .getIncrementalDir(packageAndroidArtifact.getName()), "tmp"));
/*     */     
/* 907 */     outputScope = outputScope;
/*     */     
/* 909 */     fileCache = fileCache;
/*     */     
/* 912 */     aaptOptionsNoCompress = DslAdaptersKt.convert(globalScope.getExtension().getAaptOptions()).getNoCompress();
/*     */     
/* 914 */     manifests = manifests;
/*     */     
/* 916 */     dexFolders = getDexFolders();
/* 917 */     javaResourceFiles = getJavaResources();
/*     */     
/* 919 */     assets = variantScope.getOutput(TaskOutputHolder.TaskOutputType.MERGED_ASSETS);
/* 920 */     packageAndroidArtifact.setAbiFilters(variantConfiguration.getSupportedAbis());
/* 921 */     packageAndroidArtifact.setJniDebugBuild(
/* 922 */       ((CoreBuildType)variantConfiguration.getBuildType()).isJniDebuggable());
/* 923 */     packageAndroidArtifact.setDebugBuild(
/* 924 */       ((CoreBuildType)variantConfiguration.getBuildType()).isDebuggable());
/* 925 */     packageAndroidArtifact.setPackagingOptions(globalScope
/* 926 */       .getExtension().getPackagingOptions());
/*     */     
/* 928 */     ProjectOptions projectOptions = variantScope.getGlobalScope().getProjectOptions();
/* 929 */     projectBaseName = globalScope.getProjectBaseName();
/* 930 */     manifestType = manifestType;
/*     */     
/* 932 */     aaptGeneration = AaptGeneration.fromProjectOptions(projectOptions);
/*     */     
/* 935 */     buildTargetAbi = (globalScope.getExtension().getSplits().getAbi().isEnable() ? projectOptions.get(StringOption.IDE_BUILD_TARGET_ABI) : null);
/*     */     
/* 939 */     buildTargetDensity = (globalScope.getExtension().getSplits().getDensity().isEnable() ? projectOptions.get(StringOption.IDE_BUILD_TARGET_DENSITY) : null);
/*     */     
/* 942 */     variantScope
/* 943 */       .getVariantData()
/* 944 */       .addTask(TaskContainer.TaskKind.PACKAGE_ANDROID_ARTIFACT, packageAndroidArtifact);
/*     */     
/* 947 */     configure(packageAndroidArtifact);
/*     */   }
/*     */   
/*     */   protected void configure(T task) {
/* 951 */     GlobalScope globalScope = variantScope.getGlobalScope();
/*     */     
/* 953 */     GradleVariantConfiguration variantConfiguration = variantScope.getVariantConfiguration();
/* 954 */     instantRunFileType = FileType.MAIN;
/*     */     
/* 956 */     dexFolders = getDexFolders();
/* 957 */     javaResourceFiles = getJavaResources();
/*     */     
/* 959 */     if (variantScope.getVariantData().getMultiOutputPolicy() == MultiOutputPolicy.MULTI_APK)
/*     */     {
/* 961 */       jniFolders = getJniFolders();
/*     */     }
/*     */     else {
/* 964 */       Set<String> filters = AbiSplitOptions.getAbiFilters(globalScope
/* 965 */         .getExtension().getSplits().getAbiFilters());
/*     */       
/* 967 */       jniFolders = (filters.isEmpty() ? getJniFolders() : project.files(new Object[0]));
/*     */     }
/*     */     
/* 970 */     apkList = variantScope.getOutput(TaskOutputHolder.TaskOutputType.APK_LIST);
/*     */     
/* 973 */     task.setSigningConfig(variantConfiguration.getSigningConfig());
/*     */   }
/*     */   
/*     */   public FileCollection getDexFolders()
/*     */   {
/* 978 */     return 
/*     */     
/* 980 */       variantScope.getTransformManager().getPipelineOutputAsFileCollection(StreamFilter.DEX);
/*     */   }
/*     */   
/*     */   public FileCollection getJavaResources()
/*     */   {
/* 985 */     return 
/*     */     
/* 987 */       variantScope.getTransformManager().getPipelineOutputAsFileCollection(StreamFilter.RESOURCES);
/*     */   }
/*     */   
/*     */   public FileCollection getJniFolders()
/*     */   {
/* 992 */     return 
/*     */     
/* 994 */       variantScope.getTransformManager().getPipelineOutputAsFileCollection(StreamFilter.NATIVE_LIBS);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.PackageAndroidArtifact.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */