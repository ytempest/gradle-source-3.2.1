/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Locale;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.JavaVersion;
/*     */ 
/*     */ public class CompileOptions
/*     */ {
/*     */   private static final String VERSION_PREFIX = "VERSION_";
/*     */   private JavaVersion sourceCompatibility;
/*     */   private JavaVersion targetCompatibility;
/*  42 */   private String encoding = Charsets.UTF_8
/*  43 */     .name();
/*     */   
/*  46 */   private Boolean incremental = null;
/*     */   
/*  49 */   JavaVersion defaultJavaVersion = JavaVersion.VERSION_1_6;
/*     */   
/*     */   public void setSourceCompatibility(Object sourceCompatibility)
/*     */   {
/*  58 */     this.sourceCompatibility = convert(sourceCompatibility);
/*     */   }
/*     */   
/*     */   public JavaVersion getSourceCompatibility()
/*     */   {
/*  75 */     return sourceCompatibility != null ? sourceCompatibility : defaultJavaVersion;
/*     */   }
/*     */   
/*     */   public void setTargetCompatibility(Object targetCompatibility)
/*     */   {
/*  80 */     this.targetCompatibility = convert(targetCompatibility);
/*     */   }
/*     */   
/*     */   public JavaVersion getTargetCompatibility()
/*     */   {
/*  97 */     return targetCompatibility != null ? targetCompatibility : defaultJavaVersion;
/*     */   }
/*     */   
/*     */   public void setEncoding(String encoding)
/*     */   {
/* 102 */     this.encoding = ((String)Preconditions.checkNotNull(encoding));
/*     */   }
/*     */   
/*     */   public String getEncoding()
/*     */   {
/* 110 */     return encoding;
/*     */   }
/*     */   
/*     */   public void setDefaultJavaVersion(JavaVersion defaultJavaVersion)
/*     */   {
/* 118 */     this.defaultJavaVersion = ((JavaVersion)Preconditions.checkNotNull(defaultJavaVersion));
/*     */   }
/*     */   
/*     */   public Boolean getIncremental()
/*     */   {
/* 127 */     return incremental;
/*     */   }
/*     */   
/*     */   public void setIncremental(boolean incremental)
/*     */   {
/* 132 */     this.incremental = Boolean.valueOf(incremental);
/*     */   }
/*     */   
/*     */   private static JavaVersion convert(Object version)
/*     */   {
/* 142 */     if ((version instanceof String)) {
/* 143 */       String versionString = (String)version;
/* 144 */       if (versionString.toUpperCase(Locale.ENGLISH).startsWith("VERSION_")) {
/* 145 */         version = versionString.substring("VERSION_".length()).replace('_', '.');
/*     */       }
/*     */     }
/* 148 */     return JavaVersion.toVersion(version);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.CompileOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */