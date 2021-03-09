/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.dsl.LintOptions;
/*     */ import com.android.builder.model.Version;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import com.android.tools.lint.gradle.api.LintExecutionRequest;
/*     */ import java.io.File;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.tooling.provider.model.ToolingModelBuilderRegistry;
/*     */ 
/*     */ public abstract class LintBaseTask$LintBaseTaskDescriptor
/*     */   extends LintExecutionRequest
/*     */ {
/*     */   protected LintBaseTask$LintBaseTaskDescriptor(LintBaseTask this$0) {}
/*     */   
/*     */   public File getSdkHome()
/*     */   {
/*  97 */     return this$0.sdkHome;
/*     */   }
/*     */   
/*     */   public ToolingModelBuilderRegistry getToolingRegistry()
/*     */   {
/* 103 */     return this$0.toolingRegistry;
/*     */   }
/*     */   
/*     */   public LintOptions getLintOptions()
/*     */   {
/* 109 */     return this$0.lintOptions;
/*     */   }
/*     */   
/*     */   public File getReportsDir()
/*     */   {
/* 115 */     return this$0.reportsDir;
/*     */   }
/*     */   
/*     */   public Project getProject()
/*     */   {
/* 121 */     return this$0.getProject();
/*     */   }
/*     */   
/*     */   public BuildToolInfo getBuildTools()
/*     */   {
/* 127 */     return LintBaseTask.access$000(this$0);
/*     */   }
/*     */   
/*     */   public void warn(String message, Object... args)
/*     */   {
/* 132 */     LintBaseTask.LOG.warn(message, args);
/*     */   }
/*     */   
/*     */   public String getGradlePluginVersion()
/*     */   {
/* 138 */     return Version.ANDROID_GRADLE_PLUGIN_VERSION;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.LintBaseTask.LintBaseTaskDescriptor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */