/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.BuildOutput;
/*     */ import com.android.build.gradle.internal.scope.ExistingBuildElements;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.InstantAppOutputScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*     */ import com.android.build.gradle.internal.tasks.ApplicationId;
/*     */ import com.android.utils.FileUtils;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ import org.apache.commons.compress.utils.IOUtils;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class BundleInstantApp
/*     */   extends AndroidVariantTask
/*     */ {
/*     */   private File bundleDirectory;
/*     */   private String bundleName;
/*     */   private FileCollection applicationId;
/*     */   private FileCollection apkDirectories;
/*     */   
/*     */   @TaskAction
/*     */   public void taskAction()
/*     */     throws IOException
/*     */   {
/*  52 */     FileUtils.mkdirs(bundleDirectory);
/*     */     
/*  54 */     File bundleFile = new File(bundleDirectory, bundleName);
/*  55 */     FileUtils.deleteIfExists(bundleFile);
/*     */     
/*  58 */     ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(bundleFile));Throwable localThrowable6 = null;
/*     */     try {
/*  60 */       for (File apkDirectory : apkDirectories)
/*     */       {
/*  62 */         for (BuildOutput buildOutput : ExistingBuildElements.from(TaskOutputHolder.TaskOutputType.APK, apkDirectory))
/*     */         {
/*  64 */           File apkFile = buildOutput.getOutputFile();
/*  65 */           FileInputStream fileInputStream = new FileInputStream(apkFile);Throwable localThrowable9 = null;
/*  66 */           try { byte[] inputBuffer = IOUtils.toByteArray(fileInputStream);
/*  67 */             zipOutputStream.putNextEntry(new ZipEntry(apkFile.getName()));
/*  68 */             zipOutputStream.write(inputBuffer, 0, inputBuffer.length);
/*  69 */             zipOutputStream.closeEntry();
/*     */           }
/*     */           catch (Throwable localThrowable1)
/*     */           {
/*  65 */             localThrowable9 = localThrowable1;throw localThrowable1;
/*     */           }
/*     */           finally {}
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable8)
/*     */     {
/*  58 */       localThrowable6 = localThrowable8;throw localThrowable8;
/*     */     }
/*     */     finally
/*     */     {
/*  73 */       if (zipOutputStream != null) { if (localThrowable6 != null) try { zipOutputStream.close(); } catch (Throwable localThrowable5) { localThrowable6.addSuppressed(localThrowable5); } else { zipOutputStream.close();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  80 */     InstantAppOutputScope instantAppOutputScope = new InstantAppOutputScope(ApplicationId.load(applicationId.getSingleFile()).getApplicationId(), bundleFile, new ArrayList(apkDirectories.getFiles()));
/*  81 */     instantAppOutputScope.save(bundleDirectory);
/*     */   }
/*     */   
/*     */   @OutputDirectory
/*     */   public File getBundleDirectory()
/*     */   {
/*  87 */     return bundleDirectory;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public String getBundleName()
/*     */   {
/*  93 */     return bundleName;
/*     */   }
/*     */   
/*     */   @InputFiles
/*     */   public FileCollection getApplicationId()
/*     */   {
/*  99 */     return applicationId;
/*     */   }
/*     */   
/*     */   @InputFiles
/*     */   public FileCollection getApkDirectories()
/*     */   {
/* 105 */     return apkDirectories;
/*     */   }
/*     */   
/*     */   public static class ConfigAction
/*     */     implements TaskConfigAction<BundleInstantApp>
/*     */   {
/*     */     private final VariantScope scope;
/*     */     private final File bundleDirectory;
/*     */     
/*     */     public ConfigAction(VariantScope scope, File bundleDirectory)
/*     */     {
/* 116 */       this.scope = scope;
/* 117 */       this.bundleDirectory = bundleDirectory;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 123 */       return scope.getTaskName("package", "InstantAppBundle");
/*     */     }
/*     */     
/*     */     public Class<BundleInstantApp> getType()
/*     */     {
/* 129 */       return BundleInstantApp.class;
/*     */     }
/*     */     
/*     */     public void execute(BundleInstantApp bundleInstantApp)
/*     */     {
/* 134 */       bundleInstantApp.setVariantName(scope.getFullVariantName());
/* 135 */       bundleDirectory = bundleDirectory;
/* 136 */       bundleName = 
/*     */       
/* 139 */         (scope.getGlobalScope().getProjectBaseName() + "-" + scope.getVariantConfiguration().getBaseName() + ".zip");
/*     */       
/* 141 */       applicationId = scope
/* 142 */         .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.FEATURE_APPLICATION_ID_DECLARATION);
/*     */       
/* 146 */       apkDirectories = scope
/* 147 */         .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.APK);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.BundleInstantApp
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */