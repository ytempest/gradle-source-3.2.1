/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\n\n\000\n\002\020\037\n\002\b\003\020\000\032\b\022\004\022\002H\0020\001\"\004\b\000\020\002\"\004\b\001\020\0022\f\020\003\032\b\022\004\022\002H\0020\001H\n¢\006\002\b\004"}, d2={"<anonymous>", "", "T", "collection", "invoke"})
/*    */ final class SealableCollection$Companion$wrap$2
/*    */   extends Lambda
/*    */   implements Function1<Collection<T>, Collection<T>>
/*    */ {
/*    */   public static final 2 INSTANCE = new 2();
/*    */   
/*    */   @NotNull
/*    */   public final Collection<T> invoke(@NotNull Collection<T> collection)
/*    */   {
/* 53 */     Intrinsics.checkParameterIsNotNull(collection, "collection");return collection;
/*    */   }
/*    */   
/*    */   SealableCollection$Companion$wrap$2()
/*    */   {
/*    */     super(1);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableCollection.Companion.wrap.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */