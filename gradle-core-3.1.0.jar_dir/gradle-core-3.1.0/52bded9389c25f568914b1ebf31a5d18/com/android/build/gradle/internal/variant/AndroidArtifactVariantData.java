/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.internal.TaskManager;
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.builder.profile.Recorder;
/*    */ import java.util.Collections;
/*    */ import java.util.Set;
/*    */ 
/*    */ public abstract class AndroidArtifactVariantData
/*    */   extends BaseVariantData
/*    */ {
/* 30 */   private Set<String> compatibleScreens = null;
/*    */   
/*    */   protected AndroidArtifactVariantData(GlobalScope globalScope, AndroidConfig androidConfig, TaskManager taskManager, GradleVariantConfiguration config, Recorder recorder)
/*    */   {
/* 38 */     super(globalScope, androidConfig, taskManager, config, recorder);
/*    */   }
/*    */   
/*    */   public void setCompatibleScreens(Set<String> compatibleScreens) {
/* 42 */     this.compatibleScreens = compatibleScreens;
/*    */   }
/*    */   
/*    */   public Set<String> getCompatibleScreens()
/*    */   {
/* 47 */     if (compatibleScreens == null) {
/* 48 */       return Collections.emptySet();
/*    */     }
/*    */     
/* 51 */     return compatibleScreens;
/*    */   }
/*    */   
/*    */   public boolean isSigned() {
/* 55 */     return getVariantConfiguration().isSigningReady();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.AndroidArtifactVariantData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */