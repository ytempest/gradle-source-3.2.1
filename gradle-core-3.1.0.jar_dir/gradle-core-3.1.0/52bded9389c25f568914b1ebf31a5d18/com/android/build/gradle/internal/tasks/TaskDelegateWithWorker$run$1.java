/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.workers.IsolationMode;
/*    */ import org.gradle.workers.WorkerConfiguration;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "it", "Lorg/gradle/workers/WorkerConfiguration;", "kotlin.jvm.PlatformType", "execute"})
/*    */ final class TaskDelegateWithWorker$run$1<T>
/*    */   implements Action<WorkerConfiguration>
/*    */ {
/*    */   public final void execute(WorkerConfiguration it)
/*    */   {
/* 50 */     it.params(new Object[] { this$0.getWorkerParam() }); WorkerConfiguration 
/* 51 */       tmp21_20 = it;Intrinsics.checkExpressionValueIsNotNull(tmp21_20, "it");tmp21_20.setIsolationMode(IsolationMode.NONE);
/*    */   }
/*    */   
/*    */   TaskDelegateWithWorker$run$1(TaskDelegateWithWorker paramTaskDelegateWithWorker) {}
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.TaskDelegateWithWorker.run.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */