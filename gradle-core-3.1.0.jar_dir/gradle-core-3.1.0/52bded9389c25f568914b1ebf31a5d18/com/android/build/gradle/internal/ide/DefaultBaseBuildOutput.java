/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.build.OutputFile;
/*    */ import com.android.builder.model.BaseBuildOutput;
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public abstract class DefaultBaseBuildOutput
/*    */   implements BaseBuildOutput, Serializable
/*    */ {
/*    */   private final String name;
/*    */   private final Collection<EarlySyncBuildOutput> buildOutputs;
/*    */   
/*    */   public DefaultBaseBuildOutput(String name, Collection<EarlySyncBuildOutput> buildOutputSupplier)
/*    */   {
/* 34 */     this.name = name;
/* 35 */     buildOutputs = buildOutputSupplier;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 41 */     return name;
/*    */   }
/*    */   
/*    */   public Collection<OutputFile> getOutputs()
/*    */   {
/* 47 */     return new ArrayList(buildOutputs);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DefaultBaseBuildOutput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */