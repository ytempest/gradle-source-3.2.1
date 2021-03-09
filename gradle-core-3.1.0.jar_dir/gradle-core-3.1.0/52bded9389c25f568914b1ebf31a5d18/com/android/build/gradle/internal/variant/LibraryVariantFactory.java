/*     */ package com.android.build.gradle.internal.variant;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.BuildTypeData;
/*     */ import com.android.build.gradle.internal.ProductFlavorData;
/*     */ import com.android.build.gradle.internal.TaskManager;
/*     */ import com.android.build.gradle.internal.VariantModel;
/*     */ import com.android.build.gradle.internal.api.BaseVariantImpl;
/*     */ import com.android.build.gradle.internal.api.LibraryVariantImpl;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.BuildType;
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.dsl.CoreProductFlavor;
/*     */ import com.android.build.gradle.internal.dsl.ProductFlavor;
/*     */ import com.android.build.gradle.internal.dsl.SigningConfig;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import com.android.builder.profile.Recorder;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import org.gradle.api.NamedDomainObjectContainer;
/*     */ 
/*     */ public class LibraryVariantFactory
/*     */   extends BaseVariantFactory
/*     */ {
/*     */   public LibraryVariantFactory(GlobalScope globalScope, AndroidBuilder androidBuilder, AndroidConfig extension)
/*     */   {
/*  50 */     super(globalScope, androidBuilder, extension);
/*     */   }
/*     */   
/*     */   public BaseVariantData createVariantData(GradleVariantConfiguration variantConfiguration, TaskManager taskManager, Recorder recorder)
/*     */   {
/*  59 */     return new LibraryVariantData(globalScope, extension, taskManager, variantConfiguration, recorder);
/*     */   }
/*     */   
/*     */   public Class<? extends BaseVariantImpl> getVariantImplementationClass(BaseVariantData variantData)
/*     */   {
/*  71 */     return LibraryVariantImpl.class;
/*     */   }
/*     */   
/*     */   public Collection<VariantType> getVariantConfigurationTypes()
/*     */   {
/*  77 */     return ImmutableList.of(VariantType.LIBRARY);
/*     */   }
/*     */   
/*     */   public boolean hasTestScope()
/*     */   {
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   public void validateModel(VariantModel model)
/*     */   {
/*  90 */     EvalIssueReporter issueReporter = androidBuilder.getIssueReporter();
/*     */     
/*  92 */     if (model.getDefaultConfig().getProductFlavor().getApplicationId() != null) {
/*  93 */       String applicationId = model.getDefaultConfig().getProductFlavor().getApplicationId();
/*  94 */       issueReporter.reportError(EvalIssueReporter.Type.GENERIC, "Library projects cannot set applicationId. applicationId is set to '" + applicationId + "' in default config.", applicationId);
/*     */     }
/*     */     
/*     */     String applicationIdSuffix;
/*     */     
/* 103 */     if (model.getDefaultConfig().getProductFlavor().getApplicationIdSuffix() != null)
/*     */     {
/* 105 */       applicationIdSuffix = model.getDefaultConfig().getProductFlavor().getApplicationIdSuffix();
/* 106 */       issueReporter.reportError(EvalIssueReporter.Type.GENERIC, "Library projects cannot set applicationIdSuffix. applicationIdSuffix is set to '" + applicationIdSuffix + "' in default config.", applicationIdSuffix);
/*     */     }
/*     */     
/* 115 */     for (BuildTypeData buildType : model.getBuildTypes().values()) {
/* 116 */       if (buildType.getBuildType().getApplicationIdSuffix() != null) {
/* 117 */         String applicationIdSuffix = buildType.getBuildType().getApplicationIdSuffix();
/* 118 */         issueReporter.reportError(EvalIssueReporter.Type.GENERIC, "Library projects cannot set applicationIdSuffix. applicationIdSuffix is set to '" + applicationIdSuffix + "' in build type '" + buildType
/*     */         
/* 124 */           .getBuildType().getName() + "'.", applicationIdSuffix);
/*     */       }
/*     */     }
/*     */     
/* 129 */     for (ProductFlavorData productFlavor : model.getProductFlavors().values()) {
/* 130 */       if (productFlavor.getProductFlavor().getApplicationId() != null) {
/* 131 */         String applicationId = productFlavor.getProductFlavor().getApplicationId();
/* 132 */         issueReporter.reportError(EvalIssueReporter.Type.GENERIC, "Library projects cannot set applicationId. applicationId is set to '" + applicationId + "' in flavor '" + productFlavor
/*     */         
/* 138 */           .getProductFlavor().getName() + "'.", applicationId);
/*     */       }
/*     */       
/* 143 */       if (productFlavor.getProductFlavor().getApplicationIdSuffix() != null)
/*     */       {
/* 145 */         String applicationIdSuffix = productFlavor.getProductFlavor().getApplicationIdSuffix();
/* 146 */         issueReporter.reportError(EvalIssueReporter.Type.GENERIC, "Library projects cannot set applicationIdSuffix. applicationIdSuffix is set to '" + applicationIdSuffix + "' in flavor '" + productFlavor
/*     */         
/* 152 */           .getProductFlavor().getName() + "'.", applicationIdSuffix);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void createDefaultComponents(NamedDomainObjectContainer<BuildType> buildTypes, NamedDomainObjectContainer<ProductFlavor> productFlavors, NamedDomainObjectContainer<SigningConfig> signingConfigs)
/*     */   {
/* 166 */     signingConfigs.create("debug");
/* 167 */     buildTypes.create("debug");
/* 168 */     buildTypes.create("release");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.LibraryVariantFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */