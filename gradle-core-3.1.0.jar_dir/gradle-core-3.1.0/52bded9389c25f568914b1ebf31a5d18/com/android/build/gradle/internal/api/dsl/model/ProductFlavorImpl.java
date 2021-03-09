/*    */ package com.android.build.gradle.internal.api.dsl.model;
/*    */ 
/*    */ import com.android.build.api.dsl.ApiVersion;
/*    */ import com.android.build.api.dsl.model.TypedValue;
/*    */ import com.android.build.api.dsl.options.ExternalNativeBuildOptions;
/*    */ import com.android.build.api.dsl.options.InstrumentationOptions;
/*    */ import com.android.build.api.dsl.options.JavaCompileOptions;
/*    */ import com.android.build.api.dsl.options.NdkOptions;
/*    */ import com.android.build.api.dsl.options.PostProcessingFilesOptions;
/*    */ import com.android.build.api.dsl.options.SigningConfig;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import kotlin.Deprecated;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000þ\001\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\r\n\002\020!\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\003\n\002\020\"\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020%\n\002\020\000\n\002\b\b\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\025\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\022\n\002\020$\n\002\b\003\n\002\030\002\n\002\b\017\n\002\020\002\n\002\b\006\n\002\020\021\n\002\b\003\n\002\030\002\n\002\b\007\n\002\020 \n\002\b\005\n\002\020\034\n\002\b\022\030\0002\0020\0012\0020\0022\0020\0032\0020\0042\0020\0052\0020\0062\0020\007B=\022\006\020\b\032\0020\t\022\006\020\n\032\0020\013\022\006\020\f\032\0020\r\022\006\020\016\032\0020\017\022\006\020\020\032\0020\021\022\006\020\022\032\0020\023\022\006\020\024\032\0020\025¢\006\002\020\026J%\020§\001\032\0030¨\0012\007\020©\001\032\0020\t2\007\020ª\001\032\0020\t2\006\020)\032\0020\tH\001J\024\020«\001\032\0030¨\0012\007\020¬\001\032\0020?H\001J'\020­\001\032\0030¨\0012\024\020®\001\032\013\022\006\b\001\022\0020?0¯\001\"\0020?H\001¢\006\003\020°\001J\033\020±\001\032\0030¨\0012\016\020²\001\032\t\022\004\022\0020.0³\001H\001J\032\020-\032\0030¨\0012\016\020²\001\032\t\022\004\022\0020.0³\001H\001J\t\020´\001\032\0020\tH\026J\023\020µ\001\032\0030¨\0012\007\020¶\001\032\0020\002H\026J\032\0205\032\0030¨\0012\016\020²\001\032\t\022\004\022\002060³\001H\001J\032\0209\032\0030¨\0012\016\020²\001\032\t\022\004\022\0020:0³\001H\001J\022\020M\032\0030¨\0012\006\020M\032\0020HH\001J\022\020M\032\0030¨\0012\006\020M\032\0020\tH\001J/\020·\001\032\0030¨\0012\006\020*\032\0020\t2\024\020¸\001\032\013\022\006\b\001\022\0020\t0¯\001\"\0020\tH\001¢\006\003\020¹\001J\034\020·\001\032\0030¨\0012\006\020*\032\0020\t2\007\020º\001\032\0020\tH\001J#\020·\001\032\0030¨\0012\006\020*\032\0020\t2\016\020¸\001\032\t\022\004\022\0020\t0»\001H\001J\032\020b\032\0030¨\0012\016\020²\001\032\t\022\004\022\0020c0³\001H\001J\032\020f\032\0030¨\0012\016\020²\001\032\t\022\004\022\0020g0³\001H\001J\024\020¬\001\032\0030¨\0012\007\020¬\001\032\0020?H\001J'\020®\001\032\0030¨\0012\024\020¼\001\032\013\022\006\b\001\022\0020?0¯\001\"\0020?H\001¢\006\003\020°\001J%\020½\001\032\0030¨\0012\007\020©\001\032\0020\t2\007\020ª\001\032\0020\t2\006\020)\032\0020\tH\001J\n\020¾\001\032\0030¨\001H\026J\033\020¿\001\032\0030¨\0012\016\020À\001\032\t\022\004\022\0020?0Á\001H\001J\035\020Â\001\032\0030¨\0012\020\020Ã\001\032\013\022\004\022\0020\t\030\0010Á\001H\001J&\020F\032\0030¨\0012\024\020Ä\001\032\013\022\006\b\001\022\0020\t0¯\001\"\0020\tH\001¢\006\003\020Å\001J\023\020F\032\0030¨\0012\007\020Æ\001\032\0020\tH\001J\022\020Q\032\0030¨\0012\006\020M\032\0020HH\001J\022\020Q\032\0030¨\0012\006\020M\032\0020\tH\001J\033\020Ç\001\032\0030¨\0012\016\020À\001\032\t\022\004\022\0020?0Á\001H\001J\024\020\001\032\0030¨\0012\007\020\001\032\0020HH\001J\024\020\001\032\0030¨\0012\007\020\001\032\0020\tH\001J\024\020È\001\032\0030¨\0012\007\020É\001\032\0020TH\001J\024\020Ê\001\032\0030¨\0012\007\020Ë\001\032\0020TH\001J\033\020Ì\001\032\0030¨\0012\016\020¼\001\032\t\022\004\022\0020?0Á\001H\001J\033\020Í\001\032\0030¨\0012\016\020²\001\032\t\022\004\022\0020}0³\001H\001J\024\020\001\032\0030¨\0012\007\020\001\032\0020HH\001J\024\020\001\032\0030¨\0012\007\020\001\032\0020\tH\001J\034\020Î\001\032\0030¨\0012\007\020Ï\001\032\0020\t2\006\020)\032\0020\tH\001J!\020\001\032\0030¨\0012\024\020Ð\001\032\017\022\004\022\0020\t\022\004\022\0020\t0\001H\001J\024\020Ñ\001\032\0030¨\0012\007\020¬\001\032\0020?H\001J'\020Ò\001\032\0030¨\0012\024\020®\001\032\013\022\006\b\001\022\0020?0¯\001\"\0020?H\001¢\006\003\020°\001J\034\020\001\032\0030¨\0012\017\020²\001\032\n\022\005\022\0030\0010³\001H\001J\033\020¤\001\032\0030¨\0012\t\020¤\001\032\004\030\0010TH\001¢\006\002\020XR\034\020\027\032\004\030\0010\tX\016¢\006\016\n\000\032\004\b\030\020\031\"\004\b\032\020\033R\032\020\034\032\004\030\0010\tX\017¢\006\f\032\004\b\035\020\031\"\004\b\036\020\033R\032\020\037\032\004\030\0010\tX\017¢\006\f\032\004\b \020\031\"\004\b!\020\033R\016\020\022\032\0020\023X\004¢\006\002\n\000R\036\020\"\032\b\022\004\022\0020$0#X\017¢\006\f\032\004\b%\020&\"\004\b'\020(R\016\020\f\032\0020\rX\004¢\006\002\n\000R(\020*\032\004\030\0010\t2\b\020)\032\004\030\0010\t8V@VX\016¢\006\f\032\004\b+\020\031\"\004\b,\020\033R\022\020-\032\0020.X\005¢\006\006\032\004\b/\0200R\016\020\020\032\0020\021X\004¢\006\002\n\000R\034\0201\032\n\022\004\022\0020\t\030\001028\026X\005¢\006\006\032\004\b3\0204R\022\0205\032\00206X\005¢\006\006\032\004\b7\0208R\022\0209\032\0020:X\005¢\006\006\032\004\b;\020<R$\020=\032\016\022\004\022\0020\t\022\004\022\0020?0>X\017¢\006\f\032\004\b@\020A\"\004\bB\020CR\036\020D\032\b\022\004\022\0020\t0#X\017¢\006\f\032\004\bE\020&\"\004\bF\020(R\032\020G\032\004\030\0010HX\017¢\006\f\032\004\bI\020J\"\004\bK\020LR\032\020M\032\004\030\0010NX\017¢\006\f\032\004\bO\020P\"\004\bQ\020RR\032\020S\032\004\030\0010TX\017¢\006\f\032\004\bU\020V\"\004\bW\020XR\032\020Y\032\004\030\0010ZX\017¢\006\f\032\004\b[\020\\\"\004\b]\020^R\032\020_\032\004\030\0010ZX\017¢\006\f\032\004\b`\020\\\"\004\ba\020^R\016\020\b\032\0020\tX\004¢\006\002\n\000R\022\020b\032\0020cX\005¢\006\006\032\004\bd\020eR\022\020f\032\0020gX\005¢\006\006\032\004\bh\020iR\016\020\016\032\0020\017X\004¢\006\002\n\000R\032\020j\032\004\030\0010TX\017¢\006\f\032\004\bk\020V\"\004\bl\020XR\032\020m\032\004\030\0010TX\017¢\006\f\032\004\bn\020V\"\004\bo\020XR\032\020p\032\004\030\0010TX\017¢\006\f\032\004\bq\020V\"\004\br\020XR\032\020s\032\004\030\0010HX\017¢\006\f\032\004\bt\020J\"\004\bu\020LR\036\020v\032\b\022\004\022\0020\t0#X\017¢\006\f\032\004\bw\020&\"\004\bx\020(R\036\020y\032\b\022\004\022\0020$0#X\017¢\006\f\032\004\bz\020&\"\004\b{\020(R\022\020|\032\0020}X\005¢\006\006\032\004\b~\020R \020\001\032\005\030\0010\001X\017¢\006\020\032\006\b\001\020\001\"\006\b\001\020\001R\035\020\001\032\004\030\0010NX\017¢\006\016\032\005\b\001\020P\"\005\b\001\020RR!\020\001\032\004\030\0010\t8\026@\026X\017¢\006\016\032\005\b\001\020\031\"\005\b\001\020\033R\030\020\001\032\004\030\0010T8\026X\005¢\006\007\032\005\b\001\020VR\030\020\001\032\004\030\0010T8\026X\005¢\006\007\032\005\b\001\020VR!\020\001\032\004\030\0010\t8\026@\026X\017¢\006\016\032\005\b\001\020\031\"\005\b\001\020\033R,\020\001\032\017\022\004\022\0020\t\022\004\022\0020\t0\0018\026@\026X\017¢\006\016\032\005\b\001\020A\"\005\b\001\020CR\016\020\n\032\0020\013X\004¢\006\002\n\000R\026\020\001\032\0030\001X\005¢\006\b\032\006\b\001\020\001R\035\020\001\032\004\030\0010HX\017¢\006\016\032\005\b\001\020J\"\005\b\001\020LR\035\020\001\032\004\030\0010\tX\017¢\006\016\032\005\b\001\020\031\"\005\b \001\020\033R\035\020¡\001\032\004\030\0010\tX\017¢\006\016\032\005\b¢\001\020\031\"\005\b£\001\020\033R\035\020¤\001\032\004\030\0010TX\017¢\006\016\032\005\b¥\001\020V\"\005\b¦\001\020X¨\006Ó\001"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/model/ProductFlavor;", "Lcom/android/build/api/dsl/model/VariantProperties;", "Lcom/android/build/api/dsl/model/BuildTypeOrProductFlavor;", "Lcom/android/build/api/dsl/model/ProductFlavorOrVariant;", "Lcom/android/build/api/dsl/model/FallbackStrategy;", "Lcom/android/build/api/dsl/model/BaseFlavor;", "named", "", "variantProperties", "Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;", "buildTypeOrProductFlavor", "Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;", "productFlavorOrVariant", "Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;", "fallbackStrategy", "Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;", "baseFlavor", "Lcom/android/build/gradle/internal/api/dsl/model/BaseFlavorImpl;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/lang/String;Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;Lcom/android/build/gradle/internal/api/dsl/model/BaseFlavorImpl;Lcom/android/builder/errors/EvalIssueReporter;)V", "_dimension", "get_dimension$gradle_core", "()Ljava/lang/String;", "set_dimension$gradle_core", "(Ljava/lang/String;)V", "applicationId", "getApplicationId", "setApplicationId", "applicationIdSuffix", "getApplicationIdSuffix", "setApplicationIdSuffix", "buildConfigFields", "", "Lcom/android/build/api/dsl/model/TypedValue;", "getBuildConfigFields", "()Ljava/util/List;", "setBuildConfigFields", "(Ljava/util/List;)V", "value", "dimension", "getDimension", "setDimension", "externalNativeBuildOptions", "Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "getExternalNativeBuildOptions", "()Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "generatedDensities", "", "getGeneratedDensities", "()Ljava/util/Set;", "instrumentationOptions", "Lcom/android/build/api/dsl/options/InstrumentationOptions;", "getInstrumentationOptions", "()Lcom/android/build/api/dsl/options/InstrumentationOptions;", "javaCompileOptions", "Lcom/android/build/api/dsl/options/JavaCompileOptions;", "getJavaCompileOptions", "()Lcom/android/build/api/dsl/options/JavaCompileOptions;", "manifestPlaceholders", "", "", "getManifestPlaceholders", "()Ljava/util/Map;", "setManifestPlaceholders", "(Ljava/util/Map;)V", "matchingFallbacks", "getMatchingFallbacks", "setMatchingFallbacks", "maxSdkVersion", "", "getMaxSdkVersion", "()Ljava/lang/Integer;", "setMaxSdkVersion", "(Ljava/lang/Integer;)V", "minSdkVersion", "Lcom/android/build/api/dsl/ApiVersion;", "getMinSdkVersion", "()Lcom/android/build/api/dsl/ApiVersion;", "setMinSdkVersion", "(Lcom/android/build/api/dsl/ApiVersion;)V", "multiDexEnabled", "", "getMultiDexEnabled", "()Ljava/lang/Boolean;", "setMultiDexEnabled", "(Ljava/lang/Boolean;)V", "multiDexKeepFile", "Ljava/io/File;", "getMultiDexKeepFile", "()Ljava/io/File;", "setMultiDexKeepFile", "(Ljava/io/File;)V", "multiDexKeepProguard", "getMultiDexKeepProguard", "setMultiDexKeepProguard", "ndkOptions", "Lcom/android/build/api/dsl/options/NdkOptions;", "getNdkOptions", "()Lcom/android/build/api/dsl/options/NdkOptions;", "postProcessing", "Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "getPostProcessing", "()Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "renderscriptNdkModeEnabled", "getRenderscriptNdkModeEnabled", "setRenderscriptNdkModeEnabled", "renderscriptSupportModeBlasEnabled", "getRenderscriptSupportModeBlasEnabled", "setRenderscriptSupportModeBlasEnabled", "renderscriptSupportModeEnabled", "getRenderscriptSupportModeEnabled", "setRenderscriptSupportModeEnabled", "renderscriptTargetApi", "getRenderscriptTargetApi", "setRenderscriptTargetApi", "resConfigs", "getResConfigs", "setResConfigs", "resValues", "getResValues", "setResValues", "shaders", "Lcom/android/build/api/dsl/options/ShaderOptions;", "getShaders", "()Lcom/android/build/api/dsl/options/ShaderOptions;", "signingConfig", "Lcom/android/build/api/dsl/options/SigningConfig;", "getSigningConfig", "()Lcom/android/build/api/dsl/options/SigningConfig;", "setSigningConfig", "(Lcom/android/build/api/dsl/options/SigningConfig;)V", "targetSdkVersion", "getTargetSdkVersion", "setTargetSdkVersion", "testApplicationId", "getTestApplicationId", "setTestApplicationId", "testFunctionalTest", "getTestFunctionalTest", "testHandleProfiling", "getTestHandleProfiling", "testInstrumentationRunner", "getTestInstrumentationRunner", "setTestInstrumentationRunner", "testInstrumentationRunnerArguments", "", "getTestInstrumentationRunnerArguments", "setTestInstrumentationRunnerArguments", "vectorDrawables", "Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "getVectorDrawables", "()Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "versionCode", "getVersionCode", "setVersionCode", "versionName", "getVersionName", "setVersionName", "versionNameSuffix", "getVersionNameSuffix", "setVersionNameSuffix", "wearAppUnbundled", "getWearAppUnbundled", "setWearAppUnbundled", "buildConfigField", "", "type", "name", "consumerProguardFile", "proguardFile", "consumerProguardFiles", "proguardFiles", "", "([Ljava/lang/Object;)V", "externalNativeBuild", "action", "Lorg/gradle/api/Action;", "getName", "initWith", "that", "missingDimensionStrategy", "requestedValues", "(Ljava/lang/String;[Ljava/lang/String;)V", "requestedValue", "", "files", "resValue", "seal", "setConsumerProguardFiles", "proguardFileIterable", "", "setGeneratedDensities", "densities", "fallbacks", "([Ljava/lang/String;)V", "fallback", "setProguardFiles", "setTestFunctionalTest", "functionalTest", "setTestHandleProfiling", "handleProfiling", "setTestProguardFiles", "shaderOptions", "testInstrumentationRunnerArgument", "key", "args", "testProguardFile", "testProguardFiles", "gradle-core"})
/*    */ public final class ProductFlavorImpl extends SealableObject implements com.android.build.api.dsl.model.ProductFlavor, com.android.build.api.dsl.model.VariantProperties, com.android.build.api.dsl.model.BuildTypeOrProductFlavor, com.android.build.api.dsl.model.ProductFlavorOrVariant, com.android.build.api.dsl.model.FallbackStrategy, com.android.build.api.dsl.model.BaseFlavor
/*    */ {
/*    */   @Nullable
/*    */   private String _dimension;
/*    */   private final String named;
/*    */   private final VariantPropertiesImpl variantProperties;
/*    */   private final BuildTypeOrProductFlavorImpl buildTypeOrProductFlavor;
/*    */   private final ProductFlavorOrVariantImpl productFlavorOrVariant;
/*    */   private final FallbackStrategyImpl fallbackStrategy;
/*    */   private final BaseFlavorImpl baseFlavor;
/*    */   
/*    */   public ProductFlavorImpl(@NotNull String named, @NotNull VariantPropertiesImpl variantProperties, @NotNull BuildTypeOrProductFlavorImpl buildTypeOrProductFlavor, @NotNull ProductFlavorOrVariantImpl productFlavorOrVariant, @NotNull FallbackStrategyImpl fallbackStrategy, @NotNull BaseFlavorImpl baseFlavor, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 36 */     super(issueReporter);this.named = named;this.variantProperties = variantProperties;this.buildTypeOrProductFlavor = buildTypeOrProductFlavor;this.productFlavorOrVariant = productFlavorOrVariant;this.fallbackStrategy = fallbackStrategy;this.baseFlavor = baseFlavor;
/*    */   }
/*    */   
/*    */   @NotNull
/* 44 */   public String getName() { return named; }
/*    */   @Nullable
/* 46 */   public final String get_dimension$gradle_core() { return _dimension; } public final void set_dimension$gradle_core(@Nullable String <set-?>) { _dimension = <set-?>; }
/*    */   
/*    */   @Nullable
/* 49 */   public String getDimension() { return _dimension; }
/*    */   
/* 51 */   public void setDimension(@Nullable String value) { if (checkSeal()) {
/* 52 */       _dimension = value;
/*    */     }
/*    */   }
/*    */   
/*    */   public void seal()
/*    */   {
/* 70 */     super.seal();
/*    */     
/* 72 */     variantProperties.seal();
/* 73 */     buildTypeOrProductFlavor.seal();
/* 74 */     productFlavorOrVariant.seal();
/* 75 */     fallbackStrategy.seal();
/* 76 */     baseFlavor.seal();
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public void initWith(@NotNull com.android.build.api.dsl.model.ProductFlavor that)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 47
/*    */     //   3: invokestatic 53	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_1
/*    */     //   7: dup
/*    */     //   8: instanceof 2
/*    */     //   11: ifne +5 -> 16
/*    */     //   14: pop
/*    */     //   15: aconst_null
/*    */     //   16: checkcast 2	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl
/*    */     //   19: dup
/*    */     //   20: ifnull +6 -> 26
/*    */     //   23: goto +17 -> 40
/*    */     //   26: pop
/*    */     //   27: new 55	java/lang/IllegalArgumentException
/*    */     //   30: dup
/*    */     //   31: ldc 57
/*    */     //   33: invokespecial 60	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
/*    */     //   36: checkcast 62	java/lang/Throwable
/*    */     //   39: athrow
/*    */     //   40: astore_2
/*    */     //   41: aload_0
/*    */     //   42: invokevirtual 39	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl:checkSeal	()Z
/*    */     //   45: ifeq +58 -> 103
/*    */     //   48: aload_0
/*    */     //   49: getfield 66	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl:variantProperties	Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;
/*    */     //   52: aload_2
/*    */     //   53: getfield 66	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl:variantProperties	Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;
/*    */     //   56: invokevirtual 71	com/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl:initWith	(Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;)V
/*    */     //   59: aload_0
/*    */     //   60: getfield 75	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl:buildTypeOrProductFlavor	Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;
/*    */     //   63: aload_2
/*    */     //   64: getfield 75	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl:buildTypeOrProductFlavor	Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;
/*    */     //   67: invokevirtual 80	com/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl:initWith	(Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;)V
/*    */     //   70: aload_0
/*    */     //   71: getfield 84	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl:productFlavorOrVariant	Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;
/*    */     //   74: aload_2
/*    */     //   75: getfield 84	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl:productFlavorOrVariant	Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;
/*    */     //   78: invokevirtual 90	com/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl:initWith$gradle_core	(Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;)V
/*    */     //   81: aload_0
/*    */     //   82: getfield 94	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl:fallbackStrategy	Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;
/*    */     //   85: aload_2
/*    */     //   86: getfield 94	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl:fallbackStrategy	Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;
/*    */     //   89: invokevirtual 99	com/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl:initWith$gradle_core	(Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;)V
/*    */     //   92: aload_0
/*    */     //   93: getfield 103	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl:baseFlavor	Lcom/android/build/gradle/internal/api/dsl/model/BaseFlavorImpl;
/*    */     //   96: aload_2
/*    */     //   97: getfield 103	com/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl:baseFlavor	Lcom/android/build/gradle/internal/api/dsl/model/BaseFlavorImpl;
/*    */     //   100: invokevirtual 108	com/android/build/gradle/internal/api/dsl/model/BaseFlavorImpl:initWith	(Lcom/android/build/gradle/internal/api/dsl/model/BaseFlavorImpl;)V
/*    */     //   103: return
/*    */     // Line number table:
/*    */     //   Java source line #57	-> byte code offset #6
/*    */     //   Java source line #58	-> byte code offset #27
/*    */     //   Java source line #57	-> byte code offset #40
/*    */     //   Java source line #60	-> byte code offset #41
/*    */     //   Java source line #61	-> byte code offset #48
/*    */     //   Java source line #62	-> byte code offset #59
/*    */     //   Java source line #63	-> byte code offset #70
/*    */     //   Java source line #64	-> byte code offset #81
/*    */     //   Java source line #65	-> byte code offset #92
/*    */     //   Java source line #67	-> byte code offset #103
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	104	0	this	ProductFlavorImpl
/*    */     //   0	104	1	that	com.android.build.api.dsl.model.ProductFlavor
/*    */     //   41	63	2	productFlavor	ProductFlavorImpl
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<TypedValue> getBuildConfigFields()
/*    */   {
/*    */     return variantProperties.getBuildConfigFields();
/*    */   }
/*    */   
/*    */   public void setBuildConfigFields(@NotNull List<TypedValue> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantProperties.setBuildConfigFields(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ExternalNativeBuildOptions getExternalNativeBuildOptions()
/*    */   {
/*    */     return variantProperties.getExternalNativeBuildOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public JavaCompileOptions getJavaCompileOptions()
/*    */   {
/*    */     return variantProperties.getJavaCompileOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public Map<String, Object> getManifestPlaceholders()
/*    */   {
/*    */     return variantProperties.getManifestPlaceholders();
/*    */   }
/*    */   
/*    */   public void setManifestPlaceholders(@NotNull Map<String, Object> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantProperties.setManifestPlaceholders(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Boolean getMultiDexEnabled()
/*    */   {
/*    */     return variantProperties.getMultiDexEnabled();
/*    */   }
/*    */   
/*    */   public void setMultiDexEnabled(@Nullable Boolean <set-?>)
/*    */   {
/*    */     variantProperties.setMultiDexEnabled(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public File getMultiDexKeepFile()
/*    */   {
/*    */     return variantProperties.getMultiDexKeepFile();
/*    */   }
/*    */   
/*    */   public void setMultiDexKeepFile(@Nullable File <set-?>)
/*    */   {
/*    */     variantProperties.setMultiDexKeepFile(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public File getMultiDexKeepProguard()
/*    */   {
/*    */     return variantProperties.getMultiDexKeepProguard();
/*    */   }
/*    */   
/*    */   public void setMultiDexKeepProguard(@Nullable File <set-?>)
/*    */   {
/*    */     variantProperties.setMultiDexKeepProguard(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public NdkOptions getNdkOptions()
/*    */   {
/*    */     return variantProperties.getNdkOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<TypedValue> getResValues()
/*    */   {
/*    */     return variantProperties.getResValues();
/*    */   }
/*    */   
/*    */   public void setResValues(@NotNull List<TypedValue> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantProperties.setResValues(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.ShaderOptions getShaders()
/*    */   {
/*    */     return variantProperties.getShaders();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public SigningConfig getSigningConfig()
/*    */   {
/*    */     return variantProperties.getSigningConfig();
/*    */   }
/*    */   
/*    */   public void setSigningConfig(@Nullable SigningConfig <set-?>)
/*    */   {
/*    */     variantProperties.setSigningConfig(<set-?>);
/*    */   }
/*    */   
/*    */   public void buildConfigField(@NotNull String type, @NotNull String name, @NotNull String value)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(type, "type");
/*    */     Intrinsics.checkParameterIsNotNull(name, "name");
/*    */     Intrinsics.checkParameterIsNotNull(value, "value");
/*    */     variantProperties.buildConfigField(type, name, value);
/*    */   }
/*    */   
/*    */   public void externalNativeBuild(@NotNull Action<ExternalNativeBuildOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.externalNativeBuild(action);
/*    */   }
/*    */   
/*    */   public void externalNativeBuildOptions(@NotNull Action<ExternalNativeBuildOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.externalNativeBuildOptions(action);
/*    */   }
/*    */   
/*    */   public void javaCompileOptions(@NotNull Action<JavaCompileOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.javaCompileOptions(action);
/*    */   }
/*    */   
/*    */   public void ndkOptions(@NotNull Action<NdkOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.ndkOptions(action);
/*    */   }
/*    */   
/*    */   public void resValue(@NotNull String type, @NotNull String name, @NotNull String value)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(type, "type");
/*    */     Intrinsics.checkParameterIsNotNull(name, "name");
/*    */     Intrinsics.checkParameterIsNotNull(value, "value");
/*    */     variantProperties.resValue(type, name, value);
/*    */   }
/*    */   
/*    */   public void shaderOptions(@NotNull Action<com.android.build.api.dsl.options.ShaderOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.shaderOptions(action);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public String getApplicationIdSuffix()
/*    */   {
/*    */     return buildTypeOrProductFlavor.getApplicationIdSuffix();
/*    */   }
/*    */   
/*    */   public void setApplicationIdSuffix(@Nullable String <set-?>)
/*    */   {
/*    */     buildTypeOrProductFlavor.setApplicationIdSuffix(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public String getVersionNameSuffix()
/*    */   {
/*    */     return buildTypeOrProductFlavor.getVersionNameSuffix();
/*    */   }
/*    */   
/*    */   public void setVersionNameSuffix(@Nullable String <set-?>)
/*    */   {
/*    */     buildTypeOrProductFlavor.setVersionNameSuffix(<set-?>);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void consumerProguardFile(@NotNull Object proguardFile)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*    */     buildTypeOrProductFlavor.consumerProguardFile(proguardFile);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void consumerProguardFiles(@NotNull Object... proguardFiles)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");
/*    */     buildTypeOrProductFlavor.consumerProguardFiles(proguardFiles);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void proguardFile(@NotNull Object proguardFile)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*    */     buildTypeOrProductFlavor.proguardFile(proguardFile);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void proguardFiles(@NotNull Object... files)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(files, "files");
/*    */     buildTypeOrProductFlavor.proguardFiles(files);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void setConsumerProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");
/*    */     buildTypeOrProductFlavor.setConsumerProguardFiles(proguardFileIterable);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void setProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");
/*    */     buildTypeOrProductFlavor.setProguardFiles(proguardFileIterable);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void setTestProguardFiles(@NotNull Iterable<? extends Object> files)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(files, "files");
/*    */     buildTypeOrProductFlavor.setTestProguardFiles(files);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void testProguardFile(@NotNull Object proguardFile)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*    */     buildTypeOrProductFlavor.testProguardFile(proguardFile);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void testProguardFiles(@NotNull Object... proguardFiles)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");
/*    */     buildTypeOrProductFlavor.testProguardFiles(proguardFiles);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public String getApplicationId()
/*    */   {
/*    */     return productFlavorOrVariant.getApplicationId();
/*    */   }
/*    */   
/*    */   public void setApplicationId(@Nullable String <set-?>)
/*    */   {
/*    */     productFlavorOrVariant.setApplicationId(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public InstrumentationOptions getInstrumentationOptions()
/*    */   {
/*    */     return productFlavorOrVariant.getInstrumentationOptions();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Integer getMaxSdkVersion()
/*    */   {
/*    */     return productFlavorOrVariant.getMaxSdkVersion();
/*    */   }
/*    */   
/*    */   public void setMaxSdkVersion(@Nullable Integer <set-?>)
/*    */   {
/*    */     productFlavorOrVariant.setMaxSdkVersion(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public ApiVersion getMinSdkVersion()
/*    */   {
/*    */     return productFlavorOrVariant.getMinSdkVersion();
/*    */   }
/*    */   
/*    */   public void setMinSdkVersion(@Nullable ApiVersion <set-?>)
/*    */   {
/*    */     productFlavorOrVariant.setMinSdkVersion(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Boolean getRenderscriptNdkModeEnabled()
/*    */   {
/*    */     return productFlavorOrVariant.getRenderscriptNdkModeEnabled();
/*    */   }
/*    */   
/*    */   public void setRenderscriptNdkModeEnabled(@Nullable Boolean <set-?>)
/*    */   {
/*    */     productFlavorOrVariant.setRenderscriptNdkModeEnabled(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Boolean getRenderscriptSupportModeBlasEnabled()
/*    */   {
/*    */     return productFlavorOrVariant.getRenderscriptSupportModeBlasEnabled();
/*    */   }
/*    */   
/*    */   public void setRenderscriptSupportModeBlasEnabled(@Nullable Boolean <set-?>)
/*    */   {
/*    */     productFlavorOrVariant.setRenderscriptSupportModeBlasEnabled(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Boolean getRenderscriptSupportModeEnabled()
/*    */   {
/*    */     return productFlavorOrVariant.getRenderscriptSupportModeEnabled();
/*    */   }
/*    */   
/*    */   public void setRenderscriptSupportModeEnabled(@Nullable Boolean <set-?>)
/*    */   {
/*    */     productFlavorOrVariant.setRenderscriptSupportModeEnabled(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Integer getRenderscriptTargetApi()
/*    */   {
/*    */     return productFlavorOrVariant.getRenderscriptTargetApi();
/*    */   }
/*    */   
/*    */   public void setRenderscriptTargetApi(@Nullable Integer <set-?>)
/*    */   {
/*    */     productFlavorOrVariant.setRenderscriptTargetApi(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<String> getResConfigs()
/*    */   {
/*    */     return productFlavorOrVariant.getResConfigs();
/*    */   }
/*    */   
/*    */   public void setResConfigs(@NotNull List<String> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     productFlavorOrVariant.setResConfigs(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public ApiVersion getTargetSdkVersion()
/*    */   {
/*    */     return productFlavorOrVariant.getTargetSdkVersion();
/*    */   }
/*    */   
/*    */   public void setTargetSdkVersion(@Nullable ApiVersion <set-?>)
/*    */   {
/*    */     productFlavorOrVariant.setTargetSdkVersion(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.VectorDrawablesOptions getVectorDrawables()
/*    */   {
/*    */     return productFlavorOrVariant.getVectorDrawables();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Integer getVersionCode()
/*    */   {
/*    */     return productFlavorOrVariant.getVersionCode();
/*    */   }
/*    */   
/*    */   public void setVersionCode(@Nullable Integer <set-?>)
/*    */   {
/*    */     productFlavorOrVariant.setVersionCode(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public String getVersionName()
/*    */   {
/*    */     return productFlavorOrVariant.getVersionName();
/*    */   }
/*    */   
/*    */   public void setVersionName(@Nullable String <set-?>)
/*    */   {
/*    */     productFlavorOrVariant.setVersionName(<set-?>);
/*    */   }
/*    */   
/*    */   public void instrumentationOptions(@NotNull Action<InstrumentationOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     productFlavorOrVariant.instrumentationOptions(action);
/*    */   }
/*    */   
/*    */   public void minSdkVersion(int minSdkVersion)
/*    */   {
/*    */     productFlavorOrVariant.minSdkVersion(minSdkVersion);
/*    */   }
/*    */   
/*    */   public void minSdkVersion(@NotNull String minSdkVersion)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(minSdkVersion, "minSdkVersion");
/*    */     productFlavorOrVariant.minSdkVersion(minSdkVersion);
/*    */   }
/*    */   
/*    */   public void setMinSdkVersion(int minSdkVersion)
/*    */   {
/*    */     productFlavorOrVariant.setMinSdkVersion(minSdkVersion);
/*    */   }
/*    */   
/*    */   public void setMinSdkVersion(@NotNull String minSdkVersion)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(minSdkVersion, "minSdkVersion");
/*    */     productFlavorOrVariant.setMinSdkVersion(minSdkVersion);
/*    */   }
/*    */   
/*    */   public void setTargetSdkVersion(int targetSdkVersion)
/*    */   {
/*    */     productFlavorOrVariant.setTargetSdkVersion(targetSdkVersion);
/*    */   }
/*    */   
/*    */   public void setTargetSdkVersion(@NotNull String targetSdkVersion)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(targetSdkVersion, "targetSdkVersion");
/*    */     productFlavorOrVariant.setTargetSdkVersion(targetSdkVersion);
/*    */   }
/*    */   
/*    */   public void targetSdkVersion(int targetSdkVersion)
/*    */   {
/*    */     productFlavorOrVariant.targetSdkVersion(targetSdkVersion);
/*    */   }
/*    */   
/*    */   public void targetSdkVersion(@NotNull String targetSdkVersion)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(targetSdkVersion, "targetSdkVersion");
/*    */     productFlavorOrVariant.targetSdkVersion(targetSdkVersion);
/*    */   }
/*    */   
/*    */   public void vectorDrawables(@NotNull Action<com.android.build.api.dsl.options.VectorDrawablesOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     productFlavorOrVariant.vectorDrawables(action);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<String> getMatchingFallbacks()
/*    */   {
/*    */     return fallbackStrategy.getMatchingFallbacks();
/*    */   }
/*    */   
/*    */   public void setMatchingFallbacks(@NotNull List<String> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     fallbackStrategy.setMatchingFallbacks(<set-?>);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use matchingFallbacks property")
/*    */   public void setMatchingFallbacks(@NotNull String... fallbacks)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(fallbacks, "fallbacks");
/*    */     fallbackStrategy.setMatchingFallbacks(fallbacks);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use matchingFallbacks property")
/*    */   public void setMatchingFallbacks(@NotNull String fallback)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(fallback, "fallback");
/*    */     fallbackStrategy.setMatchingFallbacks(fallback);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Nullable
/*    */   public java.util.Set<String> getGeneratedDensities()
/*    */   {
/*    */     return baseFlavor.getGeneratedDensities();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public PostProcessingFilesOptions getPostProcessing()
/*    */   {
/*    */     return baseFlavor.getPostProcessing();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Nullable
/*    */   public String getTestApplicationId()
/*    */   {
/*    */     return baseFlavor.getTestApplicationId();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   public void setTestApplicationId(@Nullable String <set-?>)
/*    */   {
/*    */     baseFlavor.setTestApplicationId(<set-?>);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Nullable
/*    */   public Boolean getTestFunctionalTest()
/*    */   {
/*    */     return baseFlavor.getTestFunctionalTest();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Nullable
/*    */   public Boolean getTestHandleProfiling()
/*    */   {
/*    */     return baseFlavor.getTestHandleProfiling();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Nullable
/*    */   public String getTestInstrumentationRunner()
/*    */   {
/*    */     return baseFlavor.getTestInstrumentationRunner();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   public void setTestInstrumentationRunner(@Nullable String <set-?>)
/*    */   {
/*    */     baseFlavor.setTestInstrumentationRunner(<set-?>);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @NotNull
/*    */   public Map<String, String> getTestInstrumentationRunnerArguments()
/*    */   {
/*    */     return baseFlavor.getTestInstrumentationRunnerArguments();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   public void setTestInstrumentationRunnerArguments(@NotNull Map<String, String> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     baseFlavor.setTestInstrumentationRunnerArguments(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Boolean getWearAppUnbundled()
/*    */   {
/*    */     return baseFlavor.getWearAppUnbundled();
/*    */   }
/*    */   
/*    */   public void setWearAppUnbundled(@Nullable Boolean <set-?>)
/*    */   {
/*    */     baseFlavor.setWearAppUnbundled(<set-?>);
/*    */   }
/*    */   
/*    */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull String... requestedValues)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*    */     Intrinsics.checkParameterIsNotNull(requestedValues, "requestedValues");
/*    */     baseFlavor.missingDimensionStrategy(dimension, requestedValues);
/*    */   }
/*    */   
/*    */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull String requestedValue)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*    */     Intrinsics.checkParameterIsNotNull(requestedValue, "requestedValue");
/*    */     baseFlavor.missingDimensionStrategy(dimension, requestedValue);
/*    */   }
/*    */   
/*    */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull List<String> requestedValues)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*    */     Intrinsics.checkParameterIsNotNull(requestedValues, "requestedValues");
/*    */     baseFlavor.missingDimensionStrategy(dimension, requestedValues);
/*    */   }
/*    */   
/*    */   public void postProcessing(@NotNull Action<PostProcessingFilesOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     baseFlavor.postProcessing(action);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use {@link VectorDrawablesOptions#setGeneratedDensities(Iterable)}\n      ")
/*    */   public void setGeneratedDensities(@Nullable Iterable<String> densities)
/*    */   {
/*    */     baseFlavor.setGeneratedDensities(densities);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use {@link InstrumentationOptions#setFunctionalTest(boolean)}\n      ")
/*    */   public void setTestFunctionalTest(boolean functionalTest)
/*    */   {
/*    */     baseFlavor.setTestFunctionalTest(functionalTest);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use {@link InstrumentationOptions#setHandleProfiling(boolean)}\n      ")
/*    */   public void setTestHandleProfiling(boolean handleProfiling)
/*    */   {
/*    */     baseFlavor.setTestHandleProfiling(handleProfiling);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use {@link InstrumentationOptions#instrumentationRunnerArgument(String, String)}\n      ")
/*    */   public void testInstrumentationRunnerArgument(@NotNull String key, @NotNull String value)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(key, "key");
/*    */     Intrinsics.checkParameterIsNotNull(value, "value");
/*    */     baseFlavor.testInstrumentationRunnerArgument(key, value);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use {@link InstrumentationOptions#addInstrumentationRunnerArguments(Map)}\n      ")
/*    */   public void testInstrumentationRunnerArguments(@NotNull Map<String, String> args)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(args, "args");
/*    */     baseFlavor.testInstrumentationRunnerArguments(args);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use {@link #setWearAppUnbundled(Boolean)} ")
/*    */   public void wearAppUnbundled(@Nullable Boolean wearAppUnbundled)
/*    */   {
/*    */     baseFlavor.wearAppUnbundled(wearAppUnbundled);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.ProductFlavorImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */