/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import java.io.File;
/*     */ import java.util.Map;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public abstract class TaskOutputHolderImpl
/*     */   implements TaskOutputHolder
/*     */ {
/*  33 */   private static final int OUTPUT_TYPE_SIZE = TaskOutputHolder.TaskOutputType.values().length + TaskOutputHolder.AnchorOutputType.values().length;
/*     */   
/*  35 */   private final Map<TaskOutputHolder.OutputType, FileCollection> outputMap = Maps.newHashMapWithExpectedSize(OUTPUT_TYPE_SIZE);
/*     */   
/*     */   protected abstract Project getProject();
/*     */   
/*     */   public FileCollection getOutput(TaskOutputHolder.OutputType outputType)
/*     */     throws MissingTaskOutputException
/*     */   {
/*  43 */     FileCollection fileCollection = (FileCollection)outputMap.get(outputType);
/*  44 */     if (fileCollection == null) {
/*  45 */       throw new MissingTaskOutputException(outputType);
/*     */     }
/*  47 */     return fileCollection;
/*     */   }
/*     */   
/*     */   public boolean hasOutput(TaskOutputHolder.OutputType outputType)
/*     */   {
/*  52 */     return outputMap.containsKey(outputType);
/*     */   }
/*     */   
/*     */   public ConfigurableFileCollection addTaskOutput(TaskOutputHolder.TaskOutputType outputType, Object file, String taskName)
/*     */     throws TaskOutputAlreadyRegisteredException
/*     */   {
/*  59 */     if (outputMap.containsKey(outputType)) {
/*  60 */       throw new TaskOutputAlreadyRegisteredException(outputType);
/*     */     }
/*     */     
/*  63 */     ConfigurableFileCollection collection = createCollection(file, taskName);
/*  64 */     outputMap.put(outputType, collection);
/*  65 */     return collection;
/*     */   }
/*     */   
/*     */   public ConfigurableFileCollection createAnchorOutput(TaskOutputHolder.AnchorOutputType outputType)
/*     */     throws TaskOutputAlreadyRegisteredException
/*     */   {
/*  72 */     if (outputMap.containsKey(outputType)) {
/*  73 */       throw new TaskOutputAlreadyRegisteredException(outputType);
/*     */     }
/*     */     
/*  76 */     ConfigurableFileCollection fileCollection = getProject().files(new Object[0]);
/*  77 */     outputMap.put(outputType, fileCollection);
/*     */     
/*  79 */     return fileCollection;
/*     */   }
/*     */   
/*     */   public void addToAnchorOutput(TaskOutputHolder.AnchorOutputType outputType, File file, String taskName)
/*     */   {
/*  87 */     addToAnchorOutput(outputType, createCollection(file, taskName));
/*     */   }
/*     */   
/*     */   public void addToAnchorOutput(TaskOutputHolder.AnchorOutputType outputType, FileCollection fileCollection)
/*     */   {
/*  95 */     FileCollection anchorCollection = (FileCollection)outputMap.get(outputType);
/*  96 */     if (anchorCollection == null) {
/*  97 */       throw new IllegalStateException("No Anchor output created for type: " + outputType);
/*     */     }
/*     */     
/* 100 */     if (!(anchorCollection instanceof ConfigurableFileCollection)) {
/* 101 */       throw new IllegalStateException("Anchor File collection for type '" + outputType + "' is not a ConfigurableFileCollection.");
/*     */     }
/*     */     
/* 107 */     ((ConfigurableFileCollection)anchorCollection).from(new Object[] { fileCollection });
/*     */   }
/*     */   
/*     */   protected ConfigurableFileCollection createCollection(Object file, String taskName)
/*     */   {
/* 113 */     ConfigurableFileCollection collection = getProject().files(new Object[] { file });
/* 114 */     if (taskName != null) {
/* 115 */       collection.builtBy(new Object[] { taskName });
/*     */     }
/*     */     
/* 118 */     return collection;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.TaskOutputHolderImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */