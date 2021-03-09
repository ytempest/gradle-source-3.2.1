/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.builder.model.LintOptions;
/*     */ import com.android.builder.model.Version;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import com.android.tools.lint.gradle.api.LintExecutionRequest;
/*     */ import com.android.tools.lint.gradle.api.VariantInputs;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.logging.Logging;
/*     */ import org.gradle.tooling.provider.model.ToolingModelBuilderRegistry;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000_\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\003\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\020\021\n\002\020\000\n\002\b\002*\001\000\b\n\030\0002\0020\001B\005¢\006\002\020\002J\022\020\"\032\004\030\0010#2\006\020 \032\0020\bH\026J)\020$\032\0020%2\006\020&\032\0020\b2\022\020'\032\n\022\006\b\001\022\0020)0(\"\0020)H\026¢\006\002\020*R\026\020\003\032\004\030\0010\004X\004¢\006\b\n\000\032\004\b\005\020\006R\024\020\007\032\0020\bX\004¢\006\b\n\000\032\004\b\t\020\nR\024\020\013\032\0020\fX\004¢\006\b\n\000\032\004\b\013\020\rR\026\020\016\032\004\030\0010\017X\004¢\006\b\n\000\032\004\b\020\020\021R\024\020\022\032\0020\023X\004¢\006\b\n\000\032\004\b\024\020\025R\026\020\026\032\004\030\0010\027X\004¢\006\b\n\000\032\004\b\030\020\031R\026\020\032\032\004\030\0010\027X\004¢\006\b\n\000\032\004\b\033\020\031R\026\020\034\032\004\030\0010\035X\004¢\006\b\n\000\032\004\b\036\020\037R\026\020 \032\004\030\0010\bX\004¢\006\b\n\000\032\004\b!\020\n¨\006+"}, d2={"com/android/build/gradle/internal/tasks/LintStandaloneTask$run$request$1", "Lcom/android/tools/lint/gradle/api/LintExecutionRequest;", "(Lcom/android/build/gradle/internal/tasks/LintStandaloneTask;)V", "buildTools", "Lcom/android/sdklib/BuildToolInfo;", "getBuildTools", "()Lcom/android/sdklib/BuildToolInfo;", "gradlePluginVersion", "", "getGradlePluginVersion", "()Ljava/lang/String;", "isFatalOnly", "", "()Z", "lintOptions", "Lcom/android/builder/model/LintOptions;", "getLintOptions", "()Lcom/android/builder/model/LintOptions;", "project", "Lorg/gradle/api/Project;", "getProject", "()Lorg/gradle/api/Project;", "reportsDir", "Ljava/io/File;", "getReportsDir", "()Ljava/io/File;", "sdkHome", "getSdkHome", "toolingRegistry", "Lorg/gradle/tooling/provider/model/ToolingModelBuilderRegistry;", "getToolingRegistry", "()Lorg/gradle/tooling/provider/model/ToolingModelBuilderRegistry;", "variantName", "getVariantName", "getVariantInputs", "Lcom/android/tools/lint/gradle/api/VariantInputs;", "warn", "", "message", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "gradle-core"})
/*     */ public final class LintStandaloneTask$run$request$1
/*     */   extends LintExecutionRequest
/*     */ {
/*     */   @NotNull
/*     */   private final Project project;
/*     */   @Nullable
/*     */   private final File reportsDir;
/*     */   @Nullable
/*     */   private final LintOptions lintOptions;
/*     */   @NotNull
/*     */   private final String gradlePluginVersion;
/*     */   private final boolean isFatalOnly;
/*     */   @Nullable
/*     */   private final BuildToolInfo buildTools;
/*     */   @Nullable
/*     */   private final String variantName;
/*     */   @Nullable
/*     */   private final File sdkHome;
/*     */   @Nullable
/*     */   private final ToolingModelBuilderRegistry toolingRegistry;
/*     */   
/*     */   @NotNull
/*     */   public Project getProject()
/*     */   {
/*  81 */     return project; } @Nullable
/*  82 */   public File getReportsDir() { return reportsDir; } @Nullable
/*  83 */   public LintOptions getLintOptions() { return lintOptions; } @NotNull
/*  84 */   public String getGradlePluginVersion() { return gradlePluginVersion; }
/*  85 */   public boolean isFatalOnly() { return isFatalOnly;
/*     */   }
/*     */   
/*     */   LintStandaloneTask$run$request$1()
/*     */   {
/*  81 */     Project tmp14_11 = $outer.getProject();Intrinsics.checkExpressionValueIsNotNull(tmp14_11, "this@LintStandaloneTask.project");project = tmp14_11;
/*  82 */     reportsDir = $outer.getReportDir();
/*  83 */     lintOptions = $outer.getLintOptions(); String 
/*  84 */       tmp43_40 = Version.ANDROID_GRADLE_PLUGIN_VERSION;Intrinsics.checkExpressionValueIsNotNull(tmp43_40, "ANDROID_GRADLE_PLUGIN_VERSION");gradlePluginVersion = tmp43_40;
/*  85 */     isFatalOnly = $outer.getFatalOnly();
/*     */   }
/*     */   
/*  88 */   public void warn(@NotNull String message, @NotNull Object... args) { Intrinsics.checkParameterIsNotNull(message, "message");Intrinsics.checkParameterIsNotNull(args, "args");Logging.getLogger(LintStandaloneTask.class).warn(message, args);
/*     */   }
/*     */   
/*     */   @Nullable
/*  92 */   public VariantInputs getVariantInputs(@NotNull String variantName) { Intrinsics.checkParameterIsNotNull(variantName, "variantName");(VariantInputs)new VariantInputs() { @NotNull
/*  93 */       public String getName() { return name; } @NotNull
/*  94 */       public List<File> getRuleJars() { return ruleJars; } @Nullable
/*  95 */       public File getMergedManifest() { return mergedManifest; } @Nullable
/*  96 */       public File getManifestMergeReport() { return manifestMergeReport; } }; }
/*     */   
/*     */   @NotNull
/*     */   private final String name = "";
/*     */   
/*     */   @Nullable
/* 102 */   public BuildToolInfo getBuildTools() { return buildTools; } @Nullable
/* 103 */   public String getVariantName() { return variantName; } @Nullable
/* 104 */   public File getSdkHome() { return sdkHome; } @Nullable
/* 105 */   public ToolingModelBuilderRegistry getToolingRegistry() { return toolingRegistry; }
/*     */   
/*     */   @NotNull
/*     */   private final List<File> ruleJars;
/*     */   @Nullable
/*     */   private final File mergedManifest;
/*     */   @Nullable
/*     */   private final File manifestMergeReport;
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.LintStandaloneTask.run.request.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */