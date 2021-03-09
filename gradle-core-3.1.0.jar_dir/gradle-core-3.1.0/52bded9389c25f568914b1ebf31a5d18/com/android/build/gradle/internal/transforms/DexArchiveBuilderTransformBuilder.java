/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.VariantScope.Java8LangSupport;
/*     */ import com.android.builder.core.DexOptions;
/*     */ import com.android.builder.dexing.DexerTool;
/*     */ import com.android.builder.utils.FileCache;
/*     */ import com.android.ide.common.blame.MessageReceiver;
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ 
/*     */ public class DexArchiveBuilderTransformBuilder
/*     */ {
/*     */   private Supplier<List<File>> androidJarClasspath;
/*     */   private DexOptions dexOptions;
/*     */   private MessageReceiver messageReceiver;
/*     */   private FileCache userLevelCache;
/*     */   private int minSdkVersion;
/*     */   private DexerTool dexer;
/*     */   private boolean useGradleWorkers;
/*     */   private Integer inBufferSize;
/*     */   private Integer outBufferSize;
/*     */   private boolean isDebuggable;
/*     */   private VariantScope.Java8LangSupport java8LangSupportType;
/*     */   private String projectVariant;
/*     */   private boolean enableIncrementalDesugaring;
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setAndroidJarClasspath(Supplier<List<File>> androidJarClasspath)
/*     */   {
/*  49 */     this.androidJarClasspath = androidJarClasspath;
/*  50 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setDexOptions(DexOptions dexOptions)
/*     */   {
/*  55 */     this.dexOptions = dexOptions;
/*  56 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setMessageReceiver(MessageReceiver messageReceiver)
/*     */   {
/*  62 */     this.messageReceiver = messageReceiver;
/*  63 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setUserLevelCache(FileCache userLevelCache)
/*     */   {
/*  68 */     this.userLevelCache = userLevelCache;
/*  69 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setMinSdkVersion(int minSdkVersion)
/*     */   {
/*  74 */     this.minSdkVersion = minSdkVersion;
/*  75 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setDexer(DexerTool dexer)
/*     */   {
/*  80 */     this.dexer = dexer;
/*  81 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setUseGradleWorkers(boolean useGradleWorkers)
/*     */   {
/*  86 */     this.useGradleWorkers = useGradleWorkers;
/*  87 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setInBufferSize(Integer inBufferSize)
/*     */   {
/*  92 */     this.inBufferSize = inBufferSize;
/*  93 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setOutBufferSize(Integer outBufferSize)
/*     */   {
/*  98 */     this.outBufferSize = outBufferSize;
/*  99 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setIsDebuggable(boolean isDebuggable)
/*     */   {
/* 104 */     this.isDebuggable = isDebuggable;
/* 105 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setJava8LangSupportType(VariantScope.Java8LangSupport java8LangSupportType)
/*     */   {
/* 111 */     this.java8LangSupportType = java8LangSupportType;
/* 112 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setProjectVariant(String projectVariant)
/*     */   {
/* 117 */     this.projectVariant = projectVariant;
/* 118 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransformBuilder setEnableIncrementalDesugaring(boolean enableIncrementalDesugaring)
/*     */   {
/* 124 */     this.enableIncrementalDesugaring = enableIncrementalDesugaring;
/* 125 */     return this;
/*     */   }
/*     */   
/*     */   public DexArchiveBuilderTransform createDexArchiveBuilderTransform()
/*     */   {
/* 130 */     Preconditions.checkNotNull(androidJarClasspath);
/* 131 */     Preconditions.checkNotNull(dexOptions);
/* 132 */     Preconditions.checkNotNull(messageReceiver);
/* 133 */     Preconditions.checkNotNull(dexer);
/* 134 */     Preconditions.checkNotNull(java8LangSupportType);
/* 135 */     Preconditions.checkNotNull(projectVariant);
/* 136 */     return new DexArchiveBuilderTransform(androidJarClasspath, dexOptions, messageReceiver, userLevelCache, minSdkVersion, dexer, useGradleWorkers, inBufferSize, outBufferSize, isDebuggable, java8LangSupportType, projectVariant, enableIncrementalDesugaring);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.DexArchiveBuilderTransformBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */