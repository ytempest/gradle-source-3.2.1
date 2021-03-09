/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.gradle.api.artifacts.result.ResolvedArtifactResult;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\016\n\000\n\002\020\"\n\002\030\002\n\002\b\002\020\000\032\020\022\f\022\n \003*\004\030\0010\0020\0020\001H\n¢\006\002\b\004"}, d2={"<anonymous>", "", "Ljava/io/File;", "kotlin.jvm.PlatformType", "invoke"})
/*     */ final class AndroidTestResourceArtifactCollection$artifactFilesSet$2
/*     */   extends Lambda
/*     */   implements Function0<Set<? extends File>>
/*     */ {
/*     */   @NotNull
/*     */   public final Set<File> invoke()
/*     */   {
/* 122 */     Iterable $receiver$iv = (Iterable)this$0.getArtifacts();
/*     */     
/*     */     int $i$f$map;
/*     */     
/* 170 */     Iterable localIterable1 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 171 */     int $i$f$mapTo; Iterable $receiver$iv$iv; Collection localCollection1; File localFile; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); localCollection1.add(localFile))
/*     */     {
/* 171 */       Object item$iv$iv = localIterator.next();
/* 172 */       ResolvedArtifactResult localResolvedArtifactResult1 = (ResolvedArtifactResult)item$iv$iv;localCollection1 = destination$iv$iv;
/*     */       int $i$a$1$unknown;
/*     */       ResolvedArtifactResult p1;
/* 122 */       localFile = 
/*     */       
/* 172 */         p1.getFile(); } return CollectionsKt.toSet(
/*     */     
/* 173 */       (Iterable)destination$iv$iv);
/*     */   }
/*     */   
/*     */   AndroidTestResourceArtifactCollection$artifactFilesSet$2(AndroidTestResourceArtifactCollection paramAndroidTestResourceArtifactCollection)
/*     */   {
/*     */     super(0);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.AndroidTestResourceArtifactCollection.artifactFilesSet.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */