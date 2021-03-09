/*    */ package com.android.build.gradle.internal.transforms;
/*    */ 
/*    */ import com.android.build.api.transform.QualifiedContent.Scope;
/*    */ import com.android.build.api.transform.Transform;
/*    */ import com.android.build.gradle.internal.PostprocessingFeatures;
/*    */ import com.android.build.gradle.internal.pipeline.TransformManager;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*    */ import com.android.builder.core.VariantType;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.Set;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.file.ConfigurableFileCollection;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ 
/*    */ public abstract class ProguardConfigurable
/*    */   extends Transform
/*    */ {
/*    */   private final ConfigurableFileCollection configurationFiles;
/*    */   private final VariantType variantType;
/*    */   
/*    */   ProguardConfigurable(VariantScope scope)
/*    */   {
/* 43 */     configurationFiles = scope.getGlobalScope().getProject().files(new Object[0]);
/* 44 */     variantType = scope.getVariantData().getType();
/*    */   }
/*    */   
/*    */   public void setConfigurationFiles(FileCollection configFiles) {
/* 48 */     configurationFiles.from(new Object[] { configFiles });
/*    */   }
/*    */   
/*    */   FileCollection getAllConfigurationFiles() {
/* 52 */     return configurationFiles;
/*    */   }
/*    */   
/*    */   public Set<? super QualifiedContent.Scope> getScopes()
/*    */   {
/* 58 */     if (variantType == VariantType.LIBRARY) {
/* 59 */       return TransformManager.SCOPE_FULL_LIBRARY_WITH_LOCAL_JARS;
/*    */     }
/*    */     
/* 62 */     return TransformManager.SCOPE_FULL_PROJECT;
/*    */   }
/*    */   
/*    */   public Set<QualifiedContent.Scope> getReferencedScopes()
/*    */   {
/* 68 */     Set<QualifiedContent.Scope> set = Sets.newHashSetWithExpectedSize(5);
/* 69 */     if (variantType == VariantType.LIBRARY) {
/* 70 */       set.add(QualifiedContent.Scope.SUB_PROJECTS);
/* 71 */       set.add(QualifiedContent.Scope.EXTERNAL_LIBRARIES);
/*    */     }
/*    */     
/* 74 */     if (variantType.isForTesting()) {
/* 75 */       set.add(QualifiedContent.Scope.TESTED_CODE);
/*    */     }
/*    */     
/* 78 */     set.add(QualifiedContent.Scope.PROVIDED_ONLY);
/*    */     
/* 80 */     return Sets.immutableEnumSet(set);
/*    */   }
/*    */   
/*    */   public abstract void keep(String paramString);
/*    */   
/*    */   public abstract void dontwarn(String paramString);
/*    */   
/*    */   public abstract void setActions(PostprocessingFeatures paramPostprocessingFeatures);
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.ProguardConfigurable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */