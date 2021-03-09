/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.BuildType;
/*     */ import com.android.builder.model.SigningConfig;
/*     */ import java.io.Serializable;
/*     */ import java.util.Objects;
/*     */ 
/*     */ final class BuildTypeImpl
/*     */   extends BaseConfigImpl
/*     */   implements BuildType, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String name;
/*     */   private final boolean debuggable;
/*     */   private final boolean testCoverageEnabled;
/*     */   private final boolean jniDebuggable;
/*     */   private final boolean pseudoLocalesEnabled;
/*     */   private final boolean renderscriptDebuggable;
/*     */   private final int renderscriptOptimLevel;
/*     */   private final String versionNameSuffix;
/*     */   private final boolean minifyEnabled;
/*     */   private final boolean zipAlignEnabled;
/*     */   private final boolean embedMicroApp;
/*     */   
/*     */   BuildTypeImpl(BuildType buildType)
/*     */   {
/*  50 */     super(buildType);
/*  51 */     name = buildType.getName();
/*  52 */     debuggable = buildType.isDebuggable();
/*  53 */     testCoverageEnabled = buildType.isTestCoverageEnabled();
/*  54 */     jniDebuggable = buildType.isJniDebuggable();
/*  55 */     pseudoLocalesEnabled = buildType.isPseudoLocalesEnabled();
/*  56 */     renderscriptDebuggable = buildType.isRenderscriptDebuggable();
/*  57 */     renderscriptOptimLevel = buildType.getRenderscriptOptimLevel();
/*  58 */     versionNameSuffix = buildType.getVersionNameSuffix();
/*  59 */     minifyEnabled = buildType.isMinifyEnabled();
/*  60 */     zipAlignEnabled = buildType.isZipAlignEnabled();
/*  61 */     embedMicroApp = buildType.isEmbedMicroApp();
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  67 */     return name;
/*     */   }
/*     */   
/*     */   public boolean isDebuggable()
/*     */   {
/*  72 */     return debuggable;
/*     */   }
/*     */   
/*     */   public boolean isTestCoverageEnabled()
/*     */   {
/*  77 */     return testCoverageEnabled;
/*     */   }
/*     */   
/*     */   public boolean isJniDebuggable()
/*     */   {
/*  82 */     return jniDebuggable;
/*     */   }
/*     */   
/*     */   public boolean isRenderscriptDebuggable()
/*     */   {
/*  87 */     return renderscriptDebuggable;
/*     */   }
/*     */   
/*     */   public boolean isPseudoLocalesEnabled()
/*     */   {
/*  92 */     return pseudoLocalesEnabled;
/*     */   }
/*     */   
/*     */   public int getRenderscriptOptimLevel()
/*     */   {
/*  97 */     return renderscriptOptimLevel;
/*     */   }
/*     */   
/*     */   public String getVersionNameSuffix()
/*     */   {
/* 103 */     return versionNameSuffix;
/*     */   }
/*     */   
/*     */   public boolean isMinifyEnabled()
/*     */   {
/* 108 */     return minifyEnabled;
/*     */   }
/*     */   
/*     */   public boolean isZipAlignEnabled()
/*     */   {
/* 113 */     return zipAlignEnabled;
/*     */   }
/*     */   
/*     */   public boolean isEmbedMicroApp()
/*     */   {
/* 118 */     return embedMicroApp;
/*     */   }
/*     */   
/*     */   public SigningConfig getSigningConfig()
/*     */   {
/* 124 */     return null;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 129 */     return 
/*     */     
/* 140 */       "BuildTypeImpl{name='" + name + '\'' + ", debuggable=" + debuggable + ", testCoverageEnabled=" + testCoverageEnabled + ", jniDebuggable=" + jniDebuggable + ", renderscriptDebuggable=" + renderscriptDebuggable + ", renderscriptOptimLevel=" + renderscriptOptimLevel + ", versionNameSuffix='" + versionNameSuffix + '\'' + ", minifyEnabled=" + minifyEnabled + ", zipAlignEnabled=" + zipAlignEnabled + ", embedMicroApp=" + embedMicroApp + "} " + super.toString();
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 145 */     if (this == o) {
/* 146 */       return true;
/*     */     }
/* 148 */     if ((o == null) || (getClass() != o.getClass())) {
/* 149 */       return false;
/*     */     }
/* 151 */     if (!super.equals(o)) {
/* 152 */       return false;
/*     */     }
/* 154 */     BuildTypeImpl buildType = (BuildTypeImpl)o;
/* 155 */     if ((debuggable == debuggable) && (testCoverageEnabled == testCoverageEnabled) && (jniDebuggable == jniDebuggable) && (pseudoLocalesEnabled == pseudoLocalesEnabled) && (renderscriptDebuggable == renderscriptDebuggable) && (renderscriptOptimLevel == renderscriptOptimLevel) && (minifyEnabled == minifyEnabled) && (zipAlignEnabled == zipAlignEnabled) && (embedMicroApp == embedMicroApp)) {} return 
/*     */     
/* 164 */       (Objects.equals(name, name)) && 
/* 165 */       (Objects.equals(versionNameSuffix, versionNameSuffix));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 170 */     return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), name, Boolean.valueOf(debuggable), Boolean.valueOf(testCoverageEnabled), Boolean.valueOf(jniDebuggable), 
/* 171 */       Boolean.valueOf(pseudoLocalesEnabled), Boolean.valueOf(renderscriptDebuggable), Integer.valueOf(renderscriptOptimLevel), versionNameSuffix, 
/*     */       
/* 173 */       Boolean.valueOf(minifyEnabled), Boolean.valueOf(zipAlignEnabled), Boolean.valueOf(embedMicroApp) });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.BuildTypeImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */