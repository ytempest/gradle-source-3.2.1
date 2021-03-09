/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.manifmerger.ManifestMerger2.Invoker.Feature;
/*     */ import java.util.List;
/*     */ 
/*     */ public class MergeManifests$BaseFeatureConfigAction
/*     */   extends MergeManifests.ConfigAction
/*     */ {
/*     */   public MergeManifests$BaseFeatureConfigAction(VariantScope scope, List<ManifestMerger2.Invoker.Feature> optionalFeatures)
/*     */   {
/* 576 */     super(scope, optionalFeatures, null);
/*     */   }
/*     */   
/*     */   public void execute(MergeManifests processManifestTask)
/*     */   {
/* 581 */     super.execute(processManifestTask);
/*     */     
/* 583 */     MergeManifests.access$1002(processManifestTask, variantScope
/* 584 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.METADATA_VALUES, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.METADATA_APP_ID_DECLARATION));
/*     */     
/* 588 */     MergeManifests.access$1102(processManifestTask, variantScope
/* 589 */       .getArtifactCollection(AndroidArtifacts.ConsumedConfigType.METADATA_VALUES, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.METADATA_FEATURE_MANIFEST));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MergeManifests.BaseFeatureConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */