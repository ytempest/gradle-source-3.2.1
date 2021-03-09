/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ 
/*     */ public class BundleInstantApp$ConfigAction
/*     */   implements TaskConfigAction<BundleInstantApp>
/*     */ {
/*     */   private final VariantScope scope;
/*     */   private final File bundleDirectory;
/*     */   
/*     */   public BundleInstantApp$ConfigAction(VariantScope scope, File bundleDirectory)
/*     */   {
/* 116 */     this.scope = scope;
/* 117 */     this.bundleDirectory = bundleDirectory;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 123 */     return scope.getTaskName("package", "InstantAppBundle");
/*     */   }
/*     */   
/*     */   public Class<BundleInstantApp> getType()
/*     */   {
/* 129 */     return BundleInstantApp.class;
/*     */   }
/*     */   
/*     */   public void execute(BundleInstantApp bundleInstantApp)
/*     */   {
/* 134 */     bundleInstantApp.setVariantName(scope.getFullVariantName());
/* 135 */     BundleInstantApp.access$002(bundleInstantApp, bundleDirectory);
/* 136 */     BundleInstantApp.access$102(bundleInstantApp, scope
/* 137 */       .getGlobalScope().getProjectBaseName() + "-" + scope
/*     */       
/* 139 */       .getVariantConfiguration().getBaseName() + ".zip");
/*     */     
/* 141 */     BundleInstantApp.access$202(bundleInstantApp, scope
/* 142 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.FEATURE_APPLICATION_ID_DECLARATION));
/*     */     
/* 146 */     BundleInstantApp.access$302(bundleInstantApp, scope
/* 147 */       .getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, AndroidArtifacts.ArtifactScope.MODULE, AndroidArtifacts.ArtifactType.APK));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.BundleInstantApp.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */