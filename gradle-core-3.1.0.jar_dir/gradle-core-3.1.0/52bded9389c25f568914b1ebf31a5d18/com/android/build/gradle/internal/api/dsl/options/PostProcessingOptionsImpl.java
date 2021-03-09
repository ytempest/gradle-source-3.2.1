/*     */ package com.android.build.gradle.internal.api.dsl.options;
/*     */ 
/*     */ import com.android.build.api.dsl.options.PostProcessingOptions;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.InitializableSealable;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableList;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableList.Companion;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000B\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\000\n\002\b\003\n\002\020\016\n\002\b\005\n\002\020!\n\002\b\005\n\002\020\013\n\002\b\021\n\002\020\002\n\002\b\003\030\0002\b\022\004\022\0020\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\020\020)\032\0020*2\006\020+\032\0020\002H\026J\b\020,\032\0020*H\026R\024\020\006\032\b\022\004\022\0020\b0\007X\004¢\006\002\n\000R\024\020\t\032\b\022\004\022\0020\b0\007X\004¢\006\002\n\000R\024\020\n\032\b\022\004\022\0020\b0\007X\004¢\006\002\n\000R$\020\r\032\0020\f2\006\020\013\032\0020\f@VX\016¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R0\020\023\032\b\022\004\022\0020\b0\0222\f\020\013\032\b\022\004\022\0020\b0\0228V@VX\016¢\006\f\032\004\b\024\020\025\"\004\b\026\020\027R$\020\031\032\0020\0302\006\020\013\032\0020\030@VX\016¢\006\016\n\000\032\004\b\031\020\032\"\004\b\033\020\034R$\020\035\032\0020\0302\006\020\013\032\0020\030@VX\016¢\006\016\n\000\032\004\b\035\020\032\"\004\b\036\020\034R$\020\037\032\0020\0302\006\020\013\032\0020\030@VX\016¢\006\016\n\000\032\004\b\037\020\032\"\004\b \020\034R$\020!\032\0020\0302\006\020\013\032\0020\030@VX\016¢\006\016\n\000\032\004\b!\020\032\"\004\b\"\020\034R0\020#\032\b\022\004\022\0020\b0\0222\f\020\013\032\b\022\004\022\0020\b0\0228V@VX\016¢\006\f\032\004\b$\020\025\"\004\b%\020\027R0\020&\032\b\022\004\022\0020\b0\0222\f\020\013\032\b\022\004\022\0020\b0\0228V@VX\016¢\006\f\032\004\b'\020\025\"\004\b(\020\027¨\006-"}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/PostProcessingOptionsImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "Lcom/android/build/api/dsl/options/PostProcessingOptions;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "_consumerProguardFiles", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableList;", "", "_proguardFiles", "_testProguardFiles", "value", "", "codeShrinker", "getCodeShrinker", "()Ljava/lang/String;", "setCodeShrinker", "(Ljava/lang/String;)V", "", "consumerProguardFiles", "getConsumerProguardFiles", "()Ljava/util/List;", "setConsumerProguardFiles", "(Ljava/util/List;)V", "", "isObfuscate", "()Z", "setObfuscate", "(Z)V", "isOptimizeCode", "setOptimizeCode", "isRemoveUnusedCode", "setRemoveUnusedCode", "isRemoveUnusedResources", "setRemoveUnusedResources", "proguardFiles", "getProguardFiles", "setProguardFiles", "testProguardFiles", "getTestProguardFiles", "setTestProguardFiles", "initWith", "", "that", "seal", "gradle-core"})
/*     */ public final class PostProcessingOptionsImpl
/*     */   extends InitializableSealable<PostProcessingOptions>
/*     */   implements PostProcessingOptions
/*     */ {
/*     */   private final SealableList<Object> _proguardFiles;
/*     */   private final SealableList<Object> _testProguardFiles;
/*     */   private final SealableList<Object> _consumerProguardFiles;
/*     */   private boolean isRemoveUnusedCode;
/*     */   private boolean isRemoveUnusedResources;
/*     */   private boolean isObfuscate;
/*     */   private boolean isOptimizeCode;
/*     */   @NotNull
/*     */   private String codeShrinker;
/*     */   
/*     */   @NotNull
/*  33 */   public List<Object> getProguardFiles() { return (List)_proguardFiles; }
/*     */   
/*  35 */   public void setProguardFiles(@NotNull List<Object> value) { Intrinsics.checkParameterIsNotNull(value, "value");_proguardFiles.reset$gradle_core((Collection)value);
/*     */   }
/*     */   
/*     */   @NotNull
/*  39 */   public List<Object> getTestProguardFiles() { return (List)_testProguardFiles; }
/*     */   
/*  41 */   public void setTestProguardFiles(@NotNull List<Object> value) { Intrinsics.checkParameterIsNotNull(value, "value");_testProguardFiles.reset$gradle_core((Collection)value);
/*     */   }
/*     */   
/*     */   @NotNull
/*  45 */   public List<Object> getConsumerProguardFiles() { return (List)_consumerProguardFiles; }
/*     */   
/*  47 */   public void setConsumerProguardFiles(@NotNull List<Object> value) { Intrinsics.checkParameterIsNotNull(value, "value");_consumerProguardFiles.reset$gradle_core((Collection)value);
/*     */   }
/*     */   
/*  50 */   public boolean isRemoveUnusedCode() { return isRemoveUnusedCode; }
/*     */   
/*  52 */   public void setRemoveUnusedCode(boolean value) { if (checkSeal()) {
/*  53 */       isRemoveUnusedCode = value;
/*     */     }
/*     */   }
/*     */   
/*  57 */   public boolean isRemoveUnusedResources() { return isRemoveUnusedResources; }
/*     */   
/*  59 */   public void setRemoveUnusedResources(boolean value) { if (checkSeal()) {
/*  60 */       isRemoveUnusedResources = value;
/*     */     }
/*     */   }
/*     */   
/*  64 */   public boolean isObfuscate() { return isObfuscate; }
/*     */   
/*  66 */   public void setObfuscate(boolean value) { if (checkSeal()) {
/*  67 */       isObfuscate = value;
/*     */     }
/*     */   }
/*     */   
/*  71 */   public boolean isOptimizeCode() { return isOptimizeCode; }
/*     */   
/*  73 */   public void setOptimizeCode(boolean value) { if (checkSeal())
/*  74 */       isOptimizeCode = value;
/*     */   }
/*     */   
/*     */   @NotNull
/*  78 */   public String getCodeShrinker() { return codeShrinker; }
/*     */   
/*     */   public PostProcessingOptionsImpl(@NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  25 */     super(issueReporter);
/*     */     
/*  28 */     _proguardFiles = SealableList.Companion.jdMethod_new(issueReporter);
/*  29 */     _testProguardFiles = SealableList.Companion.jdMethod_new(issueReporter);
/*  30 */     _consumerProguardFiles = SealableList.Companion.jdMethod_new(issueReporter);
/*     */     
/*  78 */     codeShrinker = "auto"; }
/*     */   
/*  80 */   public void setCodeShrinker(@NotNull String value) { Intrinsics.checkParameterIsNotNull(value, "value"); if (checkSeal()) {
/*  81 */       codeShrinker = value;
/*     */     }
/*     */   }
/*     */   
/*     */   public void initWith(@NotNull PostProcessingOptions that) {
/*  86 */     Intrinsics.checkParameterIsNotNull(that, "that"); if (checkSeal()) {
/*  87 */       _proguardFiles.reset$gradle_core((Collection)that.getProguardFiles());
/*  88 */       _testProguardFiles.reset$gradle_core((Collection)that.getTestProguardFiles());
/*  89 */       _consumerProguardFiles.reset$gradle_core((Collection)that.getConsumerProguardFiles());
/*  90 */       setRemoveUnusedCode(that.isRemoveUnusedCode());
/*  91 */       setRemoveUnusedResources(that.isRemoveUnusedResources());
/*  92 */       setObfuscate(that.isObfuscate());
/*  93 */       setOptimizeCode(that.isOptimizeCode());
/*  94 */       setCodeShrinker(that.getCodeShrinker());
/*     */     }
/*     */   }
/*     */   
/*     */   public void seal() {
/*  99 */     super.seal();
/*     */     
/* 101 */     _proguardFiles.seal();
/* 102 */     _testProguardFiles.seal();
/* 103 */     _consumerProguardFiles.seal();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.PostProcessingOptionsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */