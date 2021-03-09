/*    */ package com.android.build.gradle.internal.api.dsl.options;
/*    */ 
/*    */ import com.android.build.api.dsl.options.ExternalNativeBuildOptions;
/*    */ import com.android.build.api.dsl.options.ExternalNativeCmakeOptions;
/*    */ import com.android.build.api.dsl.options.ExternalNativeNdkBuildOptions;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.InitializableSealable;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.NotImplementedError;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0004\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\003\030\0002\b\022\004\022\0020\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\026\020\006\032\0020\0162\f\020\017\032\b\022\004\022\0020\0070\020H\026J\026\020\n\032\0020\0162\f\020\017\032\b\022\004\022\0020\0130\020H\026J\020\020\021\032\0020\0162\006\020\022\032\0020\002H\026R\026\020\006\032\004\030\0010\0078VX\004¢\006\006\032\004\b\b\020\tR\026\020\n\032\004\030\0010\0138VX\004¢\006\006\032\004\b\f\020\r¨\006\023"}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/ExternalNativeBuildOptionsImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "externalNativeCmakeOptions", "Lcom/android/build/api/dsl/options/ExternalNativeCmakeOptions;", "getExternalNativeCmakeOptions", "()Lcom/android/build/api/dsl/options/ExternalNativeCmakeOptions;", "externalNativeNdkBuildOptions", "Lcom/android/build/api/dsl/options/ExternalNativeNdkBuildOptions;", "getExternalNativeNdkBuildOptions", "()Lcom/android/build/api/dsl/options/ExternalNativeNdkBuildOptions;", "", "action", "Lorg/gradle/api/Action;", "initWith", "that", "gradle-core"})
/*    */ public final class ExternalNativeBuildOptionsImpl
/*    */   extends InitializableSealable<ExternalNativeBuildOptions>
/*    */   implements ExternalNativeBuildOptions
/*    */ {
/* 27 */   public ExternalNativeBuildOptionsImpl(@NotNull EvalIssueReporter issueReporter) { super(issueReporter); }
/*    */   
/*    */   @Nullable
/*    */   public ExternalNativeNdkBuildOptions getExternalNativeNdkBuildOptions() {
/* 31 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 34 */   public void externalNativeNdkBuildOptions(@NotNull Action<ExternalNativeNdkBuildOptions> action) { Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   @Nullable
/* 38 */   public ExternalNativeCmakeOptions getExternalNativeCmakeOptions() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 41 */   public void externalNativeCmakeOptions(@NotNull Action<ExternalNativeCmakeOptions> action) { Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   public void initWith(@NotNull ExternalNativeBuildOptions that) {
/* 45 */     Intrinsics.checkParameterIsNotNull(that, "that");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.ExternalNativeBuildOptionsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */