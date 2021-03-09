/*    */ package com.android.build.gradle.external.gnumake;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ class CommandLineParser
/*    */ {
/*    */   static List<CommandLine> parse(String commands, OsFileConventions policy)
/*    */   {
/* 36 */     String[] lines = commands.split("[\r\n]+");
/* 37 */     List<CommandLine> commandLines = new ArrayList();
/* 38 */     for (String line : lines) {
/* 39 */       List<String> commandList = policy.splitCommandLine(line);
/* 40 */       for (String commandString : commandList) {
/* 41 */         List<String> escapedFlags = policy.tokenizeCommandLineToEscaped(commandString);
/* 42 */         List<String> rawFlags = policy.tokenizeCommandLineToRaw(commandString);
/* 43 */         String command = (String)escapedFlags.get(0);
/* 44 */         escapedFlags.remove(0);
/* 45 */         rawFlags.remove(0);
/* 46 */         commandLines.add(new CommandLine(command, escapedFlags, rawFlags));
/*    */       }
/*    */     }
/* 49 */     return commandLines;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.CommandLineParser
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */