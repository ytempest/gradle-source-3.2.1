/*    */ package com.android.build.gradle.internal.core;
/*    */ 
/*    */ import com.android.build.gradle.internal.dsl.CoreExternalNativeCmakeOptions;
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class MergedExternalNativeCmakeOptions
/*    */   implements CoreExternalNativeCmakeOptions
/*    */ {
/*    */   private final List<String> arguments;
/*    */   private final List<String> cFlags;
/*    */   private final List<String> cppFlags;
/*    */   private final Set<String> abiFilters;
/*    */   
/*    */   public MergedExternalNativeCmakeOptions()
/*    */   {
/* 31 */     arguments = Lists.newArrayList();
/*    */     
/* 33 */     cFlags = Lists.newArrayList();
/*    */     
/* 35 */     cppFlags = Lists.newArrayList();
/*    */     
/* 37 */     abiFilters = Sets.newHashSet(); }
/*    */   
/* 39 */   private final Set<String> targets = Sets.newHashSet();
/*    */   
/*    */   public void reset() {
/* 42 */     arguments.clear();
/* 43 */     cFlags.clear();
/* 44 */     cppFlags.clear();
/* 45 */     abiFilters.clear();
/* 46 */     targets.clear();
/*    */   }
/*    */   
/*    */   public void append(CoreExternalNativeCmakeOptions options) {
/* 50 */     arguments.addAll(options.getArguments());
/* 51 */     cFlags.addAll(options.getcFlags());
/* 52 */     cppFlags.addAll(options.getCppFlags());
/* 53 */     abiFilters.addAll(options.getAbiFilters());
/* 54 */     targets.addAll(options.getTargets());
/*    */   }
/*    */   
/*    */   public List<String> getArguments()
/*    */   {
/* 60 */     return arguments;
/*    */   }
/*    */   
/*    */   public List<String> getcFlags()
/*    */   {
/* 66 */     return cFlags;
/*    */   }
/*    */   
/*    */   public List<String> getCppFlags()
/*    */   {
/* 72 */     return cppFlags;
/*    */   }
/*    */   
/*    */   public Set<String> getAbiFilters()
/*    */   {
/* 78 */     return abiFilters;
/*    */   }
/*    */   
/*    */   public Set<String> getTargets()
/*    */   {
/* 84 */     return targets;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.core.MergedExternalNativeCmakeOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */