/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.util.Deque;
/*     */ import org.objectweb.asm.Type;
/*     */ 
/*     */  enum DependencyFinderVisitor$ReflectionMethod$4
/*     */ {
/*     */   DependencyFinderVisitor$ReflectionMethod$4(String owner, String name, String desc)
/*     */   {
/* 633 */     super(paramString1, paramInt, owner, name, desc, null);
/*     */   }
/*     */   
/*     */   public <T> T getMember(ShrinkerGraph<T> graph, Deque<Object> stack)
/*     */   {
/* 640 */     if (!(stack.peek() instanceof String)) {
/* 641 */       return null;
/*     */     }
/* 643 */     String fieldName = (String)stack.pop();
/*     */     
/* 645 */     if (!(stack.peek() instanceof Type)) {
/* 646 */       return null;
/*     */     }
/* 648 */     Type fieldType = (Type)stack.pop();
/*     */     
/* 650 */     if (!(stack.peek() instanceof Type)) {
/* 651 */       return null;
/*     */     }
/* 653 */     Type klass = (Type)stack.pop();
/*     */     
/* 655 */     return (T)graph.getMemberReference(klass
/* 656 */       .getInternalName(), fieldName, fieldType.getDescriptor());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyFinderVisitor.ReflectionMethod.4
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */