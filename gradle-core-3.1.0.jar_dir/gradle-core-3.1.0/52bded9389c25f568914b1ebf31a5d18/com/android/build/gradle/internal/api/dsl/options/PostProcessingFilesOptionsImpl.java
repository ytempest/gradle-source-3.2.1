/*    */ package com.android.build.gradle.internal.api.dsl.options;
/*    */ 
/*    */ import com.android.build.api.dsl.options.PostProcessingFilesOptions;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.InitializableSealable;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableList;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableList.Companion;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\000\n\002\b\003\n\002\020!\n\002\b\f\n\002\020\002\n\002\b\003\030\0002\b\022\004\022\0020\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\020\020\030\032\0020\0312\006\020\032\032\0020\002H\026J\b\020\033\032\0020\031H\026R\024\020\006\032\b\022\004\022\0020\b0\007X\004¢\006\002\n\000R\024\020\t\032\b\022\004\022\0020\b0\007X\004¢\006\002\n\000R\024\020\n\032\b\022\004\022\0020\b0\007X\004¢\006\002\n\000R0\020\r\032\b\022\004\022\0020\b0\f2\f\020\013\032\b\022\004\022\0020\b0\f8V@VX\016¢\006\f\032\004\b\016\020\017\"\004\b\020\020\021R0\020\022\032\b\022\004\022\0020\b0\f2\f\020\013\032\b\022\004\022\0020\b0\f8V@VX\016¢\006\f\032\004\b\023\020\017\"\004\b\024\020\021R0\020\025\032\b\022\004\022\0020\b0\f2\f\020\013\032\b\022\004\022\0020\b0\f8V@VX\016¢\006\f\032\004\b\026\020\017\"\004\b\027\020\021¨\006\034"}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/PostProcessingFilesOptionsImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "_consumerProguardFiles", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableList;", "", "_proguardFiles", "_testProguardFiles", "value", "", "consumerProguardFiles", "getConsumerProguardFiles", "()Ljava/util/List;", "setConsumerProguardFiles", "(Ljava/util/List;)V", "proguardFiles", "getProguardFiles", "setProguardFiles", "testProguardFiles", "getTestProguardFiles", "setTestProguardFiles", "initWith", "", "that", "seal", "gradle-core"})
/*    */ public final class PostProcessingFilesOptionsImpl
/*    */   extends InitializableSealable<PostProcessingFilesOptions>
/*    */   implements PostProcessingFilesOptions
/*    */ {
/*    */   private final SealableList<Object> _proguardFiles;
/*    */   private final SealableList<Object> _testProguardFiles;
/*    */   private final SealableList<Object> _consumerProguardFiles;
/*    */   
/*    */   public PostProcessingFilesOptionsImpl(@NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 25 */     super(issueReporter);
/*    */     
/* 28 */     _proguardFiles = SealableList.Companion.jdMethod_new(issueReporter);
/* 29 */     _testProguardFiles = SealableList.Companion.jdMethod_new(issueReporter);
/* 30 */     _consumerProguardFiles = SealableList.Companion.jdMethod_new(issueReporter); }
/*    */   
/*    */   @NotNull
/* 33 */   public List<Object> getProguardFiles() { return (List)_proguardFiles; }
/*    */   
/* 35 */   public void setProguardFiles(@NotNull List<Object> value) { Intrinsics.checkParameterIsNotNull(value, "value");_proguardFiles.reset$gradle_core((Collection)value);
/*    */   }
/*    */   
/*    */   @NotNull
/* 39 */   public List<Object> getTestProguardFiles() { return (List)_testProguardFiles; }
/*    */   
/* 41 */   public void setTestProguardFiles(@NotNull List<Object> value) { Intrinsics.checkParameterIsNotNull(value, "value");_testProguardFiles.reset$gradle_core((Collection)value);
/*    */   }
/*    */   
/*    */   @NotNull
/* 45 */   public List<Object> getConsumerProguardFiles() { return (List)_consumerProguardFiles; }
/*    */   
/* 47 */   public void setConsumerProguardFiles(@NotNull List<Object> value) { Intrinsics.checkParameterIsNotNull(value, "value");_consumerProguardFiles.reset$gradle_core((Collection)value);
/*    */   }
/*    */   
/*    */   public void initWith(@NotNull PostProcessingFilesOptions that) {
/* 51 */     Intrinsics.checkParameterIsNotNull(that, "that");_proguardFiles.reset$gradle_core((Collection)that.getProguardFiles());
/* 52 */     _testProguardFiles.reset$gradle_core((Collection)that.getTestProguardFiles());
/* 53 */     _consumerProguardFiles.reset$gradle_core((Collection)that.getConsumerProguardFiles());
/*    */   }
/*    */   
/*    */   public void seal() {
/* 57 */     super.seal();
/*    */     
/* 59 */     _proguardFiles.seal();
/* 60 */     _testProguardFiles.seal();
/* 61 */     _consumerProguardFiles.seal();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.PostProcessingFilesOptionsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */