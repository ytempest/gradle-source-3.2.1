/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.InstantRunVariantScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TransformVariantScope;
/*     */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*     */ import com.android.builder.packaging.PackagingUtils;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.Throwables;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.logging.LogLevel;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class BuildInfoLoaderTask
/*     */   extends AndroidVariantTask
/*     */ {
/*     */   File pastBuildsFolder;
/*     */   File buildInfoFile;
/*     */   File tmpBuildInfoFile;
/*     */   Logger logger;
/*     */   InstantRunBuildContext buildContext;
/*     */   
/*     */   @TaskAction
/*     */   public void executeAction()
/*     */   {
/*     */     try
/*     */     {
/*  57 */       if (buildInfoFile.exists()) {
/*  58 */         buildContext.loadFromXmlFile(buildInfoFile);
/*     */       } else {
/*  60 */         buildContext.setVerifierStatus(InstantRunVerifierStatus.INITIAL_BUILD);
/*     */       }
/*  62 */       long token = buildContext.getSecretToken();
/*  63 */       if (token == 0L) {
/*  64 */         token = PackagingUtils.computeApplicationHash(getProject().getBuildDir());
/*  65 */         buildContext.setSecretToken(token);
/*     */       }
/*     */       
/*  69 */       if (tmpBuildInfoFile.exists()) {
/*  70 */         buildContext.mergeFromFile(tmpBuildInfoFile);
/*  71 */         FileUtils.delete(tmpBuildInfoFile);
/*     */       }
/*     */     } catch (Exception e) {
/*  74 */       throw new RuntimeException(String.format("Exception while loading build-info.xml : %s", new Object[] {
/*     */       
/*  76 */         Throwables.getStackTraceAsString(e) }));
/*     */     }
/*     */     try
/*     */     {
/*  80 */       InstantRunBuildContext.Build lastBuild = buildContext.getLastBuild();
/*  81 */       if (lastBuild == null) {
/*  82 */         return;
/*     */       }
/*     */       
/*  86 */       backupFolder = new File(pastBuildsFolder, String.valueOf(lastBuild.getBuildId()));
/*  87 */       FileUtils.mkdirs(backupFolder);
/*  88 */       for (InstantRunBuildContext.Artifact artifact : lastBuild.getArtifacts())
/*  89 */         if (!artifact.isAccumulative()) {
/*  90 */           File oldLocation = artifact.getLocation();
/*     */           
/*  92 */           if (!oldLocation.isFile()) {
/*  93 */             return;
/*     */           }
/*  95 */           File newLocation = new File(backupFolder, oldLocation.getName());
/*  96 */           if (logger.isEnabled(LogLevel.DEBUG)) {
/*  97 */             logger.debug(String.format("File moved from %1$s to %2$s", new Object[] {oldLocation
/*  98 */               .getPath(), newLocation.getPath() }));
/*     */           }
/* 100 */           Files.copy(oldLocation, newLocation);
/*     */           
/* 102 */           artifact.setLocation(newLocation);
/*     */         }
/*     */     } catch (Exception e) {
/*     */       File backupFolder;
/* 106 */       throw new RuntimeException(String.format("Exception while doing past iteration backup : %s", new Object[] {e
/*     */       
/* 108 */         .getMessage() }));
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ConfigAction
/*     */     implements TaskConfigAction<BuildInfoLoaderTask>
/*     */   {
/*     */     private final String taskName;
/*     */     private final InstantRunVariantScope variantScope;
/*     */     private final Logger logger;
/*     */     
/*     */     public ConfigAction(InstantRunVariantScope scope, Logger logger)
/*     */     {
/* 121 */       taskName = scope.getTransformVariantScope().getTaskName("buildInfo", "Loader");
/* 122 */       variantScope = scope;
/* 123 */       this.logger = logger;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 129 */       return taskName;
/*     */     }
/*     */     
/*     */     public Class<BuildInfoLoaderTask> getType()
/*     */     {
/* 135 */       return BuildInfoLoaderTask.class;
/*     */     }
/*     */     
/*     */     public void execute(BuildInfoLoaderTask task)
/*     */     {
/* 140 */       task.setDescription("InstantRun task to load and backup previous iterations artifacts");
/* 141 */       task.setVariantName(variantScope.getFullVariantName());
/* 142 */       buildInfoFile = BuildInfoWriterTask.ConfigAction.getBuildInfoFile(variantScope);
/*     */       
/* 144 */       tmpBuildInfoFile = BuildInfoWriterTask.ConfigAction.getTmpBuildInfoFile(variantScope);
/* 145 */       pastBuildsFolder = variantScope.getInstantRunPastIterationsFolder();
/* 146 */       buildContext = variantScope.getInstantRunBuildContext();
/* 147 */       logger = logger;
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.BuildInfoLoaderTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */