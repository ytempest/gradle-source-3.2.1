/*     */ package com.android.build.gradle.internal.api.dsl.sealing;
/*     */ 
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.jvm.internal.markers.KMutableMap;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000Z\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020%\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020#\n\002\020'\n\002\b\006\n\002\020\b\n\002\b\003\n\002\020\037\n\002\b\003\n\002\020\002\n\000\n\002\020\013\n\002\b\f\n\002\020$\n\002\b\006\030\000 2*\004\b\000\020\001*\004\b\001\020\0022\0020\0032\016\022\004\022\002H\001\022\004\022\002H\0020\004:\0012Bk\b\002\022\024\020\005\032\020\022\004\022\0028\000\022\004\022\0028\001\030\0010\004\022\030\020\006\032\024\022\020\022\016\022\004\022\0028\000\022\004\022\0028\0010\0040\007\022*\020\b\032&\022\020\022\016\022\004\022\0028\000\022\004\022\0028\0010\004\022\020\022\016\022\004\022\0028\000\022\004\022\0028\0010\0040\t\022\006\020\n\032\0020\013¢\006\002\020\fJ\b\020\035\032\0020\036H\026J\025\020\037\032\0020 2\006\020!\032\0028\000H\026¢\006\002\020\"J\025\020#\032\0020 2\006\020$\032\0028\001H\026¢\006\002\020\"J\030\020%\032\004\030\0018\0012\006\020!\032\0028\000H\002¢\006\002\020&J\024\020'\032\016\022\004\022\0028\000\022\004\022\0028\0010\004H\002J\b\020(\032\0020 H\026J\037\020)\032\004\030\0018\0012\006\020!\032\0028\0002\006\020$\032\0028\001H\026¢\006\002\020*J\036\020+\032\0020\0362\024\020,\032\020\022\006\b\001\022\0028\000\022\004\022\0028\0010-H\026J\027\020.\032\004\030\0018\0012\006\020!\032\0028\000H\026¢\006\002\020&J-\020/\032\016\022\004\022\0028\000\022\004\022\0028\0010\0042\022\0200\032\016\022\004\022\0028\000\022\004\022\0028\0010\004H\000¢\006\002\b1R2\020\b\032&\022\020\022\016\022\004\022\0028\000\022\004\022\0028\0010\004\022\020\022\016\022\004\022\0028\000\022\004\022\0028\0010\0040\tX\004¢\006\002\n\000R&\020\r\032\024\022\020\022\016\022\004\022\0028\000\022\004\022\0028\0010\0170\0168VX\004¢\006\006\032\004\b\020\020\021R \020\006\032\024\022\020\022\016\022\004\022\0028\000\022\004\022\0028\0010\0040\007X\004¢\006\002\n\000R\034\020\022\032\020\022\004\022\0028\000\022\004\022\0028\001\030\0010\004X\016¢\006\002\n\000R\032\020\023\032\b\022\004\022\0028\0000\0168VX\004¢\006\006\032\004\b\024\020\021R\024\020\025\032\0020\0268VX\004¢\006\006\032\004\b\027\020\030R\032\020\031\032\b\022\004\022\0028\0010\0328VX\004¢\006\006\032\004\b\033\020\034¨\0063"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/SealableMap;", "K", "V", "Lcom/android/build/gradle/internal/api/dsl/sealing/NestedSealable;", "", "originMap", "instantiator", "Lkotlin/Function0;", "cloner", "Lkotlin/Function1;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/android/builder/errors/EvalIssueReporter;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "internalMap", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrCreateMap", "isEmpty", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "reset", "newMap", "reset$gradle_core", "Companion", "gradle-core"})
/*     */ public final class SealableMap<K, V>
/*     */   extends NestedSealable
/*     */   implements Map<K, V>, KMutableMap
/*     */ {
/*     */   private Map<K, V> internalMap;
/*     */   private final Function0<Map<K, V>> instantiator;
/*     */   private final Function1<Map<K, V>, Map<K, V>> cloner;
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020%\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J&\020\003\032\016\022\004\022\002H\005\022\004\022\002H\0060\004\"\004\b\002\020\005\"\004\b\003\020\0062\006\020\007\032\0020\bJ:\020\t\032\016\022\004\022\002H\005\022\004\022\002H\0060\004\"\004\b\002\020\005\"\004\b\003\020\0062\022\020\n\032\016\022\004\022\002H\005\022\004\022\002H\0060\0132\006\020\007\032\0020\b¨\006\f"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/SealableMap$Companion;", "", "()V", "new", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableMap;", "K", "V", "errorReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "wrap", "originMap", "", "gradle-core"})
/*     */   public static final class Companion
/*     */   {
/*     */     @NotNull
/*     */     public final <K, V> SealableMap<K, V> wrap(@NotNull Map<K, V> originMap, @NotNull EvalIssueReporter errorReporter)
/*     */     {
/*  46 */       Intrinsics.checkParameterIsNotNull(originMap, "originMap");Intrinsics.checkParameterIsNotNull(errorReporter, "errorReporter");
/*     */       
/*  50 */       return new SealableMap(originMap, (Function0)wrap.1.INSTANCE, (Function1)wrap.2.INSTANCE, errorReporter, null); }
/*     */     @NotNull
/*  52 */     public final <K, V> SealableMap<K, V> jdMethod_new(@NotNull EvalIssueReporter errorReporter) { Intrinsics.checkParameterIsNotNull(errorReporter, "errorReporter");
/*     */       
/*  56 */       return new SealableMap(null, (Function0)new.1.INSTANCE, (Function1)new.2.INSTANCE, errorReporter, null);
/*     */     }
/*     */   }
/*     */   
/*     */   private SealableMap(Map<K, V> originMap, Function0<? extends Map<K, V>> instantiator, Function1<? super Map<K, V>, ? extends Map<K, V>> cloner, EvalIssueReporter issueReporter)
/*     */   {
/*  42 */     super(issueReporter);this.instantiator = instantiator;this.cloner = cloner;
/*     */     
/*  61 */     internalMap = (originMap == null ? originMap : (Map)this.cloner.invoke(
/*  62 */       originMap));
/*     */   }
/*     */   
/*     */   public void clear()
/*     */   {
/*  76 */     if (checkSeal()) {
/*  77 */       internalMap = ((Map)null);
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Collection<V> getValues()
/*     */   {
/*  86 */     return (Collection)handleSealableSubItem((SealableObject)SealableCollection.Companion.wrap(getOrCreateMap().values(), getIssueReporter()));
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Set<Map.Entry<K, V>> getEntries()
/*     */   {
/*  92 */     return (Set)handleSealableSubItem((SealableObject)SealableSet.Companion.wrap(getOrCreateMap().entrySet(), getIssueReporter()));
/*     */   }
/*     */   
/*     */   @NotNull
/*  99 */   public Set<K> getKeys() { return (Set)handleSealableSubItem((SealableObject)SealableSet.Companion.wrap(getOrCreateMap().keySet(), getIssueReporter())); }
/*     */   
/*     */   @Nullable
/* 102 */   public V put(K key, V value) { if (checkSeal()) {
/* 103 */       return (V)getOrCreateMap().put(key, value);
/*     */     }
/*     */     
/* 106 */     return null;
/*     */   }
/*     */   
/*     */   public void putAll(@NotNull Map<? extends K, ? extends V> from) {
/* 110 */     Intrinsics.checkParameterIsNotNull(from, "from"); if (checkSeal())
/* 111 */       getOrCreateMap().putAll(from);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public V remove(Object key) {
/* 116 */     if (checkSeal()) {
/* 117 */       return (V)getOrCreateMap().remove(key);
/*     */     }
/*     */     
/* 120 */     return null;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Map<K, V> reset$gradle_core(@NotNull Map<K, V> newMap)
/*     */   {
/* 127 */     Intrinsics.checkParameterIsNotNull(newMap, "newMap"); if (checkSeal()) {
/* 128 */       internalMap = ((Map)cloner.invoke(newMap));
/*     */     }
/*     */     
/* 131 */     return (Map)this;
/*     */   }
/*     */   
/*     */   private final Map<K, V> getOrCreateMap()
/*     */   {
/* 139 */     if (internalMap == null) {
/* 140 */       internalMap = ((Map)instantiator.invoke());
/*     */     }
/*     */     
/* 144 */     Map tmp27_24 = internalMap;
/*     */     
/* 144 */     if (tmp27_24 == null) Intrinsics.throwNpe(); return tmp27_24;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int getSize()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 19	com/android/build/gradle/internal/api/dsl/sealing/SealableMap:internalMap	Ljava/util/Map;
/*     */     //   4: dup
/*     */     //   5: ifnull +11 -> 16
/*     */     //   8: invokeinterface 21 1 0
/*     */     //   13: goto +5 -> 18
/*     */     //   16: pop
/*     */     //   17: iconst_0
/*     */     //   18: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #65	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	19	0	this	SealableMap
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @Nullable
/*     */   public V get(Object key)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 19	com/android/build/gradle/internal/api/dsl/sealing/SealableMap:internalMap	Ljava/util/Map;
/*     */     //   4: dup
/*     */     //   5: ifnull +12 -> 17
/*     */     //   8: aload_1
/*     */     //   9: invokeinterface 28 2 0
/*     */     //   14: goto +5 -> 19
/*     */     //   17: pop
/*     */     //   18: aconst_null
/*     */     //   19: areturn
/*     */     // Line number table:
/*     */     //   Java source line #67	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	20	0	this	SealableMap
/*     */     //   0	20	1	key	Object
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public boolean isEmpty()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 19	com/android/build/gradle/internal/api/dsl/sealing/SealableMap:internalMap	Ljava/util/Map;
/*     */     //   4: dup
/*     */     //   5: ifnull +11 -> 16
/*     */     //   8: invokeinterface 36 1 0
/*     */     //   13: goto +5 -> 18
/*     */     //   16: pop
/*     */     //   17: iconst_1
/*     */     //   18: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #69	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	19	0	this	SealableMap
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public boolean containsKey(Object key)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 19	com/android/build/gradle/internal/api/dsl/sealing/SealableMap:internalMap	Ljava/util/Map;
/*     */     //   4: dup
/*     */     //   5: ifnull +12 -> 17
/*     */     //   8: aload_1
/*     */     //   9: invokeinterface 40 2 0
/*     */     //   14: goto +5 -> 19
/*     */     //   17: pop
/*     */     //   18: iconst_0
/*     */     //   19: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #71	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	20	0	this	SealableMap
/*     */     //   0	20	1	key	Object
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public boolean containsValue(Object value)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 19	com/android/build/gradle/internal/api/dsl/sealing/SealableMap:internalMap	Ljava/util/Map;
/*     */     //   4: dup
/*     */     //   5: ifnull +12 -> 17
/*     */     //   8: aload_1
/*     */     //   9: invokeinterface 43 2 0
/*     */     //   14: goto +5 -> 19
/*     */     //   17: pop
/*     */     //   18: iconst_0
/*     */     //   19: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #73	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	20	0	this	SealableMap
/*     */     //   0	20	1	value	Object
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableMap
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */