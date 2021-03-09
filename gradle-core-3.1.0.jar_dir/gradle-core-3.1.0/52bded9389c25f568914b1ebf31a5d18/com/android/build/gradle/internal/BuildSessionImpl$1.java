/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import org.gradle.BuildListener;
/*     */ import org.gradle.BuildResult;
/*     */ import org.gradle.api.initialization.Settings;
/*     */ import org.gradle.api.invocation.Gradle;
/*     */ 
/*     */ class BuildSessionImpl$1
/*     */   implements BuildListener
/*     */ {
/*     */   BuildSessionImpl$1(BuildSessionImpl this$0) {}
/*     */   
/*     */   public void buildStarted(Gradle gradle) {}
/*     */   
/*     */   public void settingsEvaluated(Settings settings) {}
/*     */   
/*     */   public void projectsLoaded(Gradle gradle) {}
/*     */   
/*     */   public void projectsEvaluated(Gradle gradle) {}
/*     */   
/*     */   public void buildFinished(BuildResult buildResult)
/*     */   {
/* 172 */     BuildSessionImpl.access$000(this$0);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.BuildSessionImpl.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */