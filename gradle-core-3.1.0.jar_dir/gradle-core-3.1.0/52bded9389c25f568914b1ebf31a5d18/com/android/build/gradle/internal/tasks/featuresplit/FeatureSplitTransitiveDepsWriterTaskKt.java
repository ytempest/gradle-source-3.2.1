/*     */ package com.android.build.gradle.internal.tasks.featuresplit;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.artifacts.component.ComponentArtifactIdentifier;
/*     */ import org.gradle.api.artifacts.component.ComponentIdentifier;
/*     */ import org.gradle.api.artifacts.component.ModuleComponentIdentifier;
/*     */ import org.gradle.api.artifacts.component.ProjectComponentIdentifier;
/*     */ import org.gradle.api.artifacts.result.ResolvedArtifactResult;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000\020\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\032\016\020\000\032\0020\0012\006\020\002\032\0020\003\032\020\020\004\032\004\030\0010\0012\006\020\002\032\0020\003¨\006\005"}, d2={"compIdToString", "", "artifact", "Lorg/gradle/api/artifacts/result/ResolvedArtifactResult;", "getVariant", "gradle-core"})
/*     */ public final class FeatureSplitTransitiveDepsWriterTaskKt
/*     */ {
/*     */   @NotNull
/*     */   public static final String compIdToString(@NotNull ResolvedArtifactResult artifact)
/*     */   {
/*  91 */     Intrinsics.checkParameterIsNotNull(artifact, "artifact"); ComponentArtifactIdentifier tmp12_7 = artifact.getId();Intrinsics.checkExpressionValueIsNotNull(tmp12_7, "artifact.id");ComponentIdentifier id = tmp12_7.getComponentIdentifier();
/*  92 */     ComponentIdentifier localComponentIdentifier1 = id;
/*  93 */     if ((localComponentIdentifier1 instanceof ProjectComponentIdentifier)) {
/*  94 */       String variant = getVariant(artifact);
/*  95 */       if (variant == null) {
/*  96 */         String tmp51_46 = ((ProjectComponentIdentifier)id).getProjectPath();Intrinsics.checkExpressionValueIsNotNull(tmp51_46, "id.projectPath");return tmp51_46;
/*     */       }
/*  98 */       return ((ProjectComponentIdentifier)id).getProjectPath() + "::" + variant;
/*     */     }
/*     */     
/* 101 */     if ((localComponentIdentifier1 instanceof ModuleComponentIdentifier)) { return ((ModuleComponentIdentifier)id).getGroup() + ":" + ((ModuleComponentIdentifier)id).getModule();
/*     */     }
/* 103 */     return id.toString();
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @org.jetbrains.annotations.Nullable
/*     */   public static final String getVariant(@NotNull ResolvedArtifactResult artifact)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: ldc 9
/*     */     //   3: invokestatic 15	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_0
/*     */     //   7: invokeinterface 82 1 0
/*     */     //   12: dup
/*     */     //   13: ldc 84
/*     */     //   15: invokestatic 26	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   18: invokeinterface 90 1 0
/*     */     //   23: getstatic 96	com/android/build/api/attributes/VariantAttr:ATTRIBUTE	Lorg/gradle/api/attributes/Attribute;
/*     */     //   26: invokeinterface 102 2 0
/*     */     //   31: checkcast 92	com/android/build/api/attributes/VariantAttr
/*     */     //   34: dup
/*     */     //   35: ifnull +11 -> 46
/*     */     //   38: invokeinterface 105 1 0
/*     */     //   43: goto +5 -> 48
/*     */     //   46: pop
/*     */     //   47: aconst_null
/*     */     //   48: areturn
/*     */     // Line number table:
/*     */     //   Java source line #108	-> byte code offset #6
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	49	0	artifact	ResolvedArtifactResult
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.featuresplit.FeatureSplitTransitiveDepsWriterTaskKt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */