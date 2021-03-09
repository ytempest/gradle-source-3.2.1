package com.android.build.gradle.internal.scope;

import com.android.ide.common.internal.WaitableExecutor.TaskResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\024\n\000\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\020\000\032\0020\0012*\020\002\032&\022\f\022\n \005*\004\030\0010\0040\004 \005*\022\022\f\022\n \005*\004\030\0010\0040\004\030\0010\0030\003H\n¢\006\002\b\006"}, d2={"<anonymous>", "", "it", "Lcom/android/ide/common/internal/WaitableExecutor$TaskResult;", "Lcom/android/build/gradle/internal/scope/BuildElements$ActionItem;", "kotlin.jvm.PlatformType", "invoke"})
final class BuildElements$ExecutorBasedScheduler$transform$2
  extends Lambda
  implements Function1<WaitableExecutor.TaskResult<BuildElements.ActionItem>, Unit>
{
  public static final 2 INSTANCE = new 2();
  
  /* Error */
  public final void invoke(WaitableExecutor.TaskResult<BuildElements.ActionItem> it)
  {
    // Byte code:
    //   0: aload_1
    //   1: dup
    //   2: ldc 22
    //   4: invokestatic 28	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: invokevirtual 32	com/android/ide/common/internal/WaitableExecutor$TaskResult:getException	()Ljava/lang/Throwable;
    //   10: ifnull +34 -> 44
    //   13: new 34	org/gradle/tooling/BuildException
    //   16: dup
    //   17: aload_1
    //   18: invokevirtual 32	com/android/ide/common/internal/WaitableExecutor$TaskResult:getException	()Ljava/lang/Throwable;
    //   21: dup
    //   22: ifnull +9 -> 31
    //   25: invokevirtual 40	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   28: goto +5 -> 33
    //   31: pop
    //   32: aconst_null
    //   33: aload_1
    //   34: invokevirtual 32	com/android/ide/common/internal/WaitableExecutor$TaskResult:getException	()Ljava/lang/Throwable;
    //   37: invokespecial 44	org/gradle/tooling/BuildException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   40: checkcast 36	java/lang/Throwable
    //   43: athrow
    //   44: return
    // Line number table:
    //   Java source line #132	-> byte code offset #0
    //   Java source line #133	-> byte code offset #13
    //   Java source line #134	-> byte code offset #44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	2
    //   0	45	1	it	WaitableExecutor.TaskResult
  }
  
  BuildElements$ExecutorBasedScheduler$transform$2()
  {
    super(1);
  }
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildElements.ExecutorBasedScheduler.transform.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */