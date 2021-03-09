/*    */ package com.android.build.gradle.internal.core;
/*    */ 
/*    */ import com.android.build.gradle.internal.dsl.CoreExternalNativeNdkBuildOptions;
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class MergedExternalNativeNdkBuildOptions
/*    */   implements CoreExternalNativeNdkBuildOptions
/*    */ {
/*    */   private final List<String> arguments;
/*    */   private final List<String> cFlags;
/*    */   private final List<String> cppFlags;
/*    */   private final Set<String> abiFilters;
/*    */   
/*    */   public MergedExternalNativeNdkBuildOptions()
/*    */   {
/* 32 */     arguments = Lists.newArrayList();
/*    */     
/* 34 */     cFlags = Lists.newArrayList();
/*    */     
/* 36 */     cppFlags = Lists.newArrayList();
/*    */     
/* 38 */     abiFilters = Sets.newHashSet(); }
/*    */   
/* 40 */   private final Set<String> targets = Sets.newHashSet();
/*    */   
/*    */   public void reset() {
/* 43 */     arguments.clear();
/* 44 */     cFlags.clear();
/* 45 */     cppFlags.clear();
/* 46 */     abiFilters.clear();
/* 47 */     targets.clear();
/*    */   }
/*    */   
/*    */   public void append(CoreExternalNativeNdkBuildOptions options) {
/* 51 */     arguments.addAll(options.getArguments());
/* 52 */     cFlags.addAll(options.getcFlags());
/* 53 */     cppFlags.addAll(options.getCppFlags());
/* 54 */     abiFilters.addAll(options.getAbiFilters());
/* 55 */     targets.addAll(options.getTargets());
/*    */   }
/*    */   
/*    */   public List<String> getArguments()
/*    */   {
/* 61 */     return arguments;
/*    */   }
/*    */   
/*    */   public List<String> getcFlags()
/*    */   {
/* 67 */     return cFlags;
/*    */   }
/*    */   
/*    */   public List<String> getCppFlags()
/*    */   {
/* 73 */     return cppFlags;
/*    */   }
/*    */   
/*    */   public Set<String> getAbiFilters()
/*    */   {
/* 79 */     return abiFilters;
/*    */   }
/*    */   
/*    */   public Set<String> getTargets()
/*    */   {
/* 85 */     return targets;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.core.MergedExternalNativeNdkBuildOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */