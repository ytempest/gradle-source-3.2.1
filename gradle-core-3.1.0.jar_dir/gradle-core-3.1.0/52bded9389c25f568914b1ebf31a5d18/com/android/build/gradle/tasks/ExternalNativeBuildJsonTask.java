/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*    */ import com.android.ide.common.process.ProcessException;
/*    */ import java.io.IOException;
/*    */ import org.gradle.api.tasks.Nested;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ 
/*    */ public class ExternalNativeBuildJsonTask
/*    */   extends AndroidVariantTask
/*    */ {
/*    */   private ExternalNativeJsonGenerator generator;
/*    */   
/*    */   @TaskAction
/*    */   public void build()
/*    */     throws ProcessException, IOException
/*    */   {
/* 35 */     generator.build();
/*    */   }
/*    */   
/*    */   @Nested
/*    */   public ExternalNativeJsonGenerator getExternalNativeJsonGenerator() {
/* 40 */     return generator;
/*    */   }
/*    */   
/*    */   public static TaskConfigAction<ExternalNativeBuildJsonTask> createTaskConfigAction(ExternalNativeJsonGenerator generator, VariantScope scope)
/*    */   {
/* 48 */     return new ConfigAction(scope, generator, null);
/*    */   }
/*    */   
/*    */   private static class ConfigAction implements TaskConfigAction<ExternalNativeBuildJsonTask>
/*    */   {
/*    */     private final VariantScope scope;
/*    */     private final ExternalNativeJsonGenerator generator;
/*    */     
/*    */     private ConfigAction(VariantScope scope, ExternalNativeJsonGenerator generator) {
/* 57 */       this.scope = scope;
/* 58 */       this.generator = generator;
/*    */     }
/*    */     
/*    */     public String getName()
/*    */     {
/* 64 */       return scope.getTaskName("generateJsonModel");
/*    */     }
/*    */     
/*    */     public Class<ExternalNativeBuildJsonTask> getType()
/*    */     {
/* 70 */       return ExternalNativeBuildJsonTask.class;
/*    */     }
/*    */     
/*    */     public void execute(ExternalNativeBuildJsonTask task)
/*    */     {
/* 75 */       task.setVariantName(scope.getVariantConfiguration().getFullName());
/* 76 */       generator = generator;
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ExternalNativeBuildJsonTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */