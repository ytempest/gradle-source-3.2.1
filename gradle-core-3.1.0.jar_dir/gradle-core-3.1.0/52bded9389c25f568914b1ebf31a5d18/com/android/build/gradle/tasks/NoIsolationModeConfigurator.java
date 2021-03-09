/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import org.gradle.workers.IsolationMode;
/*    */ import org.gradle.workers.WorkerConfiguration;
/*    */ 
/*    */ public class NoIsolationModeConfigurator<T>
/*    */ {
/*    */   private final T parameters;
/*    */   
/*    */   public NoIsolationModeConfigurator(T parameters)
/*    */   {
/* 33 */     this.parameters = parameters;
/*    */   }
/*    */   
/*    */   public void configure(WorkerConfiguration configuration)
/*    */   {
/* 43 */     configuration.setIsolationMode(IsolationMode.NONE);
/* 44 */     configuration.setParams(new Object[] { parameters });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.NoIsolationModeConfigurator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */