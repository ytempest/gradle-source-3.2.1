/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonManager;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.internal.FunctionReference;
/*    */ import kotlin.jvm.internal.Reflection;
/*    */ import kotlin.reflect.KDeclarationContainer;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\b\n\000\n\002\020\002\n\000\020\000\032\0020\001¢\006\002\b\002"}, d2={"<anonymous>", "", "invoke"})
/*    */ final class Aapt2DaemonManagerMaintainer$firstDaemonStarted$1
/*    */   extends FunctionReference
/*    */   implements Function0<Unit>
/*    */ {
/*    */   public final void invoke()
/*    */   {
/* 99 */     ((Aapt2DaemonManager)receiver).maintain();
/*    */   }
/*    */   
/*    */   public final KDeclarationContainer getOwner()
/*    */   {
/*    */     return Reflection.getOrCreateKotlinClass(Aapt2DaemonManager.class);
/*    */   }
/*    */   
/*    */   public final String getName()
/*    */   {
/*    */     return "maintain";
/*    */   }
/*    */   
/*    */   public final String getSignature()
/*    */   {
/*    */     return "maintain()V";
/*    */   }
/*    */   
/*    */   Aapt2DaemonManagerMaintainer$firstDaemonStarted$1(Aapt2DaemonManager paramAapt2DaemonManager)
/*    */   {
/*    */     super(0, paramAapt2DaemonManager);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.Aapt2DaemonManagerMaintainer.firstDaemonStarted.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */