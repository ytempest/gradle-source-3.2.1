/*    */ package com.android.build.gradle.options;
/*    */ 
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*    */ 
/*    */ public enum OptionalBooleanOption
/*    */   implements Option<Boolean>
/*    */ {
/* 25 */   SIGNING_V1_ENABLED("android.injected.signing.v1-enabled"), 
/* 26 */   SIGNING_V2_ENABLED("android.injected.signing.v2-enabled"), 
/* 27 */   IDE_TEST_ONLY("android.injected.testOnly"), 
/* 28 */   SERIAL_AAPT2("android.injected.aapt2.serial");
/*    */   
/*    */   private final String propertyName;
/*    */   private final DeprecationReporter.DeprecationTarget deprecationTarget;
/*    */   
/*    */   private OptionalBooleanOption(String propertyName)
/*    */   {
/* 35 */     this(propertyName, null);
/*    */   }
/*    */   
/*    */   private OptionalBooleanOption(String propertyName, DeprecationReporter.DeprecationTarget deprecationTarget)
/*    */   {
/* 41 */     this.propertyName = propertyName;
/* 42 */     this.deprecationTarget = deprecationTarget;
/*    */   }
/*    */   
/*    */   public String getPropertyName()
/*    */   {
/* 48 */     return propertyName;
/*    */   }
/*    */   
/*    */   public Boolean getDefaultValue()
/*    */   {
/* 54 */     return null;
/*    */   }
/*    */   
/*    */   public Boolean parse(Object value)
/*    */   {
/* 60 */     if ((value instanceof CharSequence)) {
/* 61 */       return Boolean.valueOf(Boolean.parseBoolean(value.toString()));
/*    */     }
/* 63 */     if ((value instanceof Boolean)) {
/* 64 */       return (Boolean)value;
/*    */     }
/* 66 */     if ((value instanceof Number)) {
/* 67 */       return Boolean.valueOf(((Number)value).intValue() != 0);
/*    */     }
/*    */     
/* 75 */     throw new IllegalArgumentException("Cannot parse project property " + getPropertyName() + "='" + value + "' of type '" + value.getClass() + "' as boolean.");
/*    */   }
/*    */   
/*    */   public boolean isDeprecated()
/*    */   {
/* 81 */     return deprecationTarget != null;
/*    */   }
/*    */   
/*    */   public DeprecationReporter.DeprecationTarget getDeprecationTarget()
/*    */   {
/* 87 */     return deprecationTarget;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.OptionalBooleanOption
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */