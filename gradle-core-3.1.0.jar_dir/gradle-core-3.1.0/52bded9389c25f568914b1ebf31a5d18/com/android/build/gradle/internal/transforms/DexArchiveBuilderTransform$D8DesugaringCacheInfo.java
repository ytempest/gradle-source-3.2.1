/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import java.nio.file.Path;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ class DexArchiveBuilderTransform$D8DesugaringCacheInfo
/*     */ {
/* 601 */   private static final D8DesugaringCacheInfo NO_INFO = new D8DesugaringCacheInfo(
/* 602 */     Collections.emptyList());
/*     */   
/* 605 */   private static final D8DesugaringCacheInfo DONT_CACHE = new D8DesugaringCacheInfo(
/* 606 */     Collections.emptyList());
/*     */   private final List<Path> orderedD8DesugaringDependencies;
/*     */   
/*     */   private DexArchiveBuilderTransform$D8DesugaringCacheInfo(List<Path> orderedD8DesugaringDependencies)
/*     */   {
/* 611 */     this.orderedD8DesugaringDependencies = orderedD8DesugaringDependencies;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.DexArchiveBuilderTransform.D8DesugaringCacheInfo
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */