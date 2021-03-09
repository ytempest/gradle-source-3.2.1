/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import java.io.File;
/*    */ import org.gradle.api.tasks.AbstractCopyTask;
/*    */ import org.gradle.api.tasks.Sync;
/*    */ 
/*    */ public class PackageRenderscriptConfigAction
/*    */   implements TaskConfigAction<Sync>
/*    */ {
/*    */   private VariantScope variantScope;
/*    */   private File destDir;
/*    */   
/*    */   public PackageRenderscriptConfigAction(VariantScope variantScope, File destDir)
/*    */   {
/* 34 */     this.variantScope = variantScope;
/* 35 */     this.destDir = destDir;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 41 */     return variantScope.getTaskName("package", "Renderscript");
/*    */   }
/*    */   
/*    */   public Class<Sync> getType()
/*    */   {
/* 47 */     return Sync.class;
/*    */   }
/*    */   
/*    */   public void execute(Sync packageRenderscript)
/*    */   {
/* 55 */     packageRenderscript.from(new Object[] { variantScope.getVariantConfiguration().getRenderscriptSourceList() }).include(new String[] { "**/*.rsh" });
/* 56 */     packageRenderscript.into(destDir);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.PackageRenderscriptConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */