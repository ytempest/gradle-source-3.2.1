/*     */ package com.android.build.gradle.internal.res.namespaced;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.OutputScope;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.internal.aapt.AaptOptions;
/*     */ import com.android.builder.internal.aapt.AaptPackageConfig;
/*     */ import com.android.builder.internal.aapt.v2.QueueableAapt2;
/*     */ import com.android.builder.sdk.TargetInfo;
/*     */ import com.google.common.collect.ImmutableCollection;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.gradle.api.tasks.PathSensitive;
/*     */ import org.gradle.api.tasks.PathSensitivity;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @org.gradle.api.tasks.CacheableTask
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000,\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\022\n\002\020\002\n\002\b\002\b\027\030\0002\0020\001:\001'B\005¢\006\002\020\002J\b\020%\032\0020&H\007R&\020\005\032\0020\0042\006\020\003\032\0020\0048\007@BX.¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR&\020\013\032\0020\n2\006\020\003\032\0020\n8\007@BX.¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R&\020\020\032\0020\n2\006\020\003\032\0020\n8\007@BX.¢\006\016\n\000\032\004\b\021\020\r\"\004\b\022\020\017R&\020\024\032\0020\0232\006\020\003\032\0020\0238\007@BX.¢\006\016\n\000\032\004\b\025\020\026\"\004\b\027\020\030R&\020\031\032\0020\0042\006\020\003\032\0020\0048\007@BX.¢\006\016\n\000\032\004\b\032\020\007\"\004\b\033\020\tR&\020\034\032\0020\0042\006\020\003\032\0020\0048\007@BX.¢\006\016\n\000\032\004\b\035\020\007\"\004\b\036\020\tR&\020\037\032\0020\n2\006\020\003\032\0020\n8\007@BX.¢\006\016\n\000\032\004\b \020\r\"\004\b!\020\017R&\020\"\032\0020\n2\006\020\003\032\0020\n8\007@BX.¢\006\016\n\000\032\004\b#\020\r\"\004\b$\020\017¨\006("}, d2={"Lcom/android/build/gradle/internal/res/namespaced/ProcessAndroidAppResourcesTask;", "Lcom/android/build/gradle/internal/tasks/AndroidBuilderTask;", "()V", "<set-?>", "Ljava/io/File;", "aaptIntermediateDir", "getAaptIntermediateDir", "()Ljava/io/File;", "setAaptIntermediateDir", "(Ljava/io/File;)V", "Lorg/gradle/api/file/FileCollection;", "libraryDependencies", "getLibraryDependencies", "()Lorg/gradle/api/file/FileCollection;", "setLibraryDependencies", "(Lorg/gradle/api/file/FileCollection;)V", "manifestFileDirectory", "getManifestFileDirectory", "setManifestFileDirectory", "Lcom/android/build/gradle/internal/scope/OutputScope;", "outputScope", "getOutputScope", "()Lcom/android/build/gradle/internal/scope/OutputScope;", "setOutputScope", "(Lcom/android/build/gradle/internal/scope/OutputScope;)V", "rClassSource", "getRClassSource", "setRClassSource", "resourceApUnderscore", "getResourceApUnderscore", "setResourceApUnderscore", "sharedLibraryDependencies", "getSharedLibraryDependencies", "setSharedLibraryDependencies", "thisSubProjectStaticLibrary", "getThisSubProjectStaticLibrary", "setThisSubProjectStaticLibrary", "taskAction", "", "ConfigAction", "gradle-core"})
/*     */ public class ProcessAndroidAppResourcesTask extends com.android.build.gradle.internal.tasks.AndroidBuilderTask
/*     */ {
/*     */   @NotNull
/*     */   private FileCollection manifestFileDirectory;
/*     */   @NotNull
/*     */   private FileCollection thisSubProjectStaticLibrary;
/*     */   @NotNull
/*     */   private FileCollection libraryDependencies;
/*     */   @NotNull
/*     */   private FileCollection sharedLibraryDependencies;
/*     */   @NotNull
/*     */   private File aaptIntermediateDir;
/*     */   @NotNull
/*     */   private File rClassSource;
/*     */   @NotNull
/*     */   private File resourceApUnderscore;
/*     */   @NotNull
/*     */   private OutputScope outputScope;
/*     */   
/*     */   @InputFiles
/*     */   @PathSensitive(PathSensitivity.RELATIVE)
/*     */   @NotNull
/*     */   public final FileCollection getManifestFileDirectory()
/*     */   {
/*  56 */     FileCollection tmp4_1 = manifestFileDirectory;
/*     */     
/*  56 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("manifestFileDirectory"); return tmp4_1; } private final void setManifestFileDirectory(FileCollection <set-?>) { manifestFileDirectory = <set-?>; } @InputFiles
/*     */   @PathSensitive(PathSensitivity.RELATIVE)
/*     */   @NotNull
/*  57 */   public final FileCollection getThisSubProjectStaticLibrary() { FileCollection tmp4_1 = thisSubProjectStaticLibrary;
/*     */     
/*  57 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("thisSubProjectStaticLibrary"); return tmp4_1; } private final void setThisSubProjectStaticLibrary(FileCollection <set-?>) { thisSubProjectStaticLibrary = <set-?>; } @InputFiles
/*     */   @PathSensitive(PathSensitivity.NONE)
/*     */   @NotNull
/*  58 */   public final FileCollection getLibraryDependencies() { FileCollection tmp4_1 = libraryDependencies;
/*     */     
/*  58 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("libraryDependencies"); return tmp4_1; } private final void setLibraryDependencies(FileCollection <set-?>) { libraryDependencies = <set-?>; } @InputFiles
/*     */   @PathSensitive(PathSensitivity.NONE)
/*     */   @NotNull
/*  59 */   public final FileCollection getSharedLibraryDependencies() { FileCollection tmp4_1 = sharedLibraryDependencies;
/*     */     
/*  59 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("sharedLibraryDependencies"); return tmp4_1; } private final void setSharedLibraryDependencies(FileCollection <set-?>) { sharedLibraryDependencies = <set-?>; } @OutputDirectory
/*     */   @NotNull
/*  61 */   public final File getAaptIntermediateDir() { File tmp4_1 = aaptIntermediateDir;
/*     */     
/*  61 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("aaptIntermediateDir"); return tmp4_1; } private final void setAaptIntermediateDir(File <set-?>) { aaptIntermediateDir = <set-?>; } @OutputDirectory
/*     */   @NotNull
/*  62 */   public final File getRClassSource() { File tmp4_1 = rClassSource;
/*     */     
/*  62 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("rClassSource"); return tmp4_1; } private final void setRClassSource(File <set-?>) { rClassSource = <set-?>; } @org.gradle.api.tasks.OutputFile
/*     */   @NotNull
/*  63 */   public final File getResourceApUnderscore() { File tmp4_1 = resourceApUnderscore;
/*     */     
/*  63 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("resourceApUnderscore"); return tmp4_1; } private final void setResourceApUnderscore(File <set-?>) { resourceApUnderscore = <set-?>; } @org.gradle.api.tasks.Internal
/*     */   @NotNull
/*  65 */   public final OutputScope getOutputScope() { OutputScope tmp4_1 = outputScope;
/*     */     
/*  65 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("outputScope"); return tmp4_1; } private final void setOutputScope(OutputScope <set-?>) { outputScope = <set-?>; }
/*     */   
/*     */   @org.gradle.api.tasks.TaskAction
/*     */   public final void taskAction()
/*     */   {
/*  70 */     ImmutableList.Builder staticLibraries = ImmutableList.builder(); FileCollection 
/*  71 */       tmp9_6 = libraryDependencies;
/*  71 */     if (tmp9_6 == null) Intrinsics.throwUninitializedPropertyAccessException("libraryDependencies"); staticLibraries.addAll((Iterable)tmp9_6.getFiles()); FileCollection 
/*  72 */       tmp35_32 = thisSubProjectStaticLibrary;
/*  72 */     if (tmp35_32 == null) Intrinsics.throwUninitializedPropertyAccessException("thisSubProjectStaticLibrary"); staticLibraries.add(tmp35_32.getSingleFile()); AndroidBuilder 
/*     */     
/*  74 */       tmp61_58 = getBuilder();Intrinsics.checkExpressionValueIsNotNull(tmp61_58, "builder"); String tmp76_71 = tmp61_58.getTarget().getPath(1);Intrinsics.checkExpressionValueIsNotNull(tmp76_71, "builder.target.getPath(IAndroidTarget.ANDROID_JAR)"); FileCollection 
/*  75 */       tmp90_87 = manifestFileDirectory;
/*  75 */     if (tmp90_87 == null) { Intrinsics.throwUninitializedPropertyAccessException("manifestFileDirectory");
/*     */     }
/*     */     
/*  78 */     ImmutableList tmp123_120 = staticLibraries.build();Intrinsics.checkExpressionValueIsNotNull(tmp123_120, "staticLibraries.build()"); FileCollection 
/*  79 */       tmp133_130 = sharedLibraryDependencies;
/*  79 */     if (tmp133_130 == null) Intrinsics.throwUninitializedPropertyAccessException("sharedLibraryDependencies"); Object localObject1 = (Iterable)tmp133_130;ImmutableList localImmutableList4 = tmp123_120;AaptOptions localAaptOptions2 = new AaptOptions(null, false, null);File localFile7 = new File(tmp90_87.getSingleFile(), "AndroidManifest.xml");String str4 = tmp76_71; AaptPackageConfig localAaptPackageConfig2; AaptPackageConfig localAaptPackageConfig1 = localAaptPackageConfig2 = new com/android/builder/internal/aapt/AaptPackageConfig;Object localObject4 = localObject1; ImmutableList tmp178_175 = ImmutableList.copyOf((Iterable)localObject4);Intrinsics.checkExpressionValueIsNotNull(tmp178_175, "ImmutableList.copyOf(sha…ependencies.asIterable())"); File 
/*  80 */       tmp188_185 = rClassSource;
/*  80 */     if (tmp188_185 == null) Intrinsics.throwUninitializedPropertyAccessException("rClassSource");
/*  81 */     File tmp214_211 = resourceApUnderscore;
/*     */     
/*  81 */     if (tmp214_211 == null) { Intrinsics.throwUninitializedPropertyAccessException("resourceApUnderscore");
/*     */     }
/*  83 */     File tmp234_231 = aaptIntermediateDir;
/*     */     
/*  83 */     if (tmp234_231 == null) Intrinsics.throwUninitializedPropertyAccessException("aaptIntermediateDir"); localObject1 = tmp234_231;Object localObject2 = com.android.builder.core.VariantType.LIBRARY;boolean bool1 = false;boolean bool2 = false;ImmutableCollection localImmutableCollection1 = null;Integer localInteger = null;File localFile1 = tmp214_211;boolean bool3 = false;com.google.common.collect.ImmutableSet localImmutableSet = null;String str1 = null;boolean bool4 = false;String str2 = null;boolean bool5 = false;ImmutableCollection localImmutableCollection2 = null;File localFile2 = null;File localFile3 = null;ImmutableList localImmutableList1 = null;boolean bool6 = false;File localFile4 = null;ImmutableCollection localImmutableCollection3 = null;File localFile5 = tmp188_185;ImmutableList localImmutableList2 = tmp178_175;ImmutableList localImmutableList3 = localImmutableList4;AaptOptions localAaptOptions1 = localAaptOptions2;File localFile6 = localFile7;String str3 = str4;localAaptPackageConfig2.<init>(localFile6, localAaptOptions1, str3, (com.android.builder.core.VariantType)localObject2, localFile5, localFile1, localImmutableCollection3, localFile4, bool6, localImmutableList1, localFile3, localFile2, localImmutableCollection2, bool5, str2, bool4, str1, localImmutableSet, bool3, localImmutableList2, localInteger, localImmutableCollection1, bool2, bool1, localImmutableList3, (File)localObject1, 16252864, null);AaptPackageConfig config = localAaptPackageConfig1; AndroidBuilder 
/*     */     
/*  87 */       tmp374_371 = getBuilder();Intrinsics.checkExpressionValueIsNotNull(tmp374_371, "builder"); TargetInfo tmp383_380 = tmp374_371.getTargetInfo(); if (tmp383_380 == null) Intrinsics.throwNpe();
/*  88 */     AndroidBuilder tmp401_398 = getBuilder();Intrinsics.checkExpressionValueIsNotNull(tmp401_398, "builder");localObject1 = (java.io.Closeable)new QueueableAapt2((com.android.ide.common.process.ProcessOutputHandler)new com.android.ide.common.process.LoggedProcessOutputHandler(getILogger()), tmp383_380.getBuildTools(), (com.android.utils.ILogger)new com.android.build.gradle.internal.aapt.AaptGradleFactory.FilteringLogger(tmp401_398.getLogger()), 
/*  89 */       0);localObject2 = (Throwable)null; try { Object aapt = (QueueableAapt2)localObject1;
/*  90 */       int $i$a$1$use; ((QueueableAapt2)aapt).link(config, getILogger());aapt = 
/*  91 */         kotlin.Unit.INSTANCE;
/*     */     }
/*     */     catch (Throwable localThrowable1)
/*     */     {
/*  89 */       localObject2 = localThrowable1; throw localThrowable1; } finally { kotlin.io.CloseableKt.closeFinally((java.io.Closeable)localObject1, (Throwable)localObject2); } }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0008\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B%\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006\022\006\020\b\032\0020\t¢\006\002\020\nJ\020\020\f\032\0020\r2\006\020\016\032\0020\002H\026J\b\020\017\032\0020\020H\026J\016\020\021\032\b\022\004\022\0020\0020\022H\026R\021\020\b\032\0020\t¢\006\b\n\000\032\004\b\b\020\013R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\023"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/ProcessAndroidAppResourcesTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/namespaced/ProcessAndroidAppResourcesTask;", "scope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "rClassSource", "Ljava/io/File;", "resourceApUnderscore", "isLibrary", "", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;Ljava/io/File;Z)V", "()Z", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */   public static final class ConfigAction implements com.android.build.gradle.internal.scope.TaskConfigAction<ProcessAndroidAppResourcesTask> { private final VariantScope scope;
/*     */     
/*  94 */     public ConfigAction(@NotNull VariantScope scope, @NotNull File rClassSource, @NotNull File resourceApUnderscore, boolean isLibrary) { this.scope = scope;this.rClassSource = rClassSource;this.resourceApUnderscore = resourceApUnderscore;this.isLibrary = isLibrary; }
/*     */     
/*     */     private final File rClassSource;
/*     */     
/*  98 */     public final boolean isLibrary() { return isLibrary; }
/*     */     
/*     */     @NotNull
/* 101 */     public String getName() { String tmp13_8 = scope.getTaskName("process", "Resources");Intrinsics.checkExpressionValueIsNotNull(tmp13_8, "scope.getTaskName(\"process\", \"Resources\")");return tmp13_8;
/*     */     }
/*     */     
/*     */     @NotNull
/* 105 */     public Class<ProcessAndroidAppResourcesTask> getType() { return ProcessAndroidAppResourcesTask.class; }
/*     */     
/*     */     private final File resourceApUnderscore;
/*     */     private final boolean isLibrary;
/* 109 */     public void execute(@NotNull ProcessAndroidAppResourcesTask task) { Intrinsics.checkParameterIsNotNull(task, "task");task.setVariantName(scope.getFullVariantName());
/*     */       
/* 112 */       Intrinsics.checkExpressionValueIsNotNull(scope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.AAPT_FRIENDLY_MERGED_MANIFESTS), "scope.getOutput(TaskOutp…RIENDLY_MERGED_MANIFESTS)"); FileCollection 
/*     */       
/* 114 */         tmp77_72 = scope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS);Intrinsics.checkExpressionValueIsNotNull(tmp77_72, "scope.getOutput(TaskOutp…putType.MERGED_MANIFESTS)");ProcessAndroidAppResourcesTask.access$setManifestFileDirectory$p(task, tmp77_72); FileCollection 
/*     */       
/* 116 */         tmp102_97 = scope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.RES_STATIC_LIBRARY);Intrinsics.checkExpressionValueIsNotNull(tmp102_97, "scope.getOutput(TaskOutp…tType.RES_STATIC_LIBRARY)");ProcessAndroidAppResourcesTask.access$setThisSubProjectStaticLibrary$p(task, tmp102_97); FileCollection 
/*     */       
/* 118 */         tmp130_125 = scope.getArtifactFileCollection(
/* 119 */         AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, 
/* 120 */         AndroidArtifacts.ArtifactScope.ALL, 
/* 121 */         AndroidArtifacts.ArtifactType.RES_STATIC_LIBRARY);Intrinsics.checkExpressionValueIsNotNull(tmp130_125, "scope.getArtifactFileCol…tType.RES_STATIC_LIBRARY)");ProcessAndroidAppResourcesTask.access$setLibraryDependencies$p(task, tmp130_125); FileCollection 
/*     */       
/* 123 */         tmp158_153 = scope.getArtifactFileCollection(
/* 124 */         AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, 
/* 125 */         AndroidArtifacts.ArtifactScope.ALL, 
/* 126 */         AndroidArtifacts.ArtifactType.RES_SHARED_STATIC_LIBRARY);Intrinsics.checkExpressionValueIsNotNull(tmp158_153, "scope.getArtifactFileCol…ES_SHARED_STATIC_LIBRARY)");ProcessAndroidAppResourcesTask.access$setSharedLibraryDependencies$p(task, tmp158_153); OutputScope 
/*     */       
/* 128 */         tmp177_172 = scope.getOutputScope();Intrinsics.checkExpressionValueIsNotNull(tmp177_172, "scope.outputScope");ProcessAndroidAppResourcesTask.access$setOutputScope$p(task, tmp177_172); GlobalScope 
/*     */       
/* 131 */         tmp196_191 = scope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp196_191, "scope.globalScope"); GradleVariantConfiguration tmp225_220 = scope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp225_220, "scope.variantConfiguration");{ "res-process-intermediate" }[1] = tmp225_220.getDirName(); File tmp238_235 = com.android.utils.FileUtils.join(tmp196_191.getIntermediatesDir(), tmp214_209);Intrinsics.checkExpressionValueIsNotNull(tmp238_235, "FileUtils.join(\n        …antConfiguration.dirName)");ProcessAndroidAppResourcesTask.access$setAaptIntermediateDir$p(task, tmp238_235);
/* 132 */       ProcessAndroidAppResourcesTask.access$setRClassSource$p(task, rClassSource);
/* 133 */       ProcessAndroidAppResourcesTask.access$setResourceApUnderscore$p(task, resourceApUnderscore); GlobalScope 
/* 134 */         tmp273_268 = scope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp273_268, "scope.globalScope");task.setAndroidBuilder(tmp273_268.getAndroidBuilder());
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.ProcessAndroidAppResourcesTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */