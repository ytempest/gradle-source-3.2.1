/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ 
/*     */ public class MergeSourceSetFolders$MergeAppAssetConfigAction
/*     */   extends MergeSourceSetFolders.MergeAssetBaseConfigAction
/*     */ {
/*     */   public MergeSourceSetFolders$MergeAppAssetConfigAction(VariantScope scope, File outputDir)
/*     */   {
/* 433 */     super(scope, outputDir, true);
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 439 */     return scope.getTaskName("merge", "Assets");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MergeSourceSetFolders.MergeAppAssetConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */