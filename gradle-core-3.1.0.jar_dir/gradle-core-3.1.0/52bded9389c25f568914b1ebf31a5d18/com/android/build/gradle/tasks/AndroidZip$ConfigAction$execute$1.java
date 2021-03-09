/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.OutputScope;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.ide.common.build.ApkData;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\n\n\000\n\002\020\016\n\002\b\002\020\000\032\n \002*\004\030\0010\0010\001H\n¢\006\002\b\003"}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
/*    */ final class AndroidZip$ConfigAction$execute$1
/*    */   extends Lambda
/*    */   implements Function0<String>
/*    */ {
/*    */   public final String invoke()
/*    */   {
/* 72 */     OutputScope tmp12_7 = AndroidZip.ConfigAction.access$getVariantScope$p(this$0).getOutputScope();Intrinsics.checkExpressionValueIsNotNull(tmp12_7, "variantScope.outputScope"); ApkData tmp21_18 = tmp12_7.getMainSplit();Intrinsics.checkExpressionValueIsNotNull(tmp21_18, "variantScope.outputScope.mainSplit"); String tmp30_27 = tmp21_18.getOutputFileName();Intrinsics.checkExpressionValueIsNotNull(tmp30_27, "variantScope.outputScope.mainSplit.outputFileName");return tmp30_27;
/*    */   }
/*    */   
/*    */   AndroidZip$ConfigAction$execute$1(AndroidZip.ConfigAction paramConfigAction)
/*    */   {
/*    */     super(0);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.AndroidZip.ConfigAction.execute.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */