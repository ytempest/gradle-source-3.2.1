/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.BuildElements;
/*     */ import com.android.build.gradle.internal.scope.BuildOutput;
/*     */ import com.android.build.gradle.internal.scope.ExistingBuildElements;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.OutputScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import com.android.sdklib.IAndroidTarget;
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.OpenOption;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.nio.file.attribute.FileAttribute;
/*     */ import java.util.Properties;
/*     */ import org.gradle.api.DefaultTask;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class GenerateTestConfig
/*     */   extends DefaultTask
/*     */ {
/*     */   FileCollection resourcesDirectory;
/*     */   FileCollection assetsDirectory;
/*     */   Path sdkHome;
/*     */   File generatedJavaResourcesDirectory;
/*     */   ApkInfo mainApkInfo;
/*     */   FileCollection manifests;
/*     */   String packageForR;
/*     */   
/*     */   @Input
/*     */   ApkInfo getMainApkInfo()
/*     */   {
/*  65 */     return mainApkInfo;
/*     */   }
/*     */   
/*     */   @InputFiles
/*     */   FileCollection getManifests() {
/*  70 */     return manifests;
/*     */   }
/*     */   
/*     */   @TaskAction
/*     */   public void generateTestConfig() throws IOException {
/*  75 */     Preconditions.checkNotNull(resourcesDirectory);
/*  76 */     Preconditions.checkNotNull(assetsDirectory);
/*  77 */     Preconditions.checkNotNull(sdkHome);
/*     */     
/*  82 */     BuildOutput output = ExistingBuildElements.from(TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS, manifests).element(mainApkInfo);
/*  83 */     generateTestConfigForOutput(assetsDirectory
/*  84 */       .getSingleFile().toPath().toAbsolutePath(), resourcesDirectory
/*  85 */       .getSingleFile().toPath().toAbsolutePath(), sdkHome, packageForR, 
/*     */       
/*  88 */       ((BuildOutput)Preconditions.checkNotNull(output, "Unable to find manifest output")).getOutputFile().toPath(), generatedJavaResourcesDirectory
/*  89 */       .toPath().toAbsolutePath());
/*     */   }
/*     */   
/*     */   static void generateTestConfigForOutput(Path assetsDir, Path resDir, Path sdkHome, String packageForR, Path manifest, Path outputDir)
/*     */     throws IOException
/*     */   {
/* 102 */     Properties properties = new Properties();
/* 103 */     properties.setProperty("android_sdk_home", sdkHome.toAbsolutePath().toString());
/* 104 */     properties.setProperty("android_merged_resources", resDir.toAbsolutePath().toString());
/* 105 */     properties.setProperty("android_merged_assets", assetsDir.toAbsolutePath().toString());
/* 106 */     properties.setProperty("android_merged_manifest", manifest.toAbsolutePath().toString());
/* 107 */     properties.setProperty("android_custom_package", packageForR);
/*     */     
/* 114 */     Path output = outputDir.resolve("com").resolve("android").resolve("tools").resolve("test_config.properties");
/* 115 */     Files.createDirectories(output.getParent(), new FileAttribute[0]);
/*     */     
/* 117 */     Writer writer = Files.newBufferedWriter(output, new OpenOption[0]);Throwable localThrowable3 = null;
/* 118 */     try { properties.store(writer, "# Generated by the Android Gradle Plugin");
/*     */     }
/*     */     catch (Throwable localThrowable1)
/*     */     {
/* 117 */       localThrowable3 = localThrowable1;throw localThrowable1;
/*     */     } finally {
/* 119 */       if (writer != null) if (localThrowable3 != null) try { writer.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else writer.close();
/*     */     }
/*     */   }
/*     */   
/*     */   @Input
/* 124 */   public String getResourcesDirectory() { return resourcesDirectory.getSingleFile().getPath(); }
/*     */   
/*     */   @Input
/*     */   public String getAssetsDirectory()
/*     */   {
/* 129 */     return assetsDirectory.getSingleFile().getPath();
/*     */   }
/*     */   
/*     */   @Input
/*     */   public String getSdkHome() {
/* 134 */     return sdkHome.toString();
/*     */   }
/*     */   
/*     */   @OutputDirectory
/*     */   public File getOutputFile() {
/* 139 */     return generatedJavaResourcesDirectory;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public String getPackageForR() {
/* 144 */     return packageForR;
/*     */   }
/*     */   
/*     */   public static class ConfigAction implements TaskConfigAction<GenerateTestConfig>
/*     */   {
/*     */     private final VariantScope scope;
/*     */     private final VariantScope testedScope;
/*     */     private final File outputDirectory;
/*     */     
/*     */     public ConfigAction(VariantScope scope, File outputDirectory) {
/* 154 */       this.scope = scope;
/*     */       
/* 158 */       testedScope = ((BaseVariantData)Preconditions.checkNotNull(scope.getTestedVariantData(), "Not a unit test variant.")).getScope();
/* 159 */       this.outputDirectory = outputDirectory;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 165 */       return scope.getTaskName("generate", "Config");
/*     */     }
/*     */     
/*     */     public Class<GenerateTestConfig> getType()
/*     */     {
/* 171 */       return GenerateTestConfig.class;
/*     */     }
/*     */     
/*     */     public void execute(GenerateTestConfig task)
/*     */     {
/* 179 */       resourcesDirectory = testedScope.getOutput(TaskOutputHolder.TaskOutputType.MERGED_NOT_COMPILED_RES);
/* 180 */       task.dependsOn(new Object[] { resourcesDirectory });
/* 181 */       assetsDirectory = testedScope.getOutput(TaskOutputHolder.TaskOutputType.MERGED_ASSETS);
/* 182 */       task.dependsOn(new Object[] { assetsDirectory });
/*     */       
/* 184 */       manifests = testedScope.getOutput(TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS);
/* 185 */       mainApkInfo = testedScope.getOutputScope().getMainSplit();
/*     */       
/* 187 */       sdkHome = Paths.get(scope.getGlobalScope().getAndroidBuilder().getTarget().getLocation(), new String[0]);
/* 188 */       generatedJavaResourcesDirectory = outputDirectory;
/* 189 */       packageForR = testedScope.getVariantConfiguration().getOriginalApplicationId();
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.GenerateTestConfig
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */