/*    */ package com.android.build.gradle.internal.api.dsl.extensions;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import kotlin.Deprecated;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000Â\003\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\b\n\002\020!\n\002\030\002\n\002\b\b\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\t\n\002\020\013\n\002\b\005\n\002\020\"\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020%\n\002\020\000\n\002\b\005\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\020\036\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\027\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\034\n\002\020$\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020 \n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\016\n\002\020\002\n\002\b\b\n\002\020\021\n\002\b\023\n\002\020\034\n\002\b\022\030\0002\0020\0012\0020\0022\0020\0032\0020\0042\0020\0052\0020\0062\0020\0072\0020\b2\0020\tB=\022\006\020\n\032\0020\013\022\006\020\f\032\0020\r\022\006\020\016\032\0020\017\022\006\020\020\032\0020\021\022\006\020\022\032\0020\023\022\006\020\024\032\0020\025\022\006\020\026\032\0020\027¢\006\002\020\030J\032\020\031\032\0030\0022\016\020 \002\032\t\022\004\022\0020\0320\001H\001J\032\020\035\032\0030\0022\016\020 \002\032\t\022\004\022\0020\0360\001H\001J&\020¡\002\032\0030\0022\007\020¢\002\032\0020\"2\007\020£\002\032\0020\"2\007\020Ò\001\032\0020\"H\001J \0204\032\0030\0022\024\020 \002\032\017\022\n\022\b\022\004\022\00206050\001H\001J\032\0209\032\0030\0022\016\020 \002\032\t\022\004\022\0020:0\001H\001J\024\020¤\002\032\0030\0022\007\020¥\002\032\0020rH\001J'\020¦\002\032\0030\0022\024\020§\002\032\013\022\006\b\001\022\0020r0¨\002\"\0020rH\001¢\006\003\020©\002J\032\020@\032\0030\0022\016\020 \002\032\t\022\004\022\0020A0\001H\001J\032\020D\032\0030\0022\016\020 \002\032\t\022\004\022\0020E0\001H\001J\032\020L\032\0030\0022\016\020 \002\032\t\022\004\022\0020M0\001H\001J\033\020ª\002\032\0030\0022\016\020 \002\032\t\022\004\022\0020Q0\001H\001J\032\020P\032\0030\0022\016\020 \002\032\t\022\004\022\0020Q0\001H\001J\032\020d\032\0030\0022\016\020 \002\032\t\022\004\022\0020e0\001H\001J\032\020h\032\0030\0022\016\020 \002\032\t\022\004\022\0020i0\001H\001J\032\020l\032\0030\0022\016\020 \002\032\t\022\004\022\0020m0\001H\001J\022\020}\032\0030\0022\006\020}\032\0020xH\001J\022\020}\032\0030\0022\006\020}\032\0020\"H\001J0\020«\002\032\0030\0022\007\020¬\002\032\0020\"2\024\020­\002\032\013\022\006\b\001\022\0020\"0¨\002\"\0020\"H\001¢\006\003\020®\002J\035\020«\002\032\0030\0022\007\020¬\002\032\0020\"2\007\020¯\002\032\0020\"H\001J$\020«\002\032\0030\0022\007\020¬\002\032\0020\"2\016\020­\002\032\t\022\004\022\0020\"0ý\001H\001J\034\020\001\032\0030\0022\017\020 \002\032\n\022\005\022\0030\0010\001H\001J\034\020\001\032\0030\0022\017\020 \002\032\n\022\005\022\0030\0010\001H\001J\034\020\001\032\0030\0022\017\020 \002\032\n\022\005\022\0030\0010\001H\001J#\020°\002\032\0030\0022\026\020 \002\032\021\022\f\022\n\022\005\022\0030 \0010\0010\001H\001J\034\020±\002\032\0030\0022\017\020 \002\032\n\022\005\022\0030¤\0010\001H\001J\"\020§\001\032\0030\0022\025\020 \002\032\020\022\013\022\t\022\005\022\0030¨\001050\001H\001J\024\020¥\002\032\0030\0022\007\020¥\002\032\0020rH\001J'\020§\002\032\0030\0022\024\020²\002\032\013\022\006\b\001\022\0020r0¨\002\"\0020rH\001¢\006\003\020©\002J\025\020³\002\032\0030\0022\b\020´\002\032\0030þ\001H\001J1\020³\002\032\0030\0022\b\020´\002\032\0030þ\0012\024\020µ\002\032\013\022\006\b\001\022\0020r0¨\002\"\0020rH\001¢\006\003\020¶\002J&\020·\002\032\0030\0022\007\020¢\002\032\0020\"2\007\020£\002\032\0020\"2\007\020Ò\001\032\0020\"H\001J\n\020¸\002\032\0030\002H\026J\023\020?\032\0030\0022\007\020¹\002\032\0020xH\001J\033\020º\002\032\0030\0022\016\020»\002\032\t\022\004\022\0020r0¼\002H\001J\035\020½\002\032\0030\0022\020\020¾\002\032\013\022\004\022\0020\"\030\0010¼\002H\001J\023\020\001\032\0030\0022\006\020}\032\0020xH\001J\023\020\001\032\0030\0022\006\020}\032\0020\"H\001J\033\020¿\002\032\0030\0022\016\020»\002\032\t\022\004\022\0020r0¼\002H\001J\024\020Ø\001\032\0030\0022\007\020Ö\001\032\0020xH\001J\024\020Ø\001\032\0030\0022\007\020Ö\001\032\0020\"H\001J\024\020À\002\032\0030\0022\007\020Á\002\032\0020[H\001J\024\020Â\002\032\0030\0022\007\020Ã\002\032\0020[H\001J\033\020Ä\002\032\0030\0022\016\020²\002\032\t\022\004\022\0020r0¼\002H\001J\034\020Å\002\032\0030\0022\017\020 \002\032\n\022\005\022\0030À\0010\001H\001J\"\020É\001\032\0030\0022\025\020 \002\032\020\022\013\022\t\022\005\022\0030Ä\001050\001H\001J\"\020Ë\001\032\0030\0022\025\020 \002\032\020\022\013\022\t\022\005\022\0030Ì\001050\001H\001J\034\020Î\001\032\0030\0022\017\020 \002\032\n\022\005\022\0030Ï\0010\001H\001J\024\020Ö\001\032\0030\0022\007\020Ö\001\032\0020xH\001J\024\020Ö\001\032\0030\0022\007\020Ö\001\032\0020\"H\001J\035\020Æ\002\032\0030\0022\007\020Ç\002\032\0020\"2\007\020Ò\001\032\0020\"H\001J!\020ë\001\032\0030\0022\024\020È\002\032\017\022\004\022\0020\"\022\004\022\0020\"0ì\001H\001J\034\020ï\001\032\0030\0022\017\020 \002\032\n\022\005\022\0030ð\0010\001H\001J\024\020É\002\032\0030\0022\007\020¥\002\032\0020rH\001J'\020Ê\002\032\0030\0022\024\020§\002\032\013\022\006\b\001\022\0020r0¨\002\"\0020rH\001¢\006\003\020©\002J\024\020Ë\002\032\0030\0022\007\020£\002\032\0020\"H\001J\035\020Ë\002\032\0030\0022\007\020£\002\032\0020\"2\007\020Ì\002\032\0020[H\001J\034\020Í\002\032\0030\0022\017\020 \002\032\n\022\005\022\0030\0020\001H\001J\034\020\002\032\0030\0022\017\020 \002\032\n\022\005\022\0030\0020\001H\001J\034\020\002\032\0030\0022\t\020\002\032\004\030\0010[H\001¢\006\003\020\001R\022\020\031\032\0020\032X\005¢\006\006\032\004\b\033\020\034R\022\020\035\032\0020\036X\005¢\006\006\032\004\b\037\020 R\016\020\020\032\0020\021X\004¢\006\002\n\000R\032\020!\032\004\030\0010\"X\017¢\006\f\032\004\b#\020$\"\004\b%\020&R\032\020'\032\004\030\0010\"X\017¢\006\f\032\004\b(\020$\"\004\b)\020&R\036\020*\032\b\022\004\022\0020,0+X\017¢\006\f\032\004\b-\020.\"\004\b/\0200R\016\020\n\032\0020\013X\004¢\006\002\n\000R\032\0201\032\004\030\0010\"X\017¢\006\f\032\004\b2\020$\"\004\b3\020&R\030\0204\032\b\022\004\022\0020605X\005¢\006\006\032\004\b7\0208R\022\0209\032\0020:X\005¢\006\006\032\004\b;\020<R\032\020=\032\004\030\0010\"X\017¢\006\f\032\004\b>\020$\"\004\b?\020&R\022\020@\032\0020AX\005¢\006\006\032\004\bB\020CR\024\020D\032\0020E8\026X\005¢\006\006\032\004\bF\020GR\036\020H\032\b\022\004\022\0020I0+X\017¢\006\f\032\004\bJ\020.\"\004\bK\0200R\022\020L\032\0020MX\005¢\006\006\032\004\bN\020OR\016\020\022\032\0020\023X\004¢\006\002\n\000R\022\020P\032\0020QX\005¢\006\006\032\004\bR\020SR\"\020T\032\b\022\004\022\0020\"0+8\026@\026X\017¢\006\f\032\004\bU\020.\"\004\bV\0200R\036\020W\032\b\022\004\022\0020\"0+X\017¢\006\f\032\004\bX\020.\"\004\bY\0200R\030\020Z\032\0020[X\017¢\006\f\032\004\b\\\020]\"\004\b^\020_R\034\020`\032\n\022\004\022\0020\"\030\0010a8\026X\005¢\006\006\032\004\bb\020cR\022\020d\032\0020eX\005¢\006\006\032\004\bf\020gR\022\020h\032\0020iX\005¢\006\006\032\004\bj\020kR\022\020l\032\0020mX\005¢\006\006\032\004\bn\020oR$\020p\032\016\022\004\022\0020\"\022\004\022\0020r0qX\017¢\006\f\032\004\bs\020t\"\004\bu\020vR\032\020w\032\004\030\0010xX\017¢\006\f\032\004\by\020z\"\004\b{\020|R\035\020}\032\004\030\0010~X\017¢\006\017\032\005\b\020\001\"\006\b\001\020\001R\037\020\001\032\004\030\0010[X\017¢\006\020\032\006\b\001\020\001\"\006\b\001\020\001R \020\001\032\005\030\0010\001X\017¢\006\020\032\006\b\001\020\001\"\006\b\001\020\001R \020\001\032\005\030\0010\001X\017¢\006\020\032\006\b\001\020\001\"\006\b\001\020\001R\026\020\001\032\0030\001X\005¢\006\b\032\006\b\001\020\001R\016\020\024\032\0020\025X\004¢\006\002\n\000R\026\020\001\032\0030\001X\005¢\006\b\032\006\b\001\020\001R\026\020\001\032\0030\001X\005¢\006\b\032\006\b\001\020\001R0\020\001\032\027\022\023\022\021\022\f\022\n\022\005\022\0030 \0010\0010\0010+X\017¢\006\016\032\005\b¡\001\020.\"\005\b¢\001\0200R)\020£\001\032\020\022\f\022\n\022\005\022\0030¤\0010\0010+X\017¢\006\016\032\005\b¥\001\020.\"\005\b¦\001\0200R\033\020§\001\032\t\022\005\022\0030¨\00105X\005¢\006\007\032\005\b©\001\0208R\037\020ª\001\032\004\030\0010[X\017¢\006\020\032\006\b«\001\020\001\"\006\b¬\001\020\001R\037\020­\001\032\004\030\0010[X\017¢\006\020\032\006\b®\001\020\001\"\006\b¯\001\020\001R\037\020°\001\032\004\030\0010[X\017¢\006\020\032\006\b±\001\020\001\"\006\b²\001\020\001R\035\020³\001\032\004\030\0010xX\017¢\006\016\032\005\b´\001\020z\"\005\bµ\001\020|R!\020¶\001\032\b\022\004\022\0020\"0+X\017¢\006\016\032\005\b·\001\020.\"\005\b¸\001\0200R!\020¹\001\032\b\022\004\022\0020,0+X\017¢\006\016\032\005\bº\001\020.\"\005\b»\001\0200R\035\020¼\001\032\004\030\0010\"X\017¢\006\016\032\005\b½\001\020$\"\005\b¾\001\020&R\026\020¿\001\032\0030À\001X\005¢\006\b\032\006\bÁ\001\020Â\001R \020Ã\001\032\005\030\0010Ä\001X\017¢\006\020\032\006\bÅ\001\020Æ\001\"\006\bÇ\001\020È\001R\033\020É\001\032\t\022\005\022\0030Ä\00105X\005¢\006\007\032\005\bÊ\001\0208R\033\020Ë\001\032\t\022\005\022\0030Ì\00105X\005¢\006\007\032\005\bÍ\001\0208R\026\020Î\001\032\0030Ï\001X\005¢\006\b\032\006\bÐ\001\020Ñ\001R,\020Ó\001\032\004\030\0010\"2\t\020Ò\001\032\004\030\0010\"@VX\016¢\006\020\n\000\032\005\bÔ\001\020$\"\005\bÕ\001\020&R\037\020Ö\001\032\004\030\0010~X\017¢\006\020\032\006\b×\001\020\001\"\006\bØ\001\020\001R6\020Ù\001\032\004\030\0010\"2\t\020Ò\001\032\004\030\0010\"8\026@VX\016¢\006\030\n\000\022\006\bÚ\001\020Û\001\032\005\bÜ\001\020$\"\005\bÝ\001\020&R!\020Þ\001\032\004\030\0010\"8\026@\026X\017¢\006\016\032\005\bß\001\020$\"\005\bà\001\020&R\035\020á\001\032\004\030\0010\"X\017¢\006\016\032\005\bâ\001\020$\"\005\bã\001\020&R\031\020ä\001\032\004\030\0010[8\026X\005¢\006\b\032\006\bå\001\020\001R\031\020æ\001\032\004\030\0010[8\026X\005¢\006\b\032\006\bç\001\020\001R!\020è\001\032\004\030\0010\"8\026@\026X\017¢\006\016\032\005\bé\001\020$\"\005\bê\001\020&R,\020ë\001\032\017\022\004\022\0020\"\022\004\022\0020\"0ì\0018\026@\026X\017¢\006\016\032\005\bí\001\020t\"\005\bî\001\020vR\026\020ï\001\032\0030ð\001X\005¢\006\b\032\006\bñ\001\020ò\001R\"\020ó\001\032\t\022\005\022\0030ô\0010+X\017¢\006\016\032\005\bõ\001\020.\"\005\bö\001\0200R\037\020÷\001\032\n\022\005\022\0030ù\0010ø\0018\026X\005¢\006\b\032\006\bú\001\020û\001R\034\020ü\001\032\n\022\005\022\0030þ\0010ý\001X\005¢\006\007\032\005\bÿ\001\020.R\"\020\002\032\020\022\013\022\t\022\004\022\0020r0ý\0010ý\001X\005¢\006\007\032\005\b\002\020.R\037\020\002\032\n\022\005\022\0030\0020ø\0018\026X\005¢\006\b\032\006\b\002\020û\001R\016\020\016\032\0020\017X\004¢\006\002\n\000R\026\020\f\032\0020\rX\004¢\006\n\n\000\032\006\b\002\020\002R)\020\002\032\020\022\f\022\n\022\005\022\0030\0020\0010+X\017¢\006\016\032\005\b\002\020.\"\005\b\002\0200R\035\020\002\032\n\022\005\022\0030 \0010\002X\005¢\006\b\032\006\b\002\020\002R\026\020\002\032\0030\002X\005¢\006\b\032\006\b\002\020\002R\035\020\002\032\004\030\0010xX\017¢\006\016\032\005\b\002\020z\"\005\b\002\020|R\035\020\002\032\004\030\0010\"X\017¢\006\016\032\005\b\002\020$\"\005\b\002\020&R\035\020\002\032\004\030\0010\"X\017¢\006\016\032\005\b\002\020$\"\005\b\002\020&R\037\020\002\032\004\030\0010[X\017¢\006\020\032\006\b\002\020\001\"\006\b\002\020\001¨\006Î\002"}, d2={"Lcom/android/build/gradle/internal/api/dsl/extensions/TestExtensionImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/extension/TestExtension;", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "Lcom/android/build/api/dsl/extension/BuildProperties;", "Lcom/android/build/api/dsl/extension/VariantOrExtensionProperties;", "Lcom/android/build/api/dsl/extension/VariantAwareProperties;", "Lcom/android/build/api/dsl/extension/ApkProperties;", "Lcom/android/build/api/dsl/extension/EmbeddedTestProperties;", "Lcom/android/build/api/dsl/extension/OnDeviceTestProperties;", "buildProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/BuildPropertiesImpl;", "variantExtensionProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "variantAwareProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantAwarePropertiesImpl;", "apkPropertiesImpl", "Lcom/android/build/gradle/internal/api/dsl/extensions/ApkPropertiesImpl;", "embeddedTestProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/EmbeddedTestPropertiesImpl;", "onDeviceTestProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/OnDeviceTestPropertiesImpl;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/api/dsl/extensions/BuildPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/VariantAwarePropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/ApkPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/EmbeddedTestPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/OnDeviceTestPropertiesImpl;Lcom/android/builder/errors/EvalIssueReporter;)V", "aaptOptions", "Lcom/android/build/api/dsl/options/AaptOptions;", "getAaptOptions", "()Lcom/android/build/api/dsl/options/AaptOptions;", "adbOptions", "Lcom/android/builder/model/AdbOptions;", "getAdbOptions", "()Lcom/android/builder/model/AdbOptions;", "applicationId", "", "getApplicationId", "()Ljava/lang/String;", "setApplicationId", "(Ljava/lang/String;)V", "applicationIdSuffix", "getApplicationIdSuffix", "setApplicationIdSuffix", "buildConfigFields", "", "Lcom/android/build/api/dsl/model/TypedValue;", "getBuildConfigFields", "()Ljava/util/List;", "setBuildConfigFields", "(Ljava/util/List;)V", "buildToolsVersion", "getBuildToolsVersion", "setBuildToolsVersion", "buildTypes", "Lorg/gradle/api/NamedDomainObjectContainer;", "Lcom/android/build/api/dsl/model/BuildType;", "getBuildTypes", "()Lorg/gradle/api/NamedDomainObjectContainer;", "compileOptions", "Lcom/android/build/api/dsl/options/CompileOptions;", "getCompileOptions", "()Lcom/android/build/api/dsl/options/CompileOptions;", "compileSdkVersion", "getCompileSdkVersion", "setCompileSdkVersion", "dataBinding", "Lcom/android/builder/model/DataBindingOptions;", "getDataBinding", "()Lcom/android/builder/model/DataBindingOptions;", "defaultConfig", "Lcom/android/build/api/dsl/model/DefaultConfig;", "getDefaultConfig", "()Lcom/android/build/api/dsl/model/DefaultConfig;", "deviceProviders", "Lcom/android/builder/testing/api/DeviceProvider;", "getDeviceProviders", "setDeviceProviders", "dexOptions", "Lcom/android/build/api/dsl/options/DexOptions;", "getDexOptions", "()Lcom/android/build/api/dsl/options/DexOptions;", "externalNativeBuildOptions", "Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "getExternalNativeBuildOptions", "()Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "flavorDimensionList", "getFlavorDimensionList", "setFlavorDimensionList", "flavorDimensions", "getFlavorDimensions", "setFlavorDimensions", "generatePureSplits", "", "getGeneratePureSplits", "()Z", "setGeneratePureSplits", "(Z)V", "generatedDensities", "", "getGeneratedDensities", "()Ljava/util/Set;", "instrumentationOptions", "Lcom/android/build/api/dsl/options/InstrumentationOptions;", "getInstrumentationOptions", "()Lcom/android/build/api/dsl/options/InstrumentationOptions;", "javaCompileOptions", "Lcom/android/build/api/dsl/options/JavaCompileOptions;", "getJavaCompileOptions", "()Lcom/android/build/api/dsl/options/JavaCompileOptions;", "lintOptions", "Lcom/android/build/api/dsl/options/LintOptions;", "getLintOptions", "()Lcom/android/build/api/dsl/options/LintOptions;", "manifestPlaceholders", "", "", "getManifestPlaceholders", "()Ljava/util/Map;", "setManifestPlaceholders", "(Ljava/util/Map;)V", "maxSdkVersion", "", "getMaxSdkVersion", "()Ljava/lang/Integer;", "setMaxSdkVersion", "(Ljava/lang/Integer;)V", "minSdkVersion", "Lcom/android/build/api/dsl/ApiVersion;", "getMinSdkVersion", "()Lcom/android/build/api/dsl/ApiVersion;", "setMinSdkVersion", "(Lcom/android/build/api/dsl/ApiVersion;)V", "multiDexEnabled", "getMultiDexEnabled", "()Ljava/lang/Boolean;", "setMultiDexEnabled", "(Ljava/lang/Boolean;)V", "multiDexKeepFile", "Ljava/io/File;", "getMultiDexKeepFile", "()Ljava/io/File;", "setMultiDexKeepFile", "(Ljava/io/File;)V", "multiDexKeepProguard", "getMultiDexKeepProguard", "setMultiDexKeepProguard", "ndkOptions", "Lcom/android/build/api/dsl/options/NdkOptions;", "getNdkOptions", "()Lcom/android/build/api/dsl/options/NdkOptions;", "packagingOptions", "Lcom/android/build/api/dsl/options/PackagingOptions;", "getPackagingOptions", "()Lcom/android/build/api/dsl/options/PackagingOptions;", "postProcessing", "Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "getPostProcessing", "()Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "postVariants", "Lorg/gradle/api/Action;", "", "Lcom/android/build/api/dsl/variant/Variant;", "getPostVariants", "setPostVariants", "preVariantCallbacks", "Ljava/lang/Void;", "getPreVariantCallbacks", "setPreVariantCallbacks", "productFlavors", "Lcom/android/build/api/dsl/model/ProductFlavor;", "getProductFlavors", "renderscriptNdkModeEnabled", "getRenderscriptNdkModeEnabled", "setRenderscriptNdkModeEnabled", "renderscriptSupportModeBlasEnabled", "getRenderscriptSupportModeBlasEnabled", "setRenderscriptSupportModeBlasEnabled", "renderscriptSupportModeEnabled", "getRenderscriptSupportModeEnabled", "setRenderscriptSupportModeEnabled", "renderscriptTargetApi", "getRenderscriptTargetApi", "setRenderscriptTargetApi", "resConfigs", "getResConfigs", "setResConfigs", "resValues", "getResValues", "setResValues", "resourcePrefix", "getResourcePrefix", "setResourcePrefix", "shaders", "Lcom/android/build/api/dsl/options/ShaderOptions;", "getShaders", "()Lcom/android/build/api/dsl/options/ShaderOptions;", "signingConfig", "Lcom/android/build/api/dsl/options/SigningConfig;", "getSigningConfig", "()Lcom/android/build/api/dsl/options/SigningConfig;", "setSigningConfig", "(Lcom/android/build/api/dsl/options/SigningConfig;)V", "signingConfigs", "getSigningConfigs", "sourceSets", "Lcom/android/build/api/sourcesets/AndroidSourceSet;", "getSourceSets", "splits", "Lcom/android/build/api/dsl/options/Splits;", "getSplits", "()Lcom/android/build/api/dsl/options/Splits;", "value", "targetProjectPath", "getTargetProjectPath", "setTargetProjectPath", "targetSdkVersion", "getTargetSdkVersion", "setTargetSdkVersion", "targetVariant", "targetVariant$annotations", "()V", "getTargetVariant", "setTargetVariant", "testApplicationId", "getTestApplicationId", "setTestApplicationId", "testBuildType", "getTestBuildType", "setTestBuildType", "testFunctionalTest", "getTestFunctionalTest", "testHandleProfiling", "getTestHandleProfiling", "testInstrumentationRunner", "getTestInstrumentationRunner", "setTestInstrumentationRunner", "testInstrumentationRunnerArguments", "", "getTestInstrumentationRunnerArguments", "setTestInstrumentationRunnerArguments", "testOptions", "Lcom/android/builder/model/TestOptions;", "getTestOptions", "()Lcom/android/builder/model/TestOptions;", "testServers", "Lcom/android/builder/testing/api/TestServer;", "getTestServers", "setTestServers", "testVariants", "Lorg/gradle/api/DomainObjectSet;", "Lcom/android/build/api/dsl/variant/TestVariant;", "getTestVariants", "()Lorg/gradle/api/DomainObjectSet;", "transforms", "", "Lcom/android/build/api/transform/Transform;", "getTransforms", "transformsDependencies", "getTransformsDependencies", "unitTestVariants", "Lcom/android/build/api/dsl/variant/UnitTestVariant;", "getUnitTestVariants", "getVariantExtensionProperties", "()Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "variantFilters", "Lcom/android/build/api/dsl/variant/VariantFilter;", "getVariantFilters", "setVariantFilters", "variants", "Lcom/android/build/api/dsl/extension/VariantCallbackHandler;", "getVariants", "()Lcom/android/build/api/dsl/extension/VariantCallbackHandler;", "vectorDrawables", "Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "getVectorDrawables", "()Lcom/android/build/api/dsl/options/VectorDrawablesOptions;", "versionCode", "getVersionCode", "setVersionCode", "versionName", "getVersionName", "setVersionName", "versionNameSuffix", "getVersionNameSuffix", "setVersionNameSuffix", "wearAppUnbundled", "getWearAppUnbundled", "setWearAppUnbundled", "", "action", "buildConfigField", "type", "name", "consumerProguardFile", "proguardFile", "consumerProguardFiles", "proguardFiles", "", "([Ljava/lang/Object;)V", "externalNativeBuild", "missingDimensionStrategy", "dimension", "requestedValues", "(Ljava/lang/String;[Ljava/lang/String;)V", "requestedValue", "postVariantCallback", "preVariantCallback", "files", "registerTransform", "transform", "dependencies", "(Lcom/android/build/api/transform/Transform;[Ljava/lang/Object;)V", "resValue", "seal", "apiLevel", "setConsumerProguardFiles", "proguardFileIterable", "", "setGeneratedDensities", "densities", "setProguardFiles", "setTestFunctionalTest", "functionalTest", "setTestHandleProfiling", "handleProfiling", "setTestProguardFiles", "shaderOptions", "testInstrumentationRunnerArgument", "key", "args", "testProguardFile", "testProguardFiles", "useLibrary", "required", "variantFilter", "gradle-core"})
/*    */ public final class TestExtensionImpl extends com.android.build.gradle.internal.api.dsl.sealing.SealableObject implements com.android.build.api.dsl.extension.TestExtension, BaseExtension2, com.android.build.api.dsl.extension.BuildProperties, com.android.build.api.dsl.extension.VariantOrExtensionProperties, com.android.build.api.dsl.extension.VariantAwareProperties, com.android.build.api.dsl.extension.ApkProperties, com.android.build.api.dsl.extension.EmbeddedTestProperties, com.android.build.api.dsl.extension.OnDeviceTestProperties
/*    */ {
/*    */   @Nullable
/*    */   private String targetProjectPath;
/*    */   @Nullable
/*    */   private String targetVariant;
/*    */   private final BuildPropertiesImpl buildProperties;
/*    */   @NotNull
/*    */   private final VariantOrExtensionPropertiesImpl variantExtensionProperties;
/*    */   private final VariantAwarePropertiesImpl variantAwareProperties;
/*    */   private final ApkPropertiesImpl apkPropertiesImpl;
/*    */   private final EmbeddedTestPropertiesImpl embeddedTestProperties;
/*    */   private final OnDeviceTestPropertiesImpl onDeviceTestProperties;
/*    */   
/*    */   @NotNull
/*    */   public VariantOrExtensionPropertiesImpl getVariantExtensionProperties()
/*    */   {
/* 31 */     return variantExtensionProperties;
/*    */   }
/*    */   
/*    */   public TestExtensionImpl(@NotNull BuildPropertiesImpl buildProperties, @NotNull VariantOrExtensionPropertiesImpl variantExtensionProperties, @NotNull VariantAwarePropertiesImpl variantAwareProperties, @NotNull ApkPropertiesImpl apkPropertiesImpl, @NotNull EmbeddedTestPropertiesImpl embeddedTestProperties, @NotNull OnDeviceTestPropertiesImpl onDeviceTestProperties, @NotNull com.android.builder.errors.EvalIssueReporter issueReporter)
/*    */   {
/* 37 */     super(issueReporter);this.buildProperties = buildProperties;this.variantExtensionProperties = variantExtensionProperties;this.variantAwareProperties = variantAwareProperties;this.apkPropertiesImpl = apkPropertiesImpl;this.embeddedTestProperties = embeddedTestProperties;this.onDeviceTestProperties = onDeviceTestProperties;
/*    */   }
/*    */   
/*    */   public void seal()
/*    */   {
/* 48 */     super.seal();
/*    */     
/* 50 */     buildProperties.seal();
/* 51 */     getVariantExtensionProperties().seal();
/* 52 */     variantAwareProperties.seal();
/* 53 */     apkPropertiesImpl.seal();
/* 54 */     embeddedTestProperties.seal();
/* 55 */     onDeviceTestProperties.seal(); }
/*    */   
/*    */   @Nullable
/* 58 */   public String getTargetProjectPath() { return targetProjectPath; }
/*    */   
/* 60 */   public void setTargetProjectPath(@Nullable String value) { if (checkSeal()) {
/* 61 */       targetProjectPath = value;
/*    */     }
/*    */   }
/*    */   
/*    */   @Nullable
/* 66 */   public String getTargetVariant() { return targetVariant; }
/*    */   
/* 68 */   public void setTargetVariant(@Nullable String value) { if (checkSeal()) {
/* 69 */       targetVariant = value;
/*    */     }
/*    */   }
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
/*    */   public com.android.build.api.dsl.ApiVersion getMinSdkVersion()
/*    */   {
/*    */     return variantAwareProperties.getMinSdkVersion();
/*    */   }
/*    */   
/*    */   public void setMinSdkVersion(@Nullable com.android.build.api.dsl.ApiVersion <set-?>)
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
/*    */   public List<Action<java.util.Collection<com.android.build.api.dsl.variant.Variant>>> getPostVariants()
/*    */   {
/*    */     return variantAwareProperties.getPostVariants();
/*    */   }
/*    */   
/*    */   public void setPostVariants(@NotNull List<Action<java.util.Collection<com.android.build.api.dsl.variant.Variant>>> <set-?>)
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
/*    */   public com.android.build.api.dsl.ApiVersion getTargetSdkVersion()
/*    */   {
/*    */     return variantAwareProperties.getTargetSdkVersion();
/*    */   }
/*    */   
/*    */   public void setTargetSdkVersion(@Nullable com.android.build.api.dsl.ApiVersion <set-?>)
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
/*    */   public void postVariantCallback(@NotNull Action<java.util.Collection<com.android.build.api.dsl.variant.Variant>> action)
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
/*    */   public boolean getGeneratePureSplits()
/*    */   {
/*    */     return apkPropertiesImpl.getGeneratePureSplits();
/*    */   }
/*    */   
/*    */   public void setGeneratePureSplits(boolean <set-?>)
/*    */   {
/*    */     apkPropertiesImpl.setGeneratePureSplits(<set-?>);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.PackagingOptions getPackagingOptions()
/*    */   {
/*    */     return apkPropertiesImpl.getPackagingOptions();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public com.android.build.api.dsl.options.Splits getSplits()
/*    */   {
/*    */     return apkPropertiesImpl.getSplits();
/*    */   }
/*    */   
/*    */   public void packagingOptions(@NotNull Action<com.android.build.api.dsl.options.PackagingOptions> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     apkPropertiesImpl.packagingOptions(action);
/*    */   }
/*    */   
/*    */   public void splits(@NotNull Action<com.android.build.api.dsl.options.Splits> action)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(action, "action");
/*    */     apkPropertiesImpl.splits(action);
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
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.extensions.TestExtensionImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */