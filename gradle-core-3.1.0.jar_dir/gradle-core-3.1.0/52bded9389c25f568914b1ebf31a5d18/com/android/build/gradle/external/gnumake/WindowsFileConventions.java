/*    */ package com.android.build.gradle.external.gnumake;
/*    */ 
/*    */ import com.android.utils.StringHelperWindows;
/*    */ import java.util.List;
/*    */ 
/*    */ public class WindowsFileConventions
/*    */   extends AbstractOsFileConventions
/*    */ {
/*    */   public List<String> tokenizeCommandLineToEscaped(String commandString)
/*    */   {
/* 29 */     return StringHelperWindows.tokenizeCommandLineToEscaped(commandString);
/*    */   }
/*    */   
/*    */   public List<String> tokenizeCommandLineToRaw(String commandString)
/*    */   {
/* 35 */     return StringHelperWindows.tokenizeCommandLineToRaw(commandString);
/*    */   }
/*    */   
/*    */   public List<String> splitCommandLine(String commandString)
/*    */   {
/* 41 */     return StringHelperWindows.splitCommandLine(commandString);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.WindowsFileConventions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */