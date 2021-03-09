/*    */ package com.android.build.gradle.internal.tasks.featuresplit;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.tasks.Input;
/*    */ import org.gradle.api.tasks.OutputDirectory;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ 
/*    */ public class FeatureSplitDeclarationWriterTask
/*    */   extends AndroidVariantTask
/*    */ {
/*    */   @Input
/*    */   String uniqueIdentifier;
/*    */   @OutputDirectory
/*    */   File outputDirectory;
/*    */   
/*    */   @TaskAction
/*    */   public void fullTaskAction()
/*    */     throws IOException
/*    */   {
/* 40 */     FeatureSplitDeclaration declaration = new FeatureSplitDeclaration(uniqueIdentifier);
/* 41 */     declaration.save(outputDirectory);
/*    */   }
/*    */   
/*    */   public static class ConfigAction implements TaskConfigAction<FeatureSplitDeclarationWriterTask>
/*    */   {
/*    */     private final VariantScope variantScope;
/*    */     private final File outputDirectory;
/*    */     
/*    */     public ConfigAction(VariantScope variantScope, File outputDirectory)
/*    */     {
/* 51 */       this.variantScope = variantScope;
/* 52 */       this.outputDirectory = outputDirectory;
/*    */     }
/*    */     
/*    */     public String getName()
/*    */     {
/* 58 */       return variantScope.getTaskName("feature", "Writer");
/*    */     }
/*    */     
/*    */     public Class<FeatureSplitDeclarationWriterTask> getType()
/*    */     {
/* 64 */       return FeatureSplitDeclarationWriterTask.class;
/*    */     }
/*    */     
/*    */     public void execute(FeatureSplitDeclarationWriterTask task)
/*    */     {
/* 69 */       task.setVariantName(variantScope.getFullVariantName());
/* 70 */       uniqueIdentifier = variantScope.getGlobalScope().getProject().getPath();
/* 71 */       outputDirectory = outputDirectory;
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.featuresplit.FeatureSplitDeclarationWriterTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */