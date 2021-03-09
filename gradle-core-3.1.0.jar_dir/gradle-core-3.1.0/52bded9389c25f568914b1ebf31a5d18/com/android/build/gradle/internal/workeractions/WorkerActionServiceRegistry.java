/*    */ package com.android.build.gradle.internal.workeractions;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.Executor;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.JvmField;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0008\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020%\n\002\030\002\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\036\n\002\b\003\n\002\030\002\n\002\b\004\030\000 \0242\0020\001:\003\024\025\026B\005¢\006\002\020\002J&\020\007\032\b\022\004\022\002H\b0\006\"\b\b\000\020\b*\0020\0012\f\020\t\032\b\022\004\022\002H\b0\005H\007J4\020\n\032\0020\013\"\b\b\000\020\b*\0020\0012\f\020\t\032\b\022\004\022\002H\b0\0052\022\020\f\032\016\022\n\022\b\022\004\022\002H\b0\0060\rH\007J\022\020\016\032\f\022\b\022\006\022\002\b\0030\0060\017H\003J(\020\020\032\n\022\004\022\002H\b\030\0010\006\"\b\b\000\020\b*\0020\0012\f\020\t\032\b\022\004\022\002H\b0\005H\007J\016\020\021\032\0020\0132\006\020\022\032\0020\023R\"\020\003\032\026\022\b\022\006\022\002\b\0030\005\022\b\022\006\022\002\b\0030\0060\004X\004¢\006\002\n\000¨\006\027"}, d2={"Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry;", "", "()V", "services", "", "Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry$ServiceKey;", "Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry$RegisteredService;", "getService", "T", "key", "registerService", "", "serviceFactory", "Lkotlin/Function0;", "removeAllServices", "", "removeService", "shutdownAllRegisteredServices", "executor", "Ljava/util/concurrent/Executor;", "Companion", "RegisteredService", "ServiceKey", "gradle-core"})
/*    */ public final class WorkerActionServiceRegistry
/*    */ {
/* 31 */   public static final Companion Companion = new Companion(null); @JvmField
/*    */   @NotNull
/* 31 */   public static final WorkerActionServiceRegistry INSTANCE = new WorkerActionServiceRegistry();
/*    */   
/*    */   private final Map<ServiceKey<?>, RegisteredService<?>> services;
/*    */   
/*    */   public WorkerActionServiceRegistry()
/*    */   {
/* 43 */     WorkerActionServiceRegistry localWorkerActionServiceRegistry = this;Map localMap = (Map)new LinkedHashMap();services = localMap;
/*    */   }
/*    */   
/*    */   public final synchronized <T> void registerService(@NotNull ServiceKey<T> key, @NotNull Function0<? extends RegisteredService<? extends T>> serviceFactory)
/*    */   {
/* 48 */     Intrinsics.checkParameterIsNotNull(key, "key");Intrinsics.checkParameterIsNotNull(serviceFactory, "serviceFactory"); if (services.get(key) == null) {
/* 49 */       services.put(key, serviceFactory.invoke());
/*    */     }
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public final synchronized <T> RegisteredService<T> removeService(@NotNull ServiceKey<T> key)
/*    */   {
/* 68 */     Intrinsics.checkParameterIsNotNull(key, "key");return (RegisteredService)services.remove(key);
/*    */   }
/*    */   
/*    */   private final synchronized Collection<RegisteredService<?>> removeAllServices()
/*    */   {
/* 73 */     ArrayList toBeShutdown = new ArrayList(services.values());
/* 74 */     services.clear();
/* 75 */     return (Collection)toBeShutdown;
/*    */   }
/*    */   
/*    */   public final void shutdownAllRegisteredServices(@NotNull Executor executor)
/*    */   {
/* 84 */     Intrinsics.checkParameterIsNotNull(executor, "executor");Collection toBeShutdown = removeAllServices();
/* 85 */     Iterable $receiver$iv = (Iterable)toBeShutdown;
/*    */     
/*    */     int $i$f$forEach;
/*    */     
/*    */     RegisteredService it;
/*    */     
/*    */     int $i$a$1$forEach;
/*    */     
/* 93 */     for (Iterator localIterator = $receiver$iv.iterator(); localIterator.hasNext(); executor.execute((Runnable)new WorkerActionServiceRegistry.shutdownAllRegisteredServices.1.1(it)))
/*    */     {
/* 93 */       Object element$iv = localIterator.next();it = (RegisteredService)element$iv;
/*    */     }
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   @NotNull
/*    */   public final synchronized <T> RegisteredService<T> getService(@NotNull ServiceKey<T> key)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 12
/*    */     //   3: invokestatic 18	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_0
/*    */     //   7: getfield 22	com/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry:services	Ljava/util/Map;
/*    */     //   10: aload_1
/*    */     //   11: invokeinterface 28 2 0
/*    */     //   16: checkcast 46	com/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry$RegisteredService
/*    */     //   19: dup
/*    */     //   20: ifnull +6 -> 26
/*    */     //   23: goto +39 -> 62
/*    */     //   26: pop
/*    */     //   27: new 48	java/lang/IllegalStateException
/*    */     //   30: dup
/*    */     //   31: new 50	java/lang/StringBuilder
/*    */     //   34: dup
/*    */     //   35: invokespecial 54	java/lang/StringBuilder:<init>	()V
/*    */     //   38: ldc 56
/*    */     //   40: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   43: aload_1
/*    */     //   44: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   47: ldc 65
/*    */     //   49: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   52: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*    */     //   55: invokespecial 72	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
/*    */     //   58: checkcast 74	java/lang/Throwable
/*    */     //   61: athrow
/*    */     //   62: areturn
/*    */     // Line number table:
/*    */     //   Java source line #56	-> byte code offset #6
/*    */     //   Java source line #57	-> byte code offset #6
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	63	0	this	WorkerActionServiceRegistry
/*    */     //   0	63	1	key	ServiceKey
/*    */   }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\030\n\002\030\002\n\000\n\002\020\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\bf\030\000*\b\b\000\020\001*\0020\0022\0020\003R\030\020\004\032\b\022\004\022\0028\0000\005X¦\004¢\006\006\032\004\b\006\020\007¨\006\b"}, d2={"Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry$ServiceKey;", "T", "", "Ljava/io/Serializable;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "gradle-core"})
/*    */   public static abstract interface ServiceKey<T>
/*    */     extends Serializable
/*    */   {
/*    */     @NotNull
/*    */     public abstract Class<T> getType();
/*    */   }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\024\n\002\030\002\n\000\n\002\020\000\n\002\b\004\n\002\020\002\n\000\bf\030\000*\n\b\000\020\001 \001*\0020\0022\0020\002J\b\020\006\032\0020\007H&R\022\020\003\032\0028\000X¦\004¢\006\006\032\004\b\004\020\005¨\006\b"}, d2={"Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry$RegisteredService;", "T", "", "service", "getService", "()Ljava/lang/Object;", "shutdown", "", "gradle-core"})
/*    */   public static abstract interface RegisteredService<T>
/*    */   {
/*    */     @NotNull
/*    */     public abstract T getService();
/*    */     
/*    */     public abstract void shutdown();
/*    */   }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000¨\006\005"}, d2={"Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry$Companion;", "", "()V", "INSTANCE", "Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry;", "gradle-core"})
/*    */   public static final class Companion {}
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.workeractions.WorkerActionServiceRegistry
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */