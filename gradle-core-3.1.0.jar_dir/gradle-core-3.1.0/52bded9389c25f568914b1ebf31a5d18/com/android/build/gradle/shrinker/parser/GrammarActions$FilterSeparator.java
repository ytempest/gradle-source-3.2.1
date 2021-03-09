/*    */ package com.android.build.gradle.shrinker.parser;
/*    */ 
/*    */  enum GrammarActions$FilterSeparator
/*    */ {
/* 41 */   GENERAL(".", ".*"), 
/* 42 */   FILE("[^/]", "[^/]*"), 
/* 43 */   CLASS("[^/]", "[^/]*"), 
/* 44 */   ATTRIBUTE(".", ".*");
/*    */   
/*    */   private final String singleCharWildcard;
/*    */   
/*    */   private final String multipleCharWildcard;
/*    */   
/*    */   private GrammarActions$FilterSeparator(String singleCharWildcard, String multipleCharWildcard)
/*    */   {
/* 53 */     this.singleCharWildcard = singleCharWildcard;
/* 54 */     this.multipleCharWildcard = multipleCharWildcard;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.GrammarActions.FilterSeparator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */