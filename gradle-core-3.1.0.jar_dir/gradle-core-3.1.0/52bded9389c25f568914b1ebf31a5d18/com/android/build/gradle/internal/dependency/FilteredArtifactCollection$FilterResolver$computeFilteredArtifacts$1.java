/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.function.Function;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.Charsets;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\030\n\000\n\002\020!\n\002\020\016\n\000\n\002\020 \n\000\n\002\030\002\n\000\020\000\032&\022\f\022\n \003*\004\030\0010\0020\002 \003*\022\022\f\022\n \003*\004\030\0010\0020\002\030\0010\0040\0012\006\020\005\032\0020\006H\n¢\006\002\b\007"}, d2={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "", "file", "Ljava/io/File;", "apply"})
/*     */ final class FilteredArtifactCollection$FilterResolver$computeFilteredArtifacts$1<T, R>
/*     */   implements Function<T, R>
/*     */ {
/*     */   public static final 1 INSTANCE = new 1();
/*     */   
/*     */   public final List<String> apply(@NotNull File file)
/*     */   {
/* 134 */     Intrinsics.checkParameterIsNotNull(file, "file");
/* 135 */     return file.isFile() ? Files.readLines(file, Charsets.UTF_8) : CollectionsKt.emptyList();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.FilteredArtifactCollection.FilterResolver.computeFilteredArtifacts.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */