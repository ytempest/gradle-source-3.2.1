/*    */ package com.android.build.gradle.internal.tasks.featuresplit;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import java.io.File;
/*    */ import org.gradle.api.Project;
/*    */ 
/*    */ public class FeatureSplitDeclarationWriterTask$ConfigAction
/*    */   implements TaskConfigAction<FeatureSplitDeclarationWriterTask>
/*    */ {
/*    */   private final VariantScope variantScope;
/*    */   private final File outputDirectory;
/*    */   
/*    */   public FeatureSplitDeclarationWriterTask$ConfigAction(VariantScope variantScope, File outputDirectory)
/*    */   {
/* 51 */     this.variantScope = variantScope;
/* 52 */     this.outputDirectory = outputDirectory;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 58 */     return variantScope.getTaskName("feature", "Writer");
/*    */   }
/*    */   
/*    */   public Class<FeatureSplitDeclarationWriterTask> getType()
/*    */   {
/* 64 */     return FeatureSplitDeclarationWriterTask.class;
/*    */   }
/*    */   
/*    */   public void execute(FeatureSplitDeclarationWriterTask task)
/*    */   {
/* 69 */     task.setVariantName(variantScope.getFullVariantName());
/* 70 */     uniqueIdentifier = variantScope.getGlobalScope().getProject().getPath();
/* 71 */     outputDirectory = outputDirectory;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.featuresplit.FeatureSplitDeclarationWriterTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */