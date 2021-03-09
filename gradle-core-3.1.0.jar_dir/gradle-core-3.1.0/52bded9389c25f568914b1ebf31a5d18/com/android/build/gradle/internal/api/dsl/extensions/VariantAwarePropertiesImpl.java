/*     */ package com.android.build.gradle.internal.api.dsl.extensions;
/*     */ 
/*     */ import com.android.build.api.dsl.ApiVersion;
/*     */ import com.android.build.api.dsl.model.DefaultConfig;
/*     */ import com.android.build.api.dsl.model.TypedValue;
/*     */ import com.android.build.api.dsl.options.ExternalNativeBuildOptions;
/*     */ import com.android.build.api.dsl.options.InstrumentationOptions;
/*     */ import com.android.build.api.dsl.options.JavaCompileOptions;
/*     */ import com.android.build.api.dsl.options.PostProcessingFilesOptions;
/*     */ import com.android.build.api.dsl.options.SigningConfig;
/*     */ import com.android.build.api.dsl.variant.Variant;
/*     */ import com.android.build.api.dsl.variant.VariantFilter;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableList;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableList.Companion;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ import com.android.build.gradle.internal.variant2.DslModelData;
/*     */ import com.android.build.gradle.internal.variant2.VariantCallbackHolder;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import kotlin.Deprecated;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.NamedDomainObjectContainer;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\016\n\000\n\002\030\002\n\002\020\036\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\t\n\002\020!\n\002\030\002\n\002\b\005\n\002\030\002\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\013\n\002\020\"\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020%\n\002\020\000\n\002\b\005\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\024\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\024\n\002\020$\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\017\n\002\020\002\n\002\b\007\n\002\020\021\n\002\b\007\n\002\020 \n\002\b\007\n\002\020\034\n\002\b\020\030\0002\0020\0012\0020\0022\0020\003B%\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t\022\006\020\n\032\0020\013¢\006\002\020\fJ%\020Â\001\032\0030Ã\0012\007\020Ä\001\032\0020\0172\007\020Å\001\032\0020\0172\006\0205\032\0020\017H\001J\036\020'\032\0030Ã\0012\023\020Æ\001\032\016\022\n\022\b\022\004\022\0020)0(0\021H\026J\024\020Ç\001\032\0030Ã\0012\007\020È\001\032\0020KH\001J'\020É\001\032\0030Ã\0012\024\020Ê\001\032\013\022\006\b\001\022\0020K0Ë\001\"\0020KH\001¢\006\003\020Ì\001J\030\020,\032\0030Ã\0012\r\020Æ\001\032\b\022\004\022\0020\0030\021H\027J\032\020Í\001\032\0030Ã\0012\r\020Æ\001\032\b\022\004\022\002020\021H\001J\031\0201\032\0030Ã\0012\r\020Æ\001\032\b\022\004\022\002020\021H\001J\031\020A\032\0030Ã\0012\r\020Æ\001\032\b\022\004\022\0020B0\021H\001J\031\020E\032\0030Ã\0012\r\020Æ\001\032\b\022\004\022\0020F0\021H\001J\022\020V\032\0030Ã\0012\006\020V\032\0020QH\001J\022\020V\032\0030Ã\0012\006\020V\032\0020\017H\001J0\020Î\001\032\0030Ã\0012\007\020Ï\001\032\0020\0172\024\020Ð\001\032\013\022\006\b\001\022\0020\0170Ë\001\"\0020\017H\001¢\006\003\020Ñ\001J\035\020Î\001\032\0030Ã\0012\007\020Ï\001\032\0020\0172\007\020Ò\001\032\0020\017H\001J$\020Î\001\032\0030Ã\0012\007\020Ï\001\032\0020\0172\016\020Ð\001\032\t\022\004\022\0020\0170Ó\001H\001J\031\020k\032\0030Ã\0012\r\020Æ\001\032\b\022\004\022\0020l0\021H\001J\031\020o\032\0030Ã\0012\r\020Æ\001\032\b\022\004\022\0020p0\021H\001J\037\020Ô\001\032\0030Ã\0012\023\020Æ\001\032\016\022\n\022\b\022\004\022\0020\0230\0220\021H\026J\031\020Õ\001\032\0030Ã\0012\r\020Æ\001\032\b\022\004\022\0020\0250\021H\026J\036\020y\032\0030Ã\0012\023\020Æ\001\032\016\022\n\022\b\022\004\022\0020z0(0\021H\026J\024\020È\001\032\0030Ã\0012\007\020È\001\032\0020KH\001J'\020Ê\001\032\0030Ã\0012\024\020Ö\001\032\013\022\006\b\001\022\0020K0Ë\001\"\0020KH\001¢\006\003\020Ì\001J%\020×\001\032\0030Ã\0012\007\020Ä\001\032\0020\0172\007\020Å\001\032\0020\0172\006\0205\032\0020\017H\001J\n\020Ø\001\032\0030Ã\001H\026J\033\020Ù\001\032\0030Ã\0012\016\020Ú\001\032\t\022\004\022\0020K0Û\001H\001J\035\020Ü\001\032\0030Ã\0012\020\020Ý\001\032\013\022\004\022\0020\017\030\0010Û\001H\001J\022\020Z\032\0030Ã\0012\006\020V\032\0020QH\001J\022\020Z\032\0030Ã\0012\006\020V\032\0020\017H\001J\033\020Þ\001\032\0030Ã\0012\016\020Ú\001\032\t\022\004\022\0020K0Û\001H\001J\024\020\001\032\0030Ã\0012\007\020\001\032\0020QH\001J\024\020\001\032\0030Ã\0012\007\020\001\032\0020\017H\001J\024\020ß\001\032\0030Ã\0012\007\020à\001\032\0020]H\001J\024\020á\001\032\0030Ã\0012\007\020â\001\032\0020]H\001J\033\020ã\001\032\0030Ã\0012\016\020Ö\001\032\t\022\004\022\0020K0Û\001H\001J\033\020ä\001\032\0030Ã\0012\016\020Æ\001\032\t\022\005\022\0030\0010\021H\001J \020\001\032\0030Ã\0012\024\020Æ\001\032\017\022\013\022\t\022\005\022\0030\0010(0\021H\026J\024\020\001\032\0030Ã\0012\007\020\001\032\0020QH\001J\024\020\001\032\0030Ã\0012\007\020\001\032\0020\017H\001J\034\020å\001\032\0030Ã\0012\007\020æ\001\032\0020\0172\006\0205\032\0020\017H\001J!\020§\001\032\0030Ã\0012\024\020ç\001\032\017\022\004\022\0020\017\022\004\022\0020\0170¨\001H\001J\024\020è\001\032\0030Ã\0012\007\020È\001\032\0020KH\001J'\020é\001\032\0030Ã\0012\024\020Ê\001\032\013\022\006\b\001\022\0020K0Ë\001\"\0020KH\001¢\006\003\020Ì\001J\031\020ê\001\032\0030Ã\0012\r\020Æ\001\032\b\022\004\022\0020\0270\021H\026J\033\020²\001\032\0030Ã\0012\016\020Æ\001\032\t\022\005\022\0030³\0010\021H\001J\033\020¿\001\032\0030Ã\0012\t\020¿\001\032\004\030\0010]H\001¢\006\002\020aR\024\020\r\032\b\022\004\022\0020\0170\016X\004¢\006\002\n\000R \020\020\032\024\022\020\022\016\022\n\022\b\022\004\022\0020\0230\0220\0210\016X\004¢\006\002\n\000R\032\020\024\032\016\022\n\022\b\022\004\022\0020\0250\0210\016X\004¢\006\002\n\000R\032\020\026\032\016\022\n\022\b\022\004\022\0020\0270\0210\016X\004¢\006\002\n\000R\032\020\030\032\004\030\0010\017X\017¢\006\f\032\004\b\031\020\032\"\004\b\033\020\034R\032\020\035\032\004\030\0010\017X\017¢\006\f\032\004\b\036\020\032\"\004\b\037\020\034R\036\020 \032\b\022\004\022\0020\"0!X\017¢\006\f\032\004\b#\020$\"\004\b%\020&R\032\020'\032\b\022\004\022\0020)0(8VX\004¢\006\006\032\004\b*\020+R\032\020,\032\0020\0038VX\004¢\006\f\022\004\b-\020.\032\004\b/\0200R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000R\022\0201\032\00202X\005¢\006\006\032\004\b3\0204R6\0206\032\b\022\004\022\0020\0170!2\f\0205\032\b\022\004\022\0020\0170!8V@VX\016¢\006\022\022\004\b7\020.\032\004\b8\020$\"\004\b9\020&R0\020:\032\b\022\004\022\0020\0170!2\f\0205\032\b\022\004\022\0020\0170!8V@VX\016¢\006\f\032\004\b;\020$\"\004\b<\020&R\034\020=\032\n\022\004\022\0020\017\030\0010>8\026X\005¢\006\006\032\004\b?\020@R\022\020A\032\0020BX\005¢\006\006\032\004\bC\020DR\022\020E\032\0020FX\005¢\006\006\032\004\bG\020HR$\020I\032\016\022\004\022\0020\017\022\004\022\0020K0JX\017¢\006\f\032\004\bL\020M\"\004\bN\020OR\032\020P\032\004\030\0010QX\017¢\006\f\032\004\bR\020S\"\004\bT\020UR\032\020V\032\004\030\0010WX\017¢\006\f\032\004\bX\020Y\"\004\bZ\020[R\032\020\\\032\004\030\0010]X\017¢\006\f\032\004\b^\020_\"\004\b`\020aR\032\020b\032\004\030\0010cX\017¢\006\f\032\004\bd\020e\"\004\bf\020gR\032\020h\032\004\030\0010cX\017¢\006\f\032\004\bi\020e\"\004\bj\020gR\022\020k\032\0020lX\005¢\006\006\032\004\bm\020nR\022\020o\032\0020pX\005¢\006\006\032\004\bq\020rRH\020s\032\024\022\020\022\016\022\n\022\b\022\004\022\0020\0230\0220\0210!2\030\0205\032\024\022\020\022\016\022\n\022\b\022\004\022\0020\0230\0220\0210!8V@VX\016¢\006\f\032\004\bt\020$\"\004\bu\020&R<\020v\032\016\022\n\022\b\022\004\022\0020\0250\0210!2\022\0205\032\016\022\n\022\b\022\004\022\0020\0250\0210!8V@VX\016¢\006\f\032\004\bw\020$\"\004\bx\020&R\032\020y\032\b\022\004\022\0020z0(8VX\004¢\006\006\032\004\b{\020+R\032\020|\032\004\030\0010]X\017¢\006\f\032\004\b}\020_\"\004\b~\020aR\034\020\032\004\030\0010]X\017¢\006\016\032\005\b\001\020_\"\005\b\001\020aR\035\020\001\032\004\030\0010]X\017¢\006\016\032\005\b\001\020_\"\005\b\001\020aR\035\020\001\032\004\030\0010QX\017¢\006\016\032\005\b\001\020S\"\005\b\001\020UR!\020\001\032\b\022\004\022\0020\0170!X\017¢\006\016\032\005\b\001\020$\"\005\b\001\020&R!\020\001\032\b\022\004\022\0020\"0!X\017¢\006\016\032\005\b\001\020$\"\005\b\001\020&R\026\020\001\032\0030\001X\005¢\006\b\032\006\b\001\020\001R \020\001\032\005\030\0010\001X\017¢\006\020\032\006\b\001\020\001\"\006\b\001\020\001R\035\020\001\032\t\022\005\022\0030\0010(8VX\004¢\006\007\032\005\b\001\020+R\035\020\001\032\004\030\0010WX\017¢\006\016\032\005\b\001\020Y\"\005\b\001\020[R!\020\001\032\004\030\0010\0178\026@\026X\017¢\006\016\032\005\b\001\020\032\"\005\b\001\020\034R\030\020 \001\032\004\030\0010]8\026X\005¢\006\007\032\005\b¡\001\020_R\030\020¢\001\032\004\030\0010]8\026X\005¢\006\007\032\005\b£\001\020_R!\020¤\001\032\004\030\0010\0178\026@\026X\017¢\006\016\032\005\b¥\001\020\032\"\005\b¦\001\020\034R,\020§\001\032\017\022\004\022\0020\017\022\004\022\0020\0170¨\0018\026@\026X\017¢\006\016\032\005\b©\001\020M\"\005\bª\001\020OR?\020«\001\032\016\022\n\022\b\022\004\022\0020\0270\0210!2\022\0205\032\016\022\n\022\b\022\004\022\0020\0270\0210!8V@VX\016¢\006\016\032\005\b¬\001\020$\"\005\b­\001\020&R\036\020®\001\032\t\022\004\022\0020\0230¯\001X\004¢\006\n\n\000\032\006\b°\001\020±\001R\026\020²\001\032\0030³\001X\005¢\006\b\032\006\b´\001\020µ\001R\035\020¶\001\032\004\030\0010QX\017¢\006\016\032\005\b·\001\020S\"\005\b¸\001\020UR\035\020¹\001\032\004\030\0010\017X\017¢\006\016\032\005\bº\001\020\032\"\005\b»\001\020\034R\035\020¼\001\032\004\030\0010\017X\017¢\006\016\032\005\b½\001\020\032\"\005\b¾\001\020\034R\035\020¿\001\032\004\030\0010]X\017¢\006\016\032\005\bÀ\001\020_\"\005\bÁ\001\020a¨\006ë\001"}, d2={"Lcom/android/build/gradle/internal/api/dsl/extensions/VariantAwarePropertiesImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/extension/VariantAwareProperties;", "Lcom/android/build/api/dsl/model/DefaultConfig;", "dslModelData", "Lcom/android/build/gradle/internal/variant2/DslModelData;", "variantCallbackHolder", "Lcom/android/build/gradle/internal/variant2/VariantCallbackHolder;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/variant2/DslModelData;Lcom/android/build/gradle/internal/variant2/VariantCallbackHolder;Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)V", "_flavorDimensions", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableList;", "", "_postVariants", "Lorg/gradle/api/Action;", "", "Lcom/android/build/api/dsl/variant/Variant;", "_preVariants", "Ljava/lang/Void;", "_variantFilters", "Lcom/android/build/api/dsl/variant/VariantFilter;", "applicationId", "getApplicationId", "()Ljava/lang/String;", "setApplicationId", "(Ljava/lang/String;)V", "applicationIdSuffix", "getApplicationIdSuffix", "setApplicationIdSuffix", "buildConfigFields", "", "Lcom/android/build/api/dsl/model/TypedValue;", "getBuildConfigFields", "()Ljava/util/List;", "setBuildConfigFields", "(Ljava/util/List;)V", "buildTypes", "Lorg/gradle/api/NamedDomainObjectContainer;", "Lcom/android/build/api/dsl/model/BuildType;", "getBuildTypes", "()Lorg/gradle/api/NamedDomainObjectContainer;", "defaultConfig", "defaultConfig$annotations", "()V", "getDefaultConfig", "()Lcom/android/build/api/dsl/model/DefaultConfig;", "externalNativeBuildOptions", "Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "getExternalNativeBuildOptions", "()Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "value", "flavorDimensionList", "flavorDimensionList$annotations", "getFlavorDimensionList", "setFlavorDimensionList", "flavorDimensions", "getFlavorDimensions", "setFlavorDimensions", "generatedDensities", "", "getGeneratedDensities", "()Ljava/util/Set;", "instrumentationOptions", "Lcom/android/build/api/dsl/options/InstrumentationOptions;", "getInstrumentationOptions", "()Lcom/android/build/api/dsl/options/InstrumentationOptions;", "javaCompileOptions", "Lcom/android/build/api/dsl/options/JavaCompileOptions;", "getJavaCompileOptions", "()Lcom/android/build/api/dsl/options/JavaCompileOptions;", "manifestPlaceholders", "", "", "getManifestPlaceholders", "()Ljava/util/Map;", "setManifestPlaceholders", "(Ljava/util/Map;)V", "maxSdkVersion", "", "getMaxSdkVersion", "()Ljava/lang/Integer;", "setMaxSdkVersion", "(Ljava/lang/Integer;)V", "minSdkVersion", "Lcom/android/build/api/dsl/ApiVersion;", "getMinSdkVersion", "()Lcom/android/build/api/dsl/ApiVersion;", "setMinSdkVersion", "(Lcom/android/build/api/dsl/ApiVersion;)V", "multiDexEnabled", "", "getMultiDexEnabled", "()Ljava/lang/Boolean;", "setMultiDexEnabled", "(Ljava/lang/Boolean;)V", "multiDexKeepFile", "Ljava/io/File;", "getMultiDexKeepFile", "()Ljava/io/File;", "setMultiDexKeepFile", "(Ljava/io/File;)V", "multiDexKeepProguard", "getMultiDexKeepProguard", "setMultiDexKeepProguard", "ndkOptions", "Lcom/android/build/api/dsl/options/NdkOptions;", "getNdkOptions", "()Lcom/android/build/api/dsl/options/NdkOptions;", "postProcessing", "Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "getPostProcessing", "()Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "postVariants", "getPostVariants", "setPostVariants", "preVariantCallbacks", "getPreVariantCallbacks", "setPreVariantCallbacks", "productFlavors", "Lcom/android/build/api/dsl/model/ProductFlavor;", "getProductFlavors", "renderscriptNdkModeEnabled", "getRenderscriptNdkModeEnabled", "setRenderscriptNdkModeEnabled", "renderscriptSupportModeBlasEnabled", "getRenderscriptSupportModeBlasEnabled", "setRenderscriptSupportModeBlasEnabled", "renderscriptSupportModeEnabled", "getRenderscriptSupportModeEnabled", "setRenderscriptSupportModeEnabled", "renderscriptTargetApi", "getRenderscriptTargetApi", "setRenderscriptTargetApi", "resConfigs", "getResConfigs", "setResConfigs", "resValues", "getResValues", "setResValues", "shaders", "Lcom/android/build/api/dsl/options/ShaderOptions;", "getShaders", "()Lcom/android/build/api/dsl/options/ShaderOptions;", "signingConfig", "Lcom/android/build/api/dsl/options/SigningConfig;", "getSigningConfig", "()Lcom/android/build/api/dsl/options/SigningConfig;", "setSigningConfig", "(Lcom/android/build/api/dsl/options/SigningConfig;)V", "signingConfigs", "getSigningConfigs", "targetSdkVersion", "getTargetSdkVersion", "setTargetSdkVersion", "testApplicationId", "getTestApplicationId", "setTestApplicationId", "testFunctionalTest", "getTestFunctionalTest", "testHandleProfiling", "getTestHandleProfiling", "testInstrumentationRunner", "getTestInstrumentationRunner", "setTestInstrumentationRunner", "testInstrumentationRunnerArguments", "", "getTestInstrumentationRunnerArguments", "setTestInstrumentationRunnerArguments", "variantFilters", "getVariantFilters", "setVariantFilters", "variants", "Lcom/android/build/api/dsl/extension/VariantCallbackHandler;", "getVariants", "()Lcom/android/build/api/dsl/extension/VariantCallbackHandler;", "vectorDrawables", "Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "getVectorDrawables", "()Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "versionCode", "getVersionCode", "setVersionCode", "versionName", "getVersionName", "setVersionName", "versionNameSuffix", "getVersionNameSuffix", "setVersionNameSuffix", "wearAppUnbundled", "getWearAppUnbundled", "setWearAppUnbundled", "buildConfigField", "", "type", "name", "action", "consumerProguardFile", "proguardFile", "consumerProguardFiles", "proguardFiles", "", "([Ljava/lang/Object;)V", "externalNativeBuild", "missingDimensionStrategy", "dimension", "requestedValues", "(Ljava/lang/String;[Ljava/lang/String;)V", "requestedValue", "", "postVariantCallback", "preVariantCallback", "files", "resValue", "seal", "setConsumerProguardFiles", "proguardFileIterable", "", "setGeneratedDensities", "densities", "setProguardFiles", "setTestFunctionalTest", "functionalTest", "setTestHandleProfiling", "handleProfiling", "setTestProguardFiles", "shaderOptions", "testInstrumentationRunnerArgument", "key", "args", "testProguardFile", "testProguardFiles", "variantFilter", "gradle-core"})
/*     */ public final class VariantAwarePropertiesImpl
/*     */   extends SealableObject
/*     */   implements com.android.build.api.dsl.extension.VariantAwareProperties, DefaultConfig
/*     */ {
/*     */   private final SealableList<String> _flavorDimensions;
/*     */   private final SealableList<Action<VariantFilter>> _variantFilters;
/*     */   private final SealableList<Action<Void>> _preVariants;
/*     */   private final SealableList<Action<Collection<Variant>>> _postVariants;
/*     */   @NotNull
/*     */   private final com.android.build.api.dsl.extension.VariantCallbackHandler<Variant> variants;
/*     */   private final DslModelData dslModelData;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   
/*     */   @NotNull
/*  46 */   public NamedDomainObjectContainer<com.android.build.api.dsl.model.ProductFlavor> getProductFlavors() { return dslModelData.getProductFlavors(); }
/*     */   @NotNull
/*  48 */   public NamedDomainObjectContainer<com.android.build.api.dsl.model.BuildType> getBuildTypes() { return dslModelData.getBuildTypes(); }
/*     */   @NotNull
/*  50 */   public NamedDomainObjectContainer<SigningConfig> getSigningConfigs() { return dslModelData.getSigningConfigs(); }
/*     */   
/*     */   @NotNull
/*     */   public com.android.build.api.dsl.extension.VariantCallbackHandler<Variant> getVariants()
/*     */   {
/*  57 */     return variants;
/*     */   }
/*     */   
/*     */   public VariantAwarePropertiesImpl(@NotNull DslModelData dslModelData, @NotNull VariantCallbackHolder variantCallbackHolder, @NotNull DeprecationReporter deprecationReporter, @NotNull com.android.builder.errors.EvalIssueReporter issueReporter)
/*     */   {
/*  41 */     super(issueReporter);
/*     */     
/*  43 */     $$delegate_0 = dslModelData.getDefaultConfig();this.dslModelData = dslModelData;this.deprecationReporter = deprecationReporter;
/*     */     
/*  52 */     _flavorDimensions = SealableList.Companion.jdMethod_new(issueReporter);
/*  53 */     _variantFilters = SealableList.Companion.jdMethod_new(issueReporter);
/*  54 */     _preVariants = SealableList.Companion.jdMethod_new(issueReporter);
/*  55 */     _postVariants = SealableList.Companion.jdMethod_new(issueReporter);
/*     */     
/*  58 */     variants = variantCallbackHolder.createVariantCallbackHandler(); }
/*     */   
/*     */   @NotNull
/*  61 */   public List<Action<VariantFilter>> getVariantFilters() { return (List)_variantFilters; }
/*     */   
/*  63 */   public void setVariantFilters(@NotNull List<Action<VariantFilter>> value) { Intrinsics.checkParameterIsNotNull(value, "value");_variantFilters.reset$gradle_core((Collection)value);
/*     */   }
/*     */   
/*     */   @NotNull
/*  67 */   public List<String> getFlavorDimensions() { return (List)_flavorDimensions; }
/*     */   
/*  69 */   public void setFlavorDimensions(@NotNull List<String> value) { Intrinsics.checkParameterIsNotNull(value, "value");_flavorDimensions.reset$gradle_core((Collection)value);
/*     */   }
/*     */   
/*     */   public void buildTypes(@NotNull Action<NamedDomainObjectContainer<com.android.build.api.dsl.model.BuildType>> action) {
/*  73 */     Intrinsics.checkParameterIsNotNull(action, "action");action.execute(getBuildTypes());
/*     */   }
/*     */   
/*     */   public void productFlavors(@NotNull Action<NamedDomainObjectContainer<com.android.build.api.dsl.model.ProductFlavor>> action) {
/*  77 */     Intrinsics.checkParameterIsNotNull(action, "action");action.execute(getProductFlavors());
/*     */   }
/*     */   
/*     */   public void signingConfigs(@NotNull Action<NamedDomainObjectContainer<SigningConfig>> action) {
/*  81 */     Intrinsics.checkParameterIsNotNull(action, "action");action.execute(getSigningConfigs());
/*     */   }
/*     */   
/*     */   @NotNull
/*  85 */   public List<Action<Void>> getPreVariantCallbacks() { return (List)_preVariants; }
/*     */   
/*  87 */   public void setPreVariantCallbacks(@NotNull List<Action<Void>> value) { Intrinsics.checkParameterIsNotNull(value, "value");_preVariants.reset$gradle_core((Collection)value);
/*     */   }
/*     */   
/*     */   public void preVariantCallback(@NotNull Action<Void> action) {
/*  91 */     Intrinsics.checkParameterIsNotNull(action, "action"); if (checkSeal()) {
/*  92 */       _preVariants.add(action);
/*     */     }
/*     */   }
/*     */   
/*     */   public void variantFilter(@NotNull Action<VariantFilter> action) {
/*  97 */     Intrinsics.checkParameterIsNotNull(action, "action"); if (checkSeal()) {
/*  98 */       _variantFilters.add(action);
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/* 103 */   public List<Action<Collection<Variant>>> getPostVariants() { return (List)_postVariants; }
/*     */   
/* 105 */   public void setPostVariants(@NotNull List<Action<Collection<Variant>>> value) { Intrinsics.checkParameterIsNotNull(value, "value");_postVariants.reset$gradle_core((Collection)value);
/*     */   }
/*     */   
/*     */   public void postVariantCallback(@NotNull Action<Collection<Variant>> action) {
/* 109 */     Intrinsics.checkParameterIsNotNull(action, "action"); if (checkSeal()) {
/* 110 */       _postVariants.add(action);
/*     */     }
/*     */   }
/*     */   
/*     */   public void seal() {
/* 115 */     super.seal();
/* 116 */     _flavorDimensions.seal();
/* 117 */     _preVariants.seal();
/* 118 */     _variantFilters.seal();
/* 119 */     _postVariants.seal();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public List<String> getFlavorDimensionList()
/*     */   {
/* 127 */     deprecationReporter.reportDeprecatedUsage(
/* 128 */       "android.flavorDimensions", 
/* 129 */       "android.flavorDimensionList", 
/* 130 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 131 */     return getFlavorDimensions();
/*     */   }
/*     */   
/* 134 */   public void setFlavorDimensionList(@NotNull List<String> value) { Intrinsics.checkParameterIsNotNull(value, "value");deprecationReporter.reportDeprecatedUsage(
/* 135 */       "android.flavorDimensions", 
/* 136 */       "android.flavorDimensionList", 
/* 137 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 138 */     setFlavorDimensions(value);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public DefaultConfig getDefaultConfig()
/*     */   {
/* 144 */     deprecationReporter.reportDeprecatedUsage(
/* 145 */       "android", 
/* 146 */       "android.defaultConfig", 
/* 147 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 148 */     return (DefaultConfig)this;
/*     */   }
/*     */   
/*     */   public void defaultConfig(@NotNull Action<DefaultConfig> action)
/*     */   {
/* 153 */     Intrinsics.checkParameterIsNotNull(action, "action");deprecationReporter.reportDeprecatedUsage(
/* 154 */       "android", 
/* 155 */       "android.defaultConfig", 
/* 156 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 157 */     action.execute(this);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getApplicationId()
/*     */   {
/*     */     return $$delegate_0.getApplicationId();
/*     */   }
/*     */   
/*     */   public void setApplicationId(@Nullable String <set-?>)
/*     */   {
/*     */     $$delegate_0.setApplicationId(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getApplicationIdSuffix()
/*     */   {
/*     */     return $$delegate_0.getApplicationIdSuffix();
/*     */   }
/*     */   
/*     */   public void setApplicationIdSuffix(@Nullable String <set-?>)
/*     */   {
/*     */     $$delegate_0.setApplicationIdSuffix(<set-?>);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public List<TypedValue> getBuildConfigFields()
/*     */   {
/*     */     return $$delegate_0.getBuildConfigFields();
/*     */   }
/*     */   
/*     */   public void setBuildConfigFields(@NotNull List<TypedValue> <set-?>)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     $$delegate_0.setBuildConfigFields(<set-?>);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public ExternalNativeBuildOptions getExternalNativeBuildOptions()
/*     */   {
/*     */     return $$delegate_0.getExternalNativeBuildOptions();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Nullable
/*     */   public java.util.Set<String> getGeneratedDensities()
/*     */   {
/*     */     return $$delegate_0.getGeneratedDensities();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public InstrumentationOptions getInstrumentationOptions()
/*     */   {
/*     */     return $$delegate_0.getInstrumentationOptions();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public JavaCompileOptions getJavaCompileOptions()
/*     */   {
/*     */     return $$delegate_0.getJavaCompileOptions();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Map<String, Object> getManifestPlaceholders()
/*     */   {
/*     */     return $$delegate_0.getManifestPlaceholders();
/*     */   }
/*     */   
/*     */   public void setManifestPlaceholders(@NotNull Map<String, Object> <set-?>)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     $$delegate_0.setManifestPlaceholders(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Integer getMaxSdkVersion()
/*     */   {
/*     */     return $$delegate_0.getMaxSdkVersion();
/*     */   }
/*     */   
/*     */   public void setMaxSdkVersion(@Nullable Integer <set-?>)
/*     */   {
/*     */     $$delegate_0.setMaxSdkVersion(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public ApiVersion getMinSdkVersion()
/*     */   {
/*     */     return $$delegate_0.getMinSdkVersion();
/*     */   }
/*     */   
/*     */   public void setMinSdkVersion(@Nullable ApiVersion <set-?>)
/*     */   {
/*     */     $$delegate_0.setMinSdkVersion(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Boolean getMultiDexEnabled()
/*     */   {
/*     */     return $$delegate_0.getMultiDexEnabled();
/*     */   }
/*     */   
/*     */   public void setMultiDexEnabled(@Nullable Boolean <set-?>)
/*     */   {
/*     */     $$delegate_0.setMultiDexEnabled(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public File getMultiDexKeepFile()
/*     */   {
/*     */     return $$delegate_0.getMultiDexKeepFile();
/*     */   }
/*     */   
/*     */   public void setMultiDexKeepFile(@Nullable File <set-?>)
/*     */   {
/*     */     $$delegate_0.setMultiDexKeepFile(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public File getMultiDexKeepProguard()
/*     */   {
/*     */     return $$delegate_0.getMultiDexKeepProguard();
/*     */   }
/*     */   
/*     */   public void setMultiDexKeepProguard(@Nullable File <set-?>)
/*     */   {
/*     */     $$delegate_0.setMultiDexKeepProguard(<set-?>);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public com.android.build.api.dsl.options.NdkOptions getNdkOptions()
/*     */   {
/*     */     return $$delegate_0.getNdkOptions();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public PostProcessingFilesOptions getPostProcessing()
/*     */   {
/*     */     return $$delegate_0.getPostProcessing();
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Boolean getRenderscriptNdkModeEnabled()
/*     */   {
/*     */     return $$delegate_0.getRenderscriptNdkModeEnabled();
/*     */   }
/*     */   
/*     */   public void setRenderscriptNdkModeEnabled(@Nullable Boolean <set-?>)
/*     */   {
/*     */     $$delegate_0.setRenderscriptNdkModeEnabled(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Boolean getRenderscriptSupportModeBlasEnabled()
/*     */   {
/*     */     return $$delegate_0.getRenderscriptSupportModeBlasEnabled();
/*     */   }
/*     */   
/*     */   public void setRenderscriptSupportModeBlasEnabled(@Nullable Boolean <set-?>)
/*     */   {
/*     */     $$delegate_0.setRenderscriptSupportModeBlasEnabled(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Boolean getRenderscriptSupportModeEnabled()
/*     */   {
/*     */     return $$delegate_0.getRenderscriptSupportModeEnabled();
/*     */   }
/*     */   
/*     */   public void setRenderscriptSupportModeEnabled(@Nullable Boolean <set-?>)
/*     */   {
/*     */     $$delegate_0.setRenderscriptSupportModeEnabled(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Integer getRenderscriptTargetApi()
/*     */   {
/*     */     return $$delegate_0.getRenderscriptTargetApi();
/*     */   }
/*     */   
/*     */   public void setRenderscriptTargetApi(@Nullable Integer <set-?>)
/*     */   {
/*     */     $$delegate_0.setRenderscriptTargetApi(<set-?>);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public List<String> getResConfigs()
/*     */   {
/*     */     return $$delegate_0.getResConfigs();
/*     */   }
/*     */   
/*     */   public void setResConfigs(@NotNull List<String> <set-?>)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     $$delegate_0.setResConfigs(<set-?>);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public List<TypedValue> getResValues()
/*     */   {
/*     */     return $$delegate_0.getResValues();
/*     */   }
/*     */   
/*     */   public void setResValues(@NotNull List<TypedValue> <set-?>)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     $$delegate_0.setResValues(<set-?>);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public com.android.build.api.dsl.options.ShaderOptions getShaders()
/*     */   {
/*     */     return $$delegate_0.getShaders();
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public SigningConfig getSigningConfig()
/*     */   {
/*     */     return $$delegate_0.getSigningConfig();
/*     */   }
/*     */   
/*     */   public void setSigningConfig(@Nullable SigningConfig <set-?>)
/*     */   {
/*     */     $$delegate_0.setSigningConfig(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public ApiVersion getTargetSdkVersion()
/*     */   {
/*     */     return $$delegate_0.getTargetSdkVersion();
/*     */   }
/*     */   
/*     */   public void setTargetSdkVersion(@Nullable ApiVersion <set-?>)
/*     */   {
/*     */     $$delegate_0.setTargetSdkVersion(<set-?>);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Nullable
/*     */   public String getTestApplicationId()
/*     */   {
/*     */     return $$delegate_0.getTestApplicationId();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   public void setTestApplicationId(@Nullable String <set-?>)
/*     */   {
/*     */     $$delegate_0.setTestApplicationId(<set-?>);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Nullable
/*     */   public Boolean getTestFunctionalTest()
/*     */   {
/*     */     return $$delegate_0.getTestFunctionalTest();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Nullable
/*     */   public Boolean getTestHandleProfiling()
/*     */   {
/*     */     return $$delegate_0.getTestHandleProfiling();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Nullable
/*     */   public String getTestInstrumentationRunner()
/*     */   {
/*     */     return $$delegate_0.getTestInstrumentationRunner();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   public void setTestInstrumentationRunner(@Nullable String <set-?>)
/*     */   {
/*     */     $$delegate_0.setTestInstrumentationRunner(<set-?>);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @NotNull
/*     */   public Map<String, String> getTestInstrumentationRunnerArguments()
/*     */   {
/*     */     return $$delegate_0.getTestInstrumentationRunnerArguments();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   public void setTestInstrumentationRunnerArguments(@NotNull Map<String, String> <set-?>)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     $$delegate_0.setTestInstrumentationRunnerArguments(<set-?>);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public com.android.build.api.dsl.options.VectorDrawablesOptions getVectorDrawables()
/*     */   {
/*     */     return $$delegate_0.getVectorDrawables();
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Integer getVersionCode()
/*     */   {
/*     */     return $$delegate_0.getVersionCode();
/*     */   }
/*     */   
/*     */   public void setVersionCode(@Nullable Integer <set-?>)
/*     */   {
/*     */     $$delegate_0.setVersionCode(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getVersionName()
/*     */   {
/*     */     return $$delegate_0.getVersionName();
/*     */   }
/*     */   
/*     */   public void setVersionName(@Nullable String <set-?>)
/*     */   {
/*     */     $$delegate_0.setVersionName(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getVersionNameSuffix()
/*     */   {
/*     */     return $$delegate_0.getVersionNameSuffix();
/*     */   }
/*     */   
/*     */   public void setVersionNameSuffix(@Nullable String <set-?>)
/*     */   {
/*     */     $$delegate_0.setVersionNameSuffix(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Boolean getWearAppUnbundled()
/*     */   {
/*     */     return $$delegate_0.getWearAppUnbundled();
/*     */   }
/*     */   
/*     */   public void setWearAppUnbundled(@Nullable Boolean <set-?>)
/*     */   {
/*     */     $$delegate_0.setWearAppUnbundled(<set-?>);
/*     */   }
/*     */   
/*     */   public void buildConfigField(@NotNull String type, @NotNull String name, @NotNull String value)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(type, "type");
/*     */     Intrinsics.checkParameterIsNotNull(name, "name");
/*     */     Intrinsics.checkParameterIsNotNull(value, "value");
/*     */     $$delegate_0.buildConfigField(type, name, value);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void consumerProguardFile(@NotNull Object proguardFile)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*     */     $$delegate_0.consumerProguardFile(proguardFile);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void consumerProguardFiles(@NotNull Object... proguardFiles)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");
/*     */     $$delegate_0.consumerProguardFiles(proguardFiles);
/*     */   }
/*     */   
/*     */   public void externalNativeBuild(@NotNull Action<ExternalNativeBuildOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     $$delegate_0.externalNativeBuild(action);
/*     */   }
/*     */   
/*     */   public void externalNativeBuildOptions(@NotNull Action<ExternalNativeBuildOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     $$delegate_0.externalNativeBuildOptions(action);
/*     */   }
/*     */   
/*     */   public void instrumentationOptions(@NotNull Action<InstrumentationOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     $$delegate_0.instrumentationOptions(action);
/*     */   }
/*     */   
/*     */   public void javaCompileOptions(@NotNull Action<JavaCompileOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     $$delegate_0.javaCompileOptions(action);
/*     */   }
/*     */   
/*     */   public void minSdkVersion(int minSdkVersion)
/*     */   {
/*     */     $$delegate_0.minSdkVersion(minSdkVersion);
/*     */   }
/*     */   
/*     */   public void minSdkVersion(@NotNull String minSdkVersion)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(minSdkVersion, "minSdkVersion");
/*     */     $$delegate_0.minSdkVersion(minSdkVersion);
/*     */   }
/*     */   
/*     */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull String... requestedValues)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*     */     Intrinsics.checkParameterIsNotNull(requestedValues, "requestedValues");
/*     */     $$delegate_0.missingDimensionStrategy(dimension, requestedValues);
/*     */   }
/*     */   
/*     */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull String requestedValue)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*     */     Intrinsics.checkParameterIsNotNull(requestedValue, "requestedValue");
/*     */     $$delegate_0.missingDimensionStrategy(dimension, requestedValue);
/*     */   }
/*     */   
/*     */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull List<String> requestedValues)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*     */     Intrinsics.checkParameterIsNotNull(requestedValues, "requestedValues");
/*     */     $$delegate_0.missingDimensionStrategy(dimension, requestedValues);
/*     */   }
/*     */   
/*     */   public void ndkOptions(@NotNull Action<com.android.build.api.dsl.options.NdkOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     $$delegate_0.ndkOptions(action);
/*     */   }
/*     */   
/*     */   public void postProcessing(@NotNull Action<PostProcessingFilesOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     $$delegate_0.postProcessing(action);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void proguardFile(@NotNull Object proguardFile)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*     */     $$delegate_0.proguardFile(proguardFile);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void proguardFiles(@NotNull Object... files)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(files, "files");
/*     */     $$delegate_0.proguardFiles(files);
/*     */   }
/*     */   
/*     */   public void resValue(@NotNull String type, @NotNull String name, @NotNull String value)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(type, "type");
/*     */     Intrinsics.checkParameterIsNotNull(name, "name");
/*     */     Intrinsics.checkParameterIsNotNull(value, "value");
/*     */     $$delegate_0.resValue(type, name, value);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void setConsumerProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");
/*     */     $$delegate_0.setConsumerProguardFiles(proguardFileIterable);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use {@link VectorDrawablesOptions#setGeneratedDensities(Iterable)}\n      ")
/*     */   public void setGeneratedDensities(@Nullable Iterable<String> densities)
/*     */   {
/*     */     $$delegate_0.setGeneratedDensities(densities);
/*     */   }
/*     */   
/*     */   public void setMinSdkVersion(int minSdkVersion)
/*     */   {
/*     */     $$delegate_0.setMinSdkVersion(minSdkVersion);
/*     */   }
/*     */   
/*     */   public void setMinSdkVersion(@NotNull String minSdkVersion)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(minSdkVersion, "minSdkVersion");
/*     */     $$delegate_0.setMinSdkVersion(minSdkVersion);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void setProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");
/*     */     $$delegate_0.setProguardFiles(proguardFileIterable);
/*     */   }
/*     */   
/*     */   public void setTargetSdkVersion(int targetSdkVersion)
/*     */   {
/*     */     $$delegate_0.setTargetSdkVersion(targetSdkVersion);
/*     */   }
/*     */   
/*     */   public void setTargetSdkVersion(@NotNull String targetSdkVersion)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(targetSdkVersion, "targetSdkVersion");
/*     */     $$delegate_0.setTargetSdkVersion(targetSdkVersion);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use {@link InstrumentationOptions#setFunctionalTest(boolean)}\n      ")
/*     */   public void setTestFunctionalTest(boolean functionalTest)
/*     */   {
/*     */     $$delegate_0.setTestFunctionalTest(functionalTest);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use {@link InstrumentationOptions#setHandleProfiling(boolean)}\n      ")
/*     */   public void setTestHandleProfiling(boolean handleProfiling)
/*     */   {
/*     */     $$delegate_0.setTestHandleProfiling(handleProfiling);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void setTestProguardFiles(@NotNull Iterable<? extends Object> files)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(files, "files");
/*     */     $$delegate_0.setTestProguardFiles(files);
/*     */   }
/*     */   
/*     */   public void shaderOptions(@NotNull Action<com.android.build.api.dsl.options.ShaderOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     $$delegate_0.shaderOptions(action);
/*     */   }
/*     */   
/*     */   public void targetSdkVersion(int targetSdkVersion)
/*     */   {
/*     */     $$delegate_0.targetSdkVersion(targetSdkVersion);
/*     */   }
/*     */   
/*     */   public void targetSdkVersion(@NotNull String targetSdkVersion)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(targetSdkVersion, "targetSdkVersion");
/*     */     $$delegate_0.targetSdkVersion(targetSdkVersion);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use {@link InstrumentationOptions#instrumentationRunnerArgument(String, String)}\n      ")
/*     */   public void testInstrumentationRunnerArgument(@NotNull String key, @NotNull String value)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(key, "key");
/*     */     Intrinsics.checkParameterIsNotNull(value, "value");
/*     */     $$delegate_0.testInstrumentationRunnerArgument(key, value);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use {@link InstrumentationOptions#addInstrumentationRunnerArguments(Map)}\n      ")
/*     */   public void testInstrumentationRunnerArguments(@NotNull Map<String, String> args)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(args, "args");
/*     */     $$delegate_0.testInstrumentationRunnerArguments(args);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void testProguardFile(@NotNull Object proguardFile)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*     */     $$delegate_0.testProguardFile(proguardFile);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void testProguardFiles(@NotNull Object... proguardFiles)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");
/*     */     $$delegate_0.testProguardFiles(proguardFiles);
/*     */   }
/*     */   
/*     */   public void vectorDrawables(@NotNull Action<com.android.build.api.dsl.options.VectorDrawablesOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     $$delegate_0.vectorDrawables(action);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use {@link #setWearAppUnbundled(Boolean)} ")
/*     */   public void wearAppUnbundled(@Nullable Boolean wearAppUnbundled)
/*     */   {
/*     */     $$delegate_0.wearAppUnbundled(wearAppUnbundled);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.extensions.VariantAwarePropertiesImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */