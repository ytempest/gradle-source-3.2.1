/*     */ package com.android.build.gradle.internal.errors;
/*     */ 
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter.Severity;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.ImmutableTable;
/*     */ import com.google.common.collect.Table.Cell;
/*     */ import com.google.common.collect.UnmodifiableIterator;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\n\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J \020\007\032\0020\b2\006\020\t\032\0020\0052\006\020\n\032\0020\0052\006\020\013\032\0020\fH\026J\"\020\r\032\0020\b2\006\020\016\032\0020\0052\b\020\017\032\004\030\0010\0052\006\020\013\032\0020\fH\026J\"\020\020\032\0020\b2\030\020\021\032\024\022\004\022\0020\005\022\004\022\0020\005\022\004\022\0020\f0\022H\026J \020\023\032\0020\b2\006\020\024\032\0020\0052\006\020\025\032\0020\0052\006\020\013\032\0020\fH\026J(\020\023\032\0020\b2\006\020\024\032\0020\0052\006\020\025\032\0020\0052\006\020\026\032\0020\0052\006\020\013\032\0020\fH\026J4\020\027\032\0020\b2\006\020\030\032\0020\0052\006\020\031\032\0020\0052\b\020\032\032\004\030\0010\0052\b\020\026\032\004\030\0010\0052\006\020\013\032\0020\fH\026J\030\020\033\032\0020\b2\006\020\025\032\0020\0052\006\020\013\032\0020\fH\026J \020\033\032\0020\b2\006\020\025\032\0020\0052\006\020\026\032\0020\0052\006\020\013\032\0020\fH\026R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000¨\006\034"}, d2={"Lcom/android/build/gradle/internal/errors/DeprecationReporterImpl;", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "projectPath", "", "(Lcom/android/builder/errors/EvalIssueReporter;Ljava/lang/String;)V", "reportDeprecatedConfiguration", "", "newConfiguration", "oldConfiguration", "deprecationTarget", "Lcom/android/build/gradle/internal/errors/DeprecationReporter$DeprecationTarget;", "reportDeprecatedOption", "option", "value", "reportDeprecatedOptions", "options", "Lcom/google/common/collect/ImmutableTable;", "reportDeprecatedUsage", "newDslElement", "oldDslElement", "url", "reportDeprecatedValue", "dslElement", "oldValue", "newValue", "reportObsoleteUsage", "gradle-core"})
/*     */ public final class DeprecationReporterImpl
/*     */   implements DeprecationReporter
/*     */ {
/*     */   private final EvalIssueReporter issueReporter;
/*     */   private final String projectPath;
/*     */   
/*     */   public DeprecationReporterImpl(@NotNull EvalIssueReporter issueReporter, @NotNull String projectPath)
/*     */   {
/*  25 */     this.issueReporter = issueReporter;this.projectPath = projectPath;
/*     */   }
/*     */   
/*     */   public void reportDeprecatedUsage(@NotNull String newDslElement, @NotNull String oldDslElement, @NotNull DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */   {
/*  33 */     Intrinsics.checkParameterIsNotNull(newDslElement, "newDslElement");Intrinsics.checkParameterIsNotNull(oldDslElement, "oldDslElement");Intrinsics.checkParameterIsNotNull(deprecationTarget, "deprecationTarget");issueReporter.reportIssue(
/*  34 */       EvalIssueReporter.Type.DEPRECATED_DSL, 
/*  35 */       EvalIssueReporter.Severity.WARNING, 
/*  36 */       "DSL element '" + oldDslElement + "' is obsolete and has been replaced with '" + newDslElement + "'.\n" + "It will be removed " + 
/*  37 */       deprecationTarget.getRemovalTime(), 
/*  38 */       "" + oldDslElement + "::" + newDslElement + "::" + deprecationTarget.name());
/*     */   }
/*     */   
/*     */   public void reportDeprecatedUsage(@NotNull String newDslElement, @NotNull String oldDslElement, @NotNull String url, @NotNull DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */   {
/*  46 */     Intrinsics.checkParameterIsNotNull(newDslElement, "newDslElement");Intrinsics.checkParameterIsNotNull(oldDslElement, "oldDslElement");Intrinsics.checkParameterIsNotNull(url, "url");Intrinsics.checkParameterIsNotNull(deprecationTarget, "deprecationTarget");issueReporter.reportIssue(
/*  47 */       EvalIssueReporter.Type.DEPRECATED_DSL, 
/*  48 */       EvalIssueReporter.Severity.WARNING, 
/*  49 */       "DSL element '" + oldDslElement + "' is obsolete and has been replaced with '" + newDslElement + "'.\n" + "It will be removed " + 
/*  50 */       deprecationTarget.getRemovalTime() + '\n' + "For more information, see " + 
/*  51 */       url, 
/*  52 */       "" + oldDslElement + "::" + newDslElement + "::" + deprecationTarget.name());
/*     */   }
/*     */   
/*     */   public void reportObsoleteUsage(@NotNull String oldDslElement, @NotNull DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */   {
/*  57 */     Intrinsics.checkParameterIsNotNull(oldDslElement, "oldDslElement");Intrinsics.checkParameterIsNotNull(deprecationTarget, "deprecationTarget");issueReporter.reportIssue(
/*  58 */       EvalIssueReporter.Type.DEPRECATED_DSL, 
/*  59 */       EvalIssueReporter.Severity.WARNING, 
/*  60 */       "DSL element '" + oldDslElement + "' is obsolete and will be removed " + deprecationTarget.getRemovalTime(), 
/*  61 */       "" + oldDslElement + "::::" + deprecationTarget.name());
/*     */   }
/*     */   
/*     */   public void reportObsoleteUsage(@NotNull String oldDslElement, @NotNull String url, @NotNull DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */   {
/*  68 */     Intrinsics.checkParameterIsNotNull(oldDslElement, "oldDslElement");Intrinsics.checkParameterIsNotNull(url, "url");Intrinsics.checkParameterIsNotNull(deprecationTarget, "deprecationTarget");issueReporter.reportIssue(
/*  69 */       EvalIssueReporter.Type.DEPRECATED_DSL, 
/*  70 */       EvalIssueReporter.Severity.WARNING, 
/*  71 */       "DSL element '" + oldDslElement + "' is obsolete and will be removed " + deprecationTarget.getRemovalTime() + '\n' + "For more information, see " + 
/*  72 */       url, 
/*  73 */       "" + oldDslElement + "::::" + deprecationTarget.name());
/*     */   }
/*     */   
/*     */   public void reportDeprecatedConfiguration(@NotNull String newConfiguration, @NotNull String oldConfiguration, @NotNull DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */   {
/*  80 */     Intrinsics.checkParameterIsNotNull(newConfiguration, "newConfiguration");Intrinsics.checkParameterIsNotNull(oldConfiguration, "oldConfiguration");Intrinsics.checkParameterIsNotNull(deprecationTarget, "deprecationTarget");issueReporter.reportIssue(
/*  81 */       EvalIssueReporter.Type.DEPRECATED_CONFIGURATION, 
/*  82 */       EvalIssueReporter.Severity.WARNING, 
/*  83 */       "Configuration '" + oldConfiguration + "' is obsolete and has been replaced with '" + newConfiguration + "'.\n" + "It will be removed " + 
/*  84 */       deprecationTarget.getRemovalTime(), 
/*  85 */       "" + oldConfiguration + "::" + newConfiguration + "::" + deprecationTarget.name());
/*     */   }
/*     */   
/*     */   public void reportDeprecatedValue(@NotNull String dslElement, @NotNull String oldValue, @Nullable String newValue, @Nullable String url, @NotNull DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */   {
/*  93 */     Intrinsics.checkParameterIsNotNull(dslElement, "dslElement");Intrinsics.checkParameterIsNotNull(oldValue, "oldValue");Intrinsics.checkParameterIsNotNull(deprecationTarget, "deprecationTarget");issueReporter.reportIssue(EvalIssueReporter.Type.DEPRECATED_DSL_VALUE, 
/*  94 */       EvalIssueReporter.Severity.WARNING, 
/*  95 */       "DSL element '" + dslElement + "' has a value '" + oldValue + "' which is obsolete " + (
/*  96 */       newValue != null ? 
/*  97 */       "and has been replaced with '" + newValue + "'.\n" : 
/*     */       
/*  99 */       new StringBuilder().append("and has not been replaced.\n").append("It will be removed ")
/* 100 */       .append(deprecationTarget.getRemovalTime()).append('\n').toString()), 
/* 101 */       url);
/*     */   }
/*     */   
/*     */   public void reportDeprecatedOption(@NotNull String option, @Nullable String value, @NotNull DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */   {
/* 109 */     Intrinsics.checkParameterIsNotNull(option, "option");Intrinsics.checkParameterIsNotNull(deprecationTarget, "deprecationTarget");issueReporter.reportIssue(
/* 110 */       EvalIssueReporter.Type.GENERIC, 
/* 111 */       EvalIssueReporter.Severity.WARNING, 
/* 112 */       "The option '" + option + "' is deprecated and should not be used anymore.\n" + (
/* 113 */       value != null ? "Use '" + option + '=' + value + "' to remove this warning.\n" : "") + "It will be removed " + 
/* 114 */       deprecationTarget.getRemovalTime() + '.');
/*     */   }
/*     */   
/*     */   public void reportDeprecatedOptions(@NotNull ImmutableTable<String, String, DeprecationReporter.DeprecationTarget> options)
/*     */   {
/* 119 */     Intrinsics.checkParameterIsNotNull(options, "options"); for (UnmodifiableIterator localUnmodifiableIterator = options.cellSet().iterator(); localUnmodifiableIterator.hasNext(); 
/* 120 */         reportDeprecatedOption((String)tmp49_42, (String)cell.getColumnKey(), (DeprecationReporter.DeprecationTarget)tmp80_73))
/*     */     {
/* 119 */       Table.Cell cell = (Table.Cell)localUnmodifiableIterator.next(); Table.Cell 
/* 120 */         tmp31_30 = cell;Intrinsics.checkExpressionValueIsNotNull(tmp31_30, "cell"); Object tmp42_37 = tmp31_30.getRowKey(); if (tmp42_37 == null) Intrinsics.throwNpe(); Intrinsics.checkExpressionValueIsNotNull(tmp42_37, "cell.rowKey!!"); Object tmp73_68 = cell.getValue(); if (tmp73_68 == null) Intrinsics.throwNpe(); Intrinsics.checkExpressionValueIsNotNull(tmp73_68, "cell.value!!");
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.errors.DeprecationReporterImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */