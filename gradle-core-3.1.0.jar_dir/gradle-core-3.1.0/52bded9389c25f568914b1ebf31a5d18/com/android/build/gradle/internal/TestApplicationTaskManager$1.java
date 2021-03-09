/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.tasks.DeviceProviderInstrumentTestTask.ConfigAction;
/*     */ import com.android.build.gradle.internal.test.AbstractTestDataImpl;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.testing.api.DeviceProvider;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ class TestApplicationTaskManager$1
/*     */   extends DeviceProviderInstrumentTestTask.ConfigAction
/*     */ {
/*     */   TestApplicationTaskManager$1(TestApplicationTaskManager this$0, VariantScope scope, DeviceProvider deviceProvider, AbstractTestDataImpl testData, FileCollection testTargetManifests)
/*     */   {
/* 130 */     super(scope, deviceProvider, testData, testTargetManifests);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 134 */     return super.getName() + VariantType.ANDROID_TEST.getSuffix();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.TestApplicationTaskManager.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */