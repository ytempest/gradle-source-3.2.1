/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.builder.model.BuildType;
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import com.android.builder.model.SigningConfig;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class ReadOnlyObjectProvider
/*     */ {
/*     */   private ReadOnlyProductFlavor readOnlyDefaultConfig;
/*     */   private final Map<BuildType, BuildType> readOnlyBuildTypes;
/*     */   private final Map<ProductFlavor, ProductFlavor> readOnlyFlavors;
/*     */   
/*     */   public ReadOnlyObjectProvider()
/*     */   {
/*  42 */     readOnlyBuildTypes = Maps.newIdentityHashMap();
/*     */     
/*  48 */     readOnlyFlavors = Maps.newIdentityHashMap();
/*     */   }
/*     */   
/*  54 */   private final Map<SigningConfig, SigningConfig> readOnlySigningConfig = Maps.newIdentityHashMap();
/*     */   
/*     */   ProductFlavor getDefaultConfig(ProductFlavor defaultConfig)
/*     */   {
/*  62 */     if (readOnlyDefaultConfig != null) {
/*  63 */       if (readOnlyDefaultConfig.productFlavor != defaultConfig) {
/*  64 */         throw new IllegalStateException("Different DefaultConfigs passed to ApiObjectProvider");
/*     */       }
/*     */     } else {
/*  67 */       readOnlyDefaultConfig = new ReadOnlyProductFlavor(defaultConfig, this);
/*     */     }
/*     */     
/*  70 */     return readOnlyDefaultConfig;
/*     */   }
/*     */   
/*     */   public BuildType getBuildType(BuildType buildType)
/*     */   {
/*  80 */     BuildType readOnlyBuildType = (BuildType)readOnlyBuildTypes.get(buildType);
/*  81 */     if (readOnlyBuildType == null) {
/*  82 */       readOnlyBuildTypes.put(buildType, readOnlyBuildType = new ReadOnlyBuildType(buildType, this));
/*     */     }
/*     */     
/*  86 */     return readOnlyBuildType;
/*     */   }
/*     */   
/*     */   public ProductFlavor getProductFlavor(ProductFlavor productFlavor)
/*     */   {
/*  96 */     ProductFlavor readOnlyProductFlavor = (ProductFlavor)readOnlyFlavors.get(productFlavor);
/*  97 */     if (readOnlyProductFlavor == null) {
/*  98 */       readOnlyFlavors.put(productFlavor, readOnlyProductFlavor = new ReadOnlyProductFlavor(productFlavor, this));
/*     */     }
/*     */     
/* 103 */     return readOnlyProductFlavor;
/*     */   }
/*     */   
/*     */   public SigningConfig getSigningConfig(SigningConfig signingConfig)
/*     */   {
/* 113 */     if (signingConfig == null) {
/* 114 */       return null;
/*     */     }
/*     */     
/* 117 */     SigningConfig readOnlySigningConfig = (SigningConfig)this.readOnlySigningConfig.get(signingConfig);
/* 118 */     if (readOnlySigningConfig == null) {
/* 119 */       this.readOnlySigningConfig.put(signingConfig, readOnlySigningConfig = new ReadOnlySigningConfig(signingConfig));
/*     */     }
/*     */     
/* 123 */     return readOnlySigningConfig;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ReadOnlyObjectProvider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */