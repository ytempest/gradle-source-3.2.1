/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import org.gradle.api.Task;
/*     */ import org.gradle.api.execution.TaskExecutionAdapter;
/*     */ import org.gradle.api.tasks.TaskState;
/*     */ 
/*     */ class InstantRunTaskManager$1
/*     */   extends TaskExecutionAdapter
/*     */ {
/*     */   InstantRunTaskManager$1(InstantRunTaskManager this$0) {}
/*     */   
/*     */   public void afterExecute(Task task, TaskState state)
/*     */   {
/* 328 */     if (state.getFailure() != null) {
/* 329 */       InstantRunTaskManager.access$000(this$0).getInstantRunBuildContext().setBuildHasFailed();
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.InstantRunTaskManager.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */