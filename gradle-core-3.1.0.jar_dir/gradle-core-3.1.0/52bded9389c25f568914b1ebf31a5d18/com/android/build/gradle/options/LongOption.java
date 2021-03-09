/*    */ package com.android.build.gradle.options;
/*    */ 
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*    */ 
/*    */ public enum LongOption
/*    */   implements Option<Long>
/*    */ {
/* 24 */   DEPRECATED_NDK_COMPILE_LEASE("android.deprecatedNdkCompileLease");
/*    */   
/*    */   private final String propertyName;
/*    */   private final DeprecationReporter.DeprecationTarget deprecationTarget;
/*    */   
/*    */   private LongOption(String propertyName)
/*    */   {
/* 31 */     this(propertyName, null);
/*    */   }
/*    */   
/*    */   private LongOption(String propertyName, DeprecationReporter.DeprecationTarget deprecationTarget)
/*    */   {
/* 37 */     this.propertyName = propertyName;
/* 38 */     this.deprecationTarget = deprecationTarget;
/*    */   }
/*    */   
/*    */   public final String getPropertyName()
/*    */   {
/* 44 */     return propertyName;
/*    */   }
/*    */   
/*    */   public final Long getDefaultValue()
/*    */   {
/* 50 */     return null;
/*    */   }
/*    */   
/*    */   public final Long parse(Object value)
/*    */   {
/* 56 */     if ((value instanceof CharSequence)) {
/*    */       try {
/* 58 */         return Long.valueOf(Long.parseLong(value.toString()));
/*    */       }
/*    */       catch (NumberFormatException localNumberFormatException) {}
/*    */     }
/*    */     
/* 63 */     if ((value instanceof Number)) {
/* 64 */       return Long.valueOf(((Number)value).longValue());
/*    */     }
/*    */     
/* 72 */     throw new IllegalArgumentException("Cannot parse project property " + getPropertyName() + "='" + value + "' of type '" + value.getClass() + "' as long.");
/*    */   }
/*    */   
/*    */   public boolean isDeprecated()
/*    */   {
/* 78 */     return deprecationTarget != null;
/*    */   }
/*    */   
/*    */   public DeprecationReporter.DeprecationTarget getDeprecationTarget()
/*    */   {
/* 84 */     return deprecationTarget;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.LongOption
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */