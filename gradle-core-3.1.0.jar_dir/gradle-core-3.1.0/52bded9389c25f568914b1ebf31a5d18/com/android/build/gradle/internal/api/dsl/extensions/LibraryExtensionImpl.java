/*    */ package com.android.build.gradle.internal.api.dsl.extensions;
/*    */ 
/*    */ import com.android.build.api.dsl.ApiVersion;
/*    */ import java.io.File;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import kotlin.Deprecated;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000¨\003\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\036\n\002\020\016\n\002\b\016\n\002\020!\n\002\030\002\n\002\b\b\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\t\n\002\020\"\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020%\n\002\020\000\n\002\b\005\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\027\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\022\n\002\020$\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020 \n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\016\n\002\020\002\n\002\b\b\n\002\020\021\n\002\b\023\n\002\020\034\n\002\b\022\030\0002\0020\0012\0020\0022\0020\0032\0020\0042\0020\0052\0020\0062\0020\0072\0020\bB5\022\006\020\t\032\0020\n\022\006\020\013\032\0020\f\022\006\020\r\032\0020\016\022\006\020\017\032\0020\020\022\006\020\021\032\0020\022\022\006\020\023\032\0020\024¢\006\002\020\025J\032\020\026\032\0030\0022\016\020\002\032\t\022\004\022\0020\0270£\001H\001J\032\020\032\032\0030\0022\016\020\002\032\t\022\004\022\0020\0330£\001H\001J%\020\002\032\0030\0022\007\020\002\032\0020 2\007\020\002\032\0020 2\006\020\036\032\0020 H\001J \0208\032\0030\0022\024\020\002\032\017\022\n\022\b\022\004\022\0020:090£\001H\001J\032\020=\032\0030\0022\016\020\002\032\t\022\004\022\0020>0£\001H\001J\024\020\002\032\0030\0022\007\020\002\032\0020sH\001J'\020\002\032\0030\0022\024\020\002\032\013\022\006\b\001\022\0020s0\002\"\0020sH\001¢\006\003\020 \002J\032\020D\032\0030\0022\016\020\002\032\t\022\004\022\0020E0£\001H\001J\032\020H\032\0030\0022\016\020\002\032\t\022\004\022\0020I0£\001H\001J\032\020S\032\0030\0022\016\020\002\032\t\022\004\022\0020T0£\001H\001J\033\020¡\002\032\0030\0022\016\020\002\032\t\022\004\022\0020X0£\001H\001J\032\020W\032\0030\0022\016\020\002\032\t\022\004\022\0020X0£\001H\001J\032\020e\032\0030\0022\016\020\002\032\t\022\004\022\0020f0£\001H\001J\032\020i\032\0030\0022\016\020\002\032\t\022\004\022\0020j0£\001H\001J\032\020m\032\0030\0022\016\020\002\032\t\022\004\022\0020n0£\001H\001J\022\020~\032\0030\0022\006\020~\032\0020yH\001J\022\020~\032\0030\0022\006\020~\032\0020 H\001J0\020¢\002\032\0030\0022\007\020£\002\032\0020 2\024\020¤\002\032\013\022\006\b\001\022\0020 0\002\"\0020 H\001¢\006\003\020¥\002J\035\020¢\002\032\0030\0022\007\020£\002\032\0020 2\007\020¦\002\032\0020 H\001J$\020¢\002\032\0030\0022\007\020£\002\032\0020 2\016\020¤\002\032\t\022\004\022\0020 0ô\001H\001J\034\020\001\032\0030\0022\017\020\002\032\n\022\005\022\0030\0010£\001H\001J\034\020\001\032\0030\0022\017\020\002\032\n\022\005\022\0030\0010£\001H\001J\"\020§\002\032\0030\0022\025\020\002\032\020\022\013\022\t\022\005\022\0030¤\0010\0370£\001H\001J\034\020¨\002\032\0030\0022\017\020\002\032\n\022\005\022\0030¨\0010£\001H\001J\"\020«\001\032\0030\0022\025\020\002\032\020\022\013\022\t\022\005\022\0030¬\001090£\001H\001J\024\020\002\032\0030\0022\007\020\002\032\0020sH\001J'\020\002\032\0030\0022\024\020©\002\032\013\022\006\b\001\022\0020s0\002\"\0020sH\001¢\006\003\020 \002J\025\020ª\002\032\0030\0022\b\020«\002\032\0030õ\001H\001J1\020ª\002\032\0030\0022\b\020«\002\032\0030õ\0012\024\020¬\002\032\013\022\006\b\001\022\0020s0\002\"\0020sH\001¢\006\003\020­\002J%\020®\002\032\0030\0022\007\020\002\032\0020 2\007\020\002\032\0020 2\006\020\036\032\0020 H\001J\n\020¯\002\032\0030\002H\026J\023\020C\032\0030\0022\007\020°\002\032\0020yH\001J\033\020±\002\032\0030\0022\016\020²\002\032\t\022\004\022\0020s0³\002H\001J\035\020´\002\032\0030\0022\020\020µ\002\032\013\022\004\022\0020 \030\0010³\002H\001J\023\020\001\032\0030\0022\006\020~\032\0020yH\001J\023\020\001\032\0030\0022\006\020~\032\0020 H\001J\033\020¶\002\032\0030\0022\016\020²\002\032\t\022\004\022\0020s0³\002H\001J\024\020Ô\001\032\0030\0022\007\020Ò\001\032\0020yH\001J\024\020Ô\001\032\0030\0022\007\020Ò\001\032\0020 H\001J\025\020·\002\032\0030\0022\b\020¸\002\032\0030\001H\001J\025\020¹\002\032\0030\0022\b\020º\002\032\0030\001H\001J\033\020»\002\032\0030\0022\016\020©\002\032\t\022\004\022\0020s0³\002H\001J\034\020¼\002\032\0030\0022\017\020\002\032\n\022\005\022\0030Ä\0010£\001H\001J\"\020Í\001\032\0030\0022\025\020\002\032\020\022\013\022\t\022\005\022\0030È\001090£\001H\001J\"\020Ï\001\032\0030\0022\025\020\002\032\020\022\013\022\t\022\005\022\0030Ð\001090£\001H\001J\024\020Ò\001\032\0030\0022\007\020Ò\001\032\0020yH\001J\024\020Ò\001\032\0030\0022\007\020Ò\001\032\0020 H\001J\034\020½\002\032\0030\0022\007\020¾\002\032\0020 2\006\020\036\032\0020 H\001J!\020â\001\032\0030\0022\024\020¿\002\032\017\022\004\022\0020 \022\004\022\0020 0ã\001H\001J\034\020æ\001\032\0030\0022\017\020\002\032\n\022\005\022\0030ç\0010£\001H\001J\024\020À\002\032\0030\0022\007\020\002\032\0020sH\001J'\020Á\002\032\0030\0022\024\020\002\032\013\022\006\b\001\022\0020s0\002\"\0020sH\001¢\006\003\020 \002J\024\020Â\002\032\0030\0022\007\020\002\032\0020 H\001J\036\020Â\002\032\0030\0022\007\020\002\032\0020 2\b\020Ã\002\032\0030\001H\001J\034\020Ä\002\032\0030\0022\017\020\002\032\n\022\005\022\0030ÿ\0010£\001H\001J\034\020\002\032\0030\0022\017\020\002\032\n\022\005\022\0030\0020£\001H\001J\035\020\002\032\0030\0022\n\020\002\032\005\030\0010\001H\001¢\006\003\020\001R\022\020\026\032\0020\027X\005¢\006\006\032\004\b\030\020\031R\022\020\032\032\0020\033X\005¢\006\006\032\004\b\034\020\035R0\020!\032\b\022\004\022\0020 0\0372\f\020\036\032\b\022\004\022\0020 0\0378V@VX\016¢\006\f\032\004\b\"\020#\"\004\b$\020%R\032\020&\032\004\030\0010 X\017¢\006\f\032\004\b'\020(\"\004\b)\020*R\032\020+\032\004\030\0010 X\017¢\006\f\032\004\b,\020(\"\004\b-\020*R\036\020.\032\b\022\004\022\002000/X\017¢\006\f\032\004\b1\0202\"\004\b3\0204R\016\020\t\032\0020\nX\004¢\006\002\n\000R\032\0205\032\004\030\0010 X\017¢\006\f\032\004\b6\020(\"\004\b7\020*R\030\0208\032\b\022\004\022\0020:09X\005¢\006\006\032\004\b;\020<R\022\020=\032\0020>X\005¢\006\006\032\004\b?\020@R\032\020A\032\004\030\0010 X\017¢\006\f\032\004\bB\020(\"\004\bC\020*R\022\020D\032\0020EX\005¢\006\006\032\004\bF\020GR\024\020H\032\0020I8\026X\005¢\006\006\032\004\bJ\020KR$\020L\032\0020 2\006\020\036\032\0020 @VX\016¢\006\016\n\000\032\004\bM\020(\"\004\bN\020*R\036\020O\032\b\022\004\022\0020P0/X\017¢\006\f\032\004\bQ\0202\"\004\bR\0204R\022\020S\032\0020TX\005¢\006\006\032\004\bU\020VR\016\020\017\032\0020\020X\004¢\006\002\n\000R\022\020W\032\0020XX\005¢\006\006\032\004\bY\020ZR\"\020[\032\b\022\004\022\0020 0/8\026@\026X\017¢\006\f\032\004\b\\\0202\"\004\b]\0204R\036\020^\032\b\022\004\022\0020 0/X\017¢\006\f\032\004\b_\0202\"\004\b`\0204R\034\020a\032\n\022\004\022\0020 \030\0010b8\026X\005¢\006\006\032\004\bc\020dR\022\020e\032\0020fX\005¢\006\006\032\004\bg\020hR\022\020i\032\0020jX\005¢\006\006\032\004\bk\020lR\022\020m\032\0020nX\005¢\006\006\032\004\bo\020pR$\020q\032\016\022\004\022\0020 \022\004\022\0020s0rX\017¢\006\f\032\004\bt\020u\"\004\bv\020wR\032\020x\032\004\030\0010yX\017¢\006\f\032\004\bz\020{\"\004\b|\020}R\036\020~\032\004\030\0010X\017¢\006\020\032\006\b\001\020\001\"\006\b\001\020\001R \020\001\032\005\030\0010\001X\017¢\006\020\032\006\b\001\020\001\"\006\b\001\020\001R \020\001\032\005\030\0010\001X\017¢\006\020\032\006\b\001\020\001\"\006\b\001\020\001R \020\001\032\005\030\0010\001X\017¢\006\020\032\006\b\001\020\001\"\006\b\001\020\001R\026\020\001\032\0030\001X\005¢\006\b\032\006\b\001\020\001R\016\020\021\032\0020\022X\004¢\006\002\n\000R3\020\001\032\0030\0012\007\020\036\032\0030\0018V@VX\016¢\006\030\022\006\b\001\020\001\032\006\b\001\020\001\"\006\b\001\020\001R\026\020\001\032\0030\001X\005¢\006\b\032\006\b \001\020¡\001R/\020¢\001\032\026\022\022\022\020\022\013\022\t\022\005\022\0030¤\0010\0370£\0010/X\017¢\006\016\032\005\b¥\001\0202\"\005\b¦\001\0204R)\020§\001\032\020\022\f\022\n\022\005\022\0030¨\0010£\0010/X\017¢\006\016\032\005\b©\001\0202\"\005\bª\001\0204R\033\020«\001\032\t\022\005\022\0030¬\00109X\005¢\006\007\032\005\b­\001\020<R \020®\001\032\005\030\0010\001X\017¢\006\020\032\006\b¯\001\020\001\"\006\b°\001\020\001R \020±\001\032\005\030\0010\001X\017¢\006\020\032\006\b²\001\020\001\"\006\b³\001\020\001R \020´\001\032\005\030\0010\001X\017¢\006\020\032\006\bµ\001\020\001\"\006\b¶\001\020\001R\035\020·\001\032\004\030\0010yX\017¢\006\016\032\005\b¸\001\020{\"\005\b¹\001\020}R!\020º\001\032\b\022\004\022\0020 0/X\017¢\006\016\032\005\b»\001\0202\"\005\b¼\001\0204R!\020½\001\032\b\022\004\022\002000/X\017¢\006\016\032\005\b¾\001\0202\"\005\b¿\001\0204R\035\020À\001\032\004\030\0010 X\017¢\006\016\032\005\bÁ\001\020(\"\005\bÂ\001\020*R\026\020Ã\001\032\0030Ä\001X\005¢\006\b\032\006\bÅ\001\020Æ\001R \020Ç\001\032\005\030\0010È\001X\017¢\006\020\032\006\bÉ\001\020Ê\001\"\006\bË\001\020Ì\001R\033\020Í\001\032\t\022\005\022\0030È\00109X\005¢\006\007\032\005\bÎ\001\020<R\033\020Ï\001\032\t\022\005\022\0030Ð\00109X\005¢\006\007\032\005\bÑ\001\020<R\037\020Ò\001\032\004\030\0010X\017¢\006\020\032\006\bÓ\001\020\001\"\006\bÔ\001\020\001R!\020Õ\001\032\004\030\0010 8\026@\026X\017¢\006\016\032\005\bÖ\001\020(\"\005\b×\001\020*R\035\020Ø\001\032\004\030\0010 X\017¢\006\016\032\005\bÙ\001\020(\"\005\bÚ\001\020*R\032\020Û\001\032\005\030\0010\0018\026X\005¢\006\b\032\006\bÜ\001\020\001R\032\020Ý\001\032\005\030\0010\0018\026X\005¢\006\b\032\006\bÞ\001\020\001R!\020ß\001\032\004\030\0010 8\026@\026X\017¢\006\016\032\005\bà\001\020(\"\005\bá\001\020*R,\020â\001\032\017\022\004\022\0020 \022\004\022\0020 0ã\0018\026@\026X\017¢\006\016\032\005\bä\001\020u\"\005\bå\001\020wR\026\020æ\001\032\0030ç\001X\005¢\006\b\032\006\bè\001\020é\001R\"\020ê\001\032\t\022\005\022\0030ë\0010/X\017¢\006\016\032\005\bì\001\0202\"\005\bí\001\0204R\037\020î\001\032\n\022\005\022\0030ð\0010ï\0018\026X\005¢\006\b\032\006\bñ\001\020ò\001R\034\020ó\001\032\n\022\005\022\0030õ\0010ô\001X\005¢\006\007\032\005\bö\001\0202R\"\020÷\001\032\020\022\013\022\t\022\004\022\0020s0ô\0010ô\001X\005¢\006\007\032\005\bø\001\0202R\037\020ù\001\032\n\022\005\022\0030ú\0010ï\0018\026X\005¢\006\b\032\006\bû\001\020ò\001R\016\020\r\032\0020\016X\004¢\006\002\n\000R\026\020\013\032\0020\fX\004¢\006\n\n\000\032\006\bü\001\020ý\001R)\020þ\001\032\020\022\f\022\n\022\005\022\0030ÿ\0010£\0010/X\017¢\006\016\032\005\b\002\0202\"\005\b\002\0204R\035\020\002\032\n\022\005\022\0030¤\0010\002X\005¢\006\b\032\006\b\002\020\002R\026\020\002\032\0030\002X\005¢\006\b\032\006\b\002\020\002R\035\020\002\032\004\030\0010yX\017¢\006\016\032\005\b\002\020{\"\005\b\002\020}R\035\020\002\032\004\030\0010 X\017¢\006\016\032\005\b\002\020(\"\005\b\002\020*R\035\020\002\032\004\030\0010 X\017¢\006\016\032\005\b\002\020(\"\005\b\002\020*R \020\002\032\005\030\0010\001X\017¢\006\020\032\006\b\002\020\001\"\006\b\002\020\001¨\006Å\002"}, d2={"Lcom/android/build/gradle/internal/api/dsl/extensions/LibraryExtensionImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/extension/LibraryExtension;", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "Lcom/android/build/api/dsl/extension/BuildProperties;", "Lcom/android/build/api/dsl/extension/VariantOrExtensionProperties;", "Lcom/android/build/api/dsl/extension/VariantAwareProperties;", "Lcom/android/build/api/dsl/extension/EmbeddedTestProperties;", "Lcom/android/build/api/dsl/extension/OnDeviceTestProperties;", "buildProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/BuildPropertiesImpl;", "variantExtensionProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "variantAwareProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantAwarePropertiesImpl;", "embeddedTestProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/EmbeddedTestPropertiesImpl;", "onDeviceTestProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/OnDeviceTestPropertiesImpl;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/api/dsl/extensions/BuildPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/VariantAwarePropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/EmbeddedTestPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/OnDeviceTestPropertiesImpl;Lcom/android/builder/errors/EvalIssueReporter;)V", "aaptOptions", "Lcom/android/build/api/dsl/options/AaptOptions;", "getAaptOptions", "()Lcom/android/build/api/dsl/options/AaptOptions;", "adbOptions", "Lcom/android/builder/model/AdbOptions;", "getAdbOptions", "()Lcom/android/builder/model/AdbOptions;", "value", "", "", "aidlPackageWhiteList", "getAidlPackageWhiteList", "()Ljava/util/Collection;", "setAidlPackageWhiteList", "(Ljava/util/Collection;)V", "applicationId", "getApplicationId", "()Ljava/lang/String;", "setApplicationId", "(Ljava/lang/String;)V", "applicationIdSuffix", "getApplicationIdSuffix", "setApplicationIdSuffix", "buildConfigFields", "", "Lcom/android/build/api/dsl/model/TypedValue;", "getBuildConfigFields", "()Ljava/util/List;", "setBuildConfigFields", "(Ljava/util/List;)V", "buildToolsVersion", "getBuildToolsVersion", "setBuildToolsVersion", "buildTypes", "Lorg/gradle/api/NamedDomainObjectContainer;", "Lcom/android/build/api/dsl/model/BuildType;", "getBuildTypes", "()Lorg/gradle/api/NamedDomainObjectContainer;", "compileOptions", "Lcom/android/build/api/dsl/options/CompileOptions;", "getCompileOptions", "()Lcom/android/build/api/dsl/options/CompileOptions;", "compileSdkVersion", "getCompileSdkVersion", "setCompileSdkVersion", "dataBinding", "Lcom/android/builder/model/DataBindingOptions;", "getDataBinding", "()Lcom/android/builder/model/DataBindingOptions;", "defaultConfig", "Lcom/android/build/api/dsl/model/DefaultConfig;", "getDefaultConfig", "()Lcom/android/build/api/dsl/model/DefaultConfig;", "defaultPublishConfig", "getDefaultPublishConfig", "setDefaultPublishConfig", "deviceProviders", "Lcom/android/builder/testing/api/DeviceProvider;", "getDeviceProviders", "setDeviceProviders", "dexOptions", "Lcom/android/build/api/dsl/options/DexOptions;", "getDexOptions", "()Lcom/android/build/api/dsl/options/DexOptions;", "externalNativeBuildOptions", "Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "getExternalNativeBuildOptions", "()Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "flavorDimensionList", "getFlavorDimensionList", "setFlavorDimensionList", "flavorDimensions", "getFlavorDimensions", "setFlavorDimensions", "generatedDensities", "", "getGeneratedDensities", "()Ljava/util/Set;", "instrumentationOptions", "Lcom/android/build/api/dsl/options/InstrumentationOptions;", "getInstrumentationOptions", "()Lcom/android/build/api/dsl/options/InstrumentationOptions;", "javaCompileOptions", "Lcom/android/build/api/dsl/options/JavaCompileOptions;", "getJavaCompileOptions", "()Lcom/android/build/api/dsl/options/JavaCompileOptions;", "lintOptions", "Lcom/android/build/api/dsl/options/LintOptions;", "getLintOptions", "()Lcom/android/build/api/dsl/options/LintOptions;", "manifestPlaceholders", "", "", "getManifestPlaceholders", "()Ljava/util/Map;", "setManifestPlaceholders", "(Ljava/util/Map;)V", "maxSdkVersion", "", "getMaxSdkVersion", "()Ljava/lang/Integer;", "setMaxSdkVersion", "(Ljava/lang/Integer;)V", "minSdkVersion", "Lcom/android/build/api/dsl/ApiVersion;", "getMinSdkVersion", "()Lcom/android/build/api/dsl/ApiVersion;", "setMinSdkVersion", "(Lcom/android/build/api/dsl/ApiVersion;)V", "multiDexEnabled", "", "getMultiDexEnabled", "()Ljava/lang/Boolean;", "setMultiDexEnabled", "(Ljava/lang/Boolean;)V", "multiDexKeepFile", "Ljava/io/File;", "getMultiDexKeepFile", "()Ljava/io/File;", "setMultiDexKeepFile", "(Ljava/io/File;)V", "multiDexKeepProguard", "getMultiDexKeepProguard", "setMultiDexKeepProguard", "ndkOptions", "Lcom/android/build/api/dsl/options/NdkOptions;", "getNdkOptions", "()Lcom/android/build/api/dsl/options/NdkOptions;", "packageBuildConfig", "packageBuildConfig$annotations", "()V", "getPackageBuildConfig", "()Z", "setPackageBuildConfig", "(Z)V", "postProcessing", "Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "getPostProcessing", "()Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "postVariants", "Lorg/gradle/api/Action;", "Lcom/android/build/api/dsl/variant/Variant;", "getPostVariants", "setPostVariants", "preVariantCallbacks", "Ljava/lang/Void;", "getPreVariantCallbacks", "setPreVariantCallbacks", "productFlavors", "Lcom/android/build/api/dsl/model/ProductFlavor;", "getProductFlavors", "renderscriptNdkModeEnabled", "getRenderscriptNdkModeEnabled", "setRenderscriptNdkModeEnabled", "renderscriptSupportModeBlasEnabled", "getRenderscriptSupportModeBlasEnabled", "setRenderscriptSupportModeBlasEnabled", "renderscriptSupportModeEnabled", "getRenderscriptSupportModeEnabled", "setRenderscriptSupportModeEnabled", "renderscriptTargetApi", "getRenderscriptTargetApi", "setRenderscriptTargetApi", "resConfigs", "getResConfigs", "setResConfigs", "resValues", "getResValues", "setResValues", "resourcePrefix", "getResourcePrefix", "setResourcePrefix", "shaders", "Lcom/android/build/api/dsl/options/ShaderOptions;", "getShaders", "()Lcom/android/build/api/dsl/options/ShaderOptions;", "signingConfig", "Lcom/android/build/api/dsl/options/SigningConfig;", "getSigningConfig", "()Lcom/android/build/api/dsl/options/SigningConfig;", "setSigningConfig", "(Lcom/android/build/api/dsl/options/SigningConfig;)V", "signingConfigs", "getSigningConfigs", "sourceSets", "Lcom/android/build/api/sourcesets/AndroidSourceSet;", "getSourceSets", "targetSdkVersion", "getTargetSdkVersion", "setTargetSdkVersion", "testApplicationId", "getTestApplicationId", "setTestApplicationId", "testBuildType", "getTestBuildType", "setTestBuildType", "testFunctionalTest", "getTestFunctionalTest", "testHandleProfiling", "getTestHandleProfiling", "testInstrumentationRunner", "getTestInstrumentationRunner", "setTestInstrumentationRunner", "testInstrumentationRunnerArguments", "", "getTestInstrumentationRunnerArguments", "setTestInstrumentationRunnerArguments", "testOptions", "Lcom/android/builder/model/TestOptions;", "getTestOptions", "()Lcom/android/builder/model/TestOptions;", "testServers", "Lcom/android/builder/testing/api/TestServer;", "getTestServers", "setTestServers", "testVariants", "Lorg/gradle/api/DomainObjectSet;", "Lcom/android/build/api/dsl/variant/TestVariant;", "getTestVariants", "()Lorg/gradle/api/DomainObjectSet;", "transforms", "", "Lcom/android/build/api/transform/Transform;", "getTransforms", "transformsDependencies", "getTransformsDependencies", "unitTestVariants", "Lcom/android/build/api/dsl/variant/UnitTestVariant;", "getUnitTestVariants", "getVariantExtensionProperties", "()Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "variantFilters", "Lcom/android/build/api/dsl/variant/VariantFilter;", "getVariantFilters", "setVariantFilters", "variants", "Lcom/android/build/api/dsl/extension/VariantCallbackHandler;", "getVariants", "()Lcom/android/build/api/dsl/extension/VariantCallbackHandler;", "vectorDrawables", "Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "getVectorDrawables", "()Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "versionCode", "getVersionCode", "setVersionCode", "versionName", "getVersionName", "setVersionName", "versionNameSuffix", "getVersionNameSuffix", "setVersionNameSuffix", "wearAppUnbundled", "getWearAppUnbundled", "setWearAppUnbundled", "", "action", "buildConfigField", "type", "name", "consumerProguardFile", "proguardFile", "consumerProguardFiles", "proguardFiles", "", "([Ljava/lang/Object;)V", "externalNativeBuild", "missingDimensionStrategy", "dimension", "requestedValues", "(Ljava/lang/String;[Ljava/lang/String;)V", "requestedValue", "postVariantCallback", "preVariantCallback", "files", "registerTransform", "transform", "dependencies", "(Lcom/android/build/api/transform/Transform;[Ljava/lang/Object;)V", "resValue", "seal", "apiLevel", "setConsumerProguardFiles", "proguardFileIterable", "", "setGeneratedDensities", "densities", "setProguardFiles", "setTestFunctionalTest", "functionalTest", "setTestHandleProfiling", "handleProfiling", "setTestProguardFiles", "shaderOptions", "testInstrumentationRunnerArgument", "key", "args", "testProguardFile", "testProguardFiles", "useLibrary", "required", "variantFilter", "gradle-core"})
/*    */ public final class LibraryExtensionImpl extends com.android.build.gradle.internal.api.dsl.sealing.SealableObject implements com.android.build.api.dsl.extension.LibraryExtension, BaseExtension2, com.android.build.api.dsl.extension.BuildProperties, com.android.build.api.dsl.extension.VariantOrExtensionProperties, com.android.build.api.dsl.extension.VariantAwareProperties, com.android.build.api.dsl.extension.EmbeddedTestProperties, com.android.build.api.dsl.extension.OnDeviceTestProperties
/*    */ {
/*    */   @NotNull
/*    */   private String defaultPublishConfig;
/*    */   private final BuildPropertiesImpl buildProperties;
/*    */   @NotNull
/*    */   private final VariantOrExtensionPropertiesImpl variantExtensionProperties;
/*    */   private final VariantAwarePropertiesImpl variantAwareProperties;
/*    */   private final EmbeddedTestPropertiesImpl embeddedTestProperties;
/*    */   private final OnDeviceTestPropertiesImpl onDeviceTestProperties;
/*    */   
/*    */   @NotNull
/*    */   public VariantOrExtensionPropertiesImpl getVariantExtensionProperties()
/*    */   {
/* 30 */     return variantExtensionProperties;
/*    */   }
/*    */   
/*    */   public void seal()
/*    */   {
/* 45 */     super.seal();
/*    */     
/* 47 */     buildProperties.seal();
/* 48 */     getVariantExtensionProperties().seal();
/* 49 */     variantAwareProperties.seal();
/* 50 */     embeddedTestProperties.seal();
/* 51 */     onDeviceTestProperties.seal(); }
/*    */   
/*    */   @NotNull
/* 54 */   public String getDefaultPublishConfig() { return defaultPublishConfig; }
/*    */   
/*    */   public LibraryExtensionImpl(@NotNull BuildPropertiesImpl buildProperties, @NotNull VariantOrExtensionPropertiesImpl variantExtensionProperties, @NotNull VariantAwarePropertiesImpl variantAwareProperties, @NotNull EmbeddedTestPropertiesImpl embeddedTestProperties, @NotNull OnDeviceTestPropertiesImpl onDeviceTestProperties, @NotNull com.android.builder.errors.EvalIssueReporter issueReporter)
/*    */   {
/* 35 */     super(issueReporter);this.buildProperties = buildProperties;this.variantExtensionProperties = variantExtensionProperties;this.variantAwareProperties = variantAwareProperties;this.embeddedTestProperties = embeddedTestProperties;this.onDeviceTestProperties = onDeviceTestProperties;
/*    */     
/* 54 */     defaultPublishConfig = "release"; }
/*    */   
/* 56 */   public void setDefaultPublishConfig(@NotNull String value) { Intrinsics.checkParameterIsNotNull(value, "value"); if (checkSeal())
/* 57 */       defaultPublishConfig = value;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public Collection<String> getAidlPackageWhiteList() {
/* 62 */     String str = "not implemented";throw ((Throwable)new kotlin.NotImplementedError("An operation is not implemented: " + str)); }
/* 63 */   public void setAidlPackageWhiteList(@NotNull Collection<String> value) { Intrinsics.checkParameterIsNotNull(value, "value"); }
/*    */   
/*    */   public boolean getPackageBuildConfig()
/*    */   {
/* 67 */     String str = "not implemented";throw ((Throwable)new kotlin.NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   public void setPackageBuildConfig(boolean value) {}
/*    */   
/*    */   @Nullable
/*    */   public String getBuildToolsVersion()
/*    */   {
/*    */     return buildProperties.getBuildToolsVersion();
/*    */   }
/*    */   
/*    */   public void setBuildToolsVersion(@Nullable String <set-?>)
/*    */   {
/*    */     buildProperties.setBuildToolsVersion(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public String getCompileSdkVersion()
/*    */   {
/*    */     return buildProperties.getCompileSdkVersion();
/*    */   }
/*    */   
/*    */   public void setCompileSdkVersion(@Nullable String <set-?>)
/*    */   {
/*    */     buildProperties.setCompileSdkVersion(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public String getResourcePrefix()
/*    */   {
/*    */     return buildProperties.getResourcePrefix();
/*    */   }
/*    */   
/*    */   public void setResourcePrefix(@Nullable String <set-?>)
/*    */   {
/*    */     buildProperties.setResourcePrefix(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public NamedDomainObjectContainer<com.android.build.api.sourcesets.AndroidSourceSet> getSourceSets()
/*    */   {
/*    */     return buildProperties.getSourceSets();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<com.android.build.api.transform.Transform> getTransforms()
/*    */   {
/*    */     return buildProperties.getTransforms();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<List<Object>> getTransformsDependencies()
/*    */   {
/*    */     return buildProperties.getTransformsDependencies();
/*    */   }
/*    */   
/*    */   public void registerTransform(@NotNull com.android.build.api.transform.Transform transform)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(transform, "transform");
/*    */     buildProperties.registerTransform(transform);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="")
/*    */   public void registerTransform(@NotNull com.android.build.api.transform.Transform transform, @NotNull Object... dependencies)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(transform, "transform");
/*    */     Intrinsics.checkParameterIsNotNull(dependencies, "dependencies");
/*    */     buildProperties.registerTransform(transform, dependencies);
/*    */   }
/*    */   
/*    */   public void setCompileSdkVersion(int apiLevel)
/*    */   {
/*    */     buildProperties.setCompileSdkVersion(apiLevel);
/*    */   }
/*    */   
/*    */   public void sourceSets(@NotNull Action<NamedDomainObjectContainer<com.android.build.api.sourcesets.AndroidSourceSet>> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     buildProperties.sourceSets(action);
/*    */   }
/*    */   
/*    */   public void useLibrary(@NotNull String name)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(name, "name");
/*    */     buildProperties.useLibrary(name);
/*    */   }
/*    */   
/*    */   public void useLibrary(@NotNull String name, boolean required)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(name, "name");
/*    */     buildProperties.useLibrary(name, required);
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
/*    */   @Nullable
/*    */   public String getApplicationId()
/*    */   {
/*    */     return variantAwareProperties.getApplicationId();
/*    */   }
/*    */   
/*    */   public void setApplicationId(@Nullable String <set-?>)
/*    */   {
/*    */     variantAwareProperties.setApplicationId(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public String getApplicationIdSuffix()
/*    */   {
/*    */     return variantAwareProperties.getApplicationIdSuffix();
/*    */   }
/*    */   
/*    */   public void setApplicationIdSuffix(@Nullable String <set-?>)
/*    */   {
/*    */     variantAwareProperties.setApplicationIdSuffix(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<com.android.build.api.dsl.model.TypedValue> getBuildConfigFields()
/*    */   {
/*    */     return variantAwareProperties.getBuildConfigFields();
/*    */   }
/*    */   
/*    */   public void setBuildConfigFields(@NotNull List<com.android.build.api.dsl.model.TypedValue> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantAwareProperties.setBuildConfigFields(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public NamedDomainObjectContainer<com.android.build.api.dsl.model.BuildType> getBuildTypes()
/*    */   {
/*    */     return variantAwareProperties.getBuildTypes();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.model.DefaultConfig getDefaultConfig()
/*    */   {
/*    */     return variantAwareProperties.getDefaultConfig();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.ExternalNativeBuildOptions getExternalNativeBuildOptions()
/*    */   {
/*    */     return variantAwareProperties.getExternalNativeBuildOptions();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @NotNull
/*    */   public List<String> getFlavorDimensionList()
/*    */   {
/*    */     return variantAwareProperties.getFlavorDimensionList();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   public void setFlavorDimensionList(@NotNull List<String> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantAwareProperties.setFlavorDimensionList(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<String> getFlavorDimensions()
/*    */   {
/*    */     return variantAwareProperties.getFlavorDimensions();
/*    */   }
/*    */   
/*    */   public void setFlavorDimensions(@NotNull List<String> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantAwareProperties.setFlavorDimensions(<set-?>);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Nullable
/*    */   public java.util.Set<String> getGeneratedDensities()
/*    */   {
/*    */     return variantAwareProperties.getGeneratedDensities();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.InstrumentationOptions getInstrumentationOptions()
/*    */   {
/*    */     return variantAwareProperties.getInstrumentationOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.JavaCompileOptions getJavaCompileOptions()
/*    */   {
/*    */     return variantAwareProperties.getJavaCompileOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public Map<String, Object> getManifestPlaceholders()
/*    */   {
/*    */     return variantAwareProperties.getManifestPlaceholders();
/*    */   }
/*    */   
/*    */   public void setManifestPlaceholders(@NotNull Map<String, Object> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantAwareProperties.setManifestPlaceholders(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Integer getMaxSdkVersion()
/*    */   {
/*    */     return variantAwareProperties.getMaxSdkVersion();
/*    */   }
/*    */   
/*    */   public void setMaxSdkVersion(@Nullable Integer <set-?>)
/*    */   {
/*    */     variantAwareProperties.setMaxSdkVersion(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public ApiVersion getMinSdkVersion()
/*    */   {
/*    */     return variantAwareProperties.getMinSdkVersion();
/*    */   }
/*    */   
/*    */   public void setMinSdkVersion(@Nullable ApiVersion <set-?>)
/*    */   {
/*    */     variantAwareProperties.setMinSdkVersion(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Boolean getMultiDexEnabled()
/*    */   {
/*    */     return variantAwareProperties.getMultiDexEnabled();
/*    */   }
/*    */   
/*    */   public void setMultiDexEnabled(@Nullable Boolean <set-?>)
/*    */   {
/*    */     variantAwareProperties.setMultiDexEnabled(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public File getMultiDexKeepFile()
/*    */   {
/*    */     return variantAwareProperties.getMultiDexKeepFile();
/*    */   }
/*    */   
/*    */   public void setMultiDexKeepFile(@Nullable File <set-?>)
/*    */   {
/*    */     variantAwareProperties.setMultiDexKeepFile(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public File getMultiDexKeepProguard()
/*    */   {
/*    */     return variantAwareProperties.getMultiDexKeepProguard();
/*    */   }
/*    */   
/*    */   public void setMultiDexKeepProguard(@Nullable File <set-?>)
/*    */   {
/*    */     variantAwareProperties.setMultiDexKeepProguard(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.NdkOptions getNdkOptions()
/*    */   {
/*    */     return variantAwareProperties.getNdkOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.PostProcessingFilesOptions getPostProcessing()
/*    */   {
/*    */     return variantAwareProperties.getPostProcessing();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<Action<Collection<com.android.build.api.dsl.variant.Variant>>> getPostVariants()
/*    */   {
/*    */     return variantAwareProperties.getPostVariants();
/*    */   }
/*    */   
/*    */   public void setPostVariants(@NotNull List<Action<Collection<com.android.build.api.dsl.variant.Variant>>> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantAwareProperties.setPostVariants(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<Action<Void>> getPreVariantCallbacks()
/*    */   {
/*    */     return variantAwareProperties.getPreVariantCallbacks();
/*    */   }
/*    */   
/*    */   public void setPreVariantCallbacks(@NotNull List<Action<Void>> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantAwareProperties.setPreVariantCallbacks(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public NamedDomainObjectContainer<com.android.build.api.dsl.model.ProductFlavor> getProductFlavors()
/*    */   {
/*    */     return variantAwareProperties.getProductFlavors();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Boolean getRenderscriptNdkModeEnabled()
/*    */   {
/*    */     return variantAwareProperties.getRenderscriptNdkModeEnabled();
/*    */   }
/*    */   
/*    */   public void setRenderscriptNdkModeEnabled(@Nullable Boolean <set-?>)
/*    */   {
/*    */     variantAwareProperties.setRenderscriptNdkModeEnabled(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Boolean getRenderscriptSupportModeBlasEnabled()
/*    */   {
/*    */     return variantAwareProperties.getRenderscriptSupportModeBlasEnabled();
/*    */   }
/*    */   
/*    */   public void setRenderscriptSupportModeBlasEnabled(@Nullable Boolean <set-?>)
/*    */   {
/*    */     variantAwareProperties.setRenderscriptSupportModeBlasEnabled(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Boolean getRenderscriptSupportModeEnabled()
/*    */   {
/*    */     return variantAwareProperties.getRenderscriptSupportModeEnabled();
/*    */   }
/*    */   
/*    */   public void setRenderscriptSupportModeEnabled(@Nullable Boolean <set-?>)
/*    */   {
/*    */     variantAwareProperties.setRenderscriptSupportModeEnabled(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Integer getRenderscriptTargetApi()
/*    */   {
/*    */     return variantAwareProperties.getRenderscriptTargetApi();
/*    */   }
/*    */   
/*    */   public void setRenderscriptTargetApi(@Nullable Integer <set-?>)
/*    */   {
/*    */     variantAwareProperties.setRenderscriptTargetApi(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<String> getResConfigs()
/*    */   {
/*    */     return variantAwareProperties.getResConfigs();
/*    */   }
/*    */   
/*    */   public void setResConfigs(@NotNull List<String> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantAwareProperties.setResConfigs(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<com.android.build.api.dsl.model.TypedValue> getResValues()
/*    */   {
/*    */     return variantAwareProperties.getResValues();
/*    */   }
/*    */   
/*    */   public void setResValues(@NotNull List<com.android.build.api.dsl.model.TypedValue> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantAwareProperties.setResValues(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.ShaderOptions getShaders()
/*    */   {
/*    */     return variantAwareProperties.getShaders();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public com.android.build.api.dsl.options.SigningConfig getSigningConfig()
/*    */   {
/*    */     return variantAwareProperties.getSigningConfig();
/*    */   }
/*    */   
/*    */   public void setSigningConfig(@Nullable com.android.build.api.dsl.options.SigningConfig <set-?>)
/*    */   {
/*    */     variantAwareProperties.setSigningConfig(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public NamedDomainObjectContainer<com.android.build.api.dsl.options.SigningConfig> getSigningConfigs()
/*    */   {
/*    */     return variantAwareProperties.getSigningConfigs();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public ApiVersion getTargetSdkVersion()
/*    */   {
/*    */     return variantAwareProperties.getTargetSdkVersion();
/*    */   }
/*    */   
/*    */   public void setTargetSdkVersion(@Nullable ApiVersion <set-?>)
/*    */   {
/*    */     variantAwareProperties.setTargetSdkVersion(<set-?>);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Nullable
/*    */   public String getTestApplicationId()
/*    */   {
/*    */     return variantAwareProperties.getTestApplicationId();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   public void setTestApplicationId(@Nullable String <set-?>)
/*    */   {
/*    */     variantAwareProperties.setTestApplicationId(<set-?>);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Nullable
/*    */   public Boolean getTestFunctionalTest()
/*    */   {
/*    */     return variantAwareProperties.getTestFunctionalTest();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Nullable
/*    */   public Boolean getTestHandleProfiling()
/*    */   {
/*    */     return variantAwareProperties.getTestHandleProfiling();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Nullable
/*    */   public String getTestInstrumentationRunner()
/*    */   {
/*    */     return variantAwareProperties.getTestInstrumentationRunner();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   public void setTestInstrumentationRunner(@Nullable String <set-?>)
/*    */   {
/*    */     variantAwareProperties.setTestInstrumentationRunner(<set-?>);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @NotNull
/*    */   public Map<String, String> getTestInstrumentationRunnerArguments()
/*    */   {
/*    */     return variantAwareProperties.getTestInstrumentationRunnerArguments();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   public void setTestInstrumentationRunnerArguments(@NotNull Map<String, String> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantAwareProperties.setTestInstrumentationRunnerArguments(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<Action<com.android.build.api.dsl.variant.VariantFilter>> getVariantFilters()
/*    */   {
/*    */     return variantAwareProperties.getVariantFilters();
/*    */   }
/*    */   
/*    */   public void setVariantFilters(@NotNull List<Action<com.android.build.api.dsl.variant.VariantFilter>> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     variantAwareProperties.setVariantFilters(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.extension.VariantCallbackHandler<com.android.build.api.dsl.variant.Variant> getVariants()
/*    */   {
/*    */     return variantAwareProperties.getVariants();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.VectorDrawablesOptions getVectorDrawables()
/*    */   {
/*    */     return variantAwareProperties.getVectorDrawables();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Integer getVersionCode()
/*    */   {
/*    */     return variantAwareProperties.getVersionCode();
/*    */   }
/*    */   
/*    */   public void setVersionCode(@Nullable Integer <set-?>)
/*    */   {
/*    */     variantAwareProperties.setVersionCode(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public String getVersionName()
/*    */   {
/*    */     return variantAwareProperties.getVersionName();
/*    */   }
/*    */   
/*    */   public void setVersionName(@Nullable String <set-?>)
/*    */   {
/*    */     variantAwareProperties.setVersionName(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public String getVersionNameSuffix()
/*    */   {
/*    */     return variantAwareProperties.getVersionNameSuffix();
/*    */   }
/*    */   
/*    */   public void setVersionNameSuffix(@Nullable String <set-?>)
/*    */   {
/*    */     variantAwareProperties.setVersionNameSuffix(<set-?>);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public Boolean getWearAppUnbundled()
/*    */   {
/*    */     return variantAwareProperties.getWearAppUnbundled();
/*    */   }
/*    */   
/*    */   public void setWearAppUnbundled(@Nullable Boolean <set-?>)
/*    */   {
/*    */     variantAwareProperties.setWearAppUnbundled(<set-?>);
/*    */   }
/*    */   
/*    */   public void buildConfigField(@NotNull String type, @NotNull String name, @NotNull String value)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(type, "type");
/*    */     Intrinsics.checkParameterIsNotNull(name, "name");
/*    */     Intrinsics.checkParameterIsNotNull(value, "value");
/*    */     variantAwareProperties.buildConfigField(type, name, value);
/*    */   }
/*    */   
/*    */   public void buildTypes(@NotNull Action<NamedDomainObjectContainer<com.android.build.api.dsl.model.BuildType>> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.buildTypes(action);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void consumerProguardFile(@NotNull Object proguardFile)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*    */     variantAwareProperties.consumerProguardFile(proguardFile);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void consumerProguardFiles(@NotNull Object... proguardFiles)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");
/*    */     variantAwareProperties.consumerProguardFiles(proguardFiles);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use properties on extension itself")
/*    */   public void defaultConfig(@NotNull Action<com.android.build.api.dsl.model.DefaultConfig> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.defaultConfig(action);
/*    */   }
/*    */   
/*    */   public void externalNativeBuild(@NotNull Action<com.android.build.api.dsl.options.ExternalNativeBuildOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.externalNativeBuild(action);
/*    */   }
/*    */   
/*    */   public void externalNativeBuildOptions(@NotNull Action<com.android.build.api.dsl.options.ExternalNativeBuildOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.externalNativeBuildOptions(action);
/*    */   }
/*    */   
/*    */   public void instrumentationOptions(@NotNull Action<com.android.build.api.dsl.options.InstrumentationOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.instrumentationOptions(action);
/*    */   }
/*    */   
/*    */   public void javaCompileOptions(@NotNull Action<com.android.build.api.dsl.options.JavaCompileOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.javaCompileOptions(action);
/*    */   }
/*    */   
/*    */   public void minSdkVersion(int minSdkVersion)
/*    */   {
/*    */     variantAwareProperties.minSdkVersion(minSdkVersion);
/*    */   }
/*    */   
/*    */   public void minSdkVersion(@NotNull String minSdkVersion)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(minSdkVersion, "minSdkVersion");
/*    */     variantAwareProperties.minSdkVersion(minSdkVersion);
/*    */   }
/*    */   
/*    */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull String... requestedValues)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*    */     Intrinsics.checkParameterIsNotNull(requestedValues, "requestedValues");
/*    */     variantAwareProperties.missingDimensionStrategy(dimension, requestedValues);
/*    */   }
/*    */   
/*    */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull String requestedValue)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*    */     Intrinsics.checkParameterIsNotNull(requestedValue, "requestedValue");
/*    */     variantAwareProperties.missingDimensionStrategy(dimension, requestedValue);
/*    */   }
/*    */   
/*    */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull List<String> requestedValues)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");
/*    */     Intrinsics.checkParameterIsNotNull(requestedValues, "requestedValues");
/*    */     variantAwareProperties.missingDimensionStrategy(dimension, requestedValues);
/*    */   }
/*    */   
/*    */   public void ndkOptions(@NotNull Action<com.android.build.api.dsl.options.NdkOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.ndkOptions(action);
/*    */   }
/*    */   
/*    */   public void postProcessing(@NotNull Action<com.android.build.api.dsl.options.PostProcessingFilesOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.postProcessing(action);
/*    */   }
/*    */   
/*    */   public void postVariantCallback(@NotNull Action<Collection<com.android.build.api.dsl.variant.Variant>> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.postVariantCallback(action);
/*    */   }
/*    */   
/*    */   public void preVariantCallback(@NotNull Action<Void> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.preVariantCallback(action);
/*    */   }
/*    */   
/*    */   public void productFlavors(@NotNull Action<NamedDomainObjectContainer<com.android.build.api.dsl.model.ProductFlavor>> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.productFlavors(action);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void proguardFile(@NotNull Object proguardFile)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*    */     variantAwareProperties.proguardFile(proguardFile);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void proguardFiles(@NotNull Object... files)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(files, "files");
/*    */     variantAwareProperties.proguardFiles(files);
/*    */   }
/*    */   
/*    */   public void resValue(@NotNull String type, @NotNull String name, @NotNull String value)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(type, "type");
/*    */     Intrinsics.checkParameterIsNotNull(name, "name");
/*    */     Intrinsics.checkParameterIsNotNull(value, "value");
/*    */     variantAwareProperties.resValue(type, name, value);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void setConsumerProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");
/*    */     variantAwareProperties.setConsumerProguardFiles(proguardFileIterable);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use {@link VectorDrawablesOptions#setGeneratedDensities(Iterable)}\n      ")
/*    */   public void setGeneratedDensities(@Nullable Iterable<String> densities)
/*    */   {
/*    */     variantAwareProperties.setGeneratedDensities(densities);
/*    */   }
/*    */   
/*    */   public void setMinSdkVersion(int minSdkVersion)
/*    */   {
/*    */     variantAwareProperties.setMinSdkVersion(minSdkVersion);
/*    */   }
/*    */   
/*    */   public void setMinSdkVersion(@NotNull String minSdkVersion)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(minSdkVersion, "minSdkVersion");
/*    */     variantAwareProperties.setMinSdkVersion(minSdkVersion);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void setProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");
/*    */     variantAwareProperties.setProguardFiles(proguardFileIterable);
/*    */   }
/*    */   
/*    */   public void setTargetSdkVersion(int targetSdkVersion)
/*    */   {
/*    */     variantAwareProperties.setTargetSdkVersion(targetSdkVersion);
/*    */   }
/*    */   
/*    */   public void setTargetSdkVersion(@NotNull String targetSdkVersion)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(targetSdkVersion, "targetSdkVersion");
/*    */     variantAwareProperties.setTargetSdkVersion(targetSdkVersion);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use {@link InstrumentationOptions#setFunctionalTest(boolean)}\n      ")
/*    */   public void setTestFunctionalTest(boolean functionalTest)
/*    */   {
/*    */     variantAwareProperties.setTestFunctionalTest(functionalTest);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use {@link InstrumentationOptions#setHandleProfiling(boolean)}\n      ")
/*    */   public void setTestHandleProfiling(boolean handleProfiling)
/*    */   {
/*    */     variantAwareProperties.setTestHandleProfiling(handleProfiling);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void setTestProguardFiles(@NotNull Iterable<? extends Object> files)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(files, "files");
/*    */     variantAwareProperties.setTestProguardFiles(files);
/*    */   }
/*    */   
/*    */   public void shaderOptions(@NotNull Action<com.android.build.api.dsl.options.ShaderOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.shaderOptions(action);
/*    */   }
/*    */   
/*    */   public void signingConfigs(@NotNull Action<NamedDomainObjectContainer<com.android.build.api.dsl.options.SigningConfig>> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.signingConfigs(action);
/*    */   }
/*    */   
/*    */   public void targetSdkVersion(int targetSdkVersion)
/*    */   {
/*    */     variantAwareProperties.targetSdkVersion(targetSdkVersion);
/*    */   }
/*    */   
/*    */   public void targetSdkVersion(@NotNull String targetSdkVersion)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(targetSdkVersion, "targetSdkVersion");
/*    */     variantAwareProperties.targetSdkVersion(targetSdkVersion);
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
/*    */     variantAwareProperties.testInstrumentationRunnerArgument(key, value);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use {@link InstrumentationOptions#addInstrumentationRunnerArguments(Map)}\n      ")
/*    */   public void testInstrumentationRunnerArguments(@NotNull Map<String, String> args)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(args, "args");
/*    */     variantAwareProperties.testInstrumentationRunnerArguments(args);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void testProguardFile(@NotNull Object proguardFile)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");
/*    */     variantAwareProperties.testProguardFile(proguardFile);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use postprocessingOptions")
/*    */   public void testProguardFiles(@NotNull Object... proguardFiles)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");
/*    */     variantAwareProperties.testProguardFiles(proguardFiles);
/*    */   }
/*    */   
/*    */   public void variantFilter(@NotNull Action<com.android.build.api.dsl.variant.VariantFilter> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.variantFilter(action);
/*    */   }
/*    */   
/*    */   public void vectorDrawables(@NotNull Action<com.android.build.api.dsl.options.VectorDrawablesOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     variantAwareProperties.vectorDrawables(action);
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @Deprecated(message="Use {@link #setWearAppUnbundled(Boolean)} ")
/*    */   public void wearAppUnbundled(@Nullable Boolean wearAppUnbundled)
/*    */   {
/*    */     variantAwareProperties.wearAppUnbundled(wearAppUnbundled);
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public String getTestBuildType()
/*    */   {
/*    */     return embeddedTestProperties.getTestBuildType();
/*    */   }
/*    */   
/*    */   public void setTestBuildType(@Nullable String <set-?>)
/*    */   {
/*    */     embeddedTestProperties.setTestBuildType(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.builder.model.TestOptions getTestOptions()
/*    */   {
/*    */     return embeddedTestProperties.getTestOptions();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @NotNull
/*    */   public org.gradle.api.DomainObjectSet<com.android.build.api.dsl.variant.TestVariant> getTestVariants()
/*    */   {
/*    */     return embeddedTestProperties.getTestVariants();
/*    */   }
/*    */   
/*    */   /**
/*    */    * @deprecated
/*    */    */
/*    */   @NotNull
/*    */   public org.gradle.api.DomainObjectSet<com.android.build.api.dsl.variant.UnitTestVariant> getUnitTestVariants()
/*    */   {
/*    */     return embeddedTestProperties.getUnitTestVariants();
/*    */   }
/*    */   
/*    */   public void testOptions(@NotNull Action<com.android.builder.model.TestOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     embeddedTestProperties.testOptions(action);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.builder.model.AdbOptions getAdbOptions()
/*    */   {
/*    */     return onDeviceTestProperties.getAdbOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<com.android.builder.testing.api.DeviceProvider> getDeviceProviders()
/*    */   {
/*    */     return onDeviceTestProperties.getDeviceProviders();
/*    */   }
/*    */   
/*    */   public void setDeviceProviders(@NotNull List<com.android.builder.testing.api.DeviceProvider> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     onDeviceTestProperties.setDeviceProviders(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public List<com.android.builder.testing.api.TestServer> getTestServers()
/*    */   {
/*    */     return onDeviceTestProperties.getTestServers();
/*    */   }
/*    */   
/*    */   public void setTestServers(@NotNull List<com.android.builder.testing.api.TestServer> <set-?>)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");
/*    */     onDeviceTestProperties.setTestServers(<set-?>);
/*    */   }
/*    */   
/*    */   public void adbOptions(@NotNull Action<com.android.builder.model.AdbOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     onDeviceTestProperties.adbOptions(action);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.extensions.LibraryExtensionImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */