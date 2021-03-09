/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.builder.model.BuildType;
/*     */ import com.android.builder.model.SigningConfig;
/*     */ 
/*     */ public class ReadOnlyBuildType
/*     */   extends ReadOnlyBaseConfig
/*     */   implements BuildType
/*     */ {
/*     */   private final BuildType buildType;
/*     */   private final ReadOnlyObjectProvider readOnlyObjectProvider;
/*     */   
/*     */   public ReadOnlyBuildType(BuildType buildType, ReadOnlyObjectProvider readOnlyObjectProvider)
/*     */   {
/*  50 */     super(buildType);
/*  51 */     this.buildType = buildType;
/*  52 */     this.readOnlyObjectProvider = readOnlyObjectProvider;
/*     */   }
/*     */   
/*     */   public boolean isDebuggable()
/*     */   {
/*  57 */     return buildType.isDebuggable();
/*     */   }
/*     */   
/*     */   public boolean isTestCoverageEnabled()
/*     */   {
/*  62 */     return buildType.isTestCoverageEnabled();
/*     */   }
/*     */   
/*     */   public boolean isJniDebuggable()
/*     */   {
/*  67 */     return buildType.isJniDebuggable();
/*     */   }
/*     */   
/*     */   public boolean isPseudoLocalesEnabled()
/*     */   {
/*  72 */     return buildType.isPseudoLocalesEnabled();
/*     */   }
/*     */   
/*     */   public boolean isRenderscriptDebuggable()
/*     */   {
/*  77 */     return buildType.isRenderscriptDebuggable();
/*     */   }
/*     */   
/*     */   public int getRenderscriptOptimLevel()
/*     */   {
/*  82 */     return buildType.getRenderscriptOptimLevel();
/*     */   }
/*     */   
/*     */   public String getVersionNameSuffix()
/*     */   {
/*  88 */     return buildType.getVersionNameSuffix();
/*     */   }
/*     */   
/*     */   public boolean isMinifyEnabled()
/*     */   {
/*  93 */     return buildType.isMinifyEnabled();
/*     */   }
/*     */   
/*     */   public boolean isZipAlignEnabled()
/*     */   {
/*  98 */     return buildType.isZipAlignEnabled();
/*     */   }
/*     */   
/*     */   public boolean isEmbedMicroApp()
/*     */   {
/* 103 */     return buildType.isEmbedMicroApp();
/*     */   }
/*     */   
/*     */   public SigningConfig getSigningConfig()
/*     */   {
/* 109 */     return readOnlyObjectProvider.getSigningConfig(buildType.getSigningConfig());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ReadOnlyBuildType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */