/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.build.gradle.internal.LoggerWrapper;
/*     */ import com.google.common.collect.Iterables;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.Internal;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ 
/*     */ public class AaptOptions
/*     */ {
/*     */   private Boolean namespaced;
/*     */   private String ignoreAssetsPattern;
/*     */   private List<String> noCompressList;
/*     */   private Boolean cruncherEnabled;
/*  44 */   private boolean failOnMissingConfigEntry = false;
/*     */   
/*     */   private List<String> additionalParameters;
/*     */   
/*  49 */   private int cruncherProcesses = 0;
/*     */   
/*     */   public void setIgnoreAssetsPattern(String ignoreAssetsPattern) {
/*  52 */     this.ignoreAssetsPattern = ignoreAssetsPattern;
/*     */   }
/*     */   
/*     */   public void setIgnoreAssets(String ignoreAssetsPattern) {
/*  56 */     setIgnoreAssetsPattern(ignoreAssetsPattern);
/*     */   }
/*     */   
/*     */   @Optional
/*     */   @Input
/*     */   public String getIgnoreAssets()
/*     */   {
/*  67 */     return ignoreAssetsPattern;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public String getIgnoreAssetsPattern()
/*     */   {
/*  77 */     return ignoreAssetsPattern;
/*     */   }
/*     */   
/*     */   public void setNoCompress(String noCompress) {
/*  81 */     setNoCompress(new String[] { noCompress });
/*     */   }
/*     */   
/*     */   public void setNoCompress(Iterable<String> noCompress) {
/*  85 */     setNoCompress((String[])Iterables.toArray(noCompress, String.class));
/*     */   }
/*     */   
/*     */   public void setNoCompress(String... noCompress) {
/*  89 */     for (String p : noCompress) {
/*  90 */       if (p.equals("\"\"")) {
/*  91 */         LoggerWrapper.getLogger(AaptOptions.class).warning("noCompress pattern '\"\"' no longer matches every file. It now matches exactly two double quote characters. Please use '' instead.", new Object[0]);
/*     */       }
/*     */     }
/*     */     
/*  97 */     noCompressList = Arrays.asList(noCompress);
/*     */   }
/*     */   
/*     */   @Optional
/*     */   @Input
/*     */   public Collection<String> getNoCompress()
/*     */   {
/* 110 */     return noCompressList;
/*     */   }
/*     */   
/*     */   public void useNewCruncher(boolean value) {
/* 114 */     LoggerWrapper.getLogger(AaptOptions.class).warning("useNewCruncher has been deprecated. It will be removed in a future version of the gradle plugin. New cruncher is now always enabled.", new Object[0]);
/*     */   }
/*     */   
/*     */   public void setUseNewCruncher(boolean value)
/*     */   {
/* 120 */     LoggerWrapper.getLogger(AaptOptions.class).warning("useNewCruncher has been deprecated. It will be removed in a future version of the gradle plugin. New cruncher is now always enabled.", new Object[0]);
/*     */   }
/*     */   
/*     */   public void setCruncherEnabled(boolean value)
/*     */   {
/* 126 */     cruncherEnabled = Boolean.valueOf(value);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public boolean getCruncherEnabled()
/*     */   {
/* 145 */     return cruncherEnabled == null ? true : cruncherEnabled.booleanValue();
/*     */   }
/*     */   
/*     */   public Boolean getCruncherEnabledOverride() {
/* 149 */     return cruncherEnabled;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean getUseNewCruncher()
/*     */   {
/* 157 */     return true;
/*     */   }
/*     */   
/*     */   public void failOnMissingConfigEntry(boolean value) {
/* 161 */     failOnMissingConfigEntry = value;
/*     */   }
/*     */   
/*     */   public void setFailOnMissingConfigEntry(boolean value) {
/* 165 */     failOnMissingConfigEntry = value;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean getFailOnMissingConfigEntry()
/*     */   {
/* 175 */     return failOnMissingConfigEntry;
/*     */   }
/*     */   
/*     */   public void noCompress(String noCompress)
/*     */   {
/* 186 */     noCompressList = Collections.singletonList(noCompress);
/*     */   }
/*     */   
/*     */   public void noCompress(String... noCompress)
/*     */   {
/* 195 */     noCompressList = Arrays.asList(noCompress);
/*     */   }
/*     */   
/*     */   public void additionalParameters(String param)
/*     */   {
/* 202 */     additionalParameters = Collections.singletonList(param);
/*     */   }
/*     */   
/*     */   public void additionalParameters(String... params)
/*     */   {
/* 209 */     additionalParameters = Arrays.asList(params);
/*     */   }
/*     */   
/*     */   public void setAdditionalParameters(List<String> parameters) {
/* 213 */     additionalParameters = parameters;
/*     */   }
/*     */   
/*     */   @Optional
/*     */   @Input
/*     */   public List<String> getAdditionalParameters()
/*     */   {
/* 223 */     return additionalParameters;
/*     */   }
/*     */   
/*     */   public void setCruncherProcesses(int cruncherProcesses) {
/* 227 */     this.cruncherProcesses = cruncherProcesses;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public int getCruncherProcesses()
/*     */   {
/* 238 */     return cruncherProcesses;
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public Boolean getNamespaced()
/*     */   {
/* 249 */     return namespaced;
/*     */   }
/*     */   
/*     */   public void setNamespaced(Boolean namespaced) {
/* 253 */     this.namespaced = namespaced;
/*     */   }
/*     */   
/*     */   public void namespaced(Boolean namespaced) {
/* 257 */     this.namespaced = namespaced;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.AaptOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */