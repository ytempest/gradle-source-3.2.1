package com.android.build.gradle.internal.workeractions;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\030\n\002\030\002\n\000\n\002\020\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\bf\030\000*\b\b\000\020\001*\0020\0022\0020\003R\030\020\004\032\b\022\004\022\0028\0000\005X¦\004¢\006\006\032\004\b\006\020\007¨\006\b"}, d2={"Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry$ServiceKey;", "T", "", "Ljava/io/Serializable;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "gradle-core"})
public abstract interface WorkerActionServiceRegistry$ServiceKey<T>
  extends Serializable
{
  @NotNull
  public abstract Class<T> getType();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.workeractions.WorkerActionServiceRegistry.ServiceKey
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */