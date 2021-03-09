/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.google.common.base.Preconditions;
/*    */ 
/*    */ public final class CleanBuildCache$ConfigAction
/*    */   implements TaskConfigAction<CleanBuildCache>
/*    */ {
/*    */   private final GlobalScope globalScope;
/*    */   
/*    */   public CleanBuildCache$ConfigAction(GlobalScope globalScope)
/*    */   {
/* 52 */     this.globalScope = globalScope;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 58 */     return "cleanBuildCache";
/*    */   }
/*    */   
/*    */   public Class<CleanBuildCache> getType()
/*    */   {
/* 64 */     return CleanBuildCache.class;
/*    */   }
/*    */   
/*    */   public void execute(CleanBuildCache task)
/*    */   {
/* 69 */     Preconditions.checkNotNull(globalScope.getBuildCache());
/*    */     
/* 71 */     task.setDescription("Deletes the build cache directory.");
/* 72 */     task.setGroup("build");
/* 73 */     task.setBuildCache(globalScope.getBuildCache());
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.CleanBuildCache.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */