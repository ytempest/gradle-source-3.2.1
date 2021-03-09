/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import java.util.Objects;
/*     */ 
/*     */ public final class ArtifactCollectionWithExtraArtifact$ExtraComponentIdentifierImpl
/*     */   implements ArtifactCollectionWithExtraArtifact.ExtraComponentIdentifier
/*     */ {
/*     */   private final String projectPath;
/*     */   
/*     */   public ArtifactCollectionWithExtraArtifact$ExtraComponentIdentifierImpl(String projectPath)
/*     */   {
/* 272 */     this.projectPath = projectPath;
/*     */   }
/*     */   
/*     */   public String getDisplayName()
/*     */   {
/* 277 */     return "__extra_artifact__:" + projectPath;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 282 */     if (this == o) {
/* 283 */       return true;
/*     */     }
/* 285 */     if ((o == null) || (getClass() != o.getClass())) {
/* 286 */       return false;
/*     */     }
/* 288 */     ExtraComponentIdentifierImpl that = (ExtraComponentIdentifierImpl)o;
/* 289 */     return Objects.equals(projectPath, projectPath);
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 294 */     return Objects.hash(new Object[] { projectPath });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.ArtifactCollectionWithExtraArtifact.ExtraComponentIdentifierImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */