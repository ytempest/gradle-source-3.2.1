/*    */ package com.android.build.gradle.internal.variant2;
/*    */ 
/*    */ import com.android.build.api.dsl.ApiVersion;
/*    */ import com.android.build.api.dsl.model.TypedValue;
/*    */ import com.android.build.api.dsl.variant.Variant;
/*    */ import com.android.build.api.sourcesets.AndroidSourceSet;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.VariantOrExtensionPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.model.BuildTypeOrVariantImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.model.ProductFlavorOrVariantImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.model.VariantPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*    */ import com.android.build.gradle.internal.api.dsl.variant.CommonVariantPropertiesImpl;
/*    */ import com.android.builder.core.VariantType;
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import kotlin.Deprecated;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000¢\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\005\n\002\020 \n\002\030\002\n\002\b\003\n\002\020!\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\020%\n\002\020\000\n\002\b\005\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\r\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b \n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\013\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\013\n\002\020\002\n\000\n\002\030\002\n\002\b\021\030\0002\0020\0012\0020\0022\0020\0032\0020\0042\0020\0052\0020\0062\0020\0072\0020\bBE\022\006\020\t\032\0020\n\022\006\020\013\032\0020\f\022\006\020\r\032\0020\016\022\006\020\017\032\0020\020\022\006\020\021\032\0020\022\022\006\020\023\032\0020\024\022\006\020\025\032\0020\026\022\006\020\027\032\0020\030¢\006\002\020\031J\032\020\032\032\0030Î\0012\016\020Ï\001\032\t\022\004\022\0020\0330Ð\001H\001J&\020Ñ\001\032\0030Î\0012\007\020Ò\001\032\0020\0372\007\020\001\032\0020\0372\007\020Ó\001\032\0020\037H\001J\032\0201\032\0030Î\0012\016\020Ï\001\032\t\022\004\022\002020Ð\001H\001J\n\020Ô\001\032\0030º\001H\026J\032\020;\032\0030Î\0012\016\020Ï\001\032\t\022\004\022\0020<0Ð\001H\001J\032\020B\032\0030Î\0012\016\020Ï\001\032\t\022\004\022\0020C0Ð\001H\001J\033\020Õ\001\032\0030Î\0012\016\020Ï\001\032\t\022\004\022\0020J0Ð\001H\001J\032\020I\032\0030Î\0012\016\020Ï\001\032\t\022\004\022\0020J0Ð\001H\001J\032\020O\032\0030Î\0012\016\020Ï\001\032\t\022\004\022\0020P0Ð\001H\001J\n\020Ö\001\032\00206H\001J\n\020×\001\032\00206H\001J\n\020Ø\001\032\00206H\001J\n\020Ù\001\032\00206H\001J\n\020Ú\001\032\00206H\001J\n\020Û\001\032\00206H\001J\n\020Ü\001\032\00206H\001J\032\020S\032\0030Î\0012\016\020Ï\001\032\t\022\004\022\0020T0Ð\001H\001J\032\020Z\032\0030Î\0012\016\020Ï\001\032\t\022\004\022\0020[0Ð\001H\001J\022\020k\032\0030Î\0012\006\020k\032\0020fH\001J\022\020k\032\0030Î\0012\006\020k\032\0020\037H\001J\032\020\032\0030Î\0012\016\020Ï\001\032\t\022\004\022\0020&0Ð\001H\001J\034\020\001\032\0030Î\0012\017\020Ï\001\032\n\022\005\022\0030\0010Ð\001H\001J\034\020\001\032\0030Î\0012\017\020Ï\001\032\n\022\005\022\0030\0010Ð\001H\001J&\020Ý\001\032\0030Î\0012\007\020Ò\001\032\0020\0372\007\020\001\032\0020\0372\007\020Ó\001\032\0020\037H\001J\n\020Þ\001\032\0030Î\001H\026J\022\020o\032\0030Î\0012\006\020k\032\0020fH\001J\022\020o\032\0030Î\0012\006\020k\032\0020\037H\001J\024\020µ\001\032\0030Î\0012\007\020³\001\032\0020fH\001J\024\020µ\001\032\0030Î\0012\007\020³\001\032\0020\037H\001J\034\020ß\001\032\0030Î\0012\017\020Ï\001\032\n\022\005\022\0030ª\0010Ð\001H\001J\024\020³\001\032\0030Î\0012\007\020³\001\032\0020fH\001J\024\020³\001\032\0030Î\0012\007\020³\001\032\0020\037H\001J\t\020à\001\032\0020\037H\026J\033\020½\001\032\0030Î\0012\016\020Ï\001\032\t\022\004\022\0020&0Ð\001H\001J\034\020Á\001\032\0030Î\0012\017\020Ï\001\032\n\022\005\022\0030Â\0010Ð\001H\001R\022\020\032\032\0020\033X\005¢\006\006\032\004\b\034\020\035R\032\020\036\032\004\030\0010\037X\017¢\006\f\032\004\b \020!\"\004\b\"\020#R\030\020$\032\b\022\004\022\0020&0%X\005¢\006\006\032\004\b'\020(R\036\020)\032\b\022\004\022\0020+0*X\017¢\006\f\032\004\b,\020(\"\004\b-\020.R\022\020/\032\0020\037X\005¢\006\006\032\004\b0\020!R\016\020\017\032\0020\020X\004¢\006\002\n\000R\022\0201\032\00202X\005¢\006\006\032\004\b3\0204R\030\0205\032\00206X\017¢\006\f\032\004\b7\0208\"\004\b9\020:R\022\020;\032\0020<X\005¢\006\006\032\004\b=\020>R\030\020?\032\00206X\017¢\006\f\032\004\b@\0208\"\004\bA\020:R\022\020B\032\0020CX\005¢\006\006\032\004\bD\020ER\030\020F\032\00206X\017¢\006\f\032\004\bG\0208\"\004\bH\020:R\022\020I\032\0020JX\005¢\006\006\032\004\bK\020LR\030\020M\032\b\022\004\022\0020\0370%X\005¢\006\006\032\004\bN\020(R\022\020O\032\0020PX\005¢\006\006\032\004\bQ\020RR\016\020\023\032\0020\024X\004¢\006\002\n\000R\022\020S\032\0020TX\005¢\006\006\032\004\bU\020VR\030\020W\032\00206X\017¢\006\f\032\004\bX\0208\"\004\bY\020:R\022\020Z\032\0020[X\005¢\006\006\032\004\b\\\020]R$\020^\032\016\022\004\022\0020\037\022\004\022\0020`0_X\017¢\006\f\032\004\ba\020b\"\004\bc\020dR\032\020e\032\004\030\0010fX\017¢\006\f\032\004\bg\020h\"\004\bi\020jR\032\020k\032\004\030\0010lX\017¢\006\f\032\004\bm\020n\"\004\bo\020pR\032\020q\032\004\030\00106X\017¢\006\f\032\004\br\020s\"\004\bt\020uR\032\020v\032\004\030\0010wX\017¢\006\f\032\004\bx\020y\"\004\bz\020{R\032\020|\032\004\030\0010wX\017¢\006\f\032\004\b}\020y\"\004\b~\020{R\026\020\032\004\030\0010&X\005¢\006\b\032\006\b\001\020\001R\024\020\001\032\0020\037X\005¢\006\007\032\005\b\001\020!R\026\020\001\032\0030\001X\005¢\006\b\032\006\b\001\020\001R\026\020\001\032\0030\001X\005¢\006\b\032\006\b\001\020\001R\016\020\r\032\0020\016X\004¢\006\002\n\000R\033\020\001\032\00206X\017¢\006\016\032\005\b\001\0208\"\005\b\001\020:R\033\020\001\032\00206X\017¢\006\016\032\005\b\001\0208\"\005\b\001\020:R\035\020\001\032\004\030\00106X\017¢\006\016\032\005\b\001\020s\"\005\b\001\020uR\035\020\001\032\0020fX\017¢\006\020\032\006\b\001\020\001\"\006\b\001\020\001R\035\020\001\032\004\030\00106X\017¢\006\016\032\005\b\001\020s\"\005\b\001\020uR\035\020\001\032\004\030\00106X\017¢\006\016\032\005\b\001\020s\"\005\b\001\020uR\035\020 \001\032\004\030\0010fX\017¢\006\016\032\005\b¡\001\020h\"\005\b¢\001\020jR!\020£\001\032\b\022\004\022\0020\0370*X\017¢\006\016\032\005\b¤\001\020(\"\005\b¥\001\020.R!\020¦\001\032\b\022\004\022\0020+0*X\017¢\006\016\032\005\b§\001\020(\"\005\b¨\001\020.R\026\020©\001\032\0030ª\001X\005¢\006\b\032\006\b«\001\020¬\001R \020­\001\032\005\030\0010®\001X\017¢\006\020\032\006\b¯\001\020°\001\"\006\b±\001\020²\001R\035\020³\001\032\004\030\0010lX\017¢\006\016\032\005\b´\001\020n\"\005\bµ\001\020pR\033\020¶\001\032\00206X\017¢\006\016\032\005\b·\001\0208\"\005\b¸\001\020:R\030\020¹\001\032\0030º\0018VX\004¢\006\b\032\006\b»\001\020¼\001R\016\020\025\032\0020\026X\004¢\006\002\n\000R\016\020\021\032\0020\022X\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\027\020½\001\032\004\030\0010&X\005¢\006\b\032\006\b¾\001\020\001R\026\020\t\032\0020\nX\004¢\006\n\n\000\032\006\b¿\001\020À\001R\026\020Á\001\032\0030Â\001X\005¢\006\b\032\006\bÃ\001\020Ä\001R\035\020Å\001\032\004\030\0010fX\017¢\006\016\032\005\bÆ\001\020h\"\005\bÇ\001\020jR\035\020È\001\032\004\030\0010\037X\017¢\006\016\032\005\bÉ\001\020!\"\005\bÊ\001\020#R\033\020Ë\001\032\00206X\017¢\006\016\032\005\bÌ\001\0208\"\005\bÍ\001\020:¨\006á\001"}, d2={"Lcom/android/build/gradle/internal/variant2/AndroidTestVariantImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/variant/AndroidTestVariant;", "Lcom/android/build/gradle/internal/api/dsl/variant/SealableVariant;", "Lcom/android/build/api/dsl/model/VariantProperties;", "Lcom/android/build/api/dsl/model/ProductFlavorOrVariant;", "Lcom/android/build/api/dsl/model/BuildTypeOrVariant;", "Lcom/android/build/api/dsl/extension/VariantOrExtensionProperties;", "Lcom/android/build/api/dsl/variant/CommonVariantProperties;", "variantType", "Lcom/android/builder/core/VariantType;", "variantProperties", "Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;", "productFlavorOrVariant", "Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;", "buildTypeOrVariant", "Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;", "variantExtensionProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "internalVariantProperties", "Lcom/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl;", "variantDispatcher", "Lcom/android/build/gradle/internal/variant2/VariantDispatcher;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/core/VariantType;Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl;Lcom/android/build/gradle/internal/variant2/VariantDispatcher;Lcom/android/builder/errors/EvalIssueReporter;)V", "aaptOptions", "Lcom/android/build/api/dsl/options/AaptOptions;", "getAaptOptions", "()Lcom/android/build/api/dsl/options/AaptOptions;", "applicationId", "", "getApplicationId", "()Ljava/lang/String;", "setApplicationId", "(Ljava/lang/String;)V", "baseSourceSets", "", "Lcom/android/build/api/sourcesets/AndroidSourceSet;", "getBaseSourceSets", "()Ljava/util/List;", "buildConfigFields", "", "Lcom/android/build/api/dsl/model/TypedValue;", "getBuildConfigFields", "setBuildConfigFields", "(Ljava/util/List;)V", "buildTypeName", "getBuildTypeName", "compileOptions", "Lcom/android/build/api/dsl/options/CompileOptions;", "getCompileOptions", "()Lcom/android/build/api/dsl/options/CompileOptions;", "crunchPngs", "", "getCrunchPngs", "()Z", "setCrunchPngs", "(Z)V", "dataBinding", "Lcom/android/builder/model/DataBindingOptions;", "getDataBinding", "()Lcom/android/builder/model/DataBindingOptions;", "debuggable", "getDebuggable", "setDebuggable", "dexOptions", "Lcom/android/build/api/dsl/options/DexOptions;", "getDexOptions", "()Lcom/android/build/api/dsl/options/DexOptions;", "embedMicroApp", "getEmbedMicroApp", "setEmbedMicroApp", "externalNativeBuildOptions", "Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "getExternalNativeBuildOptions", "()Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "flavorNames", "getFlavorNames", "instrumentationOptions", "Lcom/android/build/api/dsl/options/InstrumentationOptions;", "getInstrumentationOptions", "()Lcom/android/build/api/dsl/options/InstrumentationOptions;", "javaCompileOptions", "Lcom/android/build/api/dsl/options/JavaCompileOptions;", "getJavaCompileOptions", "()Lcom/android/build/api/dsl/options/JavaCompileOptions;", "jniDebuggable", "getJniDebuggable", "setJniDebuggable", "lintOptions", "Lcom/android/build/api/dsl/options/LintOptions;", "getLintOptions", "()Lcom/android/build/api/dsl/options/LintOptions;", "manifestPlaceholders", "", "", "getManifestPlaceholders", "()Ljava/util/Map;", "setManifestPlaceholders", "(Ljava/util/Map;)V", "maxSdkVersion", "", "getMaxSdkVersion", "()Ljava/lang/Integer;", "setMaxSdkVersion", "(Ljava/lang/Integer;)V", "minSdkVersion", "Lcom/android/build/api/dsl/ApiVersion;", "getMinSdkVersion", "()Lcom/android/build/api/dsl/ApiVersion;", "setMinSdkVersion", "(Lcom/android/build/api/dsl/ApiVersion;)V", "multiDexEnabled", "getMultiDexEnabled", "()Ljava/lang/Boolean;", "setMultiDexEnabled", "(Ljava/lang/Boolean;)V", "multiDexKeepFile", "Ljava/io/File;", "getMultiDexKeepFile", "()Ljava/io/File;", "setMultiDexKeepFile", "(Ljava/io/File;)V", "multiDexKeepProguard", "getMultiDexKeepProguard", "setMultiDexKeepProguard", "multiFlavorSourceSet", "getMultiFlavorSourceSet", "()Lcom/android/build/api/sourcesets/AndroidSourceSet;", "name", "getName", "ndkOptions", "Lcom/android/build/api/dsl/options/NdkOptions;", "getNdkOptions", "()Lcom/android/build/api/dsl/options/NdkOptions;", "postProcessing", "Lcom/android/build/api/dsl/options/PostProcessingOptions;", "getPostProcessing", "()Lcom/android/build/api/dsl/options/PostProcessingOptions;", "pseudoLocalesEnabled", "getPseudoLocalesEnabled", "setPseudoLocalesEnabled", "renderscriptDebuggable", "getRenderscriptDebuggable", "setRenderscriptDebuggable", "renderscriptNdkModeEnabled", "getRenderscriptNdkModeEnabled", "setRenderscriptNdkModeEnabled", "renderscriptOptimLevel", "getRenderscriptOptimLevel", "()I", "setRenderscriptOptimLevel", "(I)V", "renderscriptSupportModeBlasEnabled", "getRenderscriptSupportModeBlasEnabled", "setRenderscriptSupportModeBlasEnabled", "renderscriptSupportModeEnabled", "getRenderscriptSupportModeEnabled", "setRenderscriptSupportModeEnabled", "renderscriptTargetApi", "getRenderscriptTargetApi", "setRenderscriptTargetApi", "resConfigs", "getResConfigs", "setResConfigs", "resValues", "getResValues", "setResValues", "shaders", "Lcom/android/build/api/dsl/options/ShaderOptions;", "getShaders", "()Lcom/android/build/api/dsl/options/ShaderOptions;", "signingConfig", "Lcom/android/build/api/dsl/options/SigningConfig;", "getSigningConfig", "()Lcom/android/build/api/dsl/options/SigningConfig;", "setSigningConfig", "(Lcom/android/build/api/dsl/options/SigningConfig;)V", "targetSdkVersion", "getTargetSdkVersion", "setTargetSdkVersion", "testCoverageEnabled", "getTestCoverageEnabled", "setTestCoverageEnabled", "testedVariant", "Lcom/android/build/api/dsl/variant/Variant;", "getTestedVariant", "()Lcom/android/build/api/dsl/variant/Variant;", "variantSourceSet", "getVariantSourceSet", "getVariantType", "()Lcom/android/builder/core/VariantType;", "vectorDrawables", "Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "getVectorDrawables", "()Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "versionCode", "getVersionCode", "setVersionCode", "versionName", "getVersionName", "setVersionName", "zipAlignEnabled", "getZipAlignEnabled", "setZipAlignEnabled", "", "action", "Lorg/gradle/api/Action;", "buildConfigField", "type", "value", "createShim", "externalNativeBuild", "isDebuggable", "isEmbedMicroApp", "isJniDebuggable", "isPseudoLocalesEnabled", "isRenderscriptDebuggable", "isTestCoverageEnabled", "isZipAlignEnabled", "resValue", "seal", "shaderOptions", "toString", "gradle-core"})
/*    */ public final class AndroidTestVariantImpl extends SealableObject implements com.android.build.api.dsl.variant.AndroidTestVariant, com.android.build.gradle.internal.api.dsl.variant.SealableVariant, com.android.build.api.dsl.model.VariantProperties, com.android.build.api.dsl.model.ProductFlavorOrVariant, com.android.build.api.dsl.model.BuildTypeOrVariant, com.android.build.api.dsl.extension.VariantOrExtensionProperties, com.android.build.api.dsl.variant.CommonVariantProperties
/*    */ {
/*    */   @NotNull
/*    */   private final VariantType variantType;
/*    */   private final VariantPropertiesImpl variantProperties;
/*    */   private final ProductFlavorOrVariantImpl productFlavorOrVariant;
/*    */   private final BuildTypeOrVariantImpl buildTypeOrVariant;
/*    */   private final VariantOrExtensionPropertiesImpl variantExtensionProperties;
/*    */   private final CommonVariantPropertiesImpl internalVariantProperties;
/*    */   private final VariantDispatcher variantDispatcher;
/*    */   
/*    */   @NotNull
/*    */   public VariantType getVariantType()
/*    */   {
/* 38 */     return variantType;
/*    */   }
/*    */   
/*    */   public AndroidTestVariantImpl(@NotNull VariantType variantType, @NotNull VariantPropertiesImpl variantProperties, @NotNull ProductFlavorOrVariantImpl productFlavorOrVariant, @NotNull BuildTypeOrVariantImpl buildTypeOrVariant, @NotNull VariantOrExtensionPropertiesImpl variantExtensionProperties, @NotNull CommonVariantPropertiesImpl internalVariantProperties, @NotNull VariantDispatcher variantDispatcher, @NotNull com.android.builder.errors.EvalIssueReporter issueReporter)
/*    */   {
/* 46 */     super(issueReporter);this.variantType = variantType;this.variantProperties = variantProperties;this.productFlavorOrVariant = productFlavorOrVariant;this.buildTypeOrVariant = buildTypeOrVariant;this.variantExtensionProperties = variantExtensionProperties;this.internalVariantProperties = internalVariantProperties;this.variantDispatcher = variantDispatcher;
/*    */   }
/*    */   
/*    */   @NotNull
/* 56 */   public Variant getTestedVariant() { return variantDispatcher.getProductionVariant(); }
/*    */   @NotNull
/* 58 */   public Variant createShim() { return (Variant)new com.android.build.gradle.internal.api.dsl.variant.AndroidTestVariantShim(this); }
/*    */   
/*    */   public void seal() {
/* 61 */     super.seal();
/* 62 */     variantProperties.seal();
/* 63 */     productFlavorOrVariant.seal();
/* 64 */     buildTypeOrVariant.seal();
/* 65 */     variantExtensionProperties.seal();
/* 66 */     internalVariantProperties.seal();
/*    */   }
/*    */   
/*    */   @NotNull
/* 70 */   public String toString() { return getName(); }
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
/*    */   public com.android.build.api.dsl.options.ExternalNativeBuildOptions getExternalNativeBuildOptions()
/*    */   {
/*    */     return variantProperties.getExternalNativeBuildOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.JavaCompileOptions getJavaCompileOptions()
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
/*    */   public com.android.build.api.dsl.options.NdkOptions getNdkOptions()
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
/*    */   public com.android.build.api.dsl.options.SigningConfig getSigningConfig()
/*    */   {
/*    */     return variantProperties.getSigningConfig();
/*    */   }
/*    */   
/*    */   public void setSigningConfig(@Nullable com.android.build.api.dsl.options.SigningConfig <set-?>)
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
/*    */   public void externalNativeBuild(@NotNull Action<com.android.build.api.dsl.options.ExternalNativeBuildOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.externalNativeBuild(action);
/*    */   }
/*    */   
/*    */   public void externalNativeBuildOptions(@NotNull Action<com.android.build.api.dsl.options.ExternalNativeBuildOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.externalNativeBuildOptions(action);
/*    */   }
/*    */   
/*    */   public void javaCompileOptions(@NotNull Action<com.android.build.api.dsl.options.JavaCompileOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantProperties.javaCompileOptions(action);
/*    */   }
/*    */   
/*    */   public void ndkOptions(@NotNull Action<com.android.build.api.dsl.options.NdkOptions> action)
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
/*    */   public com.android.build.api.dsl.options.InstrumentationOptions getInstrumentationOptions()
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
/*    */   public void instrumentationOptions(@NotNull Action<com.android.build.api.dsl.options.InstrumentationOptions> action)
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
/*    */   public boolean getCrunchPngs()
/*    */   {
/*    */     return buildTypeOrVariant.getCrunchPngs();
/*    */   }
/*    */   
/*    */   public void setCrunchPngs(boolean <set-?>)
/*    */   {
/*    */     buildTypeOrVariant.setCrunchPngs(<set-?>);
/*    */   }
/*    */   
/*    */   public boolean getDebuggable()
/*    */   {
/*    */     return buildTypeOrVariant.getDebuggable();
/*    */   }
/*    */   
/*    */   public void setDebuggable(boolean <set-?>)
/*    */   {
/*    */     buildTypeOrVariant.setDebuggable(<set-?>);
/*    */   }
/*    */   
/*    */   public boolean getEmbedMicroApp()
/*    */   {
/*    */     return buildTypeOrVariant.getEmbedMicroApp();
/*    */   }
/*    */   
/*    */   public void setEmbedMicroApp(boolean <set-?>)
/*    */   {
/*    */     buildTypeOrVariant.setEmbedMicroApp(<set-?>);
/*    */   }
/*    */   
/*    */   public boolean getJniDebuggable()
/*    */   {
/*    */     return buildTypeOrVariant.getJniDebuggable();
/*    */   }
/*    */   
/*    */   public void setJniDebuggable(boolean <set-?>)
/*    */   {
/*    */     buildTypeOrVariant.setJniDebuggable(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.PostProcessingOptions getPostProcessing()
/*    */   {
/*    */     return buildTypeOrVariant.getPostProcessing();
/*    */   }
/*    */   
/*    */   public boolean getPseudoLocalesEnabled()
/*    */   {
/*    */     return buildTypeOrVariant.getPseudoLocalesEnabled();
/*    */   }
/*    */   
/*    */   public void setPseudoLocalesEnabled(boolean <set-?>)
/*    */   {
/*    */     buildTypeOrVariant.setPseudoLocalesEnabled(<set-?>);
/*    */   }
/*    */   
/*    */   public boolean getRenderscriptDebuggable()
/*    */   {
/*    */     return buildTypeOrVariant.getRenderscriptDebuggable();
/*    */   }
/*    */   
/*    */   public void setRenderscriptDebuggable(boolean <set-?>)
/*    */   {
/*    */     buildTypeOrVariant.setRenderscriptDebuggable(<set-?>);
/*    */   }
/*    */   
/*    */   public int getRenderscriptOptimLevel()
/*    */   {
/*    */     return buildTypeOrVariant.getRenderscriptOptimLevel();
/*    */   }
/*    */   
/*    */   public void setRenderscriptOptimLevel(int <set-?>)
/*    */   {
/*    */     buildTypeOrVariant.setRenderscriptOptimLevel(<set-?>);
/*    */   }
/*    */   
/*    */   public boolean getTestCoverageEnabled()
/*    */   {
/*    */     return buildTypeOrVariant.getTestCoverageEnabled();
/*    */   }
/*    */   
/*    */   public void setTestCoverageEnabled(boolean <set-?>)
/*    */   {
/*    */     buildTypeOrVariant.setTestCoverageEnabled(<set-?>);
/*    */   }
/*    */   
/*    */   public boolean getZipAlignEnabled()
/*    */   {
/*    */     return buildTypeOrVariant.getZipAlignEnabled();
/*    */   }
/*    */   
/*    */   public void setZipAlignEnabled(boolean <set-?>)
/*    */   {
/*    */     buildTypeOrVariant.setZipAlignEnabled(<set-?>);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use property debuggable")
/*    */   public boolean isDebuggable()
/*    */   {
/*    */     return buildTypeOrVariant.isDebuggable();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use property embedMicroApp")
/*    */   public boolean isEmbedMicroApp()
/*    */   {
/*    */     return buildTypeOrVariant.isEmbedMicroApp();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use property jniDebuggable")
/*    */   public boolean isJniDebuggable()
/*    */   {
/*    */     return buildTypeOrVariant.isJniDebuggable();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use property pseudoLocalesEnabled")
/*    */   public boolean isPseudoLocalesEnabled()
/*    */   {
/*    */     return buildTypeOrVariant.isPseudoLocalesEnabled();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use property renderscriptDebuggable")
/*    */   public boolean isRenderscriptDebuggable()
/*    */   {
/*    */     return buildTypeOrVariant.isRenderscriptDebuggable();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use property testCoverageEnabled")
/*    */   public boolean isTestCoverageEnabled()
/*    */   {
/*    */     return buildTypeOrVariant.isTestCoverageEnabled();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use property zipAlignEnabled")
/*    */   public boolean isZipAlignEnabled()
/*    */   {
/*    */     return buildTypeOrVariant.isZipAlignEnabled();
/*    */   }
/*    */   
/*    */   public void postProcessing(@NotNull Action<com.android.build.api.dsl.options.PostProcessingOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     buildTypeOrVariant.postProcessing(action);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.AaptOptions getAaptOptions()
/*    */   {
/*    */     return variantExtensionProperties.getAaptOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.CompileOptions getCompileOptions()
/*    */   {
/*    */     return variantExtensionProperties.getCompileOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.builder.model.DataBindingOptions getDataBinding()
/*    */   {
/*    */     return variantExtensionProperties.getDataBinding();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.DexOptions getDexOptions()
/*    */   {
/*    */     return variantExtensionProperties.getDexOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.LintOptions getLintOptions()
/*    */   {
/*    */     return variantExtensionProperties.getLintOptions();
/*    */   }
/*    */   
/*    */   public void aaptOptions(@NotNull Action<com.android.build.api.dsl.options.AaptOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantExtensionProperties.aaptOptions(action);
/*    */   }
/*    */   
/*    */   public void compileOptions(@NotNull Action<com.android.build.api.dsl.options.CompileOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantExtensionProperties.compileOptions(action);
/*    */   }
/*    */   
/*    */   public void dataBinding(@NotNull Action<com.android.builder.model.DataBindingOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantExtensionProperties.dataBinding(action);
/*    */   }
/*    */   
/*    */   public void dexOptions(@NotNull Action<com.android.build.api.dsl.options.DexOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantExtensionProperties.dexOptions(action);
/*    */   }
/*    */   
/*    */   public void lintOptions(@NotNull Action<com.android.build.api.dsl.options.LintOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantExtensionProperties.lintOptions(action);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<AndroidSourceSet> getBaseSourceSets()
/*    */   {
/*    */     return internalVariantProperties.getBaseSourceSets();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String getBuildTypeName()
/*    */   {
/*    */     return internalVariantProperties.getBuildTypeName();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<String> getFlavorNames()
/*    */   {
/*    */     return internalVariantProperties.getFlavorNames();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public AndroidSourceSet getMultiFlavorSourceSet()
/*    */   {
/*    */     return (AndroidSourceSet)internalVariantProperties.getMultiFlavorSourceSet();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String getName()
/*    */   {
/*    */     return internalVariantProperties.getName();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public AndroidSourceSet getVariantSourceSet()
/*    */   {
/*    */     return (AndroidSourceSet)internalVariantProperties.getVariantSourceSet();
/*    */   }
/*    */   
/*    */   public void multiFlavorSourceSet(@NotNull Action<AndroidSourceSet> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     internalVariantProperties.multiFlavorSourceSet(action);
/*    */   }
/*    */   
/*    */   public void variantSourceSet(@NotNull Action<AndroidSourceSet> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     internalVariantProperties.variantSourceSet(action);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.AndroidTestVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */