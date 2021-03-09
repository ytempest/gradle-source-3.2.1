/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.builder.model.SigningConfig;
/*    */ import java.io.File;
/*    */ 
/*    */ public class ReadOnlySigningConfig
/*    */   implements SigningConfig
/*    */ {
/*    */   private final SigningConfig signingConfig;
/*    */   
/*    */   ReadOnlySigningConfig(SigningConfig signingConfig)
/*    */   {
/* 43 */     this.signingConfig = signingConfig;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 49 */     return signingConfig.getName();
/*    */   }
/*    */   
/*    */   public File getStoreFile()
/*    */   {
/* 55 */     return signingConfig.getStoreFile();
/*    */   }
/*    */   
/*    */   public String getStorePassword()
/*    */   {
/* 61 */     return signingConfig.getStorePassword();
/*    */   }
/*    */   
/*    */   public String getKeyAlias()
/*    */   {
/* 67 */     return signingConfig.getKeyAlias();
/*    */   }
/*    */   
/*    */   public String getKeyPassword()
/*    */   {
/* 73 */     return signingConfig.getKeyPassword();
/*    */   }
/*    */   
/*    */   public String getStoreType()
/*    */   {
/* 79 */     return signingConfig.getStoreType();
/*    */   }
/*    */   
/*    */   public boolean isV1SigningEnabled()
/*    */   {
/* 84 */     return signingConfig.isV1SigningEnabled();
/*    */   }
/*    */   
/*    */   public boolean isV2SigningEnabled()
/*    */   {
/* 89 */     return signingConfig.isV2SigningEnabled();
/*    */   }
/*    */   
/*    */   public boolean isSigningReady()
/*    */   {
/* 94 */     return signingConfig.isSigningReady();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ReadOnlySigningConfig
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */