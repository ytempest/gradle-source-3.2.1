/*    */ package com.android.build.gradle.shrinker.tracing;
/*    */ 
/*    */ import com.android.build.gradle.shrinker.DependencyType;
/*    */ 
/*    */ public class NoOpTrace<T>
/*    */   extends Trace<T>
/*    */ {
/*    */   public NoOpTrace()
/*    */   {
/* 26 */     super(null, null, null);
/*    */   }
/*    */   
/*    */   public Trace<T> with(T node, DependencyType dependencyType)
/*    */   {
/* 32 */     return this;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.tracing.NoOpTrace
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */