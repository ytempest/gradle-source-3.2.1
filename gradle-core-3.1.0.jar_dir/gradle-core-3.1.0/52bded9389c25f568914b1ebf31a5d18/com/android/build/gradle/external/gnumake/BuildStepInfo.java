/*     */ package com.android.build.gradle.external.gnumake;
/*     */ 
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ class BuildStepInfo
/*     */ {
/*     */   private final CommandLine command;
/*     */   private final List<String> inputs;
/*     */   private final List<String> outputs;
/*     */   private final boolean inputsAreSourceFiles;
/*     */   
/*     */   BuildStepInfo(CommandLine command, List<String> inputs, List<String> outputs)
/*     */   {
/*  40 */     this(command, inputs, outputs, false);
/*     */   }
/*     */   
/*     */   BuildStepInfo(CommandLine command, List<String> inputs, List<String> outputs, boolean inputsAreSourceFiles)
/*     */   {
/*  45 */     this.command = command;
/*  46 */     this.inputs = Lists.newArrayList(inputs);
/*  47 */     this.outputs = Lists.newArrayList(outputs);
/*  48 */     this.inputsAreSourceFiles = inputsAreSourceFiles;
/*  49 */     for (String input : inputs) {
/*  50 */       if (input == null) {
/*  51 */         throw new RuntimeException(String.format("GNUMAKE: Unexpected null input in %s", new Object[] { this }));
/*     */       }
/*     */     }
/*     */     
/*  55 */     if ((inputsAreSourceFiles()) && 
/*  56 */       (getInputs().size() != 1))
/*     */     {
/*  58 */       throw new RuntimeException(String.format("GNUMAKE: Expected exactly one source file in compile step: %s\nbut received: \n%s\nin command:\n%s\n", new Object[] { this, 
/*     */       
/*  62 */         Joiner.on("\n").join(getInputs()), command }));
/*     */     }
/*     */   }
/*     */   
/*     */   String getOnlyInput()
/*     */   {
/*  69 */     if (getInputs().size() != 1) {
/*  70 */       throw new RuntimeException("Did not expect multiple inputs");
/*     */     }
/*  72 */     return (String)getInputs().iterator().next();
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj)
/*     */   {
/*  77 */     if (!(obj instanceof BuildStepInfo)) {
/*  78 */       return false;
/*     */     }
/*  80 */     BuildStepInfo that = (BuildStepInfo)obj;
/*  81 */     return (command.executable.equals(command.executable)) && 
/*  82 */       (inputs.equals(that.getInputs())) && 
/*  83 */       (outputs.equals(that.getOutputs())) && (inputsAreSourceFiles == inputsAreSourceFiles);
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*  90 */     return 
/*     */     
/*  92 */       command.executable + " in:[" + Joiner.on(' ').join(inputs) + "] out:[" + Joiner.on(' ').join(outputs) + "]" + (inputsAreSourceFiles ? "SOURCE" : "INTERMEDIATE");
/*     */   }
/*     */   
/*     */   CommandLine getCommand()
/*     */   {
/*  98 */     return command;
/*     */   }
/*     */   
/*     */   List<String> getInputs()
/*     */   {
/* 103 */     return inputs;
/*     */   }
/*     */   
/*     */   List<String> getOutputs()
/*     */   {
/* 108 */     return outputs;
/*     */   }
/*     */   
/*     */   boolean inputsAreSourceFiles() {
/* 112 */     return inputsAreSourceFiles;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.BuildStepInfo
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */