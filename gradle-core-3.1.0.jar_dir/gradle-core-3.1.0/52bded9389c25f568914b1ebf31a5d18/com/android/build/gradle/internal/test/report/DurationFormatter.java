/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ public class DurationFormatter
/*    */ {
/*    */   public static final int MILLIS_PER_SECOND = 1000;
/*    */   public static final int MILLIS_PER_MINUTE = 60000;
/*    */   public static final int MILLIS_PER_HOUR = 3600000;
/*    */   public static final int MILLIS_PER_DAY = 86400000;
/*    */   
/*    */   public String format(long duration)
/*    */   {
/* 27 */     if (duration == 0L) {
/* 28 */       return "0s";
/*    */     }
/*    */     
/* 31 */     StringBuilder result = new StringBuilder();
/*    */     
/* 33 */     long days = duration / 86400000L;
/* 34 */     duration %= 86400000L;
/* 35 */     if (days > 0L) {
/* 36 */       result.append(days);
/* 37 */       result.append("d");
/*    */     }
/* 39 */     long hours = duration / 3600000L;
/* 40 */     duration %= 3600000L;
/* 41 */     if ((hours > 0L) || (result.length() > 0)) {
/* 42 */       result.append(hours);
/* 43 */       result.append("h");
/*    */     }
/* 45 */     long minutes = duration / 60000L;
/* 46 */     duration %= 60000L;
/* 47 */     if ((minutes > 0L) || (result.length() > 0)) {
/* 48 */       result.append(minutes);
/* 49 */       result.append("m");
/*    */     }
/* 51 */     int secondsScale = result.length() > 0 ? 2 : 3;
/* 52 */     result.append(BigDecimal.valueOf(duration).divide(BigDecimal.valueOf(1000L)).setScale(secondsScale, 4));
/* 53 */     result.append("s");
/* 54 */     return result.toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.DurationFormatter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */