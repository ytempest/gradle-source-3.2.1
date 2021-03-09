/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.builder.signing.DefaultSigningConfig;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Named;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFile;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ 
/*     */ public class SigningConfig
/*     */   extends DefaultSigningConfig
/*     */   implements Serializable, Named, CoreSigningConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   @Inject
/*     */   public SigningConfig(String name)
/*     */   {
/*  44 */     super(name);
/*     */   }
/*     */   
/*     */   public SigningConfig initWith(com.android.builder.model.SigningConfig that) {
/*  48 */     setStoreFile(that.getStoreFile());
/*  49 */     setStorePassword(that.getStorePassword());
/*  50 */     setKeyAlias(that.getKeyAlias());
/*  51 */     setKeyPassword(that.getKeyPassword());
/*  52 */     setV1SigningEnabled(that.isV1SigningEnabled());
/*  53 */     setV2SigningEnabled(that.isV2SigningEnabled());
/*  54 */     setStoreType(that.getStoreType());
/*  55 */     return this;
/*     */   }
/*     */   
/*     */   @InputFile
/*     */   @Optional
/*     */   public File getStoreFile()
/*     */   {
/*  68 */     return super.getStoreFile();
/*     */   }
/*     */   
/*     */   @Input
/*     */   public String getStorePassword()
/*     */   {
/*  81 */     return super.getStorePassword();
/*     */   }
/*     */   
/*     */   @Input
/*     */   public String getKeyAlias()
/*     */   {
/*  94 */     return super.getKeyAlias();
/*     */   }
/*     */   
/*     */   @Input
/*     */   public String getKeyPassword()
/*     */   {
/* 107 */     return super.getKeyPassword();
/*     */   }
/*     */   
/*     */   @Input
/*     */   public String getStoreType()
/*     */   {
/* 120 */     return super.getStoreType();
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isV1SigningEnabled()
/*     */   {
/* 133 */     return super.isV1SigningEnabled();
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isV2SigningEnabled()
/*     */   {
/* 146 */     return super.isV2SigningEnabled();
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 151 */     return 
/*     */     
/* 160 */       MoreObjects.toStringHelper(this).add("name", mName).add("storeFile", getStoreFile() != null ? getStoreFile().getAbsolutePath() : "null").add("storePassword", getStorePassword()).add("keyAlias", getKeyAlias()).add("keyPassword", getKeyPassword()).add("storeType", getStoreFile()).add("v1SigningEnabled", isV1SigningEnabled()).add("v2SigningEnabled", isV2SigningEnabled()).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.SigningConfig
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */