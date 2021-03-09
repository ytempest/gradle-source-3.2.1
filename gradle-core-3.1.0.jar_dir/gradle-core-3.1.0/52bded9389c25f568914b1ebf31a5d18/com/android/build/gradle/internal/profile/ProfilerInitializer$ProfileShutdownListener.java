/*     */ package com.android.build.gradle.internal.profile;
/*     */ 
/*     */ import com.android.builder.profile.ProcessProfileWriterFactory;
/*     */ import java.io.File;
/*     */ import java.nio.file.Path;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.format.DateTimeFormatter;
/*     */ import org.gradle.BuildAdapter;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.invocation.Gradle;
/*     */ import org.gradle.initialization.BuildCompletionListener;
/*     */ 
/*     */ final class ProfilerInitializer$ProfileShutdownListener
/*     */   extends BuildAdapter
/*     */   implements BuildCompletionListener
/*     */ {
/*     */   private final Gradle gradle;
/*     */   private String profileDirProperty;
/*  91 */   private Path profileDir = null;
/*     */   
/*     */   private boolean enableProfileJson;
/*     */   
/*     */   ProfilerInitializer$ProfileShutdownListener(Gradle gradle, String profileDirProperty, boolean enableProfileJson)
/*     */   {
/*  98 */     this.gradle = gradle;
/*  99 */     this.profileDirProperty = profileDirProperty;
/* 100 */     this.enableProfileJson = enableProfileJson;
/*     */   }
/*     */   
/*     */   public void projectsEvaluated(Gradle gradle)
/*     */   {
/* 105 */     if (profileDirProperty != null) {
/* 106 */       profileDir = gradle.getRootProject().file(profileDirProperty).toPath();
/* 107 */     } else if (enableProfileJson)
/*     */     {
/* 110 */       profileDir = gradle.getRootProject().getBuildDir().toPath().resolve("android-profile");
/*     */     }
/*     */   }
/*     */   
/*     */   public void completed()
/*     */   {
/*     */     try {
/* 117 */       synchronized () {
/* 118 */         if (ProfilerInitializer.access$100() != null) {
/* 119 */           gradle.removeListener(ProfilerInitializer.access$100());
/* 120 */           ProfilerInitializer.access$102(null);
/*     */           
/* 125 */           Path profileFile = profileDir == null ? null : profileDir.resolve(
/* 126 */             ProfilerInitializer.access$200().format(LocalDateTime.now()));
/*     */           
/* 128 */           ProcessProfileWriterFactory.shutdownAndMaybeWrite(profileFile);
/*     */         }
/*     */       }
/*     */     } catch (InterruptedException e) {
/* 132 */       Thread.currentThread().interrupt();
/* 133 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.profile.ProfilerInitializer.ProfileShutdownListener
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */