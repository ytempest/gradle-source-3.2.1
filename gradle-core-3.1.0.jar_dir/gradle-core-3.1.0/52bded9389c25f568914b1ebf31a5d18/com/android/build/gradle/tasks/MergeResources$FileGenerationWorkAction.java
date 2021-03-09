/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.ide.common.res2.MergedResourceWriter.FileGenerationParameters;
/*     */ import com.android.ide.common.res2.MergedResourceWriter.FileGenerationWorkAction;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ public class MergeResources$FileGenerationWorkAction
/*     */   implements Runnable
/*     */ {
/*     */   private final MergedResourceWriter.FileGenerationWorkAction workAction;
/*     */   
/*     */   @Inject
/*     */   public MergeResources$FileGenerationWorkAction(MergedResourceWriter.FileGenerationParameters workItem)
/*     */   {
/* 403 */     workAction = new MergedResourceWriter.FileGenerationWorkAction(workItem);
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/* 408 */     workAction.run();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MergeResources.FileGenerationWorkAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */