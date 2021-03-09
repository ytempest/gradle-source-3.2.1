/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.builder.testing.api.TestServer;
/*     */ import com.android.utils.StringHelper;
/*     */ 
/*     */ public class TestServerTask$TestServerTaskConfigAction
/*     */   implements TaskConfigAction<TestServerTask>
/*     */ {
/*     */   private final VariantScope scope;
/*     */   private final TestServer testServer;
/*     */   
/*     */   public TestServerTask$TestServerTaskConfigAction(VariantScope scope, TestServer testServer)
/*     */   {
/* 121 */     this.scope = scope;
/* 122 */     this.testServer = testServer;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 128 */     return 
/*     */     
/* 130 */       testServer.getName() + "Upload";
/*     */   }
/*     */   
/*     */   public Class<TestServerTask> getType()
/*     */   {
/* 136 */     return TestServerTask.class;
/*     */   }
/*     */   
/*     */   public void execute(TestServerTask serverTask)
/*     */   {
/* 142 */     BaseVariantData testedVariantData = scope.getTestedVariantData();
/*     */     
/* 144 */     String variantName = scope.getVariantConfiguration().getFullName();
/* 145 */     serverTask.setDescription("Uploads APKs for Build '" + variantName + "' to Test Server '" + 
/*     */     
/* 149 */       StringHelper.capitalize(testServer.getName()) + "'.");
/*     */     
/* 151 */     serverTask.setGroup("verification");
/* 152 */     serverTask.setVariantName(variantName);
/*     */     
/* 154 */     serverTask.setTestServer(testServer);
/*     */     
/* 156 */     if (testedVariantData != null)
/*     */     {
/* 159 */       if (testedVariantData.getScope().hasOutput(TaskOutputHolder.TaskOutputType.APK)) {
/* 160 */         serverTask.setTestedApks(testedVariantData
/*     */         
/* 162 */           .getScope()
/* 163 */           .getOutput(TaskOutputHolder.TaskOutputType.APK));
/*     */       }
/*     */     }
/* 166 */     serverTask.setTestApks(scope.getOutput(TaskOutputHolder.TaskOutputType.APK));
/*     */     
/* 168 */     if (!testServer.isConfigured()) {
/* 169 */       serverTask.setEnabled(false);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.TestServerTask.TestServerTaskConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */