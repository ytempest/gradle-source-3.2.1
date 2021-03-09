/*     */ package com.android.build.gradle.internal.test;
/*     */ 
/*     */ import com.android.build.OutputFile;
/*     */ import com.android.build.VariantOutput.OutputType;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.core.VariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.ExistingBuildElements;
/*     */ import com.android.build.gradle.internal.scope.OutputScope;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.internal.variant.TestVariantData;
/*     */ import com.android.build.gradle.internal.variant.TestedVariantData;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.model.SourceProvider;
/*     */ import com.android.builder.testing.api.DeviceConfigProvider;
/*     */ import com.android.ide.common.build.SplitOutputMatcher;
/*     */ import com.android.ide.common.process.ProcessException;
/*     */ import com.android.ide.common.process.ProcessExecutor;
/*     */ import com.android.utils.ILogger;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class TestDataImpl
/*     */   extends AbstractTestDataImpl
/*     */ {
/*     */   private final TestVariantData testVariantData;
/*     */   private final VariantConfiguration testVariantConfig;
/*     */   
/*     */   public TestDataImpl(TestVariantData testVariantData, FileCollection testApkDir, FileCollection testedApksDir)
/*     */   {
/*  62 */     super(testVariantData.getVariantConfiguration(), testApkDir, testedApksDir);
/*  63 */     this.testVariantData = testVariantData;
/*  64 */     testVariantConfig = testVariantData.getVariantConfiguration();
/*     */     
/*  68 */     if (testVariantData.getOutputScope().getSplitsByType(VariantOutput.OutputType.FULL_SPLIT).size() > 1)
/*     */     {
/*  70 */       throw new RuntimeException("Multi-output in test variant not yet supported");
/*     */     }
/*     */   }
/*     */   
/*     */   public void loadFromMetadataFile(File metadataFile)
/*     */     throws ParserConfigurationException, SAXException, IOException
/*     */   {}
/*     */   
/*     */   public String getApplicationId()
/*     */   {
/*  83 */     return testVariantData.getApplicationId();
/*     */   }
/*     */   
/*     */   public String getTestedApplicationId()
/*     */   {
/*  89 */     return testVariantConfig.getTestedApplicationId();
/*     */   }
/*     */   
/*     */   public boolean isLibrary()
/*     */   {
/*  94 */     TestedVariantData testedVariantData = testVariantData.getTestedVariantData();
/*  95 */     BaseVariantData testedVariantData2 = (BaseVariantData)testedVariantData;
/*  96 */     return testedVariantData2.getVariantConfiguration().getType() == VariantType.LIBRARY;
/*     */   }
/*     */   
/*     */   public ImmutableList<File> getTestedApks(ProcessExecutor processExecutor, File splitSelectExe, DeviceConfigProvider deviceConfigProvider, ILogger logger)
/*     */     throws ProcessException
/*     */   {
/* 107 */     BaseVariantData testedVariantData = (BaseVariantData)testVariantData.getTestedVariantData();
/*     */     
/* 109 */     ImmutableList.Builder<File> apks = ImmutableList.builder();
/*     */     
/* 112 */     Collection<OutputFile> splitOutputs = ImmutableList.copyOf(
/* 113 */       ExistingBuildElements.from(TaskOutputHolder.TaskOutputType.APK, testedVariantData
/*     */       
/* 116 */       .getScope()
/* 117 */       .getOutput(TaskOutputHolder.TaskOutputType.APK)));
/* 118 */     apks.addAll(
/* 119 */       SplitOutputMatcher.computeBestOutput(processExecutor, splitSelectExe, deviceConfigProvider, splitOutputs, testedVariantData
/*     */       
/* 124 */       .getVariantConfiguration().getSupportedAbis()));
/* 125 */     return apks.build();
/*     */   }
/*     */   
/*     */   public List<File> getTestDirectories()
/*     */   {
/* 134 */     GradleVariantConfiguration variantConfiguration = testVariantData.getVariantConfiguration();
/* 135 */     ImmutableList.Builder<File> javaDirectories = ImmutableList.builder();
/* 136 */     for (SourceProvider sourceProvider : variantConfiguration.getSortedSourceProviders()) {
/* 137 */       javaDirectories.addAll(sourceProvider.getJavaDirectories());
/*     */     }
/* 139 */     return javaDirectories.build();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.TestDataImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */