/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.build.FilterData;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\020\000\032\n \002*\004\030\0010\0010\0012\006\020\003\032\0020\004H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/android/build/FilterData;", "invoke"})
/*    */ final class EarlySyncBuildOutput$getFilterTypes$1
/*    */   extends Lambda
/*    */   implements Function1<FilterData, String>
/*    */ {
/*    */   public static final 1 INSTANCE = new 1();
/*    */   
/*    */   public final String invoke(@NotNull FilterData it)
/*    */   {
/* 54 */     Intrinsics.checkParameterIsNotNull(it, "it");return it.getFilterType();
/*    */   }
/*    */   
/*    */   EarlySyncBuildOutput$getFilterTypes$1()
/*    */   {
/*    */     super(1);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.EarlySyncBuildOutput.getFilterTypes.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */