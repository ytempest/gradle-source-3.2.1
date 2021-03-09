/*    */ package com.android.build.gradle.external.gnumake;
/*    */ 
/*    */ import com.android.utils.StringHelperPOSIX;
/*    */ import java.util.List;
/*    */ 
/*    */ public class PosixFileConventions
/*    */   extends AbstractOsFileConventions
/*    */ {
/*    */   public List<String> tokenizeCommandLineToEscaped(String commandString)
/*    */   {
/* 28 */     return StringHelperPOSIX.tokenizeCommandLineToEscaped(commandString);
/*    */   }
/*    */   
/*    */   public List<String> tokenizeCommandLineToRaw(String commandString)
/*    */   {
/* 34 */     return StringHelperPOSIX.tokenizeCommandLineToRaw(commandString);
/*    */   }
/*    */   
/*    */   public List<String> splitCommandLine(String commandString)
/*    */   {
/* 40 */     return StringHelperPOSIX.splitCommandLine(commandString);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.PosixFileConventions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */