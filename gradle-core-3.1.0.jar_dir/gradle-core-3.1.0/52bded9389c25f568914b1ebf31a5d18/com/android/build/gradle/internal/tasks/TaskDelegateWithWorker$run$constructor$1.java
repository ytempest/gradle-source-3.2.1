/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.function.Function;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\022\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\020\000\032\n\022\006\b\001\022\0020\0020\0012\016\020\003\032\n\022\006\b\001\022\0020\0020\004H\n¢\006\002\b\005"}, d2={"<anonymous>", "Ljava/lang/reflect/Constructor;", "Ljava/lang/Runnable;", "theClass", "Ljava/lang/Class;", "apply"})
/*    */ final class TaskDelegateWithWorker$run$constructor$1<T, R>
/*    */   implements Function<Class<? extends Runnable>, Constructor<? extends Runnable>>
/*    */ {
/*    */   @NotNull
/*    */   public final Constructor<? extends Runnable> apply(@NotNull Class<? extends Runnable> theClass)
/*    */   {
/* 57 */     Intrinsics.checkParameterIsNotNull(theClass, "theClass");return TaskDelegateWithWorker.access$findConstructor(this$0, theClass, $workerParam.getClass());
/*    */   }
/*    */   
/*    */   TaskDelegateWithWorker$run$constructor$1(TaskDelegateWithWorker paramTaskDelegateWithWorker, Serializable paramSerializable) {}
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.TaskDelegateWithWorker.run.constructor.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */