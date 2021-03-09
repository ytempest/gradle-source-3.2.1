/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.builder.utils.FileCache;
/*    */ import com.google.common.base.Preconditions;
/*    */ import java.io.IOException;
/*    */ import org.gradle.api.DefaultTask;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ 
/*    */ public class CleanBuildCache
/*    */   extends DefaultTask
/*    */ {
/*    */   private FileCache buildCache;
/*    */   
/*    */   public void setBuildCache(FileCache buildCache)
/*    */   {
/* 37 */     this.buildCache = buildCache;
/*    */   }
/*    */   
/*    */   @TaskAction
/*    */   public void clean() throws IOException {
/* 42 */     Preconditions.checkNotNull(buildCache, "buildCache must not be null");
/* 43 */     buildCache.delete();
/*    */   }
/*    */   
/*    */   public static final class ConfigAction implements TaskConfigAction<CleanBuildCache>
/*    */   {
/*    */     private final GlobalScope globalScope;
/*    */     
/*    */     public ConfigAction(GlobalScope globalScope)
/*    */     {
/* 52 */       this.globalScope = globalScope;
/*    */     }
/*    */     
/*    */     public String getName()
/*    */     {
/* 58 */       return "cleanBuildCache";
/*    */     }
/*    */     
/*    */     public Class<CleanBuildCache> getType()
/*    */     {
/* 64 */       return CleanBuildCache.class;
/*    */     }
/*    */     
/*    */     public void execute(CleanBuildCache task)
/*    */     {
/* 69 */       Preconditions.checkNotNull(globalScope.getBuildCache());
/*    */       
/* 71 */       task.setDescription("Deletes the build cache directory.");
/* 72 */       task.setGroup("build");
/* 73 */       task.setBuildCache(globalScope.getBuildCache());
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.CleanBuildCache
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */