/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.TestOptions;
/*    */ import com.android.builder.model.TestOptions.Execution;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ final class TestOptionsImpl
/*    */   implements TestOptions, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final boolean animationsDisabled;
/*    */   private final TestOptions.Execution execution;
/*    */   
/*    */   public TestOptionsImpl(boolean animationsDisabled, TestOptions.Execution execution)
/*    */   {
/* 33 */     this.animationsDisabled = animationsDisabled;
/* 34 */     this.execution = execution;
/*    */   }
/*    */   
/*    */   public boolean getAnimationsDisabled()
/*    */   {
/* 39 */     return animationsDisabled;
/*    */   }
/*    */   
/*    */   public TestOptions.Execution getExecution()
/*    */   {
/* 45 */     return execution;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.TestOptionsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */