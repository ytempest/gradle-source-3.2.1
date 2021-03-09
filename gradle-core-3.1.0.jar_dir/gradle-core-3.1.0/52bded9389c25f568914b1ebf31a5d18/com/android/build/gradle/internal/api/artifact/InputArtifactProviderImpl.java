/*    */ package com.android.build.gradle.internal.api.artifact;
/*    */ 
/*    */ import com.android.build.api.artifact.ArtifactType;
/*    */ import com.android.build.api.artifact.BuildArtifactType;
/*    */ import com.android.build.api.artifact.BuildableArtifact;
/*    */ import com.android.build.api.artifact.InputArtifactProvider;
/*    */ import com.android.build.gradle.internal.scope.BuildArtifactHolder;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.android.builder.errors.EvalIssueReporter.Type;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0006\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\036\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020 \n\000\n\002\030\002\n\000\030\0002\0020\001B#\022\006\020\002\032\0020\003\022\f\020\004\032\b\022\004\022\0020\0060\005\022\006\020\007\032\0020\b¢\006\002\020\tJ\020\020\f\032\0020\0132\006\020\020\032\0020\021H\026R\024\020\n\032\0020\0138VX\004¢\006\006\032\004\b\f\020\rR\016\020\002\032\0020\003X\016¢\006\002\n\000R\024\020\016\032\b\022\004\022\0020\0130\017X\004¢\006\002\n\000R\024\020\004\032\b\022\004\022\0020\0060\005X\016¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000¨\006\022"}, d2={"Lcom/android/build/gradle/internal/api/artifact/InputArtifactProviderImpl;", "Lcom/android/build/api/artifact/InputArtifactProvider;", "artifactHolder", "Lcom/android/build/gradle/internal/scope/BuildArtifactHolder;", "inputTypes", "", "Lcom/android/build/api/artifact/ArtifactType;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/scope/BuildArtifactHolder;Ljava/util/Collection;Lcom/android/builder/errors/EvalIssueReporter;)V", "artifact", "Lcom/android/build/api/artifact/BuildableArtifact;", "getArtifact", "()Lcom/android/build/api/artifact/BuildableArtifact;", "collections", "", "type", "Lcom/android/build/api/artifact/BuildArtifactType;", "gradle-core"})
/*    */ public final class InputArtifactProviderImpl
/*    */   implements InputArtifactProvider
/*    */ {
/*    */   private final List<BuildableArtifact> collections;
/*    */   private BuildArtifactHolder artifactHolder;
/*    */   private Collection<? extends ArtifactType> inputTypes;
/*    */   private final EvalIssueReporter issueReporter;
/*    */   
/*    */   @NotNull
/*    */   public BuildableArtifact getArtifact()
/*    */   {
/* 38 */     issueReporter.reportError(
/* 39 */       EvalIssueReporter.Type.GENERIC, 
/* 40 */       "No artifacts was defined for input.");
/*    */     
/* 44 */     issueReporter.reportError(
/* 45 */       EvalIssueReporter.Type.GENERIC, 
/* 46 */       "Multiple inputs types was defined.");
/*    */     
/* 50 */     return collections.size() > 1 ? (BuildableArtifact)new BuildableArtifactImpl(null, issueReporter) : collections.isEmpty() ? (BuildableArtifact)new BuildableArtifactImpl(null, issueReporter) : (BuildableArtifact)CollectionsKt.single(collections); }
/*    */   
/*    */   @NotNull
/* 53 */   public BuildableArtifact getArtifact(@NotNull BuildArtifactType type) { Intrinsics.checkParameterIsNotNull(type, "type");int index = CollectionsKt.indexOf((Iterable)inputTypes, type);
/* 54 */     if (index == -1) {
/* 55 */       issueReporter.reportError(
/* 56 */         EvalIssueReporter.Type.GENERIC, 
/* 57 */         "Artifact was not defined for input of type: " + type + '.');
/* 58 */       return (BuildableArtifact)new BuildableArtifactImpl(null, issueReporter);
/*    */     }
/* 60 */     return (BuildableArtifact)collections.get(CollectionsKt.indexOf((Iterable)inputTypes, type));
/*    */   }
/*    */   
/*    */   public InputArtifactProviderImpl(@NotNull BuildArtifactHolder artifactHolder, @NotNull Collection<? extends ArtifactType> inputTypes, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 29 */     this.artifactHolder = artifactHolder;this.inputTypes = inputTypes;this.issueReporter = issueReporter;
/*    */     
/* 33 */     Iterable localIterable1 = (Iterable)this.inputTypes;InputArtifactProviderImpl localInputArtifactProviderImpl = this;
/*    */     
/*    */     int $i$f$map;
/*    */     
/*    */     Iterable $receiver$iv;
/*    */     
/* 64 */     Iterable localIterable2 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 65 */     int $i$f$mapTo; Iterable $receiver$iv$iv; BuildableArtifact localBuildableArtifact; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); ((Collection)localObject1).add(localBuildableArtifact))
/*    */     {
/* 65 */       Object item$iv$iv = localIterator.next();
/* 66 */       ArtifactType localArtifactType1 = (ArtifactType)item$iv$iv;localObject1 = destination$iv$iv;
/*    */       int $i$a$1$map;
/*    */       ArtifactType it;
/* 33 */       localBuildableArtifact = this.artifactHolder.getArtifactFiles(it);
/*    */     }
/*    */     
/* 67 */     Object localObject1 = (List)destination$iv$iv;collections = ((List)localObject1);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.artifact.InputArtifactProviderImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */