/*     */ package com.android.build.gradle.internal.res;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.aapt.AaptGeneration;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.build.gradle.options.StringOption;
/*     */ import com.android.builder.core.VariantType;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public final class LinkApplicationAndroidResourcesTask$NamespacedConfigAction
/*     */   implements TaskConfigAction<LinkApplicationAndroidResourcesTask>
/*     */ {
/*     */   protected final VariantScope variantScope;
/*     */   private final File resPackageOutputDir;
/*     */   private final File sourceOutputDir;
/*     */   private final boolean isLibrary;
/*     */   private final boolean generateLegacyMultidexMainDexProguardRules;
/*     */   private final String baseName;
/*     */   
/*     */   public LinkApplicationAndroidResourcesTask$NamespacedConfigAction(VariantScope scope, File sourceOutputDir, File resPackageOutputDir, boolean isLibrary, boolean generateLegacyMultidexMainDexProguardRules, String baseName)
/*     */   {
/* 813 */     variantScope = scope;
/* 814 */     this.resPackageOutputDir = resPackageOutputDir;
/* 815 */     this.sourceOutputDir = sourceOutputDir;
/* 816 */     this.isLibrary = isLibrary;
/* 817 */     this.generateLegacyMultidexMainDexProguardRules = generateLegacyMultidexMainDexProguardRules;
/*     */     
/* 819 */     this.baseName = baseName;
/*     */   }
/*     */   
/*     */   public final String getName()
/*     */   {
/* 825 */     return variantScope.getTaskName("process", "Resources");
/*     */   }
/*     */   
/*     */   public final Class<LinkApplicationAndroidResourcesTask> getType()
/*     */   {
/* 831 */     return LinkApplicationAndroidResourcesTask.class;
/*     */   }
/*     */   
/*     */   public final void execute(LinkApplicationAndroidResourcesTask task)
/*     */   {
/* 836 */     BaseVariantData variantData = variantScope.getVariantData();
/* 837 */     ProjectOptions projectOptions = variantScope.getGlobalScope().getProjectOptions();
/* 838 */     GradleVariantConfiguration config = variantData.getVariantConfiguration();
/*     */     
/* 840 */     task.setAndroidBuilder(variantScope.getGlobalScope().getAndroidBuilder());
/* 841 */     task.setVariantName(config.getFullName());
/* 842 */     LinkApplicationAndroidResourcesTask.access$002(task, resPackageOutputDir);
/* 843 */     LinkApplicationAndroidResourcesTask.access$102(task, AaptGeneration.fromProjectOptions(projectOptions));
/* 844 */     task.setEnableAapt2(true);
/*     */     
/* 846 */     LinkApplicationAndroidResourcesTask.access$202(task, config.getApplicationId());
/*     */     
/* 849 */     task.setIncrementalFolder(variantScope.getIncrementalDir(getName()));
/* 850 */     if (variantData.getType().getCanHaveSplits())
/*     */     {
/* 852 */       splitListInput = variantScope.getOutput(TaskOutputHolder.TaskOutputType.SPLIT_LIST);
/*     */     }
/* 854 */     LinkApplicationAndroidResourcesTask.access$402(task, variantData.getMultiOutputPolicy());
/* 855 */     LinkApplicationAndroidResourcesTask.access$302(task, variantScope.getOutput(TaskOutputHolder.TaskOutputType.APK_LIST));
/*     */     
/* 857 */     LinkApplicationAndroidResourcesTask.access$2102(task, sourceOutputDir);
/*     */     
/* 859 */     if (variantScope.getCodeShrinker() != null) {
/* 860 */       task.setProguardOutputFile(variantScope
/* 861 */         .getProcessAndroidResourcesProguardOutputFile());
/*     */     }
/*     */     
/* 864 */     if (generateLegacyMultidexMainDexProguardRules) {
/* 865 */       task.setAaptMainDexListProguardOutputFile(variantScope
/* 866 */         .getManifestKeepListProguardFile());
/*     */     }
/*     */     
/* 869 */     LinkApplicationAndroidResourcesTask.access$802(task, variantScope);
/* 870 */     LinkApplicationAndroidResourcesTask.access$2202(task, variantData.getOutputScope());
/* 871 */     LinkApplicationAndroidResourcesTask.access$1002(task, variantData.getOutputFactory());
/* 872 */     LinkApplicationAndroidResourcesTask.access$1102(task, variantScope
/* 873 */       .getVariantConfiguration().getOriginalApplicationId());
/*     */     
/* 876 */     boolean aaptFriendlyManifestsFilePresent = variantScope.hasOutput(TaskOutputHolder.TaskOutputType.AAPT_FRIENDLY_MERGED_MANIFESTS);
/*     */     
/* 878 */     LinkApplicationAndroidResourcesTask.access$1202(task, variantScope
/*     */     
/* 881 */       .getInstantRunBuildContext().isInInstantRunMode() ? TaskOutputHolder.TaskOutputType.INSTANT_RUN_MERGED_MANIFESTS : aaptFriendlyManifestsFilePresent ? TaskOutputHolder.TaskOutputType.AAPT_FRIENDLY_MERGED_MANIFESTS : TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS);
/*     */     
/* 884 */     LinkApplicationAndroidResourcesTask.access$2300(task, variantScope.getOutput(LinkApplicationAndroidResourcesTask.access$1200(task)));
/*     */     
/* 886 */     List<FileCollection> dependencies = new ArrayList(2);
/* 887 */     dependencies.add(variantScope
/* 888 */       .getOutput(TaskOutputHolder.TaskOutputType.RES_STATIC_LIBRARY));
/* 889 */     dependencies.add(variantScope
/* 890 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, AndroidArtifacts.ArtifactScope.ALL, AndroidArtifacts.ArtifactType.RES_STATIC_LIBRARY));
/*     */     
/* 895 */     LinkApplicationAndroidResourcesTask.access$502(task, variantScope
/* 896 */       .getGlobalScope().getProject().files(new Object[] { dependencies }));
/* 897 */     LinkApplicationAndroidResourcesTask.access$2402(task, variantScope
/* 898 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.ALL, AndroidArtifacts.ArtifactType.RES_SHARED_STATIC_LIBRARY));
/*     */     
/* 902 */     task.setType(config.getType());
/* 903 */     task.setDebuggable(((CoreBuildType)config.getBuildType()).isDebuggable());
/* 904 */     task.setAaptOptions(variantScope.getGlobalScope().getExtension().getAaptOptions());
/* 905 */     task.setPseudoLocalesEnabled(((CoreBuildType)config.getBuildType()).isPseudoLocalesEnabled());
/*     */     
/* 907 */     LinkApplicationAndroidResourcesTask.access$1502(task, projectOptions.get(StringOption.IDE_BUILD_TARGET_DENSITY));
/*     */     
/* 909 */     task.setMergeBlameLogFolder(variantScope.getResourceBlameLogDir());
/*     */     
/* 911 */     LinkApplicationAndroidResourcesTask.access$1602(task, variantScope.getInstantRunBuildContext());
/*     */     
/* 913 */     LinkApplicationAndroidResourcesTask.access$1702(task, variantScope
/* 914 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.FEATURE_RESOURCE_PKG));
/*     */     
/* 916 */     if ((variantScope.getVariantData().getType() == VariantType.FEATURE) && 
/* 917 */       (!variantScope.isBaseFeature())) {
/* 918 */       LinkApplicationAndroidResourcesTask.access$2002(task, variantScope
/* 919 */         .getArtifactCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.FEATURE_IDS_DECLARATION));
/*     */     }
/*     */     
/* 923 */     LinkApplicationAndroidResourcesTask.access$1802(task, baseName);
/* 924 */     isLibrary = isLibrary;
/* 925 */     LinkApplicationAndroidResourcesTask.access$1902(task, new File(variantScope
/* 926 */       .getInstantRunSplitApkOutputFolder(), "resources"));
/* 927 */     LinkApplicationAndroidResourcesTask.access$2502(task, true);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.LinkApplicationAndroidResourcesTask.NamespacedConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */