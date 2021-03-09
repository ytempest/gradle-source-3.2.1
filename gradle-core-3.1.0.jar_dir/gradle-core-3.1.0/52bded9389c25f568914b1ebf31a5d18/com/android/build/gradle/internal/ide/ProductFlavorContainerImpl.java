/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.build.gradle.internal.ProductFlavorData;
/*     */ import com.android.build.gradle.internal.api.DefaultAndroidSourceSet;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import com.android.builder.model.ProductFlavorContainer;
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
/*     */ final class ProductFlavorContainerImpl
/*     */   implements ProductFlavorContainer, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final ProductFlavor productFlavor;
/*     */   private final SourceProvider sourceProvider;
/*     */   private final Collection<SourceProviderContainer> extraSourceProviders;
/*     */   
/*     */   static ProductFlavorContainer createProductFlavorContainer(ProductFlavorData productFlavorData, Collection<SourceProviderContainer> sourceProviderContainers)
/*     */   {
/*  60 */     List<SourceProviderContainer> clonedContainers = SourceProviderContainerImpl.cloneCollection(sourceProviderContainers);
/*     */     
/*  62 */     for (UnmodifiableIterator localUnmodifiableIterator = VariantType.getTestingTypes().iterator(); localUnmodifiableIterator.hasNext();) { VariantType variantType = (VariantType)localUnmodifiableIterator.next();
/*     */       
/*  64 */       DefaultAndroidSourceSet sourceSet = productFlavorData.getTestSourceSet(variantType);
/*  65 */       if (sourceSet != null) {
/*  66 */         clonedContainers.add(SourceProviderContainerImpl.create(variantType
/*  67 */           .getArtifactName(), sourceSet));
/*     */       }
/*     */     }
/*     */     
/*  72 */     return new ProductFlavorContainerImpl(new ProductFlavorImpl(productFlavorData
/*  73 */       .getProductFlavor()), new SourceProviderImpl(productFlavorData
/*  74 */       .getSourceSet()), clonedContainers);
/*     */   }
/*     */   
/*     */   private ProductFlavorContainerImpl(ProductFlavorImpl productFlavor, SourceProviderImpl sourceProvider, Collection<SourceProviderContainer> extraSourceProviders)
/*     */   {
/*  83 */     this.productFlavor = productFlavor;
/*  84 */     this.sourceProvider = sourceProvider;
/*  85 */     this.extraSourceProviders = extraSourceProviders;
/*     */   }
/*     */   
/*     */   public ProductFlavor getProductFlavor()
/*     */   {
/*  91 */     return productFlavor;
/*     */   }
/*     */   
/*     */   public SourceProvider getSourceProvider()
/*     */   {
/*  97 */     return sourceProvider;
/*     */   }
/*     */   
/*     */   public Collection<SourceProviderContainer> getExtraSourceProviders()
/*     */   {
/* 103 */     return extraSourceProviders;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 108 */     if (this == o) {
/* 109 */       return true;
/*     */     }
/* 111 */     if ((o == null) || (getClass() != o.getClass())) {
/* 112 */       return false;
/*     */     }
/* 114 */     ProductFlavorContainerImpl that = (ProductFlavorContainerImpl)o;
/* 115 */     return (Objects.equals(productFlavor, productFlavor)) && 
/* 116 */       (Objects.equals(sourceProvider, sourceProvider)) && 
/* 117 */       (Objects.equals(extraSourceProviders, extraSourceProviders));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 122 */     return Objects.hash(new Object[] { productFlavor, sourceProvider, extraSourceProviders });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.ProductFlavorContainerImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */