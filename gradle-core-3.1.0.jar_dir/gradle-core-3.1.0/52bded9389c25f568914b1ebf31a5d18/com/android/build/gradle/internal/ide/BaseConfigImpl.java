/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.BaseConfig;
/*     */ import com.android.builder.model.ClassField;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ 
/*     */ abstract class BaseConfigImpl
/*     */   implements BaseConfig, Serializable
/*     */ {
/*     */   private final String mApplicationIdSuffix;
/*     */   private final String mVersionNameSuffix;
/*     */   private final Map<String, Object> mManifestPlaceholders;
/*     */   private final Map<String, ClassField> mBuildConfigFields;
/*     */   private final Map<String, ClassField> mResValues;
/*     */   private final Boolean mMultiDexEnabled;
/*     */   private final File mMultiDexKeepFile;
/*     */   private final File mMultiDexKeepProguard;
/*     */   
/*     */   protected BaseConfigImpl(BaseConfig baseConfig)
/*     */   {
/*  58 */     mApplicationIdSuffix = baseConfig.getApplicationIdSuffix();
/*  59 */     mVersionNameSuffix = baseConfig.getVersionNameSuffix();
/*  60 */     mManifestPlaceholders = ImmutableMap.copyOf(baseConfig.getManifestPlaceholders());
/*  61 */     mBuildConfigFields = ImmutableMap.copyOf(baseConfig.getBuildConfigFields());
/*  62 */     mResValues = ImmutableMap.copyOf(baseConfig.getResValues());
/*  63 */     mMultiDexEnabled = baseConfig.getMultiDexEnabled();
/*  64 */     mMultiDexKeepFile = baseConfig.getMultiDexKeepFile();
/*  65 */     mMultiDexKeepProguard = baseConfig.getMultiDexKeepProguard();
/*     */   }
/*     */   
/*     */   public String getApplicationIdSuffix()
/*     */   {
/*  71 */     return mApplicationIdSuffix;
/*     */   }
/*     */   
/*     */   public String getVersionNameSuffix()
/*     */   {
/*  77 */     return mVersionNameSuffix;
/*     */   }
/*     */   
/*     */   public Map<String, ClassField> getBuildConfigFields()
/*     */   {
/*  83 */     return mBuildConfigFields;
/*     */   }
/*     */   
/*     */   public Map<String, ClassField> getResValues()
/*     */   {
/*  89 */     return mResValues;
/*     */   }
/*     */   
/*     */   public List<File> getProguardFiles()
/*     */   {
/*  95 */     return Collections.emptyList();
/*     */   }
/*     */   
/*     */   public List<File> getConsumerProguardFiles()
/*     */   {
/* 101 */     return Collections.emptyList();
/*     */   }
/*     */   
/*     */   public Collection<File> getTestProguardFiles()
/*     */   {
/* 107 */     return Collections.emptyList();
/*     */   }
/*     */   
/*     */   public Map<String, Object> getManifestPlaceholders()
/*     */   {
/* 113 */     return mManifestPlaceholders;
/*     */   }
/*     */   
/*     */   public Boolean getMultiDexEnabled()
/*     */   {
/* 119 */     return mMultiDexEnabled;
/*     */   }
/*     */   
/*     */   public File getMultiDexKeepFile()
/*     */   {
/* 125 */     return mMultiDexKeepFile;
/*     */   }
/*     */   
/*     */   public File getMultiDexKeepProguard()
/*     */   {
/* 131 */     return mMultiDexKeepProguard;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 136 */     return "BaseConfigImpl{applicationIdSuffix='" + mApplicationIdSuffix + '\'' + ", versionNameSuffix='" + mVersionNameSuffix + '\'' + ", mManifestPlaceholders=" + mManifestPlaceholders + ", mBuildConfigFields=" + mBuildConfigFields + ", mResValues=" + mResValues + ", mMultiDexEnabled=" + mMultiDexEnabled + '}';
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 156 */     if (this == o) {
/* 157 */       return true;
/*     */     }
/* 159 */     if ((o == null) || (getClass() != o.getClass())) {
/* 160 */       return false;
/*     */     }
/* 162 */     BaseConfigImpl that = (BaseConfigImpl)o;
/* 163 */     return (Objects.equals(mApplicationIdSuffix, mApplicationIdSuffix)) && 
/* 164 */       (Objects.equals(mVersionNameSuffix, mVersionNameSuffix)) && 
/* 165 */       (Objects.equals(mManifestPlaceholders, mManifestPlaceholders)) && 
/* 166 */       (Objects.equals(mBuildConfigFields, mBuildConfigFields)) && 
/* 167 */       (Objects.equals(mResValues, mResValues)) && 
/* 168 */       (Objects.equals(mMultiDexEnabled, mMultiDexEnabled)) && 
/* 169 */       (Objects.equals(mMultiDexKeepFile, mMultiDexKeepFile)) && 
/* 170 */       (Objects.equals(mMultiDexKeepProguard, mMultiDexKeepProguard));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 175 */     return Objects.hash(new Object[] { mApplicationIdSuffix, mVersionNameSuffix, mManifestPlaceholders, mBuildConfigFields, mResValues, mMultiDexEnabled, mMultiDexKeepFile, mMultiDexKeepProguard });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.BaseConfigImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */