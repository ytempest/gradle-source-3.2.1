/*    */ package com.android.build.gradle.internal.scope;
/*    */ 
/*    */ import java.nio.file.Path;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\n\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\006\020\002\032\0020\001H\n¢\006\002\b\003"}, d2={"<anonymous>", "Lcom/android/build/gradle/internal/scope/BuildOutput;", "buildOutput", "invoke"})
/*    */ final class BuildElements$persist$1
/*    */   extends Lambda
/*    */   implements Function1<BuildOutput, BuildOutput>
/*    */ {
/*    */   @NotNull
/*    */   public final BuildOutput invoke(@NotNull BuildOutput buildOutput)
/*    */   {
/* 93 */     Intrinsics.checkParameterIsNotNull(buildOutput, "buildOutput");
/*    */     
/* 97 */     return new BuildOutput(buildOutput.getType(), buildOutput.getApkInfo(), $projectPath.relativize(buildOutput.getOutputPath()), buildOutput.getProperties());
/*    */   }
/*    */   
/*    */   BuildElements$persist$1(Path paramPath)
/*    */   {
/*    */     super(1);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildElements.persist.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */