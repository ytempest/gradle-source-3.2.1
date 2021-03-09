/*    */ package com.android.build.gradle.internal.scope;
/*    */ 
/*    */ import com.android.build.api.artifact.ArtifactType;
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\026\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\030\0002\0060\001j\002`\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\006\020\007¨\006\b"}, d2={"Lcom/android/build/gradle/internal/scope/MissingBuildableArtifactException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "type", "Lcom/android/build/api/artifact/ArtifactType;", "(Lcom/android/build/api/artifact/ArtifactType;)V", "getType", "()Lcom/android/build/api/artifact/ArtifactType;", "gradle-core"})
/*    */ public final class MissingBuildableArtifactException
/*    */   extends RuntimeException
/*    */ {
/*    */   @NotNull
/*    */   private final ArtifactType type;
/*    */   
/*    */   @NotNull
/* 24 */   public final ArtifactType getType() { return type; }
/* 25 */   public MissingBuildableArtifactException(@NotNull ArtifactType type) { super("No artifact of type: " + type + '.');this.type = type;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.MissingBuildableArtifactException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */