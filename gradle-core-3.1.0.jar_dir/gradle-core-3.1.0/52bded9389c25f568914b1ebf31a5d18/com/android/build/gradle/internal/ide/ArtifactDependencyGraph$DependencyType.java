/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ public enum ArtifactDependencyGraph$DependencyType
/*     */ {
/* 761 */   JAVA("jar"), 
/* 762 */   ANDROID("aar");
/*     */   
/*     */   private final String extension;
/*     */   
/*     */   private ArtifactDependencyGraph$DependencyType(String extension) {
/* 767 */     this.extension = extension;
/*     */   }
/*     */   
/*     */   public String getExtension()
/*     */   {
/* 772 */     return extension;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.ArtifactDependencyGraph.DependencyType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */