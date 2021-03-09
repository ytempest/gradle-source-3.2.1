/*     */ package com.android.build.gradle.shrinker.parser;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ProguardFlags
/*     */ {
/*  32 */   private final List<ClassSpecification> keepClassSpecs = Lists.newArrayList();
/*     */   
/*  35 */   private final List<ClassSpecification> keepClassesWithMembersSpecs = Lists.newArrayList();
/*     */   
/*  37 */   private final List<ClassSpecification> keepClassMembersSpecs = Lists.newArrayList();
/*     */   
/*  39 */   private final List<FilterSpecification> dontWarnSpecs = Lists.newArrayList();
/*     */   
/*  41 */   private final List<ClassSpecification> whyAreYouKeepingSpecs = Lists.newArrayList();
/*     */   
/*  43 */   private BytecodeVersion bytecodeVersion = null;
/*     */   
/*     */   private boolean ignoreWarnings;
/*     */   private boolean dontShrink;
/*     */   private boolean dontObfuscate;
/*     */   private boolean dontOptimize;
/*     */   
/*     */   public List<ClassSpecification> getKeepClassSpecs()
/*     */   {
/*  52 */     return keepClassSpecs;
/*     */   }
/*     */   
/*     */   public List<ClassSpecification> getKeepClassesWithMembersSpecs()
/*     */   {
/*  57 */     return keepClassesWithMembersSpecs;
/*     */   }
/*     */   
/*     */   public List<ClassSpecification> getKeepClassMembersSpecs()
/*     */   {
/*  62 */     return keepClassMembersSpecs;
/*     */   }
/*     */   
/*     */   public void addKeepClassSpecification(ClassSpecification classSpecification) {
/*  66 */     keepClassSpecs.add(classSpecification);
/*     */   }
/*     */   
/*     */   public void addKeepClassesWithMembers(ClassSpecification classSpecification) {
/*  70 */     keepClassesWithMembersSpecs.add(classSpecification);
/*     */   }
/*     */   
/*     */   public void addKeepClassMembers(ClassSpecification classSpecification) {
/*  74 */     keepClassMembersSpecs.add(classSpecification);
/*     */   }
/*     */   
/*     */   public void whyAreYouKeeping(ClassSpecification classSpecification) {
/*  78 */     whyAreYouKeepingSpecs.add(classSpecification);
/*     */   }
/*     */   
/*  82 */   public void dontWarn(List<FilterSpecification> classSpec) { dontWarnSpecs.addAll(classSpec); }
/*     */   
/*     */   public void target(String target) { int version;
/*     */     int version;
/*     */     int version;
/*  87 */     int version; int version; int version; int version; int version; switch (target) {
/*     */     case "8": 
/*     */     case "1.8": 
/*  90 */       version = 52;
/*  91 */       break;
/*     */     case "7": 
/*     */     case "1.7": 
/*  94 */       version = 51;
/*  95 */       break;
/*     */     case "6": 
/*     */     case "1.6": 
/*  98 */       version = 50;
/*  99 */       break;
/*     */     case "5": 
/*     */     case "1.5": 
/* 102 */       version = 49;
/* 103 */       break;
/*     */     case "1.4": 
/* 105 */       version = 48;
/* 106 */       break;
/*     */     case "1.3": 
/* 108 */       version = 47;
/* 109 */       break;
/*     */     case "1.2": 
/* 111 */       version = 46;
/* 112 */       break;
/*     */     case "1.1": 
/* 114 */       version = 196653;
/* 115 */       break;
/*     */     default: 
/* 117 */       throw new AssertionError("Unknown target " + target);
/*     */     }
/*     */     int version;
/* 120 */     bytecodeVersion = new BytecodeVersion(version);
/*     */   }
/*     */   
/*     */   public List<FilterSpecification> getDontWarnSpecs()
/*     */   {
/* 125 */     return dontWarnSpecs;
/*     */   }
/*     */   
/*     */   public List<ClassSpecification> getWhyAreYouKeepingSpecs()
/*     */   {
/* 130 */     return whyAreYouKeepingSpecs;
/*     */   }
/*     */   
/*     */   public void setIgnoreWarnings(boolean ignoreWarnings) {
/* 134 */     this.ignoreWarnings = ignoreWarnings;
/*     */   }
/*     */   
/*     */   public boolean isIgnoreWarnings() {
/* 138 */     return ignoreWarnings;
/*     */   }
/*     */   
/*     */   public BytecodeVersion getBytecodeVersion()
/*     */   {
/* 143 */     return bytecodeVersion;
/*     */   }
/*     */   
/*     */   public boolean isDontShrink() {
/* 147 */     return dontShrink;
/*     */   }
/*     */   
/*     */   public void setDontShrink(boolean dontShrink) {
/* 151 */     this.dontShrink = dontShrink;
/*     */   }
/*     */   
/*     */   public boolean isDontObfuscate() {
/* 155 */     return dontObfuscate;
/*     */   }
/*     */   
/*     */   public void setDontObfuscate(boolean dontObfuscate) {
/* 159 */     this.dontObfuscate = dontObfuscate;
/*     */   }
/*     */   
/*     */   public boolean isDontOptimize() {
/* 163 */     return dontOptimize;
/*     */   }
/*     */   
/*     */   public void setDontOptimize(boolean dontOptimize) {
/* 167 */     this.dontOptimize = dontOptimize;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.ProguardFlags
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */