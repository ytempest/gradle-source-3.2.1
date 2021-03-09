/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.TransformVariantScope;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import org.gradle.api.DefaultTask;
/*    */ 
/*    */ public class InstantRunAnchorTaskConfigAction
/*    */   implements TaskConfigAction<DefaultTask>
/*    */ {
/*    */   private final TransformVariantScope variantScope;
/*    */   
/*    */   public InstantRunAnchorTaskConfigAction(VariantScope scope)
/*    */   {
/* 37 */     variantScope = scope;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 43 */     return variantScope.getTaskName("incremental", "Tasks");
/*    */   }
/*    */   
/*    */   public Class<DefaultTask> getType()
/*    */   {
/* 49 */     return DefaultTask.class;
/*    */   }
/*    */   
/*    */   public void execute(DefaultTask task)
/*    */   {
/* 54 */     task.setDescription("InstantRun task to build incremental artifacts");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunAnchorTaskConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */