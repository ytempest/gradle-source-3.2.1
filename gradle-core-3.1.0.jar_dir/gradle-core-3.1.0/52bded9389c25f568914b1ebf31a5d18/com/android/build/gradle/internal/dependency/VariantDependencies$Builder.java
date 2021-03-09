/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import com.android.build.api.attributes.BuildTypeAttr;
/*     */ import com.android.build.api.attributes.ProductFlavorAttr;
/*     */ import com.android.build.api.attributes.VariantAttr;
/*     */ import com.android.build.gradle.internal.api.DefaultAndroidSourceSet;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.dsl.CoreProductFlavor;
/*     */ import com.android.build.gradle.internal.errors.SyncIssueHandler;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.artifacts.Configuration;
/*     */ import org.gradle.api.artifacts.ConfigurationContainer;
/*     */ import org.gradle.api.artifacts.ResolutionStrategy;
/*     */ import org.gradle.api.artifacts.ResolutionStrategy.SortOrder;
/*     */ import org.gradle.api.attributes.Attribute;
/*     */ import org.gradle.api.attributes.AttributeContainer;
/*     */ import org.gradle.api.attributes.Usage;
/*     */ import org.gradle.api.model.ObjectFactory;
/*     */ 
/*     */ public final class VariantDependencies$Builder
/*     */ {
/*     */   private final Project project;
/*     */   private final SyncIssueHandler errorReporter;
/*     */   private final GradleVariantConfiguration variantConfiguration;
/* 105 */   private boolean baseSplit = false;
/*     */   
/*     */   private Map<Attribute<ProductFlavorAttr>, ProductFlavorAttr> flavorSelection;
/*     */   
/*     */   private AndroidTypeAttr consumeType;
/*     */   
/*     */   private AndroidTypeAttr publishType;
/*     */   
/* 116 */   private final Set<Configuration> compileClasspaths = Sets.newLinkedHashSet();
/* 117 */   private final Set<Configuration> apiClasspaths = Sets.newLinkedHashSet();
/* 118 */   private final Set<Configuration> implementationConfigurations = Sets.newLinkedHashSet();
/* 119 */   private final Set<Configuration> runtimeClasspaths = Sets.newLinkedHashSet();
/* 120 */   private final Set<Configuration> annotationConfigs = Sets.newLinkedHashSet();
/* 121 */   private final Set<Configuration> wearAppConfigs = Sets.newLinkedHashSet();
/*     */   
/*     */   private VariantDependencies testedVariantDependencies;
/*     */   
/*     */   protected VariantDependencies$Builder(Project project, SyncIssueHandler errorReporter, GradleVariantConfiguration variantConfiguration)
/*     */   {
/* 128 */     this.project = project;
/* 129 */     this.errorReporter = errorReporter;
/* 130 */     this.variantConfiguration = variantConfiguration;
/*     */   }
/*     */   
/*     */   public Builder setPublishType(AndroidTypeAttr publishType) {
/* 134 */     this.publishType = publishType;
/* 135 */     return this;
/*     */   }
/*     */   
/*     */   public Builder setConsumeType(AndroidTypeAttr consumeType) {
/* 139 */     this.consumeType = consumeType;
/* 140 */     return this;
/*     */   }
/*     */   
/*     */   public Builder addSourceSets(DefaultAndroidSourceSet... sourceSets) {
/* 144 */     for (DefaultAndroidSourceSet sourceSet : sourceSets) {
/* 145 */       addSourceSet(sourceSet);
/*     */     }
/* 147 */     return this;
/*     */   }
/*     */   
/*     */   public Builder addSourceSets(Collection<DefaultAndroidSourceSet> sourceSets) {
/* 151 */     for (DefaultAndroidSourceSet sourceSet : sourceSets) {
/* 152 */       addSourceSet(sourceSet);
/*     */     }
/* 154 */     return this;
/*     */   }
/*     */   
/*     */   public Builder setTestedVariantDependencies(VariantDependencies testedVariantDependencies)
/*     */   {
/* 159 */     this.testedVariantDependencies = testedVariantDependencies;
/* 160 */     return this;
/*     */   }
/*     */   
/*     */   public Builder setBaseSplit(boolean baseSplit) {
/* 164 */     this.baseSplit = baseSplit;
/* 165 */     return this;
/*     */   }
/*     */   
/*     */   public Builder addSourceSet(DefaultAndroidSourceSet sourceSet) {
/* 169 */     if (sourceSet != null)
/*     */     {
/* 171 */       ConfigurationContainer configs = project.getConfigurations();
/*     */       
/* 173 */       compileClasspaths.add(configs.getByName(sourceSet.getCompileOnlyConfigurationName()));
/* 174 */       runtimeClasspaths.add(configs.getByName(sourceSet.getRuntimeOnlyConfigurationName()));
/*     */       
/* 176 */       Configuration implementationConfig = configs.getByName(sourceSet.getImplementationConfigurationName());
/* 177 */       compileClasspaths.add(implementationConfig);
/* 178 */       runtimeClasspaths.add(implementationConfig);
/* 179 */       implementationConfigurations.add(implementationConfig);
/*     */       
/* 181 */       String apiConfigName = sourceSet.getApiConfigurationName();
/* 182 */       if (apiConfigName != null) {
/* 183 */         apiClasspaths.add(configs.getByName(apiConfigName));
/*     */       }
/*     */       
/* 186 */       annotationConfigs.add(configs.getByName(sourceSet.getAnnotationProcessorConfigurationName()));
/* 187 */       wearAppConfigs.add(configs.getByName(sourceSet.getWearAppConfigurationName()));
/*     */     }
/*     */     
/* 190 */     return this;
/*     */   }
/*     */   
/*     */   public Builder setFlavorSelection(Map<Attribute<ProductFlavorAttr>, ProductFlavorAttr> flavorSelection)
/*     */   {
/* 195 */     this.flavorSelection = flavorSelection;
/* 196 */     return this;
/*     */   }
/*     */   
/*     */   public VariantDependencies build() {
/* 200 */     Preconditions.checkNotNull(consumeType);
/*     */     
/* 202 */     ObjectFactory factory = project.getObjects();
/*     */     
/* 204 */     Usage apiUsage = (Usage)factory.named(Usage.class, "java-api");
/* 205 */     Usage runtimeUsage = (Usage)factory.named(Usage.class, "java-runtime");
/*     */     
/* 207 */     String variantName = variantConfiguration.getFullName();
/* 208 */     VariantType variantType = variantConfiguration.getType();
/* 209 */     String buildType = ((CoreBuildType)variantConfiguration.getBuildType()).getName();
/*     */     
/* 211 */     Map<Attribute<ProductFlavorAttr>, ProductFlavorAttr> consumptionFlavorMap = getFlavorAttributes(flavorSelection);
/*     */     
/* 213 */     ConfigurationContainer configurations = project.getConfigurations();
/*     */     
/* 215 */     String compileClasspathName = variantName + "CompileClasspath";
/* 216 */     Configuration compileClasspath = (Configuration)configurations.maybeCreate(compileClasspathName);
/* 217 */     compileClasspath.setVisible(false);
/* 218 */     compileClasspath.setDescription("Resolved configuration for compilation for variant: " + variantName);
/* 219 */     compileClasspath.setExtendsFrom(compileClasspaths);
/* 220 */     if (testedVariantDependencies != null)
/*     */     {
/* 222 */       for (Configuration configuration : VariantDependencies.access$000(testedVariantDependencies)) {
/* 223 */         compileClasspath.extendsFrom(new Configuration[] { configuration });
/*     */       }
/*     */     }
/* 226 */     compileClasspath.setCanBeConsumed(false);
/* 227 */     compileClasspath.getResolutionStrategy().sortArtifacts(ResolutionStrategy.SortOrder.CONSUMER_FIRST);
/* 228 */     AttributeContainer compileAttributes = compileClasspath.getAttributes();
/* 229 */     applyVariantAttributes(compileAttributes, buildType, consumptionFlavorMap);
/* 230 */     compileAttributes.attribute(Usage.USAGE_ATTRIBUTE, apiUsage);
/* 231 */     compileAttributes.attribute(AndroidTypeAttr.ATTRIBUTE, consumeType);
/*     */     
/* 234 */     Configuration annotationProcessor = (Configuration)configurations.maybeCreate(variantName + "AnnotationProcessorClasspath");
/* 235 */     annotationProcessor.setVisible(false);
/* 236 */     annotationProcessor.setDescription("Resolved configuration for annotation-processor for variant: " + variantName);
/* 237 */     annotationProcessor.setExtendsFrom(annotationConfigs);
/* 238 */     annotationProcessor.setCanBeConsumed(false);
/*     */     
/* 241 */     AttributeContainer annotationAttributes = annotationProcessor.getAttributes();
/* 242 */     annotationAttributes.attribute(Usage.USAGE_ATTRIBUTE, runtimeUsage);
/* 243 */     applyVariantAttributes(annotationAttributes, buildType, consumptionFlavorMap);
/*     */     
/* 245 */     String runtimeClasspathName = variantName + "RuntimeClasspath";
/* 246 */     Configuration runtimeClasspath = (Configuration)configurations.maybeCreate(runtimeClasspathName);
/* 247 */     runtimeClasspath.setVisible(false);
/* 248 */     runtimeClasspath.setDescription("Resolved configuration for runtime for variant: " + variantName);
/* 249 */     runtimeClasspath.setExtendsFrom(runtimeClasspaths);
/* 250 */     if (testedVariantDependencies != null)
/*     */     {
/* 252 */       for (Configuration configuration : VariantDependencies.access$100(testedVariantDependencies)) {
/* 253 */         runtimeClasspath.extendsFrom(new Configuration[] { configuration });
/*     */       }
/*     */     }
/* 256 */     runtimeClasspath.setCanBeConsumed(false);
/* 257 */     runtimeClasspath.getResolutionStrategy().sortArtifacts(ResolutionStrategy.SortOrder.CONSUMER_FIRST);
/* 258 */     AttributeContainer runtimeAttributes = runtimeClasspath.getAttributes();
/* 259 */     applyVariantAttributes(runtimeAttributes, buildType, consumptionFlavorMap);
/* 260 */     runtimeAttributes.attribute(Usage.USAGE_ATTRIBUTE, runtimeUsage);
/* 261 */     runtimeAttributes.attribute(AndroidTypeAttr.ATTRIBUTE, consumeType);
/*     */     
/* 263 */     Configuration apiElements = null;
/* 264 */     Configuration runtimeElements = null;
/* 265 */     Configuration metadataElements = null;
/* 266 */     Configuration metadataValues = null;
/* 267 */     Configuration wearApp = null;
/* 268 */     Configuration bundleElements = null;
/*     */     
/* 270 */     if (publishType != null) {
/* 271 */       if (publishType.getName().equals("Apk")) {
/* 272 */         wearApp = (Configuration)configurations.maybeCreate(variantName + "WearBundling");
/* 273 */         wearApp.setDescription("Resolved Configuration for wear app bundling for variant: " + variantName);
/*     */         
/* 276 */         wearApp.setExtendsFrom(wearAppConfigs);
/* 277 */         wearApp.setCanBeConsumed(false);
/* 278 */         AttributeContainer wearAttributes = wearApp.getAttributes();
/* 279 */         applyVariantAttributes(wearAttributes, buildType, consumptionFlavorMap);
/*     */         
/* 281 */         wearAttributes.attribute(Usage.USAGE_ATTRIBUTE, runtimeUsage);
/* 282 */         wearAttributes.attribute(AndroidTypeAttr.ATTRIBUTE, factory
/*     */         
/* 284 */           .named(AndroidTypeAttr.class, "Apk"));
/*     */         
/* 287 */         bundleElements = (Configuration)configurations.maybeCreate(variantName + "BundleElements");
/* 288 */         bundleElements.setDescription("Bundle elements for " + variantName);
/* 289 */         bundleElements.setCanBeResolved(false);
/*     */         
/* 292 */         AttributeContainer bundleElementsAttributes = bundleElements.getAttributes();
/* 293 */         VariantAttr variantNameAttr = (VariantAttr)factory.named(VariantAttr.class, variantName);
/* 294 */         bundleElementsAttributes.attribute(VariantAttr.ATTRIBUTE, variantNameAttr);
/* 295 */         bundleElementsAttributes.attribute(Usage.USAGE_ATTRIBUTE, factory
/* 296 */           .named(Usage.class, "android-bundle"));
/*     */       }
/*     */       
/* 300 */       Map<Attribute<ProductFlavorAttr>, ProductFlavorAttr> publicationFlavorMap = getFlavorAttributes(null);
/*     */       
/* 304 */       runtimeElements = (Configuration)configurations.maybeCreate(variantName + "RuntimeElements");
/* 305 */       runtimeElements.setDescription("Runtime elements for " + variantName);
/* 306 */       runtimeElements.setCanBeResolved(false);
/*     */       
/* 309 */       AttributeContainer runtimeElementsAttributes = runtimeElements.getAttributes();
/* 310 */       applyVariantAttributes(runtimeElementsAttributes, buildType, publicationFlavorMap);
/* 311 */       VariantAttr variantNameAttr = (VariantAttr)factory.named(VariantAttr.class, variantName);
/* 312 */       runtimeElementsAttributes.attribute(VariantAttr.ATTRIBUTE, variantNameAttr);
/* 313 */       runtimeElementsAttributes.attribute(Usage.USAGE_ATTRIBUTE, runtimeUsage);
/* 314 */       runtimeElementsAttributes.attribute(AndroidTypeAttr.ATTRIBUTE, publishType);
/*     */       
/* 319 */       if (variantType == VariantType.LIBRARY) {
/* 320 */         runtimeElements.extendsFrom(new Configuration[] { runtimeClasspath });
/*     */       }
/*     */       
/* 323 */       apiElements = (Configuration)configurations.maybeCreate(variantName + "ApiElements");
/* 324 */       apiElements.setDescription("API elements for " + variantName);
/* 325 */       apiElements.setCanBeResolved(false);
/* 326 */       AttributeContainer apiElementsAttributes = apiElements.getAttributes();
/* 327 */       applyVariantAttributes(apiElementsAttributes, buildType, publicationFlavorMap);
/* 328 */       apiElementsAttributes.attribute(VariantAttr.ATTRIBUTE, variantNameAttr);
/* 329 */       apiElementsAttributes.attribute(Usage.USAGE_ATTRIBUTE, apiUsage);
/* 330 */       apiElementsAttributes.attribute(AndroidTypeAttr.ATTRIBUTE, publishType);
/*     */       
/* 332 */       apiElements.setExtendsFrom(apiClasspaths);
/*     */       
/* 334 */       if (variantType != VariantType.LIBRARY)
/*     */       {
/* 340 */         metadataElements = (Configuration)configurations.maybeCreate(variantName + "MetadataElements");
/* 341 */         metadataElements.setDescription("Metadata elements for " + variantName);
/* 342 */         metadataElements.setCanBeResolved(false);
/*     */         
/* 344 */         AttributeContainer metadataElementsAttributes = metadataElements.getAttributes();
/* 345 */         applyVariantAttributes(metadataElementsAttributes, buildType, publicationFlavorMap);
/*     */         
/* 347 */         metadataElementsAttributes.attribute(AndroidTypeAttr.ATTRIBUTE, factory
/*     */         
/* 349 */           .named(AndroidTypeAttr.class, "Metadata"));
/* 350 */         metadataElementsAttributes.attribute(VariantAttr.ATTRIBUTE, variantNameAttr);
/*     */       }
/*     */       
/* 353 */       if ((variantType == VariantType.FEATURE) && (baseSplit))
/*     */       {
/* 358 */         metadataValues = (Configuration)configurations.maybeCreate(variantName + "MetadataValues");
/* 359 */         metadataValues.extendsFrom(new Configuration[] {configurations
/* 360 */           .getByName("feature"), configurations
/* 361 */           .getByName("application") });
/* 362 */         metadataValues.setDescription("Metadata Values dependencies for the base Split");
/*     */         
/* 364 */         metadataValues.setCanBeConsumed(false);
/*     */         
/* 366 */         AttributeContainer featureMetadataAttributes = metadataValues.getAttributes();
/* 367 */         featureMetadataAttributes.attribute(AndroidTypeAttr.ATTRIBUTE, factory
/*     */         
/* 369 */           .named(AndroidTypeAttr.class, "Metadata"));
/* 370 */         applyVariantAttributes(featureMetadataAttributes, buildType, consumptionFlavorMap);
/*     */       }
/*     */     }
/*     */     
/* 376 */     checkOldConfigurations(configurations, "_" + variantName + "Compile", compileClasspathName);
/*     */     
/* 378 */     checkOldConfigurations(configurations, "_" + variantName + "Apk", runtimeClasspathName);
/* 379 */     checkOldConfigurations(configurations, "_" + variantName + "Publish", runtimeClasspathName);
/*     */     
/* 382 */     return new VariantDependencies(variantName, compileClasspath, runtimeClasspath, runtimeClasspaths, implementationConfigurations, apiElements, runtimeElements, annotationProcessor, metadataElements, metadataValues, wearApp, bundleElements, null);
/*     */   }
/*     */   
/*     */   private static void checkOldConfigurations(ConfigurationContainer configurations, String oldConfigName, String newConfigName)
/*     */   {
/* 401 */     if (configurations.findByName(oldConfigName) != null)
/*     */     {
/* 403 */       throw new RuntimeException(String.format("Configuration with old name %s found. Use new name %s instead.", new Object[] { oldConfigName, newConfigName }));
/*     */     }
/*     */   }
/*     */   
/*     */   private Map<Attribute<ProductFlavorAttr>, ProductFlavorAttr> getFlavorAttributes(Map<Attribute<ProductFlavorAttr>, ProductFlavorAttr> flavorSelection)
/*     */   {
/* 417 */     List<CoreProductFlavor> productFlavors = variantConfiguration.getProductFlavors();
/* 418 */     Map<Attribute<ProductFlavorAttr>, ProductFlavorAttr> map = Maps.newHashMapWithExpectedSize(productFlavors.size());
/*     */     
/* 424 */     if (errorReporter.hasSyncIssue(EvalIssueReporter.Type.UNNAMED_FLAVOR_DIMENSION)) {
/* 425 */       return map;
/*     */     }
/*     */     
/* 428 */     ObjectFactory objectFactory = project.getObjects();
/*     */     
/* 431 */     for (CoreProductFlavor f : productFlavors) {
/* 432 */       assert (f.getDimension() != null);
/*     */       
/* 434 */       map.put(
/* 435 */         Attribute.of(f.getDimension(), ProductFlavorAttr.class), objectFactory
/* 436 */         .named(ProductFlavorAttr.class, f.getName()));
/*     */     }
/*     */     
/* 440 */     if (flavorSelection != null) {
/* 441 */       map.putAll(flavorSelection);
/*     */     }
/*     */     
/* 444 */     return map;
/*     */   }
/*     */   
/*     */   private void applyVariantAttributes(AttributeContainer attributeContainer, String buildType, Map<Attribute<ProductFlavorAttr>, ProductFlavorAttr> flavorMap)
/*     */   {
/* 451 */     attributeContainer.attribute(BuildTypeAttr.ATTRIBUTE, project
/*     */     
/* 453 */       .getObjects().named(BuildTypeAttr.class, buildType));
/* 454 */     for (Map.Entry<Attribute<ProductFlavorAttr>, ProductFlavorAttr> entry : flavorMap.entrySet()) {
/* 455 */       attributeContainer.attribute((Attribute)entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.VariantDependencies.Builder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */