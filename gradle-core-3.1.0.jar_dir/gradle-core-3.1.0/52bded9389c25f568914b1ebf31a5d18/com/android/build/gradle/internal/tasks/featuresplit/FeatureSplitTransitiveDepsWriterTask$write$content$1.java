/*    */ package com.android.build.gradle.internal.tasks.featuresplit;
/*    */ 
/*    */ import java.util.function.Function;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.artifacts.result.ResolvedArtifactResult;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "artifact", "Lorg/gradle/api/artifacts/result/ResolvedArtifactResult;", "kotlin.jvm.PlatformType", "apply"})
/*    */ final class FeatureSplitTransitiveDepsWriterTask$write$content$1<T, R>
/*    */   implements Function<T, R>
/*    */ {
/*    */   public static final 1 INSTANCE = new 1();
/*    */   
/*    */   @NotNull
/*    */   public final String apply(ResolvedArtifactResult artifact)
/*    */   {
/* 63 */     ResolvedArtifactResult tmp1_0 = artifact;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "artifact");return FeatureSplitTransitiveDepsWriterTaskKt.compIdToString(tmp1_0);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.featuresplit.FeatureSplitTransitiveDepsWriterTask.write.content.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */