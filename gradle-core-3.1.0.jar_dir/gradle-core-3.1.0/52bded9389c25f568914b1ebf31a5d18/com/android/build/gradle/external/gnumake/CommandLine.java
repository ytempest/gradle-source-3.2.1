/*    */ package com.android.build.gradle.external.gnumake;
/*    */ 
/*    */ import com.google.common.base.Joiner;
/*    */ import java.util.List;
/*    */ 
/*    */ class CommandLine
/*    */ {
/*    */   public final String executable;
/*    */   public final List<String> escapedFlags;
/*    */   public final List<String> rawFlags;
/*    */   
/*    */   CommandLine(String executable, List<String> escapedFlags, List<String> rawFlags)
/*    */   {
/* 35 */     this.executable = executable;
/* 36 */     this.escapedFlags = escapedFlags;
/* 37 */     this.rawFlags = rawFlags;
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 42 */     CommandLine other = (CommandLine)obj;
/* 43 */     return (executable.equals(executable)) && (rawFlags.equals(rawFlags));
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 48 */     return executable + " " + Joiner.on(' ').join(rawFlags);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.CommandLine
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */