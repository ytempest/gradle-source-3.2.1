/*     */ package com.android.build.gradle.internal.test;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.VariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.BuildElements;
/*     */ import com.android.build.gradle.internal.scope.BuildOutput;
/*     */ import com.android.build.gradle.internal.scope.ExistingBuildElements;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.builder.testing.TestData;
/*     */ import com.android.sdklib.AndroidVersion;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableMap.Builder;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.io.File;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public abstract class AbstractTestDataImpl
/*     */   implements TestData
/*     */ {
/*     */   private final VariantConfiguration<?, ?, ?> testVariantConfig;
/*     */   private Map<String, String> extraInstrumentationTestRunnerArgs;
/*     */   private boolean animationsDisabled;
/*     */   protected final FileCollection testApkDir;
/*     */   protected final FileCollection testedApksDir;
/*     */   
/*     */   public AbstractTestDataImpl(VariantConfiguration<?, ?, ?> testVariantConfig, FileCollection testApkDir, FileCollection testedApksDir)
/*     */   {
/*  60 */     this.testVariantConfig = ((VariantConfiguration)Preconditions.checkNotNull(testVariantConfig));
/*  61 */     extraInstrumentationTestRunnerArgs = Maps.newHashMap();
/*  62 */     this.testApkDir = testApkDir;
/*  63 */     this.testedApksDir = testedApksDir;
/*     */   }
/*     */   
/*     */   public String getInstrumentationRunner()
/*     */   {
/*  69 */     return testVariantConfig.getInstrumentationRunner();
/*     */   }
/*     */   
/*     */   public Map<String, String> getInstrumentationRunnerArguments()
/*     */   {
/*  75 */     return 
/*     */     
/*  78 */       ImmutableMap.builder().putAll(testVariantConfig.getInstrumentationRunnerArguments()).putAll(extraInstrumentationTestRunnerArgs).build();
/*     */   }
/*     */   
/*     */   public void setExtraInstrumentationTestRunnerArgs(Map<String, String> extraInstrumentationTestRunnerArgs)
/*     */   {
/*  84 */     this.extraInstrumentationTestRunnerArgs = ImmutableMap.copyOf(extraInstrumentationTestRunnerArgs);
/*     */   }
/*     */   
/*     */   public boolean getAnimationsDisabled()
/*     */   {
/*  90 */     return animationsDisabled;
/*     */   }
/*     */   
/*     */   public void setAnimationsDisabled(boolean animationsDisabled) {
/*  94 */     this.animationsDisabled = animationsDisabled;
/*     */   }
/*     */   
/*     */   public boolean isTestCoverageEnabled()
/*     */   {
/*  99 */     return testVariantConfig.isTestCoverageEnabled();
/*     */   }
/*     */   
/*     */   public AndroidVersion getMinSdkVersion()
/*     */   {
/* 105 */     return testVariantConfig.getMinSdkVersion();
/*     */   }
/*     */   
/*     */   public String getFlavorName()
/*     */   {
/* 111 */     return testVariantConfig.getFlavorName().toUpperCase(Locale.getDefault());
/*     */   }
/*     */   
/*     */   public FileCollection getTestApkDir()
/*     */   {
/* 121 */     return testApkDir;
/*     */   }
/*     */   
/*     */   public FileCollection getTestedApksDir()
/*     */   {
/* 133 */     return testedApksDir;
/*     */   }
/*     */   
/*     */   public File getTestApk()
/*     */   {
/* 142 */     BuildElements testApkOutputs = ExistingBuildElements.from(TaskOutputHolder.TaskOutputType.APK, testApkDir);
/* 143 */     if (testApkOutputs.size() != 1)
/*     */     {
/* 148 */       throw new RuntimeException("Unexpected number of main APKs, expected 1, got  " + testApkOutputs.size() + ":" + Joiner.on(",").join(testApkOutputs));
/*     */     }
/* 150 */     return ((BuildOutput)testApkOutputs.iterator().next()).getOutputFile();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.AbstractTestDataImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */