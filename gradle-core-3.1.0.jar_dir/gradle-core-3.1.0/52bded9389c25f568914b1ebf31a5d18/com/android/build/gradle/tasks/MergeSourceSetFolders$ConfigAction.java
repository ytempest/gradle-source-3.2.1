/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.VariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import java.io.File;
/*     */ 
/*     */ public abstract class MergeSourceSetFolders$ConfigAction
/*     */   implements TaskConfigAction<MergeSourceSetFolders>
/*     */ {
/*     */   protected final VariantScope scope;
/*     */   protected final File outputDir;
/*     */   
/*     */   protected MergeSourceSetFolders$ConfigAction(VariantScope scope, File outputDir)
/*     */   {
/* 357 */     this.scope = scope;
/* 358 */     this.outputDir = outputDir;
/*     */   }
/*     */   
/*     */   public Class<MergeSourceSetFolders> getType()
/*     */   {
/* 364 */     return MergeSourceSetFolders.class;
/*     */   }
/*     */   
/*     */   public void execute(MergeSourceSetFolders mergeAssetsTask)
/*     */   {
/* 369 */     BaseVariantData variantData = scope.getVariantData();
/* 370 */     VariantConfiguration variantConfig = variantData.getVariantConfiguration();
/*     */     
/* 372 */     mergeAssetsTask.setAndroidBuilder(scope.getGlobalScope().getAndroidBuilder());
/* 373 */     mergeAssetsTask.setVariantName(variantConfig.getFullName());
/* 374 */     mergeAssetsTask.setIncrementalFolder(scope.getIncrementalDir(getName()));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MergeSourceSetFolders.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */