/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.Abi;
/*     */ import com.android.build.gradle.internal.ndk.NdkHandler;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.ide.common.process.ProcessException;
/*     */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.Builder;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ 
/*     */ class CmakeAndroidNinjaExternalNativeJsonGenerator
/*     */   extends CmakeExternalNativeJsonGenerator
/*     */ {
/*     */   CmakeAndroidNinjaExternalNativeJsonGenerator(NdkHandler ndkHandler, int minSdkVersion, String variantName, Collection<Abi> abis, AndroidBuilder androidBuilder, File sdkFolder, File ndkFolder, File soFolder, File objFolder, File jsonFolder, File makeFile, File cmakeInstallFolder, boolean debuggable, List<String> buildArguments, List<String> cFlags, List<String> cppFlags, List<File> nativeBuildConfigurationsJsons, GradleBuildVariant.Builder stats)
/*     */   {
/*  58 */     super(ndkHandler, minSdkVersion, variantName, abis, androidBuilder, sdkFolder, ndkFolder, soFolder, objFolder, jsonFolder, makeFile, cmakeInstallFolder, debuggable, buildArguments, cFlags, cppFlags, nativeBuildConfigurationsJsons, stats);
/*     */   }
/*     */   
/*     */   List<String> getCacheArguments(String abi, int abiPlatformVersion)
/*     */   {
/*  82 */     List<String> cacheArguments = getCommonCacheArguments(abi, abiPlatformVersion);
/*     */     
/*  84 */     cacheArguments.add(
/*  85 */       String.format("-DCMAKE_TOOLCHAIN_FILE=%s", new Object[] {getToolChainFile().getAbsolutePath() }));
/*  86 */     cacheArguments.add(
/*  87 */       String.format("-DCMAKE_MAKE_PROGRAM=%s", new Object[] {getNinjaExecutable().getAbsolutePath() }));
/*  88 */     cacheArguments.add("-GAndroid Gradle - Ninja");
/*  89 */     return cacheArguments;
/*     */   }
/*     */   
/*     */   public String executeProcessAndGetOutput(String abi, int abiPlatformVersion, File outputJsonDir)
/*     */     throws ProcessException, IOException
/*     */   {
/*  97 */     return ExternalNativeBuildTaskUtils.executeBuildProcessAndLogError(androidBuilder, 
/*  98 */       getProcessBuilder(abi, abiPlatformVersion, outputJsonDir), true);
/*     */   }
/*     */   
/*     */   private File getNinjaExecutable()
/*     */   {
/* 104 */     if (isWindows()) {
/* 105 */       return new File(getCmakeBinFolder(), "ninja.exe");
/*     */     }
/* 107 */     return new File(getCmakeBinFolder(), "ninja");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.CmakeAndroidNinjaExternalNativeJsonGenerator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */