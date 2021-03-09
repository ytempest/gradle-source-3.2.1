/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ import com.android.resources.Density;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.ImmutableSet.Builder;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ public class DensitySplitOptions
/*     */   extends SplitOptions
/*     */ {
/*  37 */   private boolean strict = true;
/*  38 */   private boolean auto = false;
/*     */   private Set<String> compatibleScreens;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   
/*     */   @Inject
/*     */   public DensitySplitOptions(DeprecationReporter deprecationReporter) {
/*  44 */     this.deprecationReporter = deprecationReporter;
/*     */   }
/*     */   
/*     */   protected Set<String> getDefaultValues()
/*     */   {
/*  49 */     Set<Density> values = Density.getRecommendedValuesForDevice();
/*  50 */     Set<String> fullList = Sets.newHashSetWithExpectedSize(values.size());
/*  51 */     for (Density value : values) {
/*  52 */       fullList.add(value.getResourceValue());
/*     */     }
/*     */     
/*  55 */     return fullList;
/*     */   }
/*     */   
/*     */   protected ImmutableSet<String> getAllowedValues()
/*     */   {
/*  60 */     ImmutableSet.Builder<String> builder = ImmutableSet.builder();
/*     */     
/*  62 */     for (Density value : Density.values()) {
/*  63 */       if ((value != Density.NODPI) && (value != Density.ANYDPI)) {
/*  64 */         builder.add(value.getResourceValue());
/*     */       }
/*     */     }
/*     */     
/*  68 */     return builder.build();
/*     */   }
/*     */   
/*     */   public boolean isStrict()
/*     */   {
/*  75 */     return strict;
/*     */   }
/*     */   
/*     */   public void setStrict(boolean strict) {
/*  79 */     this.strict = strict;
/*     */   }
/*     */   
/*     */   public void setCompatibleScreens(List<String> sizes) {
/*  83 */     compatibleScreens = Sets.newHashSet(sizes);
/*     */   }
/*     */   
/*     */   public void compatibleScreens(String... sizes)
/*     */   {
/*  92 */     if (compatibleScreens == null) {
/*  93 */       compatibleScreens = Sets.newHashSet(sizes);
/*  94 */       return;
/*     */     }
/*     */     
/*  97 */     compatibleScreens.addAll(Arrays.asList(sizes));
/*     */   }
/*     */   
/*     */   public Set<String> getCompatibleScreens()
/*     */   {
/* 108 */     if (compatibleScreens == null) {
/* 109 */       return Collections.emptySet();
/*     */     }
/* 111 */     return compatibleScreens;
/*     */   }
/*     */   
/*     */   public void setAuto(boolean auto)
/*     */   {
/* 124 */     deprecationReporter.reportObsoleteUsage("DensitySplitOptions.auto", DeprecationReporter.DeprecationTarget.AUTO_SPLITS_OR_RES_CONFIG);
/*     */     
/* 127 */     this.auto = auto;
/*     */   }
/*     */   
/*     */   public boolean isAuto()
/*     */   {
/* 137 */     return auto;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.DensitySplitOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */