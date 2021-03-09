/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.actions.AttrExtractor;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import com.android.sdklib.IAndroidTarget;
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.api.DefaultTask;
/*    */ import org.gradle.api.tasks.CacheableTask;
/*    */ import org.gradle.api.tasks.InputFiles;
/*    */ import org.gradle.api.tasks.OutputFile;
/*    */ import org.gradle.api.tasks.PathSensitive;
/*    */ import org.gradle.api.tasks.PathSensitivity;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ import org.gradle.internal.service.ServiceRegistry;
/*    */ import org.gradle.workers.IsolationMode;
/*    */ import org.gradle.workers.WorkerConfiguration;
/*    */ import org.gradle.workers.WorkerExecutor;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @CacheableTask
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\004\b\027\030\0002\0020\001:\001\nB\005¢\006\002\020\002J\b\020\006\032\0020\007H\007J\b\020\b\032\0020\004H\007J\b\020\t\032\0020\004H\007R\016\020\003\032\0020\004X.¢\006\002\n\000R\016\020\005\032\0020\004X.¢\006\002\n\000¨\006\013"}, d2={"Lcom/android/build/gradle/internal/tasks/PlatformAttrExtractorTask;", "Lorg/gradle/api/DefaultTask;", "()V", "inputFile", "Ljava/io/File;", "outputFile", "action", "", "getInput", "getOutput", "ConfigAction", "gradle-core"})
/*    */ public class PlatformAttrExtractorTask
/*    */   extends DefaultTask
/*    */ {
/*    */   private File inputFile;
/*    */   private File outputFile;
/*    */   
/*    */   @InputFiles
/*    */   @PathSensitive(PathSensitivity.NAME_ONLY)
/*    */   @NotNull
/*    */   public final File getInput()
/*    */   {
/* 45 */     File tmp4_1 = inputFile;
/*    */     
/* 45 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("inputFile"); return tmp4_1; }
/*    */   @OutputFile
/*    */   @NotNull
/* 48 */   public final File getOutput() { File tmp4_1 = outputFile;
/*    */     
/* 48 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("outputFile"); return tmp4_1;
/*    */   }
/*    */   
/*    */   @TaskAction
/* 52 */   public final void action() { WorkerExecutor executor = (WorkerExecutor)getServices().get(WorkerExecutor.class);
/*    */     
/* 54 */     executor.submit(AttrExtractor.class, (Action)new Action() {
/* 55 */       public final void execute(WorkerConfiguration it) { it.params(new Object[] { PlatformAttrExtractorTask.access$getInputFile$p(this$0), PlatformAttrExtractorTask.access$getOutputFile$p(this$0) }); WorkerConfiguration 
/* 56 */           tmp31_30 = it;Intrinsics.checkExpressionValueIsNotNull(tmp31_30, "it");tmp31_30.setIsolationMode(IsolationMode.NONE); } }); }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\f\032\0020\r2\006\020\016\032\0020\002H\026J\b\020\017\032\0020\020H\026J\016\020\021\032\b\022\004\022\0020\0020\022H\026R\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\b\020\tR\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\n\020\013¨\006\023"}, d2={"Lcom/android/build/gradle/internal/tasks/PlatformAttrExtractorTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/tasks/PlatformAttrExtractorTask;", "scope", "Lcom/android/build/gradle/internal/scope/GlobalScope;", "output", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/GlobalScope;Ljava/io/File;)V", "getOutput", "()Ljava/io/File;", "getScope", "()Lcom/android/build/gradle/internal/scope/GlobalScope;", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*    */   public static final class ConfigAction implements TaskConfigAction<PlatformAttrExtractorTask> { @NotNull
/* 60 */     public final GlobalScope getScope() { return scope; } @NotNull
/* 60 */     public final File getOutput() { return output; } public ConfigAction(@NotNull GlobalScope scope, @NotNull File output) { this.scope = scope;this.output = output; }
/*    */     
/*    */     @NotNull
/* 63 */     public String getName() { return "platformAttrExtractor"; }
/*    */     @NotNull
/* 65 */     public Class<PlatformAttrExtractorTask> getType() { return PlatformAttrExtractorTask.class; }
/*    */     
/*    */     public void execute(@NotNull PlatformAttrExtractorTask task) {
/* 68 */       Intrinsics.checkParameterIsNotNull(task, "task"); AndroidBuilder 
/* 69 */         tmp18_15 = scope.getAndroidBuilder();Intrinsics.checkExpressionValueIsNotNull(tmp18_15, "scope.androidBuilder");PlatformAttrExtractorTask.access$setInputFile$p(task, new File(tmp18_15.getTarget()
/*    */       
/* 71 */         .getPath(1)));
/*    */       
/* 73 */       PlatformAttrExtractorTask.access$setOutputFile$p(task, output);
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     private final GlobalScope scope;
/*    */     @NotNull
/*    */     private final File output;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.PlatformAttrExtractorTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */