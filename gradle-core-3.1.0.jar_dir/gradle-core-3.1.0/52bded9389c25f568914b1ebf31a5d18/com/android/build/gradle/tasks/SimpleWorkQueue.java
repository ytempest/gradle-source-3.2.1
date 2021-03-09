/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.builder.tasks.Job;
/*    */ import com.android.builder.tasks.JobContext;
/*    */ import com.android.builder.tasks.QueueThreadContextAdapter;
/*    */ import com.android.builder.tasks.WorkQueue;
/*    */ import com.android.utils.StdLogger;
/*    */ import com.android.utils.StdLogger.Level;
/*    */ 
/*    */ public class SimpleWorkQueue
/*    */ {
/*    */   private static class EmptyThreadContext
/*    */     extends QueueThreadContextAdapter<Void>
/*    */   {
/*    */     public void runTask(Job<Void> job)
/*    */       throws Exception
/*    */     {
/* 41 */       job.runTask(new JobContext(null));
/* 42 */       job.finished();
/*    */     }
/*    */   }
/*    */   
/* 49 */   private static final WorkQueue<Void> WORK_QUEUE = new WorkQueue(new StdLogger(StdLogger.Level.VERBOSE), new EmptyThreadContext(null), "Tasks limiter", 4);
/*    */   
/*    */   public static void push(Job<Void> job)
/*    */     throws InterruptedException
/*    */   {
/* 56 */     WORK_QUEUE.push(job);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.SimpleWorkQueue
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */