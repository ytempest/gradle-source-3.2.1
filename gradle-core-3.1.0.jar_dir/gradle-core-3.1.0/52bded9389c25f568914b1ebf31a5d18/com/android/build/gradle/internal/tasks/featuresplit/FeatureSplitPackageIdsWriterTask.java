/*    */ package com.android.build.gradle.internal.tasks.featuresplit;
/*    */ 
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.IOException;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.gradle.api.file.FileTree;
/*    */ import org.gradle.api.tasks.InputFiles;
/*    */ import org.gradle.api.tasks.OutputDirectory;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ import org.gradle.tooling.BuildException;
/*    */ 
/*    */ public class FeatureSplitPackageIdsWriterTask
/*    */   extends AndroidVariantTask
/*    */ {
/*    */   FileCollection input;
/*    */   File outputDirectory;
/*    */   
/*    */   @InputFiles
/*    */   FileCollection getInput()
/*    */   {
/* 41 */     return input;
/*    */   }
/*    */   
/*    */   @OutputDirectory
/*    */   File getOutputDirectory() {
/* 46 */     return outputDirectory;
/*    */   }
/*    */   
/*    */   @TaskAction
/*    */   public void fullTaskAction() throws IOException {
/* 51 */     FeatureSplitPackageIds featureSplitPackageIds = new FeatureSplitPackageIds();
/* 52 */     for (File featureSplitDeclaration : input.getAsFileTree().getFiles()) {
/*    */       try
/*    */       {
/* 55 */         FeatureSplitDeclaration loaded = FeatureSplitDeclaration.load(featureSplitDeclaration);
/* 56 */         featureSplitPackageIds.addFeatureSplit(loaded.getUniqueIdentifier());
/*    */       } catch (FileNotFoundException e) {
/* 58 */         throw new BuildException("Cannot read features split declaration file", e);
/*    */       }
/*    */     }
/*    */     
/* 63 */     featureSplitPackageIds.save(outputDirectory);
/*    */   }
/*    */   
/*    */   public static class ConfigAction implements TaskConfigAction<FeatureSplitPackageIdsWriterTask>
/*    */   {
/*    */     private final VariantScope variantScope;
/*    */     private final File outputDirectory;
/*    */     
/*    */     public ConfigAction(VariantScope variantScope, File outputDirectory) {
/* 72 */       this.variantScope = variantScope;
/* 73 */       this.outputDirectory = outputDirectory;
/*    */     }
/*    */     
/*    */     public String getName()
/*    */     {
/* 79 */       return variantScope.getTaskName("generate", "FeaturePackageIds");
/*    */     }
/*    */     
/*    */     public Class<FeatureSplitPackageIdsWriterTask> getType()
/*    */     {
/* 85 */       return FeatureSplitPackageIdsWriterTask.class;
/*    */     }
/*    */     
/*    */     public void execute(FeatureSplitPackageIdsWriterTask task)
/*    */     {
/* 90 */       task.setVariantName(variantScope.getFullVariantName());
/* 91 */       outputDirectory = outputDirectory;
/*    */       
/* 93 */       input = variantScope.getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.METADATA_VALUES, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.METADATA_FEATURE_DECLARATION);
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.featuresplit.FeatureSplitPackageIdsWriterTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */