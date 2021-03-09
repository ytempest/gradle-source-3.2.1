/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.BuildArtifactHolder;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.build.gradle.options.StringOption;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Project;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000*\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\006\020\007¨\006\017"}, d2={"Lcom/android/build/gradle/tasks/BuildArtifactReportTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/tasks/BuildArtifactReportTask;", "scope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "(Lcom/android/build/gradle/internal/scope/VariantScope;)V", "getScope", "()Lcom/android/build/gradle/internal/scope/VariantScope;", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */ public final class BuildArtifactReportTask$ConfigAction
/*     */   implements TaskConfigAction<BuildArtifactReportTask>
/*     */ {
/*     */   @NotNull
/*     */   private final VariantScope scope;
/*     */   
/*     */   @NotNull
/*  95 */   public final VariantScope getScope() { return scope; } public BuildArtifactReportTask$ConfigAction(@NotNull VariantScope scope) { this.scope = scope; } @NotNull
/*  96 */   public String getName() { return scope.getTaskName("reportBuildArtifacts"); }
/*     */   @NotNull
/*  98 */   public Class<BuildArtifactReportTask> getType() { return BuildArtifactReportTask.class; }
/*     */   
/*     */   public void execute(@NotNull BuildArtifactReportTask task) {
/* 101 */     Intrinsics.checkParameterIsNotNull(task, "task");task.setVariantName(scope.getFullVariantName()); GlobalScope 
/*     */     
/* 103 */       tmp28_23 = scope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp28_23, "scope.globalScope");String outputFileName = tmp28_23.getProjectOptions().get(StringOption.BUILD_ARTIFACT_REPORT_FILE); GlobalScope 
/*     */     
/* 106 */       tmp61_56 = scope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp61_56, "scope.globalScope");File outputFile = outputFileName == null ? null : tmp61_56.getProject().file(outputFileName); BuildArtifactHolder 
/*     */     
/* 110 */       tmp87_82 = scope.getBuildArtifactHolder();Intrinsics.checkExpressionValueIsNotNull(tmp87_82, "scope.buildArtifactHolder");
/* 111 */     BuildArtifactHolder localBuildArtifactHolder = tmp87_82;BuildArtifactReportTask localBuildArtifactReportTask = task;List localList = CollectionsKt.emptyList();localBuildArtifactReportTask.init(localBuildArtifactHolder, (Collection)localList, 
/* 112 */       outputFile);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.BuildArtifactReportTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */