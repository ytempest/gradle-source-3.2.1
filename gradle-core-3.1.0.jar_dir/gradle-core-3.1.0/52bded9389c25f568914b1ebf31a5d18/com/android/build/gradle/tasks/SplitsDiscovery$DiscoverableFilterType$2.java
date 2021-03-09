/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.Collection;
/*     */ 
/*     */  enum SplitsDiscovery$DiscoverableFilterType$2
/*     */ {
/*     */   SplitsDiscovery$DiscoverableFilterType$2(String folderPrefix)
/*     */   {
/* 278 */     super(paramString, paramInt, folderPrefix, null);
/*     */   }
/*     */   
/*     */   Collection<String> getConfiguredFilters(SplitsDiscovery task) {
/* 282 */     return task.getLanguageFilters() != null ? task
/* 283 */       .getLanguageFilters() : 
/* 284 */       ImmutableList.of();
/*     */   }
/*     */   
/*     */   boolean isAuto(SplitsDiscovery task)
/*     */   {
/* 289 */     return task.isLanguageAuto();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.SplitsDiscovery.DiscoverableFilterType.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */