/*    */ package com.android.build.gradle.internal.scope;
/*    */ 
/*    */ import com.android.ide.common.build.ApkInfo;
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.functions.Function2;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\n\n\000\n\002\030\002\n\002\b\002\020\000\032\004\030\0010\0012\006\020\002\032\0020\001H\n¢\006\002\b\003"}, d2={"<anonymous>", "Lcom/android/build/gradle/internal/scope/BuildOutput;", "input", "invoke"})
/*    */ final class BuildElementActionScheduler$Synchronous$into$1
/*    */   extends Lambda
/*    */   implements Function1<BuildOutput, BuildOutput>
/*    */ {
/*    */   @Nullable
/*    */   public final BuildOutput invoke(@NotNull BuildOutput input)
/*    */   {
/* 43 */     Intrinsics.checkParameterIsNotNull(input, "input"); ApkInfo tmp17_14 = input.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp17_14, "input.apkInfo"); File tmp27_24 = input.getOutputFile();Intrinsics.checkExpressionValueIsNotNull(tmp27_24, "input.outputFile");File output = (File)this$0.getAction().invoke(tmp17_14, tmp27_24);
/*    */     
/* 48 */     return output == null ? null : new BuildOutput((TaskOutputHolder.OutputType)$type, input.getApkInfo(), output);
/*    */   }
/*    */   
/*    */   BuildElementActionScheduler$Synchronous$into$1(BuildElementActionScheduler.Synchronous paramSynchronous, TaskOutputHolder.TaskOutputType paramTaskOutputType)
/*    */   {
/*    */     super(1);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildElementActionScheduler.Synchronous.into.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */