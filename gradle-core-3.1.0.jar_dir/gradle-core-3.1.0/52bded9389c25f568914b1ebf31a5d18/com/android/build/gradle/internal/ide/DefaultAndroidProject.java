/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.build.gradle.internal.CompileOptions;
/*     */ import com.android.builder.model.AaptOptions;
/*     */ import com.android.builder.model.AndroidProject;
/*     */ import com.android.builder.model.ArtifactMetaData;
/*     */ import com.android.builder.model.BuildTypeContainer;
/*     */ import com.android.builder.model.JavaCompileOptions;
/*     */ import com.android.builder.model.LintOptions;
/*     */ import com.android.builder.model.NativeToolchain;
/*     */ import com.android.builder.model.ProductFlavorContainer;
/*     */ import com.android.builder.model.SigningConfig;
/*     */ import com.android.builder.model.SyncIssue;
/*     */ import com.android.builder.model.Variant;
/*     */ import com.android.builder.model.Version;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Objects;
/*     */ 
/*     */ final class DefaultAndroidProject
/*     */   implements AndroidProject, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String name;
/*     */   private final String compileTarget;
/*     */   private final Collection<String> bootClasspath;
/*     */   private final Collection<File> frameworkSource;
/*     */   private final Collection<SigningConfig> signingConfigs;
/*     */   private final AaptOptions aaptOptions;
/*     */   private final Collection<ArtifactMetaData> extraArtifacts;
/*     */   private final Collection<SyncIssue> syncIssues;
/*     */   private final int generation;
/*     */   private final boolean baseSplit;
/*     */   private final JavaCompileOptions javaCompileOptions;
/*     */   private final LintOptions lintOptions;
/*     */   private final File buildFolder;
/*     */   private final String buildToolsVersion;
/*     */   private final String resourcePrefix;
/*     */   private final Collection<NativeToolchain> nativeToolchains;
/*     */   private final int projectType;
/*     */   private final int apiVersion;
/*     */   private final ProductFlavorContainer defaultConfig;
/*     */   private final Collection<BuildTypeContainer> buildTypes;
/*     */   private final Collection<ProductFlavorContainer> productFlavors;
/*     */   private final Collection<Variant> variants;
/*     */   private final Collection<String> flavorDimensions;
/*     */   
/*     */   DefaultAndroidProject(String name, ProductFlavorContainer defaultConfig, Collection<String> flavorDimensions, Collection<BuildTypeContainer> buildTypes, Collection<ProductFlavorContainer> productFlavors, Collection<Variant> variants, String compileTarget, Collection<String> bootClasspath, Collection<File> frameworkSource, Collection<SigningConfig> signingConfigs, AaptOptions aaptOptions, Collection<ArtifactMetaData> extraArtifacts, Collection<SyncIssue> syncIssues, CompileOptions compileOptions, LintOptions lintOptions, File buildFolder, String resourcePrefix, Collection<NativeToolchain> nativeToolchains, String buildToolsVersion, int projectType, int apiVersion, int generation, boolean baseSplit)
/*     */   {
/* 116 */     this.name = name;
/* 117 */     this.defaultConfig = defaultConfig;
/* 118 */     this.flavorDimensions = flavorDimensions;
/* 119 */     this.buildTypes = buildTypes;
/* 120 */     this.productFlavors = productFlavors;
/* 121 */     this.variants = variants;
/* 122 */     this.compileTarget = compileTarget;
/* 123 */     this.bootClasspath = bootClasspath;
/* 124 */     this.frameworkSource = frameworkSource;
/* 125 */     this.signingConfigs = signingConfigs;
/* 126 */     this.aaptOptions = aaptOptions;
/* 127 */     this.extraArtifacts = extraArtifacts;
/* 128 */     this.syncIssues = syncIssues;
/* 129 */     javaCompileOptions = new DefaultJavaCompileOptions(compileOptions);
/* 130 */     this.lintOptions = lintOptions;
/* 131 */     this.buildFolder = buildFolder;
/* 132 */     this.resourcePrefix = resourcePrefix;
/* 133 */     this.projectType = projectType;
/* 134 */     this.apiVersion = apiVersion;
/* 135 */     this.generation = generation;
/* 136 */     this.nativeToolchains = nativeToolchains;
/* 137 */     this.buildToolsVersion = buildToolsVersion;
/* 138 */     this.baseSplit = baseSplit;
/*     */   }
/*     */   
/*     */   public String getModelVersion()
/*     */   {
/* 144 */     return Version.ANDROID_GRADLE_PLUGIN_VERSION;
/*     */   }
/*     */   
/*     */   public int getApiVersion()
/*     */   {
/* 149 */     return apiVersion;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 155 */     return name;
/*     */   }
/*     */   
/*     */   public ProductFlavorContainer getDefaultConfig()
/*     */   {
/* 161 */     return defaultConfig;
/*     */   }
/*     */   
/*     */   public Collection<BuildTypeContainer> getBuildTypes()
/*     */   {
/* 167 */     return buildTypes;
/*     */   }
/*     */   
/*     */   public Collection<ProductFlavorContainer> getProductFlavors()
/*     */   {
/* 173 */     return productFlavors;
/*     */   }
/*     */   
/*     */   public Collection<Variant> getVariants()
/*     */   {
/* 179 */     return variants;
/*     */   }
/*     */   
/*     */   public Collection<String> getFlavorDimensions()
/*     */   {
/* 185 */     return flavorDimensions;
/*     */   }
/*     */   
/*     */   public Collection<ArtifactMetaData> getExtraArtifacts()
/*     */   {
/* 191 */     return extraArtifacts;
/*     */   }
/*     */   
/*     */   public boolean isLibrary()
/*     */   {
/* 196 */     return getProjectType() == 1;
/*     */   }
/*     */   
/*     */   public int getProjectType()
/*     */   {
/* 201 */     return projectType;
/*     */   }
/*     */   
/*     */   public String getCompileTarget()
/*     */   {
/* 207 */     return compileTarget;
/*     */   }
/*     */   
/*     */   public Collection<String> getBootClasspath()
/*     */   {
/* 213 */     return bootClasspath;
/*     */   }
/*     */   
/*     */   public Collection<File> getFrameworkSources()
/*     */   {
/* 219 */     return frameworkSource;
/*     */   }
/*     */   
/*     */   public Collection<SigningConfig> getSigningConfigs()
/*     */   {
/* 225 */     return signingConfigs;
/*     */   }
/*     */   
/*     */   public AaptOptions getAaptOptions()
/*     */   {
/* 231 */     return aaptOptions;
/*     */   }
/*     */   
/*     */   public LintOptions getLintOptions()
/*     */   {
/* 237 */     return lintOptions;
/*     */   }
/*     */   
/*     */   public Collection<String> getUnresolvedDependencies()
/*     */   {
/* 243 */     return ImmutableList.of();
/*     */   }
/*     */   
/*     */   public Collection<SyncIssue> getSyncIssues()
/*     */   {
/* 249 */     return syncIssues;
/*     */   }
/*     */   
/*     */   public JavaCompileOptions getJavaCompileOptions()
/*     */   {
/* 255 */     return javaCompileOptions;
/*     */   }
/*     */   
/*     */   public File getBuildFolder()
/*     */   {
/* 261 */     return buildFolder;
/*     */   }
/*     */   
/*     */   public String getResourcePrefix()
/*     */   {
/* 267 */     return resourcePrefix;
/*     */   }
/*     */   
/*     */   public Collection<NativeToolchain> getNativeToolchains()
/*     */   {
/* 273 */     return nativeToolchains;
/*     */   }
/*     */   
/*     */   public String getBuildToolsVersion()
/*     */   {
/* 279 */     return buildToolsVersion;
/*     */   }
/*     */   
/*     */   public int getPluginGeneration()
/*     */   {
/* 284 */     return generation;
/*     */   }
/*     */   
/*     */   public boolean isBaseSplit()
/*     */   {
/* 289 */     return baseSplit;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 294 */     if (this == o) {
/* 295 */       return true;
/*     */     }
/* 297 */     if ((o == null) || (getClass() != o.getClass())) {
/* 298 */       return false;
/*     */     }
/* 300 */     DefaultAndroidProject that = (DefaultAndroidProject)o;
/* 301 */     if ((generation == generation) && (projectType == projectType) && (apiVersion == apiVersion)) {} return 
/*     */     
/* 304 */       (Objects.equals(name, name)) && 
/* 305 */       (Objects.equals(compileTarget, compileTarget)) && 
/* 306 */       (Objects.equals(bootClasspath, bootClasspath)) && 
/* 307 */       (Objects.equals(frameworkSource, frameworkSource)) && 
/* 308 */       (Objects.equals(signingConfigs, signingConfigs)) && 
/* 309 */       (Objects.equals(aaptOptions, aaptOptions)) && 
/* 310 */       (Objects.equals(extraArtifacts, extraArtifacts)) && 
/* 311 */       (Objects.equals(syncIssues, syncIssues)) && 
/* 312 */       (Objects.equals(javaCompileOptions, javaCompileOptions)) && 
/* 313 */       (Objects.equals(lintOptions, lintOptions)) && 
/* 314 */       (Objects.equals(buildFolder, buildFolder)) && 
/* 315 */       (Objects.equals(buildToolsVersion, buildToolsVersion)) && 
/* 316 */       (Objects.equals(resourcePrefix, resourcePrefix)) && 
/* 317 */       (Objects.equals(nativeToolchains, nativeToolchains)) && 
/* 318 */       (Objects.equals(buildTypes, buildTypes)) && 
/* 319 */       (Objects.equals(productFlavors, productFlavors)) && 
/* 320 */       (Objects.equals(variants, variants)) && 
/* 321 */       (Objects.equals(defaultConfig, defaultConfig)) && 
/* 322 */       (Objects.equals(flavorDimensions, flavorDimensions)) && 
/* 323 */       (Objects.equals(Boolean.valueOf(baseSplit), Boolean.valueOf(baseSplit)));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 328 */     return Objects.hash(new Object[] { name, compileTarget, bootClasspath, frameworkSource, signingConfigs, aaptOptions, extraArtifacts, syncIssues, 
/*     */     
/* 337 */       Integer.valueOf(generation), javaCompileOptions, lintOptions, buildFolder, buildToolsVersion, resourcePrefix, nativeToolchains, 
/*     */       
/* 344 */       Integer.valueOf(projectType), 
/* 345 */       Integer.valueOf(apiVersion), buildTypes, productFlavors, variants, defaultConfig, flavorDimensions, 
/*     */       
/* 351 */       Boolean.valueOf(baseSplit) });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DefaultAndroidProject
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */