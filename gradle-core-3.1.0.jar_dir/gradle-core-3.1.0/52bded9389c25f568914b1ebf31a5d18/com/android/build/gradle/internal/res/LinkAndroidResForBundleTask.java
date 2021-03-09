/*     */ package com.android.build.gradle.internal.res;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.aapt.AaptGeneration;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.AaptOptions;
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.OutputScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.build.gradle.options.StringOption;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.internal.aapt.Aapt;
/*     */ import com.android.ide.common.blame.MergingLog;
/*     */ import com.android.ide.common.blame.MessageReceiver;
/*     */ import com.android.ide.common.blame.ParsingProcessOutputHandler;
/*     */ import com.android.ide.common.blame.SourceFilePosition;
/*     */ import com.android.ide.common.blame.parser.PatternAwareOutputParser;
/*     */ import com.android.ide.common.blame.parser.aapt.Aapt2OutputParser;
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import com.android.utils.FileUtils;
/*     */ import java.io.File;
/*     */ import java.util.function.Function;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.gradle.api.tasks.OutputFile;
/*     */ import org.gradle.api.tasks.PathSensitive;
/*     */ import org.gradle.api.tasks.PathSensitivity;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @org.gradle.api.tasks.CacheableTask
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000P\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\t\n\002\030\002\n\002\030\002\n\002\b\f\n\002\020\b\n\002\b\017\n\002\030\002\n\000\n\002\020\002\n\002\b\002\b\027\030\0002\0020\001:\001;B\005¢\006\002\020\002J\n\0203\032\004\030\0010\006H\007J\b\0204\032\0020\bH\007J\n\0205\032\004\030\0010\032H\007J\b\0206\032\0020\020H\007J\b\0207\032\00208H\002J\b\0209\032\0020:H\007R\020\020\003\032\004\030\0010\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X.¢\006\002\n\000R\020\020\007\032\004\030\0010\bX\016¢\006\002\n\000R&\020\013\032\0020\n2\006\020\t\032\0020\n8\007@BX.¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R&\020\021\032\0020\0202\006\020\t\032\0020\0208\007@BX\016¢\006\016\n\000\032\004\b\022\020\023\"\004\b\024\020\025R&\020\026\032\0020\n2\006\020\t\032\0020\n8\007@BX.¢\006\016\n\000\032\004\b\027\020\r\"\004\b\030\020\017R\020\020\031\032\004\030\0010\032X\016¢\006\002\n\000R&\020\034\032\0020\0332\006\020\t\032\0020\0338\007@BX.¢\006\016\n\000\032\004\b\035\020\036\"\004\b\037\020 R&\020!\032\0020\0322\006\020\t\032\0020\0328\007@BX.¢\006\016\n\000\032\004\b\"\020#\"\004\b$\020%R\020\020&\032\004\030\0010\nX\016¢\006\002\n\000R\016\020'\032\0020\020X\016¢\006\002\n\000R&\020)\032\0020(2\006\020\t\032\0020(8\007@BX\016¢\006\016\n\000\032\004\b*\020+\"\004\b,\020-R*\020.\032\004\030\0010\b2\b\020\t\032\004\030\0010\b8\007@BX\016¢\006\016\n\000\032\004\b/\0200\"\004\b1\0202¨\006<"}, d2={"Lcom/android/build/gradle/internal/res/LinkAndroidResForBundleTask;", "Lcom/android/build/gradle/internal/tasks/AndroidBuilderTask;", "()V", "aaptGeneration", "Lcom/android/build/gradle/internal/aapt/AaptGeneration;", "aaptOptions", "Lcom/android/build/gradle/internal/dsl/AaptOptions;", "buildTargetDensity", "", "<set-?>", "Ljava/io/File;", "bundledResFile", "getBundledResFile", "()Ljava/io/File;", "setBundledResFile", "(Ljava/io/File;)V", "", "debuggable", "getDebuggable", "()Z", "setDebuggable", "(Z)V", "incrementalFolder", "getIncrementalFolder", "setIncrementalFolder", "inputResourcesDir", "Lorg/gradle/api/file/FileCollection;", "Lcom/android/ide/common/build/ApkInfo;", "mainSplit", "getMainSplit", "()Lcom/android/ide/common/build/ApkInfo;", "setMainSplit", "(Lcom/android/ide/common/build/ApkInfo;)V", "manifestFiles", "getManifestFiles", "()Lorg/gradle/api/file/FileCollection;", "setManifestFiles", "(Lorg/gradle/api/file/FileCollection;)V", "mergeBlameLogFolder", "pseudoLocalesEnabled", "", "versionCode", "getVersionCode", "()I", "setVersionCode", "(I)V", "versionName", "getVersionName", "()Ljava/lang/String;", "setVersionName", "(Ljava/lang/String;)V", "getAaptOptions", "getBuildToolsVersion", "getInputResourcesDir", "getPseudoLocalesEnabled", "makeAapt", "Lcom/android/builder/internal/aapt/Aapt;", "taskAction", "", "ConfigAction", "gradle-core"})
/*     */ public class LinkAndroidResForBundleTask
/*     */   extends com.android.build.gradle.internal.tasks.AndroidBuilderTask
/*     */ {
/*     */   private AaptGeneration aaptGeneration;
/*     */   private boolean debuggable;
/*     */   private boolean pseudoLocalesEnabled;
/*     */   private AaptOptions aaptOptions;
/*     */   private File mergeBlameLogFolder;
/*     */   private String buildTargetDensity;
/*     */   @NotNull
/*     */   private File bundledResFile;
/*     */   @Nullable
/*     */   private String versionName;
/*     */   private int versionCode;
/*     */   @NotNull
/*     */   private File incrementalFolder;
/*     */   @NotNull
/*     */   private ApkInfo mainSplit;
/*     */   @NotNull
/*     */   private FileCollection manifestFiles;
/*     */   private FileCollection inputResourcesDir;
/*     */   
/*     */   @Input
/*  69 */   public final boolean getDebuggable() { return debuggable; } private final void setDebuggable(boolean <set-?>) { debuggable = <set-?>; }
/*     */   
/*     */   @OutputFile
/*     */   @NotNull
/*     */   public final File getBundledResFile()
/*     */   {
/*  81 */     File tmp4_1 = bundledResFile;
/*     */     
/*  81 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("bundledResFile"); return tmp4_1; } private final void setBundledResFile(File <set-?>) { bundledResFile = <set-?>; }
/*     */   
/*     */   @Input
/*     */   @Optional
/*     */   @Nullable
/*  86 */   public final String getVersionName() { return versionName; } private final void setVersionName(String <set-?>) { versionName = <set-?>; }
/*     */   
/*     */   @Input
/*  90 */   public final int getVersionCode() { return versionCode; } private final void setVersionCode(int <set-?>) { versionCode = <set-?>; }
/*     */   
/*     */   @OutputDirectory
/*     */   @NotNull
/*  94 */   public final File getIncrementalFolder() { File tmp4_1 = incrementalFolder;
/*     */     
/*  94 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("incrementalFolder"); return tmp4_1; } private final void setIncrementalFolder(File <set-?>) { incrementalFolder = <set-?>; }
/*     */   
/*     */   @Input
/*     */   @NotNull
/*  98 */   public final ApkInfo getMainSplit() { ApkInfo tmp4_1 = mainSplit;
/*     */     
/*  98 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("mainSplit"); return tmp4_1; } private final void setMainSplit(ApkInfo <set-?>) { mainSplit = <set-?>; }
/*     */   
/*     */   private final Aapt makeAapt()
/*     */   {
/* 150 */     AndroidBuilder builder = getBuilder(); File 
/* 151 */       tmp13_10 = mergeBlameLogFolder;
/* 151 */     if (tmp13_10 == null) Intrinsics.throwNpe(); MergingLog mergingLog = new MergingLog(tmp13_10); MessageReceiver[] 
/*     */     
/* 154 */       tmp53_50 = new MessageReceiver[1]; AndroidBuilder 
/*     */     
/* 157 */       tmp71_70 = ;; { public final SourceFilePosition apply(@NotNull SourceFilePosition it) { Intrinsics.checkParameterIsNotNull(it, "it");return $mergingLog.find(it);
/* 157 */       } }, tmp71_70.getMessageReceiver()));ParsingProcessOutputHandler processOutputHandler = new ParsingProcessOutputHandler(, ); AaptGeneration 
/*     */     
/* 160 */       tmp95_92 = aaptGeneration;
/*     */     
/* 160 */     if (tmp95_92 == null) { Intrinsics.throwNpe();
/*     */     }
/*     */     
/* 164 */     File tmp116_113 = incrementalFolder;
/*     */     
/* 164 */     if (tmp116_113 == null) Intrinsics.throwUninitializedPropertyAccessException("incrementalFolder");
/* 165 */     AaptOptions tmp138_135 = aaptOptions;
/*     */     
/* 165 */     if (tmp138_135 == null) Intrinsics.throwUninitializedPropertyAccessException("aaptOptions");
/* 159 */     Aapt tmp153_150 = com.android.build.gradle.internal.aapt.AaptGradleFactory.make(
/* 160 */       tmp95_92, 
/* 161 */       builder, 
/* 162 */       (com.android.ide.common.process.ProcessOutputHandler)processOutputHandler, 
/* 163 */       true, 
/* 164 */       FileUtils.mkdirs(new File(tmp116_113, "aapt-temp")), 
/* 165 */       tmp138_135.getCruncherProcesses());Intrinsics.checkExpressionValueIsNotNull(tmp153_150, "AaptGradleFactory.make(\n…ptions.cruncherProcesses)");return tmp153_150;
/*     */   }
/*     */   
/*     */   @InputFiles
/*     */   @PathSensitive(PathSensitivity.RELATIVE)
/*     */   @NotNull
/*     */   public final FileCollection getManifestFiles()
/*     */   {
/* 170 */     FileCollection tmp4_1 = manifestFiles;
/*     */     
/* 170 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("manifestFiles"); return tmp4_1; } private final void setManifestFiles(FileCollection <set-?>) { manifestFiles = <set-?>; }
/*     */   
/*     */   @InputFiles
/*     */   @Optional
/*     */   @PathSensitive(PathSensitivity.RELATIVE)
/*     */   @Nullable
/* 179 */   public final FileCollection getInputResourcesDir() { return inputResourcesDir; }
/*     */   
/*     */   @Input
/*     */   @NotNull
/*     */   public final String getBuildToolsVersion() {
/* 184 */     BuildToolInfo tmp4_1 = getBuildTools();Intrinsics.checkExpressionValueIsNotNull(tmp4_1, "buildTools"); String tmp17_14 = tmp4_1.getRevision().toString();Intrinsics.checkExpressionValueIsNotNull(tmp17_14, "buildTools.revision.toString()");return tmp17_14;
/*     */   }
/*     */   
/*     */   @Input
/* 189 */   public final boolean getPseudoLocalesEnabled() { return pseudoLocalesEnabled; }
/*     */   
/*     */   @org.gradle.api.tasks.Nested
/*     */   @Nullable
/*     */   public final AaptOptions getAaptOptions() {
/* 194 */     AaptOptions tmp4_1 = aaptOptions;
/*     */     
/* 194 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("aaptOptions"); return tmp4_1;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @org.gradle.api.tasks.TaskAction
/*     */   public final void taskAction()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: getstatic 93	com/android/build/gradle/internal/scope/ExistingBuildElements:Companion	Lcom/android/build/gradle/internal/scope/ExistingBuildElements$Companion;
/*     */     //   3: getstatic 99	com/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType:MERGED_MANIFESTS	Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;
/*     */     //   6: checkcast 101	com/android/build/gradle/internal/scope/TaskOutputHolder$OutputType
/*     */     //   9: aload_0
/*     */     //   10: getfield 105	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:manifestFiles	Lorg/gradle/api/file/FileCollection;
/*     */     //   13: dup
/*     */     //   14: ifnonnull +8 -> 22
/*     */     //   17: ldc 106
/*     */     //   19: invokestatic 40	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   22: invokevirtual 112	com/android/build/gradle/internal/scope/ExistingBuildElements$Companion:from	(Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;Lorg/gradle/api/file/FileCollection;)Lcom/android/build/gradle/internal/scope/BuildElements;
/*     */     //   25: aload_0
/*     */     //   26: getfield 73	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:mainSplit	Lcom/android/ide/common/build/ApkInfo;
/*     */     //   29: dup
/*     */     //   30: ifnonnull +8 -> 38
/*     */     //   33: ldc 74
/*     */     //   35: invokestatic 40	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   38: invokevirtual 118	com/android/build/gradle/internal/scope/BuildElements:element	(Lcom/android/ide/common/build/ApkInfo;)Lcom/android/build/gradle/internal/scope/BuildOutput;
/*     */     //   41: dup
/*     */     //   42: ifnull +13 -> 55
/*     */     //   45: invokevirtual 123	com/android/build/gradle/internal/scope/BuildOutput:getOutputFile	()Ljava/io/File;
/*     */     //   48: dup
/*     */     //   49: ifnull +6 -> 55
/*     */     //   52: goto +17 -> 69
/*     */     //   55: pop
/*     */     //   56: new 125	java/lang/RuntimeException
/*     */     //   59: dup
/*     */     //   60: ldc 127
/*     */     //   62: invokespecial 130	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
/*     */     //   65: checkcast 83	java/lang/Throwable
/*     */     //   68: athrow
/*     */     //   69: astore_1
/*     */     //   70: aload_0
/*     */     //   71: getfield 33	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:bundledResFile	Ljava/io/File;
/*     */     //   74: dup
/*     */     //   75: ifnonnull +8 -> 83
/*     */     //   78: ldc 34
/*     */     //   80: invokestatic 40	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   83: invokevirtual 133	java/io/File:getParentFile	()Ljava/io/File;
/*     */     //   86: invokestatic 139	com/android/utils/FileUtils:mkdirs	(Ljava/io/File;)Ljava/io/File;
/*     */     //   89: pop
/*     */     //   90: nop
/*     */     //   91: aload_0
/*     */     //   92: astore_2
/*     */     //   93: aload_2
/*     */     //   94: checkcast 2	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask
/*     */     //   97: astore_3
/*     */     //   98: new 141	com/android/builder/internal/aapt/AaptPackageConfig
/*     */     //   101: dup
/*     */     //   102: aload_3
/*     */     //   103: invokevirtual 145	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:getBuilder	()Lcom/android/builder/core/AndroidBuilder;
/*     */     //   106: dup
/*     */     //   107: ldc -109
/*     */     //   109: invokestatic 151	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   112: invokevirtual 157	com/android/builder/core/AndroidBuilder:getTarget	()Lcom/android/sdklib/IAndroidTarget;
/*     */     //   115: iconst_1
/*     */     //   116: invokeinterface 163 2 0
/*     */     //   121: dup
/*     */     //   122: ldc -91
/*     */     //   124: invokestatic 151	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   127: iconst_1
/*     */     //   128: aload_1
/*     */     //   129: dup
/*     */     //   130: ldc -89
/*     */     //   132: invokestatic 151	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   135: aload_3
/*     */     //   136: getfield 169	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:aaptOptions	Lcom/android/build/gradle/internal/dsl/AaptOptions;
/*     */     //   139: dup
/*     */     //   140: ifnonnull +8 -> 148
/*     */     //   143: ldc -86
/*     */     //   145: invokestatic 40	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   148: invokestatic 176	com/android/build/gradle/internal/dsl/DslAdaptersKt:convert	(Lcom/android/build/gradle/internal/dsl/AaptOptions;)Lcom/android/builder/internal/aapt/AaptOptions;
/*     */     //   151: aconst_null
/*     */     //   152: aload_3
/*     */     //   153: getfield 33	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:bundledResFile	Ljava/io/File;
/*     */     //   156: dup
/*     */     //   157: ifnonnull +8 -> 165
/*     */     //   160: ldc 34
/*     */     //   162: invokestatic 40	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   165: aconst_null
/*     */     //   166: aconst_null
/*     */     //   167: iconst_0
/*     */     //   168: getstatic 182	com/android/builder/core/VariantType:DEFAULT	Lcom/android/builder/core/VariantType;
/*     */     //   171: aconst_null
/*     */     //   172: aconst_null
/*     */     //   173: aconst_null
/*     */     //   174: aload_3
/*     */     //   175: getfield 14	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:debuggable	Z
/*     */     //   178: aconst_null
/*     */     //   179: aload_3
/*     */     //   180: invokevirtual 185	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:getPseudoLocalesEnabled	()Z
/*     */     //   183: aconst_null
/*     */     //   184: aconst_null
/*     */     //   185: aload_3
/*     */     //   186: invokevirtual 189	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:getInputResourcesDir	()Lorg/gradle/api/file/FileCollection;
/*     */     //   189: astore 4
/*     */     //   191: astore 5
/*     */     //   193: astore 6
/*     */     //   195: istore 7
/*     */     //   197: astore 8
/*     */     //   199: istore 9
/*     */     //   201: astore 10
/*     */     //   203: astore 11
/*     */     //   205: astore 12
/*     */     //   207: astore 13
/*     */     //   209: istore 14
/*     */     //   211: astore 15
/*     */     //   213: astore 16
/*     */     //   215: astore 17
/*     */     //   217: astore 18
/*     */     //   219: astore 19
/*     */     //   221: astore 20
/*     */     //   223: istore 21
/*     */     //   225: astore 22
/*     */     //   227: astore 23
/*     */     //   229: astore 24
/*     */     //   231: aload 4
/*     */     //   233: ifnonnull +23 -> 256
/*     */     //   236: ldc -65
/*     */     //   238: astore 25
/*     */     //   240: new 193	java/lang/IllegalStateException
/*     */     //   243: dup
/*     */     //   244: aload 25
/*     */     //   246: invokevirtual 198	java/lang/Object:toString	()Ljava/lang/String;
/*     */     //   249: invokespecial 199	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
/*     */     //   252: checkcast 83	java/lang/Throwable
/*     */     //   255: athrow
/*     */     //   256: aload 4
/*     */     //   258: astore 26
/*     */     //   260: aload 24
/*     */     //   262: aload 23
/*     */     //   264: aload 22
/*     */     //   266: iload 21
/*     */     //   268: aload 20
/*     */     //   270: aload 19
/*     */     //   272: aload 18
/*     */     //   274: aload 17
/*     */     //   276: aload 16
/*     */     //   278: aload 15
/*     */     //   280: iload 14
/*     */     //   282: aload 13
/*     */     //   284: aload 12
/*     */     //   286: aload 11
/*     */     //   288: aload 10
/*     */     //   290: iload 9
/*     */     //   292: aload 8
/*     */     //   294: iload 7
/*     */     //   296: aload 6
/*     */     //   298: aload 5
/*     */     //   300: aload 26
/*     */     //   302: invokeinterface 204 1 0
/*     */     //   307: invokestatic 210	com/google/common/collect/ImmutableList:of	(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;
/*     */     //   310: dup
/*     */     //   311: ldc -44
/*     */     //   313: invokestatic 151	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   316: aconst_null
/*     */     //   317: aconst_null
/*     */     //   318: aconst_null
/*     */     //   319: iconst_0
/*     */     //   320: iconst_0
/*     */     //   321: aconst_null
/*     */     //   322: aconst_null
/*     */     //   323: astore 4
/*     */     //   325: astore 25
/*     */     //   327: istore 27
/*     */     //   329: istore 28
/*     */     //   331: astore 29
/*     */     //   333: astore 30
/*     */     //   335: astore 31
/*     */     //   337: astore 32
/*     */     //   339: astore 33
/*     */     //   341: astore 34
/*     */     //   343: istore 35
/*     */     //   345: astore 36
/*     */     //   347: istore 37
/*     */     //   349: astore 38
/*     */     //   351: astore 39
/*     */     //   353: astore 40
/*     */     //   355: astore 41
/*     */     //   357: istore 42
/*     */     //   359: astore 43
/*     */     //   361: astore 44
/*     */     //   363: astore 45
/*     */     //   365: astore 46
/*     */     //   367: astore 47
/*     */     //   369: astore 48
/*     */     //   371: istore 49
/*     */     //   373: astore 50
/*     */     //   375: aload 48
/*     */     //   377: aload 47
/*     */     //   379: aload 50
/*     */     //   381: aload 41
/*     */     //   383: aload 46
/*     */     //   385: aload 45
/*     */     //   387: aload 44
/*     */     //   389: aload 43
/*     */     //   391: iload 42
/*     */     //   393: aload 32
/*     */     //   395: aload 40
/*     */     //   397: aload 39
/*     */     //   399: aload 38
/*     */     //   401: iload 37
/*     */     //   403: aload 36
/*     */     //   405: iload 35
/*     */     //   407: aload 34
/*     */     //   409: aload 33
/*     */     //   411: iload 49
/*     */     //   413: aload 31
/*     */     //   415: aload 30
/*     */     //   417: aload 29
/*     */     //   419: iload 28
/*     */     //   421: iload 27
/*     */     //   423: aload 25
/*     */     //   425: aload 4
/*     */     //   427: ldc -43
/*     */     //   429: aconst_null
/*     */     //   430: invokespecial 216	com/android/builder/internal/aapt/AaptPackageConfig:<init>	(Ljava/io/File;Lcom/android/builder/internal/aapt/AaptOptions;Ljava/lang/String;Lcom/android/builder/core/VariantType;Ljava/io/File;Ljava/io/File;Lcom/google/common/collect/ImmutableCollection;Ljava/io/File;ZLcom/google/common/collect/ImmutableList;Ljava/io/File;Ljava/io/File;Lcom/google/common/collect/ImmutableCollection;ZLjava/lang/String;ZLjava/lang/String;Lcom/google/common/collect/ImmutableSet;ZLcom/google/common/collect/ImmutableList;Ljava/lang/Integer;Lcom/google/common/collect/ImmutableCollection;ZZLcom/google/common/collect/ImmutableList;Ljava/io/File;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
/*     */     //   433: astore 51
/*     */     //   435: aload_3
/*     */     //   436: invokespecial 220	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:makeAapt	()Lcom/android/builder/internal/aapt/Aapt;
/*     */     //   439: checkcast 222	java/io/Closeable
/*     */     //   442: astore 4
/*     */     //   444: aconst_null
/*     */     //   445: checkcast 83	java/lang/Throwable
/*     */     //   448: astore 25
/*     */     //   450: nop
/*     */     //   451: aload 4
/*     */     //   453: checkcast 224	com/android/builder/internal/aapt/Aapt
/*     */     //   456: astore 27
/*     */     //   458: aload 27
/*     */     //   460: checkcast 226	com/android/builder/internal/aapt/BlockingResourceLinker
/*     */     //   463: aload 51
/*     */     //   465: new 228	com/android/build/gradle/internal/LoggerWrapper
/*     */     //   468: dup
/*     */     //   469: aload_3
/*     */     //   470: invokevirtual 232	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:getLogger	()Lorg/gradle/api/logging/Logger;
/*     */     //   473: invokespecial 235	com/android/build/gradle/internal/LoggerWrapper:<init>	(Lorg/gradle/api/logging/Logger;)V
/*     */     //   476: checkcast 237	com/android/utils/ILogger
/*     */     //   479: invokestatic 241	com/android/builder/core/AndroidBuilder:processResources	(Lcom/android/builder/internal/aapt/BlockingResourceLinker;Lcom/android/builder/internal/aapt/AaptPackageConfig;Lcom/android/utils/ILogger;)V
/*     */     //   482: getstatic 247	kotlin/Unit:INSTANCE	Lkotlin/Unit;
/*     */     //   485: astore 27
/*     */     //   487: aload 4
/*     */     //   489: aload 25
/*     */     //   491: invokestatic 253	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
/*     */     //   494: goto +24 -> 518
/*     */     //   497: astore 27
/*     */     //   499: aload 27
/*     */     //   501: astore 25
/*     */     //   503: aload 27
/*     */     //   505: athrow
/*     */     //   506: astore 27
/*     */     //   508: aload 4
/*     */     //   510: aload 25
/*     */     //   512: invokestatic 253	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
/*     */     //   515: aload 27
/*     */     //   517: athrow
/*     */     //   518: aload_3
/*     */     //   519: invokevirtual 232	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:getLogger	()Lorg/gradle/api/logging/Logger;
/*     */     //   522: dup
/*     */     //   523: ldc -1
/*     */     //   525: invokestatic 151	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   528: invokeinterface 260 1 0
/*     */     //   533: ifeq +31 -> 564
/*     */     //   536: aload_3
/*     */     //   537: invokevirtual 232	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:getLogger	()Lorg/gradle/api/logging/Logger;
/*     */     //   540: ldc_w 262
/*     */     //   543: aload_3
/*     */     //   544: getfield 33	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:bundledResFile	Ljava/io/File;
/*     */     //   547: dup
/*     */     //   548: ifnonnull +8 -> 556
/*     */     //   551: ldc 34
/*     */     //   553: invokestatic 40	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   556: invokevirtual 265	java/io/File:getAbsolutePath	()Ljava/lang/String;
/*     */     //   559: invokeinterface 269 3 0
/*     */     //   564: nop
/*     */     //   565: nop
/*     */     //   566: goto +83 -> 649
/*     */     //   569: astore_2
/*     */     //   570: invokestatic 275	java/lang/Thread:currentThread	()Ljava/lang/Thread;
/*     */     //   573: invokevirtual 278	java/lang/Thread:interrupt	()V
/*     */     //   576: aload_0
/*     */     //   577: invokevirtual 232	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:getLogger	()Lorg/gradle/api/logging/Logger;
/*     */     //   580: aload_2
/*     */     //   581: invokevirtual 281	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
/*     */     //   584: aload_2
/*     */     //   585: checkcast 83	java/lang/Throwable
/*     */     //   588: invokeinterface 285 3 0
/*     */     //   593: new 287	org/gradle/tooling/BuildException
/*     */     //   596: dup
/*     */     //   597: aload_2
/*     */     //   598: invokevirtual 281	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
/*     */     //   601: aload_2
/*     */     //   602: checkcast 83	java/lang/Throwable
/*     */     //   605: invokespecial 289	org/gradle/tooling/BuildException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   608: checkcast 83	java/lang/Throwable
/*     */     //   611: athrow
/*     */     //   612: astore_2
/*     */     //   613: aload_0
/*     */     //   614: invokevirtual 232	com/android/build/gradle/internal/res/LinkAndroidResForBundleTask:getLogger	()Lorg/gradle/api/logging/Logger;
/*     */     //   617: aload_2
/*     */     //   618: invokevirtual 290	com/android/ide/common/process/ProcessException:getMessage	()Ljava/lang/String;
/*     */     //   621: aload_2
/*     */     //   622: checkcast 83	java/lang/Throwable
/*     */     //   625: invokeinterface 285 3 0
/*     */     //   630: new 287	org/gradle/tooling/BuildException
/*     */     //   633: dup
/*     */     //   634: aload_2
/*     */     //   635: invokevirtual 290	com/android/ide/common/process/ProcessException:getMessage	()Ljava/lang/String;
/*     */     //   638: aload_2
/*     */     //   639: checkcast 83	java/lang/Throwable
/*     */     //   642: invokespecial 289	org/gradle/tooling/BuildException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   645: checkcast 83	java/lang/Throwable
/*     */     //   648: athrow
/*     */     //   649: return
/*     */     // Line number table:
/*     */     //   Java source line #104	-> byte code offset #0
/*     */     //   Java source line #105	-> byte code offset #0
/*     */     //   Java source line #106	-> byte code offset #0
/*     */     //   Java source line #104	-> byte code offset #0
/*     */     //   Java source line #105	-> byte code offset #25
/*     */     //   Java source line #107	-> byte code offset #56
/*     */     //   Java source line #104	-> byte code offset #69
/*     */     //   Java source line #109	-> byte code offset #70
/*     */     //   Java source line #111	-> byte code offset #90
/*     */     //   Java source line #115	-> byte code offset #91
/*     */     //   Java source line #116	-> byte code offset #98
/*     */     //   Java source line #117	-> byte code offset #102
/*     */     //   Java source line #118	-> byte code offset #127
/*     */     //   Java source line #119	-> byte code offset #128
/*     */     //   Java source line #120	-> byte code offset #135
/*     */     //   Java source line #121	-> byte code offset #152
/*     */     //   Java source line #122	-> byte code offset #168
/*     */     //   Java source line #123	-> byte code offset #174
/*     */     //   Java source line #124	-> byte code offset #179
/*     */     //   Java source line #125	-> byte code offset #185
/*     */     //   Java source line #125	-> byte code offset #307
/*     */     //   Java source line #116	-> byte code offset #430
/*     */     //   Java source line #127	-> byte code offset #435
/*     */     //   Java source line #128	-> byte code offset #458
/*     */     //   Java source line #129	-> byte code offset #482
/*     */     //   Java source line #127	-> byte code offset #485
/*     */     //   Java source line #131	-> byte code offset #518
/*     */     //   Java source line #132	-> byte code offset #536
/*     */     //   Java source line #134	-> byte code offset #564
/*     */     //   Java source line #115	-> byte code offset #566
/*     */     //   Java source line #135	-> byte code offset #569
/*     */     //   Java source line #136	-> byte code offset #570
/*     */     //   Java source line #137	-> byte code offset #576
/*     */     //   Java source line #138	-> byte code offset #593
/*     */     //   Java source line #139	-> byte code offset #612
/*     */     //   Java source line #140	-> byte code offset #613
/*     */     //   Java source line #141	-> byte code offset #630
/*     */     //   Java source line #142	-> byte code offset #649
/*     */     //   Java source line #143	-> byte code offset #649
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	650	0	this	LinkAndroidResForBundleTask
/*     */     //   70	580	1	manifestFile	File
/*     */     //   570	42	2	e	InterruptedException
/*     */     //   613	36	2	e	com.android.ide.common.process.ProcessException
/*     */     //   98	467	3	$receiver	LinkAndroidResForBundleTask
/*     */     //   458	24	27	aapt	Aapt
/*     */     //   458	24	28	$i$a$1$use	int
/*     */     //   435	129	51	config	com.android.builder.internal.aapt.AaptPackageConfig
/*     */     //   98	467	52	$i$a$1$run	int
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   450	487	497	java/lang/Throwable
/*     */     //   450	487	506	finally
/*     */     //   497	506	506	finally
/*     */     //   506	508	506	finally
/*     */     //   90	566	569	java/lang/InterruptedException
/*     */     //   90	566	612	com/android/ide/common/process/ProcessException
/*     */   }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2={"Lcom/android/build/gradle/internal/res/LinkAndroidResForBundleTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/LinkAndroidResForBundleTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "bundledResFile", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;)V", "execute", "", "processResources", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */   public static final class ConfigAction
/*     */     implements TaskConfigAction<LinkAndroidResForBundleTask>
/*     */   {
/*     */     private final VariantScope variantScope;
/*     */     private final File bundledResFile;
/*     */     
/*     */     public ConfigAction(@NotNull VariantScope variantScope, @NotNull File bundledResFile)
/*     */     {
/* 197 */       this.variantScope = variantScope;this.bundledResFile = bundledResFile;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public String getName()
/*     */     {
/* 203 */       String tmp13_8 = variantScope.getTaskName("bundle", "Resources");Intrinsics.checkExpressionValueIsNotNull(tmp13_8, "variantScope.getTaskName(\"bundle\", \"Resources\")");return tmp13_8;
/*     */     }
/*     */     
/*     */     @NotNull
/* 207 */     public Class<LinkAndroidResForBundleTask> getType() { return LinkAndroidResForBundleTask.class; }
/*     */     
/*     */     public void execute(@NotNull LinkAndroidResForBundleTask processResources)
/*     */     {
/* 211 */       Intrinsics.checkParameterIsNotNull(processResources, "processResources");BaseVariantData variantData = variantScope.getVariantData(); GlobalScope 
/*     */       
/* 213 */         tmp25_20 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp25_20, "variantScope.globalScope");ProjectOptions projectOptions = tmp25_20.getProjectOptions(); BaseVariantData 
/*     */       
/* 215 */         tmp36_35 = variantData;Intrinsics.checkExpressionValueIsNotNull(tmp36_35, "variantData");GradleVariantConfiguration config = tmp36_35.getVariantConfiguration(); GlobalScope 
/*     */       
/* 217 */         tmp57_52 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp57_52, "variantScope.globalScope");processResources.setAndroidBuilder(tmp57_52.getAndroidBuilder()); GradleVariantConfiguration 
/* 218 */         tmp72_70 = config;Intrinsics.checkExpressionValueIsNotNull(tmp72_70, "config");processResources.setVariantName(tmp72_70.getFullName());
/* 219 */       LinkAndroidResForBundleTask.access$setBundledResFile$p(processResources, bundledResFile);
/* 220 */       LinkAndroidResForBundleTask.access$setAaptGeneration$p(processResources, AaptGeneration.fromProjectOptions(projectOptions)); File 
/*     */       
/* 222 */         tmp114_109 = variantScope.getIncrementalDir(getName());Intrinsics.checkExpressionValueIsNotNull(tmp114_109, "variantScope.getIncrementalDir(name)");LinkAndroidResForBundleTask.access$setIncrementalFolder$p(processResources, tmp114_109);
/*     */       
/* 224 */       LinkAndroidResForBundleTask.access$setVersionCode$p(processResources, config.getVersionCode());
/* 225 */       LinkAndroidResForBundleTask.access$setVersionName$p(processResources, config.getVersionName()); OutputScope 
/*     */       
/* 227 */         tmp146_143 = variantData.getOutputScope();Intrinsics.checkExpressionValueIsNotNull(tmp146_143, "variantData.outputScope"); com.android.ide.common.build.ApkData tmp155_152 = tmp146_143.getMainSplit();Intrinsics.checkExpressionValueIsNotNull(tmp155_152, "variantData.outputScope.mainSplit");LinkAndroidResForBundleTask.access$setMainSplit$p(processResources, (ApkInfo)tmp155_152); FileCollection 
/*     */       
/* 229 */         tmp183_178 = variantScope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS);Intrinsics.checkExpressionValueIsNotNull(tmp183_178, "variantScope.getOutput(MERGED_MANIFESTS)");LinkAndroidResForBundleTask.access$setManifestFiles$p(processResources, tmp183_178);
/*     */       
/* 231 */       LinkAndroidResForBundleTask.access$setInputResourcesDir$p(processResources, variantScope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.MERGED_RES)); CoreBuildType 
/*     */       
/* 233 */         tmp220_217 = ((CoreBuildType)config.getBuildType());Intrinsics.checkExpressionValueIsNotNull(tmp220_217, "config.buildType");LinkAndroidResForBundleTask.access$setDebuggable$p(processResources, tmp220_217.isDebuggable()); GlobalScope 
/* 234 */         tmp244_239 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp244_239, "variantScope.globalScope"); AndroidConfig tmp253_250 = tmp244_239.getExtension();Intrinsics.checkExpressionValueIsNotNull(tmp253_250, "variantScope.globalScope.extension"); AaptOptions tmp264_259 = tmp253_250.getAaptOptions();Intrinsics.checkExpressionValueIsNotNull(tmp264_259, "variantScope.globalScope.extension.aaptOptions");LinkAndroidResForBundleTask.access$setAaptOptions$p(processResources, tmp264_259); CoreBuildType 
/* 235 */         tmp282_279 = ((CoreBuildType)config.getBuildType());Intrinsics.checkExpressionValueIsNotNull(tmp282_279, "config.buildType");LinkAndroidResForBundleTask.access$setPseudoLocalesEnabled$p(processResources, tmp282_279.isPseudoLocalesEnabled());
/*     */       
/* 237 */       LinkAndroidResForBundleTask.access$setBuildTargetDensity$p(processResources, projectOptions.get(StringOption.IDE_BUILD_TARGET_DENSITY));
/*     */       
/* 239 */       LinkAndroidResForBundleTask.access$setMergeBlameLogFolder$p(processResources, variantScope.getResourceBlameLogDir());
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.LinkAndroidResForBundleTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */