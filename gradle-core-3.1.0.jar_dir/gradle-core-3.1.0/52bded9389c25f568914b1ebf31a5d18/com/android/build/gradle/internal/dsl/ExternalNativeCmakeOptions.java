/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ public class ExternalNativeCmakeOptions
/*     */   implements CoreExternalNativeCmakeOptions
/*     */ {
/*  38 */   private final List<String> arguments = Lists.newArrayList();
/*     */   
/*  40 */   private final List<String> cFlags = Lists.newArrayList();
/*     */   
/*  42 */   private final List<String> cppFlags = Lists.newArrayList();
/*     */   
/*  44 */   private final Set<String> abiFilters = Sets.newHashSet();
/*     */   
/*  46 */   private final Set<String> targets = Sets.newHashSet();
/*     */   
/*     */   public List<String> getArguments()
/*     */   {
/*  55 */     return arguments;
/*     */   }
/*     */   
/*     */   public void setArguments(List<String> arguments) {
/*  59 */     this.arguments.addAll(arguments);
/*     */   }
/*     */   
/*     */   public void arguments(String... arguments) {
/*  63 */     Collections.addAll(this.arguments, arguments);
/*     */   }
/*     */   
/*     */   public List<String> getcFlags()
/*     */   {
/*  70 */     return cFlags;
/*     */   }
/*     */   
/*     */   public void setcFlags(List<String> flags) {
/*  74 */     cFlags.addAll(flags);
/*     */   }
/*     */   
/*     */   public void cFlags(String... flags) {
/*  78 */     Collections.addAll(cFlags, flags);
/*     */   }
/*     */   
/*     */   public List<String> getCppFlags()
/*     */   {
/*  85 */     return cppFlags;
/*     */   }
/*     */   
/*     */   public void setCppFlags(List<String> flags) {
/*  89 */     cppFlags.addAll(flags);
/*     */   }
/*     */   
/*     */   public void cppFlags(String... flags) {
/*  93 */     Collections.addAll(cppFlags, flags);
/*     */   }
/*     */   
/*     */   public Set<String> getAbiFilters()
/*     */   {
/* 100 */     return abiFilters;
/*     */   }
/*     */   
/*     */   public void setAbiFilters(Set<String> abiFilters) {
/* 104 */     this.abiFilters.addAll(abiFilters);
/*     */   }
/*     */   
/*     */   public void abiFilters(String... abiFilters) {
/* 108 */     Collections.addAll(this.abiFilters, abiFilters);
/*     */   }
/*     */   
/*     */   public Set<String> getTargets()
/*     */   {
/* 115 */     return targets;
/*     */   }
/*     */   
/*     */   public void setTargets(Set<String> targets) {
/* 119 */     this.targets.addAll(targets);
/*     */   }
/*     */   
/*     */   public void targets(String... targets) {
/* 123 */     Collections.addAll(this.targets, targets);
/*     */   }
/*     */   
/*     */   public void _initWith(CoreExternalNativeCmakeOptions that) {
/* 127 */     setArguments(that.getArguments());
/* 128 */     setcFlags(that.getcFlags());
/* 129 */     setCppFlags(that.getCppFlags());
/* 130 */     setAbiFilters(that.getAbiFilters());
/* 131 */     setTargets(that.getTargets());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.ExternalNativeCmakeOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */