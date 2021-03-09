/*     */ package com.android.build.gradle.internal.res;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.ide.common.symbols.SymbolTable;
/*     */ import java.io.File;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ import org.gradle.api.tasks.OutputFile;
/*     */ import org.gradle.api.tasks.PathSensitivity;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @org.gradle.api.tasks.CacheableTask
/*     */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000:\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\005\n\002\030\002\n\002\b\006\n\002\020\013\n\002\b\f\n\002\030\002\n\002\b\022\n\002\020\002\n\000\n\002\030\002\n\002\b\007\b\027\030\0002\0020\001:\0019B\005¢\006\002\020\002J\b\0200\032\00201H\025J\030\0202\032\n 4*\004\030\00103032\006\0205\032\0020\036H\002J\n\0206\032\004\030\0010\036H\026J\b\0207\032\0020\021H\007J\b\0208\032\0020\021H\007R&\020\005\032\0020\0042\006\020\003\032\0020\0048\007@BX.¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR&\020\013\032\0020\n2\006\020\003\032\0020\n8\007@BX.¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\032\020\020\032\0020\0218CX\004¢\006\f\022\004\b\022\020\002\032\004\b\023\020\024R\034\020\025\032\0020\n8\007X.¢\006\016\n\000\032\004\b\026\020\r\"\004\b\027\020\017R&\020\030\032\0020\0042\006\020\003\032\0020\0048\007@BX.¢\006\016\n\000\032\004\b\031\020\007\"\004\b\032\020\tR&\020\033\032\0020\n2\006\020\003\032\0020\n8\007@BX.¢\006\016\n\000\032\004\b\034\020\r\"\004\b\035\020\017R*\020\037\032\004\030\0010\0362\b\020\003\032\004\030\0010\0368\007@BX\016¢\006\016\n\000\032\004\b \020!\"\004\b\"\020#R*\020$\032\004\030\0010\0362\b\020\003\032\004\030\0010\0368\007@BX\016¢\006\016\n\000\032\004\b%\020!\"\004\b&\020#R*\020'\032\004\030\0010\0362\b\020\003\032\004\030\0010\0368\007@BX\016¢\006\016\n\000\032\004\b(\020!\"\004\b)\020#R&\020*\032\0020\0362\006\020\003\032\0020\0368\007@BX.¢\006\016\n\000\032\004\b+\020!\"\004\b,\020#R&\020-\032\0020\0362\006\020\003\032\0020\0368\007@BX.¢\006\016\n\000\032\004\b.\020!\"\004\b/\020#¨\006:"}, d2={"Lcom/android/build/gradle/internal/res/GenerateLibraryRFileTask;", "Lcom/android/build/gradle/tasks/ProcessAndroidResources;", "()V", "<set-?>", "", "applicationId", "getApplicationId", "()Ljava/lang/String;", "setApplicationId", "(Ljava/lang/String;)V", "Lorg/gradle/api/file/FileCollection;", "dependencies", "getDependencies", "()Lorg/gradle/api/file/FileCollection;", "setDependencies", "(Lorg/gradle/api/file/FileCollection;)V", "hasProguardOutputFile", "", "hasProguardOutputFile$annotations", "getHasProguardOutputFile", "()Z", "inputResourcesDir", "getInputResourcesDir", "setInputResourcesDir", "packageForR", "getPackageForR", "setPackageForR", "platformAttrRTxt", "getPlatformAttrRTxt", "setPlatformAttrRTxt", "Ljava/io/File;", "proguardOutputFile", "getProguardOutputFile", "()Ljava/io/File;", "setProguardOutputFile", "(Ljava/io/File;)V", "rClassOutputJar", "getRClassOutputJar", "setRClassOutputJar", "sourceOutputDirectory", "getSourceOutputDirectory", "setSourceOutputDirectory", "symbolsWithPackageNameOutputFile", "getSymbolsWithPackageNameOutputFile", "setSymbolsWithPackageNameOutputFile", "textSymbolOutputFile", "getTextSymbolOutputFile", "setTextSymbolOutputFile", "doFullTaskAction", "", "getAndroidAttrSymbols", "Lcom/android/ide/common/symbols/SymbolTable;", "kotlin.jvm.PlatformType", "androidJar", "getSourceOutputDir", "outputRClassJar", "outputSources", "ConfigAction", "gradle-core"})
/*     */ public class GenerateLibraryRFileTask
/*     */   extends com.android.build.gradle.tasks.ProcessAndroidResources
/*     */ {
/*     */   @Nullable
/*     */   private File sourceOutputDirectory;
/*     */   @Nullable
/*     */   private File rClassOutputJar;
/*     */   @NotNull
/*     */   private File textSymbolOutputFile;
/*     */   @NotNull
/*     */   private File symbolsWithPackageNameOutputFile;
/*     */   @Nullable
/*     */   private File proguardOutputFile;
/*     */   @NotNull
/*     */   private FileCollection dependencies;
/*     */   @NotNull
/*     */   private String packageForR;
/*     */   @NotNull
/*     */   private FileCollection platformAttrRTxt;
/*     */   @NotNull
/*     */   private String applicationId;
/*     */   @NotNull
/*     */   public FileCollection inputResourcesDir;
/*     */   
/*     */   @org.gradle.api.tasks.OutputDirectory
/*     */   @Optional
/*     */   @Nullable
/*  50 */   public final File getSourceOutputDirectory() { return sourceOutputDirectory; } private final void setSourceOutputDirectory(File <set-?>) { sourceOutputDirectory = <set-?>; } @Input
/*  51 */   public final boolean outputSources() { return sourceOutputDirectory != null; } @OutputFile
/*     */   @Optional
/*     */   @Nullable
/*  53 */   public final File getRClassOutputJar() { return rClassOutputJar; } private final void setRClassOutputJar(File <set-?>) { rClassOutputJar = <set-?>; } @Input
/*  54 */   public final boolean outputRClassJar() { return rClassOutputJar != null; }
/*     */   
/*     */   @OutputFile
/*     */   @NotNull
/*  58 */   public final File getTextSymbolOutputFile() { File tmp4_1 = textSymbolOutputFile;
/*     */     
/*  58 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("textSymbolOutputFile"); return tmp4_1; } private final void setTextSymbolOutputFile(File <set-?>) { textSymbolOutputFile = <set-?>; }
/*     */   @OutputFile
/*     */   @NotNull
/*  61 */   public final File getSymbolsWithPackageNameOutputFile() { File tmp4_1 = symbolsWithPackageNameOutputFile;
/*     */     
/*  61 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("symbolsWithPackageNameOutputFile"); return tmp4_1; } private final void setSymbolsWithPackageNameOutputFile(File <set-?>) { symbolsWithPackageNameOutputFile = <set-?>; }
/*     */   
/*     */   @OutputFile
/*     */   @Optional
/*     */   @Nullable
/*  66 */   public final File getProguardOutputFile() { return proguardOutputFile; } private final void setProguardOutputFile(File <set-?>) { proguardOutputFile = <set-?>; }
/*     */   
/*     */   @Input
/*  72 */   private final boolean getHasProguardOutputFile() { return proguardOutputFile != null; } @InputFiles
/*     */   @org.gradle.api.tasks.PathSensitive(PathSensitivity.NONE)
/*     */   @NotNull
/*  75 */   public final FileCollection getDependencies() { FileCollection tmp4_1 = dependencies;
/*     */     
/*  75 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("dependencies"); return tmp4_1; } private final void setDependencies(FileCollection <set-?>) { dependencies = <set-?>; }
/*     */   @Input
/*     */   @NotNull
/*  78 */   public final String getPackageForR() { String tmp4_1 = packageForR;
/*     */     
/*  78 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("packageForR"); return tmp4_1; } private final void setPackageForR(String <set-?>) { packageForR = <set-?>; }
/*     */   @InputFiles
/*     */   @org.gradle.api.tasks.PathSensitive(PathSensitivity.NAME_ONLY)
/*     */   @NotNull
/*  82 */   public final FileCollection getPlatformAttrRTxt() { FileCollection tmp4_1 = platformAttrRTxt;
/*     */     
/*  82 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("platformAttrRTxt"); return tmp4_1; } private final void setPlatformAttrRTxt(FileCollection <set-?>) { platformAttrRTxt = <set-?>; }
/*     */   @Input
/*     */   @NotNull
/*  85 */   public final String getApplicationId() { String tmp4_1 = applicationId;
/*     */     
/*  85 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("applicationId"); return tmp4_1; } private final void setApplicationId(String <set-?>) { applicationId = <set-?>; }
/*     */   
/*     */   @InputFiles
/*     */   @org.gradle.api.tasks.PathSensitive(PathSensitivity.RELATIVE)
/*     */   @NotNull
/*  90 */   public final FileCollection getInputResourcesDir() { FileCollection tmp4_1 = inputResourcesDir;
/*     */     
/*  90 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("inputResourcesDir"); return tmp4_1; } public final void setInputResourcesDir(@NotNull FileCollection <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");inputResourcesDir = <set-?>;
/*     */   }
/*     */   
/*     */   protected void doFullTaskAction() throws java.io.IOException
/*     */   {
/*  95 */     FileCollection tmp13_10 = manifestFiles;Intrinsics.checkExpressionValueIsNotNull(tmp13_10, "manifestFiles"); Object tmp28_25 = com.google.common.collect.Iterables.getOnlyElement((Iterable)com.android.build.gradle.internal.scope.ExistingBuildElements.Companion.from((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS, tmp13_10));Intrinsics.checkExpressionValueIsNotNull(tmp28_25, "Iterables.getOnlyElement…ANIFESTS, manifestFiles))");File manifest = ((com.android.build.gradle.internal.scope.BuildOutput)tmp28_25).getOutputFile(); FileCollection 
/*     */     
/*  98 */       tmp46_43 = platformAttrRTxt;
/*     */     
/*  98 */     if (tmp46_43 == null) Intrinsics.throwUninitializedPropertyAccessException("platformAttrRTxt"); File tmp60_55 = tmp46_43.getSingleFile();Intrinsics.checkExpressionValueIsNotNull(tmp60_55, "platformAttrRTxt.singleFile");SymbolTable androidAttrSymbol = getAndroidAttrSymbols(tmp60_55); FileCollection 
/*     */     
/* 101 */       tmp74_71 = inputResourcesDir;
/*     */     
/* 101 */     if (tmp74_71 == null) Intrinsics.throwUninitializedPropertyAccessException("inputResourcesDir");
/* 100 */     SymbolTable symbolTable = com.android.ide.common.symbols.ResourceDirectoryParser.parseDirectory(
/* 101 */       tmp74_71.getSingleFile(), 
/* 102 */       com.android.ide.common.symbols.IdProvider.sequential(), 
/* 103 */       androidAttrSymbol); SymbolTable 
/*     */     
/* 106 */       tmp97_96 = symbolTable;Intrinsics.checkExpressionValueIsNotNull(tmp97_96, "symbolTable"); FileCollection 
/* 107 */       tmp107_104 = dependencies;
/* 107 */     if (tmp107_104 == null) Intrinsics.throwUninitializedPropertyAccessException("dependencies"); java.util.Set tmp121_116 = tmp107_104.getFiles();Intrinsics.checkExpressionValueIsNotNull(tmp121_116, "this.dependencies.files"); String 
/* 108 */       tmp131_128 = packageForR;
/* 108 */     if (tmp131_128 == null) Intrinsics.throwUninitializedPropertyAccessException("packageForR");
/* 109 */     File tmp141_140 = manifest;Intrinsics.checkExpressionValueIsNotNull(tmp141_140, "manifest"); File 
/*     */     
/* 112 */       tmp159_156 = textSymbolOutputFile;
/*     */     
/* 112 */     if (tmp159_156 == null) { Intrinsics.throwUninitializedPropertyAccessException("textSymbolOutputFile");
/*     */     }
/* 114 */     FileCollection tmp176_173 = inputResourcesDir;
/*     */     
/* 114 */     if (tmp176_173 == null) Intrinsics.throwUninitializedPropertyAccessException("inputResourcesDir");
/* 115 */     SymbolTable tmp191_190 = androidAttrSymbol;Intrinsics.checkExpressionValueIsNotNull(tmp191_190, "androidAttrSymbol");com.android.builder.symbols.SymbolExportUtils.processLibraryMainSymbolTable(tmp97_96, tmp121_116, tmp131_128, tmp141_140, sourceOutputDirectory, rClassOutputJar, tmp159_156, proguardOutputFile, tmp176_173.getSingleFile(), tmp191_190, 
/* 116 */       true); File 
/*     */     
/* 119 */       tmp205_202 = textSymbolOutputFile;
/*     */     
/* 119 */     if (tmp205_202 == null) { Intrinsics.throwUninitializedPropertyAccessException("textSymbolOutputFile");
/*     */     }
/* 121 */     File tmp225_222 = symbolsWithPackageNameOutputFile;
/*     */     
/* 121 */     if (tmp225_222 == null) Intrinsics.throwUninitializedPropertyAccessException("symbolsWithPackageNameOutputFile");
/* 118 */     com.android.ide.common.symbols.SymbolIo.writeSymbolTableWithPackage(
/* 119 */       tmp205_202.toPath(), 
/* 120 */       manifest.toPath(), 
/* 121 */       tmp225_222.toPath());
/*     */   }
/*     */   
/*     */   private final SymbolTable getAndroidAttrSymbols(File androidJar)
/*     */   {
/* 128 */     return androidJar.exists() ? com.android.ide.common.symbols.SymbolIo.read(androidJar, "android") : SymbolTable.Companion.builder().tablePackage("android").build();
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @Nullable
/*     */   public File getSourceOutputDir()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 14	com/android/build/gradle/internal/res/GenerateLibraryRFileTask:sourceOutputDirectory	Ljava/io/File;
/*     */     //   4: dup
/*     */     //   5: ifnull +6 -> 11
/*     */     //   8: goto +8 -> 16
/*     */     //   11: pop
/*     */     //   12: aload_0
/*     */     //   13: getfield 27	com/android/build/gradle/internal/res/GenerateLibraryRFileTask:rClassOutputJar	Ljava/io/File;
/*     */     //   16: areturn
/*     */     // Line number table:
/*     */     //   Java source line #56	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	17	0	this	GenerateLibraryRFileTask
/*     */   }
/*     */   
/*     */   @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006¢\006\002\020\bJ\020\020\t\032\0020\n2\006\020\013\032\0020\002H\026J\b\020\f\032\0020\rH\026J\016\020\016\032\b\022\004\022\0020\0020\017H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\020"}, d2={"Lcom/android/build/gradle/internal/res/GenerateLibraryRFileTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/GenerateLibraryRFileTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "symbolFile", "Ljava/io/File;", "symbolsWithPackageNameOutputFile", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;Ljava/io/File;)V", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */   public static final class ConfigAction
/*     */     implements com.android.build.gradle.internal.scope.TaskConfigAction<GenerateLibraryRFileTask>
/*     */   {
/*     */     private final VariantScope variantScope;
/*     */     private final File symbolFile;
/*     */     private final File symbolsWithPackageNameOutputFile;
/*     */     
/*     */     public ConfigAction(@NotNull VariantScope variantScope, @NotNull File symbolFile, @NotNull File symbolsWithPackageNameOutputFile)
/*     */     {
/* 132 */       this.variantScope = variantScope;this.symbolFile = symbolFile;this.symbolsWithPackageNameOutputFile = symbolsWithPackageNameOutputFile;
/*     */     }
/*     */     
/*     */     @NotNull
/* 138 */     public String getName() { return variantScope.getTaskName("generate", "RFile"); }
/*     */     @NotNull
/* 140 */     public Class<GenerateLibraryRFileTask> getType() { return GenerateLibraryRFileTask.class; }
/*     */     
/*     */     public void execute(@NotNull GenerateLibraryRFileTask task) {
/* 143 */       Intrinsics.checkParameterIsNotNull(task, "task");variantScope.getVariantData().addTask(com.android.build.gradle.internal.variant.TaskContainer.TaskKind.PROCESS_ANDROID_RESOURCES, (org.gradle.api.Task)task);
/*     */       
/* 145 */       task.setVariantName(variantScope.getFullVariantName()); FileCollection 
/*     */       
/* 149 */         tmp57_54 = variantScope.getGlobalScope().getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.PLATFORM_R_TXT);Intrinsics.checkExpressionValueIsNotNull(tmp57_54, "variantScope\n           …utputType.PLATFORM_R_TXT)");GenerateLibraryRFileTask.access$setPlatformAttrRTxt$p(task, tmp57_54); BaseVariantData 
/*     */       
/* 151 */         tmp76_71 = variantScope.getVariantData();Intrinsics.checkExpressionValueIsNotNull(tmp76_71, "variantScope.variantData"); GradleVariantConfiguration tmp85_82 = tmp76_71.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp85_82, "variantScope.variantData.variantConfiguration"); String tmp94_91 = tmp85_82.getApplicationId();Intrinsics.checkExpressionValueIsNotNull(tmp94_91, "variantScope.variantData…nfiguration.applicationId");GenerateLibraryRFileTask.access$setApplicationId$p(task, tmp94_91); FileCollection 
/*     */       
/* 153 */         tmp122_117 = variantScope.getArtifactFileCollection(
/* 154 */         com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, 
/* 155 */         com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope.ALL, 
/* 156 */         com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType.SYMBOL_LIST_WITH_PACKAGE_NAME);Intrinsics.checkExpressionValueIsNotNull(tmp122_117, "variantScope.getArtifact…L_LIST_WITH_PACKAGE_NAME)");GenerateLibraryRFileTask.access$setDependencies$p(task, tmp122_117); com.android.build.gradle.internal.scope.GlobalScope 
/* 157 */         tmp140_135 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp140_135, "variantScope.globalScope"); if (tmp140_135.getProjectOptions().get(com.android.build.gradle.options.BooleanOption.ENABLE_SEPARATE_R_CLASS_COMPILATION)) {
/* 158 */         File rJar = new File(variantScope.getIntermediateDir(TaskOutputHolder.TaskOutputType.COMPILE_ONLY_NOT_NAMESPACED_R_CLASS_JAR), "R.jar");
/* 159 */         GenerateLibraryRFileTask.access$setRClassOutputJar$p(task, rJar);
/* 160 */         variantScope.addTaskOutput(
/* 161 */           TaskOutputHolder.TaskOutputType.COMPILE_ONLY_NOT_NAMESPACED_R_CLASS_JAR, 
/* 162 */           rJar, 
/* 163 */           task.getName());
/*     */       } else {
/* 165 */         File sourceOutputDirectory = variantScope.getRClassSourceOutputDir();
/* 166 */         GenerateLibraryRFileTask.access$setSourceOutputDirectory$p(task, sourceOutputDirectory);
/* 167 */         variantScope.addTaskOutput(
/* 168 */           TaskOutputHolder.TaskOutputType.NOT_NAMESPACED_R_CLASS_SOURCES, 
/* 169 */           sourceOutputDirectory, 
/* 170 */           task.getName());
/*     */       }
/* 172 */       GenerateLibraryRFileTask.access$setTextSymbolOutputFile$p(task, symbolFile);
/* 173 */       GenerateLibraryRFileTask.access$setSymbolsWithPackageNameOutputFile$p(task, symbolsWithPackageNameOutputFile);
/*     */       
/* 175 */       if (variantScope.getCodeShrinker() != null) {
/* 176 */         GenerateLibraryRFileTask.access$setProguardOutputFile$p(task, variantScope.getProcessAndroidResourcesProguardOutputFile());
/*     */       }
/*     */       
/* 179 */       GradleVariantConfiguration tmp290_285 = variantScope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp290_285, "variantScope.variantConfiguration"); String tmp302_299 = com.google.common.base.Strings.nullToEmpty(tmp290_285.getOriginalApplicationId());Intrinsics.checkExpressionValueIsNotNull(tmp302_299, "Strings.nullToEmpty(vari…on.originalApplicationId)");GenerateLibraryRFileTask.access$setPackageForR$p(task, tmp302_299);
/*     */       
/* 181 */       GenerateLibraryRFileTask.access$setManifestFiles$p(task, variantScope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS)); FileCollection 
/*     */       
/* 183 */         tmp346_341 = variantScope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.PACKAGED_RES);Intrinsics.checkExpressionValueIsNotNull(tmp346_341, "variantScope.getOutput(T…kOutputType.PACKAGED_RES)");task.setInputResourcesDir(tmp346_341);
/*     */       
/* 185 */       GenerateLibraryRFileTask.access$setOutputScope$p(task, variantScope.getOutputScope());
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.GenerateLibraryRFileTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */