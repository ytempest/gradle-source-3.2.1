/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.core.DefaultVectorDrawablesOptions;
/*     */ import com.android.builder.model.ApiVersion;
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import com.android.builder.model.SigningConfig;
/*     */ import com.android.builder.model.VectorDrawablesOptions;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ 
/*     */ final class ProductFlavorImpl
/*     */   extends BaseConfigImpl
/*     */   implements ProductFlavor, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String name;
/*     */   private final String mDimension;
/*     */   private final ApiVersion mMinSdkVersion;
/*     */   private final ApiVersion mTargetSdkVersion;
/*     */   private final Integer mMaxSdkVersion;
/*     */   private final Integer mRenderscriptTargetApi;
/*     */   private final Boolean mRenderscriptSupportMode;
/*     */   private final Boolean mRenderscriptSupportModeBlas;
/*     */   private final Boolean mRenderscriptNdkMode;
/*     */   private final Integer mVersionCode;
/*     */   private final String mVersionName;
/*     */   private final String mApplicationId;
/*     */   private final String mTestApplicationId;
/*     */   private final String mTestInstrumentationRunner;
/*     */   private final Map<String, String> mTestInstrumentationRunnerArguments;
/*     */   private final Boolean mTestHandleProfiling;
/*     */   private final Boolean mTestFunctionalTest;
/*     */   private final Set<String> mResourceConfigurations;
/*     */   private final DefaultVectorDrawablesOptions mVectorDrawablesOptions;
/*     */   private final Boolean mWearAppUnbundled;
/*     */   
/*     */   public ProductFlavorImpl(ProductFlavor productFlavor)
/*     */   {
/*  67 */     super(productFlavor);
/*     */     
/*  69 */     name = productFlavor.getName();
/*  70 */     mDimension = productFlavor.getDimension();
/*  71 */     mMinSdkVersion = ApiVersionImpl.clone(productFlavor.getMinSdkVersion());
/*  72 */     mTargetSdkVersion = ApiVersionImpl.clone(productFlavor.getTargetSdkVersion());
/*  73 */     mMaxSdkVersion = productFlavor.getMaxSdkVersion();
/*  74 */     mRenderscriptTargetApi = productFlavor.getRenderscriptTargetApi();
/*  75 */     mRenderscriptSupportMode = productFlavor.getRenderscriptSupportModeEnabled();
/*  76 */     mRenderscriptSupportModeBlas = productFlavor.getRenderscriptSupportModeBlasEnabled();
/*  77 */     mRenderscriptNdkMode = productFlavor.getRenderscriptNdkModeEnabled();
/*     */     
/*  79 */     mVersionCode = productFlavor.getVersionCode();
/*  80 */     mVersionName = productFlavor.getVersionName();
/*     */     
/*  82 */     mApplicationId = productFlavor.getApplicationId();
/*     */     
/*  84 */     mTestApplicationId = productFlavor.getTestApplicationId();
/*  85 */     mTestInstrumentationRunner = productFlavor.getTestInstrumentationRunner();
/*  86 */     mTestHandleProfiling = productFlavor.getTestHandleProfiling();
/*  87 */     mTestFunctionalTest = productFlavor.getTestFunctionalTest();
/*     */     
/*  89 */     mResourceConfigurations = ImmutableSet.copyOf(productFlavor
/*  90 */       .getResourceConfigurations());
/*     */     
/*  92 */     mTestInstrumentationRunnerArguments = Maps.newHashMap(productFlavor
/*  93 */       .getTestInstrumentationRunnerArguments());
/*     */     
/*  96 */     mVectorDrawablesOptions = DefaultVectorDrawablesOptions.copyOf(productFlavor.getVectorDrawables());
/*     */     
/*  98 */     mWearAppUnbundled = productFlavor.getWearAppUnbundled();
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 104 */     return name;
/*     */   }
/*     */   
/*     */   public String getApplicationId()
/*     */   {
/* 110 */     return mApplicationId;
/*     */   }
/*     */   
/*     */   public Integer getVersionCode()
/*     */   {
/* 116 */     return mVersionCode;
/*     */   }
/*     */   
/*     */   public String getVersionName()
/*     */   {
/* 122 */     return mVersionName;
/*     */   }
/*     */   
/*     */   public ApiVersion getMinSdkVersion()
/*     */   {
/* 128 */     return mMinSdkVersion;
/*     */   }
/*     */   
/*     */   public ApiVersion getTargetSdkVersion()
/*     */   {
/* 134 */     return mTargetSdkVersion;
/*     */   }
/*     */   
/*     */   public Integer getMaxSdkVersion()
/*     */   {
/* 139 */     return mMaxSdkVersion;
/*     */   }
/*     */   
/*     */   public Integer getRenderscriptTargetApi()
/*     */   {
/* 144 */     return mRenderscriptTargetApi;
/*     */   }
/*     */   
/*     */   public Boolean getRenderscriptSupportModeEnabled()
/*     */   {
/* 150 */     return mRenderscriptSupportMode;
/*     */   }
/*     */   
/*     */   public Boolean getRenderscriptSupportModeBlasEnabled()
/*     */   {
/* 156 */     return mRenderscriptSupportModeBlas;
/*     */   }
/*     */   
/*     */   public Boolean getRenderscriptNdkModeEnabled()
/*     */   {
/* 162 */     return mRenderscriptNdkMode;
/*     */   }
/*     */   
/*     */   public String getTestApplicationId()
/*     */   {
/* 168 */     return mTestApplicationId;
/*     */   }
/*     */   
/*     */   public String getTestInstrumentationRunner()
/*     */   {
/* 174 */     return mTestInstrumentationRunner;
/*     */   }
/*     */   
/*     */   public Map<String, String> getTestInstrumentationRunnerArguments()
/*     */   {
/* 180 */     return mTestInstrumentationRunnerArguments;
/*     */   }
/*     */   
/*     */   public Boolean getTestHandleProfiling()
/*     */   {
/* 186 */     return mTestHandleProfiling;
/*     */   }
/*     */   
/*     */   public Boolean getTestFunctionalTest()
/*     */   {
/* 192 */     return mTestFunctionalTest;
/*     */   }
/*     */   
/*     */   public Collection<String> getResourceConfigurations()
/*     */   {
/* 198 */     return mResourceConfigurations;
/*     */   }
/*     */   
/*     */   public SigningConfig getSigningConfig()
/*     */   {
/* 204 */     return null;
/*     */   }
/*     */   
/*     */   public VectorDrawablesOptions getVectorDrawables()
/*     */   {
/* 210 */     return mVectorDrawablesOptions;
/*     */   }
/*     */   
/*     */   public Boolean getWearAppUnbundled()
/*     */   {
/* 216 */     return mWearAppUnbundled;
/*     */   }
/*     */   
/*     */   public String getDimension()
/*     */   {
/* 222 */     return mDimension;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 227 */     if (this == o) {
/* 228 */       return true;
/*     */     }
/* 230 */     if ((o == null) || (getClass() != o.getClass())) {
/* 231 */       return false;
/*     */     }
/* 233 */     if (!super.equals(o)) {
/* 234 */       return false;
/*     */     }
/* 236 */     ProductFlavorImpl that = (ProductFlavorImpl)o;
/* 237 */     if ((Objects.equals(name, name)) && 
/* 238 */       (Objects.equals(mDimension, mDimension)) && 
/* 239 */       (Objects.equals(mMinSdkVersion, mMinSdkVersion)) && 
/* 240 */       (Objects.equals(mTargetSdkVersion, mTargetSdkVersion)) && 
/* 241 */       (Objects.equals(mMaxSdkVersion, mMaxSdkVersion)) && 
/* 242 */       (Objects.equals(mRenderscriptTargetApi, mRenderscriptTargetApi)) && 
/* 243 */       (Objects.equals(mRenderscriptSupportMode, mRenderscriptSupportMode)))
/*     */     {
/* 245 */       if ((!Objects.equals(mRenderscriptSupportModeBlas, mRenderscriptSupportModeBlas)) || 
/* 246 */         (!Objects.equals(mRenderscriptNdkMode, mRenderscriptNdkMode)) || 
/* 247 */         (!Objects.equals(mVersionCode, mVersionCode)) || 
/* 248 */         (!Objects.equals(mVersionName, mVersionName)) || 
/* 249 */         (!Objects.equals(mApplicationId, mApplicationId)) || 
/* 250 */         (!Objects.equals(mTestApplicationId, mTestApplicationId)) || 
/* 251 */         (!Objects.equals(mTestInstrumentationRunner, mTestInstrumentationRunner)) || 
/* 252 */         (!Objects.equals(mTestInstrumentationRunnerArguments, mTestInstrumentationRunnerArguments))) {}
/*     */     }
/* 237 */     return 
/*     */     
/* 254 */       (Objects.equals(mTestHandleProfiling, mTestHandleProfiling)) && 
/* 255 */       (Objects.equals(mTestFunctionalTest, mTestFunctionalTest)) && 
/* 256 */       (Objects.equals(mResourceConfigurations, mResourceConfigurations)) && 
/* 257 */       (Objects.equals(mVectorDrawablesOptions, mVectorDrawablesOptions)) && 
/* 258 */       (Objects.equals(mWearAppUnbundled, mWearAppUnbundled));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 263 */     return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), name, mDimension, mMinSdkVersion, mTargetSdkVersion, mMaxSdkVersion, mRenderscriptTargetApi, mRenderscriptSupportMode, mRenderscriptSupportModeBlas, mRenderscriptNdkMode, mVersionCode, mVersionName, mApplicationId, mTestApplicationId, mTestInstrumentationRunner, mTestInstrumentationRunnerArguments, mTestHandleProfiling, mTestFunctionalTest, mResourceConfigurations, mVectorDrawablesOptions, mWearAppUnbundled });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 273 */     return 
/*     */     
/* 294 */       MoreObjects.toStringHelper(this).add("name", name).add("mDimension", mDimension).add("mMinSdkVersion", mMinSdkVersion).add("mTargetSdkVersion", mTargetSdkVersion).add("mMaxSdkVersion", mMaxSdkVersion).add("mRenderscriptTargetApi", mRenderscriptTargetApi).add("mRenderscriptSupportMode", mRenderscriptSupportMode).add("mRenderscriptSupportModeBlas", mRenderscriptSupportModeBlas).add("mRenderscriptNdkMode", mRenderscriptNdkMode).add("mVersionCode", mVersionCode).add("mVersionName", mVersionName).add("mApplicationId", mApplicationId).add("mTestApplicationId", mTestApplicationId).add("mTestInstrumentationRunner", mTestInstrumentationRunner).add("mTestInstrumentationRunnerArguments", mTestInstrumentationRunnerArguments).add("mTestHandleProfiling", mTestHandleProfiling).add("mTestFunctionalTest", mTestFunctionalTest).add("mResourceConfigurations", mResourceConfigurations).add("mVectorDrawablesOptions", mVectorDrawablesOptions).add("mWearAppUnbundled", mWearAppUnbundled).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.ProductFlavorImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */