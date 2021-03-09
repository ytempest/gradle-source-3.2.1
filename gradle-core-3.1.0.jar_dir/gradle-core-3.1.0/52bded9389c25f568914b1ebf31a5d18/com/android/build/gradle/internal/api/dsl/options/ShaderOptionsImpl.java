/*    */ package com.android.build.gradle.internal.api.dsl.options;
/*    */ 
/*    */ import com.android.build.api.dsl.options.ShaderOptions;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.InitializableSealable;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.google.common.collect.ListMultimap;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.NotImplementedError;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020!\n\002\020\016\n\002\b\005\n\002\030\002\n\002\b\006\n\002\020\002\n\002\b\002\030\0002\b\022\004\022\0020\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\020\020\024\032\0020\0252\006\020\026\032\0020\002H\026R0\020\t\032\b\022\004\022\0020\b0\0072\f\020\006\032\b\022\004\022\0020\b0\0078V@VX\016¢\006\f\032\004\b\n\020\013\"\004\b\f\020\rR<\020\017\032\016\022\004\022\0020\b\022\004\022\0020\b0\0162\022\020\006\032\016\022\004\022\0020\b\022\004\022\0020\b0\0168V@VX\016¢\006\f\032\004\b\020\020\021\"\004\b\022\020\023¨\006\027"}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/ShaderOptionsImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "Lcom/android/build/api/dsl/options/ShaderOptions;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "value", "", "", "glslcArgs", "getGlslcArgs", "()Ljava/util/List;", "setGlslcArgs", "(Ljava/util/List;)V", "Lcom/google/common/collect/ListMultimap;", "scopedGlslcArgs", "getScopedGlslcArgs", "()Lcom/google/common/collect/ListMultimap;", "setScopedGlslcArgs", "(Lcom/google/common/collect/ListMultimap;)V", "initWith", "", "that", "gradle-core"})
/*    */ public final class ShaderOptionsImpl
/*    */   extends InitializableSealable<ShaderOptions>
/*    */   implements ShaderOptions
/*    */ {
/* 25 */   public ShaderOptionsImpl(@NotNull EvalIssueReporter issueReporter) { super(issueReporter); }
/*    */   
/*    */   @NotNull
/* 28 */   public List<String> getGlslcArgs() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str)); }
/* 29 */   public void setGlslcArgs(@NotNull List<String> value) { Intrinsics.checkParameterIsNotNull(value, "value"); }
/*    */   @NotNull
/* 31 */   public ListMultimap<String, String> getScopedGlslcArgs() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str)); }
/* 32 */   public void setScopedGlslcArgs(@NotNull ListMultimap<String, String> value) { Intrinsics.checkParameterIsNotNull(value, "value"); }
/*    */   
/*    */   public void initWith(@NotNull ShaderOptions that) {
/* 35 */     Intrinsics.checkParameterIsNotNull(that, "that");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.ShaderOptionsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */