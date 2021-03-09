/*    */ package com.android.build.gradle.shrinker.parser;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class NameSpecification
/*    */   extends MatcherWithNegator<String>
/*    */ {
/*    */   private final Pattern mPattern;
/*    */   
/*    */   public NameSpecification(Pattern pattern)
/*    */   {
/* 28 */     mPattern = pattern;
/*    */   }
/*    */   
/*    */   protected boolean matchesWithoutNegator(String s)
/*    */   {
/* 33 */     return mPattern.matcher(s).matches();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.NameSpecification
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */