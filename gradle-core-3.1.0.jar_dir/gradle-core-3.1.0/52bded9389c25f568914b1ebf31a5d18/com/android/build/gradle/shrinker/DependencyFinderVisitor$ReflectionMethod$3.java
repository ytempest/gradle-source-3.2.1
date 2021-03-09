/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.util.Deque;
/*     */ 
/*     */  enum DependencyFinderVisitor$ReflectionMethod$3
/*     */ {
/*     */   DependencyFinderVisitor$ReflectionMethod$3(String owner, String name, String desc)
/*     */   {
/* 623 */     super(paramString1, paramInt, owner, name, desc, null);
/*     */   }
/*     */   
/*     */   public <T> T getMember(ShrinkerGraph<T> graph, Deque<Object> stack)
/*     */   {
/* 630 */     return (T)DependencyFinderVisitor.ReflectionMethod.access$700(graph, stack, "J");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyFinderVisitor.ReflectionMethod.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */