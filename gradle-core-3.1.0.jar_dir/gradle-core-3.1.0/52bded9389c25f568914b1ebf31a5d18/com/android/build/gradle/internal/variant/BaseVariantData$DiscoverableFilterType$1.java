/*     */ package com.android.build.gradle.internal.variant;
/*     */ 
/*     */ import com.android.build.gradle.internal.dsl.DensitySplitOptions;
/*     */ import com.android.build.gradle.internal.dsl.Splits;
/*     */ import java.util.Collection;
/*     */ 
/*     */  enum BaseVariantData$DiscoverableFilterType$1
/*     */ {
/*     */   BaseVariantData$DiscoverableFilterType$1(String folderPrefix)
/*     */   {
/* 513 */     super(paramString, paramInt, folderPrefix, null);
/*     */   }
/*     */   
/*     */   Collection<String> getConfiguredFilters(Splits splits) {
/* 517 */     return splits.getDensityFilters();
/*     */   }
/*     */   
/*     */   boolean isAuto(Splits splits)
/*     */   {
/* 522 */     return splits.getDensity().isAuto();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.BaseVariantData.DiscoverableFilterType.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */