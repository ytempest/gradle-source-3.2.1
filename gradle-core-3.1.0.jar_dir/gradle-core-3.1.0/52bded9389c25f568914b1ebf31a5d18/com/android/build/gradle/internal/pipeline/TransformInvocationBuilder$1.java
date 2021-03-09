/*     */ package com.android.build.gradle.internal.pipeline;
/*     */ 
/*     */ import com.android.build.api.transform.Context;
/*     */ import com.android.build.api.transform.SecondaryInput;
/*     */ import com.android.build.api.transform.TransformInput;
/*     */ import com.android.build.api.transform.TransformInvocation;
/*     */ import com.android.build.api.transform.TransformOutputProvider;
/*     */ import java.util.Collection;
/*     */ 
/*     */ class TransformInvocationBuilder$1
/*     */   implements TransformInvocation
/*     */ {
/*     */   TransformInvocationBuilder$1(TransformInvocationBuilder this$0) {}
/*     */   
/*     */   public Context getContext()
/*     */   {
/*  77 */     return this$0.context;
/*     */   }
/*     */   
/*     */   public Collection<TransformInput> getInputs()
/*     */   {
/*  83 */     return this$0.inputs;
/*     */   }
/*     */   
/*     */   public Collection<TransformInput> getReferencedInputs()
/*     */   {
/*  89 */     return this$0.referencedInputs;
/*     */   }
/*     */   
/*     */   public Collection<SecondaryInput> getSecondaryInputs()
/*     */   {
/*  95 */     return this$0.secondaryInputs;
/*     */   }
/*     */   
/*     */   public TransformOutputProvider getOutputProvider()
/*     */   {
/* 101 */     return this$0.transformOutputProvider;
/*     */   }
/*     */   
/*     */   public boolean isIncremental()
/*     */   {
/* 106 */     return this$0.isIncremental;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.TransformInvocationBuilder.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */