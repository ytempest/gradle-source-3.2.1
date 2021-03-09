/*     */ package com.android.build.gradle.internal.tasks.databinding;
/*     */ 
/*     */ import android.databinding.tool.BaseDataBinder;
/*     */ import android.databinding.tool.DataBindingBuilder.GradleFileWriter;
/*     */ import android.databinding.tool.store.LayoutInfoInput.Args;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.options.BooleanOption;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.utils.FileUtils;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.DefaultTask;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.gradle.api.tasks.incremental.IncrementalTaskInputs;
/*     */ import org.gradle.api.tasks.incremental.InputFileDetails;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\b\n\002\030\002\n\002\b\005\n\002\020\016\n\002\b\f\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\003\b\026\030\0002\0020\001:\002+,B\005¢\006\002\020\002J\020\020%\032\0020&2\006\020'\032\0020(H\002J\020\020)\032\0020*2\006\020'\032\0020(H\007R&\020\005\032\0020\0042\006\020\003\032\0020\0048\007@BX.¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR&\020\013\032\0020\n2\006\020\003\032\0020\n8\007@BX\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R&\020\020\032\0020\0042\006\020\003\032\0020\0048\007@BX.¢\006\016\n\000\032\004\b\021\020\007\"\004\b\022\020\tR&\020\024\032\0020\0232\006\020\003\032\0020\0238\007@BX.¢\006\016\n\000\032\004\b\025\020\026\"\004\b\027\020\030R&\020\032\032\0020\0312\006\020\003\032\0020\0318\007@BX.¢\006\016\n\000\032\004\b\033\020\034\"\004\b\035\020\036R&\020\037\032\0020\0042\006\020\003\032\0020\0048\007@BX.¢\006\016\n\000\032\004\b \020\007\"\004\b!\020\tR&\020\"\032\0020\0042\006\020\003\032\0020\0048\007@BX.¢\006\016\n\000\032\004\b#\020\007\"\004\b$\020\t¨\006-"}, d2={"Lcom/android/build/gradle/internal/tasks/databinding/DataBindingGenBaseClassesTask;", "Lorg/gradle/api/DefaultTask;", "()V", "<set-?>", "Ljava/io/File;", "classInfoBundleDir", "getClassInfoBundleDir", "()Ljava/io/File;", "setClassInfoBundleDir", "(Ljava/io/File;)V", "", "generateSources", "getGenerateSources", "()Z", "setGenerateSources", "(Z)V", "logOutFolder", "getLogOutFolder", "setLogOutFolder", "Lorg/gradle/api/file/FileCollection;", "mergedArtifactsFromDependencies", "getMergedArtifactsFromDependencies", "()Lorg/gradle/api/file/FileCollection;", "setMergedArtifactsFromDependencies", "(Lorg/gradle/api/file/FileCollection;)V", "", "packageName", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "sourceOutFolder", "getSourceOutFolder", "setSourceOutFolder", "xmlInfoFolder", "getXmlInfoFolder", "setXmlInfoFolder", "buildInputArgs", "Landroid/databinding/tool/store/LayoutInfoInput$Args;", "inputs", "Lorg/gradle/api/tasks/incremental/IncrementalTaskInputs;", "writeBaseClasses", "", "CodeGenerator", "ConfigAction", "gradle-core"})
/*     */ public class DataBindingGenBaseClassesTask extends DefaultTask
/*     */ {
/*     */   @NotNull
/*     */   private File xmlInfoFolder;
/*     */   @NotNull
/*     */   private String packageName;
/*     */   @NotNull
/*     */   private FileCollection mergedArtifactsFromDependencies;
/*     */   @NotNull
/*     */   private File logOutFolder;
/*     */   private boolean generateSources;
/*     */   @NotNull
/*     */   private File sourceOutFolder;
/*     */   @NotNull
/*     */   private File classInfoBundleDir;
/*     */   
/*     */   @org.gradle.api.tasks.InputDirectory
/*     */   @NotNull
/*     */   public final File getXmlInfoFolder()
/*     */   {
/*  53 */     File tmp4_1 = xmlInfoFolder;
/*     */     
/*  53 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("xmlInfoFolder"); return tmp4_1; } private final void setXmlInfoFolder(File <set-?>) { xmlInfoFolder = <set-?>; }
/*     */   @Input
/*     */   @NotNull
/*  56 */   public final String getPackageName() { String tmp4_1 = packageName;
/*     */     
/*  56 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("packageName"); return tmp4_1; } private final void setPackageName(String <set-?>) { packageName = <set-?>; }
/*     */   @InputFiles
/*     */   @NotNull
/*  59 */   public final FileCollection getMergedArtifactsFromDependencies() { FileCollection tmp4_1 = mergedArtifactsFromDependencies;
/*     */     
/*  59 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("mergedArtifactsFromDependencies"); return tmp4_1; } private final void setMergedArtifactsFromDependencies(FileCollection <set-?>) { mergedArtifactsFromDependencies = <set-?>; }
/*     */   @OutputDirectory
/*     */   @NotNull
/*  62 */   public final File getLogOutFolder() { File tmp4_1 = logOutFolder;
/*     */     
/*  62 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("logOutFolder"); return tmp4_1; } private final void setLogOutFolder(File <set-?>) { logOutFolder = <set-?>; }
/*     */   
/*     */   @Input
/*  67 */   public final boolean getGenerateSources() { return generateSources; } private final void setGenerateSources(boolean <set-?>) { generateSources = <set-?>; }
/*     */   @OutputDirectory
/*     */   @NotNull
/*  70 */   public final File getSourceOutFolder() { File tmp4_1 = sourceOutFolder;
/*     */     
/*  70 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("sourceOutFolder"); return tmp4_1; } private final void setSourceOutFolder(File <set-?>) { sourceOutFolder = <set-?>; } @OutputDirectory
/*     */   @NotNull
/*  72 */   public final File getClassInfoBundleDir() { File tmp4_1 = classInfoBundleDir;
/*     */     
/*  72 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("classInfoBundleDir"); return tmp4_1; } private final void setClassInfoBundleDir(File <set-?>) { classInfoBundleDir = <set-?>; }
/*     */   
/*     */   @org.gradle.api.tasks.TaskAction
/*     */   public final void writeBaseClasses(@NotNull IncrementalTaskInputs inputs)
/*     */   {
/*  77 */     Intrinsics.checkParameterIsNotNull(inputs, "inputs"); if (generateSources)
/*     */     {
/*  82 */       LayoutInfoInput.Args args = buildInputArgs(inputs); File 
/*  83 */         tmp28_25 = sourceOutFolder;
/*  83 */       if (tmp28_25 == null) Intrinsics.throwUninitializedPropertyAccessException("sourceOutFolder"); new CodeGenerator(args, tmp28_25).run();
/*     */     } else {
/*  85 */       File tmp50_47 = sourceOutFolder;
/*     */       
/*  85 */       if (tmp50_47 == null) Intrinsics.throwUninitializedPropertyAccessException("sourceOutFolder"); FileUtils.cleanOutputDir(tmp50_47); File 
/*  86 */         tmp66_63 = logOutFolder;
/*  86 */       if (tmp66_63 == null) Intrinsics.throwUninitializedPropertyAccessException("logOutFolder"); FileUtils.cleanOutputDir(tmp66_63);
/*     */     }
/*     */   }
/*     */   
/*     */   private final LayoutInfoInput.Args buildInputArgs(IncrementalTaskInputs inputs) {
/*  91 */     final ArrayList outOfDate = new ArrayList();
/*  92 */     final ArrayList removed = new ArrayList();
/*     */     
/*  95 */     if (inputs.isIncremental()) {
/*  96 */       inputs.outOfDate((Action)new Action() {
/*  97 */         public final void execute(InputFileDetails inputFileDetails) { InputFileDetails tmp1_0 = inputFileDetails;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "inputFileDetails"); if (FileUtils.isFileInDirectory(tmp1_0.getFile(), 
/*  98 */             this$0.getXmlInfoFolder())) { File tmp31_26 = inputFileDetails.getFile();Intrinsics.checkExpressionValueIsNotNull(tmp31_26, "inputFileDetails.file"); String tmp40_37 = tmp31_26.getName();Intrinsics.checkExpressionValueIsNotNull(tmp40_37, "inputFileDetails.file.name"); if (StringsKt.endsWith$default(tmp40_37, ".xml", false, 2, null))
/*  99 */               outOfDate.add(inputFileDetails.getFile());
/*     */           }
/* 101 */         } });
/* 102 */       inputs.removed((Action)new Action() {
/* 103 */         public final void execute(InputFileDetails inputFileDetails) { InputFileDetails tmp1_0 = inputFileDetails;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "inputFileDetails"); if (FileUtils.isFileInDirectory(tmp1_0.getFile(), 
/* 104 */             this$0.getXmlInfoFolder())) { File tmp31_26 = inputFileDetails.getFile();Intrinsics.checkExpressionValueIsNotNull(tmp31_26, "inputFileDetails.file"); String tmp40_37 = tmp31_26.getName();Intrinsics.checkExpressionValueIsNotNull(tmp40_37, "inputFileDetails.file.name"); if (StringsKt.endsWith$default(tmp40_37, ".xml", false, 2, null))
/* 105 */               removed.add(inputFileDetails.getFile());
/*     */           }
/*     */         }
/*     */       });
/* 109 */     } else { File tmp68_65 = logOutFolder;
/*     */       
/* 109 */       if (tmp68_65 == null) Intrinsics.throwUninitializedPropertyAccessException("logOutFolder"); FileUtils.cleanOutputDir(tmp68_65); File 
/* 110 */         tmp84_81 = sourceOutFolder;
/* 110 */       if (tmp84_81 == null) Intrinsics.throwUninitializedPropertyAccessException("sourceOutFolder"); FileUtils.cleanOutputDir(tmp84_81);
/*     */     }
/*     */     
/* 115 */     File tmp112_109 = xmlInfoFolder;
/*     */     
/* 115 */     if (tmp112_109 == null) Intrinsics.throwUninitializedPropertyAccessException("xmlInfoFolder");
/* 116 */     FileCollection tmp125_122 = mergedArtifactsFromDependencies;
/*     */     
/* 116 */     if (tmp125_122 == null) Intrinsics.throwUninitializedPropertyAccessException("mergedArtifactsFromDependencies"); File tmp139_134 = tmp125_122.getSingleFile();Intrinsics.checkExpressionValueIsNotNull(tmp139_134, "mergedArtifactsFromDependencies.singleFile"); File 
/* 117 */       tmp149_146 = logOutFolder;
/* 117 */     if (tmp149_146 == null) { Intrinsics.throwUninitializedPropertyAccessException("logOutFolder");
/*     */     }
/* 119 */     String tmp168_165 = packageName;
/*     */     
/* 119 */     if (tmp168_165 == null) Intrinsics.throwUninitializedPropertyAccessException("packageName");
/* 120 */     File tmp181_178 = classInfoBundleDir;
/*     */     
/* 120 */     if (tmp181_178 == null) Intrinsics.throwUninitializedPropertyAccessException("classInfoBundleDir"); File localFile1 = tmp181_178;String str = tmp168_165;boolean bool = inputs.isIncremental();File localFile2 = tmp149_146;return new LayoutInfoInput.Args((List)outOfDate, (List)removed, tmp112_109, tmp139_134, localFile1, localFile2, str, bool); }
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006¢\006\002\020\bJ\020\020\013\032\0020\f2\006\020\r\032\0020\002H\026J\b\020\016\032\0020\017H\026J\016\020\020\032\b\022\004\022\0020\0020\021H\026R\016\020\007\032\0020\006X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\t\020\n¨\006\022"}, d2={"Lcom/android/build/gradle/internal/tasks/databinding/DataBindingGenBaseClassesTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/tasks/databinding/DataBindingGenBaseClassesTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "sourceOutFolder", "Ljava/io/File;", "logArtifactFolder", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;Ljava/io/File;)V", "getVariantScope", "()Lcom/android/build/gradle/internal/scope/VariantScope;", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */   public static final class ConfigAction implements TaskConfigAction<DataBindingGenBaseClassesTask> { @NotNull
/*     */     private final VariantScope variantScope; @NotNull
/* 124 */     public final VariantScope getVariantScope() { return variantScope; } public ConfigAction(@NotNull VariantScope variantScope, @NotNull File sourceOutFolder, @NotNull File logArtifactFolder) { this.variantScope = variantScope;this.sourceOutFolder = sourceOutFolder;this.logArtifactFolder = logArtifactFolder; }
/*     */     
/*     */     private final File sourceOutFolder;
/*     */     private File logArtifactFolder;
/*     */     @NotNull
/* 129 */     public String getName() { String tmp11_6 = variantScope.getTaskName("dataBindingGenBaseClasses");Intrinsics.checkExpressionValueIsNotNull(tmp11_6, "variantScope.getTaskName…taBindingGenBaseClasses\")");return tmp11_6; }
/*     */     @NotNull
/* 131 */     public Class<DataBindingGenBaseClassesTask> getType() { return DataBindingGenBaseClassesTask.class; }
/*     */     
/*     */     public void execute(@NotNull DataBindingGenBaseClassesTask task) {
/* 134 */       Intrinsics.checkParameterIsNotNull(task, "task"); File tmp16_11 = variantScope.getLayoutInfoOutputForDataBinding();Intrinsics.checkExpressionValueIsNotNull(tmp16_11, "variantScope.layoutInfoOutputForDataBinding");DataBindingGenBaseClassesTask.access$setXmlInfoFolder$p(task, tmp16_11);
/* 135 */       BaseVariantData variantData = variantScope.getVariantData(); BaseVariantData 
/* 136 */         tmp37_36 = variantData;Intrinsics.checkExpressionValueIsNotNull(tmp37_36, "variantData"); GradleVariantConfiguration tmp46_43 = tmp37_36.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp46_43, "variantData.variantConfiguration"); String tmp55_52 = tmp46_43.getOriginalApplicationId();Intrinsics.checkExpressionValueIsNotNull(tmp55_52, "variantData.variantConfi…ion.originalApplicationId");DataBindingGenBaseClassesTask.access$setPackageName$p(task, tmp55_52); FileCollection 
/* 137 */         tmp80_75 = variantScope.getOutput(
/* 138 */         (TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.DATA_BINDING_BASE_CLASS_LOGS_DEPENDENCY_ARTIFACTS);Intrinsics.checkExpressionValueIsNotNull(tmp80_75, "variantScope.getOutput(\n…OGS_DEPENDENCY_ARTIFACTS)");DataBindingGenBaseClassesTask.access$setMergedArtifactsFromDependencies$p(task, tmp80_75); File 
/* 139 */         tmp103_98 = variantScope.getIncrementalDir(task.getName());Intrinsics.checkExpressionValueIsNotNull(tmp103_98, "variantScope.getIncrementalDir(task.name)");DataBindingGenBaseClassesTask.access$setLogOutFolder$p(task, tmp103_98); GlobalScope 
/* 140 */         tmp122_117 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp122_117, "variantScope.globalScope");DataBindingGenBaseClassesTask.access$setGenerateSources$p(task, tmp122_117.getProjectOptions().get(
/* 141 */         BooleanOption.ENABLE_DATA_BINDING_V2));
/* 142 */       DataBindingGenBaseClassesTask.access$setSourceOutFolder$p(task, sourceOutFolder);
/* 143 */       DataBindingGenBaseClassesTask.access$setClassInfoBundleDir$p(task, logArtifactFolder); }
/*     */      }
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\000\030\0002\0020\0012\0020\002B\027\b\007\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\b\020\n\032\0020\013H\026R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\b\020\tR\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\f"}, d2={"Lcom/android/build/gradle/internal/tasks/databinding/DataBindingGenBaseClassesTask$CodeGenerator;", "Ljava/lang/Runnable;", "Ljava/io/Serializable;", "args", "Landroid/databinding/tool/store/LayoutInfoInput$Args;", "sourceOutFolder", "Ljava/io/File;", "(Landroid/databinding/tool/store/LayoutInfoInput$Args;Ljava/io/File;)V", "getArgs", "()Landroid/databinding/tool/store/LayoutInfoInput$Args;", "run", "", "gradle-core"})
/*     */   public static final class CodeGenerator implements Runnable, java.io.Serializable { @javax.inject.Inject
/* 147 */     public CodeGenerator(@NotNull LayoutInfoInput.Args args, @NotNull File sourceOutFolder) { this.args = args;this.sourceOutFolder = sourceOutFolder; } @NotNull
/* 147 */     public final LayoutInfoInput.Args getArgs() { return args; }
/*     */     
/*     */     public void run()
/*     */     {
/* 151 */       new BaseDataBinder(new android.databinding.tool.store.LayoutInfoInput(args)).generateAll((android.databinding.tool.writer.JavaFileWriter)new DataBindingBuilder.GradleFileWriter(sourceOutFolder.getAbsolutePath()));
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     private final LayoutInfoInput.Args args;
/*     */     private final File sourceOutFolder;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.databinding.DataBindingGenBaseClassesTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */