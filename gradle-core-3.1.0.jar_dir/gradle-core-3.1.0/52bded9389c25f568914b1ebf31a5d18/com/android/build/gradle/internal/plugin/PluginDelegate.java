/*     */ package com.android.build.gradle.internal.plugin;
/*     */ 
/*     */ import com.android.build.api.dsl.options.PostProcessingFilesOptions;
/*     */ import com.android.build.api.dsl.variant.Variant;
/*     */ import com.android.build.gradle.internal.api.dsl.extensions.BaseExtension2;
/*     */ import com.android.build.gradle.internal.api.dsl.extensions.BuildPropertiesImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.extensions.VariantAwarePropertiesImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.extensions.VariantOrExtensionPropertiesImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.BaseFlavorImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.BuildTypeOrProductFlavorImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.DefaultConfigImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.FallbackStrategyImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.ProductFlavorOrVariantImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.VariantPropertiesImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.variant.SealableVariant;
/*     */ import com.android.build.gradle.internal.api.sourcesets.FilesProvider;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporterImpl;
/*     */ import com.android.build.gradle.internal.errors.SyncIssueHandlerImpl;
/*     */ import com.android.build.gradle.internal.variant2.ContainerFactory;
/*     */ import com.android.build.gradle.internal.variant2.DslModelData;
/*     */ import com.android.build.gradle.internal.variant2.DslModelDataImpl;
/*     */ import com.android.build.gradle.internal.variant2.VariantBuilder;
/*     */ import com.android.build.gradle.internal.variant2.VariantCallbackHolder;
/*     */ import com.android.build.gradle.internal.variant2.VariantModelData;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.build.gradle.options.SyncOptions;
/*     */ import com.android.build.gradle.options.SyncOptions.EvaluationMode;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import com.google.common.collect.ImmutableTable;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.artifacts.ConfigurationContainer;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.model.ObjectFactory;
/*     */ import org.gradle.api.plugins.ExtensionContainer;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000n\n\002\030\002\n\000\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\036\n\002\030\002\n\002\b\003\030\000*\n\b\000\020\001 \001*\0020\0022\0020\003BS\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t\022\006\020\n\032\0020\013\022\006\020\f\032\0020\r\022\006\020\016\032\0020\017\022\006\020\020\032\0020\021\022\006\020\022\032\0020\023\022\f\020\024\032\b\022\004\022\0028\0000\025¢\006\002\020\026J\f\020!\032\b\022\004\022\0020#0\"J\013\020$\032\0028\000¢\006\002\020%R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\027\032\0020\030X\004¢\006\002\n\000R\024\020\031\032\b\022\004\022\0028\0000\032X.¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\033\032\0020\034X\004¢\006\002\n\000R\016\020\020\032\0020\021X\004¢\006\002\n\000R\020\020\035\032\0028\000X.¢\006\004\n\002\020\036R\016\020\006\032\0020\007X\004¢\006\002\n\000R\024\020\024\032\b\022\004\022\0028\0000\025X\004¢\006\002\n\000R\016\020\037\032\0020 X.¢\006\002\n\000¨\006&"}, d2={"Lcom/android/build/gradle/internal/plugin/PluginDelegate;", "E", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "", "projectPath", "", "objectFactory", "Lorg/gradle/api/model/ObjectFactory;", "extensionContainer", "Lorg/gradle/api/plugins/ExtensionContainer;", "configurationContainer", "Lorg/gradle/api/artifacts/ConfigurationContainer;", "containerFactory", "Lcom/android/build/gradle/internal/variant2/ContainerFactory;", "filesProvider", "Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;", "logger", "Lorg/gradle/api/logging/Logger;", "projectOptions", "Lcom/android/build/gradle/options/ProjectOptions;", "typedDelegate", "Lcom/android/build/gradle/internal/plugin/TypedPluginDelegate;", "(Ljava/lang/String;Lorg/gradle/api/model/ObjectFactory;Lorg/gradle/api/plugins/ExtensionContainer;Lorg/gradle/api/artifacts/ConfigurationContainer;Lcom/android/build/gradle/internal/variant2/ContainerFactory;Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;Lorg/gradle/api/logging/Logger;Lcom/android/build/gradle/options/ProjectOptions;Lcom/android/build/gradle/internal/plugin/TypedPluginDelegate;)V", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporterImpl;", "dslModelData", "Lcom/android/build/gradle/internal/variant2/DslModelDataImpl;", "issueReporter", "Lcom/android/build/gradle/internal/errors/SyncIssueHandlerImpl;", "newExtension", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "variantModelData", "Lcom/android/build/gradle/internal/variant2/VariantModelData;", "afterEvaluate", "", "Lcom/android/build/api/dsl/variant/Variant;", "prepareForEvaluation", "()Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "gradle-core"})
/*     */ public final class PluginDelegate<E extends BaseExtension2>
/*     */ {
/*     */   private DslModelDataImpl<? super E> dslModelData;
/*     */   private VariantModelData variantModelData;
/*     */   private E newExtension;
/*     */   private final SyncIssueHandlerImpl issueReporter;
/*     */   private final DeprecationReporterImpl deprecationReporter;
/*     */   private final ObjectFactory objectFactory;
/*     */   private final ExtensionContainer extensionContainer;
/*     */   private final ConfigurationContainer configurationContainer;
/*     */   private final ContainerFactory containerFactory;
/*     */   private final FilesProvider filesProvider;
/*     */   private final Logger logger;
/*     */   private final TypedPluginDelegate<E> typedDelegate;
/*     */   
/*     */   public PluginDelegate(@NotNull String projectPath, @NotNull ObjectFactory objectFactory, @NotNull ExtensionContainer extensionContainer, @NotNull ConfigurationContainer configurationContainer, @NotNull ContainerFactory containerFactory, @NotNull FilesProvider filesProvider, @NotNull Logger logger, @NotNull ProjectOptions projectOptions, @NotNull TypedPluginDelegate<E> typedDelegate)
/*     */   {
/*  76 */     this.objectFactory = objectFactory;this.extensionContainer = extensionContainer;this.configurationContainer = configurationContainer;this.containerFactory = containerFactory;this.filesProvider = filesProvider;this.logger = logger;this.typedDelegate = typedDelegate; SyncOptions.EvaluationMode 
/*     */     
/*  92 */       tmp114_111 = SyncOptions.getModelQueryMode(projectOptions);Intrinsics.checkExpressionValueIsNotNull(tmp114_111, "SyncOptions.getModelQueryMode(projectOptions)");issueReporter = new SyncIssueHandlerImpl(tmp114_111, this.logger);
/*  93 */     deprecationReporter = new DeprecationReporterImpl((EvalIssueReporter)issueReporter, projectPath);
/*     */     
/*  96 */     if (projectOptions.hasRemovedOptions())
/*     */     {
/*  98 */       String tmp170_167 = projectOptions.getRemovedOptionsErrorMessage();Intrinsics.checkExpressionValueIsNotNull(tmp170_167, "projectOptions.removedOptionsErrorMessage");issueReporter.reportError(EvalIssueReporter.Type.GENERIC, tmp170_167);
/*     */     }
/*     */     
/* 101 */     if (projectOptions.hasDeprecatedOptions()) {
/* 102 */       ImmutableTable tmp198_195 = projectOptions.getDeprecatedOptions();Intrinsics.checkExpressionValueIsNotNull(tmp198_195, "projectOptions.deprecatedOptions");deprecationReporter.reportDeprecatedOptions(tmp198_195);
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final E prepareForEvaluation() {
/* 108 */     BaseFlavorImpl baseFlavor = new BaseFlavorImpl((DeprecationReporter)deprecationReporter, (EvalIssueReporter)issueReporter);
/* 109 */     DefaultConfigImpl defaultConfig = new DefaultConfigImpl(
/* 110 */       new VariantPropertiesImpl((EvalIssueReporter)issueReporter), 
/* 111 */       new BuildTypeOrProductFlavorImpl(
/* 112 */       (DeprecationReporter)deprecationReporter, (EvalIssueReporter)issueReporter, (Function0)new Lambda(baseFlavor) { @NotNull
/* 112 */         public final PostProcessingFilesOptions invoke() { return $baseFlavor.getPostProcessing(); }
/* 113 */       }), new ProductFlavorOrVariantImpl((EvalIssueReporter)issueReporter), 
/* 114 */       new FallbackStrategyImpl((DeprecationReporter)deprecationReporter, (EvalIssueReporter)issueReporter), 
/* 115 */       baseFlavor, 
/* 116 */       (EvalIssueReporter)issueReporter);
/*     */     
/* 118 */     dslModelData = new DslModelDataImpl(
/* 119 */       defaultConfig, 
/* 120 */       typedDelegate.getVariantFactories(), 
/* 121 */       configurationContainer, 
/* 122 */       filesProvider, 
/* 123 */       containerFactory, 
/* 124 */       objectFactory, 
/* 125 */       (DeprecationReporter)deprecationReporter, 
/* 126 */       (EvalIssueReporter)issueReporter, 
/* 127 */       logger);
/*     */     
/* 129 */     variantModelData = new VariantModelData((EvalIssueReporter)issueReporter); DslModelDataImpl 
/*     */     
/* 133 */       tmp209_206 = dslModelData;
/*     */     
/* 133 */     if (tmp209_206 == null) { Intrinsics.throwUninitializedPropertyAccessException("dslModelData");
/*     */     }
/*     */     
/* 136 */     DslModelDataImpl tmp253_250 = dslModelData;
/*     */     
/* 136 */     if (tmp253_250 == null) Intrinsics.throwUninitializedPropertyAccessException("dslModelData");
/* 137 */     VariantModelData tmp269_266 = variantModelData;
/*     */     
/* 137 */     if (tmp269_266 == null) Intrinsics.throwUninitializedPropertyAccessException("variantModelData");
/* 131 */     newExtension = typedDelegate.createNewExtension(
/* 132 */       extensionContainer, 
/* 133 */       new BuildPropertiesImpl((DslModelData)tmp209_206, (EvalIssueReporter)issueReporter), 
/* 134 */       new VariantOrExtensionPropertiesImpl((EvalIssueReporter)issueReporter), 
/* 135 */       new VariantAwarePropertiesImpl(
/* 136 */       (DslModelData)tmp253_250, 
/* 137 */       (VariantCallbackHolder)tmp269_266, 
/* 138 */       (DeprecationReporter)deprecationReporter, 
/* 139 */       (EvalIssueReporter)issueReporter), 
/* 140 */       (DeprecationReporter)deprecationReporter, 
/* 141 */       (EvalIssueReporter)issueReporter); BaseExtension2 
/*     */     
/* 143 */       tmp328_325 = newExtension;
/*     */     
/* 143 */     if (tmp328_325 == null) Intrinsics.throwUninitializedPropertyAccessException("newExtension"); typedDelegate.createDefaults(tmp328_325); BaseExtension2 
/*     */     
/* 145 */       tmp346_343 = newExtension;
/*     */     
/* 145 */     if (tmp346_343 == null) Intrinsics.throwUninitializedPropertyAccessException("newExtension"); return tmp346_343;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Collection<Variant> afterEvaluate() {
/* 150 */     BaseExtension2 tmp4_1 = newExtension;
/*     */     
/* 150 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("newExtension"); List preVariantActions = tmp4_1.getPreVariantCallbacks();
/* 151 */     for (Action action : preVariantActions) {
/* 152 */       action.execute(null);
/*     */     }
/*     */     
/* 156 */     BaseExtension2 tmp59_56 = newExtension;
/*     */     
/* 156 */     if (tmp59_56 == null) Intrinsics.throwUninitializedPropertyAccessException("newExtension"); tmp59_56.seal(); DslModelDataImpl 
/* 157 */       tmp77_74 = dslModelData;
/* 157 */     if (tmp77_74 == null) Intrinsics.throwUninitializedPropertyAccessException("dslModelData"); tmp77_74.seal(); DslModelDataImpl 
/*     */     
/* 160 */       tmp93_90 = dslModelData;
/*     */     
/* 160 */     if (tmp93_90 == null) Intrinsics.throwUninitializedPropertyAccessException("dslModelData"); tmp93_90.afterEvaluateCompute(); DslModelDataImpl 
/*     */     
/* 162 */       tmp113_110 = dslModelData;
/*     */     
/* 162 */     if (tmp113_110 == null) Intrinsics.throwUninitializedPropertyAccessException("dslModelData");
/* 163 */     BaseExtension2 tmp126_123 = newExtension;
/*     */     
/* 163 */     if (tmp126_123 == null) Intrinsics.throwUninitializedPropertyAccessException("newExtension");
/* 161 */     VariantBuilder builder = new VariantBuilder(
/* 162 */       tmp113_110, 
/* 163 */       tmp126_123, 
/* 164 */       (DeprecationReporter)deprecationReporter, 
/* 165 */       (EvalIssueReporter)issueReporter);
/* 166 */     builder.generateVariants();
/* 167 */     List variants = builder.getVariants();
/* 168 */     Collection variantShims = builder.getShims(); VariantModelData 
/*     */     
/* 171 */       tmp172_169 = variantModelData;
/*     */     
/* 171 */     if (tmp172_169 == null) Intrinsics.throwUninitializedPropertyAccessException("variantModelData"); tmp172_169.runVariantCallbacks(variantShims); BaseExtension2 
/*     */     
/* 174 */       tmp190_187 = newExtension;
/*     */     
/* 174 */     if (tmp190_187 == null) Intrinsics.throwUninitializedPropertyAccessException("newExtension"); for (Action action : tmp190_187.getPostVariants()) {
/* 175 */       action.execute(variantShims);
/*     */     }
/*     */     
/* 179 */     for (SealableVariant variant : variants) {
/* 180 */       variant.seal();
/*     */     }
/*     */     
/* 183 */     VariantModelData tmp289_286 = variantModelData;
/*     */     
/* 183 */     if (tmp289_286 == null) Intrinsics.throwUninitializedPropertyAccessException("variantModelData"); tmp289_286.seal();
/*     */     
/* 188 */     return variantShims;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.plugin.PluginDelegate
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */