/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ 
/*    */ public class CheckTestedAppObfuscation$ConfigAction
/*    */   implements TaskConfigAction<CheckTestedAppObfuscation>
/*    */ {
/*    */   private final VariantScope scope;
/*    */   
/*    */   public CheckTestedAppObfuscation$ConfigAction(VariantScope scope)
/*    */   {
/* 72 */     this.scope = scope;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 78 */     return scope.getTaskName("checkTestedAppObfuscation");
/*    */   }
/*    */   
/*    */   public Class<CheckTestedAppObfuscation> getType()
/*    */   {
/* 84 */     return CheckTestedAppObfuscation.class;
/*    */   }
/*    */   
/*    */   public void execute(CheckTestedAppObfuscation task)
/*    */   {
/* 89 */     task.setVariantName(scope.getFullVariantName());
/*    */     
/* 92 */     mappingFile = scope.getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.ALL, AndroidArtifacts.ArtifactType.APK_MAPPING);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.CheckTestedAppObfuscation.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */