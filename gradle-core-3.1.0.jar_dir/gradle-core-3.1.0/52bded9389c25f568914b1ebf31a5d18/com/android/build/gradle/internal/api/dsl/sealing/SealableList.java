/*     */ package com.android.build.gradle.internal.api.dsl.sealing;
/*     */ 
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.jvm.internal.markers.KMutableList;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000J\n\002\030\002\n\000\n\002\030\002\n\002\020!\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\b\n\002\b\003\n\002\020\013\n\000\n\002\020\036\n\002\b\006\n\002\020+\n\002\b\b\030\000 #*\004\b\000\020\0012\024\022\004\022\002H\001\022\n\022\b\022\004\022\002H\0010\0030\0022\b\022\004\022\002H\0010\003:\001#BS\b\002\022\016\020\004\032\n\022\004\022\0028\000\030\0010\003\022\022\020\005\032\016\022\n\022\b\022\004\022\0028\0000\0030\006\022\036\020\007\032\032\022\n\022\b\022\004\022\0028\0000\003\022\n\022\b\022\004\022\0028\0000\0030\b\022\006\020\t\032\0020\n¢\006\002\020\013J\035\020\f\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0028\000H\026¢\006\002\020\021J\036\020\022\032\0020\0232\006\020\016\032\0020\0172\f\020\024\032\b\022\004\022\0028\0000\025H\026J\026\020\026\032\0028\0002\006\020\016\032\0020\017H\002¢\006\002\020\027J\025\020\030\032\0020\0172\006\020\020\032\0028\000H\026¢\006\002\020\031J\025\020\032\032\0020\0172\006\020\020\032\0028\000H\026¢\006\002\020\031J\016\020\033\032\b\022\004\022\0028\0000\034H\026J\026\020\033\032\b\022\004\022\0028\0000\0342\006\020\016\032\0020\017H\026J\025\020\035\032\0028\0002\006\020\016\032\0020\017H\026¢\006\002\020\027J\036\020\036\032\0028\0002\006\020\016\032\0020\0172\006\020\020\032\0028\000H\002¢\006\002\020\037J\036\020 \032\b\022\004\022\0028\0000\0032\006\020!\032\0020\0172\006\020\"\032\0020\017H\026¨\006$"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/SealableList;", "T", "Lcom/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection;", "", "wrappedList", "instantiator", "Lkotlin/Function0;", "cloner", "Lkotlin/Function1;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/android/builder/errors/EvalIssueReporter;)V", "add", "", "index", "", "element", "(ILjava/lang/Object;)V", "addAll", "", "elements", "", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "listIterator", "", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "Companion", "gradle-core"})
/*     */ public final class SealableList<T>
/*     */   extends AbstractSealableCollection<T, List<T>>
/*     */   implements List<T>, KMutableList
/*     */ {
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*     */   private SealableList(List<T> wrappedList, Function0<? extends List<T>> instantiator, Function1<? super List<T>, ? extends List<T>> cloner, EvalIssueReporter issueReporter)
/*     */   {
/*  43 */     super(
/*  44 */       (Collection)wrappedList, 
/*  45 */       instantiator, 
/*  46 */       cloner, 
/*  47 */       issueReporter);
/*     */   }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020!\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\032\020\003\032\b\022\004\022\002H\0050\004\"\004\b\001\020\0052\006\020\006\032\0020\007J(\020\b\032\b\022\004\022\002H\0050\004\"\004\b\001\020\0052\f\020\t\032\b\022\004\022\002H\0050\n2\006\020\006\032\0020\007¨\006\013"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/SealableList$Companion;", "", "()V", "new", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableList;", "T", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "wrap", "wrappedList", "", "gradle-core"})
/*     */   public static final class Companion { @NotNull
/*  52 */     public final <T> SealableList<T> wrap(@NotNull List<T> wrappedList, @NotNull EvalIssueReporter issueReporter) { Intrinsics.checkParameterIsNotNull(wrappedList, "wrappedList");Intrinsics.checkParameterIsNotNull(issueReporter, "issueReporter");
/*     */       
/*  56 */       return new SealableList(wrappedList, (Function0)wrap.1.INSTANCE, (Function1)wrap.2.INSTANCE, issueReporter, null); }
/*     */     @NotNull
/*  58 */     public final <T> SealableList<T> jdMethod_new(@NotNull EvalIssueReporter issueReporter) { Intrinsics.checkParameterIsNotNull(issueReporter, "issueReporter");
/*     */       
/*  62 */       return new SealableList(null, (Function0)new.1.INSTANCE, (Function1)new.2.INSTANCE, issueReporter, null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void add(int index, T element)
/*     */   {
/*  72 */     if (checkSeal()) {
/*  73 */       ((List)getBackingCollection()).add(index, element);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean addAll(int index, @NotNull Collection<? extends T> elements) {
/*  78 */     Intrinsics.checkParameterIsNotNull(elements, "elements"); if (checkSeal()) {
/*  79 */       return ((List)getBackingCollection()).addAll(index, elements);
/*     */     }
/*     */     
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public T removeAt(int index)
/*     */   {
/* 104 */     if (checkSeal()) {
/* 105 */       return (T)((List)getBackingCollection()).remove(index);
/*     */     }
/*     */     
/* 110 */     return (T)((List)getBackingCollection()).get(index);
/*     */   }
/*     */   
/*     */   public T set(int index, T element) {
/* 114 */     if (checkSeal()) {
/* 115 */       return (T)((List)getBackingCollection()).set(index, element);
/*     */     }
/*     */     
/* 118 */     return (T)element;
/*     */   }
/*     */   
/*     */   @NotNull
/* 122 */   public List<T> subList(int fromIndex, int toIndex) { if (checkSeal())
/*     */     {
/* 124 */       return (List)Companion.jdMethod_new(getIssueReporter()).reset$gradle_core((Collection)((List)getBackingCollection()).subList(fromIndex, toIndex));
/*     */     }
/*     */     
/* 129 */     return (List)new ArrayList();
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public T get(int index)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual 15	com/android/build/gradle/internal/api/dsl/sealing/SealableList:getInternalCollection	()Ljava/util/Collection;
/*     */     //   4: checkcast 7	java/util/List
/*     */     //   7: dup
/*     */     //   8: ifnull +16 -> 24
/*     */     //   11: iload_1
/*     */     //   12: invokeinterface 17 2 0
/*     */     //   17: dup
/*     */     //   18: ifnull +6 -> 24
/*     */     //   21: goto +16 -> 37
/*     */     //   24: pop
/*     */     //   25: new 19	java/lang/ArrayIndexOutOfBoundsException
/*     */     //   28: dup
/*     */     //   29: iload_1
/*     */     //   30: invokespecial 23	java/lang/ArrayIndexOutOfBoundsException:<init>	(I)V
/*     */     //   33: checkcast 25	java/lang/Throwable
/*     */     //   36: athrow
/*     */     //   37: areturn
/*     */     // Line number table:
/*     */     //   Java source line #65	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	38	0	this	SealableList
/*     */     //   0	38	1	index	int
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int indexOf(Object element)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual 15	com/android/build/gradle/internal/api/dsl/sealing/SealableList:getInternalCollection	()Ljava/util/Collection;
/*     */     //   4: checkcast 7	java/util/List
/*     */     //   7: dup
/*     */     //   8: ifnull +12 -> 20
/*     */     //   11: aload_1
/*     */     //   12: invokeinterface 35 2 0
/*     */     //   17: goto +5 -> 22
/*     */     //   20: pop
/*     */     //   21: iconst_m1
/*     */     //   22: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #67	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	23	0	this	SealableList
/*     */     //   0	23	1	element	Object
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int lastIndexOf(Object element)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual 15	com/android/build/gradle/internal/api/dsl/sealing/SealableList:getInternalCollection	()Ljava/util/Collection;
/*     */     //   4: checkcast 7	java/util/List
/*     */     //   7: dup
/*     */     //   8: ifnull +12 -> 20
/*     */     //   11: aload_1
/*     */     //   12: invokeinterface 40 2 0
/*     */     //   17: goto +5 -> 22
/*     */     //   20: pop
/*     */     //   21: iconst_m1
/*     */     //   22: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #69	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	23	0	this	SealableList
/*     */     //   0	23	1	element	Object
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @NotNull
/*     */   public java.util.ListIterator<T> listIterator()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual 15	com/android/build/gradle/internal/api/dsl/sealing/SealableList:getInternalCollection	()Ljava/util/Collection;
/*     */     //   4: checkcast 7	java/util/List
/*     */     //   7: dup
/*     */     //   8: ifnull +6 -> 14
/*     */     //   11: goto +20 -> 31
/*     */     //   14: pop
/*     */     //   15: invokestatic 73	com/google/common/collect/ImmutableList:of	()Lcom/google/common/collect/ImmutableList;
/*     */     //   18: invokevirtual 76	com/google/common/collect/ImmutableList:listIterator	()Lcom/google/common/collect/UnmodifiableListIterator;
/*     */     //   21: dup
/*     */     //   22: ldc 78
/*     */     //   24: invokestatic 81	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   27: checkcast 83	java/util/ListIterator
/*     */     //   30: areturn
/*     */     //   31: astore_1
/*     */     //   32: aload_0
/*     */     //   33: new 85	com/android/build/gradle/internal/api/dsl/sealing/SealableMutableListIterator
/*     */     //   36: dup
/*     */     //   37: aload_1
/*     */     //   38: invokeinterface 87 1 0
/*     */     //   43: aload_0
/*     */     //   44: invokevirtual 91	com/android/build/gradle/internal/api/dsl/sealing/SealableList:getIssueReporter	()Lcom/android/builder/errors/EvalIssueReporter;
/*     */     //   47: invokespecial 94	com/android/build/gradle/internal/api/dsl/sealing/SealableMutableListIterator:<init>	(Ljava/util/ListIterator;Lcom/android/builder/errors/EvalIssueReporter;)V
/*     */     //   50: checkcast 96	com/android/build/gradle/internal/api/dsl/sealing/SealableObject
/*     */     //   53: invokevirtual 100	com/android/build/gradle/internal/api/dsl/sealing/SealableList:handleSealableSubItem	(Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;)Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;
/*     */     //   56: checkcast 83	java/util/ListIterator
/*     */     //   59: areturn
/*     */     // Line number table:
/*     */     //   Java source line #88	-> byte code offset #0
/*     */     //   Java source line #90	-> byte code offset #32
/*     */     //   Java source line #91	-> byte code offset #33
/*     */     //   Java source line #90	-> byte code offset #53
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	60	0	this	SealableList
/*     */     //   32	28	1	finalCollection	List
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @NotNull
/*     */   public java.util.ListIterator<T> listIterator(int index)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual 15	com/android/build/gradle/internal/api/dsl/sealing/SealableList:getInternalCollection	()Ljava/util/Collection;
/*     */     //   4: checkcast 7	java/util/List
/*     */     //   7: dup
/*     */     //   8: ifnull +6 -> 14
/*     */     //   11: goto +21 -> 32
/*     */     //   14: pop
/*     */     //   15: invokestatic 73	com/google/common/collect/ImmutableList:of	()Lcom/google/common/collect/ImmutableList;
/*     */     //   18: iload_1
/*     */     //   19: invokevirtual 106	com/google/common/collect/ImmutableList:listIterator	(I)Lcom/google/common/collect/UnmodifiableListIterator;
/*     */     //   22: dup
/*     */     //   23: ldc 108
/*     */     //   25: invokestatic 81	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   28: checkcast 83	java/util/ListIterator
/*     */     //   31: areturn
/*     */     //   32: astore_2
/*     */     //   33: aload_0
/*     */     //   34: new 85	com/android/build/gradle/internal/api/dsl/sealing/SealableMutableListIterator
/*     */     //   37: dup
/*     */     //   38: aload_2
/*     */     //   39: iload_1
/*     */     //   40: invokeinterface 110 2 0
/*     */     //   45: aload_0
/*     */     //   46: invokevirtual 91	com/android/build/gradle/internal/api/dsl/sealing/SealableList:getIssueReporter	()Lcom/android/builder/errors/EvalIssueReporter;
/*     */     //   49: invokespecial 94	com/android/build/gradle/internal/api/dsl/sealing/SealableMutableListIterator:<init>	(Ljava/util/ListIterator;Lcom/android/builder/errors/EvalIssueReporter;)V
/*     */     //   52: checkcast 96	com/android/build/gradle/internal/api/dsl/sealing/SealableObject
/*     */     //   55: invokevirtual 100	com/android/build/gradle/internal/api/dsl/sealing/SealableList:handleSealableSubItem	(Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;)Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;
/*     */     //   58: checkcast 83	java/util/ListIterator
/*     */     //   61: areturn
/*     */     // Line number table:
/*     */     //   Java source line #97	-> byte code offset #0
/*     */     //   Java source line #99	-> byte code offset #33
/*     */     //   Java source line #100	-> byte code offset #34
/*     */     //   Java source line #99	-> byte code offset #55
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	62	0	this	SealableList
/*     */     //   0	62	1	index	int
/*     */     //   33	29	2	finalCollection	List
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableList
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */