/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import org.gradle.api.Task;
/*    */ 
/*    */ public abstract interface TaskContainer
/*    */ {
/*    */   public abstract void addTask(TaskKind paramTaskKind, Task paramTask);
/*    */   
/*    */   public abstract Task getTaskByKind(TaskKind paramTaskKind);
/*    */   
/*    */   public abstract <T extends Task> T getTaskByType(Class<T> paramClass);
/*    */   
/*    */   public static enum TaskKind
/*    */   {
/* 27 */     PROCESS_ANDROID_RESOURCES, 
/*    */     
/* 29 */     PROCESS_MANIFEST, 
/*    */     
/* 31 */     PACKAGE_ANDROID_ARTIFACT, 
/*    */     
/* 33 */     ASSEMBLE;
/*    */     
/*    */     private TaskKind() {}
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.TaskContainer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */