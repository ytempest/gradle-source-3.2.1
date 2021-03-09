/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ import com.android.builder.core.DefaultApiVersion;
/*     */ import com.android.builder.core.DefaultProductFlavor;
/*     */ import com.android.builder.core.DefaultVectorDrawablesOptions;
/*     */ import com.android.builder.internal.ClassFieldImpl;
/*     */ import com.android.builder.model.ApiVersion;
/*     */ import com.android.builder.model.ClassField;
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.Iterables;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.model.ObjectFactory;
/*     */ 
/*     */ public abstract class BaseFlavor
/*     */   extends DefaultProductFlavor
/*     */   implements CoreProductFlavor
/*     */ {
/*     */   protected final Project project;
/*     */   protected final Logger logger;
/*     */   private final NdkOptions ndkConfig;
/*     */   private final ExternalNativeBuildOptions externalNativeBuildOptions;
/*     */   private final JavaCompileOptions javaCompileOptions;
/*     */   private final ShaderOptions shaderOptions;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   
/*     */   public BaseFlavor(String name, Project project, ObjectFactory objectFactory, DeprecationReporter deprecationReporter, Logger logger)
/*     */   {
/*  61 */     super(name, (DefaultVectorDrawablesOptions)objectFactory.newInstance(VectorDrawablesOptions.class, new Object[0]));
/*  62 */     this.project = project;
/*  63 */     this.deprecationReporter = deprecationReporter;
/*  64 */     this.logger = logger;
/*  65 */     ndkConfig = ((NdkOptions)objectFactory.newInstance(NdkOptions.class, new Object[0]));
/*     */     
/*  67 */     externalNativeBuildOptions = ((ExternalNativeBuildOptions)objectFactory.newInstance(ExternalNativeBuildOptions.class, new Object[] { objectFactory }));
/*  68 */     javaCompileOptions = ((JavaCompileOptions)objectFactory.newInstance(JavaCompileOptions.class, new Object[] { objectFactory }));
/*  69 */     shaderOptions = ((ShaderOptions)objectFactory.newInstance(ShaderOptions.class, new Object[0]));
/*     */   }
/*     */   
/*     */   public NdkOptions getNdk()
/*     */   {
/*  75 */     return ndkConfig;
/*     */   }
/*     */   
/*     */   public CoreNdkOptions getNdkConfig()
/*     */   {
/*  81 */     return ndkConfig;
/*     */   }
/*     */   
/*     */   public ExternalNativeBuildOptions getExternalNativeBuild()
/*     */   {
/*  93 */     return externalNativeBuildOptions;
/*     */   }
/*     */   
/*     */   public CoreExternalNativeBuildOptions getExternalNativeBuildOptions()
/*     */   {
/*  99 */     return externalNativeBuildOptions;
/*     */   }
/*     */   
/*     */   public void setMinSdkVersion(int minSdkVersion) {
/* 103 */     setMinSdkVersion(new DefaultApiVersion(minSdkVersion));
/*     */   }
/*     */   
/*     */   public void minSdkVersion(int minSdkVersion)
/*     */   {
/* 113 */     setMinSdkVersion(minSdkVersion);
/*     */   }
/*     */   
/*     */   public void setMinSdkVersion(String minSdkVersion) {
/* 117 */     setMinSdkVersion(getApiVersion(minSdkVersion));
/*     */   }
/*     */   
/*     */   public void minSdkVersion(String minSdkVersion)
/*     */   {
/* 127 */     setMinSdkVersion(minSdkVersion);
/*     */   }
/*     */   
/*     */   public ProductFlavor setTargetSdkVersion(int targetSdkVersion)
/*     */   {
/* 132 */     setTargetSdkVersion(new DefaultApiVersion(targetSdkVersion));
/* 133 */     return this;
/*     */   }
/*     */   
/*     */   public void targetSdkVersion(int targetSdkVersion)
/*     */   {
/* 143 */     setTargetSdkVersion(targetSdkVersion);
/*     */   }
/*     */   
/*     */   public void setTargetSdkVersion(String targetSdkVersion) {
/* 147 */     setTargetSdkVersion(getApiVersion(targetSdkVersion));
/*     */   }
/*     */   
/*     */   public void targetSdkVersion(String targetSdkVersion)
/*     */   {
/* 157 */     setTargetSdkVersion(targetSdkVersion);
/*     */   }
/*     */   
/*     */   public void maxSdkVersion(int maxSdkVersion)
/*     */   {
/* 167 */     setMaxSdkVersion(Integer.valueOf(maxSdkVersion));
/*     */   }
/*     */   
/*     */   private static ApiVersion getApiVersion(String value)
/*     */   {
/* 172 */     if (!Strings.isNullOrEmpty(value)) {
/* 173 */       if (Character.isDigit(value.charAt(0))) {
/*     */         try {
/* 175 */           int apiLevel = Integer.valueOf(value).intValue();
/* 176 */           return new DefaultApiVersion(apiLevel);
/*     */         } catch (NumberFormatException e) {
/* 178 */           throw new RuntimeException("'" + value + "' is not a valid API level. ", e);
/*     */         }
/*     */       }
/*     */       
/* 182 */       return new DefaultApiVersion(value);
/*     */     }
/*     */     
/* 185 */     return null;
/*     */   }
/*     */   
/*     */   public void testInstrumentationRunnerArgument(String key, String value)
/*     */   {
/* 205 */     getTestInstrumentationRunnerArguments().put(key, value);
/*     */   }
/*     */   
/*     */   public void testInstrumentationRunnerArguments(Map<String, String> args)
/*     */   {
/* 225 */     getTestInstrumentationRunnerArguments().putAll(args);
/*     */   }
/*     */   
/*     */   public SigningConfig getSigningConfig()
/*     */   {
/* 232 */     return (SigningConfig)super.getSigningConfig();
/*     */   }
/*     */   
/*     */   public void buildConfigField(String type, String name, String value)
/*     */   {
/* 251 */     ClassField alreadyPresent = (ClassField)getBuildConfigFields().get(name);
/* 252 */     if (alreadyPresent != null) {
/* 253 */       String flavorName = getName();
/* 254 */       if ("main".equals(flavorName)) {
/* 255 */         logger.info("DefaultConfig: buildConfigField '{}' value is being replaced: {} -> {}", new Object[] { name, alreadyPresent
/*     */         
/* 258 */           .getValue(), value });
/*     */       }
/*     */       else {
/* 261 */         logger.info("ProductFlavor({}): buildConfigField '{}' value is being replaced: {} -> {}", new Object[] { flavorName, name, alreadyPresent
/*     */         
/* 266 */           .getValue(), value });
/*     */       }
/*     */     }
/*     */     
/* 270 */     addBuildConfigField(new ClassFieldImpl(type, name, value));
/*     */   }
/*     */   
/*     */   public void resValue(String type, String name, String value)
/*     */   {
/* 287 */     ClassField alreadyPresent = (ClassField)getResValues().get(name);
/* 288 */     if (alreadyPresent != null) {
/* 289 */       String flavorName = getName();
/* 290 */       if ("main".equals(flavorName)) {
/* 291 */         logger.info("DefaultConfig: resValue '{}' value is being replaced: {} -> {}", new Object[] { name, alreadyPresent
/*     */         
/* 294 */           .getValue(), value });
/*     */       }
/*     */       else {
/* 297 */         logger.info("ProductFlavor({}): resValue '{}' value is being replaced: {} -> {}", new Object[] { flavorName, name, alreadyPresent
/*     */         
/* 301 */           .getValue(), value });
/*     */       }
/*     */     }
/*     */     
/* 305 */     addResValue(new ClassFieldImpl(type, name, value));
/*     */   }
/*     */   
/*     */   public void proguardFile(Object proguardFile)
/*     */   {
/* 324 */     getProguardFiles().add(project.file(proguardFile));
/*     */   }
/*     */   
/*     */   public void proguardFiles(Object... files)
/*     */   {
/* 343 */     for (Object file : files) {
/* 344 */       proguardFile(file);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setProguardFiles(Iterable<?> proguardFileIterable)
/*     */   {
/* 364 */     getProguardFiles().clear();
/* 365 */     proguardFiles(Iterables.toArray(proguardFileIterable, Object.class));
/*     */   }
/*     */   
/*     */   public void testProguardFile(Object proguardFile)
/*     */   {
/* 374 */     getTestProguardFiles().add(project.file(proguardFile));
/*     */   }
/*     */   
/*     */   public void testProguardFiles(Object... proguardFiles)
/*     */   {
/* 383 */     for (Object proguardFile : proguardFiles) {
/* 384 */       testProguardFile(proguardFile);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setTestProguardFiles(Iterable<?> files)
/*     */   {
/* 394 */     getTestProguardFiles().clear();
/* 395 */     testProguardFiles(Iterables.toArray(files, Object.class));
/*     */   }
/*     */   
/*     */   public void consumerProguardFile(Object proguardFile)
/*     */   {
/* 409 */     getConsumerProguardFiles().add(project.file(proguardFile));
/*     */   }
/*     */   
/*     */   public void consumerProguardFiles(Object... proguardFiles)
/*     */   {
/* 423 */     for (Object proguardFile : proguardFiles) {
/* 424 */       consumerProguardFile(proguardFile);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setConsumerProguardFiles(Iterable<?> proguardFileIterable)
/*     */   {
/* 439 */     getConsumerProguardFiles().clear();
/* 440 */     consumerProguardFiles(Iterables.toArray(proguardFileIterable, Object.class));
/*     */   }
/*     */   
/*     */   public void ndk(Action<NdkOptions> action)
/*     */   {
/* 445 */     action.execute(ndkConfig);
/*     */   }
/*     */   
/*     */   public void externalNativeBuild(Action<ExternalNativeBuildOptions> action)
/*     */   {
/* 456 */     action.execute(externalNativeBuildOptions);
/*     */   }
/*     */   
/*     */   public void resConfig(String config)
/*     */   {
/* 496 */     checkResConfigValue("resConfig", config);
/* 497 */     addResourceConfiguration(config);
/*     */   }
/*     */   
/*     */   public void resConfigs(String... config)
/*     */   {
/* 537 */     for (String aConfig : config) {
/* 538 */       checkResConfigValue("resConfigs", aConfig);
/*     */     }
/* 540 */     addResourceConfigurations(config);
/*     */   }
/*     */   
/*     */   public void resConfigs(Collection<String> config)
/*     */   {
/* 580 */     for (String aConfig : config) {
/* 581 */       checkResConfigValue("resConfigs", aConfig);
/*     */     }
/* 583 */     addResourceConfigurations(config);
/*     */   }
/*     */   
/*     */   private void checkResConfigValue(String dslElement, String resConfigValue) {
/* 587 */     if (resConfigValue.equals("auto")) {
/* 588 */       deprecationReporter.reportDeprecatedValue("ProductFlavor." + dslElement, "auto", null, "https://google.github.io/android-gradle-dsl/current/com.android.build.gradle.internal.dsl.ProductFlavor.html#com.android.build.gradle.internal.dsl.ProductFlavor:resConfig(java.lang.String)", DeprecationReporter.DeprecationTarget.AUTO_SPLITS_OR_RES_CONFIG);
/*     */     }
/*     */   }
/*     */   
/*     */   public JavaCompileOptions getJavaCompileOptions()
/*     */   {
/* 601 */     return javaCompileOptions;
/*     */   }
/*     */   
/*     */   public void javaCompileOptions(Action<JavaCompileOptions> action) {
/* 605 */     action.execute(javaCompileOptions);
/*     */   }
/*     */   
/*     */   public CoreShaderOptions getShaders()
/*     */   {
/* 612 */     return shaderOptions;
/*     */   }
/*     */   
/*     */   public void shaders(Action<ShaderOptions> action)
/*     */   {
/* 617 */     action.execute(shaderOptions);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public Set<String> getGeneratedDensities()
/*     */   {
/* 628 */     return getVectorDrawables().getGeneratedDensities();
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void setGeneratedDensities(Iterable<String> densities) {
/* 633 */     getVectorDrawables().setGeneratedDensities(densities);
/*     */   }
/*     */   
/*     */   public void vectorDrawables(Action<VectorDrawablesOptions> action)
/*     */   {
/* 638 */     action.execute(getVectorDrawables());
/*     */   }
/*     */   
/*     */   public VectorDrawablesOptions getVectorDrawables()
/*     */   {
/* 645 */     return (VectorDrawablesOptions)super.getVectorDrawables();
/*     */   }
/*     */   
/*     */   public void wearAppUnbundled(Boolean wearAppUnbundled)
/*     */   {
/* 655 */     setWearAppUnbundled(wearAppUnbundled);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.BaseFlavor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */