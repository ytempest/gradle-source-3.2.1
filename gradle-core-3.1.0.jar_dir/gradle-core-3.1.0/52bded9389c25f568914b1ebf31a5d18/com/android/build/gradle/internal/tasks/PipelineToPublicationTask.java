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
/*    */ import org.gradle.api.DefaultTask;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.gradle.api.tasks.CacheableTask;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @CacheableTask
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000*\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\002\b\027\030\0002\0020\001:\001\020B\005¢\006\002\020\002J\b\020\016\032\0020\017H\007R\032\020\003\032\0020\0048GX\004¢\006\f\022\004\b\005\020\002\032\004\b\006\020\007R\020\020\b\032\004\030\0010\tX\016¢\006\002\n\000R\021\020\n\032\0020\0138G¢\006\006\032\004\b\f\020\r¨\006\021"}, d2={"Lcom/android/build/gradle/internal/tasks/PipelineToPublicationTask;", "Lorg/gradle/api/DefaultTask;", "()V", "inputCollection", "Lorg/gradle/api/file/FileCollection;", "inputCollection$annotations", "getInputCollection", "()Lorg/gradle/api/file/FileCollection;", "internalDelegate", "Lcom/android/build/gradle/internal/tasks/PipelineToPublicationDelegate;", "outputFile", "Ljava/io/File;", "getOutputFile", "()Ljava/io/File;", "transform", "", "ConfigAction", "gradle-core"})
/*    */ public class PipelineToPublicationTask
/*    */   extends DefaultTask
/*    */ {
/*    */   private PipelineToPublicationDelegate internalDelegate;
/*    */   
/*    */   /* Error */
/*    */   @org.gradle.api.tasks.InputFiles
/*    */   @org.gradle.api.tasks.PathSensitive(org.gradle.api.tasks.PathSensitivity.RELATIVE)
/*    */   @NotNull
/*    */   public final FileCollection getInputCollection()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield 19	com/android/build/gradle/internal/tasks/PipelineToPublicationTask:internalDelegate	Lcom/android/build/gradle/internal/tasks/PipelineToPublicationDelegate;
/*    */     //   4: dup
/*    */     //   5: ifnull +13 -> 18
/*    */     //   8: invokevirtual 23	com/android/build/gradle/internal/tasks/PipelineToPublicationDelegate:getInputCollection	()Lorg/gradle/api/file/FileCollection;
/*    */     //   11: dup
/*    */     //   12: ifnull +6 -> 18
/*    */     //   15: goto +17 -> 32
/*    */     //   18: pop
/*    */     //   19: new 25	java/lang/IllegalStateException
/*    */     //   22: dup
/*    */     //   23: ldc 27
/*    */     //   25: invokespecial 31	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
/*    */     //   28: checkcast 33	java/lang/Throwable
/*    */     //   31: athrow
/*    */     //   32: areturn
/*    */     // Line number table:
/*    */     //   Java source line #68	-> byte code offset #0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	33	0	this	PipelineToPublicationTask
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   @org.gradle.api.tasks.OutputDirectory
/*    */   @NotNull
/*    */   public final File getOutputFile()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield 19	com/android/build/gradle/internal/tasks/PipelineToPublicationTask:internalDelegate	Lcom/android/build/gradle/internal/tasks/PipelineToPublicationDelegate;
/*    */     //   4: dup
/*    */     //   5: ifnull +13 -> 18
/*    */     //   8: invokevirtual 44	com/android/build/gradle/internal/tasks/PipelineToPublicationDelegate:getOutputFile	()Ljava/io/File;
/*    */     //   11: dup
/*    */     //   12: ifnull +6 -> 18
/*    */     //   15: goto +17 -> 32
/*    */     //   18: pop
/*    */     //   19: new 25	java/lang/IllegalStateException
/*    */     //   22: dup
/*    */     //   23: ldc 27
/*    */     //   25: invokespecial 31	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
/*    */     //   28: checkcast 33	java/lang/Throwable
/*    */     //   31: athrow
/*    */     //   32: areturn
/*    */     // Line number table:
/*    */     //   Java source line #72	-> byte code offset #0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	33	0	this	PipelineToPublicationTask
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   @org.gradle.api.tasks.TaskAction
/*    */   public final void transform()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokevirtual 49	com/android/build/gradle/internal/tasks/PipelineToPublicationTask:getInputCollection	()Lorg/gradle/api/file/FileCollection;
/*    */     //   4: invokeinterface 53 1 0
/*    */     //   9: ifeq +4 -> 13
/*    */     //   12: return
/*    */     //   13: aload_0
/*    */     //   14: invokevirtual 57	com/android/build/gradle/internal/tasks/PipelineToPublicationTask:getServices	()Lorg/gradle/internal/service/ServiceRegistry;
/*    */     //   17: ldc 59
/*    */     //   19: invokeinterface 65 2 0
/*    */     //   24: checkcast 59	org/gradle/workers/WorkerExecutor
/*    */     //   27: astore_1
/*    */     //   28: aload_0
/*    */     //   29: getfield 19	com/android/build/gradle/internal/tasks/PipelineToPublicationTask:internalDelegate	Lcom/android/build/gradle/internal/tasks/PipelineToPublicationDelegate;
/*    */     //   32: dup
/*    */     //   33: ifnull +16 -> 49
/*    */     //   36: aload_1
/*    */     //   37: dup
/*    */     //   38: ldc 67
/*    */     //   40: invokestatic 73	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   43: invokevirtual 77	com/android/build/gradle/internal/tasks/PipelineToPublicationDelegate:run	(Lorg/gradle/workers/WorkerExecutor;)V
/*    */     //   46: goto +4 -> 50
/*    */     //   49: pop
/*    */     //   50: return
/*    */     // Line number table:
/*    */     //   Java source line #76	-> byte code offset #0
/*    */     //   Java source line #77	-> byte code offset #12
/*    */     //   Java source line #80	-> byte code offset #13
/*    */     //   Java source line #81	-> byte code offset #28
/*    */     //   Java source line #82	-> byte code offset #50
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	51	0	this	PipelineToPublicationTask
/*    */     //   28	23	1	executor	org.gradle.workers.WorkerExecutor
/*    */   }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000<\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B%\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b\022\006\020\t\032\0020\n¢\006\002\020\013J\020\020\f\032\0020\r2\006\020\016\032\0020\002H\026J\b\020\017\032\0020\020H\026J\016\020\021\032\b\022\004\022\0020\0020\022H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\023"}, d2={"Lcom/android/build/gradle/internal/tasks/PipelineToPublicationTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/tasks/PipelineToPublicationTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "inputCollection", "Lorg/gradle/api/file/FileCollection;", "outputFile", "Ljava/io/File;", "outputType", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;", "(Lcom/android/build/gradle/internal/scope/VariantScope;Lorg/gradle/api/file/FileCollection;Ljava/io/File;Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;)V", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*    */   public static final class ConfigAction
/*    */     implements TaskConfigAction<PipelineToPublicationTask>
/*    */   {
/*    */     private final VariantScope variantScope;
/*    */     private final FileCollection inputCollection;
/*    */     private final File outputFile;
/*    */     private final TaskOutputHolder.TaskOutputType outputType;
/*    */     
/*    */     public ConfigAction(@NotNull VariantScope variantScope, @NotNull FileCollection inputCollection, @NotNull File outputFile, @NotNull TaskOutputHolder.TaskOutputType outputType)
/*    */     {
/* 84 */       this.variantScope = variantScope;this.inputCollection = inputCollection;this.outputFile = outputFile;this.outputType = outputType;
/*    */     }
/*    */     
/*    */     @NotNull
/* 91 */     public String getName() { return variantScope.getTaskName("prepare" + outputType, "ForPublishing"); }
/*    */     @NotNull
/* 93 */     public Class<PipelineToPublicationTask> getType() { return PipelineToPublicationTask.class; }
/*    */     
/*    */     public void execute(@NotNull PipelineToPublicationTask task) {
/* 96 */       Intrinsics.checkParameterIsNotNull(task, "task"); GlobalScope 
/* 97 */         tmp28_23 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp28_23, "variantScope.globalScope"); ProjectOptions tmp37_34 = tmp28_23.getProjectOptions();Intrinsics.checkExpressionValueIsNotNull(tmp37_34, "variantScope.globalScope.projectOptions");PipelineToPublicationTask.access$setInternalDelegate$p(task, new PipelineToPublicationDelegate(inputCollection, outputFile, tmp37_34));
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.PipelineToPublicationTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */