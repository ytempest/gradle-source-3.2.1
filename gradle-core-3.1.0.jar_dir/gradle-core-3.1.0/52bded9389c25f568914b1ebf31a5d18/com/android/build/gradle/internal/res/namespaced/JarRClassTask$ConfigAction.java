/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b¢\006\002\020\tJ\020\020\n\032\0020\0132\006\020\f\032\0020\002H\026J\b\020\r\032\0020\004H\026J\016\020\016\032\b\022\004\022\0020\0020\017H\026R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000¨\006\020"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/JarRClassTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/namespaced/JarRClassTask;", "name", "", "rClassClasses", "Lorg/gradle/api/file/FileCollection;", "rClassJar", "Ljava/io/File;", "(Ljava/lang/String;Lorg/gradle/api/file/FileCollection;Ljava/io/File;)V", "execute", "", "task", "getName", "getType", "Ljava/lang/Class;", "gradle-core"})
/*    */ public final class JarRClassTask$ConfigAction
/*    */   implements TaskConfigAction<JarRClassTask>
/*    */ {
/*    */   private final String name;
/*    */   private final FileCollection rClassClasses;
/*    */   private final File rClassJar;
/*    */   
/*    */   public JarRClassTask$ConfigAction(@NotNull String name, @NotNull FileCollection rClassClasses, @NotNull File rClassJar)
/*    */   {
/* 51 */     this.name = name;this.rClassClasses = rClassClasses;this.rClassJar = rClassJar;
/*    */   }
/*    */   
/*    */   @NotNull
/* 55 */   public String getName() { return name; } @NotNull
/* 56 */   public Class<JarRClassTask> getType() { return JarRClassTask.class; }
/*    */   
/* 58 */   public void execute(@NotNull JarRClassTask task) { Intrinsics.checkParameterIsNotNull(task, "task");JarRClassTask.access$setRClassClasses$p(task, rClassClasses);
/* 59 */     JarRClassTask.access$setRClassJar$p(task, rClassJar);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.JarRClassTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */