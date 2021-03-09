/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ 
/*     */ public class SourceSetsTask$ConfigAction
/*     */   implements TaskConfigAction<SourceSetsTask>
/*     */ {
/*     */   private final AndroidConfig extension;
/*     */   
/*     */   public SourceSetsTask$ConfigAction(AndroidConfig extension)
/*     */   {
/* 116 */     this.extension = extension;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 122 */     return "sourceSets";
/*     */   }
/*     */   
/*     */   public Class<SourceSetsTask> getType()
/*     */   {
/* 128 */     return SourceSetsTask.class;
/*     */   }
/*     */   
/*     */   public void execute(SourceSetsTask sourceSetsTask)
/*     */   {
/* 133 */     sourceSetsTask.setConfig(extension);
/* 134 */     sourceSetsTask.setDescription("Prints out all the source sets defined in this project.");
/*     */     
/* 136 */     sourceSetsTask.setGroup("Android");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.SourceSetsTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */