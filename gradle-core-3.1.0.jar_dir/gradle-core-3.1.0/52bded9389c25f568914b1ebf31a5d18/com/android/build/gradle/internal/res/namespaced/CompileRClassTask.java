/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.gradle.api.tasks.CacheableTask;
/*    */ import org.gradle.api.tasks.compile.JavaCompile;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @CacheableTask
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\f\n\002\030\002\n\002\030\002\n\002\b\003\b\027\030\0002\0020\001:\001\003B\005¢\006\002\020\002¨\006\004"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/CompileRClassTask;", "Lorg/gradle/api/tasks/compile/JavaCompile;", "()V", "ConfigAction", "gradle-core"})
/*    */ public class CompileRClassTask
/*    */   extends JavaCompile
/*    */ {
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b¢\006\002\020\tJ\020\020\n\032\0020\0132\006\020\f\032\0020\002H\026J\b\020\r\032\0020\004H\026J\016\020\016\032\b\022\004\022\0020\0020\017H\026R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\020"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/CompileRClassTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/namespaced/CompileRClassTask;", "name", "", "rClassSource", "Lorg/gradle/api/file/FileCollection;", "rClassDir", "Ljava/io/File;", "(Ljava/lang/String;Lorg/gradle/api/file/FileCollection;Ljava/io/File;)V", "execute", "", "task", "getName", "getType", "Ljava/lang/Class;", "gradle-core"})
/*    */   public static final class ConfigAction
/*    */     implements TaskConfigAction<CompileRClassTask>
/*    */   {
/*    */     private final String name;
/*    */     private final FileCollection rClassSource;
/*    */     private final File rClassDir;
/*    */     
/*    */     public ConfigAction(@NotNull String name, @NotNull FileCollection rClassSource, @NotNull File rClassDir)
/*    */     {
/* 35 */       this.name = name;this.rClassSource = rClassSource;this.rClassDir = rClassDir;
/*    */     }
/*    */     
/*    */     @NotNull
/* 40 */     public String getName() { return name; }
/*    */     @NotNull
/* 42 */     public Class<CompileRClassTask> getType() { return CompileRClassTask.class; }
/*    */     
/*    */     public void execute(@NotNull CompileRClassTask task) {
/* 45 */       Intrinsics.checkParameterIsNotNull(task, "task");task.setClasspath((FileCollection)task.getProject().files(new Object[0]));
/* 46 */       task.source(new Object[] { rClassSource });
/* 47 */       task.setDestinationDir(rClassDir);
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.CompileRClassTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */