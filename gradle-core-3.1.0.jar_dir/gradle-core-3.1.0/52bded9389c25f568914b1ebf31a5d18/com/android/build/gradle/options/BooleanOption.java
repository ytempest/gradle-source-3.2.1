/*     */ package com.android.build.gradle.options;
/*     */ 
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ 
/*     */ public enum BooleanOption
/*     */   implements Option<Boolean>
/*     */ {
/*  25 */   ENABLE_AAPT2("android.enableAapt2", true, DeprecationReporter.DeprecationTarget.AAPT), 
/*     */   
/*  27 */   ENABLE_BUILD_CACHE("android.enableBuildCache", true), 
/*  28 */   ENABLE_PROFILE_JSON("android.enableProfileJson", false), 
/*  29 */   ENABLE_SDK_DOWNLOAD("android.builder.sdkDownload", true), 
/*  30 */   ENABLE_TEST_SHARDING("android.androidTest.shardBetweenDevices"), 
/*  31 */   ENABLE_DEX_ARCHIVE("android.useDexArchive", true), 
/*     */   
/*  33 */   ENABLE_IMPROVED_DEPENDENCY_RESOLUTION("android.enableImprovedDependenciesResolution", true), 
/*  34 */   ENABLE_INTERMEDIATE_ARTIFACTS_CACHE("android.enableIntermediateArtifactsCache", true), 
/*  35 */   ENABLE_EXTRACT_ANNOTATIONS("android.enableExtractAnnotations", true), 
/*  36 */   VERSION_CHECK_OVERRIDE_PROPERTY("android.overrideVersionCheck"), 
/*  37 */   VERSION_CHECK_OVERRIDE_PROPERTY_OLD("com.android.build.gradle.overrideVersionCheck"), 
/*  38 */   OVERRIDE_PATH_CHECK_PROPERTY("android.overridePathCheck"), 
/*  39 */   OVERRIDE_PATH_CHECK_PROPERTY_OLD("com.android.build.gradle.overridePathCheck"), 
/*  40 */   ENABLE_DESUGAR("android.enableDesugar", true), 
/*  41 */   ENABLE_INCREMENTAL_DESUGARING("android.enableIncrementalDesugaring", true), 
/*  42 */   ENABLE_GRADLE_WORKERS("android.enableGradleWorkers", false), 
/*  43 */   ENABLE_AAPT2_WORKER_ACTIONS("android.enableAapt2WorkerActions", false), 
/*  44 */   ENABLE_CORE_LAMBDA_STUBS("android.enableCoreLambdaStubs", true), 
/*     */   
/*  46 */   ENABLE_D8("android.enableD8", true, DeprecationReporter.DeprecationTarget.LEGACY_DEXER), 
/*  47 */   ENABLE_D8_DESUGARING("android.enableD8.desugaring", false), 
/*  48 */   ENABLE_D8_MAIN_DEX_LIST("android.enableD8MainDexList", true), 
/*     */   
/*  50 */   ENABLE_DEPRECATED_NDK("android.useDeprecatedNdk"), 
/*  51 */   DISABLE_RESOURCE_VALIDATION("android.disableResourceValidation"), 
/*  52 */   CONSUME_DEPENDENCIES_AS_SHARED_LIBRARIES("android.consumeDependenciesAsSharedLibraries"), 
/*     */   
/*  55 */   BUILD_ONLY_TARGET_ABI("android.buildOnlyTargetAbi", true), 
/*  56 */   KEEP_TIMESTAMPS_IN_APK("android.keepTimestampsInApk"), 
/*     */   
/*  58 */   ENABLE_NEW_DSL_AND_API("android.enableNewDsl"), 
/*     */   
/*  60 */   ENABLE_DATA_BINDING_V2("android.databinding.enableV2", false), 
/*     */   
/*  62 */   IDE_INVOKED_FROM_IDE("android.injected.invoked.from.ide"), 
/*  63 */   IDE_BUILD_MODEL_ONLY("android.injected.build.model.only"), 
/*  64 */   IDE_BUILD_MODEL_ONLY_ADVANCED("android.injected.build.model.only.advanced"), 
/*  65 */   IDE_BUILD_MODEL_FEATURE_FULL_DEPENDENCIES("android.injected.build.model.feature.full.dependencies"), 
/*     */   
/*  67 */   IDE_REFRESH_EXTERNAL_NATIVE_MODEL("android.injected.refresh.external.native.model"), 
/*  68 */   IDE_GENERATE_SOURCES_ONLY("android.injected.generateSourcesOnly"), 
/*  69 */   ENABLE_SEPARATE_APK_RESOURCES("android.enableSeparateApkRes", true), 
/*  70 */   ENABLE_EXPERIMENTAL_FEATURE_DATABINDING("android.enableExperimentalFeatureDatabinding", false), 
/*  71 */   ENABLE_SEPARATE_R_CLASS_COMPILATION("android.enableSeparateRClassCompilation");
/*     */   
/*     */   private final String propertyName;
/*     */   private final boolean defaultValue;
/*     */   private final DeprecationReporter.DeprecationTarget deprecationTarget;
/*     */   
/*     */   private BooleanOption(String propertyName)
/*     */   {
/*  79 */     this(propertyName, false);
/*     */   }
/*     */   
/*     */   private BooleanOption(String propertyName, boolean defaultValue) {
/*  83 */     this(propertyName, defaultValue, null);
/*     */   }
/*     */   
/*     */   private BooleanOption(String propertyName, boolean defaultValue, DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */   {
/*  90 */     this.propertyName = propertyName;
/*  91 */     this.defaultValue = defaultValue;
/*  92 */     this.deprecationTarget = deprecationTarget;
/*     */   }
/*     */   
/*     */   public String getPropertyName()
/*     */   {
/*  98 */     return propertyName;
/*     */   }
/*     */   
/*     */   public Boolean getDefaultValue()
/*     */   {
/* 104 */     return Boolean.valueOf(defaultValue);
/*     */   }
/*     */   
/*     */   public Boolean parse(Object value)
/*     */   {
/* 110 */     if ((value instanceof Boolean)) {
/* 111 */       return (Boolean)value;
/*     */     }
/* 113 */     if ((value instanceof CharSequence)) {
/* 114 */       return Boolean.valueOf(Boolean.parseBoolean(value.toString()));
/*     */     }
/* 116 */     if ((value instanceof Number)) {
/* 117 */       return Boolean.valueOf(((Number)value).intValue() != 0);
/*     */     }
/*     */     
/* 125 */     throw new IllegalArgumentException("Cannot parse project property " + getPropertyName() + "='" + value + "' of type '" + value.getClass() + "' as boolean.");
/*     */   }
/*     */   
/*     */   public boolean isDeprecated()
/*     */   {
/* 131 */     return deprecationTarget != null;
/*     */   }
/*     */   
/*     */   public DeprecationReporter.DeprecationTarget getDeprecationTarget()
/*     */   {
/* 137 */     return deprecationTarget;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.BooleanOption
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */