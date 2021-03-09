/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.build.VariantOutput.OutputType;
/*     */ import com.android.build.gradle.internal.scope.BuildOutput;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import java.io.File;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Collection;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2={"<anonymous>", "Lcom/android/build/gradle/internal/ide/EarlySyncBuildOutput;", "buildOutput", "Lcom/android/build/gradle/internal/scope/BuildOutput;", "invoke"})
/*     */ final class EarlySyncBuildOutput$Companion$load$2
/*     */   extends Lambda
/*     */   implements Function1<BuildOutput, EarlySyncBuildOutput>
/*     */ {
/*     */   @NotNull
/*     */   public final EarlySyncBuildOutput invoke(@NotNull BuildOutput buildOutput)
/*     */   {
/*  98 */     Intrinsics.checkParameterIsNotNull(buildOutput, "buildOutput"); TaskOutputHolder.OutputType 
/*  99 */       tmp14_11 = buildOutput.getType();Intrinsics.checkExpressionValueIsNotNull(tmp14_11, "buildOutput.type"); ApkInfo 
/* 100 */       tmp24_21 = buildOutput.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp24_21, "buildOutput.apkInfo"); VariantOutput.OutputType tmp35_30 = tmp24_21.getType();Intrinsics.checkExpressionValueIsNotNull(tmp35_30, "buildOutput.apkInfo.type"); ApkInfo 
/* 101 */       tmp45_42 = buildOutput.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp45_42, "buildOutput.apkInfo"); Collection tmp56_51 = tmp45_42.getFilters();Intrinsics.checkExpressionValueIsNotNull(tmp56_51, "buildOutput.apkInfo.filters"); ApkInfo 
/* 102 */       tmp66_63 = buildOutput.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp66_63, "buildOutput.apkInfo"); File 
/* 103 */       tmp95_90 = $projectPath.resolve(buildOutput.getOutputPath()).toFile();Intrinsics.checkExpressionValueIsNotNull(tmp95_90, "projectPath.resolve(buil…tput.outputPath).toFile()");return new EarlySyncBuildOutput(tmp14_11, tmp35_30, tmp56_51, tmp66_63.getVersionCode(), tmp95_90);
/*     */   }
/*     */   
/*     */   EarlySyncBuildOutput$Companion$load$2(Path paramPath)
/*     */   {
/*     */     super(1);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.EarlySyncBuildOutput.Companion.load.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */