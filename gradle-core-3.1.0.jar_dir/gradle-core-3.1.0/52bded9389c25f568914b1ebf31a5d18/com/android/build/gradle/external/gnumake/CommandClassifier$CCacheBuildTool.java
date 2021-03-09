/*     */ package com.android.build.gradle.external.gnumake;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ 
/*     */ class CommandClassifier$CCacheBuildTool
/*     */   implements CommandClassifier.BuildTool
/*     */ {
/*     */   public BuildStepInfo createCommand(CommandLine command)
/*     */   {
/* 174 */     CommandLine translated = translateToCompilerCommandLine(command);
/* 175 */     return CommandClassifier.access$000().createCommand(translated);
/*     */   }
/*     */   
/*     */   public boolean isMatch(CommandLine command)
/*     */   {
/* 180 */     String executable = new File(executable).getName();
/* 181 */     if (executable.endsWith("ccache")) {
/* 182 */       CommandLine translated = translateToCompilerCommandLine(command);
/* 183 */       return CommandClassifier.access$000().isMatch(translated);
/*     */     }
/* 185 */     return false;
/*     */   }
/*     */   
/*     */   private static CommandLine translateToCompilerCommandLine(CommandLine command)
/*     */   {
/* 190 */     List<String> escaped = Lists.newArrayList(escapedFlags);
/* 191 */     List<String> raw = Lists.newArrayList(rawFlags);
/* 192 */     String baseCommand = (String)escaped.get(0);
/* 193 */     escaped.remove(0);
/* 194 */     raw.remove(0);
/* 195 */     return new CommandLine(baseCommand, escaped, raw);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.CommandClassifier.CCacheBuildTool
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */