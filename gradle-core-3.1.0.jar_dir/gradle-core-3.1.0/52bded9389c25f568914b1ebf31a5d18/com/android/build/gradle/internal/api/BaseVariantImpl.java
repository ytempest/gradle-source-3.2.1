/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.build.api.attributes.ProductFlavorAttr;
/*     */ import com.android.build.gradle.api.BaseVariant;
/*     */ import com.android.build.gradle.api.BaseVariantOutput;
/*     */ import com.android.build.gradle.api.JavaCompileOptions;
/*     */ import com.android.build.gradle.api.SourceKind;
/*     */ import com.android.build.gradle.internal.VariantManager;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dependency.VariantDependencies;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.internal.variant.TaskContainer.TaskKind;
/*     */ import com.android.build.gradle.tasks.AidlCompile;
/*     */ import com.android.build.gradle.tasks.ExternalNativeBuildTask;
/*     */ import com.android.build.gradle.tasks.GenerateBuildConfig;
/*     */ import com.android.build.gradle.tasks.MergeResources;
/*     */ import com.android.build.gradle.tasks.MergeSourceSetFolders;
/*     */ import com.android.build.gradle.tasks.NdkCompile;
/*     */ import com.android.build.gradle.tasks.RenderscriptCompile;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import com.android.builder.model.BuildType;
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import com.android.builder.model.SourceProvider;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import org.gradle.api.DomainObjectCollection;
/*     */ import org.gradle.api.NamedDomainObjectContainer;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.Task;
/*     */ import org.gradle.api.artifacts.ArtifactCollection;
/*     */ import org.gradle.api.artifacts.Configuration;
/*     */ import org.gradle.api.artifacts.dsl.DependencyHandler;
/*     */ import org.gradle.api.attributes.Attribute;
/*     */ import org.gradle.api.attributes.AttributeContainer;
/*     */ import org.gradle.api.attributes.AttributesSchema;
/*     */ import org.gradle.api.file.ConfigurableFileTree;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.model.ObjectFactory;
/*     */ import org.gradle.api.tasks.Sync;
/*     */ import org.gradle.api.tasks.compile.JavaCompile;
/*     */ 
/*     */ public abstract class BaseVariantImpl
/*     */   implements BaseVariant
/*     */ {
/*     */   private final ObjectFactory objectFactory;
/*     */   protected final AndroidBuilder androidBuilder;
/*     */   protected final ReadOnlyObjectProvider readOnlyObjectProvider;
/*     */   protected final NamedDomainObjectContainer<BaseVariantOutput> outputs;
/*     */   
/*     */   BaseVariantImpl(ObjectFactory objectFactory, AndroidBuilder androidBuilder, ReadOnlyObjectProvider readOnlyObjectProvider, NamedDomainObjectContainer<BaseVariantOutput> outputs)
/*     */   {
/*  83 */     this.objectFactory = objectFactory;
/*  84 */     this.androidBuilder = androidBuilder;
/*  85 */     this.readOnlyObjectProvider = readOnlyObjectProvider;
/*  86 */     this.outputs = outputs;
/*     */   }
/*     */   
/*     */   protected abstract BaseVariantData getVariantData();
/*     */   
/*     */   public void addOutputs(List<BaseVariantOutput> outputs)
/*     */   {
/*  93 */     this.outputs.addAll(outputs);
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  99 */     return getVariantData().getVariantConfiguration().getFullName();
/*     */   }
/*     */   
/*     */   public String getDescription()
/*     */   {
/* 105 */     return getVariantData().getDescription();
/*     */   }
/*     */   
/*     */   public String getDirName()
/*     */   {
/* 111 */     return getVariantData().getVariantConfiguration().getDirName();
/*     */   }
/*     */   
/*     */   public String getBaseName()
/*     */   {
/* 117 */     return getVariantData().getVariantConfiguration().getBaseName();
/*     */   }
/*     */   
/*     */   public String getFlavorName()
/*     */   {
/* 123 */     return getVariantData().getVariantConfiguration().getFlavorName();
/*     */   }
/*     */   
/*     */   public DomainObjectCollection<BaseVariantOutput> getOutputs()
/*     */   {
/* 129 */     return outputs;
/*     */   }
/*     */   
/*     */   public BuildType getBuildType()
/*     */   {
/* 135 */     return readOnlyObjectProvider.getBuildType(
/* 136 */       getVariantData().getVariantConfiguration().getBuildType());
/*     */   }
/*     */   
/*     */   public List<ProductFlavor> getProductFlavors()
/*     */   {
/* 142 */     return new ImmutableFlavorList(
/* 143 */       getVariantData().getVariantConfiguration().getProductFlavors(), readOnlyObjectProvider);
/*     */   }
/*     */   
/*     */   public ProductFlavor getMergedFlavor()
/*     */   {
/* 150 */     return getVariantData().getVariantConfiguration().getMergedFlavor();
/*     */   }
/*     */   
/*     */   public JavaCompileOptions getJavaCompileOptions()
/*     */   {
/* 156 */     return getVariantData().getVariantConfiguration().getJavaCompileOptions();
/*     */   }
/*     */   
/*     */   public List<SourceProvider> getSourceSets()
/*     */   {
/* 162 */     return getVariantData().getVariantConfiguration().getSortedSourceProviders();
/*     */   }
/*     */   
/*     */   public List<ConfigurableFileTree> getSourceFolders(SourceKind folderType)
/*     */   {
/* 168 */     switch (folderType) {
/*     */     case JAVA: 
/* 170 */       return getVariantData().getJavaSources();
/*     */     }
/*     */     
/*     */     
/* 174 */     androidBuilder.getIssueReporter().reportError(EvalIssueReporter.Type.GENERIC, "Unknown SourceKind value: " + folderType);
/*     */     
/* 179 */     return ImmutableList.of();
/*     */   }
/*     */   
/*     */   public Configuration getCompileConfiguration()
/*     */   {
/* 185 */     return getVariantData().getVariantDependency().getCompileClasspath();
/*     */   }
/*     */   
/*     */   public Configuration getRuntimeConfiguration()
/*     */   {
/* 191 */     return getVariantData().getVariantDependency().getRuntimeClasspath();
/*     */   }
/*     */   
/*     */   public Configuration getAnnotationProcessorConfiguration()
/*     */   {
/* 197 */     return getVariantData().getVariantDependency().getAnnotationProcessorConfiguration();
/*     */   }
/*     */   
/*     */   public String getApplicationId()
/*     */   {
/* 203 */     return getVariantData().getApplicationId();
/*     */   }
/*     */   
/*     */   public Task getPreBuild()
/*     */   {
/* 209 */     return getVariantDatapreBuildTask;
/*     */   }
/*     */   
/*     */   public Task getCheckManifest()
/*     */   {
/* 215 */     return getVariantDatacheckManifestTask;
/*     */   }
/*     */   
/*     */   public AidlCompile getAidlCompile()
/*     */   {
/* 221 */     return getVariantDataaidlCompileTask;
/*     */   }
/*     */   
/*     */   public RenderscriptCompile getRenderscriptCompile()
/*     */   {
/* 227 */     return getVariantDatarenderscriptCompileTask;
/*     */   }
/*     */   
/*     */   public MergeResources getMergeResources()
/*     */   {
/* 232 */     return getVariantDatamergeResourcesTask;
/*     */   }
/*     */   
/*     */   public MergeSourceSetFolders getMergeAssets()
/*     */   {
/* 237 */     return getVariantDatamergeAssetsTask;
/*     */   }
/*     */   
/*     */   public GenerateBuildConfig getGenerateBuildConfig()
/*     */   {
/* 242 */     return getVariantDatagenerateBuildConfigTask;
/*     */   }
/*     */   
/*     */   public JavaCompile getJavaCompile()
/*     */   {
/* 248 */     return getVariantDatajavacTask;
/*     */   }
/*     */   
/*     */   public Task getJavaCompiler()
/*     */   {
/* 254 */     return getVariantDatajavacTask;
/*     */   }
/*     */   
/*     */   public NdkCompile getNdkCompile()
/*     */   {
/* 260 */     return getVariantDatandkCompileTask;
/*     */   }
/*     */   
/*     */   public Collection<ExternalNativeBuildTask> getExternalNativeBuildTasks()
/*     */   {
/* 265 */     return getVariantDataexternalNativeBuildTasks;
/*     */   }
/*     */   
/*     */   public Task getObfuscation()
/*     */   {
/* 271 */     return getVariantDataobfuscationTask;
/*     */   }
/*     */   
/*     */   public File getMappingFile()
/*     */   {
/* 277 */     VariantScope scope = getVariantData().getScope();
/* 278 */     if (scope.hasOutput(TaskOutputHolder.TaskOutputType.APK_MAPPING)) {
/* 279 */       return scope.getOutput(TaskOutputHolder.TaskOutputType.APK_MAPPING).getSingleFile();
/*     */     }
/* 281 */     return null;
/*     */   }
/*     */   
/*     */   public Sync getProcessJavaResources()
/*     */   {
/* 287 */     return getVariantDataprocessJavaResourcesTask;
/*     */   }
/*     */   
/*     */   public Task getAssemble()
/*     */   {
/* 293 */     return getVariantData().getTaskByKind(TaskContainer.TaskKind.ASSEMBLE);
/*     */   }
/*     */   
/*     */   public void addJavaSourceFoldersToModel(File... generatedSourceFolders)
/*     */   {
/* 298 */     getVariantData().addJavaSourceFoldersToModel(generatedSourceFolders);
/*     */   }
/*     */   
/*     */   public void addJavaSourceFoldersToModel(Collection<File> generatedSourceFolders)
/*     */   {
/* 303 */     getVariantData().addJavaSourceFoldersToModel(generatedSourceFolders);
/*     */   }
/*     */   
/*     */   public void registerJavaGeneratingTask(Task task, File... sourceFolders)
/*     */   {
/* 308 */     getVariantData().registerJavaGeneratingTask(task, sourceFolders);
/*     */   }
/*     */   
/*     */   public void registerJavaGeneratingTask(Task task, Collection<File> sourceFolders)
/*     */   {
/* 313 */     getVariantData().registerJavaGeneratingTask(task, sourceFolders);
/*     */   }
/*     */   
/*     */   public void registerExternalAptJavaOutput(ConfigurableFileTree folder)
/*     */   {
/* 318 */     getVariantData().registerExternalAptJavaOutput(folder);
/*     */   }
/*     */   
/*     */   public void registerGeneratedResFolders(FileCollection folders)
/*     */   {
/* 323 */     getVariantData().registerGeneratedResFolders(folders);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void registerResGeneratingTask(Task task, File... generatedResFolders)
/*     */   {
/* 329 */     getVariantData().registerResGeneratingTask(task, generatedResFolders);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void registerResGeneratingTask(Task task, Collection<File> generatedResFolders)
/*     */   {
/* 335 */     getVariantData().registerResGeneratingTask(task, generatedResFolders);
/*     */   }
/*     */   
/*     */   public Object registerPreJavacGeneratedBytecode(FileCollection fileCollection)
/*     */   {
/* 340 */     return getVariantData().registerPreJavacGeneratedBytecode(fileCollection);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public Object registerGeneratedBytecode(FileCollection fileCollection)
/*     */   {
/* 346 */     return registerPreJavacGeneratedBytecode(fileCollection);
/*     */   }
/*     */   
/*     */   public void registerPostJavacGeneratedBytecode(FileCollection fileCollection)
/*     */   {
/* 351 */     getVariantData().registerPostJavacGeneratedBytecode(fileCollection);
/*     */   }
/*     */   
/*     */   public FileCollection getCompileClasspath(Object generatorKey)
/*     */   {
/* 357 */     return 
/*     */     
/* 359 */       getVariantData().getScope().getJavaClasspath(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactType.CLASSES, generatorKey);
/*     */   }
/*     */   
/*     */   public ArtifactCollection getCompileClasspathArtifacts(Object generatorKey)
/*     */   {
/* 368 */     return 
/*     */     
/* 370 */       getVariantData().getScope().getJavaClasspathArtifacts(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactType.CLASSES, generatorKey);
/*     */   }
/*     */   
/*     */   public void buildConfigField(String type, String name, String value)
/*     */   {
/* 379 */     getVariantData().getVariantConfiguration().addBuildConfigField(type, name, value);
/*     */   }
/*     */   
/*     */   public void resValue(String type, String name, String value)
/*     */   {
/* 384 */     getVariantData().getVariantConfiguration().addResValue(type, name, value);
/*     */   }
/*     */   
/*     */   public void missingDimensionStrategy(String dimension, String requestedValue)
/*     */   {
/* 391 */     _missingDimensionStrategy(dimension, ImmutableList.of(requestedValue));
/*     */   }
/*     */   
/*     */   public void missingDimensionStrategy(String dimension, String... requestedValues)
/*     */   {
/* 397 */     _missingDimensionStrategy(dimension, ImmutableList.copyOf(requestedValues));
/*     */   }
/*     */   
/*     */   public void missingDimensionStrategy(String dimension, List<String> requestedValues)
/*     */   {
/* 403 */     _missingDimensionStrategy(dimension, ImmutableList.copyOf(requestedValues));
/*     */   }
/*     */   
/*     */   private void _missingDimensionStrategy(String dimension, ImmutableList<String> alternatedValues)
/*     */   {
/* 408 */     VariantScope variantScope = getVariantData().getScope();
/*     */     
/* 412 */     String requestedValue = VariantManager.getModifiedName(getName());
/*     */     
/* 415 */     Attribute<ProductFlavorAttr> attributeKey = Attribute.of(dimension, ProductFlavorAttr.class);
/*     */     
/* 417 */     ProductFlavorAttr attributeValue = (ProductFlavorAttr)objectFactory.named(ProductFlavorAttr.class, requestedValue);
/*     */     
/* 419 */     VariantDependencies dependencies = variantScope.getVariantDependencies();
/* 420 */     dependencies.getCompileClasspath().getAttributes().attribute(attributeKey, attributeValue);
/* 421 */     dependencies.getRuntimeClasspath().getAttributes().attribute(attributeKey, attributeValue);
/* 422 */     dependencies
/* 423 */       .getAnnotationProcessorConfiguration()
/* 424 */       .getAttributes()
/* 425 */       .attribute(attributeKey, attributeValue);
/*     */     
/* 429 */     AttributesSchema schema = variantScope.getGlobalScope().getProject().getDependencies().getAttributesSchema();
/*     */     
/* 431 */     VariantManager.addFlavorStrategy(schema, dimension, 
/* 432 */       ImmutableMap.of(requestedValue, alternatedValues));
/*     */   }
/*     */   
/*     */   public void setOutputsAreSigned(boolean isSigned)
/*     */   {
/* 437 */     getVariantDataoutputsAreSigned = isSigned;
/*     */   }
/*     */   
/*     */   public boolean getOutputsAreSigned()
/*     */   {
/* 442 */     return getVariantDataoutputsAreSigned;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.BaseVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */