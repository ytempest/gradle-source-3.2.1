/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import org.gradle.api.specs.Spec;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "it", "Ljava/io/File;", "kotlin.jvm.PlatformType", "isSatisfiedBy"})
/*     */ final class AndroidTestResourceArtifactCollection$_artifactFiles$2$1<T>
/*     */   implements Spec<File>
/*     */ {
/*     */   public final boolean isSatisfiedBy(File it)
/*     */   {
/* 126 */     return AndroidTestResourceArtifactCollection.access$getArtifactFilesSet$p(this$0.this$0).contains(it);
/*     */   }
/*     */   
/*     */   AndroidTestResourceArtifactCollection$_artifactFiles$2$1(AndroidTestResourceArtifactCollection._artifactFiles.2 param2) {}
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.AndroidTestResourceArtifactCollection._artifactFiles.2.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */