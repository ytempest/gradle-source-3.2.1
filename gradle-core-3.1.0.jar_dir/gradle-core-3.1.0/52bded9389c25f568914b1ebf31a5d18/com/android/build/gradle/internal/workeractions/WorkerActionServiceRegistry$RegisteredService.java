package com.android.build.gradle.internal.workeractions;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\024\n\002\030\002\n\000\n\002\020\000\n\002\b\004\n\002\020\002\n\000\bf\030\000*\n\b\000\020\001 \001*\0020\0022\0020\002J\b\020\006\032\0020\007H&R\022\020\003\032\0028\000X¦\004¢\006\006\032\004\b\004\020\005¨\006\b"}, d2={"Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry$RegisteredService;", "T", "", "service", "getService", "()Ljava/lang/Object;", "shutdown", "", "gradle-core"})
public abstract interface WorkerActionServiceRegistry$RegisteredService<T>
{
  @NotNull
  public abstract T getService();
  
  public abstract void shutdown();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.workeractions.WorkerActionServiceRegistry.RegisteredService
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */