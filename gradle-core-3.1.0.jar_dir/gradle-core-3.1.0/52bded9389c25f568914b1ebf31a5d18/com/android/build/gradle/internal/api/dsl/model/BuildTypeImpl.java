/*     */ package com.android.build.gradle.internal.api.dsl.model;
/*     */ 
/*     */ import com.android.build.api.dsl.model.TypedValue;
/*     */ import com.android.build.api.dsl.options.PostProcessingOptions;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import kotlin.Deprecated;
/*     */ import kotlin.NotImplementedError;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Action;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000Ê\001\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\007\n\002\020!\n\002\030\002\n\002\b\007\n\002\020\013\n\002\b\021\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\006\n\002\020%\n\002\020\000\n\002\b\021\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\t\n\002\020\b\n\002\b\b\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\021\n\002\020\002\n\002\b\006\n\002\020\021\n\002\b\003\n\002\030\002\n\002\b\024\n\002\020\034\n\002\b\t\030\0002\0020\0012\0020\0022\0020\0032\0020\0042\0020\0052\0020\006B=\022\006\020\007\032\0020\b\022\006\020\t\032\0020\n\022\006\020\013\032\0020\f\022\006\020\r\032\0020\016\022\006\020\017\032\0020\020\022\006\020\021\032\0020\022\022\006\020\023\032\0020\024¢\006\002\020\025J%\020\001\032\0030\0012\007\020\001\032\0020\b2\007\020\001\032\0020\b2\006\020*\032\0020\bH\001J\024\020\001\032\0030\0012\007\020\001\032\0020CH\001J'\020\001\032\0030\0012\024\020\001\032\013\022\006\b\001\022\0020C0\001\"\0020CH\001¢\006\003\020\001J\033\020\001\032\0030\0012\016\020\001\032\t\022\004\022\002070\001H\001J\032\0206\032\0030\0012\016\020\001\032\t\022\004\022\002070\001H\001J\t\020\001\032\0020\bH\026J\023\020\001\032\0030\0012\007\020\001\032\0020\002H\026J\t\020\001\032\0020%H\027J\t\020\001\032\0020%H\027J\n\020 \001\032\0020%H\001J\n\020¡\001\032\0020%H\001J\n\020¢\001\032\0020%H\001J\t\020£\001\032\0020%H\027J\n\020¤\001\032\0020%H\001J\n\020¥\001\032\0020%H\001J\t\020¦\001\032\0020%H\027J\n\020§\001\032\0020%H\001J\020\020¨\001\032\004\030\0010%H\027¢\006\002\020QJ\n\020©\001\032\0020%H\001J\032\020:\032\0030\0012\016\020\001\032\t\022\004\022\0020;0\001H\001J\032\020]\032\0030\0012\016\020\001\032\t\022\004\022\0020^0\001H\001J\032\020a\032\0030\0012\016\020\001\032\t\022\004\022\0020b0\001H\001J\024\020\001\032\0030\0012\007\020\001\032\0020CH\001J'\020\001\032\0030\0012\024\020ª\001\032\013\022\006\b\001\022\0020C0\001\"\0020CH\001¢\006\003\020\001J%\020«\001\032\0030\0012\007\020\001\032\0020\b2\007\020\001\032\0020\b2\006\020*\032\0020\bH\001J\n\020¬\001\032\0030\001H\026J\033\020­\001\032\0030\0012\016\020®\001\032\t\022\004\022\0020C0¯\001H\001J&\020J\032\0030\0012\024\020°\001\032\013\022\006\b\001\022\0020\b0\001\"\0020\bH\001¢\006\003\020±\001J\023\020J\032\0030\0012\007\020²\001\032\0020\bH\001J\033\020³\001\032\0030\0012\016\020®\001\032\t\022\004\022\0020C0¯\001H\001J\033\020´\001\032\0030\0012\016\020ª\001\032\t\022\004\022\0020C0¯\001H\001J\033\020µ\001\032\0030\0012\016\020\001\032\t\022\004\022\0020u0\001H\001J\024\020¶\001\032\0030\0012\007\020\001\032\0020CH\001J'\020·\001\032\0030\0012\024\020\001\032\013\022\006\b\001\022\0020C0\001\"\0020CH\001¢\006\003\020\001R\032\020\026\032\004\030\0010\bX\017¢\006\f\032\004\b\027\020\030\"\004\b\031\020\032R\036\020\033\032\b\022\004\022\0020\0350\034X\017¢\006\f\032\004\b\036\020\037\"\004\b \020!R\016\020\013\032\0020\fX\004¢\006\002\n\000R\024\020\r\032\0020\016X\004¢\006\b\n\000\032\004\b\"\020#R\030\020$\032\0020%X\017¢\006\f\032\004\b&\020'\"\004\b(\020)R,\020+\032\0020%2\006\020*\032\0020%8V@VX\016¢\006\024\n\000\022\004\b,\020-\032\004\b.\020'\"\004\b/\020)R\030\0200\032\0020%X\017¢\006\f\032\004\b1\020'\"\004\b2\020)R\016\020\021\032\0020\022X\004¢\006\002\n\000R\030\0203\032\0020%X\017¢\006\f\032\004\b4\020'\"\004\b5\020)R\022\0206\032\00207X\005¢\006\006\032\004\b8\0209R\016\020\017\032\0020\020X\004¢\006\002\n\000R\022\020:\032\0020;X\005¢\006\006\032\004\b<\020=R\030\020>\032\0020%X\017¢\006\f\032\004\b?\020'\"\004\b@\020)R$\020A\032\016\022\004\022\0020\b\022\004\022\0020C0BX\017¢\006\f\032\004\bD\020E\"\004\bF\020GR\036\020H\032\b\022\004\022\0020\b0\034X\017¢\006\f\032\004\bI\020\037\"\004\bJ\020!R*\020K\032\0020%2\006\020*\032\0020%8V@VX\016¢\006\022\022\004\bL\020-\032\004\bM\020'\"\004\bN\020)R\032\020O\032\004\030\0010%X\017¢\006\f\032\004\bP\020Q\"\004\bR\020SR\032\020T\032\004\030\0010UX\017¢\006\f\032\004\bV\020W\"\004\bX\020YR\032\020Z\032\004\030\0010UX\017¢\006\f\032\004\b[\020W\"\004\b\\\020YR\016\020\007\032\0020\bX\004¢\006\002\n\000R\022\020]\032\0020^X\005¢\006\006\032\004\b_\020`R\022\020a\032\0020bX\005¢\006\006\032\004\bc\020dR\030\020e\032\0020%X\017¢\006\f\032\004\bf\020'\"\004\bg\020)R\030\020h\032\0020%X\017¢\006\f\032\004\bi\020'\"\004\bj\020)R\030\020k\032\0020lX\017¢\006\f\032\004\bm\020n\"\004\bo\020pR\036\020q\032\b\022\004\022\0020\0350\034X\017¢\006\f\032\004\br\020\037\"\004\bs\020!R\022\020t\032\0020uX\005¢\006\006\032\004\bv\020wR*\020x\032\0020%2\006\020*\032\0020%8V@VX\016¢\006\022\022\004\by\020-\032\004\bz\020'\"\004\b{\020)R\034\020|\032\004\030\0010}X\017¢\006\016\032\004\b~\020\"\006\b\001\020\001R\033\020\001\032\0020%X\017¢\006\016\032\005\b\001\020'\"\005\b\001\020)R\037\020\001\032\004\030\0010%8VX\004¢\006\016\022\005\b\001\020-\032\005\b\001\020QR\016\020\t\032\0020\nX\004¢\006\002\n\000R\035\020\001\032\004\030\0010\bX\017¢\006\016\032\005\b\001\020\030\"\005\b\001\020\032R\033\020\001\032\0020%X\017¢\006\016\032\005\b\001\020'\"\005\b\001\020)¨\006¸\001"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/model/BuildType;", "Lcom/android/build/api/dsl/model/VariantProperties;", "Lcom/android/build/api/dsl/model/BuildTypeOrProductFlavor;", "Lcom/android/build/api/dsl/model/BuildTypeOrVariant;", "Lcom/android/build/api/dsl/model/FallbackStrategy;", "named", "", "variantProperties", "Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;", "buildTypeOrProductFlavor", "Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;", "buildTypeOrVariant", "Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;", "fallbackStrategy", "Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/lang/String;Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)V", "applicationIdSuffix", "getApplicationIdSuffix", "()Ljava/lang/String;", "setApplicationIdSuffix", "(Ljava/lang/String;)V", "buildConfigFields", "", "Lcom/android/build/api/dsl/model/TypedValue;", "getBuildConfigFields", "()Ljava/util/List;", "setBuildConfigFields", "(Ljava/util/List;)V", "getBuildTypeOrVariant$gradle_core", "()Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;", "crunchPngs", "", "getCrunchPngs", "()Z", "setCrunchPngs", "(Z)V", "value", "crunchPngsDefault", "crunchPngsDefault$annotations", "()V", "getCrunchPngsDefault", "setCrunchPngsDefault", "debuggable", "getDebuggable", "setDebuggable", "embedMicroApp", "getEmbedMicroApp", "setEmbedMicroApp", "externalNativeBuildOptions", "Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "getExternalNativeBuildOptions", "()Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "javaCompileOptions", "Lcom/android/build/api/dsl/options/JavaCompileOptions;", "getJavaCompileOptions", "()Lcom/android/build/api/dsl/options/JavaCompileOptions;", "jniDebuggable", "getJniDebuggable", "setJniDebuggable", "manifestPlaceholders", "", "", "getManifestPlaceholders", "()Ljava/util/Map;", "setManifestPlaceholders", "(Ljava/util/Map;)V", "matchingFallbacks", "getMatchingFallbacks", "setMatchingFallbacks", "minifyEnabled", "minifyEnabled$annotations", "getMinifyEnabled", "setMinifyEnabled", "multiDexEnabled", "getMultiDexEnabled", "()Ljava/lang/Boolean;", "setMultiDexEnabled", "(Ljava/lang/Boolean;)V", "multiDexKeepFile", "Ljava/io/File;", "getMultiDexKeepFile", "()Ljava/io/File;", "setMultiDexKeepFile", "(Ljava/io/File;)V", "multiDexKeepProguard", "getMultiDexKeepProguard", "setMultiDexKeepProguard", "ndkOptions", "Lcom/android/build/api/dsl/options/NdkOptions;", "getNdkOptions", "()Lcom/android/build/api/dsl/options/NdkOptions;", "postProcessing", "Lcom/android/build/api/dsl/options/PostProcessingOptions;", "getPostProcessing", "()Lcom/android/build/api/dsl/options/PostProcessingOptions;", "pseudoLocalesEnabled", "getPseudoLocalesEnabled", "setPseudoLocalesEnabled", "renderscriptDebuggable", "getRenderscriptDebuggable", "setRenderscriptDebuggable", "renderscriptOptimLevel", "", "getRenderscriptOptimLevel", "()I", "setRenderscriptOptimLevel", "(I)V", "resValues", "getResValues", "setResValues", "shaders", "Lcom/android/build/api/dsl/options/ShaderOptions;", "getShaders", "()Lcom/android/build/api/dsl/options/ShaderOptions;", "shrinkResources", "shrinkResources$annotations", "getShrinkResources", "setShrinkResources", "signingConfig", "Lcom/android/build/api/dsl/options/SigningConfig;", "getSigningConfig", "()Lcom/android/build/api/dsl/options/SigningConfig;", "setSigningConfig", "(Lcom/android/build/api/dsl/options/SigningConfig;)V", "testCoverageEnabled", "getTestCoverageEnabled", "setTestCoverageEnabled", "useProguard", "useProguard$annotations", "getUseProguard", "versionNameSuffix", "getVersionNameSuffix", "setVersionNameSuffix", "zipAlignEnabled", "getZipAlignEnabled", "setZipAlignEnabled", "buildConfigField", "", "type", "name", "consumerProguardFile", "proguardFile", "consumerProguardFiles", "proguardFiles", "", "([Ljava/lang/Object;)V", "externalNativeBuild", "action", "Lorg/gradle/api/Action;", "getName", "initWith", "that", "isCrunchPngs", "isCrunchPngsDefault", "isDebuggable", "isEmbedMicroApp", "isJniDebuggable", "isMinifiedEnabled", "isPseudoLocalesEnabled", "isRenderscriptDebuggable", "isShrinkResources", "isTestCoverageEnabled", "isUseProguard", "isZipAlignEnabled", "files", "resValue", "seal", "setConsumerProguardFiles", "proguardFileIterable", "", "fallbacks", "([Ljava/lang/String;)V", "fallback", "setProguardFiles", "setTestProguardFiles", "shaderOptions", "testProguardFile", "testProguardFiles", "gradle-core"})
/*     */ public final class BuildTypeImpl extends SealableObject implements com.android.build.api.dsl.model.BuildType, com.android.build.api.dsl.model.VariantProperties, com.android.build.api.dsl.model.BuildTypeOrProductFlavor, com.android.build.api.dsl.model.BuildTypeOrVariant, com.android.build.api.dsl.model.FallbackStrategy
/*     */ {
/*     */   private boolean crunchPngsDefault;
/*     */   private final String named;
/*     */   private final VariantPropertiesImpl variantProperties;
/*     */   private final BuildTypeOrProductFlavorImpl buildTypeOrProductFlavor;
/*     */   @NotNull
/*     */   private final BuildTypeOrVariantImpl buildTypeOrVariant;
/*     */   private final FallbackStrategyImpl fallbackStrategy;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   
/*     */   @NotNull
/*     */   public final BuildTypeOrVariantImpl getBuildTypeOrVariant$gradle_core()
/*     */   {
/*  33 */     return buildTypeOrVariant;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getName()
/*     */   {
/*  44 */     return named;
/*     */   }
/*     */   
/*     */   public BuildTypeImpl(@NotNull String named, @NotNull VariantPropertiesImpl variantProperties, @NotNull BuildTypeOrProductFlavorImpl buildTypeOrProductFlavor, @NotNull BuildTypeOrVariantImpl buildTypeOrVariant, @NotNull FallbackStrategyImpl fallbackStrategy, @NotNull DeprecationReporter deprecationReporter, @NotNull com.android.builder.errors.EvalIssueReporter issueReporter)
/*     */   {
/*  37 */     super(issueReporter);this.named = named;this.variantProperties = variantProperties;this.buildTypeOrProductFlavor = buildTypeOrProductFlavor;this.buildTypeOrVariant = buildTypeOrVariant;this.fallbackStrategy = fallbackStrategy;this.deprecationReporter = deprecationReporter;
/*     */     
/*  47 */     crunchPngsDefault = (Intrinsics.areEqual(getName(), "debug") ^ true); }
/*     */   
/*  49 */   public boolean getCrunchPngsDefault() { deprecationReporter.reportObsoleteUsage(
/*  50 */       "BuildType.crunchPngsDefault", 
/*  51 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/*  52 */     return crunchPngsDefault;
/*     */   }
/*     */   
/*  55 */   public void setCrunchPngsDefault(boolean value) { deprecationReporter.reportObsoleteUsage(
/*  56 */       "BuildType.crunchPngsDefault", 
/*  57 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/*  58 */     if (checkSeal()) {
/*  59 */       crunchPngsDefault = value;
/*     */     }
/*     */   }
/*     */   
/*     */   public void seal()
/*     */   {
/*  76 */     super.seal();
/*     */     
/*  78 */     variantProperties.seal();
/*  79 */     buildTypeOrProductFlavor.seal();
/*  80 */     buildTypeOrVariant.seal();
/*  81 */     fallbackStrategy.seal();
/*     */   }
/*     */   
/*     */   public boolean isCrunchPngs()
/*     */   {
/*  88 */     deprecationReporter.reportDeprecatedUsage(
/*  89 */       "BuildType.crunchPngs", 
/*  90 */       "BuildType.isCrunchPngs", 
/*  91 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/*  92 */     return getCrunchPngs();
/*     */   }
/*     */   
/*     */   public boolean getMinifyEnabled()
/*     */   {
/*  98 */     deprecationReporter.reportDeprecatedUsage(
/*  99 */       "PostProcessingOptions", 
/* 100 */       "BuildType.minifyEnabled", 
/* 101 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 102 */     return (getPostProcessing().isObfuscate()) || (getPostProcessing().isRemoveUnusedCode());
/*     */   }
/*     */   
/* 105 */   public void setMinifyEnabled(boolean value) { deprecationReporter.reportDeprecatedUsage(
/* 106 */       "PostProcessingOptions", 
/* 107 */       "BuildType.minifyEnabled", 
/* 108 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 109 */     getPostProcessing().setObfuscate(true);
/* 110 */     getPostProcessing().setRemoveUnusedCode(true);
/*     */   }
/*     */   
/*     */   public boolean isMinifiedEnabled()
/*     */   {
/* 115 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public boolean getShrinkResources()
/*     */   {
/* 120 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public boolean isShrinkResources()
/*     */   {
/* 125 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Boolean getUseProguard() {
/* 130 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   @Nullable
/* 134 */   public Boolean isUseProguard() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public boolean isCrunchPngsDefault()
/*     */   {
/* 139 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void initWith(@NotNull com.android.build.api.dsl.model.BuildType that)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 62
/*     */     //   3: invokestatic 68	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_1
/*     */     //   7: dup
/*     */     //   8: instanceof 2
/*     */     //   11: ifne +5 -> 16
/*     */     //   14: pop
/*     */     //   15: aconst_null
/*     */     //   16: checkcast 2	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl
/*     */     //   19: dup
/*     */     //   20: ifnull +6 -> 26
/*     */     //   23: goto +17 -> 40
/*     */     //   26: pop
/*     */     //   27: new 70	java/lang/IllegalArgumentException
/*     */     //   30: dup
/*     */     //   31: ldc 72
/*     */     //   33: invokespecial 76	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
/*     */     //   36: checkcast 78	java/lang/Throwable
/*     */     //   39: athrow
/*     */     //   40: astore_2
/*     */     //   41: aload_0
/*     */     //   42: invokevirtual 54	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:checkSeal	()Z
/*     */     //   45: ifeq +47 -> 92
/*     */     //   48: aload_0
/*     */     //   49: getfield 82	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:variantProperties	Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;
/*     */     //   52: aload_2
/*     */     //   53: getfield 82	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:variantProperties	Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;
/*     */     //   56: invokevirtual 87	com/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl:initWith	(Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;)V
/*     */     //   59: aload_0
/*     */     //   60: getfield 91	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:buildTypeOrProductFlavor	Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;
/*     */     //   63: aload_2
/*     */     //   64: getfield 91	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:buildTypeOrProductFlavor	Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;
/*     */     //   67: invokevirtual 96	com/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl:initWith	(Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;)V
/*     */     //   70: aload_0
/*     */     //   71: getfield 100	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:buildTypeOrVariant	Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;
/*     */     //   74: aload_2
/*     */     //   75: getfield 100	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:buildTypeOrVariant	Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;
/*     */     //   78: invokevirtual 106	com/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl:initWith$gradle_core	(Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;)V
/*     */     //   81: aload_0
/*     */     //   82: getfield 110	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:fallbackStrategy	Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;
/*     */     //   85: aload_2
/*     */     //   86: getfield 110	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:fallbackStrategy	Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;
/*     */     //   89: invokevirtual 115	com/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl:initWith$gradle_core	(Lcom/android/build/gradle/internal/api/dsl/model/FallbackStrategyImpl;)V
/*     */     //   92: return
/*     */     // Line number table:
/*     */     //   Java source line #64	-> byte code offset #6
/*     */     //   Java source line #65	-> byte code offset #27
/*     */     //   Java source line #64	-> byte code offset #40
/*     */     //   Java source line #67	-> byte code offset #41
/*     */     //   Java source line #68	-> byte code offset #48
/*     */     //   Java source line #69	-> byte code offset #59
/*     */     //   Java source line #70	-> byte code offset #70
/*     */     //   Java source line #71	-> byte code offset #81
/*     */     //   Java source line #73	-> byte code offset #92
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	93	0	this	BuildTypeImpl
/*     */     //   0	93	1	that	com.android.build.api.dsl.model.BuildType
/*     */     //   41	52	2	buildType	BuildTypeImpl
/*     */   }
/*     */   
/*     */   public void setShrinkResources(boolean value) {}
/*     */   
/*     */   @NotNull
/*     */   public List<TypedValue> getBuildConfigFields()
/*     */   {
/*     */     return variantProperties.getBuildConfigFields();
/*     */   }
/*     */   
/*     */   public void setBuildConfigFields(@NotNull List<TypedValue> <set-?>)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     variantProperties.setBuildConfigFields(<set-?>);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public com.android.build.api.dsl.options.ExternalNativeBuildOptions getExternalNativeBuildOptions()
/*     */   {
/*     */     return variantProperties.getExternalNativeBuildOptions();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public com.android.build.api.dsl.options.JavaCompileOptions getJavaCompileOptions()
/*     */   {
/*     */     return variantProperties.getJavaCompileOptions();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Map<String, Object> getManifestPlaceholders()
/*     */   {
/*     */     return variantProperties.getManifestPlaceholders();
/*     */   }
/*     */   
/*     */   public void setManifestPlaceholders(@NotNull Map<String, Object> <set-?>)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     variantProperties.setManifestPlaceholders(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Boolean getMultiDexEnabled()
/*     */   {
/*     */     return variantProperties.getMultiDexEnabled();
/*     */   }
/*     */   
/*     */   public void setMultiDexEnabled(@Nullable Boolean <set-?>)
/*     */   {
/*     */     variantProperties.setMultiDexEnabled(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public File getMultiDexKeepFile()
/*     */   {
/*     */     return variantProperties.getMultiDexKeepFile();
/*     */   }
/*     */   
/*     */   public void setMultiDexKeepFile(@Nullable File <set-?>)
/*     */   {
/*     */     variantProperties.setMultiDexKeepFile(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public File getMultiDexKeepProguard()
/*     */   {
/*     */     return variantProperties.getMultiDexKeepProguard();
/*     */   }
/*     */   
/*     */   public void setMultiDexKeepProguard(@Nullable File <set-?>)
/*     */   {
/*     */     variantProperties.setMultiDexKeepProguard(<set-?>);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public com.android.build.api.dsl.options.NdkOptions getNdkOptions()
/*     */   {
/*     */     return variantProperties.getNdkOptions();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public List<TypedValue> getResValues()
/*     */   {
/*     */     return variantProperties.getResValues();
/*     */   }
/*     */   
/*     */   public void setResValues(@NotNull List<TypedValue> <set-?>)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     variantProperties.setResValues(<set-?>);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public com.android.build.api.dsl.options.ShaderOptions getShaders()
/*     */   {
/*     */     return variantProperties.getShaders();
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public com.android.build.api.dsl.options.SigningConfig getSigningConfig()
/*     */   {
/*     */     return variantProperties.getSigningConfig();
/*     */   }
/*     */   
/*     */   public void setSigningConfig(@Nullable com.android.build.api.dsl.options.SigningConfig <set-?>)
/*     */   {
/*     */     variantProperties.setSigningConfig(<set-?>);
/*     */   }
/*     */   
/*     */   public void buildConfigField(@NotNull String type, @NotNull String name, @NotNull String value)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(type, "type");
/*     */     Intrinsics.checkParameterIsNotNull(name, "name");
/*     */     Intrinsics.checkParameterIsNotNull(value, "value");
/*     */     variantProperties.buildConfigField(type, name, value);
/*     */   }
/*     */   
/*     */   public void externalNativeBuild(@NotNull Action<com.android.build.api.dsl.options.ExternalNativeBuildOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     variantProperties.externalNativeBuild(action);
/*     */   }
/*     */   
/*     */   public void externalNativeBuildOptions(@NotNull Action<com.android.build.api.dsl.options.ExternalNativeBuildOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     variantProperties.externalNativeBuildOptions(action);
/*     */   }
/*     */   
/*     */   public void javaCompileOptions(@NotNull Action<com.android.build.api.dsl.options.JavaCompileOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     variantProperties.javaCompileOptions(action);
/*     */   }
/*     */   
/*     */   public void ndkOptions(@NotNull Action<com.android.build.api.dsl.options.NdkOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     variantProperties.ndkOptions(action);
/*     */   }
/*     */   
/*     */   public void resValue(@NotNull String type, @NotNull String name, @NotNull String value)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(type, "type");
/*     */     Intrinsics.checkParameterIsNotNull(name, "name");
/*     */     Intrinsics.checkParameterIsNotNull(value, "value");
/*     */     variantProperties.resValue(type, name, value);
/*     */   }
/*     */   
/*     */   public void shaderOptions(@NotNull Action<com.android.build.api.dsl.options.ShaderOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     variantProperties.shaderOptions(action);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getApplicationIdSuffix()
/*     */   {
/*     */     return buildTypeOrProductFlavor.getApplicationIdSuffix();
/*     */   }
/*     */   
/*     */   public void setApplicationIdSuffix(@Nullable String <set-?>)
/*     */   {
/*     */     buildTypeOrProductFlavor.setApplicationIdSuffix(<set-?>);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getVersionNameSuffix()
/*     */   {
/*     */     return buildTypeOrProductFlavor.getVersionNameSuffix();
/*     */   }
/*     */   
/*     */   public void setVersionNameSuffix(@Nullable String <set-?>)
/*     */   {
/*     */     buildTypeOrProductFlavor.setVersionNameSuffix(<set-?>);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void consumerProguardFile(@NotNull Object proguardFile)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*     */     buildTypeOrProductFlavor.consumerProguardFile(proguardFile);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void consumerProguardFiles(@NotNull Object... proguardFiles)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");
/*     */     buildTypeOrProductFlavor.consumerProguardFiles(proguardFiles);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void proguardFile(@NotNull Object proguardFile)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*     */     buildTypeOrProductFlavor.proguardFile(proguardFile);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void proguardFiles(@NotNull Object... files)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(files, "files");
/*     */     buildTypeOrProductFlavor.proguardFiles(files);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void setConsumerProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");
/*     */     buildTypeOrProductFlavor.setConsumerProguardFiles(proguardFileIterable);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void setProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");
/*     */     buildTypeOrProductFlavor.setProguardFiles(proguardFileIterable);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void setTestProguardFiles(@NotNull Iterable<? extends Object> files)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(files, "files");
/*     */     buildTypeOrProductFlavor.setTestProguardFiles(files);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void testProguardFile(@NotNull Object proguardFile)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*     */     buildTypeOrProductFlavor.testProguardFile(proguardFile);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use postprocessingOptions")
/*     */   public void testProguardFiles(@NotNull Object... proguardFiles)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");
/*     */     buildTypeOrProductFlavor.testProguardFiles(proguardFiles);
/*     */   }
/*     */   
/*     */   public boolean getCrunchPngs()
/*     */   {
/*     */     return buildTypeOrVariant.getCrunchPngs();
/*     */   }
/*     */   
/*     */   public void setCrunchPngs(boolean <set-?>)
/*     */   {
/*     */     buildTypeOrVariant.setCrunchPngs(<set-?>);
/*     */   }
/*     */   
/*     */   public boolean getDebuggable()
/*     */   {
/*     */     return buildTypeOrVariant.getDebuggable();
/*     */   }
/*     */   
/*     */   public void setDebuggable(boolean <set-?>)
/*     */   {
/*     */     buildTypeOrVariant.setDebuggable(<set-?>);
/*     */   }
/*     */   
/*     */   public boolean getEmbedMicroApp()
/*     */   {
/*     */     return buildTypeOrVariant.getEmbedMicroApp();
/*     */   }
/*     */   
/*     */   public void setEmbedMicroApp(boolean <set-?>)
/*     */   {
/*     */     buildTypeOrVariant.setEmbedMicroApp(<set-?>);
/*     */   }
/*     */   
/*     */   public boolean getJniDebuggable()
/*     */   {
/*     */     return buildTypeOrVariant.getJniDebuggable();
/*     */   }
/*     */   
/*     */   public void setJniDebuggable(boolean <set-?>)
/*     */   {
/*     */     buildTypeOrVariant.setJniDebuggable(<set-?>);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public PostProcessingOptions getPostProcessing()
/*     */   {
/*     */     return buildTypeOrVariant.getPostProcessing();
/*     */   }
/*     */   
/*     */   public boolean getPseudoLocalesEnabled()
/*     */   {
/*     */     return buildTypeOrVariant.getPseudoLocalesEnabled();
/*     */   }
/*     */   
/*     */   public void setPseudoLocalesEnabled(boolean <set-?>)
/*     */   {
/*     */     buildTypeOrVariant.setPseudoLocalesEnabled(<set-?>);
/*     */   }
/*     */   
/*     */   public boolean getRenderscriptDebuggable()
/*     */   {
/*     */     return buildTypeOrVariant.getRenderscriptDebuggable();
/*     */   }
/*     */   
/*     */   public void setRenderscriptDebuggable(boolean <set-?>)
/*     */   {
/*     */     buildTypeOrVariant.setRenderscriptDebuggable(<set-?>);
/*     */   }
/*     */   
/*     */   public int getRenderscriptOptimLevel()
/*     */   {
/*     */     return buildTypeOrVariant.getRenderscriptOptimLevel();
/*     */   }
/*     */   
/*     */   public void setRenderscriptOptimLevel(int <set-?>)
/*     */   {
/*     */     buildTypeOrVariant.setRenderscriptOptimLevel(<set-?>);
/*     */   }
/*     */   
/*     */   public boolean getTestCoverageEnabled()
/*     */   {
/*     */     return buildTypeOrVariant.getTestCoverageEnabled();
/*     */   }
/*     */   
/*     */   public void setTestCoverageEnabled(boolean <set-?>)
/*     */   {
/*     */     buildTypeOrVariant.setTestCoverageEnabled(<set-?>);
/*     */   }
/*     */   
/*     */   public boolean getZipAlignEnabled()
/*     */   {
/*     */     return buildTypeOrVariant.getZipAlignEnabled();
/*     */   }
/*     */   
/*     */   public void setZipAlignEnabled(boolean <set-?>)
/*     */   {
/*     */     buildTypeOrVariant.setZipAlignEnabled(<set-?>);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use property debuggable")
/*     */   public boolean isDebuggable()
/*     */   {
/*     */     return buildTypeOrVariant.isDebuggable();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use property embedMicroApp")
/*     */   public boolean isEmbedMicroApp()
/*     */   {
/*     */     return buildTypeOrVariant.isEmbedMicroApp();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use property jniDebuggable")
/*     */   public boolean isJniDebuggable()
/*     */   {
/*     */     return buildTypeOrVariant.isJniDebuggable();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use property pseudoLocalesEnabled")
/*     */   public boolean isPseudoLocalesEnabled()
/*     */   {
/*     */     return buildTypeOrVariant.isPseudoLocalesEnabled();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use property renderscriptDebuggable")
/*     */   public boolean isRenderscriptDebuggable()
/*     */   {
/*     */     return buildTypeOrVariant.isRenderscriptDebuggable();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use property testCoverageEnabled")
/*     */   public boolean isTestCoverageEnabled()
/*     */   {
/*     */     return buildTypeOrVariant.isTestCoverageEnabled();
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use property zipAlignEnabled")
/*     */   public boolean isZipAlignEnabled()
/*     */   {
/*     */     return buildTypeOrVariant.isZipAlignEnabled();
/*     */   }
/*     */   
/*     */   public void postProcessing(@NotNull Action<PostProcessingOptions> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     buildTypeOrVariant.postProcessing(action);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public List<String> getMatchingFallbacks()
/*     */   {
/*     */     return fallbackStrategy.getMatchingFallbacks();
/*     */   }
/*     */   
/*     */   public void setMatchingFallbacks(@NotNull List<String> <set-?>)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*     */     fallbackStrategy.setMatchingFallbacks(<set-?>);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use matchingFallbacks property")
/*     */   public void setMatchingFallbacks(@NotNull String... fallbacks)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(fallbacks, "fallbacks");
/*     */     fallbackStrategy.setMatchingFallbacks(fallbacks);
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   @Deprecated(message="Use matchingFallbacks property")
/*     */   public void setMatchingFallbacks(@NotNull String fallback)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(fallback, "fallback");
/*     */     fallbackStrategy.setMatchingFallbacks(fallback);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.BuildTypeImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */