/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.ide.common.res2.MergedAssetWriter.AssetWorkAction;
/*     */ import com.android.ide.common.res2.MergedAssetWriter.AssetWorkParameters;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ public class MergeSourceSetFolders$AssetWorkAction
/*     */   implements Runnable
/*     */ {
/*     */   private final MergedAssetWriter.AssetWorkAction workAction;
/*     */   
/*     */   @Inject
/*     */   public MergeSourceSetFolders$AssetWorkAction(MergedAssetWriter.AssetWorkParameters workItem)
/*     */   {
/* 219 */     workAction = new MergedAssetWriter.AssetWorkAction(workItem);
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/* 224 */     workAction.run();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MergeSourceSetFolders.AssetWorkAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */