/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.Abi;
/*     */ import com.android.build.gradle.internal.ndk.NdkHandler;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ExternalNativeCleanTask$ConfigAction
/*     */   implements TaskConfigAction<ExternalNativeCleanTask>
/*     */ {
/*     */   private final ExternalNativeJsonGenerator generator;
/*     */   private final VariantScope scope;
/*     */   private final AndroidBuilder androidBuilder;
/*     */   
/*     */   public ExternalNativeCleanTask$ConfigAction(ExternalNativeJsonGenerator generator, VariantScope scope, AndroidBuilder androidBuilder)
/*     */   {
/* 145 */     this.generator = generator;
/* 146 */     this.scope = scope;
/* 147 */     this.androidBuilder = androidBuilder;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 153 */     return scope.getTaskName("externalNativeBuildClean");
/*     */   }
/*     */   
/*     */   public Class<ExternalNativeCleanTask> getType()
/*     */   {
/* 159 */     return ExternalNativeCleanTask.class;
/*     */   }
/*     */   
/*     */   public void execute(ExternalNativeCleanTask task)
/*     */   {
/* 164 */     BaseVariantData variantData = scope.getVariantData();
/* 165 */     task.setVariantName(variantData.getName());
/*     */     
/* 170 */     List<String> abiNames = Lists.newArrayList();
/* 171 */     for (Abi abi : NdkHandler.getAbiList()) {
/* 172 */       abiNames.add(abi.getName());
/*     */     }
/* 174 */     task.setAndroidBuilder(androidBuilder);
/* 175 */     ExternalNativeCleanTask.access$002(task, 
/* 176 */       ExternalNativeBuildTaskUtils.getOutputJsons(generator
/* 177 */       .getJsonFolder(), abiNames));
/* 178 */     ExternalNativeCleanTask.access$102(task, generator.getStlSharedObjectFiles());
/* 179 */     ExternalNativeCleanTask.access$202(task, generator.getObjFolder());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ExternalNativeCleanTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */