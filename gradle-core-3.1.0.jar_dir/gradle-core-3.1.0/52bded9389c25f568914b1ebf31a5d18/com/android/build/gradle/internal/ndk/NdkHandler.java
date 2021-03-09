/*     */ package com.android.build.gradle.internal.ndk;
/*     */ 
/*     */ import com.android.build.gradle.internal.SdkHandler;
/*     */ import com.android.build.gradle.internal.core.Abi;
/*     */ import com.android.build.gradle.internal.core.Toolchain;
/*     */ import com.android.repository.Revision;
/*     */ import com.android.utils.Pair;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.Collection;
/*     */ import java.util.Properties;
/*     */ import org.gradle.api.InvalidUserDataException;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.logging.Logging;
/*     */ 
/*     */ public class NdkHandler
/*     */ {
/*     */   private String platformVersion;
/*     */   private String compileSdkVersion;
/*     */   private final Toolchain toolchain;
/*     */   private final String toolchainVersion;
/*     */   private final File ndkDirectory;
/*     */   private final boolean useUnifiedHeaders;
/*     */   private final NdkInfo ndkInfo;
/*     */   private final Revision revision;
/*     */   private static final int LATEST_SUPPORTED_VERSION = 14;
/*     */   
/*     */   public NdkHandler(File projectDir, String platformVersion, String toolchainName, String toolchainVersion, Boolean useUnifiedHeaders)
/*     */   {
/*  69 */     toolchain = Toolchain.getByName(toolchainName);
/*  70 */     this.toolchainVersion = toolchainVersion;
/*  71 */     this.platformVersion = platformVersion;
/*  72 */     ndkDirectory = findNdkDirectory(projectDir);
/*     */     
/*  74 */     if ((ndkDirectory == null) || (!ndkDirectory.exists())) {
/*  75 */       ndkInfo = null;
/*  76 */       revision = null;
/*     */     } else {
/*  78 */       revision = findRevision(ndkDirectory);
/*  79 */       if (revision == null) {
/*  80 */         ndkInfo = new DefaultNdkInfo(ndkDirectory);
/*  81 */       } else if (revision.getMajor() > 14) {
/*  82 */         ndkInfo = new NdkR14Info(ndkDirectory);
/*     */       } else {
/*  84 */         switch (revision.getMajor()) {
/*     */         case 14: 
/*  86 */           ndkInfo = new NdkR14Info(ndkDirectory);
/*  87 */           break;
/*     */         case 13: 
/*  89 */           ndkInfo = new NdkR13Info(ndkDirectory);
/*  90 */           break;
/*     */         case 12: 
/*  92 */           ndkInfo = new NdkR12Info(ndkDirectory);
/*  93 */           break;
/*     */         case 11: 
/*  95 */           ndkInfo = new NdkR11Info(ndkDirectory);
/*  96 */           break;
/*     */         default: 
/*  98 */           ndkInfo = new DefaultNdkInfo(ndkDirectory);
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     
/* 107 */     this.useUnifiedHeaders = ((revision != null) && (revision.getMajor() > 14) ? true : useUnifiedHeaders != null ? useUnifiedHeaders.booleanValue() : false);
/*     */     
/* 109 */     if ((this.useUnifiedHeaders) && ((revision == null) || (revision.getMajor() < 14))) {
/* 110 */       throw new InvalidUserDataException("Unified headers is not supported before NDK r14.");
/*     */     }
/*     */   }
/*     */   
/*     */   private static Properties readProperties(File file) {
/* 115 */     Properties properties = new Properties();
/* 116 */     try { FileInputStream fis = new FileInputStream(file);Throwable localThrowable6 = null;
/* 117 */       try { InputStreamReader reader = new InputStreamReader(fis, Charsets.UTF_8);Throwable localThrowable7 = null;
/* 118 */         try { properties.load(reader);
/*     */         }
/*     */         catch (Throwable localThrowable1)
/*     */         {
/* 116 */           localThrowable7 = localThrowable1;throw localThrowable1; } finally {} } catch (Throwable localThrowable4) { localThrowable6 = localThrowable4;throw localThrowable4;
/*     */       }
/*     */       finally {
/* 119 */         if (fis != null) if (localThrowable6 != null) try { fis.close(); } catch (Throwable localThrowable5) { localThrowable6.addSuppressed(localThrowable5); } else fis.close();
/*     */       }
/*     */     }
/*     */     catch (FileNotFoundException localFileNotFoundException) {}catch (IOException e) {
/* 123 */       throw new RuntimeException(String.format("Unable to read %1$s.", new Object[] { file }), e);
/*     */     }
/* 125 */     return properties;
/*     */   }
/*     */   
/*     */   public static Revision findRevision(File ndkDirectory)
/*     */   {
/* 131 */     if (ndkDirectory == null) {
/* 132 */       return null;
/*     */     }
/* 134 */     File sourceProperties = new File(ndkDirectory, "source.properties");
/* 135 */     if (!sourceProperties.exists())
/*     */     {
/* 137 */       return null;
/*     */     }
/* 139 */     Properties properties = readProperties(sourceProperties);
/* 140 */     String version = properties.getProperty("Pkg.Revision");
/* 141 */     if (version != null) {
/* 142 */       return Revision.parseRevision(version);
/*     */     }
/* 144 */     return null;
/*     */   }
/*     */   
/*     */   public Revision getRevision()
/*     */   {
/* 152 */     return revision;
/*     */   }
/*     */   
/*     */   public String getPlatformVersion()
/*     */   {
/* 157 */     if ((platformVersion == null) && (compileSdkVersion != null)) {
/* 158 */       Preconditions.checkNotNull(ndkInfo);
/* 159 */       platformVersion = ndkInfo.findLatestPlatformVersion(compileSdkVersion);
/*     */     }
/* 161 */     return platformVersion;
/*     */   }
/*     */   
/*     */   public void setCompileSdkVersion(String compileSdkVersion) {
/* 165 */     this.compileSdkVersion = compileSdkVersion;
/*     */   }
/*     */   
/*     */   public Toolchain getToolchain() {
/* 169 */     return toolchain;
/*     */   }
/*     */   
/*     */   public String getToolchainVersion() {
/* 173 */     return toolchainVersion;
/*     */   }
/*     */   
/*     */   private static File findNdkDirectory(File projectDir)
/*     */   {
/* 178 */     File localProperties = new File(projectDir, "local.properties");
/* 179 */     Properties properties = new Properties();
/* 180 */     if (localProperties.isFile()) {
/* 181 */       properties = readProperties(localProperties);
/*     */     }
/*     */     
/* 184 */     File ndkDir = findNdkDirectory(properties, projectDir);
/* 185 */     if (ndkDir == null) {
/* 186 */       return null;
/*     */     }
/* 188 */     return checkNdkDir(ndkDir) ? ndkDir : null;
/*     */   }
/*     */   
/*     */   private static boolean checkNdkDir(File ndkDir)
/*     */   {
/* 195 */     if (!new File(ndkDir, "platforms").isDirectory()) {
/* 196 */       invalidNdkWarning("NDK is missing a \"platforms\" directory.", ndkDir);
/* 197 */       return false;
/*     */     }
/* 199 */     if (!new File(ndkDir, "toolchains").isDirectory()) {
/* 200 */       invalidNdkWarning("NDK is missing a \"toolchains\" directory.", ndkDir);
/* 201 */       return false;
/*     */     }
/* 203 */     return true;
/*     */   }
/*     */   
/*     */   private static void invalidNdkWarning(String message, File ndkDir) {
/* 207 */     Logging.getLogger(NdkHandler.class).warn("{}\nIf you are using NDK, verify the ndk.dir is set to a valid NDK directory.  It is currently set to {}.\nIf you are not using NDK, unset the NDK variable from ANDROID_NDK_HOME or local.properties to remove this warning.\n", message, ndkDir
/*     */     
/* 214 */       .getAbsolutePath());
/*     */   }
/*     */   
/*     */   public static File findNdkDirectory(Properties properties, File projectDir)
/*     */   {
/* 227 */     String ndkDirProp = properties.getProperty("ndk.dir");
/* 228 */     if (ndkDirProp != null) {
/* 229 */       return new File(ndkDirProp);
/*     */     }
/*     */     
/* 232 */     String ndkEnvVar = System.getenv("ANDROID_NDK_HOME");
/* 233 */     if (ndkEnvVar != null) {
/* 234 */       return new File(ndkEnvVar);
/*     */     }
/*     */     
/* 237 */     Pair<File, Boolean> sdkLocation = SdkHandler.findSdkLocation(properties, projectDir);
/* 238 */     File sdkFolder = (File)sdkLocation.getFirst();
/* 239 */     if (sdkFolder != null)
/*     */     {
/* 241 */       File ndkBundle = new File(sdkFolder, "ndk-bundle");
/* 242 */       if (ndkBundle.isDirectory()) {
/* 243 */         return ndkBundle;
/*     */       }
/*     */     }
/*     */     
/* 247 */     return null;
/*     */   }
/*     */   
/*     */   public File getNdkDirectory()
/*     */   {
/* 255 */     return ndkDirectory;
/*     */   }
/*     */   
/*     */   public boolean isConfigured()
/*     */   {
/* 262 */     return (ndkDirectory != null) && (ndkDirectory.isDirectory());
/*     */   }
/*     */   
/*     */   private File getToolchainPath(Toolchain toolchain, String toolchainVersion, Abi abi)
/*     */   {
/* 278 */     Preconditions.checkNotNull(ndkInfo);
/* 279 */     return ndkInfo.getToolchainPath(toolchain, toolchainVersion, abi);
/*     */   }
/*     */   
/*     */   public boolean isUseUnifiedHeaders() {
/* 283 */     return useUnifiedHeaders;
/*     */   }
/*     */   
/*     */   public String getCompilerSysroot(Abi abi)
/*     */   {
/* 289 */     if (getPlatformVersion() == null) {
/* 290 */       return "";
/*     */     }
/* 292 */     Preconditions.checkNotNull(ndkInfo);
/* 293 */     return ndkInfo.getCompilerSysrootPath(abi, getPlatformVersion(), useUnifiedHeaders);
/*     */   }
/*     */   
/*     */   public String getCompilerSysroot(Abi abi, String platformVersionOverride)
/*     */   {
/* 300 */     Preconditions.checkNotNull(ndkInfo);
/* 301 */     if (platformVersionOverride == null) {
/* 302 */       return getCompilerSysroot(abi);
/*     */     }
/* 304 */     return ndkInfo.getCompilerSysrootPath(abi, platformVersionOverride, useUnifiedHeaders);
/*     */   }
/*     */   
/*     */   public String getLinkerSysroot(Abi abi)
/*     */   {
/* 310 */     if (getPlatformVersion() == null) {
/* 311 */       return "";
/*     */     }
/* 313 */     Preconditions.checkNotNull(ndkInfo);
/* 314 */     return ndkInfo.getLinkerSysrootPath(abi, getPlatformVersion());
/*     */   }
/*     */   
/*     */   public String getLinkerSysroot(Abi abi, String platformVersionOverride)
/*     */   {
/* 321 */     Preconditions.checkNotNull(ndkInfo);
/* 322 */     if (platformVersionOverride == null) {
/* 323 */       return getLinkerSysroot(abi);
/*     */     }
/* 325 */     return ndkInfo.getLinkerSysrootPath(abi, platformVersionOverride);
/*     */   }
/*     */   
/*     */   private boolean supports64Bits()
/*     */   {
/* 331 */     if (getPlatformVersion() == null) {
/* 332 */       return false;
/*     */     }
/* 334 */     String targetString = getPlatformVersion().replace("android-", "");
/*     */     try {
/* 336 */       return Integer.parseInt(targetString) >= 20;
/*     */     }
/*     */     catch (NumberFormatException ignored) {}
/* 339 */     return true;
/*     */   }
/*     */   
/*     */   private String getGccToolchainVersion(Abi abi)
/*     */   {
/* 353 */     Preconditions.checkNotNull(ndkInfo);
/* 354 */     return (toolchain == Toolchain.GCC) && (!toolchainVersion.isEmpty()) ? toolchainVersion : ndkInfo
/*     */     
/* 356 */       .getDefaultToolchainVersion(Toolchain.GCC, abi);
/*     */   }
/*     */   
/*     */   public File getDefaultGccToolchainPath(Abi abi)
/*     */   {
/* 364 */     return getToolchainPath(Toolchain.GCC, getGccToolchainVersion(abi), abi);
/*     */   }
/*     */   
/*     */   public static Collection<Abi> getAbiList()
/*     */   {
/* 372 */     return ImmutableList.copyOf(Abi.values());
/*     */   }
/*     */   
/*     */   public static Collection<Abi> getDefaultAbiList()
/*     */   {
/* 378 */     return Abi.getDefaultValues();
/*     */   }
/*     */   
/*     */   private static Collection<Abi> getAbiList32()
/*     */   {
/* 386 */     ImmutableList.Builder<Abi> builder = ImmutableList.builder();
/* 387 */     for (Abi abi : Abi.values()) {
/* 388 */       if (!abi.supports64Bits()) {
/* 389 */         builder.add(abi);
/*     */       }
/*     */     }
/* 392 */     return builder.build();
/*     */   }
/*     */   
/*     */   public Collection<Abi> getSupportedAbis()
/*     */   {
/* 400 */     if (ndkInfo != null) {
/* 401 */       return supports64Bits() ? ndkInfo.getSupportedAbis() : ndkInfo.getSupported32BitsAbis();
/*     */     }
/* 403 */     return supports64Bits() ? getAbiList() : getAbiList32();
/*     */   }
/*     */   
/*     */   public Collection<Abi> getDefaultAbis()
/*     */   {
/* 409 */     if (ndkInfo != null) {
/* 410 */       return supports64Bits() ? ndkInfo.getDefaultAbis() : ndkInfo.getDefault32BitsAbis();
/*     */     }
/* 412 */     return supports64Bits() ? getAbiList() : getAbiList32();
/*     */   }
/*     */   
/*     */   public File getCCompiler(Abi abi)
/*     */   {
/* 420 */     Preconditions.checkNotNull(ndkInfo);
/* 421 */     return ndkInfo.getCCompiler(toolchain, toolchainVersion, abi);
/*     */   }
/*     */   
/*     */   public File getCppCompiler(Abi abi)
/*     */   {
/* 429 */     Preconditions.checkNotNull(ndkInfo);
/* 430 */     return ndkInfo.getCppCompiler(toolchain, toolchainVersion, abi);
/*     */   }
/*     */   
/*     */   public File getLinker(Abi abi)
/*     */   {
/* 438 */     Preconditions.checkNotNull(ndkInfo);
/* 439 */     return ndkInfo.getLinker(toolchain, toolchainVersion, abi);
/*     */   }
/*     */   
/*     */   public File getAssembler(Abi abi)
/*     */   {
/* 447 */     Preconditions.checkNotNull(ndkInfo);
/* 448 */     return ndkInfo.getAssembler(toolchain, toolchainVersion, abi);
/*     */   }
/*     */   
/*     */   public File getAr(Abi abi)
/*     */   {
/* 455 */     Preconditions.checkNotNull(ndkInfo);
/* 456 */     return ndkInfo.getAr(toolchain, toolchainVersion, abi);
/*     */   }
/*     */   
/*     */   public File getStripExecutable(Abi abi)
/*     */   {
/* 464 */     Preconditions.checkNotNull(ndkInfo);
/* 465 */     return ndkInfo.getStripExecutable(toolchain, toolchainVersion, abi);
/*     */   }
/*     */   
/*     */   public StlNativeToolSpecification getStlNativeToolSpecification(Stl stl, String stlVersion, Abi abi)
/*     */   {
/* 472 */     Preconditions.checkNotNull(ndkInfo);
/* 473 */     return ndkInfo.getStlNativeToolSpecification(stl, stlVersion, abi);
/*     */   }
/*     */   
/*     */   public int findSuitablePlatformVersion(String abi, int minSdkVersion) {
/* 477 */     Preconditions.checkNotNull(ndkInfo);
/* 478 */     return ndkInfo.findSuitablePlatformVersion(abi, minSdkVersion);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.NdkHandler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */