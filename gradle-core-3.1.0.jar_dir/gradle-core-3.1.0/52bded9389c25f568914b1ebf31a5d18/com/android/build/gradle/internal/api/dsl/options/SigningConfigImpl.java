/*     */ package com.android.build.gradle.internal.api.dsl.options;
/*     */ 
/*     */ import com.android.build.api.dsl.options.SigningConfig;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import java.io.File;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000:\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\013\n\002\020\013\n\002\b\n\n\002\020\002\n\002\b\005\b\007\030\0002\0020\0012\0020\002B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b¢\006\002\020\tJ\b\020(\032\0020\004H\026J\020\020)\032\0020*2\006\020+\032\0020\002H\026J\b\020,\032\0020\037H\026J\b\020-\032\0020\037H\026J\b\020.\032\0020\037H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R(\020\013\032\004\030\0010\0042\b\020\n\032\004\030\0010\004@VX\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R(\020\020\032\004\030\0010\0042\b\020\n\032\004\030\0010\004@VX\016¢\006\016\n\000\032\004\b\021\020\r\"\004\b\022\020\017R\016\020\003\032\0020\004X\004¢\006\002\n\000R(\020\024\032\004\030\0010\0232\b\020\n\032\004\030\0010\023@VX\016¢\006\016\n\000\032\004\b\025\020\026\"\004\b\027\020\030R(\020\031\032\004\030\0010\0042\b\020\n\032\004\030\0010\004@VX\016¢\006\016\n\000\032\004\b\032\020\r\"\004\b\033\020\017R(\020\034\032\004\030\0010\0042\b\020\n\032\004\030\0010\004@VX\016¢\006\016\n\000\032\004\b\035\020\r\"\004\b\036\020\017R$\020 \032\0020\0372\006\020\n\032\0020\037@VX\016¢\006\016\n\000\032\004\b!\020\"\"\004\b#\020$R$\020%\032\0020\0372\006\020\n\032\0020\037@VX\016¢\006\016\n\000\032\004\b&\020\"\"\004\b'\020$¨\006/"}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/SigningConfigImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/options/SigningConfig;", "named", "", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/lang/String;Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)V", "value", "keyAlias", "getKeyAlias", "()Ljava/lang/String;", "setKeyAlias", "(Ljava/lang/String;)V", "keyPassword", "getKeyPassword", "setKeyPassword", "Ljava/io/File;", "storeFile", "getStoreFile", "()Ljava/io/File;", "setStoreFile", "(Ljava/io/File;)V", "storePassword", "getStorePassword", "setStorePassword", "storeType", "getStoreType", "setStoreType", "", "v1SigningEnabled", "getV1SigningEnabled", "()Z", "setV1SigningEnabled", "(Z)V", "v2SigningEnabled", "getV2SigningEnabled", "setV2SigningEnabled", "getName", "initWith", "", "that", "isSigningReady", "isV1SigningEnabled", "isV2SigningEnabled", "gradle-core"})
/*     */ public final class SigningConfigImpl
/*     */   extends SealableObject
/*     */   implements SigningConfig
/*     */ {
/*     */   @Nullable
/*     */   private File storeFile;
/*     */   @Nullable
/*     */   private String storePassword;
/*     */   @Nullable
/*     */   private String keyAlias;
/*     */   @Nullable
/*     */   private String keyPassword;
/*     */   @Nullable
/*     */   private String storeType;
/*     */   private boolean v1SigningEnabled;
/*     */   private boolean v2SigningEnabled;
/*     */   private final String named;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   
/*     */   @NotNull
/*  32 */   public String getName() { return named; }
/*     */   @Nullable
/*  34 */   public File getStoreFile() { return storeFile; }
/*     */   
/*  36 */   public void setStoreFile(@Nullable File value) { if (checkSeal())
/*  37 */       storeFile = value;
/*     */   }
/*     */   
/*     */   @Nullable
/*  41 */   public String getStorePassword() { return storePassword; }
/*     */   
/*  43 */   public void setStorePassword(@Nullable String value) { if (checkSeal())
/*  44 */       storePassword = value;
/*     */   }
/*     */   
/*     */   @Nullable
/*  48 */   public String getKeyAlias() { return keyAlias; }
/*     */   
/*  50 */   public void setKeyAlias(@Nullable String value) { if (checkSeal())
/*  51 */       keyAlias = value;
/*     */   }
/*     */   
/*     */   @Nullable
/*  55 */   public String getKeyPassword() { return keyPassword; }
/*     */   
/*  57 */   public void setKeyPassword(@Nullable String value) { if (checkSeal())
/*  58 */       keyPassword = value;
/*     */   }
/*     */   
/*     */   @Nullable
/*  62 */   public String getStoreType() { return storeType; }
/*     */   
/*  64 */   public void setStoreType(@Nullable String value) { if (checkSeal()) {
/*  65 */       storeType = value;
/*     */     }
/*     */   }
/*     */   
/*  69 */   public boolean getV1SigningEnabled() { return v1SigningEnabled; }
/*     */   
/*  71 */   public void setV1SigningEnabled(boolean value) { if (checkSeal())
/*  72 */       v1SigningEnabled = value;
/*     */   }
/*     */   
/*     */   public boolean getV2SigningEnabled() {
/*  76 */     return v2SigningEnabled;
/*     */   }
/*     */   
/*     */   public SigningConfigImpl(@NotNull String named, @NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  30 */     super(issueReporter);this.named = named;this.deprecationReporter = deprecationReporter;
/*     */     
/*  69 */     v1SigningEnabled = true;
/*     */     
/*  76 */     v2SigningEnabled = true; }
/*     */   
/*  78 */   public void setV2SigningEnabled(boolean value) { if (checkSeal()) {
/*  79 */       v2SigningEnabled = value;
/*     */     }
/*     */   }
/*     */   
/*  83 */   public boolean isSigningReady() { return (getStoreFile() != null) && (getStorePassword() != null) && (getKeyAlias() != null) && (getKeyPassword() != null); }
/*     */   
/*     */   public boolean isV1SigningEnabled() {
/*  86 */     deprecationReporter.reportDeprecatedUsage(
/*  87 */       "SigningConfig.v1SigningEnabled", 
/*  88 */       "SigningConfig.isV1SigningEnabled()", 
/*  89 */       com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget.OLD_DSL);
/*  90 */     return getV1SigningEnabled();
/*     */   }
/*     */   
/*     */   public boolean isV2SigningEnabled() {
/*  94 */     deprecationReporter.reportDeprecatedUsage(
/*  95 */       "SigningConfig.v2SigningEnabled", 
/*  96 */       "SigningConfig.isV2SigningEnabled()", 
/*  97 */       com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget.OLD_DSL);
/*  98 */     return getV2SigningEnabled();
/*     */   }
/*     */   
/*     */   public void initWith(@NotNull SigningConfig that) {
/* 102 */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(that, "that"); if (checkSeal()) {
/* 103 */       setStoreFile(that.getStoreFile());
/* 104 */       setStorePassword(that.getStorePassword());
/* 105 */       setKeyAlias(that.getKeyAlias());
/* 106 */       setKeyPassword(that.getKeyPassword());
/* 107 */       setV1SigningEnabled(that.getV1SigningEnabled());
/* 108 */       setV2SigningEnabled(that.getV2SigningEnabled());
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.SigningConfigImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */