/*     */ package com.android.build.gradle.internal.res.namespaced;
/*     */ 
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.ide.common.res2.CompileResourceRequest;
/*     */ import com.android.ide.common.res2.FileStatus;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import java.io.File;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Consumer;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.workers.IsolationMode;
/*     */ import org.gradle.workers.WorkerConfiguration;
/*     */ import org.gradle.workers.WorkerExecutor;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000L\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\b\n\002\020\013\n\002\b\n\n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\020\002\n\002\b\002\n\002\020%\n\002\030\002\n\002\b\003\n\002\020 \n\002\b\003\b\026\030\0002\0020\001:\001)B\017\b\007\022\006\020\002\032\0020\003¢\006\002\020\004J\032\020\031\032\0020\0322\006\020\033\032\0020\0062\b\b\002\020\034\032\0020\035H\002J\b\020\036\032\0020\037H\024J\034\020 \032\0020\0372\022\020!\032\016\022\004\022\0020\006\022\004\022\0020#0\"H\024J\b\020$\032\0020\017H\024J\026\020%\032\0020\0372\f\020&\032\b\022\004\022\0020\0320'H\002J\020\020(\032\0020\0172\006\020\033\032\0020\006H\002R&\020\007\032\0020\0062\006\020\005\032\0020\0068\007@BX.¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R&\020\f\032\0020\0062\006\020\005\032\0020\0068\007@BX.¢\006\016\n\000\032\004\b\r\020\t\"\004\b\016\020\013R&\020\020\032\0020\0172\006\020\005\032\0020\0178\007@BX\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023R&\020\024\032\0020\0172\006\020\005\032\0020\0178\007@BX\016¢\006\016\n\000\032\004\b\024\020\021\"\004\b\025\020\023R&\020\026\032\0020\0062\006\020\005\032\0020\0068\007@BX.¢\006\016\n\000\032\004\b\027\020\t\"\004\b\030\020\013R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006*"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/CompileSourceSetResources;", "Lcom/android/build/gradle/internal/tasks/IncrementalTask;", "workerExecutor", "Lorg/gradle/workers/WorkerExecutor;", "(Lorg/gradle/workers/WorkerExecutor;)V", "<set-?>", "Ljava/io/File;", "aaptIntermediateDirectory", "getAaptIntermediateDirectory", "()Ljava/io/File;", "setAaptIntermediateDirectory", "(Ljava/io/File;)V", "inputDirectory", "getInputDirectory", "setInputDirectory", "", "isPngCrunching", "()Z", "setPngCrunching", "(Z)V", "isPseudoLocalize", "setPseudoLocalize", "outputDirectory", "getOutputDirectory", "setOutputDirectory", "compileRequest", "Lcom/android/ide/common/res2/CompileResourceRequest;", "file", "inputDirectoryName", "", "doFullTaskAction", "", "doIncrementalTaskAction", "changedInputs", "", "Lcom/android/ide/common/res2/FileStatus;", "isIncremental", "submit", "requests", "", "willCompile", "ConfigAction", "gradle-core"})
/*     */ public class CompileSourceSetResources
/*     */   extends com.android.build.gradle.internal.tasks.IncrementalTask
/*     */ {
/*     */   @NotNull
/*     */   private File inputDirectory;
/*     */   private boolean isPngCrunching;
/*     */   private boolean isPseudoLocalize;
/*     */   @NotNull
/*     */   private File outputDirectory;
/*     */   @NotNull
/*     */   private File aaptIntermediateDirectory;
/*     */   private final WorkerExecutor workerExecutor;
/*     */   
/*     */   @javax.inject.Inject
/*  40 */   public CompileSourceSetResources(@NotNull WorkerExecutor workerExecutor) { this.workerExecutor = workerExecutor; } @org.gradle.api.tasks.InputFiles
/*     */   @org.gradle.api.tasks.SkipWhenEmpty
/*     */   @NotNull
/*  42 */   public final File getInputDirectory() { File tmp4_1 = inputDirectory;
/*     */     
/*  42 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("inputDirectory"); return tmp4_1; } private final void setInputDirectory(File <set-?>) { inputDirectory = <set-?>; } @org.gradle.api.tasks.Input
/*  43 */   public final boolean isPngCrunching() { return isPngCrunching; } private final void setPngCrunching(boolean <set-?>) { isPngCrunching = <set-?>; } @org.gradle.api.tasks.Input
/*  44 */   public final boolean isPseudoLocalize() { return isPseudoLocalize; } private final void setPseudoLocalize(boolean <set-?>) { isPseudoLocalize = <set-?>; } @org.gradle.api.tasks.OutputDirectory
/*     */   @NotNull
/*  45 */   public final File getOutputDirectory() { File tmp4_1 = outputDirectory;
/*     */     
/*  45 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("outputDirectory"); return tmp4_1; } private final void setOutputDirectory(File <set-?>) { outputDirectory = <set-?>; } @org.gradle.api.tasks.OutputDirectory
/*     */   @NotNull
/*  46 */   public final File getAaptIntermediateDirectory() { File tmp4_1 = aaptIntermediateDirectory;
/*     */     
/*  46 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("aaptIntermediateDirectory"); return tmp4_1; } private final void setAaptIntermediateDirectory(File <set-?>) { aaptIntermediateDirectory = <set-?>; }
/*     */   
/*  48 */   protected boolean isIncremental() { return true; }
/*     */   
/*     */   protected void doFullTaskAction() {
/*  51 */     File tmp4_1 = outputDirectory;
/*     */     
/*  51 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("outputDirectory"); com.android.utils.FileUtils.cleanOutputDir(tmp4_1); File 
/*  52 */       tmp20_17 = inputDirectory;
/*  52 */     if (tmp20_17 == null) Intrinsics.throwUninitializedPropertyAccessException("inputDirectory"); if (!tmp20_17.isDirectory())
/*     */     {
/*  54 */       return;
/*     */     }
/*  56 */     final List requests = (List)new ArrayList(); File 
/*     */     
/*  59 */       tmp51_48 = inputDirectory;
/*     */     
/*  59 */     if (tmp51_48 == null) Intrinsics.throwUninitializedPropertyAccessException("inputDirectory"); Files.list(tmp51_48.toPath()).forEach((Consumer)new Consumer() {
/*  60 */       public final void accept(Path subDir) { if (Files.isDirectory(subDir, new java.nio.file.LinkOption[0]))
/*  61 */           Files.list(subDir).forEach((Consumer)new Consumer() {
/*  62 */             public final void accept(Path resFile) { if (Files.isRegularFile(resFile, new java.nio.file.LinkOption[0])) {
/*  63 */                 File tmp31_26 = resFile.toFile();Intrinsics.checkExpressionValueIsNotNull(tmp31_26, "resFile.toFile()");this$0.$requests.add(CompileSourceSetResources.compileRequest$default(this$0.this$0, tmp31_26, null, 2, null));
/*     */               }
/*     */             }
/*     */           });
/*     */       }
/*  68 */     });
/*  69 */     submit(requests);
/*     */   }
/*     */   
/*     */   protected void doIncrementalTaskAction(@NotNull Map<File, FileStatus> changedInputs) {
/*  73 */     Intrinsics.checkParameterIsNotNull(changedInputs, "changedInputs");final List requests = (List)new ArrayList();
/*  74 */     final List deletes = (List)new ArrayList();
/*     */     
/*  76 */     changedInputs.forEach((java.util.function.BiConsumer)new java.util.function.BiConsumer() {
/*  77 */       public final void accept(@NotNull File file, @NotNull FileStatus status) { Intrinsics.checkParameterIsNotNull(file, "file");Intrinsics.checkParameterIsNotNull(status, "status"); if (CompileSourceSetResources.access$willCompile(this$0, file)) { File tmp34_31 = file.getParentFile();Intrinsics.checkExpressionValueIsNotNull(tmp34_31, "file.parentFile"); if (Intrinsics.areEqual(this$0.getInputDirectory(), tmp34_31.getParentFile()))
/*  78 */             switch (CompileSourceSetResources.WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) {
/*     */             case 1: case 2: 
/*  80 */               requests.add(CompileSourceSetResources.compileRequest$default(this$0, file, null, 2, null)); break;
/*     */             
/*     */             case 3: 
/*  83 */               deletes.add(file);
/*     */             }
/*     */         }
/*     */       }
/*     */     });
/*  88 */     if (!deletes.isEmpty())
/*  89 */       workerExecutor.submit(Aapt2CompileDeleteRunnable.class, (Action)new Action() {
/*  90 */         public final void execute(WorkerConfiguration it) { WorkerConfiguration tmp1_0 = it;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "it");tmp1_0.setIsolationMode(IsolationMode.NONE);
/*  91 */           it.setParams(new Object[] { new Aapt2CompileDeleteRunnable.Params(
/*  92 */             this$0.getOutputDirectory(), 
/*  93 */             (Iterable)deletes) });
/*     */         }
/*     */       });
/*  96 */     submit(requests);
/*     */   }
/*     */   
/*     */   private final CompileResourceRequest compileRequest(File file, String inputDirectoryName)
/*     */   {
/* 102 */     File tmp9_6 = outputDirectory;
/*     */     
/* 102 */     if (tmp9_6 == null) { Intrinsics.throwUninitializedPropertyAccessException("outputDirectory");
/*     */     }
/*     */     
/* 105 */     return new CompileResourceRequest(file, tmp9_6, inputDirectoryName, isPseudoLocalize, isPngCrunching);
/*     */   }
/*     */   
/* 108 */   private final void submit(List<CompileResourceRequest> requests) { if (requests.isEmpty()) {
/* 109 */       return;
/*     */     }
/* 111 */     for (final CompileResourceRequest request : requests) {
/* 112 */       workerExecutor.submit(Aapt2CompileRunnable.class, (Action)new Action() {
/* 113 */         public final void execute(WorkerConfiguration it) { WorkerConfiguration tmp1_0 = it;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "it");tmp1_0.setIsolationMode(IsolationMode.NONE); Object[] 
/* 114 */             tmp20_17 = new Object[1]; com.android.builder.core.AndroidBuilder 
/* 115 */             tmp33_30 = CompileSourceSetResources.access$getBuilder(this$0);Intrinsics.checkExpressionValueIsNotNull(tmp33_30, "builder"); BuildToolInfo tmp42_39 = tmp33_30.getBuildToolInfo();Intrinsics.checkExpressionValueIsNotNull(tmp42_39, "builder.buildToolInfo"); com.android.repository.Revision tmp51_48 = tmp42_39.getRevision();Intrinsics.checkExpressionValueIsNotNull(tmp51_48, "builder.buildToolInfo.revision");tmp20_17[0] = new Aapt2CompileRunnable.Params(tmp51_48, 
/* 116 */             kotlin.collections.CollectionsKt.listOf(request), 
/* 117 */             this$0.getOutputDirectory());it.setParams(tmp20_17);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   private final boolean willCompile(File file)
/*     */   {
/* 123 */     String tmp4_1 = file.getName();Intrinsics.checkExpressionValueIsNotNull(tmp4_1, "file.name");return (!kotlin.text.StringsKt.startsWith$default(tmp4_1, ".", false, 2, null)) && (!file.isDirectory()); }
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\003\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B-\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006\022\006\020\b\032\0020\t\022\006\020\n\032\0020\006¢\006\002\020\013J\020\020\f\032\0020\r2\006\020\016\032\0020\002H\026J\b\020\017\032\0020\004H\026J\016\020\020\032\b\022\004\022\0020\0020\021H\026R\016\020\n\032\0020\006X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000¨\006\022"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/CompileSourceSetResources$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/namespaced/CompileSourceSetResources;", "name", "", "inputDirectory", "Ljava/io/File;", "outputDirectory", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "aaptIntermediateDirectory", "(Ljava/lang/String;Ljava/io/File;Ljava/io/File;Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;)V", "execute", "", "task", "getName", "getType", "Ljava/lang/Class;", "gradle-core"})
/* 125 */   public static final class ConfigAction implements com.android.build.gradle.internal.scope.TaskConfigAction<CompileSourceSetResources> { public ConfigAction(@NotNull String name, @NotNull File inputDirectory, @NotNull File outputDirectory, @NotNull VariantScope variantScope, @NotNull File aaptIntermediateDirectory) { this.name = name;this.inputDirectory = inputDirectory;this.outputDirectory = outputDirectory;this.variantScope = variantScope;this.aaptIntermediateDirectory = aaptIntermediateDirectory; }
/*     */     
/*     */     private final String name;
/*     */     private final File inputDirectory;
/*     */     
/*     */     @NotNull
/* 131 */     public String getName() { return name; } @NotNull
/* 132 */     public Class<CompileSourceSetResources> getType() { return CompileSourceSetResources.class; }
/*     */     
/* 134 */     public void execute(@NotNull CompileSourceSetResources task) { Intrinsics.checkParameterIsNotNull(task, "task");CompileSourceSetResources.access$setInputDirectory$p(task, inputDirectory);
/* 135 */       CompileSourceSetResources.access$setOutputDirectory$p(task, outputDirectory);
/* 136 */       task.setVariantName(variantScope.getFullVariantName());
/* 137 */       CompileSourceSetResources.access$setPngCrunching$p(task, variantScope.isCrunchPngs()); BaseVariantData 
/* 138 */         tmp58_53 = variantScope.getVariantData();Intrinsics.checkExpressionValueIsNotNull(tmp58_53, "variantScope.variantData"); com.android.build.gradle.internal.core.GradleVariantConfiguration tmp67_64 = tmp58_53.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp67_64, "variantScope.variantData.variantConfiguration"); CoreBuildType tmp79_76 = ((CoreBuildType)tmp67_64.getBuildType());Intrinsics.checkExpressionValueIsNotNull(tmp79_76, "variantScope.variantData…ntConfiguration.buildType");CompileSourceSetResources.access$setPseudoLocalize$p(task, tmp79_76.isPseudoLocalesEnabled());
/* 139 */       CompileSourceSetResources.access$setAaptIntermediateDirectory$p(task, aaptIntermediateDirectory); com.android.build.gradle.internal.scope.GlobalScope 
/* 140 */         tmp111_106 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp111_106, "variantScope.globalScope");task.setAndroidBuilder(tmp111_106.getAndroidBuilder());
/*     */     }
/*     */     
/*     */     private final File outputDirectory;
/*     */     private final VariantScope variantScope;
/*     */     private final File aaptIntermediateDirectory;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.CompileSourceSetResources
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */