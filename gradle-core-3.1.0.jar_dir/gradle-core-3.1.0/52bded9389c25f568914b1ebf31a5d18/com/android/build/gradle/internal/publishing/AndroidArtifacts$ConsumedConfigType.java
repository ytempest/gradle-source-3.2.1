/*     */ package com.android.build.gradle.internal.publishing;
/*     */ 
/*     */ public enum AndroidArtifacts$ConsumedConfigType
/*     */ {
/*  93 */   COMPILE_CLASSPATH("compileClasspath", AndroidArtifacts.PublishedConfigType.API_ELEMENTS, true), 
/*  94 */   RUNTIME_CLASSPATH("runtimeClasspath", AndroidArtifacts.PublishedConfigType.RUNTIME_ELEMENTS, true), 
/*  95 */   ANNOTATION_PROCESSOR("annotationProcessorClasspath", AndroidArtifacts.PublishedConfigType.RUNTIME_ELEMENTS, false), 
/*  96 */   METADATA_VALUES("metadata", AndroidArtifacts.PublishedConfigType.METADATA_ELEMENTS, false);
/*     */   
/*     */   private final String name;
/*     */   
/*     */   private final AndroidArtifacts.PublishedConfigType publishedTo;
/*     */   private final boolean needsTestedComponents;
/*     */   
/*     */   private AndroidArtifacts$ConsumedConfigType(String name, AndroidArtifacts.PublishedConfigType publishedTo, boolean needsTestedComponents)
/*     */   {
/* 106 */     this.name = name;
/* 107 */     this.publishedTo = publishedTo;
/* 108 */     this.needsTestedComponents = needsTestedComponents;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 113 */     return name;
/*     */   }
/*     */   
/*     */   public AndroidArtifacts.PublishedConfigType getPublishedTo()
/*     */   {
/* 118 */     return publishedTo;
/*     */   }
/*     */   
/*     */   public boolean needsTestedComponents() {
/* 122 */     return needsTestedComponents;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */