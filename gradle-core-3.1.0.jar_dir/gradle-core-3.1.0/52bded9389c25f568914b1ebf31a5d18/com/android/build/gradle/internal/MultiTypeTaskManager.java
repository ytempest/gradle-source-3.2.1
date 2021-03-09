/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import android.databinding.tool.DataBindingBuilder;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.AnchorOutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.profile.Recorder;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.tooling.provider.model.ToolingModelBuilderRegistry;
/*     */ 
/*     */ public class MultiTypeTaskManager
/*     */   extends TaskManager
/*     */ {
/*     */   Map<VariantType, TaskManager> delegates;
/*     */   
/*     */   public MultiTypeTaskManager(GlobalScope globalScope, Project project, ProjectOptions projectOptions, AndroidBuilder androidBuilder, DataBindingBuilder dataBindingBuilder, AndroidConfig extension, SdkHandler sdkHandler, ToolingModelBuilderRegistry toolingRegistry, Recorder recorder)
/*     */   {
/*  54 */     super(globalScope, project, projectOptions, androidBuilder, dataBindingBuilder, extension, sdkHandler, toolingRegistry, recorder);
/*     */     
/*  65 */     delegates = ImmutableMap.of(VariantType.FEATURE, new FeatureTaskManager(globalScope, project, projectOptions, androidBuilder, dataBindingBuilder, extension, sdkHandler, toolingRegistry, recorder), VariantType.LIBRARY, new LibraryTaskManager(globalScope, project, projectOptions, androidBuilder, dataBindingBuilder, extension, sdkHandler, toolingRegistry, recorder));
/*     */   }
/*     */   
/*     */   public void createTasksForVariantScope(VariantScope variantScope)
/*     */   {
/*  94 */     ((TaskManager)delegates.get(variantScope.getVariantData().getType())).createTasksForVariantScope(variantScope);
/*     */   }
/*     */   
/*     */   protected Set<? super QualifiedContent.Scope> getResMergingScopes(VariantScope variantScope)
/*     */   {
/* 101 */     VariantType variantType = variantScope.getVariantData().getType();
/* 102 */     if (variantType.isForTesting()) {
/* 103 */       variantType = variantScope.getTestedVariantData().getType();
/*     */     }
/* 105 */     return ((TaskManager)delegates.get(variantType)).getResMergingScopes(variantScope);
/*     */   }
/*     */   
/*     */   protected void postJavacCreation(VariantScope scope)
/*     */   {
/* 114 */     ConfigurableFileCollection fileCollection = scope.createAnchorOutput(TaskOutputHolder.AnchorOutputType.ALL_CLASSES);
/* 115 */     fileCollection.from(new Object[] { scope.getOutput(TaskOutputHolder.TaskOutputType.JAVAC) });
/* 116 */     fileCollection.from(new Object[] { scope.getVariantData().getAllPreJavacGeneratedBytecode() });
/* 117 */     fileCollection.from(new Object[] { scope.getVariantData().getAllPostJavacGeneratedBytecode() });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.MultiTypeTaskManager
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */