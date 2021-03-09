/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.utils.FileUtils;
/*    */ import java.io.File;
/*    */ import org.gradle.api.tasks.OutputDirectory;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ 
/*    */ public class LintCompile
/*    */   extends AndroidBuilderTask
/*    */ {
/*    */   private File outputDirectory;
/*    */   
/*    */   @OutputDirectory
/*    */   public File getOutputDirectory()
/*    */   {
/* 38 */     return outputDirectory;
/*    */   }
/*    */   
/*    */   public void setOutputDirectory(File outputDirectory) {
/* 42 */     this.outputDirectory = outputDirectory;
/*    */   }
/*    */   
/*    */   @TaskAction
/*    */   public void compile()
/*    */   {
/* 48 */     FileUtils.mkdirs(getOutputDirectory());
/*    */   }
/*    */   
/*    */   public static class ConfigAction implements TaskConfigAction<LintCompile>
/*    */   {
/*    */     private final GlobalScope globalScope;
/*    */     
/*    */     public ConfigAction(GlobalScope globalScope)
/*    */     {
/* 57 */       this.globalScope = globalScope;
/*    */     }
/*    */     
/*    */     public String getName()
/*    */     {
/* 63 */       return "compileLint";
/*    */     }
/*    */     
/*    */     public Class<LintCompile> getType()
/*    */     {
/* 69 */       return LintCompile.class;
/*    */     }
/*    */     
/*    */     public void execute(LintCompile task)
/*    */     {
/* 74 */       task.setOutputDirectory(new File(globalScope.getIntermediatesDir(), "lint"));
/* 75 */       task.setVariantName("");
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.LintCompile
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */