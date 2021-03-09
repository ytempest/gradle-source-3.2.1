/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import com.android.build.gradle.internal.tasks.featuresplit.FeatureSplitTransitiveDepsWriterTaskKt;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.Charsets;
/*     */ import org.gradle.api.artifacts.ArtifactCollection;
/*     */ import org.gradle.api.artifacts.result.ResolvedArtifactResult;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000>\n\002\030\002\n\002\030\002\n\002\020\036\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020#\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\020\"\n\002\020\016\n\002\b\003\b\002\030\0002\016\022\n\022\b\022\004\022\0020\0030\0020\001B\025\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\b\020\017\032\0020\020H\002J\016\020\021\032\b\022\004\022\0020\0230\022H\002J\016\020\024\032\b\022\004\022\0020\0030\002H\027J\f\020\025\032\b\022\004\022\0020\0130\022R\026\020\t\032\n\022\004\022\0020\013\030\0010\nX\016¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\026\020\f\032\n\022\004\022\0020\003\030\0010\002X\016¢\006\002\n\000R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\r\020\016¨\006\026"}, d2={"Lcom/android/build/gradle/internal/dependency/FilteredArtifactCollection$FilterResolver;", "Ljava/util/function/Supplier;", "", "Ljava/io/File;", "mainArtifacts", "Lorg/gradle/api/artifacts/ArtifactCollection;", "directoryArtifacts", "Lorg/gradle/api/file/FileCollection;", "(Lorg/gradle/api/artifacts/ArtifactCollection;Lorg/gradle/api/file/FileCollection;)V", "artifactResults", "", "Lorg/gradle/api/artifacts/result/ResolvedArtifactResult;", "files", "getMainArtifacts", "()Lorg/gradle/api/artifacts/ArtifactCollection;", "computeCollection", "", "computeFilteredArtifacts", "", "", "get", "getArtifactResults", "gradle-core"})
/*     */ final class FilteredArtifactCollection$FilterResolver
/*     */   implements Supplier<Collection<? extends File>>
/*     */ {
/*     */   private Set<ResolvedArtifactResult> artifactResults;
/*     */   private Collection<? extends File> files;
/*     */   @NotNull
/*     */   private final ArtifactCollection mainArtifacts;
/*     */   private final FileCollection directoryArtifacts;
/*     */   
/*     */   public FilteredArtifactCollection$FilterResolver(@NotNull ArtifactCollection mainArtifacts, @NotNull FileCollection directoryArtifacts)
/*     */   {
/*  80 */     this.mainArtifacts = mainArtifacts;this.directoryArtifacts = directoryArtifacts; } @NotNull
/*  81 */   public final ArtifactCollection getMainArtifacts() { return mainArtifacts; }
/*     */   
/*     */   @NotNull
/*     */   public final Set<ResolvedArtifactResult> getArtifactResults()
/*     */   {
/*  89 */     computeCollection(); Set 
/*  90 */       tmp8_5 = artifactResults;
/*  90 */     if (tmp8_5 == null) Intrinsics.throwNpe(); return tmp8_5;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Collection<File> get() throws Exception {
/*  95 */     computeCollection(); Collection 
/*  96 */       tmp8_5 = files;
/*  96 */     if (tmp8_5 == null) Intrinsics.throwNpe(); return tmp8_5;
/*     */   }
/*     */   
/*     */   private final void computeCollection() {
/* 100 */     synchronized (this) { int $i$a$1$synchronized;
/* 101 */       if (artifactResults == null)
/*     */       {
/* 103 */         Set filteredArtifacts = computeFilteredArtifacts();
/*     */         
/* 105 */         if (filteredArtifacts.isEmpty()) {
/* 106 */           artifactResults = mainArtifacts.getArtifacts(); FileCollection 
/* 107 */             tmp49_44 = mainArtifacts.getArtifactFiles();Intrinsics.checkExpressionValueIsNotNull(tmp49_44, "mainArtifacts.artifactFiles");files = ((Collection)tmp49_44.getFiles());
/*     */         }
/*     */         else
/*     */         {
/* 112 */           results = Sets.newLinkedHashSet();
/* 113 */           ImmutableList.Builder builder = ImmutableList.builder();
/* 114 */           for (ResolvedArtifactResult artifactResult : mainArtifacts.getArtifacts())
/*     */           {
/* 116 */             ResolvedArtifactResult tmp119_117 = artifactResult;Intrinsics.checkExpressionValueIsNotNull(tmp119_117, "artifactResult"); if (!filteredArtifacts.contains(FeatureSplitTransitiveDepsWriterTaskKt.compIdToString(tmp119_117))) {
/* 117 */               results.add(artifactResult);
/* 118 */               builder.add(artifactResult.getFile());
/*     */             }
/*     */           }
/*     */           
/* 122 */           artifactResults = ((Set)results);
/* 123 */           files = ((Collection)builder.build());
/*     */         }
/*     */       }
/* 100 */       results = 
/*     */       
/* 126 */         Unit.INSTANCE;
/*     */     }
/*     */   }
/*     */   
/*     */   private final Set<String> computeFilteredArtifacts()
/*     */   {
/* 138 */     Object tmp44_39 = directoryArtifacts.getFiles().stream().map((Function)computeFilteredArtifacts.1.INSTANCE).flatMap((Function)computeFilteredArtifacts.2.INSTANCE).collect(Collectors.toSet());Intrinsics.checkExpressionValueIsNotNull(tmp44_39, "directoryArtifacts\n     …llectors.toSet<String>())");return (Set)tmp44_39;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.FilteredArtifactCollection.FilterResolver
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */