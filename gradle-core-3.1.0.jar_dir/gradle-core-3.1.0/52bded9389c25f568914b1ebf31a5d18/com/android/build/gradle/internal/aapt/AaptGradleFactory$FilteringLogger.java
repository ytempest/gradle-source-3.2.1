/*     */ package com.android.build.gradle.internal.aapt;
/*     */ 
/*     */ import com.android.utils.ILogger;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class AaptGradleFactory$FilteringLogger
/*     */   implements ILogger
/*     */ {
/* 102 */   private static final List<Pattern> IGNORED_WARNINGS = Lists.newArrayList(new Pattern[] {
/* 103 */     Pattern.compile("Not recognizing known sRGB profile that has been edited") });
/*     */   
/*     */   private final ILogger mDelegate;
/*     */   
/*     */   public AaptGradleFactory$FilteringLogger(ILogger delegate)
/*     */   {
/* 117 */     mDelegate = delegate;
/*     */   }
/*     */   
/*     */   public void error(Throwable t, String msgFormat, Object... args)
/*     */   {
/* 122 */     if ((msgFormat != null) && (shouldDowngrade(msgFormat, args))) {
/* 123 */       mDelegate.info(Strings.nullToEmpty(msgFormat), args);
/*     */     } else {
/* 125 */       mDelegate.error(t, msgFormat, args);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warning(String msgFormat, Object... args)
/*     */   {
/* 131 */     if (shouldDowngrade(msgFormat, args)) {
/* 132 */       mDelegate.info(msgFormat, args);
/*     */     } else {
/* 134 */       mDelegate.warning(msgFormat, args);
/*     */     }
/*     */   }
/*     */   
/*     */   public void info(String msgFormat, Object... args)
/*     */   {
/* 140 */     mDelegate.info(msgFormat, args);
/*     */   }
/*     */   
/*     */   public void verbose(String msgFormat, Object... args)
/*     */   {
/* 145 */     mDelegate.verbose(msgFormat, args);
/*     */   }
/*     */   
/*     */   private static boolean shouldDowngrade(String msgFormat, Object... args)
/*     */   {
/* 156 */     String message = String.format(msgFormat, args);
/* 157 */     for (Pattern pattern : IGNORED_WARNINGS) {
/* 158 */       if (pattern.matcher(message).find()) {
/* 159 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 163 */     return false;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.aapt.AaptGradleFactory.FilteringLogger
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */