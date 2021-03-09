/*     */ package com.android.build.gradle.internal.profile;
/*     */ 
/*     */ import com.android.build.gradle.internal.LoggerWrapper;
/*     */ import com.android.build.gradle.options.BooleanOption;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.build.gradle.options.StringOption;
/*     */ import com.android.builder.profile.ProcessProfileWriter;
/*     */ import com.android.builder.profile.ProcessProfileWriterFactory;
/*     */ import java.io.File;
/*     */ import java.nio.file.Path;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.format.DateTimeFormatter;
/*     */ import java.util.Locale;
/*     */ import org.gradle.BuildAdapter;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.invocation.Gradle;
/*     */ import org.gradle.initialization.BuildCompletionListener;
/*     */ 
/*     */ public final class ProfilerInitializer
/*     */ {
/*     */   private static final String PROFILE_DIRECTORY = "android-profile";
/*  47 */   private static final DateTimeFormatter PROFILE_FILE_NAME = DateTimeFormatter.ofPattern("'profile-'YYYY-MM-dd-HH-mm-ss-SSS'.rawproto'", Locale.US);
/*     */   
/*  49 */   private static final Object lock = new Object();
/*     */   
/*     */   private static volatile RecordingBuildListener recordingBuildListener;
/*     */   
/*     */   public static void init(Project project, ProjectOptions projectOptions)
/*     */   {
/*  64 */     synchronized (lock)
/*     */     {
/*  66 */       if (recordingBuildListener != null) {
/*  67 */         return;
/*     */       }
/*  69 */       ProcessProfileWriterFactory.initialize(
/*  70 */         project.getRootProject().getProjectDir(), project
/*  71 */         .getGradle().getGradleVersion(), new LoggerWrapper(project
/*  72 */         .getLogger()), projectOptions
/*  73 */         .get(BooleanOption.ENABLE_PROFILE_JSON));
/*  74 */       recordingBuildListener = new RecordingBuildListener(ProcessProfileWriter.get());
/*  75 */       project.getGradle().addListener(recordingBuildListener);
/*     */     }
/*     */     
/*  79 */     project.getGradle().addListener(new ProfileShutdownListener(project
/*     */     
/*  81 */       .getGradle(), projectOptions
/*  82 */       .get(StringOption.PROFILE_OUTPUT_DIR), projectOptions
/*  83 */       .get(BooleanOption.ENABLE_PROFILE_JSON)));
/*     */   }
/*     */   
/*     */   private static final class ProfileShutdownListener
/*     */     extends BuildAdapter implements BuildCompletionListener
/*     */   {
/*     */     private final Gradle gradle;
/*     */     private String profileDirProperty;
/*  91 */     private Path profileDir = null;
/*     */     
/*     */     private boolean enableProfileJson;
/*     */     
/*     */     ProfileShutdownListener(Gradle gradle, String profileDirProperty, boolean enableProfileJson)
/*     */     {
/*  98 */       this.gradle = gradle;
/*  99 */       this.profileDirProperty = profileDirProperty;
/* 100 */       this.enableProfileJson = enableProfileJson;
/*     */     }
/*     */     
/*     */     public void projectsEvaluated(Gradle gradle)
/*     */     {
/* 105 */       if (profileDirProperty != null) {
/* 106 */         profileDir = gradle.getRootProject().file(profileDirProperty).toPath();
/* 107 */       } else if (enableProfileJson)
/*     */       {
/* 110 */         profileDir = gradle.getRootProject().getBuildDir().toPath().resolve("android-profile");
/*     */       }
/*     */     }
/*     */     
/*     */     public void completed()
/*     */     {
/*     */       try {
/* 117 */         synchronized (ProfilerInitializer.lock) {
/* 118 */           if (ProfilerInitializer.recordingBuildListener != null) {
/* 119 */             gradle.removeListener(ProfilerInitializer.recordingBuildListener);
/* 120 */             ProfilerInitializer.access$102(null);
/*     */             
/* 125 */             Path profileFile = profileDir == null ? null : profileDir.resolve(
/* 126 */               ProfilerInitializer.PROFILE_FILE_NAME.format(LocalDateTime.now()));
/*     */             
/* 128 */             ProcessProfileWriterFactory.shutdownAndMaybeWrite(profileFile);
/*     */           }
/*     */         }
/*     */       } catch (InterruptedException e) {
/* 132 */         Thread.currentThread().interrupt();
/* 133 */         throw new RuntimeException(e);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.profile.ProfilerInitializer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */