/*    */ package com.android.build.gradle.internal.packaging;
/*    */ 
/*    */ import com.android.build.gradle.internal.LoggerWrapper;
/*    */ import com.android.builder.signing.DefaultSigningConfig;
/*    */ import com.android.ide.common.signing.KeystoreHelper;
/*    */ import com.android.ide.common.signing.KeytoolException;
/*    */ import com.android.prefs.AndroidLocation.AndroidLocationException;
/*    */ import com.android.utils.ILogger;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.JvmName;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.InvalidUserDataException;
/*    */ import org.gradle.api.logging.Logger;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000\026\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\032\030\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\005H\007\032\006\020\006\032\0020\003¨\006\007"}, d2={"createDefaultDebugStore", "", "defaultDebugKeystoreLocation", "Ljava/io/File;", "logger", "Lorg/gradle/api/logging/Logger;", "getDefaultDebugKeystoreLocation", "gradle-core"})
/*    */ @JvmName(name="GradleKeystoreHelper")
/*    */ public final class GradleKeystoreHelper
/*    */ {
/*    */   @NotNull
/*    */   public static final File getDefaultDebugKeystoreLocation()
/*    */   {
/*    */     File localFile;
/*    */     try
/*    */     {
/* 31 */       localFile = new File(KeystoreHelper.defaultDebugKeystoreLocation());
/*    */     } catch (AndroidLocation.AndroidLocationException e) {
/* 33 */       throw ((Throwable)new InvalidUserDataException("Failed to get default debug keystore location.", (Throwable)e)); }
/* 34 */     return localFile;
/*    */   }
/*    */   
/*    */   public static final void createDefaultDebugStore(@NotNull File defaultDebugKeystoreLocation, @NotNull Logger logger) throws IOException {
/* 38 */     Intrinsics.checkParameterIsNotNull(defaultDebugKeystoreLocation, "defaultDebugKeystoreLocation");Intrinsics.checkParameterIsNotNull(logger, "logger");DefaultSigningConfig signingConfig = DefaultSigningConfig.debugSigningConfig(defaultDebugKeystoreLocation);
/* 39 */     logger.info(
/* 40 */       "Creating default debug keystore at {}", 
/* 41 */       defaultDebugKeystoreLocation.getAbsolutePath());
/*    */     try
/*    */     {
/* 44 */       DefaultSigningConfig tmp31_30 = signingConfig;Intrinsics.checkExpressionValueIsNotNull(tmp31_30, "signingConfig"); File 
/* 45 */         tmp44_41 = signingConfig.getStoreFile();
/* 45 */       if (tmp44_41 == null) Intrinsics.throwNpe();
/* 46 */       String tmp55_52 = signingConfig.getStorePassword();
/*    */       
/* 46 */       if (tmp55_52 == null) Intrinsics.throwNpe();
/* 47 */       String tmp66_63 = signingConfig.getKeyPassword();
/*    */       
/* 47 */       if (tmp66_63 == null) Intrinsics.throwNpe();
/* 48 */       String tmp77_74 = signingConfig.getKeyAlias();
/*    */       
/* 48 */       if (tmp77_74 == null) Intrinsics.throwNpe();
/* 43 */       if (!KeystoreHelper.createDebugStore(
/* 44 */         tmp31_30.getStoreType(), 
/* 45 */         tmp44_41, 
/* 46 */         tmp55_52, 
/* 47 */         tmp66_63, 
/* 48 */         tmp77_74, 
/* 49 */         (ILogger)new LoggerWrapper(logger))) {
/* 50 */         throw ((Throwable)new IOException("Unable to create missing debug keystore."));
/*    */       }
/*    */     } catch (KeytoolException e) {
/* 53 */       throw ((Throwable)new IOException((Throwable)e));
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.packaging.GradleKeystoreHelper
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */