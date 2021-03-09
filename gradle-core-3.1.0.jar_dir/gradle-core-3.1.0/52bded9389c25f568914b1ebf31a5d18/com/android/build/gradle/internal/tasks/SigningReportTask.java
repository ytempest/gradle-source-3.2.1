/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.builder.model.SigningConfig;
/*     */ import com.android.ide.common.signing.CertificateInfo;
/*     */ import com.android.ide.common.signing.KeystoreHelper;
/*     */ import com.android.ide.common.signing.KeytoolException;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.security.cert.Certificate;
/*     */ import java.security.cert.CertificateEncodingException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.text.DateFormat;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.DefaultTask;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ import org.gradle.internal.logging.text.StyledTextOutput;
/*     */ import org.gradle.internal.logging.text.StyledTextOutput.Style;
/*     */ import org.gradle.internal.logging.text.StyledTextOutputFactory;
/*     */ import org.gradle.internal.service.ServiceRegistry;
/*     */ 
/*     */ public class SigningReportTask
/*     */   extends DefaultTask
/*     */ {
/*  54 */   private Set<VariantScope> variants = Sets.newHashSet();
/*     */   
/*     */   @TaskAction
/*     */   public void generate()
/*     */     throws IOException
/*     */   {
/*  60 */     StyledTextOutput textOutput = ((StyledTextOutputFactory)getServices().get(StyledTextOutputFactory.class)).create(getClass());
/*     */     
/*  62 */     Map<SigningConfig, SigningInfo> cache = Maps.newHashMap();
/*     */     
/*  64 */     for (VariantScope variant : variants) {
/*  65 */       textOutput.withStyle(StyledTextOutput.Style.Identifier).text("Variant: ");
/*  66 */       textOutput.withStyle(StyledTextOutput.Style.Description).text(variant.getFullVariantName());
/*  67 */       textOutput.println();
/*     */       
/*  70 */       SigningConfig signingConfig = variant.getVariantConfiguration().getSigningConfig();
/*  71 */       if (signingConfig == null) {
/*  72 */         textOutput.withStyle(StyledTextOutput.Style.Identifier).text("Config: ");
/*  73 */         textOutput.withStyle(StyledTextOutput.Style.Normal).text("none");
/*  74 */         textOutput.println();
/*     */       } else {
/*  76 */         SigningInfo signingInfo = getSigningInfo(signingConfig, cache);
/*     */         
/*  79 */         textOutput.withStyle(StyledTextOutput.Style.Identifier).text("Config: ");
/*  80 */         textOutput.withStyle(StyledTextOutput.Style.Description).text(signingConfig.getName());
/*  81 */         textOutput.println();
/*     */         
/*  83 */         textOutput.withStyle(StyledTextOutput.Style.Identifier).text("Store: ");
/*  84 */         textOutput.withStyle(StyledTextOutput.Style.Description).text(signingConfig.getStoreFile());
/*  85 */         textOutput.println();
/*     */         
/*  87 */         textOutput.withStyle(StyledTextOutput.Style.Identifier).text("Alias: ");
/*  88 */         textOutput.withStyle(StyledTextOutput.Style.Description).text(signingConfig.getKeyAlias());
/*  89 */         textOutput.println();
/*     */         
/*  91 */         if (signingInfo.isValid()) {
/*  92 */           if (error != null) {
/*  93 */             textOutput.withStyle(StyledTextOutput.Style.Identifier).text("Error: ");
/*  94 */             textOutput.withStyle(StyledTextOutput.Style.Failure).text(error);
/*  95 */             textOutput.println();
/*     */           } else {
/*  97 */             textOutput.withStyle(StyledTextOutput.Style.Identifier).text("MD5: ");
/*  98 */             textOutput.withStyle(StyledTextOutput.Style.Description).text(md5);
/*  99 */             textOutput.println();
/*     */             
/* 101 */             textOutput.withStyle(StyledTextOutput.Style.Identifier).text("SHA1: ");
/* 102 */             textOutput.withStyle(StyledTextOutput.Style.Description).text(sha1);
/* 103 */             textOutput.println();
/*     */             
/* 105 */             textOutput.withStyle(StyledTextOutput.Style.Identifier).text("Valid until: ");
/* 106 */             DateFormat df = DateFormat.getDateInstance(0);
/* 107 */             textOutput.withStyle(StyledTextOutput.Style.Description).text(df.format(notAfter));
/* 108 */             textOutput.println();
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 113 */       textOutput.withStyle(StyledTextOutput.Style.Normal).text("----------");
/* 114 */       textOutput.println();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setVariants(Collection<VariantScope> variants)
/*     */   {
/* 120 */     this.variants.addAll(variants);
/*     */   }
/*     */   
/*     */   private static SigningInfo getSigningInfo(SigningConfig signingConfig, Map<SigningConfig, SigningInfo> cache)
/*     */   {
/* 126 */     SigningInfo signingInfo = (SigningInfo)cache.get(signingConfig);
/*     */     
/* 128 */     if (signingInfo == null) {
/* 129 */       signingInfo = new SigningInfo(null);
/*     */       
/* 131 */       if (signingConfig.isSigningReady())
/*     */       {
/*     */         try
/*     */         {
/* 136 */           CertificateInfo certificateInfo = KeystoreHelper.getCertificateInfo(signingConfig
/* 137 */             .getStoreType(), signingConfig
/* 138 */             .getStoreFile(), signingConfig
/* 139 */             .getStorePassword(), signingConfig
/* 140 */             .getKeyPassword(), signingConfig
/* 141 */             .getKeyAlias());
/* 142 */           md5 = getFingerprint(certificateInfo.getCertificate(), "MD5");
/* 143 */           sha1 = getFingerprint(certificateInfo.getCertificate(), "SHA1");
/* 144 */           notAfter = certificateInfo.getCertificate().getNotAfter();
/*     */         } catch (KeytoolException e) {
/* 146 */           error = e.getMessage();
/*     */         } catch (FileNotFoundException e) {
/* 148 */           error = "Missing keystore";
/*     */         }
/*     */       }
/*     */       
/* 152 */       cache.put(signingConfig, signingInfo);
/*     */     }
/*     */     
/* 155 */     return signingInfo;
/*     */   }
/*     */   
/*     */   private static final class SigningInfo {
/*     */     String md5;
/*     */     String sha1;
/*     */     Date notAfter;
/*     */     String error;
/*     */     
/*     */     boolean isValid() {
/* 165 */       return (md5 != null) || (error != null);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getFingerprint(Certificate cert, String hashAlgorithm)
/*     */   {
/* 173 */     if (cert == null) {
/* 174 */       return null;
/*     */     }
/*     */     try {
/* 177 */       MessageDigest digest = MessageDigest.getInstance(hashAlgorithm);
/* 178 */       return toHexadecimalString(digest.digest(cert.getEncoded()));
/*     */     }
/*     */     catch (NoSuchAlgorithmException|CertificateEncodingException localNoSuchAlgorithmException) {}
/*     */     
/* 182 */     return null;
/*     */   }
/*     */   
/*     */   private static String toHexadecimalString(byte[] value) {
/* 186 */     StringBuilder sb = new StringBuilder();
/* 187 */     int len = value.length;
/* 188 */     for (int i = 0; i < len; i++) {
/* 189 */       int num = value[i] & 0xFF;
/* 190 */       if (num < 16) {
/* 191 */         sb.append('0');
/*     */       }
/* 193 */       sb.append(Integer.toHexString(num));
/* 194 */       if (i < len - 1) {
/* 195 */         sb.append(':');
/*     */       }
/*     */     }
/* 198 */     return sb.toString().toUpperCase(Locale.US);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.SigningReportTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */