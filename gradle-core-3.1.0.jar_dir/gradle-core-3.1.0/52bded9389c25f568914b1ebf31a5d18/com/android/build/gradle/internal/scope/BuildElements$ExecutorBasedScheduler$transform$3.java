package com.android.build.gradle.internal.scope;

import com.android.ide.common.internal.WaitableExecutor.TaskResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\024\n\000\n\002\020\013\n\000\n\002\030\002\n\002\030\002\n\002\b\002\020\000\032\0020\0012*\020\002\032&\022\f\022\n \005*\004\030\0010\0040\004 \005*\022\022\f\022\n \005*\004\030\0010\0040\004\030\0010\0030\003H\n¢\006\002\b\006"}, d2={"<anonymous>", "", "it", "Lcom/android/ide/common/internal/WaitableExecutor$TaskResult;", "Lcom/android/build/gradle/internal/scope/BuildElements$ActionItem;", "kotlin.jvm.PlatformType", "invoke"})
final class BuildElements$ExecutorBasedScheduler$transform$3
  extends Lambda
  implements Function1<WaitableExecutor.TaskResult<BuildElements.ActionItem>, Boolean>
{
  public static final 3 INSTANCE = new 3();
  
  /* Error */
  public final boolean invoke(WaitableExecutor.TaskResult<BuildElements.ActionItem> it)
  {
    // Byte code:
    //   0: aload_1
    //   1: dup
    //   2: ldc 22
    //   4: invokestatic 28	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: invokevirtual 32	com/android/ide/common/internal/WaitableExecutor$TaskResult:getValue	()Ljava/lang/Object;
    //   10: checkcast 34	com/android/build/gradle/internal/scope/BuildElements$ActionItem
    //   13: dup
    //   14: ifnull +9 -> 23
    //   17: invokevirtual 38	com/android/build/gradle/internal/scope/BuildElements$ActionItem:getOutput	()Ljava/io/File;
    //   20: goto +5 -> 25
    //   23: pop
    //   24: aconst_null
    //   25: ifnull +7 -> 32
    //   28: iconst_1
    //   29: goto +4 -> 33
    //   32: iconst_0
    //   33: ireturn
    // Line number table:
    //   Java source line #135	-> byte code offset #0
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	3
    //   0	34	1	it	WaitableExecutor.TaskResult
  }
  
  BuildElements$ExecutorBasedScheduler$transform$3()
  {
    super(1);
  }
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildElements.ExecutorBasedScheduler.transform.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */