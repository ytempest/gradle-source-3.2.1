/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import com.android.build.gradle.api.TestedComponentIdentifier;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public final class ArtifactCollectionWithExtraArtifact$TestedComponentIdentifierImpl
/*     */   implements TestedComponentIdentifier, ArtifactCollectionWithExtraArtifact.ExtraComponentIdentifier
/*     */ {
/*     */   private final String projectPath;
/*     */   private final String variantName;
/*     */   
/*     */   public ArtifactCollectionWithExtraArtifact$TestedComponentIdentifierImpl(String projectPath, String variantName)
/*     */   {
/* 233 */     this.projectPath = projectPath;
/* 234 */     this.variantName = variantName;
/*     */   }
/*     */   
/*     */   public String getVariantName()
/*     */   {
/* 240 */     return variantName;
/*     */   }
/*     */   
/*     */   public String getDisplayName()
/*     */   {
/* 245 */     return "__tested_artifact__:" + projectPath;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 250 */     if (this == o) {
/* 251 */       return true;
/*     */     }
/* 253 */     if ((o == null) || (getClass() != o.getClass())) {
/* 254 */       return false;
/*     */     }
/* 256 */     TestedComponentIdentifierImpl that = (TestedComponentIdentifierImpl)o;
/* 257 */     return (Objects.equals(projectPath, projectPath)) && 
/* 258 */       (Objects.equals(variantName, variantName));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 263 */     return Objects.hash(new Object[] { projectPath, variantName });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.ArtifactCollectionWithExtraArtifact.TestedComponentIdentifierImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */