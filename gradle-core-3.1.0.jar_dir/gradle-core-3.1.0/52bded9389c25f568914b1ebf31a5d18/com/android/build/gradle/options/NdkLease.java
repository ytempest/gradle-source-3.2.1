/*    */ package com.android.build.gradle.options;
/*    */ 
/*    */ import java.time.Instant;
/*    */ 
/*    */ public final class NdkLease
/*    */ {
/*    */   public static final long DEPRECATED_NDK_COMPILE_LEASE_DAYS = 60L;
/*    */   public static final long DEPRECATED_NDK_COMPILE_LEASE_MILLIS = 5184000000L;
/*    */   
/*    */   public static long getFreshDeprecatedNdkCompileLease()
/*    */   {
/* 30 */     return Instant.now().toEpochMilli();
/*    */   }
/*    */   
/*    */   public static boolean isDeprecatedNdkCompileLeaseExpired(ProjectOptions options) {
/* 34 */     Long leaseDate = options.get(LongOption.DEPRECATED_NDK_COMPILE_LEASE);
/* 35 */     if (leaseDate == null)
/*    */     {
/* 37 */       return true;
/*    */     }
/* 39 */     long freshLease = getFreshDeprecatedNdkCompileLease();
/* 40 */     if (freshLease - leaseDate.longValue() > 5184000000L)
/*    */     {
/* 42 */       return true;
/*    */     }
/* 44 */     if (leaseDate.longValue() > freshLease)
/*    */     {
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.NdkLease
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */