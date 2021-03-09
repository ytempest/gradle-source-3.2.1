/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ public class LanguageSplitOptions
/*     */ {
/*  40 */   private boolean enable = false;
/*  41 */   private boolean auto = false;
/*     */   private Set<String> include;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   
/*     */   @Inject
/*     */   public LanguageSplitOptions(DeprecationReporter deprecationReporter) {
/*  47 */     this.deprecationReporter = deprecationReporter;
/*     */   }
/*     */   
/*     */   public Set<String> getInclude()
/*     */   {
/*  54 */     return include;
/*     */   }
/*     */   
/*     */   public void setInclude(List<String> list) {
/*  58 */     include = Sets.newHashSet(list);
/*     */   }
/*     */   
/*     */   public void include(String... includes)
/*     */   {
/*  65 */     if (include == null) {
/*  66 */       include = Sets.newHashSet(includes);
/*  67 */       return;
/*     */     }
/*     */     
/*  70 */     include.addAll(Arrays.asList(includes));
/*     */   }
/*     */   
/*     */   public Set<String> getApplicationFilters()
/*     */   {
/*  75 */     return (include == null) || (!enable) ? new HashSet() : include;
/*     */   }
/*     */   
/*     */   public void setEnable(boolean enable)
/*     */   {
/*  82 */     this.enable = enable;
/*     */   }
/*     */   
/*     */   public boolean isEnable()
/*     */   {
/*  89 */     return enable;
/*     */   }
/*     */   
/*     */   public void setAuto(boolean auto)
/*     */   {
/* 106 */     deprecationReporter.reportObsoleteUsage("LanguageSplitOptions.auto", DeprecationReporter.DeprecationTarget.AUTO_SPLITS_OR_RES_CONFIG);
/*     */     
/* 109 */     this.auto = auto;
/*     */   }
/*     */   
/*     */   public boolean isAuto()
/*     */   {
/* 118 */     return auto;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.LanguageSplitOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */