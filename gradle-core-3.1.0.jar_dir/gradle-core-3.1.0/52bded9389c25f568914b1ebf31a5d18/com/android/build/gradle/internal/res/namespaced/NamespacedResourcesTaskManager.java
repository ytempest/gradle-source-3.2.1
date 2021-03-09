/*     */ package com.android.build.gradle.internal.res.namespaced;
/*     */ 
/*     */ import com.android.build.gradle.internal.TaskFactory;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.res.LinkApplicationAndroidResourcesTask;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.model.SourceProvider;
/*     */ import com.android.utils.FileUtils;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.collections.IndexedValue;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import org.gradle.api.Task;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000@\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\013\n\002\b\004\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\b\020\t\032\0020\nH\002J\b\020\013\032\0020\nH\002J\b\020\f\032\0020\nH\002J*\020\r\032\0020\n2\006\020\016\032\0020\0172\b\020\020\032\004\030\0010\0212\006\020\022\032\0020\0232\006\020\024\032\0020\025H\002J\032\020\026\032\0020\n2\006\020\016\032\0020\0172\b\020\020\032\004\030\0010\021H\002J\b\020\027\032\0020\nH\002J(\020\030\032\0020\n2\006\020\016\032\0020\0172\b\020\020\032\004\030\0010\0212\006\020\022\032\0020\0232\006\020\024\032\0020\025R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000¨\006\031"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/NamespacedResourcesTaskManager;", "", "globalScope", "Lcom/android/build/gradle/internal/scope/GlobalScope;", "taskFactory", "Lcom/android/build/gradle/internal/TaskFactory;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "(Lcom/android/build/gradle/internal/scope/GlobalScope;Lcom/android/build/gradle/internal/TaskFactory;Lcom/android/build/gradle/internal/scope/VariantScope;)V", "createCompileResourcesTask", "", "createCompileRuntimeRClassTask", "createLinkResourcesTask", "createNamespacedAppProcessTask", "resPackageOutputFolder", "Ljava/io/File;", "packageOutputType", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;", "baseName", "", "useAaptToGenerateLegacyMultidexMainDexProguardRules", "", "createNamespacedLibraryProcessResourcesTask", "createNamespacedLibraryRFiles", "createNamespacedResourceTasks", "gradle-core"})
/*     */ public final class NamespacedResourcesTaskManager
/*     */ {
/*     */   private final GlobalScope globalScope;
/*     */   private final TaskFactory taskFactory;
/*     */   private final VariantScope variantScope;
/*     */   
/*     */   public NamespacedResourcesTaskManager(@NotNull GlobalScope globalScope, @NotNull TaskFactory taskFactory, @NotNull VariantScope variantScope)
/*     */   {
/*  37 */     this.globalScope = globalScope;this.taskFactory = taskFactory;this.variantScope = variantScope;
/*     */   }
/*     */   
/*     */   private final void createNamespacedLibraryRFiles()
/*     */   {
/*  84 */     GlobalScope tmp13_8 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp13_8, "variantScope.globalScope"); GradleVariantConfiguration 
/*  85 */       tmp43_38 = variantScope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp43_38, "variantScope.variantConfiguration");File rClassJarFile = new File(tmp13_8.getIntermediatesDir(), "res-rJar/" + tmp43_38.getDirName() + "/R.jar"); GlobalScope 
/*     */     
/*  87 */       tmp80_75 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp80_75, "variantScope.globalScope"); GradleVariantConfiguration 
/*  88 */       tmp110_105 = variantScope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp110_105, "variantScope.variantConfiguration");File resIdsFile = new File(tmp80_75.getIntermediatesDir(), "res-ids/" + tmp110_105.getDirName() + "res-ids.txt"); FileCollection 
/*     */     
/*  93 */       tmp161_156 = variantScope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.SYMBOL_LIST);Intrinsics.checkExpressionValueIsNotNull(tmp161_156, "variantScope.getOutput(TaskOutputType.SYMBOL_LIST)");GenerateNamespacedLibraryRFilesTask task = (GenerateNamespacedLibraryRFilesTask)taskFactory.create((TaskConfigAction)new GenerateNamespacedLibraryRFilesTask.ConfigAction(variantScope, tmp161_156, 
/*  94 */       rClassJarFile, 
/*  95 */       resIdsFile)); GenerateNamespacedLibraryRFilesTask 
/*     */     
/* 100 */       tmp193_192 = task;Intrinsics.checkExpressionValueIsNotNull(tmp193_192, "task");variantScope.addTaskOutput(TaskOutputHolder.TaskOutputType.COMPILE_ONLY_NAMESPACED_R_CLASS_JAR, rClassJarFile, tmp193_192.getName());
/* 101 */     variantScope.addTaskOutput(
/* 102 */       TaskOutputHolder.TaskOutputType.NAMESPACED_SYMBOL_LIST_WITH_PACKAGE_NAME, 
/* 103 */       resIdsFile, 
/* 104 */       task.getName());
/*     */   }
/*     */   
/*     */   private final void createCompileRuntimeRClassTask()
/*     */   {
/* 110 */     GlobalScope tmp13_8 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp13_8, "variantScope.globalScope"); GradleVariantConfiguration 
/* 111 */       tmp43_38 = variantScope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp43_38, "variantScope.variantConfiguration");File rClassCompiledOutputDir = new File(tmp13_8.getIntermediatesDir(), "res-final-r-classes/" + tmp43_38.getDirName()); String 
/*     */     
/* 114 */       tmp83_78 = variantScope.getTaskName("compile", "FinalRClass");Intrinsics.checkExpressionValueIsNotNull(tmp83_78, "variantScope.getTaskName(\"compile\", \"FinalRClass\")"); FileCollection 
/* 115 */       tmp104_99 = variantScope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.RUNTIME_R_CLASS_SOURCES);Intrinsics.checkExpressionValueIsNotNull(tmp104_99, "variantScope.getOutput(T….RUNTIME_R_CLASS_SOURCES)");CompileRClassTask task = (CompileRClassTask)taskFactory.create((TaskConfigAction)new CompileRClassTask.ConfigAction(tmp83_78, tmp104_99, 
/* 116 */       rClassCompiledOutputDir)); CompileRClassTask 
/*     */     
/* 121 */       tmp135_134 = task;Intrinsics.checkExpressionValueIsNotNull(tmp135_134, "task");variantScope.addTaskOutput(TaskOutputHolder.TaskOutputType.RUNTIME_R_CLASS_CLASSES, rClassCompiledOutputDir, tmp135_134.getName());
/*     */   }
/*     */   
/*     */   private final void createNamespacedAppProcessTask(File resPackageOutputFolder, TaskOutputHolder.TaskOutputType packageOutputType, String baseName, boolean useAaptToGenerateLegacyMultidexMainDexProguardRules)
/*     */   {
/* 130 */     GradleVariantConfiguration tmp32_27 = variantScope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp32_27, "variantScope.variantConfiguration");File runtimeRClassSources = new File(globalScope.getGeneratedDir(), "source/final-r/" + tmp32_27.getDirName()); BaseVariantData 
/*     */     
/* 136 */       tmp76_71 = variantScope.getVariantData();Intrinsics.checkExpressionValueIsNotNull(tmp76_71, "variantScope.variantData");LinkApplicationAndroidResourcesTask process = (LinkApplicationAndroidResourcesTask)taskFactory.create((TaskConfigAction)new com.android.build.gradle.internal.res.LinkApplicationAndroidResourcesTask.NamespacedConfigAction(variantScope, runtimeRClassSources, resPackageOutputFolder, Intrinsics.areEqual(tmp76_71.getType(), VariantType.LIBRARY), 
/* 137 */       useAaptToGenerateLegacyMultidexMainDexProguardRules, 
/* 138 */       baseName)); LinkApplicationAndroidResourcesTask 
/*     */     
/* 142 */       tmp120_118 = process;Intrinsics.checkExpressionValueIsNotNull(tmp120_118, "process");variantScope.addTaskOutput(TaskOutputHolder.TaskOutputType.PROCESSED_RES, resPackageOutputFolder, tmp120_118.getName());
/* 143 */     variantScope.addTaskOutput(
/* 144 */       TaskOutputHolder.TaskOutputType.RUNTIME_R_CLASS_SOURCES, 
/* 145 */       runtimeRClassSources, 
/* 146 */       process.getName());
/* 147 */     if (packageOutputType != null) {
/* 148 */       variantScope.addTaskOutput(
/* 149 */         packageOutputType, 
/* 150 */         variantScope.getProcessResourcePackageOutputDirectory(), 
/* 151 */         process.getName());
/*     */     }
/*     */   }
/*     */   
/*     */   private final void createNamespacedLibraryProcessResourcesTask(File resPackageOutputFolder, TaskOutputHolder.TaskOutputType packageOutputType)
/*     */   {
/* 159 */     GradleVariantConfiguration tmp32_27 = variantScope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp32_27, "variantScope.variantConfiguration");File runtimeRClassSources = new File(globalScope.getGeneratedDir(), "source/final-r/" + tmp32_27.getDirName()); BaseVariantData 
/*     */     
/* 165 */       tmp84_79 = variantScope.getVariantData();Intrinsics.checkExpressionValueIsNotNull(tmp84_79, "variantScope.variantData");ProcessAndroidAppResourcesTask process = (ProcessAndroidAppResourcesTask)taskFactory.create((TaskConfigAction)new ProcessAndroidAppResourcesTask.ConfigAction(variantScope, runtimeRClassSources, new File(resPackageOutputFolder, "res.apk"), Intrinsics.areEqual(tmp84_79.getType(), VariantType.LIBRARY))); ProcessAndroidAppResourcesTask 
/*     */     
/* 169 */       tmp125_123 = process;Intrinsics.checkExpressionValueIsNotNull(tmp125_123, "process");variantScope.addTaskOutput(TaskOutputHolder.TaskOutputType.PROCESSED_RES, resPackageOutputFolder, tmp125_123.getName());
/* 170 */     variantScope.addTaskOutput(
/* 171 */       TaskOutputHolder.TaskOutputType.RUNTIME_R_CLASS_SOURCES, 
/* 172 */       runtimeRClassSources, 
/* 173 */       process.getName());
/* 174 */     if (packageOutputType != null) {
/* 175 */       variantScope.addTaskOutput(
/* 176 */         packageOutputType, 
/* 177 */         variantScope.getProcessResourcePackageOutputDirectory(), 
/* 178 */         process.getName());
/*     */     }
/*     */   }
/*     */   
/*     */   private final void createCompileResourcesTask()
/*     */   {
/* 185 */     GlobalScope tmp9_4 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp9_4, "variantScope.globalScope"); GradleVariantConfiguration 
/*     */     
/* 188 */       tmp45_40 = variantScope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp45_40, "variantScope.variantConfiguration");{"res", "compiled" }[2] = tmp45_40.getDirName();File compiledDirectory = FileUtils.join(tmp9_4.getIntermediatesDir(), tmp34_28); BaseVariantData 
/*     */     
/* 191 */       tmp68_63 = variantScope.getVariantData();Intrinsics.checkExpressionValueIsNotNull(tmp68_63, "variantScope.variantData"); GradleVariantConfiguration tmp77_74 = tmp68_63.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp77_74, "variantScope.variantData.variantConfiguration");List sourceSets = tmp77_74.getSortedSourceProviders();
/*     */     
/* 193 */     List tasks = (List)new ArrayList();
/*     */     
/* 195 */     List directories = (List)new ArrayList();
/*     */     
/* 197 */     for (Iterator localIterator1 = sourceSets.iterator(); localIterator1.hasNext();) { sourceSet = (SourceProvider)localIterator1.next(); SourceProvider 
/*     */       
/* 201 */         tmp143_141 = sourceSet;Intrinsics.checkExpressionValueIsNotNull(tmp143_141, "sourceSet"); java.util.Collection tmp155_150 = tmp143_141.getResDirectories();Intrinsics.checkExpressionValueIsNotNull(tmp155_150, "sourceSet.resDirectories"); for (localIterator2 = CollectionsKt.withIndex((Iterable)tmp155_150).iterator(); localIterator2.hasNext();) { localObject1 = (IndexedValue)localIterator2.next();int index = ((IndexedValue)localObject1).component1();File resDirectory = (File)((IndexedValue)localObject1).component2();
/* 202 */         String sourceSetDirName = 
/* 203 */           "" + sourceSet.getName() + "" + (index + 1);
/* 204 */         File outputDir = new File(compiledDirectory, sourceSetDirName); String 
/* 205 */           tmp296_294 = sourceSetDirName;Intrinsics.checkExpressionValueIsNotNull(tmp296_294, "sourceSetDirName"); String 
/* 206 */           tmp324_319 = variantScope.getFullVariantName();Intrinsics.checkExpressionValueIsNotNull(tmp324_319, "variantScope.fullVariantName");String name = "compile" + StringsKt.capitalize(tmp296_294) + "ResourcesFor" + StringsKt.capitalize(tmp324_319); File 
/*     */         
/* 209 */           tmp355_353 = resDirectory;Intrinsics.checkExpressionValueIsNotNull(tmp355_353, "resDirectory"); File 
/*     */         
/* 212 */           tmp379_374 = variantScope.getIncrementalDir(name);Intrinsics.checkExpressionValueIsNotNull(tmp379_374, "variantScope.getIncrementalDir(name)"); Task tmp397_392 = taskFactory.create((TaskConfigAction)new CompileSourceSetResources.ConfigAction(name, tmp355_353, outputDir, variantScope, tmp379_374));Intrinsics.checkExpressionValueIsNotNull(tmp397_392, "taskFactory.create(Compi…getIncrementalDir(name)))");tasks.add(tmp397_392);
/* 213 */         directories.add(outputDir); } }
/*     */     SourceProvider sourceSet;
/*     */     Iterator localIterator2;
/* 216 */     GlobalScope tmp435_430 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp435_430, "variantScope.globalScope");ConfigurableFileCollection compiled = tmp435_430.getProject().files(new Object[] { directories });
/*     */     
/* 218 */     Iterable $receiver$iv = (Iterable)tasks;
/*     */     
/*     */     int $i$f$forEach;
/*     */     
/* 250 */     for (Object localObject1 = $receiver$iv.iterator(); ((Iterator)localObject1).hasNext();) { Object element$iv = ((Iterator)localObject1).next();Task it = (Task)element$iv;
/*     */       int $i$a$1$forEach;
/* 219 */       it.dependsOn(new Object[] { variantScope.getResourceGenTask() });
/* 220 */       compiled.builtBy(new Object[] { it });
/*     */     }
/* 222 */     variantScope.addTaskOutput(
/* 223 */       TaskOutputHolder.TaskOutputType.RES_COMPILED_FLAT_FILES, compiled, null);
/*     */   }
/*     */   
/*     */   private final void createLinkResourcesTask()
/*     */   {
/* 228 */     GradleVariantConfiguration tmp33_28 = variantScope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp33_28, "variantScope.variantConfiguration");File rDotTxt = new File(globalScope.getIntermediatesDir(), "symbols/" + tmp33_28.getDirName() + "/" + "R.txt"); GradleVariantConfiguration 
/*     */     
/* 232 */       tmp92_87 = variantScope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp92_87, "variantScope.variantConfiguration");{"res-linked" }[1] = tmp92_87.getDirName(); String[] tmp102_81 = tmp81_75;tmp102_81[
/* 233 */       2] = "res.apk";File resourceStaticLibrary = FileUtils.join(globalScope.getIntermediatesDir(), tmp102_81); GradleVariantConfiguration 
/*     */     
/* 236 */       tmp145_140 = variantScope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp145_140, "variantScope.variantConfiguration");File compileOnlyRClassSourceDir = new File(globalScope.getGeneratedDir(), "source/r/" + tmp145_140.getDirName()); File 
/*     */     
/* 239 */       tmp178_177 = resourceStaticLibrary;Intrinsics.checkExpressionValueIsNotNull(tmp178_177, "resourceStaticLibrary");LinkLibraryAndroidResourcesTask link = (LinkLibraryAndroidResourcesTask)taskFactory.create((TaskConfigAction)new LinkLibraryAndroidResourcesTask.ConfigAction(variantScope, compileOnlyRClassSourceDir, tmp178_177, rDotTxt)); LinkLibraryAndroidResourcesTask 
/*     */     
/* 243 */       tmp212_210 = link;Intrinsics.checkExpressionValueIsNotNull(tmp212_210, "link");variantScope.addTaskOutput(TaskOutputHolder.TaskOutputType.RES_STATIC_LIBRARY, resourceStaticLibrary, tmp212_210.getName());
/* 244 */     variantScope.addTaskOutput(
/* 245 */       TaskOutputHolder.TaskOutputType.SYMBOL_LIST, 
/* 246 */       rDotTxt, 
/* 247 */       link.getName());
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public final void createNamespacedResourceTasks(@NotNull File resPackageOutputFolder, @org.jetbrains.annotations.Nullable TaskOutputHolder.TaskOutputType packageOutputType, @NotNull String baseName, boolean useAaptToGenerateLegacyMultidexMainDexProguardRules)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 10
/*     */     //   3: invokestatic 16	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_3
/*     */     //   7: ldc 18
/*     */     //   9: invokestatic 16	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   12: aload_0
/*     */     //   13: getfield 22	com/android/build/gradle/internal/res/namespaced/NamespacedResourcesTaskManager:globalScope	Lcom/android/build/gradle/internal/scope/GlobalScope;
/*     */     //   16: invokevirtual 28	com/android/build/gradle/internal/scope/GlobalScope:getProjectOptions	()Lcom/android/build/gradle/options/ProjectOptions;
/*     */     //   19: invokestatic 34	com/android/build/gradle/internal/aapt/AaptGeneration:fromProjectOptions	(Lcom/android/build/gradle/options/ProjectOptions;)Lcom/android/build/gradle/internal/aapt/AaptGeneration;
/*     */     //   22: astore 5
/*     */     //   24: aload 5
/*     */     //   26: getstatic 38	com/android/build/gradle/internal/aapt/AaptGeneration:AAPT_V2_DAEMON_MODE	Lcom/android/build/gradle/internal/aapt/AaptGeneration;
/*     */     //   29: invokestatic 42	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   32: ldc 44
/*     */     //   34: iconst_0
/*     */     //   35: anewarray 4	java/lang/Object
/*     */     //   38: invokestatic 50	com/google/common/base/Preconditions:checkState	(ZLjava/lang/String;[Ljava/lang/Object;)V
/*     */     //   41: aload_0
/*     */     //   42: invokespecial 54	com/android/build/gradle/internal/res/namespaced/NamespacedResourcesTaskManager:createCompileResourcesTask	()V
/*     */     //   45: aload_0
/*     */     //   46: invokespecial 57	com/android/build/gradle/internal/res/namespaced/NamespacedResourcesTaskManager:createLinkResourcesTask	()V
/*     */     //   49: aload_0
/*     */     //   50: invokespecial 60	com/android/build/gradle/internal/res/namespaced/NamespacedResourcesTaskManager:createNamespacedLibraryRFiles	()V
/*     */     //   53: aload_0
/*     */     //   54: getfield 64	com/android/build/gradle/internal/res/namespaced/NamespacedResourcesTaskManager:variantScope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */     //   57: invokeinterface 70 1 0
/*     */     //   62: dup
/*     */     //   63: ldc 72
/*     */     //   65: invokestatic 75	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   68: invokevirtual 81	com/android/build/gradle/internal/variant/BaseVariantData:getType	()Lcom/android/builder/core/VariantType;
/*     */     //   71: getstatic 87	com/android/builder/core/VariantType:LIBRARY	Lcom/android/builder/core/VariantType;
/*     */     //   74: invokestatic 42	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   77: ifne +33 -> 110
/*     */     //   80: aload_0
/*     */     //   81: getfield 64	com/android/build/gradle/internal/res/namespaced/NamespacedResourcesTaskManager:variantScope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */     //   84: invokeinterface 90 1 0
/*     */     //   89: dup
/*     */     //   90: ifnull +9 -> 99
/*     */     //   93: invokevirtual 81	com/android/build/gradle/internal/variant/BaseVariantData:getType	()Lcom/android/builder/core/VariantType;
/*     */     //   96: goto +5 -> 101
/*     */     //   99: pop
/*     */     //   100: aconst_null
/*     */     //   101: getstatic 87	com/android/builder/core/VariantType:LIBRARY	Lcom/android/builder/core/VariantType;
/*     */     //   104: invokestatic 42	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   107: ifeq +12 -> 119
/*     */     //   110: aload_0
/*     */     //   111: aload_1
/*     */     //   112: aload_2
/*     */     //   113: invokespecial 94	com/android/build/gradle/internal/res/namespaced/NamespacedResourcesTaskManager:createNamespacedLibraryProcessResourcesTask	(Ljava/io/File;Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;)V
/*     */     //   116: goto +12 -> 128
/*     */     //   119: aload_0
/*     */     //   120: aload_1
/*     */     //   121: aload_2
/*     */     //   122: aload_3
/*     */     //   123: iload 4
/*     */     //   125: invokespecial 97	com/android/build/gradle/internal/res/namespaced/NamespacedResourcesTaskManager:createNamespacedAppProcessTask	(Ljava/io/File;Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;Ljava/lang/String;Z)V
/*     */     //   128: aload_0
/*     */     //   129: invokespecial 100	com/android/build/gradle/internal/res/namespaced/NamespacedResourcesTaskManager:createCompileRuntimeRClassTask	()V
/*     */     //   132: return
/*     */     // Line number table:
/*     */     //   Java source line #60	-> byte code offset #12
/*     */     //   Java source line #61	-> byte code offset #24
/*     */     //   Java source line #62	-> byte code offset #32
/*     */     //   Java source line #61	-> byte code offset #38
/*     */     //   Java source line #64	-> byte code offset #41
/*     */     //   Java source line #65	-> byte code offset #45
/*     */     //   Java source line #66	-> byte code offset #49
/*     */     //   Java source line #68	-> byte code offset #53
/*     */     //   Java source line #69	-> byte code offset #110
/*     */     //   Java source line #70	-> byte code offset #111
/*     */     //   Java source line #71	-> byte code offset #112
/*     */     //   Java source line #69	-> byte code offset #113
/*     */     //   Java source line #73	-> byte code offset #119
/*     */     //   Java source line #74	-> byte code offset #120
/*     */     //   Java source line #75	-> byte code offset #121
/*     */     //   Java source line #76	-> byte code offset #122
/*     */     //   Java source line #77	-> byte code offset #123
/*     */     //   Java source line #73	-> byte code offset #125
/*     */     //   Java source line #78	-> byte code offset #128
/*     */     //   Java source line #79	-> byte code offset #128
/*     */     //   Java source line #80	-> byte code offset #132
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	133	0	this	NamespacedResourcesTaskManager
/*     */     //   0	133	1	resPackageOutputFolder	File
/*     */     //   0	133	2	packageOutputType	TaskOutputHolder.TaskOutputType
/*     */     //   0	133	3	baseName	String
/*     */     //   0	133	4	useAaptToGenerateLegacyMultidexMainDexProguardRules	boolean
/*     */     //   24	109	5	aaptGeneration	com.android.build.gradle.internal.aapt.AaptGeneration
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.NamespacedResourcesTaskManager
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */