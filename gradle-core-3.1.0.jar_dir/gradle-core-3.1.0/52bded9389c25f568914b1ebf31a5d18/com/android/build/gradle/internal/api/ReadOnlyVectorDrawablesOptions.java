/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.builder.model.VectorDrawablesOptions;
/*    */ import com.google.common.collect.ImmutableSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class ReadOnlyVectorDrawablesOptions
/*    */   implements VectorDrawablesOptions
/*    */ {
/*    */   private final VectorDrawablesOptions mOptions;
/*    */   
/*    */   public ReadOnlyVectorDrawablesOptions(VectorDrawablesOptions options)
/*    */   {
/* 32 */     mOptions = options;
/*    */   }
/*    */   
/*    */   public Set<String> getGeneratedDensities()
/*    */   {
/* 38 */     if (mOptions.getGeneratedDensities() == null) {
/* 39 */       return null;
/*    */     }
/* 41 */     return ImmutableSet.copyOf(mOptions.getGeneratedDensities());
/*    */   }
/*    */   
/*    */   public Boolean getUseSupportLibrary()
/*    */   {
/* 48 */     return mOptions.getUseSupportLibrary();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ReadOnlyVectorDrawablesOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */