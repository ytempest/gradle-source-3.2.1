/*     */ package com.android.build.gradle.internal.pipeline;
/*     */ 
/*     */ import com.android.build.api.transform.Status;
/*     */ import com.android.builder.profile.Recorder.Block;
/*     */ import com.android.ide.common.util.ReferenceHolder;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.tasks.incremental.IncrementalTaskInputs;
/*     */ 
/*     */ class TransformTask$1
/*     */   implements Recorder.Block<Void>
/*     */ {
/*     */   TransformTask$1(TransformTask this$0, ReferenceHolder paramReferenceHolder1, IncrementalTaskInputs paramIncrementalTaskInputs, ReferenceHolder paramReferenceHolder2, ReferenceHolder paramReferenceHolder3, ReferenceHolder paramReferenceHolder4) {}
/*     */   
/*     */   public Void call()
/*     */     throws Exception
/*     */   {
/* 160 */     Map<File, Status> changedMap = Maps.newHashMap();
/* 161 */     Set<File> removedFiles = Sets.newHashSet();
/* 162 */     if (((Boolean)val$isIncremental.getValue()).booleanValue())
/*     */     {
/* 164 */       TransformTask.access$000(
/* 165 */         this$0.getLogger(), val$incrementalTaskInputs, changedMap, removedFiles);
/*     */       
/* 169 */       val$isIncremental.setValue(Boolean.valueOf(TransformTask.access$100(this$0, changedMap, removedFiles)));
/*     */     }
/*     */     
/* 172 */     if (((Boolean)val$isIncremental.getValue()).booleanValue())
/*     */     {
/* 175 */       List<IncrementalTransformInput> incInputs = TransformTask.access$200(this$0.consumedInputStreams);
/*     */       
/* 177 */       List<IncrementalTransformInput> incReferencedInputs = TransformTask.access$200(this$0.referencedInputStreams);
/*     */       
/* 180 */       if (((Boolean)val$isIncremental.setValue(
/* 181 */         Boolean.valueOf(TransformTask.access$300(this$0, incInputs, incReferencedInputs, changedMap, removedFiles)))).booleanValue())
/*     */       {
/* 186 */         val$consumedInputs.setValue(TransformTask.access$400(incInputs));
/* 187 */         val$referencedInputs.setValue(TransformTask.access$400(incReferencedInputs));
/*     */       }
/*     */     }
/*     */     
/* 193 */     if (!((Boolean)val$isIncremental.getValue()).booleanValue()) {
/* 194 */       val$consumedInputs.setValue(
/* 195 */         TransformTask.access$500(this$0.consumedInputStreams));
/* 196 */       val$referencedInputs.setValue(
/* 197 */         TransformTask.access$500(this$0.referencedInputStreams));
/* 198 */       val$changedSecondaryInputs.setValue(ImmutableList.of());
/*     */     }
/*     */     else {
/* 201 */       val$changedSecondaryInputs.setValue(
/* 202 */         TransformTask.access$600(this$0, changedMap, removedFiles));
/*     */     }
/*     */     
/* 205 */     return null;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.TransformTask.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */