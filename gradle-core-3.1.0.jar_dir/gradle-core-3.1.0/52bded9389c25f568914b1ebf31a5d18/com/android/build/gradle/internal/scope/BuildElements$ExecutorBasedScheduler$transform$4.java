/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.ide.common.internal.WaitableExecutor.TaskResult;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\024\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\020\000\032\0020\0012*\020\002\032&\022\f\022\n \005*\004\030\0010\0040\004 \005*\022\022\f\022\n \005*\004\030\0010\0040\004\030\0010\0030\003H\n¢\006\002\b\006"}, d2={"<anonymous>", "Lcom/android/build/gradle/internal/scope/BuildOutput;", "it", "Lcom/android/ide/common/internal/WaitableExecutor$TaskResult;", "Lcom/android/build/gradle/internal/scope/BuildElements$ActionItem;", "kotlin.jvm.PlatformType", "invoke"})
/*     */ final class BuildElements$ExecutorBasedScheduler$transform$4
/*     */   extends Lambda
/*     */   implements Function1<WaitableExecutor.TaskResult<BuildElements.ActionItem>, BuildOutput>
/*     */ {
/*     */   @NotNull
/*     */   public final BuildOutput invoke(WaitableExecutor.TaskResult<BuildElements.ActionItem> it)
/*     */   {
/* 138 */     WaitableExecutor.TaskResult tmp12_11 = it;Intrinsics.checkExpressionValueIsNotNull(tmp12_11, "it"); Object tmp21_18 = tmp12_11.getValue(); if (tmp21_18 == null) throw new TypeCastException("null cannot be cast to non-null type com.android.build.gradle.internal.scope.BuildElements.ActionItem");
/* 139 */     Object tmp45_42 = it.getValue();
/*     */     
/* 139 */     if (tmp45_42 == null) throw new TypeCastException("null cannot be cast to non-null type com.android.build.gradle.internal.scope.BuildElements.ActionItem"); File tmp65_62 = ((BuildElements.ActionItem)tmp45_42).getOutput();
/*     */     
/* 139 */     if (tmp65_62 == null) Intrinsics.throwNpe(); return new BuildOutput((TaskOutputHolder.OutputType)$to, ((BuildElements.ActionItem)tmp21_18).getApkInfo(), tmp65_62);
/*     */   }
/*     */   
/*     */   BuildElements$ExecutorBasedScheduler$transform$4(TaskOutputHolder.TaskOutputType paramTaskOutputType)
/*     */   {
/*     */     super(1);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildElements.ExecutorBasedScheduler.transform.4
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */