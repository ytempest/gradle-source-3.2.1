/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.tools.lint.gradle.api.VariantInputs;
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000%\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\016\n\002\b\003\n\002\020 \n\002\b\003*\001\000\b\n\030\0002\0020\001B\005¢\006\002\020\002R\026\020\003\032\004\030\0010\004X\004¢\006\b\n\000\032\004\b\005\020\006R\026\020\007\032\004\030\0010\004X\004¢\006\b\n\000\032\004\b\b\020\006R\024\020\t\032\0020\nXD¢\006\b\n\000\032\004\b\013\020\fR\032\020\r\032\b\022\004\022\0020\0040\016X\004¢\006\b\n\000\032\004\b\017\020\020¨\006\021"}, d2={"com/android/build/gradle/internal/tasks/LintStandaloneTask$run$request$1$getVariantInputs$1", "Lcom/android/tools/lint/gradle/api/VariantInputs;", "(Lcom/android/build/gradle/internal/tasks/LintStandaloneTask$run$request$1;)V", "manifestMergeReport", "Ljava/io/File;", "getManifestMergeReport", "()Ljava/io/File;", "mergedManifest", "getMergedManifest", "name", "", "getName", "()Ljava/lang/String;", "ruleJars", "", "getRuleJars", "()Ljava/util/List;", "gradle-core"})
/*    */ public final class LintStandaloneTask$run$request$1$getVariantInputs$1
/*    */   implements VariantInputs
/*    */ {
/*    */   @NotNull
/*    */   private final String name = "";
/*    */   @NotNull
/*    */   private final List<File> ruleJars;
/*    */   @Nullable
/*    */   private final File mergedManifest;
/*    */   @Nullable
/*    */   private final File manifestMergeReport;
/*    */   
/*    */   @NotNull
/* 93 */   public String getName() { return name; } @NotNull
/* 94 */   public List<File> getRuleJars() { return ruleJars; }
/*    */   
/*    */   LintStandaloneTask$run$request$1$getVariantInputs$1()
/*    */   {
/* 93 */     name = "";
/* 94 */     ruleJars = LintStandaloneTask.access$computeLocalChecks(this$0); } @Nullable
/* 95 */   public File getMergedManifest() { return mergedManifest; } @Nullable
/* 96 */   public File getManifestMergeReport() { return manifestMergeReport; }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.LintStandaloneTask.run.request.1.getVariantInputs.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */