/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import com.android.build.gradle.internal.tasks.TaskInputHelper;
/*     */ import com.android.build.gradle.internal.tasks.featuresplit.FeatureSplitTransitiveDepsWriterTaskKt;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.Unit;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.TypeIntrinsics;
/*     */ import kotlin.text.Charsets;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.artifacts.ArtifactCollection;
/*     */ import org.gradle.api.artifacts.result.ResolvedArtifactResult;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000P\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\"\n\000\n\002\020\036\n\002\020\003\n\000\n\002\020)\n\000\n\002\030\002\n\002\b\003\030\0002\0020\001:\001\033B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\001\022\006\020\005\032\0020\006¢\006\002\020\007J\030\020\013\032\0020\f2\016\020\r\032\n\022\006\b\000\022\0020\0170\016H\026J\b\020\020\032\0020\006H\026J\016\020\021\032\b\022\004\022\0020\0170\022H\026J\016\020\023\032\b\022\004\022\0020\0250\024H\026J\017\020\026\032\b\022\004\022\0020\0170\027H\002J\026\020\030\032\020\022\f\022\n \032*\004\030\0010\0170\0170\031H\026R\016\020\b\032\0020\006X\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000¨\006\034"}, d2={"Lcom/android/build/gradle/internal/dependency/FilteredArtifactCollection;", "Lorg/gradle/api/artifacts/ArtifactCollection;", "project", "Lorg/gradle/api/Project;", "mainArtifact", "excludeDirectoryFiles", "Lorg/gradle/api/file/FileCollection;", "(Lorg/gradle/api/Project;Lorg/gradle/api/artifacts/ArtifactCollection;Lorg/gradle/api/file/FileCollection;)V", "fileCollection", "filterResolver", "Lcom/android/build/gradle/internal/dependency/FilteredArtifactCollection$FilterResolver;", "forEach", "", "action", "Ljava/util/function/Consumer;", "Lorg/gradle/api/artifacts/result/ResolvedArtifactResult;", "getArtifactFiles", "getArtifacts", "", "getFailures", "", "", "iterator", "", "spliterator", "Ljava/util/Spliterator;", "kotlin.jvm.PlatformType", "FilterResolver", "gradle-core"})
/*     */ public final class FilteredArtifactCollection
/*     */   implements ArtifactCollection
/*     */ {
/*     */   private final FileCollection fileCollection;
/*     */   private final FilterResolver filterResolver;
/*     */   
/*     */   public FilteredArtifactCollection(@NotNull Project project, @NotNull ArtifactCollection mainArtifact, @NotNull FileCollection excludeDirectoryFiles)
/*     */   {
/*  52 */     filterResolver = new FilterResolver(mainArtifact, excludeDirectoryFiles); Object[] 
/*     */     
/*  58 */       tmp63_60 = new Object[1]; FileCollection 
/*  59 */       tmp71_66 = mainArtifact.getArtifactFiles();Intrinsics.checkExpressionValueIsNotNull(tmp71_66, "mainArtifact.artifactFiles");tmp63_60[0] = tmp71_66.getBuildDependencies(); ConfigurableFileCollection 
/*  60 */       tmp106_101 = project.files(new Object[] { TaskInputHelper.bypassFileCallable((Supplier)filterResolver) }).builtBy(tmp63_60).builtBy(new Object[] {excludeDirectoryFiles.getBuildDependencies() });Intrinsics.checkExpressionValueIsNotNull(tmp106_101, "project.files(TaskInputH…yFiles.buildDependencies)");fileCollection = ((FileCollection)tmp106_101); }
/*     */   
/*     */   @NotNull
/*  63 */   public FileCollection getArtifactFiles() { return fileCollection; }
/*     */   @NotNull
/*  65 */   public Set<ResolvedArtifactResult> getArtifacts() { return filterResolver.getArtifactResults(); }
/*     */   
/*     */   @NotNull
/*  68 */   public Collection<Throwable> getFailures() { ImmutableList.Builder builder = ImmutableList.builder();
/*  69 */     builder.addAll((Iterable)filterResolver.getMainArtifacts().getFailures()); ImmutableList 
/*  70 */       tmp28_25 = builder.build();Intrinsics.checkExpressionValueIsNotNull(tmp28_25, "builder.build()");return (Collection)tmp28_25; }
/*     */   
/*     */   @NotNull
/*  73 */   public Iterator<ResolvedArtifactResult> iterator() { Iterator tmp9_4 = getArtifacts().iterator();
/*     */     
/*  73 */     if (tmp9_4 == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableIterator<org.gradle.api.artifacts.result.ResolvedArtifactResult>"); return TypeIntrinsics.asMutableIterator(tmp9_4); } @NotNull
/*  74 */   public Spliterator<ResolvedArtifactResult> spliterator() { return getArtifacts().spliterator(); }
/*     */   
/*     */   public void forEach(@NotNull Consumer<? super ResolvedArtifactResult> action) {
/*  77 */     Intrinsics.checkParameterIsNotNull(action, "action");getArtifacts().forEach(action); }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000>\n\002\030\002\n\002\030\002\n\002\020\036\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020#\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\020\"\n\002\020\016\n\002\b\003\b\002\030\0002\016\022\n\022\b\022\004\022\0020\0030\0020\001B\025\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\b\020\017\032\0020\020H\002J\016\020\021\032\b\022\004\022\0020\0230\022H\002J\016\020\024\032\b\022\004\022\0020\0030\002H\027J\f\020\025\032\b\022\004\022\0020\0130\022R\026\020\t\032\n\022\004\022\0020\013\030\0010\nX\016¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\026\020\f\032\n\022\004\022\0020\003\030\0010\002X\016¢\006\002\n\000R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\r\020\016¨\006\026"}, d2={"Lcom/android/build/gradle/internal/dependency/FilteredArtifactCollection$FilterResolver;", "Ljava/util/function/Supplier;", "", "Ljava/io/File;", "mainArtifacts", "Lorg/gradle/api/artifacts/ArtifactCollection;", "directoryArtifacts", "Lorg/gradle/api/file/FileCollection;", "(Lorg/gradle/api/artifacts/ArtifactCollection;Lorg/gradle/api/file/FileCollection;)V", "artifactResults", "", "Lorg/gradle/api/artifacts/result/ResolvedArtifactResult;", "files", "getMainArtifacts", "()Lorg/gradle/api/artifacts/ArtifactCollection;", "computeCollection", "", "computeFilteredArtifacts", "", "", "get", "getArtifactResults", "gradle-core"})
/*  80 */   private static final class FilterResolver implements Supplier<Collection<? extends File>> { public FilterResolver(@NotNull ArtifactCollection mainArtifacts, @NotNull FileCollection directoryArtifacts) { this.mainArtifacts = mainArtifacts;this.directoryArtifacts = directoryArtifacts; } @NotNull
/*  81 */     public final ArtifactCollection getMainArtifacts() { return mainArtifacts; }
/*     */     
/*     */     private Set<ResolvedArtifactResult> artifactResults;
/*     */     private Collection<? extends File> files;
/*     */     @NotNull
/*     */     public final Set<ResolvedArtifactResult> getArtifactResults()
/*     */     {
/*  89 */       computeCollection(); Set 
/*  90 */         tmp8_5 = artifactResults;
/*  90 */       if (tmp8_5 == null) Intrinsics.throwNpe(); return tmp8_5;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public Collection<File> get() throws Exception {
/*  95 */       computeCollection(); Collection 
/*  96 */         tmp8_5 = files;
/*  96 */       if (tmp8_5 == null) Intrinsics.throwNpe(); return tmp8_5;
/*     */     }
/*     */     
/*     */     private final void computeCollection() {
/* 100 */       synchronized (this) { int $i$a$1$synchronized;
/* 101 */         if (artifactResults == null)
/*     */         {
/* 103 */           Set filteredArtifacts = computeFilteredArtifacts();
/*     */           
/* 105 */           if (filteredArtifacts.isEmpty()) {
/* 106 */             artifactResults = mainArtifacts.getArtifacts(); FileCollection 
/* 107 */               tmp49_44 = mainArtifacts.getArtifactFiles();Intrinsics.checkExpressionValueIsNotNull(tmp49_44, "mainArtifacts.artifactFiles");files = ((Collection)tmp49_44.getFiles());
/*     */           }
/*     */           else
/*     */           {
/* 112 */             results = Sets.newLinkedHashSet();
/* 113 */             ImmutableList.Builder builder = ImmutableList.builder();
/* 114 */             for (ResolvedArtifactResult artifactResult : mainArtifacts.getArtifacts())
/*     */             {
/* 116 */               ResolvedArtifactResult tmp119_117 = artifactResult;Intrinsics.checkExpressionValueIsNotNull(tmp119_117, "artifactResult"); if (!filteredArtifacts.contains(FeatureSplitTransitiveDepsWriterTaskKt.compIdToString(tmp119_117))) {
/* 117 */                 results.add(artifactResult);
/* 118 */                 builder.add(artifactResult.getFile());
/*     */               }
/*     */             }
/*     */             
/* 122 */             artifactResults = ((Set)results);
/* 123 */             files = ((Collection)builder.build());
/*     */           }
/*     */         }
/* 100 */         results = 
/*     */         
/* 126 */           Unit.INSTANCE;
/*     */       }
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     private final ArtifactCollection mainArtifacts;
/*     */     
/*     */     private final FileCollection directoryArtifacts;
/*     */     
/*     */     private final Set<String> computeFilteredArtifacts()
/*     */     {
/* 138 */       Object tmp44_39 = directoryArtifacts.getFiles().stream().map((Function)computeFilteredArtifacts.1.INSTANCE).flatMap((Function)computeFilteredArtifacts.2.INSTANCE).collect(Collectors.toSet());Intrinsics.checkExpressionValueIsNotNull(tmp44_39, "directoryArtifacts\n     …llectors.toSet<String>())");return (Set)tmp44_39;
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.FilteredArtifactCollection
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */