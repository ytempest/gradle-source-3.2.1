/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public class InstantRunResourcesApkBuilder$ConfigAction
/*     */   implements TaskConfigAction<InstantRunResourcesApkBuilder>
/*     */ {
/*     */   protected final VariantScope variantScope;
/*     */   private final FileCollection resources;
/*     */   private final TaskOutputHolder.TaskOutputType resInputType;
/*     */   
/*     */   public InstantRunResourcesApkBuilder$ConfigAction(TaskOutputHolder.TaskOutputType resInputType, FileCollection resources, VariantScope scope)
/*     */   {
/* 187 */     this.resInputType = resInputType;
/* 188 */     this.resources = resources;
/* 189 */     variantScope = scope;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 195 */     return variantScope.getTaskName("processInstantRun", "ResourcesApk");
/*     */   }
/*     */   
/*     */   public Class<InstantRunResourcesApkBuilder> getType()
/*     */   {
/* 201 */     return InstantRunResourcesApkBuilder.class;
/*     */   }
/*     */   
/*     */   public void execute(InstantRunResourcesApkBuilder resourcesApkBuilder)
/*     */   {
/* 206 */     resourcesApkBuilder.setVariantName(variantScope.getFullVariantName());
/* 207 */     InstantRunResourcesApkBuilder.access$002(resourcesApkBuilder, resInputType);
/* 208 */     InstantRunResourcesApkBuilder.access$102(resourcesApkBuilder, variantScope.getIncrementalDir(getName()));
/* 209 */     InstantRunResourcesApkBuilder.access$202(resourcesApkBuilder, variantScope.getGlobalScope().getAndroidBuilder());
/* 210 */     InstantRunResourcesApkBuilder.access$302(resourcesApkBuilder, variantScope
/* 211 */       .getVariantConfiguration().getSigningConfig());
/* 212 */     InstantRunResourcesApkBuilder.access$402(resourcesApkBuilder, variantScope.getInstantRunBuildContext());
/* 213 */     InstantRunResourcesApkBuilder.access$502(resourcesApkBuilder, resources);
/* 214 */     InstantRunResourcesApkBuilder.access$602(resourcesApkBuilder, variantScope.getInstantRunResourceApkFolder());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.InstantRunResourcesApkBuilder.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */