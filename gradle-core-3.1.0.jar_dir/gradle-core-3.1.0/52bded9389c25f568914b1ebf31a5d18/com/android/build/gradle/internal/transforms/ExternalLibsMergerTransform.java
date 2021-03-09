/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.JarInput;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.Status;
/*     */ import com.android.build.api.transform.TransformInput;
/*     */ import com.android.build.api.transform.TransformInvocation;
/*     */ import com.android.build.api.transform.TransformOutputProvider;
/*     */ import com.android.build.gradle.internal.LoggerWrapper;
/*     */ import com.android.builder.dexing.DexMergerTool;
/*     */ import com.android.builder.dexing.DexingType;
/*     */ import com.android.ide.common.blame.MessageReceiver;
/*     */ import com.android.ide.common.blame.ParsingProcessOutputHandler;
/*     */ import com.android.ide.common.blame.parser.DexParser;
/*     */ import com.android.ide.common.blame.parser.PatternAwareOutputParser;
/*     */ import com.android.ide.common.blame.parser.ToolOutputParser;
/*     */ import com.android.ide.common.process.ProcessOutput;
/*     */ import com.android.utils.ILogger;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableMap.Builder;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.nio.file.Path;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ForkJoinPool;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000p\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\"\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020%\n\002\020\000\n\000\n\002\020#\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\001B5\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t\022\006\020\n\032\0020\013\022\006\020\f\032\0020\r¢\006\002\020\016J\016\020\024\032\b\022\004\022\0020\0260\025H\026J\b\020\027\032\0020\030H\026J\024\020\031\032\016\022\004\022\0020\030\022\004\022\0020\0330\032H\026J\020\020\034\032\n\022\006\b\000\022\0020\0360\035H\026J\b\020\037\032\0020\tH\026J\020\020 \032\0020!2\006\020\"\032\0020#H\026R\016\020\f\032\0020\rX\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R\026\020\017\032\n \021*\004\030\0010\0200\020X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\022\032\0020\023X\004¢\006\002\n\000R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000¨\006$"}, d2={"Lcom/android/build/gradle/internal/transforms/ExternalLibsMergerTransform;", "Lcom/android/build/api/transform/Transform;", "dexingType", "Lcom/android/builder/dexing/DexingType;", "dexMergerTool", "Lcom/android/builder/dexing/DexMergerTool;", "minSdkVersion", "", "isDebuggable", "", "messageReceiver", "Lcom/android/ide/common/blame/MessageReceiver;", "callableFactory", "Lcom/android/build/gradle/internal/transforms/DexMergerTransformCallable$Factory;", "(Lcom/android/builder/dexing/DexingType;Lcom/android/builder/dexing/DexMergerTool;IZLcom/android/ide/common/blame/MessageReceiver;Lcom/android/build/gradle/internal/transforms/DexMergerTransformCallable$Factory;)V", "forkJoinPool", "Ljava/util/concurrent/ForkJoinPool;", "kotlin.jvm.PlatformType", "logger", "Lcom/android/build/gradle/internal/LoggerWrapper;", "getInputTypes", "", "Lcom/android/build/api/transform/QualifiedContent$ContentType;", "getName", "", "getParameterInputs", "", "", "getScopes", "", "Lcom/android/build/api/transform/QualifiedContent$Scope;", "isIncremental", "transform", "", "transformInvocation", "Lcom/android/build/api/transform/TransformInvocation;", "gradle-core"})
/*     */ public final class ExternalLibsMergerTransform extends com.android.build.api.transform.Transform
/*     */ {
/*     */   private final LoggerWrapper logger;
/*     */   private final ForkJoinPool forkJoinPool;
/*     */   private final DexingType dexingType;
/*     */   private final DexMergerTool dexMergerTool;
/*     */   private final int minSdkVersion;
/*     */   private final boolean isDebuggable;
/*     */   private final MessageReceiver messageReceiver;
/*     */   private final DexMergerTransformCallable.Factory callableFactory;
/*     */   
/*     */   public ExternalLibsMergerTransform(@NotNull DexingType dexingType, @NotNull DexMergerTool dexMergerTool, int minSdkVersion, boolean isDebuggable, @NotNull MessageReceiver messageReceiver, @NotNull DexMergerTransformCallable.Factory callableFactory)
/*     */   {
/*  51 */     this.dexingType = dexingType;this.dexMergerTool = dexMergerTool;this.minSdkVersion = minSdkVersion;this.isDebuggable = isDebuggable;this.messageReceiver = messageReceiver;this.callableFactory = callableFactory;
/*     */     
/*  53 */     logger = LoggerWrapper.getLogger(ExternalLibsMergerTransform.class);
/*  54 */     forkJoinPool = ForkJoinPool.commonPool(); }
/*     */   @NotNull
/*  56 */   public String getName() { return "externalLibsDexMerger"; }
/*     */   
/*     */   @NotNull
/*  59 */   public Set<QualifiedContent.ContentType> getInputTypes() { ImmutableSet tmp6_3 = ImmutableSet.of(com.android.build.gradle.internal.pipeline.ExtendedContentType.DEX_ARCHIVE);Intrinsics.checkExpressionValueIsNotNull(tmp6_3, "ImmutableSet.of(ExtendedContentType.DEX_ARCHIVE)");return (Set)tmp6_3; }
/*     */   
/*     */   @NotNull
/*  62 */   public Set<? super QualifiedContent.Scope> getScopes() { ImmutableSet tmp6_3 = ImmutableSet.of(QualifiedContent.Scope.EXTERNAL_LIBRARIES);Intrinsics.checkExpressionValueIsNotNull(tmp6_3, "ImmutableSet.of(Qualifie…Scope.EXTERNAL_LIBRARIES)");return (Set)tmp6_3;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Map<String, Object> getParameterInputs()
/*     */   {
/*  68 */     ImmutableMap tmp30_27 = ImmutableMap.builder().put("dexing-type", dexingType.name()).put("dex-merger-tool", dexMergerTool.name()).build();Intrinsics.checkExpressionValueIsNotNull(tmp30_27, "ImmutableMap.builder<Str…\n                .build()");return (Map)tmp30_27; }
/*     */   
/*  70 */   public boolean isIncremental() { return true; }
/*     */   
/*     */   public void transform(@NotNull TransformInvocation transformInvocation)
/*     */   {
/*  74 */     Intrinsics.checkParameterIsNotNull(transformInvocation, "transformInvocation"); Collection tmp12_7 = transformInvocation.getInputs();Intrinsics.checkExpressionValueIsNotNull(tmp12_7, "transformInvocation.inputs");Iterable localIterable1 = (Iterable)tmp12_7;
/*     */     
/*     */     int $i$f$flatMap;
/*     */     
/*     */     Iterable $receiver$iv;
/*     */     
/* 128 */     Iterable localIterable2 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList();
/*     */     
/*     */     int $i$f$flatMapTo;
/*     */     
/*     */     Iterable $receiver$iv$iv;
/*     */     
/* 135 */     for (Object element$iv$iv : $receiver$iv$iv) {
/* 136 */       TransformInput it = (TransformInput)element$iv$iv;
/*     */       int $i$a$1$flatMap;
/*  75 */       TransformInput tmp75_73 = it;Intrinsics.checkExpressionValueIsNotNull(tmp75_73, "it");Iterable list$iv$iv = (Iterable)tmp75_73.getJarInputs();
/*     */       
/* 137 */       CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
/*     */     }
/*  74 */     List flattenInputs = 
/*     */     
/* 139 */       (List)destination$iv$iv;
/*  80 */     if (transformInvocation.isIncremental())
/*     */     {
/*  78 */       $receiver$iv = (Iterable)flattenInputs;
/*     */       
/*     */       int $i$f$filter;
/*     */       
/*     */       Iterable $receiver$iv;
/*     */       
/* 140 */       $receiver$iv$iv = $receiver$iv;destination$iv$iv = (Collection)new ArrayList();
/* 141 */       int $i$f$filterTo; for (??? = $receiver$iv$iv.iterator(); ???.hasNext();) { element$iv$iv = ???.next();JarInput it = (JarInput)element$iv$iv;
/*     */         int $i$a$1$filter;
/*  79 */         JarInput tmp175_173 = it;Intrinsics.checkExpressionValueIsNotNull(tmp175_173, "it"); if ((Intrinsics.areEqual(tmp175_173.getStatus(), Status.NOTCHANGED) ^ true)) destination$iv$iv.add(element$iv$iv); }
/*  80 */       if (
/*     */       
/* 142 */         ((List)destination$iv$iv).isEmpty()) {
/*  81 */         return;
/*     */       }
/*     */     }
/*  84 */     android.databinding.tool.util.Preconditions.check(transformInvocation.getOutputProvider() != null, 
/*  85 */       "No OutputProvider for ExternalLibsMergerTransform", new Object[0]);
/*     */     
/*  88 */     Iterable $receiver$iv$iv = (Iterable)flattenInputs;
/*     */     
/*     */     int $i$f$filter;
/*     */     
/* 143 */     Collection destination$iv$iv = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList();
/* 144 */     int $i$f$filterTo; for (Object element$iv$iv = $receiver$iv$iv.iterator(); ((Iterator)element$iv$iv).hasNext();) { Object element$iv$iv = ((Iterator)element$iv$iv).next();it = (JarInput)element$iv$iv;
/*     */       int $i$a$1$filter;
/*  89 */       JarInput tmp307_305 = it;Intrinsics.checkExpressionValueIsNotNull(tmp307_305, "it"); if ((Intrinsics.areEqual(tmp307_305.getStatus(), Status.REMOVED) ^ true)) { destination$iv$iv.add(element$iv$iv);
/*     */       }
/*     */     }
/*     */     
/*     */     JarInput it;
/*     */     
/* 145 */     Iterable $receiver$iv = (Iterable)destination$iv$iv;
/* 146 */     int $i$f$map; Iterable $receiver$iv; Iterable $receiver$iv$iv = $receiver$iv;Object destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 147 */     int $i$f$mapTo; Iterable $receiver$iv$iv; Object localObject1; Path localPath; for (element$iv$iv = $receiver$iv$iv.iterator(); ((Iterator)element$iv$iv).hasNext(); ((Collection)localObject1).add(localPath))
/*     */     {
/* 147 */       Object item$iv$iv = ((Iterator)element$iv$iv).next();
/* 148 */       it = (JarInput)item$iv$iv;localObject1 = destination$iv$iv;
/*     */       int $i$a$2$map;
/*     */       JarInput it;
/*  90 */       JarInput tmp417_415 = it;Intrinsics.checkExpressionValueIsNotNull(tmp417_415, "it");localPath = tmp417_415.getFile().toPath();
/*     */     }
/*  88 */     List jarInputList = 
/*     */     
/*  91 */       CollectionsKt.toList(
/*     */       
/* 149 */       (Iterable)destination$iv$iv);ParsingProcessOutputHandler outputHandler = new ParsingProcessOutputHandler(new ToolOutputParser((PatternAwareOutputParser)new DexParser(), com.android.ide.common.blame.Message.Kind.ERROR, (ILogger)logger), new ToolOutputParser((PatternAwareOutputParser)new DexParser(), (ILogger)logger), new MessageReceiver[] {messageReceiver }); TransformOutputProvider tmp535_530 = transformInvocation.getOutputProvider();
/*     */     
/*  98 */     if (tmp535_530 == null) Intrinsics.throwNpe(); File outputDir = tmp535_530.getContentLocation("main", 
/*  99 */       getOutputTypes(), 
/* 100 */       getScopes(), 
/* 101 */       com.android.build.api.transform.Format.DIRECTORY);
/* 102 */     com.android.utils.FileUtils.cleanOutputDir(outputDir);
/*     */     
/* 105 */     if (jarInputList.isEmpty()) {
/* 106 */       return;
/*     */     }
/*     */     
/* 109 */     destination$iv$iv = (Closeable)outputHandler.createOutput();element$iv$iv = (Throwable)null; try { ProcessOutput processOutputHandler = (ProcessOutput)destination$iv$iv;
/* 110 */       int $i$a$2$use; DexMergerTransformCallable callable = callableFactory.create(
/* 111 */         messageReceiver, 
/* 112 */         dexingType, 
/* 113 */         processOutputHandler, 
/* 114 */         outputDir, 
/* 115 */         (Iterable)jarInputList, 
/* 116 */         null, 
/* 117 */         forkJoinPool, 
/* 118 */         dexMergerTool, 
/* 119 */         minSdkVersion, 
/* 120 */         isDebuggable);processOutputHandler = 
/*     */       
/* 123 */         callable.call();
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/* 109 */       element$iv$iv = localThrowable; throw localThrowable; } finally { kotlin.io.CloseableKt.closeFinally((Closeable)destination$iv$iv, (Throwable)element$iv$iv);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.ExternalLibsMergerTransform
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */