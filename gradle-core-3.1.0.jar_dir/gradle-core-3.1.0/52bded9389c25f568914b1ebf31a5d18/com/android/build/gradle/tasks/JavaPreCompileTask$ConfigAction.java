/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.api.JavaCompileOptions;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.builder.core.VariantType;
/*     */ import java.io.File;
/*     */ 
/*     */ public class JavaPreCompileTask$ConfigAction
/*     */   implements TaskConfigAction<JavaPreCompileTask>
/*     */ {
/*     */   private final VariantScope scope;
/*     */   private final File processorListFile;
/*     */   
/*     */   public JavaPreCompileTask$ConfigAction(VariantScope scope, File processorListFile)
/*     */   {
/* 226 */     this.scope = scope;
/* 227 */     this.processorListFile = processorListFile;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 233 */     return scope.getTaskName("javaPreCompile");
/*     */   }
/*     */   
/*     */   public Class<JavaPreCompileTask> getType()
/*     */   {
/* 239 */     return JavaPreCompileTask.class;
/*     */   }
/*     */   
/*     */   public void execute(JavaPreCompileTask task)
/*     */   {
/* 244 */     task.init(processorListFile, scope
/*     */     
/* 246 */       .getVariantData().getType().isForTesting() ? scope
/* 247 */       .getVariantData().getType().getPrefix() + "AnnotationProcessor" : "annotationProcessor", scope
/*     */       
/* 249 */       .getArtifactCollection(AndroidArtifacts.ConsumedConfigType.ANNOTATION_PROCESSOR, AndroidArtifacts.ArtifactScope.ALL, AndroidArtifacts.ArtifactType.JAR), scope
/* 250 */       .getJavaClasspathArtifacts(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactType.CLASSES, null), scope
/* 251 */       .getVariantConfiguration()
/* 252 */       .getJavaCompileOptions()
/* 253 */       .getAnnotationProcessorOptions(), scope
/* 254 */       .getVariantData().getType().isForTesting(), false);
/*     */     
/* 256 */     task.setVariantName(scope.getFullVariantName());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.JavaPreCompileTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */