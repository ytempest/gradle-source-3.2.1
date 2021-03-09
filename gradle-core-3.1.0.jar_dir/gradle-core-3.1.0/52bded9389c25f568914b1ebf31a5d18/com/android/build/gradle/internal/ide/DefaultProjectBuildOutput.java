/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.ProjectBuildOutput;
/*    */ import com.android.builder.model.VariantBuildOutput;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.io.Serializable;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class DefaultProjectBuildOutput
/*    */   implements ProjectBuildOutput, Serializable
/*    */ {
/*    */   private final Collection<VariantBuildOutput> variantBuildOutputs;
/*    */   
/*    */   DefaultProjectBuildOutput(ImmutableList<VariantBuildOutput> variantBuildOutputs)
/*    */   {
/* 32 */     this.variantBuildOutputs = variantBuildOutputs;
/*    */   }
/*    */   
/*    */   public Collection<VariantBuildOutput> getVariantsBuildOutput()
/*    */   {
/* 38 */     return variantBuildOutputs;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DefaultProjectBuildOutput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */