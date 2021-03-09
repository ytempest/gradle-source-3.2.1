/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.bundling.Jar;
/*     */ 
/*     */ class ApplicationTaskManager$1
/*     */   implements TaskConfigAction<Jar>
/*     */ {
/*     */   ApplicationTaskManager$1(ApplicationTaskManager this$0, VariantScope paramVariantScope, FileCollection paramFileCollection1, FileCollection paramFileCollection2, FileCollection paramFileCollection3, File paramFile) {}
/*     */   
/*     */   public String getName()
/*     */   {
/* 414 */     return val$scope.getTaskName("bundleAppClasses");
/*     */   }
/*     */   
/*     */   public Class<Jar> getType()
/*     */   {
/* 420 */     return Jar.class;
/*     */   }
/*     */   
/*     */   public void execute(Jar task)
/*     */   {
/* 425 */     task.from(new Object[] { val$javacOutput });
/* 426 */     task.from(new Object[] { val$preJavacGeneratedBytecode });
/* 427 */     task.from(new Object[] { val$postJavacGeneratedBytecode });
/* 428 */     task.setDestinationDir(val$dest);
/* 429 */     task.setArchiveName("classes.jar");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ApplicationTaskManager.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */