/*    */ package com.android.build.gradle.internal.scope;
/*    */ 
/*    */ public class TaskOutputAlreadyRegisteredException
/*    */   extends RuntimeException
/*    */ {
/*    */   private final TaskOutputHolder.OutputType outputType;
/*    */   
/*    */   public TaskOutputAlreadyRegisteredException(TaskOutputHolder.OutputType outputType)
/*    */   {
/* 26 */     super("Output already registered for type: " + outputType);
/* 27 */     this.outputType = outputType;
/*    */   }
/*    */   
/*    */   public TaskOutputHolder.OutputType getOutputType()
/*    */   {
/* 32 */     return outputType;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.TaskOutputAlreadyRegisteredException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */