/*    */ package com.android.build.gradle.internal.api.dsl.options;
/*    */ 
/*    */ import com.android.build.api.artifact.InputArtifactProvider;
/*    */ import com.android.build.api.artifact.OutputFileProvider;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.functions.Function3;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\030\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\001\"\004\b\000\020\002*\002H\0022\006\020\003\032\0020\0042\006\020\005\032\0020\006H\n¢\006\004\b\007\020\b"}, d2={"<anonymous>", "", "T", "input", "Lcom/android/build/api/artifact/InputArtifactProvider;", "output", "Lcom/android/build/api/artifact/OutputFileProvider;", "invoke", "(Ljava/lang/Object;Lcom/android/build/api/artifact/InputArtifactProvider;Lcom/android/build/api/artifact/OutputFileProvider;)V"})
/*    */ public final class BuildArtifactsOptionsImpl$convertFunction$1
/*    */   extends Lambda
/*    */   implements Function3<T, InputArtifactProvider, OutputFileProvider, Unit>
/*    */ {
/*    */   public final void invoke(T $receiver, @NotNull InputArtifactProvider input, @NotNull OutputFileProvider output)
/*    */   {
/* 61 */     Intrinsics.checkParameterIsNotNull(input, "input");Intrinsics.checkParameterIsNotNull(output, "output");$function.invoke($receiver, input.getArtifact(), output.getFile());
/*    */   }
/*    */   
/*    */   public BuildArtifactsOptionsImpl$convertFunction$1(Function3 paramFunction3)
/*    */   {
/*    */     super(3);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.BuildArtifactsOptionsImpl.convertFunction.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */