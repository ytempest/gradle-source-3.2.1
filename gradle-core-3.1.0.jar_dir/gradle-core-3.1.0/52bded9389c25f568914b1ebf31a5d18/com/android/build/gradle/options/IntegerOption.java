/*     */ package com.android.build.gradle.options;
/*     */ 
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ 
/*     */ public enum IntegerOption
/*     */   implements Option<Integer>
/*     */ {
/*  25 */   ANDROID_TEST_SHARD_COUNT("android.androidTest.numShards"), 
/*  26 */   ANDROID_SDK_CHANNEL("android.sdk.channel"), 
/*     */   
/*  40 */   IDE_BUILD_MODEL_ONLY_VERSION("android.injected.build.model.only.versioned"), 
/*     */   
/*  48 */   IDE_TARGET_DEVICE_API("android.injected.build.api"), 
/*     */   
/*  50 */   IDE_VERSION_CODE_OVERRIDE("android.injected.version.code"), 
/*     */   
/*  56 */   DEXING_READ_BUFFER_SIZE("android.dexingReadBuffer.size"), 
/*  57 */   DEXING_WRITE_BUFFER_SIZE("android.dexingWriteBuffer.size");
/*     */   
/*     */   private final String propertyName;
/*     */   private final DeprecationReporter.DeprecationTarget deprecationTarget;
/*     */   
/*     */   private IntegerOption(String propertyName) {
/*  63 */     this(propertyName, null);
/*     */   }
/*     */   
/*     */   private IntegerOption(String propertyName, DeprecationReporter.DeprecationTarget deprecationTarget)
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
/*     */   public Integer getDefaultValue()
/*     */   {
/*  82 */     return null;
/*     */   }
/*     */   
/*     */   public Integer parse(Object value)
/*     */   {
/*  88 */     if ((value instanceof CharSequence)) {
/*     */       try {
/*  90 */         return Integer.valueOf(Integer.parseInt(value.toString()));
/*     */       }
/*     */       catch (NumberFormatException localNumberFormatException) {}
/*     */     }
/*     */     
/*  95 */     if ((value instanceof Number)) {
/*  96 */       return Integer.valueOf(((Number)value).intValue());
/*     */     }
/*     */     
/* 104 */     throw new IllegalArgumentException("Cannot parse project property " + getPropertyName() + "='" + value + "' of type '" + value.getClass() + "' as integer.");
/*     */   }
/*     */   
/*     */   public boolean isDeprecated()
/*     */   {
/* 110 */     return deprecationTarget != null;
/*     */   }
/*     */   
/*     */   public DeprecationReporter.DeprecationTarget getDeprecationTarget()
/*     */   {
/* 116 */     return deprecationTarget;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.IntegerOption
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */