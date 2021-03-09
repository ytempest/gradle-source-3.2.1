package com.android.build.gradle.internal.dependency;

import com.google.common.collect.ImmutableSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.gradle.api.artifacts.result.ResolvedArtifactResult;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\016\n\000\n\002\030\002\n\002\030\002\n\002\b\002\020\000\032&\022\f\022\n \003*\004\030\0010\0020\002 \003*\022\022\f\022\n \003*\004\030\0010\0020\002\030\0010\0010\001H\n¢\006\002\b\004"}, d2={"<anonymous>", "Lcom/google/common/collect/ImmutableSet;", "Lorg/gradle/api/artifacts/result/ResolvedArtifactResult;", "kotlin.jvm.PlatformType", "invoke"})
final class AndroidTestResourceArtifactCollection$_artifacts$2
  extends Lambda
  implements Function0<ImmutableSet<ResolvedArtifactResult>>
{
  /* Error */
  public final ImmutableSet<ResolvedArtifactResult> invoke()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$_artifacts$2:this$0	Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;
    //   4: invokestatic 22	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection:access$getDependencyRootsToKeep$p	(Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;)Ljava/util/Collection;
    //   7: checkcast 24	java/lang/Iterable
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 16	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$_artifacts$2:this$0	Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;
    //   15: astore_3
    //   16: aload_2
    //   17: astore 4
    //   19: new 26	java/util/ArrayList
    //   22: dup
    //   23: invokespecial 30	java/util/ArrayList:<init>	()V
    //   26: checkcast 32	java/util/Collection
    //   29: astore 5
    //   31: aload 4
    //   33: astore 6
    //   35: aload 6
    //   37: invokeinterface 36 1 0
    //   42: astore 7
    //   44: aload 7
    //   46: invokeinterface 42 1 0
    //   51: ifeq +57 -> 108
    //   54: aload 7
    //   56: invokeinterface 45 1 0
    //   61: astore 8
    //   63: aload 8
    //   65: astore 9
    //   67: aload 9
    //   69: checkcast 47	org/gradle/api/artifacts/Dependency
    //   72: astore 10
    //   74: aload_3
    //   75: aload 10
    //   77: invokestatic 51	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection:access$toRequest	(Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;Lorg/gradle/api/artifacts/Dependency;)Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request;
    //   80: dup
    //   81: ifnull +22 -> 103
    //   84: astore 12
    //   86: aload 12
    //   88: astore 13
    //   90: aload 5
    //   92: aload 13
    //   94: invokeinterface 55 2 0
    //   99: pop
    //   100: goto +4 -> 104
    //   103: pop
    //   104: nop
    //   105: goto -61 -> 44
    //   108: nop
    //   109: aload 5
    //   111: checkcast 57	java/util/List
    //   114: checkcast 24	java/lang/Iterable
    //   117: invokestatic 63	kotlin/collections/CollectionsKt:toSet	(Ljava/lang/Iterable;)Ljava/util/Set;
    //   120: astore_1
    //   121: new 65	java/util/HashSet
    //   124: dup
    //   125: invokespecial 66	java/util/HashSet:<init>	()V
    //   128: astore_2
    //   129: aload_0
    //   130: getfield 16	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$_artifacts$2:this$0	Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;
    //   133: invokestatic 70	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection:access$getDependencyGraph$p	(Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;)Lorg/gradle/api/artifacts/ResolvableDependencies;
    //   136: invokeinterface 76 1 0
    //   141: dup
    //   142: ldc 78
    //   144: invokestatic 84	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   147: invokeinterface 90 1 0
    //   152: dup
    //   153: ldc 92
    //   155: invokestatic 84	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   158: invokeinterface 98 1 0
    //   163: invokeinterface 101 1 0
    //   168: astore 4
    //   170: aload 4
    //   172: invokeinterface 42 1 0
    //   177: ifeq +94 -> 271
    //   180: aload 4
    //   182: invokeinterface 45 1 0
    //   187: checkcast 103	org/gradle/api/artifacts/result/DependencyResult
    //   190: astore_3
    //   191: aload_3
    //   192: dup
    //   193: ifnonnull +13 -> 206
    //   196: new 105	kotlin/TypeCastException
    //   199: dup
    //   200: ldc 107
    //   202: invokespecial 110	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   205: athrow
    //   206: checkcast 112	org/gradle/api/artifacts/result/ResolvedDependencyResult
    //   209: pop
    //   210: aload_1
    //   211: checkcast 24	java/lang/Iterable
    //   214: aload_0
    //   215: getfield 16	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$_artifacts$2:this$0	Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;
    //   218: aload_3
    //   219: checkcast 112	org/gradle/api/artifacts/result/ResolvedDependencyResult
    //   222: invokeinterface 115 1 0
    //   227: dup
    //   228: ldc 117
    //   230: invokestatic 84	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   233: invokeinterface 121 1 0
    //   238: dup
    //   239: ldc 123
    //   241: invokestatic 84	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   244: invokestatic 126	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection:access$toRequest	(Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;Lorg/gradle/api/artifacts/component/ComponentIdentifier;)Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request;
    //   247: invokestatic 130	kotlin/collections/CollectionsKt:contains	(Ljava/lang/Iterable;Ljava/lang/Object;)Z
    //   250: ifeq +18 -> 268
    //   253: aload_0
    //   254: getfield 16	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$_artifacts$2:this$0	Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;
    //   257: aload_2
    //   258: checkcast 100	java/util/Set
    //   261: aload_3
    //   262: checkcast 112	org/gradle/api/artifacts/result/ResolvedDependencyResult
    //   265: invokestatic 134	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection:access$collect	(Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;Ljava/util/Set;Lorg/gradle/api/artifacts/result/ResolvedDependencyResult;)V
    //   268: goto -98 -> 170
    //   271: invokestatic 140	com/google/common/collect/ImmutableSet:builder	()Lcom/google/common/collect/ImmutableSet$Builder;
    //   274: astore_3
    //   275: aload_0
    //   276: getfield 16	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$_artifacts$2:this$0	Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;
    //   279: invokestatic 144	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection:access$getDependenciesToFilter$p	(Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection;)Lorg/gradle/api/artifacts/ArtifactCollection;
    //   282: invokeinterface 149 1 0
    //   287: dup
    //   288: ldc -105
    //   290: invokestatic 84	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   293: checkcast 24	java/lang/Iterable
    //   296: astore 4
    //   298: nop
    //   299: aload 4
    //   301: astore 5
    //   303: new 26	java/util/ArrayList
    //   306: dup
    //   307: invokespecial 30	java/util/ArrayList:<init>	()V
    //   310: checkcast 32	java/util/Collection
    //   313: astore 6
    //   315: aload 5
    //   317: invokeinterface 36 1 0
    //   322: astore 7
    //   324: aload 7
    //   326: invokeinterface 42 1 0
    //   331: ifeq +63 -> 394
    //   334: aload 7
    //   336: invokeinterface 45 1 0
    //   341: astore 8
    //   343: aload 8
    //   345: checkcast 153	org/gradle/api/artifacts/result/ResolvedArtifactResult
    //   348: astore 9
    //   350: aload_2
    //   351: aload 9
    //   353: dup
    //   354: ldc -101
    //   356: invokestatic 84	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   359: invokeinterface 158 1 0
    //   364: dup
    //   365: ldc -96
    //   367: invokestatic 84	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   370: invokeinterface 165 1 0
    //   375: invokevirtual 167	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   378: ifeq +13 -> 391
    //   381: aload 6
    //   383: aload 8
    //   385: invokeinterface 55 2 0
    //   390: pop
    //   391: goto -67 -> 324
    //   394: aload 6
    //   396: checkcast 57	java/util/List
    //   399: checkcast 24	java/lang/Iterable
    //   402: astore 4
    //   404: nop
    //   405: aload 4
    //   407: invokeinterface 36 1 0
    //   412: astore 5
    //   414: aload 5
    //   416: invokeinterface 42 1 0
    //   421: ifeq +30 -> 451
    //   424: aload 5
    //   426: invokeinterface 45 1 0
    //   431: astore 6
    //   433: aload 6
    //   435: checkcast 153	org/gradle/api/artifacts/result/ResolvedArtifactResult
    //   438: astore 7
    //   440: aload_3
    //   441: aload 7
    //   443: invokevirtual 172	com/google/common/collect/ImmutableSet$Builder:add	(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet$Builder;
    //   446: pop
    //   447: nop
    //   448: goto -34 -> 414
    //   451: nop
    //   452: aload_3
    //   453: invokevirtual 175	com/google/common/collect/ImmutableSet$Builder:build	()Lcom/google/common/collect/ImmutableSet;
    //   456: areturn
    // Line number table:
    //   Java source line #103	-> byte code offset #0
    //   Java source line #170	-> byte code offset #16
    //   Java source line #178	-> byte code offset #31
    //   Java source line #179	-> byte code offset #35
    //   Java source line #178	-> byte code offset #67
    //   Java source line #103	-> byte code offset #77
    //   Java source line #178	-> byte code offset #90
    //   Java source line #178	-> byte code offset #100
    //   Java source line #178	-> byte code offset #104
    //   Java source line #180	-> byte code offset #108
    //   Java source line #181	-> byte code offset #109
    //   Java source line #103	-> byte code offset #117
    //   Java source line #107	-> byte code offset #121
    //   Java source line #108	-> byte code offset #129
    //   Java source line #109	-> byte code offset #191
    //   Java source line #110	-> byte code offset #210
    //   Java source line #111	-> byte code offset #253
    //   Java source line #108	-> byte code offset #268
    //   Java source line #114	-> byte code offset #271
    //   Java source line #115	-> byte code offset #275
    //   Java source line #117	-> byte code offset #275
    //   Java source line #115	-> byte code offset #275
    //   Java source line #116	-> byte code offset #275
    //   Java source line #115	-> byte code offset #275
    //   Java source line #116	-> byte code offset #298
    //   Java source line #182	-> byte code offset #299
    //   Java source line #183	-> byte code offset #315
    //   Java source line #116	-> byte code offset #350
    //   Java source line #184	-> byte code offset #394
    //   Java source line #117	-> byte code offset #404
    //   Java source line #185	-> byte code offset #405
    //   Java source line #117	-> byte code offset #440
    //   Java source line #186	-> byte code offset #451
    //   Java source line #118	-> byte code offset #452
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	2
    //   121	335	1	requests	java.util.Set
    //   16	98	2	$receiver$iv	Iterable
    //   129	327	2	keptComponents	java.util.HashSet
    //   191	77	3	dependencyResult	org.gradle.api.artifacts.result.DependencyResult
    //   275	181	3	builder	com.google.common.collect.ImmutableSet.Builder
    //   31	80	4	$receiver$iv$iv	Iterable
    //   299	100	4	$receiver$iv	Iterable
    //   405	47	4	$receiver$iv	Iterable
    //   31	80	5	destination$iv$iv	java.util.Collection
    //   315	81	5	$receiver$iv$iv	Iterable
    //   35	74	6	$receiver$iv$iv$iv	Iterable
    //   315	81	6	destination$iv$iv	java.util.Collection
    //   433	15	6	element$iv	Object
    //   440	7	7	it	ResolvedArtifactResult
    //   63	42	8	element$iv$iv$iv	Object
    //   343	48	8	element$iv$iv	Object
    //   440	7	8	$i$a$2$forEach	int
    //   67	37	9	element$iv$iv	Object
    //   350	28	9	it	ResolvedArtifactResult
    //   405	47	9	$i$f$forEach	int
    //   74	6	10	p1	org.gradle.api.artifacts.Dependency
    //   350	28	10	$i$a$1$filter	int
    //   74	6	11	$i$a$1$unknown	int
    //   315	81	11	$i$f$filterTo	int
    //   299	100	12	$i$f$filter	int
    //   90	9	13	it$iv$iv	Object
    //   90	9	14	$i$a$1$let	int
    //   67	37	15	$i$a$1$forEach	int
    //   35	74	16	$i$f$forEach	int
    //   31	80	17	$i$f$mapNotNullTo	int
    //   16	98	18	$i$f$mapNotNull	int
  }
  
  AndroidTestResourceArtifactCollection$_artifacts$2(AndroidTestResourceArtifactCollection paramAndroidTestResourceArtifactCollection)
  {
    super(0);
  }
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.AndroidTestResourceArtifactCollection._artifacts.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */