/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ public class IncrementalShrinker$IncrementalRunImpossibleException
/*    */   extends RuntimeException
/*    */ {
/*    */   IncrementalShrinker$IncrementalRunImpossibleException(String message)
/*    */   {
/* 56 */     super(message);
/*    */   }
/*    */   
/*    */   IncrementalShrinker$IncrementalRunImpossibleException(Throwable cause) {
/* 60 */     super("Failed to load incremental state.", cause);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.IncrementalShrinker.IncrementalRunImpossibleException
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */