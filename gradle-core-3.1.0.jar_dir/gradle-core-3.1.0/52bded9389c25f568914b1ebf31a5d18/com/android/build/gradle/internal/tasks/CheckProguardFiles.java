/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.ProguardFiles;
/*     */ import com.android.build.gradle.ProguardFiles.ProguardFile;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.shrinker.ProguardConfig;
/*     */ import com.android.build.gradle.shrinker.parser.ProguardFlags;
/*     */ import com.android.build.gradle.shrinker.parser.UnsupportedFlagsHandler;
/*     */ import java.io.File;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.gradle.api.DefaultTask;
/*     */ import org.gradle.api.InvalidUserDataException;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class CheckProguardFiles
/*     */   extends DefaultTask
/*     */ {
/*  39 */   private static final Logger logger = LoggerFactory.getLogger(CheckProguardFiles.class);
/*     */   
/*     */   private List<File> proguardFiles;
/*     */   
/*     */   @TaskAction
/*     */   public void run()
/*     */   {
/*  48 */     ProguardConfig proguardConfig = new ProguardConfig();
/*     */     
/*  50 */     Map<File, ProguardFiles.ProguardFile> oldFiles = new HashMap();
/*  51 */     oldFiles.put(
/*  52 */       ProguardFiles.getDefaultProguardFile(OPTIMIZEfileName, getProject())
/*  53 */       .getAbsoluteFile(), ProguardFiles.ProguardFile.OPTIMIZE);
/*     */     
/*  55 */     oldFiles.put(
/*  56 */       ProguardFiles.getDefaultProguardFile(DONT_OPTIMIZEfileName, 
/*  57 */       getProject())
/*  58 */       .getAbsoluteFile(), ProguardFiles.ProguardFile.DONT_OPTIMIZE);
/*     */     
/*  61 */     for (File file : proguardFiles) {
/*  62 */       if (oldFiles.containsKey(file.getAbsoluteFile())) {
/*  63 */         String name = getgetAbsoluteFilefileName;
/*  64 */         throw new InvalidUserDataException(name + " should not be used together with the new postprocessing DSL. The new DSL includes sensible settings by default, you can override this using `postprocessing { proguardFiles = []}`");
/*     */       }
/*     */       
/*     */       try
/*     */       {
/*  72 */         proguardConfig.parse(file, UnsupportedFlagsHandler.NO_OP);
/*     */       }
/*     */       catch (Exception e) {
/*  75 */         logger.info("Failed to parse " + file.getAbsolutePath(), e); }
/*  76 */       continue;
/*     */       
/*  79 */       ProguardFlags flags = proguardConfig.getFlags();
/*  80 */       if ((flags.isDontShrink()) || (flags.isDontOptimize()) || (flags.isDontObfuscate()))
/*     */       {
/*  82 */         throw new InvalidUserDataException(file.getAbsolutePath() + ": When postprocessing features are configured in the DSL, corresponding flags (e.g. -dontobfuscate) cannot be used.");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @InputFiles
/*     */   public List<File> getProguardFiles()
/*     */   {
/*  91 */     return proguardFiles;
/*     */   }
/*     */   
/*     */   public static class ConfigAction implements TaskConfigAction<CheckProguardFiles> {
/*     */     private final VariantScope scope;
/*     */     
/*     */     public ConfigAction(VariantScope scope) {
/*  98 */       this.scope = scope;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 104 */       return scope.getTaskName("check", "ProguardFiles");
/*     */     }
/*     */     
/*     */     public Class<CheckProguardFiles> getType()
/*     */     {
/* 110 */       return CheckProguardFiles.class;
/*     */     }
/*     */     
/*     */     public void execute(CheckProguardFiles task)
/*     */     {
/* 115 */       proguardFiles = scope.getProguardFiles();
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.CheckProguardFiles
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */