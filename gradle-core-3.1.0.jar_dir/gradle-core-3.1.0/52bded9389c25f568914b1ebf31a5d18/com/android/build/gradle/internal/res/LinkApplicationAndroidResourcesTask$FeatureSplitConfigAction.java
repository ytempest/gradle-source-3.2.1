/*     */ package com.android.build.gradle.internal.res;
/*     */ 
/*     */ import com.android.build.gradle.internal.TaskManager.MergeType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ import java.util.function.Supplier;
/*     */ 
/*     */ public class LinkApplicationAndroidResourcesTask$FeatureSplitConfigAction
/*     */   extends LinkApplicationAndroidResourcesTask.ConfigAction
/*     */ {
/*     */   public LinkApplicationAndroidResourcesTask$FeatureSplitConfigAction(VariantScope scope, Supplier<File> symbolLocation, File symbolsWithPackageName, File resPackageOutputFolder, boolean generateLegacyMultidexMainDexProguardRules, TaskManager.MergeType mergeType, String baseName)
/*     */   {
/* 772 */     super(scope, symbolLocation, symbolsWithPackageName, resPackageOutputFolder, generateLegacyMultidexMainDexProguardRules, mergeType, baseName, false);
/*     */   }
/*     */   
/*     */   public void execute(LinkApplicationAndroidResourcesTask processResources)
/*     */   {
/* 785 */     super.execute(processResources);
/*     */     
/* 787 */     LinkApplicationAndroidResourcesTask.access$2002(processResources, variantScope
/* 788 */       .getArtifactCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.FEATURE_IDS_DECLARATION));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.LinkApplicationAndroidResourcesTask.FeatureSplitConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */