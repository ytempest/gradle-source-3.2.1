/*     */ package com.android.build.gradle.internal.res;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.aapt.AaptGeneration;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.AaptOptions;
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.OutputScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.build.gradle.options.StringOption;
/*     */ import com.android.ide.common.build.ApkData;
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2={"Lcom/android/build/gradle/internal/res/LinkAndroidResForBundleTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/LinkAndroidResForBundleTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "bundledResFile", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;)V", "execute", "", "processResources", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */ public final class LinkAndroidResForBundleTask$ConfigAction
/*     */   implements TaskConfigAction<LinkAndroidResForBundleTask>
/*     */ {
/*     */   private final VariantScope variantScope;
/*     */   private final File bundledResFile;
/*     */   
/*     */   public LinkAndroidResForBundleTask$ConfigAction(@NotNull VariantScope variantScope, @NotNull File bundledResFile)
/*     */   {
/* 197 */     this.variantScope = variantScope;this.bundledResFile = bundledResFile;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getName()
/*     */   {
/* 203 */     String tmp13_8 = variantScope.getTaskName("bundle", "Resources");Intrinsics.checkExpressionValueIsNotNull(tmp13_8, "variantScope.getTaskName(\"bundle\", \"Resources\")");return tmp13_8;
/*     */   }
/*     */   
/*     */   @NotNull
/* 207 */   public Class<LinkAndroidResForBundleTask> getType() { return LinkAndroidResForBundleTask.class; }
/*     */   
/*     */   public void execute(@NotNull LinkAndroidResForBundleTask processResources)
/*     */   {
/* 211 */     Intrinsics.checkParameterIsNotNull(processResources, "processResources");BaseVariantData variantData = variantScope.getVariantData(); GlobalScope 
/*     */     
/* 213 */       tmp25_20 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp25_20, "variantScope.globalScope");ProjectOptions projectOptions = tmp25_20.getProjectOptions(); BaseVariantData 
/*     */     
/* 215 */       tmp36_35 = variantData;Intrinsics.checkExpressionValueIsNotNull(tmp36_35, "variantData");GradleVariantConfiguration config = tmp36_35.getVariantConfiguration(); GlobalScope 
/*     */     
/* 217 */       tmp57_52 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp57_52, "variantScope.globalScope");processResources.setAndroidBuilder(tmp57_52.getAndroidBuilder()); GradleVariantConfiguration 
/* 218 */       tmp72_70 = config;Intrinsics.checkExpressionValueIsNotNull(tmp72_70, "config");processResources.setVariantName(tmp72_70.getFullName());
/* 219 */     LinkAndroidResForBundleTask.access$setBundledResFile$p(processResources, bundledResFile);
/* 220 */     LinkAndroidResForBundleTask.access$setAaptGeneration$p(processResources, AaptGeneration.fromProjectOptions(projectOptions)); File 
/*     */     
/* 222 */       tmp114_109 = variantScope.getIncrementalDir(getName());Intrinsics.checkExpressionValueIsNotNull(tmp114_109, "variantScope.getIncrementalDir(name)");LinkAndroidResForBundleTask.access$setIncrementalFolder$p(processResources, tmp114_109);
/*     */     
/* 224 */     LinkAndroidResForBundleTask.access$setVersionCode$p(processResources, config.getVersionCode());
/* 225 */     LinkAndroidResForBundleTask.access$setVersionName$p(processResources, config.getVersionName()); OutputScope 
/*     */     
/* 227 */       tmp146_143 = variantData.getOutputScope();Intrinsics.checkExpressionValueIsNotNull(tmp146_143, "variantData.outputScope"); ApkData tmp155_152 = tmp146_143.getMainSplit();Intrinsics.checkExpressionValueIsNotNull(tmp155_152, "variantData.outputScope.mainSplit");LinkAndroidResForBundleTask.access$setMainSplit$p(processResources, (ApkInfo)tmp155_152); FileCollection 
/*     */     
/* 229 */       tmp183_178 = variantScope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS);Intrinsics.checkExpressionValueIsNotNull(tmp183_178, "variantScope.getOutput(MERGED_MANIFESTS)");LinkAndroidResForBundleTask.access$setManifestFiles$p(processResources, tmp183_178);
/*     */     
/* 231 */     LinkAndroidResForBundleTask.access$setInputResourcesDir$p(processResources, variantScope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.MERGED_RES)); CoreBuildType 
/*     */     
/* 233 */       tmp220_217 = ((CoreBuildType)config.getBuildType());Intrinsics.checkExpressionValueIsNotNull(tmp220_217, "config.buildType");LinkAndroidResForBundleTask.access$setDebuggable$p(processResources, tmp220_217.isDebuggable()); GlobalScope 
/* 234 */       tmp244_239 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp244_239, "variantScope.globalScope"); AndroidConfig tmp253_250 = tmp244_239.getExtension();Intrinsics.checkExpressionValueIsNotNull(tmp253_250, "variantScope.globalScope.extension"); AaptOptions tmp264_259 = tmp253_250.getAaptOptions();Intrinsics.checkExpressionValueIsNotNull(tmp264_259, "variantScope.globalScope.extension.aaptOptions");LinkAndroidResForBundleTask.access$setAaptOptions$p(processResources, tmp264_259); CoreBuildType 
/* 235 */       tmp282_279 = ((CoreBuildType)config.getBuildType());Intrinsics.checkExpressionValueIsNotNull(tmp282_279, "config.buildType");LinkAndroidResForBundleTask.access$setPseudoLocalesEnabled$p(processResources, tmp282_279.isPseudoLocalesEnabled());
/*     */     
/* 237 */     LinkAndroidResForBundleTask.access$setBuildTargetDensity$p(processResources, projectOptions.get(StringOption.IDE_BUILD_TARGET_DENSITY));
/*     */     
/* 239 */     LinkAndroidResForBundleTask.access$setMergeBlameLogFolder$p(processResources, variantScope.getResourceBlameLogDir());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.LinkAndroidResForBundleTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */