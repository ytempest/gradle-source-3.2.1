/*     */ package com.android.build.gradle.internal.pipeline;
/*     */ 
/*     */ import com.android.build.api.transform.Transform;
/*     */ import com.android.builder.profile.Recorder.Block;
/*     */ import com.android.ide.common.util.ReferenceHolder;
/*     */ import java.util.Collection;
/*     */ 
/*     */ class TransformTask$2
/*     */   implements Recorder.Block<Void>
/*     */ {
/*     */   TransformTask$2(TransformTask this$0, ReferenceHolder paramReferenceHolder1, ReferenceHolder paramReferenceHolder2, ReferenceHolder paramReferenceHolder3, ReferenceHolder paramReferenceHolder4) {}
/*     */   
/*     */   public Void call()
/*     */     throws Exception
/*     */   {
/* 221 */     TransformTask.access$700(this$0).transform(new TransformInvocationBuilder(this$0)
/*     */     
/* 223 */       .addInputs((Collection)val$consumedInputs.getValue())
/* 224 */       .addReferencedInputs((Collection)val$referencedInputs.getValue())
/* 225 */       .addSecondaryInputs((Collection)val$changedSecondaryInputs.getValue())
/* 226 */       .addOutputProvider(this$0.outputStream != null ? this$0.outputStream
/*     */       
/* 228 */       .asOutput() : null)
/*     */       
/* 230 */       .setIncrementalMode(((Boolean)val$isIncremental.getValue()).booleanValue())
/* 231 */       .build());
/*     */     
/* 233 */     if (this$0.outputStream != null) {
/* 234 */       this$0.outputStream.save();
/*     */     }
/* 236 */     return null;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.TransformTask.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */