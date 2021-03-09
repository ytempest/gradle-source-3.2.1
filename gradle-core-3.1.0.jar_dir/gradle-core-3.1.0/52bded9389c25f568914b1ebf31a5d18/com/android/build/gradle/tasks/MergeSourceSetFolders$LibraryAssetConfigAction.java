/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ 
/*     */ public class MergeSourceSetFolders$LibraryAssetConfigAction
/*     */   extends MergeSourceSetFolders.MergeAssetBaseConfigAction
/*     */ {
/*     */   public MergeSourceSetFolders$LibraryAssetConfigAction(VariantScope scope, File outputDir)
/*     */   {
/* 445 */     super(scope, outputDir, false);
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 451 */     return scope.getTaskName("package", "Assets");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MergeSourceSetFolders.LibraryAssetConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */