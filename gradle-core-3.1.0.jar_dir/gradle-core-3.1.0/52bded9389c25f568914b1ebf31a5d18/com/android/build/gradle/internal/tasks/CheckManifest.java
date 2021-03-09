/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import java.io.File;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class CheckManifest
/*     */   extends AndroidVariantTask
/*     */ {
/*     */   private File manifest;
/*     */   private Boolean isOptional;
/*     */   private File fakeOutputDir;
/*     */   
/*     */   @Optional
/*     */   @Input
/*     */   public File getManifest()
/*     */   {
/*  39 */     return manifest;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean getManifestPresence() {
/*  44 */     return (manifest != null) && (manifest.isFile());
/*     */   }
/*     */   
/*     */   public void setManifest(File manifest) {
/*  48 */     this.manifest = manifest;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public Boolean getOptional() {
/*  53 */     return isOptional;
/*     */   }
/*     */   
/*     */   public void setOptional(Boolean optional) {
/*  57 */     isOptional = optional;
/*     */   }
/*     */   
/*     */   @OutputDirectory
/*     */   public File getFakeOutputDir() {
/*  62 */     return fakeOutputDir;
/*     */   }
/*     */   
/*     */   @TaskAction
/*     */   void check() {
/*  67 */     if ((!isOptional.booleanValue()) && (manifest != null) && (!manifest.isFile()))
/*     */     {
/*  69 */       throw new IllegalArgumentException(String.format("Main Manifest missing for variant %1$s. Expected path: %2$s", new Object[] {
/*     */       
/*  71 */         getVariantName(), getManifest().getAbsolutePath() }));
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ConfigAction implements TaskConfigAction<CheckManifest>
/*     */   {
/*     */     private final VariantScope scope;
/*     */     private final boolean isManifestOptional;
/*     */     
/*     */     public ConfigAction(VariantScope scope, boolean isManifestOptional) {
/*  81 */       this.scope = scope;
/*  82 */       this.isManifestOptional = isManifestOptional;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/*  88 */       return scope.getTaskName("check", "Manifest");
/*     */     }
/*     */     
/*     */     public Class<CheckManifest> getType()
/*     */     {
/*  94 */       return CheckManifest.class;
/*     */     }
/*     */     
/*     */     public void execute(CheckManifest checkManifestTask)
/*     */     {
/*  99 */       scope.getVariantData().checkManifestTask = checkManifestTask;
/* 100 */       checkManifestTask.setVariantName(scope
/* 101 */         .getVariantData().getVariantConfiguration().getFullName());
/* 102 */       checkManifestTask.setOptional(Boolean.valueOf(isManifestOptional));
/* 103 */       manifest = scope
/* 104 */         .getVariantData().getVariantConfiguration().getMainManifest();
/*     */       
/* 106 */       fakeOutputDir = new File(scope
/*     */       
/* 108 */         .getGlobalScope().getIntermediatesDir(), "check-manifest/" + scope
/* 109 */         .getVariantConfiguration().getDirName());
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.CheckManifest
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */