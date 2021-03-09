/*     */ package com.android.build.gradle.internal.api.dsl.model;
/*     */ 
/*     */ import com.android.build.api.dsl.options.PostProcessingFiles;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.collections.ArraysKt;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000L\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\t\n\002\020\002\n\000\n\002\020\000\n\002\b\002\n\002\020\021\n\002\b\006\n\002\020\034\n\002\b\005\030\0002\0020\0012\0020\002B#\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\f\020\007\032\b\022\004\022\0020\t0\b¢\006\002\020\nJ\020\020\025\032\0020\0262\006\020\027\032\0020\030H\027J!\020\031\032\0020\0262\022\020\032\032\n\022\006\b\001\022\0020\0300\033\"\0020\030H\027¢\006\002\020\034J\016\020\035\032\0020\0262\006\020\036\032\0020\000J\020\020\027\032\0020\0262\006\020\027\032\0020\030H\027J!\020\032\032\0020\0262\022\020\037\032\n\022\006\b\001\022\0020\0300\033\"\0020\030H\027¢\006\002\020\034J\026\020 \032\0020\0262\f\020!\032\b\022\004\022\0020\0300\"H\027J\026\020#\032\0020\0262\f\020!\032\b\022\004\022\0020\0300\"H\027J\026\020$\032\0020\0262\f\020\037\032\b\022\004\022\0020\0300\"H\027J\020\020%\032\0020\0262\006\020\027\032\0020\030H\027J!\020&\032\0020\0262\022\020\032\032\n\022\006\b\001\022\0020\0300\033\"\0020\030H\027¢\006\002\020\034R(\020\r\032\004\030\0010\f2\b\020\013\032\004\030\0010\f@VX\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R\016\020\003\032\0020\004X\004¢\006\002\n\000R\024\020\007\032\b\022\004\022\0020\t0\bX\004¢\006\002\n\000R(\020\022\032\004\030\0010\f2\b\020\013\032\004\030\0010\f@VX\016¢\006\016\n\000\032\004\b\023\020\017\"\004\b\024\020\021¨\006'"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrProductFlavorImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/model/BuildTypeOrProductFlavor;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "postProcessingFiles", "Lkotlin/Function0;", "Lcom/android/build/api/dsl/options/PostProcessingFiles;", "(Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;Lkotlin/jvm/functions/Function0;)V", "value", "", "applicationIdSuffix", "getApplicationIdSuffix", "()Ljava/lang/String;", "setApplicationIdSuffix", "(Ljava/lang/String;)V", "versionNameSuffix", "getVersionNameSuffix", "setVersionNameSuffix", "consumerProguardFile", "", "proguardFile", "", "consumerProguardFiles", "proguardFiles", "", "([Ljava/lang/Object;)V", "initWith", "that", "files", "setConsumerProguardFiles", "proguardFileIterable", "", "setProguardFiles", "setTestProguardFiles", "testProguardFile", "testProguardFiles", "gradle-core"})
/*     */ public final class BuildTypeOrProductFlavorImpl extends SealableObject implements com.android.build.api.dsl.model.BuildTypeOrProductFlavor
/*     */ {
/*     */   @Nullable
/*     */   private String applicationIdSuffix;
/*     */   @Nullable
/*     */   private String versionNameSuffix;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   private final Function0<PostProcessingFiles> postProcessingFiles;
/*     */   
/*     */   public BuildTypeOrProductFlavorImpl(@NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter, @NotNull Function0<? extends PostProcessingFiles> postProcessingFiles)
/*     */   {
/*  29 */     super(issueReporter);this.deprecationReporter = deprecationReporter;this.postProcessingFiles = postProcessingFiles; }
/*     */   @Nullable
/*  31 */   public String getApplicationIdSuffix() { return applicationIdSuffix; }
/*     */   
/*  33 */   public void setApplicationIdSuffix(@Nullable String value) { if (checkSeal())
/*  34 */       applicationIdSuffix = value; }
/*     */   
/*     */   @Nullable
/*  37 */   public String getVersionNameSuffix() { return versionNameSuffix; }
/*     */   
/*  39 */   public void setVersionNameSuffix(@Nullable String value) { if (checkSeal()) {
/*  40 */       versionNameSuffix = value;
/*     */     }
/*     */   }
/*     */   
/*     */   public void proguardFile(@NotNull Object proguardFile)
/*     */   {
/*  46 */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");deprecationReporter.reportDeprecatedUsage(
/*  47 */       "Postprocessing.proguardFiles", 
/*  48 */       "proguardFile()", 
/*  49 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/*  50 */     ((PostProcessingFiles)postProcessingFiles.invoke()).getProguardFiles().add(proguardFile);
/*     */   }
/*     */   
/*     */   public void proguardFiles(@NotNull Object... files)
/*     */   {
/*  55 */     Intrinsics.checkParameterIsNotNull(files, "files");deprecationReporter.reportDeprecatedUsage(
/*  56 */       "Postprocessing.proguardFiles", 
/*  57 */       "proguardFiles()", 
/*  58 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/*  59 */     ((PostProcessingFiles)postProcessingFiles.invoke()).getProguardFiles().addAll((Collection)ArraysKt.toMutableList(files));
/*     */   }
/*     */   
/*     */   public void setProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable)
/*     */   {
/*  64 */     Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");deprecationReporter.reportDeprecatedUsage(
/*  65 */       "Postprocessing.proguardFiles", 
/*  66 */       "setProguardFiles()", 
/*  67 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/*  68 */     ((PostProcessingFiles)postProcessingFiles.invoke()).getProguardFiles().addAll((Collection)CollectionsKt.toMutableList(proguardFileIterable));
/*     */   }
/*     */   
/*     */   public void testProguardFile(@NotNull Object proguardFile)
/*     */   {
/*  73 */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");deprecationReporter.reportDeprecatedUsage(
/*  74 */       "Postprocessing.testProguardFiles", 
/*  75 */       "testProguardFile()", 
/*  76 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/*  77 */     ((PostProcessingFiles)postProcessingFiles.invoke()).getTestProguardFiles().add(proguardFile);
/*     */   }
/*     */   
/*     */   public void testProguardFiles(@NotNull Object... proguardFiles)
/*     */   {
/*  82 */     Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");deprecationReporter.reportDeprecatedUsage(
/*  83 */       "Postprocessing.testProguardFiles", 
/*  84 */       "testProguardFiles()", 
/*  85 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/*  86 */     ((PostProcessingFiles)postProcessingFiles.invoke()).getTestProguardFiles().addAll((Collection)ArraysKt.toMutableList(proguardFiles));
/*     */   }
/*     */   
/*     */   public void setTestProguardFiles(@NotNull Iterable<? extends Object> files)
/*     */   {
/*  91 */     Intrinsics.checkParameterIsNotNull(files, "files");deprecationReporter.reportDeprecatedUsage(
/*  92 */       "Postprocessing.testProguardFiles", 
/*  93 */       "setTestProguardFiles()", 
/*  94 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/*  95 */     ((PostProcessingFiles)postProcessingFiles.invoke()).getTestProguardFiles().addAll((Collection)CollectionsKt.toMutableList(files));
/*     */   }
/*     */   
/*     */   public void consumerProguardFile(@NotNull Object proguardFile)
/*     */   {
/* 100 */     Intrinsics.checkParameterIsNotNull(proguardFile, "proguardFile");deprecationReporter.reportDeprecatedUsage(
/* 101 */       "Postprocessing.consumerProguardFiles", 
/* 102 */       "consumerProguardFile()", 
/* 103 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 104 */     ((PostProcessingFiles)postProcessingFiles.invoke()).getConsumerProguardFiles().add(proguardFile);
/*     */   }
/*     */   
/*     */   public void consumerProguardFiles(@NotNull Object... proguardFiles)
/*     */   {
/* 109 */     Intrinsics.checkParameterIsNotNull(proguardFiles, "proguardFiles");deprecationReporter.reportDeprecatedUsage(
/* 110 */       "Postprocessing.consumerProguardFiles", 
/* 111 */       "consumerProguardFiles()", 
/* 112 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 113 */     ((PostProcessingFiles)postProcessingFiles.invoke()).getConsumerProguardFiles().addAll((Collection)ArraysKt.toMutableList(proguardFiles));
/*     */   }
/*     */   
/*     */   public void setConsumerProguardFiles(@NotNull Iterable<? extends Object> proguardFileIterable)
/*     */   {
/* 118 */     Intrinsics.checkParameterIsNotNull(proguardFileIterable, "proguardFileIterable");deprecationReporter.reportDeprecatedUsage(
/* 119 */       "Postprocessing.consumerProguardFiles", 
/* 120 */       "setConsumerProguardFile()", 
/* 121 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 122 */     ((PostProcessingFiles)postProcessingFiles.invoke()).getConsumerProguardFiles().addAll((Collection)CollectionsKt.toMutableList(proguardFileIterable));
/*     */   }
/*     */   
/*     */   public final void initWith(@NotNull BuildTypeOrProductFlavorImpl that) {
/* 126 */     Intrinsics.checkParameterIsNotNull(that, "that");setApplicationIdSuffix(that.getApplicationIdSuffix());
/* 127 */     setVersionNameSuffix(that.getVersionNameSuffix());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.BuildTypeOrProductFlavorImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */