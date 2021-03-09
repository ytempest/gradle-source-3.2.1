/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.builder.model.ApiVersion;
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import com.android.builder.model.SigningConfig;
/*     */ import com.android.builder.model.VectorDrawablesOptions;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class ReadOnlyProductFlavor
/*     */   extends ReadOnlyBaseConfig
/*     */   implements ProductFlavor
/*     */ {
/*     */   final ProductFlavor productFlavor;
/*     */   private final ReadOnlyObjectProvider readOnlyObjectProvider;
/*     */   
/*     */   ReadOnlyProductFlavor(ProductFlavor productFlavor, ReadOnlyObjectProvider readOnlyObjectProvider)
/*     */   {
/*  56 */     super(productFlavor);
/*  57 */     this.productFlavor = productFlavor;
/*  58 */     this.readOnlyObjectProvider = readOnlyObjectProvider;
/*     */   }
/*     */   
/*     */   public String getApplicationId()
/*     */   {
/*  64 */     return productFlavor.getApplicationId();
/*     */   }
/*     */   
/*     */   public Integer getVersionCode()
/*     */   {
/*  70 */     return productFlavor.getVersionCode();
/*     */   }
/*     */   
/*     */   public String getVersionName()
/*     */   {
/*  76 */     return productFlavor.getVersionName();
/*     */   }
/*     */   
/*     */   public ApiVersion getMinSdkVersion()
/*     */   {
/*  82 */     return productFlavor.getMinSdkVersion();
/*     */   }
/*     */   
/*     */   public ApiVersion getTargetSdkVersion()
/*     */   {
/*  88 */     return productFlavor.getTargetSdkVersion();
/*     */   }
/*     */   
/*     */   public Integer getMaxSdkVersion()
/*     */   {
/*  94 */     return productFlavor.getMaxSdkVersion();
/*     */   }
/*     */   
/*     */   public Integer getRenderscriptTargetApi()
/*     */   {
/* 100 */     return productFlavor.getRenderscriptTargetApi();
/*     */   }
/*     */   
/*     */   public Boolean getRenderscriptSupportModeEnabled()
/*     */   {
/* 106 */     return productFlavor.getRenderscriptSupportModeEnabled();
/*     */   }
/*     */   
/*     */   public Boolean getRenderscriptSupportModeBlasEnabled()
/*     */   {
/* 112 */     return productFlavor.getRenderscriptSupportModeBlasEnabled();
/*     */   }
/*     */   
/*     */   public Boolean getRenderscriptNdkModeEnabled()
/*     */   {
/* 118 */     return productFlavor.getRenderscriptNdkModeEnabled();
/*     */   }
/*     */   
/*     */   public String getTestApplicationId()
/*     */   {
/* 124 */     return productFlavor.getTestApplicationId();
/*     */   }
/*     */   
/*     */   public String getTestInstrumentationRunner()
/*     */   {
/* 130 */     return productFlavor.getTestInstrumentationRunner();
/*     */   }
/*     */   
/*     */   public Map<String, String> getTestInstrumentationRunnerArguments()
/*     */   {
/* 136 */     return ImmutableMap.copyOf(productFlavor.getTestInstrumentationRunnerArguments());
/*     */   }
/*     */   
/*     */   public Boolean getTestHandleProfiling()
/*     */   {
/* 142 */     return productFlavor.getTestHandleProfiling();
/*     */   }
/*     */   
/*     */   public Boolean getTestFunctionalTest()
/*     */   {
/* 148 */     return productFlavor.getTestFunctionalTest();
/*     */   }
/*     */   
/*     */   public Collection<String> getResourceConfigurations()
/*     */   {
/* 154 */     return ImmutableList.copyOf(productFlavor.getResourceConfigurations());
/*     */   }
/*     */   
/*     */   public SigningConfig getSigningConfig()
/*     */   {
/* 160 */     return readOnlyObjectProvider.getSigningConfig(productFlavor.getSigningConfig());
/*     */   }
/*     */   
/*     */   public VectorDrawablesOptions getVectorDrawables()
/*     */   {
/* 166 */     return new ReadOnlyVectorDrawablesOptions(productFlavor.getVectorDrawables());
/*     */   }
/*     */   
/*     */   public String getDimension()
/*     */   {
/* 172 */     return productFlavor.getDimension();
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public String getFlavorDimension()
/*     */   {
/* 178 */     return productFlavor.getDimension();
/*     */   }
/*     */   
/*     */   public Boolean getWearAppUnbundled()
/*     */   {
/* 184 */     return productFlavor.getWearAppUnbundled();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ReadOnlyProductFlavor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */