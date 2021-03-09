/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ 
/*     */ class TaskManager$1
/*     */   implements TaskConfigAction<TaskManager.ConfigAttrTask>
/*     */ {
/*     */   TaskManager$1(TaskManager this$0) {}
/*     */   
/*     */   public String getName()
/*     */   {
/* 440 */     return "resolveConfigAttr";
/*     */   }
/*     */   
/*     */   public Class<TaskManager.ConfigAttrTask> getType()
/*     */   {
/* 446 */     return TaskManager.ConfigAttrTask.class;
/*     */   }
/*     */   
/*     */   public void execute(TaskManager.ConfigAttrTask task)
/*     */   {
/* 451 */     resolvable = true;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.TaskManager.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */