/*     */ package com.android.build.gradle.external.gnumake;
/*     */ 
/*     */ import java.util.List;
/*     */ 
/*     */ class NativeBuildConfigValueBuilder$Output
/*     */ {
/*     */   private final String outputFileName;
/*     */   private final List<BuildStepInfo> commandInputs;
/*     */   private final String buildCommand;
/*     */   private final String cleanCommand;
/*     */   private final String variantName;
/*     */   private String artifactName;
/*     */   private String libraryName;
/*     */   private String toolchain;
/*     */   
/*     */   private NativeBuildConfigValueBuilder$Output(String outputFileName, List<BuildStepInfo> commandInputs, String buildCommand, String cleanCommand, String variantName)
/*     */   {
/* 364 */     this.outputFileName = outputFileName;
/* 365 */     this.commandInputs = commandInputs;
/* 366 */     this.buildCommand = buildCommand;
/* 367 */     this.cleanCommand = cleanCommand;
/* 368 */     this.variantName = variantName;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.NativeBuildConfigValueBuilder.Output
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */