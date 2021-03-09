/*    */ package com.android.build.gradle.internal.api.dsl.options;
/*    */ 
/*    */ import com.android.build.api.dsl.options.AnnotationProcessorOptions;
/*    */ import com.android.build.api.dsl.options.JavaCompileOptions;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.InitializableSealable;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.NotImplementedError;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000,\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\003\030\0002\b\022\004\022\0020\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\026\020\006\032\0020\n2\f\020\013\032\b\022\004\022\0020\0070\fH\026J\020\020\r\032\0020\n2\006\020\016\032\0020\002H\026R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\b\020\t¨\006\017"}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/JavaCompileOptionsImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "Lcom/android/build/api/dsl/options/JavaCompileOptions;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "annotationProcessorOptions", "Lcom/android/build/api/dsl/options/AnnotationProcessorOptions;", "getAnnotationProcessorOptions", "()Lcom/android/build/api/dsl/options/AnnotationProcessorOptions;", "", "action", "Lorg/gradle/api/Action;", "initWith", "that", "gradle-core"})
/*    */ public final class JavaCompileOptionsImpl
/*    */   extends InitializableSealable<JavaCompileOptions>
/*    */   implements JavaCompileOptions
/*    */ {
/* 26 */   public JavaCompileOptionsImpl(@NotNull EvalIssueReporter issueReporter) { super(issueReporter); }
/*    */   
/*    */   @NotNull
/* 29 */   public AnnotationProcessorOptions getAnnotationProcessorOptions() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 32 */   public void annotationProcessorOptions(@NotNull Action<AnnotationProcessorOptions> action) { Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   public void initWith(@NotNull JavaCompileOptions that) {
/* 36 */     Intrinsics.checkParameterIsNotNull(that, "that");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.JavaCompileOptionsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */