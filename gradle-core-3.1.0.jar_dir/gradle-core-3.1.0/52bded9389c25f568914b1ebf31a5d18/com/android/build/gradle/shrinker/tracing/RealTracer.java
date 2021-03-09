/*    */ package com.android.build.gradle.shrinker.tracing;
/*    */ 
/*    */ import com.google.common.base.Verify;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ public class RealTracer<T>
/*    */   implements Tracer<T>
/*    */ {
/*    */   private final Set<T> nodesToExplain;
/*    */   private final Map<T, Trace<T>> traces;
/*    */   
/*    */   public RealTracer(Set<T> nodesToExplain)
/*    */   {
/* 33 */     this.nodesToExplain = nodesToExplain;
/* 34 */     traces = new ConcurrentHashMap();
/*    */   }
/*    */   
/*    */   public Trace<T> startTrace()
/*    */   {
/* 40 */     return new Trace(null, null, null);
/*    */   }
/*    */   
/*    */   public void nodeReached(T node, Trace<T> trace)
/*    */   {
/* 45 */     Verify.verify(node.equals(node), "Trace does not end with the node.", new Object[0]);
/*    */     
/* 47 */     if (nodesToExplain.contains(node)) {
/* 48 */       Verify.verify(!traces.containsKey(node), "Node %s already recorded.", new Object[] { node });
/* 49 */       traces.put(node, trace);
/*    */     }
/*    */   }
/*    */   
/*    */   public Map<T, Trace<T>> getRecordedTraces()
/*    */   {
/* 56 */     return traces;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.tracing.RealTracer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */