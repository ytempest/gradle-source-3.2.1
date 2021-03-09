/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ 
/*     */ public class NdkOptions
/*     */   implements CoreNdkOptions, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String moduleName;
/*     */   private String cFlags;
/*     */   private List<String> ldLibs;
/*     */   private Set<String> abiFilters;
/*     */   private String stl;
/*     */   private Integer jobs;
/*     */   
/*     */   public void _initWith(CoreNdkOptions ndkConfig)
/*     */   {
/*  48 */     moduleName = ndkConfig.getModuleName();
/*  49 */     cFlags = ndkConfig.getcFlags();
/*  50 */     setLdLibs(ndkConfig.getLdLibs());
/*  51 */     setAbiFilters(ndkConfig.getAbiFilters());
/*     */   }
/*     */   
/*     */   @Input
/*     */   @Optional
/*     */   public String getModuleName() {
/*  57 */     return moduleName;
/*     */   }
/*     */   
/*     */   public void setModuleName(String moduleName) {
/*  61 */     this.moduleName = moduleName;
/*     */   }
/*     */   
/*     */   @Input
/*     */   @Optional
/*     */   public String getcFlags() {
/*  67 */     return cFlags;
/*     */   }
/*     */   
/*     */   public void setcFlags(String cFlags) {
/*  71 */     this.cFlags = cFlags;
/*     */   }
/*     */   
/*     */   @Input
/*     */   @Optional
/*     */   public List<String> getLdLibs() {
/*  77 */     return ldLibs;
/*     */   }
/*     */   
/*     */   public NdkOptions ldLibs(String lib)
/*     */   {
/*  82 */     if (ldLibs == null) {
/*  83 */       ldLibs = Lists.newArrayList();
/*     */     }
/*  85 */     ldLibs.add(lib);
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   public NdkOptions ldLibs(String... libs)
/*     */   {
/*  91 */     if (ldLibs == null) {
/*  92 */       ldLibs = Lists.newArrayListWithCapacity(libs.length);
/*     */     }
/*  94 */     Collections.addAll(ldLibs, libs);
/*  95 */     return this;
/*     */   }
/*     */   
/*     */   public NdkOptions setLdLibs(Collection<String> libs)
/*     */   {
/* 100 */     if (libs != null) {
/* 101 */       if (ldLibs == null) {
/* 102 */         ldLibs = Lists.newArrayListWithCapacity(libs.size());
/*     */       } else {
/* 104 */         ldLibs.clear();
/*     */       }
/* 106 */       ldLibs.addAll(libs);
/*     */     } else {
/* 108 */       ldLibs = null;
/*     */     }
/* 110 */     return this;
/*     */   }
/*     */   
/*     */   @Input
/*     */   @Optional
/*     */   public Set<String> getAbiFilters()
/*     */   {
/* 118 */     return abiFilters;
/*     */   }
/*     */   
/*     */   public NdkOptions abiFilter(String filter)
/*     */   {
/* 124 */     if (abiFilters == null) {
/* 125 */       abiFilters = Sets.newHashSetWithExpectedSize(2);
/*     */     }
/* 127 */     abiFilters.add(filter);
/* 128 */     return this;
/*     */   }
/*     */   
/*     */   public NdkOptions abiFilters(String... filters)
/*     */   {
/* 133 */     if (abiFilters == null) {
/* 134 */       abiFilters = Sets.newHashSetWithExpectedSize(2);
/*     */     }
/* 136 */     Collections.addAll(abiFilters, filters);
/* 137 */     return this;
/*     */   }
/*     */   
/*     */   public NdkOptions setAbiFilters(Collection<String> filters)
/*     */   {
/* 142 */     if (filters != null) {
/* 143 */       if (abiFilters == null) {
/* 144 */         abiFilters = Sets.newHashSetWithExpectedSize(filters.size());
/*     */       } else {
/* 146 */         abiFilters.clear();
/*     */       }
/* 148 */       abiFilters.addAll(filters);
/*     */     } else {
/* 150 */       abiFilters = null;
/*     */     }
/* 152 */     return this;
/*     */   }
/*     */   
/*     */   public String getStl()
/*     */   {
/* 158 */     return stl;
/*     */   }
/*     */   
/*     */   public void setStl(String stl) {
/* 162 */     this.stl = stl;
/*     */   }
/*     */   
/*     */   public Integer getJobs()
/*     */   {
/* 168 */     return jobs;
/*     */   }
/*     */   
/*     */   public void setJobs(Integer jobs) {
/* 172 */     this.jobs = jobs;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.NdkOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */