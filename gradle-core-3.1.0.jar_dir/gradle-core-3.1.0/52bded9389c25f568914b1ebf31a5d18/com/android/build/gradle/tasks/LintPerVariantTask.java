/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.utils.StringHelper;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class LintPerVariantTask
/*     */   extends LintBaseTask
/*     */ {
/*     */   private LintBaseTask.VariantInputs variantInputs;
/*     */   private boolean fatalOnly;
/*     */   
/*     */   @InputFiles
/*     */   @Optional
/*     */   public FileCollection getVariantInputs()
/*     */   {
/*  36 */     return variantInputs.getAllInputs();
/*     */   }
/*     */   
/*     */   @TaskAction
/*  41 */   public void lint() { runLint(new LintPerVariantTaskDescriptor(null)); }
/*     */   
/*     */   private class LintPerVariantTaskDescriptor extends LintBaseTask.LintBaseTaskDescriptor {
/*  44 */     private LintPerVariantTaskDescriptor() { super(); }
/*     */     
/*     */     public String getVariantName()
/*     */     {
/*  48 */       return LintPerVariantTask.this.getVariantName();
/*     */     }
/*     */     
/*     */     public LintBaseTask.VariantInputs getVariantInputs(String variantName)
/*     */     {
/*  54 */       assert (variantName.equals(getVariantName()));
/*  55 */       return variantInputs;
/*     */     }
/*     */     
/*     */     public boolean isFatalOnly()
/*     */     {
/*  60 */       return fatalOnly;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ConfigAction extends LintBaseTask.BaseConfigAction<LintPerVariantTask>
/*     */   {
/*     */     private final VariantScope scope;
/*     */     
/*     */     public ConfigAction(VariantScope scope) {
/*  69 */       super();
/*  70 */       this.scope = scope;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/*  76 */       return scope.getTaskName("lint");
/*     */     }
/*     */     
/*     */     public Class<LintPerVariantTask> getType()
/*     */     {
/*  82 */       return LintPerVariantTask.class;
/*     */     }
/*     */     
/*     */     public void execute(LintPerVariantTask lint)
/*     */     {
/*  87 */       super.execute(lint);
/*     */       
/*  89 */       lint.setVariantName(scope.getVariantConfiguration().getFullName());
/*     */       
/*  91 */       variantInputs = new LintBaseTask.VariantInputs(scope);
/*     */       
/*  93 */       lint.setDescription(
/*  94 */         StringHelper.appendCapitalized("Runs lint on the ", scope
/*     */         
/*  96 */         .getVariantConfiguration().getFullName(), " build."));
/*     */     }
/*     */   }
/*     */   
/*     */   public static class VitalConfigAction extends LintBaseTask.BaseConfigAction<LintPerVariantTask>
/*     */   {
/*     */     private final VariantScope scope;
/*     */     
/*     */     public VitalConfigAction(VariantScope scope)
/*     */     {
/* 106 */       super();
/* 107 */       this.scope = scope;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 113 */       return scope.getTaskName("lintVital");
/*     */     }
/*     */     
/*     */     public Class<LintPerVariantTask> getType()
/*     */     {
/* 119 */       return LintPerVariantTask.class;
/*     */     }
/*     */     
/*     */     public void execute(LintPerVariantTask task)
/*     */     {
/* 124 */       super.execute(task);
/*     */       
/* 126 */       String variantName = scope.getVariantData().getVariantConfiguration().getFullName();
/* 127 */       task.setVariantName(variantName);
/*     */       
/* 129 */       variantInputs = new LintBaseTask.VariantInputs(scope);
/* 130 */       fatalOnly = true;
/* 131 */       task.setDescription("Runs lint on just the fatal issues in the " + variantName + " build.");
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.LintPerVariantTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */