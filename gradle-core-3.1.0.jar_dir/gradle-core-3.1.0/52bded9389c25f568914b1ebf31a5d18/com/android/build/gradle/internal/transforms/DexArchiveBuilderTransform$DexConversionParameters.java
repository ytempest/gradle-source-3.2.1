/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.DirectoryInput;
/*     */ import com.android.build.api.transform.QualifiedContent;
/*     */ import com.android.build.gradle.internal.scope.VariantScope.Java8LangSupport;
/*     */ import com.android.builder.dexing.DexerTool;
/*     */ import com.android.builder.dexing.r8.ClassFileProviderFactory;
/*     */ import com.android.ide.common.blame.MessageReceiver;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.net.URI;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.annotation.Nonnull;
/*     */ 
/*     */ public class DexArchiveBuilderTransform$DexConversionParameters
/*     */   implements Serializable
/*     */ {
/*     */   private final QualifiedContent input;
/*     */   private final List<String> bootClasspath;
/*     */   private final List<String> classpath;
/*     */   private final String output;
/*     */   private final int numberOfBuckets;
/*     */   private final int buckedId;
/*     */   private final int minSdkVersion;
/*     */   private final List<String> dexAdditionalParameters;
/*     */   private final int inBufferSize;
/*     */   private final int outBufferSize;
/*     */   private final DexerTool dexer;
/*     */   private final boolean isDebuggable;
/*     */   private final boolean isIncremental;
/*     */   private final ClassFileProviderFactory classFileProviderFactory;
/*     */   private final VariantScope.Java8LangSupport java8LangSupportType;
/*     */   private final Set<File> additionalPaths;
/*     */   @Nonnull
/*     */   private final MessageReceiver messageReceiver;
/*     */   
/*     */   public DexArchiveBuilderTransform$DexConversionParameters(QualifiedContent input, List<String> bootClasspath, List<String> classpath, File output, int numberOfBuckets, int buckedId, int minSdkVersion, List<String> dexAdditionalParameters, int inBufferSize, int outBufferSize, DexerTool dexer, boolean isDebuggable, boolean isIncremental, ClassFileProviderFactory classFileProviderFactory, VariantScope.Java8LangSupport java8LangSupportType, Set<File> additionalPaths, @Nonnull MessageReceiver messageReceiver)
/*     */   {
/* 547 */     this.input = input;
/* 548 */     this.bootClasspath = bootClasspath;
/* 549 */     this.classpath = classpath;
/* 550 */     this.numberOfBuckets = numberOfBuckets;
/* 551 */     this.buckedId = buckedId;
/* 552 */     this.output = output.toURI().toString();
/* 553 */     this.minSdkVersion = minSdkVersion;
/* 554 */     this.dexAdditionalParameters = dexAdditionalParameters;
/* 555 */     this.inBufferSize = inBufferSize;
/* 556 */     this.outBufferSize = outBufferSize;
/* 557 */     this.dexer = dexer;
/* 558 */     this.isDebuggable = isDebuggable;
/* 559 */     this.isIncremental = isIncremental;
/* 560 */     this.classFileProviderFactory = classFileProviderFactory;
/* 561 */     this.java8LangSupportType = java8LangSupportType;
/* 562 */     this.additionalPaths = additionalPaths;
/* 563 */     this.messageReceiver = messageReceiver;
/*     */   }
/*     */   
/*     */   public boolean belongsToThisBucket(String path) {
/* 567 */     return Math.abs(path.hashCode()) % numberOfBuckets == buckedId;
/*     */   }
/*     */   
/*     */   public boolean isDirectoryBased() {
/* 571 */     return input instanceof DirectoryInput;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.DexArchiveBuilderTransform.DexConversionParameters
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */