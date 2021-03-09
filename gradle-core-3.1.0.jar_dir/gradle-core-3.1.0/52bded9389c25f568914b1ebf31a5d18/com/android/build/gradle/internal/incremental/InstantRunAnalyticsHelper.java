/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.google.common.annotations.VisibleForTesting;
/*     */ import com.google.wireless.android.sdk.stats.InstantRunArtifact;
/*     */ import com.google.wireless.android.sdk.stats.InstantRunArtifact.Builder;
/*     */ import com.google.wireless.android.sdk.stats.InstantRunArtifact.Type;
/*     */ import com.google.wireless.android.sdk.stats.InstantRunStatus;
/*     */ import com.google.wireless.android.sdk.stats.InstantRunStatus.BuildMode;
/*     */ import com.google.wireless.android.sdk.stats.InstantRunStatus.Builder;
/*     */ import com.google.wireless.android.sdk.stats.InstantRunStatus.PatchingPolicy;
/*     */ import com.google.wireless.android.sdk.stats.InstantRunStatus.VerifierStatus;
/*     */ 
/*     */ public class InstantRunAnalyticsHelper
/*     */ {
/*     */   public static InstantRunStatus generateAnalyticsProto(InstantRunBuildContext buildContext)
/*     */   {
/*  31 */     InstantRunStatus.Builder builder = InstantRunStatus.newBuilder();
/*     */     
/*  33 */     builder.setBuildMode(convert(buildContext.getBuildMode()));
/*  34 */     builder.setPatchingPolicy(convert(buildContext.getPatchingPolicy()));
/*  35 */     builder.setVerifierStatus(convert(buildContext.getVerifierResult()));
/*     */     
/*  37 */     InstantRunBuildContext.Build last = buildContext.getLastBuild();
/*  38 */     if (last != null) {
/*  39 */       for (InstantRunBuildContext.Artifact artifact : last.getArtifacts()) {
/*  40 */         builder.addArtifact(
/*  41 */           InstantRunArtifact.newBuilder().setType(convert(artifact.getType())));
/*     */       }
/*     */     }
/*  44 */     return builder.build();
/*     */   }
/*     */   
/*     */   @VisibleForTesting
/*     */   static InstantRunStatus.BuildMode convert(InstantRunBuildMode mode)
/*     */   {
/*  51 */     switch (mode) {
/*     */     case HOT_WARM: 
/*  53 */       return InstantRunStatus.BuildMode.HOT_WARM;
/*     */     case COLD: 
/*  55 */       return InstantRunStatus.BuildMode.COLD;
/*     */     case FULL: 
/*  57 */       return InstantRunStatus.BuildMode.FULL;
/*     */     }
/*  59 */     return InstantRunStatus.BuildMode.UNKNOWN_BUILD_MODE;
/*     */   }
/*     */   
/*     */   @VisibleForTesting
/*     */   static InstantRunStatus.PatchingPolicy convert(InstantRunPatchingPolicy policy)
/*     */   {
/*  66 */     if (policy == null) {
/*  67 */       return InstantRunStatus.PatchingPolicy.UNKNOWN_PATCHING_POLICY;
/*     */     }
/*  69 */     switch (policy) {
/*     */     case MULTI_APK: 
/*  71 */       return InstantRunStatus.PatchingPolicy.MULTI_APK;
/*     */     case MULTI_APK_SEPARATE_RESOURCES: 
/*  73 */       return InstantRunStatus.PatchingPolicy.MULTI_APK_SEPARATE_RESOURCES;
/*     */     }
/*  75 */     return InstantRunStatus.PatchingPolicy.UNKNOWN_PATCHING_POLICY;
/*     */   }
/*     */   
/*     */   @VisibleForTesting
/*     */   static InstantRunStatus.VerifierStatus convert(InstantRunVerifierStatus status)
/*     */   {
/*     */     try
/*     */     {
/*  83 */       return InstantRunStatus.VerifierStatus.valueOf(status.toString());
/*     */     } catch (IllegalArgumentException ignored) {}
/*  85 */     return InstantRunStatus.VerifierStatus.UNKNOWN_VERIFIER_STATUS;
/*     */   }
/*     */   
/*     */   @VisibleForTesting
/*     */   static InstantRunArtifact.Type convert(FileType type)
/*     */   {
/*  92 */     switch (type) {
/*     */     case MAIN: 
/*  94 */       return InstantRunArtifact.Type.MAIN;
/*     */     case SPLIT_MAIN: 
/*  96 */       return InstantRunArtifact.Type.SPLIT_MAIN;
/*     */     case RELOAD_DEX: 
/*  98 */       return InstantRunArtifact.Type.RELOAD_DEX;
/*     */     case SPLIT: 
/* 100 */       return InstantRunArtifact.Type.SPLIT;
/*     */     case RESOURCES: 
/* 102 */       return InstantRunArtifact.Type.RESOURCES;
/*     */     }
/* 104 */     throw new RuntimeException("Cannot convert " + type);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunAnalyticsHelper
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */