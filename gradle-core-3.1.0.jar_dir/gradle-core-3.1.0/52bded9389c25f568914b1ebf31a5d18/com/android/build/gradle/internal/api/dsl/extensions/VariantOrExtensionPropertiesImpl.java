/*    */ package com.android.build.gradle.internal.api.dsl.extensions;
/*    */ 
/*    */ import com.android.build.api.dsl.extension.VariantOrExtensionProperties;
/*    */ import com.android.build.api.dsl.options.AaptOptions;
/*    */ import com.android.build.api.dsl.options.CompileOptions;
/*    */ import com.android.build.api.dsl.options.DexOptions;
/*    */ import com.android.build.api.dsl.options.LintOptions;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.android.builder.model.DataBindingOptions;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.NotImplementedError;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000L\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\003\030\0002\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\026\020\006\032\0020\0322\f\020\033\032\b\022\004\022\0020\0070\034H\026J\026\020\n\032\0020\0322\f\020\033\032\b\022\004\022\0020\0130\034H\026J\026\020\016\032\0020\0322\f\020\033\032\b\022\004\022\0020\0170\034H\026J\026\020\022\032\0020\0322\f\020\033\032\b\022\004\022\0020\0230\034H\026J\016\020\035\032\0020\0322\006\020\036\032\0020\000J\026\020\026\032\0020\0322\f\020\033\032\b\022\004\022\0020\0270\034H\026R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\b\020\tR\024\020\n\032\0020\0138VX\004¢\006\006\032\004\b\f\020\rR\024\020\016\032\0020\0178VX\004¢\006\006\032\004\b\020\020\021R\024\020\022\032\0020\0238VX\004¢\006\006\032\004\b\024\020\025R\024\020\026\032\0020\0278VX\004¢\006\006\032\004\b\030\020\031¨\006\037"}, d2={"Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/extension/VariantOrExtensionProperties;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "aaptOptions", "Lcom/android/build/api/dsl/options/AaptOptions;", "getAaptOptions", "()Lcom/android/build/api/dsl/options/AaptOptions;", "compileOptions", "Lcom/android/build/api/dsl/options/CompileOptions;", "getCompileOptions", "()Lcom/android/build/api/dsl/options/CompileOptions;", "dataBinding", "Lcom/android/builder/model/DataBindingOptions;", "getDataBinding", "()Lcom/android/builder/model/DataBindingOptions;", "dexOptions", "Lcom/android/build/api/dsl/options/DexOptions;", "getDexOptions", "()Lcom/android/build/api/dsl/options/DexOptions;", "lintOptions", "Lcom/android/build/api/dsl/options/LintOptions;", "getLintOptions", "()Lcom/android/build/api/dsl/options/LintOptions;", "", "action", "Lorg/gradle/api/Action;", "initWith", "that", "gradle-core"})
/*    */ public final class VariantOrExtensionPropertiesImpl
/*    */   extends SealableObject
/*    */   implements VariantOrExtensionProperties
/*    */ {
/* 30 */   public VariantOrExtensionPropertiesImpl(@NotNull EvalIssueReporter issueReporter) { super(issueReporter); }
/*    */   
/*    */   public void aaptOptions(@NotNull Action<AaptOptions> action) {
/* 33 */     Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   @NotNull
/* 37 */   public AaptOptions getAaptOptions() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 40 */   public void compileOptions(@NotNull Action<CompileOptions> action) { Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   @NotNull
/* 44 */   public CompileOptions getCompileOptions() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 47 */   public void dexOptions(@NotNull Action<DexOptions> action) { Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   @NotNull
/* 51 */   public DexOptions getDexOptions() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str)); }
/*    */   @NotNull
/* 53 */   public LintOptions getLintOptions() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 56 */   public void lintOptions(@NotNull Action<LintOptions> action) { Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   @NotNull
/* 60 */   public DataBindingOptions getDataBinding() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 63 */   public void dataBinding(@NotNull Action<DataBindingOptions> action) { Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   public final void initWith(@NotNull VariantOrExtensionPropertiesImpl that)
/*    */   {
/* 68 */     Intrinsics.checkParameterIsNotNull(that, "that");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.extensions.VariantOrExtensionPropertiesImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */