/*    */ package com.android.build.gradle.internal.scope;
/*    */ 
/*    */ public class MissingTaskOutputException
/*    */   extends RuntimeException
/*    */ {
/*    */   private final TaskOutputHolder.OutputType outputType;
/*    */   
/*    */   public MissingTaskOutputException(TaskOutputHolder.OutputType outputType)
/*    */   {
/* 26 */     super("No output of type: " + outputType);
/* 27 */     this.outputType = outputType;
/*    */   }
/*    */   
/*    */   public TaskOutputHolder.OutputType getOutputType()
/*    */   {
/* 32 */     return outputType;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.MissingTaskOutputException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */