/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\024\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\037\n\000\020\000\032\022\022\004\022\002H\0020\001j\b\022\004\022\002H\002`\003\"\004\b\000\020\002\"\004\b\001\020\0022\f\020\004\032\b\022\004\022\002H\0020\005H\n¢\006\002\b\006"}, d2={"<anonymous>", "Ljava/util/ArrayList;", "T", "Lkotlin/collections/ArrayList;", "collection", "", "invoke"})
/*    */ final class SealableCollection$Companion$new$2
/*    */   extends Lambda
/*    */   implements Function1<Collection<T>, ArrayList<T>>
/*    */ {
/*    */   public static final 2 INSTANCE = new 2();
/*    */   
/*    */   @NotNull
/*    */   public final ArrayList<T> invoke(@NotNull Collection<T> collection)
/*    */   {
/* 59 */     Intrinsics.checkParameterIsNotNull(collection, "collection");return new ArrayList(collection);
/*    */   }
/*    */   
/*    */   SealableCollection$Companion$new$2()
/*    */   {
/*    */     super(1);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableCollection.Companion.new.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */