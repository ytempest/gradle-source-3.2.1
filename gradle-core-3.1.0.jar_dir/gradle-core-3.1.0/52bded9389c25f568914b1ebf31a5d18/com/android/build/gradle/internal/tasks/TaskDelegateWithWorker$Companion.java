/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.Map;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\020%\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\005\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R6\020\003\032\036\022\f\022\n\022\006\b\001\022\0020\0060\005\022\f\022\n\022\006\b\001\022\0020\0060\0070\004X.¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013¨\006\f"}, d2={"Lcom/android/build/gradle/internal/tasks/TaskDelegateWithWorker$Companion;", "", "()V", "constructorCache", "", "Ljava/lang/Class;", "Ljava/lang/Runnable;", "Ljava/lang/reflect/Constructor;", "getConstructorCache", "()Ljava/util/Map;", "setConstructorCache", "(Ljava/util/Map;)V", "gradle-core"})
/*    */ public final class TaskDelegateWithWorker$Companion
/*    */ {
/*    */   public final void setConstructorCache(@NotNull Map<Class<? extends Runnable>, Constructor<? extends Runnable>> <set-?>)
/*    */   {
/* 82 */     Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");TaskDelegateWithWorker.constructorCache = <set-?>; } @NotNull
/* 82 */   public final Map<Class<? extends Runnable>, Constructor<? extends Runnable>> getConstructorCache() { Map tmp3_0 = TaskDelegateWithWorker.constructorCache;
/*    */     
/* 82 */     if (tmp3_0 == null) Intrinsics.throwUninitializedPropertyAccessException("constructorCache"); return tmp3_0;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.TaskDelegateWithWorker.Companion
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */