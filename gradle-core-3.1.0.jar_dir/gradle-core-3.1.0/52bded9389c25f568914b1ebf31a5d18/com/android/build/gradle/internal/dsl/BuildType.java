/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.scope.CodeShrinker;
/*     */ import com.android.builder.core.DefaultBuildType;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import com.android.builder.internal.ClassFieldImpl;
/*     */ import com.android.builder.model.BaseConfig;
/*     */ import com.android.builder.model.ClassField;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Iterables;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Supplier;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.Incubating;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.model.ObjectFactory;
/*     */ import org.gradle.api.tasks.Internal;
/*     */ 
/*     */ public class BuildType
/*     */   extends DefaultBuildType
/*     */   implements CoreBuildType, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  57 */   private static ThreadLocal<Boolean> dslChecksEnabled = ThreadLocal.withInitial(new Supplier()
/*     */   {
/*     */     public Boolean get()
/*     */     {
/*  61 */       return Boolean.valueOf(true);
/*     */     }
/*  57 */   });
/*     */   private final Project project;
/*     */   private final NdkOptions ndkConfig;
/*     */   private final ExternalNativeBuildOptions externalNativeBuildOptions;
/*     */   private final JavaCompileOptions javaCompileOptions;
/*     */   private final ShaderOptions shaderOptions;
/*     */   private final EvalIssueReporter issueReporter;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   private final PostprocessingOptions postprocessingOptions;
/*     */   private PostprocessingConfiguration postprocessingConfiguration;
/*     */   private String postprocessingDslMethodUsed;
/*     */   
/*  69 */   public static enum PostprocessingConfiguration { POSTPROCESSING_BLOCK, 
/*  70 */     OLD_DSL;
/*     */     
/*     */     private PostprocessingConfiguration() {}
/*     */   }
/*     */   
/*  86 */   private boolean shrinkResources = false;
/*     */   private Boolean useProguard;
/*     */   private Boolean crunchPngs;
/*  89 */   private boolean isCrunchPngsDefault = true;
/*     */   
/*     */   private ImmutableList<String> matchingFallbacks;
/*     */   
/*     */   @Inject
/*     */   public BuildType(String name, Project project, ObjectFactory objectFactory, EvalIssueReporter issueReporter, DeprecationReporter deprecationReporter)
/*     */   {
/*  98 */     super(name);
/*  99 */     this.project = project;
/* 100 */     this.issueReporter = issueReporter;
/* 101 */     this.deprecationReporter = deprecationReporter;
/*     */     
/* 104 */     javaCompileOptions = ((JavaCompileOptions)objectFactory.newInstance(JavaCompileOptions.class, new Object[] { objectFactory }));
/*     */     
/* 107 */     shaderOptions = ((ShaderOptions)objectFactory.newInstance(ShaderOptions.class, new Object[0]));
/* 108 */     ndkConfig = ((NdkOptions)objectFactory.newInstance(NdkOptions.class, new Object[0]));
/*     */     
/* 110 */     externalNativeBuildOptions = ((ExternalNativeBuildOptions)objectFactory.newInstance(ExternalNativeBuildOptions.class, new Object[] { objectFactory }));
/* 111 */     postprocessingOptions = ((PostprocessingOptions)objectFactory.newInstance(PostprocessingOptions.class, new Object[] { project }));
/*     */   }
/*     */   
/*     */   BuildType(String name, Project project, EvalIssueReporter issueReporter, DeprecationReporter deprecationReporter)
/*     */   {
/* 121 */     super(name);
/* 122 */     this.project = project;
/* 123 */     this.issueReporter = issueReporter;
/* 124 */     this.deprecationReporter = deprecationReporter;
/* 125 */     javaCompileOptions = new JavaCompileOptions();
/* 126 */     shaderOptions = new ShaderOptions();
/* 127 */     ndkConfig = new NdkOptions();
/* 128 */     externalNativeBuildOptions = new ExternalNativeBuildOptions();
/* 129 */     postprocessingOptions = new PostprocessingOptions(project);
/*     */   }
/*     */   
/*     */   public void setMatchingFallbacks(String... fallbacks)
/*     */   {
/* 135 */     matchingFallbacks = ImmutableList.copyOf(fallbacks);
/*     */   }
/*     */   
/*     */   public void setMatchingFallbacks(List<String> fallbacks) {
/* 139 */     matchingFallbacks = ImmutableList.copyOf(fallbacks);
/*     */   }
/*     */   
/*     */   public void setMatchingFallbacks(String fallback) {
/* 143 */     matchingFallbacks = ImmutableList.of(fallback);
/*     */   }
/*     */   
/*     */   public List<String> getMatchingFallbacks()
/*     */   {
/* 197 */     if (matchingFallbacks == null) {
/* 198 */       return ImmutableList.of();
/*     */     }
/* 200 */     return matchingFallbacks;
/*     */   }
/*     */   
/*     */   public CoreNdkOptions getNdkConfig()
/*     */   {
/* 206 */     return ndkConfig;
/*     */   }
/*     */   
/*     */   public ExternalNativeBuildOptions getExternalNativeBuildOptions()
/*     */   {
/* 212 */     return externalNativeBuildOptions;
/*     */   }
/*     */   
/*     */   public com.android.build.gradle.api.JavaCompileOptions getJavaCompileOptions()
/*     */   {
/* 219 */     return javaCompileOptions;
/*     */   }
/*     */   
/*     */   public CoreShaderOptions getShaders()
/*     */   {
/* 225 */     return shaderOptions;
/*     */   }
/*     */   
/*     */   public void init(SigningConfig debugSigningConfig)
/*     */   {
/* 232 */     if ("debug".equals(getName())) {
/* 233 */       setDebuggable(true);
/* 234 */       setEmbedMicroApp(false);
/* 235 */       isCrunchPngsDefault = false;
/*     */       
/* 237 */       assert (debugSigningConfig != null);
/* 238 */       setSigningConfig(debugSigningConfig);
/*     */     }
/*     */   }
/*     */   
/*     */   public SigningConfig getSigningConfig()
/*     */   {
/* 246 */     return (SigningConfig)super.getSigningConfig();
/*     */   }
/*     */   
/*     */   protected void _initWith(BaseConfig that)
/*     */   {
/* 251 */     super._initWith(that);
/* 252 */     BuildType thatBuildType = (BuildType)that;
/* 253 */     ndkConfig._initWith(thatBuildType.getNdkConfig());
/* 254 */     javaCompileOptions.getAnnotationProcessorOptions()._initWith(thatBuildType
/* 255 */       .getJavaCompileOptions().getAnnotationProcessorOptions());
/* 256 */     shrinkResources = thatBuildType.isShrinkResources();
/* 257 */     shaderOptions._initWith(thatBuildType.getShaders());
/* 258 */     externalNativeBuildOptions._initWith(thatBuildType.getExternalNativeBuildOptions());
/* 259 */     useProguard = thatBuildType.isUseProguard();
/* 260 */     postprocessingOptions.initWith(((BuildType)that).getPostprocessing());
/* 261 */     crunchPngs = thatBuildType.isCrunchPngs();
/*     */     
/* 263 */     isCrunchPngsDefault = thatBuildType.isCrunchPngsDefault();
/* 264 */     matchingFallbacks = ImmutableList.copyOf(thatBuildType.getMatchingFallbacks());
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 270 */     return System.identityHashCode(this);
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 276 */     return this == o;
/*     */   }
/*     */   
/*     */   public void buildConfigField(String type, String name, String value)
/*     */   {
/* 297 */     ClassField alreadyPresent = (ClassField)getBuildConfigFields().get(name);
/* 298 */     if (alreadyPresent != null)
/*     */     {
/* 300 */       String message = String.format("BuildType(%s): buildConfigField '%s' value is being replaced: %s -> %s", new Object[] {
/*     */       
/* 302 */         getName(), name, alreadyPresent.getValue(), value });
/* 303 */       issueReporter.reportWarning(EvalIssueReporter.Type.GENERIC, message);
/*     */     }
/* 305 */     addBuildConfigField(new ClassFieldImpl(type, name, value));
/*     */   }
/*     */   
/*     */   public void resValue(String type, String name, String value)
/*     */   {
/* 323 */     ClassField alreadyPresent = (ClassField)getResValues().get(name);
/* 324 */     if (alreadyPresent != null)
/*     */     {
/* 326 */       String message = String.format("BuildType(%s): resValue '%s' value is being replaced: %s -> %s", new Object[] {
/*     */       
/* 328 */         getName(), name, alreadyPresent.getValue(), value });
/* 329 */       issueReporter.reportWarning(EvalIssueReporter.Type.GENERIC, message);
/*     */     }
/* 331 */     addResValue(new ClassFieldImpl(type, name, value));
/*     */   }
/*     */   
/*     */   public BuildType proguardFile(Object proguardFile)
/*     */   {
/* 349 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "proguardFile");
/* 350 */     getProguardFiles().add(project.file(proguardFile));
/* 351 */     return this;
/*     */   }
/*     */   
/*     */   public BuildType proguardFiles(Object... files)
/*     */   {
/* 367 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "proguardFiles");
/* 368 */     for (Object file : files) {
/* 369 */       proguardFile(file);
/*     */     }
/* 371 */     return this;
/*     */   }
/*     */   
/*     */   public BuildType setProguardFiles(Iterable<?> proguardFileIterable)
/*     */   {
/* 387 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "setProguardFiles");
/* 388 */     getProguardFiles().clear();
/* 389 */     proguardFiles(Iterables.toArray(proguardFileIterable, Object.class));
/* 390 */     return this;
/*     */   }
/*     */   
/*     */   public BuildType testProguardFile(Object proguardFile)
/*     */   {
/* 400 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "testProguardFile");
/* 401 */     getTestProguardFiles().add(project.file(proguardFile));
/* 402 */     return this;
/*     */   }
/*     */   
/*     */   public BuildType testProguardFiles(Object... proguardFiles)
/*     */   {
/* 412 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "testProguardFiles");
/* 413 */     for (Object proguardFile : proguardFiles) {
/* 414 */       testProguardFile(proguardFile);
/*     */     }
/* 416 */     return this;
/*     */   }
/*     */   
/*     */   public BuildType setTestProguardFiles(Iterable<?> files)
/*     */   {
/* 426 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "setTestProguardFiles");
/*     */     
/* 428 */     getTestProguardFiles().clear();
/* 429 */     testProguardFiles(Iterables.toArray(files, Object.class));
/* 430 */     return this;
/*     */   }
/*     */   
/*     */   public BuildType consumerProguardFile(Object proguardFile)
/*     */   {
/* 445 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "consumerProguardFile");
/*     */     
/* 447 */     getConsumerProguardFiles().add(project.file(proguardFile));
/* 448 */     return this;
/*     */   }
/*     */   
/*     */   public BuildType consumerProguardFiles(Object... proguardFiles)
/*     */   {
/* 463 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "consumerProguardFiles");
/*     */     
/* 465 */     for (Object proguardFile : proguardFiles) {
/* 466 */       consumerProguardFile(proguardFile);
/*     */     }
/*     */     
/* 469 */     return this;
/*     */   }
/*     */   
/*     */   public BuildType setConsumerProguardFiles(Iterable<?> proguardFileIterable)
/*     */   {
/* 484 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "setConsumerProguardFiles");
/*     */     
/* 486 */     getConsumerProguardFiles().clear();
/* 487 */     consumerProguardFiles(Iterables.toArray(proguardFileIterable, Object.class));
/* 488 */     return this;
/*     */   }
/*     */   
/*     */   public void ndk(Action<NdkOptions> action)
/*     */   {
/* 493 */     action.execute(ndkConfig);
/*     */   }
/*     */   
/*     */   public ExternalNativeBuildOptions externalNativeBuild(Action<ExternalNativeBuildOptions> action)
/*     */   {
/* 500 */     action.execute(externalNativeBuildOptions);
/* 501 */     return externalNativeBuildOptions;
/*     */   }
/*     */   
/*     */   public void shaders(Action<ShaderOptions> action)
/*     */   {
/* 508 */     action.execute(shaderOptions);
/*     */   }
/*     */   
/*     */   public com.android.builder.model.BuildType setMinifyEnabled(boolean enabled)
/*     */   {
/* 514 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "setMinifyEnabled");
/* 515 */     return super.setMinifyEnabled(enabled);
/*     */   }
/*     */   
/*     */   public boolean isMinifyEnabled()
/*     */   {
/* 526 */     if (postprocessingConfiguration != PostprocessingConfiguration.POSTPROCESSING_BLOCK) {
/* 527 */       return super.isMinifyEnabled();
/*     */     }
/* 529 */     return (postprocessingOptions.isRemoveUnusedCode()) || 
/* 530 */       (postprocessingOptions.isObfuscate()) || 
/* 531 */       (postprocessingOptions.isOptimizeCode());
/*     */   }
/*     */   
/*     */   public boolean isShrinkResources()
/*     */   {
/* 543 */     if (postprocessingConfiguration != PostprocessingConfiguration.POSTPROCESSING_BLOCK) {
/* 544 */       return shrinkResources;
/*     */     }
/* 546 */     return postprocessingOptions.isRemoveUnusedResources();
/*     */   }
/*     */   
/*     */   public void setShrinkResources(boolean shrinkResources)
/*     */   {
/* 551 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "setShrinkResources");
/* 552 */     this.shrinkResources = shrinkResources;
/*     */   }
/*     */   
/*     */   public Boolean isUseProguard()
/*     */   {
/* 576 */     if (postprocessingConfiguration != PostprocessingConfiguration.POSTPROCESSING_BLOCK) {
/* 577 */       return useProguard;
/*     */     }
/* 579 */     return Boolean.valueOf(postprocessingOptions.getCodeShrinkerEnum() == CodeShrinker.PROGUARD);
/*     */   }
/*     */   
/*     */   public void setUseProguard(boolean useProguard)
/*     */   {
/* 584 */     checkPostprocessingConfiguration(PostprocessingConfiguration.OLD_DSL, "setUseProguard");
/* 585 */     this.useProguard = Boolean.valueOf(useProguard);
/*     */   }
/*     */   
/*     */   public Boolean isCrunchPngs()
/*     */   {
/* 591 */     return crunchPngs;
/*     */   }
/*     */   
/*     */   public void setCrunchPngs(Boolean crunchPngs) {
/* 595 */     this.crunchPngs = crunchPngs;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public boolean isCrunchPngsDefault()
/*     */   {
/* 606 */     return isCrunchPngsDefault;
/*     */   }
/*     */   
/*     */   @Incubating
/*     */   @Internal
/*     */   public PostprocessingOptions getPostprocessing()
/*     */   {
/* 614 */     checkPostprocessingConfiguration(PostprocessingConfiguration.POSTPROCESSING_BLOCK, "getPostProcessing");
/*     */     
/* 616 */     return postprocessingOptions;
/*     */   }
/*     */   
/*     */   @Incubating
/*     */   @Internal
/*     */   public void postprocessing(Action<PostprocessingOptions> action)
/*     */   {
/* 623 */     checkPostprocessingConfiguration(PostprocessingConfiguration.POSTPROCESSING_BLOCK, "postProcessing");
/*     */     
/* 625 */     action.execute(postprocessingOptions);
/*     */   }
/*     */   
/*     */   public PostprocessingConfiguration getPostprocessingConfiguration()
/*     */   {
/* 632 */     return postprocessingConfiguration != null ? postprocessingConfiguration : PostprocessingConfiguration.OLD_DSL;
/*     */   }
/*     */   
/*     */   private void checkPostprocessingConfiguration(PostprocessingConfiguration used, String methodName)
/*     */   {
/* 643 */     if (!((Boolean)dslChecksEnabled.get()).booleanValue()) {
/* 644 */       return;
/*     */     }
/*     */     
/* 647 */     if (postprocessingConfiguration == null) {
/* 648 */       postprocessingConfiguration = used;
/* 649 */       postprocessingDslMethodUsed = methodName;
/* 650 */     } else if (postprocessingConfiguration != used) {
/* 651 */       assert (postprocessingDslMethodUsed != null);
/*     */       String message;
/* 653 */       String message; switch (used)
/*     */       {
/*     */       case POSTPROCESSING_BLOCK: 
/* 657 */         message = String.format("The `postProcessing` block cannot be used with together with the `%s` method.", new Object[] { postprocessingDslMethodUsed });
/*     */         
/* 660 */         break;
/*     */       
/*     */       case OLD_DSL: 
/* 664 */         message = String.format("The `%s` method cannot be used with together with the `postProcessing` block.", new Object[] { methodName });
/*     */         
/* 667 */         break;
/*     */       default: 
/* 669 */         throw new AssertionError("Unknown value " + used); }
/*     */       String message;
/* 671 */       issueReporter.reportError(EvalIssueReporter.Type.GENERIC, message, methodName);
/*     */     }
/*     */   }
/*     */   
/*     */   public BuildType initWith(com.android.builder.model.BuildType that)
/*     */   {
/* 677 */     dslChecksEnabled.set(Boolean.valueOf(false));
/*     */     try {
/* 679 */       return (BuildType)super.initWith(that);
/*     */     } finally {
/* 681 */       dslChecksEnabled.set(Boolean.valueOf(true));
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.BuildType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */