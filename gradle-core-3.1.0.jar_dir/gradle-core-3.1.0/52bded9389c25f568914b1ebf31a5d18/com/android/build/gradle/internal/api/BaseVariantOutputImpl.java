/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.build.FilterData;
/*     */ import com.android.build.OutputFile;
/*     */ import com.android.build.gradle.api.BaseVariantOutput;
/*     */ import com.android.build.gradle.internal.variant.TaskContainer;
/*     */ import com.android.build.gradle.internal.variant.TaskContainer.TaskKind;
/*     */ import com.android.build.gradle.tasks.ManifestProcessorTask;
/*     */ import com.android.build.gradle.tasks.ProcessAndroidResources;
/*     */ import com.android.ide.common.build.ApkData;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import org.gradle.api.GradleException;
/*     */ import org.gradle.api.Task;
/*     */ 
/*     */ public abstract class BaseVariantOutputImpl
/*     */   implements BaseVariantOutput
/*     */ {
/*     */   protected final TaskContainer taskContainer;
/*     */   protected final ApkData apkData;
/*     */   
/*     */   protected BaseVariantOutputImpl(ApkData apkData, TaskContainer taskContainer)
/*     */   {
/*  48 */     this.apkData = apkData;
/*  49 */     this.taskContainer = taskContainer;
/*     */   }
/*     */   
/*     */   public OutputFile getMainOutputFile()
/*     */   {
/*  55 */     return getApkData().getMainOutputFile();
/*     */   }
/*     */   
/*     */   protected ApkData getApkData()
/*     */   {
/*  60 */     return apkData;
/*     */   }
/*     */   
/*     */   public File getOutputFile()
/*     */   {
/*  66 */     return getApkData().getMainOutputFile().getOutputFile();
/*     */   }
/*     */   
/*     */   public ImmutableList<OutputFile> getOutputs()
/*     */   {
/*  72 */     return ImmutableList.of(this);
/*     */   }
/*     */   
/*     */   public ProcessAndroidResources getProcessResources()
/*     */   {
/*  78 */     return (ProcessAndroidResources)taskContainer.getTaskByType(ProcessAndroidResources.class);
/*     */   }
/*     */   
/*     */   public ManifestProcessorTask getProcessManifest()
/*     */   {
/*  84 */     return (ManifestProcessorTask)taskContainer.getTaskByType(ManifestProcessorTask.class);
/*     */   }
/*     */   
/*     */   public Task getAssemble()
/*     */   {
/*  90 */     return taskContainer.getTaskByKind(TaskContainer.TaskKind.ASSEMBLE);
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  96 */     return getApkData().getBaseName();
/*     */   }
/*     */   
/*     */   public String getBaseName()
/*     */   {
/* 102 */     return getApkData().getBaseName();
/*     */   }
/*     */   
/*     */   public String getDirName()
/*     */   {
/* 108 */     return getApkData().getDirName();
/*     */   }
/*     */   
/*     */   public String getOutputType()
/*     */   {
/* 114 */     return getApkData().getOutputType();
/*     */   }
/*     */   
/*     */   public Collection<String> getFilterTypes()
/*     */   {
/* 120 */     return getApkData().getFilterTypes();
/*     */   }
/*     */   
/*     */   public Collection<FilterData> getFilters()
/*     */   {
/* 126 */     return getApkData().getFilters();
/*     */   }
/*     */   
/*     */   public String getFilter(String filterType)
/*     */   {
/* 131 */     return getApkData().getFilter(filterType);
/*     */   }
/*     */   
/*     */   public String getOutputFileName() {
/* 135 */     return apkData.getOutputFileName();
/*     */   }
/*     */   
/*     */   public void setOutputFileName(String outputFileName) {
/* 139 */     if (new File(outputFileName).isAbsolute()) {
/* 140 */       throw new GradleException("Absolute path are not supported when setting an output file name");
/*     */     }
/*     */     
/* 143 */     apkData.setOutputFileName(outputFileName);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.BaseVariantOutputImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */