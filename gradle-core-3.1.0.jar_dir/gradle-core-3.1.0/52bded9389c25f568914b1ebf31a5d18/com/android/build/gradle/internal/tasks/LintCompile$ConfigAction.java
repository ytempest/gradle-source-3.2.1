/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import java.io.File;
/*    */ 
/*    */ public class LintCompile$ConfigAction
/*    */   implements TaskConfigAction<LintCompile>
/*    */ {
/*    */   private final GlobalScope globalScope;
/*    */   
/*    */   public LintCompile$ConfigAction(GlobalScope globalScope)
/*    */   {
/* 57 */     this.globalScope = globalScope;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 63 */     return "compileLint";
/*    */   }
/*    */   
/*    */   public Class<LintCompile> getType()
/*    */   {
/* 69 */     return LintCompile.class;
/*    */   }
/*    */   
/*    */   public void execute(LintCompile task)
/*    */   {
/* 74 */     task.setOutputDirectory(new File(globalScope.getIntermediatesDir(), "lint"));
/* 75 */     task.setVariantName("");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.LintCompile.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */