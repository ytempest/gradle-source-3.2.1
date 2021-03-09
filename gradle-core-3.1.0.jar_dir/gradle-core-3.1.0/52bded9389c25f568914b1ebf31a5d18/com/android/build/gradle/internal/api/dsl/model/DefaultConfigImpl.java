/*    */ package com.android.build.gradle.internal.api.dsl.model; import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\b\n\002\020!\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\"\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020%\n\002\020\000\n\002\b\b\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\025\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\022\n\002\020$\n\002\b\003\n\002\030\002\n\002\b\017\n\002\020\002\n\002\b\007\n\002\020\021\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020 \n\002\b\005\n\002\020\034\n\002\b\022\030\0002\0020\0012\0020\0022\0020\0032\0020\0042\0020\0052\0020\0062\0020\007B5\022\006\020\b\032\0020\t\022\006\020\n\032\0020\013\022\006\020\f\032\0020\r\022\006\020\016\032\0020\017\022\006\020\020\032\0020\021\022\006\020\022\032\0020\023¢\006\002\020\024J&\020\001\032\0030 \0012\007\020¡\001\032\0020\0262\007\020¢\001\032\0020\0262\007\020£\001\032\0020\026H\001J\024\020¤\001\032\0030 \0012\007\020¥\001\032\00207H\001J'\020¦\001\032\0030 \0012\024\020§\001\032\013\022\006\b\001\022\002070¨\001\"\00207H\001¢\006\003\020©\001J\033\020ª\001\032\0030 \0012\016\020«\001\032\t\022\004\022\0020&0¬\001H\001J\032\020%\032\0030 \0012\016\020«\001\032\t\022\004\022\0020&0¬\001H\001J\032\020-\032\0030 \0012\016\020«\001\032\t\022\004\022\0020.0¬\001H\001J\032\0201\032\0030 \0012\016\020«\001\032\t\022\004\022\002020¬\001H\001J\022\020E\032\0030 \0012\006\020E\032\0020@H\001J\022\020E\032\0030 \0012\006\020E\032\0020\026H\001J0\020­\001\032\0030 \0012\007\020®\001\032\0020\0262\024\020¯\001\032\013\022\006\b\001\022\0020\0260¨\001\"\0020\026H\001¢\006\003\020°\001J\035\020­\001\032\0030 \0012\007\020®\001\032\0020\0262\007\020±\001\032\0020\026H\001J$\020­\001\032\0030 \0012\007\020®\001\032\0020\0262\016\020¯\001\032\t\022\004\022\0020\0260²\001H\001J\032\020Z\032\0030 \0012\016\020«\001\032\t\022\004\022\0020[0¬\001H\001J\032\020^\032\0030 \0012\016\020«\001\032\t\022\004\022\0020_0¬\001H\001J\024\020¥\001\032\0030 \0012\007\020¥\001\032\00207H\001J'\020§\001\032\0030 \0012\024\020³\001\032\013\022\006\b\001\022\002070¨\001\"\00207H\001¢\006\003\020©\001J&\020´\001\032\0030 \0012\007\020¡\001\032\0020\0262\007\020¢\001\032\0020\0262\007\020£\001\032\0020\026H\001J\n\020µ\001\032\0030 \001H\026J\033\020¶\001\032\0030 \0012\016\020·\001\032\t\022\004\022\002070¸\001H\001J\035\020¹\001\032\0030 \0012\020\020º\001\032\013\022\004\022\0020\026\030\0010¸\001H\001J&\020>\032\0030 \0012\024\020»\001\032\013\022\006\b\001\022\0020\0260¨\001\"\0020\026H\001¢\006\003\020¼\001J\023\020>\032\0030 \0012\007\020½\001\032\0020\026H\001J\022\020I\032\0030 \0012\006\020E\032\0020@H\001J\022\020I\032\0030 \0012\006\020E\032\0020\026H\001J\033\020¾\001\032\0030 \0012\016\020·\001\032\t\022\004\022\002070¸\001H\001J\023\020\001\032\0030 \0012\006\020~\032\0020@H\001J\023\020\001\032\0030 \0012\006\020~\032\0020\026H\001J\024\020¿\001\032\0030 \0012\007\020À\001\032\0020LH\001J\024\020Á\001\032\0030 \0012\007\020Â\001\032\0020LH\001J\033\020Ã\001\032\0030 \0012\016\020³\001\032\t\022\004\022\002070¸\001H\001J\033\020Ä\001\032\0030 \0012\016\020«\001\032\t\022\004\022\0020u0¬\001H\001J\022\020~\032\0030 \0012\006\020~\032\0020@H\001J\022\020~\032\0030 \0012\006\020~\032\0020\026H\001J\035\020Å\001\032\0030 \0012\007\020Æ\001\032\0020\0262\007\020£\001\032\0020\026H\001J!\020\001\032\0030 \0012\024\020Ç\001\032\017\022\004\022\0020\026\022\004\022\0020\0260\001H\001J\024\020È\001\032\0030 \0012\007\020¥\001\032\00207H\001J'\020É\001\032\0030 \0012\024\020§\001\032\013\022\006\b\001\022\002070¨\001\"\00207H\001¢\006\003\020©\001J\034\020\001\032\0030 \0012\017\020«\001\032\n\022\005\022\0030\0010¬\001H\001J\033\020\001\032\0030 \0012\t\020\001\032\004\030\0010LH\001¢\006\002\020PR\032\020\025\032\004\030\0010\026X\017¢\006\f\032\004\b\027\020\030\"\004\b\031\020\032R\032\020\033\032\004\030\0010\026X\017¢\006\f\032\004\b\034\020\030\"\004\b\035\020\032R\016\020\020\032\0020\021X\004¢\006\002\n\000R\036\020\036\032\b\022\004\022\0020 0\037X\017¢\006\f\032\004\b!\020\"\"\004\b#\020$R\016\020\n\032\0020\013X\004¢\006\002\n\000R\022\020%\032\0020&X\005¢\006\006\032\004\b'\020(R\016\020\016\032\0020\017X\004¢\006\002\n\000R\034\020)\032\n\022\004\022\0020\026\030\0010*8\026X\005¢\006\006\032\004\b+\020,R\022\020-\032\0020.X\005¢\006\006\032\004\b/\0200R\022\0201\032\00202X\005¢\006\006\032\004\b3\0204R$\0205\032\016\022\004\022\0020\026\022\004\022\0020706X\017¢\006\f\032\004\b8\0209\"\004\b:\020;R\036\020<\032\b\022\004\022\0020\0260\037X\017¢\006\f\032\004\b=\020\"\"\004\b>\020$R\032\020?\032\004\030\0010@X\017¢\006\f\032\004\bA\020B\"\004\bC\020DR\032\020E\032\004\030\0010FX\017¢\006\f\032\004\bG\020H\"\004\bI\020JR\032\020K\032\004\030\0010LX\017¢\006\f\032\004\bM\020N\"\004\bO\020PR\032\020Q\032\004\030\0010RX\017¢\006\f\032\004\bS\020T\"\004\bU\020VR\032\020W\032\004\030\0010RX\017¢\006\f\032\004\bX\020T\"\004\bY\020VR\022\020Z\032\0020[X\005¢\006\006\032\004\b\\\020]R\022\020^\032\0020_X\005¢\006\006\032\004\b`\020aR\016\020\f\032\0020\rX\004¢\006\002\n\000R\032\020b\032\004\030\0010LX\017¢\006\f\032\004\bc\020N\"\004\bd\020PR\032\020e\032\004\030\0010LX\017¢\006\f\032\004\bf\020N\"\004\bg\020PR\032\020h\032\004\030\0010LX\017¢\006\f\032\004\bi\020N\"\004\bj\020PR\032\020k\032\004\030\0010@X\017¢\006\f\032\004\bl\020B\"\004\bm\020DR\036\020n\032\b\022\004\022\0020\0260\037X\017¢\006\f\032\004\bo\020\"\"\004\bp\020$R\036\020q\032\b\022\004\022\0020 0\037X\017¢\006\f\032\004\br\020\"\"\004\bs\020$R\022\020t\032\0020uX\005¢\006\006\032\004\bv\020wR\032\020x\032\004\030\0010yX\017¢\006\f\032\004\bz\020{\"\004\b|\020}R\033\020~\032\004\030\0010FX\017¢\006\r\032\004\b\020H\"\005\b\001\020JR!\020\001\032\004\030\0010\0268\026@\026X\017¢\006\016\032\005\b\001\020\030\"\005\b\001\020\032R\030\020\001\032\004\030\0010L8\026X\005¢\006\007\032\005\b\001\020NR\030\020\001\032\004\030\0010L8\026X\005¢\006\007\032\005\b\001\020NR!\020\001\032\004\030\0010\0268\026@\026X\017¢\006\016\032\005\b\001\020\030\"\005\b\001\020\032R,\020\001\032\017\022\004\022\0020\026\022\004\022\0020\0260\0018\026@\026X\017¢\006\016\032\005\b\001\0209\"\005\b\001\020;R\016\020\b\032\0020\tX\004¢\006\002\n\000R\026\020\001\032\0030\001X\005¢\006\b\032\006\b\001\020\001R\035\020\001\032\004\030\0010@X\017¢\006\016\032\005\b\001\020B\"\005\b\001\020DR\035\020\001\032\004\030\0010\026X\017¢\006\016\032\005\b\001\020\030\"\005\b\001\020\032R\035\020\001\032\004\030\0010\026X\017¢\006\016\032\005\b\001\020\030\"\005\b\001\020\032R\035\020\001\032\004\030\0010LX\017¢\006\016\032\005\b\001\020N\"\005\b\001\020P¨\006Ê\001"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/DefaultConfigImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/model/DefaultConfig;", "Lcom/android/build/api/dsl/model/VariantProperties;", "Lcom/android/build/api/dsl/model/BuildTypeOrProductFlavor;", "Lcom/android/build/api/dsl/model/ProductFlavorOrVariant;", "Lcom/android/build/api/dsl/model/FallbackStrategy;", "Lcom/android/build/api/dsl/model/BaseFlavor;", "variantProperties", "Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;", "buildTypeOrProductFlavor", "Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;", "productFlavorOrVariant", "Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;", "fallbackStrategy", "Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;", "baseFlavor", "Lcom/android/build/gradle/internal/api/dsl/model/BaseFlavorImpl;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;Lcom/android/build/gradle/internal/api/dsl/model/BaseFlavorImpl;Lcom/android/builder/errors/EvalIssueReporter;)V", "applicationId", "", "getApplicationId", "()Ljava/lang/String;", "setApplicationId", "(Ljava/lang/String;)V", "applicationIdSuffix", "getApplicationIdSuffix", "setApplicationIdSuffix", "buildConfigFields", "", "Lcom/android/build/api/dsl/model/TypedValue;", "getBuildConfigFields", "()Ljava/util/List;", "setBuildConfigFields", "(Ljava/util/List;)V", "externalNativeBuildOptions", "Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "getExternalNativeBuildOptions", "()Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "generatedDensities", "", "getGeneratedDensities", "()Ljava/util/Set;", "instrumentationOptions", "Lcom/android/build/api/dsl/options/InstrumentationOptions;", "getInstrumentationOptions", "()Lcom/android/build/api/dsl/options/InstrumentationOptions;", "javaCompileOptions", "Lcom/android/build/api/dsl/options/JavaCompileOptions;", "getJavaCompileOptions", "()Lcom/android/build/api/dsl/options/JavaCompileOptions;", "manifestPlaceholders", "", "", "getManifestPlaceholders", "()Ljava/util/Map;", "setManifestPlaceholders", "(Ljava/util/Map;)V", "matchingFallbacks", "getMatchingFallbacks", "setMatchingFallbacks", "maxSdkVersion", "", "getMaxSdkVersion", "()Ljava/lang/Integer;", "setMaxSdkVersion", "(Ljava/lang/Integer;)V", "minSdkVersion", "Lcom/android/build/api/dsl/ApiVersion;", "getMinSdkVersion", "()Lcom/android/build/api/dsl/ApiVersion;", "setMinSdkVersion", "(Lcom/android/build/api/dsl/ApiVersion;)V", "multiDexEnabled", "", "getMultiDexEnabled", "()Ljava/lang/Boolean;", "setMultiDexEnabled", "(Ljava/lang/Boolean;)V", "multiDexKeepFile", "Ljava/io/File;", "getMultiDexKeepFile", "()Ljava/io/File;", "setMultiDexKeepFile", "(Ljava/io/File;)V", "multiDexKeepProguard", "getMultiDexKeepProguard", "setMultiDexKeepProguard", "ndkOptions", "Lcom/android/build/api/dsl/options/NdkOptions;", "getNdkOptions", "()Lcom/android/build/api/dsl/options/NdkOptions;", "postProcessing", "Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "getPostProcessing", "()Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "renderscriptNdkModeEnabled", "getRenderscriptNdkModeEnabled", "setRenderscriptNdkModeEnabled", "renderscriptSupportModeBlasEnabled", "getRenderscriptSupportModeBlasEnabled", "setRenderscriptSupportModeBlasEnabled", "renderscriptSupportModeEnabled", "getRenderscriptSupportModeEnabled", "setRenderscriptSupportModeEnabled", "renderscriptTargetApi", "getRenderscriptTargetApi", "setRenderscriptTargetApi", "resConfigs", "getResConfigs", "setResConfigs", "resValues", "getResValues", "setResValues", "shaders", "Lcom/android/build/api/dsl/options/ShaderOptions;", "getShaders", "()Lcom/android/build/api/dsl/options/ShaderOptions;", "signingConfig", "Lcom/android/build/api/dsl/options/SigningConfig;", "getSigningConfig", "()Lcom/android/build/api/dsl/options/SigningConfig;", "setSigningConfig", "(Lcom/android/build/api/dsl/options/SigningConfig;)V", "targetSdkVersion", "getTargetSdkVersion", "setTargetSdkVersion", "testApplicationId", "getTestApplicationId", "setTestApplicationId", "testFunctionalTest", "getTestFunctionalTest", "testHandleProfiling", "getTestHandleProfiling", "testInstrumentationRunner", "getTestInstrumentationRunner", "setTestInstrumentationRunner", "testInstrumentationRunnerArguments", "", "getTestInstrumentationRunnerArguments", "setTestInstrumentationRunnerArguments", "vectorDrawables", "Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "getVectorDrawables", "()Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "versionCode", "getVersionCode", "setVersionCode", "versionName", "getVersionName", "setVersionName", "versionNameSuffix", "getVersionNameSuffix", "setVersionNameSuffix", "wearAppUnbundled", "getWearAppUnbundled", "setWearAppUnbundled", "buildConfigField", "", "type", "name", "value", "consumerProguardFile", "proguardFile", "consumerProguardFiles", "proguardFiles", "", "([Ljava/lang/Object;)V", "externalNativeBuild", "action", "Lorg/gradle/api/Action;", "missingDimensionStrategy", "dimension", "requestedValues", "(Ljava/lang/String;[Ljava/lang/String;)V", "requestedValue", "", "files", "resValue", "seal", "setConsumerProguardFiles", "proguardFileIterable", "", "setGeneratedDensities", "densities", "fallbacks", "([Ljava/lang/String;)V", "fallback", "setProguardFiles", "setTestFunctionalTest", "functionalTest", "setTestHandleProfiling", "handleProfiling", "setTestProguardFiles", "shaderOptions", "testInstrumentationRunnerArgument", "key", "args", "testProguardFile", "testProguardFiles", "gradle-core"})
/*    */ public final class DefaultConfigImpl extends com.android.build.gradle.internal.api.dsl.sealing.SealableObject implements com.android.build.api.dsl.model.DefaultConfig, com.android.build.api.dsl.model.VariantProperties, com.android.build.api.dsl.model.BuildTypeOrProductFlavor, com.android.build.api.dsl.model.ProductFlavorOrVariant, com.android.build.api.dsl.model.FallbackStrategy, com.android.build.api.dsl.model.BaseFlavor { /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use {@link #setWearAppUnbundled(Boolean)} ")
/*    */   public void wearAppUnbundled(@org.jetbrains.annotations.Nullable Boolean wearAppUnbundled) { baseFlavor.wearAppUnbundled(wearAppUnbundled); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use {@link InstrumentationOptions#addInstrumentationRunnerArguments(Map)}\n      ")
/*    */   public void testInstrumentationRunnerArguments(@NotNull java.util.Map<String, String> args) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(args, "args");
/*    */     baseFlavor.testInstrumentationRunnerArguments(args); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use {@link InstrumentationOptions#instrumentationRunnerArgument(String, String)}\n      ")
/*    */   public void testInstrumentationRunnerArgument(@NotNull String key, @NotNull String value) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(key, "key");
/*    */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(value, "value");
/*    */     baseFlavor.testInstrumentationRunnerArgument(key, value); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use {@link InstrumentationOptions#setHandleProfiling(boolean)}\n      ")
/*    */   public void setTestHandleProfiling(boolean handleProfiling) { baseFlavor.setTestHandleProfiling(handleProfiling); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use {@link InstrumentationOptions#setFunctionalTest(boolean)}\n      ")
/*    */   public void setTestFunctionalTest(boolean functionalTest) { baseFlavor.setTestFunctionalTest(functionalTest); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use {@link VectorDrawablesOptions#setGeneratedDensities(Iterable)}\n      ")
/*    */   public void setGeneratedDensities(@org.jetbrains.annotations.Nullable Iterable<String> densities) { baseFlavor.setGeneratedDensities(densities); } public void postProcessing(@NotNull org.gradle.api.Action<com.android.build.api.dsl.options.PostProcessingFilesOptions> action) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     baseFlavor.postProcessing(action); } public void missingDimensionStrategy(@NotNull String dimension, @NotNull java.util.List<String> requestedValues) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*    */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(requestedValues, "requestedValues");
/*    */     baseFlavor.missingDimensionStrategy(dimension, requestedValues); } public void missingDimensionStrategy(@NotNull String dimension, @NotNull String requestedValue) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*    */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(requestedValue, "requestedValue");
/*    */     baseFlavor.missingDimensionStrategy(dimension, requestedValue); } public void missingDimensionStrategy(@NotNull String dimension, @NotNull String... requestedValues) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*    */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(requestedValues, "requestedValues");
/*    */     baseFlavor.missingDimensionStrategy(dimension, requestedValues); } public void setWearAppUnbundled(@org.jetbrains.annotations.Nullable Boolean <set-?>) { baseFlavor.setWearAppUnbundled(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public Boolean getWearAppUnbundled() { return baseFlavor.getWearAppUnbundled(); } /**
/*    */    * @deprecated
/*    */    */
/*    */   public void setTestInstrumentationRunnerArguments(@NotNull java.util.Map<String, String> <set-?>) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     baseFlavor.setTestInstrumentationRunnerArguments(<set-?>); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @NotNull
/*    */   public java.util.Map<String, String> getTestInstrumentationRunnerArguments() { return baseFlavor.getTestInstrumentationRunnerArguments(); } /**
/*    */    * @deprecated
/*    */    */
/*    */   public void setTestInstrumentationRunner(@org.jetbrains.annotations.Nullable String <set-?>) { baseFlavor.setTestInstrumentationRunner(<set-?>); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @org.jetbrains.annotations.Nullable
/*    */   public String getTestInstrumentationRunner() { return baseFlavor.getTestInstrumentationRunner(); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @org.jetbrains.annotations.Nullable
/*    */   public Boolean getTestHandleProfiling() { return baseFlavor.getTestHandleProfiling(); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @org.jetbrains.annotations.Nullable
/*    */   public Boolean getTestFunctionalTest() { return baseFlavor.getTestFunctionalTest(); } /**
/*    */    * @deprecated
/*    */    */
/*    */   public void setTestApplicationId(@org.jetbrains.annotations.Nullable String <set-?>) { baseFlavor.setTestApplicationId(<set-?>); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @org.jetbrains.annotations.Nullable
/*    */   public String getTestApplicationId() { return baseFlavor.getTestApplicationId(); } @NotNull
/*    */   public com.android.build.api.dsl.options.PostProcessingFilesOptions getPostProcessing() { return baseFlavor.getPostProcessing(); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @org.jetbrains.annotations.Nullable
/*    */   public java.util.Set<String> getGeneratedDensities() { return baseFlavor.getGeneratedDensities(); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use matchingFallbacks property")
/*    */   public void setMatchingFallbacks(@NotNull String fallback) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(fallback, "fallback");
/*    */     fallbackStrategy.setMatchingFallbacks(fallback); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use matchingFallbacks property")
/*    */   public void setMatchingFallbacks(@NotNull String... fallbacks) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(fallbacks, "fallbacks");
/*    */     fallbackStrategy.setMatchingFallbacks(fallbacks); } public void setMatchingFallbacks(@NotNull java.util.List<String> <set-?>) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     fallbackStrategy.setMatchingFallbacks(<set-?>); } @NotNull
/*    */   public java.util.List<String> getMatchingFallbacks() { return fallbackStrategy.getMatchingFallbacks(); } public void vectorDrawables(@NotNull org.gradle.api.Action<com.android.build.api.dsl.options.VectorDrawablesOptions> action) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     productFlavorOrVariant.vectorDrawables(action); } public void targetSdkVersion(@NotNull String targetSdkVersion) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(targetSdkVersion, "targetSdkVersion");
/*    */     productFlavorOrVariant.targetSdkVersion(targetSdkVersion); } public void targetSdkVersion(int targetSdkVersion) { productFlavorOrVariant.targetSdkVersion(targetSdkVersion); } public void setTargetSdkVersion(@NotNull String targetSdkVersion) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(targetSdkVersion, "targetSdkVersion");
/*    */     productFlavorOrVariant.setTargetSdkVersion(targetSdkVersion); } public void setTargetSdkVersion(int targetSdkVersion) { productFlavorOrVariant.setTargetSdkVersion(targetSdkVersion); } public void setMinSdkVersion(@NotNull String minSdkVersion) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minSdkVersion, "minSdkVersion");
/*    */     productFlavorOrVariant.setMinSdkVersion(minSdkVersion); } public void setMinSdkVersion(int minSdkVersion) { productFlavorOrVariant.setMinSdkVersion(minSdkVersion); } public void minSdkVersion(@NotNull String minSdkVersion) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minSdkVersion, "minSdkVersion");
/*    */     productFlavorOrVariant.minSdkVersion(minSdkVersion); } public void minSdkVersion(int minSdkVersion) { productFlavorOrVariant.minSdkVersion(minSdkVersion); } public void instrumentationOptions(@NotNull org.gradle.api.Action<com.android.build.api.dsl.options.InstrumentationOptions> action) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     productFlavorOrVariant.instrumentationOptions(action); } public void setVersionName(@org.jetbrains.annotations.Nullable String <set-?>) { productFlavorOrVariant.setVersionName(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public String getVersionName() { return productFlavorOrVariant.getVersionName(); } public void setVersionCode(@org.jetbrains.annotations.Nullable Integer <set-?>) { productFlavorOrVariant.setVersionCode(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public Integer getVersionCode() { return productFlavorOrVariant.getVersionCode(); } @NotNull
/*    */   public com.android.build.api.dsl.options.VectorDrawablesOptions getVectorDrawables() { return productFlavorOrVariant.getVectorDrawables(); } public void setTargetSdkVersion(@org.jetbrains.annotations.Nullable com.android.build.api.dsl.ApiVersion <set-?>) { productFlavorOrVariant.setTargetSdkVersion(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public com.android.build.api.dsl.ApiVersion getTargetSdkVersion() { return productFlavorOrVariant.getTargetSdkVersion(); } public void setResConfigs(@NotNull java.util.List<String> <set-?>) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     productFlavorOrVariant.setResConfigs(<set-?>); } @NotNull
/*    */   public java.util.List<String> getResConfigs() { return productFlavorOrVariant.getResConfigs(); } public void setRenderscriptTargetApi(@org.jetbrains.annotations.Nullable Integer <set-?>) { productFlavorOrVariant.setRenderscriptTargetApi(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public Integer getRenderscriptTargetApi() { return productFlavorOrVariant.getRenderscriptTargetApi(); } public void setRenderscriptSupportModeEnabled(@org.jetbrains.annotations.Nullable Boolean <set-?>) { productFlavorOrVariant.setRenderscriptSupportModeEnabled(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public Boolean getRenderscriptSupportModeEnabled() { return productFlavorOrVariant.getRenderscriptSupportModeEnabled(); } public void setRenderscriptSupportModeBlasEnabled(@org.jetbrains.annotations.Nullable Boolean <set-?>) { productFlavorOrVariant.setRenderscriptSupportModeBlasEnabled(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public Boolean getRenderscriptSupportModeBlasEnabled() { return productFlavorOrVariant.getRenderscriptSupportModeBlasEnabled(); } public void setRenderscriptNdkModeEnabled(@org.jetbrains.annotations.Nullable Boolean <set-?>) { productFlavorOrVariant.setRenderscriptNdkModeEnabled(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public Boolean getRenderscriptNdkModeEnabled() { return productFlavorOrVariant.getRenderscriptNdkModeEnabled(); } public void setMinSdkVersion(@org.jetbrains.annotations.Nullable com.android.build.api.dsl.ApiVersion <set-?>) { productFlavorOrVariant.setMinSdkVersion(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public com.android.build.api.dsl.ApiVersion getMinSdkVersion() { return productFlavorOrVariant.getMinSdkVersion(); } public void setMaxSdkVersion(@org.jetbrains.annotations.Nullable Integer <set-?>) { productFlavorOrVariant.setMaxSdkVersion(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public Integer getMaxSdkVersion() { return productFlavorOrVariant.getMaxSdkVersion(); } @NotNull
/*    */   public com.android.build.api.dsl.options.InstrumentationOptions getInstrumentationOptions() { return productFlavorOrVariant.getInstrumentationOptions(); } public void setApplicationId(@org.jetbrains.annotations.Nullable String <set-?>) { productFlavorOrVariant.setApplicationId(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public String getApplicationId() { return productFlavorOrVariant.getApplicationId(); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use postprocessingOptions")
/*    */   public void testProguardFiles(@NotNull Object... proguardFiles) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");
/*    */     buildTypeOrProductFlavor.testProguardFiles(proguardFiles); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use postprocessingOptions")
/*    */   public void testProguardFile(@NotNull Object proguardFile) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*    */     buildTypeOrProductFlavor.testProguardFile(proguardFile); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use postprocessingOptions")
/*    */   public void setTestProguardFiles(@NotNull Iterable<? extends Object> files) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(files, "files");
/*    */     buildTypeOrProductFlavor.setTestProguardFiles(files); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use postprocessingOptions")
/*    */   public void setProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");
/*    */     buildTypeOrProductFlavor.setProguardFiles(proguardFileIterable); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use postprocessingOptions")
/*    */   public void setConsumerProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");
/*    */     buildTypeOrProductFlavor.setConsumerProguardFiles(proguardFileIterable); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use postprocessingOptions")
/*    */   public void proguardFiles(@NotNull Object... files) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(files, "files");
/*    */     buildTypeOrProductFlavor.proguardFiles(files); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use postprocessingOptions")
/*    */   public void proguardFile(@NotNull Object proguardFile) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*    */     buildTypeOrProductFlavor.proguardFile(proguardFile); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use postprocessingOptions")
/*    */   public void consumerProguardFiles(@NotNull Object... proguardFiles) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");
/*    */     buildTypeOrProductFlavor.consumerProguardFiles(proguardFiles); } /**
/*    */    * @deprecated
/*    */    */
/*    */   @kotlin.Deprecated(message="Use postprocessingOptions")
/*    */   public void consumerProguardFile(@NotNull Object proguardFile) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*    */     buildTypeOrProductFlavor.consumerProguardFile(proguardFile); } public void setVersionNameSuffix(@org.jetbrains.annotations.Nullable String <set-?>) { buildTypeOrProductFlavor.setVersionNameSuffix(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public String getVersionNameSuffix() { return buildTypeOrProductFlavor.getVersionNameSuffix(); } public void setApplicationIdSuffix(@org.jetbrains.annotations.Nullable String <set-?>) { buildTypeOrProductFlavor.setApplicationIdSuffix(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public String getApplicationIdSuffix() { return buildTypeOrProductFlavor.getApplicationIdSuffix(); } public void shaderOptions(@NotNull org.gradle.api.Action<com.android.build.api.dsl.options.ShaderOptions> action) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.shaderOptions(action); } public void resValue(@NotNull String type, @NotNull String name, @NotNull String value) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(type, "type");
/*    */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(name, "name");
/*    */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(value, "value");
/*    */     variantProperties.resValue(type, name, value); } public void ndkOptions(@NotNull org.gradle.api.Action<com.android.build.api.dsl.options.NdkOptions> action) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.ndkOptions(action); } public void javaCompileOptions(@NotNull org.gradle.api.Action<com.android.build.api.dsl.options.JavaCompileOptions> action) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.javaCompileOptions(action); } public void externalNativeBuildOptions(@NotNull org.gradle.api.Action<com.android.build.api.dsl.options.ExternalNativeBuildOptions> action) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.externalNativeBuildOptions(action); } public void externalNativeBuild(@NotNull org.gradle.api.Action<com.android.build.api.dsl.options.ExternalNativeBuildOptions> action) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.externalNativeBuild(action); } public void buildConfigField(@NotNull String type, @NotNull String name, @NotNull String value) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(type, "type");
/*    */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(name, "name");
/*    */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(value, "value");
/*    */     variantProperties.buildConfigField(type, name, value); } public void setSigningConfig(@org.jetbrains.annotations.Nullable com.android.build.api.dsl.options.SigningConfig <set-?>) { variantProperties.setSigningConfig(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public com.android.build.api.dsl.options.SigningConfig getSigningConfig() { return variantProperties.getSigningConfig(); } @NotNull
/*    */   public com.android.build.api.dsl.options.ShaderOptions getShaders() { return variantProperties.getShaders(); } public void setResValues(@NotNull java.util.List<com.android.build.api.dsl.model.TypedValue> <set-?>) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantProperties.setResValues(<set-?>); } @NotNull
/*    */   public java.util.List<com.android.build.api.dsl.model.TypedValue> getResValues() { return variantProperties.getResValues(); } @NotNull
/*    */   public com.android.build.api.dsl.options.NdkOptions getNdkOptions() { return variantProperties.getNdkOptions(); } public void setMultiDexKeepProguard(@org.jetbrains.annotations.Nullable java.io.File <set-?>) { variantProperties.setMultiDexKeepProguard(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public java.io.File getMultiDexKeepProguard() { return variantProperties.getMultiDexKeepProguard(); } public void setMultiDexKeepFile(@org.jetbrains.annotations.Nullable java.io.File <set-?>) { variantProperties.setMultiDexKeepFile(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public java.io.File getMultiDexKeepFile() { return variantProperties.getMultiDexKeepFile(); } public void setMultiDexEnabled(@org.jetbrains.annotations.Nullable Boolean <set-?>) { variantProperties.setMultiDexEnabled(<set-?>); } @org.jetbrains.annotations.Nullable
/*    */   public Boolean getMultiDexEnabled() { return variantProperties.getMultiDexEnabled(); } public void setManifestPlaceholders(@NotNull java.util.Map<String, Object> <set-?>) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantProperties.setManifestPlaceholders(<set-?>); } @NotNull
/*    */   public java.util.Map<String, Object> getManifestPlaceholders() { return variantProperties.getManifestPlaceholders(); } @NotNull
/*    */   public com.android.build.api.dsl.options.JavaCompileOptions getJavaCompileOptions() { return variantProperties.getJavaCompileOptions(); } @NotNull
/*    */   public com.android.build.api.dsl.options.ExternalNativeBuildOptions getExternalNativeBuildOptions() { return variantProperties.getExternalNativeBuildOptions(); } public void setBuildConfigFields(@NotNull java.util.List<com.android.build.api.dsl.model.TypedValue> <set-?>) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantProperties.setBuildConfigFields(<set-?>); } @NotNull
/*    */   public java.util.List<com.android.build.api.dsl.model.TypedValue> getBuildConfigFields() { return variantProperties.getBuildConfigFields(); } public DefaultConfigImpl(@NotNull VariantPropertiesImpl variantProperties, @NotNull BuildTypeOrProductFlavorImpl buildTypeOrProductFlavor, @NotNull ProductFlavorOrVariantImpl productFlavorOrVariant, @NotNull FallbackStrategyImpl fallbackStrategy, @NotNull BaseFlavorImpl baseFlavor, @NotNull com.android.builder.errors.EvalIssueReporter issueReporter) { super(issueReporter);this.variantProperties = variantProperties;this.buildTypeOrProductFlavor = buildTypeOrProductFlavor;this.productFlavorOrVariant = productFlavorOrVariant;this.fallbackStrategy = fallbackStrategy;this.baseFlavor = baseFlavor;
/*    */   }
/*    */   
/*    */   private final VariantPropertiesImpl variantProperties;
/*    */   private final BuildTypeOrProductFlavorImpl buildTypeOrProductFlavor;
/*    */   private final ProductFlavorOrVariantImpl productFlavorOrVariant;
/*    */   private final FallbackStrategyImpl fallbackStrategy;
/*    */   private final BaseFlavorImpl baseFlavor;
/*    */   public void seal() {
/* 44 */     super.seal();
/*    */     
/* 46 */     variantProperties.seal();
/* 47 */     buildTypeOrProductFlavor.seal();
/* 48 */     productFlavorOrVariant.seal();
/* 49 */     fallbackStrategy.seal();
/* 50 */     baseFlavor.seal();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.DefaultConfigImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */