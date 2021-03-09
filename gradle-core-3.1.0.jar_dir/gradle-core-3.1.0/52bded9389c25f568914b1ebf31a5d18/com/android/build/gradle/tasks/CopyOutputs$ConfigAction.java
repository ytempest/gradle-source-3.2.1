/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ import org.gradle.api.Project;
/*     */ 
/*     */ public class CopyOutputs$ConfigAction
/*     */   implements TaskConfigAction<CopyOutputs>
/*     */ {
/*     */   private final VariantScope variantScope;
/*     */   private final File outputDirectory;
/*     */   
/*     */   public CopyOutputs$ConfigAction(VariantScope variantScope, File outputDirectory)
/*     */   {
/* 113 */     this.variantScope = variantScope;
/* 114 */     this.outputDirectory = outputDirectory;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 120 */     return variantScope.getTaskName("copyOutputs");
/*     */   }
/*     */   
/*     */   public Class<CopyOutputs> getType()
/*     */   {
/* 126 */     return CopyOutputs.class;
/*     */   }
/*     */   
/*     */   public void execute(CopyOutputs task)
/*     */   {
/* 131 */     task.setVariantName(variantScope.getFullVariantName());
/* 132 */     fullApks = variantScope.getOutput(TaskOutputHolder.TaskOutputType.FULL_APK);
/* 133 */     Project project = variantScope.getGlobalScope().getProject();
/*     */     
/* 137 */     abiSplits = (variantScope.hasOutput(TaskOutputHolder.TaskOutputType.ABI_PACKAGED_SPLIT) ? variantScope.getOutput(TaskOutputHolder.TaskOutputType.ABI_PACKAGED_SPLIT) : project.files(new Object[0]));
/*     */     
/* 142 */     resourcesSplits = (variantScope.hasOutput(TaskOutputHolder.TaskOutputType.DENSITY_OR_LANGUAGE_PACKAGED_SPLIT) ? variantScope.getOutput(TaskOutputHolder.TaskOutputType.DENSITY_OR_LANGUAGE_PACKAGED_SPLIT) : project.files(new Object[0]));
/* 143 */     destinationDir = outputDirectory;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.CopyOutputs.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */