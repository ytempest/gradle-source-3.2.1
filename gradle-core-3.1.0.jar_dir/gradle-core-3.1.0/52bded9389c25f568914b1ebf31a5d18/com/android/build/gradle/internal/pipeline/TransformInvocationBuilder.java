/*    */ package com.android.build.gradle.internal.pipeline;
/*    */ 
/*    */ import com.android.build.api.transform.Context;
/*    */ import com.android.build.api.transform.SecondaryInput;
/*    */ import com.android.build.api.transform.TransformInput;
/*    */ import com.android.build.api.transform.TransformInvocation;
/*    */ import com.android.build.api.transform.TransformOutputProvider;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class TransformInvocationBuilder
/*    */ {
/*    */   Context context;
/* 36 */   Collection<TransformInput> inputs = ImmutableList.of();
/* 37 */   Collection<TransformInput> referencedInputs = ImmutableList.of();
/* 38 */   Collection<SecondaryInput> secondaryInputs = ImmutableList.of();
/*    */   TransformOutputProvider transformOutputProvider;
/* 40 */   boolean isIncremental = false;
/*    */   
/*    */   public TransformInvocationBuilder(Context context) {
/* 43 */     this.context = context;
/*    */   }
/*    */   
/*    */   public TransformInvocationBuilder addInputs(Collection<TransformInput> inputs) {
/* 47 */     this.inputs = ImmutableList.copyOf(inputs);
/* 48 */     return this;
/*    */   }
/*    */   
/*    */   public TransformInvocationBuilder addReferencedInputs(Collection<TransformInput> referencedInputs) {
/* 52 */     this.referencedInputs = ImmutableList.copyOf(referencedInputs);
/* 53 */     return this;
/*    */   }
/*    */   
/*    */   public TransformInvocationBuilder addSecondaryInputs(Collection<SecondaryInput> secondaryInputs) {
/* 57 */     this.secondaryInputs = ImmutableList.copyOf(secondaryInputs);
/* 58 */     return this;
/*    */   }
/*    */   
/*    */   public TransformInvocationBuilder addOutputProvider(TransformOutputProvider transformOutputProvider)
/*    */   {
/* 63 */     this.transformOutputProvider = transformOutputProvider;
/* 64 */     return this;
/*    */   }
/*    */   
/*    */   public TransformInvocationBuilder setIncrementalMode(boolean isIncremental) {
/* 68 */     this.isIncremental = isIncremental;
/* 69 */     return this;
/*    */   }
/*    */   
/*    */   public TransformInvocation build() {
/* 73 */     new TransformInvocation()
/*    */     {
/*    */       public Context getContext()
/*    */       {
/* 77 */         return context;
/*    */       }
/*    */       
/*    */       public Collection<TransformInput> getInputs()
/*    */       {
/* 83 */         return inputs;
/*    */       }
/*    */       
/*    */       public Collection<TransformInput> getReferencedInputs()
/*    */       {
/* 89 */         return referencedInputs;
/*    */       }
/*    */       
/*    */       public Collection<SecondaryInput> getSecondaryInputs()
/*    */       {
/* 95 */         return secondaryInputs;
/*    */       }
/*    */       
/*    */       public TransformOutputProvider getOutputProvider()
/*    */       {
/* :1 */         return transformOutputProvider;
/*    */       }
/*    */       
/*    */       public boolean isIncremental()
/*    */       {
/* :6 */         return isIncremental;
/*    */       }
/*    */     };
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.TransformInvocationBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */