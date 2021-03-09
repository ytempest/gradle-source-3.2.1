/*     */ package com.android.build.gradle.tasks.ir;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TransformVariantScope;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public class GenerateInstantRunAppInfoTask$ConfigAction
/*     */   implements TaskConfigAction<GenerateInstantRunAppInfoTask>
/*     */ {
/*     */   private final VariantScope variantScope;
/*     */   private final TransformVariantScope transformVariantScope;
/*     */   private final FileCollection manifests;
/*     */   
/*     */   public GenerateInstantRunAppInfoTask$ConfigAction(TransformVariantScope transformVariantScope, VariantScope variantScope, FileCollection manifests)
/*     */   {
/* 207 */     this.transformVariantScope = transformVariantScope;
/* 208 */     this.variantScope = variantScope;
/* 209 */     this.manifests = manifests;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 215 */     return transformVariantScope.getTaskName("generate", "InstantRunAppInfo");
/*     */   }
/*     */   
/*     */   public Class<GenerateInstantRunAppInfoTask> getType()
/*     */   {
/* 221 */     return GenerateInstantRunAppInfoTask.class;
/*     */   }
/*     */   
/*     */   public void execute(GenerateInstantRunAppInfoTask task)
/*     */   {
/* 226 */     task.setVariantName(variantScope.getFullVariantName());
/* 227 */     GenerateInstantRunAppInfoTask.access$002(task, variantScope.getInstantRunBuildContext());
/* 228 */     GenerateInstantRunAppInfoTask.access$102(task, new File(variantScope
/* 229 */       .getIncrementalApplicationSupportDir(), "instant-run-bootstrap.jar"));
/*     */     
/* 232 */     GenerateInstantRunAppInfoTask.access$202(task, manifests);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ir.GenerateInstantRunAppInfoTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */