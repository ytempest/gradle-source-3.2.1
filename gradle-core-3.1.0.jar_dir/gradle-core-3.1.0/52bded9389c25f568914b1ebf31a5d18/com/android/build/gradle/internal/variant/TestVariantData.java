/*     */ package com.android.build.gradle.internal.variant;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.TaskManager;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.core.VariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.OutputFactory;
/*     */ import com.android.build.gradle.internal.tasks.DeviceProviderInstrumentTestTask;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.profile.Recorder;
/*     */ import com.android.utils.StringHelper;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TestVariantData
/*     */   extends ApkVariantData
/*     */ {
/*     */   public DeviceProviderInstrumentTestTask connectedTestTask;
/*  36 */   public final List<DeviceProviderInstrumentTestTask> providerTestTaskList = Lists.newArrayList();
/*     */   
/*     */   private final TestedVariantData testedVariantData;
/*     */   
/*     */   public TestVariantData(GlobalScope globalScope, AndroidConfig androidConfig, TaskManager taskManager, GradleVariantConfiguration config, TestedVariantData testedVariantData, Recorder recorder)
/*     */   {
/*  47 */     super(globalScope, androidConfig, taskManager, config, recorder);
/*  48 */     this.testedVariantData = testedVariantData;
/*     */     
/*  51 */     getOutputFactory().addMainApk();
/*     */   }
/*     */   
/*     */   public TestedVariantData getTestedVariantData()
/*     */   {
/*  56 */     return testedVariantData;
/*     */   }
/*     */   
/*     */   public String getDescription()
/*     */   {
/*     */     String prefix;
/*     */     String prefix;
/*  63 */     switch (getType()) {
/*     */     case ANDROID_TEST: 
/*  65 */       prefix = "android (on device) tests";
/*  66 */       break;
/*     */     case UNIT_TEST: 
/*  68 */       prefix = "unit tests";
/*  69 */       break;
/*     */     default: 
/*  71 */       throw new IllegalStateException("Unknown test variant type.");
/*     */     }
/*     */     String prefix;
/*  74 */     GradleVariantConfiguration config = getVariantConfiguration();
/*     */     
/*  76 */     if (config.hasFlavors()) {
/*  77 */       StringBuilder sb = new StringBuilder(50);
/*  78 */       sb.append(prefix);
/*  79 */       sb.append(" for the ");
/*  80 */       StringHelper.appendCapitalized(sb, config.getFlavorName());
/*  81 */       StringHelper.appendCapitalized(sb, ((CoreBuildType)config.getBuildType()).getName());
/*  82 */       sb.append(" build");
/*  83 */       return sb.toString();
/*     */     }
/*  85 */     StringBuilder sb = new StringBuilder(50);
/*  86 */     sb.append(prefix);
/*  87 */     sb.append(" for the ");
/*  88 */     StringHelper.appendCapitalized(sb, ((CoreBuildType)config.getBuildType()).getName());
/*  89 */     sb.append(" build");
/*  90 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String getTaskName(String prefix, String suffix)
/*     */   {
/*  97 */     if (testedVariantData.getVariantConfiguration().getType() == VariantType.FEATURE) {
/*  98 */       return StringHelper.appendCapitalized(prefix, new String[] {
/*     */       
/* 100 */         getVariantConfiguration().getFullName(), "Feature", suffix });
/*     */     }
/*     */     
/* 104 */     return super.getTaskName(prefix, suffix);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.TestVariantData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */