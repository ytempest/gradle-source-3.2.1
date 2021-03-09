/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.util.Deque;
/*     */ 
/*     */  enum DependencyFinderVisitor$ReflectionMethod$2
/*     */ {
/*     */   DependencyFinderVisitor$ReflectionMethod$2(String owner, String name, String desc)
/*     */   {
/* 613 */     super(paramString1, paramInt, owner, name, desc, null);
/*     */   }
/*     */   
/*     */   public <T> T getMember(ShrinkerGraph<T> graph, Deque<Object> stack)
/*     */   {
/* 620 */     return (T)DependencyFinderVisitor.ReflectionMethod.access$700(graph, stack, "I");
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyFinderVisitor.ReflectionMethod.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */