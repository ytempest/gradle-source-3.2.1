/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.SdkConstants;
/*     */ import com.android.build.gradle.external.cmake.CmakeUtils;
/*     */ import com.android.build.gradle.internal.SdkHandler;
/*     */ import com.android.build.gradle.internal.model.CoreCmakeOptions;
/*     */ import com.android.build.gradle.internal.model.CoreExternalNativeBuild;
/*     */ import com.android.build.gradle.internal.model.CoreNdkBuildOptions;
/*     */ import com.android.build.gradle.options.BooleanOption;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.ide.common.process.BuildCommandException;
/*     */ import com.android.ide.common.process.ProcessException;
/*     */ import com.android.ide.common.process.ProcessInfoBuilder;
/*     */ import com.android.ide.common.process.ProcessOutput;
/*     */ import com.android.ide.common.process.ProcessOutputHandler;
/*     */ import com.android.ide.common.process.ProcessResult;
/*     */ import com.android.repository.Revision;
/*     */ import com.android.repository.api.ConsoleProgressIndicator;
/*     */ import com.android.repository.api.LocalPackage;
/*     */ import com.android.repository.api.ProgressIndicator;
/*     */ import com.android.sdklib.repository.AndroidSdkHandler;
/*     */ import com.android.utils.ILogger;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.io.ByteSource;
/*     */ import com.google.common.io.CharSource;
/*     */ import com.google.common.io.FileBackedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.LinkOption;
/*     */ import java.nio.file.attribute.FileTime;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.EnumMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class ExternalNativeBuildTaskUtils
/*     */ {
/*     */   public static final String CUSTOM_FORK_CMAKE_VERSION = "3.6.0-rc2";
/*     */   
/*     */   public static boolean fileIsUpToDate(File source, File derived)
/*     */     throws IOException
/*     */   {
/*  78 */     if (!source.exists())
/*     */     {
/*  81 */       return false;
/*     */     }
/*  83 */     if (!derived.exists())
/*     */     {
/*  85 */       return false;
/*     */     }
/*  87 */     long sourceTimestamp = Files.getLastModifiedTime(source.toPath(), new LinkOption[0]).toMillis();
/*  88 */     long derivedTimestamp = Files.getLastModifiedTime(derived.toPath(), new LinkOption[0]).toMillis();
/*  89 */     return sourceTimestamp <= derivedTimestamp;
/*     */   }
/*     */   
/*     */   public static File getJsonMiniConfigFile(File originalJson)
/*     */   {
/*  98 */     return new File(originalJson.getParent(), "android_gradle_build_mini.json");
/*     */   }
/*     */   
/*     */   static File getOutputFolder(File jsonFolder, String abi)
/*     */   {
/* 107 */     return new File(jsonFolder, abi);
/*     */   }
/*     */   
/*     */   public static File getOutputJson(File jsonFolder, String abi)
/*     */   {
/* 115 */     return new File(getOutputFolder(jsonFolder, abi), "android_gradle_build.json");
/*     */   }
/*     */   
/*     */   public static File getCompileCommandsJson(File jsonFolder, String abi)
/*     */   {
/* 121 */     return new File(getOutputFolder(jsonFolder, abi), "compile_commands.json");
/*     */   }
/*     */   
/*     */   public static List<File> getOutputJsons(File jsonFolder, Collection<String> abis)
/*     */   {
/* 127 */     List<File> outputs = Lists.newArrayList();
/* 128 */     for (String abi : abis) {
/* 129 */       outputs.add(getOutputJson(jsonFolder, abi));
/*     */     }
/* 131 */     return outputs;
/*     */   }
/*     */   
/*     */   public static boolean shouldRegenerateOutOfDateJsons(ProjectOptions options)
/*     */   {
/* 136 */     return (options.get(BooleanOption.IDE_BUILD_MODEL_ONLY)) || 
/* 137 */       (options.get(BooleanOption.IDE_BUILD_MODEL_ONLY_ADVANCED)) || 
/* 138 */       (options.get(BooleanOption.IDE_INVOKED_FROM_IDE)) || 
/* 139 */       (options.get(BooleanOption.IDE_REFRESH_EXTERNAL_NATIVE_MODEL));
/*     */   }
/*     */   
/*     */   public static boolean isExternalNativeBuildEnabled(CoreExternalNativeBuild config) {
/* 143 */     return (config.getNdkBuild().getPath() != null) || 
/* 144 */       (config.getCmake().getPath() != null);
/*     */   }
/*     */   
/*     */   public static ExternalNativeBuildProjectPathResolution getProjectPath(CoreExternalNativeBuild config)
/*     */   {
/* 161 */     Map<NativeBuildSystem, File> externalProjectPaths = getExternalBuildExplicitPaths(config);
/* 162 */     if (externalProjectPaths.size() > 1) {
/* 163 */       return new ExternalNativeBuildProjectPathResolution(null, null, null, "More than one externalNativeBuild path specified", null);
/*     */     }
/*     */     
/* 167 */     if (externalProjectPaths.isEmpty())
/*     */     {
/* 169 */       return new ExternalNativeBuildProjectPathResolution(null, null, null, null, null);
/*     */     }
/*     */     
/* 172 */     NativeBuildSystem buildSystem = (NativeBuildSystem)externalProjectPaths.keySet().iterator().next();
/* 173 */     return new ExternalNativeBuildProjectPathResolution(buildSystem, 
/*     */     
/* 175 */       (File)externalProjectPaths.get(buildSystem), 
/* 176 */       (File)getExternalNativeBuildPath(config).get(buildSystem), null, null);
/*     */   }
/*     */   
/*     */   private static Map<NativeBuildSystem, File> getExternalBuildExplicitPaths(CoreExternalNativeBuild config)
/*     */   {
/* 187 */     Map<NativeBuildSystem, File> map = new EnumMap(NativeBuildSystem.class);
/* 188 */     File cmake = config.getCmake().getPath();
/* 189 */     File ndkBuild = config.getNdkBuild().getPath();
/*     */     
/* 191 */     if (cmake != null) {
/* 192 */       map.put(NativeBuildSystem.CMAKE, cmake);
/*     */     }
/* 194 */     if (ndkBuild != null) {
/* 195 */       map.put(NativeBuildSystem.NDK_BUILD, ndkBuild);
/*     */     }
/* 197 */     return map;
/*     */   }
/*     */   
/*     */   private static Map<NativeBuildSystem, File> getExternalNativeBuildPath(CoreExternalNativeBuild config)
/*     */   {
/* 203 */     Map<NativeBuildSystem, File> map = new EnumMap(NativeBuildSystem.class);
/* 204 */     File cmake = config.getCmake().getBuildStagingDirectory();
/* 205 */     File ndkBuild = config.getNdkBuild().getBuildStagingDirectory();
/* 206 */     if (cmake != null) {
/* 207 */       map.put(NativeBuildSystem.CMAKE, cmake);
/*     */     }
/* 209 */     if (ndkBuild != null) {
/* 210 */       map.put(NativeBuildSystem.NDK_BUILD, ndkBuild);
/*     */     }
/*     */     
/* 213 */     return map;
/*     */   }
/*     */   
/*     */   public static String executeBuildProcessAndLogError(AndroidBuilder androidBuilder, ProcessInfoBuilder process, boolean logStdioToInfo)
/*     */     throws BuildCommandException, IOException
/*     */   {
/* 229 */     ProgressiveLoggingProcessOutputHandler handler = new ProgressiveLoggingProcessOutputHandler(androidBuilder.getLogger(), logStdioToInfo);
/*     */     
/*     */     try
/*     */     {
/* 233 */       androidBuilder.getLogger().verbose(process.toString(), new Object[0]);
/* 234 */       androidBuilder.executeProcess(process.createProcess(), handler)
/* 235 */         .rethrowFailure().assertNormalExitValue();
/*     */       
/* 237 */       return handler.getStandardOutputString();
/*     */     }
/*     */     catch (ProcessException e)
/*     */     {
/* 242 */       String combinedMessage = String.format("%s\n%s", new Object[] { e.getMessage(), handler
/* 243 */         .getCombinedOutputString() });
/* 244 */       throw new BuildCommandException(combinedMessage);
/*     */     }
/*     */   }
/*     */   
/*     */   public static File findCmakeExecutableFolder(String cmakeVersion, SdkHandler sdkHandler)
/*     */   {
/* 258 */     return doFindCmakeExecutableFolder(cmakeVersion, sdkHandler, getEnvironmentPathList());
/*     */   }
/*     */   
/*     */   private static List<File> getEnvironmentPathList()
/*     */   {
/* 267 */     List<File> fileList = new ArrayList();
/* 268 */     String envPath = System.getenv("PATH");
/*     */     
/* 270 */     List<String> pathList = new ArrayList();
/* 271 */     if (envPath != null) {
/* 272 */       pathList.addAll(Arrays.asList(envPath.split(System.getProperty("path.separator"))));
/*     */     }
/*     */     
/* 275 */     for (String path : pathList) {
/* 276 */       fileList.add(new File(path));
/*     */     }
/*     */     
/* 279 */     return fileList;
/*     */   }
/*     */   
/*     */   static File doFindCmakeExecutableFolder(String cmakeVersion, SdkHandler sdkHandler, List<File> foldersToSearch)
/*     */   {
/* 307 */     if (sdkHandler.getCmakePathInLocalProp() != null) {
/* 308 */       return sdkHandler.getCmakePathInLocalProp();
/*     */     }
/*     */     
/* 311 */     if ((cmakeVersion != null) && (!isDefaultSdkCmakeVersion(cmakeVersion)))
/*     */     {
/* 315 */       File cmakeFolder = getRequiredCmakeFromFolders(
/* 316 */         Revision.parseRevision(cmakeVersion), foldersToSearch);
/* 317 */       return new File(cmakeFolder.getParent());
/*     */     }
/*     */     
/* 320 */     return getCmakeFolderFromSdkPackage(sdkHandler);
/*     */   }
/*     */   
/*     */   private static boolean isDefaultSdkCmakeVersion(String cmakeVersion)
/*     */   {
/* 329 */     return cmakeVersion.equals("3.6.0-rc2");
/*     */   }
/*     */   
/*     */   private static File getRequiredCmakeFromFolders(Revision cmakeVersion, List<File> foldersToSearch)
/*     */   {
/* 343 */     List<File> foldersWithErrors = new ArrayList();
/* 344 */     for (File cmakeFolder : foldersToSearch) {
/*     */       File cmakeBin;
/*     */       File cmakeBin;
/* 347 */       if (SdkConstants.CURRENT_PLATFORM == 2) {
/* 348 */         cmakeBin = new File(cmakeFolder, "cmake.exe");
/*     */       } else {
/* 350 */         cmakeBin = new File(cmakeFolder, "cmake");
/*     */       }
/*     */       
/* 353 */       if (cmakeBin.exists())
/*     */       {
/*     */         try
/*     */         {
/* 357 */           Revision version = CmakeUtils.getVersion(cmakeFolder);
/* 358 */           if (cmakeVersion.equals(version)) {
/* 359 */             return cmakeFolder;
/*     */           }
/*     */         }
/*     */         catch (IOException e)
/*     */         {
/* 364 */           foldersWithErrors.add(cmakeFolder);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 370 */     StringBuilder errorMsg = new StringBuilder(String.format("Unable to find CMake with version: %s within folder: %s\n.", new Object[] { cmakeVersion, foldersToSearch
/*     */     
/* 372 */       .toString() }));
/*     */     
/* 374 */     if (!foldersWithErrors.isEmpty()) {
/* 375 */       errorMsg.append(
/* 376 */         String.format("Folders have inaccessible/corrupt CMake: %s", new Object[] {foldersWithErrors
/*     */         
/* 378 */         .toString() }));
/*     */     }
/*     */     
/* 381 */     errorMsg.append("Please make sure the folder with the CMake binary is added to the PATH environment variable.");
/*     */     
/* 385 */     throw new RuntimeException(errorMsg.toString());
/*     */   }
/*     */   
/*     */   private static File getCmakeFolderFromSdkPackage(SdkHandler sdkHandler)
/*     */   {
/* 394 */     ProgressIndicator progress = new ConsoleProgressIndicator();
/* 395 */     AndroidSdkHandler sdk = AndroidSdkHandler.getInstance(sdkHandler.getSdkFolder());
/*     */     
/* 397 */     LocalPackage cmakePackage = sdk.getLatestLocalPackageForPrefix("cmake", null, true, progress);
/* 398 */     if (cmakePackage != null) {
/* 399 */       return cmakePackage.getLocation();
/*     */     }
/*     */     
/* 402 */     sdkHandler.installCMake();
/*     */     
/* 404 */     cmakePackage = sdk.getLatestLocalPackageForPrefix("cmake", null, true, progress);
/* 405 */     if (cmakePackage != null) {
/* 406 */       return cmakePackage.getLocation();
/*     */     }
/*     */     
/* 409 */     return new File(sdkHandler.getSdkFolder(), "cmake");
/*     */   }
/*     */   
/*     */   public static class ExternalNativeBuildProjectPathResolution
/*     */   {
/*     */     public final String errorText;
/*     */     
/*     */     public final NativeBuildSystem buildSystem;
/*     */     public final File makeFile;
/*     */     public final File externalNativeBuildDir;
/*     */     
/*     */     private ExternalNativeBuildProjectPathResolution(NativeBuildSystem buildSystem, File makeFile, File externalNativeBuildDir, String errorText)
/*     */     {
/* 423 */       Preconditions.checkArgument((makeFile == null) || (buildSystem != null), "Expected path and buildSystem together, no taskClass");
/*     */       
/* 426 */       Preconditions.checkArgument((makeFile != null) || (buildSystem == null), "Expected path and buildSystem together, no path");
/*     */       
/* 429 */       Preconditions.checkArgument((makeFile == null) || (errorText == null), "Expected path or error but both existed");
/*     */       
/* 432 */       this.buildSystem = buildSystem;
/* 433 */       this.makeFile = makeFile;
/* 434 */       this.externalNativeBuildDir = externalNativeBuildDir;
/* 435 */       this.errorText = errorText;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ProgressiveLoggingProcessOutputHandler
/*     */     implements ProcessOutputHandler
/*     */   {
/*     */     private final ILogger logger;
/*     */     
/*     */     private final FileBackedOutputStream standardOutput;
/*     */     
/*     */     private final FileBackedOutputStream combinedOutput;
/*     */     
/*     */     private final ProgressiveLoggingProcessOutput loggingProcessOutput;
/*     */     
/*     */     private final boolean logStdioToInfo;
/*     */     
/*     */     public ProgressiveLoggingProcessOutputHandler(ILogger logger, boolean logStdioToInfo)
/*     */     {
/* 455 */       this.logger = logger;
/* 456 */       this.logStdioToInfo = logStdioToInfo;
/* 457 */       standardOutput = new FileBackedOutputStream(2048);
/* 458 */       combinedOutput = new FileBackedOutputStream(2048);
/* 459 */       loggingProcessOutput = new ProgressiveLoggingProcessOutput();
/*     */     }
/*     */     
/*     */     String getStandardOutputString() throws IOException
/*     */     {
/* 464 */       return standardOutput.asByteSource().asCharSource(Charsets.UTF_8).read();
/*     */     }
/*     */     
/*     */     String getCombinedOutputString() throws IOException
/*     */     {
/* 469 */       return combinedOutput.asByteSource().asCharSource(Charsets.UTF_8).read();
/*     */     }
/*     */     
/*     */     public ProcessOutput createOutput()
/*     */     {
/* 475 */       return loggingProcessOutput;
/*     */     }
/*     */     
/*     */     public void handleOutput(ProcessOutput processOutput)
/*     */       throws ProcessException
/*     */     {}
/*     */     
/*     */     private class ProgressiveLoggingProcessOutput
/*     */       implements ProcessOutput
/*     */     {
/*     */       private final ProgressiveLoggingOutputStream outputStream;
/*     */       private final ProgressiveLoggingOutputStream errorStream;
/*     */       
/*     */       ProgressiveLoggingProcessOutput()
/*     */       {
/* 490 */         outputStream = new ProgressiveLoggingOutputStream(logStdioToInfo, standardOutput);
/* 491 */         errorStream = new ProgressiveLoggingOutputStream(true, null);
/*     */       }
/*     */       
/*     */       public ProgressiveLoggingOutputStream getStandardOutput()
/*     */       {
/* 497 */         return outputStream;
/*     */       }
/*     */       
/*     */       public ProgressiveLoggingOutputStream getErrorOutput()
/*     */       {
/* 503 */         return errorStream;
/*     */       }
/*     */       
/*     */       public void close() throws IOException
/*     */       {}
/*     */       
/*     */       private class ProgressiveLoggingOutputStream extends OutputStream {
/*     */         private static final int INITIAL_BUFFER_SIZE = 256;
/*     */         private final boolean logToInfo;
/*     */         private final FileBackedOutputStream individualOutput;
/* 513 */         byte[] buffer = new byte['Ā'];
/*     */         
/* 515 */         int nextByteIndex = 0;
/*     */         
/*     */         ProgressiveLoggingOutputStream(boolean logToInfo, FileBackedOutputStream individualOutput)
/*     */         {
/* 519 */           this.logToInfo = logToInfo;
/* 520 */           this.individualOutput = individualOutput;
/*     */         }
/*     */         
/*     */         public void write(int b) throws IOException
/*     */         {
/* 525 */           combinedOutput.write(b);
/* 526 */           if (individualOutput != null) {
/* 527 */             individualOutput.write(b);
/*     */           }
/*     */           
/* 530 */           if ((b == 10) || (b == 13)) {
/* 531 */             printBuffer();
/*     */           } else {
/* 533 */             writeBuffer(b);
/*     */           }
/*     */         }
/*     */         
/*     */         private void writeBuffer(int b) {
/* 538 */           if (nextByteIndex == buffer.length) {
/* 539 */             buffer = Arrays.copyOf(buffer, buffer.length * 2);
/*     */           }
/* 541 */           buffer[nextByteIndex] = ((byte)b);
/* 542 */           nextByteIndex += 1;
/*     */         }
/*     */         
/*     */         private void printBuffer() throws UnsupportedEncodingException {
/* 546 */           if (nextByteIndex == 0) {
/* 547 */             return;
/*     */           }
/* 549 */           if (logToInfo) {
/* 550 */             String line = new String(buffer, 0, nextByteIndex, "UTF-8");
/* 551 */             logger.info(line, new Object[0]);
/*     */           }
/* 553 */           nextByteIndex = 0;
/*     */         }
/*     */         
/*     */         public void close() throws IOException
/*     */         {
/* 558 */           printBuffer();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ExternalNativeBuildTaskUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */