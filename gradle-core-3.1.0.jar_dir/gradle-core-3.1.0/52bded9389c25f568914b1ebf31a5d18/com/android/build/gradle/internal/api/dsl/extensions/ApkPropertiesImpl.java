/*    */ package com.android.build.gradle.internal.api.dsl.extensions;
/*    */ 
/*    */ import com.android.build.api.dsl.extension.ApkProperties;
/*    */ import com.android.build.api.dsl.options.PackagingOptions;
/*    */ import com.android.build.api.dsl.options.Splits;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.NotImplementedError;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000:\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\026\020\r\032\0020\0252\f\020\026\032\b\022\004\022\0020\0160\027H\026J\026\020\021\032\0020\0252\f\020\026\032\b\022\004\022\0020\0220\027H\026R$\020\b\032\0020\0072\006\020\006\032\0020\0078V@VX\016¢\006\f\032\004\b\t\020\n\"\004\b\013\020\fR\024\020\r\032\0020\0168VX\004¢\006\006\032\004\b\017\020\020R\024\020\021\032\0020\0228VX\004¢\006\006\032\004\b\023\020\024¨\006\030"}, d2={"Lcom/android/build/gradle/internal/api/dsl/extensions/ApkPropertiesImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/extension/ApkProperties;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "value", "", "generatePureSplits", "getGeneratePureSplits", "()Z", "setGeneratePureSplits", "(Z)V", "packagingOptions", "Lcom/android/build/api/dsl/options/PackagingOptions;", "getPackagingOptions", "()Lcom/android/build/api/dsl/options/PackagingOptions;", "splits", "Lcom/android/build/api/dsl/options/Splits;", "getSplits", "()Lcom/android/build/api/dsl/options/Splits;", "", "action", "Lorg/gradle/api/Action;", "gradle-core"})
/*    */ public final class ApkPropertiesImpl
/*    */   extends SealableObject
/*    */   implements ApkProperties
/*    */ {
/* 26 */   public ApkPropertiesImpl(@NotNull EvalIssueReporter issueReporter) { super(issueReporter); }
/*    */   @NotNull
/* 28 */   public PackagingOptions getPackagingOptions() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 31 */   public void packagingOptions(@NotNull Action<PackagingOptions> action) { Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   @NotNull
/* 35 */   public Splits getSplits() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 38 */   public void splits(@NotNull Action<Splits> action) { Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   public boolean getGeneratePureSplits() {
/* 42 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   public void setGeneratePureSplits(boolean value) {}
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.extensions.ApkPropertiesImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */