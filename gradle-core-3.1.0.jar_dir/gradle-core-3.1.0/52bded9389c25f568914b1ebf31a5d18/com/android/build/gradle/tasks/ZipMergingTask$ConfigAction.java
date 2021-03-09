/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public class ZipMergingTask$ConfigAction
/*     */   implements TaskConfigAction<ZipMergingTask>
/*     */ {
/*     */   private VariantScope scope;
/*     */   private File outputFile;
/*     */   
/*     */   public ZipMergingTask$ConfigAction(VariantScope scope, File outputFile)
/*     */   {
/* 116 */     this.scope = scope;
/* 117 */     this.outputFile = outputFile;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 123 */     return scope.getTaskName("createFullJar");
/*     */   }
/*     */   
/*     */   public Class<ZipMergingTask> getType()
/*     */   {
/* 129 */     return ZipMergingTask.class;
/*     */   }
/*     */   
/*     */   public void execute(ZipMergingTask task)
/*     */   {
/* 134 */     task.init(scope
/* 135 */       .getOutput(TaskOutputHolder.TaskOutputType.LIBRARY_CLASSES)
/* 136 */       .plus(scope.getOutput(TaskOutputHolder.TaskOutputType.LIBRARY_JAVA_RES)), outputFile);
/*     */     
/* 138 */     task.setVariantName(scope.getFullVariantName());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ZipMergingTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */