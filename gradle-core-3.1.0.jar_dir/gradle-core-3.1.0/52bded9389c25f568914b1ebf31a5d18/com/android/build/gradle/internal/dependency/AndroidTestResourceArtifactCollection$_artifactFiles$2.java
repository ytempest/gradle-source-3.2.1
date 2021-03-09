/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.gradle.api.artifacts.ArtifactCollection;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.specs.Spec;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\n\n\000\n\002\030\002\n\002\b\002\020\000\032\n \002*\004\030\0010\0010\001H\n¢\006\002\b\003"}, d2={"<anonymous>", "Lorg/gradle/api/file/FileCollection;", "kotlin.jvm.PlatformType", "invoke"})
/*     */ final class AndroidTestResourceArtifactCollection$_artifactFiles$2
/*     */   extends Lambda
/*     */   implements Function0<FileCollection>
/*     */ {
/*     */   public final FileCollection invoke()
/*     */   {
/* 126 */     AndroidTestResourceArtifactCollection.access$getDependenciesToFilter$p(this$0).getArtifactFiles().filter((Spec)new Spec() { public final boolean isSatisfiedBy(File it) { return AndroidTestResourceArtifactCollection.access$getArtifactFilesSet$p(this$0.this$0).contains(it); }
/*     */     });
/*     */   }
/*     */   
/*     */   AndroidTestResourceArtifactCollection$_artifactFiles$2(AndroidTestResourceArtifactCollection paramAndroidTestResourceArtifactCollection)
/*     */   {
/*     */     super(0);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.AndroidTestResourceArtifactCollection._artifactFiles.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */