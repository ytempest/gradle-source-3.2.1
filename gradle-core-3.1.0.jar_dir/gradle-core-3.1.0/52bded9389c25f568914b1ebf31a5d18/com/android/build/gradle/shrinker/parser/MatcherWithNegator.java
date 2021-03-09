/*    */ package com.android.build.gradle.shrinker.parser;
/*    */ 
/*    */ public abstract class MatcherWithNegator<T>
/*    */   implements Matcher<T>
/*    */ {
/* 21 */   private boolean negator = false;
/*    */   
/*    */   public boolean matches(T t)
/*    */   {
/* 25 */     boolean result = matchesWithoutNegator(t);
/* 26 */     if (!negator) {
/* 27 */       return result;
/*    */     }
/* 29 */     return !result;
/*    */   }
/*    */   
/*    */   protected abstract boolean matchesWithoutNegator(T paramT);
/*    */   
/*    */   public void setNegator(boolean negator)
/*    */   {
/* 36 */     this.negator = negator;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.MatcherWithNegator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */