/*     */ package com.android.build.gradle.internal.res;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.TaskManager.MergeType;
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
/*     */ import com.android.build.gradle.internal.variant.TaskContainer.TaskKind;
/*     */ import com.android.build.gradle.options.BooleanOption;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.build.gradle.options.StringOption;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.io.File;
/*     */ import java.util.function.Supplier;
/*     */ 
/*     */ public class LinkApplicationAndroidResourcesTask$ConfigAction
/*     */   implements TaskConfigAction<LinkApplicationAndroidResourcesTask>
/*     */ {
/*     */   protected final VariantScope variantScope;
/*     */   protected final Supplier<File> symbolLocation;
/*     */   private final File symbolsWithPackageNameOutputFile;
/*     */   private final File resPackageOutputFolder;
/*     */   private final boolean generateLegacyMultidexMainDexProguardRules;
/*     */   private final TaskManager.MergeType sourceTaskOutputType;
/*     */   private final String baseName;
/*     */   private final boolean isLibrary;
/*     */   
/*     */   public LinkApplicationAndroidResourcesTask$ConfigAction(VariantScope scope, Supplier<File> symbolLocation, File symbolsWithPackageNameOutputFile, File resPackageOutputFolder, boolean generateLegacyMultidexMainDexProguardRules, TaskManager.MergeType sourceTaskOutputType, String baseName, boolean isLibrary)
/*     */   {
/* 625 */     variantScope = scope;
/* 626 */     this.symbolLocation = symbolLocation;
/* 627 */     this.symbolsWithPackageNameOutputFile = symbolsWithPackageNameOutputFile;
/* 628 */     this.resPackageOutputFolder = resPackageOutputFolder;
/* 629 */     this.generateLegacyMultidexMainDexProguardRules = generateLegacyMultidexMainDexProguardRules;
/*     */     
/* 631 */     this.baseName = baseName;
/* 632 */     this.sourceTaskOutputType = sourceTaskOutputType;
/* 633 */     this.isLibrary = isLibrary;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 639 */     return variantScope.getTaskName("process", "Resources");
/*     */   }
/*     */   
/*     */   public Class<LinkApplicationAndroidResourcesTask> getType()
/*     */   {
/* 645 */     return LinkApplicationAndroidResourcesTask.class;
/*     */   }
/*     */   
/*     */   public void execute(LinkApplicationAndroidResourcesTask processResources)
/*     */   {
/* 650 */     BaseVariantData variantData = variantScope.getVariantData();
/*     */     
/* 652 */     ProjectOptions projectOptions = variantScope.getGlobalScope().getProjectOptions();
/*     */     
/* 654 */     variantData.addTask(TaskContainer.TaskKind.PROCESS_ANDROID_RESOURCES, processResources);
/*     */     
/* 656 */     GradleVariantConfiguration config = variantData.getVariantConfiguration();
/*     */     
/* 658 */     processResources.setAndroidBuilder(variantScope.getGlobalScope().getAndroidBuilder());
/* 659 */     processResources.setVariantName(config.getFullName());
/* 660 */     LinkApplicationAndroidResourcesTask.access$002(processResources, resPackageOutputFolder);
/* 661 */     LinkApplicationAndroidResourcesTask.access$102(processResources, AaptGeneration.fromProjectOptions(projectOptions));
/*     */     
/* 663 */     if (variantData.getType() == VariantType.LIBRARY) {
/* 664 */       throw new IllegalArgumentException("Use GenerateLibraryRFileTask");
/*     */     }
/* 666 */     Preconditions.checkState(sourceTaskOutputType == TaskManager.MergeType.MERGE, "source output type should be MERGE", sourceTaskOutputType);
/*     */     
/* 672 */     processResources.setEnableAapt2(projectOptions.get(BooleanOption.ENABLE_AAPT2));
/*     */     
/* 674 */     LinkApplicationAndroidResourcesTask.access$202(processResources, config.getApplicationId());
/*     */     
/* 677 */     processResources.setIncrementalFolder(variantScope.getIncrementalDir(getName()));
/*     */     
/* 679 */     if (variantData.getType().getCanHaveSplits())
/*     */     {
/* 681 */       splitListInput = variantScope.getOutput(TaskOutputHolder.TaskOutputType.SPLIT_LIST);
/*     */     }
/*     */     
/* 684 */     LinkApplicationAndroidResourcesTask.access$302(processResources, variantScope
/* 685 */       .getOutput(TaskOutputHolder.TaskOutputType.APK_LIST));
/*     */     
/* 687 */     LinkApplicationAndroidResourcesTask.access$402(processResources, variantData.getMultiOutputPolicy());
/*     */     
/* 689 */     LinkApplicationAndroidResourcesTask.access$502(processResources, variantScope
/* 690 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, AndroidArtifacts.ArtifactScope.ALL, AndroidArtifacts.ArtifactType.SYMBOL_LIST_WITH_PACKAGE_NAME));
/*     */     
/* 696 */     File sourceOut = variantScope.getRClassSourceOutputDir();
/* 697 */     processResources.setSourceOutputDir(sourceOut);
/* 698 */     variantScope.addTaskOutput(TaskOutputHolder.TaskOutputType.NOT_NAMESPACED_R_CLASS_SOURCES, sourceOut, 
/*     */     
/* 701 */       getName());
/*     */     
/* 703 */     LinkApplicationAndroidResourcesTask.access$602(processResources, symbolLocation);
/* 704 */     LinkApplicationAndroidResourcesTask.access$702(processResources, symbolsWithPackageNameOutputFile);
/*     */     
/* 706 */     if (variantScope.getCodeShrinker() != null) {
/* 707 */       processResources.setProguardOutputFile(variantScope
/* 708 */         .getProcessAndroidResourcesProguardOutputFile());
/*     */     }
/*     */     
/* 711 */     if (generateLegacyMultidexMainDexProguardRules) {
/* 712 */       processResources.setAaptMainDexListProguardOutputFile(variantScope
/* 713 */         .getManifestKeepListProguardFile());
/*     */     }
/*     */     
/* 716 */     LinkApplicationAndroidResourcesTask.access$802(processResources, variantScope);
/* 717 */     LinkApplicationAndroidResourcesTask.access$902(processResources, variantData.getOutputScope());
/* 718 */     LinkApplicationAndroidResourcesTask.access$1002(processResources, variantData.getOutputFactory());
/* 719 */     LinkApplicationAndroidResourcesTask.access$1102(processResources, variantScope
/* 720 */       .getVariantConfiguration().getOriginalApplicationId());
/*     */     
/* 723 */     boolean aaptFriendlyManifestsFilePresent = variantScope.hasOutput(TaskOutputHolder.TaskOutputType.AAPT_FRIENDLY_MERGED_MANIFESTS);
/*     */     
/* 725 */     LinkApplicationAndroidResourcesTask.access$1202(processResources, variantScope
/*     */     
/* 728 */       .getInstantRunBuildContext().isInInstantRunMode() ? TaskOutputHolder.TaskOutputType.INSTANT_RUN_MERGED_MANIFESTS : aaptFriendlyManifestsFilePresent ? TaskOutputHolder.TaskOutputType.AAPT_FRIENDLY_MERGED_MANIFESTS : TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS);
/*     */     
/* 731 */     LinkApplicationAndroidResourcesTask.access$1300(processResources, variantScope
/* 732 */       .getOutput(LinkApplicationAndroidResourcesTask.access$1200(processResources)));
/*     */     
/* 734 */     LinkApplicationAndroidResourcesTask.access$1402(processResources, variantScope
/* 735 */       .getOutput(sourceTaskOutputType.getOutputType()));
/*     */     
/* 737 */     processResources.setType(config.getType());
/* 738 */     processResources.setDebuggable(((CoreBuildType)config.getBuildType()).isDebuggable());
/* 739 */     processResources.setAaptOptions(variantScope
/* 740 */       .getGlobalScope().getExtension().getAaptOptions());
/* 741 */     processResources.setPseudoLocalesEnabled(
/* 742 */       ((CoreBuildType)config.getBuildType()).isPseudoLocalesEnabled());
/*     */     
/* 744 */     LinkApplicationAndroidResourcesTask.access$1502(processResources, projectOptions
/* 745 */       .get(StringOption.IDE_BUILD_TARGET_DENSITY));
/*     */     
/* 747 */     processResources.setMergeBlameLogFolder(variantScope.getResourceBlameLogDir());
/*     */     
/* 749 */     LinkApplicationAndroidResourcesTask.access$1602(processResources, variantScope.getInstantRunBuildContext());
/*     */     
/* 751 */     LinkApplicationAndroidResourcesTask.access$1702(processResources, variantScope
/* 752 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.FEATURE_RESOURCE_PKG));
/*     */     
/* 755 */     LinkApplicationAndroidResourcesTask.access$1802(processResources, baseName);
/* 756 */     isLibrary = isLibrary;
/* 757 */     LinkApplicationAndroidResourcesTask.access$1902(processResources, new File(variantScope
/* 758 */       .getInstantRunSplitApkOutputFolder(), "resources"));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.LinkApplicationAndroidResourcesTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */