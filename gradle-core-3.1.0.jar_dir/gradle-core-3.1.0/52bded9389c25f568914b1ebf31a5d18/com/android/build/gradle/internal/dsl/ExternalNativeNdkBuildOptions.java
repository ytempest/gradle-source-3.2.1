/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ public class ExternalNativeNdkBuildOptions
/*     */   implements CoreExternalNativeNdkBuildOptions
/*     */ {
/*  35 */   private final List<String> arguments = Lists.newArrayList();
/*     */   
/*  37 */   private final List<String> cFlags = Lists.newArrayList();
/*     */   
/*  39 */   private final List<String> cppFlags = Lists.newArrayList();
/*     */   
/*  41 */   private final Set<String> abiFilters = Sets.newHashSet();
/*     */   
/*  43 */   private final Set<String> targets = Sets.newHashSet();
/*     */   
/*     */   public List<String> getArguments()
/*     */   {
/*  52 */     return arguments;
/*     */   }
/*     */   
/*     */   public void setArguments(List<String> arguments) {
/*  56 */     this.arguments.addAll(arguments);
/*     */   }
/*     */   
/*     */   public void arguments(String... arguments) {
/*  60 */     Collections.addAll(this.arguments, arguments);
/*     */   }
/*     */   
/*     */   public List<String> getcFlags()
/*     */   {
/*  67 */     return cFlags;
/*     */   }
/*     */   
/*     */   public void setcFlags(List<String> flags) {
/*  71 */     cFlags.addAll(flags);
/*     */   }
/*     */   
/*     */   public void cFlags(String... flags) {
/*  75 */     Collections.addAll(cFlags, flags);
/*     */   }
/*     */   
/*     */   public List<String> getCppFlags()
/*     */   {
/*  82 */     return cppFlags;
/*     */   }
/*     */   
/*     */   public void setCppFlags(List<String> flags) {
/*  86 */     cppFlags.addAll(flags);
/*     */   }
/*     */   
/*     */   public void cppFlags(String... flags) {
/*  90 */     Collections.addAll(cppFlags, flags);
/*     */   }
/*     */   
/*     */   public Set<String> getAbiFilters()
/*     */   {
/*  97 */     return abiFilters;
/*     */   }
/*     */   
/*     */   public void setAbiFilters(Set<String> abiFilters) {
/* 101 */     this.abiFilters.addAll(abiFilters);
/*     */   }
/*     */   
/*     */   public void abiFilters(String... abiFilters) {
/* 105 */     Collections.addAll(this.abiFilters, abiFilters);
/*     */   }
/*     */   
/*     */   public Set<String> getTargets()
/*     */   {
/* 112 */     return targets;
/*     */   }
/*     */   
/*     */   public void setTargets(Set<String> targets) {
/* 116 */     this.targets.addAll(targets);
/*     */   }
/*     */   
/*     */   public void targets(String... targets) {
/* 120 */     Collections.addAll(this.targets, targets);
/*     */   }
/*     */   
/*     */   public void _initWith(CoreExternalNativeNdkBuildOptions that) {
/* 124 */     setArguments(that.getArguments());
/* 125 */     setcFlags(that.getcFlags());
/* 126 */     setCppFlags(that.getCppFlags());
/* 127 */     setAbiFilters(that.getAbiFilters());
/* 128 */     setTargets(that.getTargets());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.ExternalNativeNdkBuildOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */