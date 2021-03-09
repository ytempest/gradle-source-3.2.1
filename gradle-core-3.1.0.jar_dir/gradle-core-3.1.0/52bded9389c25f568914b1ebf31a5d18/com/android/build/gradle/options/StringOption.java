/*     */ package com.android.build.gradle.options;
/*     */ 
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ 
/*     */ public enum StringOption
/*     */   implements Option<String>
/*     */ {
/*  25 */   BUILD_CACHE_DIR("android.buildCacheDir"), 
/*     */   
/*  27 */   IDE_BUILD_TARGET_DENSITY("android.injected.build.density"), 
/*  28 */   IDE_BUILD_TARGET_ABI("android.injected.build.abi"), 
/*     */   
/*  30 */   IDE_RESTRICT_VARIANT_PROJECT("android.injected.restrict.variant.project"), 
/*  31 */   IDE_RESTRICT_VARIANT_NAME("android.injected.restrict.variant.name"), 
/*     */   
/*  34 */   IDE_SIGNING_STORE_TYPE("android.injected.signing.store.type"), 
/*  35 */   IDE_SIGNING_STORE_FILE("android.injected.signing.store.file"), 
/*  36 */   IDE_SIGNING_STORE_PASSWORD("android.injected.signing.store.password"), 
/*  37 */   IDE_SIGNING_KEY_ALIAS("android.injected.signing.key.alias"), 
/*  38 */   IDE_SIGNING_KEY_PASSWORD("android.injected.signing.key.password"), 
/*     */   
/*  40 */   IDE_APK_LOCATION("android.injected.apk.location"), 
/*     */   
/*  43 */   IDE_OPTIONAL_COMPILATION_STEPS("android.optional.compilation"), 
/*  44 */   IDE_COLD_SWAP_MODE("android.injected.coldswap.mode"), 
/*  45 */   IDE_VERSION_NAME_OVERRIDE("android.injected.version.name"), 
/*     */   
/*  47 */   IDE_TARGET_DEVICE_CODENAME("android.injected.build.codename"), 
/*     */   
/*  50 */   IDE_ANDROID_CUSTOM_CLASS_TRANSFORMS("android.advanced.profiling.transforms"), 
/*     */   
/*  53 */   DEVICE_POOL_SERIAL("com.android.test.devicepool.serial"), 
/*  54 */   PROFILE_OUTPUT_DIR("android.advanced.profileOutputDir"), 
/*     */   
/*  56 */   BUILD_ARTIFACT_REPORT_FILE("android.buildartifact.reportfile");
/*     */   
/*     */   private final String propertyName;
/*     */   private final DeprecationReporter.DeprecationTarget deprecationTarget;
/*     */   
/*     */   private StringOption(String propertyName)
/*     */   {
/*  63 */     this(propertyName, null);
/*     */   }
/*     */   
/*     */   private StringOption(String propertyName, DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */   {
/*  69 */     this.propertyName = propertyName;
/*  70 */     this.deprecationTarget = deprecationTarget;
/*     */   }
/*     */   
/*     */   public String getPropertyName()
/*     */   {
/*  76 */     return propertyName;
/*     */   }
/*     */   
/*     */   public String getDefaultValue()
/*     */   {
/*  82 */     return null;
/*     */   }
/*     */   
/*     */   public String parse(Object value)
/*     */   {
/*  88 */     if (((value instanceof CharSequence)) || ((value instanceof Number))) {
/*  89 */       return value.toString();
/*     */     }
/*     */     
/*  97 */     throw new IllegalArgumentException("Cannot parse project property " + getPropertyName() + "='" + value + "' of type '" + value.getClass() + "' as string.");
/*     */   }
/*     */   
/*     */   public boolean isDeprecated()
/*     */   {
/* 103 */     return deprecationTarget != null;
/*     */   }
/*     */   
/*     */   public DeprecationReporter.DeprecationTarget getDeprecationTarget()
/*     */   {
/* 109 */     return deprecationTarget;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.StringOption
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */