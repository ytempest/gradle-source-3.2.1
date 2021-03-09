/*      */ package com.android.build.gradle.internal;
/*      */ 
/*      */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*      */ import com.android.build.gradle.internal.scope.VariantScope;
/*      */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*      */ import org.gradle.api.Task;
/*      */ 
/*      */ class TaskManager$3
/*      */   implements TaskConfigAction<Task>
/*      */ {
/*      */   TaskManager$3(TaskManager this$0, VariantScope paramVariantScope, BaseVariantData paramBaseVariantData) {}
/*      */   
/*      */   public String getName()
/*      */   {
/* 3541 */     return val$scope.getTaskName("compile", "Sources");
/*      */   }
/*      */   
/*      */   public Class<Task> getType()
/*      */   {
/* 3547 */     return Task.class;
/*      */   }
/*      */   
/*      */   public void execute(Task task)
/*      */   {
/* 3552 */     val$variantData.compileTask = task;
/* 3553 */     val$variantData.compileTask.setGroup("build");
/*      */   }
/*      */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.TaskManager.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */