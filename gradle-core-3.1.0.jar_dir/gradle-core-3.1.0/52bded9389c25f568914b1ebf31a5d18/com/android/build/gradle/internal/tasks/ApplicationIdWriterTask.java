/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class ApplicationIdWriterTask
/*     */   extends AndroidVariantTask
/*     */ {
/*     */   private String applicationId;
/*     */   private FileCollection packageManifest;
/*     */   private File outputDirectory;
/*     */   
/*     */   @Input
/*     */   public String getApplicationId()
/*     */   {
/*  46 */     return applicationId;
/*     */   }
/*     */   
/*     */   @InputFiles
/*     */   @Optional
/*     */   public FileCollection getPackageManifest() {
/*  52 */     return packageManifest;
/*     */   }
/*     */   
/*     */   @OutputDirectory
/*  57 */   public File getOutputDirectory() { return outputDirectory; }
/*     */   
/*     */   @TaskAction
/*     */   public void fullTaskAction() throws IOException {
/*     */     String packageId;
/*     */     String packageId;
/*  63 */     if ((packageManifest != null) && (!packageManifest.isEmpty())) {
/*  64 */       packageId = ApplicationId.load(packageManifest.getSingleFile()).getApplicationId();
/*     */     } else {
/*  66 */       packageId = applicationId;
/*     */     }
/*  68 */     ApplicationId declaration = new ApplicationId(packageId);
/*  69 */     declaration.save(outputDirectory);
/*     */   }
/*     */   
/*     */   public static class ConfigAction implements TaskConfigAction<ApplicationIdWriterTask>
/*     */   {
/*     */     protected final VariantScope variantScope;
/*     */     protected final File outputDirectory;
/*     */     
/*     */     public ConfigAction(VariantScope variantScope, File outputDirectory) {
/*  78 */       this.variantScope = variantScope;
/*  79 */       this.outputDirectory = outputDirectory;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/*  85 */       return variantScope.getTaskName("write", "ApplicationId");
/*     */     }
/*     */     
/*     */     public Class<ApplicationIdWriterTask> getType()
/*     */     {
/*  91 */       return ApplicationIdWriterTask.class;
/*     */     }
/*     */     
/*     */     public void execute(ApplicationIdWriterTask task)
/*     */     {
/*  96 */       task.setVariantName(variantScope.getFullVariantName());
/*  97 */       applicationId = variantScope.getVariantConfiguration().getApplicationId();
/*  98 */       outputDirectory = outputDirectory;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BaseFeatureConfigAction extends ApplicationIdWriterTask.ConfigAction
/*     */   {
/*     */     public BaseFeatureConfigAction(VariantScope variantScope, File outputDirectory)
/*     */     {
/* 106 */       super(outputDirectory);
/*     */     }
/*     */     
/*     */     public void execute(ApplicationIdWriterTask task)
/*     */     {
/* 111 */       super.execute(task);
/* 112 */       packageManifest = variantScope
/* 113 */         .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.METADATA_VALUES, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.METADATA_APP_ID_DECLARATION);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.ApplicationIdWriterTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */