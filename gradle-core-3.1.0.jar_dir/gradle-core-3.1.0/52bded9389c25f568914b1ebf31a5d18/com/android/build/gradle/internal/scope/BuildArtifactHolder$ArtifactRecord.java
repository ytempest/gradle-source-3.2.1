/*    */ package com.android.build.gradle.internal.scope;
/*    */ 
/*    */ import com.android.build.api.artifact.BuildableArtifact;
/*    */ import com.android.build.gradle.internal.api.artifact.BuildableArtifactImpl;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.TypeCastException;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0004\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020!\n\002\b\005\n\002\020\013\n\002\b\n\n\002\020\002\n\000\n\002\030\002\n\000\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\016\020\031\032\0020\0322\006\020\033\032\0020\034R\021\020\002\032\0020\0058F¢\006\006\032\004\b\006\020\007R \020\b\032\b\022\004\022\0020\0050\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\032\020\016\032\0020\017X\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023R$\020\025\032\0020\0052\006\020\024\032\0020\0058F@FX\016¢\006\f\032\004\b\026\020\007\"\004\b\027\020\030¨\006\035"}, d2={"Lcom/android/build/gradle/internal/scope/BuildArtifactHolder$ArtifactRecord;", "", "first", "Lcom/android/build/gradle/internal/api/artifact/BuildableArtifactImpl;", "(Lcom/android/build/gradle/internal/api/artifact/BuildableArtifactImpl;)V", "Lcom/android/build/api/artifact/BuildableArtifact;", "getFirst", "()Lcom/android/build/api/artifact/BuildableArtifact;", "history", "", "getHistory", "()Ljava/util/List;", "setHistory", "(Ljava/util/List;)V", "initialized", "", "getInitialized", "()Z", "setInitialized", "(Z)V", "value", "last", "getLast", "setLast", "(Lcom/android/build/api/artifact/BuildableArtifact;)V", "modifyFirst", "", "collection", "Lorg/gradle/api/file/FileCollection;", "gradle-core"})
/*    */ final class BuildArtifactHolder$ArtifactRecord
/*    */ {
/*    */   private boolean initialized;
/*    */   @NotNull
/*    */   private List<BuildableArtifact> history;
/*    */   
/* 66 */   public final boolean getInitialized() { return initialized; } public final void setInitialized(boolean <set-?>) { initialized = <set-?>; }
/*    */   
/*    */   @NotNull
/* 71 */   public final List<BuildableArtifact> getHistory() { return history; } public final void setHistory(@NotNull List<BuildableArtifact> <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");history = <set-?>; } public BuildArtifactHolder$ArtifactRecord(@NotNull BuildableArtifactImpl first) { history = CollectionsKt.mutableListOf(new BuildableArtifact[] { (BuildableArtifact)first }); }
/*    */   
/*    */   @NotNull
/* 75 */   public final BuildableArtifact getLast() { return (BuildableArtifact)CollectionsKt.last(history); }
/*    */   
/* 77 */   public final void setLast(@NotNull BuildableArtifact value) { Intrinsics.checkParameterIsNotNull(value, "value");history.add(value);
/*    */   }
/*    */   
/*    */   @NotNull
/* 82 */   public final BuildableArtifact getFirst() { return (BuildableArtifact)CollectionsKt.first(history); }
/*    */   
/*    */   public final void modifyFirst(@NotNull FileCollection collection) {
/* 85 */     Intrinsics.checkParameterIsNotNull(collection, "collection");initialized = true; Object 
/* 86 */       tmp18_15 = CollectionsKt.first(history);
/* 86 */     if (tmp18_15 == null) throw new TypeCastException("null cannot be cast to non-null type com.android.build.gradle.internal.api.artifact.BuildableArtifactImpl"); ((BuildableArtifactImpl)tmp18_15).setFileCollection$gradle_core(collection);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildArtifactHolder.ArtifactRecord
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */