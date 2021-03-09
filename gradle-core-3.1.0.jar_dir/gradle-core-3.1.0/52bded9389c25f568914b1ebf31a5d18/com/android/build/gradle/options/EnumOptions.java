/*     */ package com.android.build.gradle.options;
/*     */ 
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ import com.android.builder.model.AaptOptions.Namespacing;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ 
/*     */ public final class EnumOptions
/*     */ {
/*     */   private final AaptOptions.Namespacing namespacing;
/*     */   
/*     */   EnumOptions(AaptOptions.Namespacing namespacing)
/*     */   {
/*  37 */     this.namespacing = namespacing;
/*     */   }
/*     */   
/*     */   public AaptOptions.Namespacing getNamespacing()
/*     */   {
/*  42 */     return namespacing;
/*     */   }
/*     */   
/*     */   private static <T extends Enum<T>> T get(ImmutableMap<EnumOption, String> options, EnumOption option, Class<T> enumClass)
/*     */   {
/*  50 */     String optionValue = (String)options.get(option);
/*  51 */     if (optionValue == null) {
/*  52 */       return null;
/*     */     }
/*     */     try {
/*  55 */       return Enum.valueOf(enumClass, optionValue);
/*     */     }
/*     */     catch (IllegalArgumentException e)
/*     */     {
/*  63 */       throw new IllegalArgumentException("Project property " + option.getPropertyName() + " is set to invalid value '" + optionValue + "'. Possible values are: " + Joiner.on(", ").join(enumClass.getEnumConstants()) + ".");
/*     */     }
/*     */   }
/*     */   
/*     */   static EnumOptions load(ImmutableMap<EnumOption, String> options)
/*     */   {
/*  70 */     AaptOptions.Namespacing namespacing = (AaptOptions.Namespacing)MoreObjects.firstNonNull(
/*  71 */       get(options, EnumOption.AAPT_OPTIONS_NAMESPACING, AaptOptions.Namespacing.class), AaptOptions.Namespacing.DISABLED);
/*     */     
/*  77 */     return new EnumOptions(namespacing);
/*     */   }
/*     */   
/*     */   static enum EnumOption
/*     */     implements Option<String>
/*     */   {
/*  87 */     AAPT_OPTIONS_NAMESPACING("android.aaptNamespacing");
/*     */     
/*     */     private final String propertyName;
/*     */     private final DeprecationReporter.DeprecationTarget deprecationTarget;
/*     */     
/*     */     private EnumOption(String propertyName)
/*     */     {
/*  94 */       this(propertyName, null);
/*     */     }
/*     */     
/*     */     private EnumOption(String propertyName, DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */     {
/* 100 */       this.propertyName = propertyName;
/* 101 */       this.deprecationTarget = deprecationTarget;
/*     */     }
/*     */     
/*     */     public String getPropertyName()
/*     */     {
/* 107 */       return propertyName;
/*     */     }
/*     */     
/*     */     public String getDefaultValue()
/*     */     {
/* 113 */       return null;
/*     */     }
/*     */     
/*     */     public String parse(Object value)
/*     */     {
/* 119 */       if (((value instanceof CharSequence)) || ((value instanceof Number))) {
/* 120 */         return value.toString();
/*     */       }
/*     */       
/* 128 */       throw new IllegalArgumentException("Cannot parse project property " + getPropertyName() + "='" + value + "' of type '" + value.getClass() + "' as string to be interpreted as an enum constant.");
/*     */     }
/*     */     
/*     */     public boolean isDeprecated()
/*     */     {
/* 134 */       return deprecationTarget != null;
/*     */     }
/*     */     
/*     */     public DeprecationReporter.DeprecationTarget getDeprecationTarget()
/*     */     {
/* 140 */       return deprecationTarget;
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.EnumOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */