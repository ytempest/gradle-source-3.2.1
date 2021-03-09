/*     */ package com.android.build.gradle.internal.tasks.databinding;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.options.BooleanOption;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006¢\006\002\020\bJ\020\020\013\032\0020\f2\006\020\r\032\0020\002H\026J\b\020\016\032\0020\017H\026J\016\020\020\032\b\022\004\022\0020\0020\021H\026R\016\020\007\032\0020\006X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\t\020\n¨\006\022"}, d2={"Lcom/android/build/gradle/internal/tasks/databinding/DataBindingGenBaseClassesTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/tasks/databinding/DataBindingGenBaseClassesTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "sourceOutFolder", "Ljava/io/File;", "logArtifactFolder", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;Ljava/io/File;)V", "getVariantScope", "()Lcom/android/build/gradle/internal/scope/VariantScope;", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */ public final class DataBindingGenBaseClassesTask$ConfigAction
/*     */   implements TaskConfigAction<DataBindingGenBaseClassesTask>
/*     */ {
/*     */   @NotNull
/*     */   private final VariantScope variantScope;
/*     */   private final File sourceOutFolder;
/*     */   private File logArtifactFolder;
/*     */   
/*     */   @NotNull
/* 124 */   public final VariantScope getVariantScope() { return variantScope; } public DataBindingGenBaseClassesTask$ConfigAction(@NotNull VariantScope variantScope, @NotNull File sourceOutFolder, @NotNull File logArtifactFolder) { this.variantScope = variantScope;this.sourceOutFolder = sourceOutFolder;this.logArtifactFolder = logArtifactFolder;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getName() {
/* 129 */     String tmp11_6 = variantScope.getTaskName("dataBindingGenBaseClasses");Intrinsics.checkExpressionValueIsNotNull(tmp11_6, "variantScope.getTaskName…taBindingGenBaseClasses\")");return tmp11_6; }
/*     */   @NotNull
/* 131 */   public Class<DataBindingGenBaseClassesTask> getType() { return DataBindingGenBaseClassesTask.class; }
/*     */   
/*     */   public void execute(@NotNull DataBindingGenBaseClassesTask task) {
/* 134 */     Intrinsics.checkParameterIsNotNull(task, "task"); File tmp16_11 = variantScope.getLayoutInfoOutputForDataBinding();Intrinsics.checkExpressionValueIsNotNull(tmp16_11, "variantScope.layoutInfoOutputForDataBinding");DataBindingGenBaseClassesTask.access$setXmlInfoFolder$p(task, tmp16_11);
/* 135 */     BaseVariantData variantData = variantScope.getVariantData(); BaseVariantData 
/* 136 */       tmp37_36 = variantData;Intrinsics.checkExpressionValueIsNotNull(tmp37_36, "variantData"); GradleVariantConfiguration tmp46_43 = tmp37_36.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp46_43, "variantData.variantConfiguration"); String tmp55_52 = tmp46_43.getOriginalApplicationId();Intrinsics.checkExpressionValueIsNotNull(tmp55_52, "variantData.variantConfi…ion.originalApplicationId");DataBindingGenBaseClassesTask.access$setPackageName$p(task, tmp55_52); FileCollection 
/* 137 */       tmp80_75 = variantScope.getOutput(
/* 138 */       (TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.DATA_BINDING_BASE_CLASS_LOGS_DEPENDENCY_ARTIFACTS);Intrinsics.checkExpressionValueIsNotNull(tmp80_75, "variantScope.getOutput(\n…OGS_DEPENDENCY_ARTIFACTS)");DataBindingGenBaseClassesTask.access$setMergedArtifactsFromDependencies$p(task, tmp80_75); File 
/* 139 */       tmp103_98 = variantScope.getIncrementalDir(task.getName());Intrinsics.checkExpressionValueIsNotNull(tmp103_98, "variantScope.getIncrementalDir(task.name)");DataBindingGenBaseClassesTask.access$setLogOutFolder$p(task, tmp103_98); GlobalScope 
/* 140 */       tmp122_117 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp122_117, "variantScope.globalScope");DataBindingGenBaseClassesTask.access$setGenerateSources$p(task, tmp122_117.getProjectOptions().get(
/* 141 */       BooleanOption.ENABLE_DATA_BINDING_V2));
/* 142 */     DataBindingGenBaseClassesTask.access$setSourceOutFolder$p(task, sourceOutFolder);
/* 143 */     DataBindingGenBaseClassesTask.access$setClassInfoBundleDir$p(task, logArtifactFolder);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.databinding.DataBindingGenBaseClassesTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */