/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import java.io.File;
/*     */ import java.util.concurrent.Callable;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function2;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2={"<anonymous>", "Lcom/android/build/gradle/internal/scope/BuildElements$ActionItem;", "call"})
/*     */ final class BuildElements$ExecutorBasedScheduler$transform$$inlined$forEach$lambda$1<V>
/*     */   implements Callable<BuildElements.ActionItem>
/*     */ {
/*     */   BuildElements$ExecutorBasedScheduler$transform$$inlined$forEach$lambda$1(BuildOutput paramBuildOutput, BuildElements.ExecutorBasedScheduler paramExecutorBasedScheduler, Function2 paramFunction2) {}
/*     */   
/*     */   @NotNull
/*     */   public final BuildElements.ActionItem call()
/*     */   {
/* 121 */     ApkInfo tmp11_8 = $it.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp11_8, "it.apkInfo"); ApkInfo tmp28_25 = $it.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp28_25, "it.apkInfo"); File tmp41_38 = $it.getOutputFile();Intrinsics.checkExpressionValueIsNotNull(tmp41_38, "it.outputFile");return new BuildElements.ActionItem(tmp11_8, (File)$action$inlined.invoke(tmp28_25, tmp41_38));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildElements.ExecutorBasedScheduler.transform..inlined.forEach.lambda.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */