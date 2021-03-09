/*    */ package com.android.build.gradle.internal.actions;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import javax.inject.Inject;
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\034\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\002\n\000\030\0002\0020\0012\0020\002B\027\b\007\022\006\020\003\032\0020\004\022\006\020\005\032\0020\004¢\006\002\020\006J\b\020\n\032\0020\013H\026R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\007\020\bR\021\020\005\032\0020\004¢\006\b\n\000\032\004\b\t\020\b¨\006\f"}, d2={"Lcom/android/build/gradle/internal/actions/AttrExtractor;", "Ljava/lang/Runnable;", "Ljava/io/Serializable;", "inputFile", "Ljava/io/File;", "outputFile", "(Ljava/io/File;Ljava/io/File;)V", "getInputFile", "()Ljava/io/File;", "getOutputFile", "run", "", "gradle-core"})
/*    */ public final class AttrExtractor
/*    */   implements Runnable, Serializable
/*    */ {
/*    */   @NotNull
/*    */   private final File inputFile;
/*    */   @NotNull
/*    */   private final File outputFile;
/*    */   
/*    */   @Inject
/*    */   public AttrExtractor(@NotNull File inputFile, @NotNull File outputFile)
/*    */   {
/* 33 */     this.inputFile = inputFile;this.outputFile = outputFile; } @NotNull
/* 33 */   public final File getOutputFile() { return outputFile; } @NotNull
/* 33 */   public final File getInputFile() { return inputFile; }
/*    */   
/*    */   /* Error */
/*    */   public void run()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: new 14	java/util/zip/ZipFile
/*    */     //   3: dup
/*    */     //   4: aload_0
/*    */     //   5: getfield 18	com/android/build/gradle/internal/actions/AttrExtractor:inputFile	Ljava/io/File;
/*    */     //   8: invokespecial 22	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
/*    */     //   11: checkcast 24	java/io/Closeable
/*    */     //   14: astore_2
/*    */     //   15: aconst_null
/*    */     //   16: checkcast 12	java/lang/Throwable
/*    */     //   19: astore_3
/*    */     //   20: nop
/*    */     //   21: aload_2
/*    */     //   22: checkcast 14	java/util/zip/ZipFile
/*    */     //   25: astore 4
/*    */     //   27: aload 4
/*    */     //   29: ldc 26
/*    */     //   31: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
/*    */     //   34: astore 5
/*    */     //   36: aload 5
/*    */     //   38: ifnull +56 -> 94
/*    */     //   41: aload 4
/*    */     //   43: aload 5
/*    */     //   45: invokevirtual 34	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
/*    */     //   48: dup
/*    */     //   49: ifnonnull +6 -> 55
/*    */     //   52: invokestatic 39	kotlin/jvm/internal/Intrinsics:throwNpe	()V
/*    */     //   55: astore 6
/*    */     //   57: new 41	com/android/build/gradle/internal/actions/CustomClassVisitor
/*    */     //   60: dup
/*    */     //   61: invokespecial 43	com/android/build/gradle/internal/actions/CustomClassVisitor:<init>	()V
/*    */     //   64: astore 7
/*    */     //   66: new 45	org/objectweb/asm/ClassReader
/*    */     //   69: dup
/*    */     //   70: aload 6
/*    */     //   72: invokespecial 48	org/objectweb/asm/ClassReader:<init>	(Ljava/io/InputStream;)V
/*    */     //   75: aload 7
/*    */     //   77: checkcast 50	org/objectweb/asm/ClassVisitor
/*    */     //   80: iconst_0
/*    */     //   81: invokevirtual 54	org/objectweb/asm/ClassReader:accept	(Lorg/objectweb/asm/ClassVisitor;I)V
/*    */     //   84: aload 7
/*    */     //   86: invokevirtual 58	com/android/build/gradle/internal/actions/CustomClassVisitor:getAttributes	()Ljava/util/List;
/*    */     //   89: astore 8
/*    */     //   91: goto +9 -> 100
/*    */     //   94: aconst_null
/*    */     //   95: checkcast 60	java/util/List
/*    */     //   98: astore 8
/*    */     //   100: aload 8
/*    */     //   102: nop
/*    */     //   103: astore 4
/*    */     //   105: aload_2
/*    */     //   106: aload_3
/*    */     //   107: invokestatic 66	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
/*    */     //   110: aload 4
/*    */     //   112: goto +21 -> 133
/*    */     //   115: astore 4
/*    */     //   117: aload 4
/*    */     //   119: astore_3
/*    */     //   120: aload 4
/*    */     //   122: athrow
/*    */     //   123: astore 4
/*    */     //   125: aload_2
/*    */     //   126: aload_3
/*    */     //   127: invokestatic 66	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
/*    */     //   130: aload 4
/*    */     //   132: athrow
/*    */     //   133: astore_1
/*    */     //   134: new 68	java/io/FileWriter
/*    */     //   137: dup
/*    */     //   138: aload_0
/*    */     //   139: getfield 71	com/android/build/gradle/internal/actions/AttrExtractor:outputFile	Ljava/io/File;
/*    */     //   142: invokespecial 72	java/io/FileWriter:<init>	(Ljava/io/File;)V
/*    */     //   145: checkcast 24	java/io/Closeable
/*    */     //   148: astore_2
/*    */     //   149: aconst_null
/*    */     //   150: checkcast 12	java/lang/Throwable
/*    */     //   153: astore_3
/*    */     //   154: nop
/*    */     //   155: aload_2
/*    */     //   156: checkcast 68	java/io/FileWriter
/*    */     //   159: astore 4
/*    */     //   161: aload_1
/*    */     //   162: ifnull +141 -> 303
/*    */     //   165: aload_1
/*    */     //   166: invokeinterface 76 1 0
/*    */     //   171: astore 5
/*    */     //   173: aload 5
/*    */     //   175: invokeinterface 82 1 0
/*    */     //   180: ifeq +123 -> 303
/*    */     //   183: aload 5
/*    */     //   185: invokeinterface 86 1 0
/*    */     //   190: checkcast 88	com/android/build/gradle/internal/actions/AttributeValue
/*    */     //   193: astore 6
/*    */     //   195: aload 6
/*    */     //   197: invokevirtual 92	com/android/build/gradle/internal/actions/AttributeValue:component1	()Ljava/lang/String;
/*    */     //   200: astore 7
/*    */     //   202: aload 6
/*    */     //   204: invokevirtual 96	com/android/build/gradle/internal/actions/AttributeValue:component2	()I
/*    */     //   207: istore 8
/*    */     //   209: aload 4
/*    */     //   211: new 98	java/lang/StringBuilder
/*    */     //   214: dup
/*    */     //   215: invokespecial 99	java/lang/StringBuilder:<init>	()V
/*    */     //   218: ldc 101
/*    */     //   220: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   223: aload 7
/*    */     //   225: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   228: ldc 107
/*    */     //   230: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   233: getstatic 113	kotlin/jvm/internal/StringCompanionObject:INSTANCE	Lkotlin/jvm/internal/StringCompanionObject;
/*    */     //   236: astore 9
/*    */     //   238: ldc 115
/*    */     //   240: astore 10
/*    */     //   242: iconst_1
/*    */     //   243: anewarray 4	java/lang/Object
/*    */     //   246: dup
/*    */     //   247: iconst_0
/*    */     //   248: iload 8
/*    */     //   250: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*    */     //   253: aastore
/*    */     //   254: astore 11
/*    */     //   256: astore 12
/*    */     //   258: astore 13
/*    */     //   260: aload 10
/*    */     //   262: aload 11
/*    */     //   264: dup
/*    */     //   265: arraylength
/*    */     //   266: invokestatic 127	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
/*    */     //   269: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*    */     //   272: dup
/*    */     //   273: ldc -121
/*    */     //   275: invokestatic 139	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   278: astore 14
/*    */     //   280: aload 13
/*    */     //   282: aload 12
/*    */     //   284: aload 14
/*    */     //   286: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   289: bipush 10
/*    */     //   291: invokevirtual 142	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
/*    */     //   294: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*    */     //   297: invokevirtual 149	java/io/FileWriter:write	(Ljava/lang/String;)V
/*    */     //   300: goto -127 -> 173
/*    */     //   303: getstatic 154	kotlin/Unit:INSTANCE	Lkotlin/Unit;
/*    */     //   306: astore 4
/*    */     //   308: aload_2
/*    */     //   309: aload_3
/*    */     //   310: invokestatic 66	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
/*    */     //   313: goto +21 -> 334
/*    */     //   316: astore 4
/*    */     //   318: aload 4
/*    */     //   320: astore_3
/*    */     //   321: aload 4
/*    */     //   323: athrow
/*    */     //   324: astore 4
/*    */     //   326: aload_2
/*    */     //   327: aload_3
/*    */     //   328: invokestatic 66	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
/*    */     //   331: aload 4
/*    */     //   333: athrow
/*    */     //   334: return
/*    */     // Line number table:
/*    */     //   Java source line #36	-> byte code offset #0
/*    */     //   Java source line #37	-> byte code offset #27
/*    */     //   Java source line #39	-> byte code offset #36
/*    */     //   Java source line #41	-> byte code offset #36
/*    */     //   Java source line #42	-> byte code offset #41
/*    */     //   Java source line #44	-> byte code offset #57
/*    */     //   Java source line #45	-> byte code offset #66
/*    */     //   Java source line #47	-> byte code offset #84
/*    */     //   Java source line #49	-> byte code offset #94
/*    */     //   Java source line #50	-> byte code offset #100
/*    */     //   Java source line #53	-> byte code offset #100
/*    */     //   Java source line #36	-> byte code offset #103
/*    */     //   Java source line #36	-> byte code offset #133
/*    */     //   Java source line #56	-> byte code offset #134
/*    */     //   Java source line #57	-> byte code offset #161
/*    */     //   Java source line #58	-> byte code offset #165
/*    */     //   Java source line #59	-> byte code offset #209
/*    */     //   Java source line #59	-> byte code offset #297
/*    */     //   Java source line #58	-> byte code offset #300
/*    */     //   Java source line #62	-> byte code offset #303
/*    */     //   Java source line #56	-> byte code offset #306
/*    */     //   Java source line #63	-> byte code offset #334
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	335	0	this	AttrExtractor
/*    */     //   134	201	1	attributes	java.util.List
/*    */     //   27	76	4	zip	java.util.zip.ZipFile
/*    */     //   161	142	4	writer	java.io.FileWriter
/*    */     //   36	66	5	entry	java.util.zip.ZipEntry
/*    */     //   57	34	6	stream	java.io.InputStream
/*    */     //   66	25	7	customClassVisitor	CustomClassVisitor
/*    */     //   195	105	7	name	String
/*    */     //   36	66	8	result	java.util.List
/*    */     //   195	105	8	value	int
/*    */     //   27	76	9	$i$a$1$use	int
/*    */     //   161	142	15	$i$a$1$use	int
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   20	105	115	java/lang/Throwable
/*    */     //   20	105	123	finally
/*    */     //   115	123	123	finally
/*    */     //   123	125	123	finally
/*    */     //   154	308	316	java/lang/Throwable
/*    */     //   154	308	324	finally
/*    */     //   316	324	324	finally
/*    */     //   324	326	324	finally
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.actions.AttrExtractor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */