/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ 
/*     */ public enum InstantRunVerifierStatus
/*     */ {
/*  26 */   NO_CHANGES(InstantRunBuildMode.HOT_WARM), 
/*     */   
/*  29 */   COMPATIBLE(InstantRunBuildMode.HOT_WARM), 
/*     */   
/*  32 */   NOT_RUN, 
/*     */   
/*  35 */   INSTANT_RUN_DISABLED, 
/*     */   
/*  38 */   INSTANT_RUN_FAILURE, 
/*     */   
/*  41 */   CLASS_ADDED, 
/*     */   
/*  44 */   PARENT_CLASS_CHANGED, 
/*  45 */   IMPLEMENTED_INTERFACES_CHANGE, 
/*     */   
/*  48 */   CLASS_ANNOTATION_CHANGE, 
/*  49 */   STATIC_INITIALIZER_CHANGE, 
/*     */   
/*  52 */   CONSTRUCTOR_SIGNATURE_CHANGE, 
/*  53 */   SYNTHETIC_CONSTRUCTOR_CHANGE, 
/*     */   
/*  56 */   METHOD_SIGNATURE_CHANGE, 
/*  57 */   METHOD_ANNOTATION_CHANGE, 
/*  58 */   METHOD_DELETED, 
/*  59 */   METHOD_ADDED, 
/*  60 */   ABSTRACT_METHOD_CHANGE, 
/*     */   
/*  63 */   FIELD_ADDED, 
/*  64 */   FIELD_REMOVED, 
/*     */   
/*  66 */   FIELD_TYPE_CHANGE, 
/*     */   
/*  68 */   R_CLASS_CHANGE, 
/*     */   
/*  71 */   REFLECTION_USED, 
/*     */   
/*  73 */   JAVA_RESOURCES_CHANGED, 
/*     */   
/*  75 */   BUILD_NOT_INCREMENTAL, 
/*  76 */   DEPENDENCY_CHANGED, 
/*     */   
/*  84 */   MANIFEST_FILE_CHANGE, 
/*     */   
/*  88 */   BINARY_MANIFEST_FILE_CHANGE, 
/*     */   
/*  90 */   COLD_SWAP_REQUESTED, 
/*     */   
/*  92 */   FULL_BUILD_REQUESTED(InstantRunBuildMode.FULL), 
/*     */   
/*  94 */   INITIAL_BUILD(InstantRunBuildMode.FULL);
/*     */   
/*     */   private final ImmutableMap<InstantRunPatchingPolicy, InstantRunBuildMode> buildMode;
/*     */   
/*     */   private InstantRunVerifierStatus() {
/*  99 */     this(InstantRunBuildMode.COLD);
/*     */   }
/*     */   
/*     */   private InstantRunVerifierStatus(InstantRunBuildMode multiApkBuildMode)
/*     */   {
/* 105 */     buildMode = ImmutableMap.of(InstantRunPatchingPolicy.MULTI_APK, multiApkBuildMode, InstantRunPatchingPolicy.MULTI_APK_SEPARATE_RESOURCES, multiApkBuildMode);
/*     */   }
/*     */   
/*     */   public InstantRunBuildMode getInstantRunBuildModeForPatchingPolicy(InstantRunPatchingPolicy patchingPolicy)
/*     */   {
/* 112 */     return (InstantRunBuildMode)buildMode.get(patchingPolicy);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunVerifierStatus
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */