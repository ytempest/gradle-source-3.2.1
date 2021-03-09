/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import java.util.Map;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\n\n\000\n\002\020%\n\002\b\004\020\000\032\016\022\004\022\002H\002\022\004\022\002H\0030\001\"\004\b\000\020\002\"\004\b\001\020\003\"\004\b\002\020\002\"\004\b\003\020\0032\022\020\004\032\016\022\004\022\002H\002\022\004\022\002H\0030\001H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "K", "V", "collection", "invoke"})
/*    */ final class SealableMap$Companion$wrap$2
/*    */   extends Lambda
/*    */   implements Function1<Map<K, V>, Map<K, V>>
/*    */ {
/*    */   public static final 2 INSTANCE = new 2();
/*    */   
/*    */   @NotNull
/*    */   public final Map<K, V> invoke(@NotNull Map<K, V> collection)
/*    */   {
/* 49 */     Intrinsics.checkParameterIsNotNull(collection, "collection");return collection;
/*    */   }
/*    */   
/*    */   SealableMap$Companion$wrap$2()
/*    */   {
/*    */     super(1);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableMap.Companion.wrap.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */