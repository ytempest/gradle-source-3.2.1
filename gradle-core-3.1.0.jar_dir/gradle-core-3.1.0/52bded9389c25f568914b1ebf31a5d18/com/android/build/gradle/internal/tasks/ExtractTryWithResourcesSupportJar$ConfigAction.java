/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import org.gradle.api.file.ConfigurableFileCollection;
/*    */ 
/*    */ public class ExtractTryWithResourcesSupportJar$ConfigAction
/*    */   implements TaskConfigAction<ExtractTryWithResourcesSupportJar>
/*    */ {
/*    */   private final ConfigurableFileCollection outputLocation;
/*    */   private final String taskName;
/*    */   private final String variantName;
/*    */   
/*    */   public ExtractTryWithResourcesSupportJar$ConfigAction(ConfigurableFileCollection outputLocation, String taskName, String variantName)
/*    */   {
/* 68 */     this.outputLocation = outputLocation;
/* 69 */     this.taskName = taskName;
/* 70 */     this.variantName = variantName;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 76 */     return taskName;
/*    */   }
/*    */   
/*    */   public Class<ExtractTryWithResourcesSupportJar> getType()
/*    */   {
/* 82 */     return ExtractTryWithResourcesSupportJar.class;
/*    */   }
/*    */   
/*    */   public void execute(ExtractTryWithResourcesSupportJar task)
/*    */   {
/* 87 */     ExtractTryWithResourcesSupportJar.access$002(task, outputLocation);
/* 88 */     task.setVariantName(variantName);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.ExtractTryWithResourcesSupportJar.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */