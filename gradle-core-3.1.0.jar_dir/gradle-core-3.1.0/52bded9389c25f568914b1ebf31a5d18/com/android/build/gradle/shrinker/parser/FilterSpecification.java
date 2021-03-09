/*    */ package com.android.build.gradle.shrinker.parser;
/*    */ 
/*    */ public class FilterSpecification
/*    */   extends MatcherWithNegator<String>
/*    */ {
/*    */   private final NameSpecification name;
/*    */   
/*    */   public FilterSpecification(NameSpecification name, boolean negator)
/*    */   {
/* 27 */     this.name = name;
/* 28 */     setNegator(negator);
/*    */   }
/*    */   
/*    */   protected boolean matchesWithoutNegator(String t)
/*    */   {
/* 33 */     return name.matches(t);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 39 */     return super.toString() + name.toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.FilterSpecification
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */