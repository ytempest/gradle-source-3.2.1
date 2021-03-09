/*     */ package com.android.build.gradle.internal.res;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.internal.variant.TaskContainer.TaskKind;
/*     */ import com.android.build.gradle.options.BooleanOption;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.google.common.base.Strings;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Task;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006¢\006\002\020\bJ\020\020\t\032\0020\n2\006\020\013\032\0020\002H\026J\b\020\f\032\0020\rH\026J\016\020\016\032\b\022\004\022\0020\0020\017H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\020"}, d2={"Lcom/android/build/gradle/internal/res/GenerateLibraryRFileTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/GenerateLibraryRFileTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "symbolFile", "Ljava/io/File;", "symbolsWithPackageNameOutputFile", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;Ljava/io/File;)V", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */ public final class GenerateLibraryRFileTask$ConfigAction
/*     */   implements TaskConfigAction<GenerateLibraryRFileTask>
/*     */ {
/*     */   private final VariantScope variantScope;
/*     */   private final File symbolFile;
/*     */   private final File symbolsWithPackageNameOutputFile;
/*     */   
/*     */   public GenerateLibraryRFileTask$ConfigAction(@NotNull VariantScope variantScope, @NotNull File symbolFile, @NotNull File symbolsWithPackageNameOutputFile)
/*     */   {
/* 132 */     this.variantScope = variantScope;this.symbolFile = symbolFile;this.symbolsWithPackageNameOutputFile = symbolsWithPackageNameOutputFile;
/*     */   }
/*     */   
/*     */   @NotNull
/* 138 */   public String getName() { return variantScope.getTaskName("generate", "RFile"); }
/*     */   @NotNull
/* 140 */   public Class<GenerateLibraryRFileTask> getType() { return GenerateLibraryRFileTask.class; }
/*     */   
/*     */   public void execute(@NotNull GenerateLibraryRFileTask task) {
/* 143 */     Intrinsics.checkParameterIsNotNull(task, "task");variantScope.getVariantData().addTask(TaskContainer.TaskKind.PROCESS_ANDROID_RESOURCES, (Task)task);
/*     */     
/* 145 */     task.setVariantName(variantScope.getFullVariantName()); FileCollection 
/*     */     
/* 149 */       tmp57_54 = variantScope.getGlobalScope().getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.PLATFORM_R_TXT);Intrinsics.checkExpressionValueIsNotNull(tmp57_54, "variantScope\n           …utputType.PLATFORM_R_TXT)");GenerateLibraryRFileTask.access$setPlatformAttrRTxt$p(task, tmp57_54); BaseVariantData 
/*     */     
/* 151 */       tmp76_71 = variantScope.getVariantData();Intrinsics.checkExpressionValueIsNotNull(tmp76_71, "variantScope.variantData"); GradleVariantConfiguration tmp85_82 = tmp76_71.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp85_82, "variantScope.variantData.variantConfiguration"); String tmp94_91 = tmp85_82.getApplicationId();Intrinsics.checkExpressionValueIsNotNull(tmp94_91, "variantScope.variantData…nfiguration.applicationId");GenerateLibraryRFileTask.access$setApplicationId$p(task, tmp94_91); FileCollection 
/*     */     
/* 153 */       tmp122_117 = variantScope.getArtifactFileCollection(
/* 154 */       AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, 
/* 155 */       AndroidArtifacts.ArtifactScope.ALL, 
/* 156 */       AndroidArtifacts.ArtifactType.SYMBOL_LIST_WITH_PACKAGE_NAME);Intrinsics.checkExpressionValueIsNotNull(tmp122_117, "variantScope.getArtifact…L_LIST_WITH_PACKAGE_NAME)");GenerateLibraryRFileTask.access$setDependencies$p(task, tmp122_117); GlobalScope 
/* 157 */       tmp140_135 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp140_135, "variantScope.globalScope"); if (tmp140_135.getProjectOptions().get(BooleanOption.ENABLE_SEPARATE_R_CLASS_COMPILATION)) {
/* 158 */       File rJar = new File(variantScope.getIntermediateDir(TaskOutputHolder.TaskOutputType.COMPILE_ONLY_NOT_NAMESPACED_R_CLASS_JAR), "R.jar");
/* 159 */       GenerateLibraryRFileTask.access$setRClassOutputJar$p(task, rJar);
/* 160 */       variantScope.addTaskOutput(
/* 161 */         TaskOutputHolder.TaskOutputType.COMPILE_ONLY_NOT_NAMESPACED_R_CLASS_JAR, 
/* 162 */         rJar, 
/* 163 */         task.getName());
/*     */     } else {
/* 165 */       File sourceOutputDirectory = variantScope.getRClassSourceOutputDir();
/* 166 */       GenerateLibraryRFileTask.access$setSourceOutputDirectory$p(task, sourceOutputDirectory);
/* 167 */       variantScope.addTaskOutput(
/* 168 */         TaskOutputHolder.TaskOutputType.NOT_NAMESPACED_R_CLASS_SOURCES, 
/* 169 */         sourceOutputDirectory, 
/* 170 */         task.getName());
/*     */     }
/* 172 */     GenerateLibraryRFileTask.access$setTextSymbolOutputFile$p(task, symbolFile);
/* 173 */     GenerateLibraryRFileTask.access$setSymbolsWithPackageNameOutputFile$p(task, symbolsWithPackageNameOutputFile);
/*     */     
/* 175 */     if (variantScope.getCodeShrinker() != null) {
/* 176 */       GenerateLibraryRFileTask.access$setProguardOutputFile$p(task, variantScope.getProcessAndroidResourcesProguardOutputFile());
/*     */     }
/*     */     
/* 179 */     GradleVariantConfiguration tmp290_285 = variantScope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp290_285, "variantScope.variantConfiguration"); String tmp302_299 = Strings.nullToEmpty(tmp290_285.getOriginalApplicationId());Intrinsics.checkExpressionValueIsNotNull(tmp302_299, "Strings.nullToEmpty(vari…on.originalApplicationId)");GenerateLibraryRFileTask.access$setPackageForR$p(task, tmp302_299);
/*     */     
/* 181 */     GenerateLibraryRFileTask.access$setManifestFiles$p(task, variantScope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS)); FileCollection 
/*     */     
/* 183 */       tmp346_341 = variantScope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.PACKAGED_RES);Intrinsics.checkExpressionValueIsNotNull(tmp346_341, "variantScope.getOutput(T…kOutputType.PACKAGED_RES)");task.setInputResourcesDir(tmp346_341);
/*     */     
/* 185 */     GenerateLibraryRFileTask.access$setOutputScope$p(task, variantScope.getOutputScope());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.GenerateLibraryRFileTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */