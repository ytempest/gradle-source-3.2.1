/*     */ package com.android.build.gradle.internal.process;
/*     */ 
/*     */ import com.android.ide.common.process.JavaProcessExecutor;
/*     */ import com.android.ide.common.process.JavaProcessInfo;
/*     */ import com.android.ide.common.process.ProcessException;
/*     */ import com.android.ide.common.process.ProcessOutput;
/*     */ import com.android.ide.common.process.ProcessOutputHandler;
/*     */ import com.android.ide.common.process.ProcessResult;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.process.ExecResult;
/*     */ import org.gradle.process.JavaExecSpec;
/*     */ 
/*     */ public class GradleJavaProcessExecutor
/*     */   implements JavaProcessExecutor
/*     */ {
/*     */   private final Project project;
/*     */   
/*     */   public GradleJavaProcessExecutor(Project project)
/*     */   {
/*  43 */     this.project = project;
/*     */   }
/*     */   
/*     */   public ProcessResult execute(JavaProcessInfo javaProcessInfo, ProcessOutputHandler processOutputHandler)
/*     */   {
/*  51 */     project.getLogger().info("Executing java process: ", javaProcessInfo.toString());
/*  52 */     ProcessOutput output = processOutputHandler.createOutput();
/*     */     
/*     */     try
/*     */     {
/*  56 */       ExecResult result = project.javaexec(new ExecAction(javaProcessInfo, output, null));
/*     */       try
/*     */       {
/*  59 */         output.close();
/*     */       } catch (IOException e) {
/*  61 */         project.getLogger().warn("Exception while closing sub process streams", e);
/*     */       }
/*     */       
/*     */       try
/*     */       {
/*  66 */         processOutputHandler.handleOutput(output);
/*     */       } catch (ProcessException e) {
/*  68 */         return new OutputHandlerFailedGradleProcessResult(e);
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/*  59 */         output.close();
/*     */       } catch (IOException e) {
/*  61 */         project.getLogger().warn("Exception while closing sub process streams", e);
/*     */       }
/*     */     }
/*     */     
/*     */     ExecResult result;
/*     */     
/*  71 */     return new GradleProcessResult(result, javaProcessInfo);
/*     */   }
/*     */   
/*     */   private static class ExecAction
/*     */     implements Action<JavaExecSpec>
/*     */   {
/*     */     private final JavaProcessInfo javaProcessInfo;
/*     */     
/*     */     private final ProcessOutput processOutput;
/*     */     
/*     */     private ExecAction(JavaProcessInfo javaProcessInfo, ProcessOutput processOutput)
/*     */     {
/*  84 */       this.javaProcessInfo = javaProcessInfo;
/*  85 */       this.processOutput = processOutput;
/*     */     }
/*     */     
/*     */     public void execute(JavaExecSpec javaExecSpec)
/*     */     {
/*  90 */       javaExecSpec.classpath(new Object[] { new File(javaProcessInfo.getClasspath()) });
/*  91 */       javaExecSpec.setMain(javaProcessInfo.getMainClass());
/*  92 */       javaExecSpec.args(javaProcessInfo.getArgs());
/*  93 */       javaExecSpec.jvmArgs(javaProcessInfo.getJvmArgs());
/*  94 */       javaExecSpec.environment(javaProcessInfo.getEnvironment());
/*  95 */       javaExecSpec.setStandardOutput(processOutput.getStandardOutput());
/*  96 */       javaExecSpec.setErrorOutput(processOutput.getErrorOutput());
/*     */       
/*  99 */       javaExecSpec.systemProperty("java.awt.headless", "true");
/*     */       
/* 102 */       javaExecSpec.setIgnoreExitValue(true);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.process.GradleJavaProcessExecutor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */