/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import org.gradle.api.artifacts.component.ComponentArtifactIdentifier;
/*     */ import org.gradle.api.artifacts.component.ComponentIdentifier;
/*     */ 
/*     */ final class ArtifactCollectionWithExtraArtifact$ExtraComponentArtifactIdentifier
/*     */   implements ComponentArtifactIdentifier
/*     */ {
/*     */   private final ComponentIdentifier id;
/*     */   
/*     */   public ArtifactCollectionWithExtraArtifact$ExtraComponentArtifactIdentifier(ComponentIdentifier id)
/*     */   {
/* 211 */     this.id = id;
/*     */   }
/*     */   
/*     */   public ComponentIdentifier getComponentIdentifier()
/*     */   {
/* 216 */     return id;
/*     */   }
/*     */   
/*     */   public String getDisplayName()
/*     */   {
/* 221 */     return id.getDisplayName();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.ArtifactCollectionWithExtraArtifact.ExtraComponentArtifactIdentifier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */