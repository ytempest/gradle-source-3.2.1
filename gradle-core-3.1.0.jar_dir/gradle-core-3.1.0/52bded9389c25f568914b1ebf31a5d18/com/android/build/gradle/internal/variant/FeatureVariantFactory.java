/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.internal.TaskManager;
/*    */ import com.android.build.gradle.internal.VariantModel;
/*    */ import com.android.build.gradle.internal.api.BaseVariantImpl;
/*    */ import com.android.build.gradle.internal.api.FeatureVariantImpl;
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.dsl.BuildType;
/*    */ import com.android.build.gradle.internal.dsl.ProductFlavor;
/*    */ import com.android.build.gradle.internal.dsl.SigningConfig;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import com.android.builder.core.VariantType;
/*    */ import com.android.builder.profile.Recorder;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.util.Collection;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ 
/*    */ public class FeatureVariantFactory
/*    */   extends BaseVariantFactory
/*    */ {
/*    */   public FeatureVariantFactory(GlobalScope globalScope, AndroidBuilder androidBuilder, AndroidConfig extension)
/*    */   {
/* 46 */     super(globalScope, androidBuilder, extension);
/*    */   }
/*    */   
/*    */   public BaseVariantData createVariantData(GradleVariantConfiguration variantConfiguration, TaskManager taskManager, Recorder recorder)
/*    */   {
/* 55 */     return new FeatureVariantData(globalScope, extension, taskManager, variantConfiguration, recorder);
/*    */   }
/*    */   
/*    */   public Class<? extends BaseVariantImpl> getVariantImplementationClass(BaseVariantData variantData)
/*    */   {
/* 67 */     return FeatureVariantImpl.class;
/*    */   }
/*    */   
/*    */   public Collection<VariantType> getVariantConfigurationTypes()
/*    */   {
/* 73 */     return ImmutableList.of(VariantType.FEATURE);
/*    */   }
/*    */   
/*    */   public boolean hasTestScope()
/*    */   {
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public void validateModel(VariantModel model) {}
/*    */   
/*    */   public void createDefaultComponents(NamedDomainObjectContainer<BuildType> buildTypes, NamedDomainObjectContainer<ProductFlavor> productFlavors, NamedDomainObjectContainer<SigningConfig> signingConfigs)
/*    */   {
/* 91 */     signingConfigs.create("debug");
/* 92 */     buildTypes.create("debug");
/* 93 */     buildTypes.create("release");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.FeatureVariantFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */