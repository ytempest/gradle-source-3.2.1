/*     */ package com.android.build.gradle.tasks.factory;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.TestOptions;
/*     */ import com.android.build.gradle.internal.dsl.TestOptions.UnitTestOptions;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.AnchorOutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.internal.variant.TestVariantData;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.sdklib.IAndroidTarget;
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.io.File;
/*     */ import java.util.Objects;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.api.reporting.ConfigurableReport;
/*     */ import org.gradle.api.tasks.testing.TestTaskReports;
/*     */ 
/*     */ public class AndroidUnitTest$ConfigAction
/*     */   implements TaskConfigAction<AndroidUnitTest>
/*     */ {
/*     */   private final VariantScope scope;
/*     */   
/*     */   public AndroidUnitTest$ConfigAction(VariantScope scope)
/*     */   {
/*  85 */     this.scope = ((VariantScope)Preconditions.checkNotNull(scope));
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  91 */     return scope.getTaskName(VariantType.UNIT_TEST.getPrefix());
/*     */   }
/*     */   
/*     */   public Class<AndroidUnitTest> getType()
/*     */   {
/*  97 */     return AndroidUnitTest.class;
/*     */   }
/*     */   
/*     */   public void execute(AndroidUnitTest runTestsTask)
/*     */   {
/* 102 */     TestVariantData variantData = (TestVariantData)scope.getVariantData();
/*     */     
/* 104 */     BaseVariantData testedVariantData = (BaseVariantData)variantData.getTestedVariantData();
/*     */     
/* 107 */     runTestsTask.systemProperty("java.awt.headless", "true");
/*     */     
/* 109 */     runTestsTask.setGroup("verification");
/* 110 */     runTestsTask.setDescription("Run unit tests for the " + testedVariantData
/*     */     
/* 112 */       .getVariantConfiguration().getFullName() + " build.");
/*     */     
/* 115 */     runTestsTask.setTestClassesDirs(scope.getOutput(TaskOutputHolder.AnchorOutputType.ALL_CLASSES));
/*     */     
/* 122 */     boolean includeAndroidResources = scope.getGlobalScope().getExtension().getTestOptions().getUnitTests().isIncludeAndroidResources();
/*     */     
/* 124 */     runTestsTask.setClasspath(computeClasspath(includeAndroidResources));
/* 125 */     AndroidUnitTest.access$002(runTestsTask, scope
/* 126 */       .getGlobalScope().getAndroidBuilder().getTarget().getLocation());
/*     */     
/* 130 */     VariantScope testedScope = testedVariantData.getScope();
/* 131 */     if (includeAndroidResources) {
/* 132 */       AndroidUnitTest.access$102(runTestsTask, testedScope.getOutput(TaskOutputHolder.TaskOutputType.MERGED_ASSETS));
/* 133 */       AndroidUnitTest.access$202(runTestsTask, testedScope
/* 134 */         .getOutput(TaskOutputHolder.TaskOutputType.MERGED_NOT_COMPILED_RES));
/*     */     }
/* 136 */     AndroidUnitTest.access$302(runTestsTask, testedScope.getOutput(TaskOutputHolder.TaskOutputType.MERGED_MANIFESTS));
/*     */     
/* 142 */     TestTaskReports testTaskReports = runTestsTask.getReports();
/* 143 */     ConfigurableReport xmlReport = testTaskReports.getJunitXml();
/* 144 */     xmlReport.setDestination(new File(scope
/*     */     
/* 146 */       .getGlobalScope().getTestResultsFolder(), runTestsTask
/* 147 */       .getName()));
/*     */     
/* 149 */     ConfigurableReport htmlReport = testTaskReports.getHtml();
/* 150 */     htmlReport.setDestination(new File(scope
/*     */     
/* 152 */       .getGlobalScope().getTestReportFolder(), runTestsTask
/* 153 */       .getName()));
/*     */     
/* 155 */     scope.getGlobalScope()
/* 156 */       .getExtension()
/* 157 */       .getTestOptions()
/* 158 */       .getUnitTests()
/* 159 */       .applyConfiguration(runTestsTask);
/*     */   }
/*     */   
/*     */   private ConfigurableFileCollection computeClasspath(boolean includeAndroidResources)
/*     */   {
/* 164 */     ConfigurableFileCollection collection = scope.getGlobalScope().getProject().files(new Object[0]);
/*     */     
/* 168 */     if (includeAndroidResources) {
/* 169 */       collection.from(new Object[] { scope.getOutput(TaskOutputHolder.TaskOutputType.UNIT_TEST_CONFIG_DIRECTORY) });
/*     */     }
/*     */     
/* 172 */     collection.from(new Object[] { scope.getOutput(TaskOutputHolder.AnchorOutputType.ALL_CLASSES) });
/*     */     
/* 174 */     collection.from(new Object[] { scope.getOutput(TaskOutputHolder.TaskOutputType.JAVA_RES) });
/*     */     
/* 177 */     collection.from(new Object[] {scope
/* 178 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, AndroidArtifacts.ArtifactScope.ALL, AndroidArtifacts.ArtifactType.CLASSES) });
/* 179 */     collection.from(new Object[] {scope
/* 180 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, AndroidArtifacts.ArtifactScope.ALL, AndroidArtifacts.ArtifactType.JAVA_RES) });
/*     */     
/* 187 */     VariantScope testedScope = ((BaseVariantData)Objects.requireNonNull(scope.getTestedVariantData())).getScope();
/* 188 */     if (testedScope.hasOutput(TaskOutputHolder.TaskOutputType.COMPILE_ONLY_NOT_NAMESPACED_R_CLASS_JAR)) {
/* 189 */       collection.from(new Object[] {testedScope
/* 190 */         .getOutput(TaskOutputHolder.TaskOutputType.COMPILE_ONLY_NOT_NAMESPACED_R_CLASS_JAR) });
/*     */     }
/*     */     
/* 195 */     collection.from(new Object[] {scope
/* 196 */       .getGlobalScope()
/* 197 */       .getProject()
/* 198 */       .files(new Object[] {scope
/* 199 */       .getGlobalScope()
/* 200 */       .getAndroidBuilder()
/* 201 */       .computeAdditionalAndRequestedOptionalLibraries() }) });
/*     */     
/* 206 */     collection.from(new Object[] { scope.getGlobalScope().getOutput(TaskOutputHolder.TaskOutputType.MOCKABLE_JAR) });
/* 207 */     return collection;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.factory.AndroidUnitTest.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */