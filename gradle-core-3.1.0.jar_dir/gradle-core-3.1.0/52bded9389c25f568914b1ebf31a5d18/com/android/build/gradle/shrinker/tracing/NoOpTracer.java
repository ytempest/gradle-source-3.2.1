/*    */ package com.android.build.gradle.shrinker.tracing;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class NoOpTracer<T>
/*    */   implements Tracer<T>
/*    */ {
/*    */   public Trace<T> startTrace()
/*    */   {
/* 29 */     return new NoOpTrace();
/*    */   }
/*    */   
/*    */   public void nodeReached(T node, Trace<T> trace) {}
/*    */   
/*    */   public Map<T, Trace<T>> getRecordedTraces()
/*    */   {
/* 40 */     return Collections.emptyMap();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.tracing.NoOpTracer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */