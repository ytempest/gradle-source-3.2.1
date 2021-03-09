/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ 
/*     */ class TaskManager$2
/*     */   implements TaskConfigAction<TaskManager.ConfigAttrTask>
/*     */ {
/*     */   TaskManager$2(TaskManager this$0) {}
/*     */   
/*     */   public String getName()
/*     */   {
/* 460 */     return "consumeConfigAttr";
/*     */   }
/*     */   
/*     */   public Class<TaskManager.ConfigAttrTask> getType()
/*     */   {
/* 466 */     return TaskManager.ConfigAttrTask.class;
/*     */   }
/*     */   
/*     */   public void execute(TaskManager.ConfigAttrTask task)
/*     */   {
/* 471 */     consumable = true;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.TaskManager.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */