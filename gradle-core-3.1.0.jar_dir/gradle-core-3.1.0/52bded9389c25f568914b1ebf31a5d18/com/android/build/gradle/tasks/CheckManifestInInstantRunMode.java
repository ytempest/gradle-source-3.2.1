/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunVerifierStatus;
/*     */ import com.android.build.gradle.internal.scope.BuildElements;
/*     */ import com.android.build.gradle.internal.scope.BuildOutput;
/*     */ import com.android.build.gradle.internal.scope.ExistingBuildElements;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.io.CharSink;
/*     */ import com.google.common.io.CharSource;
/*     */ import com.google.common.io.FileWriteMode;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Set;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.zip.ZipEntry;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.logging.Logging;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class CheckManifestInInstantRunMode
/*     */   extends AndroidVariantTask
/*     */ {
/*  49 */   private static final Logger LOG = Logging.getLogger(CheckManifestInInstantRunMode.class);
/*     */   private InstantRunBuildContext buildContext;
/*     */   private File manifestCheckerDir;
/*     */   private FileCollection instantRunManifests;
/*     */   private FileCollection processedRes;
/*     */   private TaskOutputHolder.TaskOutputType resInputType;
/*     */   
/*     */   @Input
/*     */   TaskOutputHolder.TaskOutputType getResourcesInputType()
/*     */   {
/*  59 */     return resInputType;
/*     */   }
/*     */   
/*     */   @InputFiles
/*     */   FileCollection getInstantRunManifests() {
/*  64 */     return instantRunManifests;
/*     */   }
/*     */   
/*     */   @InputFiles
/*     */   FileCollection getProcessedRes() {
/*  69 */     return processedRes;
/*     */   }
/*     */   
/*     */   @TaskAction
/*     */   public void checkManifestChanges()
/*     */     throws IOException
/*     */   {
/*  76 */     if (!buildContext.isInInstantRunMode()) {
/*  77 */       LOG.warn("CheckManifestInInstantRunMode configured in non instant run build, please file a bug.");
/*     */       
/*  79 */       return;
/*     */     }
/*     */     
/*  82 */     if (instantRunManifests.getFiles().isEmpty()) {
/*  83 */       String message = "No instant run specific merged manifests in InstantRun mode, please file a bug and disable InstantRun.";
/*     */       
/*  86 */       LOG.error(message);
/*  87 */       throw new RuntimeException(message);
/*     */     }
/*     */     
/*  90 */     if (instantRunManifests.getFiles().size() > 1) {
/*  91 */       String message = "Full Split are not supported in InstantRun mode, please disable InstantRun";
/*     */       
/*  94 */       LOG.error(message);
/*  95 */       throw new RuntimeException(message);
/*     */     }
/*     */     
/* 103 */     BuildElements processedResOutputs = ExistingBuildElements.from(resInputType, processedRes);
/*     */     
/* 106 */     for (BuildOutput buildOutput : ExistingBuildElements.from(TaskOutputHolder.TaskOutputType.INSTANT_RUN_MERGED_MANIFESTS, instantRunManifests))
/*     */     {
/* 108 */       ApkInfo apkInfo = buildOutput.getApkInfo();
/* 109 */       File mergedManifest = buildOutput.getOutputFile();
/*     */       
/* 111 */       LOG.info("CheckManifestInInstantRunMode : Merged manifest %1$s", mergedManifest);
/* 112 */       runManifestChangeVerifier(buildContext, manifestCheckerDir, mergedManifest);
/*     */       
/* 118 */       BuildOutput processedResOutput = processedResOutputs.element(apkInfo);
/* 119 */       if (processedResOutput == null)
/*     */       {
/* 124 */         throw new RuntimeException("Cannot find processed resources for " + apkInfo + " split in " + Joiner.on(",").join(processedResOutputs.getElements()));
/*     */       }
/* 126 */       File resourcesApk = processedResOutput.getOutputFile();
/*     */       
/* 130 */       LOG.info("CheckManifestInInstantRunMode : Resource APK %1$s", resourcesApk);
/* 131 */       if (resourcesApk.exists()) {
/* 132 */         runManifestBinaryChangeVerifier(buildContext, manifestCheckerDir, resourcesApk);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void runManifestChangeVerifier(InstantRunBuildContext buildContext, File instantRunSupportDir, File manifestFileToPackage)
/*     */     throws IOException
/*     */   {
/* 143 */     File previousManifestFile = new File(instantRunSupportDir, "manifest.xml");
/*     */     
/* 145 */     if (previousManifestFile.exists())
/*     */     {
/* 147 */       String currentManifest = Files.asCharSource(manifestFileToPackage, Charsets.UTF_8).read();
/*     */       
/* 149 */       String previousManifest = Files.asCharSource(previousManifestFile, Charsets.UTF_8).read();
/* 150 */       if (!currentManifest.equals(previousManifest))
/*     */       {
/* 152 */         buildContext.setVerifierStatus(InstantRunVerifierStatus.MANIFEST_FILE_CHANGE);
/*     */         
/* 154 */         Files.copy(manifestFileToPackage, previousManifestFile);
/*     */       }
/*     */     } else {
/* 157 */       Files.createParentDirs(previousManifestFile);
/* 158 */       Files.copy(manifestFileToPackage, previousManifestFile);
/*     */       
/* 160 */       buildContext.setVerifierStatus(InstantRunVerifierStatus.INITIAL_BUILD);
/*     */     }
/*     */   }
/*     */   
/*     */   static void runManifestBinaryChangeVerifier(InstantRunBuildContext buildContext, File instantRunSupportDir, File resOutBaseNameFile)
/*     */     throws IOException
/*     */   {
/* 171 */     String currentIterationCRC = null;
/* 172 */     JarFile jarFile = new JarFile(resOutBaseNameFile);Throwable localThrowable3 = null;
/* 173 */     try { ZipEntry entry = jarFile.getEntry("AndroidManifest.xml");
/* 174 */       if (entry != null) {
/* 175 */         currentIterationCRC = String.valueOf(entry.getCrc());
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable1)
/*     */     {
/* 172 */       localThrowable3 = localThrowable1;throw localThrowable1;
/*     */     }
/*     */     finally
/*     */     {
/* 177 */       if (jarFile != null) if (localThrowable3 != null) try { jarFile.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else jarFile.close();
/*     */     }
/* 179 */     File crcFile = new File(instantRunSupportDir, "manifest.crc");
/*     */     
/* 181 */     if ((crcFile.exists()) && (currentIterationCRC != null))
/*     */     {
/* 184 */       String previousIterationCRC = Files.asCharSource(crcFile, Charsets.UTF_8).readFirstLine();
/* 185 */       if (!currentIterationCRC.equals(previousIterationCRC)) {
/* 186 */         buildContext.setVerifierStatus(InstantRunVerifierStatus.BINARY_MANIFEST_FILE_CHANGE);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 191 */       buildContext.setVerifierStatus(InstantRunVerifierStatus.INITIAL_BUILD);
/*     */     }
/*     */     
/* 194 */     if (currentIterationCRC != null)
/*     */     {
/* 196 */       Files.createParentDirs(crcFile);
/* 197 */       Files.asCharSink(crcFile, Charsets.UTF_8, new FileWriteMode[0]).write(currentIterationCRC);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ConfigAction implements TaskConfigAction<CheckManifestInInstantRunMode>
/*     */   {
/*     */     protected final VariantScope variantScope;
/*     */     
/*     */     public ConfigAction(VariantScope variantScope) {
/* 206 */       this.variantScope = variantScope;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 212 */       return variantScope.getTaskName("checkManifestChanges");
/*     */     }
/*     */     
/*     */     public Class<CheckManifestInInstantRunMode> getType()
/*     */     {
/* 218 */       return CheckManifestInInstantRunMode.class;
/*     */     }
/*     */     
/*     */     public void execute(CheckManifestInInstantRunMode task)
/*     */     {
/* 224 */       instantRunManifests = variantScope
/* 225 */         .getOutput(TaskOutputHolder.TaskOutputType.INSTANT_RUN_MERGED_MANIFESTS);
/* 226 */       resInputType = 
/* 227 */         (variantScope.getInstantRunBuildContext().useSeparateApkForResources() ? TaskOutputHolder.TaskOutputType.INSTANT_RUN_MAIN_APK_RESOURCES : TaskOutputHolder.TaskOutputType.PROCESSED_RES);
/*     */       
/* 230 */       processedRes = variantScope.getOutput(resInputType);
/* 231 */       buildContext = variantScope.getInstantRunBuildContext();
/* 232 */       manifestCheckerDir = variantScope.getManifestCheckerDir();
/* 233 */       task.setVariantName(variantScope.getFullVariantName());
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.CheckManifestInInstantRunMode
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */