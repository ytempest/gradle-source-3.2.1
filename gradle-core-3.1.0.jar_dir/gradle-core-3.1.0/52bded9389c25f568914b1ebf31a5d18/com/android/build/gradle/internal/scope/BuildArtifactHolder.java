/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.build.api.artifact.ArtifactType;
/*     */ import com.android.build.api.artifact.BuildArtifactType;
/*     */ import com.android.build.api.artifact.BuildableArtifact;
/*     */ import com.android.build.gradle.internal.api.artifact.BuildableArtifactImpl;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.android.utils.FileUtils;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Pair;
/*     */ import kotlin.TuplesKt;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.collections.MapsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.ranges.RangesKt;
/*     */ import kotlin.text.StringsKt;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000f\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020$\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\036\n\002\b\007\n\002\020\002\n\002\b\006\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\003\030\0002\0020\001:\001+B;\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\005\022\f\020\t\032\b\022\004\022\0020\0130\n\022\006\020\f\032\0020\r¢\006\002\020\016J$\020\022\032\0020\0232\006\020\024\032\0020\0252\f\020\026\032\b\022\004\022\0020\0050\0272\006\020\030\032\0020\005J%\020\031\032\n \032*\004\030\0010\0070\0072\006\020\030\032\0020\0052\006\020\033\032\0020\005H\000¢\006\002\b\034J\036\020\035\032\0020\0232\006\020\024\032\0020\0252\006\020\033\032\0020\0052\006\020\030\032\0020\005J$\020\035\032\0020\0232\006\020\024\032\0020\0252\f\020\026\032\b\022\004\022\0020\0050\0272\006\020\030\032\0020\005J\030\020\036\032\0020\0372\006\020\024\032\0020\0252\006\020 \032\0020\023H\002J\016\020!\032\0020\0232\006\020\024\032\0020\025J\024\020\"\032\b\022\004\022\0020\0230\n2\006\020\024\032\0020\025J\016\020#\032\0020\0052\006\020$\032\0020\005J\016\020%\032\0020&2\006\020\024\032\0020\025J\030\020'\032\0020\0232\006\020\024\032\0020\0252\006\020(\032\0020)H\002J$\020*\032\0020\0232\006\020\024\032\0020\0252\f\020\026\032\b\022\004\022\0020\0050\0272\006\020\030\032\0020\005R\032\020\017\032\016\022\004\022\0020\013\022\004\022\0020\0210\020X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\005X\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000¨\006,"}, d2={"Lcom/android/build/gradle/internal/scope/BuildArtifactHolder;", "", "project", "Lorg/gradle/api/Project;", "variantName", "", "rootOutputDir", "Ljava/io/File;", "variantDirName", "initialArtifactTypes", "", "Lcom/android/build/api/artifact/BuildArtifactType;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lorg/gradle/api/Project;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/util/List;Lcom/android/builder/errors/EvalIssueReporter;)V", "artifactRecordMap", "", "Lcom/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord;", "appendArtifact", "Lcom/android/build/api/artifact/BuildableArtifact;", "artifactType", "Lcom/android/build/api/artifact/ArtifactType;", "filenames", "", "taskName", "createFile", "kotlin.jvm.PlatformType", "filename", "createFile$gradle_core", "createFirstArtifactFiles", "createOutput", "", "artifact", "getArtifactFiles", "getHistory", "getTaskName", "prefix", "hasArtifact", "", "initializeFirstArtifactFiles", "collection", "Lorg/gradle/api/file/FileCollection;", "replaceArtifact", "ArtifactRecord", "gradle-core"})
/*     */ public final class BuildArtifactHolder
/*     */ {
/*     */   private final Map<BuildArtifactType, ArtifactRecord> artifactRecordMap;
/*     */   private final Project project;
/*     */   private final String variantName;
/*     */   private final File rootOutputDir;
/*     */   private final String variantDirName;
/*     */   private final EvalIssueReporter issueReporter;
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0004\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020!\n\002\b\005\n\002\020\013\n\002\b\n\n\002\020\002\n\000\n\002\030\002\n\000\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\016\020\031\032\0020\0322\006\020\033\032\0020\034R\021\020\002\032\0020\0058F¢\006\006\032\004\b\006\020\007R \020\b\032\b\022\004\022\0020\0050\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\032\020\016\032\0020\017X\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023R$\020\025\032\0020\0052\006\020\024\032\0020\0058F@FX\016¢\006\f\032\004\b\026\020\007\"\004\b\027\020\030¨\006\035"}, d2={"Lcom/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord;", "", "first", "Lcom/android/build/gradle/internal/api/artifact/BuildableArtifactImpl;", "(Lcom/android/build/gradle/internal/api/artifact/BuildableArtifactImpl;)V", "Lcom/android/build/api/artifact/BuildableArtifact;", "getFirst", "()Lcom/android/build/api/artifact/BuildableArtifact;", "history", "", "getHistory", "()Ljava/util/List;", "setHistory", "(Ljava/util/List;)V", "initialized", "", "getInitialized", "()Z", "setInitialized", "(Z)V", "value", "last", "getLast", "setLast", "(Lcom/android/build/api/artifact/BuildableArtifact;)V", "modifyFirst", "", "collection", "Lorg/gradle/api/file/FileCollection;", "gradle-core"})
/*     */   private static final class ArtifactRecord
/*     */   {
/*     */     private boolean initialized;
/*     */     @NotNull
/*     */     private List<BuildableArtifact> history;
/*     */     
/*  66 */     public final boolean getInitialized() { return initialized; } public final void setInitialized(boolean <set-?>) { initialized = <set-?>; }
/*     */     
/*     */     @NotNull
/*  71 */     public final List<BuildableArtifact> getHistory() { return history; } public final void setHistory(@NotNull List<BuildableArtifact> <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");history = <set-?>; } public ArtifactRecord(@NotNull BuildableArtifactImpl first) { history = CollectionsKt.mutableListOf(new BuildableArtifact[] { (BuildableArtifact)first }); }
/*     */     
/*     */     @NotNull
/*  75 */     public final BuildableArtifact getLast() { return (BuildableArtifact)CollectionsKt.last(history); }
/*     */     
/*  77 */     public final void setLast(@NotNull BuildableArtifact value) { Intrinsics.checkParameterIsNotNull(value, "value");history.add(value);
/*     */     }
/*     */     
/*     */     @NotNull
/*  82 */     public final BuildableArtifact getFirst() { return (BuildableArtifact)CollectionsKt.first(history); }
/*     */     
/*     */     public final void modifyFirst(@NotNull FileCollection collection) {
/*  85 */       Intrinsics.checkParameterIsNotNull(collection, "collection");initialized = true; Object 
/*  86 */         tmp18_15 = CollectionsKt.first(history);
/*  86 */       if (tmp18_15 == null) throw new TypeCastException("null cannot be cast to non-null type com.android.build.gradle.internal.api.artifact.BuildableArtifactImpl"); ((BuildableArtifactImpl)tmp18_15).setFileCollection$gradle_core(collection);
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String getTaskName(@NotNull String prefix)
/*     */   {
/*  94 */     Intrinsics.checkParameterIsNotNull(prefix, "prefix");return prefix + StringsKt.capitalize(variantName);
/*     */   }
/*     */   
/*     */   public final boolean hasArtifact(@NotNull ArtifactType artifactType)
/*     */   {
/* 113 */     Intrinsics.checkParameterIsNotNull(artifactType, "artifactType");Map localMap = artifactRecordMap; Map tmp12_11 = localMap; if (tmp12_11 == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>"); return tmp12_11.containsKey(artifactType);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BuildableArtifact createFirstArtifactFiles(@NotNull ArtifactType artifactType, @NotNull String filename, @NotNull String taskName)
/*     */   {
/* 205 */     Intrinsics.checkParameterIsNotNull(artifactType, "artifactType");Intrinsics.checkParameterIsNotNull(filename, "filename");Intrinsics.checkParameterIsNotNull(taskName, "taskName");ConfigurableFileCollection collection = project.files(new Object[] { createFile$gradle_core(artifactType.name(), filename) });
/* 206 */     collection.builtBy(new Object[] { taskName }); ConfigurableFileCollection 
/* 207 */       tmp67_65 = collection;Intrinsics.checkExpressionValueIsNotNull(tmp67_65, "collection");return initializeFirstArtifactFiles(artifactType, (FileCollection)tmp67_65);
/*     */   }
/*     */   
/*     */   public final File createFile$gradle_core(@NotNull String taskName, @NotNull String filename)
/*     */   {
/* 239 */     Intrinsics.checkParameterIsNotNull(taskName, "taskName");Intrinsics.checkParameterIsNotNull(filename, "filename");
/*     */     
/* 242 */     return FileUtils.join(rootOutputDir, new String[] {taskName, variantDirName, filename });
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BuildableArtifact replaceArtifact(@NotNull ArtifactType artifactType, @NotNull Collection<String> filenames, @NotNull String taskName)
/*     */   {
/* 134 */     Intrinsics.checkParameterIsNotNull(artifactType, "artifactType");Intrinsics.checkParameterIsNotNull(filenames, "filenames");Intrinsics.checkParameterIsNotNull(taskName, "taskName");Iterable localIterable1 = (Iterable)filenames;int i = 0; Object[] arrayOfObject2; Object[] arrayOfObject1 = arrayOfObject2 = new Object[1];Project localProject = project;
/*     */     
/*     */     int $i$f$map;
/*     */     
/*     */     Iterable $receiver$iv;
/*     */     
/* 255 */     Iterable localIterable2 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 256 */     int $i$f$mapTo; Iterable $receiver$iv$iv; File localFile; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); ((Collection)localObject1).add(localFile))
/*     */     {
/* 256 */       Object item$iv$iv = localIterator.next();
/* 257 */       String str1 = (String)item$iv$iv;localObject1 = destination$iv$iv;
/*     */       int $i$a$1$map;
/*     */       String it;
/* 134 */       localFile = createFile$gradle_core(taskName, it);
/*     */     }
/*     */     
/* 258 */     Object localObject1 = (List)destination$iv$iv;arrayOfObject2[i] = localObject1;ConfigurableFileCollection collection = localProject.files(arrayOfObject1).builtBy(new Object[] { taskName });BuildableArtifactImpl files = new BuildableArtifactImpl((FileCollection)collection, issueReporter);createOutput(artifactType, (BuildableArtifact)files);return (BuildableArtifact)files;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BuildableArtifact appendArtifact(@NotNull ArtifactType artifactType, @NotNull Collection<String> filenames, @NotNull String taskName)
/*     */   {
/* 158 */     Intrinsics.checkParameterIsNotNull(artifactType, "artifactType");Intrinsics.checkParameterIsNotNull(filenames, "filenames");Intrinsics.checkParameterIsNotNull(taskName, "taskName");BuildableArtifact originalOutput = getArtifactFiles(artifactType);
/*     */     
/* 161 */     Iterable localIterable1 = (Iterable)filenames;int i = 0; Object[] arrayOfObject2; Object[] arrayOfObject1 = arrayOfObject2 = new Object[2];Project localProject = project;
/*     */     
/*     */     int $i$f$map;
/*     */     
/*     */     Iterable $receiver$iv;
/*     */     
/* 259 */     Iterable localIterable2 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 260 */     int $i$f$mapTo; Iterable $receiver$iv$iv; File localFile; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); ((Collection)localObject1).add(localFile))
/*     */     {
/* 260 */       Object item$iv$iv = localIterator.next();
/* 261 */       String str1 = (String)item$iv$iv;localObject1 = destination$iv$iv;
/*     */       int $i$a$1$map;
/*     */       String it;
/* 161 */       localFile = createFile$gradle_core(taskName, it);
/*     */     }
/*     */     
/* 262 */     Object localObject1 = (List)destination$iv$iv;arrayOfObject2[i] = localObject1; Object[] tmp151_142 = arrayOfObject1;tmp151_142[1] = originalOutput;ConfigurableFileCollection collection = localProject.files(tmp151_142).builtBy(new Object[] { taskName, originalOutput });BuildableArtifactImpl files = new BuildableArtifactImpl((FileCollection)collection, issueReporter);createOutput(artifactType, (BuildableArtifact)files);return (BuildableArtifact)files;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BuildableArtifact createFirstArtifactFiles(@NotNull ArtifactType artifactType, @NotNull Collection<String> filenames, @NotNull String taskName)
/*     */   {
/* 190 */     Intrinsics.checkParameterIsNotNull(artifactType, "artifactType");Intrinsics.checkParameterIsNotNull(filenames, "filenames");Intrinsics.checkParameterIsNotNull(taskName, "taskName");Iterable localIterable1 = (Iterable)filenames;int i = 0; Object[] arrayOfObject2; Object[] arrayOfObject1 = arrayOfObject2 = new Object[1];Project localProject = project;
/*     */     
/*     */     int $i$f$map;
/*     */     
/*     */     Iterable $receiver$iv;
/*     */     
/* 263 */     Iterable localIterable2 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 264 */     int $i$f$mapTo; Iterable $receiver$iv$iv; File localFile; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); ((Collection)localObject1).add(localFile))
/*     */     {
/* 264 */       Object item$iv$iv = localIterator.next();
/* 265 */       String str1 = (String)item$iv$iv;localObject1 = destination$iv$iv;
/*     */       int $i$a$1$map;
/*     */       String it;
/* 190 */       localFile = createFile$gradle_core(artifactType.name(), it);
/*     */     }
/*     */     
/* 266 */     Object localObject1 = (List)destination$iv$iv;arrayOfObject2[i] = localObject1;ConfigurableFileCollection collection = localProject.files(arrayOfObject1);collection.builtBy(new Object[] { taskName }); ConfigurableFileCollection tmp176_174 = collection;Intrinsics.checkExpressionValueIsNotNull(tmp176_174, "collection");return initializeFirstArtifactFiles(artifactType, (FileCollection)tmp176_174);
/*     */   }
/*     */   
/*     */   public BuildArtifactHolder(@NotNull Project project, @NotNull String variantName, @NotNull File rootOutputDir, @NotNull String variantDirName, @NotNull List<? extends BuildArtifactType> initialArtifactTypes, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  48 */     this.project = project;this.variantName = variantName;this.rootOutputDir = rootOutputDir;this.variantDirName = variantDirName;this.issueReporter = issueReporter;
/*     */     
/*  57 */     Iterable localIterable1 = (Iterable)initialArtifactTypes;BuildArtifactHolder localBuildArtifactHolder = this;
/*     */     
/*     */     int $i$f$associate;
/*     */     
/*     */     Iterable $receiver$iv;
/*     */     
/* 267 */     int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
/* 268 */     Iterable localIterable2 = $receiver$iv;Map destination$iv$iv = (Map)new LinkedHashMap(capacity$iv);
/* 269 */     int $i$f$associateTo; Iterable $receiver$iv$iv; Map localMap1; Pair localPair; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); localMap1.put(localPair.getFirst(), localPair.getSecond()))
/*     */     {
/* 269 */       Object element$iv$iv = localIterator.next();
/* 270 */       localMap1 = destination$iv$iv;BuildArtifactType it = (BuildArtifactType)element$iv$iv;
/*     */       int $i$a$1$associate;
/*  58 */       localPair = TuplesKt.to(it, new ArtifactRecord(new BuildableArtifactImpl(null, this.issueReporter)));
/*     */     }
/*     */     
/* 272 */     Map localMap2 = destination$iv$iv;artifactRecordMap = localMap2;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @NotNull
/*     */   public final BuildableArtifact getArtifactFiles(@NotNull ArtifactType artifactType)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 47
/*     */     //   3: invokestatic 18	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_0
/*     */     //   7: getfield 49	com/android/build/gradle/internal/scope/BuildArtifactHolder:artifactRecordMap	Ljava/util/Map;
/*     */     //   10: astore_3
/*     */     //   11: aload_3
/*     */     //   12: aload_1
/*     */     //   13: invokeinterface 55 2 0
/*     */     //   18: checkcast 57	com/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord
/*     */     //   21: dup
/*     */     //   22: ifnull +6 -> 28
/*     */     //   25: goto +16 -> 41
/*     */     //   28: pop
/*     */     //   29: new 59	com/android/build/gradle/internal/scope/MissingBuildableArtifactException
/*     */     //   32: dup
/*     */     //   33: aload_1
/*     */     //   34: invokespecial 62	com/android/build/gradle/internal/scope/MissingBuildableArtifactException:<init>	(Lcom/android/build/api/artifact/ArtifactType;)V
/*     */     //   37: checkcast 64	java/lang/Throwable
/*     */     //   40: athrow
/*     */     //   41: astore_2
/*     */     //   42: aload_2
/*     */     //   43: invokevirtual 68	com/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord:getLast	()Lcom/android/build/api/artifact/BuildableArtifact;
/*     */     //   46: areturn
/*     */     // Line number table:
/*     */     //   Java source line #104	-> byte code offset #6
/*     */     //   Java source line #105	-> byte code offset #29
/*     */     //   Java source line #104	-> byte code offset #41
/*     */     //   Java source line #106	-> byte code offset #42
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	47	0	this	BuildArtifactHolder
/*     */     //   0	47	1	artifactType	ArtifactType
/*     */     //   42	5	2	output	ArtifactRecord
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private final void createOutput(ArtifactType artifactType, BuildableArtifact artifact)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 49	com/android/build/gradle/internal/scope/BuildArtifactHolder:artifactRecordMap	Ljava/util/Map;
/*     */     //   4: astore 4
/*     */     //   6: aload 4
/*     */     //   8: aload_1
/*     */     //   9: invokeinterface 55 2 0
/*     */     //   14: checkcast 57	com/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord
/*     */     //   17: dup
/*     */     //   18: ifnull +6 -> 24
/*     */     //   21: goto +16 -> 37
/*     */     //   24: pop
/*     */     //   25: new 59	com/android/build/gradle/internal/scope/MissingBuildableArtifactException
/*     */     //   28: dup
/*     */     //   29: aload_1
/*     */     //   30: invokespecial 62	com/android/build/gradle/internal/scope/MissingBuildableArtifactException:<init>	(Lcom/android/build/api/artifact/ArtifactType;)V
/*     */     //   33: checkcast 64	java/lang/Throwable
/*     */     //   36: athrow
/*     */     //   37: astore_3
/*     */     //   38: aload_3
/*     */     //   39: aload_2
/*     */     //   40: invokevirtual 190	com/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord:setLast	(Lcom/android/build/api/artifact/BuildableArtifact;)V
/*     */     //   43: return
/*     */     // Line number table:
/*     */     //   Java source line #170	-> byte code offset #0
/*     */     //   Java source line #171	-> byte code offset #25
/*     */     //   Java source line #170	-> byte code offset #37
/*     */     //   Java source line #172	-> byte code offset #38
/*     */     //   Java source line #173	-> byte code offset #43
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	44	0	this	BuildArtifactHolder
/*     */     //   0	44	1	artifactType	ArtifactType
/*     */     //   0	44	2	artifact	BuildableArtifact
/*     */     //   38	6	3	output	ArtifactRecord
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private final BuildableArtifact initializeFirstArtifactFiles(ArtifactType artifactType, FileCollection collection)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 49	com/android/build/gradle/internal/scope/BuildArtifactHolder:artifactRecordMap	Ljava/util/Map;
/*     */     //   4: astore 4
/*     */     //   6: aload 4
/*     */     //   8: aload_1
/*     */     //   9: invokeinterface 55 2 0
/*     */     //   14: checkcast 57	com/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord
/*     */     //   17: dup
/*     */     //   18: ifnull +6 -> 24
/*     */     //   21: goto +16 -> 37
/*     */     //   24: pop
/*     */     //   25: new 59	com/android/build/gradle/internal/scope/MissingBuildableArtifactException
/*     */     //   28: dup
/*     */     //   29: aload_1
/*     */     //   30: invokespecial 62	com/android/build/gradle/internal/scope/MissingBuildableArtifactException:<init>	(Lcom/android/build/api/artifact/ArtifactType;)V
/*     */     //   33: checkcast 64	java/lang/Throwable
/*     */     //   36: athrow
/*     */     //   37: astore_3
/*     */     //   38: aload_3
/*     */     //   39: invokevirtual 209	com/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord:getInitialized	()Z
/*     */     //   42: ifeq +33 -> 75
/*     */     //   45: new 211	java/lang/RuntimeException
/*     */     //   48: dup
/*     */     //   49: new 20	java/lang/StringBuilder
/*     */     //   52: dup
/*     */     //   53: invokespecial 24	java/lang/StringBuilder:<init>	()V
/*     */     //   56: ldc -43
/*     */     //   58: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   61: aload_1
/*     */     //   62: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   65: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   68: invokespecial 217	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
/*     */     //   71: checkcast 64	java/lang/Throwable
/*     */     //   74: athrow
/*     */     //   75: aload_3
/*     */     //   76: aload_2
/*     */     //   77: invokevirtual 221	com/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord:modifyFirst	(Lorg/gradle/api/file/FileCollection;)V
/*     */     //   80: aload_3
/*     */     //   81: invokevirtual 224	com/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord:getFirst	()Lcom/android/build/api/artifact/BuildableArtifact;
/*     */     //   84: areturn
/*     */     // Line number table:
/*     */     //   Java source line #222	-> byte code offset #0
/*     */     //   Java source line #223	-> byte code offset #25
/*     */     //   Java source line #222	-> byte code offset #37
/*     */     //   Java source line #224	-> byte code offset #38
/*     */     //   Java source line #225	-> byte code offset #45
/*     */     //   Java source line #227	-> byte code offset #75
/*     */     //   Java source line #228	-> byte code offset #80
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	85	0	this	BuildArtifactHolder
/*     */     //   0	85	1	artifactType	ArtifactType
/*     */     //   0	85	2	collection	FileCollection
/*     */     //   38	47	3	output	ArtifactRecord
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @NotNull
/*     */   public final List<BuildableArtifact> getHistory(@NotNull ArtifactType artifactType)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 47
/*     */     //   3: invokestatic 18	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_0
/*     */     //   7: getfield 49	com/android/build/gradle/internal/scope/BuildArtifactHolder:artifactRecordMap	Ljava/util/Map;
/*     */     //   10: astore_3
/*     */     //   11: aload_3
/*     */     //   12: aload_1
/*     */     //   13: invokeinterface 55 2 0
/*     */     //   18: checkcast 57	com/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord
/*     */     //   21: dup
/*     */     //   22: ifnull +6 -> 28
/*     */     //   25: goto +16 -> 41
/*     */     //   28: pop
/*     */     //   29: new 59	com/android/build/gradle/internal/scope/MissingBuildableArtifactException
/*     */     //   32: dup
/*     */     //   33: aload_1
/*     */     //   34: invokespecial 62	com/android/build/gradle/internal/scope/MissingBuildableArtifactException:<init>	(Lcom/android/build/api/artifact/ArtifactType;)V
/*     */     //   37: checkcast 64	java/lang/Throwable
/*     */     //   40: athrow
/*     */     //   41: astore_2
/*     */     //   42: aload_2
/*     */     //   43: invokevirtual 243	com/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord:getHistory	()Ljava/util/List;
/*     */     //   46: areturn
/*     */     // Line number table:
/*     */     //   Java source line #249	-> byte code offset #6
/*     */     //   Java source line #250	-> byte code offset #29
/*     */     //   Java source line #249	-> byte code offset #41
/*     */     //   Java source line #251	-> byte code offset #42
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	47	0	this	BuildArtifactHolder
/*     */     //   0	47	1	artifactType	ArtifactType
/*     */     //   42	5	2	record	ArtifactRecord
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildArtifactHolder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */