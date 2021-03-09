/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.android.builder.errors.EvalIssueReporter.Type;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.plugins.PluginManager;
/*    */ 
/*    */ public abstract class BaseVariantFactory
/*    */   implements VariantFactory
/*    */ {
/*    */   protected final GlobalScope globalScope;
/*    */   protected final AndroidConfig extension;
/*    */   protected final AndroidBuilder androidBuilder;
/*    */   
/*    */   public BaseVariantFactory(GlobalScope globalScope, AndroidBuilder androidBuilder, AndroidConfig extension)
/*    */   {
/* 39 */     this.globalScope = globalScope;
/* 40 */     this.androidBuilder = androidBuilder;
/* 41 */     this.extension = extension;
/*    */   }
/*    */   
/*    */   public void preVariantWork(Project project)
/*    */   {
/* 46 */     if (project.getPluginManager().hasPlugin("com.neenbedankt.android-apt"))
/*    */     {
/* 50 */       globalScope.getAndroidBuilder().getIssueReporter().reportError(EvalIssueReporter.Type.INCOMPATIBLE_PLUGIN, "android-apt plugin is incompatible with the Android Gradle plugin.  Please use 'annotationProcessor' configuration instead.", "android-apt");
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.BaseVariantFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */