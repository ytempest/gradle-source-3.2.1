/*     */ package com.android.build.gradle.internal.aapt;
/*     */ 
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.internal.aapt.Aapt;
/*     */ import com.android.builder.internal.aapt.v1.AaptV1;
/*     */ import com.android.builder.internal.aapt.v1.AaptV1.PngProcessMode;
/*     */ import com.android.builder.internal.aapt.v2.QueueableAapt2;
/*     */ import com.android.builder.sdk.TargetInfo;
/*     */ import com.android.ide.common.process.LoggedProcessOutputHandler;
/*     */ import com.android.ide.common.process.ProcessOutputHandler;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import com.android.utils.ILogger;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public final class AaptGradleFactory
/*     */ {
/*     */   public static Aapt make(AaptGeneration aaptGeneration, AndroidBuilder builder, ProcessOutputHandler outputHandler, boolean crunchPng, File intermediateDir, int cruncherProcesses)
/*     */   {
/*  65 */     TargetInfo target = builder.getTargetInfo();
/*  66 */     Preconditions.checkNotNull(target, "target == null");
/*  67 */     BuildToolInfo buildTools = target.getBuildTools();
/*     */     
/*  69 */     if (outputHandler == null)
/*     */     {
/*  72 */       outputHandler = new LoggedProcessOutputHandler(new FilteringLogger(builder.getLogger()));
/*     */     }
/*     */     
/*  75 */     switch (aaptGeneration) {
/*     */     case AAPT_V1: 
/*  77 */       return new AaptV1(builder
/*  78 */         .getProcessExecutor(), outputHandler, buildTools, new FilteringLogger(builder
/*     */         
/*  81 */         .getLogger()), crunchPng ? AaptV1.PngProcessMode.ALL : AaptV1.PngProcessMode.NO_CRUNCH, cruncherProcesses);
/*     */     
/*     */     case AAPT_V2_DAEMON_MODE: 
/*  85 */       return new QueueableAapt2(outputHandler, buildTools, new FilteringLogger(builder
/*     */       
/*  88 */         .getLogger()), 0);
/*     */     }
/*     */     
/*  91 */     throw new IllegalArgumentException("unknown aapt generation" + aaptGeneration);
/*     */   }
/*     */   
/*     */   public static class FilteringLogger
/*     */     implements ILogger
/*     */   {
/* 102 */     private static final List<Pattern> IGNORED_WARNINGS = Lists.newArrayList(new Pattern[] {
/* 103 */       Pattern.compile("Not recognizing known sRGB profile that has been edited") });
/*     */     
/*     */     private final ILogger mDelegate;
/*     */     
/*     */     public FilteringLogger(ILogger delegate)
/*     */     {
/* 117 */       mDelegate = delegate;
/*     */     }
/*     */     
/*     */     public void error(Throwable t, String msgFormat, Object... args)
/*     */     {
/* 122 */       if ((msgFormat != null) && (shouldDowngrade(msgFormat, args))) {
/* 123 */         mDelegate.info(Strings.nullToEmpty(msgFormat), args);
/*     */       } else {
/* 125 */         mDelegate.error(t, msgFormat, args);
/*     */       }
/*     */     }
/*     */     
/*     */     public void warning(String msgFormat, Object... args)
/*     */     {
/* 131 */       if (shouldDowngrade(msgFormat, args)) {
/* 132 */         mDelegate.info(msgFormat, args);
/*     */       } else {
/* 134 */         mDelegate.warning(msgFormat, args);
/*     */       }
/*     */     }
/*     */     
/*     */     public void info(String msgFormat, Object... args)
/*     */     {
/* 140 */       mDelegate.info(msgFormat, args);
/*     */     }
/*     */     
/*     */     public void verbose(String msgFormat, Object... args)
/*     */     {
/* 145 */       mDelegate.verbose(msgFormat, args);
/*     */     }
/*     */     
/*     */     private static boolean shouldDowngrade(String msgFormat, Object... args)
/*     */     {
/* 156 */       String message = String.format(msgFormat, args);
/* 157 */       for (Pattern pattern : IGNORED_WARNINGS) {
/* 158 */         if (pattern.matcher(message).find()) {
/* 159 */           return true;
/*     */         }
/*     */       }
/*     */       
/* 163 */       return false;
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.aapt.AaptGradleFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */