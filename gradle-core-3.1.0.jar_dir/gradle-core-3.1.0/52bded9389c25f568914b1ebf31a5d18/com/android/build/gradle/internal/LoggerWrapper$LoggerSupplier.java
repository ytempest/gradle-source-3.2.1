/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import com.android.utils.ILogger;
/*     */ import java.io.Serializable;
/*     */ import java.util.function.Supplier;
/*     */ import org.gradle.api.logging.Logging;
/*     */ 
/*     */ class LoggerWrapper$LoggerSupplier
/*     */   implements Supplier<ILogger>, Serializable
/*     */ {
/*     */   private final Class<?> clazz;
/* 123 */   private ILogger logger = null;
/*     */   
/*     */   private LoggerWrapper$LoggerSupplier(Class<?> clazz) {
/* 126 */     this.clazz = clazz;
/*     */   }
/*     */   
/*     */   public synchronized ILogger get()
/*     */   {
/* 131 */     if (logger == null) {
/* 132 */       logger = new LoggerWrapper(Logging.getLogger(clazz));
/*     */     }
/* 134 */     return logger;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.LoggerWrapper.LoggerSupplier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */