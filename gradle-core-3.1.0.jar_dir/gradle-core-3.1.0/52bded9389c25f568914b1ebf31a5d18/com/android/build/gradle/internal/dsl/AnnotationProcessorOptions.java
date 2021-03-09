/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class AnnotationProcessorOptions
/*     */   implements com.android.build.gradle.api.AnnotationProcessorOptions
/*     */ {
/*  33 */   private final List<String> classNames = Lists.newArrayList();
/*  34 */   private final Map<String, String> arguments = Maps.newHashMap();
/*     */   
/*  36 */   private Boolean includeCompileClasspath = null;
/*     */   
/*     */   public List<String> getClassNames()
/*     */   {
/*  43 */     return classNames;
/*     */   }
/*     */   
/*     */   public void setClassNames(List<String> classNames) {
/*  47 */     this.classNames.clear();
/*  48 */     this.classNames.addAll(classNames);
/*     */   }
/*     */   
/*     */   public void className(String className) {
/*  52 */     classNames.add(className);
/*     */   }
/*     */   
/*     */   public void classNames(Collection<String> className)
/*     */   {
/*  61 */     classNames.addAll(className);
/*     */   }
/*     */   
/*     */   public Map<String, String> getArguments()
/*     */   {
/*  68 */     return arguments;
/*     */   }
/*     */   
/*     */   public void setArguments(Map<String, String> arguments) {
/*  72 */     this.arguments.clear();
/*  73 */     this.arguments.putAll(arguments);
/*     */   }
/*     */   
/*     */   public void argument(String key, String value) {
/*  77 */     arguments.put(key, value);
/*     */   }
/*     */   
/*     */   public void arguments(Map<String, String> arguments)
/*     */   {
/*  84 */     this.arguments.putAll(arguments);
/*     */   }
/*     */   
/*     */   public Boolean getIncludeCompileClasspath()
/*     */   {
/*  91 */     return includeCompileClasspath;
/*     */   }
/*     */   
/*     */   public void setIncludeCompileClasspath(Boolean includeCompileClasspath) {
/*  95 */     this.includeCompileClasspath = includeCompileClasspath;
/*     */   }
/*     */   
/*     */   public void _initWith(com.android.build.gradle.api.AnnotationProcessorOptions aptOptions) {
/*  99 */     setClassNames(aptOptions.getClassNames());
/* 100 */     setArguments(aptOptions.getArguments());
/* 101 */     setIncludeCompileClasspath(aptOptions.getIncludeCompileClasspath());
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 106 */     return 
/*     */     
/* 110 */       MoreObjects.toStringHelper(this).add("classNames", classNames).add("arguments", arguments).add("includeCompileClasspath", includeCompileClasspath).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.AnnotationProcessorOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */