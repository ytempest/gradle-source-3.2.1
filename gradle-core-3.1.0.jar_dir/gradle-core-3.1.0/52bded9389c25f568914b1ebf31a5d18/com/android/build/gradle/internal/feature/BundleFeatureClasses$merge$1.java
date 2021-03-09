package com.android.build.gradle.internal.feature;

import java.util.HashMap;
import kotlin.Metadata;
import org.gradle.api.Action;
import org.gradle.workers.WorkerConfiguration;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "it", "Lorg/gradle/workers/WorkerConfiguration;", "kotlin.jvm.PlatformType", "execute"})
final class BundleFeatureClasses$merge$1<T>
  implements Action<WorkerConfiguration>
{
  /* Error */
  public final void execute(WorkerConfiguration it)
  {
    // Byte code:
    //   0: aload_1
    //   1: dup
    //   2: ldc 16
    //   4: invokestatic 22	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: getstatic 28	org/gradle/workers/IsolationMode:NONE	Lorg/gradle/workers/IsolationMode;
    //   10: invokeinterface 32 2 0
    //   15: aload_1
    //   16: iconst_1
    //   17: anewarray 5	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: new 34	com/android/build/gradle/internal/res/namespaced/JarRequest
    //   25: dup
    //   26: aload_0
    //   27: getfield 38	com/android/build/gradle/internal/feature/BundleFeatureClasses$merge$1:this$0	Lcom/android/build/gradle/internal/feature/BundleFeatureClasses;
    //   30: invokevirtual 44	com/android/build/gradle/internal/feature/BundleFeatureClasses:getOutputJar	()Ljava/io/File;
    //   33: aconst_null
    //   34: aload_0
    //   35: getfield 38	com/android/build/gradle/internal/feature/BundleFeatureClasses$merge$1:this$0	Lcom/android/build/gradle/internal/feature/BundleFeatureClasses;
    //   38: invokestatic 48	com/android/build/gradle/internal/feature/BundleFeatureClasses:access$getDependencyRClassClasses$p	(Lcom/android/build/gradle/internal/feature/BundleFeatureClasses;)Lorg/gradle/api/file/FileCollection;
    //   41: dup
    //   42: ifnull +25 -> 67
    //   45: invokeinterface 54 1 0
    //   50: dup
    //   51: ifnull +16 -> 67
    //   54: checkcast 56	java/lang/Iterable
    //   57: invokestatic 62	kotlin/collections/CollectionsKt:toList	(Ljava/lang/Iterable;)Ljava/util/List;
    //   60: dup
    //   61: ifnull +6 -> 67
    //   64: goto +39 -> 103
    //   67: pop
    //   68: astore 9
    //   70: astore 8
    //   72: astore 7
    //   74: astore 6
    //   76: istore 5
    //   78: astore 4
    //   80: astore_3
    //   81: astore_2
    //   82: invokestatic 66	kotlin/collections/CollectionsKt:emptyList	()Ljava/util/List;
    //   85: astore 10
    //   87: aload_2
    //   88: aload_3
    //   89: aload 4
    //   91: iload 5
    //   93: aload 6
    //   95: aload 7
    //   97: aload 8
    //   99: aload 9
    //   101: aload 10
    //   103: aload_0
    //   104: getfield 70	com/android/build/gradle/internal/feature/BundleFeatureClasses$merge$1:$files	Ljava/util/HashMap;
    //   107: checkcast 72	java/util/Map
    //   110: iconst_2
    //   111: aconst_null
    //   112: invokespecial 76	com/android/build/gradle/internal/res/namespaced/JarRequest:<init>	(Ljava/io/File;Ljava/util/List;Ljava/util/List;Ljava/util/Map;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   115: aastore
    //   116: invokeinterface 80 2 0
    //   121: return
    // Line number table:
    //   Java source line #70	-> byte code offset #0
    //   Java source line #71	-> byte code offset #15
    //   Java source line #72	-> byte code offset #21
    //   Java source line #73	-> byte code offset #26
    //   Java source line #74	-> byte code offset #34
    //   Java source line #75	-> byte code offset #103
    //   Java source line #72	-> byte code offset #112
    //   Java source line #71	-> byte code offset #116
    //   Java source line #76	-> byte code offset #121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	1
    //   0	122	1	it	WorkerConfiguration
  }
  
  BundleFeatureClasses$merge$1(BundleFeatureClasses paramBundleFeatureClasses, HashMap paramHashMap) {}
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.feature.BundleFeatureClasses.merge.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */