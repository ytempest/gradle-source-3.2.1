/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.Abi;
/*     */ import com.android.build.gradle.internal.ndk.NdkHandler;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.ide.common.process.ProcessException;
/*     */ import com.android.ide.common.process.ProcessInfoBuilder;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.Builder;
/*     */ import com.google.wireless.android.sdk.stats.GradleNativeAndroidModule.NativeBuildSystemType;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.gradle.api.GradleException;
/*     */ 
/*     */ abstract class CmakeExternalNativeJsonGenerator
/*     */   extends ExternalNativeJsonGenerator
/*     */ {
/*  51 */   private static final Pattern cmakeFileFinder = Pattern.compile("^(.*CMake (Error|Warning).* at\\s+)([^:]+)(:.*)$", 32);
/*     */   
/*     */   final File cmakeInstallFolder;
/*     */   
/*     */   CmakeExternalNativeJsonGenerator(NdkHandler ndkHandler, int minSdkVersion, String variantName, Collection<Abi> abis, AndroidBuilder androidBuilder, File sdkFolder, File ndkFolder, File soFolder, File objFolder, File jsonFolder, File makeFile, File cmakeInstallFolder, boolean debuggable, List<String> buildArguments, List<String> cFlags, List<String> cppFlags, List<File> nativeBuildConfigurationsJsons, GradleBuildVariant.Builder stats)
/*     */   {
/*  74 */     super(ndkHandler, minSdkVersion, variantName, abis, androidBuilder, sdkFolder, ndkFolder, soFolder, objFolder, jsonFolder, makeFile, debuggable, buildArguments, cFlags, cppFlags, nativeBuildConfigurationsJsons, stats);
/*     */     
/*  92 */     this.cmakeInstallFolder = cmakeInstallFolder;
/*  93 */     this.stats.setNativeBuildSystemType(GradleNativeAndroidModule.NativeBuildSystemType.CMAKE);
/*     */   }
/*     */   
/*     */   abstract List<String> getCacheArguments(String paramString, int paramInt);
/*     */   
/*     */   public abstract String executeProcessAndGetOutput(String paramString, int paramInt, File paramFile)
/*     */     throws ProcessException, IOException;
/*     */   
/*     */   public String executeProcess(String abi, int abiPlatformVersion, File outputJsonDir)
/*     */     throws ProcessException, IOException
/*     */   {
/* 126 */     String output = executeProcessAndGetOutput(abi, abiPlatformVersion, outputJsonDir);
/* 127 */     return correctMakefilePaths(output, getMakefile().getParentFile());
/*     */   }
/*     */   
/*     */   void processBuildOutput(String buildOutput, String abi, int abiPlatformVersion)
/*     */     throws IOException
/*     */   {}
/*     */   
/*     */   ProcessInfoBuilder getProcessBuilder(String abi, int abiPlatformVersion, File outputJson)
/*     */   {
/* 141 */     checkConfiguration();
/* 142 */     ProcessInfoBuilder builder = new ProcessInfoBuilder();
/*     */     
/* 144 */     builder.setExecutable(getSdkCmakeExecutable());
/* 145 */     builder.addArgs(getProcessBuilderArgs(abi, abiPlatformVersion, outputJson));
/*     */     
/* 147 */     return builder;
/*     */   }
/*     */   
/*     */   List<String> getProcessBuilderArgs(String abi, int abiPlatformVersion, File outputJson)
/*     */   {
/* 155 */     List<String> processBuilderArgs = Lists.newArrayList();
/*     */     
/* 157 */     File cmakeListsFolder = getMakefile().getParentFile();
/*     */     
/* 159 */     processBuilderArgs.add(String.format("-H%s", new Object[] { cmakeListsFolder }));
/* 160 */     processBuilderArgs.add(String.format("-B%s", new Object[] { outputJson.getParentFile() }));
/* 161 */     processBuilderArgs.addAll(getCacheArguments(abi, abiPlatformVersion));
/*     */     
/* 164 */     processBuilderArgs.addAll(getBuildArguments());
/* 165 */     return processBuilderArgs;
/*     */   }
/*     */   
/*     */   protected List<String> getCommonCacheArguments(String abi, int abiPlatformVersion)
/*     */   {
/* 176 */     List<String> cacheArguments = Lists.newArrayList();
/* 177 */     cacheArguments.add(String.format("-DANDROID_ABI=%s", new Object[] { abi }));
/* 178 */     cacheArguments.add(String.format("-DANDROID_PLATFORM=android-%s", new Object[] { Integer.valueOf(abiPlatformVersion) }));
/* 179 */     cacheArguments.add(
/* 180 */       String.format("-DCMAKE_LIBRARY_OUTPUT_DIRECTORY=%s", new Object[] { new File(
/* 181 */       getObjFolder(), abi) }));
/* 182 */     cacheArguments.add(
/* 183 */       String.format("-DCMAKE_BUILD_TYPE=%s", new Object[] {isDebuggable() ? "Debug" : "Release" }));
/* 184 */     cacheArguments.add(String.format("-DANDROID_NDK=%s", new Object[] { getNdkFolder() }));
/* 185 */     if (!getcFlags().isEmpty()) {
/* 186 */       cacheArguments.add(
/* 187 */         String.format("-DCMAKE_C_FLAGS=%s", new Object[] {Joiner.on(" ").join(getcFlags()) }));
/*     */     }
/*     */     
/* 190 */     if (!getCppFlags().isEmpty()) {
/* 191 */       cacheArguments.add(
/* 192 */         String.format("-DCMAKE_CXX_FLAGS=%s", new Object[] {Joiner.on(" ").join(getCppFlags()) }));
/*     */     }
/*     */     
/* 195 */     return cacheArguments;
/*     */   }
/*     */   
/*     */   public File getCompileCommandsJson(String abi)
/*     */   {
/* 201 */     return ExternalNativeBuildTaskUtils.getCompileCommandsJson(getJsonFolder(), abi);
/*     */   }
/*     */   
/*     */   public NativeBuildSystem getNativeBuildSystem()
/*     */   {
/* 207 */     return NativeBuildSystem.CMAKE;
/*     */   }
/*     */   
/*     */   Map<Abi, File> getStlSharedObjectFiles()
/*     */   {
/* 214 */     String stl = null;
/* 215 */     File ndkBasePath = null;
/* 216 */     for (Iterator localIterator = getBuildArguments().iterator(); localIterator.hasNext();) { argument = (String)localIterator.next();
/* 217 */       argument = argument.replace(" ", "");
/* 218 */       if (argument.equals("-DANDROID_STL=stlport_shared")) {
/* 219 */         stl = "stlport";
/* 220 */         ndkBasePath = FileUtils.join(getNdkFolder(), new String[] { "sources", "cxx-stl", "stlport" });
/* 221 */       } else if (argument.equals("-DANDROID_STL=gnustl_shared")) {
/* 222 */         stl = "gnustl";
/* 223 */         ndkBasePath = FileUtils.join(getNdkFolder(), new String[] { "sources", "cxx-stl", "gnu-libstdc++", "4.9" });
/*     */       }
/* 225 */       else if (argument.equals("-DANDROID_STL=c++_shared")) {
/* 226 */         stl = "c++";
/* 227 */         ndkBasePath = FileUtils.join(getNdkFolder(), new String[] { "sources", "cxx-stl", "llvm-libc++" });
/*     */       } }
/*     */     String argument;
/* 230 */     Object result = Maps.newHashMap();
/* 231 */     if (stl == null) {
/* 232 */       return (Map<Abi, File>)result;
/*     */     }
/* 234 */     for (Abi abi : getAbis()) {
/* 235 */       File file = FileUtils.join(ndkBasePath, new String[] { "libs", abi.getName(), 
/* 236 */         String.format("lib%s_shared.so", new Object[] { stl }) });
/* 237 */       Preconditions.checkState(file.isFile(), "Expected NDK STL shared object file at %s", file.toString());
/* 238 */       ((Map)result).put(abi, file);
/*     */     }
/* 240 */     return (Map<Abi, File>)result;
/*     */   }
/*     */   
/*     */   static String correctMakefilePaths(String input, File makeFileDirectory)
/*     */   {
/* 246 */     Matcher cmakeFinderMatcher = cmakeFileFinder.matcher(input);
/* 247 */     if (cmakeFinderMatcher.matches())
/*     */     {
/* 250 */       List<String> corrected = new ArrayList();
/* 251 */       for (String entry : input.split(System.lineSeparator())) {
/* 252 */         cmakeFinderMatcher = cmakeFileFinder.matcher(entry);
/* 253 */         if (cmakeFinderMatcher.matches()) {
/* 254 */           String fileName = cmakeFinderMatcher.group(3);
/* 255 */           File makeFile = new File(fileName);
/*     */           
/* 257 */           if (makeFile.isAbsolute()) {
/* 258 */             corrected.add(entry);
/*     */           }
/*     */           else
/*     */           {
/* 263 */             makeFile = new File(makeFileDirectory, fileName);
/* 264 */             if (!makeFile.exists()) {
/* 265 */               corrected.add(entry);
/*     */             }
/*     */             else
/*     */             {
/* 270 */               corrected.add(cmakeFinderMatcher
/* 271 */                 .group(1) + makeFile
/* 272 */                 .getAbsolutePath() + cmakeFinderMatcher
/* 273 */                 .group(4)); }
/*     */           }
/* 275 */         } else { corrected.add(entry);
/*     */         }
/*     */       }
/*     */       
/* 279 */       return Joiner.on(System.lineSeparator()).join(corrected);
/*     */     }
/*     */     
/* 282 */     return input;
/*     */   }
/*     */   
/*     */   protected File getToolChainFile()
/*     */   {
/* 287 */     String toolchainFileName = "android.toolchain.cmake";
/* 288 */     File ndkCmakeFolder = new File(new File(getNdkFolder(), "build"), "cmake");
/*     */     
/* 290 */     File toolchainFile = new File(ndkCmakeFolder, toolchainFileName);
/* 291 */     if (!toolchainFile.exists())
/*     */     {
/* 294 */       toolchainFile = new File(getCmakeInstallFolder(), toolchainFileName);
/*     */     }
/* 296 */     return toolchainFile;
/*     */   }
/*     */   
/*     */   protected File getSdkCmakeFolder()
/*     */   {
/* 301 */     return getCmakeFolderFromSdkFolder(getSdkFolder());
/*     */   }
/*     */   
/*     */   protected File getCmakeBinFolder()
/*     */   {
/* 306 */     return new File(getCmakeInstallFolder(), "bin");
/*     */   }
/*     */   
/*     */   protected File getCmakeExecutable()
/*     */   {
/* 311 */     if (isWindows()) {
/* 312 */       return new File(getCmakeBinFolder(), "cmake.exe");
/*     */     }
/* 314 */     return new File(getCmakeBinFolder(), "cmake");
/*     */   }
/*     */   
/*     */   private void checkConfiguration()
/*     */   {
/* 322 */     List<String> configurationErrors = getConfigurationErrors();
/* 323 */     if (!configurationErrors.isEmpty()) {
/* 324 */       throw new GradleException(Joiner.on("\n").join(configurationErrors));
/*     */     }
/*     */   }
/*     */   
/*     */   private List<String> getConfigurationErrors()
/*     */   {
/* 333 */     List<String> messages = Lists.newArrayList();
/*     */     
/* 335 */     String cmakeListsTxt = "CMakeLists.txt";
/* 336 */     if (getMakefile().isDirectory()) {
/* 337 */       messages.add(
/* 338 */         String.format("Gradle project cmake.path %s is a folder. It must be %s", new Object[] {
/*     */         
/* 340 */         getMakefile(), cmakeListsTxt }));
/*     */     }
/* 342 */     else if (getMakefile().isFile()) {
/* 343 */       String filename = getMakefile().getName();
/* 344 */       if (!filename.equals(cmakeListsTxt)) {
/* 345 */         messages.add(String.format("Gradle project cmake.path specifies %s but it must be %s", new Object[] { filename, cmakeListsTxt }));
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 351 */       messages.add(
/* 352 */         String.format("Gradle project cmake.path is %s but that file doesn't exist", new Object[] {
/*     */         
/* 354 */         getMakefile() }));
/*     */     }
/* 356 */     messages.addAll(getBaseConfigurationErrors());
/* 357 */     return messages;
/*     */   }
/*     */   
/*     */   private File getCmakeInstallFolder()
/*     */   {
/* 362 */     return cmakeInstallFolder;
/*     */   }
/*     */   
/*     */   protected File getSdkCmakeExecutable()
/*     */   {
/* 367 */     return getSdkCmakeExecutable(getSdkFolder());
/*     */   }
/*     */   
/*     */   protected File getSdkCmakeBinFolder()
/*     */   {
/* 372 */     return getSdkCmakeBinFolder(getSdkFolder());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.CmakeExternalNativeJsonGenerator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */