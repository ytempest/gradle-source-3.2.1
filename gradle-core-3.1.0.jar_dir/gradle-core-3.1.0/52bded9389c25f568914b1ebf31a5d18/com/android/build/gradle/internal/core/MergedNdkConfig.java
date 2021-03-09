/*     */ package com.android.build.gradle.internal.core;
/*     */ 
/*     */ import com.android.build.gradle.internal.dsl.CoreNdkOptions;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class MergedNdkConfig
/*     */   implements CoreNdkOptions
/*     */ {
/*     */   private String moduleName;
/*     */   private String cFlags;
/*     */   private List<String> ldLibs;
/*     */   private Set<String> abiFilters;
/*     */   private String stl;
/*     */   private Integer jobs;
/*     */   
/*     */   public void reset()
/*     */   {
/*  40 */     moduleName = null;
/*  41 */     cFlags = null;
/*  42 */     ldLibs = null;
/*  43 */     abiFilters = null;
/*     */   }
/*     */   
/*     */   public String getModuleName()
/*     */   {
/*  49 */     return moduleName;
/*     */   }
/*     */   
/*     */   public String getcFlags()
/*     */   {
/*  55 */     return cFlags;
/*     */   }
/*     */   
/*     */   public List<String> getLdLibs()
/*     */   {
/*  61 */     return ldLibs;
/*     */   }
/*     */   
/*     */   public Set<String> getAbiFilters()
/*     */   {
/*  67 */     return abiFilters;
/*     */   }
/*     */   
/*     */   public String getStl()
/*     */   {
/*  73 */     return stl;
/*     */   }
/*     */   
/*     */   public Integer getJobs()
/*     */   {
/*  79 */     return jobs;
/*     */   }
/*     */   
/*     */   public void append(CoreNdkOptions ndkConfig)
/*     */   {
/*  84 */     if (ndkConfig.getModuleName() != null) {
/*  85 */       moduleName = ndkConfig.getModuleName();
/*     */     }
/*     */     
/*  88 */     if (ndkConfig.getStl() != null) {
/*  89 */       stl = ndkConfig.getStl();
/*     */     }
/*     */     
/*  92 */     if (ndkConfig.getJobs() != null) {
/*  93 */       jobs = ndkConfig.getJobs();
/*     */     }
/*     */     
/*  97 */     if (ndkConfig.getAbiFilters() != null) {
/*  98 */       if (abiFilters == null) {
/*  99 */         abiFilters = Sets.newHashSetWithExpectedSize(ndkConfig.getAbiFilters().size());
/*     */       }
/* 101 */       abiFilters.addAll(ndkConfig.getAbiFilters());
/*     */     }
/*     */     
/* 104 */     if (cFlags == null) {
/* 105 */       cFlags = ndkConfig.getcFlags();
/* 106 */     } else if ((ndkConfig.getcFlags() != null) && (!ndkConfig.getcFlags().isEmpty())) {
/* 107 */       cFlags = (cFlags + " " + ndkConfig.getcFlags());
/*     */     }
/*     */     
/* 110 */     if (ndkConfig.getLdLibs() != null) {
/* 111 */       if (ldLibs == null) {
/* 112 */         ldLibs = Lists.newArrayListWithCapacity(ndkConfig.getLdLibs().size());
/*     */       }
/* 114 */       ldLibs.addAll(ndkConfig.getLdLibs());
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.core.MergedNdkConfig
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */