/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.build.gradle.internal.BuildTypeData;
/*     */ import com.android.build.gradle.internal.api.DefaultAndroidSourceSet;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.model.BuildType;
/*     */ import com.android.builder.model.BuildTypeContainer;
/*     */ import com.android.builder.model.SourceProvider;
/*     */ import com.android.builder.model.SourceProviderContainer;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.UnmodifiableIterator;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ final class BuildTypeContainerImpl
/*     */   implements BuildTypeContainer, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final BuildType buildType;
/*     */   private final SourceProvider sourceProvider;
/*     */   private final Collection<SourceProviderContainer> extraSourceProviders;
/*     */   
/*     */   static BuildTypeContainer create(BuildTypeData buildTypeData, Collection<SourceProviderContainer> sourceProviderContainers)
/*     */   {
/*  58 */     List<SourceProviderContainer> clonedContainers = SourceProviderContainerImpl.cloneCollection(sourceProviderContainers);
/*     */     
/*  60 */     for (UnmodifiableIterator localUnmodifiableIterator = VariantType.getTestingTypes().iterator(); localUnmodifiableIterator.hasNext();) { VariantType variantType = (VariantType)localUnmodifiableIterator.next();
/*  61 */       DefaultAndroidSourceSet testSourceSet = buildTypeData.getTestSourceSet(variantType);
/*  62 */       if (testSourceSet != null) {
/*  63 */         clonedContainers.add(SourceProviderContainerImpl.create(variantType
/*  64 */           .getArtifactName(), testSourceSet));
/*     */       }
/*     */     }
/*     */     
/*  68 */     return new BuildTypeContainerImpl(new BuildTypeImpl(buildTypeData
/*  69 */       .getBuildType()), new SourceProviderImpl(buildTypeData
/*  70 */       .getSourceSet()), clonedContainers);
/*     */   }
/*     */   
/*     */   private BuildTypeContainerImpl(BuildTypeImpl buildType, SourceProviderImpl sourceProvider, Collection<SourceProviderContainer> extraSourceProviders)
/*     */   {
/*  78 */     this.buildType = buildType;
/*  79 */     this.sourceProvider = sourceProvider;
/*  80 */     this.extraSourceProviders = extraSourceProviders;
/*     */   }
/*     */   
/*     */   public BuildType getBuildType()
/*     */   {
/*  86 */     return buildType;
/*     */   }
/*     */   
/*     */   public SourceProvider getSourceProvider()
/*     */   {
/*  92 */     return sourceProvider;
/*     */   }
/*     */   
/*     */   public Collection<SourceProviderContainer> getExtraSourceProviders()
/*     */   {
/*  98 */     return extraSourceProviders;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 103 */     if (this == o) {
/* 104 */       return true;
/*     */     }
/* 106 */     if ((o == null) || (getClass() != o.getClass())) {
/* 107 */       return false;
/*     */     }
/* 109 */     BuildTypeContainerImpl that = (BuildTypeContainerImpl)o;
/* 110 */     return (Objects.equals(buildType, buildType)) && 
/* 111 */       (Objects.equals(sourceProvider, sourceProvider)) && 
/* 112 */       (Objects.equals(extraSourceProviders, extraSourceProviders));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 117 */     return Objects.hash(new Object[] { buildType, sourceProvider, extraSourceProviders });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.BuildTypeContainerImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */