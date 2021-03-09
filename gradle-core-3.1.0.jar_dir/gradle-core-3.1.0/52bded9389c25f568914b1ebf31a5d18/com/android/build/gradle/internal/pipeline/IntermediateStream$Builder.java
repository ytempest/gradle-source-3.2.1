/*     */ package com.android.build.gradle.internal.pipeline;
/*     */ 
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.QualifiedContent.ScopeType;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.io.File;
/*     */ import java.util.Arrays;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ final class IntermediateStream$Builder
/*     */ {
/*     */   private final Project project;
/*     */   private final String name;
/*  53 */   private Set<QualifiedContent.ContentType> contentTypes = Sets.newHashSet();
/*  54 */   private Set<QualifiedContent.ScopeType> scopes = Sets.newHashSet();
/*     */   private File rootLocation;
/*     */   private String taskName;
/*     */   
/*     */   public IntermediateStream$Builder(Project project, String name) {
/*  59 */     this.project = project;
/*  60 */     this.name = name;
/*     */   }
/*     */   
/*     */   public IntermediateStream build() {
/*  64 */     Preconditions.checkNotNull(rootLocation);
/*  65 */     Preconditions.checkNotNull(taskName);
/*  66 */     Preconditions.checkState(!contentTypes.isEmpty());
/*  67 */     Preconditions.checkState(!scopes.isEmpty());
/*     */     
/*  70 */     FileCollection fileCollection = project.files(new Object[] { rootLocation }).builtBy(new Object[] { taskName });
/*     */     
/*  72 */     return new IntermediateStream(name, 
/*     */     
/*  74 */       ImmutableSet.copyOf(contentTypes), 
/*  75 */       ImmutableSet.copyOf(scopes), fileCollection, null);
/*     */   }
/*     */   
/*     */   Builder addContentTypes(Set<QualifiedContent.ContentType> types)
/*     */   {
/*  80 */     contentTypes.addAll(types);
/*  81 */     return this;
/*     */   }
/*     */   
/*     */   Builder addContentTypes(QualifiedContent.ContentType... types) {
/*  85 */     contentTypes.addAll(Arrays.asList(types));
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   Builder addScopes(Set<? super QualifiedContent.Scope> scopes) {
/*  90 */     for (Object scope : scopes) {
/*  91 */       this.scopes.add((QualifiedContent.ScopeType)scope);
/*     */     }
/*  93 */     return this;
/*     */   }
/*     */   
/*     */   Builder addScopes(QualifiedContent.Scope... scopes) {
/*  97 */     this.scopes.addAll(Arrays.asList(scopes));
/*  98 */     return this;
/*     */   }
/*     */   
/*     */   Builder setRootLocation(File rootLocation) {
/* 102 */     this.rootLocation = rootLocation;
/* 103 */     return this;
/*     */   }
/*     */   
/*     */   Builder setTaskName(String taskName) {
/* 107 */     this.taskName = taskName;
/* 108 */     return this;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.IntermediateStream.Builder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */