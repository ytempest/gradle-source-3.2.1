/*     */ package com.android.build.gradle.tasks.ir;
/*     */ 
/*     */ import com.android.build.gradle.internal.aapt.AaptGeneration;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.builder.utils.FileCache;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\n\032\0020\0132\006\020\f\032\0020\002H\026J\b\020\r\032\0020\016H\026J\016\020\017\032\b\022\004\022\0020\0020\020H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\b\020\t¨\006\021"}, d2={"Lcom/android/build/gradle/tasks/ir/InstantRunMainApkResourcesBuilder$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/tasks/ir/InstantRunMainApkResourcesBuilder;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "taskInputType", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;", "(Lcom/android/build/gradle/internal/scope/VariantScope;Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;)V", "getVariantScope", "()Lcom/android/build/gradle/internal/scope/VariantScope;", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */ public final class InstantRunMainApkResourcesBuilder$ConfigAction
/*     */   implements TaskConfigAction<InstantRunMainApkResourcesBuilder>
/*     */ {
/*     */   @NotNull
/*     */   private final VariantScope variantScope;
/*     */   private final TaskOutputHolder.OutputType taskInputType;
/*     */   
/*     */   public InstantRunMainApkResourcesBuilder$ConfigAction(@NotNull VariantScope variantScope, @NotNull TaskOutputHolder.OutputType taskInputType)
/*     */   {
/* 111 */     this.variantScope = variantScope;this.taskInputType = taskInputType; } @NotNull
/* 112 */   public final VariantScope getVariantScope() { return variantScope; }
/*     */   
/*     */   @NotNull
/* 116 */   public String getName() { return variantScope.getTaskName("instantRunMainApkResources"); }
/*     */   @NotNull
/* 118 */   public Class<InstantRunMainApkResourcesBuilder> getType() { return InstantRunMainApkResourcesBuilder.class; }
/*     */   
/*     */   public void execute(@NotNull InstantRunMainApkResourcesBuilder task) {
/* 121 */     Intrinsics.checkParameterIsNotNull(task, "task");task.setVariantName(variantScope.getFullVariantName()); GlobalScope 
/* 122 */       tmp29_24 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp29_24, "variantScope.globalScope");task.setAndroidBuilder(tmp29_24.getAndroidBuilder()); FileCollection 
/*     */     
/* 124 */       tmp55_50 = variantScope.getOutput(taskInputType);Intrinsics.checkExpressionValueIsNotNull(tmp55_50, "variantScope.getOutput(taskInputType)");task.setResourceFiles(tmp55_50);
/* 125 */     task.setManifestFiles(variantScope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.INSTANT_RUN_MERGED_MANIFESTS)); File 
/* 126 */       tmp93_88 = variantScope.getInstantRunMainApkResourcesDir();Intrinsics.checkExpressionValueIsNotNull(tmp93_88, "variantScope.instantRunMainApkResourcesDir");task.setOutputDirectory(tmp93_88); GlobalScope 
/*     */     
/* 128 */       tmp112_107 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp112_107, "variantScope.globalScope"); AaptGeneration tmp124_121 = AaptGeneration.fromProjectOptions(tmp112_107.getProjectOptions());Intrinsics.checkExpressionValueIsNotNull(tmp124_121, "AaptGeneration.fromProje…obalScope.projectOptions)");InstantRunMainApkResourcesBuilder.access$setAaptGeneration$p(task, tmp124_121); GlobalScope 
/* 129 */       tmp143_138 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp143_138, "variantScope.globalScope"); FileCache tmp152_149 = tmp143_138.getBuildCache(); if (tmp152_149 == null) Intrinsics.throwNpe(); InstantRunMainApkResourcesBuilder.access$setFileCache$p(task, tmp152_149);
/* 130 */     InstantRunMainApkResourcesBuilder.access$setAaptIntermediateFolder$p(task, new File(variantScope.getIncrementalDir(getName()), "aapt-temp"));
/*     */     
/* 132 */     variantScope.addTaskOutput(TaskOutputHolder.TaskOutputType.INSTANT_RUN_MAIN_APK_RESOURCES, task.getOutputDirectory(), getName());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ir.InstantRunMainApkResourcesBuilder.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */