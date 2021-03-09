/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.Method;
/*     */ 
/*     */ final class BuildSessionImpl$DelegateInvocationHandler
/*     */   implements InvocationHandler
/*     */ {
/*     */   private final Object delegate;
/*     */   
/*     */   public BuildSessionImpl$DelegateInvocationHandler(Object delegate)
/*     */   {
/* 230 */     this.delegate = delegate;
/*     */   }
/*     */   
/*     */   public Object getDelegate()
/*     */   {
/* 236 */     return delegate;
/*     */   }
/*     */   
/*     */   public Object invoke(Object proxy, Method method, Object[] args)
/*     */     throws Throwable
/*     */   {
/* 243 */     return 
/*     */     
/* 245 */       delegate.getClass().getMethod(method.getName(), method.getParameterTypes()).invoke(delegate, args);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.BuildSessionImpl.DelegateInvocationHandler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */