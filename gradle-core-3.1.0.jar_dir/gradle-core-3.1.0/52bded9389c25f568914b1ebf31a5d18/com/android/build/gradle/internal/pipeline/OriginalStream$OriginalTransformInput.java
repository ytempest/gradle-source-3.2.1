/*     */ package com.android.build.gradle.internal.pipeline;
/*     */ 
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ class OriginalStream$OriginalTransformInput
/*     */   extends IncrementalTransformInput
/*     */ {
/*     */   protected boolean checkRemovedFolder(Set<? super QualifiedContent.Scope> transformScopes, Set<QualifiedContent.ContentType> transformInputTypes, File file, List<String> fileSegments)
/*     */   {
/* 256 */     return false;
/*     */   }
/*     */   
/*     */   boolean checkRemovedJarFile(Set<? super QualifiedContent.Scope> transformScopes, Set<QualifiedContent.ContentType> transformInputTypes, File file, List<String> fileSegments)
/*     */   {
/* 266 */     return false;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.OriginalStream.OriginalTransformInput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */