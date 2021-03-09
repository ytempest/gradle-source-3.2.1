/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.TestAndroidConfig;
/*    */ import com.android.build.gradle.internal.dsl.BuildType;
/*    */ import com.android.build.gradle.internal.dsl.ProductFlavor;
/*    */ import com.android.build.gradle.internal.dsl.SigningConfig;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import com.google.common.collect.ImmutableMap;
/*    */ import java.util.Map;
/*    */ import org.gradle.api.GradleException;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.artifacts.dsl.DependencyHandler;
/*    */ 
/*    */ public class TestVariantFactory
/*    */   extends ApplicationVariantFactory
/*    */ {
/*    */   public TestVariantFactory(GlobalScope globalScope, AndroidBuilder androidBuilder, AndroidConfig extension)
/*    */   {
/* 44 */     super(globalScope, androidBuilder, extension);
/*    */   }
/*    */   
/*    */   public boolean hasTestScope()
/*    */   {
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public void preVariantWork(Project project)
/*    */   {
/* 54 */     super.preVariantWork(project);
/*    */     
/* 56 */     TestAndroidConfig testExtension = (TestAndroidConfig)extension;
/*    */     
/* 58 */     String path = testExtension.getTargetProjectPath();
/* 59 */     if (path == null)
/*    */     {
/* 61 */       throw new GradleException("targetProjectPath cannot be null in test project " + project.getName());
/*    */     }
/*    */     
/* 64 */     DependencyHandler handler = project.getDependencies();
/* 65 */     Map<String, String> projectNotation = ImmutableMap.of("path", path);
/* 66 */     handler.add("implementation", handler.project(projectNotation));
/*    */   }
/*    */   
/*    */   public void createDefaultComponents(NamedDomainObjectContainer<BuildType> buildTypes, NamedDomainObjectContainer<ProductFlavor> productFlavors, NamedDomainObjectContainer<SigningConfig> signingConfigs)
/*    */   {
/* 77 */     signingConfigs.create("debug");
/* 78 */     buildTypes.create("debug");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.TestVariantFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */