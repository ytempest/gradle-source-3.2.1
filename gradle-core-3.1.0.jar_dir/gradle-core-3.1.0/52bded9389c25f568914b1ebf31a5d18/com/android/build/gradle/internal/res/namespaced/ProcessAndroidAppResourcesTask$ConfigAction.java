/*     */ package com.android.build.gradle.internal.res.namespaced;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.OutputScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.utils.FileUtils;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0008\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B%\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006\022\006\020\b\032\0020\t¢\006\002\020\nJ\020\020\f\032\0020\r2\006\020\016\032\0020\002H\026J\b\020\017\032\0020\020H\026J\016\020\021\032\b\022\004\022\0020\0020\022H\026R\021\020\b\032\0020\t¢\006\b\n\000\032\004\b\b\020\013R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\023"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/ProcessAndroidAppResourcesTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/namespaced/ProcessAndroidAppResourcesTask;", "scope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "rClassSource", "Ljava/io/File;", "resourceApUnderscore", "isLibrary", "", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;Ljava/io/File;Z)V", "()Z", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */ public final class ProcessAndroidAppResourcesTask$ConfigAction
/*     */   implements TaskConfigAction<ProcessAndroidAppResourcesTask>
/*     */ {
/*     */   private final VariantScope scope;
/*     */   private final File rClassSource;
/*     */   private final File resourceApUnderscore;
/*     */   private final boolean isLibrary;
/*     */   
/*     */   public ProcessAndroidAppResourcesTask$ConfigAction(@NotNull VariantScope scope, @NotNull File rClassSource, @NotNull File resourceApUnderscore, boolean isLibrary)
/*     */   {
/*  94 */     this.scope = scope;this.rClassSource = rClassSource;this.resourceApUnderscore = resourceApUnderscore;this.isLibrary = isLibrary;
/*     */   }
/*     */   
/*  98 */   public final boolean isLibrary() { return isLibrary; }
/*     */   
/*     */   @NotNull
/* 101 */   public String getName() { String tmp13_8 = scope.getTaskName("process", "Resources");Intrinsics.checkExpressionValueIsNotNull(tmp13_8, "scope.getTaskName(\"process\", \"Resources\")");return tmp13_8;
/*     */   }
/*     */   
/*     */   @NotNull
/* 105 */   public Class<ProcessAndroidAppResourcesTask> getType() { return ProcessAndroidAppResourcesTask.class; }
/*     */   
/*     */   public void execute(@NotNull ProcessAndroidAppResourcesTask task)
/*     */   {
/* 109 */     Intrinsics.checkParameterIsNotNull(task, "task");task.setVariantName(scope.getFullVariantName());
/*     */     
/* 112 */     Intrinsics.checkExpressionValueIsNotNull(scope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.AAPT_FRIENDLY_MERGED_MANIFESTS), "scope.getOutput(TaskOutp…RIENDLY_MERGED_MANIFESTS)"); FileCollection 
/*     */     
/* 114 */       tmp77_72 = scope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS);Intrinsics.checkExpressionValueIsNotNull(tmp77_72, "scope.getOutput(TaskOutp…putType.MERGED_MANIFESTS)");ProcessAndroidAppResourcesTask.access$setManifestFileDirectory$p(task, tmp77_72); FileCollection 
/*     */     
/* 116 */       tmp102_97 = scope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.RES_STATIC_LIBRARY);Intrinsics.checkExpressionValueIsNotNull(tmp102_97, "scope.getOutput(TaskOutp…tType.RES_STATIC_LIBRARY)");ProcessAndroidAppResourcesTask.access$setThisSubProjectStaticLibrary$p(task, tmp102_97); FileCollection 
/*     */     
/* 118 */       tmp130_125 = scope.getArtifactFileCollection(
/* 119 */       AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, 
/* 120 */       AndroidArtifacts.ArtifactScope.ALL, 
/* 121 */       AndroidArtifacts.ArtifactType.RES_STATIC_LIBRARY);Intrinsics.checkExpressionValueIsNotNull(tmp130_125, "scope.getArtifactFileCol…tType.RES_STATIC_LIBRARY)");ProcessAndroidAppResourcesTask.access$setLibraryDependencies$p(task, tmp130_125); FileCollection 
/*     */     
/* 123 */       tmp158_153 = scope.getArtifactFileCollection(
/* 124 */       AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, 
/* 125 */       AndroidArtifacts.ArtifactScope.ALL, 
/* 126 */       AndroidArtifacts.ArtifactType.RES_SHARED_STATIC_LIBRARY);Intrinsics.checkExpressionValueIsNotNull(tmp158_153, "scope.getArtifactFileCol…ES_SHARED_STATIC_LIBRARY)");ProcessAndroidAppResourcesTask.access$setSharedLibraryDependencies$p(task, tmp158_153); OutputScope 
/*     */     
/* 128 */       tmp177_172 = scope.getOutputScope();Intrinsics.checkExpressionValueIsNotNull(tmp177_172, "scope.outputScope");ProcessAndroidAppResourcesTask.access$setOutputScope$p(task, tmp177_172); GlobalScope 
/*     */     
/* 131 */       tmp196_191 = scope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp196_191, "scope.globalScope"); GradleVariantConfiguration tmp225_220 = scope.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp225_220, "scope.variantConfiguration");{ "res-process-intermediate" }[1] = tmp225_220.getDirName(); File tmp238_235 = FileUtils.join(tmp196_191.getIntermediatesDir(), tmp214_209);Intrinsics.checkExpressionValueIsNotNull(tmp238_235, "FileUtils.join(\n        …antConfiguration.dirName)");ProcessAndroidAppResourcesTask.access$setAaptIntermediateDir$p(task, tmp238_235);
/* 132 */     ProcessAndroidAppResourcesTask.access$setRClassSource$p(task, rClassSource);
/* 133 */     ProcessAndroidAppResourcesTask.access$setResourceApUnderscore$p(task, resourceApUnderscore); GlobalScope 
/* 134 */       tmp273_268 = scope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp273_268, "scope.globalScope");task.setAndroidBuilder(tmp273_268.getAndroidBuilder());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.ProcessAndroidAppResourcesTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */