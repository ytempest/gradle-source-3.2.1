/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.builder.model.BaseConfig;
/*     */ import com.android.builder.model.ClassField;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import groovy.lang.GroovyObject;
/*     */ import groovy.lang.GroovyObjectSupport;
/*     */ import groovy.lang.MissingPropertyException;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import org.codehaus.groovy.runtime.DefaultGroovyMethods;
/*     */ 
/*     */ public abstract class ReadOnlyBaseConfig
/*     */   extends GroovyObjectSupport
/*     */   implements BaseConfig
/*     */ {
/*     */   private BaseConfig baseConfig;
/*     */   
/*     */   protected ReadOnlyBaseConfig(BaseConfig baseConfig)
/*     */   {
/*  51 */     this.baseConfig = baseConfig;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  57 */     return baseConfig.getName();
/*     */   }
/*     */   
/*     */   public String getApplicationIdSuffix()
/*     */   {
/*  63 */     return baseConfig.getApplicationIdSuffix();
/*     */   }
/*     */   
/*     */   public String getVersionNameSuffix()
/*     */   {
/*  69 */     return baseConfig.getVersionNameSuffix();
/*     */   }
/*     */   
/*     */   public Map<String, ClassField> getBuildConfigFields()
/*     */   {
/*  76 */     return ImmutableMap.copyOf(baseConfig.getBuildConfigFields());
/*     */   }
/*     */   
/*     */   public Map<String, ClassField> getResValues()
/*     */   {
/*  82 */     return ImmutableMap.copyOf(baseConfig.getResValues());
/*     */   }
/*     */   
/*     */   public Collection<File> getProguardFiles()
/*     */   {
/*  88 */     return ImmutableList.copyOf(baseConfig.getProguardFiles());
/*     */   }
/*     */   
/*     */   public Collection<File> getConsumerProguardFiles()
/*     */   {
/*  94 */     return ImmutableList.copyOf(baseConfig.getConsumerProguardFiles());
/*     */   }
/*     */   
/*     */   public Collection<File> getTestProguardFiles()
/*     */   {
/* 100 */     return ImmutableList.copyOf(baseConfig.getTestProguardFiles());
/*     */   }
/*     */   
/*     */   public Map<String, Object> getManifestPlaceholders()
/*     */   {
/* 106 */     return ImmutableMap.copyOf(baseConfig.getManifestPlaceholders());
/*     */   }
/*     */   
/*     */   public Boolean getMultiDexEnabled()
/*     */   {
/* 112 */     return baseConfig.getMultiDexEnabled();
/*     */   }
/*     */   
/*     */   public File getMultiDexKeepFile()
/*     */   {
/* 118 */     return baseConfig.getMultiDexKeepFile();
/*     */   }
/*     */   
/*     */   public File getMultiDexKeepProguard()
/*     */   {
/* 124 */     return baseConfig.getMultiDexKeepProguard();
/*     */   }
/*     */   
/*     */   public Object propertyMissing(String name)
/*     */   {
/*     */     try
/*     */     {
/* 138 */       return ((GroovyObject)baseConfig).getProperty(name);
/*     */     }
/*     */     catch (MissingPropertyException e) {
/* 141 */       throw new MissingPropertyException("Could not find " + name + " on " + this);
/*     */     }
/*     */   }
/*     */   
/*     */   public void propertyMissing(String name, Object value)
/*     */   {
/* 152 */     throw new RuntimeException(String.format("Cannot set property %s on read-only %s.", new Object[] { name, baseConfig
/*     */     
/* 155 */       .getClass().getName() }));
/*     */   }
/*     */   
/*     */   public boolean hasProperty(String name)
/*     */   {
/* 160 */     if (DefaultGroovyMethods.hasProperty(this, name) != null) {
/* 161 */       return true;
/*     */     }
/* 163 */     GroovyObject groovyObject = (GroovyObject)baseConfig;
/*     */     
/* 166 */     return ((Boolean)groovyObject.invokeMethod("hasProperty", name)).booleanValue();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ReadOnlyBaseConfig
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */