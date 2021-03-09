/*    */ package com.android.build.gradle.shrinker.tracing;
/*    */ 
/*    */ import com.android.build.gradle.shrinker.DependencyType;
/*    */ import com.android.utils.Pair;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Trace<T>
/*    */ {
/*    */   final T node;
/*    */   final DependencyType dependencyType;
/*    */   private final Trace<T> rest;
/*    */   
/*    */   Trace(T node, DependencyType dependencyType, Trace<T> rest)
/*    */   {
/* 39 */     this.node = node;
/* 40 */     this.rest = rest;
/* 41 */     this.dependencyType = dependencyType;
/*    */   }
/*    */   
/*    */   public Trace<T> with(T node, DependencyType dependencyType) {
/* 45 */     return new Trace(node, dependencyType, this);
/*    */   }
/*    */   
/*    */   public List<Pair<T, DependencyType>> toList() {
/* 49 */     List<Pair<T, DependencyType>> result = new ArrayList();
/* 50 */     Trace<T> current = this;
/* 51 */     while ((current != null) && 
/* 52 */       (node != null))
/*    */     {
/* 56 */       result.add(Pair.of(node, dependencyType));
/* 57 */       current = rest;
/*    */     }
/* 59 */     return result;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.tracing.Trace
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */