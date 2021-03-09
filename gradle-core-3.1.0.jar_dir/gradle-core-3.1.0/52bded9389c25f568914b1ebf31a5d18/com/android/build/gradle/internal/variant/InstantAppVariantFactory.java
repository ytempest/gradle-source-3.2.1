/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.internal.TaskManager;
/*    */ import com.android.build.gradle.internal.VariantModel;
/*    */ import com.android.build.gradle.internal.api.BaseVariantImpl;
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.dsl.BuildType;
/*    */ import com.android.build.gradle.internal.dsl.ProductFlavor;
/*    */ import com.android.build.gradle.internal.dsl.SigningConfig;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.OutputFactory;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import com.android.builder.core.VariantType;
/*    */ import com.android.builder.profile.Recorder;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.util.Collection;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ 
/*    */ public class InstantAppVariantFactory
/*    */   extends BaseVariantFactory
/*    */ {
/*    */   public InstantAppVariantFactory(GlobalScope globalScope, AndroidBuilder androidBuilder, AndroidConfig extension)
/*    */   {
/* 47 */     super(globalScope, androidBuilder, extension);
/*    */   }
/*    */   
/*    */   public BaseVariantData createVariantData(GradleVariantConfiguration variantConfiguration, TaskManager taskManager, Recorder recorder)
/*    */   {
/* 56 */     InstantAppVariantData variant = new InstantAppVariantData(globalScope, extension, taskManager, variantConfiguration, recorder);
/*    */     
/* 63 */     variant.getOutputFactory().addMainApk();
/* 64 */     return variant;
/*    */   }
/*    */   
/*    */   public Class<? extends BaseVariantImpl> getVariantImplementationClass(BaseVariantData variantData)
/*    */   {
/* 71 */     return null;
/*    */   }
/*    */   
/*    */   public Collection<VariantType> getVariantConfigurationTypes()
/*    */   {
/* 77 */     return ImmutableList.of(VariantType.INSTANTAPP);
/*    */   }
/*    */   
/*    */   public boolean hasTestScope()
/*    */   {
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public void validateModel(VariantModel model) {}
/*    */   
/*    */   public void createDefaultComponents(NamedDomainObjectContainer<BuildType> buildTypes, NamedDomainObjectContainer<ProductFlavor> productFlavors, NamedDomainObjectContainer<SigningConfig> signingConfigs)
/*    */   {
/* 95 */     buildTypes.create("debug");
/* 96 */     buildTypes.create("release");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.InstantAppVariantFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */