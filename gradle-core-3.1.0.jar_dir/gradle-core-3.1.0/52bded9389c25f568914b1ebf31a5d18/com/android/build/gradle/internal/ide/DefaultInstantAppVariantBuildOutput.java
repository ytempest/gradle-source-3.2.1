/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.build.OutputFile;
/*    */ import com.android.build.gradle.internal.scope.BuildOutput;
/*    */ import com.android.builder.model.InstantAppVariantBuildOutput;
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class DefaultInstantAppVariantBuildOutput
/*    */   implements InstantAppVariantBuildOutput, Serializable
/*    */ {
/*    */   private final String name;
/*    */   private final String applicationId;
/*    */   private final BuildOutput buildOutput;
/*    */   private final Collection<EarlySyncBuildOutput> featureOutputs;
/*    */   
/*    */   public DefaultInstantAppVariantBuildOutput(String name, String applicationId, BuildOutput buildOutputSupplier, Collection<EarlySyncBuildOutput> featureOutputsSupplier)
/*    */   {
/* 41 */     this.name = name;
/* 42 */     this.applicationId = applicationId;
/* 43 */     buildOutput = buildOutputSupplier;
/* 44 */     featureOutputs = featureOutputsSupplier;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 50 */     return name;
/*    */   }
/*    */   
/*    */   public String getApplicationId()
/*    */   {
/* 56 */     return applicationId;
/*    */   }
/*    */   
/*    */   public OutputFile getOutput()
/*    */   {
/* 62 */     return buildOutput;
/*    */   }
/*    */   
/*    */   public Collection<OutputFile> getFeatureOutputs()
/*    */   {
/* 68 */     return new ArrayList(featureOutputs);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DefaultInstantAppVariantBuildOutput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */