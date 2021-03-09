/*    */ package com.android.build.gradle.internal.api.dsl.options;
/*    */ 
/*    */ import com.android.build.api.artifact.BuildArtifactTransformBuilder.ConfigurationAction;
/*    */ import com.android.build.api.artifact.BuildArtifactTransformBuilder.SimpleConfigurationAction;
/*    */ import com.android.build.api.artifact.InputArtifactProvider;
/*    */ import com.android.build.api.artifact.OutputFileProvider;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Task;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000.\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\002\030\000*\n\b\000\020\001 \000*\0020\0022\b\022\004\022\002H\0010\003B\023\022\f\020\004\032\b\022\004\022\0028\0000\005¢\006\002\020\006J%\020\t\032\0020\n2\006\020\013\032\0028\0002\006\020\f\032\0020\r2\006\020\016\032\0020\017H\026¢\006\002\020\020R\027\020\004\032\b\022\004\022\0028\0000\005¢\006\b\n\000\032\004\b\007\020\b¨\006\021"}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/BuildArtifactsOptionsImpl$ConfigurationActionWrapper;", "T", "Lorg/gradle/api/Task;", "Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$ConfigurationAction;", "action", "Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$SimpleConfigurationAction;", "(Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$SimpleConfigurationAction;)V", "getAction", "()Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$SimpleConfigurationAction;", "accept", "", "task", "input", "Lcom/android/build/api/artifact/InputArtifactProvider;", "output", "Lcom/android/build/api/artifact/OutputFileProvider;", "(Lorg/gradle/api/Task;Lcom/android/build/api/artifact/InputArtifactProvider;Lcom/android/build/api/artifact/OutputFileProvider;)V", "gradle-core"})
/*    */ final class BuildArtifactsOptionsImpl$ConfigurationActionWrapper<T extends Task>
/*    */   implements BuildArtifactTransformBuilder.ConfigurationAction<T>
/*    */ {
/*    */   @NotNull
/*    */   private final BuildArtifactTransformBuilder.SimpleConfigurationAction<T> action;
/*    */   
/* 46 */   public BuildArtifactsOptionsImpl$ConfigurationActionWrapper(@NotNull BuildArtifactTransformBuilder.SimpleConfigurationAction<? super T> action) { this.action = action; } @NotNull
/* 47 */   public final BuildArtifactTransformBuilder.SimpleConfigurationAction<T> getAction() { return action; }
/*    */   
/*    */   public void accept(@NotNull T task, @NotNull InputArtifactProvider input, @NotNull OutputFileProvider output) {
/* 50 */     Intrinsics.checkParameterIsNotNull(task, "task");Intrinsics.checkParameterIsNotNull(input, "input");Intrinsics.checkParameterIsNotNull(output, "output");action.accept(task, input.getArtifact(), output.getFile());
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.BuildArtifactsOptionsImpl.ConfigurationActionWrapper
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */