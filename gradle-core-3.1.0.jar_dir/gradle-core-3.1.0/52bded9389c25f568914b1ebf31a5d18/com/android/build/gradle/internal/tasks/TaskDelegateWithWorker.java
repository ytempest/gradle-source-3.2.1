/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.options.BooleanOption;
/*    */ import com.android.build.gradle.options.ProjectOptions;
/*    */ import java.io.Serializable;
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import java.util.function.Function;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.workers.IsolationMode;
/*    */ import org.gradle.workers.WorkerConfiguration;
/*    */ import org.gradle.workers.WorkerExecutor;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000>\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\b&\030\000 \0242\0020\001:\001\024B\r\022\006\020\002\032\0020\003¢\006\002\020\004J,\020\007\032\n\022\006\b\001\022\0020\t0\b2\016\020\n\032\n\022\006\b\001\022\0020\t0\0132\n\020\f\032\006\022\002\b\0030\013H\002J\020\020\r\032\n\022\006\b\001\022\0020\t0\013H&J\b\020\016\032\0020\017H&J\016\020\020\032\0020\0212\006\020\022\032\0020\023R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\025"}, d2={"Lcom/android/build/gradle/internal/tasks/TaskDelegateWithWorker;", "", "projectOptions", "Lcom/android/build/gradle/options/ProjectOptions;", "(Lcom/android/build/gradle/options/ProjectOptions;)V", "useExecutor", "", "findConstructor", "Ljava/lang/reflect/Constructor;", "Ljava/lang/Runnable;", "theClass", "Ljava/lang/Class;", "paramClass", "getWorkerClass", "getWorkerParam", "Ljava/io/Serializable;", "run", "", "executor", "Lorg/gradle/workers/WorkerExecutor;", "Companion", "gradle-core"})
/*    */ public abstract class TaskDelegateWithWorker
/*    */ {
/*    */   private final boolean useExecutor;
/*    */   @NotNull
/*    */   public static Map<Class<? extends Runnable>, Constructor<? extends Runnable>> constructorCache;
/*    */   public static final Companion Companion = new Companion(null);
/*    */   
/*    */   public TaskDelegateWithWorker(@NotNull ProjectOptions projectOptions)
/*    */   {
/* 28 */     useExecutor = projectOptions.get(BooleanOption.ENABLE_GRADLE_WORKERS);
/*    */     
/* 31 */     if (!useExecutor) {
/* 32 */       Companion localCompanion = Companion;Map localMap = (Map)new LinkedHashMap();localCompanion.setConstructorCache(localMap);
/*    */     }
/*    */   }
/*    */   
/*    */   public final void run(@NotNull WorkerExecutor executor)
/*    */   {
/* 48 */     Intrinsics.checkParameterIsNotNull(executor, "executor"); if (useExecutor) {
/* 49 */       executor.submit(getWorkerClass(), (Action)new Action() {
/* 50 */         public final void execute(WorkerConfiguration it) { it.params(new Object[] { this$0.getWorkerParam() }); WorkerConfiguration 
/* 51 */             tmp21_20 = it;Intrinsics.checkExpressionValueIsNotNull(tmp21_20, "it");tmp21_20.setIsolationMode(IsolationMode.NONE);
/*    */         }
/*    */       });
/* 54 */     } else { final Serializable workerParam = getWorkerParam();
/*    */       
/* 56 */       Constructor constructor = (Constructor)Companion.getConstructorCache().computeIfAbsent(getWorkerClass(), (Function)new Function() { @NotNull
/* 57 */         public final Constructor<? extends Runnable> apply(@NotNull Class<? extends Runnable> theClass) { Intrinsics.checkParameterIsNotNull(theClass, "theClass");return TaskDelegateWithWorker.access$findConstructor(this$0, theClass, workerParam.getClass());
/*    */         }
/* 59 */       });
/* 60 */       Runnable runnable = (Runnable)constructor.newInstance(new Object[] { workerParam });
/* 61 */       runnable.run();
/*    */     }
/*    */   }
/*    */   
/*    */   private final Constructor<? extends Runnable> findConstructor(Class<? extends Runnable> theClass, Class<?> paramClass)
/*    */   {
/* 68 */     Constructor[] tmp4_1 = theClass.getDeclaredConstructors();
/*    */     
/* 68 */     if (tmp4_1 == null) { throw new kotlin.TypeCastException("null cannot be cast to non-null type kotlin.Array<out java.lang.reflect.Constructor<java.lang.Runnable>>");
/*    */     }
/* 67 */     Constructor[] constructors = 
/* 68 */       tmp4_1;
/*    */     
/* 70 */     for (int i = 0; i < constructors.length; i++) { Constructor constructor = constructors[i]; Class[] 
/* 71 */         tmp41_38 = constructor.getParameterTypes();Intrinsics.checkExpressionValueIsNotNull(tmp41_38, "constructor.parameterTypes"); if (TaskDelegateWithWorkerKt.access$checkCompatibility(paramClass, tmp41_38)) {
/* 72 */         return constructor;
/*    */       }
/*    */     }
/*    */     
/* 76 */     throw ((Throwable)new RuntimeException(
/* 77 */       "Unable to find constructor for " + theClass.getCanonicalName() + " with single parameter" + " of type " + 
/* 78 */       paramClass.getCanonicalName()));
/*    */   }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\020%\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\005\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R6\020\003\032\036\022\f\022\n\022\006\b\001\022\0020\0060\005\022\f\022\n\022\006\b\001\022\0020\0060\0070\004X.¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013¨\006\f"}, d2={"Lcom/android/build/gradle/internal/tasks/TaskDelegateWithWorker$Companion;", "", "()V", "constructorCache", "", "Ljava/lang/Class;", "Ljava/lang/Runnable;", "Ljava/lang/reflect/Constructor;", "getConstructorCache", "()Ljava/util/Map;", "setConstructorCache", "(Ljava/util/Map;)V", "gradle-core"})
/* 82 */   public static final class Companion { public final void setConstructorCache(@NotNull Map<Class<? extends Runnable>, Constructor<? extends Runnable>> <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");TaskDelegateWithWorker.constructorCache = <set-?>; } @NotNull
/* 82 */     public final Map<Class<? extends Runnable>, Constructor<? extends Runnable>> getConstructorCache() { Map tmp3_0 = TaskDelegateWithWorker.constructorCache;
/*    */       
/* 82 */       if (tmp3_0 == null) Intrinsics.throwUninitializedPropertyAccessException("constructorCache"); return tmp3_0;
/*    */     }
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public abstract Class<? extends Runnable> getWorkerClass();
/*    */   
/*    */   @NotNull
/*    */   public abstract Serializable getWorkerParam();
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.TaskDelegateWithWorker
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */