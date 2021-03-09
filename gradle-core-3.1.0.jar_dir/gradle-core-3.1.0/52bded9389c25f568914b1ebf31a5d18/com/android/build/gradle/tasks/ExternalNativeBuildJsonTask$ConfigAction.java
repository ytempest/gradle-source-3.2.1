/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ 
/*    */ class ExternalNativeBuildJsonTask$ConfigAction
/*    */   implements TaskConfigAction<ExternalNativeBuildJsonTask>
/*    */ {
/*    */   private final VariantScope scope;
/*    */   private final ExternalNativeJsonGenerator generator;
/*    */   
/*    */   private ExternalNativeBuildJsonTask$ConfigAction(VariantScope scope, ExternalNativeJsonGenerator generator)
/*    */   {
/* 57 */     this.scope = scope;
/* 58 */     this.generator = generator;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 64 */     return scope.getTaskName("generateJsonModel");
/*    */   }
/*    */   
/*    */   public Class<ExternalNativeBuildJsonTask> getType()
/*    */   {
/* 70 */     return ExternalNativeBuildJsonTask.class;
/*    */   }
/*    */   
/*    */   public void execute(ExternalNativeBuildJsonTask task)
/*    */   {
/* 75 */     task.setVariantName(scope.getVariantConfiguration().getFullName());
/* 76 */     ExternalNativeBuildJsonTask.access$102(task, generator);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ExternalNativeBuildJsonTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */