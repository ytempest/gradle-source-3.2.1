/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.VariantConfiguration;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.model.BuildType;
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ public class VariantFilter
/*     */   implements com.android.build.gradle.api.VariantFilter
/*     */ {
/*     */   private final ReadOnlyObjectProvider readOnlyObjectProvider;
/*     */   private boolean ignore;
/*     */   private ProductFlavor defaultConfig;
/*     */   private BuildType buildType;
/*     */   private List<ProductFlavor> flavors;
/*     */   private VariantType type;
/*     */   private String name;
/*     */   
/*     */   public VariantFilter(ReadOnlyObjectProvider readOnlyObjectProvider)
/*     */   {
/*  46 */     this.readOnlyObjectProvider = readOnlyObjectProvider;
/*     */   }
/*     */   
/*     */   public void reset(ProductFlavor defaultConfig, BuildType buildType, VariantType type, List<ProductFlavor> flavors)
/*     */   {
/*  54 */     ignore = false;
/*  55 */     this.defaultConfig = defaultConfig;
/*  56 */     this.buildType = buildType;
/*  57 */     this.flavors = flavors;
/*  58 */     this.type = type;
/*  59 */     name = null;
/*     */   }
/*     */   
/*     */   public boolean isIgnore()
/*     */   {
/*  66 */     return ignore;
/*     */   }
/*     */   
/*     */   public void setIgnore(boolean ignore)
/*     */   {
/*  71 */     this.ignore = ignore;
/*     */   }
/*     */   
/*     */   public ProductFlavor getDefaultConfig()
/*     */   {
/*  83 */     return readOnlyObjectProvider.getDefaultConfig(defaultConfig);
/*     */   }
/*     */   
/*     */   public BuildType getBuildType()
/*     */   {
/*  95 */     return readOnlyObjectProvider.getBuildType(buildType);
/*     */   }
/*     */   
/*     */   public List<ProductFlavor> getFlavors()
/*     */   {
/* 107 */     return flavors != null ? new ImmutableFlavorList(flavors, readOnlyObjectProvider) : 
/*     */     
/* 109 */       Collections.emptyList();
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 115 */     if (name == null)
/*     */     {
/* 117 */       name = VariantConfiguration.computeFullName(
/* 118 */         VariantConfiguration.computeFlavorName(flavors), buildType, type, null);
/*     */     }
/*     */     
/* 124 */     return name;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.VariantFilter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */