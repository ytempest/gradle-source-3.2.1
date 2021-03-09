/*    */ package com.android.build.gradle.internal.tasks.featuresplit;
/*    */ 
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import java.io.File;
/*    */ 
/*    */ public class FeatureSplitPackageIdsWriterTask$ConfigAction
/*    */   implements TaskConfigAction<FeatureSplitPackageIdsWriterTask>
/*    */ {
/*    */   private final VariantScope variantScope;
/*    */   private final File outputDirectory;
/*    */   
/*    */   public FeatureSplitPackageIdsWriterTask$ConfigAction(VariantScope variantScope, File outputDirectory)
/*    */   {
/* 72 */     this.variantScope = variantScope;
/* 73 */     this.outputDirectory = outputDirectory;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 79 */     return variantScope.getTaskName("generate", "FeaturePackageIds");
/*    */   }
/*    */   
/*    */   public Class<FeatureSplitPackageIdsWriterTask> getType()
/*    */   {
/* 85 */     return FeatureSplitPackageIdsWriterTask.class;
/*    */   }
/*    */   
/*    */   public void execute(FeatureSplitPackageIdsWriterTask task)
/*    */   {
/* 90 */     task.setVariantName(variantScope.getFullVariantName());
/* 91 */     outputDirectory = outputDirectory;
/*    */     
/* 93 */     input = variantScope.getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.METADATA_VALUES, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.METADATA_FEATURE_DECLARATION);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.featuresplit.FeatureSplitPackageIdsWriterTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */