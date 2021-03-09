/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.DefaultContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.SecondaryFile;
/*     */ import com.android.build.api.transform.TransformException;
/*     */ import com.android.build.api.transform.TransformInvocation;
/*     */ import com.android.build.gradle.internal.LoggerWrapper;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.multidex.D8MainDexList;
/*     */ import com.android.builder.multidex.D8MainDexList.MainDexListException;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.io.File;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.OpenOption;
/*     */ import java.nio.file.Path;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.Supplier;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000v\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\020 \n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\000\n\002\020\037\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\017\b\026\022\006\020\002\032\0020\003¢\006\002\020\004BA\022\006\020\005\032\0020\006\022\n\b\002\020\007\032\004\030\0010\006\022\n\b\002\020\b\032\004\030\0010\006\022\006\020\t\032\0020\006\022\022\020\n\032\016\022\n\022\b\022\004\022\0020\0060\f0\013¢\006\002\020\rJ\020\020\020\032\n\022\006\b\001\022\0020\0220\021H\026J\b\020\023\032\0020\024H\026J\024\020\025\032\016\022\004\022\0020\024\022\004\022\0020\0270\026H\026J\020\020\030\032\n\022\006\b\000\022\0020\0310\021H\026J\020\020\032\032\n\022\006\b\000\022\0020\0310\021H\026J\016\020\033\032\b\022\004\022\0020\0350\034H\026J\016\020\036\032\b\022\004\022\0020 0\037H\026J\b\020!\032\0020\"H\026J\b\020#\032\0020\"H\026J\020\020$\032\0020%2\006\020&\032\0020'H\026R\032\020\n\032\016\022\n\022\b\022\004\022\0020\0060\f0\013X\004¢\006\002\n\000R\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\t\032\0020\006X\004¢\006\002\n\000R\020\020\b\032\004\030\0010\006X\004¢\006\002\n\000R\020\020\007\032\004\030\0010\006X\004¢\006\002\n\000¨\006("}, d2={"Lcom/android/build/gradle/internal/transforms/D8MainDexListTransform;", "Lcom/android/build/api/transform/Transform;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "(Lcom/android/build/gradle/internal/scope/VariantScope;)V", "manifestProguardRules", "Ljava/nio/file/Path;", "userProguardRules", "userClasses", "outputMainDexList", "bootClasspath", "Ljava/util/function/Supplier;", "", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/util/function/Supplier;)V", "logger", "Lcom/android/build/gradle/internal/LoggerWrapper;", "getInputTypes", "Lcom/google/common/collect/ImmutableSet;", "Lcom/android/build/api/transform/QualifiedContent$ContentType;", "getName", "", "getParameterInputs", "Lcom/google/common/collect/ImmutableMap;", "", "getReferencedScopes", "Lcom/android/build/api/transform/QualifiedContent$Scope;", "getScopes", "getSecondaryFileOutputs", "Lcom/google/common/collect/ImmutableList;", "Ljava/io/File;", "getSecondaryFiles", "", "Lcom/android/build/api/transform/SecondaryFile;", "isCacheable", "", "isIncremental", "transform", "", "invocation", "Lcom/android/build/api/transform/TransformInvocation;", "gradle-core"})
/*     */ public final class D8MainDexListTransform extends com.android.build.api.transform.Transform
/*     */ {
/*     */   private final LoggerWrapper logger;
/*     */   private final Path manifestProguardRules;
/*     */   private final Path userProguardRules;
/*     */   private final Path userClasses;
/*     */   private final Path outputMainDexList;
/*     */   private final Supplier<List<Path>> bootClasspath;
/*     */   
/*     */   public D8MainDexListTransform(@NotNull Path manifestProguardRules, @Nullable Path userProguardRules, @Nullable Path userClasses, @NotNull Path outputMainDexList, @NotNull Supplier<List<Path>> bootClasspath)
/*     */   {
/*  49 */     this.manifestProguardRules = manifestProguardRules;this.userProguardRules = userProguardRules;this.userClasses = userClasses;this.outputMainDexList = outputMainDexList;this.bootClasspath = bootClasspath;
/*     */     
/*  51 */     logger = LoggerWrapper.getLogger(D8MainDexListTransform.class);
/*     */   }
/*     */   
/*     */   @NotNull
/*  66 */   public String getName() { return "multidexlist"; }
/*     */   
/*     */   @NotNull
/*  69 */   public ImmutableSet<? extends QualifiedContent.ContentType> getInputTypes() { ImmutableSet tmp13_10 = Sets.immutableEnumSet((Enum)QualifiedContent.DefaultContentType.CLASSES, new QualifiedContent.DefaultContentType[0]);Intrinsics.checkExpressionValueIsNotNull(tmp13_10, "Sets.immutableEnumSet(Qu…faultContentType.CLASSES)");return tmp13_10; }
/*     */   @NotNull
/*  71 */   public ImmutableSet<? super QualifiedContent.Scope> getScopes() { ImmutableSet tmp3_0 = ImmutableSet.of();Intrinsics.checkExpressionValueIsNotNull(tmp3_0, "ImmutableSet.of()");return tmp3_0; }
/*     */   
/*     */   @NotNull
/*  74 */   public ImmutableSet<? super QualifiedContent.Scope> getReferencedScopes() { ImmutableSet tmp37_34 = Sets.immutableEnumSet(
/*  75 */       (Enum)QualifiedContent.Scope.PROJECT, new QualifiedContent.Scope[] {
/*  76 */       QualifiedContent.Scope.SUB_PROJECTS, 
/*  77 */       QualifiedContent.Scope.EXTERNAL_LIBRARIES, 
/*  78 */       QualifiedContent.Scope.PROVIDED_ONLY, 
/*  79 */       QualifiedContent.Scope.TESTED_CODE });Intrinsics.checkExpressionValueIsNotNull(tmp37_34, "Sets.immutableEnumSet(\n …       Scope.TESTED_CODE)");return tmp37_34; }
/*     */   
/*  81 */   public boolean isIncremental() { return false; }
/*     */   
/*  83 */   public boolean isCacheable() { return true; }
/*     */   
/*     */   @NotNull
/*     */   public ImmutableList<File> getSecondaryFileOutputs()
/*     */   {
/*  92 */     ImmutableList tmp12_9 = ImmutableList.of(outputMainDexList.toFile());Intrinsics.checkExpressionValueIsNotNull(tmp12_9, "ImmutableList.of(outputMainDexList.toFile())");return tmp12_9; }
/*     */   
/*     */   @NotNull
/*  95 */   public ImmutableMap<String, Object> getParameterInputs() { ImmutableMap tmp10_7 = ImmutableMap.of("implementation", D8MainDexListTransform.class.getName());Intrinsics.checkExpressionValueIsNotNull(tmp10_7, "ImmutableMap.of(\"impleme…ansform::class.java.name)");return tmp10_7;
/*     */   }
/*     */   
/*  98 */   public void transform(@NotNull TransformInvocation invocation) { Intrinsics.checkParameterIsNotNull(invocation, "invocation");logger.verbose("Generating the main dex list using D8.", new Object[0]);
/*     */     try {
/* 100 */       Map inputs = MainDexListTransform.getByInputType(invocation); Object 
/* 101 */         tmp34_29 = inputs.get(MainDexListTransform.ProguardInput.INPUT_JAR);
/* 101 */       if (tmp34_29 == null) Intrinsics.throwNpe(); Iterable $receiver$iv = (Iterable)tmp34_29;
/*     */       
/*     */       int $i$f$map;
/*     */       
/* 140 */       Iterable localIterable1 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 141 */       int $i$f$mapTo; Iterable $receiver$iv$iv; Collection localCollection1; int $i$a$1$map; Object localObject1; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); localCollection1.add(localObject1))
/*     */       {
/* 141 */         item$iv$iv = localIterator.next();
/* 142 */         File localFile1 = (File)item$iv$iv;localCollection1 = destination$iv$iv;
/*     */         File it;
/* 101 */         localObject1 = it.toPath(); } List programFiles = 
/*     */       
/* 143 */         (List)destination$iv$iv; Object tmp143_138 = inputs.get(MainDexListTransform.ProguardInput.LIBRARY_JAR);
/* 102 */       if (tmp143_138 == null) Intrinsics.throwNpe(); Iterable $receiver$iv = (Iterable)tmp143_138;
/*     */       
/*     */       int $i$f$map;
/*     */       
/* 144 */       destination$iv$iv = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 145 */       int $i$f$mapTo; Iterable $receiver$iv$iv; for (Object item$iv$iv = $receiver$iv$iv.iterator(); ((Iterator)item$iv$iv).hasNext(); localCollection1.add(localObject1))
/*     */       {
/* 145 */         item$iv$iv = ((Iterator)item$iv$iv).next();
/* 146 */         $i$a$1$map = (File)item$iv$iv;localCollection1 = destination$iv$iv;
/*     */         File it;
/* 102 */         localObject1 = it.toPath(); } Object tmp254_249 = bootClasspath.get();Intrinsics.checkExpressionValueIsNotNull(tmp254_249, "bootClasspath.get()");List libraryFiles = CollectionsKt.plus(
/*     */       
/* 147 */         (Collection)destination$iv$iv, (Iterable)tmp254_249);logger.verbose("Program files: %s", new Object[] { CollectionsKt.joinToString$default((Iterable)programFiles, null, null, null, 0, null, null, 63, null) });logger.verbose("Library files: %s", new Object[] { CollectionsKt.joinToString$default((Iterable)libraryFiles, null, null, null, 0, null, null, 63, null) });logger.verbose("Proguard rule files: %s", new Object[] {CollectionsKt.joinToString$default((Iterable)CollectionsKt.listOfNotNull(new Path[] { manifestProguardRules, userProguardRules }), null, null, null, 0, null, null, 63, null) });List proguardRules = CollectionsKt.listOfNotNull(new Path[] { manifestProguardRules, userProguardRules });Set mainDexClasses = (Set)new LinkedHashSet(); List tmp426_423 = MainDexListTransform.getPlatformRules();Intrinsics.checkExpressionValueIsNotNull(tmp426_423, "MainDexListTransform.getPlatformRules()");Iterable $receiver$iv = (Iterable)tmp426_423;
/*     */       
/*     */       int $i$f$map;
/*     */       
/* 148 */       Object item$iv$iv = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 149 */       int $i$f$mapTo; Iterable $receiver$iv$iv; for (int $i$a$1$map = $receiver$iv$iv.iterator(); $i$a$1$map.hasNext(); localCollection1.add(localObject1))
/*     */       {
/* 149 */         Object item$iv$iv = $i$a$1$map.next();
/* 150 */         $i$f$map = (String)item$iv$iv;localCollection1 = destination$iv$iv;
/*     */         int $i$a$1$map;
/*     */         String it;
/* 112 */         localObject1 = "-keep " + it; } List keepRules = 
/*     */       
/* 151 */         (List)destination$iv$iv; List tmp561_558 = D8MainDexList.generate(keepRules, proguardRules, (Collection)programFiles, (Collection)libraryFiles);Intrinsics.checkExpressionValueIsNotNull(tmp561_558, "D8MainDexList.generate(\n…            libraryFiles)");mainDexClasses.addAll((Collection)tmp561_558);
/*     */       
/* 120 */       if (userClasses != null) {
/* 121 */         List tmp593_590 = Files.readAllLines(userClasses);Intrinsics.checkExpressionValueIsNotNull(tmp593_590, "Files.readAllLines(userClasses)");mainDexClasses.addAll((Collection)tmp593_590);
/*     */       }
/*     */       
/* 124 */       Files.deleteIfExists(outputMainDexList);
/* 125 */       Files.write(outputMainDexList, (Iterable)mainDexClasses, new OpenOption[0]);
/*     */     } catch (D8MainDexList.MainDexListException e) {
/* 127 */       throw ((Throwable)new TransformException("Error while generating the main dex list.", (Throwable)e));
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Collection<SecondaryFile> getSecondaryFiles()
/*     */   {
/*  86 */     Iterable localIterable1 = (Iterable)CollectionsKt.listOfNotNull(new Path[] { manifestProguardRules, userProguardRules, userClasses });
/*     */     
/*     */     int $i$f$map;
/*     */     
/* 132 */     Iterable localIterable2 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 133 */     int $i$f$mapTo; Collection localCollection1; Object it; Object localObject1; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); localCollection1.add(localObject1))
/*     */     {
/* 133 */       Object item$iv$iv = localIterator.next();
/* 134 */       Path localPath = (Path)item$iv$iv;localCollection1 = destination$iv$iv;
/*     */       int $i$a$1$map;
/*  87 */       localObject1 = ((Path)it).toFile();
/*     */     }
/*     */     
/* 135 */     Iterable $receiver$iv = (Iterable)destination$iv$iv;
/* 136 */     int $i$f$map; Iterable $receiver$iv; Iterable $receiver$iv$iv = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 137 */     int $i$f$mapTo; Iterable $receiver$iv$iv; for (localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); localCollection1.add(localObject1))
/*     */     {
/* 137 */       Object item$iv$iv = localIterator.next();
/* 138 */       it = (File)item$iv$iv;localCollection1 = destination$iv$iv;
/*     */       int $i$a$2$map;
/*     */       File it;
/*  88 */       localObject1 = SecondaryFile.nonIncremental(it); }
/*  89 */     return CollectionsKt.toCollection(
/*     */     
/* 139 */       (Iterable)destination$iv$iv, (Collection)new ArrayList());
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public D8MainDexListTransform(@NotNull VariantScope variantScope)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc_w 363
/*     */     //   4: invokestatic 207	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   7: aload_0
/*     */     //   8: aload_1
/*     */     //   9: invokeinterface 368 1 0
/*     */     //   14: invokevirtual 242	java/io/File:toPath	()Ljava/nio/file/Path;
/*     */     //   17: dup
/*     */     //   18: ldc_w 370
/*     */     //   21: invokestatic 42	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   24: aload_1
/*     */     //   25: invokeinterface 374 1 0
/*     */     //   30: dup
/*     */     //   31: ldc_w 376
/*     */     //   34: invokestatic 42	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   37: invokevirtual 381	com/android/build/gradle/internal/core/GradleVariantConfiguration:getMultiDexKeepProguard	()Ljava/io/File;
/*     */     //   40: dup
/*     */     //   41: ifnull +9 -> 50
/*     */     //   44: invokevirtual 242	java/io/File:toPath	()Ljava/nio/file/Path;
/*     */     //   47: goto +5 -> 52
/*     */     //   50: pop
/*     */     //   51: aconst_null
/*     */     //   52: aload_1
/*     */     //   53: invokeinterface 374 1 0
/*     */     //   58: dup
/*     */     //   59: ldc_w 376
/*     */     //   62: invokestatic 42	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   65: invokevirtual 384	com/android/build/gradle/internal/core/GradleVariantConfiguration:getMultiDexKeepFile	()Ljava/io/File;
/*     */     //   68: dup
/*     */     //   69: ifnull +9 -> 78
/*     */     //   72: invokevirtual 242	java/io/File:toPath	()Ljava/nio/file/Path;
/*     */     //   75: goto +5 -> 80
/*     */     //   78: pop
/*     */     //   79: aconst_null
/*     */     //   80: aload_1
/*     */     //   81: invokeinterface 387 1 0
/*     */     //   86: invokevirtual 242	java/io/File:toPath	()Ljava/nio/file/Path;
/*     */     //   89: dup
/*     */     //   90: ldc_w 389
/*     */     //   93: invokestatic 42	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   96: new 391	com/android/build/gradle/internal/transforms/D8MainDexListTransform$1
/*     */     //   99: dup
/*     */     //   100: aload_1
/*     */     //   101: invokespecial 393	com/android/build/gradle/internal/transforms/D8MainDexListTransform$1:<init>	(Lcom/android/build/gradle/internal/scope/VariantScope;)V
/*     */     //   104: checkcast 251	java/util/function/Supplier
/*     */     //   107: invokespecial 360	com/android/build/gradle/internal/transforms/D8MainDexListTransform:<init>	(Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/util/function/Supplier;)V
/*     */     //   110: return
/*     */     // Line number table:
/*     */     //   Java source line #53	-> byte code offset #7
/*     */     //   Java source line #55	-> byte code offset #8
/*     */     //   Java source line #56	-> byte code offset #24
/*     */     //   Java source line #57	-> byte code offset #52
/*     */     //   Java source line #58	-> byte code offset #80
/*     */     //   Java source line #59	-> byte code offset #96
/*     */     //   Java source line #54	-> byte code offset #107
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	111	0	this	D8MainDexListTransform
/*     */     //   0	111	1	variantScope	VariantScope
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.D8MainDexListTransform
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */