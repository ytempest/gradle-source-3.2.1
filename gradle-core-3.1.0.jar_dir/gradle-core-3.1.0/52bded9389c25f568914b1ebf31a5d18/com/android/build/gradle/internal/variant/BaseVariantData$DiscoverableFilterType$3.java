/*     */ package com.android.build.gradle.internal.variant;
/*     */ 
/*     */ import com.android.build.gradle.internal.dsl.Splits;
/*     */ import java.util.Collection;
/*     */ 
/*     */  enum BaseVariantData$DiscoverableFilterType$3
/*     */ {
/*     */   BaseVariantData$DiscoverableFilterType$3(String folderPrefix)
/*     */   {
/* 536 */     super(paramString, paramInt, folderPrefix, null);
/*     */   }
/*     */   
/*     */   Collection<String> getConfiguredFilters(Splits splits) {
/* 540 */     return splits.getAbiFilters();
/*     */   }
/*     */   
/*     */   boolean isAuto(Splits splits)
/*     */   {
/* 546 */     return false;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.BaseVariantData.DiscoverableFilterType.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */