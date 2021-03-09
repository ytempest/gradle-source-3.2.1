/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import java.io.File;
/*    */ import javax.inject.Inject;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.api.DefaultTask;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.gradle.api.tasks.InputFiles;
/*    */ import org.gradle.api.tasks.OutputFile;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ import org.gradle.workers.IsolationMode;
/*    */ import org.gradle.workers.WorkerConfiguration;
/*    */ import org.gradle.workers.WorkerExecutor;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000*\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\006\n\002\020\002\n\002\b\002\b\026\030\0002\0020\001:\001\024B\017\b\007\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\022\032\0020\023H\007R&\020\007\032\0020\0062\006\020\005\032\0020\0068\007@BX.¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R&\020\r\032\0020\f2\006\020\005\032\0020\f8\007@BX.¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\025"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/JarRClassTask;", "Lorg/gradle/api/DefaultTask;", "workerExecutor", "Lorg/gradle/workers/WorkerExecutor;", "(Lorg/gradle/workers/WorkerExecutor;)V", "<set-?>", "Lorg/gradle/api/file/FileCollection;", "rClassClasses", "getRClassClasses", "()Lorg/gradle/api/file/FileCollection;", "setRClassClasses", "(Lorg/gradle/api/file/FileCollection;)V", "Ljava/io/File;", "rClassJar", "getRClassJar", "()Ljava/io/File;", "setRClassJar", "(Ljava/io/File;)V", "jar", "", "ConfigAction", "gradle-core"})
/*    */ public class JarRClassTask
/*    */   extends DefaultTask
/*    */ {
/*    */   @NotNull
/*    */   private FileCollection rClassClasses;
/*    */   @NotNull
/*    */   private File rClassJar;
/*    */   private final WorkerExecutor workerExecutor;
/*    */   
/*    */   @Inject
/* 35 */   public JarRClassTask(@NotNull WorkerExecutor workerExecutor) { this.workerExecutor = workerExecutor; } @InputFiles
/*    */   @NotNull
/* 37 */   public final FileCollection getRClassClasses() { FileCollection tmp4_1 = rClassClasses;
/*    */     
/* 37 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("rClassClasses"); return tmp4_1; } private final void setRClassClasses(FileCollection <set-?>) { rClassClasses = <set-?>; } @OutputFile
/*    */   @NotNull
/* 38 */   public final File getRClassJar() { File tmp4_1 = rClassJar;
/*    */     
/* 38 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("rClassJar"); return tmp4_1; } private final void setRClassJar(File <set-?>) { rClassJar = <set-?>; }
/*    */   
/*    */   @TaskAction
/* 42 */   public final void jar() { workerExecutor.submit(JarWorkerRunnable.class, (Action)new Action() {
/* 43 */       public final void execute(WorkerConfiguration it) { WorkerConfiguration tmp1_0 = it;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "it");tmp1_0.setIsolationMode(IsolationMode.NONE);
/* 44 */         it.setParams(new Object[] {
/* 45 */           new JarRequest(
/* 46 */           this$0.getRClassJar(), 
/* 47 */           CollectionsKt.listOf(this$0.getRClassClasses().getSingleFile()), null, null, 12, null) });
/*    */       } }); }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b¢\006\002\020\tJ\020\020\n\032\0020\0132\006\020\f\032\0020\002H\026J\b\020\r\032\0020\004H\026J\016\020\016\032\b\022\004\022\0020\0020\017H\026R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000¨\006\020"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/JarRClassTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/namespaced/JarRClassTask;", "name", "", "rClassClasses", "Lorg/gradle/api/file/FileCollection;", "rClassJar", "Ljava/io/File;", "(Ljava/lang/String;Lorg/gradle/api/file/FileCollection;Ljava/io/File;)V", "execute", "", "task", "getName", "getType", "Ljava/lang/Class;", "gradle-core"})
/* 51 */   public static final class ConfigAction implements TaskConfigAction<JarRClassTask> { public ConfigAction(@NotNull String name, @NotNull FileCollection rClassClasses, @NotNull File rClassJar) { this.name = name;this.rClassClasses = rClassClasses;this.rClassJar = rClassJar; }
/*    */     
/*    */     private final String name;
/*    */     @NotNull
/* 55 */     public String getName() { return name; } @NotNull
/* 56 */     public Class<JarRClassTask> getType() { return JarRClassTask.class; }
/*    */     
/* 58 */     public void execute(@NotNull JarRClassTask task) { Intrinsics.checkParameterIsNotNull(task, "task");JarRClassTask.access$setRClassClasses$p(task, rClassClasses);
/* 59 */       JarRClassTask.access$setRClassJar$p(task, rClassJar);
/*    */     }
/*    */     
/*    */     private final FileCollection rClassClasses;
/*    */     private final File rClassJar;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.JarRClassTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */