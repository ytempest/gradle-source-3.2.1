package com.android.build.gradle.internal.tasks;

import kotlin.Metadata;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000\026\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\021\n\002\b\002\032-\020\000\032\0020\0012\n\020\002\032\006\022\002\b\0030\0032\022\020\004\032\016\022\n\022\b\022\002\b\003\030\0010\0030\005H\002¢\006\002\020\006¨\006\007"}, d2={"checkCompatibility", "", "argumentType", "Ljava/lang/Class;", "parameterTypes", "", "(Ljava/lang/Class;[Ljava/lang/Class;)Z", "gradle-core"})
public final class TaskDelegateWithWorkerKt
{
  /* Error */
  private static final boolean checkCompatibility(Class<?> argumentType, Class<?>[] parameterTypes)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 8	[Ljava/lang/Object;
    //   4: arraylength
    //   5: iconst_1
    //   6: if_icmpeq +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_1
    //   12: iconst_0
    //   13: aaload
    //   14: dup
    //   15: ifnull +6 -> 21
    //   18: goto +6 -> 24
    //   21: pop
    //   22: iconst_0
    //   23: ireturn
    //   24: astore_2
    //   25: aload_2
    //   26: aload_0
    //   27: invokevirtual 14	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   30: ireturn
    // Line number table:
    //   Java source line #87	-> byte code offset #0
    //   Java source line #88	-> byte code offset #9
    //   Java source line #91	-> byte code offset #11
    //   Java source line #93	-> byte code offset #25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	argumentType	Class
    //   0	31	1	parameterTypes	Class[]
    //   25	6	2	parameterType	Class
  }
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.TaskDelegateWithWorkerKt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */