/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.function.BiConsumer;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.functions.Function2;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\024\n\000\n\002\020\002\n\000\n\002\020\016\n\000\n\002\020 \n\000\020\000\032\0020\0012\b\020\002\032\004\030\0010\0032\f\020\004\032\b\022\004\022\0020\0030\005H\n¢\006\002\b\006"}, d2={"<anonymous>", "", "data", "", "messages", "", "invoke"})
/*    */ final class DependencyFailureHandlerKt$processDependencyThrowable$1
/*    */   extends Lambda
/*    */   implements Function2<String, List<? extends String>, Unit>
/*    */ {
/*    */   public final void invoke(@Nullable String data, @NotNull List<String> messages)
/*    */   {
/* 88 */     Intrinsics.checkParameterIsNotNull(messages, "messages");$resultConsumer.accept(data, messages);
/*    */   }
/*    */   
/*    */   DependencyFailureHandlerKt$processDependencyThrowable$1(BiConsumer paramBiConsumer)
/*    */   {
/*    */     super(2);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DependencyFailureHandlerKt.processDependencyThrowable.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */