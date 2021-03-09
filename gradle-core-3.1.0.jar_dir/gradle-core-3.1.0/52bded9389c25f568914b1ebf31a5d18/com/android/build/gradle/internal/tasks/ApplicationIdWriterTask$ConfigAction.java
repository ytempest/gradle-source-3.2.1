/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import java.io.File;
/*    */ 
/*    */ public class ApplicationIdWriterTask$ConfigAction
/*    */   implements TaskConfigAction<ApplicationIdWriterTask>
/*    */ {
/*    */   protected final VariantScope variantScope;
/*    */   protected final File outputDirectory;
/*    */   
/*    */   public ApplicationIdWriterTask$ConfigAction(VariantScope variantScope, File outputDirectory)
/*    */   {
/* 78 */     this.variantScope = variantScope;
/* 79 */     this.outputDirectory = outputDirectory;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 85 */     return variantScope.getTaskName("write", "ApplicationId");
/*    */   }
/*    */   
/*    */   public Class<ApplicationIdWriterTask> getType()
/*    */   {
/* 91 */     return ApplicationIdWriterTask.class;
/*    */   }
/*    */   
/*    */   public void execute(ApplicationIdWriterTask task)
/*    */   {
/* 96 */     task.setVariantName(variantScope.getFullVariantName());
/* 97 */     ApplicationIdWriterTask.access$002(task, variantScope.getVariantConfiguration().getApplicationId());
/* 98 */     ApplicationIdWriterTask.access$102(task, outputDirectory);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.ApplicationIdWriterTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */