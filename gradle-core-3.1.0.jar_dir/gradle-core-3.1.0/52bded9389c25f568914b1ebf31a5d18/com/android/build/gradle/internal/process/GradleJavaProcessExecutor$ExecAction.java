/*     */ package com.android.build.gradle.internal.process;
/*     */ 
/*     */ import com.android.ide.common.process.JavaProcessInfo;
/*     */ import com.android.ide.common.process.ProcessOutput;
/*     */ import java.io.File;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.process.JavaExecSpec;
/*     */ 
/*     */ class GradleJavaProcessExecutor$ExecAction
/*     */   implements Action<JavaExecSpec>
/*     */ {
/*     */   private final JavaProcessInfo javaProcessInfo;
/*     */   private final ProcessOutput processOutput;
/*     */   
/*     */   private GradleJavaProcessExecutor$ExecAction(JavaProcessInfo javaProcessInfo, ProcessOutput processOutput)
/*     */   {
/*  84 */     this.javaProcessInfo = javaProcessInfo;
/*  85 */     this.processOutput = processOutput;
/*     */   }
/*     */   
/*     */   public void execute(JavaExecSpec javaExecSpec)
/*     */   {
/*  90 */     javaExecSpec.classpath(new Object[] { new File(javaProcessInfo.getClasspath()) });
/*  91 */     javaExecSpec.setMain(javaProcessInfo.getMainClass());
/*  92 */     javaExecSpec.args(javaProcessInfo.getArgs());
/*  93 */     javaExecSpec.jvmArgs(javaProcessInfo.getJvmArgs());
/*  94 */     javaExecSpec.environment(javaProcessInfo.getEnvironment());
/*  95 */     javaExecSpec.setStandardOutput(processOutput.getStandardOutput());
/*  96 */     javaExecSpec.setErrorOutput(processOutput.getErrorOutput());
/*     */     
/*  99 */     javaExecSpec.systemProperty("java.awt.headless", "true");
/*     */     
/* 102 */     javaExecSpec.setIgnoreExitValue(true);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.process.GradleJavaProcessExecutor.ExecAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */