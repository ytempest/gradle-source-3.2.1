/*     */ package com.android.build.gradle.tasks.factory;
/*     */ 
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext.TaskType;
/*     */ import com.android.builder.profile.ProcessProfileWriter;
/*     */ import com.android.sdklib.AndroidTargetHash;
/*     */ import com.android.sdklib.AndroidVersion;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import com.google.wireless.android.sdk.stats.AnnotationProcessorInfo;
/*     */ import com.google.wireless.android.sdk.stats.AnnotationProcessorInfo.Builder;
/*     */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.Builder;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.UncheckedIOException;
/*     */ import java.util.List;
/*     */ import org.gradle.api.JavaVersion;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.tasks.CacheableTask;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.Internal;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.gradle.api.tasks.PathSensitive;
/*     */ import org.gradle.api.tasks.PathSensitivity;
/*     */ import org.gradle.api.tasks.compile.JavaCompile;
/*     */ import org.gradle.api.tasks.incremental.IncrementalTaskInputs;
/*     */ 
/*     */ @CacheableTask
/*     */ public class AndroidJavaCompile
/*     */   extends JavaCompile
/*     */ {
/*     */   String compileSdkVersion;
/*     */   InstantRunBuildContext mInstantRunBuildContext;
/*     */   File annotationProcessorOutputFolder;
/*     */   FileCollection processorListFile;
/*     */   String variantName;
/*     */   FileCollection dataBindingDependencyArtifacts;
/*     */   FileCollection dataBindingClassLogDir;
/*     */   File dataBindingArtifactOutputDirectory;
/*     */   
/*     */   @PathSensitive(PathSensitivity.NONE)
/*     */   @InputFiles
/*     */   public FileCollection getProcessorListFile()
/*     */   {
/*  78 */     return processorListFile;
/*     */   }
/*     */   
/*     */   @OutputDirectory
/*     */   public File getAnnotationProcessorOutputFolder() {
/*  83 */     return annotationProcessorOutputFolder;
/*     */   }
/*     */   
/*     */   @OutputDirectory
/*     */   @Optional
/*     */   public File getDataBindingArtifactOutputDirectory() {
/*  89 */     return dataBindingArtifactOutputDirectory;
/*     */   }
/*     */   
/*     */   @PathSensitive(PathSensitivity.RELATIVE)
/*     */   @InputFiles
/*     */   @Optional
/*     */   public FileCollection getDataBindingDependencyArtifacts() {
/*  96 */     return dataBindingDependencyArtifacts;
/*     */   }
/*     */   
/*     */   @PathSensitive(PathSensitivity.RELATIVE)
/*     */   @InputFiles
/*     */   @Optional
/*     */   public FileCollection getDataBindingClassLogDir() {
/* 103 */     return dataBindingClassLogDir;
/*     */   }
/*     */   
/*     */   protected void compile(IncrementalTaskInputs inputs)
/*     */   {
/* 108 */     getLogger().info("Compiling with source level {} and target level {}.", 
/*     */     
/* 110 */       getSourceCompatibility(), 
/* 111 */       getTargetCompatibility());
/* 112 */     if ((isPostN()) && 
/* 113 */       (!JavaVersion.current().isJava8Compatible())) {
/* 114 */       throw new RuntimeException("compileSdkVersion '" + compileSdkVersion + "' requires JDK 1.8 or later to compile.");
/*     */     }
/*     */     
/* 119 */     processAnalytics();
/*     */     
/* 122 */     FileUtils.mkdirs(annotationProcessorOutputFolder);
/*     */     
/* 124 */     mInstantRunBuildContext.startRecording(InstantRunBuildContext.TaskType.JAVAC);
/* 125 */     super.compile(inputs);
/* 126 */     mInstantRunBuildContext.stopRecording(InstantRunBuildContext.TaskType.JAVAC);
/*     */   }
/*     */   
/*     */   void processAnalytics()
/*     */   {
/* 132 */     Gson gson = new GsonBuilder().create();
/*     */     try {
/* 134 */       FileReader reader = new FileReader(processorListFile.getSingleFile());Throwable localThrowable3 = null;
/* 135 */       try { classNames = (List)gson.fromJson(reader, new TypeToken() {}.getType());
/*     */       }
/*     */       catch (Throwable localThrowable1)
/*     */       {
/*     */         List<String> classNames;
/* 134 */         localThrowable3 = localThrowable1;throw localThrowable1;
/*     */       } finally {
/* 136 */         if (reader != null) if (localThrowable3 != null) try { reader.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else reader.close(); } } catch (IOException e) { List<String> classNames;
/* 137 */       throw new UncheckedIOException(e);
/*     */     }
/*     */     List<String> classNames;
/* 140 */     String projectPath = getProject().getPath();
/*     */     
/* 142 */     GradleBuildVariant.Builder variant = ProcessProfileWriter.getOrCreateVariant(projectPath, variantName);
/* 143 */     for (String processorName : classNames) {
/* 144 */       AnnotationProcessorInfo.Builder builder = AnnotationProcessorInfo.newBuilder();
/* 145 */       builder.setSpec(processorName);
/* 146 */       variant.addAnnotationProcessors(builder);
/*     */     }
/*     */   }
/*     */   
/*     */   @Internal
/*     */   private boolean isPostN() {
/* 152 */     AndroidVersion hash = AndroidTargetHash.getVersionFromHash(compileSdkVersion);
/* 153 */     return (hash != null) && (hash.getApiLevel() >= 24);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.factory.AndroidJavaCompile
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */