/*    */ package com.android.build.gradle.internal;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.api.DefaultTask;
/*    */ import org.gradle.api.Task;
/*    */ import org.gradle.api.tasks.TaskContainer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000H\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J \020\005\032\0020\0062\006\020\007\032\0020\b2\016\020\t\032\n\022\006\b\000\022\0020\0130\nH\026J\020\020\f\032\0020\r2\006\020\007\032\0020\bH\026J%\020\016\032\002H\017\"\b\b\000\020\017*\0020\0132\f\020\t\032\b\022\004\022\002H\0170\020H\026¢\006\002\020\021J\020\020\016\032\0020\0132\006\020\007\032\0020\bH\026J-\020\016\032\002H\022\"\b\b\000\020\022*\0020\0132\006\020\007\032\0020\b2\f\020\023\032\b\022\004\022\002H\0220\024H\026¢\006\002\020\025J;\020\016\032\002H\017\"\b\b\000\020\017*\0020\0132\006\020\026\032\0020\b2\f\020\027\032\b\022\004\022\002H\0170\0242\f\020\t\032\b\022\004\022\002H\0170\nH\026¢\006\002\020\030J\036\020\016\032\0020\0312\006\020\026\032\0020\b2\f\020\t\032\b\022\004\022\0020\0310\nH\026J\022\020\032\032\004\030\0010\0132\006\020\007\032\0020\bH\026R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\033"}, d2={"Lcom/android/build/gradle/internal/TaskFactoryImpl;", "Lcom/android/build/gradle/internal/TaskFactory;", "taskContainer", "Lorg/gradle/api/tasks/TaskContainer;", "(Lorg/gradle/api/tasks/TaskContainer;)V", "configure", "", "name", "", "configAction", "Lorg/gradle/api/Action;", "Lorg/gradle/api/Task;", "containsKey", "", "create", "T", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "(Lcom/android/build/gradle/internal/scope/TaskConfigAction;)Lorg/gradle/api/Task;", "S", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Lorg/gradle/api/Task;", "taskName", "taskClass", "(Ljava/lang/String;Ljava/lang/Class;Lorg/gradle/api/Action;)Lorg/gradle/api/Task;", "Lorg/gradle/api/DefaultTask;", "findByName", "gradle-core"})
/*    */ public final class TaskFactoryImpl
/*    */   implements TaskFactory
/*    */ {
/*    */   private final TaskContainer taskContainer;
/*    */   
/* 25 */   public TaskFactoryImpl(@NotNull TaskContainer taskContainer) { this.taskContainer = taskContainer; }
/*    */   
/*    */   public boolean containsKey(@NotNull String name) {
/* 28 */     Intrinsics.checkParameterIsNotNull(name, "name");return taskContainer.findByName(name) != null;
/*    */   }
/*    */   
/*    */   @NotNull
/* 32 */   public Task create(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name"); Task tmp16_11 = taskContainer.create(name);Intrinsics.checkExpressionValueIsNotNull(tmp16_11, "taskContainer.create(name)");return tmp16_11;
/*    */   }
/*    */   
/*    */   @NotNull
/* 36 */   public <S extends Task> S create(@NotNull String name, @NotNull Class<S> type) { Intrinsics.checkParameterIsNotNull(name, "name");Intrinsics.checkParameterIsNotNull(type, "type"); Task tmp23_18 = taskContainer.create(name, type);Intrinsics.checkExpressionValueIsNotNull(tmp23_18, "taskContainer.create(name, type)");return tmp23_18;
/*    */   }
/*    */   
/*    */   public void configure(@NotNull String name, @NotNull Action<? super Task> configAction) {
/* 40 */     Intrinsics.checkParameterIsNotNull(name, "name");Intrinsics.checkParameterIsNotNull(configAction, "configAction");Task task = taskContainer.getByName(name);
/* 41 */     configAction.execute(task);
/*    */   }
/*    */   
/*    */   @Nullable
/* 45 */   public Task findByName(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name");return (Task)taskContainer.findByName(name);
/*    */   }
/*    */   
/*    */   @NotNull
/* 49 */   public <T extends Task> T create(@NotNull TaskConfigAction<T> configAction) { Intrinsics.checkParameterIsNotNull(configAction, "configAction"); Task 
/* 50 */       tmp31_26 = taskContainer.create(configAction.getName(), configAction.getType(), (Action)configAction);Intrinsics.checkExpressionValueIsNotNull(tmp31_26, "taskContainer\n          …ction.type, configAction)");return tmp31_26;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public <T extends Task> T create(@NotNull String taskName, @NotNull Class<T> taskClass, @NotNull Action<T> configAction) {
/* 55 */     Intrinsics.checkParameterIsNotNull(taskName, "taskName");Intrinsics.checkParameterIsNotNull(taskClass, "taskClass");Intrinsics.checkParameterIsNotNull(configAction, "configAction"); Task tmp30_25 = taskContainer.create(taskName, taskClass, configAction);Intrinsics.checkExpressionValueIsNotNull(tmp30_25, "taskContainer.create(tas… taskClass, configAction)");return tmp30_25;
/*    */   }
/*    */   
/*    */   @NotNull
/* 59 */   public DefaultTask create(@NotNull String taskName, @NotNull Action<DefaultTask> configAction) { Intrinsics.checkParameterIsNotNull(taskName, "taskName");Intrinsics.checkParameterIsNotNull(configAction, "configAction");return (DefaultTask)create(taskName, DefaultTask.class, configAction);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.TaskFactoryImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */