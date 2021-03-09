/*     */ package com.android.build.gradle.internal.variant;
/*     */ 
/*     */ import com.android.build.gradle.internal.dsl.LanguageSplitOptions;
/*     */ import com.android.build.gradle.internal.dsl.Splits;
/*     */ import java.util.Collection;
/*     */ 
/*     */  enum BaseVariantData$DiscoverableFilterType$2
/*     */ {
/*     */   BaseVariantData$DiscoverableFilterType$2(String folderPrefix)
/*     */   {
/* 525 */     super(paramString, paramInt, folderPrefix, null);
/*     */   }
/*     */   
/*     */   Collection<String> getConfiguredFilters(Splits splits) {
/* 529 */     return splits.getLanguageFilters();
/*     */   }
/*     */   
/*     */   boolean isAuto(Splits splits)
/*     */   {
/* 534 */     return splits.getLanguage().isAuto();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.BaseVariantData.DiscoverableFilterType.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */