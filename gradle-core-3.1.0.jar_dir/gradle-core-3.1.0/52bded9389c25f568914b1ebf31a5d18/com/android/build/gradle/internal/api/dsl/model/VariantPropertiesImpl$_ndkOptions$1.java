/*    */ package com.android.build.gradle.internal.api.dsl.model;
/*    */ 
/*    */ import com.android.build.gradle.internal.api.dsl.options.NdkOptionsImpl;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2={"<anonymous>", "Lcom/android/build/gradle/internal/api/dsl/options/NdkOptionsImpl;", "invoke"})
/*    */ final class VariantPropertiesImpl$_ndkOptions$1
/*    */   extends Lambda
/*    */   implements Function0<NdkOptionsImpl>
/*    */ {
/*    */   @NotNull
/*    */   public final NdkOptionsImpl invoke()
/*    */   {
/* 49 */     return new NdkOptionsImpl($issueReporter);
/*    */   }
/*    */   
/*    */   VariantPropertiesImpl$_ndkOptions$1(EvalIssueReporter paramEvalIssueReporter)
/*    */   {
/*    */     super(0);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.VariantPropertiesImpl._ndkOptions.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */