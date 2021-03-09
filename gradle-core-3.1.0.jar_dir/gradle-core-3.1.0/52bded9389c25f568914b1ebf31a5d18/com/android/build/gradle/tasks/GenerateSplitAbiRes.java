/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.VariantOutput.FilterType;
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.aapt.AaptGeneration;
/*     */ import com.android.build.gradle.internal.aapt.AaptGradleFactory;
/*     */ import com.android.build.gradle.internal.aapt.AaptGradleFactory.FilteringLogger;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.core.VariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.AaptOptions;
/*     */ import com.android.build.gradle.internal.dsl.AbiSplitOptions;
/*     */ import com.android.build.gradle.internal.dsl.DslAdaptersKt;
/*     */ import com.android.build.gradle.internal.dsl.Splits;
/*     */ import com.android.build.gradle.internal.dsl.VariantOutputFactory;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.BuildElements;
/*     */ import com.android.build.gradle.internal.scope.BuildOutput;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.OutputFactory;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.tasks.AndroidBuilderTask;
/*     */ import com.android.build.gradle.internal.tasks.ApplicationId;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.internal.variant.FeatureVariantData;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.internal.aapt.Aapt;
/*     */ import com.android.builder.internal.aapt.AaptPackageConfig.Builder;
/*     */ import com.android.builder.model.BuildType;
/*     */ import com.android.ide.common.build.ApkData;
/*     */ import com.android.ide.common.process.LoggedProcessOutputHandler;
/*     */ import com.android.ide.common.process.ProcessException;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.CharMatcher;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.Nested;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class GenerateSplitAbiRes
/*     */   extends AndroidBuilderTask
/*     */ {
/*     */   private String applicationId;
/*     */   private String outputBaseName;
/*     */   private String versionName;
/*     */   private int versionCode;
/*     */   private AaptGeneration aaptGeneration;
/*     */   private Set<String> splits;
/*     */   private File outputDirectory;
/*     */   private boolean debuggable;
/*     */   private AaptOptions aaptOptions;
/*     */   private OutputFactory outputFactory;
/*     */   private VariantType variantType;
/*     */   private VariantScope variantScope;
/*     */   private String featureName;
/*     */   private FileCollection applicationIdOverride;
/*     */   
/*     */   @Input
/*     */   public String getApplicationId()
/*     */   {
/*  93 */     return applicationId;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public int getVersionCode() {
/*  98 */     return versionCode;
/*     */   }
/*     */   
/*     */   @Input
/*     */   @Optional
/*     */   public String getVersionName() {
/* 104 */     return versionName;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public String getAaptGeneration() {
/* 109 */     return aaptGeneration.name();
/*     */   }
/*     */   
/*     */   @Input
/*     */   public String getOutputBaseName() {
/* 114 */     return outputBaseName;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public Set<String> getSplits() {
/* 119 */     return splits;
/*     */   }
/*     */   
/*     */   @OutputDirectory
/*     */   public File getOutputDirectory() {
/* 124 */     return outputDirectory;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isDebuggable() {
/* 129 */     return debuggable;
/*     */   }
/*     */   
/*     */   @Nested
/*     */   public AaptOptions getAaptOptions() {
/* 134 */     return aaptOptions;
/*     */   }
/*     */   
/*     */   @Input
/*     */   @Optional
/*     */   public String getFeatureName()
/*     */   {
/* 141 */     return featureName;
/*     */   }
/*     */   
/*     */   @InputFiles
/*     */   @Optional
/*     */   public FileCollection getApplicationIdOverride()
/*     */   {
/* 148 */     return applicationIdOverride;
/*     */   }
/*     */   
/*     */   @TaskAction
/*     */   protected void doFullTaskAction() throws IOException, InterruptedException, ProcessException
/*     */   {
/* 154 */     ImmutableList.Builder<BuildOutput> buildOutputs = ImmutableList.builder();
/* 155 */     for (String split : getSplits()) {
/* 156 */       File resPackageFile = getOutputFileForSplit(split);
/*     */       
/* 159 */       ApkData abiApkData = outputFactory.addConfigurationSplit(VariantOutput.FilterType.ABI, split, resPackageFile
/* 160 */         .getName());
/* 161 */       abiApkData.setVersionCode(variantScope.getVariantConfiguration().getVersionCode());
/* 162 */       abiApkData.setVersionName(variantScope.getVariantConfiguration().getVersionName());
/*     */       
/* 165 */       if (variantScope.getVariantData().variantOutputFactory != null) {
/* 166 */         variantScope.getVariantData().variantOutputFactory.create(abiApkData);
/*     */       }
/*     */       
/* 169 */       File manifestFile = generateSplitManifest(split, abiApkData);
/*     */       
/* 171 */       AndroidBuilder builder = getBuilder();
/*     */       
/* 173 */       Aapt aapt = AaptGradleFactory.make(aaptGeneration, builder, new LoggedProcessOutputHandler(new AaptGradleFactory.FilteringLogger(builder
/*     */       
/* 177 */         .getLogger())), true, 
/*     */         
/* 179 */         FileUtils.mkdirs(new File(variantScope
/*     */         
/* 181 */         .getIncrementalDir(getName()), "aapt-temp")), variantScope
/*     */         
/* 184 */         .getGlobalScope()
/* 185 */         .getExtension()
/* 186 */         .getAaptOptions()
/* 187 */         .getCruncherProcesses());Throwable localThrowable3 = null;
/*     */       
/*     */       try
/*     */       {
/* 189 */         AaptPackageConfig.Builder aaptConfig = new AaptPackageConfig.Builder();
/* 190 */         aaptConfig
/* 191 */           .setManifestFile(manifestFile)
/* 192 */           .setOptions(DslAdaptersKt.convert(aaptOptions))
/* 193 */           .setDebuggable(debuggable)
/* 194 */           .setResourceOutputApk(resPackageFile)
/* 195 */           .setVariantType(variantType);
/*     */         
/* 197 */         getBuilder().processResources(aapt, aaptConfig);
/*     */       }
/*     */       catch (Throwable localThrowable1)
/*     */       {
/* 172 */         localThrowable3 = localThrowable1;throw localThrowable1;
/*     */       }
/*     */       finally
/*     */       {
/* 198 */         if (aapt != null) if (localThrowable3 != null) try { aapt.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else aapt.close();
/*     */       }
/* 200 */       buildOutputs.add(new BuildOutput(TaskOutputHolder.TaskOutputType.ABI_PROCESSED_SPLIT_RES, abiApkData, resPackageFile));
/*     */     }
/*     */     
/* 207 */     new BuildElements(buildOutputs.build()).save(outputDirectory);
/*     */   }
/*     */   
/*     */   File generateSplitManifest(String split, ApkData abiApkData)
/*     */     throws IOException
/*     */   {
/* 220 */     CharMatcher charMatcher = CharMatcher.inRange('0', '9').or(CharMatcher.inRange('A', 'Z')).or(CharMatcher.inRange('a', 'z')).or(CharMatcher.is('_')).or(CharMatcher.is('.')).negate();
/*     */     
/* 225 */     String encodedSplitName = (featureName != null ? featureName + "." : "") + "config." + charMatcher.replaceFrom(split, '_');
/*     */     
/* 227 */     File tmpDirectory = new File(outputDirectory, split);
/* 228 */     FileUtils.mkdirs(tmpDirectory);
/*     */     
/* 230 */     File tmpFile = new File(tmpDirectory, "AndroidManifest.xml");
/*     */     
/* 232 */     String versionNameToUse = abiApkData.getVersionName();
/* 233 */     if (versionNameToUse == null) {
/* 234 */       versionNameToUse = String.valueOf(abiApkData.getVersionCode());
/*     */     }
/*     */     
/*     */     String manifestAppId;
/*     */     String manifestAppId;
/* 239 */     if ((applicationIdOverride != null) && (!applicationIdOverride.isEmpty()))
/*     */     {
/* 241 */       manifestAppId = ApplicationId.load(applicationIdOverride.getSingleFile()).getApplicationId();
/*     */     } else {
/* 243 */       manifestAppId = applicationId;
/*     */     }
/*     */     
/* 246 */     OutputStreamWriter fileWriter = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(tmpFile)), "UTF-8");Throwable localThrowable3 = null;
/*     */     
/*     */     try
/*     */     {
/* 250 */       fileWriter.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"\n      package=\"" + manifestAppId + "\"\n      android:versionCode=\"" + abiApkData
/*     */       
/* 257 */         .getVersionCode() + "\"\n      android:versionName=\"" + versionNameToUse + "\"\n");
/*     */       
/* 263 */       if (featureName != null) {
/* 264 */         fileWriter.append("      configForSplit=\"" + featureName + "\"\n");
/*     */       }
/*     */       
/* 267 */       fileWriter.append("      split=\"" + encodedSplitName + "\"\n      targetABI=\"" + split + "\">\n       <uses-sdk android:minSdkVersion=\"21\"/>\n</manifest> ");
/*     */       
/* 276 */       fileWriter.flush();
/*     */     }
/*     */     catch (Throwable localThrowable1)
/*     */     {
/* 246 */       localThrowable3 = localThrowable1;throw localThrowable1;
/*     */     }
/*     */     finally
/*     */     {
/* 277 */       if (fileWriter != null) if (localThrowable3 != null) try { fileWriter.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else fileWriter.close(); }
/* 278 */     return tmpFile;
/*     */   }
/*     */   
/*     */   private File getOutputFileForSplit(String split)
/*     */   {
/* 283 */     return new File(outputDirectory, "resources-" + getOutputBaseName() + "-" + split + ".ap_");
/*     */   }
/*     */   
/*     */   public static class ConfigAction
/*     */     implements TaskConfigAction<GenerateSplitAbiRes>
/*     */   {
/*     */     private final VariantScope scope;
/*     */     private final File outputDirectory;
/*     */     
/*     */     public ConfigAction(VariantScope scope, File outputDirectory)
/*     */     {
/* 294 */       this.scope = scope;
/* 295 */       this.outputDirectory = outputDirectory;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 301 */       return scope.getTaskName("generate", "SplitAbiRes");
/*     */     }
/*     */     
/*     */     public Class<GenerateSplitAbiRes> getType()
/*     */     {
/* 307 */       return GenerateSplitAbiRes.class;
/*     */     }
/*     */     
/*     */     public void execute(GenerateSplitAbiRes generateSplitAbiRes)
/*     */     {
/* 312 */       VariantConfiguration config = scope.getVariantConfiguration();
/*     */       
/* 314 */       generateSplitAbiRes.setAndroidBuilder(scope.getGlobalScope().getAndroidBuilder());
/* 315 */       generateSplitAbiRes.setVariantName(config.getFullName());
/* 316 */       featureName = 
/* 317 */         ((config.getType() == VariantType.FEATURE) && (!scope.isBaseFeature()) ? 
/* 318 */         ((FeatureVariantData)scope.getVariantData()).getFeatureName() : null);
/*     */       
/* 322 */       versionCode = config.getVersionCode();
/* 323 */       versionName = config.getVersionName();
/* 324 */       aaptGeneration = 
/* 325 */         AaptGeneration.fromProjectOptions(scope.getGlobalScope().getProjectOptions());
/*     */       
/* 327 */       variantScope = scope;
/* 328 */       variantType = config.getType();
/* 329 */       outputDirectory = outputDirectory;
/* 330 */       splits = 
/* 331 */         AbiSplitOptions.getAbiFilters(scope
/* 332 */         .getGlobalScope().getExtension().getSplits().getAbiFilters());
/* 333 */       outputBaseName = config.getBaseName();
/* 334 */       applicationId = config.getApplicationId();
/* 335 */       debuggable = config.getBuildType().isDebuggable();
/* 336 */       aaptOptions = scope
/* 337 */         .getGlobalScope().getExtension().getAaptOptions();
/* 338 */       outputFactory = scope.getVariantData().getOutputFactory();
/*     */       
/* 340 */       if (scope.getVariantData().getType() == VariantType.FEATURE) {
/* 341 */         if (scope.isBaseFeature()) {
/* 342 */           applicationIdOverride = scope
/* 343 */             .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.METADATA_VALUES, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.METADATA_APP_ID_DECLARATION);
/*     */         }
/*     */         else {
/* 346 */           applicationIdOverride = scope
/* 347 */             .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.FEATURE_APPLICATION_ID_DECLARATION);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.GenerateSplitAbiRes
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */