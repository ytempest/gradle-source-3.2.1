/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import com.android.build.VariantOutput;
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.api.BaseVariantOutput;
/*    */ import com.android.build.gradle.internal.api.BaseVariantImpl;
/*    */ import com.android.build.gradle.internal.variant.TaskContainer;
/*    */ import com.android.ide.common.build.ApkData;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.util.Collection;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public class VariantOutputFactory
/*    */ {
/*    */   private final Class<? extends BaseVariantOutput> targetClass;
/*    */   private final ObjectFactory objectFactory;
/*    */   private final BaseVariantImpl variantPublicApi;
/*    */   private final TaskContainer taskContainer;
/*    */   private final AndroidConfig androidConfig;
/*    */   
/*    */   public VariantOutputFactory(Class<? extends BaseVariantOutput> targetClass, ObjectFactory objectFactory, AndroidConfig androidConfig, BaseVariantImpl variantPublicApi, TaskContainer taskContainer)
/*    */   {
/* 48 */     this.targetClass = targetClass;
/* 49 */     this.objectFactory = objectFactory;
/* 50 */     this.variantPublicApi = variantPublicApi;
/* 51 */     this.taskContainer = taskContainer;
/* 52 */     this.androidConfig = androidConfig;
/*    */   }
/*    */   
/*    */   public VariantOutput create(ApkData apkData)
/*    */   {
/* 57 */     BaseVariantOutput variantOutput = (BaseVariantOutput)objectFactory.newInstance(targetClass, new Object[] { apkData, taskContainer });
/* 58 */     androidConfig.getBuildOutputs().add(variantOutput);
/* 59 */     if (variantPublicApi != null) {
/* 60 */       variantPublicApi.addOutputs(ImmutableList.of(variantOutput));
/*    */     }
/* 62 */     return variantOutput;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.VariantOutputFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */