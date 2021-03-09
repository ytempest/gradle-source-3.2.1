/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.internal.TaskManager;
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.builder.core.VariantType;
/*    */ import com.android.builder.profile.Recorder;
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ApplicationVariantData
/*    */   extends ApkVariantData
/*    */   implements TestedVariantData
/*    */ {
/*    */   private final Map<VariantType, TestVariantData> testVariants;
/*    */   
/*    */   public ApplicationVariantData(GlobalScope globalScope, AndroidConfig androidConfig, GradleVariantConfiguration config, TaskManager taskManager, Recorder recorder)
/*    */   {
/* 41 */     super(globalScope, androidConfig, taskManager, config, recorder);
/* 42 */     testVariants = Maps.newEnumMap(VariantType.class);
/*    */   }
/*    */   
/*    */   public void setTestVariantData(TestVariantData testVariantData, VariantType type)
/*    */   {
/* 49 */     testVariants.put(type, testVariantData);
/*    */   }
/*    */   
/*    */   public TestVariantData getTestVariantData(VariantType type)
/*    */   {
/* 55 */     return (TestVariantData)testVariants.get(type);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.ApplicationVariantData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */