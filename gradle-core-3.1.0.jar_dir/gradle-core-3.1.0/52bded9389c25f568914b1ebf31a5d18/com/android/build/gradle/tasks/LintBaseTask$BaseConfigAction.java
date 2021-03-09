/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.SdkHandler;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import java.io.File;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.artifacts.ConfigurationContainer;
/*     */ 
/*     */ public abstract class LintBaseTask$BaseConfigAction<T extends LintBaseTask>
/*     */   implements TaskConfigAction<T>
/*     */ {
/*     */   private final GlobalScope globalScope;
/*     */   
/*     */   public LintBaseTask$BaseConfigAction(GlobalScope globalScope)
/*     */   {
/* 285 */     this.globalScope = globalScope;
/*     */   }
/*     */   
/*     */   protected GlobalScope getGlobalScope()
/*     */   {
/* 290 */     return globalScope;
/*     */   }
/*     */   
/*     */   public void execute(T lintTask)
/*     */   {
/* 295 */     lintTask.setGroup("verification");
/* 296 */     lintOptions = globalScope.getExtension().getLintOptions();
/* 297 */     File sdkFolder = globalScope.getSdkHandler().getSdkFolder();
/* 298 */     if (sdkFolder != null) {
/* 299 */       sdkHome = sdkFolder;
/*     */     }
/*     */     
/* 302 */     toolingRegistry = globalScope.getToolingRegistry();
/* 303 */     reportsDir = globalScope.getReportsDir();
/* 304 */     lintTask.setAndroidBuilder(globalScope.getAndroidBuilder());
/*     */     
/* 307 */     lintClassPath = globalScope.getProject().getConfigurations().getByName("lintClassPath");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.LintBaseTask.BaseConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */