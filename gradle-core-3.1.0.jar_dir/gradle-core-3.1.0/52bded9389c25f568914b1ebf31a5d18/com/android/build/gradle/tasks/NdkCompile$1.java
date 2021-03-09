/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.ide.common.util.ReferenceHolder;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.tasks.incremental.InputFileDetails;
/*     */ 
/*     */ class NdkCompile$1
/*     */   implements Action<InputFileDetails>
/*     */ {
/*     */   NdkCompile$1(NdkCompile this$0, ReferenceHolder paramReferenceHolder) {}
/*     */   
/*     */   public void execute(InputFileDetails change)
/*     */   {
/* 266 */     if (change.isAdded()) {
/* 267 */       val$generateMakeFile.setValue(Boolean.valueOf(true));
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.NdkCompile.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */