/*     */ package com.android.build.gradle.options;
/*     */ 
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ 
/*     */  enum EnumOptions$EnumOption
/*     */   implements Option<String>
/*     */ {
/*  87 */   AAPT_OPTIONS_NAMESPACING("android.aaptNamespacing");
/*     */   
/*     */   private final String propertyName;
/*     */   private final DeprecationReporter.DeprecationTarget deprecationTarget;
/*     */   
/*     */   private EnumOptions$EnumOption(String propertyName)
/*     */   {
/*  94 */     this(propertyName, null);
/*     */   }
/*     */   
/*     */   private EnumOptions$EnumOption(String propertyName, DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */   {
/* 100 */     this.propertyName = propertyName;
/* 101 */     this.deprecationTarget = deprecationTarget;
/*     */   }
/*     */   
/*     */   public String getPropertyName()
/*     */   {
/* 107 */     return propertyName;
/*     */   }
/*     */   
/*     */   public String getDefaultValue()
/*     */   {
/* 113 */     return null;
/*     */   }
/*     */   
/*     */   public String parse(Object value)
/*     */   {
/* 119 */     if (((value instanceof CharSequence)) || ((value instanceof Number))) {
/* 120 */       return value.toString();
/*     */     }
/*     */     
/* 128 */     throw new IllegalArgumentException("Cannot parse project property " + getPropertyName() + "='" + value + "' of type '" + value.getClass() + "' as string to be interpreted as an enum constant.");
/*     */   }
/*     */   
/*     */   public boolean isDeprecated()
/*     */   {
/* 134 */     return deprecationTarget != null;
/*     */   }
/*     */   
/*     */   public DeprecationReporter.DeprecationTarget getDeprecationTarget()
/*     */   {
/* 140 */     return deprecationTarget;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.EnumOptions.EnumOption
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */