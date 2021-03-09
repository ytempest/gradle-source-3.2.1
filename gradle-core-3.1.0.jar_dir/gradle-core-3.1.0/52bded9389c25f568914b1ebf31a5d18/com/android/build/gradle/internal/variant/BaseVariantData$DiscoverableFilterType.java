/*     */ package com.android.build.gradle.internal.variant;
/*     */ 
/*     */ import com.android.build.gradle.internal.dsl.DensitySplitOptions;
/*     */ import com.android.build.gradle.internal.dsl.LanguageSplitOptions;
/*     */ import com.android.build.gradle.internal.dsl.Splits;
/*     */ import java.util.Collection;
/*     */ 
/*     */  enum BaseVariantData$DiscoverableFilterType
/*     */ {
/* 513 */   DENSITY("drawable-"), 
/*     */   
/* 525 */   LANGUAGE("values-"), 
/*     */   
/* 536 */   ABI("");
/*     */   
/*     */   private String folderPrefix;
/*     */   
/*     */   private BaseVariantData$DiscoverableFilterType(String folderPrefix)
/*     */   {
/* 556 */     this.folderPrefix = folderPrefix;
/*     */   }
/*     */   
/*     */   abstract Collection<String> getConfiguredFilters(Splits paramSplits);
/*     */   
/*     */   abstract boolean isAuto(Splits paramSplits);
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.BaseVariantData.DiscoverableFilterType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */