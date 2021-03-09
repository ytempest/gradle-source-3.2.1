/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.builder.model.TestOptions.Execution;
/*     */ import com.android.utils.HelpfulEnumConverter;
/*     */ import com.google.common.base.Converter;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.base.Verify;
/*     */ import groovy.lang.Closure;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.DomainObjectSet;
/*     */ import org.gradle.api.internal.DefaultDomainObjectSet;
/*     */ import org.gradle.api.model.ObjectFactory;
/*     */ import org.gradle.api.tasks.testing.Test;
/*     */ import org.gradle.util.ConfigureUtil;
/*     */ 
/*     */ public class TestOptions
/*     */ {
/*  37 */   private static final HelpfulEnumConverter<TestOptions.Execution> EXECUTION_CONVERTER = new HelpfulEnumConverter(TestOptions.Execution.class);
/*     */   
/*     */   private String resultsDir;
/*     */   
/*     */   private String reportDir;
/*     */   
/*     */   private boolean animationsDisabled;
/*     */   
/*  46 */   private TestOptions.Execution execution = TestOptions.Execution.HOST;
/*     */   
/*     */   private final UnitTestOptions unitTests;
/*     */   
/*     */   @Inject
/*     */   public TestOptions(ObjectFactory objectFactory)
/*     */   {
/*  57 */     unitTests = ((UnitTestOptions)objectFactory.newInstance(UnitTestOptions.class, new Object[0]));
/*     */   }
/*     */   
/*     */   public void unitTests(Closure closure)
/*     */   {
/*  66 */     ConfigureUtil.configure(closure, unitTests);
/*     */   }
/*     */   
/*     */   public UnitTestOptions getUnitTests()
/*     */   {
/*  76 */     return unitTests;
/*     */   }
/*     */   
/*     */   public String getResultsDir()
/*     */   {
/*  82 */     return resultsDir;
/*     */   }
/*     */   
/*     */   public void setResultsDir(String resultsDir) {
/*  86 */     this.resultsDir = resultsDir;
/*     */   }
/*     */   
/*     */   public String getReportDir()
/*     */   {
/*  92 */     return reportDir;
/*     */   }
/*     */   
/*     */   public void setReportDir(String reportDir) {
/*  96 */     this.reportDir = reportDir;
/*     */   }
/*     */   
/*     */   public boolean getAnimationsDisabled()
/*     */   {
/* 101 */     return animationsDisabled;
/*     */   }
/*     */   
/*     */   public void setAnimationsDisabled(boolean animationsDisabled) {
/* 105 */     this.animationsDisabled = animationsDisabled;
/*     */   }
/*     */   
/*     */   public String getExecution()
/*     */   {
/* 129 */     return (String)Verify.verifyNotNull(EXECUTION_CONVERTER
/* 130 */       .reverse().convert(execution), "No string representation for enum.", new Object[0]);
/*     */   }
/*     */   
/*     */   public TestOptions.Execution getExecutionEnum()
/*     */   {
/* 136 */     return execution;
/*     */   }
/*     */   
/*     */   public void setExecution(String execution)
/*     */   {
/* 141 */     this.execution = ((TestOptions.Execution)Preconditions.checkNotNull(EXECUTION_CONVERTER
/* 142 */       .convert(execution), "The value of `execution` cannot be null."));
/*     */   }
/*     */   
/*     */   public static class UnitTestOptions
/*     */   {
/* 149 */     private DomainObjectSet<Test> testTasks = new DefaultDomainObjectSet(Test.class);
/*     */     
/*     */     private boolean returnDefaultValues;
/*     */     
/*     */     private boolean includeAndroidResources;
/*     */     
/*     */     public boolean isReturnDefaultValues()
/*     */     {
/* 165 */       return returnDefaultValues;
/*     */     }
/*     */     
/*     */     public void setReturnDefaultValues(boolean returnDefaultValues) {
/* 169 */       this.returnDefaultValues = returnDefaultValues;
/*     */     }
/*     */     
/*     */     public boolean isIncludeAndroidResources()
/*     */     {
/* 200 */       return includeAndroidResources;
/*     */     }
/*     */     
/*     */     public void setIncludeAndroidResources(boolean includeAndroidResources) {
/* 204 */       this.includeAndroidResources = includeAndroidResources;
/*     */     }
/*     */     
/*     */     public void all(final Closure<Test> configClosure)
/*     */     {
/* 231 */       testTasks.all(new Action()
/*     */       {
/*     */         public void execute(Test testTask)
/*     */         {
/* 235 */           ConfigureUtil.configure(configClosure, testTask);
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*     */     public void applyConfiguration(Test task)
/*     */     {
/* 251 */       testTasks.add(task);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.TestOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */