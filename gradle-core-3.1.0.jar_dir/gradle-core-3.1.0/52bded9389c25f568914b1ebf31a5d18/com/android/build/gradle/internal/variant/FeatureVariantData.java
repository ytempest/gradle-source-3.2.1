/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.internal.TaskManager;
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.OutputFactory;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.builder.core.VariantType;
/*    */ import com.android.builder.profile.Recorder;
/*    */ import com.android.utils.StringHelper;
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.Map;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class FeatureVariantData
/*    */   extends ApkVariantData
/*    */   implements TestedVariantData
/*    */ {
/* 35 */   private static final Pattern FEATURE_REPLACEMENT = Pattern.compile("-");
/*    */   
/* 38 */   private static final Pattern FEATURE_EXCLUSION = Pattern.compile("[^a-zA-Z0-9_]");
/*    */   
/*    */   private final Map<VariantType, TestVariantData> testVariants;
/*    */   
/*    */   private final String featureName;
/*    */   
/*    */   public FeatureVariantData(GlobalScope globalScope, AndroidConfig androidConfig, TaskManager taskManager, GradleVariantConfiguration config, Recorder recorder)
/*    */   {
/* 49 */     super(globalScope, androidConfig, taskManager, config, recorder);
/* 50 */     testVariants = Maps.newEnumMap(VariantType.class);
/*    */     
/* 56 */     String splitName = FEATURE_REPLACEMENT.matcher(getScope().getGlobalScope().getProjectBaseName()).replaceAll("_");
/* 57 */     featureName = FEATURE_EXCLUSION.matcher(splitName).replaceAll("");
/*    */     
/* 60 */     getOutputFactory().addMainApk();
/*    */   }
/*    */   
/*    */   public String getDescription()
/*    */   {
/* 66 */     GradleVariantConfiguration config = getVariantConfiguration();
/*    */     
/* 68 */     if (config.hasFlavors()) {
/* 69 */       StringBuilder sb = new StringBuilder(50);
/* 70 */       StringHelper.appendCapitalized(sb, ((CoreBuildType)config.getBuildType()).getName());
/* 71 */       sb.append(" feature split build for flavor ");
/* 72 */       StringHelper.appendCapitalized(sb, config.getFlavorName());
/* 73 */       return sb.toString();
/*    */     }
/* 75 */     return StringHelper.capitalizeWithSuffix(
/* 76 */       ((CoreBuildType)config.getBuildType()).getName(), " feature split build");
/*    */   }
/*    */   
/*    */   public TestVariantData getTestVariantData(VariantType type)
/*    */   {
/* 83 */     return (TestVariantData)testVariants.get(type);
/*    */   }
/*    */   
/*    */   public void setTestVariantData(TestVariantData testVariantData, VariantType type)
/*    */   {
/* 89 */     testVariants.put(type, testVariantData);
/*    */   }
/*    */   
/*    */   public String getFeatureName()
/*    */   {
/* 94 */     return featureName;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.FeatureVariantData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */