/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.TransformInvocation;
/*     */ import com.android.builder.tasks.Job;
/*     */ import com.android.builder.tasks.JobContext;
/*     */ import com.android.builder.tasks.Task;
/*     */ import com.google.common.util.concurrent.SettableFuture;
/*     */ import java.io.IOException;
/*     */ 
/*     */ class ProGuardTransform$1
/*     */   implements Task<Void>
/*     */ {
/*     */   ProGuardTransform$1(ProGuardTransform this$0, TransformInvocation paramTransformInvocation, SettableFuture paramSettableFuture) {}
/*     */   
/*     */   public void run(Job<Void> job, JobContext<Void> context)
/*     */     throws IOException
/*     */   {
/* 173 */     ProGuardTransform.access$000(this$0, val$invocation
/* 174 */       .getInputs(), val$invocation
/* 175 */       .getReferencedInputs(), val$invocation
/* 176 */       .getOutputProvider());
/*     */   }
/*     */   
/*     */   public void finished()
/*     */   {
/* 181 */     val$resultFuture.set(val$invocation.getOutputProvider());
/*     */   }
/*     */   
/*     */   public void error(Throwable e)
/*     */   {
/* 186 */     val$resultFuture.setException(e);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.ProGuardTransform.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */