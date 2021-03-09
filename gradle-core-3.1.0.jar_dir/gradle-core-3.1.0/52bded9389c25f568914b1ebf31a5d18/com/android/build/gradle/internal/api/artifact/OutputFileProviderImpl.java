/*    */ package com.android.build.gradle.internal.api.artifact;
/*    */ 
/*    */ import com.android.build.api.artifact.ArtifactType;
/*    */ import com.android.build.api.artifact.OutputFileProvider;
/*    */ import com.android.build.gradle.internal.scope.BuildArtifactHolder;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.android.builder.errors.EvalIssueReporter.Type;
/*    */ import com.google.common.collect.Multimap;
/*    */ import java.io.File;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Pair;
/*    */ import kotlin.TuplesKt;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import kotlin.collections.MapsKt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.ranges.RangesKt;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000@\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\036\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020$\n\002\b\005\030\0002\0020\001B[\022\006\020\002\032\0020\003\022\f\020\004\032\b\022\004\022\0020\0060\005\022\f\020\007\032\b\022\004\022\0020\0060\005\022\022\020\b\032\016\022\004\022\0020\006\022\004\022\0020\n0\t\022\f\020\013\032\b\022\004\022\0020\n0\005\022\006\020\f\032\0020\n\022\006\020\r\032\0020\016¢\006\002\020\017J\020\020\022\032\0020\0212\006\020\031\032\0020\nH\026R\024\020\020\032\0020\0218VX\004¢\006\006\032\004\b\022\020\023R*\020\024\032\036\022\f\022\n \026*\004\030\0010\n0\n\022\f\022\n \026*\004\030\0010\0210\0210\025X\004¢\006\002\n\000R\021\020\r\032\0020\016¢\006\b\n\000\032\004\b\027\020\030¨\006\032"}, d2={"Lcom/android/build/gradle/internal/api/artifact/OutputFileProviderImpl;", "Lcom/android/build/api/artifact/OutputFileProvider;", "artifactHolder", "Lcom/android/build/gradle/internal/scope/BuildArtifactHolder;", "replacedArtifacts", "", "Lcom/android/build/api/artifact/ArtifactType;", "appendedArtifacts", "filenamesMap", "Lcom/google/common/collect/Multimap;", "", "unassociatedFilenames", "taskName", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/scope/BuildArtifactHolder;Ljava/util/Collection;Ljava/util/Collection;Lcom/google/common/collect/Multimap;Ljava/util/Collection;Ljava/lang/String;Lcom/android/builder/errors/EvalIssueReporter;)V", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "fileMap", "", "kotlin.jvm.PlatformType", "getIssueReporter", "()Lcom/android/builder/errors/EvalIssueReporter;", "filename", "gradle-core"})
/*    */ public final class OutputFileProviderImpl
/*    */   implements OutputFileProvider
/*    */ {
/*    */   private final Map<String, File> fileMap;
/*    */   @NotNull
/*    */   private final EvalIssueReporter issueReporter;
/*    */   
/*    */   @NotNull
/*    */   public final EvalIssueReporter getIssueReporter()
/*    */   {
/* 44 */     return issueReporter;
/*    */   }
/*    */   
/*    */   public OutputFileProviderImpl(@NotNull BuildArtifactHolder artifactHolder, @NotNull Collection<? extends ArtifactType> replacedArtifacts, @NotNull Collection<? extends ArtifactType> appendedArtifacts, @NotNull Multimap<ArtifactType, String> filenamesMap, @NotNull Collection<String> unassociatedFilenames, @NotNull String taskName, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 37 */     this.issueReporter = issueReporter; Collection 
/*    */     
/* 48 */       tmp64_59 = filenamesMap.values();Intrinsics.checkExpressionValueIsNotNull(tmp64_59, "filenamesMap.values()");Iterable localIterable1 = (Iterable)CollectionsKt.union((Iterable)tmp64_59, (Iterable)unassociatedFilenames);
/* 49 */     OutputFileProviderImpl localOutputFileProviderImpl = this;
/*    */     
/*    */     int $i$f$associate;
/*    */     
/*    */     Iterable $receiver$iv;
/*    */     
/* :0 */     int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
/* :1 */     Iterable localIterable2 = $receiver$iv;Map destination$iv$iv = (Map)new LinkedHashMap(capacity$iv);
/* :2 */     int $i$f$associateTo; Iterable $receiver$iv$iv; Map localMap1; Pair localPair; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); localMap1.put(localPair.getFirst(), localPair.getSecond()))
/*    */     {
/* :2 */       Object element$iv$iv = localIterator.next();
/* :3 */       localMap1 = destination$iv$iv;String it = (String)element$iv$iv;
/*    */       int $i$a$1$associate;
/* 49 */       String tmp169_167 = it;Intrinsics.checkExpressionValueIsNotNull(tmp169_167, "it");localPair = TuplesKt.to(it, artifactHolder.createFile$gradle_core(taskName, tmp169_167));
/*    */     }
/*    */     
/* :5 */     Map localMap2 = destination$iv$iv;fileMap = localMap2;
/* 52 */     for (capacity$iv = replacedArtifacts.iterator(); capacity$iv.hasNext(); 
/*    */         
/* 62 */         artifactHolder.replaceArtifact(artifactType, tmp328_326, taskName))
/*    */     {
/* 52 */       ArtifactType artifactType = (ArtifactType)capacity$iv.next();
/* 53 */       BuildArtifactSpec spec = BuildArtifactSpec.Companion.get(artifactType);
/* 54 */       Collection files = filenamesMap.get(artifactType);
/* 55 */       if ((spec.getSingleFile()) && 
/* 56 */         (files.isEmpty())) {
/* 57 */         this.issueReporter.reportError(
/* 58 */           EvalIssueReporter.Type.GENERIC, 
/* 59 */           "An output file must be created for OutputType '" + artifactType + "'.");
/*    */       }
/*    */       
/* 62 */       Intrinsics.checkExpressionValueIsNotNull(files, "files");
/*    */     }
/*    */     
/* 65 */     for (capacity$iv = appendedArtifacts.iterator(); capacity$iv.hasNext(); 
/* 66 */         artifactHolder.appendArtifact(artifactType, tmp385_380, taskName))
/*    */     {
/* 65 */       ArtifactType artifactType = (ArtifactType)capacity$iv.next();
/* 66 */       Intrinsics.checkExpressionValueIsNotNull(filenamesMap.get(artifactType), "filenamesMap[artifactType]");
/*    */     }
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public File getFile()
/*    */   {
/* 73 */     issueReporter.reportError(
/* 74 */       EvalIssueReporter.Type.GENERIC, 
/* 75 */       "No output file was defined.");
/*    */     
/* 80 */     issueReporter.reportError(
/* 81 */       EvalIssueReporter.Type.GENERIC, 
/* 82 */       "Multiple output files was defined."); Object 
/*    */     
/* 85 */       tmp104_101 = CollectionsKt.single((Iterable)fileMap.values());Intrinsics.checkExpressionValueIsNotNull(tmp104_101, "fileMap.values.single()");
/* 86 */     return fileMap.values().size() > 1 ? new File("") : fileMap.values().isEmpty() ? new File("") : (File)tmp104_101; }
/*    */   
/*    */   @NotNull
/* 89 */   public File getFile(@NotNull String filename) { Intrinsics.checkParameterIsNotNull(filename, "filename");File file = (File)fileMap.get(filename);
/* 90 */     if (file == null) {
/* 91 */       issueReporter.reportError(
/* 92 */         EvalIssueReporter.Type.GENERIC, 
/* 93 */         "Multiple output files was defined.");
/* 94 */       return new File("");
/*    */     }
/* 96 */     return file;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.artifact.OutputFileProviderImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */