/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.dsl.TestOptions;
/*     */ import com.android.build.gradle.internal.dsl.TestOptions.UnitTestOptions;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.sdklib.IAndroidTarget;
/*     */ import java.io.File;
/*     */ 
/*     */ public class MockableAndroidJarTask$ConfigAction
/*     */   implements TaskConfigAction<MockableAndroidJarTask>
/*     */ {
/*     */   private final GlobalScope scope;
/*     */   private final File mockableJar;
/*     */   
/*     */   public MockableAndroidJarTask$ConfigAction(GlobalScope scope, File mockableJar)
/*     */   {
/* 109 */     this.scope = scope;
/* 110 */     this.mockableJar = mockableJar;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 116 */     return "mockableAndroidJar";
/*     */   }
/*     */   
/*     */   public Class<MockableAndroidJarTask> getType()
/*     */   {
/* 122 */     return MockableAndroidJarTask.class;
/*     */   }
/*     */   
/*     */   public void execute(MockableAndroidJarTask task)
/*     */   {
/* 127 */     task.setGroup("build");
/* 128 */     task.setDescription("Creates a version of android.jar that's suitable for unit tests.");
/*     */     
/* 130 */     MockableAndroidJarTask.access$002(task, scope
/* 131 */       .getExtension().getTestOptions().getUnitTests().isReturnDefaultValues());
/*     */     
/* 133 */     MockableAndroidJarTask.access$102(task, new File(scope
/*     */     
/* 135 */       .getAndroidBuilder()
/* 136 */       .getTarget()
/* 137 */       .getPath(1)));
/*     */     
/* 139 */     MockableAndroidJarTask.access$202(task, mockableJar);
/* 140 */     MockableAndroidJarTask.access$302(task, scope.getBuildCache());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.MockableAndroidJarTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */