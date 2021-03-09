/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.ndk.NdkHandler;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ 
/*     */ public class ShaderCompile$ConfigAction
/*     */   implements TaskConfigAction<ShaderCompile>
/*     */ {
/*     */   VariantScope scope;
/*     */   File outputDir;
/*     */   
/*     */   public ShaderCompile$ConfigAction(VariantScope scope, File outputDir)
/*     */   {
/* 143 */     this.scope = scope;
/* 144 */     this.outputDir = outputDir;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 150 */     return scope.getTaskName("compile", "Shaders");
/*     */   }
/*     */   
/*     */   public Class<ShaderCompile> getType()
/*     */   {
/* 156 */     return ShaderCompile.class;
/*     */   }
/*     */   
/*     */   public void execute(ShaderCompile compileTask)
/*     */   {
/* 161 */     GradleVariantConfiguration variantConfiguration = scope.getVariantConfiguration();
/*     */     
/* 163 */     scope.getVariantData().shaderCompileTask = compileTask;
/*     */     
/* 165 */     compileTask.setAndroidBuilder(scope.getGlobalScope().getAndroidBuilder());
/* 166 */     compileTask.setVariantName(variantConfiguration.getFullName());
/*     */     
/* 168 */     ShaderCompile.access$002(compileTask, scope.getGlobalScope().getNdkHandler().getNdkDirectory());
/*     */     
/* 170 */     compileTask.setSourceDir(scope.getMergeShadersOutputDir());
/* 171 */     compileTask.setOutputDir(outputDir);
/* 172 */     compileTask.setDefaultArgs(variantConfiguration.getDefautGlslcArgs());
/* 173 */     compileTask.setScopedArgs(variantConfiguration.getScopedGlslcArgs());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ShaderCompile.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */