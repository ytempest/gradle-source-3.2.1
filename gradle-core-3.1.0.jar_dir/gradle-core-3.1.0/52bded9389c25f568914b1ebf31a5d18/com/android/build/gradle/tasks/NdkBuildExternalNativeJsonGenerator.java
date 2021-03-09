/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.SdkConstants;
/*     */ import com.android.build.gradle.external.gnumake.NativeBuildConfigValueBuilder;
/*     */ import com.android.build.gradle.internal.core.Abi;
/*     */ import com.android.build.gradle.internal.cxx.json.NativeBuildConfigValue;
/*     */ import com.android.build.gradle.internal.cxx.json.PlainFileGsonTypeAdaptor;
/*     */ import com.android.build.gradle.internal.ndk.NdkHandler;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.ide.common.process.ProcessException;
/*     */ import com.android.ide.common.process.ProcessInfoBuilder;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.Builder;
/*     */ import com.google.wireless.android.sdk.stats.GradleNativeAndroidModule.NativeBuildSystemType;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.OpenOption;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.gradle.api.GradleException;
/*     */ 
/*     */ class NdkBuildExternalNativeJsonGenerator
/*     */   extends ExternalNativeJsonGenerator
/*     */ {
/*     */   private final File projectDir;
/*     */   
/*     */   NdkBuildExternalNativeJsonGenerator(NdkHandler ndkHandler, int minSdkVersion, String variantName, Collection<Abi> abis, AndroidBuilder androidBuilder, File projectDir, File sdkFolder, File ndkFolder, File soFolder, File objFolder, File jsonFolder, File makeFile, boolean debuggable, List<String> buildArguments, List<String> cFlags, List<String> cppFlags, List<File> nativeBuildConfigurationsJsons, GradleBuildVariant.Builder stats)
/*     */   {
/*  74 */     super(ndkHandler, minSdkVersion, variantName, abis, androidBuilder, sdkFolder, ndkFolder, soFolder, new File(objFolder, "local"), jsonFolder, makeFile, debuggable, buildArguments, cFlags, cppFlags, nativeBuildConfigurationsJsons, stats);
/*     */     
/*  92 */     this.projectDir = projectDir;
/*  93 */     this.stats.setNativeBuildSystemType(GradleNativeAndroidModule.NativeBuildSystemType.NDK_BUILD);
/*     */   }
/*     */   
/*     */   void processBuildOutput(String buildOutput, String abi, int abiPlatformVersion)
/*     */     throws IOException
/*     */   {
/* 103 */     File applicationMk = new File(getMakeFile().getParent(), "Application.mk");
/*     */     
/* 106 */     diagnostic("parse and convert ndk-build output to build configuration JSON", new Object[0]);
/*     */     
/* 147 */     NativeBuildConfigValue buildConfig = new NativeBuildConfigValueBuilder(getMakeFile(), projectDir).addCommands(getBuildCommand(abi, abiPlatformVersion, applicationMk, false), getBuildCommand(abi, abiPlatformVersion, applicationMk, true) + " clean", variantName, buildOutput).build();
/*     */     
/* 149 */     if (applicationMk.exists()) {
/* 150 */       diagnostic("found application make file %s", new Object[] { applicationMk.getAbsolutePath() });
/* 151 */       Preconditions.checkNotNull(buildFiles);
/* 152 */       buildFiles.add(applicationMk);
/*     */     }
/*     */     
/* 159 */     String actualResult = new GsonBuilder().registerTypeAdapter(File.class, new PlainFileGsonTypeAdaptor()).setPrettyPrinting().create().toJson(buildConfig);
/*     */     
/* 162 */     File expectedJson = ExternalNativeBuildTaskUtils.getOutputJson(getJsonFolder(), abi);
/* 163 */     Files.write(expectedJson.toPath(), actualResult.getBytes(Charsets.UTF_8), new OpenOption[0]);
/*     */   }
/*     */   
/*     */   ProcessInfoBuilder getProcessBuilder(String abi, int abiPlatformVersion, File outputJson)
/*     */   {
/* 174 */     checkConfiguration();
/*     */     
/* 177 */     File applicationMk = new File(getMakeFile().getParent(), "Application.mk");
/* 178 */     ProcessInfoBuilder builder = new ProcessInfoBuilder();
/* 179 */     builder.setExecutable(getNdkBuild())
/* 180 */       .addArgs(
/* 181 */       getBaseArgs(abi, abiPlatformVersion, applicationMk, false))
/*     */       
/* 184 */       .addArgs("APP_SHORT_COMMANDS=false")
/* 185 */       .addArgs("LOCAL_SHORT_COMMANDS=false")
/* 186 */       .addArgs("-B")
/* 187 */       .addArgs("-n");
/* 188 */     return builder;
/*     */   }
/*     */   
/*     */   String executeProcess(String abi, int abiPlatformVersion, File outputJsonDir)
/*     */     throws ProcessException, IOException
/*     */   {
/* 195 */     return ExternalNativeBuildTaskUtils.executeBuildProcessAndLogError(androidBuilder, 
/*     */     
/* 197 */       getProcessBuilder(abi, abiPlatformVersion, outputJsonDir), false);
/*     */   }
/*     */   
/*     */   public NativeBuildSystem getNativeBuildSystem()
/*     */   {
/* 204 */     return NativeBuildSystem.NDK_BUILD;
/*     */   }
/*     */   
/*     */   Map<Abi, File> getStlSharedObjectFiles()
/*     */   {
/* 210 */     return Maps.newHashMap();
/*     */   }
/*     */   
/*     */   private String getNdkBuild()
/*     */   {
/* 216 */     String tool = "ndk-build";
/* 217 */     if (isWindows()) {
/* 218 */       tool = tool + ".cmd";
/*     */     }
/* 220 */     File toolFile = new File(getNdkFolder(), tool);
/*     */     
/*     */     try
/*     */     {
/* 225 */       return toolFile.getCanonicalPath();
/*     */     } catch (IOException e) {
/* 227 */       warn("Attempted to get ndkFolder canonical path and failed: %s\nFalling back to absolute path.", new Object[] { e });
/*     */     }
/* 229 */     return toolFile.getAbsolutePath();
/*     */   }
/*     */   
/*     */   private File getMakeFile()
/*     */   {
/* 238 */     if (getMakefile().isDirectory()) {
/* 239 */       return new File(getMakefile(), "Android.mk");
/*     */     }
/* 241 */     return getMakefile();
/*     */   }
/*     */   
/*     */   private void checkConfiguration()
/*     */   {
/* 249 */     List<String> configurationErrors = getConfigurationErrors();
/* 250 */     if (!configurationErrors.isEmpty()) {
/* 251 */       throw new GradleException(Joiner.on("\n").join(configurationErrors));
/*     */     }
/*     */   }
/*     */   
/*     */   private List<String> getBaseArgs(String abi, int abiPlatformVersion, File applicationMk, boolean removeJobsFlag)
/*     */   {
/* 262 */     List<String> result = Lists.newArrayList();
/* 263 */     result.add("NDK_PROJECT_PATH=null");
/* 264 */     result.add("APP_BUILD_SCRIPT=" + getMakeFile());
/*     */     
/* 266 */     if (applicationMk.exists())
/*     */     {
/* 268 */       result.add("NDK_APPLICATION_MK=" + applicationMk.getAbsolutePath());
/*     */     }
/*     */     
/* 275 */     result.add("APP_ABI=" + abi);
/* 276 */     result.add("NDK_ALL_ABIS=" + abi);
/*     */     
/* 278 */     if (isDebuggable()) {
/* 279 */       result.add("NDK_DEBUG=1");
/*     */     } else {
/* 281 */       result.add("NDK_DEBUG=0");
/*     */     }
/*     */     
/* 284 */     result.add("APP_PLATFORM=android-" + abiPlatformVersion);
/*     */     
/* 288 */     String ndkOut = getObjFolder().getParent();
/* 289 */     if (SdkConstants.CURRENT_PLATFORM == 2)
/*     */     {
/* 295 */       ndkOut = ndkOut.replace('\\', '/');
/*     */     }
/* 297 */     result.add("NDK_OUT=" + ndkOut);
/*     */     
/* 299 */     result.add("NDK_LIBS_OUT=" + getSoFolder().getAbsolutePath());
/*     */     
/* 305 */     for (String flag : getcFlags()) {
/* 306 */       result.add(String.format("APP_CFLAGS+=%s", new Object[] { flag }));
/*     */     }
/*     */     
/* 309 */     for (??? = getCppFlags().iterator(); ???.hasNext();) { flag = (String)???.next();
/* 310 */       result.add(String.format("APP_CPPFLAGS+=%s", new Object[] { flag }));
/*     */     }
/*     */     String flag;
/* 313 */     boolean skipNextArgument = false;
/* 314 */     for (String argument : getBuildArguments())
/*     */     {
/* 317 */       if ((removeJobsFlag) && (argument.equals("-j")))
/*     */       {
/* 320 */         skipNextArgument = true;
/*     */       }
/* 323 */       else if ((removeJobsFlag) && (argument.equals("--jobs")))
/*     */       {
/* 326 */         skipNextArgument = true;
/*     */       }
/* 329 */       else if (skipNextArgument)
/*     */       {
/* 331 */         skipNextArgument = false;
/*     */       }
/* 334 */       else if ((!removeJobsFlag) || ((!argument.startsWith("-j")) && (!argument.startsWith("--jobs="))))
/*     */       {
/* 339 */         result.add(argument);
/*     */       }
/*     */     }
/* 342 */     return result;
/*     */   }
/*     */   
/*     */   private String getBuildCommand(String abi, int abiPlatformVersion, File applicationMk, boolean removeJobsFlag)
/*     */   {
/* 352 */     return 
/*     */     
/* 355 */       getNdkBuild() + " " + Joiner.on(" ").join(getBaseArgs(abi, abiPlatformVersion, applicationMk, removeJobsFlag));
/*     */   }
/*     */   
/*     */   private List<String> getConfigurationErrors()
/*     */   {
/* 363 */     List<String> messages = Lists.newArrayList();
/* 364 */     if (getMakefile().isDirectory()) {
/* 365 */       messages.add(
/* 366 */         String.format("Gradle project ndkBuild.path %s is a folder. Only files (like Android.mk) are allowed.", new Object[] {
/*     */         
/* 369 */         getMakefile() }));
/* 370 */     } else if (!getMakefile().exists()) {
/* 371 */       messages.add(
/* 372 */         String.format("Gradle project ndkBuild.path is %s but that file doesn't exist", new Object[] {
/* 373 */         getMakefile() }));
/*     */     }
/*     */     
/* 376 */     messages.addAll(getBaseConfigurationErrors());
/* 377 */     return messages;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.NdkBuildExternalNativeJsonGenerator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */