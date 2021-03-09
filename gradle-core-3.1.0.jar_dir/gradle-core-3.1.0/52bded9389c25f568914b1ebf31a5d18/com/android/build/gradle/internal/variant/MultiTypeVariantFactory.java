/*     */ package com.android.build.gradle.internal.variant;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.TaskManager;
/*     */ import com.android.build.gradle.internal.VariantModel;
/*     */ import com.android.build.gradle.internal.api.BaseVariantImpl;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.BuildType;
/*     */ import com.android.build.gradle.internal.dsl.ProductFlavor;
/*     */ import com.android.build.gradle.internal.dsl.SigningConfig;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.profile.Recorder;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import org.gradle.api.NamedDomainObjectContainer;
/*     */ 
/*     */ public class MultiTypeVariantFactory
/*     */   extends BaseVariantFactory
/*     */ {
/*     */   private final Map<VariantType, BaseVariantFactory> delegates;
/*     */   
/*     */   public MultiTypeVariantFactory(GlobalScope globalScope, AndroidBuilder androidBuilder, AndroidConfig extension)
/*     */   {
/*  48 */     super(globalScope, androidBuilder, extension);
/*     */     
/*  50 */     delegates = ImmutableMap.of(VariantType.FEATURE, new FeatureVariantFactory(globalScope, androidBuilder, extension), VariantType.LIBRARY, new LibraryVariantFactory(globalScope, androidBuilder, extension));
/*     */   }
/*     */   
/*     */   public BaseVariantData createVariantData(GradleVariantConfiguration variantConfiguration, TaskManager taskManager, Recorder recorder)
/*     */   {
/*  63 */     return 
/*     */     
/*  65 */       ((BaseVariantFactory)delegates.get(variantConfiguration.getType())).createVariantData(variantConfiguration, taskManager, recorder);
/*     */   }
/*     */   
/*     */   public Class<? extends BaseVariantImpl> getVariantImplementationClass(BaseVariantData variantData)
/*     */   {
/*  72 */     return ((BaseVariantFactory)delegates.get(variantData.getType())).getVariantImplementationClass(variantData);
/*     */   }
/*     */   
/*     */   public Collection<VariantType> getVariantConfigurationTypes()
/*     */   {
/*  78 */     return ImmutableList.of(VariantType.FEATURE, VariantType.LIBRARY);
/*     */   }
/*     */   
/*     */   public boolean hasTestScope()
/*     */   {
/*  83 */     return true;
/*     */   }
/*     */   
/*     */   public void validateModel(VariantModel model)
/*     */   {
/*  88 */     for (BaseVariantFactory variantFactory : delegates.values()) {
/*  89 */       variantFactory.validateModel(model);
/*     */     }
/*     */   }
/*     */   
/*     */   public void createDefaultComponents(NamedDomainObjectContainer<BuildType> buildTypes, NamedDomainObjectContainer<ProductFlavor> productFlavors, NamedDomainObjectContainer<SigningConfig> signingConfigs)
/*     */   {
/* 100 */     signingConfigs.create("debug");
/* 101 */     buildTypes.create("debug");
/* 102 */     buildTypes.create("release");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.MultiTypeVariantFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */