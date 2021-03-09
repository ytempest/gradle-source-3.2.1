/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.build.gradle.options.ProjectOptions;
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000<\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B%\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b\022\006\020\t\032\0020\n¢\006\002\020\013J\020\020\f\032\0020\r2\006\020\016\032\0020\002H\026J\b\020\017\032\0020\020H\026J\016\020\021\032\b\022\004\022\0020\0020\022H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\023"}, d2={"Lcom/android/build/gradle/internal/tasks/PipelineToPublicationTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/tasks/PipelineToPublicationTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "inputCollection", "Lorg/gradle/api/file/FileCollection;", "outputFile", "Ljava/io/File;", "outputType", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;", "(Lcom/android/build/gradle/internal/scope/VariantScope;Lorg/gradle/api/file/FileCollection;Ljava/io/File;Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;)V", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*    */ public final class PipelineToPublicationTask$ConfigAction
/*    */   implements TaskConfigAction<PipelineToPublicationTask>
/*    */ {
/*    */   private final VariantScope variantScope;
/*    */   private final FileCollection inputCollection;
/*    */   private final File outputFile;
/*    */   private final TaskOutputHolder.TaskOutputType outputType;
/*    */   
/*    */   public PipelineToPublicationTask$ConfigAction(@NotNull VariantScope variantScope, @NotNull FileCollection inputCollection, @NotNull File outputFile, @NotNull TaskOutputHolder.TaskOutputType outputType)
/*    */   {
/* 84 */     this.variantScope = variantScope;this.inputCollection = inputCollection;this.outputFile = outputFile;this.outputType = outputType;
/*    */   }
/*    */   
/*    */   @NotNull
/* 91 */   public String getName() { return variantScope.getTaskName("prepare" + outputType, "ForPublishing"); }
/*    */   @NotNull
/* 93 */   public Class<PipelineToPublicationTask> getType() { return PipelineToPublicationTask.class; }
/*    */   
/*    */   public void execute(@NotNull PipelineToPublicationTask task) {
/* 96 */     Intrinsics.checkParameterIsNotNull(task, "task"); GlobalScope 
/* 97 */       tmp28_23 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp28_23, "variantScope.globalScope"); ProjectOptions tmp37_34 = tmp28_23.getProjectOptions();Intrinsics.checkExpressionValueIsNotNull(tmp37_34, "variantScope.globalScope.projectOptions");PipelineToPublicationTask.access$setInternalDelegate$p(task, new PipelineToPublicationDelegate(inputCollection, outputFile, tmp37_34));
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.PipelineToPublicationTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */