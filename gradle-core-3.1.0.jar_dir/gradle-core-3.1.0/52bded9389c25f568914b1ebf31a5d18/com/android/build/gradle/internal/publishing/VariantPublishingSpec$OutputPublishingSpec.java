/*     */ package com.android.build.gradle.internal.publishing;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public final class VariantPublishingSpec$OutputPublishingSpec
/*     */ {
/*     */   private final TaskOutputHolder.OutputType outputType;
/*     */   private final AndroidArtifacts.ArtifactType artifactType;
/*     */   private final List<AndroidArtifacts.PublishedConfigType> publishedConfigTypes;
/*     */   
/*     */   private VariantPublishingSpec$OutputPublishingSpec(TaskOutputHolder.OutputType outputType, AndroidArtifacts.ArtifactType artifactType, ImmutableList<AndroidArtifacts.PublishedConfigType> publishedConfigTypes)
/*     */   {
/* 359 */     this.outputType = outputType;
/* 360 */     this.artifactType = artifactType;
/* 361 */     this.publishedConfigTypes = publishedConfigTypes;
/*     */   }
/*     */   
/*     */   public TaskOutputHolder.OutputType getOutputType()
/*     */   {
/* 366 */     return outputType;
/*     */   }
/*     */   
/*     */   public AndroidArtifacts.ArtifactType getArtifactType()
/*     */   {
/* 371 */     return artifactType;
/*     */   }
/*     */   
/*     */   public Collection<AndroidArtifacts.PublishedConfigType> getPublishedConfigTypes()
/*     */   {
/* 376 */     return publishedConfigTypes;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 381 */     if (this == o) {
/* 382 */       return true;
/*     */     }
/* 384 */     if ((o == null) || (getClass() != o.getClass())) {
/* 385 */       return false;
/*     */     }
/* 387 */     OutputPublishingSpec that = (OutputPublishingSpec)o;
/* 388 */     if ((outputType == outputType) && (artifactType == artifactType)) {} return 
/*     */     
/* 390 */       Objects.equals(publishedConfigTypes, publishedConfigTypes);
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 395 */     return Objects.hash(new Object[] { outputType, artifactType, publishedConfigTypes });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.publishing.VariantPublishingSpec.OutputPublishingSpec
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */