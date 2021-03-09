/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import java.io.File;
/*     */ import org.gradle.api.artifacts.component.ComponentArtifactIdentifier;
/*     */ import org.gradle.api.artifacts.result.ResolvedArtifactResult;
/*     */ import org.gradle.api.artifacts.result.ResolvedVariantResult;
/*     */ import org.gradle.api.component.Artifact;
/*     */ 
/*     */ final class ArtifactCollectionWithExtraArtifact$ExtraResolvedArtifactResult
/*     */   implements ResolvedArtifactResult
/*     */ {
/*     */   private final File artifactFile;
/*     */   private final ArtifactCollectionWithExtraArtifact.ExtraComponentArtifactIdentifier artifactId;
/*     */   
/*     */   private ArtifactCollectionWithExtraArtifact$ExtraResolvedArtifactResult(File artifactFile, ArtifactCollectionWithExtraArtifact.ExtraComponentArtifactIdentifier artifactId)
/*     */   {
/* 178 */     this.artifactFile = artifactFile;
/* 179 */     this.artifactId = artifactId;
/*     */   }
/*     */   
/*     */   public File getFile()
/*     */   {
/* 184 */     return artifactFile;
/*     */   }
/*     */   
/*     */   public ResolvedVariantResult getVariant()
/*     */   {
/* 189 */     throw new UnsupportedOperationException("Call to ExtraResolvedArtifactResult.getVariant is not allowed");
/*     */   }
/*     */   
/*     */   public ComponentArtifactIdentifier getId()
/*     */   {
/* 195 */     return artifactId;
/*     */   }
/*     */   
/*     */   public Class<? extends Artifact> getType()
/*     */   {
/* 200 */     throw new UnsupportedOperationException("Call to ExtraResolvedArtifactResult.getType is not allowed");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.ArtifactCollectionWithExtraArtifact.ExtraResolvedArtifactResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */