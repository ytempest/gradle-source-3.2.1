/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.FeatureVariantData;
/*     */ import com.android.manifmerger.ManifestMerger2.Invoker.Feature;
/*     */ import java.util.List;
/*     */ 
/*     */ public class MergeManifests$FeatureConfigAction
/*     */   extends MergeManifests.ConfigAction
/*     */ {
/*     */   public MergeManifests$FeatureConfigAction(VariantScope scope, List<ManifestMerger2.Invoker.Feature> optionalFeatures)
/*     */   {
/* 557 */     super(scope, optionalFeatures, null);
/*     */   }
/*     */   
/*     */   public void execute(MergeManifests processManifestTask)
/*     */   {
/* 562 */     super.execute(processManifestTask);
/*     */     
/* 564 */     MergeManifests.access$902(processManifestTask, 
/* 565 */       ((FeatureVariantData)variantScope.getVariantData()).getFeatureName());
/* 566 */     MergeManifests.access$1002(processManifestTask, variantScope
/* 567 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.FEATURE_APPLICATION_ID_DECLARATION));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MergeManifests.FeatureConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */