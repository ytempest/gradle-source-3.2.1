/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.Collection;
/*     */ 
/*     */  enum SplitsDiscovery$DiscoverableFilterType$3
/*     */ {
/*     */   SplitsDiscovery$DiscoverableFilterType$3(String folderPrefix)
/*     */   {
/* 291 */     super(paramString, paramInt, folderPrefix, null);
/*     */   }
/*     */   
/*     */   Collection<String> getConfiguredFilters(SplitsDiscovery task) {
/* 295 */     return task.getAbiFilters() != null ? task
/* 296 */       .getAbiFilters() : 
/* 297 */       ImmutableList.of();
/*     */   }
/*     */   
/*     */   boolean isAuto(SplitsDiscovery task)
/*     */   {
/* 303 */     return false;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.SplitsDiscovery.DiscoverableFilterType.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */