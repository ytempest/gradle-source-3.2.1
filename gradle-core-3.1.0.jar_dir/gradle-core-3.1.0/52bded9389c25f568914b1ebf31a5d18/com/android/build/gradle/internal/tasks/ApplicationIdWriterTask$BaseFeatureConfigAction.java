/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ 
/*     */ public class ApplicationIdWriterTask$BaseFeatureConfigAction
/*     */   extends ApplicationIdWriterTask.ConfigAction
/*     */ {
/*     */   public ApplicationIdWriterTask$BaseFeatureConfigAction(VariantScope variantScope, File outputDirectory)
/*     */   {
/* 106 */     super(variantScope, outputDirectory);
/*     */   }
/*     */   
/*     */   public void execute(ApplicationIdWriterTask task)
/*     */   {
/* 111 */     super.execute(task);
/* 112 */     ApplicationIdWriterTask.access$202(task, variantScope
/* 113 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.METADATA_VALUES, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.METADATA_APP_ID_DECLARATION));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.ApplicationIdWriterTask.BaseFeatureConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */