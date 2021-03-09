/*     */ package com.android.build.gradle.internal.res.namespaced;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.builder.internal.aapt.AaptPackageConfig;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import java.io.File;
/*     */ import java.util.function.Supplier;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.FunctionReference;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ import org.gradle.api.tasks.OutputFile;
/*     */ import org.gradle.api.tasks.PathSensitive;
/*     */ import org.gradle.api.tasks.PathSensitivity;
/*     */ import org.gradle.workers.WorkerConfiguration;
/*     */ import org.gradle.workers.WorkerExecutor;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @org.gradle.api.tasks.CacheableTask
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000:\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\017\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\025\n\002\020\002\n\002\b\002\b\027\030\0002\0020\001:\0016B\017\b\007\022\006\020\002\032\0020\003¢\006\002\020\004J\b\0204\032\00205H\007R&\020\007\032\0020\0062\006\020\005\032\0020\0068\007@BX.¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R*\020\r\032\004\030\0010\f2\b\020\005\032\004\030\0010\f8\007@BX\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R&\020\022\032\0020\f2\006\020\005\032\0020\f8\007@BX.¢\006\016\n\000\032\004\b\023\020\017\"\004\b\024\020\021R&\020\025\032\0020\f2\006\020\005\032\0020\f8\007@BX.¢\006\016\n\000\032\004\b\026\020\017\"\004\b\027\020\021R&\020\030\032\0020\f2\006\020\005\032\0020\f8\007@BX.¢\006\016\n\000\032\004\b\031\020\017\"\004\b\032\020\021R\024\020\033\032\0020\0348CX\004¢\006\006\032\004\b\035\020\036R2\020 \032\b\022\004\022\0020\0340\0372\f\020\005\032\b\022\004\022\0020\0340\0378\007@BX.¢\006\016\n\000\032\004\b!\020\"\"\004\b#\020$R*\020%\032\004\030\0010\0062\b\020\005\032\004\030\0010\0068\007@BX\016¢\006\016\n\000\032\004\b&\020\t\"\004\b'\020\013R&\020(\032\0020\0062\006\020\005\032\0020\0068\007@BX.¢\006\016\n\000\032\004\b)\020\t\"\004\b*\020\013R&\020+\032\0020\f2\006\020\005\032\0020\f8\007@BX.¢\006\016\n\000\032\004\b,\020\017\"\004\b-\020\021R&\020.\032\0020\0062\006\020\005\032\0020\0068\007@BX.¢\006\016\n\000\032\004\b/\020\t\"\004\b0\020\013R*\0201\032\004\030\0010\f2\b\020\005\032\004\030\0010\f8\007@BX\016¢\006\016\n\000\032\004\b2\020\017\"\004\b3\020\021R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\0067"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;", "Lcom/android/build/gradle/internal/tasks/AndroidBuilderTask;", "workerExecutor", "Lorg/gradle/workers/WorkerExecutor;", "(Lorg/gradle/workers/WorkerExecutor;)V", "<set-?>", "Ljava/io/File;", "aaptIntermediateDir", "getAaptIntermediateDir", "()Ljava/io/File;", "setAaptIntermediateDir", "(Ljava/io/File;)V", "Lorg/gradle/api/file/FileCollection;", "featureDependencies", "getFeatureDependencies", "()Lorg/gradle/api/file/FileCollection;", "setFeatureDependencies", "(Lorg/gradle/api/file/FileCollection;)V", "inputResourcesDirectories", "getInputResourcesDirectories", "setInputResourcesDirectories", "libraryDependencies", "getLibraryDependencies", "setLibraryDependencies", "manifestFileDirectory", "getManifestFileDirectory", "setManifestFileDirectory", "packageForR", "", "getPackageForR", "()Ljava/lang/String;", "Ljava/util/function/Supplier;", "packageForRSupplier", "getPackageForRSupplier", "()Ljava/util/function/Supplier;", "setPackageForRSupplier", "(Ljava/util/function/Supplier;)V", "rClassSource", "getRClassSource", "setRClassSource", "rDotTxt", "getRDotTxt", "setRDotTxt", "sharedLibraryDependencies", "getSharedLibraryDependencies", "setSharedLibraryDependencies", "staticLibApk", "getStaticLibApk", "setStaticLibApk", "tested", "getTested", "setTested", "taskAction", "", "ConfigAction", "gradle-core"})
/*     */ public class LinkLibraryAndroidResourcesTask
/*     */   extends com.android.build.gradle.internal.tasks.AndroidBuilderTask
/*     */ {
/*     */   @NotNull
/*     */   private FileCollection manifestFileDirectory;
/*     */   @NotNull
/*     */   private FileCollection inputResourcesDirectories;
/*     */   @NotNull
/*     */   private FileCollection libraryDependencies;
/*     */   @NotNull
/*     */   private FileCollection sharedLibraryDependencies;
/*     */   @Nullable
/*     */   private FileCollection featureDependencies;
/*     */   @Nullable
/*     */   private FileCollection tested;
/*     */   @NotNull
/*     */   private Supplier<String> packageForRSupplier;
/*     */   @NotNull
/*     */   private File aaptIntermediateDir;
/*     */   @Nullable
/*     */   private File rClassSource;
/*     */   @NotNull
/*     */   private File rDotTxt;
/*     */   @NotNull
/*     */   private File staticLibApk;
/*     */   private final WorkerExecutor workerExecutor;
/*     */   
/*     */   @javax.inject.Inject
/*  54 */   public LinkLibraryAndroidResourcesTask(@NotNull WorkerExecutor workerExecutor) { this.workerExecutor = workerExecutor; } @InputFiles
/*     */   @PathSensitive(PathSensitivity.RELATIVE)
/*     */   @NotNull
/*  56 */   public final FileCollection getManifestFileDirectory() { FileCollection tmp4_1 = manifestFileDirectory;
/*     */     
/*  56 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("manifestFileDirectory"); return tmp4_1; } private final void setManifestFileDirectory(FileCollection <set-?>) { manifestFileDirectory = <set-?>; } @InputFiles
/*     */   @PathSensitive(PathSensitivity.RELATIVE)
/*     */   @NotNull
/*  57 */   public final FileCollection getInputResourcesDirectories() { FileCollection tmp4_1 = inputResourcesDirectories;
/*     */     
/*  57 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("inputResourcesDirectories"); return tmp4_1; } private final void setInputResourcesDirectories(FileCollection <set-?>) { inputResourcesDirectories = <set-?>; } @InputFiles
/*     */   @PathSensitive(PathSensitivity.NONE)
/*     */   @NotNull
/*  58 */   public final FileCollection getLibraryDependencies() { FileCollection tmp4_1 = libraryDependencies;
/*     */     
/*  58 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("libraryDependencies"); return tmp4_1; } private final void setLibraryDependencies(FileCollection <set-?>) { libraryDependencies = <set-?>; } @InputFiles
/*     */   @PathSensitive(PathSensitivity.NONE)
/*     */   @NotNull
/*  59 */   public final FileCollection getSharedLibraryDependencies() { FileCollection tmp4_1 = sharedLibraryDependencies;
/*     */     
/*  59 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("sharedLibraryDependencies"); return tmp4_1; } private final void setSharedLibraryDependencies(FileCollection <set-?>) { sharedLibraryDependencies = <set-?>; } @InputFiles
/*     */   @PathSensitive(PathSensitivity.NONE)
/*     */   @Optional
/*     */   @Nullable
/*  60 */   public final FileCollection getFeatureDependencies() { return featureDependencies; } private final void setFeatureDependencies(FileCollection <set-?>) { featureDependencies = <set-?>; } @InputFiles
/*     */   @PathSensitive(PathSensitivity.NONE)
/*     */   @Optional
/*     */   @Nullable
/*  61 */   public final FileCollection getTested() { return tested; } private final void setTested(FileCollection <set-?>) { tested = <set-?>; } @org.gradle.api.tasks.Internal
/*     */   @NotNull
/*  63 */   public final Supplier<String> getPackageForRSupplier() { Supplier tmp4_1 = packageForRSupplier;
/*     */     
/*  63 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("packageForRSupplier"); return tmp4_1; } private final void setPackageForRSupplier(Supplier<String> <set-?>) { packageForRSupplier = <set-?>; } @org.gradle.api.tasks.Input
/*  64 */   private final String getPackageForR() { Supplier tmp4_1 = packageForRSupplier;
/*     */     
/*  64 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("packageForRSupplier"); return (String)tmp4_1.get(); } @org.gradle.api.tasks.OutputDirectory
/*     */   @NotNull
/*  66 */   public final File getAaptIntermediateDir() { File tmp4_1 = aaptIntermediateDir;
/*     */     
/*  66 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("aaptIntermediateDir"); return tmp4_1; } private final void setAaptIntermediateDir(File <set-?>) { aaptIntermediateDir = <set-?>; } @Optional
/*     */   @Nullable
/*  67 */   public final File getRClassSource() { return rClassSource; } private final void setRClassSource(File <set-?>) { rClassSource = <set-?>; } @OutputFile
/*     */   @NotNull
/*  68 */   public final File getRDotTxt() { File tmp4_1 = rDotTxt;
/*     */     
/*  68 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("rDotTxt"); return tmp4_1; } private final void setRDotTxt(File <set-?>) { rDotTxt = <set-?>; } @OutputFile
/*     */   @NotNull
/*  69 */   public final File getStaticLibApk() { File tmp4_1 = staticLibApk;
/*     */     
/*  69 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("staticLibApk"); return tmp4_1; } private final void setStaticLibApk(File <set-?>) { staticLibApk = <set-?>; }
/*     */   
/*     */   /* Error */
/*     */   @org.gradle.api.tasks.TaskAction
/*     */   public final void taskAction()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: invokestatic 123	com/google/common/collect/ImmutableList:builder	()Lcom/google/common/collect/ImmutableList$Builder;
/*     */     //   3: astore_1
/*     */     //   4: aload_1
/*     */     //   5: aload_0
/*     */     //   6: getfield 42	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:libraryDependencies	Lorg/gradle/api/file/FileCollection;
/*     */     //   9: dup
/*     */     //   10: ifnonnull +8 -> 18
/*     */     //   13: ldc 43
/*     */     //   15: invokestatic 24	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   18: invokeinterface 127 1 0
/*     */     //   23: checkcast 129	java/lang/Iterable
/*     */     //   26: invokevirtual 135	com/google/common/collect/ImmutableList$Builder:addAll	(Ljava/lang/Iterable;)Lcom/google/common/collect/ImmutableList$Builder;
/*     */     //   29: pop
/*     */     //   30: aload_1
/*     */     //   31: aload_0
/*     */     //   32: getfield 48	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:sharedLibraryDependencies	Lorg/gradle/api/file/FileCollection;
/*     */     //   35: dup
/*     */     //   36: ifnonnull +8 -> 44
/*     */     //   39: ldc 49
/*     */     //   41: invokestatic 24	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   44: invokeinterface 127 1 0
/*     */     //   49: checkcast 129	java/lang/Iterable
/*     */     //   52: invokevirtual 135	com/google/common/collect/ImmutableList$Builder:addAll	(Ljava/lang/Iterable;)Lcom/google/common/collect/ImmutableList$Builder;
/*     */     //   55: pop
/*     */     //   56: aload_0
/*     */     //   57: getfield 56	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:featureDependencies	Lorg/gradle/api/file/FileCollection;
/*     */     //   60: dup
/*     */     //   61: ifnull +344 -> 405
/*     */     //   64: astore_2
/*     */     //   65: aload_2
/*     */     //   66: astore_3
/*     */     //   67: aload_1
/*     */     //   68: aload_3
/*     */     //   69: invokeinterface 127 1 0
/*     */     //   74: dup
/*     */     //   75: ldc -119
/*     */     //   77: invokestatic 141	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   80: checkcast 129	java/lang/Iterable
/*     */     //   83: astore 4
/*     */     //   85: astore 5
/*     */     //   87: aload 4
/*     */     //   89: astore 6
/*     */     //   91: new 143	java/util/ArrayList
/*     */     //   94: dup
/*     */     //   95: aload 4
/*     */     //   97: bipush 10
/*     */     //   99: invokestatic 149	kotlin/collections/CollectionsKt:collectionSizeOrDefault	(Ljava/lang/Iterable;I)I
/*     */     //   102: invokespecial 153	java/util/ArrayList:<init>	(I)V
/*     */     //   105: checkcast 155	java/util/Collection
/*     */     //   108: astore 7
/*     */     //   110: aload 6
/*     */     //   112: invokeinterface 159 1 0
/*     */     //   117: astore 8
/*     */     //   119: aload 8
/*     */     //   121: invokeinterface 165 1 0
/*     */     //   126: ifeq +58 -> 184
/*     */     //   129: aload 8
/*     */     //   131: invokeinterface 168 1 0
/*     */     //   136: astore 9
/*     */     //   138: aload 7
/*     */     //   140: aload 9
/*     */     //   142: checkcast 94	java/io/File
/*     */     //   145: astore 10
/*     */     //   147: astore 11
/*     */     //   149: getstatic 174	com/android/build/gradle/internal/scope/ExistingBuildElements:Companion	Lcom/android/build/gradle/internal/scope/ExistingBuildElements$Companion;
/*     */     //   152: getstatic 180	com/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType:PROCESSED_RES	Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;
/*     */     //   155: checkcast 182	com/android/build/gradle/internal/scope/TaskOutputHolder$OutputType
/*     */     //   158: aload 10
/*     */     //   160: dup
/*     */     //   161: ldc -72
/*     */     //   163: invokestatic 141	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   166: invokevirtual 190	com/android/build/gradle/internal/scope/ExistingBuildElements$Companion:from	(Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;Ljava/io/File;)Lcom/android/build/gradle/internal/scope/BuildElements;
/*     */     //   169: astore 12
/*     */     //   171: aload 11
/*     */     //   173: aload 12
/*     */     //   175: invokeinterface 194 2 0
/*     */     //   180: pop
/*     */     //   181: goto -62 -> 119
/*     */     //   184: aload 7
/*     */     //   186: checkcast 196	java/util/List
/*     */     //   189: astore 11
/*     */     //   191: aload 5
/*     */     //   193: aload 11
/*     */     //   195: checkcast 129	java/lang/Iterable
/*     */     //   198: astore 4
/*     */     //   200: astore 5
/*     */     //   202: aload 4
/*     */     //   204: astore 6
/*     */     //   206: new 143	java/util/ArrayList
/*     */     //   209: dup
/*     */     //   210: invokespecial 198	java/util/ArrayList:<init>	()V
/*     */     //   213: checkcast 155	java/util/Collection
/*     */     //   216: astore 7
/*     */     //   218: aload 6
/*     */     //   220: invokeinterface 159 1 0
/*     */     //   225: astore 8
/*     */     //   227: aload 8
/*     */     //   229: invokeinterface 165 1 0
/*     */     //   234: ifeq +40 -> 274
/*     */     //   237: aload 8
/*     */     //   239: invokeinterface 168 1 0
/*     */     //   244: astore 9
/*     */     //   246: aload 9
/*     */     //   248: checkcast 200	com/android/build/gradle/internal/scope/BuildElements
/*     */     //   251: astore 10
/*     */     //   253: aload 10
/*     */     //   255: invokevirtual 203	com/android/build/gradle/internal/scope/BuildElements:isEmpty	()Z
/*     */     //   258: ifne +13 -> 271
/*     */     //   261: aload 7
/*     */     //   263: aload 9
/*     */     //   265: invokeinterface 194 2 0
/*     */     //   270: pop
/*     */     //   271: goto -44 -> 227
/*     */     //   274: aload 7
/*     */     //   276: checkcast 196	java/util/List
/*     */     //   279: astore 11
/*     */     //   281: aload 5
/*     */     //   283: aload 11
/*     */     //   285: checkcast 129	java/lang/Iterable
/*     */     //   288: astore 4
/*     */     //   290: astore 5
/*     */     //   292: aload 4
/*     */     //   294: astore 6
/*     */     //   296: new 143	java/util/ArrayList
/*     */     //   299: dup
/*     */     //   300: aload 4
/*     */     //   302: bipush 10
/*     */     //   304: invokestatic 149	kotlin/collections/CollectionsKt:collectionSizeOrDefault	(Ljava/lang/Iterable;I)I
/*     */     //   307: invokespecial 153	java/util/ArrayList:<init>	(I)V
/*     */     //   310: checkcast 155	java/util/Collection
/*     */     //   313: astore 7
/*     */     //   315: aload 6
/*     */     //   317: invokeinterface 159 1 0
/*     */     //   322: astore 8
/*     */     //   324: aload 8
/*     */     //   326: invokeinterface 165 1 0
/*     */     //   331: ifeq +52 -> 383
/*     */     //   334: aload 8
/*     */     //   336: invokeinterface 168 1 0
/*     */     //   341: astore 9
/*     */     //   343: aload 7
/*     */     //   345: aload 9
/*     */     //   347: checkcast 200	com/android/build/gradle/internal/scope/BuildElements
/*     */     //   350: astore 10
/*     */     //   352: astore 11
/*     */     //   354: aload 10
/*     */     //   356: checkcast 129	java/lang/Iterable
/*     */     //   359: invokestatic 207	kotlin/collections/CollectionsKt:single	(Ljava/lang/Iterable;)Ljava/lang/Object;
/*     */     //   362: checkcast 209	com/android/build/gradle/internal/scope/BuildOutput
/*     */     //   365: invokevirtual 212	com/android/build/gradle/internal/scope/BuildOutput:getOutputFile	()Ljava/io/File;
/*     */     //   368: astore 12
/*     */     //   370: aload 11
/*     */     //   372: aload 12
/*     */     //   374: invokeinterface 194 2 0
/*     */     //   379: pop
/*     */     //   380: goto -56 -> 324
/*     */     //   383: aload 7
/*     */     //   385: checkcast 196	java/util/List
/*     */     //   388: astore 11
/*     */     //   390: aload 5
/*     */     //   392: aload 11
/*     */     //   394: checkcast 129	java/lang/Iterable
/*     */     //   397: invokevirtual 135	com/google/common/collect/ImmutableList$Builder:addAll	(Ljava/lang/Iterable;)Lcom/google/common/collect/ImmutableList$Builder;
/*     */     //   400: pop
/*     */     //   401: nop
/*     */     //   402: goto +4 -> 406
/*     */     //   405: pop
/*     */     //   406: new 214	com/android/builder/internal/aapt/AaptPackageConfig
/*     */     //   409: dup
/*     */     //   410: aload_0
/*     */     //   411: invokevirtual 218	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:getBuilder	()Lcom/android/builder/core/AndroidBuilder;
/*     */     //   414: dup
/*     */     //   415: ldc -37
/*     */     //   417: invokestatic 141	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   420: invokevirtual 225	com/android/builder/core/AndroidBuilder:getTarget	()Lcom/android/sdklib/IAndroidTarget;
/*     */     //   423: iconst_1
/*     */     //   424: invokeinterface 231 2 0
/*     */     //   429: dup
/*     */     //   430: ldc -23
/*     */     //   432: invokestatic 141	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   435: new 94	java/io/File
/*     */     //   438: dup
/*     */     //   439: aload_0
/*     */     //   440: getfield 17	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:manifestFileDirectory	Lorg/gradle/api/file/FileCollection;
/*     */     //   443: dup
/*     */     //   444: ifnonnull +8 -> 452
/*     */     //   447: ldc 18
/*     */     //   449: invokestatic 24	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   452: invokeinterface 236 1 0
/*     */     //   457: ldc -18
/*     */     //   459: invokespecial 241	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
/*     */     //   462: new 243	com/android/builder/internal/aapt/AaptOptions
/*     */     //   465: dup
/*     */     //   466: aconst_null
/*     */     //   467: iconst_0
/*     */     //   468: aconst_null
/*     */     //   469: invokespecial 246	com/android/builder/internal/aapt/AaptOptions:<init>	(Ljava/util/Collection;ZLjava/util/List;)V
/*     */     //   472: aload_0
/*     */     //   473: getfield 35	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:inputResourcesDirectories	Lorg/gradle/api/file/FileCollection;
/*     */     //   476: dup
/*     */     //   477: ifnonnull +8 -> 485
/*     */     //   480: ldc 36
/*     */     //   482: invokestatic 24	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   485: checkcast 129	java/lang/Iterable
/*     */     //   488: astore_3
/*     */     //   489: astore 33
/*     */     //   491: astore 32
/*     */     //   493: astore 31
/*     */     //   495: astore 30
/*     */     //   497: astore 29
/*     */     //   499: aload_3
/*     */     //   500: astore 34
/*     */     //   502: aload 29
/*     */     //   504: aload 30
/*     */     //   506: aload 31
/*     */     //   508: aload 32
/*     */     //   510: aload 33
/*     */     //   512: aload 34
/*     */     //   514: invokestatic 250	com/google/common/collect/ImmutableList:copyOf	(Ljava/lang/Iterable;)Lcom/google/common/collect/ImmutableList;
/*     */     //   517: dup
/*     */     //   518: ldc -4
/*     */     //   520: invokestatic 141	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   523: iconst_1
/*     */     //   524: aload_1
/*     */     //   525: invokevirtual 256	com/google/common/collect/ImmutableList$Builder:build	()Lcom/google/common/collect/ImmutableList;
/*     */     //   528: dup
/*     */     //   529: ldc_w 258
/*     */     //   532: invokestatic 141	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   535: aconst_null
/*     */     //   536: aload_0
/*     */     //   537: getfield 100	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:rClassSource	Ljava/io/File;
/*     */     //   540: iconst_0
/*     */     //   541: aload_0
/*     */     //   542: getfield 112	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:staticLibApk	Ljava/io/File;
/*     */     //   545: dup
/*     */     //   546: ifnonnull +8 -> 554
/*     */     //   549: ldc 113
/*     */     //   551: invokestatic 24	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   554: aconst_null
/*     */     //   555: aconst_null
/*     */     //   556: aconst_null
/*     */     //   557: iconst_0
/*     */     //   558: getstatic 264	com/android/builder/core/VariantType:LIBRARY	Lcom/android/builder/core/VariantType;
/*     */     //   561: iconst_0
/*     */     //   562: aconst_null
/*     */     //   563: aconst_null
/*     */     //   564: iconst_0
/*     */     //   565: aload_0
/*     */     //   566: invokespecial 266	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:getPackageForR	()Ljava/lang/String;
/*     */     //   569: aconst_null
/*     */     //   570: aconst_null
/*     */     //   571: iconst_0
/*     */     //   572: aload_0
/*     */     //   573: getfield 106	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:rDotTxt	Ljava/io/File;
/*     */     //   576: dup
/*     */     //   577: ifnonnull +8 -> 585
/*     */     //   580: ldc 107
/*     */     //   582: invokestatic 24	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   585: invokevirtual 269	java/io/File:getParentFile	()Ljava/io/File;
/*     */     //   588: aconst_null
/*     */     //   589: aload_0
/*     */     //   590: getfield 91	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:aaptIntermediateDir	Ljava/io/File;
/*     */     //   593: dup
/*     */     //   594: ifnonnull +8 -> 602
/*     */     //   597: ldc 92
/*     */     //   599: invokestatic 24	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   602: astore_3
/*     */     //   603: astore 4
/*     */     //   605: astore 5
/*     */     //   607: istore 6
/*     */     //   609: astore 7
/*     */     //   611: astore 8
/*     */     //   613: astore 9
/*     */     //   615: istore 10
/*     */     //   617: astore 11
/*     */     //   619: astore 12
/*     */     //   621: istore 13
/*     */     //   623: astore 14
/*     */     //   625: istore 15
/*     */     //   627: astore 16
/*     */     //   629: astore 17
/*     */     //   631: astore 18
/*     */     //   633: astore 19
/*     */     //   635: istore 20
/*     */     //   637: astore 21
/*     */     //   639: astore 22
/*     */     //   641: astore 23
/*     */     //   643: istore 24
/*     */     //   645: astore 25
/*     */     //   647: astore 26
/*     */     //   649: astore 27
/*     */     //   651: astore 28
/*     */     //   653: aload 27
/*     */     //   655: aload 26
/*     */     //   657: aload 28
/*     */     //   659: aload 14
/*     */     //   661: aload 21
/*     */     //   663: aload 19
/*     */     //   665: aload 22
/*     */     //   667: aload 5
/*     */     //   669: iload 20
/*     */     //   671: aload 25
/*     */     //   673: aload 18
/*     */     //   675: aload 17
/*     */     //   677: aload 16
/*     */     //   679: iload 15
/*     */     //   681: aload 9
/*     */     //   683: iload 13
/*     */     //   685: aload 12
/*     */     //   687: aload 11
/*     */     //   689: iload 10
/*     */     //   691: aload 23
/*     */     //   693: aload 8
/*     */     //   695: aload 7
/*     */     //   697: iload 6
/*     */     //   699: iload 24
/*     */     //   701: aload 4
/*     */     //   703: aload_3
/*     */     //   704: ldc_w 270
/*     */     //   707: aconst_null
/*     */     //   708: invokespecial 273	com/android/builder/internal/aapt/AaptPackageConfig:<init>	(Ljava/io/File;Lcom/android/builder/internal/aapt/AaptOptions;Ljava/lang/String;Lcom/android/builder/core/VariantType;Ljava/io/File;Ljava/io/File;Lcom/google/common/collect/ImmutableCollection;Ljava/io/File;ZLcom/google/common/collect/ImmutableList;Ljava/io/File;Ljava/io/File;Lcom/google/common/collect/ImmutableCollection;ZLjava/lang/String;ZLjava/lang/String;Lcom/google/common/collect/ImmutableSet;ZLcom/google/common/collect/ImmutableList;Ljava/lang/Integer;Lcom/google/common/collect/ImmutableCollection;ZZLcom/google/common/collect/ImmutableList;Ljava/io/File;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
/*     */     //   711: astore_2
/*     */     //   712: aload_0
/*     */     //   713: getfield 277	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:workerExecutor	Lorg/gradle/workers/WorkerExecutor;
/*     */     //   716: ldc_w 279
/*     */     //   719: new 281	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$taskAction$2
/*     */     //   722: dup
/*     */     //   723: aload_0
/*     */     //   724: aload_2
/*     */     //   725: invokespecial 284	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$taskAction$2:<init>	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Lcom/android/builder/internal/aapt/AaptPackageConfig;)V
/*     */     //   728: checkcast 286	org/gradle/api/Action
/*     */     //   731: invokeinterface 292 3 0
/*     */     //   736: return
/*     */     // Line number table:
/*     */     //   Java source line #74	-> byte code offset #0
/*     */     //   Java source line #76	-> byte code offset #4
/*     */     //   Java source line #77	-> byte code offset #30
/*     */     //   Java source line #80	-> byte code offset #56
/*     */     //   Java source line #81	-> byte code offset #67
/*     */     //   Java source line #82	-> byte code offset #68
/*     */     //   Java source line #85	-> byte code offset #68
/*     */     //   Java source line #82	-> byte code offset #68
/*     */     //   Java source line #84	-> byte code offset #68
/*     */     //   Java source line #82	-> byte code offset #68
/*     */     //   Java source line #83	-> byte code offset #68
/*     */     //   Java source line #82	-> byte code offset #68
/*     */     //   Java source line #83	-> byte code offset #85
/*     */     //   Java source line #166	-> byte code offset #87
/*     */     //   Java source line #167	-> byte code offset #110
/*     */     //   Java source line #168	-> byte code offset #138
/*     */     //   Java source line #83	-> byte code offset #149
/*     */     //   Java source line #167	-> byte code offset #181
/*     */     //   Java source line #169	-> byte code offset #184
/*     */     //   Java source line #84	-> byte code offset #200
/*     */     //   Java source line #170	-> byte code offset #202
/*     */     //   Java source line #171	-> byte code offset #218
/*     */     //   Java source line #84	-> byte code offset #253
/*     */     //   Java source line #172	-> byte code offset #274
/*     */     //   Java source line #85	-> byte code offset #290
/*     */     //   Java source line #173	-> byte code offset #292
/*     */     //   Java source line #174	-> byte code offset #315
/*     */     //   Java source line #175	-> byte code offset #343
/*     */     //   Java source line #85	-> byte code offset #354
/*     */     //   Java source line #174	-> byte code offset #380
/*     */     //   Java source line #176	-> byte code offset #383
/*     */     //   Java source line #81	-> byte code offset #397
/*     */     //   Java source line #85	-> byte code offset #401
/*     */     //   Java source line #80	-> byte code offset #402
/*     */     //   Java source line #88	-> byte code offset #406
/*     */     //   Java source line #89	-> byte code offset #410
/*     */     //   Java source line #90	-> byte code offset #435
/*     */     //   Java source line #91	-> byte code offset #457
/*     */     //   Java source line #90	-> byte code offset #459
/*     */     //   Java source line #92	-> byte code offset #462
/*     */     //   Java source line #93	-> byte code offset #472
/*     */     //   Java source line #93	-> byte code offset #514
/*     */     //   Java source line #94	-> byte code offset #523
/*     */     //   Java source line #95	-> byte code offset #524
/*     */     //   Java source line #97	-> byte code offset #536
/*     */     //   Java source line #98	-> byte code offset #541
/*     */     //   Java source line #99	-> byte code offset #558
/*     */     //   Java source line #100	-> byte code offset #565
/*     */     //   Java source line #101	-> byte code offset #572
/*     */     //   Java source line #102	-> byte code offset #589
/*     */     //   Java source line #88	-> byte code offset #708
/*     */     //   Java source line #104	-> byte code offset #712
/*     */     //   Java source line #108	-> byte code offset #736
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	737	0	this	LinkLibraryAndroidResourcesTask
/*     */     //   4	733	1	imports	com.google.common.collect.ImmutableList.Builder
/*     */     //   712	25	2	request	AaptPackageConfig
/*     */     //   67	335	3	it	FileCollection
/*     */     //   87	102	4	$receiver$iv	Iterable
/*     */     //   202	77	4	$receiver$iv	Iterable
/*     */     //   292	96	4	$receiver$iv	Iterable
/*     */     //   110	76	6	$receiver$iv$iv	Iterable
/*     */     //   218	58	6	$receiver$iv$iv	Iterable
/*     */     //   315	70	6	$receiver$iv$iv	Iterable
/*     */     //   110	76	7	destination$iv$iv	java.util.Collection
/*     */     //   218	58	7	destination$iv$iv	java.util.Collection
/*     */     //   315	70	7	destination$iv$iv	java.util.Collection
/*     */     //   138	43	9	item$iv$iv	Object
/*     */     //   246	25	9	element$iv$iv	Object
/*     */     //   343	37	9	item$iv$iv	Object
/*     */     //   149	20	10	it	File
/*     */     //   253	5	10	it	com.android.build.gradle.internal.scope.BuildElements
/*     */     //   354	14	10	splitOutputs	com.android.build.gradle.internal.scope.BuildElements
/*     */     //   149	20	13	$i$a$1$map	int
/*     */     //   253	5	13	$i$a$2$filterNot	int
/*     */     //   354	14	13	$i$a$3$map	int
/*     */     //   110	76	14	$i$f$mapTo	int
/*     */     //   218	58	14	$i$f$filterNotTo	int
/*     */     //   315	70	14	$i$f$mapTo	int
/*     */     //   87	102	15	$i$f$map	int
/*     */     //   202	77	15	$i$f$filterNot	int
/*     */     //   292	96	15	$i$f$map	int
/*     */     //   67	335	16	$i$a$1$let	int
/*     */   }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B'\022\006\020\003\032\0020\004\022\b\020\005\032\004\030\0010\006\022\006\020\007\032\0020\006\022\006\020\b\032\0020\006¢\006\002\020\tJ\020\020\n\032\0020\0132\006\020\f\032\0020\002H\026J\b\020\r\032\0020\016H\026J\016\020\017\032\b\022\004\022\0020\0020\020H\026R\020\020\005\032\004\030\0010\006X\004¢\006\002\n\000R\016\020\b\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000¨\006\021"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;", "scope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "rClassSource", "Ljava/io/File;", "staticLibApk", "rDotTxt", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;Ljava/io/File;Ljava/io/File;)V", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */   public static final class ConfigAction
/*     */     implements com.android.build.gradle.internal.scope.TaskConfigAction<LinkLibraryAndroidResourcesTask>
/*     */   {
/*     */     private final VariantScope scope;
/*     */     private final File rClassSource;
/*     */     private final File staticLibApk;
/*     */     private final File rDotTxt;
/*     */     
/*     */     public ConfigAction(@NotNull VariantScope scope, @Nullable File rClassSource, @NotNull File staticLibApk, @NotNull File rDotTxt)
/*     */     {
/* 110 */       this.scope = scope;this.rClassSource = rClassSource;this.staticLibApk = staticLibApk;this.rDotTxt = rDotTxt;
/*     */     }
/*     */     
/*     */     @NotNull
/* 116 */     public String getName() { return scope.getTaskName("link", "Resources"); }
/*     */     @NotNull
/* 118 */     public Class<LinkLibraryAndroidResourcesTask> getType() { return LinkLibraryAndroidResourcesTask.class; }
/*     */     
/*     */     /* Error */
/*     */     public void execute(@NotNull LinkLibraryAndroidResourcesTask task)
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: ldc 37
/*     */       //   3: invokestatic 43	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   6: aload_1
/*     */       //   7: aload_0
/*     */       //   8: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   11: invokeinterface 46 1 0
/*     */       //   16: invokevirtual 50	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:setVariantName	(Ljava/lang/String;)V
/*     */       //   19: aload_1
/*     */       //   20: aload_0
/*     */       //   21: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   24: getstatic 56	com/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType:AAPT_FRIENDLY_MERGED_MANIFESTS	Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;
/*     */       //   27: checkcast 58	com/android/build/gradle/internal/scope/TaskOutputHolder$OutputType
/*     */       //   30: invokeinterface 62 2 0
/*     */       //   35: ifeq +27 -> 62
/*     */       //   38: aload_0
/*     */       //   39: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   42: getstatic 56	com/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType:AAPT_FRIENDLY_MERGED_MANIFESTS	Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;
/*     */       //   45: checkcast 58	com/android/build/gradle/internal/scope/TaskOutputHolder$OutputType
/*     */       //   48: invokeinterface 66 2 0
/*     */       //   53: dup
/*     */       //   54: ldc 68
/*     */       //   56: invokestatic 71	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   59: goto +24 -> 83
/*     */       //   62: aload_0
/*     */       //   63: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   66: getstatic 74	com/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType:MERGED_MANIFESTS	Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;
/*     */       //   69: checkcast 58	com/android/build/gradle/internal/scope/TaskOutputHolder$OutputType
/*     */       //   72: invokeinterface 66 2 0
/*     */       //   77: dup
/*     */       //   78: ldc 76
/*     */       //   80: invokestatic 71	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   83: invokestatic 80	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:access$setManifestFileDirectory$p	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Lorg/gradle/api/file/FileCollection;)V
/*     */       //   86: aload_1
/*     */       //   87: aload_0
/*     */       //   88: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   91: getstatic 83	com/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType:RES_COMPILED_FLAT_FILES	Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;
/*     */       //   94: checkcast 58	com/android/build/gradle/internal/scope/TaskOutputHolder$OutputType
/*     */       //   97: invokeinterface 66 2 0
/*     */       //   102: dup
/*     */       //   103: ldc 85
/*     */       //   105: invokestatic 71	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   108: invokestatic 88	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:access$setInputResourcesDirectories$p	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Lorg/gradle/api/file/FileCollection;)V
/*     */       //   111: aload_1
/*     */       //   112: aload_0
/*     */       //   113: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   116: getstatic 94	com/android/build/gradle/internal/publishing/AndroidArtifacts$ConsumedConfigType:COMPILE_CLASSPATH	Lcom/android/build/gradle/internal/publishing/AndroidArtifacts$ConsumedConfigType;
/*     */       //   119: getstatic 100	com/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactScope:ALL	Lcom/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactScope;
/*     */       //   122: getstatic 106	com/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactType:RES_STATIC_LIBRARY	Lcom/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactType;
/*     */       //   125: invokeinterface 110 4 0
/*     */       //   130: dup
/*     */       //   131: ldc 112
/*     */       //   133: invokestatic 71	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   136: invokestatic 115	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:access$setLibraryDependencies$p	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Lorg/gradle/api/file/FileCollection;)V
/*     */       //   139: aload_1
/*     */       //   140: aload_0
/*     */       //   141: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   144: getstatic 94	com/android/build/gradle/internal/publishing/AndroidArtifacts$ConsumedConfigType:COMPILE_CLASSPATH	Lcom/android/build/gradle/internal/publishing/AndroidArtifacts$ConsumedConfigType;
/*     */       //   147: getstatic 100	com/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactScope:ALL	Lcom/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactScope;
/*     */       //   150: getstatic 118	com/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactType:RES_SHARED_STATIC_LIBRARY	Lcom/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactType;
/*     */       //   153: invokeinterface 110 4 0
/*     */       //   158: dup
/*     */       //   159: ldc 120
/*     */       //   161: invokestatic 71	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   164: invokestatic 123	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:access$setSharedLibraryDependencies$p	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Lorg/gradle/api/file/FileCollection;)V
/*     */       //   167: aload_0
/*     */       //   168: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   171: invokeinterface 127 1 0
/*     */       //   176: dup
/*     */       //   177: ldc -127
/*     */       //   179: invokestatic 71	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   182: invokevirtual 134	com/android/build/gradle/internal/variant/BaseVariantData:getType	()Lcom/android/builder/core/VariantType;
/*     */       //   185: getstatic 140	com/android/builder/core/VariantType:FEATURE	Lcom/android/builder/core/VariantType;
/*     */       //   188: invokestatic 144	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */       //   191: ifeq +37 -> 228
/*     */       //   194: aload_0
/*     */       //   195: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   198: invokeinterface 148 1 0
/*     */       //   203: ifne +25 -> 228
/*     */       //   206: aload_1
/*     */       //   207: aload_0
/*     */       //   208: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   211: getstatic 94	com/android/build/gradle/internal/publishing/AndroidArtifacts$ConsumedConfigType:COMPILE_CLASSPATH	Lcom/android/build/gradle/internal/publishing/AndroidArtifacts$ConsumedConfigType;
/*     */       //   214: getstatic 151	com/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactScope:MODULE	Lcom/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactScope;
/*     */       //   217: getstatic 154	com/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactType:FEATURE_RESOURCE_PKG	Lcom/android/build/gradle/internal/publishing/AndroidArtifacts$ArtifactType;
/*     */       //   220: invokeinterface 110 4 0
/*     */       //   225: invokestatic 157	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:access$setFeatureDependencies$p	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Lorg/gradle/api/file/FileCollection;)V
/*     */       //   228: aload_0
/*     */       //   229: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   232: invokeinterface 160 1 0
/*     */       //   237: dup
/*     */       //   238: ifnull +9 -> 247
/*     */       //   241: invokevirtual 164	com/android/build/gradle/internal/variant/BaseVariantData:getScope	()Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   244: goto +5 -> 249
/*     */       //   247: pop
/*     */       //   248: aconst_null
/*     */       //   249: astore_2
/*     */       //   250: aload_2
/*     */       //   251: ifnull +19 -> 270
/*     */       //   254: aload_1
/*     */       //   255: aload_2
/*     */       //   256: getstatic 166	com/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType:RES_STATIC_LIBRARY	Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;
/*     */       //   259: checkcast 58	com/android/build/gradle/internal/scope/TaskOutputHolder$OutputType
/*     */       //   262: invokeinterface 66 2 0
/*     */       //   267: invokestatic 169	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:access$setTested$p	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Lorg/gradle/api/file/FileCollection;)V
/*     */       //   270: aload_1
/*     */       //   271: aload_0
/*     */       //   272: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   275: invokeinterface 173 1 0
/*     */       //   280: dup
/*     */       //   281: ldc -81
/*     */       //   283: invokestatic 71	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   286: invokevirtual 181	com/android/build/gradle/internal/scope/GlobalScope:getIntermediatesDir	()Ljava/io/File;
/*     */       //   289: iconst_2
/*     */       //   290: anewarray 183	java/lang/String
/*     */       //   293: dup
/*     */       //   294: iconst_0
/*     */       //   295: ldc -71
/*     */       //   297: aastore
/*     */       //   298: dup
/*     */       //   299: iconst_1
/*     */       //   300: aload_0
/*     */       //   301: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   304: invokeinterface 189 1 0
/*     */       //   309: dup
/*     */       //   310: ldc -65
/*     */       //   312: invokestatic 71	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   315: invokevirtual 196	com/android/build/gradle/internal/core/GradleVariantConfiguration:getDirName	()Ljava/lang/String;
/*     */       //   318: aastore
/*     */       //   319: invokestatic 202	com/android/utils/FileUtils:join	(Ljava/io/File;[Ljava/lang/String;)Ljava/io/File;
/*     */       //   322: dup
/*     */       //   323: ldc -52
/*     */       //   325: invokestatic 71	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   328: invokestatic 208	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:access$setAaptIntermediateDir$p	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Ljava/io/File;)V
/*     */       //   331: aload_1
/*     */       //   332: aload_0
/*     */       //   333: getfield 212	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:rClassSource	Ljava/io/File;
/*     */       //   336: invokestatic 215	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:access$setRClassSource$p	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Ljava/io/File;)V
/*     */       //   339: aload_1
/*     */       //   340: aload_0
/*     */       //   341: getfield 218	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:staticLibApk	Ljava/io/File;
/*     */       //   344: invokestatic 221	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:access$setStaticLibApk$p	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Ljava/io/File;)V
/*     */       //   347: aload_1
/*     */       //   348: aload_0
/*     */       //   349: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   352: invokeinterface 173 1 0
/*     */       //   357: dup
/*     */       //   358: ldc -81
/*     */       //   360: invokestatic 71	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   363: invokevirtual 225	com/android/build/gradle/internal/scope/GlobalScope:getAndroidBuilder	()Lcom/android/builder/core/AndroidBuilder;
/*     */       //   366: invokevirtual 229	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:setAndroidBuilder	(Lcom/android/builder/core/AndroidBuilder;)V
/*     */       //   369: aload_1
/*     */       //   370: new 231	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction$execute$1
/*     */       //   373: dup
/*     */       //   374: aload_0
/*     */       //   375: getfield 14	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:scope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   378: invokeinterface 189 1 0
/*     */       //   383: invokespecial 235	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction$execute$1:<init>	(Lcom/android/build/gradle/internal/core/GradleVariantConfiguration;)V
/*     */       //   386: checkcast 237	kotlin/jvm/functions/Function0
/*     */       //   389: astore_3
/*     */       //   390: new 239	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTaskKt$sam$Supplier$207e2d1c
/*     */       //   393: dup
/*     */       //   394: aload_3
/*     */       //   395: invokespecial 242	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTaskKt$sam$Supplier$207e2d1c:<init>	(Lkotlin/jvm/functions/Function0;)V
/*     */       //   398: checkcast 244	com/google/common/base/Supplier
/*     */       //   401: invokestatic 250	com/google/common/base/Suppliers:memoize	(Lcom/google/common/base/Supplier;)Lcom/google/common/base/Supplier;
/*     */       //   404: dup
/*     */       //   405: ldc -4
/*     */       //   407: invokestatic 71	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   410: checkcast 254	java/util/function/Supplier
/*     */       //   413: invokestatic 258	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:access$setPackageForRSupplier$p	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Ljava/util/function/Supplier;)V
/*     */       //   416: aload_1
/*     */       //   417: aload_0
/*     */       //   418: getfield 261	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask$ConfigAction:rDotTxt	Ljava/io/File;
/*     */       //   421: invokestatic 264	com/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask:access$setRDotTxt$p	(Lcom/android/build/gradle/internal/res/namespaced/LinkLibraryAndroidResourcesTask;Ljava/io/File;)V
/*     */       //   424: return
/*     */       // Line number table:
/*     */       //   Java source line #121	-> byte code offset #6
/*     */       //   Java source line #122	-> byte code offset #19
/*     */       //   Java source line #123	-> byte code offset #19
/*     */       //   Java source line #124	-> byte code offset #38
/*     */       //   Java source line #126	-> byte code offset #62
/*     */       //   Java source line #123	-> byte code offset #83
/*     */       //   Java source line #128	-> byte code offset #86
/*     */       //   Java source line #129	-> byte code offset #111
/*     */       //   Java source line #130	-> byte code offset #111
/*     */       //   Java source line #131	-> byte code offset #116
/*     */       //   Java source line #132	-> byte code offset #119
/*     */       //   Java source line #133	-> byte code offset #122
/*     */       //   Java source line #130	-> byte code offset #125
/*     */       //   Java source line #134	-> byte code offset #139
/*     */       //   Java source line #135	-> byte code offset #139
/*     */       //   Java source line #136	-> byte code offset #144
/*     */       //   Java source line #137	-> byte code offset #147
/*     */       //   Java source line #138	-> byte code offset #150
/*     */       //   Java source line #135	-> byte code offset #153
/*     */       //   Java source line #140	-> byte code offset #167
/*     */       //   Java source line #141	-> byte code offset #206
/*     */       //   Java source line #142	-> byte code offset #206
/*     */       //   Java source line #143	-> byte code offset #211
/*     */       //   Java source line #144	-> byte code offset #214
/*     */       //   Java source line #145	-> byte code offset #217
/*     */       //   Java source line #142	-> byte code offset #220
/*     */       //   Java source line #148	-> byte code offset #228
/*     */       //   Java source line #149	-> byte code offset #250
/*     */       //   Java source line #150	-> byte code offset #254
/*     */       //   Java source line #153	-> byte code offset #270
/*     */       //   Java source line #154	-> byte code offset #270
/*     */       //   Java source line #155	-> byte code offset #271
/*     */       //   Java source line #154	-> byte code offset #319
/*     */       //   Java source line #156	-> byte code offset #331
/*     */       //   Java source line #157	-> byte code offset #339
/*     */       //   Java source line #158	-> byte code offset #347
/*     */       //   Java source line #159	-> byte code offset #369
/*     */       //   Java source line #160	-> byte code offset #416
/*     */       //   Java source line #161	-> byte code offset #424
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	signature
/*     */       //   0	425	0	this	ConfigAction
/*     */       //   0	425	1	task	LinkLibraryAndroidResourcesTask
/*     */       //   250	175	2	testedScope	VariantScope
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.LinkLibraryAndroidResourcesTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */