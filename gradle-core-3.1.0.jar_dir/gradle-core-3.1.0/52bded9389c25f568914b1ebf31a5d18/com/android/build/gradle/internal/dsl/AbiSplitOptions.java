/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import com.android.build.OutputFile;
/*    */ import com.android.build.gradle.internal.core.Abi;
/*    */ import com.android.build.gradle.internal.ndk.NdkHandler;
/*    */ import com.google.common.collect.ImmutableSet;
/*    */ import com.google.common.collect.ImmutableSet.Builder;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class AbiSplitOptions
/*    */   extends SplitOptions
/*    */ {
/* 36 */   private boolean universalApk = false;
/*    */   
/*    */   protected Set<String> getDefaultValues()
/*    */   {
/* 40 */     Set<String> values = Sets.newHashSet();
/* 41 */     for (Abi abi : NdkHandler.getDefaultAbiList()) {
/* 42 */       values.add(abi.getName());
/*    */     }
/* 44 */     return values;
/*    */   }
/*    */   
/*    */   protected ImmutableSet<String> getAllowedValues()
/*    */   {
/* 49 */     ImmutableSet.Builder<String> builder = ImmutableSet.builder();
/* 50 */     for (Abi abi : NdkHandler.getAbiList()) {
/* 51 */       builder.add(abi.getName());
/*    */     }
/* 53 */     return builder.build();
/*    */   }
/*    */   
/*    */   public boolean isUniversalApk()
/*    */   {
/* 58 */     return universalApk;
/*    */   }
/*    */   
/*    */   public void setUniversalApk(boolean universalApk) {
/* 62 */     this.universalApk = universalApk;
/*    */   }
/*    */   
/*    */   public static ImmutableSet<String> getAbiFilters(Set<String> allFilters)
/*    */   {
/* 72 */     ImmutableSet.Builder<String> filters = ImmutableSet.builder();
/* 73 */     for (String abi : allFilters)
/*    */     {
/* 76 */       if (abi != OutputFile.NO_FILTER) {
/* 77 */         filters.add(abi);
/*    */       }
/*    */     }
/* 80 */     return filters.build();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.AbiSplitOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */