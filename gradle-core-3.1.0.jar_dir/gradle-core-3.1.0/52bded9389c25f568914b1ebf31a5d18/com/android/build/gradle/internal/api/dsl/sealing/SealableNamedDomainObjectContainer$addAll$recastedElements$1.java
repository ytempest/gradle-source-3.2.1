/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.FunctionReference;
/*    */ import kotlin.jvm.internal.Reflection;
/*    */ import kotlin.reflect.KDeclarationContainer;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\026\n\000\n\002\020\013\n\002\b\003\n\002\020\000\n\002\030\002\n\002\b\004\020\000\032\0020\001\"\004\b\000\020\002\"\b\b\001\020\003*\002H\0022,\020\004\032( \t*\023\030\0010\005¢\006\f\b\006\022\b\b\007\022\004\b\b(\b0\005¢\006\f\b\006\022\b\b\007\022\004\b\b(\b¢\006\002\b\n"}, d2={"<anonymous>", "", "InterfaceT", "ImplementationT", "p1", "", "Lkotlin/ParameterName;", "name", "p0", "kotlin.jvm.PlatformType", "invoke"})
/*    */ final class SealableNamedDomainObjectContainer$addAll$recastedElements$1
/*    */   extends FunctionReference
/*    */   implements Function1<Object, Boolean>
/*    */ {
/*    */   public final boolean invoke(Object p1)
/*    */   {
/* 82 */     return ((Class)receiver).isInstance(p1);
/*    */   }
/*    */   
/*    */   public final KDeclarationContainer getOwner()
/*    */   {
/*    */     return Reflection.getOrCreateKotlinClass(Class.class);
/*    */   }
/*    */   
/*    */   public final String getName()
/*    */   {
/*    */     return "isInstance";
/*    */   }
/*    */   
/*    */   public final String getSignature()
/*    */   {
/*    */     return "isInstance(Ljava/lang/Object;)Z";
/*    */   }
/*    */   
/*    */   SealableNamedDomainObjectContainer$addAll$recastedElements$1(Class paramClass)
/*    */   {
/*    */     super(1, paramClass);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableNamedDomainObjectContainer.addAll.recastedElements.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */