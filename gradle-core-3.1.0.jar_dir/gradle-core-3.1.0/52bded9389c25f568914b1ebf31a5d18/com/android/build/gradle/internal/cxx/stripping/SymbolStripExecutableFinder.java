/*    */ package com.android.build.gradle.internal.cxx.stripping;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.Abi;
/*    */ import java.io.File;
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000,\n\002\030\002\n\002\020\000\n\000\n\002\020$\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\036\n\002\b\004\n\002\030\002\n\002\020\016\n\000\030\0002\0020\001B\031\022\022\020\002\032\016\022\004\022\0020\004\022\004\022\0020\0050\003¢\006\002\020\006J\f\020\007\032\b\022\004\022\0020\0050\bJ0\020\t\032\004\030\0010\0052\006\020\n\032\0020\0052\b\020\013\032\004\030\0010\0042\024\020\f\032\020\022\004\022\0020\016\022\006\022\004\030\0010\0050\rR\032\020\002\032\016\022\004\022\0020\004\022\004\022\0020\0050\003X\004¢\006\002\n\000¨\006\017"}, d2={"Lcom/android/build/gradle/internal/cxx/stripping/SymbolStripExecutableFinder;", "", "stripExecutables", "", "Lcom/android/build/gradle/internal/core/Abi;", "Ljava/io/File;", "(Ljava/util/Map;)V", "executables", "", "stripToolExecutableFile", "input", "abi", "reportAndFallback", "Lkotlin/Function1;", "", "gradle-core"})
/*    */ public final class SymbolStripExecutableFinder
/*    */ {
/*    */   private final Map<Abi, File> stripExecutables;
/*    */   
/*    */   public SymbolStripExecutableFinder(@NotNull Map<Abi, ? extends File> stripExecutables)
/*    */   {
/* 26 */     this.stripExecutables = stripExecutables;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   @org.jetbrains.annotations.Nullable
/*    */   public final File stripToolExecutableFile(@NotNull File input, @org.jetbrains.annotations.Nullable Abi abi, @NotNull kotlin.jvm.functions.Function1<? super String, ? extends File> reportAndFallback)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 23
/*    */     //   3: invokestatic 29	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_3
/*    */     //   7: ldc 31
/*    */     //   9: invokestatic 29	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   12: aload_2
/*    */     //   13: ifnonnull +45 -> 58
/*    */     //   16: aload_3
/*    */     //   17: new 33	java/lang/StringBuilder
/*    */     //   20: dup
/*    */     //   21: invokespecial 37	java/lang/StringBuilder:<init>	()V
/*    */     //   24: ldc 39
/*    */     //   26: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   29: aload_1
/*    */     //   30: invokevirtual 49	java/io/File:getAbsolutePath	()Ljava/lang/String;
/*    */     //   33: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   36: ldc 51
/*    */     //   38: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   41: ldc 53
/*    */     //   43: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   46: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*    */     //   49: invokeinterface 62 2 0
/*    */     //   54: checkcast 45	java/io/File
/*    */     //   57: areturn
/*    */     //   58: aload_0
/*    */     //   59: getfield 11	com/android/build/gradle/internal/cxx/stripping/SymbolStripExecutableFinder:stripExecutables	Ljava/util/Map;
/*    */     //   62: aload_2
/*    */     //   63: invokeinterface 65 2 0
/*    */     //   68: checkcast 45	java/io/File
/*    */     //   71: dup
/*    */     //   72: ifnull +6 -> 78
/*    */     //   75: goto +55 -> 130
/*    */     //   78: pop
/*    */     //   79: aload_3
/*    */     //   80: new 33	java/lang/StringBuilder
/*    */     //   83: dup
/*    */     //   84: invokespecial 37	java/lang/StringBuilder:<init>	()V
/*    */     //   87: ldc 39
/*    */     //   89: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   92: aload_1
/*    */     //   93: invokevirtual 49	java/io/File:getAbsolutePath	()Ljava/lang/String;
/*    */     //   96: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   99: ldc 67
/*    */     //   101: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   104: ldc 69
/*    */     //   106: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   109: aload_2
/*    */     //   110: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   113: ldc 74
/*    */     //   115: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   118: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*    */     //   121: invokeinterface 62 2 0
/*    */     //   126: checkcast 45	java/io/File
/*    */     //   129: areturn
/*    */     //   130: areturn
/*    */     // Line number table:
/*    */     //   Java source line #45	-> byte code offset #12
/*    */     //   Java source line #46	-> byte code offset #16
/*    */     //   Java source line #49	-> byte code offset #58
/*    */     //   Java source line #50	-> byte code offset #79
/*    */     //   Java source line #51	-> byte code offset #80
/*    */     //   Java source line #52	-> byte code offset #109
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	131	0	this	SymbolStripExecutableFinder
/*    */     //   0	131	1	input	File
/*    */     //   0	131	2	abi	Abi
/*    */     //   0	131	3	reportAndFallback	kotlin.jvm.functions.Function1
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final Collection<File> executables()
/*    */   {
/* 32 */     return stripExecutables.values();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.cxx.stripping.SymbolStripExecutableFinder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */