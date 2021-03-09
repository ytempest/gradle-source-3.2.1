/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.SigningConfig;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Objects;
/*     */ 
/*     */ final class SigningConfigImpl
/*     */   implements SigningConfig, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String name;
/*     */   private final File storeFile;
/*     */   private final String storePassword;
/*     */   private final String keyAlias;
/*     */   private final String keyPassword;
/*     */   private final String storeType;
/*     */   private final boolean v1SigningEnabled;
/*     */   private final boolean v2SigningEnabled;
/*     */   private final boolean signingReady;
/*     */   
/*     */   static SigningConfig createSigningConfig(SigningConfig signingConfig)
/*     */   {
/*  54 */     return new SigningConfigImpl(signingConfig
/*  55 */       .getName(), signingConfig
/*  56 */       .getStoreFile(), signingConfig
/*  57 */       .getStorePassword(), signingConfig
/*  58 */       .getKeyAlias(), signingConfig
/*  59 */       .getKeyPassword(), signingConfig
/*  60 */       .getStoreType(), signingConfig
/*  61 */       .isV1SigningEnabled(), signingConfig
/*  62 */       .isV2SigningEnabled(), signingConfig
/*  63 */       .isSigningReady());
/*     */   }
/*     */   
/*     */   private SigningConfigImpl(String name, File storeFile, String storePassword, String keyAlias, String keyPassword, String storeType, boolean v1SigningEnabled, boolean v2SigningEnabled, boolean signingReady)
/*     */   {
/*  76 */     this.name = name;
/*  77 */     this.storeFile = storeFile;
/*  78 */     this.storePassword = storePassword;
/*  79 */     this.keyAlias = keyAlias;
/*  80 */     this.keyPassword = keyPassword;
/*  81 */     this.storeType = storeType;
/*  82 */     this.v1SigningEnabled = v1SigningEnabled;
/*  83 */     this.v2SigningEnabled = v2SigningEnabled;
/*  84 */     this.signingReady = signingReady;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  90 */     return name;
/*     */   }
/*     */   
/*     */   public File getStoreFile()
/*     */   {
/*  96 */     return storeFile;
/*     */   }
/*     */   
/*     */   public String getStorePassword()
/*     */   {
/* 102 */     return storePassword;
/*     */   }
/*     */   
/*     */   public String getKeyAlias()
/*     */   {
/* 108 */     return keyAlias;
/*     */   }
/*     */   
/*     */   public String getKeyPassword()
/*     */   {
/* 114 */     return keyPassword;
/*     */   }
/*     */   
/*     */   public String getStoreType()
/*     */   {
/* 120 */     return storeType;
/*     */   }
/*     */   
/*     */   public boolean isV1SigningEnabled()
/*     */   {
/* 125 */     return v1SigningEnabled;
/*     */   }
/*     */   
/*     */   public boolean isV2SigningEnabled()
/*     */   {
/* 130 */     return v2SigningEnabled;
/*     */   }
/*     */   
/*     */   public boolean isSigningReady()
/*     */   {
/* 135 */     return signingReady;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 140 */     if (this == o) {
/* 141 */       return true;
/*     */     }
/* 143 */     if ((o == null) || (getClass() != o.getClass())) {
/* 144 */       return false;
/*     */     }
/* 146 */     SigningConfigImpl that = (SigningConfigImpl)o;
/* 147 */     if ((v1SigningEnabled == v1SigningEnabled) && (v2SigningEnabled == v2SigningEnabled) && (signingReady == signingReady)) {} return 
/*     */     
/* 150 */       (Objects.equals(name, name)) && 
/* 151 */       (Objects.equals(storeFile, storeFile)) && 
/* 152 */       (Objects.equals(storePassword, storePassword)) && 
/* 153 */       (Objects.equals(keyAlias, keyAlias)) && 
/* 154 */       (Objects.equals(keyPassword, keyPassword)) && 
/* 155 */       (Objects.equals(storeType, storeType));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 160 */     return Objects.hash(new Object[] { name, storeFile, storePassword, keyAlias, keyPassword, storeType, 
/* 161 */       Boolean.valueOf(v1SigningEnabled), Boolean.valueOf(v2SigningEnabled), Boolean.valueOf(signingReady) });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 166 */     return 
/*     */     
/* 176 */       MoreObjects.toStringHelper(this).add("name", name).add("storeFile", storeFile).add("storePassword", storePassword).add("keyAlias", keyAlias).add("keyPassword", keyPassword).add("storeType", storeType).add("v1SigningEnabled", v1SigningEnabled).add("v2SigningEnabled", v2SigningEnabled).add("signingReady", signingReady).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.SigningConfigImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */