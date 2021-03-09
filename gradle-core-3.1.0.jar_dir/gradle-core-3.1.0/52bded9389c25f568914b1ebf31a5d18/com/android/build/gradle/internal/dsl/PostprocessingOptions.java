/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.build.gradle.ProguardFiles;
/*     */ import com.android.build.gradle.ProguardFiles.ProguardFile;
/*     */ import com.android.build.gradle.internal.scope.CodeShrinker;
/*     */ import com.android.utils.HelpfulEnumConverter;
/*     */ import com.google.common.base.Converter;
/*     */ import com.google.common.base.Verify;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Incubating;
/*     */ import org.gradle.api.Project;
/*     */ 
/*     */ @Incubating
/*     */ public class PostprocessingOptions
/*     */ {
/*     */   private static final String AUTO = "auto";
/*  50 */   private static final HelpfulEnumConverter<CodeShrinker> SHRINKER_CONVERTER = new HelpfulEnumConverter(CodeShrinker.class);
/*     */   
/*     */   private final Project project;
/*     */   
/*     */   private boolean removeUnusedCode;
/*     */   
/*     */   private boolean removeUnusedResources;
/*     */   
/*     */   private boolean obfuscate;
/*     */   private boolean optimizeCode;
/*     */   private List<File> proguardFiles;
/*     */   private List<File> testProguardFiles;
/*     */   private List<File> consumerProguardFiles;
/*     */   private CodeShrinker codeShrinker;
/*     */   
/*     */   @Inject
/*     */   public PostprocessingOptions(Project project)
/*     */   {
/*  68 */     this(project, 
/*     */     
/*  70 */       ImmutableList.of(
/*  71 */       ProguardFiles.getDefaultProguardFile(NO_ACTIONSfileName, project)));
/*     */   }
/*     */   
/*     */   PostprocessingOptions(Project project, List<File> proguardFiles)
/*     */   {
/*  77 */     this.project = project;
/*  78 */     this.proguardFiles = Lists.newArrayList(proguardFiles);
/*  79 */     testProguardFiles = new ArrayList();
/*  80 */     consumerProguardFiles = new ArrayList();
/*     */   }
/*     */   
/*     */   public void initWith(PostprocessingOptions that) {
/*  84 */     removeUnusedCode = that.isRemoveUnusedCode();
/*  85 */     removeUnusedResources = that.isRemoveUnusedResources();
/*  86 */     obfuscate = that.isObfuscate();
/*  87 */     optimizeCode = that.isOptimizeCode();
/*  88 */     proguardFiles = Lists.newArrayList(that.getProguardFiles());
/*  89 */     testProguardFiles = Lists.newArrayList(that.getTestProguardFiles());
/*  90 */     consumerProguardFiles = Lists.newArrayList(that.getConsumerProguardFiles());
/*  91 */     codeShrinker = that.getCodeShrinkerEnum();
/*     */   }
/*     */   
/*     */   public boolean isRemoveUnusedCode() {
/*  95 */     return removeUnusedCode;
/*     */   }
/*     */   
/*     */   public void setRemoveUnusedCode(boolean removeUnusedCode) {
/*  99 */     this.removeUnusedCode = removeUnusedCode;
/*     */   }
/*     */   
/*     */   public boolean isRemoveUnusedResources() {
/* 103 */     return removeUnusedResources;
/*     */   }
/*     */   
/*     */   public void setRemoveUnusedResources(boolean removeUnusedResources) {
/* 107 */     this.removeUnusedResources = removeUnusedResources;
/*     */   }
/*     */   
/*     */   public boolean isObfuscate() {
/* 111 */     return obfuscate;
/*     */   }
/*     */   
/*     */   public void setObfuscate(boolean obfuscate) {
/* 115 */     this.obfuscate = obfuscate;
/*     */   }
/*     */   
/*     */   public boolean isOptimizeCode() {
/* 119 */     return optimizeCode;
/*     */   }
/*     */   
/*     */   public void setOptimizeCode(boolean optimizeCode) {
/* 123 */     this.optimizeCode = optimizeCode;
/*     */   }
/*     */   
/*     */   public List<File> getProguardFiles() {
/* 127 */     return proguardFiles;
/*     */   }
/*     */   
/*     */   public void setProguardFiles(List<Object> proguardFiles) {
/* 131 */     this.proguardFiles = new ArrayList();
/* 132 */     for (Object file : proguardFiles) {
/* 133 */       this.proguardFiles.add(project.file(file));
/*     */     }
/*     */   }
/*     */   
/*     */   public void proguardFile(Object file) {
/* 138 */     proguardFiles.add(project.file(file));
/*     */   }
/*     */   
/*     */   public void proguardFiles(Object... files) {
/* 142 */     for (Object file : files) {
/* 143 */       proguardFile(file);
/*     */     }
/*     */   }
/*     */   
/*     */   public List<File> getTestProguardFiles() {
/* 148 */     return testProguardFiles;
/*     */   }
/*     */   
/*     */   public void setTestProguardFiles(List<Object> testProguardFiles) {
/* 152 */     this.testProguardFiles = new ArrayList();
/* 153 */     for (Object file : testProguardFiles) {
/* 154 */       this.testProguardFiles.add(project.file(file));
/*     */     }
/*     */   }
/*     */   
/*     */   public void testProguardFile(Object file) {
/* 159 */     testProguardFiles.add(project.file(file));
/*     */   }
/*     */   
/*     */   public void testProguardFiles(Object... files) {
/* 163 */     for (Object file : files) {
/* 164 */       testProguardFile(file);
/*     */     }
/*     */   }
/*     */   
/*     */   public List<File> getConsumerProguardFiles() {
/* 169 */     return consumerProguardFiles;
/*     */   }
/*     */   
/*     */   public void setConsumerProguardFiles(List<Object> consumerProguardFiles) {
/* 173 */     this.consumerProguardFiles = new ArrayList();
/* 174 */     for (Object file : consumerProguardFiles) {
/* 175 */       this.consumerProguardFiles.add(project.file(file));
/*     */     }
/*     */   }
/*     */   
/*     */   public void consumerProguardFile(Object file) {
/* 180 */     consumerProguardFiles.add(project.file(file));
/*     */   }
/*     */   
/*     */   public void consumerProguardFiles(Object... files) {
/* 184 */     for (Object file : files) {
/* 185 */       consumerProguardFile(file);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCodeShrinker()
/*     */   {
/* 191 */     if (codeShrinker == null) {
/* 192 */       return "auto";
/*     */     }
/* 194 */     return (String)Verify.verifyNotNull(SHRINKER_CONVERTER.reverse().convert(codeShrinker));
/*     */   }
/*     */   
/*     */   public void setCodeShrinker(String name)
/*     */   {
/* 199 */     if (name.equals("auto")) {
/* 200 */       codeShrinker = null;
/*     */     } else {
/* 202 */       codeShrinker = ((CodeShrinker)SHRINKER_CONVERTER.convert(name));
/*     */     }
/*     */   }
/*     */   
/*     */   public CodeShrinker getCodeShrinkerEnum()
/*     */   {
/* 209 */     return codeShrinker;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.PostprocessingOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */