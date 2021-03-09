/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import java.io.File;
/*     */ import org.gradle.api.artifacts.component.ComponentArtifactIdentifier;
/*     */ import org.gradle.api.artifacts.result.ResolvedArtifactResult;
/*     */ import org.gradle.api.artifacts.result.ResolvedVariantResult;
/*     */ import org.gradle.api.component.Artifact;
/*     */ 
/*     */ public class ArtifactDependencyGraph$HashableResolvedArtifactResult
/*     */   implements ResolvedArtifactResult
/*     */ {
/*     */   private final ResolvedArtifactResult delegate;
/*     */   private final ArtifactDependencyGraph.DependencyType dependencyType;
/*     */   private final boolean wrappedModule;
/*     */   private final ResolvedArtifactResult bundleResult;
/*     */   private final ImmutableMap<String, String> buildMapping;
/*     */   
/*     */   public ArtifactDependencyGraph$HashableResolvedArtifactResult(ResolvedArtifactResult delegate, ArtifactDependencyGraph.DependencyType dependencyType, boolean wrappedModule, ResolvedArtifactResult bundleResult, ImmutableMap<String, String> buildMapping)
/*     */   {
/* 830 */     this.delegate = delegate;
/* 831 */     this.dependencyType = dependencyType;
/* 832 */     this.wrappedModule = wrappedModule;
/* 833 */     this.bundleResult = bundleResult;
/* 834 */     this.buildMapping = buildMapping;
/*     */   }
/*     */   
/*     */   public File getFile()
/*     */   {
/* 839 */     return delegate.getFile();
/*     */   }
/*     */   
/*     */   public ResolvedVariantResult getVariant()
/*     */   {
/* 844 */     return delegate.getVariant();
/*     */   }
/*     */   
/*     */   public ComponentArtifactIdentifier getId()
/*     */   {
/* 849 */     return delegate.getId();
/*     */   }
/*     */   
/*     */   public Class<? extends Artifact> getType()
/*     */   {
/* 854 */     return delegate.getType();
/*     */   }
/*     */   
/*     */   public ArtifactDependencyGraph.DependencyType getDependencyType()
/*     */   {
/* 859 */     return dependencyType;
/*     */   }
/*     */   
/*     */   public boolean isWrappedModule() {
/* 863 */     return wrappedModule;
/*     */   }
/*     */   
/*     */   public ImmutableMap<String, String> getBuildMapping()
/*     */   {
/* 868 */     return buildMapping;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 873 */     if (this == o) {
/* 874 */       return true;
/*     */     }
/* 876 */     if ((o == null) || (getClass() != o.getClass())) {
/* 877 */       return false;
/*     */     }
/* 879 */     HashableResolvedArtifactResult that = (HashableResolvedArtifactResult)o;
/* 880 */     if ((wrappedModule == wrappedModule) && (dependencyType == dependencyType)) {} return 
/*     */     
/* 882 */       (com.google.common.base.Objects.equal(getFile(), that.getFile())) && 
/* 883 */       (com.google.common.base.Objects.equal(getId(), that.getId())) && 
/* 884 */       (com.google.common.base.Objects.equal(getType(), that.getType())) && 
/* 885 */       (com.google.common.base.Objects.equal(getBuildMapping(), that.getBuildMapping()));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 890 */     return java.util.Objects.hash(new Object[] { delegate, dependencyType, Boolean.valueOf(wrappedModule), buildMapping });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 895 */     return getId().toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.ArtifactDependencyGraph.HashableResolvedArtifactResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */