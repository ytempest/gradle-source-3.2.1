/*    */ package com.android.build.gradle.internal.scope;
/*    */ 
/*    */ import com.android.build.gradle.tasks.PackageApplication;
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.List;
/*    */ import org.gradle.api.DefaultTask;
/*    */ 
/*    */ public abstract class GenericVariantScopeImpl
/*    */   extends TaskOutputHolderImpl
/*    */   implements InstantRunVariantScope
/*    */ {
/* 31 */   private List<DefaultTask> coldSwapBuildTasks = Lists.newArrayList();
/*    */   private PackageApplication packageApplicationTask;
/*    */   
/*    */   public List<DefaultTask> getColdSwapBuildTasks() {
/* 35 */     return coldSwapBuildTasks;
/*    */   }
/*    */   
/*    */   public void addColdSwapBuildTask(DefaultTask task)
/*    */   {
/* 40 */     coldSwapBuildTasks.add(task);
/*    */   }
/*    */   
/*    */   public PackageApplication getPackageApplicationTask()
/*    */   {
/* 47 */     return packageApplicationTask;
/*    */   }
/*    */   
/*    */   public void setPackageApplicationTask(PackageApplication packageApplicationTask)
/*    */   {
/* 52 */     this.packageApplicationTask = packageApplicationTask;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.GenericVariantScopeImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */