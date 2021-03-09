/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.Collection;
/*     */ 
/*     */  enum SplitsDiscovery$DiscoverableFilterType
/*     */ {
/* 264 */   DENSITY("drawable-"), 
/*     */   
/* 278 */   LANGUAGE("values-"), 
/*     */   
/* 291 */   ABI("");
/*     */   
/*     */   private final String folderPrefix;
/*     */   
/*     */   private SplitsDiscovery$DiscoverableFilterType(String folderPrefix)
/*     */   {
/* 311 */     this.folderPrefix = folderPrefix;
/*     */   }
/*     */   
/*     */   abstract Collection<String> getConfiguredFilters(SplitsDiscovery paramSplitsDiscovery);
/*     */   
/*     */   abstract boolean isAuto(SplitsDiscovery paramSplitsDiscovery);
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.SplitsDiscovery.DiscoverableFilterType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */