/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.builder.model.LintOptions;
/*     */ import com.android.builder.model.Version;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import com.android.tools.lint.gradle.api.LintExecutionRequest;
/*     */ import com.android.tools.lint.gradle.api.ReflectiveLintRunner;
/*     */ import com.android.tools.lint.gradle.api.VariantInputs;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.DefaultTask;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.artifacts.ArtifactView.ViewConfiguration;
/*     */ import org.gradle.api.artifacts.Configuration;
/*     */ import org.gradle.api.artifacts.ConfigurationContainer;
/*     */ import org.gradle.api.attributes.AttributeContainer;
/*     */ import org.gradle.api.invocation.Gradle;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.tasks.Classpath;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.gradle.tooling.provider.model.ToolingModelBuilderRegistry;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0008\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020 \n\000\n\002\020\002\n\000\b\026\030\0002\0020\001B\005¢\006\002\020\002J\016\020\033\032\b\022\004\022\0020\0260\034H\002J\b\020\035\032\0020\036H\007R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\036\020\t\032\004\030\0010\n8\007X\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R\034\020\017\032\004\030\0010\020X\016¢\006\016\n\000\032\004\b\021\020\022\"\004\b\023\020\024R\036\020\025\032\004\030\0010\0268\007X\016¢\006\016\n\000\032\004\b\027\020\030\"\004\b\031\020\032¨\006\037"}, d2={"Lcom/android/build/gradle/internal/tasks/LintStandaloneTask;", "Lorg/gradle/api/DefaultTask;", "()V", "fatalOnly", "", "getFatalOnly", "()Z", "setFatalOnly", "(Z)V", "lintChecks", "Lorg/gradle/api/artifacts/Configuration;", "getLintChecks", "()Lorg/gradle/api/artifacts/Configuration;", "setLintChecks", "(Lorg/gradle/api/artifacts/Configuration;)V", "lintOptions", "Lcom/android/builder/model/LintOptions;", "getLintOptions", "()Lcom/android/builder/model/LintOptions;", "setLintOptions", "(Lcom/android/builder/model/LintOptions;)V", "reportDir", "Ljava/io/File;", "getReportDir", "()Ljava/io/File;", "setReportDir", "(Ljava/io/File;)V", "computeLocalChecks", "", "run", "", "gradle-core"})
/*     */ public class LintStandaloneTask
/*     */   extends DefaultTask
/*     */ {
/*     */   @Nullable
/*     */   private File reportDir;
/*     */   private boolean fatalOnly;
/*     */   @Nullable
/*     */   private LintOptions lintOptions;
/*     */   @Nullable
/*     */   private Configuration lintChecks;
/*     */   
/*     */   @OutputDirectory
/*     */   @Nullable
/*  48 */   public final File getReportDir() { return reportDir; } public final void setReportDir(@Nullable File <set-?>) { reportDir = <set-?>; }
/*     */   
/*  50 */   public final boolean getFatalOnly() { return fatalOnly; } public final void setFatalOnly(boolean <set-?>) { fatalOnly = <set-?>; }
/*     */   @Nullable
/*  52 */   public final LintOptions getLintOptions() { return lintOptions; } public final void setLintOptions(@Nullable LintOptions <set-?>) { lintOptions = <set-?>; }
/*     */   @Optional
/*     */   @Classpath
/*     */   @Nullable
/*  56 */   public final Configuration getLintChecks() { return lintChecks; } public final void setLintChecks(@Nullable Configuration <set-?>) { lintChecks = <set-?>; }
/*     */   
/*     */   @NotNull
/*     */   private final Project project;
/*     */   
/*     */   @Nullable
/*     */   private final File reportsDir;
/*     */   
/*     */   @org.gradle.api.tasks.TaskAction
/*     */   public final void run()
/*     */     throws IOException, InterruptedException
/*     */   {
/*  78 */     Project tmp4_1 = getProject();Intrinsics.checkExpressionValueIsNotNull(tmp4_1, "project");Configuration lintClassPath = tmp4_1.getConfigurations().getByName("lintClassPath");
/*  79 */     if (lintClassPath != null) {
/*  80 */       LintExecutionRequest request = new LintExecutionRequest() { @NotNull
/*  81 */         public Project getProject() { return project; } @Nullable
/*  82 */         public File getReportsDir() { return reportsDir; } @Nullable
/*  83 */         public LintOptions getLintOptions() { return lintOptions; } @NotNull
/*  84 */         public String getGradlePluginVersion() { return gradlePluginVersion; }
/*  85 */         public boolean isFatalOnly() { return isFatalOnly; }
/*     */         
/*     */         public void warn(@NotNull String message, @NotNull Object... args) {
/*  88 */           Intrinsics.checkParameterIsNotNull(message, "message");Intrinsics.checkParameterIsNotNull(args, "args");org.gradle.api.logging.Logging.getLogger(LintStandaloneTask.class).warn(message, args);
/*     */         }
/*     */         
/*     */         @Nullable
/*  92 */         public VariantInputs getVariantInputs(@NotNull String variantName) { Intrinsics.checkParameterIsNotNull(variantName, "variantName");(VariantInputs)new VariantInputs() { @NotNull
/*  93 */             public String getName() { return name; } @NotNull
/*  94 */             public List<File> getRuleJars() { return ruleJars; } @Nullable
/*  95 */             public File getMergedManifest() { return mergedManifest; } @Nullable
/*  96 */             public File getManifestMergeReport() { return manifestMergeReport; } }; }
/*     */         
/*     */         @NotNull
/*     */         private final String name = "";
/*     */         
/*     */         @Nullable
/* 102 */         public BuildToolInfo getBuildTools() { return buildTools; } @Nullable
/* 103 */         public String getVariantName() { return variantName; } @Nullable
/* 104 */         public File getSdkHome() { return sdkHome; } @Nullable
/* 105 */         public ToolingModelBuilderRegistry getToolingRegistry() { return toolingRegistry;
/*     */         }
/* 108 */       }; Project tmp47_44 = getProject();Intrinsics.checkExpressionValueIsNotNull(tmp47_44, "project"); Gradle tmp58_53 = tmp47_44.getGradle();Intrinsics.checkExpressionValueIsNotNull(tmp58_53, "project.gradle"); Set tmp74_69 = lintClassPath.getFiles();Intrinsics.checkExpressionValueIsNotNull(tmp74_69, "lintClassPath.files");new ReflectiveLintRunner().runLint(tmp58_53, (LintExecutionRequest)request, tmp74_69);
/*     */     }
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   private final LintOptions lintOptions;
/*     */   @NotNull
/*     */   private final String gradlePluginVersion;
/*     */   @NotNull
/*     */   private final List<File> ruleJars;
/*     */   @Nullable
/*     */   private final File mergedManifest;
/*     */   @Nullable
/*     */   private final File manifestMergeReport;
/*     */   private final boolean isFatalOnly;
/*     */   @Nullable
/*     */   private final BuildToolInfo buildTools;
/*     */   @Nullable
/*     */   private final String variantName;
/*     */   @Nullable
/*     */   private final File sdkHome;
/*     */   @Nullable
/*     */   private final ToolingModelBuilderRegistry toolingRegistry;
/*     */   /* Error */
/*     */   private final List<File> computeLocalChecks()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 41	com/android/build/gradle/internal/tasks/LintStandaloneTask:lintChecks	Lorg/gradle/api/artifacts/Configuration;
/*     */     //   4: dup
/*     */     //   5: ifnull +6 -> 11
/*     */     //   8: goto +8 -> 16
/*     */     //   11: pop
/*     */     //   12: invokestatic 50	kotlin/collections/CollectionsKt:emptyList	()Ljava/util/List;
/*     */     //   15: areturn
/*     */     //   16: astore_1
/*     */     //   17: getstatic 56	com/android/build/gradle/internal/tasks/LintStandaloneTask$computeLocalChecks$attributes$1:INSTANCE	Lcom/android/build/gradle/internal/tasks/LintStandaloneTask$computeLocalChecks$attributes$1;
/*     */     //   20: checkcast 58	org/gradle/api/Action
/*     */     //   23: astore_2
/*     */     //   24: aload_1
/*     */     //   25: invokeinterface 64 1 0
/*     */     //   30: new 66	com/android/build/gradle/internal/tasks/LintStandaloneTask$computeLocalChecks$1
/*     */     //   33: dup
/*     */     //   34: aload_2
/*     */     //   35: invokespecial 70	com/android/build/gradle/internal/tasks/LintStandaloneTask$computeLocalChecks$1:<init>	(Lorg/gradle/api/Action;)V
/*     */     //   38: checkcast 58	org/gradle/api/Action
/*     */     //   41: invokeinterface 76 2 0
/*     */     //   46: dup
/*     */     //   47: ldc 78
/*     */     //   49: invokestatic 84	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   52: invokeinterface 90 1 0
/*     */     //   57: dup
/*     */     //   58: ldc 92
/*     */     //   60: invokestatic 84	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   63: invokeinterface 98 1 0
/*     */     //   68: dup
/*     */     //   69: ldc 100
/*     */     //   71: invokestatic 84	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   74: invokeinterface 106 1 0
/*     */     //   79: dup
/*     */     //   80: ldc 108
/*     */     //   82: invokestatic 84	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   85: checkcast 110	java/lang/Iterable
/*     */     //   88: invokestatic 114	kotlin/collections/CollectionsKt:toList	(Ljava/lang/Iterable;)Ljava/util/List;
/*     */     //   91: areturn
/*     */     // Line number table:
/*     */     //   Java source line #60	-> byte code offset #0
/*     */     //   Java source line #61	-> byte code offset #17
/*     */     //   Java source line #66	-> byte code offset #24
/*     */     //   Java source line #72	-> byte code offset #24
/*     */     //   Java source line #66	-> byte code offset #24
/*     */     //   Java source line #71	-> byte code offset #24
/*     */     //   Java source line #66	-> byte code offset #24
/*     */     //   Java source line #70	-> byte code offset #24
/*     */     //   Java source line #66	-> byte code offset #24
/*     */     //   Java source line #69	-> byte code offset #24
/*     */     //   Java source line #66	-> byte code offset #24
/*     */     //   Java source line #68	-> byte code offset #24
/*     */     //   Java source line #66	-> byte code offset #24
/*     */     //   Java source line #67	-> byte code offset #24
/*     */     //   Java source line #66	-> byte code offset #24
/*     */     //   Java source line #68	-> byte code offset #30
/*     */     //   Java source line #72	-> byte code offset #88
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	92	0	this	LintStandaloneTask
/*     */     //   17	75	1	configuration	Configuration
/*     */     //   24	68	2	attributes	Action
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.LintStandaloneTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */