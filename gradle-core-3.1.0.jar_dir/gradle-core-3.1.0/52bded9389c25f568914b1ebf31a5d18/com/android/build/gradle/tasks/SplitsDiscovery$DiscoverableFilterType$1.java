/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.Collection;
/*     */ 
/*     */  enum SplitsDiscovery$DiscoverableFilterType$1
/*     */ {
/*     */   SplitsDiscovery$DiscoverableFilterType$1(String folderPrefix)
/*     */   {
/* 264 */     super(paramString, paramInt, folderPrefix, null);
/*     */   }
/*     */   
/*     */   Collection<String> getConfiguredFilters(SplitsDiscovery task) {
/* 268 */     return task.getDensityFilters() != null ? task
/* 269 */       .getDensityFilters() : 
/* 270 */       ImmutableList.of();
/*     */   }
/*     */   
/*     */   boolean isAuto(SplitsDiscovery task)
/*     */   {
/* 275 */     return task.isDensityAuto();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.SplitsDiscovery.DiscoverableFilterType.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */