/*     */ package com.android.build.gradle.options;
/*     */ 
/*     */ public final class SigningOptions
/*     */ {
/*     */   private final String storeFile;
/*     */   
/*     */   private final String storePassword;
/*     */   
/*     */   private final String keyAlias;
/*     */   
/*     */   private final String keyPassword;
/*     */   
/*     */   private final String storeType;
/*     */   
/*     */   private final Boolean v1Enabled;
/*     */   
/*     */   private final Boolean v2Enabled;
/*     */   
/*     */   public static SigningOptions readSigningOptions(ProjectOptions options)
/*     */   {
/*  35 */     String signingStoreFile = options.get(StringOption.IDE_SIGNING_STORE_FILE);
/*  36 */     String signingStorePassword = options.get(StringOption.IDE_SIGNING_STORE_PASSWORD);
/*  37 */     String signingKeyAlias = options.get(StringOption.IDE_SIGNING_KEY_ALIAS);
/*  38 */     String signingKeyPassword = options.get(StringOption.IDE_SIGNING_KEY_PASSWORD);
/*     */     
/*  40 */     if ((signingStoreFile != null) && (signingStorePassword != null) && (signingKeyAlias != null) && (signingKeyPassword != null))
/*     */     {
/*  45 */       return new SigningOptions(signingStoreFile, signingStorePassword, signingKeyAlias, signingKeyPassword, options
/*     */       
/*  50 */         .get(StringOption.IDE_SIGNING_STORE_TYPE), options
/*  51 */         .get(OptionalBooleanOption.SIGNING_V1_ENABLED), options
/*  52 */         .get(OptionalBooleanOption.SIGNING_V2_ENABLED));
/*     */     }
/*     */     
/*  55 */     return null;
/*     */   }
/*     */   
/*     */   public SigningOptions(String storeFile, String storePassword, String keyAlias, String keyPassword, String storeType, Boolean v1Enabled, Boolean v2Enabled)
/*     */   {
/*  74 */     this.storeFile = storeFile;
/*  75 */     this.storeType = storeType;
/*  76 */     this.storePassword = storePassword;
/*  77 */     this.keyAlias = keyAlias;
/*  78 */     this.keyPassword = keyPassword;
/*  79 */     this.v1Enabled = v1Enabled;
/*  80 */     this.v2Enabled = v2Enabled;
/*     */   }
/*     */   
/*     */   public String getStoreFile()
/*     */   {
/*  85 */     return storeFile;
/*     */   }
/*     */   
/*     */   public String getStorePassword()
/*     */   {
/*  90 */     return storePassword;
/*     */   }
/*     */   
/*     */   public String getKeyAlias()
/*     */   {
/*  95 */     return keyAlias;
/*     */   }
/*     */   
/*     */   public String getKeyPassword()
/*     */   {
/* 100 */     return keyPassword;
/*     */   }
/*     */   
/*     */   public String getStoreType()
/*     */   {
/* 105 */     return storeType;
/*     */   }
/*     */   
/*     */   public Boolean getV1Enabled()
/*     */   {
/* 110 */     return v1Enabled;
/*     */   }
/*     */   
/*     */   public Boolean getV2Enabled()
/*     */   {
/* 115 */     return v2Enabled;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.SigningOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */