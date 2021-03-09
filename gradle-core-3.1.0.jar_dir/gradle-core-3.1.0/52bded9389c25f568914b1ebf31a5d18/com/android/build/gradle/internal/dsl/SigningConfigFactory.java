/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import com.android.builder.signing.DefaultSigningConfig;
/*    */ import java.io.File;
/*    */ import org.gradle.api.NamedDomainObjectFactory;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public class SigningConfigFactory
/*    */   implements NamedDomainObjectFactory<SigningConfig>
/*    */ {
/*    */   private final ObjectFactory objectFactory;
/*    */   private final File defaultDebugKeystoreLocation;
/*    */   
/*    */   public SigningConfigFactory(ObjectFactory objectFactory, File defaultDebugKeystoreLocation)
/*    */   {
/* 33 */     this.objectFactory = objectFactory;
/* 34 */     this.defaultDebugKeystoreLocation = defaultDebugKeystoreLocation;
/*    */   }
/*    */   
/*    */   public SigningConfig create(String name)
/*    */   {
/* 40 */     SigningConfig signingConfig = (SigningConfig)objectFactory.newInstance(SigningConfig.class, new Object[] { name });
/* 41 */     if ("debug".equals(name)) {
/* 42 */       signingConfig.initWith(
/* 43 */         DefaultSigningConfig.debugSigningConfig(defaultDebugKeystoreLocation));
/*    */     }
/* 45 */     return signingConfig;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.SigningConfigFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */