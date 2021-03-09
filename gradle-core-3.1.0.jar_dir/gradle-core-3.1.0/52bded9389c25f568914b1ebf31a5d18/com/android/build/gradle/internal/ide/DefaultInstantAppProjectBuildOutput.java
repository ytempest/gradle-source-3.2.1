/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.InstantAppProjectBuildOutput;
/*    */ import com.android.builder.model.InstantAppVariantBuildOutput;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.io.Serializable;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class DefaultInstantAppProjectBuildOutput
/*    */   implements InstantAppProjectBuildOutput, Serializable
/*    */ {
/*    */   private final Collection<InstantAppVariantBuildOutput> variantBuildOutputs;
/*    */   
/*    */   DefaultInstantAppProjectBuildOutput(ImmutableList<InstantAppVariantBuildOutput> variantBuildOutputs)
/*    */   {
/* 34 */     this.variantBuildOutputs = variantBuildOutputs;
/*    */   }
/*    */   
/*    */   public Collection<InstantAppVariantBuildOutput> getInstantAppVariantsBuildOutput()
/*    */   {
/* 40 */     return variantBuildOutputs;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DefaultInstantAppProjectBuildOutput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */