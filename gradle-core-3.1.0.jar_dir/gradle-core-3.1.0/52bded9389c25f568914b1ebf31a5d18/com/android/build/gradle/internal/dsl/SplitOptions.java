/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Set;
/*     */ 
/*     */ public abstract class SplitOptions
/*     */ {
/*     */   private final Set<String> values;
/*     */   private final ImmutableSet<String> allowedValues;
/*  35 */   private boolean enable = false;
/*     */   
/*     */   protected SplitOptions() {
/*  38 */     values = getDefaultValues();
/*  39 */     allowedValues = getAllowedValues();
/*     */   }
/*     */   
/*     */   protected abstract Set<String> getDefaultValues();
/*     */   
/*     */   protected abstract ImmutableSet<String> getAllowedValues();
/*     */   
/*     */   public boolean isEnable()
/*     */   {
/*  49 */     return enable;
/*     */   }
/*     */   
/*     */   public void setEnable(boolean enable) {
/*  53 */     this.enable = enable;
/*     */   }
/*     */   
/*     */   public void exclude(String... excludes)
/*     */   {
/*  60 */     values.removeAll(Arrays.asList(excludes));
/*     */   }
/*     */   
/*     */   public void include(String... includes)
/*     */   {
/*  67 */     values.addAll(Arrays.asList(includes));
/*     */   }
/*     */   
/*     */   public void reset()
/*     */   {
/*  77 */     values.clear();
/*     */   }
/*     */   
/*     */   public Set<String> getApplicableFilters()
/*     */   {
/*  89 */     if (!enable) {
/*  90 */       return Collections.emptySet();
/*     */     }
/*     */     
/*  93 */     Set<String> results = Sets.newHashSetWithExpectedSize(values.size());
/*     */     
/*  95 */     for (String value : values) {
/*  96 */       if (allowedValues.contains(value)) {
/*  97 */         results.add(value);
/*     */       }
/*     */     }
/*     */     
/* 101 */     return results;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.SplitOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */