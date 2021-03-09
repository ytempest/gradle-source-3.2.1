/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import com.android.build.gradle.internal.incremental.ByteCodeUtils;
/*     */ import java.util.Deque;
/*     */ 
/*     */  enum DependencyFinderVisitor$ReflectionMethod$1
/*     */ {
/* 603 */   DependencyFinderVisitor$ReflectionMethod$1(String owner, String name, String desc) { super(paramString1, paramInt, owner, name, desc, null); }
/*     */   
/*     */   public <T> T getMember(ShrinkerGraph<T> graph, Deque<Object> stack) {
/* 606 */     if (!(stack.peek() instanceof String)) {
/* 607 */       return null;
/*     */     }
/*     */     
/* 610 */     return (T)graph.getClassReference(ByteCodeUtils.toInternalName((String)stack.pop()));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyFinderVisitor.ReflectionMethod.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */