/*     */ package com.android.build.gradle.external.gnumake;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import joptsimple.OptionParser;
/*     */ import joptsimple.OptionSet;
/*     */ import joptsimple.OptionSpecBuilder;
/*     */ 
/*     */ class CommandClassifier$ArBuildTool
/*     */   implements CommandClassifier.BuildTool
/*     */ {
/*  96 */   private static final OptionParser PARSER = new OptionParser("cSE");
/*     */   
/*     */   static {
/*  99 */     PARSER.accepts("plugin").withRequiredArg();
/* 100 */     PARSER.accepts("target").withRequiredArg();
/* 101 */     PARSER.accepts("X32_64");
/* 102 */     PARSER.accepts("p").withOptionalArg();
/*     */   }
/*     */   
/*     */   private static void checkValidInput(String arg)
/*     */   {
/* 107 */     if (!arg.endsWith(".o")) {
/* 108 */       throw new RuntimeException(arg);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void checkValidOutput(String arg) {
/* 113 */     if (!arg.endsWith(".a")) {
/* 114 */       throw new RuntimeException(arg);
/*     */     }
/*     */   }
/*     */   
/*     */   public BuildStepInfo createCommand(CommandLine command)
/*     */   {
/* 121 */     String[] arr = new String[escapedFlags.size()];
/* 122 */     for (int i = 0; i < arr.length; i++) {
/* 123 */       arr[i] = ((String)escapedFlags.get(i));
/*     */     }
/*     */     
/* 126 */     List<String> options = PARSER.parse(arr).nonOptionArguments();
/*     */     
/* 128 */     if ((!((String)options.get(0)).contains("c")) || (options.size() < 2)) {
/* 129 */       return null;
/*     */     }
/*     */     
/* 132 */     if (options.size() == 2)
/*     */     {
/* 136 */       return new BuildStepInfo(command, Lists.newArrayList(), Lists.newArrayList());
/*     */     }
/*     */     
/* 139 */     List<String> inputs = new ArrayList();
/* 140 */     List<String> outputs = new ArrayList();
/*     */     
/* 142 */     String output = (String)options.get(1);
/* 143 */     checkValidOutput(output);
/* 144 */     outputs.add(output);
/*     */     
/* 146 */     for (int i = 2; i < options.size(); i++) {
/* 147 */       String arg = (String)options.get(i);
/* 148 */       checkValidInput(arg);
/* 149 */       inputs.add(arg);
/*     */     }
/* 151 */     return new BuildStepInfo(command, inputs, outputs);
/*     */   }
/*     */   
/*     */   public boolean isMatch(CommandLine command)
/*     */   {
/* 156 */     return (executable.endsWith("gcc-ar")) || 
/* 157 */       (executable.endsWith("android-ar")) || 
/* 158 */       (executable.endsWith("androideabi-ar"));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.CommandClassifier.ArBuildTool
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */