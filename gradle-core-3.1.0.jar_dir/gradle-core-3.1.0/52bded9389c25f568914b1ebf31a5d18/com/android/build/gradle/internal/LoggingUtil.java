/*    */ package com.android.build.gradle.internal;
/*    */ 
/*    */ import com.android.utils.ILogger;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.logging.Logger;
/*    */ 
/*    */ public class LoggingUtil
/*    */ {
/*    */   public static void displayWarning(ILogger logger, Project project, String message)
/*    */   {
/* 29 */     logger.warning(createWarning(project.getPath(), message), new Object[0]);
/*    */   }
/*    */   
/*    */   public static void displayWarning(Logger logger, Project project, String message) {
/* 33 */     logger.warn(createWarning(project.getPath(), message));
/*    */   }
/*    */   
/*    */   public static void displayDeprecationWarning(Logger logger, Project project, String message) {
/* 37 */     displayWarning(logger, project, message);
/*    */   }
/*    */   
/*    */   private static String createWarning(String projectName, String message) {
/* 41 */     return "WARNING [Project: " + projectName + "] " + message;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.LoggingUtil
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */