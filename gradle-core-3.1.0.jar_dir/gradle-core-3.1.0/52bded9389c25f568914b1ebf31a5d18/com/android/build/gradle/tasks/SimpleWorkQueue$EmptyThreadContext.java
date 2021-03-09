/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.builder.tasks.Job;
/*    */ import com.android.builder.tasks.JobContext;
/*    */ import com.android.builder.tasks.QueueThreadContextAdapter;
/*    */ 
/*    */ class SimpleWorkQueue$EmptyThreadContext
/*    */   extends QueueThreadContextAdapter<Void>
/*    */ {
/*    */   public void runTask(Job<Void> job)
/*    */     throws Exception
/*    */   {
/* 41 */     job.runTask(new JobContext(null));
/* 42 */     job.finished();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.SimpleWorkQueue.EmptyThreadContext
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */