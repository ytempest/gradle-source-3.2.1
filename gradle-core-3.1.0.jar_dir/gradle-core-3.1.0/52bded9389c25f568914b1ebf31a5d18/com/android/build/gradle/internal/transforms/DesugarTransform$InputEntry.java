/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.builder.utils.FileCache;
/*     */ import com.android.builder.utils.FileCache.Inputs;
/*     */ import java.nio.file.Path;
/*     */ 
/*     */ class DesugarTransform$InputEntry
/*     */ {
/*     */   private final FileCache cache;
/*     */   private final FileCache.Inputs inputs;
/*     */   private final Path inputPath;
/*     */   private final Path outputPath;
/*     */   
/*     */   public DesugarTransform$InputEntry(FileCache cache, FileCache.Inputs inputs, Path inputPath, Path outputPath)
/*     */   {
/* 107 */     this.cache = cache;
/* 108 */     this.inputs = inputs;
/* 109 */     this.inputPath = inputPath;
/* 110 */     this.outputPath = outputPath;
/*     */   }
/*     */   
/*     */   public FileCache getCache()
/*     */   {
/* 115 */     return cache;
/*     */   }
/*     */   
/*     */   public FileCache.Inputs getInputs()
/*     */   {
/* 120 */     return inputs;
/*     */   }
/*     */   
/*     */   public Path getInputPath()
/*     */   {
/* 125 */     return inputPath;
/*     */   }
/*     */   
/*     */   public Path getOutputPath()
/*     */   {
/* 130 */     return outputPath;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.DesugarTransform.InputEntry
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */