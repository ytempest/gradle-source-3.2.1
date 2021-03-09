/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.SecondaryFile;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunVerifierStatus;
/*     */ import java.io.File;
/*     */ 
/*     */ class InstantRunSplitApkBuilder$SplitSecondaryFile
/*     */   extends SecondaryFile
/*     */ {
/*     */   public InstantRunSplitApkBuilder$SplitSecondaryFile(InstantRunSplitApkBuilder paramInstantRunSplitApkBuilder, File secondaryInputFile)
/*     */   {
/* 155 */     super(secondaryInputFile, true);
/*     */   }
/*     */   
/*     */   public boolean supportsIncrementalBuild()
/*     */   {
/* 162 */     return !this$0.buildContext.hasVerifierStatusBeenSet(InstantRunVerifierStatus.MANIFEST_FILE_CHANGE);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunSplitApkBuilder.SplitSecondaryFile
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */