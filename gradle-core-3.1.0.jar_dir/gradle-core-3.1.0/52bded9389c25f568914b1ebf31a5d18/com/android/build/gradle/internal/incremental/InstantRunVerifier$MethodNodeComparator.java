package com.android.build.gradle.internal.incremental;

import org.objectweb.asm.tree.MethodNode;

class InstantRunVerifier$MethodNodeComparator
  implements InstantRunVerifier.Comparator<MethodNode>
{
  /* Error */
  public boolean areEqual(MethodNode first, MethodNode second)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +9 -> 10
    //   4: aload_2
    //   5: ifnonnull +5 -> 10
    //   8: iconst_1
    //   9: ireturn
    //   10: aload_1
    //   11: ifnull +7 -> 18
    //   14: aload_2
    //   15: ifnonnull +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_1
    //   21: getfield 3	org/objectweb/asm/tree/MethodNode:name	Ljava/lang/String;
    //   24: aload_2
    //   25: getfield 3	org/objectweb/asm/tree/MethodNode:name	Ljava/lang/String;
    //   28: invokevirtual 4	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +17 -> 48
    //   34: aload_1
    //   35: getfield 5	org/objectweb/asm/tree/MethodNode:desc	Ljava/lang/String;
    //   38: aload_2
    //   39: getfield 5	org/objectweb/asm/tree/MethodNode:desc	Ljava/lang/String;
    //   42: invokevirtual 4	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifne +5 -> 50
    //   48: iconst_0
    //   49: ireturn
    //   50: new 6	com/android/build/gradle/internal/incremental/InstantRunVerifier$VerifierTextifier
    //   53: dup
    //   54: invokespecial 7	com/android/build/gradle/internal/incremental/InstantRunVerifier$VerifierTextifier:<init>	()V
    //   57: astore_3
    //   58: new 6	com/android/build/gradle/internal/incremental/InstantRunVerifier$VerifierTextifier
    //   61: dup
    //   62: invokespecial 7	com/android/build/gradle/internal/incremental/InstantRunVerifier$VerifierTextifier:<init>	()V
    //   65: astore 4
    //   67: aload_1
    //   68: new 8	org/objectweb/asm/util/TraceMethodVisitor
    //   71: dup
    //   72: aload_3
    //   73: invokespecial 9	org/objectweb/asm/util/TraceMethodVisitor:<init>	(Lorg/objectweb/asm/util/Printer;)V
    //   76: invokevirtual 10	org/objectweb/asm/tree/MethodNode:accept	(Lorg/objectweb/asm/MethodVisitor;)V
    //   79: aload_2
    //   80: new 8	org/objectweb/asm/util/TraceMethodVisitor
    //   83: dup
    //   84: aload 4
    //   86: invokespecial 9	org/objectweb/asm/util/TraceMethodVisitor:<init>	(Lorg/objectweb/asm/util/Printer;)V
    //   89: invokevirtual 10	org/objectweb/asm/tree/MethodNode:accept	(Lorg/objectweb/asm/MethodVisitor;)V
    //   92: new 11	java/io/StringWriter
    //   95: dup
    //   96: invokespecial 12	java/io/StringWriter:<init>	()V
    //   99: astore 5
    //   101: aconst_null
    //   102: astore 6
    //   104: new 11	java/io/StringWriter
    //   107: dup
    //   108: invokespecial 12	java/io/StringWriter:<init>	()V
    //   111: astore 7
    //   113: aconst_null
    //   114: astore 8
    //   116: aload_3
    //   117: new 13	java/io/PrintWriter
    //   120: dup
    //   121: aload 5
    //   123: invokespecial 14	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   126: invokevirtual 15	com/android/build/gradle/internal/incremental/InstantRunVerifier$VerifierTextifier:print	(Ljava/io/PrintWriter;)V
    //   129: aload 4
    //   131: new 13	java/io/PrintWriter
    //   134: dup
    //   135: aload 7
    //   137: invokespecial 14	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   140: invokevirtual 15	com/android/build/gradle/internal/incremental/InstantRunVerifier$VerifierTextifier:print	(Ljava/io/PrintWriter;)V
    //   143: aload 5
    //   145: invokevirtual 16	java/io/StringWriter:toString	()Ljava/lang/String;
    //   148: aload 7
    //   150: invokevirtual 16	java/io/StringWriter:toString	()Ljava/lang/String;
    //   153: invokevirtual 4	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: istore 9
    //   158: aload 7
    //   160: ifnull +33 -> 193
    //   163: aload 8
    //   165: ifnull +23 -> 188
    //   168: aload 7
    //   170: invokevirtual 17	java/io/StringWriter:close	()V
    //   173: goto +20 -> 193
    //   176: astore 10
    //   178: aload 8
    //   180: aload 10
    //   182: invokevirtual 19	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   185: goto +8 -> 193
    //   188: aload 7
    //   190: invokevirtual 17	java/io/StringWriter:close	()V
    //   193: aload 5
    //   195: ifnull +33 -> 228
    //   198: aload 6
    //   200: ifnull +23 -> 223
    //   203: aload 5
    //   205: invokevirtual 17	java/io/StringWriter:close	()V
    //   208: goto +20 -> 228
    //   211: astore 10
    //   213: aload 6
    //   215: aload 10
    //   217: invokevirtual 19	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   220: goto +8 -> 228
    //   223: aload 5
    //   225: invokevirtual 17	java/io/StringWriter:close	()V
    //   228: iload 9
    //   230: ireturn
    //   231: astore 9
    //   233: aload 9
    //   235: astore 8
    //   237: aload 9
    //   239: athrow
    //   240: astore 11
    //   242: aload 7
    //   244: ifnull +33 -> 277
    //   247: aload 8
    //   249: ifnull +23 -> 272
    //   252: aload 7
    //   254: invokevirtual 17	java/io/StringWriter:close	()V
    //   257: goto +20 -> 277
    //   260: astore 12
    //   262: aload 8
    //   264: aload 12
    //   266: invokevirtual 19	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   269: goto +8 -> 277
    //   272: aload 7
    //   274: invokevirtual 17	java/io/StringWriter:close	()V
    //   277: aload 11
    //   279: athrow
    //   280: astore 7
    //   282: aload 7
    //   284: astore 6
    //   286: aload 7
    //   288: athrow
    //   289: astore 13
    //   291: aload 5
    //   293: ifnull +33 -> 326
    //   296: aload 6
    //   298: ifnull +23 -> 321
    //   301: aload 5
    //   303: invokevirtual 17	java/io/StringWriter:close	()V
    //   306: goto +20 -> 326
    //   309: astore 14
    //   311: aload 6
    //   313: aload 14
    //   315: invokevirtual 19	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   318: goto +8 -> 326
    //   321: aload 5
    //   323: invokevirtual 17	java/io/StringWriter:close	()V
    //   326: aload 13
    //   328: athrow
    //   329: astore 5
    //   331: new 21	java/lang/RuntimeException
    //   334: dup
    //   335: ldc 22
    //   337: aload 5
    //   339: invokespecial 23	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   342: athrow
    // Line number table:
    //   Java source line #427	-> byte code offset #0
    //   Java source line #428	-> byte code offset #8
    //   Java source line #430	-> byte code offset #10
    //   Java source line #431	-> byte code offset #18
    //   Java source line #433	-> byte code offset #20
    //   Java source line #434	-> byte code offset #48
    //   Java source line #436	-> byte code offset #50
    //   Java source line #437	-> byte code offset #58
    //   Java source line #438	-> byte code offset #67
    //   Java source line #439	-> byte code offset #79
    //   Java source line #441	-> byte code offset #92
    //   Java source line #442	-> byte code offset #104
    //   Java source line #441	-> byte code offset #113
    //   Java source line #444	-> byte code offset #116
    //   Java source line #445	-> byte code offset #129
    //   Java source line #447	-> byte code offset #143
    //   Java source line #448	-> byte code offset #158
    //   Java source line #447	-> byte code offset #228
    //   Java source line #441	-> byte code offset #231
    //   Java source line #448	-> byte code offset #240
    //   Java source line #441	-> byte code offset #280
    //   Java source line #448	-> byte code offset #289
    //   Java source line #449	-> byte code offset #331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	MethodNodeComparator
    //   0	343	1	first	MethodNode
    //   0	343	2	second	MethodNode
    //   57	60	3	firstMethodTextifier	InstantRunVerifier.VerifierTextifier
    //   65	65	4	secondMethodTextifier	InstantRunVerifier.VerifierTextifier
    //   99	223	5	firstText	java.io.StringWriter
    //   329	9	5	e	java.io.IOException
    //   102	210	6	localThrowable6	Throwable
    //   111	162	7	secondText	java.io.StringWriter
    //   280	7	7	localThrowable4	Throwable
    //   114	149	8	localThrowable7	Throwable
    //   231	7	9	localThrowable2	Throwable
    //   231	7	9	localThrowable8	Throwable
    //   176	5	10	localThrowable	Throwable
    //   211	5	10	localThrowable1	Throwable
    //   240	38	11	localObject1	Object
    //   260	5	12	localThrowable3	Throwable
    //   289	38	13	localObject2	Object
    //   309	5	14	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   168	173	176	java/lang/Throwable
    //   203	208	211	java/lang/Throwable
    //   116	158	231	java/lang/Throwable
    //   116	158	240	finally
    //   231	242	240	finally
    //   252	257	260	java/lang/Throwable
    //   104	193	280	java/lang/Throwable
    //   231	280	280	java/lang/Throwable
    //   104	193	289	finally
    //   231	291	289	finally
    //   301	306	309	java/lang/Throwable
    //   92	228	329	java/io/IOException
    //   231	329	329	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunVerifier.MethodNodeComparator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */