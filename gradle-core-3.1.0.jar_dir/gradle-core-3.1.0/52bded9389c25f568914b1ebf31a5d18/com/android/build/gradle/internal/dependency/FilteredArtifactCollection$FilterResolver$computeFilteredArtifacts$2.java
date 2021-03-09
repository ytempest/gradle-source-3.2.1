/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.function.Function;
/*     */ import java.util.stream.Stream;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\022\n\000\n\002\030\002\n\002\020\016\n\000\n\002\020 \n\000\020\000\032\b\022\004\022\0020\0020\0012\f\020\003\032\b\022\004\022\0020\0020\004H\n¢\006\002\b\005"}, d2={"<anonymous>", "Ljava/util/stream/Stream;", "", "list", "", "apply"})
/*     */ final class FilteredArtifactCollection$FilterResolver$computeFilteredArtifacts$2<T, R>
/*     */   implements Function<T, Stream<? extends R>>
/*     */ {
/*     */   public static final 2 INSTANCE = new 2();
/*     */   
/*     */   @NotNull
/*     */   public final Stream<String> apply(@NotNull List<String> list)
/*     */   {
/* 137 */     Intrinsics.checkParameterIsNotNull(list, "list");return list.stream();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.FilteredArtifactCollection.FilterResolver.computeFilteredArtifacts.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */