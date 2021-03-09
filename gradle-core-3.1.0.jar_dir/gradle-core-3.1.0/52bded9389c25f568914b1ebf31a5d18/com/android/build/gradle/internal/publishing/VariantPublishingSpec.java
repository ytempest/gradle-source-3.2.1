/*     */ package com.android.build.gradle.internal.publishing;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.AnchorOutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class VariantPublishingSpec
/*     */ {
/*  97 */   private static final ImmutableList<AndroidArtifacts.PublishedConfigType> API_ELEMENTS_ONLY = ImmutableList.of(AndroidArtifacts.PublishedConfigType.API_ELEMENTS);
/*     */   
/*  99 */   private static final ImmutableList<AndroidArtifacts.PublishedConfigType> RUNTIME_ELEMENTS_ONLY = ImmutableList.of(AndroidArtifacts.PublishedConfigType.RUNTIME_ELEMENTS);
/*     */   
/* 101 */   private static final ImmutableList<AndroidArtifacts.PublishedConfigType> API_AND_RUNTIME_ELEMENTS = ImmutableList.of(AndroidArtifacts.PublishedConfigType.API_ELEMENTS, AndroidArtifacts.PublishedConfigType.RUNTIME_ELEMENTS);
/*     */   
/* 103 */   private static final ImmutableList<AndroidArtifacts.PublishedConfigType> METADATA_ELEMENTS_ONLY = ImmutableList.of(AndroidArtifacts.PublishedConfigType.METADATA_ELEMENTS);
/*     */   
/* 105 */   private static final ImmutableList<AndroidArtifacts.PublishedConfigType> BUNDLE_ELEMENTS_ONLY = ImmutableList.of(AndroidArtifacts.PublishedConfigType.BUNDLE_ELEMENTS);
/*     */   
/* 108 */   private static final Map<VariantType, VariantPublishingSpec> variantMap = Maps.newEnumMap(VariantType.class);
/*     */   
/*     */   private final VariantPublishingSpec parentSpec;
/*     */   
/*     */   private final VariantType variantType;
/*     */   
/*     */   private final Set<OutputPublishingSpec> taskSpecs;
/*     */   
/* 116 */   private final Map<VariantType, VariantPublishingSpec> testingSpecs = Maps.newEnumMap(VariantType.class);
/*     */   
/*     */   private Map<AndroidArtifacts.ArtifactType, OutputPublishingSpec> artifactMap;
/*     */   
/*     */   private Map<TaskOutputHolder.OutputType, OutputPublishingSpec> outputMap;
/*     */   
/*     */   static
/*     */   {
/* 156 */     variantSpec(VariantType.DEFAULT, new OutputPublishingSpec[] { outputSpec(TaskOutputHolder.TaskOutputType.MANIFEST_METADATA, AndroidArtifacts.ArtifactType.MANIFEST_METADATA, API_ELEMENTS_ONLY), outputSpec(TaskOutputHolder.TaskOutputType.APP_CLASSES, AndroidArtifacts.ArtifactType.JAR, API_ELEMENTS_ONLY), outputSpec(TaskOutputHolder.TaskOutputType.APK, AndroidArtifacts.ArtifactType.APK, RUNTIME_ELEMENTS_ONLY), outputSpec(TaskOutputHolder.TaskOutputType.APK_MAPPING, AndroidArtifacts.ArtifactType.APK_MAPPING, API_ELEMENTS_ONLY), outputSpec(TaskOutputHolder.TaskOutputType.METADATA_APP_ID_DECLARATION, AndroidArtifacts.ArtifactType.METADATA_APP_ID_DECLARATION, METADATA_ELEMENTS_ONLY), outputSpec(TaskOutputHolder.TaskOutputType.MERGED_ASSETS, AndroidArtifacts.ArtifactType.ASSETS, BUNDLE_ELEMENTS_ONLY), outputSpec(TaskOutputHolder.TaskOutputType.PUBLISHED_DEX, AndroidArtifacts.ArtifactType.DEX, BUNDLE_ELEMENTS_ONLY), outputSpec(TaskOutputHolder.TaskOutputType.PUBLISHED_JAVA_RES, AndroidArtifacts.ArtifactType.JAVA_RES, BUNDLE_ELEMENTS_ONLY), outputSpec(TaskOutputHolder.TaskOutputType.PUBLISHED_NATIVE_LIBS, AndroidArtifacts.ArtifactType.JNI, BUNDLE_ELEMENTS_ONLY), outputSpec(TaskOutputHolder.TaskOutputType.LINKED_RES_FOR_BUNDLE, AndroidArtifacts.ArtifactType.RES_BUNDLE, BUNDLE_ELEMENTS_ONLY) }).withTestingSpec(VariantType.ANDROID_TEST, new OutputPublishingSpec[] { outputSpec(TaskOutputHolder.TaskOutputType.APP_CLASSES, AndroidArtifacts.ArtifactType.CLASSES, API_ELEMENTS_ONLY) }).withTestingSpec(VariantType.UNIT_TEST, new OutputPublishingSpec[] {
/*     */     
/* 161 */       outputSpec(TaskOutputHolder.AnchorOutputType.ALL_CLASSES, AndroidArtifacts.ArtifactType.CLASSES, API_AND_RUNTIME_ELEMENTS), 
/*     */       
/* 163 */       outputSpec(TaskOutputHolder.TaskOutputType.JAVA_RES, AndroidArtifacts.ArtifactType.JAVA_RES, API_AND_RUNTIME_ELEMENTS) });
/*     */     
/* 165 */     variantSpec(VariantType.LIBRARY, new OutputPublishingSpec[] {
/*     */     
/* 169 */       outputSpec(TaskOutputHolder.TaskOutputType.LIBRARY_MANIFEST, AndroidArtifacts.ArtifactType.MANIFEST, API_AND_RUNTIME_ELEMENTS), 
/*     */       
/* 171 */       outputSpec(TaskOutputHolder.TaskOutputType.LIBRARY_ASSETS, AndroidArtifacts.ArtifactType.ASSETS, RUNTIME_ELEMENTS_ONLY), 
/* 172 */       outputSpec(TaskOutputHolder.TaskOutputType.PACKAGED_RES, AndroidArtifacts.ArtifactType.ANDROID_RES, RUNTIME_ELEMENTS_ONLY), 
/* 173 */       outputSpec(TaskOutputHolder.TaskOutputType.RES_STATIC_LIBRARY, AndroidArtifacts.ArtifactType.RES_STATIC_LIBRARY, API_AND_RUNTIME_ELEMENTS), 
/*     */       
/* 177 */       outputSpec(TaskOutputHolder.TaskOutputType.COMPILE_ONLY_NAMESPACED_R_CLASS_JAR, AndroidArtifacts.ArtifactType.COMPILE_ONLY_NAMESPACED_R_CLASS_JAR, API_ELEMENTS_ONLY), 
/*     */       
/* 181 */       outputSpec(TaskOutputHolder.TaskOutputType.PUBLIC_RES, AndroidArtifacts.ArtifactType.PUBLIC_RES, RUNTIME_ELEMENTS_ONLY), 
/* 182 */       outputSpec(TaskOutputHolder.TaskOutputType.SYMBOL_LIST, AndroidArtifacts.ArtifactType.SYMBOL_LIST, RUNTIME_ELEMENTS_ONLY), 
/* 183 */       outputSpec(TaskOutputHolder.TaskOutputType.SYMBOL_LIST_WITH_PACKAGE_NAME, AndroidArtifacts.ArtifactType.SYMBOL_LIST_WITH_PACKAGE_NAME, RUNTIME_ELEMENTS_ONLY), 
/*     */       
/* 187 */       outputSpec(TaskOutputHolder.TaskOutputType.AIDL_PARCELABLE, AndroidArtifacts.ArtifactType.AIDL, API_ELEMENTS_ONLY), 
/* 188 */       outputSpec(TaskOutputHolder.TaskOutputType.RENDERSCRIPT_HEADERS, AndroidArtifacts.ArtifactType.RENDERSCRIPT, API_ELEMENTS_ONLY), 
/*     */       
/* 190 */       outputSpec(TaskOutputHolder.TaskOutputType.DATA_BINDING_ARTIFACT, AndroidArtifacts.ArtifactType.DATA_BINDING_ARTIFACT, API_AND_RUNTIME_ELEMENTS), 
/*     */       
/* 194 */       outputSpec(TaskOutputHolder.TaskOutputType.DATA_BINDING_BASE_CLASS_LOG_ARTIFACT, AndroidArtifacts.ArtifactType.DATA_BINDING_BASE_CLASS_LOG_ARTIFACT, API_AND_RUNTIME_ELEMENTS), 
/*     */       
/* 198 */       outputSpec(TaskOutputHolder.TaskOutputType.LIBRARY_CLASSES, AndroidArtifacts.ArtifactType.CLASSES, API_AND_RUNTIME_ELEMENTS), 
/* 199 */       outputSpec(TaskOutputHolder.TaskOutputType.FULL_JAR, AndroidArtifacts.ArtifactType.JAR, API_AND_RUNTIME_ELEMENTS), 
/* 200 */       outputSpec(TaskOutputHolder.TaskOutputType.LIBRARY_JAVA_RES, AndroidArtifacts.ArtifactType.JAVA_RES, RUNTIME_ELEMENTS_ONLY), 
/* 201 */       outputSpec(TaskOutputHolder.TaskOutputType.CONSUMER_PROGUARD_FILE, AndroidArtifacts.ArtifactType.PROGUARD_RULES, RUNTIME_ELEMENTS_ONLY), 
/*     */       
/* 205 */       outputSpec(TaskOutputHolder.TaskOutputType.LIBRARY_JNI, AndroidArtifacts.ArtifactType.JNI, RUNTIME_ELEMENTS_ONLY), 
/* 206 */       outputSpec(TaskOutputHolder.TaskOutputType.LINT_JAR, AndroidArtifacts.ArtifactType.LINT, RUNTIME_ELEMENTS_ONLY) })
/* 207 */       .withTestingSpec(VariantType.UNIT_TEST, new OutputPublishingSpec[] {
/*     */       
/* 211 */       outputSpec(TaskOutputHolder.AnchorOutputType.ALL_CLASSES, AndroidArtifacts.ArtifactType.CLASSES, API_AND_RUNTIME_ELEMENTS) });
/*     */     
/* 213 */     variantSpec(VariantType.FEATURE, new OutputPublishingSpec[] {
/*     */     
/* 215 */       outputSpec(TaskOutputHolder.TaskOutputType.METADATA_FEATURE_DECLARATION, AndroidArtifacts.ArtifactType.METADATA_FEATURE_DECLARATION, METADATA_ELEMENTS_ONLY), 
/*     */       
/* 219 */       outputSpec(TaskOutputHolder.TaskOutputType.METADADA_FEATURE_MANIFEST, AndroidArtifacts.ArtifactType.METADATA_FEATURE_MANIFEST, METADATA_ELEMENTS_ONLY), 
/*     */       
/* 223 */       outputSpec(TaskOutputHolder.TaskOutputType.FEATURE_IDS_DECLARATION, AndroidArtifacts.ArtifactType.FEATURE_IDS_DECLARATION, API_ELEMENTS_ONLY), 
/*     */       
/* 227 */       outputSpec(TaskOutputHolder.TaskOutputType.FEATURE_APPLICATION_ID_DECLARATION, AndroidArtifacts.ArtifactType.FEATURE_APPLICATION_ID_DECLARATION, API_ELEMENTS_ONLY), 
/*     */       
/* 231 */       outputSpec(TaskOutputHolder.TaskOutputType.FEATURE_RESOURCE_PKG, AndroidArtifacts.ArtifactType.FEATURE_RESOURCE_PKG, API_ELEMENTS_ONLY), 
/*     */       
/* 233 */       outputSpec(TaskOutputHolder.TaskOutputType.FEATURE_TRANSITIVE_DEPS, AndroidArtifacts.ArtifactType.FEATURE_TRANSITIVE_DEPS, RUNTIME_ELEMENTS_ONLY), 
/*     */       
/* 237 */       outputSpec(TaskOutputHolder.TaskOutputType.FEATURE_CLASSES, AndroidArtifacts.ArtifactType.CLASSES, API_ELEMENTS_ONLY), 
/* 238 */       outputSpec(TaskOutputHolder.TaskOutputType.APK, AndroidArtifacts.ArtifactType.APK, RUNTIME_ELEMENTS_ONLY) });
/*     */     
/* 241 */     variantSpec(VariantType.ANDROID_TEST, new OutputPublishingSpec[0]);
/* 242 */     variantSpec(VariantType.UNIT_TEST, new OutputPublishingSpec[0]);
/* 243 */     variantSpec(VariantType.INSTANTAPP, new OutputPublishingSpec[0]);
/*     */   }
/*     */   
/*     */   public static VariantPublishingSpec getVariantSpec(VariantType variantType) {
/* 247 */     return (VariantPublishingSpec)variantMap.get(variantType);
/*     */   }
/*     */   
/*     */   public VariantPublishingSpec getTestingSpec(VariantType variantType) {
/* 251 */     Preconditions.checkState(variantType.isForTesting());
/*     */     
/* 253 */     VariantPublishingSpec testingSpec = (VariantPublishingSpec)testingSpecs.get(variantType);
/* 254 */     if (testingSpec != null) {
/* 255 */       return testingSpec;
/*     */     }
/*     */     
/* 258 */     return this;
/*     */   }
/*     */   
/*     */   public OutputPublishingSpec getSpec(AndroidArtifacts.ArtifactType artifactType) {
/* 262 */     if (artifactMap == null) {
/* 263 */       artifactMap = Maps.newEnumMap(AndroidArtifacts.ArtifactType.class);
/* 264 */       for (OutputPublishingSpec taskSpec : taskSpecs) {
/* 265 */         artifactMap.put(artifactType, taskSpec);
/*     */       }
/*     */     }
/*     */     
/* 269 */     OutputPublishingSpec spec = (OutputPublishingSpec)artifactMap.get(artifactType);
/* 270 */     if (spec != null) {
/* 271 */       return spec;
/*     */     }
/*     */     
/* 274 */     if (parentSpec != null) {
/* 275 */       return parentSpec.getSpec(artifactType);
/*     */     }
/*     */     
/* 278 */     return null;
/*     */   }
/*     */   
/*     */   public OutputPublishingSpec getSpec(TaskOutputHolder.OutputType taskOutputType) {
/* 282 */     if (outputMap == null) {
/* 283 */       outputMap = Maps.newHashMap();
/* 284 */       for (OutputPublishingSpec taskSpec : taskSpecs) {
/* 285 */         outputMap.put(outputType, taskSpec);
/*     */       }
/*     */     }
/*     */     
/* 289 */     OutputPublishingSpec spec = (OutputPublishingSpec)outputMap.get(taskOutputType);
/* 290 */     if (spec != null) {
/* 291 */       return spec;
/*     */     }
/*     */     
/* 294 */     if (parentSpec != null) {
/* 295 */       return parentSpec.getSpec(taskOutputType);
/*     */     }
/*     */     
/* 298 */     return null;
/*     */   }
/*     */   
/*     */   private static VariantPublishingSpec variantSpec(VariantType variantType, OutputPublishingSpec... taskSpecs)
/*     */   {
/* 304 */     VariantPublishingSpec spec = new VariantPublishingSpec(variantType, ImmutableSet.copyOf(taskSpecs));
/* 305 */     variantMap.put(variantType, spec);
/*     */     
/* 307 */     return spec;
/*     */   }
/*     */   
/*     */   private VariantPublishingSpec withTestingSpec(VariantType variantType, OutputPublishingSpec... taskSpecs)
/*     */   {
/* 312 */     Preconditions.checkState(!this.variantType.isForTesting());
/* 313 */     Preconditions.checkState(variantType.isForTesting());
/* 314 */     Preconditions.checkState(!testingSpecs.containsKey(variantType));
/*     */     
/* 317 */     VariantPublishingSpec spec = new VariantPublishingSpec(this, variantType, ImmutableSet.copyOf(taskSpecs));
/*     */     
/* 319 */     testingSpecs.put(variantType, spec);
/*     */     
/* 321 */     return this;
/*     */   }
/*     */   
/*     */   private static OutputPublishingSpec outputSpec(TaskOutputHolder.OutputType taskOutputType, AndroidArtifacts.ArtifactType artifactType, ImmutableList<AndroidArtifacts.PublishedConfigType> publishedConfigTypes)
/*     */   {
/* 328 */     return new OutputPublishingSpec(taskOutputType, artifactType, publishedConfigTypes, null);
/*     */   }
/*     */   
/*     */   private VariantPublishingSpec(VariantType variantType, Set<OutputPublishingSpec> taskSpecs)
/*     */   {
/* 333 */     this(null, variantType, taskSpecs);
/*     */   }
/*     */   
/*     */   private VariantPublishingSpec(VariantPublishingSpec parentSpec, VariantType variantType, Set<OutputPublishingSpec> taskSpecs)
/*     */   {
/* 340 */     this.parentSpec = parentSpec;
/* 341 */     this.variantType = variantType;
/* 342 */     this.taskSpecs = taskSpecs;
/*     */   }
/*     */   
/*     */   static Map<VariantType, VariantPublishingSpec> getVariantMap()
/*     */   {
/* 347 */     return variantMap;
/*     */   }
/*     */   
/*     */   public static final class OutputPublishingSpec
/*     */   {
/*     */     private final TaskOutputHolder.OutputType outputType;
/*     */     private final AndroidArtifacts.ArtifactType artifactType;
/*     */     private final List<AndroidArtifacts.PublishedConfigType> publishedConfigTypes;
/*     */     
/*     */     private OutputPublishingSpec(TaskOutputHolder.OutputType outputType, AndroidArtifacts.ArtifactType artifactType, ImmutableList<AndroidArtifacts.PublishedConfigType> publishedConfigTypes)
/*     */     {
/* 359 */       this.outputType = outputType;
/* 360 */       this.artifactType = artifactType;
/* 361 */       this.publishedConfigTypes = publishedConfigTypes;
/*     */     }
/*     */     
/*     */     public TaskOutputHolder.OutputType getOutputType()
/*     */     {
/* 366 */       return outputType;
/*     */     }
/*     */     
/*     */     public AndroidArtifacts.ArtifactType getArtifactType()
/*     */     {
/* 371 */       return artifactType;
/*     */     }
/*     */     
/*     */     public Collection<AndroidArtifacts.PublishedConfigType> getPublishedConfigTypes()
/*     */     {
/* 376 */       return publishedConfigTypes;
/*     */     }
/*     */     
/*     */     public boolean equals(Object o)
/*     */     {
/* 381 */       if (this == o) {
/* 382 */         return true;
/*     */       }
/* 384 */       if ((o == null) || (getClass() != o.getClass())) {
/* 385 */         return false;
/*     */       }
/* 387 */       OutputPublishingSpec that = (OutputPublishingSpec)o;
/* 388 */       if ((outputType == outputType) && (artifactType == artifactType)) {} return 
/*     */       
/* 390 */         Objects.equals(publishedConfigTypes, publishedConfigTypes);
/*     */     }
/*     */     
/*     */     public int hashCode()
/*     */     {
/* 395 */       return Objects.hash(new Object[] { outputType, artifactType, publishedConfigTypes });
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.publishing.VariantPublishingSpec
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */