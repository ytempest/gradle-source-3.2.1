/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.InstantRunVariantScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TransformVariantScope;
/*     */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*     */ import com.android.builder.profile.ProcessProfileWriter;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.io.Files;
/*     */ import com.google.wireless.android.sdk.stats.GradleBuildProfile.Builder;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.gradle.api.logging.LogLevel;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class BuildInfoWriterTask
/*     */   extends AndroidVariantTask
/*     */ {
/*     */   File buildInfoFile;
/*     */   File tmpBuildInfoFile;
/*     */   Logger logger;
/*     */   InstantRunBuildContext buildContext;
/*     */   
/*     */   @TaskAction
/*     */   public void executeAction()
/*     */   {
/*  58 */     if (buildContext.getBuildHasFailed()) {
/*     */       try {
/*  60 */         buildContext.writeTmpBuildInfo(tmpBuildInfoFile);
/*     */       } catch (ParserConfigurationException|IOException e) {
/*  62 */         throw new RuntimeException("Exception while saving temp-build-info.xml", e);
/*     */       }
/*  64 */       return;
/*     */     }
/*     */     
/*  68 */     buildContext.close();
/*     */     try
/*     */     {
/*  71 */       String xml = buildContext.toXml();
/*  72 */       if (logger.isEnabled(LogLevel.DEBUG)) {
/*  73 */         logger.debug("build-id $1$l, build-info.xml : %2$s", 
/*  74 */           Long.valueOf(buildContext.getBuildId()), xml);
/*     */       }
/*  76 */       Files.createParentDirs(buildInfoFile);
/*  77 */       Files.write(xml, buildInfoFile, Charsets.UTF_8);
/*     */     } catch (Exception e) {
/*  79 */       throw new RuntimeException("Exception while saving build-info.xml", e);
/*     */     }
/*     */     
/*  84 */     ProcessProfileWriter.getGlobalProperties().setInstantRunStatus(
/*  85 */       InstantRunAnalyticsHelper.generateAnalyticsProto(buildContext)); }
/*     */   
/*     */   public static class ConfigAction implements TaskConfigAction<BuildInfoWriterTask> { private final String taskName;
/*     */     private final InstantRunVariantScope variantScope;
/*     */     private final Logger logger;
/*     */     
/*  91 */     public static File getBuildInfoFile(InstantRunVariantScope scope) { return new File(scope.getBuildInfoOutputFolder(), "build-info.xml"); }
/*     */     
/*     */     public static File getTmpBuildInfoFile(InstantRunVariantScope scope)
/*     */     {
/*  95 */       return new File(scope.getBuildInfoOutputFolder(), "tmp-build-info.xml");
/*     */     }
/*     */     
/*     */     public ConfigAction(InstantRunVariantScope scope, Logger logger)
/*     */     {
/* 105 */       taskName = scope.getTransformVariantScope().getTaskName("buildInfoGenerator");
/* 106 */       variantScope = scope;
/* 107 */       this.logger = logger;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 113 */       return taskName;
/*     */     }
/*     */     
/*     */     public Class<BuildInfoWriterTask> getType()
/*     */     {
/* 119 */       return BuildInfoWriterTask.class;
/*     */     }
/*     */     
/*     */     public void execute(BuildInfoWriterTask task)
/*     */     {
/* 124 */       task.setDescription("InstantRun task to build incremental artifacts");
/* 125 */       task.setVariantName(variantScope.getFullVariantName());
/* 126 */       buildInfoFile = getBuildInfoFile(variantScope);
/* 127 */       tmpBuildInfoFile = getTmpBuildInfoFile(variantScope);
/* 128 */       buildContext = variantScope.getInstantRunBuildContext();
/* 129 */       logger = logger;
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.BuildInfoWriterTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */