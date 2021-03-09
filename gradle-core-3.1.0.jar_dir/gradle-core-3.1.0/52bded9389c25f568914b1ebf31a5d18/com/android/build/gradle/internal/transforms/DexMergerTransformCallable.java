/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.builder.dexing.DexArchiveMerger;
/*     */ import com.android.builder.dexing.DexMergerTool;
/*     */ import com.android.builder.dexing.DexingType;
/*     */ import com.android.dx.command.dexer.DxContext;
/*     */ import com.android.ide.common.blame.MessageReceiver;
/*     */ import com.android.ide.common.process.ProcessOutput;
/*     */ import java.io.File;
/*     */ import java.nio.file.Path;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ForkJoinPool;
/*     */ 
/*     */ public class DexMergerTransformCallable
/*     */   implements Callable<Void>
/*     */ {
/*     */   private final MessageReceiver messageReceiver;
/*     */   private final DexingType dexingType;
/*     */   private final ProcessOutput processOutput;
/*     */   private final File dexOutputDir;
/*     */   private final Iterable<Path> dexArchives;
/*     */   private final ForkJoinPool forkJoinPool;
/*     */   private final Path mainDexList;
/*     */   private final DexMergerTool dexMerger;
/*     */   private final int minSdkVersion;
/*     */   private final boolean isDebuggable;
/*     */   
/*     */   public DexMergerTransformCallable(MessageReceiver messageReceiver, DexingType dexingType, ProcessOutput processOutput, File dexOutputDir, Iterable<Path> dexArchives, Path mainDexList, ForkJoinPool forkJoinPool, DexMergerTool dexMerger, int minSdkVersion, boolean isDebuggable)
/*     */   {
/*  60 */     this.messageReceiver = messageReceiver;
/*  61 */     this.dexingType = dexingType;
/*  62 */     this.processOutput = processOutput;
/*  63 */     this.dexOutputDir = dexOutputDir;
/*  64 */     this.dexArchives = dexArchives;
/*  65 */     this.mainDexList = mainDexList;
/*  66 */     this.forkJoinPool = forkJoinPool;
/*  67 */     this.dexMerger = dexMerger;
/*  68 */     this.minSdkVersion = minSdkVersion;
/*  69 */     this.isDebuggable = isDebuggable;
/*     */   }
/*     */   
/*     */   public Void call() throws Exception {
/*     */     DexArchiveMerger merger;
/*     */     DexArchiveMerger merger;
/*  75 */     switch (dexMerger)
/*     */     {
/*     */     case DX: 
/*  79 */       DxContext dxContext = new DxContext(processOutput.getStandardOutput(), processOutput.getErrorOutput());
/*  80 */       merger = DexArchiveMerger.createDxDexMerger(dxContext, forkJoinPool);
/*  81 */       break;
/*     */     case D8: 
/*  83 */       int d8MinSdkVersion = minSdkVersion;
/*  84 */       if ((d8MinSdkVersion < 21) && (dexingType == DexingType.NATIVE_MULTIDEX))
/*     */       {
/*  91 */         d8MinSdkVersion = 21;
/*     */       }
/*     */       
/*  94 */       merger = DexArchiveMerger.createD8DexMerger(messageReceiver, d8MinSdkVersion, isDebuggable);
/*     */       
/*  96 */       break;
/*     */     default: 
/*  98 */       throw new AssertionError("Unknown dex merger " + dexMerger.name()); }
/*     */     
/*     */     DexArchiveMerger merger;
/* 101 */     merger.mergeDexArchives(dexArchives, dexOutputDir.toPath(), mainDexList, dexingType);
/* 102 */     return null;
/*     */   }
/*     */   
/*     */   public static abstract interface Factory
/*     */   {
/*     */     public abstract DexMergerTransformCallable create(MessageReceiver paramMessageReceiver, DexingType paramDexingType, ProcessOutput paramProcessOutput, File paramFile, Iterable<Path> paramIterable, Path paramPath, ForkJoinPool paramForkJoinPool, DexMergerTool paramDexMergerTool, int paramInt, boolean paramBoolean);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.DexMergerTransformCallable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */