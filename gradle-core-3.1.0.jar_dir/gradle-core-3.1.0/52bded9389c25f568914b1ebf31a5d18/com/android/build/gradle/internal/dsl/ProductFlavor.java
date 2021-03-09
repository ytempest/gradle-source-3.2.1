/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.build.gradle.internal.VariantManager;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.builder.core.DefaultProductFlavor.DimensionRequest;
/*     */ import com.android.builder.model.BaseConfig;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.model.ObjectFactory;
/*     */ 
/*     */ public class ProductFlavor
/*     */   extends BaseFlavor
/*     */ {
/*     */   private ImmutableList<String> matchingFallbacks;
/*     */   
/*     */   @Inject
/*     */   public ProductFlavor(String name, Project project, ObjectFactory objectFactory, DeprecationReporter deprecationReporter, Logger logger)
/*     */   {
/*  70 */     super(name, project, objectFactory, deprecationReporter, logger);
/*     */   }
/*     */   
/*     */   public void setMatchingFallbacks(String... fallbacks)
/*     */   {
/*  76 */     matchingFallbacks = ImmutableList.copyOf(fallbacks);
/*     */   }
/*     */   
/*     */   public void setMatchingFallbacks(String fallback) {
/*  80 */     matchingFallbacks = ImmutableList.of(fallback);
/*     */   }
/*     */   
/*     */   public void setMatchingFallbacks(List<String> fallbacks) {
/*  84 */     matchingFallbacks = ImmutableList.copyOf(fallbacks);
/*     */   }
/*     */   
/*     */   public List<String> getMatchingFallbacks()
/*     */   {
/* 149 */     if (matchingFallbacks == null) {
/* 150 */       return ImmutableList.of();
/*     */     }
/* 152 */     return matchingFallbacks;
/*     */   }
/*     */   
/*     */   protected DefaultProductFlavor.DimensionRequest computeRequestedAndFallBacks(List<String> requestedValues)
/*     */   {
/* 163 */     return new DefaultProductFlavor.DimensionRequest(
/* 164 */       VariantManager.getModifiedName(getName()), ImmutableList.copyOf(requestedValues));
/*     */   }
/*     */   
/*     */   protected void _initWith(BaseConfig that)
/*     */   {
/* 169 */     super._initWith(that);
/*     */     
/* 171 */     if ((that instanceof ProductFlavor)) {
/* 172 */       matchingFallbacks = matchingFallbacks;
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.ProductFlavor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */