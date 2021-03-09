/*     */ package com.android.build.gradle.internal.api.dsl.sealing;
/*     */ 
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import java.util.Collection;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.CollectionToArray;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.markers.KMutableCollection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000N\n\002\030\002\n\002\b\002\n\002\020\037\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\b\n\002\020\b\n\002\b\003\n\002\020\013\n\002\b\004\n\002\020\036\n\000\n\002\020\002\n\002\b\005\n\002\020)\n\002\b\b\b&\030\000*\004\b\000\020\001*\016\b\001\020\002*\b\022\004\022\002H\0010\0032\0020\0042\b\022\004\022\002H\0010\003B;\b\004\022\b\020\005\032\004\030\0018\001\022\f\020\006\032\b\022\004\022\0028\0010\007\022\022\020\b\032\016\022\004\022\0028\001\022\004\022\0028\0010\t\022\006\020\n\032\0020\013¢\006\002\020\fJ\025\020\027\032\0020\0302\006\020\031\032\0028\000H\026¢\006\002\020\032J\026\020\033\032\0020\0302\f\020\034\032\b\022\004\022\0028\0000\035H\026J\b\020\036\032\0020\037H\026J\026\020 \032\0020\0302\006\020\031\032\0028\000H\002¢\006\002\020\032J\026\020!\032\0020\0302\f\020\034\032\b\022\004\022\0028\0000\035H\026J\r\020\"\032\0028\001H\004¢\006\002\020\017J\b\020#\032\0020\030H\026J\017\020$\032\b\022\004\022\0028\0000%H\002J\025\020&\032\0020\0302\006\020\031\032\0028\000H\026¢\006\002\020\032J\026\020'\032\0020\0302\f\020\034\032\b\022\004\022\0028\0000\035H\026J\027\020(\032\0028\0012\006\020)\032\0028\001H\000¢\006\004\b*\020+J\026\020,\032\0020\0302\f\020\034\032\b\022\004\022\0028\0000\035H\026R\032\020\b\032\016\022\004\022\0028\001\022\004\022\0028\0010\tX\004¢\006\002\n\000R\024\020\006\032\b\022\004\022\0028\0010\007X\004¢\006\002\n\000R\036\020\r\032\004\030\0018\001X\016¢\006\020\n\002\020\022\032\004\b\016\020\017\"\004\b\020\020\021R\024\020\023\032\0020\0248VX\004¢\006\006\032\004\b\025\020\026¨\006-"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection;", "T", "C", "", "Lcom/android/build/gradle/internal/api/dsl/sealing/NestedSealable;", "originCollection", "instantiator", "Lkotlin/Function0;", "cloner", "Lkotlin/Function1;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/android/builder/errors/EvalIssueReporter;)V", "internalCollection", "getInternalCollection", "()Ljava/util/Collection;", "setInternalCollection", "(Ljava/util/Collection;)V", "Ljava/util/Collection;", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "getBackingCollection", "isEmpty", "iterator", "", "remove", "removeAll", "reset", "newCollectionToWrap", "reset$gradle_core", "(Ljava/util/Collection;)Ljava/util/Collection;", "retainAll", "gradle-core"})
/*     */ public abstract class AbstractSealableCollection<T, C extends Collection<T>>
/*     */   extends NestedSealable
/*     */   implements Collection<T>, KMutableCollection
/*     */ {
/*     */   @Nullable
/*     */   private C internalCollection;
/*     */   private final Function0<C> instantiator;
/*     */   private final Function1<C, C> cloner;
/*     */   
/*     */   @Nullable
/*  46 */   protected final C getInternalCollection() { return internalCollection; } protected final void setInternalCollection(@Nullable C <set-?>) { internalCollection = <set-?>; }
/*     */   
/*     */   protected AbstractSealableCollection(@Nullable C originCollection, @NotNull Function0<? extends C> instantiator, @NotNull Function1<? super C, ? extends C> cloner, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  39 */     super(issueReporter);this.instantiator = instantiator;this.cloner = cloner;
/*     */     
/*  46 */     internalCollection = (originCollection == null ? originCollection : (Collection)this.cloner.invoke(
/*  47 */       originCollection));
/*     */   }
/*     */   
/*     */   public boolean add(T element)
/*     */   {
/*  60 */     if (checkSeal()) {
/*  61 */       return getBackingCollection().add(element);
/*     */     }
/*     */     
/*  64 */     return false;
/*     */   }
/*     */   
/*     */   public boolean addAll(@NotNull Collection<? extends T> elements) {
/*  68 */     Intrinsics.checkParameterIsNotNull(elements, "elements"); if (checkSeal()) {
/*  69 */       return getBackingCollection().addAll(elements);
/*     */     }
/*     */     
/*  72 */     return false;
/*     */   }
/*     */   
/*     */   public boolean remove(Object element) {
/*  76 */     if (checkSeal()) {
/*  77 */       return getBackingCollection().remove(element);
/*     */     }
/*     */     
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public boolean removeAll(@NotNull Collection<? extends Object> elements) {
/*  84 */     Intrinsics.checkParameterIsNotNull(elements, "elements"); if (checkSeal()) {
/*  85 */       return getBackingCollection().removeAll(elements);
/*     */     }
/*     */     
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public boolean retainAll(@NotNull Collection<? extends Object> elements) {
/*  92 */     Intrinsics.checkParameterIsNotNull(elements, "elements"); if (checkSeal()) {
/*  93 */       return getBackingCollection().retainAll(elements);
/*     */     }
/*     */     
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final C reset$gradle_core(@NotNull C newCollectionToWrap)
/*     */   {
/* 118 */     Intrinsics.checkParameterIsNotNull(newCollectionToWrap, "newCollectionToWrap"); if (checkSeal()) {
/* 119 */       internalCollection = ((Collection)cloner.invoke(newCollectionToWrap));
/*     */     }
/*     */     
/* 123 */     if (this == null) throw new TypeCastException("null cannot be cast to non-null type C"); return (Collection)this;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   protected final C getBackingCollection()
/*     */   {
/* 132 */     if (internalCollection == null) {
/* 133 */       internalCollection = ((Collection)instantiator.invoke());
/*     */     }
/*     */     
/* 137 */     Collection tmp27_24 = internalCollection;
/*     */     
/* 137 */     if (tmp27_24 == null) Intrinsics.throwNpe(); return tmp27_24;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int getSize()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 17	com/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection:internalCollection	Ljava/util/Collection;
/*     */     //   4: dup
/*     */     //   5: ifnull +11 -> 16
/*     */     //   8: invokeinterface 29 1 0
/*     */     //   13: goto +5 -> 18
/*     */     //   16: pop
/*     */     //   17: iconst_0
/*     */     //   18: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #50	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	19	0	this	AbstractSealableCollection
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public boolean contains(Object element)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 17	com/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection:internalCollection	Ljava/util/Collection;
/*     */     //   4: dup
/*     */     //   5: ifnull +12 -> 17
/*     */     //   8: aload_1
/*     */     //   9: invokeinterface 33 2 0
/*     */     //   14: goto +5 -> 19
/*     */     //   17: pop
/*     */     //   18: iconst_0
/*     */     //   19: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #52	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	20	0	this	AbstractSealableCollection
/*     */     //   0	20	1	element	Object
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public boolean containsAll(@NotNull Collection<? extends Object> elements)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 40
/*     */     //   3: invokestatic 46	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_0
/*     */     //   7: getfield 17	com/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection:internalCollection	Ljava/util/Collection;
/*     */     //   10: dup
/*     */     //   11: ifnull +12 -> 23
/*     */     //   14: aload_1
/*     */     //   15: invokeinterface 48 2 0
/*     */     //   20: goto +5 -> 25
/*     */     //   23: pop
/*     */     //   24: iconst_0
/*     */     //   25: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #55	-> byte code offset #6
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	26	0	this	AbstractSealableCollection
/*     */     //   0	26	1	elements	Collection
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public boolean isEmpty()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 17	com/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection:internalCollection	Ljava/util/Collection;
/*     */     //   4: dup
/*     */     //   5: ifnull +11 -> 16
/*     */     //   8: invokeinterface 52 1 0
/*     */     //   13: goto +5 -> 18
/*     */     //   16: pop
/*     */     //   17: iconst_1
/*     */     //   18: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #57	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	19	0	this	AbstractSealableCollection
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void clear()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual 56	com/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection:checkSeal	()Z
/*     */     //   4: ifeq +20 -> 24
/*     */     //   7: aload_0
/*     */     //   8: getfield 17	com/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection:internalCollection	Ljava/util/Collection;
/*     */     //   11: dup
/*     */     //   12: ifnull +11 -> 23
/*     */     //   15: invokeinterface 77 1 0
/*     */     //   20: goto +4 -> 24
/*     */     //   23: pop
/*     */     //   24: return
/*     */     // Line number table:
/*     */     //   Java source line #100	-> byte code offset #0
/*     */     //   Java source line #101	-> byte code offset #7
/*     */     //   Java source line #103	-> byte code offset #24
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	25	0	this	AbstractSealableCollection
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @NotNull
/*     */   public java.util.Iterator<T> iterator()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 17	com/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection:internalCollection	Ljava/util/Collection;
/*     */     //   4: dup
/*     */     //   5: ifnull +6 -> 11
/*     */     //   8: goto +20 -> 28
/*     */     //   11: pop
/*     */     //   12: invokestatic 85	com/google/common/collect/ImmutableList:of	()Lcom/google/common/collect/ImmutableList;
/*     */     //   15: invokevirtual 88	com/google/common/collect/ImmutableList:iterator	()Lcom/google/common/collect/UnmodifiableIterator;
/*     */     //   18: dup
/*     */     //   19: ldc 90
/*     */     //   21: invokestatic 93	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   24: checkcast 95	java/util/Iterator
/*     */     //   27: areturn
/*     */     //   28: astore_1
/*     */     //   29: aload_0
/*     */     //   30: new 97	com/android/build/gradle/internal/api/dsl/sealing/SealableMutableIterator
/*     */     //   33: dup
/*     */     //   34: aload_1
/*     */     //   35: invokeinterface 99 1 0
/*     */     //   40: aload_0
/*     */     //   41: invokevirtual 103	com/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection:getIssueReporter	()Lcom/android/builder/errors/EvalIssueReporter;
/*     */     //   44: invokespecial 107	com/android/build/gradle/internal/api/dsl/sealing/SealableMutableIterator:<init>	(Ljava/util/Iterator;Lcom/android/builder/errors/EvalIssueReporter;)V
/*     */     //   47: checkcast 109	com/android/build/gradle/internal/api/dsl/sealing/SealableObject
/*     */     //   50: invokevirtual 113	com/android/build/gradle/internal/api/dsl/sealing/AbstractSealableCollection:handleSealableSubItem	(Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;)Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;
/*     */     //   53: checkcast 95	java/util/Iterator
/*     */     //   56: areturn
/*     */     // Line number table:
/*     */     //   Java source line #108	-> byte code offset #0
/*     */     //   Java source line #110	-> byte code offset #29
/*     */     //   Java source line #111	-> byte code offset #30
/*     */     //   Java source line #110	-> byte code offset #50
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	57	0	this	AbstractSealableCollection
/*     */     //   29	28	1	finalCollection	Collection
/*     */   }
/*     */   
/*     */   public Object[] toArray()
/*     */   {
/*     */     return CollectionToArray.toArray(this);
/*     */   }
/*     */   
/*     */   public <T> T[] toArray(T[] paramArrayOfT)
/*     */   {
/*     */     return CollectionToArray.toArray(this, paramArrayOfT);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.AbstractSealableCollection
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */