/*     */ package com.android.build.gradle.tasks.factory;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.CompileOptions;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.scope.VariantScope.Java8LangSupport;
/*     */ import com.android.builder.model.DataBindingOptions;
/*     */ import com.android.sdklib.AndroidTargetHash;
/*     */ import com.android.sdklib.AndroidVersion;
/*     */ import com.android.utils.ILogger;
/*     */ import org.gradle.api.JavaVersion;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.artifacts.Configuration;
/*     */ import org.gradle.api.artifacts.DependencySet;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.logging.Logging;
/*     */ import org.gradle.api.plugins.PluginContainer;
/*     */ import org.gradle.api.tasks.compile.AbstractCompile;
/*     */ 
/*     */ public class AbstractCompilesUtil
/*     */ {
/*     */   public static final String ANDROID_APT_PLUGIN_NAME = "com.neenbedankt.android-apt";
/*     */   
/*     */   public static void configureLanguageLevel(AbstractCompile compileTask, CompileOptions compileOptions, String compileSdkVersion, VariantScope.Java8LangSupport java8LangSupport)
/*     */   {
/*  49 */     setDefaultJavaVersion(compileOptions, compileSdkVersion, java8LangSupport);
/*  50 */     compileTask.setSourceCompatibility(compileOptions.getSourceCompatibility().toString());
/*  51 */     compileTask.setTargetCompatibility(compileOptions.getTargetCompatibility().toString());
/*     */   }
/*     */   
/*     */   public static void setDefaultJavaVersion(CompileOptions compileOptions, String compileSdkVersion, VariantScope.Java8LangSupport java8LangSupport)
/*     */   {
/*  58 */     compileOptions.setDefaultJavaVersion(
/*  59 */       chooseDefaultJavaVersion(compileSdkVersion, 
/*     */       
/*  61 */       System.getProperty("java.specification.version"), java8LangSupport));
/*     */   }
/*     */   
/*     */   static JavaVersion chooseDefaultJavaVersion(String compileSdkVersion, String currentJdkVersion, VariantScope.Java8LangSupport java8LangSupport)
/*     */   {
/*  71 */     AndroidVersion hash = AndroidTargetHash.getVersionFromHash(compileSdkVersion);
/*  72 */     Integer compileSdkLevel = hash == null ? null : Integer.valueOf(hash.getFeatureLevel());
/*     */     JavaVersion javaVersionToUse;
/*     */     JavaVersion javaVersionToUse;
/*  75 */     if (compileSdkLevel == null) {
/*  76 */       javaVersionToUse = JavaVersion.VERSION_1_6;
/*     */     } else { JavaVersion javaVersionToUse;
/*  78 */       if ((0 < compileSdkLevel.intValue()) && (compileSdkLevel.intValue() <= 20)) {
/*  79 */         javaVersionToUse = JavaVersion.VERSION_1_6; } else { JavaVersion javaVersionToUse;
/*  80 */         if ((21 <= compileSdkLevel.intValue()) && (compileSdkLevel.intValue() < 24)) {
/*  81 */           javaVersionToUse = JavaVersion.VERSION_1_7;
/*     */         } else {
/*  83 */           javaVersionToUse = JavaVersion.VERSION_1_7;
/*     */         }
/*     */       }
/*     */     }
/*  87 */     JavaVersion jdkVersion = JavaVersion.toVersion(currentJdkVersion);
/*     */     
/*  89 */     if (jdkVersion.compareTo(javaVersionToUse) < 0) {
/*  90 */       Logging.getLogger(AbstractCompilesUtil.class).warn("Default language level for compileSdkVersion '{}' is {}, but the JDK used is {}, so the JDK language level will be used.", new Object[] { compileSdkVersion, javaVersionToUse, jdkVersion });
/*     */       
/*  96 */       javaVersionToUse = jdkVersion;
/*     */     }
/*  98 */     return javaVersionToUse;
/*     */   }
/*     */   
/*     */   public static boolean isIncremental(Project project, VariantScope variantScope, CompileOptions compileOptions, Configuration processorConfiguration, ILogger log)
/*     */   {
/* 110 */     boolean incremental = true;
/* 111 */     if (compileOptions.getIncremental() != null) {
/* 112 */       incremental = compileOptions.getIncremental().booleanValue();
/* 113 */       log.verbose("Incremental flag set to %1$b in DSL", new Object[] { Boolean.valueOf(incremental) });
/*     */     } else {
/* 115 */       if (processorConfiguration != null) {}
/*     */       
/* 117 */       boolean hasAnnotationProcessor = !processorConfiguration.getAllDependencies().isEmpty();
/* 118 */       if ((variantScope.getGlobalScope().getExtension().getDataBinding().isEnabled()) || (hasAnnotationProcessor) || 
/*     */       
/* 120 */         (project.getPlugins().hasPlugin("me.tatarka.retrolambda"))) {
/* 121 */         incremental = false;
/* 122 */         log.verbose("Incremental Java compilation disabled in variant %1$s as you are using an incompatible plugin", new Object[] {variantScope
/*     */         
/* 124 */           .getVariantConfiguration().getFullName() });
/*     */       }
/*     */     }
/* 127 */     return incremental;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.factory.AbstractCompilesUtil
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */