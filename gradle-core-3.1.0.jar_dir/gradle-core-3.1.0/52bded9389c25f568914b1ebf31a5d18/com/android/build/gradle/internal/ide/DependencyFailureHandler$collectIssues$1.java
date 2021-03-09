/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\n\n\000\n\002\020\016\n\002\b\002\020\000\032\004\030\0010\0012\006\020\002\032\0020\001H\n¢\006\002\b\003"}, d2={"<anonymous>", "", "message", "invoke"})
/*    */ final class DependencyFailureHandler$collectIssues$1
/*    */   extends Lambda
/*    */   implements Function1<String, String>
/*    */ {
/*    */   public static final 1 INSTANCE = new 1();
/*    */   
/*    */   @Nullable
/*    */   public final String invoke(@NotNull String message)
/*    */   {
/* 54 */     Intrinsics.checkParameterIsNotNull(message, "message");return DependencyFailureHandlerKt.access$checkForData(message);
/*    */   }
/*    */   
/*    */   DependencyFailureHandler$collectIssues$1()
/*    */   {
/*    */     super(1);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DependencyFailureHandler.collectIssues.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */