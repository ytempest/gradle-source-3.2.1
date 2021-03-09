/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import com.android.ide.common.res2.MergingException;
/*     */ import com.android.utils.ILogger;
/*     */ import java.io.Serializable;
/*     */ import java.util.function.Supplier;
/*     */ import org.gradle.api.logging.LogLevel;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.logging.Logging;
/*     */ 
/*     */ public class LoggerWrapper
/*     */   implements ILogger
/*     */ {
/*  36 */   private static final LogLevel ILOGGER_ERROR = LogLevel.ERROR;
/*  37 */   private static final LogLevel ILOGGER_WARNING = LogLevel.WARN;
/*  38 */   private static final LogLevel ILOGGER_INFO = LogLevel.LIFECYCLE;
/*  39 */   private static final LogLevel ILOGGER_VERBOSE = LogLevel.INFO;
/*     */   
/*     */   private final Logger logger;
/*     */   
/*     */   public static LoggerWrapper getLogger(Class<?> klass)
/*     */   {
/*  45 */     return new LoggerWrapper(Logging.getLogger(klass));
/*     */   }
/*     */   
/*     */   public LoggerWrapper(Logger logger) {
/*  49 */     this.logger = logger;
/*     */   }
/*     */   
/*     */   public void error(Throwable throwable, String s, Object... objects)
/*     */   {
/*  54 */     if ((throwable instanceof MergingException))
/*     */     {
/*  62 */       return;
/*     */     }
/*     */     
/*  65 */     if (!logger.isEnabled(ILOGGER_ERROR)) {
/*  66 */       return;
/*     */     }
/*     */     
/*  69 */     if (s == null) {
/*  70 */       s = "[no message defined]";
/*  71 */     } else if ((objects != null) && (objects.length > 0)) {
/*  72 */       s = String.format(s, objects);
/*     */     }
/*     */     
/*  75 */     if (throwable == null) {
/*  76 */       logger.log(ILOGGER_ERROR, s);
/*     */     }
/*     */     else {
/*  79 */       logger.log(ILOGGER_ERROR, s, throwable);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warning(String s, Object... objects)
/*     */   {
/*  85 */     log(ILOGGER_WARNING, s, objects);
/*     */   }
/*     */   
/*     */   public void info(String s, Object... objects)
/*     */   {
/*  90 */     log(ILOGGER_INFO, s, objects);
/*     */   }
/*     */   
/*     */   public void verbose(String s, Object... objects)
/*     */   {
/*  95 */     log(ILOGGER_VERBOSE, s, objects);
/*     */   }
/*     */   
/*     */   private void log(LogLevel logLevel, String s, Object[] objects) {
/*  99 */     if (!logger.isEnabled(logLevel)) {
/* 100 */       return;
/*     */     }
/* 102 */     if ((objects == null) || (objects.length == 0)) {
/* 103 */       logger.log(logLevel, s);
/*     */     }
/*     */     else {
/* 106 */       logger.log(logLevel, String.format(s, objects));
/*     */     }
/*     */   }
/*     */   
/*     */   public static Supplier<ILogger> supplierFor(Class<?> c)
/*     */   {
/* 117 */     return new LoggerSupplier(c, null);
/*     */   }
/*     */   
/*     */   private static class LoggerSupplier implements Supplier<ILogger>, Serializable
/*     */   {
/*     */     private final Class<?> clazz;
/* 123 */     private ILogger logger = null;
/*     */     
/*     */     private LoggerSupplier(Class<?> clazz) {
/* 126 */       this.clazz = clazz;
/*     */     }
/*     */     
/*     */     public synchronized ILogger get()
/*     */     {
/* 131 */       if (logger == null) {
/* 132 */         logger = new LoggerWrapper(Logging.getLogger(clazz));
/*     */       }
/* 134 */       return logger;
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.LoggerWrapper
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */